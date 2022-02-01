package com.tencent.mobileqq.profilecard.vas.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import java.util.HashMap;

public class VasProfilePhotoView
  extends AbsProfileHeaderView
{
  public VasProfilePhotoView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    this.mActivity = paramBaseActivity;
    this.mApp = paramBaseActivity.app;
    this.mCardInfo = paramProfileCardInfo;
  }
  
  private View initMainView(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131562188, this, true);
  }
  
  private void updateAvatarArea(ProfileCardInfo paramProfileCardInfo, Context paramContext, View paramView)
  {
    AvatarLayout localAvatarLayout = (AvatarLayout)paramView.findViewById(2131369058);
    localAvatarLayout.setVisibility(0);
    ProfileCardTemplate.a((ImageView)paramView.findViewById(2131369059), "src", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonFaceBackground");
    DataTag localDataTag = new DataTag(1, null);
    localAvatarLayout.setTag(localDataTag);
    localAvatarLayout.setOnClickListener(this.mOnClickListener);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (paramContext = paramContext.getString(2131691276);; paramContext = paramContext.getString(2131691275))
    {
      localAvatarLayout.setContentDescription(paramContext);
      localAvatarLayout.a(0, localAvatarLayout.findViewById(2131363511), false);
      this.mHeaderChildMap.put("map_key_face", localAvatarLayout);
      this.mHeaderChildMap.put("map_key_face_stoke", paramView.findViewById(2131369059));
      super.updateAvatar(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      paramContext = (ImageView)paramView.findViewById(2131368891);
      paramContext.setVisibility(4);
      paramContext.setOnClickListener(this.mOnClickListener);
      paramContext.setTag(localDataTag);
      this.mHeaderChildMap.put("map_key_avatar_pendant", paramContext);
      super.updateAvatarPendantImage(paramProfileCardInfo, true);
      return;
    }
  }
  
  private void updateBaseInfoArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131369065);
    ProfileCardTemplate.a(paramView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "photoAddressColor");
    this.mHeaderChildMap.put("map_key_sex_age_area", paramView);
    super.updateSexAgeArea(paramProfileCardInfo);
  }
  
  private void updateHeadArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    paramView = (ProfileNameView)paramView.findViewById(2131369073);
    ProfileCardTemplate.a(paramView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "photoNickNameColor");
    paramView.setVisibility(0);
    paramView.setClickable(true);
    paramView.setClickListener(this.mOnClickListener);
    this.mHeaderChildMap.put("map_key_profile_nick_name", paramView);
    super.updateHead(paramProfileCardInfo);
  }
  
  private void updateLikeArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    VoteView localVoteView = (VoteView)findViewById(2131381767);
    paramView = (HeartLayout)paramView.findViewById(2131368400);
    paramView.setEnabled(false);
    localVoteView.setHeartLayout(this.mApp, paramView);
    this.mHeaderChildMap.put("map_key_like", localVoteView);
    super.updateLike(paramProfileCardInfo);
  }
  
  private void updatePhotoWallArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    paramView = (QzonePhotoView)paramView.findViewById(2131375417);
    paramView.a(this.mActivity, paramProfileCardInfo);
    this.mHeaderChildMap.put("map_key_qzonecover", paramView);
    ProfileCardTemplate.a(paramView, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonMaskBackground");
  }
  
  private void updateTipsArea(View paramView)
  {
    paramView = (LinearLayout)paramView.findViewById(2131369104);
    this.mHeaderChildMap.put("map_key_tips", paramView);
  }
  
  public boolean intercept(View paramView, MotionEvent paramMotionEvent)
  {
    View localView = (View)this.mHeaderChildMap.get("map_key_qzonecover");
    if ((localView != null) && ((localView instanceof QzonePhotoView))) {
      return ((QzonePhotoView)localView).intercept(paramView, paramMotionEvent);
    }
    return super.intercept(paramView, paramMotionEvent);
  }
  
  public void onInit(ProfileCardInfo paramProfileCardInfo)
  {
    Context localContext = getContext();
    View localView = initMainView(localContext);
    updateAvatarArea(paramProfileCardInfo, localContext, localView);
    updateHeadArea(paramProfileCardInfo, localView);
    updateBaseInfoArea(paramProfileCardInfo, localView);
    updateLikeArea(paramProfileCardInfo, localView);
    updatePhotoWallArea(paramProfileCardInfo, localView);
    updateTipsArea(localView);
    super.onInit(paramProfileCardInfo);
    super.updateJueban(paramProfileCardInfo);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mCardInfo != null) {
      super.updateAvatarPendantImage(this.mCardInfo, false);
    }
  }
  
  public void onUpdate(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.updateLike(paramProfileCardInfo);
    super.updateHead(paramProfileCardInfo);
    super.updateSexAgeArea(paramProfileCardInfo);
    super.updateAvatarPendantImage(paramProfileCardInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfilePhotoView
 * JD-Core Version:    0.7.0.1
 */