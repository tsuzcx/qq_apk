package com.tencent.mobileqq.profilecard.vas.view;

import SummaryCardTaf.summaryCardWzryInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.VipWZRYTemplateConfig;
import com.tencent.mobileqq.profile.VipWZRYTemplateConfig.WZRYHonorItem;
import com.tencent.mobileqq.profile.VipWZRYTemplateConfig.WZRYResourceItem;
import com.tencent.mobileqq.profile.VipWZRYTemplateHelper;
import com.tencent.mobileqq.profile.view.ShimmerLinearLayout;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class VasProfileWZRYView
  extends AbsProfileHeaderView
{
  private static final String NUMBER_PLACE_HOLDER = "[num]";
  private static final int WZRY_HEADER_HEIGHT = 160;
  private ImageView mAddIcon;
  private View mBlankView;
  private HorizontalScrollView mGameInfoLayout;
  private ShimmerLinearLayout mGameInfoShimmerLayout;
  private LayoutInflater mInflater = null;
  private ImageView mLogo;
  private ImageView mLogoBg;
  private float mOldScreenHeight = 0.0F;
  private int mOriginalBlankViewHeight;
  
  public VasProfileWZRYView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity, paramProfileCardInfo);
  }
  
  private View initMainView()
  {
    this.mInflater = LayoutInflater.from(getContext());
    return this.mInflater.inflate(2131562200, this, true);
  }
  
  private void prepareForEnterAnimation()
  {
    int i = getResources().getDimensionPixelSize(2131297098);
    int j = ProfileCardUtil.a(getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mBlankView.getLayoutParams();
    localLayoutParams.height = ((int)this.mScreenHeight - ProfileCardUtil.b(this.mActivity, 160) - i - j);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      localLayoutParams.height += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + localLayoutParams.height);
    }
    this.mOriginalBlankViewHeight = localLayoutParams.height;
    this.mBlankView.setLayoutParams(localLayoutParams);
    this.mBlankView.setFocusable(true);
    this.mBlankView.setFocusableInTouchMode(true);
  }
  
  private void updateAvatarArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    AvatarLayout localAvatarLayout = (AvatarLayout)paramView.findViewById(2131382079);
    localAvatarLayout.setVisibility(0);
    DataTag localDataTag = new DataTag(1, null);
    localAvatarLayout.setTag(localDataTag);
    localAvatarLayout.setOnClickListener(this.mOnClickListener);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (String str = getContext().getString(2131691276);; str = getContext().getString(2131691275))
    {
      localAvatarLayout.setContentDescription(str);
      localAvatarLayout.a(0, localAvatarLayout.findViewById(2131363511), false);
      this.mHeaderChildMap.put("map_key_face", localAvatarLayout);
      super.updateAvatar(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      paramView = (ImageView)paramView.findViewById(2131382077);
      paramView.setVisibility(4);
      paramView.setOnClickListener(this.mOnClickListener);
      paramView.setTag(localDataTag);
      this.mHeaderChildMap.put("map_key_avatar_pendant", paramView);
      super.updateAvatarPendantImage(paramProfileCardInfo, true);
      return;
    }
  }
  
  private void updateBaseInfoArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131382083);
    this.mHeaderChildMap.put("map_key_sex_age_area", paramView);
    super.updateSexAgeArea(paramProfileCardInfo);
  }
  
  private void updateHeadArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    paramView = (ProfileNameView)paramView.findViewById(2131382081);
    paramView.setVisibility(0);
    paramView.setClickable(true);
    paramView.setClickListener(this.mOnClickListener);
    this.mHeaderChildMap.put("map_key_profile_nick_name", paramView);
    super.updateHead(paramProfileCardInfo);
  }
  
  private void updateLikeArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    HeartLayout localHeartLayout = (HeartLayout)paramView.findViewById(2131382075);
    localHeartLayout.setEnabled(false);
    paramView = (VoteView)paramView.findViewById(2131382090);
    paramView.setHeartLayout(this.mApp, localHeartLayout);
    this.mHeaderChildMap.put("map_key_like", paramView);
    super.updateLike(paramProfileCardInfo);
  }
  
  private void updateLogoArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    this.mLogo = ((ImageView)paramView.findViewById(2131382084));
    ProfileCardTemplate.a(this.mLogo, "apngDrawable", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "wzryLogo");
    ApngImage.playByTag(7);
    this.mLogoBg = ((ImageView)paramView.findViewById(2131382085));
    ProfileCardTemplate.a(this.mLogoBg, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "wzryLogoBg");
  }
  
  int calcTopNumTextSize(TextView paramTextView, int paramInt, String paramString, String[] paramArrayOfString)
  {
    int m = 0;
    TextPaint localTextPaint = new TextPaint(paramTextView.getPaint());
    int k = m;
    float f2;
    if (!TextUtils.isEmpty(paramString))
    {
      k = m;
      if (paramArrayOfString != null)
      {
        k = m;
        if (paramArrayOfString.length > 0)
        {
          paramTextView = paramString;
          if (paramString.endsWith("[num]")) {
            paramTextView = paramString + "\r\n";
          }
          int i = paramTextView.split("\\[num\\]").length - 1;
          if (i > paramArrayOfString.length) {
            i = paramArrayOfString.length;
          }
          int j;
          for (;;)
          {
            k = m;
            if (i <= 0) {
              break label298;
            }
            paramString = "";
            j = 0;
            k = 0;
            while (k < i)
            {
              j += paramArrayOfString[k].length();
              paramString = paramString + paramArrayOfString[k];
              k += 1;
            }
          }
          k = m;
          if (j > 0)
          {
            paramTextView = paramTextView.replace("[num]", "");
            i = 0;
            while (i < j - 1)
            {
              paramTextView = paramTextView + " ";
              i += 1;
            }
            f2 = paramInt - localTextPaint.measureText(paramTextView);
          }
        }
      }
    }
    for (float f1 = f2;; f1 -= 1.0F)
    {
      k = m;
      if (f1 > 0.0F)
      {
        localTextPaint.setTextSize(f1);
        if (localTextPaint.measureText(paramString) >= f2) {
          continue;
        }
        if (f1 > paramInt / 2) {
          k = paramInt / 2;
        }
      }
      else
      {
        label298:
        return k;
      }
      return (int)f1;
    }
  }
  
  void generateLogoAnimation()
  {
    this.mUIHandler.postDelayed(new VasProfileWZRYView.2(this), 1000L);
  }
  
  public SpannableStringBuilder getSpannableString(String paramString, String[] paramArrayOfString, int paramInt, float paramFloat, ColorStateList paramColorStateList)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (TextUtils.isEmpty(paramString)) {
      return localSpannableStringBuilder;
    }
    if (paramString.contains("[num]"))
    {
      String str;
      int i;
      label71:
      int k;
      int j;
      if (paramString.equals("[num]"))
      {
        str = paramString + " ";
        paramString = str.split("\\[num\\]");
        i = 0;
        if (i >= paramString.length) {
          break label336;
        }
        str = paramString[i];
        if ((i != 0) && (!"\r\n".equals(str))) {
          localSpannableStringBuilder.append(" ");
        }
        if (!"\r\n".equals(str)) {
          localSpannableStringBuilder.append(str);
        }
        if (i < paramString.length - 1)
        {
          k = localSpannableStringBuilder.length();
          if ((paramArrayOfString == null) || (i >= paramArrayOfString.length)) {
            break label304;
          }
          j = paramArrayOfString[i].length();
          localSpannableStringBuilder.append(paramArrayOfString[i]);
          j += k;
        }
      }
      for (;;)
      {
        if (ProfileCardTemplate.b != null) {
          localSpannableStringBuilder.setSpan(new VasProfileWZRYView.CustomTypefaceSpan("", ProfileCardTemplate.b), k, j, 17);
        }
        localSpannableStringBuilder.setSpan(new TextAppearanceSpan(null, 3, paramInt, paramColorStateList, null), k, j, 17);
        localSpannableStringBuilder.setSpan(new VasProfileWZRYView.VerticalCenterTextSpan(paramInt, -2.0F), k, j, 17);
        i += 1;
        break label71;
        str = paramString;
        if (!paramString.endsWith("[num]")) {
          break;
        }
        str = paramString + "\r\n";
        break;
        label304:
        j = "[num]".length();
        localSpannableStringBuilder.append("[num]");
        j += k;
      }
    }
    else
    {
      localSpannableStringBuilder.append(paramString);
    }
    label336:
    return localSpannableStringBuilder;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    int i = (int)this.mScreenHeight;
    if (this.mOldScreenHeight != this.mScreenHeight)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.mBlankView.getLayoutParams();
      paramConfiguration.height = ((int)(paramConfiguration.height + (this.mScreenHeight - this.mOldScreenHeight)));
      this.mBlankView.setLayoutParams(paramConfiguration);
      this.mOriginalBlankViewHeight = ((int)(this.mOriginalBlankViewHeight + (this.mScreenHeight - this.mOldScreenHeight)));
      this.mOldScreenHeight = this.mScreenHeight;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.i(TAG, 1, "VipProfileWZRYView.onDestroy");
    if (this.mGameInfoShimmerLayout != null) {
      this.mGameInfoShimmerLayout.c();
    }
  }
  
  public void onInit(ProfileCardInfo paramProfileCardInfo)
  {
    this.mOldScreenHeight = this.mScreenHeight;
    Object localObject = initMainView();
    updateLogoArea(paramProfileCardInfo, (View)localObject);
    this.mBlankView = ((View)localObject).findViewById(2131382078);
    this.mGameInfoShimmerLayout = ((ShimmerLinearLayout)((View)localObject).findViewById(2131382073));
    this.mAddIcon = ((ImageView)((View)localObject).findViewById(2131382072));
    this.mGameInfoLayout = ((HorizontalScrollView)((View)localObject).findViewById(2131382074));
    ProfileCardTemplate.a(this.mGameInfoLayout, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "wzryGameInfoBackground");
    prepareForEnterAnimation();
    updateAvatarArea(paramProfileCardInfo, (View)localObject);
    updateHeadArea(paramProfileCardInfo, (View)localObject);
    updateBaseInfoArea(paramProfileCardInfo, (View)localObject);
    updateLikeArea(paramProfileCardInfo, (View)localObject);
    updateGameInfo(paramProfileCardInfo);
    super.onInit(paramProfileCardInfo);
    super.updateJueban(paramProfileCardInfo);
    generateLogoAnimation();
    if (this.mApp.getCurrentAccountUin().equals(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {}
    for (localObject = "PV_owner";; localObject = "PV_visitor")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_gameking", (String)localObject, "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), String.valueOf(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
      return;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.mGameInfoShimmerLayout.b();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(7);
  }
  
  public void onUpdate(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.updateLike(paramProfileCardInfo);
    super.updateHead(paramProfileCardInfo);
    super.updateSexAgeArea(paramProfileCardInfo);
    super.updateAvatarPendantImage(paramProfileCardInfo, false);
    updateGameInfo(paramProfileCardInfo);
  }
  
  public void updateGameInfo(ProfileCardInfo paramProfileCardInfo)
  {
    this.mGameInfoShimmerLayout.b();
    this.mGameInfoShimmerLayout.removeAllViews();
    Object localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getWzryHonorInfo();
    Object localObject2 = (RelativeLayout.LayoutParams)this.mBlankView.getLayoutParams();
    if (((List)localObject1).isEmpty())
    {
      this.mGameInfoLayout.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject2).height = (this.mOriginalBlankViewHeight - ProfileCardUtil.b(this.mActivity, 67));
      return;
    }
    this.mGameInfoLayout.setVisibility(0);
    ((RelativeLayout.LayoutParams)localObject2).height = (this.mOriginalBlankViewHeight - ProfileCardUtil.b(this.mActivity, 132));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, 0, DisplayUtil.a(getContext(), 5.0F), 0);
    VipWZRYTemplateConfig localVipWZRYTemplateConfig = VipWZRYTemplateConfig.jdField_a_of_type_ComTencentMobileqqProfileVipWZRYTemplateConfig;
    int j = getResources().getDimensionPixelSize(2131299318);
    int k = getResources().getDimensionPixelSize(2131299320);
    ColorStateList localColorStateList1 = getResources().getColorStateList(2131167419);
    ColorStateList localColorStateList2 = getResources().getColorStateList(2131167421);
    if (localVipWZRYTemplateConfig != null)
    {
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (summaryCardWzryInfo)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 4, "honor data: id=" + ((summaryCardWzryInfo)localObject2).honorId + ", record=" + ((summaryCardWzryInfo)localObject2).strRecord);
        }
        localObject1 = null;
        if (!TextUtils.isEmpty(((summaryCardWzryInfo)localObject2).strRecord)) {
          localObject1 = ((summaryCardWzryInfo)localObject2).strRecord.split("_");
        }
        VipWZRYTemplateConfig.WZRYHonorItem localWZRYHonorItem = (VipWZRYTemplateConfig.WZRYHonorItem)localVipWZRYTemplateConfig.jdField_a_of_type_AndroidUtilSparseArray.get(((summaryCardWzryInfo)localObject2).honorId);
        if (localWZRYHonorItem != null)
        {
          View localView = this.mInflater.inflate(2131562201, null);
          ImageView localImageView = (ImageView)localView.findViewById(2131382086);
          TextView localTextView1 = (TextView)localView.findViewById(2131382088);
          TextView localTextView2 = (TextView)localView.findViewById(2131382087);
          if (ProfileCardTemplate.a != null)
          {
            localTextView1.setTypeface(ProfileCardTemplate.a);
            localTextView2.setTypeface(ProfileCardTemplate.a);
          }
          int i;
          label407:
          label418:
          String str;
          if (localWZRYHonorItem.jdField_b_of_type_Int == 2)
          {
            i = 1;
            if (i == 0) {
              break label532;
            }
            localObject2 = localWZRYHonorItem.jdField_b_of_type_JavaLangString;
            if (i == 0) {
              break label542;
            }
            str = localWZRYHonorItem.jdField_a_of_type_JavaLangString;
            label429:
            localTextView1.setText(getSpannableString((String)localObject2, (String[])localObject1, calcTopNumTextSize(localTextView1, k, (String)localObject2, (String[])localObject1), 0.0F, localColorStateList2));
            localTextView2.setText(getSpannableString(str, (String[])localObject1, j, localTextView2.getTextSize(), localColorStateList1));
            if ((localWZRYHonorItem.jdField_a_of_type_ComTencentMobileqqProfileVipWZRYTemplateConfig$WZRYResourceItem != null) && (!TextUtils.isEmpty(localWZRYHonorItem.jdField_a_of_type_ComTencentMobileqqProfileVipWZRYTemplateConfig$WZRYResourceItem.jdField_a_of_type_JavaLangString))) {
              break label552;
            }
            localImageView.setVisibility(8);
            localTextView1.setVisibility(0);
          }
          for (;;)
          {
            this.mGameInfoShimmerLayout.addView(localView, localLayoutParams);
            break;
            i = 0;
            break label407;
            label532:
            localObject2 = localWZRYHonorItem.jdField_a_of_type_JavaLangString;
            break label418;
            label542:
            str = localWZRYHonorItem.jdField_b_of_type_JavaLangString;
            break label429;
            label552:
            localImageView.setVisibility(0);
            localTextView1.setVisibility(8);
            localObject2 = localWZRYHonorItem.jdField_a_of_type_ComTencentMobileqqProfileVipWZRYTemplateConfig$WZRYResourceItem.jdField_a_of_type_JavaLangString;
            localObject1 = localObject2;
            if (((String)localObject2).contains("/")) {
              localObject1 = ((String)localObject2).substring(((String)localObject2).lastIndexOf("/"));
            }
            localObject1 = VipWZRYTemplateHelper.a(this.mApp.getApp()) + (String)localObject1;
            if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate != null) {
              localImageView.setImageDrawable(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a(this.mApp, (String)localObject1, true, true));
            }
          }
        }
      }
    }
    if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.mApp.getCurrentAccountUin())))
    {
      this.mAddIcon.setVisibility(0);
      ProfileCardTemplate.a(this.mAddIcon, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "addIcon");
      this.mAddIcon.setOnClickListener(new VasProfileWZRYView.1(this, paramProfileCardInfo));
    }
    if (this.mGameInfoShimmerLayout.a == null) {
      ProfileCardTemplate.a(this.mGameInfoShimmerLayout, "shimmer_mask", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "wzryShimmer");
    }
    this.mGameInfoShimmerLayout.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileWZRYView
 * JD-Core Version:    0.7.0.1
 */