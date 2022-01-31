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
import awki;
import awmk;
import awmr;
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
  
  public ProfilePhotoView(BaseActivity paramBaseActivity, awmk paramawmk)
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
  }
  
  public void a(awmk paramawmk)
  {
    Object localObject1 = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject1).inflate(2131561813, this, true);
    Object localObject2 = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367602);
    localObject2 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368239);
    getResources().getDisplayMetrics();
    int i = getResources().getDimensionPixelSize(2131297094);
    int j = getResources().getDimensionPixelSize(2131297098);
    this.e = (this.jdField_b_of_type_Float - (i + j * 3));
    this.d = (70.0F * this.jdField_a_of_type_Float);
    this.f = (this.jdField_b_of_type_Float - 103.0F * this.jdField_a_of_type_Float - j * 2);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368231));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368232));
    awmr.a(this.jdField_b_of_type_AndroidWidgetImageView, "src", paramawmk.jdField_a_of_type_Awmr, "commonFaceBackground");
    localObject2 = new awki(1, null);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setTag(localObject2);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(paramawmk.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (localObject1 = ((Context)localObject1).getString(2131691238);; localObject1 = ((Context)localObject1).getString(2131691237))
    {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setContentDescription((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363115), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131368232));
      super.a(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368067));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramawmk.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_a_of_type_AndroidWidgetImageView);
      super.b(paramawmk, true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368249));
      awmr.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView, "color", paramawmk.jdField_a_of_type_Awmr, "photoNickNameColor");
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      super.f(paramawmk);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368240));
      awmr.a(this.jdField_a_of_type_AndroidWidgetTextView, "color", paramawmk.jdField_a_of_type_Awmr, "photoAddressColor");
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", this.jdField_a_of_type_AndroidWidgetTextView);
      super.b(paramawmk);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)findViewById(2131380029));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367623));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView);
      super.e(paramawmk);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personal_like_tip", this.jdField_a_of_type_AndroidViewView.findViewById(2131371714));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView = ((QzonePhotoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374118));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramawmk);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView);
      awmr.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView, "background", paramawmk.jdField_a_of_type_Awmr, "commonMaskBackground");
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368297));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_a_of_type_AndroidWidgetLinearLayout);
      super.a(paramawmk);
      super.g(paramawmk);
      return;
    }
  }
  
  public void a(awmk paramawmk, boolean paramBoolean)
  {
    super.e(paramawmk);
    super.f(paramawmk);
    super.b(paramawmk);
    super.c(paramawmk);
    super.b(paramawmk, false);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a(paramView, paramMotionEvent);
  }
  
  public void d(awmk paramawmk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("commonFaceBackground", "drawable");
    localHashMap.put("photoNickNameColor", "color");
    localHashMap.put("photoAddressColor", "color");
    localHashMap.put("photoAddSrc", "drawable");
    super.a(paramawmk, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfilePhotoView
 * JD-Core Version:    0.7.0.1
 */