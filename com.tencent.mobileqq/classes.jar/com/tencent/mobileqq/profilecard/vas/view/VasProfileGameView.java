package com.tencent.mobileqq.profilecard.vas.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import azde;
import azfe;
import azfl;
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
  public VasProfileGameView(BaseActivity paramBaseActivity, azfe paramazfe)
  {
    super(paramBaseActivity, paramazfe);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Azfe = paramazfe;
  }
  
  @NotNull
  private View a(azfe paramazfe, Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131562063, this, true);
    azfl.a((LinearLayout)paramContext.findViewById(2131368576), "background", paramazfe.jdField_a_of_type_Azfl, "gameHeadInfoBackground");
    return paramContext;
  }
  
  private void a(View paramView)
  {
    paramView = (LinearLayout)paramView.findViewById(2131368616);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", paramView);
  }
  
  private void a(azfe paramazfe, Context paramContext, View paramView)
  {
    AvatarLayout localAvatarLayout = (AvatarLayout)paramView.findViewById(2131368570);
    localAvatarLayout.setVisibility(0);
    azfl.a((ImageView)paramView.findViewById(2131368571), "src", paramazfe.jdField_a_of_type_Azfl, "commonFaceBackground");
    azde localazde = new azde(1, null);
    localAvatarLayout.setTag(localazde);
    localAvatarLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (paramContext = paramContext.getString(2131691044);; paramContext = paramContext.getString(2131691043))
    {
      localAvatarLayout.setContentDescription(paramContext);
      localAvatarLayout.a(0, localAvatarLayout.findViewById(2131363303), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", localAvatarLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", paramView.findViewById(2131368571));
      super.a(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      paramContext = (ImageView)paramView.findViewById(2131368403);
      paramContext.setVisibility(4);
      paramContext.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramContext.setTag(localazde);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", paramContext);
      super.b(paramazfe, true);
      return;
    }
  }
  
  private void a(azfe paramazfe, View paramView)
  {
    VoteView localVoteView = (VoteView)paramView.findViewById(2131381048);
    paramView = (HeartLayout)paramView.findViewById(2131367940);
    paramView.setEnabled(false);
    localVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", localVoteView);
    super.g(paramazfe);
  }
  
  private void b(azfe paramazfe, View paramView)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131368615);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sign_common_topic", localLinearLayout);
    paramView = (TextView)paramView.findViewById(2131368614);
    azfl.a(paramView, "color", paramazfe.jdField_a_of_type_Azfl, "gameSignColor");
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sign", paramView);
    e(paramazfe);
  }
  
  private void c(azfe paramazfe, View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131368577);
    azfl.a(paramView, "color", paramazfe.jdField_a_of_type_Azfl, "gameAddressColor");
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", paramView);
    super.d(paramazfe);
  }
  
  private void d(azfe paramazfe, View paramView)
  {
    paramView = (ProfileNameView)paramView.findViewById(2131368585);
    azfl.a(paramView, "color", paramazfe.jdField_a_of_type_Azfl, "gameNickNameColor");
    paramView.setVisibility(0);
    paramView.setClickable(true);
    paramView.setClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", paramView);
    super.c(paramazfe);
  }
  
  public void a(azfe paramazfe)
  {
    Context localContext = getContext();
    View localView = a(paramazfe, localContext);
    a(paramazfe, localContext, localView);
    d(paramazfe, localView);
    c(paramazfe, localView);
    b(paramazfe, localView);
    a(paramazfe, localView);
    a(localView);
    super.a(paramazfe);
    super.b(paramazfe);
  }
  
  public void a(azfe paramazfe, boolean paramBoolean)
  {
    super.g(paramazfe);
    super.c(paramazfe);
    super.d(paramazfe);
    e(paramazfe);
    super.b(paramazfe, false);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Azfe != null) {
      super.b(this.jdField_a_of_type_Azfe, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileGameView
 * JD-Core Version:    0.7.0.1
 */