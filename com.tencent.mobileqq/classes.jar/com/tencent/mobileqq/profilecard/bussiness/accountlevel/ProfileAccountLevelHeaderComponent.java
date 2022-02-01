package com.tencent.mobileqq.profilecard.bussiness.accountlevel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.ProfileQQLevelView;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.report.ProfileAccountLevelReport;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ProfileAccountLevelHeaderComponent
  extends ProfileAccountLevelComponent
{
  private static final String TAG = "ProfileAccountLevelHeaderComponent";
  private ProfileCardInfo mCardInfo;
  private boolean mFirstVisible = true;
  
  public ProfileAccountLevelHeaderComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
    this.mCardInfo = paramProfileCardInfo;
  }
  
  private void initAccountLevel()
  {
    if (this.mViewContainer != null) {
      this.mActivity.getLayoutInflater().inflate(2131561477, (ViewGroup)this.mViewContainer);
    }
  }
  
  private void refreshAccountLevel(Card paramCard, boolean paramBoolean)
  {
    if (this.mViewContainer != null)
    {
      paramBoolean = needShowAccountLevel(paramCard);
      boolean bool = this.mConfigHelper.a(12);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileAccountLevelHeaderComponent", 2, String.format("refreshAccountLevel showAccountInfo=%s baseInfoABTestEnable=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) }));
      }
      if ((!paramBoolean) || (!bool)) {
        ((View)this.mViewContainer).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    if (this.mFirstVisible) {
      ProfileAccountLevelReport.reportAccountLevelVisible(this.mApp, this.mCardInfo);
    }
    this.mFirstVisible = false;
    ((View)this.mViewContainer).setVisibility(0);
    paramCard = (ProfileQQLevelView)((View)this.mViewContainer).findViewById(2131374727);
    if (paramCard != null)
    {
      paramCard.update((ProfileCardInfo)this.mData, this.mIsFromArkBabyQ);
      paramCard.setClickable(false);
    }
    updateDarenView();
    updateNumPAGView();
    ((View)this.mViewContainer).setTag(new DataTag(69, null));
    ((View)this.mViewContainer).setOnClickListener(this);
    paramCard = (ImageView)((View)this.mViewContainer).findViewById(2131363027);
    updateItemTheme((View)this.mViewContainer, null, null, paramCard);
  }
  
  public String getComponentName()
  {
    return "ProfileAccountLevelHeaderComponent";
  }
  
  public int getComponentType()
  {
    return 1022;
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    int k = 1;
    int j = 1;
    Object localObject = paramView.getTag();
    if ((localObject instanceof DataTag)) {
      switch (((DataTag)localObject).a)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      handleDarenIconClick();
      if (ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData))
      {
        if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
        {
          i = 1;
          label107:
          localObject = this.mApp;
          if (i == 0) {
            break label133;
          }
        }
        label133:
        for (i = j;; i = 3)
        {
          ProfileAccountLevelReport.reportAccountDarenClick((QQAppInterface)localObject, i);
          break;
          i = 0;
          break label107;
        }
        handleAccountLevelClick();
        if (ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData))
        {
          if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {
            i = 1;
          }
          localObject = this.mApp;
          if (i != 0) {}
          for (i = k;; i = 3)
          {
            ProfileAccountLevelReport.reportAccountLevelClick((QQAppInterface)localObject, i);
            break;
          }
          if ((this.mCardInfo != null) && (this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
            handleVipNumPagViewClick(paramView, this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
          }
        }
      }
    }
  }
  
  public void onCreate(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    initAccountLevel();
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    this.mCardInfo = paramProfileCardInfo;
    refreshAccountLevel(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard, ((ProfileCardInfo)this.mData).d);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountlevel.ProfileAccountLevelHeaderComponent
 * JD-Core Version:    0.7.0.1
 */