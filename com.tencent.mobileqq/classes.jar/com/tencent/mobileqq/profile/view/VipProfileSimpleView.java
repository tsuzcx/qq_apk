package com.tencent.mobileqq.profile.view;

import alud;
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
import awor;
import awqt;
import awra;
import awwo;
import awwp;
import bddf;
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
  
  public VipProfileSimpleView(BaseActivity paramBaseActivity, awqt paramawqt)
  {
    super(paramBaseActivity, paramawqt);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Awqt = paramawqt;
    d(paramawqt);
    a(paramawqt);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Awqt != null) {
      super.b(this.jdField_a_of_type_Awqt, false);
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      localLayoutParams.addRule(3, 2131367633);
      localLayoutParams.addRule(8, 0);
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
    }
  }
  
  @TargetApi(9)
  public void a(awqt paramawqt)
  {
    Object localObject1 = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject1).inflate(2131561837, this, true);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368242));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368243));
    awra.a(this.jdField_a_of_type_AndroidWidgetImageView, "src", paramawqt.jdField_a_of_type_Awra, "commonFaceBackground");
    Object localObject2 = new awor(1, null);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setTag(localObject2);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (localObject1 = ((Context)localObject1).getString(2131691239);; localObject1 = ((Context)localObject1).getString(2131691238))
    {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setContentDescription((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363115), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131368243));
      super.a(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368078));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setTag(localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_b_of_type_AndroidWidgetImageView);
      super.b(paramawqt, true);
      this.jdField_d_of_type_Float = this.jdField_c_of_type_Float;
      this.g = getResources().getDimensionPixelSize(2131296956);
      this.h = bddf.a(getResources());
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368240);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)this.jdField_c_of_type_Float - bddf.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 129) - bddf.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18) - this.g - this.h);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368260));
      awra.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView, "color", paramawqt.jdField_a_of_type_Awra, "simpleNickNameColor");
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      super.f(paramawqt);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368254));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368252));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368253));
      awra.a(this.jdField_a_of_type_AndroidWidgetTextView, "color", paramawqt.jdField_a_of_type_Awra, "simpleAddressColor");
      awra.a(this.jdField_c_of_type_AndroidWidgetTextView, "color", paramawqt.jdField_a_of_type_Awra, "simpleAddressColor");
      awra.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramawqt.jdField_a_of_type_Awra, "simpleAddressColor");
      awra.a(this.jdField_a_of_type_AndroidWidgetTextView, "background", paramawqt.jdField_a_of_type_Awra, "simpleAddressBackground");
      awra.a(this.jdField_c_of_type_AndroidWidgetTextView, "background", paramawqt.jdField_a_of_type_Awra, "simpleAddressBackground");
      awra.a(this.jdField_b_of_type_AndroidWidgetTextView, "background", paramawqt.jdField_a_of_type_Awra, "simpleAddressBackground");
      n(paramawqt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380087));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367633));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView);
      super.e(paramawqt);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personal_like_tip", this.jdField_a_of_type_AndroidViewView.findViewById(2131371734));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple = ((VipPhotoViewForSimple)this.jdField_a_of_type_AndroidViewView.findViewById(2131374169));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramawqt);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple);
      awra.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple, "background", paramawqt.jdField_a_of_type_Awra, "commonMaskBackground");
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368308));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372313));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372314));
      this.jdField_c_of_type_AndroidWidgetImageView.setTag(new awor(73, this.jdField_d_of_type_AndroidWidgetTextView));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnClickListener);
      super.a(paramawqt);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (!(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) || (!((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).k)) {
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      g(paramawqt);
      return;
    }
    localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, 0.0F, 0, -100.0F);
    ((Animation)localObject1).setDuration(500L);
    ((Animation)localObject1).setFillAfter(true);
    localObject2 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, -100.0F, 0, 0.0F);
    ((Animation)localObject2).setDuration(500L);
    ((Animation)localObject2).setAnimationListener(new awwo(this, paramawqt));
    ((Animation)localObject1).setAnimationListener(new awwp(this, (Animation)localObject2));
    startAnimation((Animation)localObject1);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(awqt paramawqt, boolean paramBoolean)
  {
    super.e(paramawqt);
    super.f(paramawqt);
    n(paramawqt);
    super.c(paramawqt);
    super.b(paramawqt, false);
    m(paramawqt);
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
      localLayoutParams.addRule(8, 2131368317);
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
    localLayoutParams.height = ((int)this.jdField_c_of_type_Float - bddf.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 129) - bddf.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18) - this.g - this.h);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      localLayoutParams.height += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + localLayoutParams.height);
    }
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void d(awqt paramawqt)
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
    super.a(paramawqt, localHashMap);
  }
  
  @TargetApi(9)
  void m(awqt paramawqt)
  {
    if (!paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    do
    {
      return;
      if ((paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.cardType != 2) && (paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId != 1600L)) {
        break;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramawqt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("vip_profile_diy_card", 0);
    } while (paramawqt.getBoolean("vip_diy_card_edit_hint", false));
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    paramawqt.edit().putBoolean("vip_diy_card_edit_hint", true).apply();
    return;
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void n(awqt paramawqt)
  {
    int j = -1;
    if (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      paramawqt = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699673);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, 10, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramawqt);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(paramawqt);
      return;
    }
    Object localObject = "";
    Card localCard = paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard;
    ContactCard localContactCard = paramawqt.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    int i;
    if ((paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 0) || (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 1)) {
      i = paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte;
    }
    for (;;)
    {
      if (i == 0)
      {
        paramawqt = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694192);
        label141:
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea sex=" + paramawqt);
        }
        if (TextUtils.isEmpty(paramawqt)) {
          break label688;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramawqt);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramawqt);
        label205:
        localObject = "";
        if (localCard == null) {
          break label700;
        }
        i = localCard.age;
        label221:
        paramawqt = (awqt)localObject;
        if (i > 0)
        {
          paramawqt = (awqt)localObject;
          if (!bddf.b()) {
            paramawqt = i + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131720518);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea age=" + paramawqt);
        }
        if (TextUtils.isEmpty(paramawqt)) {
          break label716;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramawqt);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(paramawqt);
        label329:
        localObject = "";
        if (localCard == null) {
          break label728;
        }
        paramawqt = (awqt)localObject;
        if (!TextUtils.isEmpty(localCard.strCountry))
        {
          paramawqt = (awqt)localObject;
          if (!alud.a(2131717165).equals(localCard.strCountry)) {
            paramawqt = "" + localCard.strCountry;
          }
        }
        localObject = paramawqt;
        if (!TextUtils.isEmpty(localCard.strProvince))
        {
          localObject = paramawqt;
          if (!TextUtils.isEmpty(paramawqt)) {
            localObject = paramawqt + "，";
          }
          localObject = (String)localObject + localCard.strProvince;
        }
        paramawqt = (awqt)localObject;
        if (!TextUtils.isEmpty(localCard.strCity))
        {
          paramawqt = (awqt)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramawqt = (String)localObject + "，";
          }
          paramawqt = paramawqt + localCard.strCity;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea place=" + paramawqt);
        }
        if (TextUtils.isEmpty(paramawqt)) {
          break label939;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramawqt);
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramawqt);
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
        paramawqt = (awqt)localObject;
        if (i != 1) {
          break label141;
        }
        paramawqt = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692471);
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
        paramawqt = (awqt)localObject;
        if (localContactCard != null)
        {
          paramawqt = (awqt)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCountry))
          {
            paramawqt = (awqt)localObject;
            if (!alud.a(2131717164).equals(localContactCard.strCountry)) {
              paramawqt = "" + localContactCard.strCountry;
            }
          }
          localObject = paramawqt;
          if (!TextUtils.isEmpty(localContactCard.strProvince))
          {
            localObject = paramawqt;
            if (!TextUtils.isEmpty(paramawqt)) {
              localObject = paramawqt + "，";
            }
            localObject = (String)localObject + localContactCard.strProvince;
          }
          paramawqt = (awqt)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCity))
          {
            paramawqt = (awqt)localObject;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              paramawqt = (String)localObject + "，";
            }
            paramawqt = paramawqt + localContactCard.strCity;
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