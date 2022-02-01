package com.tencent.mobileqq.profilecard.bussiness.achievement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.achievement.bean.LifeAchivementData;
import com.tencent.mobileqq.profilecard.bussiness.achievement.bean.ProfileLifeAchievementInfo;
import com.tencent.mobileqq.profilecard.bussiness.achievement.handler.LifeAchievementHandler;
import com.tencent.mobileqq.profilecard.bussiness.achievement.handler.LifeAchievementObserver;
import com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementPanelView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class ProfileAchievementComponent
  extends AbsProfileContentComponent
{
  private static final String TAG = "ProfileAchievementComponent";
  private Handler mHandler;
  private boolean mHasScrollToAchievement;
  private LifeAchievementObserver mLifeAchievementObserver = new ProfileAchievementComponent.1(this);
  private boolean mScrollToAchievement;
  
  public ProfileAchievementComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void handlePraiseLifeAchievementResponse(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!paramBoolean)
    {
      Object localObject = (ProfileLifeAchievementInfo)((ProfileCardInfo)this.mData).getBusinessInfo(ProfileLifeAchievementInfo.class);
      if ((localObject != null) && (((ProfileLifeAchievementInfo)localObject).lifeAchievementList != null))
      {
        localObject = ((ProfileLifeAchievementInfo)localObject).lifeAchievementList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          LifeAchivementData localLifeAchivementData = (LifeAchivementData)((Iterator)localObject).next();
          if (localLifeAchivementData.id == paramInt2) {
            if (paramInt1 == 1)
            {
              localLifeAchivementData.praiseNum -= 1;
              localLifeAchivementData.hasPraised = false;
            }
            else if (paramInt1 == 2)
            {
              localLifeAchivementData.praiseNum += 1;
              localLifeAchivementData.hasPraised = true;
            }
          }
        }
      }
      localObject = MobileQQ.sMobileQQ.getApplicationContext();
      QQToast.makeText((Context)localObject, ((Context)localObject).getString(2131892359), 0).show();
    }
    if (this.mViewContainer != null) {
      makeOrRefreshLifeAchievement(((ProfileCardInfo)this.mData).card, false);
    }
  }
  
  private boolean makeOrRefreshLifeAchievement(Card paramCard, boolean paramBoolean)
  {
    ProfileLifeAchievementInfo localProfileLifeAchievementInfo = (ProfileLifeAchievementInfo)((ProfileCardInfo)this.mData).getBusinessInfo(ProfileLifeAchievementInfo.class);
    int i = ((ProfileCardInfo)this.mData).allInOne.pa;
    boolean bool3 = false;
    paramBoolean = false;
    boolean bool1;
    if (i == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((localProfileLifeAchievementInfo != null) && (localProfileLifeAchievementInfo.lifeAchievementList != null) && (!localProfileLifeAchievementInfo.lifeAchievementList.isEmpty())) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool4 = LifeAchivementHelper.shouldShowAchivementPanelOrNot(paramCard, this.mConfigHelper, bool1, bool2);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAchievementComponent", 2, String.format("makeOrRefreshLifeAchievement isSelf=%s hasLifeAchievement=%s showLifeAchievement=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool4) }));
    }
    if (!bool4)
    {
      paramBoolean = bool3;
      if (this.mViewContainer != null)
      {
        this.mViewContainer = null;
        return true;
      }
    }
    else
    {
      if (this.mViewContainer == null)
      {
        localLifeAchivementPanelView = new LifeAchivementPanelView(this.mActivity);
        localLifeAchivementPanelView.setLifeAchievementHandler((LifeAchievementHandler)this.mApp.getBusinessHandler(LifeAchievementHandler.class.getName()));
        localLifeAchivementPanelView.setTitle(this.mActivity.getString(2131888131));
        this.mViewContainer = localLifeAchivementPanelView;
        paramBoolean = true;
      }
      LifeAchivementPanelView localLifeAchivementPanelView = (LifeAchivementPanelView)this.mViewContainer;
      localLifeAchivementPanelView.updateUserInfo((ProfileCardInfo)this.mData, paramCard, localProfileLifeAchievementInfo.lifeAchievementOpenId);
      updateLifeAchievementView(localProfileLifeAchievementInfo, bool2, localLifeAchivementPanelView);
      if (bool1) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(this.mApp, "", "", "", "0X800AE53", "0X800AE53", i, 0, "", "", "", "");
    }
    return paramBoolean;
  }
  
  private void scrollToAchievement()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.postDelayed(new ProfileAchievementComponent.2(this), 1000L);
    }
  }
  
  private void updateLifeAchievementView(ProfileLifeAchievementInfo paramProfileLifeAchievementInfo, boolean paramBoolean, LifeAchivementPanelView paramLifeAchivementPanelView)
  {
    updateItemTheme(paramLifeAchivementPanelView, true);
    int i = 0;
    if (paramBoolean)
    {
      i = paramProfileLifeAchievementInfo.lifeAchievementTotalCount;
      String str = String.format(this.mActivity.getString(2131896971), new Object[] { Integer.valueOf(i) });
      TextView localTextView = new TextView(this.mActivity);
      localTextView.setText(str);
      paramLifeAchivementPanelView.mTitleExtContainer.removeAllViews();
      paramLifeAchivementPanelView.mTitleExtContainer.addView(localTextView);
      paramLifeAchivementPanelView.mTitleExtContainer.setVisibility(0);
      paramLifeAchivementPanelView.showAchivementList(paramProfileLifeAchievementInfo.lifeAchievementList, paramProfileLifeAchievementInfo.lifeAchievementTotalCount);
      updateItemTheme(null, localTextView);
    }
    else
    {
      paramLifeAchivementPanelView.mTitleExtContainer.removeAllViews();
      paramLifeAchivementPanelView.mTitleExtContainer.setVisibility(8);
      paramLifeAchivementPanelView.showEmptyView();
      paramBoolean = ThemeUtil.isInNightMode(this.mApp);
      if (((ProfileCardInfo)this.mData).currentTemplate != null) {
        i = 1;
      }
      if ((paramBoolean) || (i != 0)) {
        ((URLImageView)paramLifeAchivementPanelView.findViewById(2131436821)).setVisibility(4);
      }
      paramProfileLifeAchievementInfo = (TextView)paramLifeAchivementPanelView.findViewById(2131448221);
      paramLifeAchivementPanelView = (TextView)paramLifeAchivementPanelView.findViewById(2131448222);
      updateItemTheme(paramProfileLifeAchievementInfo, null);
      updateItemTheme(paramLifeAchivementPanelView, null);
    }
    if ((this.mScrollToAchievement) && (!this.mHasScrollToAchievement))
    {
      this.mHasScrollToAchievement = true;
      scrollToAchievement();
    }
  }
  
  public String getComponentName()
  {
    return "ProfileAchievementComponent";
  }
  
  public int getComponentType()
  {
    return 1007;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_life_achievement";
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    paramQBaseActivity = this.mActivity.getIntent();
    if (paramQBaseActivity != null) {
      this.mScrollToAchievement = paramQBaseActivity.getBooleanExtra("profile_scroll_to_achievement", false);
    }
    this.mHandler = new Handler(Looper.getMainLooper());
    this.mApp.addObserver(this.mLifeAchievementObserver);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    return super.onDataUpdate(paramProfileCardInfo) | makeOrRefreshLifeAchievement(((ProfileCardInfo)this.mData).card, ((ProfileCardInfo)this.mData).isNetRet);
  }
  
  public void onDestroy()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
    this.mApp.removeObserver(this.mLifeAchievementObserver);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.achievement.ProfileAchievementComponent
 * JD-Core Version:    0.7.0.1
 */