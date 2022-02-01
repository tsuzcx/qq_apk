package com.tencent.mobileqq.profilecard.vas.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import java.util.HashMap;

public class VasProfilePhotoView
  extends AbsProfileHeaderView
{
  public VasProfilePhotoView(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramQBaseActivity, paramProfileCardInfo);
  }
  
  private View initMainView(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131562025, this, true);
  }
  
  private void updateAvatarArea(ProfileCardInfo paramProfileCardInfo, Context paramContext, View paramView)
  {
    AvatarLayout localAvatarLayout = (AvatarLayout)paramView.findViewById(2131368780);
    localAvatarLayout.setVisibility(0);
    Object localObject = (ImageView)paramView.findViewById(2131368781);
    this.templateUtils.updateViewAttr((View)localObject, "src", paramProfileCardInfo.currentTemplate, "commonFaceBackground");
    localObject = new DataTag(1, null);
    localAvatarLayout.setTag(localObject);
    localAvatarLayout.setOnClickListener(this.mOnClickListener);
    if (paramProfileCardInfo.allInOne.pa == 0) {
      paramContext = paramContext.getString(2131691197);
    } else {
      paramContext = paramContext.getString(2131691196);
    }
    localAvatarLayout.setContentDescription(paramContext);
    localAvatarLayout.a(0, localAvatarLayout.findViewById(2131363438), false);
    this.mHeaderChildMap.put("map_key_face", localAvatarLayout);
    this.mHeaderChildMap.put("map_key_face_stoke", paramView.findViewById(2131368781));
    super.updateAvatar(paramProfileCardInfo.allInOne);
    paramContext = (ImageView)paramView.findViewById(2131368617);
    paramContext.setVisibility(4);
    paramContext.setOnClickListener(this.mOnClickListener);
    paramContext.setTag(localObject);
    this.mHeaderChildMap.put("map_key_avatar_pendant", paramContext);
    super.updateAvatarPendantImage(paramProfileCardInfo, true);
  }
  
  private void updateBaseInfoArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131368787);
    this.templateUtils.updateViewAttr(paramView, "color", paramProfileCardInfo.currentTemplate, "photoAddressColor");
    this.mHeaderChildMap.put("map_key_sex_age_area", paramView);
    super.updateSexAgeArea(paramProfileCardInfo);
  }
  
  private void updateHeadArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    paramView = (ProfileNameView)paramView.findViewById(2131368795);
    this.templateUtils.updateViewAttr(paramView, "color", paramProfileCardInfo.currentTemplate, "photoNickNameColor");
    paramView.setVisibility(0);
    paramView.setClickable(true);
    paramView.setClickListener(this.mOnClickListener);
    this.mHeaderChildMap.put("map_key_profile_nick_name", paramView);
    super.updateHead(paramProfileCardInfo);
  }
  
  private void updateLikeArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    VoteView localVoteView = (VoteView)findViewById(2131380996);
    paramView = (HeartLayout)paramView.findViewById(2131368151);
    paramView.setEnabled(false);
    localVoteView.setHeartLayout(this.mApp, paramView);
    this.mHeaderChildMap.put("map_key_like", localVoteView);
    super.updateLike(paramProfileCardInfo);
  }
  
  private void updatePhotoWallArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    paramView = (QzonePhotoView)paramView.findViewById(2131374935);
    paramView.setTemplateUtils(this.templateUtils);
    paramView.a(this.mActivity, paramProfileCardInfo);
    this.mHeaderChildMap.put("map_key_qzonecover", paramView);
    this.templateUtils.updateViewAttr(paramView, "background", paramProfileCardInfo.currentTemplate, "commonMaskBackground");
  }
  
  private void updateTipsArea(View paramView)
  {
    paramView = (LinearLayout)paramView.findViewById(2131368825);
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
  
  protected void onInit(ProfileCardInfo paramProfileCardInfo)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfilePhotoView
 * JD-Core Version:    0.7.0.1
 */