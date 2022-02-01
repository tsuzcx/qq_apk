package com.tencent.mobileqq.profilecard.vas.view;

import android.content.Context;
import android.view.LayoutInflater;
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
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

public class VasProfileGameView
  extends AbsProfileHeaderView
{
  public VasProfileGameView(BaseActivity paramBaseActivity, azrb paramazrb)
  {
    super(paramBaseActivity, paramazrb);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Azrb = paramazrb;
  }
  
  @NotNull
  private View a(azrb paramazrb, Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131562043, this, true);
    azri.a((LinearLayout)paramContext.findViewById(2131368832), "background", paramazrb.jdField_a_of_type_Azri, "gameHeadInfoBackground");
    return paramContext;
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
    VoteView localVoteView = (VoteView)paramView.findViewById(2131381304);
    paramView = (HeartLayout)paramView.findViewById(2131368178);
    paramView.setEnabled(false);
    localVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", localVoteView);
    super.h(paramazrb);
  }
  
  private void b(azrb paramazrb, View paramView)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131368871);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sign_common_topic", localLinearLayout);
    paramView = (TextView)paramView.findViewById(2131368870);
    azri.a(paramView, "color", paramazrb.jdField_a_of_type_Azri, "gameSignColor");
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sign", paramView);
    f(paramazrb);
  }
  
  private void c(azrb paramazrb, View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131368833);
    azri.a(paramView, "color", paramazrb.jdField_a_of_type_Azri, "gameAddressColor");
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", paramView);
    super.d(paramazrb);
  }
  
  private void d(azrb paramazrb, View paramView)
  {
    paramView = (ProfileNameView)paramView.findViewById(2131368841);
    azri.a(paramView, "color", paramazrb.jdField_a_of_type_Azri, "gameNickNameColor");
    paramView.setVisibility(0);
    paramView.setClickable(true);
    paramView.setClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", paramView);
    super.c(paramazrb);
  }
  
  public void a(azrb paramazrb)
  {
    Context localContext = getContext();
    View localView = a(paramazrb, localContext);
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
    f(paramazrb);
    super.b(paramazrb, false);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Azrb != null) {
      super.b(this.jdField_a_of_type_Azrb, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileGameView
 * JD-Core Version:    0.7.0.1
 */