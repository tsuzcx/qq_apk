package com.tencent.mobileqq.profile.view;

import SummaryCardTaf.summaryCardWzryInfo;
import ajsd;
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
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ausw;
import auuy;
import auvf;
import auwm;
import auwn;
import auwo;
import auwp;
import avau;
import avav;
import baxn;
import bbac;
import bfnk;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import naj;

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
  public AvatarLayout a;
  public ProfileNameView a;
  public VoteView a;
  public View b;
  public ImageView b;
  public ImageView c;
  private float d;
  public ImageView d;
  int g;
  
  static
  {
    jdField_c_of_type_JavaLangString = ajsd.cm + File.separator + "wzryTemplate";
  }
  
  public VipProfileWZRYView(BaseActivity paramBaseActivity, auuy paramauuy)
  {
    super(paramBaseActivity, paramauuy);
    d(paramauuy);
    a(paramauuy);
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
              break label293;
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
        label293:
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
      label69:
      int k;
      int j;
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
          k = localSpannableStringBuilder.length();
          if ((paramArrayOfString == null) || (i >= paramArrayOfString.length)) {
            break label296;
          }
          j = paramArrayOfString[i].length();
          localSpannableStringBuilder.append(paramArrayOfString[i]);
          j += k;
        }
      }
      for (;;)
      {
        if (auvf.b != null) {
          localSpannableStringBuilder.setSpan(new VipProfileWZRYView.CustomTypefaceSpan("", auvf.b), k, j, 17);
        }
        localSpannableStringBuilder.setSpan(new TextAppearanceSpan(null, 3, paramInt, paramColorStateList, null), k, j, 17);
        localSpannableStringBuilder.setSpan(new avav(paramInt, -2.0F), k, j, 17);
        i += 1;
        break label69;
        str = paramString;
        if (!paramString.endsWith("[num]")) {
          break;
        }
        str = paramString + "\r\n";
        break;
        label296:
        j = "[num]".length();
        localSpannableStringBuilder.append("[num]");
        j += k;
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
  
  public void a(auuy paramauuy)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getContext());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561636, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379539));
    auvf.a(this.jdField_a_of_type_AndroidWidgetImageView, "apngDrawable", paramauuy.jdField_a_of_type_Auvf, "wzryLogo");
    ApngImage.playByTag(7);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379540));
    auvf.a(this.jdField_b_of_type_AndroidWidgetImageView, "background", paramauuy.jdField_a_of_type_Auvf, "wzryLogoBg");
    this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379546));
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379530));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379534));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379532));
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379536));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379538));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379533);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout = ((ShimmerLinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379528));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379525));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379529));
    auvf.a(this.jdField_a_of_type_AndroidWidgetHorizontalScrollView, "background", paramauuy.jdField_a_of_type_Auvf, "wzryGameInfoBackground");
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
    ausw localausw = new ausw(1, null);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setTag(localausw);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(paramauuy.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localObject = getContext().getString(2131691185);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setContentDescription((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363079), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
      super.a(paramauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramauuy.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setTag(localausw);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_c_of_type_AndroidWidgetImageView);
      super.b(paramauuy, true);
      this.jdField_d_of_type_Float = this.jdField_c_of_type_Float;
      int i = getResources().getDimensionPixelSize(2131296940);
      int j = bbac.a(getResources());
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = ((int)this.jdField_c_of_type_Float - bbac.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 160) - i - j);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        ((RelativeLayout.LayoutParams)localObject).height += ImmersiveUtils.getStatusBarHeight(getContext());
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + ((RelativeLayout.LayoutParams)localObject).height);
      }
      this.g = ((RelativeLayout.LayoutParams)localObject).height;
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidViewView.setFocusable(true);
      this.jdField_b_of_type_AndroidViewView.setFocusableInTouchMode(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      super.f(paramauuy);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", this.jdField_a_of_type_AndroidWidgetTextView);
      super.b(paramauuy);
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView);
      super.e(paramauuy);
      m(paramauuy);
      super.a(paramauuy);
      super.g(paramauuy);
      d();
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        break label784;
      }
    }
    label784:
    for (Object localObject = "PV_owner";; localObject = "PV_visitor")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_gameking", (String)localObject, "0", 1, 0, 0, naj.a(), String.valueOf(paramauuy.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId), String.valueOf(paramauuy.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId));
      return;
      localObject = getContext().getString(2131691184);
      break;
    }
  }
  
  public void a(auuy paramauuy, boolean paramBoolean)
  {
    super.e(paramauuy);
    super.f(paramauuy);
    super.b(paramauuy);
    super.c(paramauuy);
    super.b(paramauuy, false);
    m(paramauuy);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.b();
  }
  
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
    this.jdField_a_of_type_Bfnk.postDelayed(new VipProfileWZRYView.2(this), 1000L);
  }
  
  public void d(auuy paramauuy) {}
  
  public void m(auuy paramauuy)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.b();
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.removeAllViews();
    Object localObject1 = paramauuy.jdField_a_of_type_ComTencentMobileqqDataCard.getWzryHonorInfo();
    Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    if (((List)localObject1).isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject2).height = (this.g - bbac.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 67));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(0);
    ((RelativeLayout.LayoutParams)localObject2).height = (this.g - bbac.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 132));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, 0, baxn.a(getContext(), 5.0F), 0);
    auwm localauwm = auwm.jdField_a_of_type_Auwm;
    int j = getResources().getDimensionPixelSize(2131298968);
    int k = getResources().getDimensionPixelSize(2131298970);
    ColorStateList localColorStateList1 = getResources().getColorStateList(2131167154);
    ColorStateList localColorStateList2 = getResources().getColorStateList(2131167156);
    if (localauwm != null)
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
        auwn localauwn = (auwn)localauwm.jdField_a_of_type_AndroidUtilSparseArray.get(((summaryCardWzryInfo)localObject2).honorId);
        if (localauwn != null)
        {
          View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561637, null);
          ImageView localImageView = (ImageView)localView.findViewById(2131379542);
          TextView localTextView1 = (TextView)localView.findViewById(2131379544);
          TextView localTextView2 = (TextView)localView.findViewById(2131379543);
          if (auvf.a != null)
          {
            localTextView1.setTypeface(auvf.a);
            localTextView2.setTypeface(auvf.a);
          }
          int i;
          label407:
          label418:
          String str;
          if (localauwn.jdField_b_of_type_Int == 2)
          {
            i = 1;
            if (i == 0) {
              break label532;
            }
            localObject2 = localauwn.jdField_b_of_type_JavaLangString;
            if (i == 0) {
              break label542;
            }
            str = localauwn.jdField_a_of_type_JavaLangString;
            label429:
            localTextView1.setText(a((String)localObject2, (String[])localObject1, a(localTextView1, k, (String)localObject2, (String[])localObject1), 0.0F, localColorStateList2));
            localTextView2.setText(a(str, (String[])localObject1, j, localTextView2.getTextSize(), localColorStateList1));
            if ((localauwn.jdField_a_of_type_Auwo != null) && (!TextUtils.isEmpty(localauwn.jdField_a_of_type_Auwo.jdField_a_of_type_JavaLangString))) {
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
            localObject2 = localauwn.jdField_a_of_type_JavaLangString;
            break label418;
            label542:
            str = localauwn.jdField_b_of_type_JavaLangString;
            break label429;
            label552:
            localImageView.setVisibility(0);
            localTextView1.setVisibility(8);
            localObject2 = localauwn.jdField_a_of_type_Auwo.jdField_a_of_type_JavaLangString;
            localObject1 = localObject2;
            if (((String)localObject2).contains("/")) {
              localObject1 = ((String)localObject2).substring(((String)localObject2).lastIndexOf("/"));
            }
            localObject1 = auwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()) + (String)localObject1;
            if (paramauuy.jdField_a_of_type_Auvf != null) {
              localImageView.setImageDrawable(paramauuy.jdField_a_of_type_Auvf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true, true));
            }
          }
        }
      }
    }
    if ((paramauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (paramauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      auvf.a(this.jdField_d_of_type_AndroidWidgetImageView, "background", paramauuy.jdField_a_of_type_Auvf, "addIcon");
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new avau(this, paramauuy));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.a == null) {
      auvf.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout, "shimmer_mask", paramauuy.jdField_a_of_type_Auvf, "wzryShimmer");
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout.a();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    int i = (int)this.jdField_c_of_type_Float;
    if (this.jdField_d_of_type_Float != this.jdField_c_of_type_Float)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      paramConfiguration.height = ((int)(paramConfiguration.height + (this.jdField_c_of_type_Float - this.jdField_d_of_type_Float)));
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramConfiguration);
      this.g = ((int)(this.g + (this.jdField_c_of_type_Float - this.jdField_d_of_type_Float)));
      this.jdField_d_of_type_Float = this.jdField_c_of_type_Float;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipProfileWZRYView
 * JD-Core Version:    0.7.0.1
 */