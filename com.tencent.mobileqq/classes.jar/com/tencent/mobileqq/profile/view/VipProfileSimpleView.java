package com.tencent.mobileqq.profile.view;

import alpo;
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
import awki;
import awmk;
import awmr;
import awsf;
import awsg;
import bcyw;
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
  View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public HeartLayout a;
  public VipPhotoViewForSimple a;
  public AvatarLayout a;
  public ProfileNameView a;
  public VoteView a;
  private boolean jdField_a_of_type_Boolean;
  private long b;
  public View b;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public TextView c;
  private float d;
  public TextView d;
  public int g = -1;
  public int h = -1;
  
  public VipProfileSimpleView(BaseActivity paramBaseActivity, awmk paramawmk)
  {
    super(paramBaseActivity, paramawmk);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Awmk = paramawmk;
    d(paramawmk);
    a(paramawmk);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Awmk != null) {
      super.b(this.jdField_a_of_type_Awmk, false);
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      localLayoutParams.addRule(3, 2131367623);
      localLayoutParams.addRule(8, 0);
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
    }
  }
  
  @TargetApi(9)
  public void a(awmk paramawmk)
  {
    Object localObject1 = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject1).inflate(2131561819, this, true);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368231));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368232));
    awmr.a(this.jdField_a_of_type_AndroidWidgetImageView, "src", paramawmk.jdField_a_of_type_Awmr, "commonFaceBackground");
    Object localObject2 = new awki(1, null);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setTag(localObject2);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(paramawmk.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (localObject1 = ((Context)localObject1).getString(2131691238);; localObject1 = ((Context)localObject1).getString(2131691237))
    {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setContentDescription((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363115), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131368232));
      super.a(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368067));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramawmk.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setTag(localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_b_of_type_AndroidWidgetImageView);
      super.b(paramawmk, true);
      this.jdField_d_of_type_Float = this.jdField_c_of_type_Float;
      this.g = getResources().getDimensionPixelSize(2131296956);
      this.h = bcyw.a(getResources());
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368229);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)this.jdField_c_of_type_Float - bcyw.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 129) - bcyw.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18) - this.g - this.h);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368249));
      awmr.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView, "color", paramawmk.jdField_a_of_type_Awmr, "simpleNickNameColor");
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      super.f(paramawmk);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368243));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368241));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368242));
      awmr.a(this.jdField_a_of_type_AndroidWidgetTextView, "color", paramawmk.jdField_a_of_type_Awmr, "simpleAddressColor");
      awmr.a(this.jdField_c_of_type_AndroidWidgetTextView, "color", paramawmk.jdField_a_of_type_Awmr, "simpleAddressColor");
      awmr.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramawmk.jdField_a_of_type_Awmr, "simpleAddressColor");
      awmr.a(this.jdField_a_of_type_AndroidWidgetTextView, "background", paramawmk.jdField_a_of_type_Awmr, "simpleAddressBackground");
      awmr.a(this.jdField_c_of_type_AndroidWidgetTextView, "background", paramawmk.jdField_a_of_type_Awmr, "simpleAddressBackground");
      awmr.a(this.jdField_b_of_type_AndroidWidgetTextView, "background", paramawmk.jdField_a_of_type_Awmr, "simpleAddressBackground");
      n(paramawmk);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380029));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367623));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView);
      super.e(paramawmk);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personal_like_tip", this.jdField_a_of_type_AndroidViewView.findViewById(2131371714));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple = ((VipPhotoViewForSimple)this.jdField_a_of_type_AndroidViewView.findViewById(2131374118));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramawmk);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple);
      awmr.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple, "background", paramawmk.jdField_a_of_type_Awmr, "commonMaskBackground");
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368297));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372293));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372294));
      this.jdField_c_of_type_AndroidWidgetImageView.setTag(new awki(73, this.jdField_d_of_type_AndroidWidgetTextView));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramawmk.jdField_a_of_type_AndroidViewView$OnClickListener);
      super.a(paramawmk);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (!(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) || (!((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).k)) {
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      g(paramawmk);
      return;
    }
    localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, 0.0F, 0, -100.0F);
    ((Animation)localObject1).setDuration(500L);
    ((Animation)localObject1).setFillAfter(true);
    localObject2 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, -100.0F, 0, 0.0F);
    ((Animation)localObject2).setDuration(500L);
    ((Animation)localObject2).setAnimationListener(new awsf(this, paramawmk));
    ((Animation)localObject1).setAnimationListener(new awsg(this, (Animation)localObject2));
    startAnimation((Animation)localObject1);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(awmk paramawmk, boolean paramBoolean)
  {
    super.e(paramawmk);
    super.f(paramawmk);
    n(paramawmk);
    super.c(paramawmk);
    super.b(paramawmk, false);
    m(paramawmk);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long > 1000L) {}
    for (int i = 1; (i == 0) && (!this.jdField_a_of_type_Boolean); i = 0) {
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
      localLayoutParams.addRule(8, 2131368306);
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
    localLayoutParams.height = ((int)this.jdField_c_of_type_Float - bcyw.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 129) - bcyw.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18) - this.g - this.h);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      localLayoutParams.height += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + localLayoutParams.height);
    }
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void d(awmk paramawmk)
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
    super.a(paramawmk, localHashMap);
  }
  
  @TargetApi(9)
  void m(awmk paramawmk)
  {
    if (!paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    do
    {
      return;
      if ((paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.cardType != 2) && (paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId != 1600L)) {
        break;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramawmk = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("vip_profile_diy_card", 0);
    } while (paramawmk.getBoolean("vip_diy_card_edit_hint", false));
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    paramawmk.edit().putBoolean("vip_diy_card_edit_hint", true).apply();
    return;
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void n(awmk paramawmk)
  {
    int j = -1;
    if (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      paramawmk = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699661);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, 10, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramawmk);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(paramawmk);
      return;
    }
    Object localObject = "";
    Card localCard = paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard;
    ContactCard localContactCard = paramawmk.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    int i;
    if ((paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 0) || (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 1)) {
      i = paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte;
    }
    for (;;)
    {
      if (i == 0)
      {
        paramawmk = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694190);
        label141:
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea sex=" + paramawmk);
        }
        if (TextUtils.isEmpty(paramawmk)) {
          break label688;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramawmk);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramawmk);
        label205:
        localObject = "";
        if (localCard == null) {
          break label700;
        }
        i = localCard.age;
        label221:
        paramawmk = (awmk)localObject;
        if (i > 0)
        {
          paramawmk = (awmk)localObject;
          if (!bcyw.b()) {
            paramawmk = i + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131720506);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea age=" + paramawmk);
        }
        if (TextUtils.isEmpty(paramawmk)) {
          break label716;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramawmk);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(paramawmk);
        label329:
        localObject = "";
        if (localCard == null) {
          break label728;
        }
        paramawmk = (awmk)localObject;
        if (!TextUtils.isEmpty(localCard.strCountry))
        {
          paramawmk = (awmk)localObject;
          if (!alpo.a(2131717153).equals(localCard.strCountry)) {
            paramawmk = "" + localCard.strCountry;
          }
        }
        localObject = paramawmk;
        if (!TextUtils.isEmpty(localCard.strProvince))
        {
          localObject = paramawmk;
          if (!TextUtils.isEmpty(paramawmk)) {
            localObject = paramawmk + "，";
          }
          localObject = (String)localObject + localCard.strProvince;
        }
        paramawmk = (awmk)localObject;
        if (!TextUtils.isEmpty(localCard.strCity))
        {
          paramawmk = (awmk)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramawmk = (String)localObject + "，";
          }
          paramawmk = paramawmk + localCard.strCity;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea place=" + paramawmk);
        }
        if (TextUtils.isEmpty(paramawmk)) {
          break label939;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramawmk);
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramawmk);
        return;
        if ((localCard != null) && ((localCard.shGender == 0) || (localCard.shGender == 1)))
        {
          i = localCard.shGender;
          break;
        }
        if ((localContactCard == null) || ((localContactCard.bSex != 0) && (localContactCard.bSex != 1))) {
          break label949;
        }
        i = localContactCard.bSex;
        break;
        paramawmk = (awmk)localObject;
        if (i != 1) {
          break label141;
        }
        paramawmk = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692470);
        break label141;
        label688:
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label205;
        label700:
        i = j;
        if (localContactCard == null) {
          break label221;
        }
        i = localContactCard.bAge;
        break label221;
        label716:
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        break label329;
        label728:
        paramawmk = (awmk)localObject;
        if (localContactCard != null)
        {
          paramawmk = (awmk)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCountry))
          {
            paramawmk = (awmk)localObject;
            if (!alpo.a(2131717152).equals(localContactCard.strCountry)) {
              paramawmk = "" + localContactCard.strCountry;
            }
          }
          localObject = paramawmk;
          if (!TextUtils.isEmpty(localContactCard.strProvince))
          {
            localObject = paramawmk;
            if (!TextUtils.isEmpty(paramawmk)) {
              localObject = paramawmk + "，";
            }
            localObject = (String)localObject + localContactCard.strProvince;
          }
          paramawmk = (awmk)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCity))
          {
            paramawmk = (awmk)localObject;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              paramawmk = (String)localObject + "，";
            }
            paramawmk = paramawmk + localContactCard.strCity;
          }
        }
      }
      label939:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      label949:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipProfileSimpleView
 * JD-Core Version:    0.7.0.1
 */