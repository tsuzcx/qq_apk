package com.tencent.mobileqq.profilecard.bussiness.accountinfo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.report.ProfileAccountInfoReport;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils.ProfileAccountInfoUtils;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.PrettyAccountUtil;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ProfileAccountInfoHeaderComponent
  extends ProfileAccountInfoV2Component
{
  private static final String TAG = "ProfileAccountInfoHeaderComponent";
  
  public ProfileAccountInfoHeaderComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private SpannableStringBuilder combineAccountInfo(List<SpannableString> paramList)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      localSpannableStringBuilder.append((CharSequence)paramList.get(i));
      if (i != j - 1) {
        localSpannableStringBuilder.append(" ");
      }
      i += 1;
    }
    return localSpannableStringBuilder;
  }
  
  private List<SpannableString> getAccountInfo(QQAppInterface paramQQAppInterface, Context paramContext, ProfileCardInfo paramProfileCardInfo)
  {
    ArrayList localArrayList = new ArrayList();
    int i = ProfileAccountInfoUtils.getGenderWithPrivacy(paramProfileCardInfo);
    String str;
    if (i == 0)
    {
      localArrayList.add(new SpannableString(paramContext.getString(2131693923)));
      str = ProfileAccountInfoUtils.getSchoolWithPrivacy(paramProfileCardInfo);
      if (!TextUtils.isEmpty(str))
      {
        if (!paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.schoolVerifiedFlag) {
          break label335;
        }
        localArrayList.add(ProfileCardUtil.a(str, true, 2130845301, 2131298265, 2131298264, paramContext, paramQQAppInterface));
      }
    }
    for (;;)
    {
      paramQQAppInterface = ProfileAccountInfoUtils.getCompanyWithPrivacy(paramProfileCardInfo);
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        localArrayList.add(new SpannableString(paramQQAppInterface));
      }
      paramQQAppInterface = ProfileAccountInfoUtils.getLocationCountryWithPrivacy(paramProfileCardInfo);
      paramContext = ProfileAccountInfoUtils.getLocationProvinceWithPrivacy(paramProfileCardInfo);
      str = ProfileAccountInfoUtils.getLocationCityWithPrivacy(paramProfileCardInfo);
      StringBuilder localStringBuilder = new StringBuilder();
      if ((!TextUtils.isEmpty(paramQQAppInterface)) && (!HardCodeUtil.a(2131708438).equals(paramQQAppInterface))) {
        localStringBuilder.append(paramQQAppInterface);
      }
      if (!TextUtils.isEmpty(paramContext))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("-");
        }
        localStringBuilder.append(paramContext);
      }
      if (!TextUtils.isEmpty(str))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("-");
        }
        localStringBuilder.append(str);
      }
      if (localStringBuilder.length() > 0) {
        localArrayList.add(new SpannableString(localStringBuilder.toString()));
      }
      paramQQAppInterface = ProfileAccountInfoUtils.getConstellationWithPrivacy(paramProfileCardInfo);
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        localArrayList.add(new SpannableString(paramQQAppInterface));
      }
      if (localArrayList.size() < 4) {
        break label355;
      }
      return localArrayList.subList(0, 3);
      if (i != 1) {
        break;
      }
      localArrayList.add(new SpannableString(paramContext.getString(2131692330)));
      break;
      label335:
      localArrayList.add(new SpannableString(str));
    }
    label355:
    return localArrayList;
  }
  
  private void initAccountInfo()
  {
    if (this.mViewContainer != null) {
      this.mActivity.getLayoutInflater().inflate(2131561476, (ViewGroup)this.mViewContainer);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void refreshAccountInfo(Card paramCard, boolean paramBoolean)
  {
    boolean bool1;
    int i;
    if (this.mViewContainer != null)
    {
      paramCard = getAccountInfo(this.mApp, this.mActivity, (ProfileCardInfo)this.mData);
      bool1 = paramCard.isEmpty();
      if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != 0) {
        break label165;
      }
      i = 1;
      if ((bool1) && (i != 0)) {
        paramCard.add(new SpannableString(this.mActivity.getString(2131699059)));
      }
      if (paramCard.isEmpty()) {
        break label170;
      }
      paramBoolean = true;
      label96:
      boolean bool2 = this.mConfigHelper.a(12);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileAccountInfoHeaderComponent", 2, String.format("refreshAccountInfo showAccountInfo=%s baseInfoABTestEnable=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2) }));
      }
      if ((paramBoolean) && (!bool2)) {
        break label175;
      }
      ((View)this.mViewContainer).setVisibility(8);
    }
    label165:
    label170:
    label175:
    TextView localTextView;
    do
    {
      do
      {
        return;
        i = 0;
        break;
        paramBoolean = false;
        break label96;
        ((View)this.mViewContainer).setVisibility(0);
        localTextView = (TextView)((View)this.mViewContainer).findViewById(2131379091);
      } while (localTextView == null);
      localTextView.setText(combineAccountInfo(paramCard));
      localTextView.setOnTouchListener(UITools.a);
      localTextView.setOnClickListener(this);
    } while (bool1);
    ProfileCardUtil.a(localTextView, null, null);
  }
  
  public String getComponentName()
  {
    return "ProfileAccountInfoHeaderComponent";
  }
  
  public int getComponentType()
  {
    return 1024;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ProfileCardUtil.a((ProfileCardInfo)this.mData, this.mApp, this.mActivity);
    } while (!ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData));
    label81:
    QQAppInterface localQQAppInterface;
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      i = 1;
      localQQAppInterface = this.mApp;
      if (i == 0) {
        break label105;
      }
    }
    label105:
    for (int i = 2;; i = 4)
    {
      ProfileAccountInfoReport.reportAccountInfoClick(localQQAppInterface, i);
      break;
      i = 0;
      break label81;
    }
  }
  
  public void onCreate(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    initAccountInfo();
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    refreshAccountInfo(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard, ((ProfileCardInfo)this.mData).d);
    PrettyAccountUtil.a(this.mApp, (ProfileCardInfo)this.mData, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountinfo.ProfileAccountInfoHeaderComponent
 * JD-Core Version:    0.7.0.1
 */