package com.tencent.mobileqq.profile.view;

import ajjy;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import atuw;
import atwx;
import atxe;
import aubk;
import aubl;
import azyk;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;

public class VipProfileSimpleView
  extends ProfileHeaderView
{
  View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public HeartLayout a;
  public VipPhotoViewForSimple a;
  public AvatarLayout a;
  public ProfileNameView a;
  public VoteView a;
  public boolean a;
  public View b;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public TextView c;
  private float d;
  public TextView d;
  public int g = -1;
  public int h = -1;
  
  public VipProfileSimpleView(BaseActivity paramBaseActivity, atwx paramatwx)
  {
    super(paramBaseActivity, paramatwx);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Atwx = paramatwx;
    d(paramatwx);
    a(paramatwx);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Atwx != null) {
      super.b(this.jdField_a_of_type_Atwx, false);
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      localLayoutParams.addRule(3, 2131301878);
      localLayoutParams.addRule(8, 0);
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
    }
  }
  
  @TargetApi(9)
  public void a(atwx paramatwx)
  {
    Object localObject1 = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject1).inflate(2131496037, this, true);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131302473));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302474));
    atxe.a(this.jdField_a_of_type_AndroidWidgetImageView, "src", paramatwx.jdField_a_of_type_Atxe, "commonFaceBackground");
    Object localObject2 = new atuw(1, null);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setTag(localObject2);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (localObject1 = ((Context)localObject1).getString(2131625610);; localObject1 = ((Context)localObject1).getString(2131625609))
    {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setContentDescription((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131297539), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131302474));
      super.a(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302311));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setTag(localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_b_of_type_AndroidWidgetImageView);
      super.b(paramatwx, true);
      this.jdField_d_of_type_Float = this.jdField_c_of_type_Float;
      this.g = getResources().getDimensionPixelSize(2131165865);
      this.h = azyk.a(getResources());
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131302471);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)this.jdField_c_of_type_Float - azyk.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 129) - azyk.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18) - this.g - this.h);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        ((RelativeLayout.LayoutParams)localObject1).height += ImmersiveUtils.getStatusBarHeight(getContext());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) && (((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).k)) {
        ((RelativeLayout.LayoutParams)localObject1).height = ((int)(((RelativeLayout.LayoutParams)localObject1).height - this.jdField_c_of_type_Float / 2.0F));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + ((RelativeLayout.LayoutParams)localObject1).height);
      }
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_b_of_type_AndroidViewView.setFocusable(true);
      this.jdField_b_of_type_AndroidViewView.setFocusableInTouchMode(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302491));
      atxe.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView, "color", paramatwx.jdField_a_of_type_Atxe, "simpleNickNameColor");
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      super.f(paramatwx);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302485));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302483));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302484));
      atxe.a(this.jdField_a_of_type_AndroidWidgetTextView, "color", paramatwx.jdField_a_of_type_Atxe, "simpleAddressColor");
      atxe.a(this.jdField_c_of_type_AndroidWidgetTextView, "color", paramatwx.jdField_a_of_type_Atxe, "simpleAddressColor");
      atxe.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramatwx.jdField_a_of_type_Atxe, "simpleAddressColor");
      atxe.a(this.jdField_a_of_type_AndroidWidgetTextView, "background", paramatwx.jdField_a_of_type_Atxe, "simpleAddressBackground");
      atxe.a(this.jdField_c_of_type_AndroidWidgetTextView, "background", paramatwx.jdField_a_of_type_Atxe, "simpleAddressBackground");
      atxe.a(this.jdField_b_of_type_AndroidWidgetTextView, "background", paramatwx.jdField_a_of_type_Atxe, "simpleAddressBackground");
      n(paramatwx);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313488));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131301878));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView);
      super.e(paramatwx);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personal_like_tip", this.jdField_a_of_type_AndroidViewView.findViewById(2131305702));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple = ((VipPhotoViewForSimple)this.jdField_a_of_type_AndroidViewView.findViewById(2131307947));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramatwx);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple);
      atxe.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple, "background", paramatwx.jdField_a_of_type_Atxe, "commonMaskBackground");
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131302531));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131306279));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131306280));
      this.jdField_c_of_type_AndroidWidgetImageView.setTag(new atuw(73, this.jdField_d_of_type_AndroidWidgetTextView));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnClickListener);
      super.a(paramatwx);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (!(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) || (!((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).k)) {
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      g(paramatwx);
      return;
    }
    localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, 0.0F, 0, -100.0F);
    ((Animation)localObject1).setDuration(500L);
    ((Animation)localObject1).setFillAfter(true);
    localObject2 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, -100.0F, 0, 0.0F);
    ((Animation)localObject2).setDuration(500L);
    ((Animation)localObject2).setAnimationListener(new aubk(this, paramatwx));
    ((Animation)localObject1).setAnimationListener(new aubl(this, (Animation)localObject2));
    startAnimation((Animation)localObject1);
  }
  
  public void a(atwx paramatwx, boolean paramBoolean)
  {
    super.e(paramatwx);
    super.f(paramatwx);
    n(paramatwx);
    super.c(paramatwx);
    super.b(paramatwx, false);
    m(paramatwx);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return true;
    }
    return super.a(paramView, paramMotionEvent);
  }
  
  public void c(int paramInt)
  {
    super.c(paramInt);
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.addRule(3, 0);
      localLayoutParams.addRule(8, 2131302540);
      localLayoutParams.bottomMargin = paramInt;
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard", 2, "onApolloExpand h:" + paramInt);
      }
    }
  }
  
  public void d()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = ((int)this.jdField_c_of_type_Float - azyk.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 129) - azyk.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18) - this.g - this.h);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      localLayoutParams.height += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + localLayoutParams.height);
    }
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void d(atwx paramatwx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("commonFaceBackground", "drawable");
    localHashMap.put("simpleQQNumColor", "color");
    localHashMap.put("simpleNickNameColor", "color");
    localHashMap.put("simpleAddressColor", "color");
    localHashMap.put("simpleGridAddBackground", "color");
    localHashMap.put("simpleAddressBackground", "drawable");
    localHashMap.put("simpleAddSrc", "drawable");
    localHashMap.put("simpleGridAddSrc", "drawable");
    super.a(paramatwx, localHashMap);
  }
  
  @TargetApi(9)
  void m(atwx paramatwx)
  {
    if (!paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    do
    {
      return;
      if ((paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.cardType != 2) && (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId != 1600L)) {
        break;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramatwx = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("vip_profile_diy_card", 0);
    } while (paramatwx.getBoolean("vip_diy_card_edit_hint", false));
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    paramatwx.edit().putBoolean("vip_diy_card_edit_hint", true).apply();
    return;
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void n(atwx paramatwx)
  {
    int j = -1;
    if (paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      paramatwx = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131633544);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, 10, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramatwx);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(paramatwx);
      return;
    }
    Object localObject = "";
    Card localCard = paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard;
    ContactCard localContactCard = paramatwx.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    int i;
    if ((paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 0) || (paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 1)) {
      i = paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte;
    }
    for (;;)
    {
      if (i == 0)
      {
        paramatwx = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131628431);
        label141:
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea sex=" + paramatwx);
        }
        if (TextUtils.isEmpty(paramatwx)) {
          break label685;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramatwx);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramatwx);
        label204:
        localObject = "";
        if (localCard == null) {
          break label697;
        }
        i = localCard.age;
        label220:
        paramatwx = (atwx)localObject;
        if (i > 0)
        {
          paramatwx = (atwx)localObject;
          if (!azyk.b()) {
            paramatwx = i + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131654071);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea age=" + paramatwx);
        }
        if (TextUtils.isEmpty(paramatwx)) {
          break label713;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramatwx);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(paramatwx);
        label327:
        localObject = "";
        if (localCard == null) {
          break label725;
        }
        paramatwx = (atwx)localObject;
        if (!TextUtils.isEmpty(localCard.strCountry))
        {
          paramatwx = (atwx)localObject;
          if (!ajjy.a(2131650979).equals(localCard.strCountry)) {
            paramatwx = "" + localCard.strCountry;
          }
        }
        localObject = paramatwx;
        if (!TextUtils.isEmpty(localCard.strProvince))
        {
          localObject = paramatwx;
          if (!TextUtils.isEmpty(paramatwx)) {
            localObject = paramatwx + "，";
          }
          localObject = (String)localObject + localCard.strProvince;
        }
        paramatwx = (atwx)localObject;
        if (!TextUtils.isEmpty(localCard.strCity))
        {
          paramatwx = (atwx)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramatwx = (String)localObject + "，";
          }
          paramatwx = paramatwx + localCard.strCity;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea place=" + paramatwx);
        }
        if (TextUtils.isEmpty(paramatwx)) {
          break label936;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramatwx);
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramatwx);
        return;
        if ((localCard != null) && ((localCard.shGender == 0) || (localCard.shGender == 1)))
        {
          i = localCard.shGender;
          break;
        }
        if ((localContactCard == null) || ((localContactCard.bSex != 0) && (localContactCard.bSex != 1))) {
          break label946;
        }
        i = localContactCard.bSex;
        break;
        paramatwx = (atwx)localObject;
        if (i != 1) {
          break label141;
        }
        paramatwx = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131626792);
        break label141;
        label685:
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label204;
        label697:
        i = j;
        if (localContactCard == null) {
          break label220;
        }
        i = localContactCard.bAge;
        break label220;
        label713:
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        break label327;
        label725:
        paramatwx = (atwx)localObject;
        if (localContactCard != null)
        {
          paramatwx = (atwx)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCountry))
          {
            paramatwx = (atwx)localObject;
            if (!ajjy.a(2131650978).equals(localContactCard.strCountry)) {
              paramatwx = "" + localContactCard.strCountry;
            }
          }
          localObject = paramatwx;
          if (!TextUtils.isEmpty(localContactCard.strProvince))
          {
            localObject = paramatwx;
            if (!TextUtils.isEmpty(paramatwx)) {
              localObject = paramatwx + "，";
            }
            localObject = (String)localObject + localContactCard.strProvince;
          }
          paramatwx = (atwx)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCity))
          {
            paramatwx = (atwx)localObject;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              paramatwx = (String)localObject + "，";
            }
            paramatwx = paramatwx + localContactCard.strCity;
          }
        }
      }
      label936:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      label946:
      i = -1;
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_d_of_type_Float != this.jdField_c_of_type_Float)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      paramConfiguration.height = ((int)(paramConfiguration.height + (this.jdField_c_of_type_Float - this.jdField_d_of_type_Float)));
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramConfiguration);
      this.jdField_d_of_type_Float = this.jdField_c_of_type_Float;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipProfileSimpleView
 * JD-Core Version:    0.7.0.1
 */