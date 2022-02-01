package com.tencent.mobileqq.profilecard.bussiness.accountlevel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.ProfileQQLevelView;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.report.ProfileAccountLevelReport;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
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
      this.mActivity.getLayoutInflater().inflate(2131627677, (ViewGroup)this.mViewContainer);
    }
  }
  
  private void refreshAccountLevel(Card paramCard, boolean paramBoolean)
  {
    if (this.mViewContainer != null)
    {
      paramBoolean = needShowAccountLevel(paramCard);
      boolean bool = this.mConfigHelper.isSwitchEnable(12);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileAccountLevelHeaderComponent", 2, String.format("refreshAccountLevel showAccountInfo=%s baseInfoABTestEnable=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) }));
      }
      if ((paramBoolean) && (bool))
      {
        if (this.mFirstVisible) {
          ProfileAccountLevelReport.reportAccountLevelVisible(this.mQQAppInterface, this.mCardInfo);
        }
        this.mFirstVisible = false;
        ((View)this.mViewContainer).setVisibility(0);
        paramCard = (ProfileQQLevelView)((View)this.mViewContainer).findViewById(2131442358);
        if (paramCard != null)
        {
          paramCard.update((ProfileCardInfo)this.mData, this.mIsFromArkBabyQ);
          paramCard.setClickable(false);
        }
        updateDarenView();
        updateNumPAGView();
        ((View)this.mViewContainer).setTag(new DataTag(69, null));
        ((View)this.mViewContainer).setOnClickListener(this);
        paramCard = (ImageView)((View)this.mViewContainer).findViewById(2131428774);
        updateItemTheme((View)this.mViewContainer, null, null, paramCard);
        return;
      }
      ((View)this.mViewContainer).setVisibility(8);
    }
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
    Object localObject = paramView.getTag();
    if ((localObject instanceof DataTag))
    {
      int m = ((DataTag)localObject).a;
      int i = 3;
      int k = 0;
      int j = 0;
      if (m != 69)
      {
        if (m != 100)
        {
          if (m == 104)
          {
            localObject = this.mCardInfo;
            if ((localObject != null) && (((ProfileCardInfo)localObject).card != null)) {
              handleVipNumPagViewClick(paramView, this.mCardInfo.card.uin);
            }
          }
        }
        else
        {
          handleDarenIconClick();
          if (ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData))
          {
            if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
              j = 1;
            }
            localObject = this.mQQAppInterface;
            if (j != 0) {
              i = 1;
            }
            ProfileAccountLevelReport.reportAccountDarenClick((QQAppInterface)localObject, i);
          }
        }
      }
      else
      {
        handleAccountLevelClick();
        if (ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData))
        {
          j = k;
          if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
            j = 1;
          }
          localObject = this.mQQAppInterface;
          if (j != 0) {
            i = 1;
          }
          ProfileAccountLevelReport.reportAccountLevelClick((QQAppInterface)localObject, i);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    initAccountLevel();
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    this.mCardInfo = paramProfileCardInfo;
    refreshAccountLevel(((ProfileCardInfo)this.mData).card, ((ProfileCardInfo)this.mData).isNetRet);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountlevel.ProfileAccountLevelHeaderComponent
 * JD-Core Version:    0.7.0.1
 */