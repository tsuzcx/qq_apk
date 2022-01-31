package com.tencent.mobileqq.profile.view;

import SummaryCardTaf.summaryCardWzryInfo;
import agem;
import agen;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.AppConstants;
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
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class VipProfileWZRYView
  extends ProfileHeaderView
{
  public static final String c;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  public HorizontalScrollView a;
  public ImageView a;
  public TextView a;
  public HeartLayout a;
  public ShimmerLinearLayout a;
  public VoteView a;
  public View b;
  public TextView b;
  public ImageView c;
  public TextView c;
  public ImageView d;
  public ImageView e;
  public ImageView f;
  int j;
  
  static
  {
    jdField_c_of_type_JavaLangString = AppConstants.bU + File.separator + "wzryTemplate";
  }
  
  public VipProfileWZRYView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    b(paramProfileCardInfo);
    a(paramProfileCardInfo);
  }
  
  int a(TextView paramTextView, int paramInt, String paramString, String[] paramArrayOfString)
  {
    int n = 0;
    TextPaint localTextPaint = new TextPaint(paramTextView.getPaint());
    int m = n;
    float f2;
    if (!TextUtils.isEmpty(paramString))
    {
      m = n;
      if (paramArrayOfString != null)
      {
        m = n;
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
          int k;
          for (;;)
          {
            m = n;
            if (i <= 0) {
              break label293;
            }
            paramString = "";
            k = 0;
            m = 0;
            while (m < i)
            {
              k += paramArrayOfString[m].length();
              paramString = paramString + paramArrayOfString[m];
              m += 1;
            }
          }
          m = n;
          if (k > 0)
          {
            paramTextView = paramTextView.replace("[num]", "");
            i = 0;
            while (i < k - 1)
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
      m = n;
      if (f1 > 0.0F)
      {
        localTextPaint.setTextSize(f1);
        if (localTextPaint.measureText(paramString) >= f2) {
          continue;
        }
        if (f1 > paramInt / 2) {
          m = paramInt / 2;
        }
      }
      else
      {
        label293:
        return m;
      }
      return (int)f1;
    }
  }
  
  public SpannableStringBuilder a(String paramString, String[] paramArrayOfString, int paramInt, float paramFloat, ColorStateList paramColorStateList)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (TextUtils.isEmpty(paramString)) {
      return localSpannableStringBuilder;
    }
    if (paramString.contains("[num]"))
    {
      String str;
      int i;
      label69:
      int m;
      int k;
      if (paramString.equals("[num]"))
      {
        str = paramString + " ";
        paramString = str.split("\\[num\\]");
        i = 0;
        if (i >= paramString.length) {
          break label328;
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
          m = localSpannableStringBuilder.length();
          if ((paramArrayOfString == null) || (i >= paramArrayOfString.length)) {
            break label296;
          }
          k = paramArrayOfString[i].length();
          localSpannableStringBuilder.append(paramArrayOfString[i]);
          k += m;
        }
      }
      for (;;)
      {
        if (ProfileCardTemplate.b != null) {
          localSpannableStringBuilder.setSpan(new VipProfileWZRYView.CustomTypefaceSpan("", ProfileCardTemplate.b), m, k, 17);
        }
        localSpannableStringBuilder.setSpan(new TextAppearanceSpan(null, 3, paramInt, paramColorStateList, null), m, k, 17);
        localSpannableStringBuilder.setSpan(new VipProfileWZRYView.VerticalCenterTextSpan(paramInt, -2.0F), m, k, 17);
        i += 1;
        break label69;
        str = paramString;
        if (!paramString.endsWith("[num]")) {
          break;
        }
        str = paramString + "\r\n";
        break;
        label296:
        k = "[num]".length();
        localSpannableStringBuilder.append("[num]");
        k += m;
      }
    }
    else
    {
      localSpannableStringBuilder.append(paramString);
    }
    label328:
    return localSpannableStringBuilder;
  }
  
  public void a()
  {
    super.a();
    ApngImage.playByTag(7);
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getContext());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970970, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372404));
    ProfileCardTemplate.a(this.jdField_a_of_type_AndroidWidgetImageView, "apngDrawable", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "wzryLogo");
    ApngImage.playByTag(7);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372403));
    ProfileCardTemplate.a(this.jdField_c_of_type_AndroidWidgetImageView, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "wzryLogoBg");
    this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372415));
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372418));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372416));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372413));
    this.e = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372414));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372410));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372412));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372402);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout = ((ShimmerLinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372406));
    this.f = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372407));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372405));
    ProfileCardTemplate.a(this.jdField_a_of_type_AndroidWidgetHorizontalScrollView, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "wzryGameInfoBackground");
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    DataTag localDataTag = new DataTag(1, null);
    this.jdField_d_of_type_AndroidWidgetImageView.setTag(localDataTag);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localObject = getContext().getString(2131427397);
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_d_of_type_AndroidWidgetImageView);
      super.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.e.setVisibility(4);
      this.e.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.e.setTag(localDataTag);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.e);
      super.c(paramProfileCardInfo, true);
      int i = getResources().getDimensionPixelSize(2131558669);
      int k = ProfileCardUtil.a(getResources());
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = ((int)this.jdField_d_of_type_Float - ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 160) - i - k);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        ((RelativeLayout.LayoutParams)localObject).height += ImmersiveUtils.a(getContext());
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + ((RelativeLayout.LayoutParams)localObject).height);
      }
      this.j = ((RelativeLayout.LayoutParams)localObject).height;
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidViewView.setFocusable(true);
      this.jdField_b_of_type_AndroidViewView.setFocusableInTouchMode(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_b_of_type_AndroidWidgetTextView);
      super.i(paramProfileCardInfo);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", this.jdField_c_of_type_AndroidWidgetTextView);
      super.c(paramProfileCardInfo);
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView);
      super.g(paramProfileCardInfo);
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372353);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_num", localObject);
      ((TextView)localObject).setOnClickListener(this);
      localObject = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewView.findViewById(2131372411)).a(53).a(true).c(1).e(10).a();
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_increment", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_container", this.jdField_a_of_type_AndroidViewView.findViewById(2131372411));
      d(paramProfileCardInfo);
      f(paramProfileCardInfo);
      super.a(paramProfileCardInfo);
      super.h(paramProfileCardInfo);
      d();
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        break label890;
      }
    }
    label890:
    for (Object localObject = "PV_owner";; localObject = "PV_visitor")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_gameking", (String)localObject, "0", 1, 0, 0, HttpUtil.a(), String.valueOf(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), String.valueOf(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
      return;
      localObject = getContext().getString(2131427396);
      break;
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.g(paramProfileCardInfo);
    super.i(paramProfileCardInfo);
    super.c(paramProfileCardInfo);
    super.e(paramProfileCardInfo);
    super.c(paramProfileCardInfo, false);
    super.d(paramProfileCardInfo);
    f(paramProfileCardInfo);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.b();
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo) {}
  
  public void c()
  {
    super.c();
    QLog.i(jdField_a_of_type_JavaLangString, 1, "VipProfileWZRYView.onDestroy");
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.c();
    }
  }
  
  void d()
  {
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.postDelayed(new agen(this), 1000L);
  }
  
  public void f(ProfileCardInfo paramProfileCardInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.b();
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.removeAllViews();
    Object localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getWzryHonorInfo();
    Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    if (((List)localObject1).isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject2).height = (this.j - ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 67));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(0);
    ((RelativeLayout.LayoutParams)localObject2).height = (this.j - ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 132));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, 0, DisplayUtil.a(getContext(), 5.0F), 0);
    VipWZRYTemplateConfig localVipWZRYTemplateConfig = VipWZRYTemplateConfig.jdField_a_of_type_ComTencentMobileqqProfileVipWZRYTemplateConfig;
    int k = getResources().getDimensionPixelSize(2131559420);
    int m = getResources().getDimensionPixelSize(2131559418);
    ColorStateList localColorStateList1 = getResources().getColorStateList(2131493386);
    ColorStateList localColorStateList2 = getResources().getColorStateList(2131493387);
    if (localVipWZRYTemplateConfig != null)
    {
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (summaryCardWzryInfo)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "honor data: id=" + ((summaryCardWzryInfo)localObject2).honorId + ", record=" + ((summaryCardWzryInfo)localObject2).strRecord);
        }
        localObject1 = null;
        if (!TextUtils.isEmpty(((summaryCardWzryInfo)localObject2).strRecord)) {
          localObject1 = ((summaryCardWzryInfo)localObject2).strRecord.split("_");
        }
        VipWZRYTemplateConfig.WZRYHonorItem localWZRYHonorItem = (VipWZRYTemplateConfig.WZRYHonorItem)localVipWZRYTemplateConfig.jdField_a_of_type_AndroidUtilSparseArray.get(((summaryCardWzryInfo)localObject2).honorId);
        if (localWZRYHonorItem != null)
        {
          View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970971, null);
          ImageView localImageView = (ImageView)localView.findViewById(2131372421);
          TextView localTextView1 = (TextView)localView.findViewById(2131372420);
          TextView localTextView2 = (TextView)localView.findViewById(2131372422);
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
            localTextView1.setText(a((String)localObject2, (String[])localObject1, a(localTextView1, m, (String)localObject2, (String[])localObject1), 0.0F, localColorStateList2));
            localTextView2.setText(a(str, (String[])localObject1, k, localTextView2.getTextSize(), localColorStateList1));
            if ((localWZRYHonorItem.jdField_a_of_type_ComTencentMobileqqProfileVipWZRYTemplateConfig$WZRYResourceItem != null) && (!TextUtils.isEmpty(localWZRYHonorItem.jdField_a_of_type_ComTencentMobileqqProfileVipWZRYTemplateConfig$WZRYResourceItem.jdField_a_of_type_JavaLangString))) {
              break label552;
            }
            localImageView.setVisibility(8);
            localTextView1.setVisibility(0);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.addView(localView, localLayoutParams);
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
            localObject1 = VipWZRYTemplateHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()) + (String)localObject1;
            if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate != null) {
              localImageView.setImageDrawable(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true, true));
            }
          }
        }
      }
    }
    if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      this.f.setVisibility(0);
      ProfileCardTemplate.a(this.f, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "addIcon");
      this.f.setOnClickListener(new agem(this, paramProfileCardInfo));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.a == null) {
      ProfileCardTemplate.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout, "shimmer_mask", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "wzryShimmer");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipProfileWZRYView
 * JD-Core Version:    0.7.0.1
 */