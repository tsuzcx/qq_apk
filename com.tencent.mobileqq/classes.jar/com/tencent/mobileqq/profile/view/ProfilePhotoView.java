package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import atuw;
import atwx;
import atxe;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ProfilePhotoView
  extends ProfileHeaderView
{
  View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  public QzonePhotoView a;
  private AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  private ProfileNameView jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
  private VoteView jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
  private ImageView b;
  private float d;
  private float e;
  private float f;
  
  public ProfilePhotoView(BaseActivity paramBaseActivity, atwx paramatwx)
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
  }
  
  public void a(atwx paramatwx)
  {
    Object localObject1 = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject1).inflate(2131496031, this, true);
    Object localObject2 = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131301862);
    localObject2 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131302481);
    getResources().getDisplayMetrics();
    int i = getResources().getDimensionPixelSize(2131166002);
    int j = getResources().getDimensionPixelSize(2131166006);
    this.e = (this.jdField_b_of_type_Float - (i + j * 3));
    this.d = (70.0F * this.jdField_a_of_type_Float);
    this.f = (this.jdField_b_of_type_Float - 103.0F * this.jdField_a_of_type_Float - j * 2);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131302473));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302474));
    atxe.a(this.jdField_b_of_type_AndroidWidgetImageView, "src", paramatwx.jdField_a_of_type_Atxe, "commonFaceBackground");
    localObject2 = new atuw(1, null);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setTag(localObject2);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (localObject1 = ((Context)localObject1).getString(2131625610);; localObject1 = ((Context)localObject1).getString(2131625609))
    {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setContentDescription((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131297539), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131302474));
      super.a(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302311));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_a_of_type_AndroidWidgetImageView);
      super.b(paramatwx, true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302491));
      atxe.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView, "color", paramatwx.jdField_a_of_type_Atxe, "photoNickNameColor");
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      super.f(paramatwx);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302482));
      atxe.a(this.jdField_a_of_type_AndroidWidgetTextView, "color", paramatwx.jdField_a_of_type_Atxe, "photoAddressColor");
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", this.jdField_a_of_type_AndroidWidgetTextView);
      super.b(paramatwx);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)findViewById(2131313488));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131301878));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView);
      super.e(paramatwx);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personal_like_tip", this.jdField_a_of_type_AndroidViewView.findViewById(2131305702));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView = ((QzonePhotoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131307947));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramatwx);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView);
      atxe.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView, "background", paramatwx.jdField_a_of_type_Atxe, "commonMaskBackground");
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131302531));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_a_of_type_AndroidWidgetLinearLayout);
      super.a(paramatwx);
      super.g(paramatwx);
      return;
    }
  }
  
  public void a(atwx paramatwx, boolean paramBoolean)
  {
    super.e(paramatwx);
    super.f(paramatwx);
    super.b(paramatwx);
    super.c(paramatwx);
    super.b(paramatwx, false);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a(paramView, paramMotionEvent);
  }
  
  public void d(atwx paramatwx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("commonFaceBackground", "drawable");
    localHashMap.put("photoNickNameColor", "color");
    localHashMap.put("photoAddressColor", "color");
    localHashMap.put("photoAddSrc", "drawable");
    super.a(paramatwx, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfilePhotoView
 * JD-Core Version:    0.7.0.1
 */