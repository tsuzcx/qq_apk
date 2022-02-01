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
import aykg;
import aymg;
import aymn;
import aynq;
import aynr;
import ayns;
import aynt;
import ayzh;
import ayzi;
import bfrj;
import bjmp;
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
  
  public VasProfileWZRYView(BaseActivity paramBaseActivity, aymg paramaymg)
  {
    super(paramBaseActivity, paramaymg);
  }
  
  private View a()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getContext());
    return this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561997, this, true);
  }
  
  private void a(aymg paramaymg, View paramView)
  {
    AvatarLayout localAvatarLayout = (AvatarLayout)paramView.findViewById(2131381247);
    localAvatarLayout.setVisibility(0);
    aykg localaykg = new aykg(1, null);
    localAvatarLayout.setTag(localaykg);
    localAvatarLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (String str = getContext().getString(2131691084);; str = getContext().getString(2131691083))
    {
      localAvatarLayout.setContentDescription(str);
      localAvatarLayout.a(0, localAvatarLayout.findViewById(2131363357), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", localAvatarLayout);
      super.a(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      paramView = (ImageView)paramView.findViewById(2131381245);
      paramView.setVisibility(4);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setTag(localaykg);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", paramView);
      super.b(paramaymg, true);
      return;
    }
  }
  
  private void b(aymg paramaymg, View paramView)
  {
    paramView = (ProfileNameView)paramView.findViewById(2131381249);
    paramView.setVisibility(0);
    paramView.setClickable(true);
    paramView.setClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", paramView);
    super.c(paramaymg);
  }
  
  private void c(aymg paramaymg, View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131381251);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", paramView);
    super.d(paramaymg);
  }
  
  private void d(aymg paramaymg, View paramView)
  {
    HeartLayout localHeartLayout = (HeartLayout)paramView.findViewById(2131381243);
    localHeartLayout.setEnabled(false);
    paramView = (VoteView)paramView.findViewById(2131381258);
    paramView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHeartLayout);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", paramView);
    super.g(paramaymg);
  }
  
  private void e(aymg paramaymg, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381252));
    aymn.a(this.jdField_a_of_type_AndroidWidgetImageView, "apngDrawable", paramaymg.jdField_a_of_type_Aymn, "wzryLogo");
    ApngImage.playByTag(7);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381253));
    aymn.a(this.jdField_b_of_type_AndroidWidgetImageView, "background", paramaymg.jdField_a_of_type_Aymn, "wzryLogoBg");
  }
  
  private void f()
  {
    int i = getResources().getDimensionPixelSize(2131297076);
    int j = bfrj.a(getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = ((int)this.jdField_c_of_type_Float - bfrj.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 160) - i - j);
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
        if (aymn.b != null) {
          localSpannableStringBuilder.setSpan(new VasProfileWZRYView.CustomTypefaceSpan("", aymn.b), k, j, 17);
        }
        localSpannableStringBuilder.setSpan(new TextAppearanceSpan(null, 3, paramInt, paramColorStateList, null), k, j, 17);
        localSpannableStringBuilder.setSpan(new ayzi(paramInt, -2.0F), k, j, 17);
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
  
  public void a(aymg paramaymg)
  {
    this.d = this.jdField_c_of_type_Float;
    Object localObject = a();
    e(paramaymg, (View)localObject);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131381246);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout = ((ShimmerLinearLayout)((View)localObject).findViewById(2131381241));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131381240));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)((View)localObject).findViewById(2131381242));
    aymn.a(this.jdField_a_of_type_AndroidWidgetHorizontalScrollView, "background", paramaymg.jdField_a_of_type_Aymn, "wzryGameInfoBackground");
    f();
    a(paramaymg, (View)localObject);
    b(paramaymg, (View)localObject);
    c(paramaymg, (View)localObject);
    d(paramaymg, (View)localObject);
    j(paramaymg);
    super.a(paramaymg);
    super.b(paramaymg);
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {}
    for (localObject = "PV_owner";; localObject = "PV_visitor")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_gameking", (String)localObject, "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), String.valueOf(paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
      return;
    }
  }
  
  public void a(aymg paramaymg, boolean paramBoolean)
  {
    super.g(paramaymg);
    super.c(paramaymg);
    super.d(paramaymg);
    super.b(paramaymg, false);
    j(paramaymg);
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
    this.jdField_a_of_type_Bjmp.postDelayed(new VasProfileWZRYView.2(this), 1000L);
  }
  
  public void j(aymg paramaymg)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.b();
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.removeAllViews();
    Object localObject1 = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.getWzryHonorInfo();
    Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (((List)localObject1).isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject2).height = (this.jdField_b_of_type_Int - bfrj.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 67));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(0);
    ((RelativeLayout.LayoutParams)localObject2).height = (this.jdField_b_of_type_Int - bfrj.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 132));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, 0, DisplayUtil.dip2px(getContext(), 5.0F), 0);
    aynq localaynq = aynq.jdField_a_of_type_Aynq;
    int j = getResources().getDimensionPixelSize(2131299218);
    int k = getResources().getDimensionPixelSize(2131299220);
    ColorStateList localColorStateList1 = getResources().getColorStateList(2131167381);
    ColorStateList localColorStateList2 = getResources().getColorStateList(2131167383);
    if (localaynq != null)
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
        aynr localaynr = (aynr)localaynq.jdField_a_of_type_AndroidUtilSparseArray.get(((summaryCardWzryInfo)localObject2).honorId);
        if (localaynr != null)
        {
          View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561998, null);
          ImageView localImageView = (ImageView)localView.findViewById(2131381254);
          TextView localTextView1 = (TextView)localView.findViewById(2131381256);
          TextView localTextView2 = (TextView)localView.findViewById(2131381255);
          if (aymn.a != null)
          {
            localTextView1.setTypeface(aymn.a);
            localTextView2.setTypeface(aymn.a);
          }
          int i;
          label407:
          label418:
          String str;
          if (localaynr.jdField_b_of_type_Int == 2)
          {
            i = 1;
            if (i == 0) {
              break label532;
            }
            localObject2 = localaynr.jdField_b_of_type_JavaLangString;
            if (i == 0) {
              break label542;
            }
            str = localaynr.jdField_a_of_type_JavaLangString;
            label429:
            localTextView1.setText(a((String)localObject2, (String[])localObject1, a(localTextView1, k, (String)localObject2, (String[])localObject1), 0.0F, localColorStateList2));
            localTextView2.setText(a(str, (String[])localObject1, j, localTextView2.getTextSize(), localColorStateList1));
            if ((localaynr.jdField_a_of_type_Ayns != null) && (!TextUtils.isEmpty(localaynr.jdField_a_of_type_Ayns.jdField_a_of_type_JavaLangString))) {
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
            localObject2 = localaynr.jdField_a_of_type_JavaLangString;
            break label418;
            label542:
            str = localaynr.jdField_b_of_type_JavaLangString;
            break label429;
            label552:
            localImageView.setVisibility(0);
            localTextView1.setVisibility(8);
            localObject2 = localaynr.jdField_a_of_type_Ayns.jdField_a_of_type_JavaLangString;
            localObject1 = localObject2;
            if (((String)localObject2).contains("/")) {
              localObject1 = ((String)localObject2).substring(((String)localObject2).lastIndexOf("/"));
            }
            localObject1 = aynt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()) + (String)localObject1;
            if (paramaymg.jdField_a_of_type_Aymn != null) {
              localImageView.setImageDrawable(paramaymg.jdField_a_of_type_Aymn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true, true));
            }
          }
        }
      }
    }
    if ((paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      aymn.a(this.jdField_c_of_type_AndroidWidgetImageView, "background", paramaymg.jdField_a_of_type_Aymn, "addIcon");
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new ayzh(this, paramaymg));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.a == null) {
      aymn.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout, "shimmer_mask", paramaymg.jdField_a_of_type_Aymn, "wzryShimmer");
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