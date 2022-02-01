package com.tencent.mobileqq.profilecard.bussiness.achievement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.lifeachivement.LifeAchivementData;
import com.tencent.mobileqq.profile.lifeachivement.LifeAchivementHelper;
import com.tencent.mobileqq.profile.lifeachivement.LifeAchivementPanelView;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ProfileAchievementComponent
  extends AbsProfileContentComponent
{
  private static final String TAG = "ProfileAchievementComponent";
  private CardObserver mCardObserver = new ProfileAchievementComponent.1(this);
  private Handler mHandler;
  private boolean mHasScrollToAchievement;
  private boolean mScrollToAchievement;
  
  public ProfileAchievementComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void handlePraiseLifeAchievementResponse(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject;
    LifeAchivementData localLifeAchivementData;
    if (!paramBoolean)
    {
      localObject = (ProfileLifeAchievementInfo)((ProfileCardInfo)this.mData).a(ProfileLifeAchievementInfo.class);
      if ((localObject != null) && (((ProfileLifeAchievementInfo)localObject).lifeAchievementList != null))
      {
        localObject = ((ProfileLifeAchievementInfo)localObject).lifeAchievementList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localLifeAchivementData = (LifeAchivementData)((Iterator)localObject).next();
          if (localLifeAchivementData.b == paramInt2)
          {
            if (paramInt1 != 1) {
              break label144;
            }
            localLifeAchivementData.c -= 1;
            localLifeAchivementData.a = false;
          }
        }
      }
    }
    for (;;)
    {
      localObject = BaseApplicationImpl.getApplication();
      QQToast.a((Context)localObject, ((Context)localObject).getString(2131694693), 0).a();
      if (this.mViewContainer != null) {
        makeOrRefreshLifeAchievement(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard, false);
      }
      return;
      label144:
      if (paramInt1 == 2)
      {
        localLifeAchivementData.c += 1;
        localLifeAchivementData.a = true;
      }
    }
  }
  
  private boolean makeOrRefreshLifeAchievement(Card paramCard, boolean paramBoolean)
  {
    int i = 2;
    ProfileLifeAchievementInfo localProfileLifeAchievementInfo = (ProfileLifeAchievementInfo)((ProfileCardInfo)this.mData).a(ProfileLifeAchievementInfo.class);
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      paramBoolean = true;
      if ((localProfileLifeAchievementInfo == null) || (localProfileLifeAchievementInfo.lifeAchievementList == null) || (localProfileLifeAchievementInfo.lifeAchievementList.isEmpty())) {
        break label145;
      }
    }
    label145:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = LifeAchivementHelper.a(paramCard, this.mConfigHelper, paramBoolean, bool1);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileAchievementComponent", 2, String.format("makeOrRefreshLifeAchievement isSelf=%s hasLifeAchievement=%s showLifeAchievement=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      if (bool2) {
        break label151;
      }
      if (this.mViewContainer == null) {
        break label291;
      }
      this.mViewContainer = null;
      return true;
      paramBoolean = false;
      break;
    }
    label151:
    LifeAchivementPanelView localLifeAchivementPanelView;
    if (this.mViewContainer == null)
    {
      localLifeAchivementPanelView = new LifeAchivementPanelView(this.mActivity);
      localLifeAchivementPanelView.setCardHandler((CardHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
      localLifeAchivementPanelView.setTitle(this.mActivity.getString(2131691264));
      this.mViewContainer = localLifeAchivementPanelView;
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      localLifeAchivementPanelView = (LifeAchivementPanelView)this.mViewContainer;
      localLifeAchivementPanelView.a((ProfileCardInfo)this.mData, paramCard, localProfileLifeAchievementInfo.lifeAchievementOpenId);
      updateLifeAchievementView(localProfileLifeAchievementInfo, bool1, localLifeAchivementPanelView);
      if (paramBoolean) {
        i = 1;
      }
      ReportController.b(this.mApp, "", "", "", "0X800AE53", "0X800AE53", i, 0, "", "", "", "");
      return bool2;
    }
    label291:
    return false;
  }
  
  private void scrollToAchievement()
  {
    if (this.mHandler != null) {
      this.mHandler.postDelayed(new ProfileAchievementComponent.2(this), 1000L);
    }
  }
  
  private void updateLifeAchievementView(ProfileLifeAchievementInfo paramProfileLifeAchievementInfo, boolean paramBoolean, LifeAchivementPanelView paramLifeAchivementPanelView)
  {
    updateItemTheme(paramLifeAchivementPanelView, true);
    if (paramBoolean)
    {
      i = paramProfileLifeAchievementInfo.lifeAchievementTotalCount;
      String str = String.format(this.mActivity.getString(2131698900), new Object[] { Integer.valueOf(i) });
      TextView localTextView = new TextView(this.mActivity);
      localTextView.setText(str);
      paramLifeAchivementPanelView.mTitleExtContainer.removeAllViews();
      paramLifeAchivementPanelView.mTitleExtContainer.addView(localTextView);
      paramLifeAchivementPanelView.mTitleExtContainer.setVisibility(0);
      paramLifeAchivementPanelView.a(paramProfileLifeAchievementInfo.lifeAchievementList, paramProfileLifeAchievementInfo.lifeAchievementTotalCount);
      updateItemTheme(null, localTextView);
      if ((this.mScrollToAchievement) && (!this.mHasScrollToAchievement))
      {
        this.mHasScrollToAchievement = true;
        scrollToAchievement();
      }
      return;
    }
    paramLifeAchivementPanelView.mTitleExtContainer.removeAllViews();
    paramLifeAchivementPanelView.mTitleExtContainer.setVisibility(8);
    paramLifeAchivementPanelView.a();
    paramBoolean = ThemeUtil.isInNightMode(this.mApp);
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate != null) {}
    for (int i = 1;; i = 0)
    {
      if ((paramBoolean) || (i != 0)) {
        ((URLImageView)paramLifeAchivementPanelView.findViewById(2131370024)).setVisibility(4);
      }
      paramProfileLifeAchievementInfo = (TextView)paramLifeAchivementPanelView.findViewById(2131380151);
      paramLifeAchivementPanelView = (TextView)paramLifeAchivementPanelView.findViewById(2131380152);
      updateItemTheme(paramProfileLifeAchievementInfo, null);
      updateItemTheme(paramLifeAchivementPanelView, null);
      break;
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
  
  public void onCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    paramBaseActivity = this.mActivity.getIntent();
    if (paramBaseActivity != null) {
      this.mScrollToAchievement = paramBaseActivity.getBooleanExtra("profile_scroll_to_achievement", false);
    }
    this.mHandler = new Handler(Looper.getMainLooper());
    this.mApp.addObserver(this.mCardObserver);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshLifeAchievement(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard, ((ProfileCardInfo)this.mData).d) | bool;
  }
  
  public void onDestroy()
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
    this.mApp.removeObserver(this.mCardObserver);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.achievement.ProfileAchievementComponent
 * JD-Core Version:    0.7.0.1
 */