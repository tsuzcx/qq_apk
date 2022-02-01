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
import com.tencent.av.utils.UITools;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.report.ProfileAccountInfoReport;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils.ProfileAccountInfoUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
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
  
  private List<SpannableString> getAccountInfo(AppInterface paramAppInterface, Context paramContext, ProfileCardInfo paramProfileCardInfo)
  {
    ArrayList localArrayList = new ArrayList();
    int i = ProfileAccountInfoUtils.getGenderWithPrivacy(paramProfileCardInfo);
    if (i == 0) {
      localArrayList.add(new SpannableString(paramContext.getString(2131891484)));
    } else if (i == 1) {
      localArrayList.add(new SpannableString(paramContext.getString(2131889246)));
    }
    String str = ProfileAccountInfoUtils.getSchoolWithPrivacy(paramProfileCardInfo);
    if (!TextUtils.isEmpty(str)) {
      if (paramProfileCardInfo.card.schoolVerifiedFlag) {
        localArrayList.add(((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).makeSchoolAuthenticationIcon(str, true, 2130846620, 2131298961, 2131298960, paramContext, paramAppInterface));
      } else {
        localArrayList.add(new SpannableString(str));
      }
    }
    paramAppInterface = ProfileAccountInfoUtils.getCompanyWithPrivacy(paramProfileCardInfo);
    if (!TextUtils.isEmpty(paramAppInterface)) {
      localArrayList.add(new SpannableString(paramAppInterface));
    }
    paramAppInterface = ProfileAccountInfoUtils.getLocationCountryWithPrivacy(paramProfileCardInfo);
    paramContext = ProfileAccountInfoUtils.getLocationProvinceWithPrivacy(paramProfileCardInfo);
    str = ProfileAccountInfoUtils.getLocationCityWithPrivacy(paramProfileCardInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((!TextUtils.isEmpty(paramAppInterface)) && (!HardCodeUtil.a(2131906230).equals(paramAppInterface))) {
      localStringBuilder.append(paramAppInterface);
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
    paramAppInterface = ProfileAccountInfoUtils.getConstellationWithPrivacy(paramProfileCardInfo);
    if (!TextUtils.isEmpty(paramAppInterface)) {
      localArrayList.add(new SpannableString(paramAppInterface));
    }
    paramAppInterface = localArrayList;
    if (localArrayList.size() >= 4) {
      paramAppInterface = localArrayList.subList(0, 3);
    }
    return paramAppInterface;
  }
  
  private void initAccountInfo()
  {
    if (this.mViewContainer != null) {
      this.mActivity.getLayoutInflater().inflate(2131627676, (ViewGroup)this.mViewContainer);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void refreshAccountInfo(Card paramCard, boolean paramBoolean)
  {
    if (this.mViewContainer != null)
    {
      paramCard = getAccountInfo(this.mApp, this.mActivity, (ProfileCardInfo)this.mData);
      paramBoolean = paramCard.isEmpty();
      int i;
      if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((paramBoolean) && (i != 0)) {
        paramCard.add(new SpannableString(this.mActivity.getString(2131897180)));
      }
      boolean bool1 = paramCard.isEmpty() ^ true;
      boolean bool2 = this.mConfigHelper.isSwitchEnable(12);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileAccountInfoHeaderComponent", 2, String.format("refreshAccountInfo showAccountInfo=%s baseInfoABTestEnable=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      if ((bool1) && (!bool2))
      {
        ((View)this.mViewContainer).setVisibility(0);
        TextView localTextView = (TextView)((View)this.mViewContainer).findViewById(2131447062);
        if (localTextView != null)
        {
          localTextView.setText(combineAccountInfo(paramCard));
          localTextView.setOnTouchListener(UITools.a);
          localTextView.setOnClickListener(this);
          if (!paramBoolean) {
            ((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).dealTextViewForCopyAction(localTextView, null, null);
          }
        }
      }
      else
      {
        ((View)this.mViewContainer).setVisibility(8);
      }
    }
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
    if (paramView.getId() == 2131447062)
    {
      ((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).jumpProfileOpenDetails((ProfileCardInfo)this.mData, this.mApp, this.mActivity);
      if (((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).isDefaultProfile((ProfileCardInfo)this.mData))
      {
        int i;
        if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
          i = 1;
        } else {
          i = 0;
        }
        AppInterface localAppInterface = this.mApp;
        if (i != 0) {
          i = 2;
        } else {
          i = 4;
        }
        ProfileAccountInfoReport.reportAccountInfoClick(localAppInterface, i);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    initAccountInfo();
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    refreshAccountInfo(((ProfileCardInfo)this.mData).card, ((ProfileCardInfo)this.mData).isNetRet);
    PrettyAccountUtil.a(this.mApp, (ProfileCardInfo)this.mData, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountinfo.ProfileAccountInfoHeaderComponent
 * JD-Core Version:    0.7.0.1
 */