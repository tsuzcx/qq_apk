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
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.view.VipPhotoViewForSimple;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils.ProfileAccountInfoUtils;
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
  private boolean mIsAnimEnd = false;
  private float mOldScreenHeight = 0.0F;
  private TextView mSexText;
  private int mStatusBarHeight = -1;
  
  public VasProfileSimpleView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    this.mActivity = paramBaseActivity;
    this.mApp = paramBaseActivity.app;
    this.mCardInfo = paramProfileCardInfo;
  }
  
  private void initDiyTextView(View paramView)
  {
    this.mDiyTextEdit = ((ImageView)paramView.findViewById(2131373523));
    this.mDiyEditHint = ((TextView)paramView.findViewById(2131373524));
    this.mDiyTextEdit.setTag(new DataTag(73, this.mDiyEditHint));
    this.mDiyTextEdit.setOnClickListener(this.mOnClickListener);
  }
  
  private View initMainView(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131562193, this, true);
  }
  
  private void prepareForEnterAnimation(View paramView)
  {
    this.mBottomBarHeight = getResources().getDimensionPixelSize(2131297098);
    this.mStatusBarHeight = ProfileCardUtil.a(getResources());
    this.mBlankView = paramView.findViewById(2131369056);
    paramView = (RelativeLayout.LayoutParams)this.mBlankView.getLayoutParams();
    if (this.mActivity != null) {
      paramView.height = ((int)this.mScreenHeight - ProfileCardUtil.b(this.mActivity, 129) - ProfileCardUtil.b(this.mActivity, 18) - this.mBottomBarHeight - this.mStatusBarHeight);
    }
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      paramView.height += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    if (((this.mActivity instanceof FriendProfileCardActivity)) && (((FriendProfileCardActivity)this.mActivity).e)) {
      paramView.height = ((int)(paramView.height - this.mScreenHeight / 2.0F));
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + paramView.height);
    }
    this.mBlankView.setLayoutParams(paramView);
    this.mBlankView.setFocusable(true);
    this.mBlankView.setFocusableInTouchMode(true);
  }
  
  private void setPlaceTxt(ProfileCardInfo paramProfileCardInfo, ContactCard paramContactCard)
  {
    Object localObject2 = "";
    Card localCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
    Object localObject1;
    if (localCard != null)
    {
      paramContactCard = (ContactCard)localObject2;
      if (!TextUtils.isEmpty(localCard.strCountry))
      {
        paramContactCard = (ContactCard)localObject2;
        if (!HardCodeUtil.a(2131716599).equals(localCard.strCountry)) {
          paramContactCard = "" + localCard.strCountry;
        }
      }
      localObject2 = paramContactCard;
      if (!TextUtils.isEmpty(localCard.strProvince))
      {
        localObject1 = paramContactCard;
        if (!TextUtils.isEmpty(paramContactCard)) {
          localObject1 = paramContactCard + "，";
        }
        localObject2 = (String)localObject1 + localCard.strProvince;
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(localCard.strCity))
      {
        paramContactCard = (ContactCard)localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramContactCard = (String)localObject2 + "，";
        }
        localObject1 = paramContactCard + localCard.strCity;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea place=" + (String)localObject1);
      }
      if (!ProfileAccountInfoUtils.isFieldVisible(41614, paramProfileCardInfo)) {
        localObject1 = "";
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      this.mAreaText.setVisibility(0);
      this.mAreaText.setText((CharSequence)localObject1);
      this.mAreaText.setContentDescription((CharSequence)localObject1);
      return;
      localObject1 = localObject2;
      if (paramContactCard != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramContactCard.strCountry))
        {
          localObject1 = localObject2;
          if (!HardCodeUtil.a(2131716598).equals(paramContactCard.strCountry)) {
            localObject1 = "" + paramContactCard.strCountry;
          }
        }
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(paramContactCard.strProvince))
        {
          localObject2 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = (String)localObject1 + "，";
          }
          localObject2 = (String)localObject2 + paramContactCard.strProvince;
        }
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramContactCard.strCity))
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = (String)localObject2 + "，";
          }
          localObject1 = (String)localObject1 + paramContactCard.strCity;
        }
      }
    }
    this.mAreaText.setVisibility(8);
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
    AvatarLayout localAvatarLayout = (AvatarLayout)paramView.findViewById(2131369058);
    localAvatarLayout.setVisibility(0);
    ProfileCardTemplate.a((ImageView)paramView.findViewById(2131369059), "src", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonFaceBackground");
    DataTag localDataTag = new DataTag(1, null);
    localAvatarLayout.setTag(localDataTag);
    localAvatarLayout.setOnClickListener(this.mOnClickListener);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
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
    this.mSexText = ((TextView)paramView.findViewById(2131369068));
    this.mAgeText = ((TextView)paramView.findViewById(2131369066));
    this.mAreaText = ((TextView)paramView.findViewById(2131369067));
    ProfileCardTemplate.a(this.mSexText, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressColor");
    ProfileCardTemplate.a(this.mAgeText, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressColor");
    ProfileCardTemplate.a(this.mAreaText, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressColor");
    ProfileCardTemplate.a(this.mSexText, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressBackground");
    ProfileCardTemplate.a(this.mAgeText, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressBackground");
    ProfileCardTemplate.a(this.mAreaText, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressBackground");
    updateSexAgeAreaSimple(paramProfileCardInfo);
  }
  
  private void updateHeadArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    paramView = (ProfileNameView)paramView.findViewById(2131369073);
    ProfileCardTemplate.a(paramView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleNickNameColor");
    paramView.setVisibility(0);
    paramView.setClickable(true);
    paramView.setClickListener(this.mOnClickListener);
    this.mHeaderChildMap.put("map_key_profile_nick_name", paramView);
    super.updateHead(paramProfileCardInfo);
  }
  
  private void updateLikeArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    VoteView localVoteView = (VoteView)paramView.findViewById(2131381767);
    paramView = (HeartLayout)paramView.findViewById(2131368400);
    paramView.setEnabled(false);
    localVoteView.setHeartLayout(this.mApp, paramView);
    this.mHeaderChildMap.put("map_key_like", localVoteView);
    super.updateLike(paramProfileCardInfo);
  }
  
  private void updatePhotoWallArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    paramView = (VipPhotoViewForSimple)paramView.findViewById(2131375417);
    paramView.a(this.mActivity, paramProfileCardInfo);
    this.mHeaderChildMap.put("map_key_qzonecover", paramView);
    ProfileCardTemplate.a(paramView, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonMaskBackground");
  }
  
  private void updateTipArea(View paramView)
  {
    paramView = (LinearLayout)paramView.findViewById(2131369104);
    this.mHeaderChildMap.put("map_key_tips", paramView);
  }
  
  public void fixBlankHeight()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mBlankView.getLayoutParams();
    localLayoutParams.height = ((int)this.mScreenHeight - ProfileCardUtil.b(this.mActivity, 129) - ProfileCardUtil.b(this.mActivity, 18) - this.mBottomBarHeight - this.mStatusBarHeight);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      localLayoutParams.height += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + localLayoutParams.height);
    }
    this.mBlankView.setLayoutParams(localLayoutParams);
  }
  
  public boolean intercept(View paramView, MotionEvent paramMotionEvent)
  {
    if (System.currentTimeMillis() - this.mAnimBeginTime > 1000L) {}
    for (int i = 1; (i == 0) && (!this.mIsAnimEnd); i = 0) {
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
      localLayoutParams.addRule(8, 2131369113);
      localLayoutParams.bottomMargin = paramInt;
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard", 2, "onApolloExpand h:" + paramInt);
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
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
  public void onInit(ProfileCardInfo paramProfileCardInfo)
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
    if ((this.mActivity != null) && ((this.mActivity instanceof FriendProfileCardActivity)) && (((FriendProfileCardActivity)this.mActivity).e))
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
      localLayoutParams.addRule(3, 2131368400);
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
  
  @TargetApi(9)
  void updateDiyText(ProfileCardInfo paramProfileCardInfo)
  {
    if (!paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.mApp.getCurrentAccountUin())) {
      this.mDiyTextEdit.setVisibility(8);
    }
    do
    {
      return;
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.cardType != 2) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId != 1600L)) {
        break;
      }
      this.mDiyTextEdit.setVisibility(0);
      paramProfileCardInfo = this.mApp.getApp().getSharedPreferences("vip_profile_diy_card", 0);
    } while (paramProfileCardInfo.getBoolean("vip_diy_card_edit_hint", false));
    this.mDiyEditHint.setVisibility(0);
    paramProfileCardInfo.edit().putBoolean("vip_diy_card_edit_hint", true).apply();
    return;
    this.mDiyTextEdit.setVisibility(8);
  }
  
  public void updateSexAgeAreaSimple(ProfileCardInfo paramProfileCardInfo)
  {
    int j = -1;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      paramProfileCardInfo = this.mActivity.getString(2131699051);
      this.mAgeText.setVisibility(0);
      this.mSexText.setVisibility(8);
      this.mAreaText.setVisibility(8);
      this.mAgeText.setPadding(0, 10, 0, 0);
      this.mAgeText.setText(paramProfileCardInfo);
      this.mAgeText.setContentDescription(paramProfileCardInfo);
      return;
    }
    Object localObject = "";
    Card localCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
    ContactCard localContactCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    int i;
    if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 0) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 1)) {
      i = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte;
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject = this.mActivity.getString(2131693923);
        label141:
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea sex=" + (String)localObject);
        }
        if (!ProfileAccountInfoUtils.isFieldVisible(41611, paramProfileCardInfo)) {
          localObject = "";
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label455;
        }
        this.mSexText.setVisibility(0);
        this.mSexText.setText((CharSequence)localObject);
        this.mSexText.setContentDescription((CharSequence)localObject);
        label222:
        String str = "";
        if (localCard == null) {
          break label467;
        }
        i = localCard.age;
        label237:
        localObject = str;
        if (i > 0)
        {
          localObject = str;
          if (!ProfileCardUtil.a()) {
            localObject = i + this.mActivity.getString(2131719672);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea age=" + (String)localObject);
        }
        if (!ProfileAccountInfoUtils.isFieldVisible(41610, paramProfileCardInfo)) {
          localObject = "";
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label483;
        }
        this.mAgeText.setVisibility(0);
        this.mAgeText.setText((CharSequence)localObject);
        this.mAgeText.setContentDescription((CharSequence)localObject);
      }
      for (;;)
      {
        setPlaceTxt(paramProfileCardInfo, localContactCard);
        return;
        if ((localCard != null) && ((localCard.shGender == 0) || (localCard.shGender == 1)))
        {
          i = localCard.shGender;
          break;
        }
        if ((localContactCard == null) || ((localContactCard.bSex != 0) && (localContactCard.bSex != 1))) {
          break label495;
        }
        i = localContactCard.bSex;
        break;
        if (i != 1) {
          break label141;
        }
        localObject = this.mActivity.getString(2131692330);
        break label141;
        label455:
        this.mSexText.setVisibility(8);
        break label222;
        label467:
        i = j;
        if (localContactCard == null) {
          break label237;
        }
        i = localContactCard.bAge;
        break label237;
        label483:
        this.mAgeText.setVisibility(8);
      }
      label495:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileSimpleView
 * JD-Core Version:    0.7.0.1
 */