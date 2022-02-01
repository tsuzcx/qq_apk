package com.tencent.mobileqq.profilecard.vas.view;

import amtj;
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
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aykg;
import aymg;
import aymn;
import ayue;
import ayyt;
import ayyu;
import bfrj;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.view.VipPhotoViewForSimple;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;

public class VasProfileSimpleView
  extends AbsProfileHeaderView
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int = -1;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private float jdField_d_of_type_Float;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  
  public VasProfileSimpleView(BaseActivity paramBaseActivity, aymg paramaymg)
  {
    super(paramBaseActivity, paramaymg);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Aymg = paramaymg;
  }
  
  private View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131561990, this, true);
  }
  
  private void a(View paramView)
  {
    this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131297076);
    this.jdField_c_of_type_Int = bfrj.a(getResources());
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368665);
    paramView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
      paramView.height = ((int)this.jdField_c_of_type_Float - bfrj.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 129) - bfrj.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18) - this.jdField_b_of_type_Int - this.jdField_c_of_type_Int);
    }
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      paramView.height += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) && (((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).e)) {
      paramView.height = ((int)(paramView.height - this.jdField_c_of_type_Float / 2.0F));
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + paramView.height);
    }
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramView);
    this.jdField_a_of_type_AndroidViewView.setFocusable(true);
    this.jdField_a_of_type_AndroidViewView.setFocusableInTouchMode(true);
  }
  
  private void a(aymg paramaymg, Context paramContext, View paramView)
  {
    AvatarLayout localAvatarLayout = (AvatarLayout)paramView.findViewById(2131368667);
    localAvatarLayout.setVisibility(0);
    aymn.a((ImageView)paramView.findViewById(2131368668), "src", paramaymg.jdField_a_of_type_Aymn, "commonFaceBackground");
    aykg localaykg = new aykg(1, null);
    localAvatarLayout.setTag(localaykg);
    localAvatarLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (paramContext = paramContext.getString(2131691084);; paramContext = paramContext.getString(2131691083))
    {
      localAvatarLayout.setContentDescription(paramContext);
      localAvatarLayout.a(0, localAvatarLayout.findViewById(2131363357), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", localAvatarLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", paramView.findViewById(2131368668));
      super.a(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      paramContext = (ImageView)paramView.findViewById(2131368501);
      paramContext.setVisibility(4);
      paramContext.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramContext.setTag(localaykg);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", paramContext);
      super.b(paramaymg, true);
      return;
    }
  }
  
  private void a(aymg paramaymg, View paramView)
  {
    paramView = (VipPhotoViewForSimple)paramView.findViewById(2131374798);
    paramView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramaymg);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", paramView);
    aymn.a(paramView, "background", paramaymg.jdField_a_of_type_Aymn, "commonMaskBackground");
  }
  
  private void a(aymg paramaymg, ContactCard paramContactCard)
  {
    Object localObject2 = "";
    Card localCard = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard;
    Object localObject1;
    if (localCard != null)
    {
      paramContactCard = (ContactCard)localObject2;
      if (!TextUtils.isEmpty(localCard.strCountry))
      {
        paramContactCard = (ContactCard)localObject2;
        if (!amtj.a(2131715785).equals(localCard.strCountry)) {
          paramContactCard = "" + localCard.strCountry;
        }
      }
      localObject2 = paramContactCard;
      if (!TextUtils.isEmpty(localCard.strProvince))
      {
        localObject1 = paramContactCard;
        if (!TextUtils.isEmpty(paramContactCard)) {
          localObject1 = paramContactCard + "，";
        }
        localObject2 = (String)localObject1 + localCard.strProvince;
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(localCard.strCity))
      {
        paramContactCard = (ContactCard)localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramContactCard = (String)localObject2 + "，";
        }
        localObject1 = paramContactCard + localCard.strCity;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea place=" + (String)localObject1);
      }
      if (!ayue.a(41614, paramaymg)) {
        localObject1 = "";
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject1);
      return;
      localObject1 = localObject2;
      if (paramContactCard != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramContactCard.strCountry))
        {
          localObject1 = localObject2;
          if (!amtj.a(2131715784).equals(paramContactCard.strCountry)) {
            localObject1 = "" + paramContactCard.strCountry;
          }
        }
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(paramContactCard.strProvince))
        {
          localObject2 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = (String)localObject1 + "，";
          }
          localObject2 = (String)localObject2 + paramContactCard.strProvince;
        }
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramContactCard.strCity))
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = (String)localObject2 + "，";
          }
          localObject1 = (String)localObject1 + paramContactCard.strCity;
        }
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372987));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372988));
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(new aykg(73, this.jdField_d_of_type_AndroidWidgetTextView));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void b(aymg paramaymg, View paramView)
  {
    VoteView localVoteView = (VoteView)paramView.findViewById(2131380952);
    paramView = (HeartLayout)paramView.findViewById(2131368043);
    paramView.setEnabled(false);
    localVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", localVoteView);
    super.g(paramaymg);
  }
  
  private void c(View paramView)
  {
    paramView = (LinearLayout)paramView.findViewById(2131368713);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", paramView);
  }
  
  private void c(aymg paramaymg, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368677));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368675));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368676));
    aymn.a(this.jdField_a_of_type_AndroidWidgetTextView, "color", paramaymg.jdField_a_of_type_Aymn, "simpleAddressColor");
    aymn.a(this.jdField_c_of_type_AndroidWidgetTextView, "color", paramaymg.jdField_a_of_type_Aymn, "simpleAddressColor");
    aymn.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramaymg.jdField_a_of_type_Aymn, "simpleAddressColor");
    aymn.a(this.jdField_a_of_type_AndroidWidgetTextView, "background", paramaymg.jdField_a_of_type_Aymn, "simpleAddressBackground");
    aymn.a(this.jdField_c_of_type_AndroidWidgetTextView, "background", paramaymg.jdField_a_of_type_Aymn, "simpleAddressBackground");
    aymn.a(this.jdField_b_of_type_AndroidWidgetTextView, "background", paramaymg.jdField_a_of_type_Aymn, "simpleAddressBackground");
    k(paramaymg);
  }
  
  private void d(aymg paramaymg, View paramView)
  {
    paramView = (ProfileNameView)paramView.findViewById(2131368682);
    aymn.a(paramView, "color", paramaymg.jdField_a_of_type_Aymn, "simpleNickNameColor");
    paramView.setVisibility(0);
    paramView.setClickable(true);
    paramView.setClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", paramView);
    super.c(paramaymg);
  }
  
  private void l(aymg paramaymg)
  {
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, 0.0F, 0, -100.0F);
    localTranslateAnimation1.setDuration(500L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, -100.0F, 0, 0.0F);
    localTranslateAnimation2.setDuration(500L);
    localTranslateAnimation2.setAnimationListener(new ayyt(this, paramaymg));
    localTranslateAnimation1.setAnimationListener(new ayyu(this, localTranslateAnimation2));
    startAnimation(localTranslateAnimation1);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
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
      localLayoutParams.addRule(8, 2131368722);
      localLayoutParams.bottomMargin = paramInt;
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard", 2, "onApolloExpand h:" + paramInt);
      }
    }
  }
  
  @TargetApi(9)
  public void a(aymg paramaymg)
  {
    this.jdField_d_of_type_Float = this.jdField_c_of_type_Float;
    Context localContext = getContext();
    View localView = a(localContext);
    b(localView);
    a(localView);
    a(paramaymg, localContext, localView);
    d(paramaymg, localView);
    c(paramaymg, localView);
    b(paramaymg, localView);
    a(paramaymg, localView);
    c(localView);
    super.a(paramaymg);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) && (((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).e))
    {
      this.jdField_a_of_type_Boolean = true;
      b(paramaymg);
      return;
    }
    l(paramaymg);
  }
  
  public void a(aymg paramaymg, boolean paramBoolean)
  {
    super.g(paramaymg);
    super.c(paramaymg);
    k(paramaymg);
    super.b(paramaymg, false);
    j(paramaymg);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Aymg != null) {
      super.b(this.jdField_a_of_type_Aymg, false);
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      localLayoutParams.addRule(3, 2131368043);
      localLayoutParams.addRule(8, 0);
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
    }
  }
  
  public void e()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = ((int)this.jdField_c_of_type_Float - bfrj.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 129) - bfrj.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18) - this.jdField_b_of_type_Int - this.jdField_c_of_type_Int);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      localLayoutParams.height += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + localLayoutParams.height);
    }
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public boolean intercept(View paramView, MotionEvent paramMotionEvent)
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long > 1000L) {}
    for (int i = 1; (i == 0) && (!this.jdField_a_of_type_Boolean); i = 0) {
      return true;
    }
    return super.intercept(paramView, paramMotionEvent);
  }
  
  @TargetApi(9)
  void j(aymg paramaymg)
  {
    if (!paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    do
    {
      return;
      if ((paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.cardType != 2) && (paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId != 1600L)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramaymg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("vip_profile_diy_card", 0);
    } while (paramaymg.getBoolean("vip_diy_card_edit_hint", false));
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    paramaymg.edit().putBoolean("vip_diy_card_edit_hint", true).apply();
    return;
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void k(aymg paramaymg)
  {
    int j = -1;
    if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      paramaymg = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698452);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, 10, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramaymg);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(paramaymg);
      return;
    }
    Object localObject = "";
    Card localCard = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard;
    ContactCard localContactCard = paramaymg.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    int i;
    if ((paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 0) || (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 1)) {
      i = paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte;
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693568);
        label141:
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea sex=" + (String)localObject);
        }
        if (!ayue.a(41611, paramaymg)) {
          localObject = "";
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label455;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
        label222:
        String str = "";
        if (localCard == null) {
          break label467;
        }
        i = localCard.age;
        label237:
        localObject = str;
        if (i > 0)
        {
          localObject = str;
          if (!bfrj.b()) {
            localObject = i + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718743);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea age=" + (String)localObject);
        }
        if (!ayue.a(41610, paramaymg)) {
          localObject = "";
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label483;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
      }
      for (;;)
      {
        a(paramaymg, localContactCard);
        return;
        if ((localCard != null) && ((localCard.shGender == 0) || (localCard.shGender == 1)))
        {
          i = localCard.shGender;
          break;
        }
        if ((localContactCard == null) || ((localContactCard.bSex != 0) && (localContactCard.bSex != 1))) {
          break label495;
        }
        i = localContactCard.bSex;
        break;
        if (i != 1) {
          break label141;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692108);
        break label141;
        label455:
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label222;
        label467:
        i = j;
        if (localContactCard == null) {
          break label237;
        }
        i = localContactCard.bAge;
        break label237;
        label483:
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      label495:
      i = -1;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_d_of_type_Float != this.jdField_c_of_type_Float)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramConfiguration.height = ((int)(paramConfiguration.height + (this.jdField_c_of_type_Float - this.jdField_d_of_type_Float)));
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramConfiguration);
      this.jdField_d_of_type_Float = this.jdField_c_of_type_Float;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileSimpleView
 * JD-Core Version:    0.7.0.1
 */