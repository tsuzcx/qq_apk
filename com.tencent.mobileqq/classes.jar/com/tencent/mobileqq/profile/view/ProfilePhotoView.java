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
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ProfilePhotoView
  extends ProfileHeaderView
{
  private float jdField_a_of_type_Float;
  View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public TextView a;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  public QzonePhotoView a;
  private VoteView jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
  private TextView b;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ImageView d;
  private float e;
  private float f;
  
  public ProfilePhotoView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
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
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject1).inflate(2130970959, this, true);
    Object localObject2 = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370866);
    localObject2 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372364);
    getResources().getDisplayMetrics();
    int i = getResources().getDimensionPixelSize(2131558565);
    int j = getResources().getDimensionPixelSize(2131558575);
    this.e = (this.jdField_c_of_type_Float - (i + j * 3));
    this.jdField_a_of_type_Float = (70.0F * this.jdField_b_of_type_Float);
    this.f = (this.jdField_c_of_type_Float - 103.0F * this.jdField_b_of_type_Float - j * 2);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369034));
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.d = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370868));
    ProfileCardTemplate.a(this.d, "src", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonFaceBackground");
    localObject2 = new DataTag(1, null);
    this.jdField_c_of_type_AndroidWidgetImageView.setTag(localObject2);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (localObject1 = ((Context)localObject1).getString(2131427397);; localObject1 = ((Context)localObject1).getString(2131427396))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_c_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131370868));
      super.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364641));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_a_of_type_AndroidWidgetImageView);
      super.c(paramProfileCardInfo, true);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370146));
      ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "photoNickNameColor");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_b_of_type_AndroidWidgetTextView);
      super.i(paramProfileCardInfo);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372366));
      ProfileCardTemplate.a(this.jdField_c_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "photoAddressColor");
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", this.jdField_c_of_type_AndroidWidgetTextView);
      super.c(paramProfileCardInfo);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)findViewById(2131370395));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370566));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView);
      super.g(paramProfileCardInfo);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personal_like_tip", this.jdField_a_of_type_AndroidViewView.findViewById(2131372362));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372367));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tag_jueban", this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView = ((QzonePhotoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372377));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramProfileCardInfo);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView);
      ProfileCardTemplate.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonMaskBackground");
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372363));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_a_of_type_AndroidWidgetLinearLayout);
      localObject1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372353);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_num", localObject1);
      ((TextView)localObject1).setOnClickListener(this);
      localObject1 = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewView.findViewById(2131372350)).a(53).a(true).c(1).e(10).a();
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_increment", localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_container", this.jdField_a_of_type_AndroidViewView.findViewById(2131372350));
      d(paramProfileCardInfo);
      super.a(paramProfileCardInfo);
      super.h(paramProfileCardInfo);
      return;
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.g(paramProfileCardInfo);
    super.i(paramProfileCardInfo);
    super.c(paramProfileCardInfo);
    super.e(paramProfileCardInfo);
    super.c(paramProfileCardInfo, false);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a(paramView, paramMotionEvent);
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("commonFaceBackground", "drawable");
    localHashMap.put("photoNickNameColor", "color");
    localHashMap.put("photoAddressColor", "color");
    localHashMap.put("photoAddSrc", "drawable");
    super.a(paramProfileCardInfo, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfilePhotoView
 * JD-Core Version:    0.7.0.1
 */