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
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileGuideApi;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.report.ProfileAccountInfoReport;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils.ProfileAccountInfoUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
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
    String str = ProfileAccountInfoUtils.getConstellationWithPrivacy(paramProfileCardInfo);
    long l = ProfileAccountInfoUtils.getBirthdayWithPrivacy(paramProfileCardInfo);
    if (l > 0L)
    {
      int i = (int)(0xFF00 & l) >> 8;
      int j = (int)(l & 0xFF);
      if ((i > 0) && (j > 0))
      {
        paramProfileCardInfo = new StringBuilder();
        paramProfileCardInfo.append(i);
        paramProfileCardInfo.append(paramResources.getString(2131694201));
        paramProfileCardInfo.append(j);
        paramProfileCardInfo.append(paramResources.getString(2131691450));
        paramProfileCardInfo = paramProfileCardInfo.toString();
        break label104;
      }
    }
    paramProfileCardInfo = null;
    label104:
    if ((!TextUtils.isEmpty(paramProfileCardInfo)) && (!TextUtils.isEmpty(str)))
    {
      paramResources = new StringBuilder();
      paramResources.append(paramProfileCardInfo);
      paramResources.append(" ");
      paramResources.append(str);
      paramList.add(paramResources.toString());
      return;
    }
    if (!TextUtils.isEmpty(paramProfileCardInfo))
    {
      paramList.add(paramProfileCardInfo);
      return;
    }
    if (!TextUtils.isEmpty(str)) {
      paramList.add(str);
    }
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
    int i = ProfileAccountInfoUtils.getGenderWithPrivacy(paramProfileCardInfo);
    Object localObject = null;
    String str;
    if (i == 0) {
      str = paramResources.getString(2131693879);
    } else if (i == 1) {
      str = paramResources.getString(2131692259);
    } else {
      str = null;
    }
    i = ProfileAccountInfoUtils.getAgeWithPrivacy(paramProfileCardInfo);
    paramProfileCardInfo = localObject;
    if (i > 0)
    {
      paramProfileCardInfo = new StringBuilder();
      paramProfileCardInfo.append(i);
      paramProfileCardInfo.append(paramResources.getString(2131719391));
      paramProfileCardInfo = paramProfileCardInfo.toString();
    }
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramProfileCardInfo)))
    {
      paramResources = new StringBuilder();
      paramResources.append(str);
      paramResources.append(" ");
      paramResources.append(paramProfileCardInfo);
      paramList.add(paramResources.toString());
      return;
    }
    if (!TextUtils.isEmpty(str))
    {
      paramList.add(str);
      return;
    }
    if (!TextUtils.isEmpty(paramProfileCardInfo)) {
      paramList.add(paramProfileCardInfo);
    }
  }
  
  private void appendHometown(List<String> paramList, ProfileCardInfo paramProfileCardInfo, Resources paramResources)
  {
    String str = ProfileAccountInfoUtils.getHometownProvinceWithPrivacy(paramProfileCardInfo);
    paramProfileCardInfo = ProfileAccountInfoUtils.getHometownCityWithPrivacy(paramProfileCardInfo);
    if ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty(paramProfileCardInfo)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramResources.getString(2131699150));
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
      localStringBuilder.append(paramResources.getString(2131699151));
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
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() > 0)
      {
        localObject = paramString;
        if (paramTextView != null)
        {
          Resources localResources = paramTextView.getResources();
          TextPaint localTextPaint = paramTextView.getPaint();
          int i = paramTextView.getPaddingLeft();
          int j = paramTextView.getPaddingRight();
          int n = paramTextView.getWidth() - i - j;
          localObject = paramString;
          if (n > 0)
          {
            int i1 = paramString.length();
            j = 0;
            int k = 0;
            for (;;)
            {
              int m = paramString.offsetByCodePoints(j, 1);
              paramTextView = paramString.substring(j, m);
              if ("|".equals(paramTextView)) {
                i = Utils.a(1.0F, localResources);
              } else if (" ".equals(paramTextView)) {
                i = Utils.a(8.0F, localResources);
              } else {
                i = (int)localTextPaint.measureText(paramTextView);
              }
              k += i;
              if (k > n) {
                break;
              }
              if (m >= i1 - 1) {
                return paramString;
              }
              j = m;
            }
            paramTextView = paramString.substring(0, j).trim();
            paramString = paramString.substring(j).trim();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramTextView);
            if (!TextUtils.isEmpty(paramString))
            {
              ((StringBuilder)localObject).append('\n');
              ((StringBuilder)localObject).append(paramString);
            }
            localObject = ((StringBuilder)localObject).toString();
          }
        }
      }
    }
    return localObject;
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
    localColorDrawable.setBounds(0, 0, Utils.a(8.0F, paramContext), 0);
    return new ImageSpan(localColorDrawable);
  }
  
  private ImageSpan genSplitImageSpan(Context paramContext)
  {
    return new ProfileAccountInfoV2Component.CustomImageSpan(paramContext, 2130845895, 2);
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
    Object localObject = makeAccountInfo(paramCard);
    int i = ((ProfileCardInfo)this.mData).allInOne.pa;
    boolean bool3 = false;
    boolean bool2 = false;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    paramBoolean = ProfilePAUtils.isPaTypeShowAccount(((ProfileCardInfo)this.mData).allInOne);
    boolean bool1 = ((List)localObject).isEmpty() ^ true;
    if ((((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).isDefaultProfile((ProfileCardInfo)this.mData)) && (paramCard != null) && ((i != 0) || ((paramBoolean) && (bool1)))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    boolean bool4 = this.mConfigHelper.isSwitchEnable(12);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAccountInfoV2Component", 2, String.format("makeOrRefreshAccountInfo showAccountInfo=%s baseInfoABTestEnable=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool4) }));
    }
    if ((paramBoolean) && (bool4))
    {
      paramBoolean = bool2;
      if (this.mViewContainer == null)
      {
        this.mViewContainer = this.mActivity.getLayoutInflater().inflate(2131561341, null);
        ((View)this.mViewContainer).setOnClickListener(this);
        paramBoolean = true;
      }
      paramCard = (TextView)((View)this.mViewContainer).findViewById(2131378460);
      ImageView localImageView = (ImageView)((View)this.mViewContainer).findViewById(2131362975);
      if (paramCard != null) {
        if ((i != 0) && (!bool1))
        {
          paramCard.setText(2131699152);
          localObject = new DataTag(81, null);
          ((View)this.mViewContainer).setTag(localObject);
        }
        else
        {
          paramCard.setText(combineAccountInfo((List)localObject, paramCard));
          localObject = new DataTag(103, null);
          ((View)this.mViewContainer).setTag(localObject);
        }
      }
      updateItemTheme((View)this.mViewContainer, paramCard, null, localImageView);
      return paramBoolean;
    }
    paramBoolean = bool3;
    if (this.mViewContainer != null)
    {
      this.mViewContainer = null;
      paramBoolean = true;
    }
    return paramBoolean;
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
    Object localObject = paramView.getTag();
    if ((localObject instanceof DataTag))
    {
      int i = ((DataTag)localObject).a;
      if (i != 81)
      {
        if (i == 103)
        {
          ((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).jumpProfileOpenDetails((ProfileCardInfo)this.mData, this.mApp, this.mActivity);
          if (((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).isDefaultProfile((ProfileCardInfo)this.mData))
          {
            i = ((ProfileCardInfo)this.mData).allInOne.pa;
            int j = 1;
            if (i == 0) {
              i = 1;
            } else {
              i = 0;
            }
            localObject = this.mApp;
            if (i != 0) {
              i = j;
            } else {
              i = 3;
            }
            ProfileAccountInfoReport.reportAccountInfoClick((AppInterface)localObject, i);
          }
        }
      }
      else {
        ((IProfileGuideApi)QRoute.api(IProfileGuideApi.class)).jumpProfileEdit(this.mApp, this.mActivity, (ProfileCardInfo)this.mData);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    return super.onDataUpdate(paramProfileCardInfo) | makeOrRefreshAccountInfo(((ProfileCardInfo)this.mData).card, ((ProfileCardInfo)this.mData).isNetRet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountinfo.ProfileAccountInfoV2Component
 * JD-Core Version:    0.7.0.1
 */