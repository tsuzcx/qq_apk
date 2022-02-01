package com.tencent.mobileqq.profilecard.vas.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

public class VasProfileGameView
  extends AbsProfileHeaderView
{
  public VasProfileGameView(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramQBaseActivity, paramProfileCardInfo);
  }
  
  @NotNull
  private View initMainView(ProfileCardInfo paramProfileCardInfo, Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131628444, this, true);
    LinearLayout localLinearLayout = (LinearLayout)paramContext.findViewById(2131435707);
    this.templateUtils.updateViewAttr(localLinearLayout, "background", paramProfileCardInfo.currentTemplate, "gameHeadInfoBackground");
    return paramContext;
  }
  
  private void updateAvatarArea(ProfileCardInfo paramProfileCardInfo, Context paramContext, View paramView)
  {
    AvatarLayout localAvatarLayout = (AvatarLayout)paramView.findViewById(2131435701);
    localAvatarLayout.setVisibility(0);
    Object localObject = (ImageView)paramView.findViewById(2131435702);
    this.templateUtils.updateViewAttr((View)localObject, "src", paramProfileCardInfo.currentTemplate, "commonFaceBackground");
    localObject = new DataTag(1, null);
    localAvatarLayout.setTag(localObject);
    localAvatarLayout.setOnClickListener(this.mOnClickListener);
    if (paramProfileCardInfo.allInOne.pa == 0) {
      paramContext = paramContext.getString(2131888143);
    } else {
      paramContext = paramContext.getString(2131888142);
    }
    localAvatarLayout.setContentDescription(paramContext);
    localAvatarLayout.a(0, localAvatarLayout.findViewById(2131429335), false);
    this.mHeaderChildMap.put("map_key_face", localAvatarLayout);
    this.mHeaderChildMap.put("map_key_face_stoke", paramView.findViewById(2131435702));
    super.updateAvatar(paramProfileCardInfo.allInOne);
    paramContext = (ImageView)paramView.findViewById(2131435529);
    paramContext.setVisibility(4);
    paramContext.setOnClickListener(this.mOnClickListener);
    paramContext.setTag(localObject);
    this.mHeaderChildMap.put("map_key_avatar_pendant", paramContext);
    super.updateAvatarPendantImage(paramProfileCardInfo, true);
  }
  
  private void updateBaseInfoArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131435708);
    this.templateUtils.updateViewAttr(paramView, "color", paramProfileCardInfo.currentTemplate, "gameAddressColor");
    this.mHeaderChildMap.put("map_key_sex_age_area", paramView);
    super.updateSexAgeArea(paramProfileCardInfo);
  }
  
  private void updateHeadArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    paramView = (ProfileNameView)paramView.findViewById(2131435716);
    this.templateUtils.updateViewAttr(paramView, "color", paramProfileCardInfo.currentTemplate, "gameNickNameColor");
    paramView.setVisibility(0);
    paramView.setClickable(true);
    paramView.setClickListener(this.mOnClickListener);
    this.mHeaderChildMap.put("map_key_profile_nick_name", paramView);
    super.updateHead(paramProfileCardInfo);
  }
  
  private void updateLikeArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    VoteView localVoteView = (VoteView)paramView.findViewById(2131449991);
    paramView = (HeartLayout)paramView.findViewById(2131435008);
    paramView.setEnabled(false);
    localVoteView.setHeartLayout(this.mApp, paramView);
    this.mHeaderChildMap.put("map_key_like", localVoteView);
    super.updateLike(paramProfileCardInfo);
  }
  
  private void updateSignArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131435745);
    this.mHeaderChildMap.put("map_key_sign_common_topic", localLinearLayout);
    paramView = (TextView)paramView.findViewById(2131435744);
    this.templateUtils.updateViewAttr(paramView, "color", paramProfileCardInfo.currentTemplate, "gameSignColor");
    this.mHeaderChildMap.put("map_key_sign", paramView);
    updateSign(paramProfileCardInfo);
  }
  
  private void updateTipArea(View paramView)
  {
    paramView = (LinearLayout)paramView.findViewById(2131435746);
    this.mHeaderChildMap.put("map_key_tips", paramView);
  }
  
  protected void onInit(ProfileCardInfo paramProfileCardInfo)
  {
    Context localContext = getContext();
    View localView = initMainView(paramProfileCardInfo, localContext);
    updateAvatarArea(paramProfileCardInfo, localContext, localView);
    updateHeadArea(paramProfileCardInfo, localView);
    updateBaseInfoArea(paramProfileCardInfo, localView);
    updateSignArea(paramProfileCardInfo, localView);
    updateLikeArea(paramProfileCardInfo, localView);
    updateTipArea(localView);
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
    updateSign(paramProfileCardInfo);
    super.updateAvatarPendantImage(paramProfileCardInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileGameView
 * JD-Core Version:    0.7.0.1
 */