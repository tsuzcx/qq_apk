package com.tencent.mobileqq.profilecard.vas.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import azpb;
import azrb;
import azri;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import java.util.HashMap;

public class VasProfilePhotoView
  extends AbsProfileHeaderView
{
  public VasProfilePhotoView(BaseActivity paramBaseActivity, azrb paramazrb)
  {
    super(paramBaseActivity, paramazrb);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Azrb = paramazrb;
  }
  
  private View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131562050, this, true);
  }
  
  private void a(View paramView)
  {
    paramView = (LinearLayout)paramView.findViewById(2131368872);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", paramView);
  }
  
  private void a(azrb paramazrb, Context paramContext, View paramView)
  {
    AvatarLayout localAvatarLayout = (AvatarLayout)paramView.findViewById(2131368826);
    localAvatarLayout.setVisibility(0);
    azri.a((ImageView)paramView.findViewById(2131368827), "src", paramazrb.jdField_a_of_type_Azri, "commonFaceBackground");
    azpb localazpb = new azpb(1, null);
    localAvatarLayout.setTag(localazpb);
    localAvatarLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (paramContext = paramContext.getString(2131691169);; paramContext = paramContext.getString(2131691168))
    {
      localAvatarLayout.setContentDescription(paramContext);
      localAvatarLayout.a(0, localAvatarLayout.findViewById(2131363426), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", localAvatarLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", paramView.findViewById(2131368827));
      super.a(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      paramContext = (ImageView)paramView.findViewById(2131368659);
      paramContext.setVisibility(4);
      paramContext.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramContext.setTag(localazpb);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", paramContext);
      super.b(paramazrb, true);
      return;
    }
  }
  
  private void a(azrb paramazrb, View paramView)
  {
    paramView = (QzonePhotoView)paramView.findViewById(2131375039);
    paramView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramazrb);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", paramView);
    azri.a(paramView, "background", paramazrb.jdField_a_of_type_Azri, "commonMaskBackground");
  }
  
  private void b(azrb paramazrb, View paramView)
  {
    VoteView localVoteView = (VoteView)findViewById(2131381304);
    paramView = (HeartLayout)paramView.findViewById(2131368178);
    paramView.setEnabled(false);
    localVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", localVoteView);
    super.h(paramazrb);
  }
  
  private void c(azrb paramazrb, View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131368833);
    azri.a(paramView, "color", paramazrb.jdField_a_of_type_Azri, "photoAddressColor");
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", paramView);
    super.d(paramazrb);
  }
  
  private void d(azrb paramazrb, View paramView)
  {
    paramView = (ProfileNameView)paramView.findViewById(2131368841);
    azri.a(paramView, "color", paramazrb.jdField_a_of_type_Azri, "photoNickNameColor");
    paramView.setVisibility(0);
    paramView.setClickable(true);
    paramView.setClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", paramView);
    super.c(paramazrb);
  }
  
  public void a(azrb paramazrb)
  {
    Context localContext = getContext();
    View localView = a(localContext);
    a(paramazrb, localContext, localView);
    d(paramazrb, localView);
    c(paramazrb, localView);
    b(paramazrb, localView);
    a(paramazrb, localView);
    a(localView);
    super.a(paramazrb);
    super.b(paramazrb);
  }
  
  public void a(azrb paramazrb, boolean paramBoolean)
  {
    super.h(paramazrb);
    super.c(paramazrb);
    super.d(paramazrb);
    super.b(paramazrb, false);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Azrb != null) {
      super.b(this.jdField_a_of_type_Azrb, false);
    }
  }
  
  public boolean intercept(View paramView, MotionEvent paramMotionEvent)
  {
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localView != null) && ((localView instanceof QzonePhotoView))) {
      return ((QzonePhotoView)localView).intercept(paramView, paramMotionEvent);
    }
    return super.intercept(paramView, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfilePhotoView
 * JD-Core Version:    0.7.0.1
 */