package com.tencent.mobileqq.profilecard.vas.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.vas.PrettyAccountUtil;
import com.tencent.mobileqq.vas.QidCoolTextView;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class VasProfileQVipV5View
  extends AbsProfileHeaderView
{
  private View mAccountInfoView;
  private AvatarLayout mAvatar;
  private ImageView mAvatarPendant;
  private View mContentView;
  private ViewGroup mHeadContainer;
  private boolean mIsFromArkBabyQ;
  private ProfileNameView mNameView;
  private QidCoolTextView mQidInfoView;
  private TextView mRemarkName;
  private TextView mUinInfoView;
  private HeartLayout mVoteHeartLayout;
  private VoteViewV2 mVoteView;
  
  public VasProfileQVipV5View(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    this.mActivity = paramBaseActivity;
    this.mApp = paramBaseActivity.app;
    this.mCardInfo = paramProfileCardInfo;
    this.mNewVoteAnimHelper = new NewVoteAnimHelper(paramBaseActivity, this.mApp, 3, 1);
  }
  
  private void initHeadUI()
  {
    int j = -16777216;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "initHeadUI");
    }
    Object localObject = getContext();
    this.mHeadContainer = ((ViewGroup)this.mContentView.findViewById(2131369062));
    this.mAvatar = ((AvatarLayout)this.mContentView.findViewById(2131369058));
    this.mAvatar.setVisibility(0);
    DataTag localDataTag = new DataTag(1, null);
    int i;
    if (this.mCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localObject = ((Context)localObject).getString(2131691276);
      this.mAvatar.setTag(localDataTag);
      this.mAvatar.setOnClickListener(this.mOnClickListener);
      this.mAvatar.setContentDescription((CharSequence)localObject);
      this.mAvatar.a(0, this.mAvatar.findViewById(2131363511), false);
      this.mHeaderChildMap.put("map_key_face", this.mAvatar);
      this.mHeaderChildMap.put("map_key_face_stoke", this.mContentView.findViewById(2131369060));
      this.mAvatarPendant = ((ImageView)this.mContentView.findViewById(2131368891));
      this.mHeaderChildMap.put("map_key_avatar_pendant", this.mAvatarPendant);
      this.mAvatarPendant.setVisibility(8);
      this.mAvatarPendant.setTag(localDataTag);
      this.mAvatarPendant.setOnClickListener(this.mOnClickListener);
      this.mNameView = ((ProfileNameView)this.mContentView.findViewById(2131372272));
      localObject = this.mNameView;
      if (this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor != 1L) {
        break label605;
      }
      i = -16777216;
      label276:
      ((ProfileNameView)localObject).setTextColor(i);
      this.mHeaderChildMap.put("map_key_profile_nick_name", this.mNameView);
      this.mNameView.setVisibility(0);
      this.mNameView.setClickable(true);
      this.mNameView.setClickListener(this.mOnClickListener);
      this.mRemarkName = ((TextView)this.mContentView.findViewById(2131376901));
      this.mHeaderChildMap.put("map_key_profile_remark_name", this.mRemarkName);
      this.mAccountInfoView = this.mContentView.findViewById(2131374668);
      this.mHeaderChildMap.put("map_key_details", this.mAccountInfoView);
      this.mVoteView = ((VoteViewV2)this.mContentView.findViewById(2131381767));
      this.mVoteHeartLayout = ((HeartLayout)this.mContentView.findViewById(2131368400));
      this.mHeaderChildMap.put("map_key_like", this.mVoteView);
      this.mVoteView.setHeartLayout(this.mApp, this.mVoteHeartLayout);
      this.mVoteView.a(0);
      this.mVoteHeartLayout.setEnabled(false);
      this.mUinInfoView = ((TextView)this.mContentView.findViewById(2131374496));
      localObject = this.mUinInfoView;
      if (this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor != 1L) {
        break label610;
      }
      i = j;
      label496:
      ((TextView)localObject).setTextColor(i);
      this.mHeaderChildMap.put("map_key_uin_info", this.mUinInfoView);
      this.mQidInfoView = ((QidCoolTextView)this.mContentView.findViewById(2131374769));
      this.mHeaderChildMap.put("map_key_qid_info", this.mQidInfoView);
      this.mQidInfoView.setOnClickListener(this.mOnClickListener);
      localObject = this.mQidInfoView;
      if (PrettyAccountUtil.a(this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard) != 1) {
        break label615;
      }
    }
    label605:
    label610:
    label615:
    for (float f = 8.5F;; f = 7.0F)
    {
      ((QidCoolTextView)localObject).a(f, 0.0F);
      return;
      localObject = ((Context)localObject).getString(2131691275);
      break;
      i = -1;
      break label276;
      i = -1;
      break label496;
    }
  }
  
  protected void loadHeadLayout(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, " needRefreshUI=" + paramBoolean);
    }
    View localView = LayoutInflater.from(getContext()).inflate(2131562184, this.mHeadContainer, false);
    if (localView != null)
    {
      this.mHeadContainer.removeAllViews();
      this.mHeadContainer.addView(localView);
      if (paramBoolean)
      {
        initHeadUI();
        updateAvatar(this.mCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        updateAvatarPendantImage(this.mCardInfo, false);
        updateHead(this.mCardInfo);
        updateDetail(this.mCardInfo);
        updateLike(this.mCardInfo);
        updateUinInfo(this.mCardInfo, this.mApp.getCurrentAccountUin());
        updateQidInfo(this.mCardInfo);
      }
    }
  }
  
  public void onInit(ProfileCardInfo paramProfileCardInfo)
  {
    this.mContentView = LayoutInflater.from(getContext()).inflate(2131562198, this, true);
    this.mHeadContainer = ((ViewGroup)this.mContentView.findViewById(2131369062));
    loadHeadLayout(false);
    initHeadUI();
    updateAvatar(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    updateAvatarPendantImage(paramProfileCardInfo, true);
    updateHead(paramProfileCardInfo);
    updateDetail(paramProfileCardInfo);
    updateLike(paramProfileCardInfo);
    updateUinInfo(paramProfileCardInfo, this.mApp.getCurrentAccountUin());
    updateQidInfo(paramProfileCardInfo);
    super.onInit(paramProfileCardInfo);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mCardInfo != null) {
      updateAvatarPendantImage(this.mCardInfo, false);
    }
  }
  
  public void onUpdate(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    updateAvatar(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    updateAvatarPendantImage(paramProfileCardInfo, false);
    updateHead(paramProfileCardInfo);
    updateDetail(paramProfileCardInfo);
    updateLike(paramProfileCardInfo);
    updateUinInfo(paramProfileCardInfo, this.mApp.getCurrentAccountUin());
    updateQidInfo(paramProfileCardInfo);
  }
  
  public void setProfileArgs(boolean paramBoolean)
  {
    this.mIsFromArkBabyQ = paramBoolean;
  }
  
  public void updateAvatarPendantImage(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    if (this.mAvatarPendant == null) {
      return;
    }
    if (!ProfileActivity.AllInOne.g(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.mAvatarPendant.setVisibility(8);
      this.mPendantId = 0L;
      return;
    }
    ThreadManager.post(new VasProfileQVipV5View.1(this, paramProfileCardInfo, paramBoolean), 8, null, true);
  }
  
  public void updateLike(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((paramProfileCardInfo.b) && (((TroopManager)localObject).n(paramProfileCardInfo.jdField_a_of_type_JavaLangString))) {}
    do
    {
      return;
      localObject = (View)this.mHeaderChildMap.get("map_key_like");
    } while (!(localObject instanceof VoteViewV2));
    VoteViewV2 localVoteViewV2 = (VoteViewV2)localObject;
    boolean bool1 = isShowZan(paramProfileCardInfo);
    if (this.mIsFromArkBabyQ) {
      bool1 = false;
    }
    for (;;)
    {
      boolean bool2 = TextUtils.equals(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.mApp.getCurrentAccountUin());
      if (bool1)
      {
        localVoteViewV2.setVisibility(0);
        int j;
        int i;
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null)
        {
          paramProfileCardInfo = this.mActivity.getString(2131691323);
          localObject = null;
          j = 0;
          bool1 = false;
          i = 0;
        }
        for (;;)
        {
          localVoteViewV2.a(bool2, bool1, i, j, this.mNewVoteAnimHelper, false);
          localVoteViewV2.setTag(localObject);
          localVoteViewV2.setOnClickListener(this.mOnClickListener);
          localVoteViewV2.setContentDescription(paramProfileCardInfo);
          return;
          if (this.mNewVoteAnimHelper == null) {
            this.mNewVoteAnimHelper = new NewVoteAnimHelper(this.mActivity, this.mApp, 1, 1);
          }
          i = (int)paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
          j = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
          if (1 == paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
          for (bool1 = true;; bool1 = false)
          {
            this.mNewVoteAnimHelper.a = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
            if (j <= this.mNewVoteAnimHelper.a.size()) {
              this.mNewVoteAnimHelper.a = this.mNewVoteAnimHelper.a.subList(0, j);
            }
            this.mNewVoteAnimHelper.a = PraiseConfigHelper.a(this.mNewVoteAnimHelper.a);
            if (!bool2) {
              break label359;
            }
            localObject = new DataTag(10, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
            paramProfileCardInfo = String.format(this.mActivity.getString(2131691321), new Object[] { String.valueOf(i) });
            break;
          }
          label359:
          localObject = new DataTag(10, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
          String str = String.format(this.mActivity.getString(2131691234), new Object[] { String.valueOf(i) });
          if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0) {
            localVoteViewV2.a();
          }
          paramProfileCardInfo = str;
        }
      }
      localVoteViewV2.setVisibility(4);
      return;
    }
  }
  
  public void updateLiked(ProfileCardInfo paramProfileCardInfo, long paramLong, boolean paramBoolean)
  {
    Object localObject = (View)this.mHeaderChildMap.get("map_key_like");
    if ((localObject instanceof VoteViewV2))
    {
      localObject = (VoteViewV2)localObject;
      long l = paramLong;
      if (paramLong == -1L) {
        l = ((VoteViewV2)localObject).e;
      }
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0)) {
        ((VoteViewV2)localObject).a();
      }
      ((VoteViewV2)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteViewV2)localObject).setContentDescription(String.format(this.mActivity.getString(2131691246), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void updateSexAgeArea(ProfileCardInfo paramProfileCardInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipV5View
 * JD-Core Version:    0.7.0.1
 */