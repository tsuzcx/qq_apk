package com.tencent.mobileqq.profilecard.vas.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.view.VipPhotoViewForSimple;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;

public class VasProfileSimpleView
  extends AbsProfileHeaderView
{
  private static final int ANIM_TIME_OUT_LENGTH = 1000;
  private static final int SPACE_HEAD_HEIGHT = 129;
  private static final int SPACE_TIP_HEIGHT = 18;
  private TextView mAgeText;
  private long mAnimBeginTime;
  private TextView mAreaText;
  private View mBlankView;
  private int mBottomBarHeight = -1;
  private TextView mDiyEditHint;
  private ImageView mDiyTextEdit;
  private boolean mFromExtendFriend;
  private boolean mIsAnimEnd = false;
  private float mOldScreenHeight = 0.0F;
  private TextView mSexText;
  private int mStatusBarHeight = -1;
  
  public VasProfileSimpleView(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramQBaseActivity, paramProfileCardInfo);
  }
  
  private void initDiyTextView(View paramView)
  {
    this.mDiyTextEdit = ((ImageView)paramView.findViewById(2131440704));
    this.mDiyEditHint = ((TextView)paramView.findViewById(2131440705));
    this.mDiyTextEdit.setTag(new DataTag(73, this.mDiyEditHint));
    this.mDiyTextEdit.setOnClickListener(this.mOnClickListener);
  }
  
  private View initMainView(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131628456, this, true);
  }
  
  private String jointPlaceStr(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    Object localObject = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject = paramString1;
      if (!HardCodeUtil.a(paramInt).equals(paramString2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(paramString2);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    paramString1 = (String)localObject;
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = (String)localObject;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramString1 = new StringBuilder();
        paramString1.append((String)localObject);
        paramString1.append("，");
        paramString1 = paramString1.toString();
      }
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(paramString3);
      paramString1 = paramString2.toString();
    }
    paramString2 = paramString1;
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString2 = paramString1;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append("，");
        paramString2 = paramString2.toString();
      }
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append(paramString4);
      paramString2 = paramString1.toString();
    }
    return paramString2;
  }
  
  private void prepareForEnterAnimation(View paramView)
  {
    this.mBottomBarHeight = getResources().getDimensionPixelSize(2131297461);
    this.mStatusBarHeight = ProfileCardUtil.a(getResources());
    this.mBlankView = paramView.findViewById(2131435699);
    paramView = (RelativeLayout.LayoutParams)this.mBlankView.getLayoutParams();
    if (this.mActivity != null) {
      paramView.height = ((int)this.mScreenHeight - ProfileCardUtil.b(this.mActivity, 129) - ProfileCardUtil.b(this.mActivity, 18) - this.mBottomBarHeight - this.mStatusBarHeight);
    }
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      paramView.height += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    if (this.mFromExtendFriend) {
      paramView.height = ((int)(paramView.height - this.mScreenHeight / 2.0F));
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rl.height: ");
      localStringBuilder.append(paramView.height);
      QLog.d("Q.profilecard.FrdProfileCard", 2, localStringBuilder.toString());
    }
    this.mBlankView.setLayoutParams(paramView);
    this.mBlankView.setFocusable(true);
    this.mBlankView.setFocusableInTouchMode(true);
  }
  
  private void setAgeTxt(ProfileCardInfo paramProfileCardInfo, Card paramCard, ContactCard paramContactCard)
  {
    int i;
    if (paramCard != null) {
      i = paramCard.age;
    } else if (paramContactCard != null) {
      i = paramContactCard.bAge;
    } else {
      i = -1;
    }
    if ((i > 0) && (!ProfileCardUtil.c()))
    {
      paramCard = new StringBuilder();
      paramCard.append(i);
      paramCard.append(this.mActivity.getString(2131916946));
      paramCard = paramCard.toString();
    }
    else
    {
      paramCard = "";
    }
    if (QLog.isColorLevel())
    {
      paramContactCard = new StringBuilder();
      paramContactCard.append("updateSexAgeArea age=");
      paramContactCard.append(paramCard);
      QLog.d("Q.profilecard.FrdProfileCard", 2, paramContactCard.toString());
    }
    if (!((IProfileCardApi)QRoute.api(IProfileCardApi.class)).isFieldVisible(41610, paramProfileCardInfo)) {
      paramCard = "";
    }
    if (!TextUtils.isEmpty(paramCard))
    {
      this.mAgeText.setVisibility(0);
      this.mAgeText.setText(paramCard);
      this.mAgeText.setContentDescription(paramCard);
      return;
    }
    this.mAgeText.setVisibility(8);
  }
  
  private void setPlaceTxt(ProfileCardInfo paramProfileCardInfo, ContactCard paramContactCard)
  {
    Card localCard = paramProfileCardInfo.card;
    String str = "";
    if (localCard != null) {
      str = jointPlaceStr("", localCard.strCountry, 2131913696, localCard.strProvince, localCard.strCity);
    } else if (paramContactCard != null) {
      str = jointPlaceStr("", paramContactCard.strCountry, 2131913695, paramContactCard.strProvince, paramContactCard.strCity);
    }
    if (QLog.isColorLevel())
    {
      paramContactCard = new StringBuilder();
      paramContactCard.append("updateSexAgeArea place=");
      paramContactCard.append(str);
      QLog.d("Q.profilecard.FrdProfileCard", 2, paramContactCard.toString());
    }
    if (!((IProfileCardApi)QRoute.api(IProfileCardApi.class)).isFieldVisible(41614, paramProfileCardInfo)) {
      str = "";
    }
    if (!TextUtils.isEmpty(str))
    {
      this.mAreaText.setVisibility(0);
      this.mAreaText.setText(str);
      this.mAreaText.setContentDescription(str);
      return;
    }
    this.mAreaText.setVisibility(8);
  }
  
  private void setSexTxt(ProfileCardInfo paramProfileCardInfo, Card paramCard, ContactCard paramContactCard)
  {
    int i;
    if ((paramProfileCardInfo.allInOne.gender != 0) && (paramProfileCardInfo.allInOne.gender != 1))
    {
      if ((paramCard != null) && ((paramCard.shGender == 0) || (paramCard.shGender == 1))) {
        i = paramCard.shGender;
      } else if ((paramContactCard != null) && ((paramContactCard.bSex == 0) || (paramContactCard.bSex == 1))) {
        i = paramContactCard.bSex;
      } else {
        i = -1;
      }
    }
    else {
      i = paramProfileCardInfo.allInOne.gender;
    }
    showSexTxt(paramProfileCardInfo, "", i);
  }
  
  private void showSexTxt(ProfileCardInfo paramProfileCardInfo, String paramString, int paramInt)
  {
    if (paramInt == 0) {
      paramString = this.mActivity.getString(2131891484);
    } else if (paramInt == 1) {
      paramString = this.mActivity.getString(2131889246);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSexAgeArea sex=");
      localStringBuilder.append(paramString);
      QLog.d("Q.profilecard.FrdProfileCard", 2, localStringBuilder.toString());
    }
    if (!((IProfileCardApi)QRoute.api(IProfileCardApi.class)).isFieldVisible(41611, paramProfileCardInfo)) {
      paramString = "";
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.mSexText.setVisibility(0);
      this.mSexText.setText(paramString);
      this.mSexText.setContentDescription(paramString);
      return;
    }
    this.mSexText.setVisibility(8);
  }
  
  private void startEnterAnimation(ProfileCardInfo paramProfileCardInfo)
  {
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, 0.0F, 0, -100.0F);
    localTranslateAnimation1.setDuration(500L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, -100.0F, 0, 0.0F);
    localTranslateAnimation2.setDuration(500L);
    localTranslateAnimation2.setAnimationListener(new VasProfileSimpleView.1(this, paramProfileCardInfo));
    localTranslateAnimation1.setAnimationListener(new VasProfileSimpleView.2(this, localTranslateAnimation2));
    startAnimation(localTranslateAnimation1);
    this.mAnimBeginTime = System.currentTimeMillis();
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
    this.mSexText = ((TextView)paramView.findViewById(2131435711));
    this.mAgeText = ((TextView)paramView.findViewById(2131435709));
    this.mAreaText = ((TextView)paramView.findViewById(2131435710));
    this.templateUtils.updateViewAttr(this.mSexText, "color", paramProfileCardInfo.currentTemplate, "simpleAddressColor");
    this.templateUtils.updateViewAttr(this.mAgeText, "color", paramProfileCardInfo.currentTemplate, "simpleAddressColor");
    this.templateUtils.updateViewAttr(this.mAreaText, "color", paramProfileCardInfo.currentTemplate, "simpleAddressColor");
    this.templateUtils.updateViewAttr(this.mSexText, "background", paramProfileCardInfo.currentTemplate, "simpleAddressBackground");
    this.templateUtils.updateViewAttr(this.mAgeText, "background", paramProfileCardInfo.currentTemplate, "simpleAddressBackground");
    this.templateUtils.updateViewAttr(this.mAreaText, "background", paramProfileCardInfo.currentTemplate, "simpleAddressBackground");
    updateSexAgeAreaSimple(paramProfileCardInfo);
  }
  
  private void updateHeadArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    paramView = (ProfileNameView)paramView.findViewById(2131435716);
    this.templateUtils.updateViewAttr(paramView, "color", paramProfileCardInfo.currentTemplate, "simpleNickNameColor");
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
  
  private void updatePhotoWallArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    paramView = (VipPhotoViewForSimple)paramView.findViewById(2131443120);
    paramView.setTemplateUtils(this.templateUtils);
    paramView.a(this.mActivity, paramProfileCardInfo);
    this.mHeaderChildMap.put("map_key_qzonecover", paramView);
    this.templateUtils.updateViewAttr(paramView, "background", paramProfileCardInfo.currentTemplate, "commonMaskBackground");
  }
  
  private void updateTipArea(View paramView)
  {
    paramView = (LinearLayout)paramView.findViewById(2131435746);
    this.mHeaderChildMap.put("map_key_tips", paramView);
  }
  
  public void fixBlankHeight()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mBlankView.getLayoutParams();
    localLayoutParams.height = ((int)this.mScreenHeight - ProfileCardUtil.b(this.mActivity, 129) - ProfileCardUtil.b(this.mActivity, 18) - this.mBottomBarHeight - this.mStatusBarHeight);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      localLayoutParams.height += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rl.height: ");
      localStringBuilder.append(localLayoutParams.height);
      QLog.d("Q.profilecard.FrdProfileCard", 2, localStringBuilder.toString());
    }
    this.mBlankView.setLayoutParams(localLayoutParams);
  }
  
  public boolean intercept(View paramView, MotionEvent paramMotionEvent)
  {
    int i;
    if (System.currentTimeMillis() - this.mAnimBeginTime > 1000L) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (!this.mIsAnimEnd)) {
      return true;
    }
    return super.intercept(paramView, paramMotionEvent);
  }
  
  public void onApolloExpand(int paramInt)
  {
    super.onApolloExpand(paramInt);
    Object localObject = (View)this.mHeaderChildMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.addRule(3, 0);
      localLayoutParams.addRule(8, 2131435776);
      localLayoutParams.bottomMargin = paramInt;
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onApolloExpand h:");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("Q.profilecard", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mOldScreenHeight != this.mScreenHeight)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.mBlankView.getLayoutParams();
      paramConfiguration.height = ((int)(paramConfiguration.height + (this.mScreenHeight - this.mOldScreenHeight)));
      this.mBlankView.setLayoutParams(paramConfiguration);
      this.mOldScreenHeight = this.mScreenHeight;
    }
  }
  
  @TargetApi(9)
  protected void onInit(ProfileCardInfo paramProfileCardInfo)
  {
    this.mOldScreenHeight = this.mScreenHeight;
    Context localContext = getContext();
    View localView = initMainView(localContext);
    initDiyTextView(localView);
    prepareForEnterAnimation(localView);
    updateAvatarArea(paramProfileCardInfo, localContext, localView);
    updateHeadArea(paramProfileCardInfo, localView);
    updateBaseInfoArea(paramProfileCardInfo, localView);
    updateLikeArea(paramProfileCardInfo, localView);
    updatePhotoWallArea(paramProfileCardInfo, localView);
    updateTipArea(localView);
    super.onInit(paramProfileCardInfo);
    if (this.mFromExtendFriend)
    {
      this.mIsAnimEnd = true;
      updateJueban(paramProfileCardInfo);
      return;
    }
    startEnterAnimation(paramProfileCardInfo);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mCardInfo != null) {
      super.updateAvatarPendantImage(this.mCardInfo, false);
    }
    Object localObject = (View)this.mHeaderChildMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      localLayoutParams.addRule(3, 2131435008);
      localLayoutParams.addRule(8, 0);
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
    }
  }
  
  public void onUpdate(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.updateLike(paramProfileCardInfo);
    super.updateHead(paramProfileCardInfo);
    updateSexAgeAreaSimple(paramProfileCardInfo);
    super.updateAvatarPendantImage(paramProfileCardInfo, false);
    updateDiyText(paramProfileCardInfo);
  }
  
  public void setFromExtendFriend(boolean paramBoolean)
  {
    this.mFromExtendFriend = paramBoolean;
  }
  
  @TargetApi(9)
  void updateDiyText(ProfileCardInfo paramProfileCardInfo)
  {
    if (!paramProfileCardInfo.allInOne.uin.equals(this.mApp.getCurrentAccountUin()))
    {
      this.mDiyTextEdit.setVisibility(8);
      return;
    }
    if ((paramProfileCardInfo.card.cardType != 2) && (paramProfileCardInfo.card.lCurrentBgId != 1600L))
    {
      this.mDiyTextEdit.setVisibility(8);
      return;
    }
    this.mDiyTextEdit.setVisibility(0);
    paramProfileCardInfo = this.mApp.getApp().getSharedPreferences("vip_profile_diy_card", 0);
    if (!paramProfileCardInfo.getBoolean("vip_diy_card_edit_hint", false))
    {
      this.mDiyEditHint.setVisibility(0);
      paramProfileCardInfo.edit().putBoolean("vip_diy_card_edit_hint", true).apply();
    }
  }
  
  public void updateSexAgeAreaSimple(ProfileCardInfo paramProfileCardInfo)
  {
    if (paramProfileCardInfo.allInOne.pa == 33)
    {
      paramProfileCardInfo = this.mActivity.getString(2131897171);
      this.mAgeText.setVisibility(0);
      this.mSexText.setVisibility(8);
      this.mAreaText.setVisibility(8);
      this.mAgeText.setPadding(0, 10, 0, 0);
      this.mAgeText.setText(paramProfileCardInfo);
      this.mAgeText.setContentDescription(paramProfileCardInfo);
      return;
    }
    Card localCard = paramProfileCardInfo.card;
    ContactCard localContactCard = paramProfileCardInfo.contactCard;
    setSexTxt(paramProfileCardInfo, localCard, localContactCard);
    setAgeTxt(paramProfileCardInfo, localCard, localContactCard);
    setPlaceTxt(paramProfileCardInfo, localContactCard);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileSimpleView
 * JD-Core Version:    0.7.0.1
 */