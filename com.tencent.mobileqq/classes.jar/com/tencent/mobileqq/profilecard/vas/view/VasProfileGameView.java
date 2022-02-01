package com.tencent.mobileqq.profilecard.vas.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aykg;
import aymg;
import aymn;
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
  public VasProfileGameView(BaseActivity paramBaseActivity, aymg paramaymg)
  {
    super(paramBaseActivity, paramaymg);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Aymg = paramaymg;
  }
  
  @NotNull
  private View a(aymg paramaymg, Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131561978, this, true);
    aymn.a((LinearLayout)paramContext.findViewById(2131368673), "background", paramaymg.jdField_a_of_type_Aymn, "gameHeadInfoBackground");
    return paramContext;
  }
  
  private void a(View paramView)
  {
    paramView = (LinearLayout)paramView.findViewById(2131368713);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", paramView);
  }
  
  private void a(aymg paramaymg, Context paramContext, View paramView)
  {
    AvatarLayout localAvatarLayout = (AvatarLayout)paramView.findViewById(2131368667);
    localAvatarLayout.setVisibility(0);
    aymn.a((ImageView)paramView.findViewById(2131368668), "src", paramaymg.jdField_a_of_type_Aymn, "commonFaceBackground");
    aykg localaykg = new aykg(1, null);
    localAvatarLayout.setTag(localaykg);
    localAvatarLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
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
    VoteView localVoteView = (VoteView)paramView.findViewById(2131380952);
    paramView = (HeartLayout)paramView.findViewById(2131368043);
    paramView.setEnabled(false);
    localVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", localVoteView);
    super.g(paramaymg);
  }
  
  private void b(aymg paramaymg, View paramView)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131368712);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sign_common_topic", localLinearLayout);
    paramView = (TextView)paramView.findViewById(2131368711);
    aymn.a(paramView, "color", paramaymg.jdField_a_of_type_Aymn, "gameSignColor");
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sign", paramView);
    e(paramaymg);
  }
  
  private void c(aymg paramaymg, View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131368674);
    aymn.a(paramView, "color", paramaymg.jdField_a_of_type_Aymn, "gameAddressColor");
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", paramView);
    super.d(paramaymg);
  }
  
  private void d(aymg paramaymg, View paramView)
  {
    paramView = (ProfileNameView)paramView.findViewById(2131368682);
    aymn.a(paramView, "color", paramaymg.jdField_a_of_type_Aymn, "gameNickNameColor");
    paramView.setVisibility(0);
    paramView.setClickable(true);
    paramView.setClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", paramView);
    super.c(paramaymg);
  }
  
  public void a(aymg paramaymg)
  {
    Context localContext = getContext();
    View localView = a(paramaymg, localContext);
    a(paramaymg, localContext, localView);
    d(paramaymg, localView);
    c(paramaymg, localView);
    b(paramaymg, localView);
    a(paramaymg, localView);
    a(localView);
    super.a(paramaymg);
    super.b(paramaymg);
  }
  
  public void a(aymg paramaymg, boolean paramBoolean)
  {
    super.g(paramaymg);
    super.c(paramaymg);
    super.d(paramaymg);
    e(paramaymg);
    super.b(paramaymg, false);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Aymg != null) {
      super.b(this.jdField_a_of_type_Aymg, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileGameView
 * JD-Core Version:    0.7.0.1
 */