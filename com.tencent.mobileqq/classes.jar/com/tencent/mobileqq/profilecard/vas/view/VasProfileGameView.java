package com.tencent.mobileqq.profilecard.vas.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import azvr;
import azxr;
import azxy;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

public class VasProfileGameView
  extends AbsProfileHeaderView
{
  public VasProfileGameView(BaseActivity paramBaseActivity, azxr paramazxr)
  {
    super(paramBaseActivity, paramazxr);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Azxr = paramazxr;
  }
  
  @NotNull
  private View a(azxr paramazxr, Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131562103, this, true);
    azxy.a((LinearLayout)paramContext.findViewById(2131368649), "background", paramazxr.jdField_a_of_type_Azxy, "gameHeadInfoBackground");
    return paramContext;
  }
  
  private void a(View paramView)
  {
    paramView = (LinearLayout)paramView.findViewById(2131368689);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", paramView);
  }
  
  private void a(azxr paramazxr, Context paramContext, View paramView)
  {
    AvatarLayout localAvatarLayout = (AvatarLayout)paramView.findViewById(2131368643);
    localAvatarLayout.setVisibility(0);
    azxy.a((ImageView)paramView.findViewById(2131368644), "src", paramazxr.jdField_a_of_type_Azxy, "commonFaceBackground");
    azvr localazvr = new azvr(1, null);
    localAvatarLayout.setTag(localazvr);
    localAvatarLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (paramContext = paramContext.getString(2131691044);; paramContext = paramContext.getString(2131691043))
    {
      localAvatarLayout.setContentDescription(paramContext);
      localAvatarLayout.a(0, localAvatarLayout.findViewById(2131363327), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", localAvatarLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", paramView.findViewById(2131368644));
      super.a(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      paramContext = (ImageView)paramView.findViewById(2131368476);
      paramContext.setVisibility(4);
      paramContext.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramContext.setTag(localazvr);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", paramContext);
      super.b(paramazxr, true);
      return;
    }
  }
  
  private void a(azxr paramazxr, View paramView)
  {
    VoteView localVoteView = (VoteView)paramView.findViewById(2131381230);
    paramView = (HeartLayout)paramView.findViewById(2131368010);
    paramView.setEnabled(false);
    localVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", localVoteView);
    super.g(paramazxr);
  }
  
  private void b(azxr paramazxr, View paramView)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131368688);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sign_common_topic", localLinearLayout);
    paramView = (TextView)paramView.findViewById(2131368687);
    azxy.a(paramView, "color", paramazxr.jdField_a_of_type_Azxy, "gameSignColor");
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sign", paramView);
    e(paramazxr);
  }
  
  private void c(azxr paramazxr, View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131368650);
    azxy.a(paramView, "color", paramazxr.jdField_a_of_type_Azxy, "gameAddressColor");
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", paramView);
    super.d(paramazxr);
  }
  
  private void d(azxr paramazxr, View paramView)
  {
    paramView = (ProfileNameView)paramView.findViewById(2131368658);
    azxy.a(paramView, "color", paramazxr.jdField_a_of_type_Azxy, "gameNickNameColor");
    paramView.setVisibility(0);
    paramView.setClickable(true);
    paramView.setClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", paramView);
    super.c(paramazxr);
  }
  
  public void a(azxr paramazxr)
  {
    Context localContext = getContext();
    View localView = a(paramazxr, localContext);
    a(paramazxr, localContext, localView);
    d(paramazxr, localView);
    c(paramazxr, localView);
    b(paramazxr, localView);
    a(paramazxr, localView);
    a(localView);
    super.a(paramazxr);
    super.b(paramazxr);
  }
  
  public void a(azxr paramazxr, boolean paramBoolean)
  {
    super.g(paramazxr);
    super.c(paramazxr);
    super.d(paramazxr);
    e(paramazxr);
    super.b(paramazxr, false);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Azxr != null) {
      super.b(this.jdField_a_of_type_Azxr, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileGameView
 * JD-Core Version:    0.7.0.1
 */