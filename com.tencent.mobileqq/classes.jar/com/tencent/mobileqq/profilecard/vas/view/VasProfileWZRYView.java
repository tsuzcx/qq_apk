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
import azpb;
import azrb;
import azri;
import azsl;
import azsm;
import azsn;
import azso;
import baes;
import baet;
import bhaa;
import bkyc;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.view.ShimmerLinearLayout;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class VasProfileWZRYView
  extends AbsProfileHeaderView
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ShimmerLinearLayout jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  private float d;
  
  public VasProfileWZRYView(BaseActivity paramBaseActivity, azrb paramazrb)
  {
    super(paramBaseActivity, paramazrb);
  }
  
  private View a()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getContext());
    return this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562062, this, true);
  }
  
  private void a(azrb paramazrb, View paramView)
  {
    AvatarLayout localAvatarLayout = (AvatarLayout)paramView.findViewById(2131381610);
    localAvatarLayout.setVisibility(0);
    azpb localazpb = new azpb(1, null);
    localAvatarLayout.setTag(localazpb);
    localAvatarLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (String str = getContext().getString(2131691169);; str = getContext().getString(2131691168))
    {
      localAvatarLayout.setContentDescription(str);
      localAvatarLayout.a(0, localAvatarLayout.findViewById(2131363426), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", localAvatarLayout);
      super.a(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      paramView = (ImageView)paramView.findViewById(2131381608);
      paramView.setVisibility(4);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setTag(localazpb);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", paramView);
      super.b(paramazrb, true);
      return;
    }
  }
  
  private void b(azrb paramazrb, View paramView)
  {
    paramView = (ProfileNameView)paramView.findViewById(2131381612);
    paramView.setVisibility(0);
    paramView.setClickable(true);
    paramView.setClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", paramView);
    super.c(paramazrb);
  }
  
  private void c(azrb paramazrb, View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131381614);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", paramView);
    super.d(paramazrb);
  }
  
  private void d(azrb paramazrb, View paramView)
  {
    HeartLayout localHeartLayout = (HeartLayout)paramView.findViewById(2131381606);
    localHeartLayout.setEnabled(false);
    paramView = (VoteView)paramView.findViewById(2131381621);
    paramView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHeartLayout);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", paramView);
    super.h(paramazrb);
  }
  
  private void e(azrb paramazrb, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381615));
    azri.a(this.jdField_a_of_type_AndroidWidgetImageView, "apngDrawable", paramazrb.jdField_a_of_type_Azri, "wzryLogo");
    ApngImage.playByTag(7);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381616));
    azri.a(this.jdField_b_of_type_AndroidWidgetImageView, "background", paramazrb.jdField_a_of_type_Azri, "wzryLogoBg");
  }
  
  private void f()
  {
    int i = getResources().getDimensionPixelSize(2131297077);
    int j = bhaa.a(getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = ((int)this.jdField_c_of_type_Float - bhaa.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 160) - i - j);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      localLayoutParams.height += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + localLayoutParams.height);
    }
    this.jdField_b_of_type_Int = localLayoutParams.height;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewView.setFocusable(true);
    this.jdField_a_of_type_AndroidViewView.setFocusableInTouchMode(true);
  }
  
  int a(TextView paramTextView, int paramInt, String paramString, String[] paramArrayOfString)
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
              break label300;
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
        label300:
        return k;
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
      label73:
      int k;
      int j;
      if (paramString.equals("[num]"))
      {
        str = paramString + " ";
        paramString = str.split("\\[num\\]");
        i = 0;
        if (i >= paramString.length) {
          break label341;
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
            break label307;
          }
          j = paramArrayOfString[i].length();
          localSpannableStringBuilder.append(paramArrayOfString[i]);
          j += k;
        }
      }
      for (;;)
      {
        if (azri.b != null) {
          localSpannableStringBuilder.setSpan(new VasProfileWZRYView.CustomTypefaceSpan("", azri.b), k, j, 17);
        }
        localSpannableStringBuilder.setSpan(new TextAppearanceSpan(null, 3, paramInt, paramColorStateList, null), k, j, 17);
        localSpannableStringBuilder.setSpan(new baet(paramInt, -2.0F), k, j, 17);
        i += 1;
        break label73;
        str = paramString;
        if (!paramString.endsWith("[num]")) {
          break;
        }
        str = paramString + "\r\n";
        break;
        label307:
        j = "[num]".length();
        localSpannableStringBuilder.append("[num]");
        j += k;
      }
    }
    else
    {
      localSpannableStringBuilder.append(paramString);
    }
    label341:
    return localSpannableStringBuilder;
  }
  
  public void a(azrb paramazrb)
  {
    this.d = this.jdField_c_of_type_Float;
    Object localObject = a();
    e(paramazrb, (View)localObject);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131381609);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout = ((ShimmerLinearLayout)((View)localObject).findViewById(2131381604));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131381603));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)((View)localObject).findViewById(2131381605));
    azri.a(this.jdField_a_of_type_AndroidWidgetHorizontalScrollView, "background", paramazrb.jdField_a_of_type_Azri, "wzryGameInfoBackground");
    f();
    a(paramazrb, (View)localObject);
    b(paramazrb, (View)localObject);
    c(paramazrb, (View)localObject);
    d(paramazrb, (View)localObject);
    k(paramazrb);
    super.a(paramazrb);
    super.b(paramazrb);
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {}
    for (localObject = "PV_owner";; localObject = "PV_visitor")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_gameking", (String)localObject, "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), String.valueOf(paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
      return;
    }
  }
  
  public void a(azrb paramazrb, boolean paramBoolean)
  {
    super.h(paramazrb);
    super.c(paramazrb);
    super.d(paramazrb);
    super.b(paramazrb, false);
    k(paramazrb);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.b();
  }
  
  public void c()
  {
    super.c();
    ApngImage.playByTag(7);
  }
  
  public void d()
  {
    super.d();
    QLog.i(jdField_a_of_type_JavaLangString, 1, "VipProfileWZRYView.onDestroy");
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.c();
    }
  }
  
  void e()
  {
    this.jdField_a_of_type_Bkyc.postDelayed(new VasProfileWZRYView.2(this), 1000L);
  }
  
  public void k(azrb paramazrb)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.b();
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.removeAllViews();
    Object localObject1 = paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.getWzryHonorInfo();
    Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (((List)localObject1).isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject2).height = (this.jdField_b_of_type_Int - bhaa.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 67));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(0);
    ((RelativeLayout.LayoutParams)localObject2).height = (this.jdField_b_of_type_Int - bhaa.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 132));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, 0, DisplayUtil.dip2px(getContext(), 5.0F), 0);
    azsl localazsl = azsl.jdField_a_of_type_Azsl;
    int j = getResources().getDimensionPixelSize(2131299229);
    int k = getResources().getDimensionPixelSize(2131299231);
    ColorStateList localColorStateList1 = getResources().getColorStateList(2131167407);
    ColorStateList localColorStateList2 = getResources().getColorStateList(2131167409);
    if (localazsl != null)
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
        azsm localazsm = (azsm)localazsl.jdField_a_of_type_AndroidUtilSparseArray.get(((summaryCardWzryInfo)localObject2).honorId);
        if (localazsm != null)
        {
          View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562063, null);
          ImageView localImageView = (ImageView)localView.findViewById(2131381617);
          TextView localTextView1 = (TextView)localView.findViewById(2131381619);
          TextView localTextView2 = (TextView)localView.findViewById(2131381618);
          if (azri.a != null)
          {
            localTextView1.setTypeface(azri.a);
            localTextView2.setTypeface(azri.a);
          }
          int i;
          label407:
          label418:
          String str;
          if (localazsm.jdField_b_of_type_Int == 2)
          {
            i = 1;
            if (i == 0) {
              break label532;
            }
            localObject2 = localazsm.jdField_b_of_type_JavaLangString;
            if (i == 0) {
              break label542;
            }
            str = localazsm.jdField_a_of_type_JavaLangString;
            label429:
            localTextView1.setText(a((String)localObject2, (String[])localObject1, a(localTextView1, k, (String)localObject2, (String[])localObject1), 0.0F, localColorStateList2));
            localTextView2.setText(a(str, (String[])localObject1, j, localTextView2.getTextSize(), localColorStateList1));
            if ((localazsm.jdField_a_of_type_Azsn != null) && (!TextUtils.isEmpty(localazsm.jdField_a_of_type_Azsn.jdField_a_of_type_JavaLangString))) {
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
            localObject2 = localazsm.jdField_a_of_type_JavaLangString;
            break label418;
            label542:
            str = localazsm.jdField_b_of_type_JavaLangString;
            break label429;
            label552:
            localImageView.setVisibility(0);
            localTextView1.setVisibility(8);
            localObject2 = localazsm.jdField_a_of_type_Azsn.jdField_a_of_type_JavaLangString;
            localObject1 = localObject2;
            if (((String)localObject2).contains("/")) {
              localObject1 = ((String)localObject2).substring(((String)localObject2).lastIndexOf("/"));
            }
            localObject1 = azso.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()) + (String)localObject1;
            if (paramazrb.jdField_a_of_type_Azri != null) {
              localImageView.setImageDrawable(paramazrb.jdField_a_of_type_Azri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true, true));
            }
          }
        }
      }
    }
    if ((paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      azri.a(this.jdField_c_of_type_AndroidWidgetImageView, "background", paramazrb.jdField_a_of_type_Azri, "addIcon");
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new baes(this, paramazrb));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.a == null) {
      azri.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout, "shimmer_mask", paramazrb.jdField_a_of_type_Azri, "wzryShimmer");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.a();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    int i = (int)this.jdField_c_of_type_Float;
    if (this.d != this.jdField_c_of_type_Float)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramConfiguration.height = ((int)(paramConfiguration.height + (this.jdField_c_of_type_Float - this.d)));
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramConfiguration);
      this.jdField_b_of_type_Int = ((int)(this.jdField_b_of_type_Int + (this.jdField_c_of_type_Float - this.d)));
      this.d = this.jdField_c_of_type_Float;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileWZRYView
 * JD-Core Version:    0.7.0.1
 */