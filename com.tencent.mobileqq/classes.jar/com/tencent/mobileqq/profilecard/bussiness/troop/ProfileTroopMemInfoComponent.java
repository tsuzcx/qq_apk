package com.tencent.mobileqq.profilecard.bussiness.troop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberCard.MemberGameInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardReport;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberCardHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.onlinepush.api.TroopOnlinePushObserver;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi.LinkParams;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerBizHandler;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.mobileqq.troop.utils.BizTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopMemberGlobalLevelUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.troop.TroopPluginManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ProfileTroopMemInfoComponent
  extends AbsQQProfileContentComponent
  implements View.OnClickListener
{
  private static final String TAG = "ProfileTroopMemInfoComponent";
  private boolean gameImfoPrepared = false;
  volatile boolean isPluginInstalled = false;
  private View mCharmLevelView;
  private View mGameInfoView;
  private View mJoinTimeView;
  private View mRecentSaidView;
  protected TroopManagerBizObserver mTroopManagerBizObserver = new ProfileTroopMemInfoComponent.3(this);
  protected TroopObserver mTroopObserver = new ProfileTroopMemInfoComponent.1(this);
  protected TroopOnlinePushObserver troopOnlinePushObserver = new ProfileTroopMemInfoComponent.2(this);
  
  public ProfileTroopMemInfoComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void addCharmLevelView()
  {
    try
    {
      if (this.mCharmLevelView != null)
      {
        if ((this.mCharmLevelView.getParent() != null) && ((this.mCharmLevelView.getParent() instanceof ViewGroup)))
        {
          ViewParent localViewParent = this.mCharmLevelView.getParent();
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTroopMemInfoComponent", 2, new Object[] { "remove mCharmLevelView. view=%s viewParent=%s", this.mCharmLevelView, localViewParent });
          }
          ((ViewGroup)localViewParent).removeView(this.mCharmLevelView);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ProfileTroopMemInfoComponent", 2, "add mCharmLevelView :");
        }
        ((ViewGroup)this.mViewContainer).addView(this.mCharmLevelView);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ProfileTroopMemInfoComponent", 1, "update mCharmLevelView fail.", localException);
    }
  }
  
  private void addGameInfoView()
  {
    try
    {
      if (this.mGameInfoView != null)
      {
        if ((this.mGameInfoView.getParent() != null) && ((this.mGameInfoView.getParent() instanceof ViewGroup)))
        {
          ViewParent localViewParent = this.mGameInfoView.getParent();
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTroopMemInfoComponent", 2, new Object[] { "remove mGameInfoView. view=%s viewParent=%s", this.mGameInfoView, localViewParent });
          }
          ((ViewGroup)localViewParent).removeView(this.mGameInfoView);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ProfileTroopMemInfoComponent", 2, "add mGameInfoView :");
        }
        ((ViewGroup)this.mViewContainer).addView(this.mGameInfoView);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ProfileTroopMemInfoComponent", 1, "update mGameInfoView fail.", localException);
    }
  }
  
  private void addJoinTimeView()
  {
    try
    {
      if (this.mJoinTimeView != null)
      {
        if ((this.mJoinTimeView.getParent() != null) && ((this.mJoinTimeView.getParent() instanceof ViewGroup)))
        {
          ViewParent localViewParent = this.mJoinTimeView.getParent();
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTroopMemInfoComponent", 2, new Object[] { "remove mJoinTimeView. view=%s viewParent=%s", this.mJoinTimeView, localViewParent });
          }
          ((ViewGroup)localViewParent).removeView(this.mJoinTimeView);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ProfileTroopMemInfoComponent", 2, "add mJoinTimeView :");
        }
        ((ViewGroup)this.mViewContainer).addView(this.mJoinTimeView);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ProfileTroopMemInfoComponent", 1, "update mJoinTimeView fail.", localException);
    }
  }
  
  private void addRecentSaidView()
  {
    try
    {
      if (this.mRecentSaidView != null)
      {
        if ((this.mRecentSaidView.getParent() != null) && ((this.mRecentSaidView.getParent() instanceof ViewGroup)))
        {
          ViewParent localViewParent = this.mRecentSaidView.getParent();
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTroopMemInfoComponent", 2, new Object[] { "remove mRecentSaidView. view=%s viewParent=%s", this.mRecentSaidView, localViewParent });
          }
          ((ViewGroup)localViewParent).removeView(this.mRecentSaidView);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ProfileTroopMemInfoComponent", 2, "add mRecentSaidView :");
        }
        ((ViewGroup)this.mViewContainer).addView(this.mRecentSaidView);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ProfileTroopMemInfoComponent", 1, "update mRecentSaidView fail.", localException);
    }
  }
  
  private void handleCharmLevelClick()
  {
    if ((this.mData != null) && (((ProfileCardInfo)this.mData).allInOne != null))
    {
      ITroopLinkApi localITroopLinkApi = (ITroopLinkApi)QRoute.api(ITroopLinkApi.class);
      Object localObject2 = TroopMemberGlobalLevelUtils.a();
      Object localObject1 = localObject2;
      if (this.mData != null)
      {
        localObject1 = localObject2;
        if (((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).isNewRealLevelGrayTroop(((ProfileCardInfo)this.mData).troopUin))
        {
          localObject1 = localObject2;
          if (((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).hasNewGroupMemberLevelJumpUrl()) {
            localObject1 = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getNewGroupMemberLevelJumpUrl();
          }
        }
      }
      localObject2 = new ITroopLinkApi.LinkParams();
      ((ITroopLinkApi.LinkParams)localObject2).c = "31";
      ((ITroopLinkApi.LinkParams)localObject2).b = ((ProfileCardInfo)this.mData).allInOne.uin;
      ((ITroopLinkApi.LinkParams)localObject2).a = ((ProfileCardInfo)this.mData).troopUin;
      localObject1 = localITroopLinkApi.replaceParams((String)localObject1, (ITroopLinkApi.LinkParams)localObject2);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleCharmLevelClick, url:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("ProfileTroopMemInfoComponent", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = new Intent(this.mActivity, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("uin", this.mApp.getCurrentUin());
      ((Intent)localObject2).putExtra("portraitOnly", true);
      ((Intent)localObject2).putExtra("hide_more_button", true);
      ((Intent)localObject2).putExtra("hide_operation_bar", true);
      ((Intent)localObject2).putExtra("isShowAd", false);
      this.mActivity.startActivity((Intent)localObject2);
      ReportController.b(this.mApp, "dc00899", "Grp_grade", "", "mber_card", "clk_grade", 0, 0, ((ProfileCardInfo)this.mData).troopUin, "", "", "");
      new ReportTask(this.mQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("grade_clk").a(new String[] { ((ProfileCardInfo)this.mData).troopUin }).a();
      ProfileCardReport.reportTroopLevelClick(this.mQQAppInterface, (ProfileCardInfo)this.mData);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, "handleCharmLevelClick, mData == null || mData.allinone == null");
    }
  }
  
  private void handleGameInfoClick()
  {
    if ((this.mData != null) && (((ProfileCardInfo)this.mData).troopMemberCard != null))
    {
      TroopMemberCard.MemberGameInfo localMemberGameInfo = ((ProfileCardInfo)this.mData).troopMemberCard.mMemberGameInfo;
      if (localMemberGameInfo != null)
      {
        String str = localMemberGameInfo.gameUrl;
        Intent localIntent = new Intent(this.mActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", str);
        this.mActivity.startActivity(localIntent);
        TroopReportor.a("Grp_game", "Mber_data", "game_clk", 0, 0, new String[] { ((ProfileCardInfo)this.mData).troopUin, localMemberGameInfo.gameName });
      }
    }
  }
  
  private void handleRecentSaidClick()
  {
    if ((this.mData != null) && (((ProfileCardInfo)this.mData).allInOne != null) && (this.mActivity != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("troop_uin", ((ProfileCardInfo)this.mData).troopUin);
      localIntent.putExtra("member_uin", ((ProfileCardInfo)this.mData).allInOne.uin);
      PublicFragmentActivity.a(this.mActivity, localIntent, TroopMemberHistoryFragment.class);
      if (this.mApp != null)
      {
        new ReportTask(this.mQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("recent_clk").a(new String[] { ((ProfileCardInfo)this.mData).troopUin }).a();
        ReportController.b(this.mApp, "CliOper", "", "", "0X800A596", "0X800A596", 2, 0, "", "", "", "");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, "handleRecentSaidClick, mData == null || mData.allinone == null || mActivity == null");
    }
  }
  
  private void init()
  {
    requestTroopMemberInfo();
  }
  
  private void initRecentSaidItem(ProfileCardInfo paramProfileCardInfo)
  {
    ThreadManager.post(new ProfileTroopMemInfoComponent.4(this, paramProfileCardInfo), 8, null, true);
  }
  
  private boolean makeOrRefreshGameTroopInfoView(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool2 = paramProfileCardInfo.isTroopMemberCard;
    boolean bool1 = true;
    if ((bool2) && (paramProfileCardInfo.troopMemberCard != null) && (paramProfileCardInfo.troopMemberCard.mMemberGameInfo != null) && (!TextUtils.isEmpty(paramProfileCardInfo.troopMemberCard.mMemberGameInfo.gameName)))
    {
      if (this.mGameInfoView == null)
      {
        this.mGameInfoView = this.mActivity.getLayoutInflater().inflate(2131561347, null);
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      TextView localTextView1 = (TextView)this.mGameInfoView.findViewById(2131367486);
      TextView localTextView2 = (TextView)this.mGameInfoView.findViewById(2131367495);
      localTextView2.setBackgroundDrawable(BizTroopUtil.a(this.mActivity.getResources(), Color.parseColor("#3094cf")));
      Object localObject = (ImageView)this.mGameInfoView.findViewById(2131375974);
      TextView localTextView3 = (TextView)this.mGameInfoView.findViewById(2131367496);
      TextView localTextView4 = (TextView)this.mGameInfoView.findViewById(2131367497);
      ImageView localImageView = (ImageView)this.mGameInfoView.findViewById(2131362975);
      TroopMemberCard.MemberGameInfo localMemberGameInfo = paramProfileCardInfo.troopMemberCard.mMemberGameInfo;
      if (localMemberGameInfo != null)
      {
        localTextView1.setText(localMemberGameInfo.gameName);
        if ((localMemberGameInfo.descInfo != null) && (localMemberGameInfo.descInfo.size() > 0) && (!TextUtils.isEmpty((CharSequence)localMemberGameInfo.descInfo.get(0))))
        {
          localTextView3.setVisibility(0);
          localTextView3.setText((CharSequence)localMemberGameInfo.descInfo.get(0));
        }
        if ((localMemberGameInfo.descInfo != null) && (localMemberGameInfo.descInfo.size() > 1) && (!TextUtils.isEmpty((CharSequence)localMemberGameInfo.descInfo.get(1))))
        {
          localTextView4.setVisibility(0);
          localTextView4.setText((CharSequence)localMemberGameInfo.descInfo.get(1));
        }
        try
        {
          int i = AIOUtils.b(18.0F, this.mActivity.getResources());
          int j = AIOUtils.b(18.0F, this.mActivity.getResources());
          if (!TextUtils.isEmpty(localMemberGameInfo.levelIcon))
          {
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestHeight = i;
            localURLDrawableOptions.mRequestWidth = j;
            ((ImageView)localObject).setImageDrawable(URLDrawable.getDrawable(localMemberGameInfo.levelIcon, localURLDrawableOptions));
          }
          if (!TextUtils.isEmpty(localMemberGameInfo.levelName))
          {
            localTextView2.setVisibility(0);
            localTextView2.setText(localMemberGameInfo.levelName);
            float f = AIOUtils.b(2.0F, this.mActivity.getResources());
            i = AIOUtils.b(4.0F, this.mActivity.getResources());
            localObject = new GradientDrawable();
            ((GradientDrawable)localObject).setCornerRadius(f);
            localTextView2.setPadding(i, 0, i, 0);
            if (!TextUtils.isEmpty(localMemberGameInfo.gameBackGroundColor)) {
              ((GradientDrawable)localObject).setColor(Color.parseColor(localMemberGameInfo.gameBackGroundColor));
            } else {
              ((GradientDrawable)localObject).setColor(Color.parseColor("#FFBA26"));
            }
            localTextView2.setBackgroundDrawable((Drawable)localObject);
          }
          if (!TextUtils.isEmpty(localMemberGameInfo.gameFontColor)) {
            localTextView2.setTextColor(Color.parseColor(localMemberGameInfo.gameFontColor));
          }
          this.gameImfoPrepared = true;
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshGameTroopInfoView. Showing game info.");
          }
          TroopReportor.a("Grp_game", "Mber_data", "game_exp", 0, 0, new String[] { paramProfileCardInfo.troopUin, localMemberGameInfo.gameName });
        }
        catch (Exception paramProfileCardInfo)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.profilecard.FrdProfileCard", 2, paramProfileCardInfo.toString());
          }
        }
      }
      paramProfileCardInfo = new DataTag(83, null);
      this.mGameInfoView.setTag(paramProfileCardInfo);
      this.mGameInfoView.setOnClickListener(this);
      this.mGameInfoView.setVisibility(0);
      updateItemTheme(this.mGameInfoView, localTextView1, localTextView3, localImageView);
      updateItemTheme(this.mGameInfoView, localTextView2, localTextView4, localImageView);
      return bool1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshGameTroopInfoView. Not showing game info.");
    }
    if (this.mGameInfoView == null) {
      bool1 = false;
    }
    paramProfileCardInfo = this.mGameInfoView;
    if (paramProfileCardInfo != null) {
      paramProfileCardInfo.setVisibility(8);
    }
    return bool1;
  }
  
  private boolean makeOrRefreshTroopMemInfoEntry(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool3 = makeOrRefreshTroopMemJoinTime((ProfileCardInfo)this.mData) | false | makeOrRefreshTroopMemCharmLevelInfo((ProfileCardInfo)this.mData) | makeOrRefreshTroopMemRecentSaidEntry((ProfileCardInfo)this.mData) | makeOrRefreshGameTroopInfoView((ProfileCardInfo)this.mData);
    paramProfileCardInfo = this.mJoinTimeView;
    if ((paramProfileCardInfo == null) || (paramProfileCardInfo.getVisibility() != 0))
    {
      paramProfileCardInfo = this.mCharmLevelView;
      if ((paramProfileCardInfo == null) || (paramProfileCardInfo.getVisibility() != 0))
      {
        paramProfileCardInfo = this.mRecentSaidView;
        if ((paramProfileCardInfo == null) || (paramProfileCardInfo.getVisibility() != 0))
        {
          paramProfileCardInfo = this.mGameInfoView;
          if ((paramProfileCardInfo == null) || (paramProfileCardInfo.getVisibility() != 0)) {
            break label120;
          }
        }
      }
    }
    boolean bool1 = true;
    break label122;
    label120:
    bool1 = false;
    label122:
    if (bool3)
    {
      if (this.mViewContainer == null)
      {
        paramProfileCardInfo = new LinearLayout(this.mActivity);
        paramProfileCardInfo.setOrientation(1);
        paramProfileCardInfo.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.mViewContainer = paramProfileCardInfo;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, new Object[] { "mViewContainer removeAllViews before show. mViewContainer=%s", this.mViewContainer });
      }
      ((ViewGroup)this.mViewContainer).removeAllViews();
      if ((!ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy()) && (((View)this.mViewContainer).getParent() != null) && ((((View)this.mViewContainer).getParent() instanceof ViewGroup))) {
        ((ViewGroup)((View)this.mViewContainer).getParent()).removeView((View)this.mViewContainer);
      }
      addJoinTimeView();
      addCharmLevelView();
      addRecentSaidView();
      addGameInfoView();
    }
    boolean bool2 = bool3;
    if (!bool1)
    {
      if (this.mViewContainer == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 = bool3 | bool1;
      if (this.mViewContainer != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemInfoComponent", 2, new Object[] { "bShow = false. mViewContainer removeAllViews. mViewContainer=%s", this.mViewContainer });
        }
        ((ViewGroup)this.mViewContainer).removeAllViews();
      }
      this.mViewContainer = null;
    }
    paramProfileCardInfo = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
    if (paramProfileCardInfo.isDiy()) {
      paramProfileCardInfo.updateTroopMemInfoForDeepDiy((View)this.mViewContainer);
    }
    return bool2;
  }
  
  private boolean makeOrRefreshTroopMemJoinTime(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool4 = paramProfileCardInfo.isTroopMemberCard;
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    long l;
    if ((bool4) && (paramProfileCardInfo.troopMemberCard != null))
    {
      l = paramProfileCardInfo.troopMemberCard.joinTime;
      str = "";
      localObject2 = str;
      if (l > 0L)
      {
        l = paramProfileCardInfo.troopMemberCard.joinTime;
        localObject1 = str;
        if (paramProfileCardInfo.troopMemberCard.joinTime == 1L) {}
      }
    }
    try
    {
      localObject1 = DateFormat.format(this.mActivity.getString(2131693369), 1000L * l).toString();
    }
    catch (Exception paramProfileCardInfo)
    {
      for (;;)
      {
        localObject1 = str;
      }
    }
    Object localObject2 = localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("ProfileTroopMemInfoComponent", 2, String.format("makeOrRefreshTroopMemJoinTime, timeStamp: %s, joinTime: %s", new Object[] { Long.valueOf(l), localObject1 }));
      localObject2 = localObject1;
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (this.mJoinTimeView == null) {
        bool1 = false;
      }
      paramProfileCardInfo = this.mJoinTimeView;
      if (paramProfileCardInfo != null) {
        paramProfileCardInfo.setVisibility(8);
      }
      return bool1;
    }
    if (this.mJoinTimeView == null)
    {
      this.mJoinTimeView = this.mActivity.getLayoutInflater().inflate(2131562969, null);
      paramProfileCardInfo = (ImageView)this.mJoinTimeView.findViewById(2131368343);
      paramProfileCardInfo.setImageResource(2130845964);
      paramProfileCardInfo.clearColorFilter();
      paramProfileCardInfo.setColorFilter(10067634);
      bool1 = bool2;
    }
    else
    {
      bool1 = false;
    }
    paramProfileCardInfo = (TextView)this.mJoinTimeView.findViewById(2131369087);
    localObject1 = (ImageView)this.mJoinTimeView.findViewById(2131362975);
    ((ImageView)localObject1).setVisibility(8);
    paramProfileCardInfo.setText((CharSequence)localObject2);
    this.mJoinTimeView.setVisibility(0);
    QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshTroopMemJoinTime 05");
    updateItemTheme(this.mJoinTimeView, paramProfileCardInfo, null, (ImageView)localObject1);
    return bool1;
    if (this.mJoinTimeView != null) {
      bool1 = bool3;
    } else {
      bool1 = false;
    }
    paramProfileCardInfo = this.mJoinTimeView;
    if (paramProfileCardInfo != null) {
      paramProfileCardInfo.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, String.format("makeOrRefreshTroopMemJoinTime, Not showing mem join time", new Object[0]));
    }
    return bool1;
  }
  
  private boolean makeOrRefreshTroopMemRecentSaidEntry(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool3 = paramProfileCardInfo.isTroopMemberCard;
    boolean bool2 = true;
    boolean bool1 = true;
    if (!bool3)
    {
      if (this.mRecentSaidView == null) {
        bool1 = false;
      }
      paramProfileCardInfo = this.mRecentSaidView;
      if (paramProfileCardInfo != null) {
        paramProfileCardInfo.setVisibility(8);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshTroopMemRecentSaidEntry, isTroopMemberCard = false. Not showing recent said.");
      }
      return bool1;
    }
    if (this.mRecentSaidView == null)
    {
      this.mRecentSaidView = this.mActivity.getLayoutInflater().inflate(2131562969, null);
      localObject = (ImageView)this.mRecentSaidView.findViewById(2131368343);
      ((ImageView)localObject).setImageResource(2130845978);
      ((ImageView)localObject).clearColorFilter();
      ((ImageView)localObject).setColorFilter(10067634);
      bool1 = bool2;
    }
    else
    {
      bool1 = false;
    }
    Object localObject = (TextView)this.mRecentSaidView.findViewById(2131369087);
    ImageView localImageView = (ImageView)this.mRecentSaidView.findViewById(2131362975);
    DataTag localDataTag = new DataTag(78, null);
    this.mRecentSaidView.setTag(localDataTag);
    this.mRecentSaidView.setOnClickListener(this);
    updateItemTheme(this.mRecentSaidView, (TextView)localObject, null, localImageView);
    if (!this.isPluginInstalled)
    {
      this.isPluginInstalled = ((TroopPluginManager)this.mApp.getManager(QQManagerFactory.TROOP_PLUGIN_MANAGER)).a("troop_member_card_plugin.apk", new ProfileTroopMemInfoComponent.TroopProfilePluginCallback(new WeakReference(this), paramProfileCardInfo));
      if (!this.isPluginInstalled)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshTroopMemRecentSaidEntry, isPluginInstalled = false. hide mRecentSaidView.");
        }
        this.mRecentSaidView.setVisibility(8);
      }
    }
    else
    {
      updateRecentSaidView(this.mRecentSaidView, paramProfileCardInfo, this);
    }
    initRecentSaidItem(paramProfileCardInfo);
    return bool1;
  }
  
  private void onPluginInstallFinish(ProfileCardInfo paramProfileCardInfo)
  {
    this.isPluginInstalled = true;
    if (this.mRecentSaidView != null)
    {
      if (this.mActivity == null) {
        return;
      }
      if (!this.mActivity.isResume()) {
        return;
      }
      this.mActivity.runOnUiThread(new ProfileTroopMemInfoComponent.5(this, paramProfileCardInfo));
    }
  }
  
  private MessageRecord queryRecentMsg(ProfileCardInfo paramProfileCardInfo)
  {
    if (this.mApp == null)
    {
      QLog.e("ProfileTroopMemInfoComponent", 2, "queryRecentMsg, mApp == null");
      return null;
    }
    String str2 = UinTypeUtil.a();
    EntityManager localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
    String str1 = MessageRecord.getTableName(paramProfileCardInfo.troopUin, 1);
    str2 = String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype %s and isValid=1", new Object[] { Long.valueOf(9223372036854775807L), str2 });
    if (paramProfileCardInfo.card != null) {
      paramProfileCardInfo = paramProfileCardInfo.card.uin;
    } else {
      paramProfileCardInfo = paramProfileCardInfo.allInOne.uin;
    }
    paramProfileCardInfo = localEntityManager.query(MessageRecord.class, str1, false, str2, new String[] { paramProfileCardInfo }, null, null, "shmsgseq DESC", String.valueOf(1));
    localEntityManager.close();
    if (paramProfileCardInfo != null)
    {
      if (paramProfileCardInfo.isEmpty()) {
        return null;
      }
      return (MessageRecord)paramProfileCardInfo.get(0);
    }
    return null;
  }
  
  private void updateHeader()
  {
    AbsProfileHeaderComponent localAbsProfileHeaderComponent = (AbsProfileHeaderComponent)this.mComponentCenter.getComponent(1002);
    if (localAbsProfileHeaderComponent != null) {
      localAbsProfileHeaderComponent.onDataUpdate((ProfileCardInfo)this.mData);
    }
  }
  
  private static void updateRecentSaidView(View paramView, ProfileCardInfo paramProfileCardInfo, View.OnClickListener paramOnClickListener)
  {
    paramView.setVisibility(0);
    Context localContext = paramView.getContext();
    TextView localTextView = (TextView)paramView.findViewById(2131369087);
    ImageView localImageView = (ImageView)paramView.findViewById(2131362975);
    if (!TextUtils.isEmpty(paramProfileCardInfo.troopRecentSaid))
    {
      localTextView.setText(paramProfileCardInfo.troopRecentSaid);
      localTextView.setContentDescription(paramProfileCardInfo.troopRecentSaid);
      localImageView.setVisibility(0);
      paramView.setOnClickListener(paramOnClickListener);
      return;
    }
    localTextView.setText(localContext.getString(2131697589));
    localTextView.setContentDescription(localContext.getString(2131697589));
    localImageView.setVisibility(0);
    paramView.setOnClickListener(paramOnClickListener);
  }
  
  private void updateTroopUI()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileTroopMemInfoComponent", 2, "updateTroopUI");
    }
    if (this.mDelegate != null) {
      this.mDelegate.notifyCardUpdate();
    }
  }
  
  public void checkAndUpdateTroopInfo(TroopInfo paramTroopInfo)
  {
    AllInOne localAllInOne = ((ProfileCardInfo)this.mData).allInOne;
    if ((localAllInOne != null) && (paramTroopInfo != null) && (ProfilePAUtils.isFromTroopMemberCard(localAllInOne.pa)) && (TextUtils.isEmpty(localAllInOne.troopUin)))
    {
      localAllInOne.troopUin = paramTroopInfo.troopcode;
      localAllInOne.troopCode = paramTroopInfo.troopuin;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileTroopMemInfoComponent", 2, String.format("checkAndUpdateTroopInfo troop[%s, %s]", new Object[] { paramTroopInfo.troopuin, paramTroopInfo.troopcode }));
      }
    }
  }
  
  public String getComponentName()
  {
    return "ProfileTroopMemInfoComponent";
  }
  
  public int getComponentType()
  {
    return 1013;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_troop_mem_info";
  }
  
  public boolean makeOrRefreshTroopMemCharmLevelInfo(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
    boolean bool3 = paramProfileCardInfo.isTroopMemberCard;
    boolean bool2 = true;
    boolean bool1 = true;
    if ((bool3) && (paramProfileCardInfo.troopGlamourLevel >= 0) && (!((TroopManager)localObject).m(paramProfileCardInfo.troopUin)))
    {
      if (this.mActivity == null) {
        return false;
      }
      if (this.mCharmLevelView == null)
      {
        this.mCharmLevelView = this.mActivity.getLayoutInflater().inflate(2131562969, null);
        localObject = (ImageView)this.mCharmLevelView.findViewById(2131368343);
        ((ImageView)localObject).setImageResource(2130845960);
        ((ImageView)localObject).clearColorFilter();
        ((ImageView)localObject).setColorFilter(10067634);
      }
      else
      {
        bool1 = false;
      }
      localObject = (TextView)this.mCharmLevelView.findViewById(2131369087);
      ImageView localImageView = (ImageView)this.mCharmLevelView.findViewById(2131362975);
      ((TextView)localObject).setText(this.mActivity.getString(2131693370));
      DataTag localDataTag = new DataTag(80, null);
      this.mCharmLevelView.setTag(localDataTag);
      this.mCharmLevelView.setOnClickListener(this);
      updateItemTheme(this.mCharmLevelView, (TextView)localObject, null, localImageView);
      ReportController.b(this.mApp, "dc00899", "Grp_flower", "", "charm", "exp_grpname", 0, 0, String.valueOf(paramProfileCardInfo.troopGlamourLevel), "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshTroopMemCharmLevelInfo, showing charm level.");
      }
      return bool1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("makeOrRefreshTroopMemCharmLevelInfo, cardInfo.isTroopMemberCard: ");
      ((StringBuilder)localObject).append(paramProfileCardInfo.isTroopMemberCard);
      ((StringBuilder)localObject).append(", cardInfo.glamourLevel: ");
      ((StringBuilder)localObject).append(paramProfileCardInfo.troopGlamourLevel);
      ((StringBuilder)localObject).append(" isQidianPrivateTroop");
      QLog.d("ProfileTroopMemInfoComponent", 2, ((StringBuilder)localObject).toString());
    }
    if (this.mCharmLevelView != null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    paramProfileCardInfo = this.mCharmLevelView;
    if (paramProfileCardInfo != null) {
      paramProfileCardInfo.setVisibility(8);
    }
    return bool1;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof DataTag))
    {
      DataTag localDataTag = (DataTag)paramView.getTag();
      if (localDataTag.a == 78) {
        handleRecentSaidClick();
      } else if (localDataTag.a == 80) {
        handleCharmLevelClick();
      } else if (localDataTag.a == 83) {
        handleGameInfoClick();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    this.mActivity.addObserver(this.mTroopObserver);
    this.mActivity.addObserver(this.troopOnlinePushObserver);
    this.mActivity.addObserver(this.mTroopManagerBizObserver);
    init();
    paramQBaseActivity = ((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).b(((ProfileCardInfo)this.mData).troopUin);
    checkAndUpdateTroopInfo(paramQBaseActivity);
    if ((paramQBaseActivity != null) && (paramQBaseActivity.isGameBind())) {
      TroopReportor.a("Grp_game", "Mber_data", "mdata_exp", 0, 0, new String[] { paramQBaseActivity.troopuin });
    }
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    return super.onDataUpdate(paramProfileCardInfo) | makeOrRefreshTroopMemInfoEntry((ProfileCardInfo)this.mData);
  }
  
  public void onDestroy()
  {
    if (this.mActivity != null)
    {
      this.mActivity.removeObserver(this.mTroopObserver);
      this.mActivity.removeObserver(this.troopOnlinePushObserver);
      this.mActivity.removeObserver(this.mTroopManagerBizObserver);
    }
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void requestTroopMemberInfo()
  {
    if ((this.mData != null) && (((ProfileCardInfo)this.mData).isTroopMemberCard) && (((ProfileCardInfo)this.mData).allInOne != null))
    {
      if (!NetworkUtil.isNetworkAvailable(this.mActivity)) {
        return;
      }
      try
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(((ProfileCardInfo)this.mData).allInOne.uin);
        localObject = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
        ITroopManagerBizHandler localITroopManagerBizHandler = (ITroopManagerBizHandler)((QQAppInterface)this.mApp).getBusinessHandler(BusinessHandlerFactory.TROOP_MANAGER_BIZ_HANDLER);
        ITroopMemberCardHandler localITroopMemberCardHandler = (ITroopMemberCardHandler)((QQAppInterface)this.mApp).getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER);
        TroopInfo localTroopInfo = ((TroopManager)localObject).b(((ProfileCardInfo)this.mData).troopUin);
        checkAndUpdateTroopInfo(localTroopInfo);
        if ((localTroopInfo != null) && (localITroopMemberCardHandler != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTroopMemInfoComponent", 2, "requestTroopMemberInfo.getTroopMemberCardInfo");
          }
          localITroopMemberCardHandler.a(((ProfileCardInfo)this.mData).troopUin, localTroopInfo.troopcode, localArrayList);
          localITroopMemberCardHandler.a(Long.parseLong(((ProfileCardInfo)this.mData).troopUin), Long.parseLong(((ProfileCardInfo)this.mData).allInOne.uin));
          if (!((TroopManager)localObject).m(((ProfileCardInfo)this.mData).troopUin))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ProfileTroopMemInfoComponent", 2, "requestTroopMemberInfo.requestGlobalTroopLevel");
            }
            localITroopManagerBizHandler.a(Long.parseLong(((ProfileCardInfo)this.mData).allInOne.uin));
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("ProfileTroopMemInfoComponent", 2, "requestTroopMemberInfo.getTroopMemberCardInfo troopInfo null");
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("loadTroopMemberCard:");
          ((StringBuilder)localObject).append(localException.toString());
          QLog.i("ProfileTroopMemInfoComponent", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent
 * JD-Core Version:    0.7.0.1
 */