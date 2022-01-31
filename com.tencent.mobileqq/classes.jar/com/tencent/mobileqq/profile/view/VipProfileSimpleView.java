package com.tencent.mobileqq.profile.view;

import agek;
import agel;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.util.ProfileCardUtil;
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
  public VoteView a;
  public View b;
  public TextView b;
  public ImageView c;
  public TextView c;
  public boolean c;
  public ImageView d;
  public TextView d;
  public ImageView e;
  public TextView e;
  public TextView f;
  public int j = -1;
  public int k = -1;
  
  public VipProfileSimpleView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    b(paramProfileCardInfo);
    a(paramProfileCardInfo);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) {
      super.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, false);
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      localLayoutParams.addRule(3, 2131370566);
      localLayoutParams.addRule(8, 0);
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.addRule(3, 0);
      localLayoutParams.addRule(8, 2131370870);
      localLayoutParams.bottomMargin = paramInt;
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard", 2, "onApolloExpand h:" + paramInt);
      }
    }
  }
  
  @TargetApi(9)
  public void a(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject1).inflate(2130970965, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369034));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370868));
    ProfileCardTemplate.a(this.jdField_c_of_type_AndroidWidgetImageView, "src", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonFaceBackground");
    Object localObject2 = new DataTag(1, null);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject2);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (localObject1 = ((Context)localObject1).getString(2131427397);; localObject1 = ((Context)localObject1).getString(2131427396))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131370868));
      super.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364641));
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_d_of_type_AndroidWidgetImageView.setTag(localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_d_of_type_AndroidWidgetImageView);
      super.c(paramProfileCardInfo, true);
      this.j = getResources().getDimensionPixelSize(2131558669);
      this.k = ProfileCardUtil.a(getResources());
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372382);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)this.jdField_d_of_type_Float - ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 129) - ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18) - this.j - this.k);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        ((RelativeLayout.LayoutParams)localObject1).height += ImmersiveUtils.a(getContext());
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + ((RelativeLayout.LayoutParams)localObject1).height);
      }
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_b_of_type_AndroidViewView.setFocusable(true);
      this.jdField_b_of_type_AndroidViewView.setFocusableInTouchMode(true);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370146));
      ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleNickNameColor");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_b_of_type_AndroidWidgetTextView);
      super.i(paramProfileCardInfo);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370872));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370871));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370873));
      ProfileCardTemplate.a(this.jdField_c_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressColor");
      ProfileCardTemplate.a(this.jdField_e_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressColor");
      ProfileCardTemplate.a(this.jdField_d_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressColor");
      ProfileCardTemplate.a(this.jdField_c_of_type_AndroidWidgetTextView, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressBackground");
      ProfileCardTemplate.a(this.jdField_e_of_type_AndroidWidgetTextView, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressBackground");
      ProfileCardTemplate.a(this.jdField_d_of_type_AndroidWidgetTextView, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressBackground");
      m(paramProfileCardInfo);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370395));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370566));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView);
      super.g(paramProfileCardInfo);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personal_like_tip", this.jdField_a_of_type_AndroidViewView.findViewById(2131372362));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372367));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tag_jueban", this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple = ((VipPhotoViewForSimple)this.jdField_a_of_type_AndroidViewView.findViewById(2131372377));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramProfileCardInfo);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple);
      ProfileCardTemplate.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonMaskBackground");
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372363));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_a_of_type_AndroidWidgetLinearLayout);
      localObject1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372353);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_num", localObject1);
      ((TextView)localObject1).setOnClickListener(this);
      localObject1 = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewView.findViewById(2131372350)).a(53).a(true).c(1).e(10).a();
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_increment", localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_container", this.jdField_a_of_type_AndroidViewView.findViewById(2131372350));
      d(paramProfileCardInfo);
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372393));
      this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372394));
      this.jdField_e_of_type_AndroidWidgetImageView.setTag(new DataTag(73, this.f));
      this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      super.a(paramProfileCardInfo);
      localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, 0.0F, 0, -100.0F);
      ((Animation)localObject1).setDuration(500L);
      ((Animation)localObject1).setFillAfter(true);
      localObject2 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, -100.0F, 0, 0.0F);
      ((Animation)localObject2).setDuration(500L);
      ((Animation)localObject2).setAnimationListener(new agek(this, paramProfileCardInfo));
      ((Animation)localObject1).setAnimationListener(new agel(this, (Animation)localObject2));
      startAnimation((Animation)localObject1);
      return;
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.g(paramProfileCardInfo);
    super.i(paramProfileCardInfo);
    m(paramProfileCardInfo);
    super.e(paramProfileCardInfo);
    super.c(paramProfileCardInfo, false);
    f(paramProfileCardInfo);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return true;
    }
    return super.a(paramView, paramMotionEvent);
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
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
    super.a(paramProfileCardInfo, localHashMap);
  }
  
  @TargetApi(9)
  void f(ProfileCardInfo paramProfileCardInfo)
  {
    if (!paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    do
    {
      return;
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.cardType != 2) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId != 1600L)) {
        break;
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("vip_profile_diy_card", 0);
    } while (paramProfileCardInfo.getBoolean("vip_diy_card_edit_hint", false));
    this.f.setVisibility(0);
    paramProfileCardInfo.edit().putBoolean("vip_diy_card_edit_hint", true).apply();
    return;
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void m(ProfileCardInfo paramProfileCardInfo)
  {
    int m = -1;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436533);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetTextView.setPadding(0, 10, 0, 0);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramProfileCardInfo);
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(paramProfileCardInfo);
      return;
    }
    Object localObject = "";
    Card localCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
    ContactCard localContactCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    int i;
    if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 0) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 1)) {
      i = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte;
    }
    for (;;)
    {
      if (i == 0)
      {
        paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433924);
        label141:
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea sex=" + paramProfileCardInfo);
        }
        if (TextUtils.isEmpty(paramProfileCardInfo)) {
          break label685;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramProfileCardInfo);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(paramProfileCardInfo);
        label205:
        localObject = "";
        if (localCard == null) {
          break label697;
        }
        i = localCard.age;
        label221:
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (i > 0)
        {
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (!ProfileCardUtil.b()) {
            paramProfileCardInfo = i + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433926);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea age=" + paramProfileCardInfo);
        }
        if (TextUtils.isEmpty(paramProfileCardInfo)) {
          break label713;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramProfileCardInfo);
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(paramProfileCardInfo);
        label329:
        localObject = "";
        if (localCard == null) {
          break label725;
        }
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (!TextUtils.isEmpty(localCard.strCountry))
        {
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (!"中国".equals(localCard.strCountry)) {
            paramProfileCardInfo = "" + localCard.strCountry;
          }
        }
        localObject = paramProfileCardInfo;
        if (!TextUtils.isEmpty(localCard.strProvince))
        {
          localObject = paramProfileCardInfo;
          if (!TextUtils.isEmpty(paramProfileCardInfo)) {
            localObject = paramProfileCardInfo + "，";
          }
          localObject = (String)localObject + localCard.strProvince;
        }
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (!TextUtils.isEmpty(localCard.strCity))
        {
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramProfileCardInfo = (String)localObject + "，";
          }
          paramProfileCardInfo = paramProfileCardInfo + localCard.strCity;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea place=" + paramProfileCardInfo);
        }
        if (TextUtils.isEmpty(paramProfileCardInfo)) {
          break label933;
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(paramProfileCardInfo);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(paramProfileCardInfo);
        return;
        if ((localCard != null) && ((localCard.shGender == 0) || (localCard.shGender == 1)))
        {
          i = localCard.shGender;
          break;
        }
        if ((localContactCard == null) || ((localContactCard.bSex != 0) && (localContactCard.bSex != 1))) {
          break label943;
        }
        i = localContactCard.bSex;
        break;
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (i != 1) {
          break label141;
        }
        paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433925);
        break label141;
        label685:
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        break label205;
        label697:
        i = m;
        if (localContactCard == null) {
          break label221;
        }
        i = localContactCard.bAge;
        break label221;
        label713:
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        break label329;
        label725:
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (localContactCard != null)
        {
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCountry))
          {
            paramProfileCardInfo = (ProfileCardInfo)localObject;
            if (!"中国".equals(localContactCard.strCountry)) {
              paramProfileCardInfo = "" + localContactCard.strCountry;
            }
          }
          localObject = paramProfileCardInfo;
          if (!TextUtils.isEmpty(localContactCard.strProvince))
          {
            localObject = paramProfileCardInfo;
            if (!TextUtils.isEmpty(paramProfileCardInfo)) {
              localObject = paramProfileCardInfo + "，";
            }
            localObject = (String)localObject + localContactCard.strProvince;
          }
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCity))
          {
            paramProfileCardInfo = (ProfileCardInfo)localObject;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              paramProfileCardInfo = (String)localObject + "，";
            }
            paramProfileCardInfo = paramProfileCardInfo + localContactCard.strCity;
          }
        }
      }
      label933:
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      label943:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipProfileSimpleView
 * JD-Core Version:    0.7.0.1
 */