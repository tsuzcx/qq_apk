package com.tencent.mobileqq.profilecard.bussiness.accountinfo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.report.ProfileAccountInfoReport;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils.ProfileAccountInfoUtils;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileAccountInfoV2Component
  extends AbsProfileContentComponent
  implements View.OnClickListener
{
  private static final float SPACE_WIDTH = 8.0F;
  private static final float SPLIT_WIDTH = 1.0F;
  private static final String TAG = "ProfileAccountInfoV2Component";
  
  public ProfileAccountInfoV2Component(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void appendBirthdayAndConstellation(List<String> paramList, ProfileCardInfo paramProfileCardInfo, Resources paramResources)
  {
    Object localObject = null;
    String str = ProfileAccountInfoUtils.getConstellationWithPrivacy(paramProfileCardInfo);
    long l = ProfileAccountInfoUtils.getBirthdayWithPrivacy(paramProfileCardInfo);
    paramProfileCardInfo = localObject;
    if (l > 0L)
    {
      int i = (int)(0xFF00 & l) >> 8;
      int j = (int)(l & 0xFF);
      paramProfileCardInfo = localObject;
      if (i > 0)
      {
        paramProfileCardInfo = localObject;
        if (j > 0)
        {
          paramProfileCardInfo = new StringBuilder();
          paramProfileCardInfo.append(i);
          paramProfileCardInfo.append(paramResources.getString(2131694236));
          paramProfileCardInfo.append(j);
          paramProfileCardInfo.append(paramResources.getString(2131691528));
          paramProfileCardInfo = paramProfileCardInfo.toString();
        }
      }
    }
    if ((!TextUtils.isEmpty(paramProfileCardInfo)) && (!TextUtils.isEmpty(str))) {
      paramList.add(paramProfileCardInfo + " " + str);
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramProfileCardInfo))
      {
        paramList.add(paramProfileCardInfo);
        return;
      }
    } while (TextUtils.isEmpty(str));
    paramList.add(str);
  }
  
  private void appendCompany(List<String> paramList, ProfileCardInfo paramProfileCardInfo, Resources paramResources)
  {
    paramProfileCardInfo = ProfileAccountInfoUtils.getCompanyWithPrivacy(paramProfileCardInfo);
    if (!TextUtils.isEmpty(paramProfileCardInfo)) {
      paramList.add(paramProfileCardInfo);
    }
  }
  
  private void appendEmail(List<String> paramList, ProfileCardInfo paramProfileCardInfo, Resources paramResources)
  {
    paramProfileCardInfo = ProfileAccountInfoUtils.getEmailWithPrivacy(paramProfileCardInfo);
    if (!TextUtils.isEmpty(paramProfileCardInfo)) {
      paramList.add(paramProfileCardInfo);
    }
  }
  
  private void appendGenderAndAge(List<String> paramList, ProfileCardInfo paramProfileCardInfo, Resources paramResources)
  {
    Object localObject = null;
    int i = ProfileAccountInfoUtils.getGenderWithPrivacy(paramProfileCardInfo);
    String str;
    if (i == 0) {
      str = paramResources.getString(2131693923);
    }
    for (;;)
    {
      i = ProfileAccountInfoUtils.getAgeWithPrivacy(paramProfileCardInfo);
      paramProfileCardInfo = localObject;
      if (i > 0) {
        paramProfileCardInfo = i + paramResources.getString(2131719672);
      }
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramProfileCardInfo))) {
        paramList.add(str + " " + paramProfileCardInfo);
      }
      do
      {
        return;
        if (i != 1) {
          break label159;
        }
        str = paramResources.getString(2131692330);
        break;
        if (!TextUtils.isEmpty(str))
        {
          paramList.add(str);
          return;
        }
      } while (TextUtils.isEmpty(paramProfileCardInfo));
      paramList.add(paramProfileCardInfo);
      return;
      label159:
      str = null;
    }
  }
  
  private void appendHometown(List<String> paramList, ProfileCardInfo paramProfileCardInfo, Resources paramResources)
  {
    String str = ProfileAccountInfoUtils.getHometownProvinceWithPrivacy(paramProfileCardInfo);
    paramProfileCardInfo = ProfileAccountInfoUtils.getHometownCityWithPrivacy(paramProfileCardInfo);
    if ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty(paramProfileCardInfo)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramResources.getString(2131699046));
      if (!TextUtils.isEmpty(str)) {
        localStringBuilder.append(str);
      }
      if (!TextUtils.isEmpty(paramProfileCardInfo)) {
        localStringBuilder.append(paramProfileCardInfo);
      }
      paramList.add(localStringBuilder.toString());
    }
  }
  
  private void appendLocation(List<String> paramList, ProfileCardInfo paramProfileCardInfo, Resources paramResources)
  {
    String str = ProfileAccountInfoUtils.getLocationProvinceWithPrivacy(paramProfileCardInfo);
    paramProfileCardInfo = ProfileAccountInfoUtils.getLocationCityWithPrivacy(paramProfileCardInfo);
    if ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty(paramProfileCardInfo)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramResources.getString(2131699047));
      if (!TextUtils.isEmpty(str)) {
        localStringBuilder.append(str);
      }
      if (!TextUtils.isEmpty(paramProfileCardInfo)) {
        localStringBuilder.append(paramProfileCardInfo);
      }
      paramList.add(localStringBuilder.toString());
    }
  }
  
  private void appendProfession(List<String> paramList, ProfileCardInfo paramProfileCardInfo, Resources paramResources)
  {
    paramProfileCardInfo = ProfileAccountInfoUtils.getProfessionTagWithPrivacy(paramProfileCardInfo);
    if (!TextUtils.isEmpty(paramProfileCardInfo)) {
      paramList.add(paramProfileCardInfo);
    }
  }
  
  private void appendSchool(List<String> paramList, ProfileCardInfo paramProfileCardInfo, Resources paramResources)
  {
    paramProfileCardInfo = ProfileAccountInfoUtils.getSchoolWithPrivacy(paramProfileCardInfo);
    if (!TextUtils.isEmpty(paramProfileCardInfo)) {
      paramList.add(paramProfileCardInfo);
    }
  }
  
  private String calculateAccountInfoBreak(String paramString, TextView paramTextView)
  {
    Object localObject;
    TextPaint localTextPaint;
    int i;
    int j;
    int n;
    int i1;
    if ((paramString != null) && (paramString.length() > 0) && (paramTextView != null))
    {
      localObject = paramTextView.getResources();
      localTextPaint = paramTextView.getPaint();
      i = paramTextView.getPaddingLeft();
      j = paramTextView.getPaddingRight();
      n = paramTextView.getWidth() - i - j;
      if (n > 0)
      {
        i1 = paramString.length();
        j = 0;
      }
    }
    int m;
    label222:
    for (int k = 0;; k = m)
    {
      m = paramString.offsetByCodePoints(k, 1);
      paramTextView = paramString.substring(k, m);
      if ("|".equals(paramTextView)) {
        i = AIOUtils.a(1.0F, (Resources)localObject);
      }
      while (j + i <= n)
      {
        j += i;
        if (m < i1 - 1) {
          break label222;
        }
        return paramString;
        if (" ".equals(paramTextView)) {
          i = AIOUtils.a(8.0F, (Resources)localObject);
        } else {
          i = (int)localTextPaint.measureText(paramTextView);
        }
      }
      paramTextView = paramString.substring(0, k).trim();
      paramString = paramString.substring(k).trim();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramTextView);
      if (!TextUtils.isEmpty(paramString))
      {
        ((StringBuilder)localObject).append('\n');
        ((StringBuilder)localObject).append(paramString);
      }
      return ((StringBuilder)localObject).toString();
    }
  }
  
  private SpannableStringBuilder combineAccountInfo(List<String> paramList, TextView paramTextView)
  {
    Object localObject = new StringBuilder();
    if ((paramList != null) && (!paramList.isEmpty()) && (paramTextView != null))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject).append((String)paramList.get(i));
        if (i != j - 1) {
          ((StringBuilder)localObject).append(" | ");
        }
        i += 1;
      }
    }
    paramTextView = calculateAccountInfoBreak(((StringBuilder)localObject).toString(), paramTextView);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAccountInfoV2Component", 2, String.format("combineAccountInfo accountInfo=%s", new Object[] { paramTextView }));
    }
    paramList = new SpannableStringBuilder(paramTextView);
    localObject = Pattern.compile("\\|").matcher(paramTextView);
    while (((Matcher)localObject).find()) {
      paramList.setSpan(genSplitImageSpan(this.mActivity.getApplicationContext()), ((Matcher)localObject).start(), ((Matcher)localObject).end(), 33);
    }
    paramTextView = Pattern.compile(" ").matcher(paramTextView);
    while (paramTextView.find()) {
      paramList.setSpan(genSpaceImageSpan(this.mActivity.getApplicationContext()), paramTextView.start(), paramTextView.end(), 33);
    }
    return paramList;
  }
  
  private ImageSpan genSpaceImageSpan(Context paramContext)
  {
    paramContext = paramContext.getResources();
    ColorDrawable localColorDrawable = new ColorDrawable();
    localColorDrawable.setBounds(0, 0, AIOUtils.a(8.0F, paramContext), 0);
    return new ImageSpan(localColorDrawable);
  }
  
  private ImageSpan genSplitImageSpan(Context paramContext)
  {
    return new ProfileAccountInfoV2Component.CustomImageSpan(paramContext, 2130846020, 2);
  }
  
  private List<String> makeAccountInfo(Card paramCard)
  {
    Resources localResources = this.mActivity.getResources();
    ArrayList localArrayList = new ArrayList();
    if (paramCard != null)
    {
      appendGenderAndAge(localArrayList, (ProfileCardInfo)this.mData, localResources);
      appendBirthdayAndConstellation(localArrayList, (ProfileCardInfo)this.mData, localResources);
      appendSchool(localArrayList, (ProfileCardInfo)this.mData, localResources);
      appendLocation(localArrayList, (ProfileCardInfo)this.mData, localResources);
      appendHometown(localArrayList, (ProfileCardInfo)this.mData, localResources);
      appendCompany(localArrayList, (ProfileCardInfo)this.mData, localResources);
      appendProfession(localArrayList, (ProfileCardInfo)this.mData, localResources);
      appendEmail(localArrayList, (ProfileCardInfo)this.mData, localResources);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAccountInfoV2Component", 2, String.format("makeAccountInfo list=%s", new Object[] { Arrays.toString(localArrayList.toArray()) }));
    }
    return localArrayList;
  }
  
  private boolean makeOrRefreshAccountInfo(Card paramCard, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject = makeAccountInfo(paramCard);
    int i;
    int j;
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      i = 1;
      paramBoolean = ProfileActivity.AllInOne.a(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      if (((List)localObject).isEmpty()) {
        break label171;
      }
      j = 1;
      label58:
      if ((!ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData)) || (paramCard == null) || ((i == 0) && ((!paramBoolean) || (j == 0)))) {
        break label352;
      }
    }
    label171:
    label314:
    label352:
    for (paramBoolean = true;; paramBoolean = false)
    {
      boolean bool3 = this.mConfigHelper.a(12);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileAccountInfoV2Component", 2, String.format("makeOrRefreshAccountInfo showAccountInfo=%s baseInfoABTestEnable=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool3) }));
      }
      if ((!paramBoolean) || (!bool3))
      {
        paramBoolean = bool1;
        if (this.mViewContainer != null)
        {
          this.mViewContainer = null;
          paramBoolean = true;
        }
        return paramBoolean;
        i = 0;
        break;
        j = 0;
        break label58;
      }
      paramBoolean = bool2;
      if (this.mViewContainer == null)
      {
        this.mViewContainer = this.mActivity.getLayoutInflater().inflate(2131561497, null);
        ((View)this.mViewContainer).setOnClickListener(this);
        paramBoolean = true;
      }
      paramCard = (TextView)((View)this.mViewContainer).findViewById(2131379091);
      ImageView localImageView = (ImageView)((View)this.mViewContainer).findViewById(2131363027);
      if (paramCard != null)
      {
        if ((i == 0) || (j != 0)) {
          break label314;
        }
        paramCard.setText(2131699048);
        localObject = new DataTag(81, null);
        ((View)this.mViewContainer).setTag(localObject);
      }
      for (;;)
      {
        updateItemTheme((View)this.mViewContainer, paramCard, null, localImageView);
        return paramBoolean;
        paramCard.setText(combineAccountInfo((List)localObject, paramCard));
        localObject = new DataTag(103, null);
        ((View)this.mViewContainer).setTag(localObject);
      }
    }
  }
  
  public String getComponentName()
  {
    return "ProfileAccountInfoV2Component";
  }
  
  public int getComponentType()
  {
    return 1023;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_account_info_v2";
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    Object localObject = paramView.getTag();
    if ((localObject instanceof DataTag)) {
      switch (((DataTag)localObject).a)
      {
      }
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        ProfileCardUtils.openProfileEdit(this.mApp, this.mActivity, (ProfileCardInfo)this.mData);
      }
      ProfileCardUtil.a((ProfileCardInfo)this.mData, this.mApp, this.mActivity);
    } while (!ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData));
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      i = 1;
      label130:
      localObject = this.mApp;
      if (i == 0) {
        break label156;
      }
    }
    label156:
    for (int i = j;; i = 3)
    {
      ProfileAccountInfoReport.reportAccountInfoClick((QQAppInterface)localObject, i);
      break;
      i = 0;
      break label130;
    }
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshAccountInfo(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard, ((ProfileCardInfo)this.mData).d) | bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountinfo.ProfileAccountInfoV2Component
 * JD-Core Version:    0.7.0.1
 */