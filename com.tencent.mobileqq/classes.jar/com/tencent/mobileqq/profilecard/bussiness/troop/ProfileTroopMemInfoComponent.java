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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberCard.MemberGameInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.container.ProfileContentContainer;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.handler.TroopMemberInfoHandler;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelUtils;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.troop.utils.TroopLinkManager.LinkParams;
import com.tencent.mobileqq.troop.utils.TroopMemberGlobalLevelUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.troop.TroopPluginManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ProfileTroopMemInfoComponent
  extends AbsProfileContentComponent
  implements View.OnClickListener
{
  private static final String TAG = "ProfileTroopMemInfoComponent";
  private boolean gameImfoPrepared = false;
  volatile boolean isPluginInstalled = false;
  private View mCharmLevelView;
  private View mGameInfoView;
  private View mJoinTimeView;
  private View mRecentSaidView;
  protected TroopBusinessObserver mTroopBusinessObserver = new ProfileTroopMemInfoComponent.2(this);
  protected TroopObserver mTroopObserver = new ProfileTroopMemInfoComponent.1(this);
  
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
      }
      return;
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
      }
      return;
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
      }
      return;
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
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ProfileTroopMemInfoComponent", 1, "update mRecentSaidView fail.", localException);
    }
  }
  
  private void handleCharmLevelClick()
  {
    if ((this.mData == null) || (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "handleCharmLevelClick, mData == null || mData.allinone == null");
      }
      return;
    }
    TroopLinkManager localTroopLinkManager = TroopLinkManager.a();
    Object localObject2 = TroopMemberGlobalLevelUtils.a();
    Object localObject1 = localObject2;
    if (this.mData != null)
    {
      localObject1 = localObject2;
      if (TroopMemberLevelUtils.a(((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString))
      {
        localObject1 = localObject2;
        if (TroopMemberLevelUtils.a()) {
          localObject1 = TroopMemberLevelUtils.a();
        }
      }
    }
    localObject2 = new TroopLinkManager.LinkParams();
    ((TroopLinkManager.LinkParams)localObject2).c = "31";
    ((TroopLinkManager.LinkParams)localObject2).jdField_b_of_type_JavaLangString = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    ((TroopLinkManager.LinkParams)localObject2).jdField_a_of_type_JavaLangString = ((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString;
    localObject1 = localTroopLinkManager.a((String)localObject1, (TroopLinkManager.LinkParams)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, "handleCharmLevelClick, url:" + (String)localObject1);
    }
    localObject2 = new Intent(this.mActivity, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    ((Intent)localObject2).putExtra("uin", this.mApp.getCurrentUin());
    ((Intent)localObject2).putExtra("portraitOnly", true);
    ((Intent)localObject2).putExtra("hide_more_button", true);
    ((Intent)localObject2).putExtra("hide_operation_bar", true);
    ((Intent)localObject2).putExtra("isShowAd", false);
    this.mActivity.startActivity((Intent)localObject2);
    ReportController.b(this.mApp, "dc00899", "Grp_grade", "", "mber_card", "clk_grade", 0, 0, ((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString, "", "", "");
    new ReportTask(this.mApp).a("dc00899").b("Grp_mem_card").c("page").d("grade_clk").a(new String[] { ((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString }).a();
    ProfileCardReport.reportTroopLevelClick(this.mApp, (ProfileCardInfo)this.mData);
  }
  
  private void handleGameInfoClick()
  {
    if ((this.mData != null) && (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard != null))
    {
      TroopMemberCard.MemberGameInfo localMemberGameInfo = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard.mMemberGameInfo;
      if (localMemberGameInfo != null)
      {
        String str = localMemberGameInfo.gameUrl;
        Intent localIntent = new Intent(this.mActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", str);
        this.mActivity.startActivity(localIntent);
        TroopReportor.a("Grp_game", "Mber_data", "game_clk", 0, 0, new String[] { ((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString, localMemberGameInfo.gameName });
      }
    }
  }
  
  private void handleRecentSaidClick()
  {
    if ((this.mData == null) || (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (this.mActivity == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "handleRecentSaidClick, mData == null || mData.allinone == null || mActivity == null");
      }
    }
    do
    {
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("troop_uin", ((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString);
      localIntent.putExtra("member_uin", ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      PublicFragmentActivity.a(this.mActivity, localIntent, TroopMemberHistoryFragment.class);
    } while (this.mApp == null);
    new ReportTask(this.mApp).a("dc00899").b("Grp_mem_card").c("page").d("recent_clk").a(new String[] { ((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString }).a();
    ReportController.b(this.mApp, "CliOper", "", "", "0X800A596", "0X800A596", 2, 0, "", "", "", "");
  }
  
  private void initRecentSaidItem(ProfileCardInfo paramProfileCardInfo)
  {
    ThreadManager.post(new ProfileTroopMemInfoComponent.3(this, paramProfileCardInfo), 8, null, true);
  }
  
  private boolean makeOrRefreshGameTroopInfoView(ProfileCardInfo paramProfileCardInfo)
  {
    if ((!paramProfileCardInfo.jdField_b_of_type_Boolean) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard.mMemberGameInfo == null) || (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard.mMemberGameInfo.gameName)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshGameTroopInfoView. Not showing game info.");
      }
      if (this.mGameInfoView != null) {}
      for (bool = true;; bool = false)
      {
        if (this.mGameInfoView != null) {
          this.mGameInfoView.setVisibility(8);
        }
        return bool;
      }
    }
    if (this.mGameInfoView == null) {
      this.mGameInfoView = this.mActivity.getLayoutInflater().inflate(2131561506, null);
    }
    for (boolean bool = true;; bool = false)
    {
      TextView localTextView1 = (TextView)this.mGameInfoView.findViewById(2131367729);
      TextView localTextView2 = (TextView)this.mGameInfoView.findViewById(2131367736);
      localTextView2.setBackgroundDrawable(TroopUtils.a(this.mActivity.getResources(), Color.parseColor("#3094cf")));
      Object localObject = (ImageView)this.mGameInfoView.findViewById(2131376462);
      TextView localTextView3 = (TextView)this.mGameInfoView.findViewById(2131367737);
      TextView localTextView4 = (TextView)this.mGameInfoView.findViewById(2131367738);
      ImageView localImageView = (ImageView)this.mGameInfoView.findViewById(2131363027);
      TroopMemberCard.MemberGameInfo localMemberGameInfo = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard.mMemberGameInfo;
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
      }
      for (;;)
      {
        try
        {
          int i = AIOUtils.a(18.0F, this.mActivity.getResources());
          int j = AIOUtils.a(18.0F, this.mActivity.getResources());
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
            float f = AIOUtils.a(2.0F, this.mActivity.getResources());
            i = AIOUtils.a(4.0F, this.mActivity.getResources());
            localObject = new GradientDrawable();
            ((GradientDrawable)localObject).setCornerRadius(f);
            localTextView2.setPadding(i, 0, i, 0);
            if (TextUtils.isEmpty(localMemberGameInfo.gameBackGroundColor)) {
              continue;
            }
            ((GradientDrawable)localObject).setColor(Color.parseColor(localMemberGameInfo.gameBackGroundColor));
            localTextView2.setBackgroundDrawable((Drawable)localObject);
          }
          if (!TextUtils.isEmpty(localMemberGameInfo.gameFontColor)) {
            localTextView2.setTextColor(Color.parseColor(localMemberGameInfo.gameFontColor));
          }
          this.gameImfoPrepared = true;
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshGameTroopInfoView. Showing game info.");
          }
          TroopReportor.a("Grp_game", "Mber_data", "game_exp", 0, 0, new String[] { paramProfileCardInfo.jdField_a_of_type_JavaLangString, localMemberGameInfo.gameName });
        }
        catch (Exception paramProfileCardInfo)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.profilecard.FrdProfileCard", 2, paramProfileCardInfo.toString());
          continue;
        }
        paramProfileCardInfo = new DataTag(83, null);
        this.mGameInfoView.setTag(paramProfileCardInfo);
        this.mGameInfoView.setOnClickListener(this);
        this.mGameInfoView.setVisibility(0);
        updateItemTheme(this.mGameInfoView, localTextView1, localTextView3, localImageView);
        updateItemTheme(this.mGameInfoView, localTextView2, localTextView4, localImageView);
        return bool;
        ((GradientDrawable)localObject).setColor(Color.parseColor("#FFBA26"));
      }
    }
  }
  
  private boolean makeOrRefreshTroopMemInfoEntry(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool2 = false | makeOrRefreshTroopMemJoinTime((ProfileCardInfo)this.mData) | makeOrRefreshTroopMemCharmLevelInfo((ProfileCardInfo)this.mData) | makeOrRefreshTroopMemRecentSaidEntry((ProfileCardInfo)this.mData) | makeOrRefreshGameTroopInfoView((ProfileCardInfo)this.mData);
    if (((this.mJoinTimeView != null) && (this.mJoinTimeView.getVisibility() == 0)) || ((this.mCharmLevelView != null) && (this.mCharmLevelView.getVisibility() == 0)) || ((this.mRecentSaidView != null) && (this.mRecentSaidView.getVisibility() == 0)) || ((this.mGameInfoView != null) && (this.mGameInfoView.getVisibility() == 0)))
    {
      bool1 = true;
      if (bool2)
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
        if ((((View)this.mViewContainer).getParent() != null) && ((((View)this.mViewContainer).getParent() instanceof ViewGroup))) {
          ((ViewGroup)((View)this.mViewContainer).getParent()).removeView((View)this.mViewContainer);
        }
        addJoinTimeView();
        addCharmLevelView();
        addRecentSaidView();
        addGameInfoView();
      }
      if (bool1) {
        return bool2;
      }
      if (this.mViewContainer != null) {
        break label347;
      }
    }
    label347:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.mViewContainer != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemInfoComponent", 2, new Object[] { "bShow = false. mViewContainer removeAllViews. mViewContainer=%s", this.mViewContainer });
        }
        ((ViewGroup)this.mViewContainer).removeAllViews();
      }
      this.mViewContainer = null;
      return bool2 | bool1;
      bool1 = false;
      break;
    }
    return bool2;
  }
  
  private boolean makeOrRefreshTroopMemJoinTime(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((!paramProfileCardInfo.jdField_b_of_type_Boolean) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard == null)) {
      if (this.mJoinTimeView != null)
      {
        bool1 = true;
        if (this.mJoinTimeView != null) {
          this.mJoinTimeView.setVisibility(8);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemInfoComponent", 2, String.format("makeOrRefreshTroopMemJoinTime, Not showing mem join time", new Object[0]));
        }
        bool2 = bool1;
      }
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      return bool2;
      bool1 = false;
      break;
      localObject1 = "";
      localObject2 = localObject1;
      long l;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard.joinTime > 0L)
      {
        l = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard.joinTime;
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberCard.joinTime == 1L) {}
      }
      try
      {
        localObject1 = DateFormat.format(this.mActivity.getString(2131693414), 1000L * l).toString();
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("ProfileTroopMemInfoComponent", 2, String.format("makeOrRefreshTroopMemJoinTime, timeStamp: %s, joinTime: %s", new Object[] { Long.valueOf(l), localObject1 }));
          localObject2 = localObject1;
        }
        if (TextUtils.isEmpty(localObject2)) {
          if (this.mJoinTimeView != null)
          {
            bool2 = bool1;
            if (this.mJoinTimeView == null) {
              continue;
            }
            this.mJoinTimeView.setVisibility(8);
            return bool1;
          }
        }
      }
      catch (Exception paramProfileCardInfo)
      {
        for (;;)
        {
          localObject1 = "";
          continue;
          bool1 = false;
        }
      }
    }
    if (this.mJoinTimeView == null)
    {
      this.mJoinTimeView = this.mActivity.getLayoutInflater().inflate(2131563146, null);
      paramProfileCardInfo = (ImageView)this.mJoinTimeView.findViewById(2131368603);
      paramProfileCardInfo.setImageResource(2130846087);
      paramProfileCardInfo.clearColorFilter();
      paramProfileCardInfo.setColorFilter(10067634);
    }
    for (bool1 = true;; bool1 = false)
    {
      paramProfileCardInfo = (TextView)this.mJoinTimeView.findViewById(2131369358);
      localObject1 = (ImageView)this.mJoinTimeView.findViewById(2131363027);
      ((ImageView)localObject1).setVisibility(8);
      paramProfileCardInfo.setText(localObject2);
      this.mJoinTimeView.setVisibility(0);
      QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshTroopMemJoinTime 05");
      updateItemTheme(this.mJoinTimeView, paramProfileCardInfo, null, (ImageView)localObject1);
      return bool1;
    }
  }
  
  private boolean makeOrRefreshTroopMemRecentSaidEntry(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = false;
    if (!paramProfileCardInfo.jdField_b_of_type_Boolean)
    {
      if (this.mRecentSaidView != null) {
        bool = true;
      }
      if (this.mRecentSaidView != null) {
        this.mRecentSaidView.setVisibility(8);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshTroopMemRecentSaidEntry, isTroopMemberCard = false. Not showing recent said.");
      }
      return bool;
    }
    Object localObject;
    if (this.mRecentSaidView == null)
    {
      this.mRecentSaidView = this.mActivity.getLayoutInflater().inflate(2131563146, null);
      localObject = (ImageView)this.mRecentSaidView.findViewById(2131368603);
      ((ImageView)localObject).setImageResource(2130846101);
      ((ImageView)localObject).clearColorFilter();
      ((ImageView)localObject).setColorFilter(10067634);
    }
    for (bool = true;; bool = false)
    {
      localObject = (TextView)this.mRecentSaidView.findViewById(2131369358);
      ImageView localImageView = (ImageView)this.mRecentSaidView.findViewById(2131363027);
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
      for (;;)
      {
        initRecentSaidItem(paramProfileCardInfo);
        return bool;
        updateRecentSaidView(this.mRecentSaidView, paramProfileCardInfo, this);
      }
    }
  }
  
  private void onPluginInstallFinish(ProfileCardInfo paramProfileCardInfo)
  {
    this.isPluginInstalled = true;
    if ((this.mRecentSaidView == null) || (this.mActivity == null)) {}
    while (!this.mActivity.isResume()) {
      return;
    }
    this.mActivity.runOnUiThread(new ProfileTroopMemInfoComponent.4(this, paramProfileCardInfo));
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
    String str1 = MessageRecord.getTableName(paramProfileCardInfo.jdField_a_of_type_JavaLangString, 1);
    str2 = String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype %s and isValid=1", new Object[] { Long.valueOf(9223372036854775807L), str2 });
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) {}
    for (paramProfileCardInfo = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin;; paramProfileCardInfo = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)
    {
      paramProfileCardInfo = localEntityManager.query(MessageRecord.class, str1, false, str2, new String[] { paramProfileCardInfo }, null, null, "shmsgseq DESC", String.valueOf(1));
      localEntityManager.close();
      if ((paramProfileCardInfo == null) || (paramProfileCardInfo.isEmpty())) {
        break;
      }
      return (MessageRecord)paramProfileCardInfo.get(0);
    }
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
    TextView localTextView = (TextView)paramView.findViewById(2131369358);
    ImageView localImageView = (ImageView)paramView.findViewById(2131363027);
    if (!TextUtils.isEmpty(paramProfileCardInfo.jdField_b_of_type_JavaLangString))
    {
      localTextView.setText(paramProfileCardInfo.jdField_b_of_type_JavaLangString);
      localTextView.setContentDescription(paramProfileCardInfo.jdField_b_of_type_JavaLangString);
      localImageView.setVisibility(0);
      paramView.setOnClickListener(paramOnClickListener);
      return;
    }
    localTextView.setText(localContext.getString(2131697583));
    localTextView.setContentDescription(localContext.getString(2131697583));
    localImageView.setVisibility(0);
    paramView.setOnClickListener(paramOnClickListener);
  }
  
  private void updateTroopUI()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileTroopMemInfoComponent", 2, "updateTroopUI");
    }
    ProfileContentContainer localProfileContentContainer = (ProfileContentContainer)this.mComponentCenter.getComponent(103);
    if (localProfileContentContainer != null) {
      localProfileContentContainer.onDataUpdate((ProfileCardInfo)this.mData);
    }
  }
  
  public void checkAndUpdateTroopInfo(TroopInfo paramTroopInfo)
  {
    ProfileActivity.AllInOne localAllInOne = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
    if ((localAllInOne != null) && (paramTroopInfo != null) && (ProfileActivity.f(localAllInOne.jdField_a_of_type_Int)) && (TextUtils.isEmpty(localAllInOne.d)))
    {
      localAllInOne.d = paramTroopInfo.troopcode;
      localAllInOne.c = paramTroopInfo.troopuin;
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
  
  public void init()
  {
    requestTroopMemberInfo();
  }
  
  public boolean makeOrRefreshTroopMemCharmLevelInfo(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((!paramProfileCardInfo.jdField_b_of_type_Boolean) || (paramProfileCardInfo.jdField_a_of_type_Int < 0) || (((TroopManager)localObject).n(paramProfileCardInfo.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshTroopMemCharmLevelInfo, cardInfo.isTroopMemberCard: " + paramProfileCardInfo.jdField_b_of_type_Boolean + ", cardInfo.glamourLevel: " + paramProfileCardInfo.jdField_a_of_type_Int + " isQidianPrivateTroop");
      }
      if (this.mCharmLevelView != null) {
        bool1 = true;
      }
      bool2 = bool1;
      if (this.mCharmLevelView != null)
      {
        this.mCharmLevelView.setVisibility(8);
        bool2 = bool1;
      }
    }
    while (this.mActivity == null) {
      return bool2;
    }
    if (this.mCharmLevelView == null)
    {
      this.mCharmLevelView = this.mActivity.getLayoutInflater().inflate(2131563146, null);
      localObject = (ImageView)this.mCharmLevelView.findViewById(2131368603);
      ((ImageView)localObject).setImageResource(2130846083);
      ((ImageView)localObject).clearColorFilter();
      ((ImageView)localObject).setColorFilter(10067634);
    }
    for (bool1 = true;; bool1 = false)
    {
      localObject = (TextView)this.mCharmLevelView.findViewById(2131369358);
      ImageView localImageView = (ImageView)this.mCharmLevelView.findViewById(2131363027);
      ((TextView)localObject).setText(this.mActivity.getString(2131693415));
      DataTag localDataTag = new DataTag(80, null);
      this.mCharmLevelView.setTag(localDataTag);
      this.mCharmLevelView.setOnClickListener(this);
      updateItemTheme(this.mCharmLevelView, (TextView)localObject, null, localImageView);
      ReportController.b(this.mApp, "dc00899", "Grp_flower", "", "charm", "exp_grpname", 0, 0, String.valueOf(paramProfileCardInfo.jdField_a_of_type_Int), "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshTroopMemCharmLevelInfo, showing charm level.");
      }
      return bool1;
    }
  }
  
  public void onClick(View paramView)
  {
    DataTag localDataTag;
    if ((paramView.getTag() instanceof DataTag))
    {
      localDataTag = (DataTag)paramView.getTag();
      if (localDataTag.jdField_a_of_type_Int != 78) {
        break label39;
      }
      handleRecentSaidClick();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label39:
      if (localDataTag.jdField_a_of_type_Int == 80) {
        handleCharmLevelClick();
      } else if (localDataTag.jdField_a_of_type_Int == 83) {
        handleGameInfoClick();
      }
    }
  }
  
  public void onCreate(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    this.mActivity.addObserver(this.mTroopObserver);
    this.mActivity.addObserver(this.mTroopBusinessObserver);
    paramBaseActivity = ((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).b(((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString);
    checkAndUpdateTroopInfo(paramBaseActivity);
    if ((paramBaseActivity != null) && (paramBaseActivity.isGameBind())) {
      TroopReportor.a("Grp_game", "Mber_data", "mdata_exp", 0, 0, new String[] { paramBaseActivity.troopuin });
    }
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshTroopMemInfoEntry((ProfileCardInfo)this.mData) | bool;
  }
  
  public void onDestroy()
  {
    if (this.mActivity != null)
    {
      this.mActivity.removeObserver(this.mTroopObserver);
      this.mActivity.removeObserver(this.mTroopBusinessObserver);
    }
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void requestTroopMemberInfo()
  {
    if ((this.mData == null) || (!((ProfileCardInfo)this.mData).jdField_b_of_type_Boolean) || (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (!NetworkUtil.g(this.mActivity))) {}
    label305:
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            TroopManager localTroopManager = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
            TroopHandler localTroopHandler = (TroopHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
            TroopMemberInfoHandler localTroopMemberInfoHandler = (TroopMemberInfoHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER);
            TroopInfo localTroopInfo = localTroopManager.b(((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString);
            checkAndUpdateTroopInfo(localTroopInfo);
            if ((localTroopInfo == null) || (localTroopMemberInfoHandler == null)) {
              break label305;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ProfileTroopMemInfoComponent", 2, "requestTroopMemberInfo.getTroopMemberCardInfo");
            }
            localTroopMemberInfoHandler.a(((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString, localTroopInfo.troopcode, localArrayList);
            localTroopMemberInfoHandler.a(Long.parseLong(((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString), Long.parseLong(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
            if (!localTroopManager.n(((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ProfileTroopMemInfoComponent", 2, "requestTroopMemberInfo.requestGlobalTroopLevel");
              }
              localTroopHandler.d(Long.parseLong(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
              return;
            }
          }
          catch (Exception localException) {}
        }
      } while (!QLog.isColorLevel());
      QLog.i("ProfileTroopMemInfoComponent", 2, "loadTroopMemberCard:" + localException.toString());
      return;
    } while (!QLog.isColorLevel());
    QLog.d("ProfileTroopMemInfoComponent", 2, "requestTroopMemberInfo.getTroopMemberCardInfo troopInfo null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent
 * JD-Core Version:    0.7.0.1
 */