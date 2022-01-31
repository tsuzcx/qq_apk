package com.tencent.mobileqq.profile.view;

import ajxn;
import ajyc;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ausu;
import auuw;
import auvd;
import auvp;
import aweo;
import axqw;
import bazo;
import bcni;
import bcrj;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.List;

public class ProfileShoppingView
  extends ProfileHeaderView
{
  View a;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public PhotoViewForShopping a;
  public AvatarLayout a;
  public VoteView a;
  public boolean a;
  public View b;
  public ImageView b;
  public RelativeLayout b;
  public TextView b;
  public View c;
  public TextView c;
  public View d;
  public TextView d;
  public TextView e;
  public TextView f;
  public int g = -1;
  public int h = -1;
  public int i = -1;
  public int j = -1;
  public int k = -1;
  
  public ProfileShoppingView(BaseActivity paramBaseActivity, auuw paramauuw)
  {
    super(paramBaseActivity, paramauuw);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Auuw = paramauuw;
    d(paramauuw);
    a(paramauuw);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Auuw != null) {
      super.b(this.jdField_a_of_type_Auuw, false);
    }
  }
  
  public void a(auuw paramauuw)
  {
    Object localObject2 = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject2).inflate(2131561628, this, true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373660));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373661));
    Object localObject1 = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject1 != null) {}
    for (localObject1 = ((ajxn)localObject1).a(paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; localObject1 = null)
    {
      if ((localObject1 != null) && (((ExtensionInfo)localObject1).isPendantValid()))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368093));
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363080), false);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368094));
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367931));
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
        auvd.a(this.jdField_a_of_type_AndroidWidgetImageView, "src", paramauuw.jdField_a_of_type_Auvd, "commonFaceBackground");
        Object localObject3 = new ausu(1, null);
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setTag(localObject3);
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(paramauuw.jdField_a_of_type_AndroidViewView$OnClickListener);
        if (paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label1380;
        }
        localObject1 = ((Context)localObject2).getString(2131691185);
        label256:
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setContentDescription((CharSequence)localObject1);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131368094));
        super.a(paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramauuw.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_b_of_type_AndroidWidgetImageView.setTag(localObject3);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_b_of_type_AndroidWidgetImageView);
        super.b(paramauuw, true);
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373668));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373665));
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sign", this.jdField_a_of_type_AndroidWidgetTextView);
        auvd.a(this.jdField_a_of_type_AndroidWidgetTextView, "color", paramauuw.jdField_a_of_type_Auvd, "commonItemContentColor");
        h(paramauuw);
        localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373666);
        auvd.a((View)localObject1, "background", paramauuw.jdField_a_of_type_Auvd, "shoppingInfoMaskBackground");
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_space_sign", localObject1);
        auvd.a((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373656), "background", paramauuw.jdField_a_of_type_Auvd, "shoppingUserInfoBackground");
        auvd.a(this.jdField_c_of_type_AndroidWidgetTextView, "color", paramauuw.jdField_a_of_type_Auvd, "shoppingShopnameText");
        auvd.a(this.jdField_a_of_type_AndroidWidgetTextView, "color", paramauuw.jdField_a_of_type_Auvd, "shoppingSignColor");
        this.j = getResources().getDimensionPixelSize(2131296940);
        this.k = bazo.a(getResources());
        this.h = getResources().getDimensionPixelSize(2131297112);
        this.g = getResources().getDimensionPixelSize(2131297098);
        this.i = getResources().getDimensionPixelSize(2131297113);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368091);
        int m = (int)((int)(this.jdField_b_of_type_Float / 1.35F) / 1.6F);
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).height = ((int)this.jdField_c_of_type_Float - this.g - bazo.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 28) - this.h - this.i - this.j - this.k - m);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          ((RelativeLayout.LayoutParams)localObject2).height += ImmersiveUtils.getStatusBarHeight(getContext());
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + ((RelativeLayout.LayoutParams)localObject2).height);
        }
        if (((RelativeLayout.LayoutParams)localObject2).height <= bazo.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 110))
        {
          int n = bazo.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 110);
          int i1 = ((RelativeLayout.LayoutParams)localObject2).height;
          n = bazo.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 10) + (n - i1);
          localObject3 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject3).topMargin -= n;
          ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((RelativeLayout.LayoutParams)localObject2).height += n;
        }
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_b_of_type_AndroidViewView.setFocusable(true);
        this.jdField_b_of_type_AndroidViewView.setFocusableInTouchMode(true);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_space_view", this.jdField_b_of_type_AndroidViewView);
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368111));
        auvd.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramauuw.jdField_a_of_type_Auvd, "shoppingSignColor");
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_b_of_type_AndroidWidgetTextView);
        super.f(paramauuw);
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368105));
        this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368103));
        this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368104));
        this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379171);
        this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379170);
        m(paramauuw);
        auvd.a(this.jdField_d_of_type_AndroidWidgetTextView, "color", paramauuw.jdField_a_of_type_Auvd, "shoppingSignColor");
        auvd.a(this.f, "color", paramauuw.jdField_a_of_type_Auvd, "shoppingSignColor");
        auvd.a(this.e, "color", paramauuw.jdField_a_of_type_Auvd, "shoppingSignColor");
        auvd.a(this.jdField_d_of_type_AndroidViewView, "color", paramauuw.jdField_a_of_type_Auvd, "shoppingSignColor");
        auvd.a(this.jdField_c_of_type_AndroidViewView, "color", paramauuw.jdField_a_of_type_Auvd, "shoppingSignColor");
        this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379323));
        localObject1 = (HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367495);
        ((HeartLayout)localObject1).setEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (HeartLayout)localObject1);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView);
        super.e(paramauuw);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personal_like_tip", this.jdField_a_of_type_AndroidViewView.findViewById(2131371398));
        this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping = ((PhotoViewForShopping)this.jdField_a_of_type_AndroidViewView.findViewById(2131373664));
        this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramauuw, m, this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368151));
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_a_of_type_AndroidWidgetLinearLayout);
        if (paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label1393;
        }
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "ProfileShopping", "", "Shop_Ftemplate", "0X8005B9A", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        super.a(paramauuw);
        this.jdField_a_of_type_Boolean = true;
        return;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368096));
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363082), false);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368095));
        break;
        label1380:
        localObject1 = ((Context)localObject2).getString(2131691184);
        break label256;
        label1393:
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "ProfileShopping", "", "Shop_Mtemplate", "0X8005B96", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(auuw paramauuw, boolean paramBoolean)
  {
    super.e(paramauuw);
    super.f(paramauuw);
    m(paramauuw);
    super.c(paramauuw);
    super.b(paramauuw, false);
    h(paramauuw);
  }
  
  public void a(String paramString, int paramInt, List<auvp> paramList)
  {
    if ((paramString == null) || (paramList == null)) {
      return;
    }
    b(paramString, paramInt);
    a(paramList);
  }
  
  public void a(List<auvp> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping.a(true, this.jdField_a_of_type_Auuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramList);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return true;
    }
    return super.a(paramView, paramMotionEvent);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileShoppingView", 2, "shop name:" + paramString);
    }
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
      if (paramInt == 0) {
        break label89;
      }
      paramString = getContext().getResources().getDrawable(2130846497);
      if (paramString != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramString, null);
      }
    }
    return;
    label89:
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public void d(auuw paramauuw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("shoppingUserInfoBackground", "color");
    localHashMap.put("shoppingInfoMaskBackground", "color");
    localHashMap.put("shoppingShopnameText", "color");
    localHashMap.put("shoppingSignColor", "color");
    super.a(paramauuw, localHashMap);
  }
  
  public void h(auuw paramauuw)
  {
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sign");
    TextView localTextView;
    if ((localObject1 instanceof TextView))
    {
      localTextView = (TextView)localObject1;
      if ((paramauuw != null) && (paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)) {
        break label51;
      }
      localTextView.setVisibility(4);
    }
    label51:
    SpannableString localSpannableString;
    SpannableStringBuilder localSpannableStringBuilder;
    do
    {
      return;
      localObject1 = paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard.getRichStatus();
      if ((!ProfileActivity.AllInOne.g(paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (localObject1 == null))
      {
        localTextView.setVisibility(4);
        return;
      }
      localSpannableString = ((RichStatus)localObject1).toSpannableString("");
      if (TextUtils.isEmpty(((RichStatus)localObject1).actionText)) {
        break;
      }
      localSpannableStringBuilder = new SpannableStringBuilder(localSpannableString);
    } while (TextUtils.isEmpty(localSpannableStringBuilder));
    localSpannableStringBuilder.insert(0, "[S] ");
    aweo localaweo = (aweo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
    if (localaweo != null)
    {
      localObject1 = localaweo.a(((RichStatus)localObject1).actionId, 200);
      localObject1 = new bcrj(getResources(), (Bitmap)localObject1, false, false);
      int m = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
      ((BitmapDrawable)localObject1).setBounds(0, 0, m, m);
      localObject1 = new bcni((Drawable)localObject1, 0);
      ((bcni)localObject1).a(-0.1F);
      localSpannableStringBuilder.setSpan(localObject1, 0, "[S]".length(), 17);
      if (paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor != 1L) {
        break label534;
      }
      localObject1 = "#686c6f";
      label247:
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor((String)localObject1)), "[S]".length(), localSpannableStringBuilder.toString().indexOf(" ", "[S]".length() + 1), 33);
      localTextView.setText(localSpannableStringBuilder);
      localTextView.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "sign ssb= " + localSpannableStringBuilder + ",textColor = " + localTextView.getCurrentTextColor() + ",indexof=" + localSpannableStringBuilder.toString().indexOf(" ", "[S]".length() + 1));
      }
      label379:
      if ((paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (ProfileActivity.AllInOne.b(paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
        localTextView.setOnClickListener(paramauuw.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      if (TextUtils.isEmpty(localSpannableString)) {
        break label557;
      }
      localObject1 = localSpannableString.toString();
      label422:
      localTextView.setTag(new ausu(3, localObject1));
      localTextView.setOnLongClickListener(paramauuw.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localObject1 = new StringBuilder().append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691221)).append(":");
      if (TextUtils.isEmpty(localSpannableString)) {
        break label564;
      }
    }
    label534:
    label557:
    label564:
    for (paramauuw = localSpannableString.toString();; paramauuw = "")
    {
      for (;;)
      {
        localTextView.setContentDescription(paramauuw);
        return;
        try
        {
          localObject1 = BitmapFactory.decodeResource(getResources(), 2130848533);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          Object localObject2 = null;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          str = null;
        }
      }
      break;
      String str = "#ffffff";
      break label247;
      localTextView.setText(localSpannableString);
      localTextView.setVisibility(0);
      break label379;
      str = "";
      break label422;
    }
  }
  
  public void m(auuw paramauuw)
  {
    int n = -1;
    if (paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      paramauuw = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699305);
      this.f.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.e.setVisibility(8);
      this.f.setPadding(0, 10, 0, 0);
      this.f.setText(paramauuw);
      this.f.setContentDescription(paramauuw);
      return;
    }
    Object localObject = "";
    Card localCard = paramauuw.jdField_a_of_type_ComTencentMobileqqDataCard;
    ContactCard localContactCard = paramauuw.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    int m;
    if ((paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 0) || (paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 1)) {
      m = paramauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte;
    }
    for (;;)
    {
      if (m == 0)
      {
        paramauuw = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694073);
        label141:
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea sex=" + paramauuw);
        }
        if (TextUtils.isEmpty(paramauuw)) {
          break label696;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(paramauuw);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(paramauuw);
        label213:
        localObject = "";
        if (localCard == null) {
          break label724;
        }
        m = localCard.age;
        label229:
        paramauuw = (auuw)localObject;
        if (m > 0)
        {
          paramauuw = (auuw)localObject;
          if (!bazo.b()) {
            paramauuw = m + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719960);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea age=" + paramauuw);
        }
        if (TextUtils.isEmpty(paramauuw)) {
          break label740;
        }
        this.f.setVisibility(0);
        this.f.setText(paramauuw);
        this.f.setContentDescription(paramauuw);
        label337:
        localObject = "";
        if (localCard == null) {
          break label768;
        }
        paramauuw = (auuw)localObject;
        if (!TextUtils.isEmpty(localCard.strCountry))
        {
          paramauuw = (auuw)localObject;
          if (!ajyc.a(2131708495).equals(localCard.strCountry)) {
            paramauuw = "" + localCard.strCountry;
          }
        }
        localObject = paramauuw;
        if (!TextUtils.isEmpty(localCard.strProvince))
        {
          localObject = paramauuw;
          if (!TextUtils.isEmpty(paramauuw)) {
            localObject = paramauuw + "，";
          }
          localObject = (String)localObject + localCard.strProvince;
        }
        paramauuw = (auuw)localObject;
        if (!TextUtils.isEmpty(localCard.strCity))
        {
          paramauuw = (auuw)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramauuw = (String)localObject + "，";
          }
          paramauuw = paramauuw + localCard.strCity;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea place=" + paramauuw);
        }
        if (TextUtils.isEmpty(paramauuw)) {
          break label979;
        }
        this.e.setVisibility(0);
        this.e.setText(paramauuw);
        this.e.setContentDescription(paramauuw);
        return;
        if ((localCard != null) && ((localCard.shGender == 0) || (localCard.shGender == 1)))
        {
          m = localCard.shGender;
          break;
        }
        if ((localContactCard == null) || ((localContactCard.bSex != 0) && (localContactCard.bSex != 1))) {
          break label1005;
        }
        m = localContactCard.bSex;
        break;
        paramauuw = (auuw)localObject;
        if (m != 1) {
          break label141;
        }
        paramauuw = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692394);
        break label141;
        label696:
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        if (this.jdField_c_of_type_AndroidViewView == null) {
          break label213;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        break label213;
        label724:
        m = n;
        if (localContactCard == null) {
          break label229;
        }
        m = localContactCard.bAge;
        break label229;
        label740:
        this.f.setVisibility(8);
        if (this.jdField_c_of_type_AndroidViewView == null) {
          break label337;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        break label337;
        label768:
        paramauuw = (auuw)localObject;
        if (localContactCard != null)
        {
          paramauuw = (auuw)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCountry))
          {
            paramauuw = (auuw)localObject;
            if (!ajyc.a(2131708494).equals(localContactCard.strCountry)) {
              paramauuw = "" + localContactCard.strCountry;
            }
          }
          localObject = paramauuw;
          if (!TextUtils.isEmpty(localContactCard.strProvince))
          {
            localObject = paramauuw;
            if (!TextUtils.isEmpty(paramauuw)) {
              localObject = paramauuw + "，";
            }
            localObject = (String)localObject + localContactCard.strProvince;
          }
          paramauuw = (auuw)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCity))
          {
            paramauuw = (auuw)localObject;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              paramauuw = (String)localObject + "，";
            }
            paramauuw = paramauuw + localContactCard.strCity;
          }
        }
      }
      label979:
      this.e.setVisibility(8);
      if (this.jdField_d_of_type_AndroidViewView == null) {
        break;
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      return;
      label1005:
      m = -1;
    }
  }
  
  public void setShoppingBgBlur(boolean paramBoolean)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(16908290);
      if ((localObject != null) && (((FrameLayout)localObject).getChildCount() > 0))
      {
        localObject = ((FrameLayout)localObject).getChildAt(0);
        if (localObject != null)
        {
          localObject = ((View)localObject).getBackground();
          if (!paramBoolean) {
            break label66;
          }
        }
      }
    }
    label66:
    for (int m = 255;; m = 0)
    {
      if (localObject != null) {
        ((Drawable)localObject).setAlpha(m);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileShoppingView
 * JD-Core Version:    0.7.0.1
 */