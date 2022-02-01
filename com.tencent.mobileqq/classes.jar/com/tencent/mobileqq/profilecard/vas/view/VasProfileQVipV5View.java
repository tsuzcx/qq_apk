package com.tencent.mobileqq.profilecard.vas.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.qid.QidCoolTextView;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
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
  
  public VasProfileQVipV5View(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramQBaseActivity, paramProfileCardInfo);
    this.mNewVoteAnimHelper = new NewVoteAnimHelper(paramQBaseActivity, this.mApp, 3, 1);
  }
  
  private void initHeadUI()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "initHeadUI");
    }
    Object localObject = getContext();
    this.mHeadContainer = ((ViewGroup)this.mContentView.findViewById(2131368784));
    this.mAvatar = ((AvatarLayout)this.mContentView.findViewById(2131368780));
    this.mAvatar.setVisibility(0);
    DataTag localDataTag = new DataTag(1, null);
    if (this.mCardInfo.allInOne.pa == 0) {
      localObject = ((Context)localObject).getString(2131691197);
    } else {
      localObject = ((Context)localObject).getString(2131691196);
    }
    this.mAvatar.setTag(localDataTag);
    this.mAvatar.setOnClickListener(this.mOnClickListener);
    this.mAvatar.setContentDescription((CharSequence)localObject);
    localObject = this.mAvatar;
    ((AvatarLayout)localObject).a(0, ((AvatarLayout)localObject).findViewById(2131363438), false);
    this.mHeaderChildMap.put("map_key_face", this.mAvatar);
    this.mHeaderChildMap.put("map_key_face_stoke", this.mContentView.findViewById(2131368782));
    this.mAvatarPendant = ((ImageView)this.mContentView.findViewById(2131368617));
    this.mHeaderChildMap.put("map_key_avatar_pendant", this.mAvatarPendant);
    this.mAvatarPendant.setVisibility(8);
    this.mAvatarPendant.setTag(localDataTag);
    this.mAvatarPendant.setOnClickListener(this.mOnClickListener);
    this.mNameView = ((ProfileNameView)this.mContentView.findViewById(2131371861));
    localObject = this.mNameView;
    long l = this.mCardInfo.card.backgroundColor;
    int j = -16777216;
    int i;
    if (l == 1L) {
      i = -16777216;
    } else {
      i = -1;
    }
    ((ProfileNameView)localObject).setTextColor(i);
    this.mHeaderChildMap.put("map_key_profile_nick_name", this.mNameView);
    this.mNameView.setVisibility(0);
    this.mNameView.setClickable(true);
    this.mNameView.setClickListener(this.mOnClickListener);
    this.mRemarkName = ((TextView)this.mContentView.findViewById(2131376390));
    this.mHeaderChildMap.put("map_key_profile_remark_name", this.mRemarkName);
    this.mAccountInfoView = this.mContentView.findViewById(2131374206);
    this.mHeaderChildMap.put("map_key_details", this.mAccountInfoView);
    this.mVoteView = ((VoteViewV2)this.mContentView.findViewById(2131380996));
    this.mVoteHeartLayout = ((HeartLayout)this.mContentView.findViewById(2131368151));
    this.mHeaderChildMap.put("map_key_like", this.mVoteView);
    this.mVoteView.setHeartLayout(this.mApp, this.mVoteHeartLayout);
    this.mVoteView.a(0);
    this.mVoteHeartLayout.setEnabled(false);
    this.mUinInfoView = ((TextView)this.mContentView.findViewById(2131374034));
    localObject = this.mUinInfoView;
    if (this.mCardInfo.card.backgroundColor == 1L) {
      i = j;
    } else {
      i = -1;
    }
    ((TextView)localObject).setTextColor(i);
    this.mHeaderChildMap.put("map_key_uin_info", this.mUinInfoView);
    this.mQidInfoView = ((QidCoolTextView)this.mContentView.findViewById(2131374305));
    this.mHeaderChildMap.put("map_key_qid_info", this.mQidInfoView);
    this.mQidInfoView.setOnClickListener(this.mOnClickListener);
    localObject = this.mQidInfoView;
    float f;
    if (PrettyAccountUtil.a(this.mCardInfo.card) == 1) {
      f = 8.5F;
    } else {
      f = 7.0F;
    }
    ((QidCoolTextView)localObject).a(f, 0.0F);
  }
  
  protected void loadHeadLayout(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" needRefreshUI=");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = LayoutInflater.from(getContext()).inflate(2131562021, this.mHeadContainer, false);
    if (localObject != null)
    {
      this.mHeadContainer.removeAllViews();
      this.mHeadContainer.addView((View)localObject);
      if (paramBoolean)
      {
        initHeadUI();
        updateAvatar(this.mCardInfo.allInOne);
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
    this.mContentView = LayoutInflater.from(getContext()).inflate(2131562035, this, true);
    this.mHeadContainer = ((ViewGroup)this.mContentView.findViewById(2131368784));
    loadHeadLayout(false);
    initHeadUI();
    updateAvatar(paramProfileCardInfo.allInOne);
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
    updateAvatar(paramProfileCardInfo.allInOne);
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
    if (!ProfilePAUtils.isPaTypeHasUin(paramProfileCardInfo.allInOne))
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
    if ((paramProfileCardInfo.isTroopMemberCard) && (((TroopManager)localObject).m(paramProfileCardInfo.troopUin))) {
      return;
    }
    localObject = (View)this.mHeaderChildMap.get("map_key_like");
    if ((localObject instanceof VoteViewV2))
    {
      VoteViewV2 localVoteViewV2 = (VoteViewV2)localObject;
      boolean bool1 = isShowZan(paramProfileCardInfo);
      if (this.mIsFromArkBabyQ) {
        bool1 = false;
      }
      boolean bool2 = TextUtils.equals(paramProfileCardInfo.allInOne.uin, this.mApp.getCurrentAccountUin());
      if (bool1)
      {
        localVoteViewV2.setVisibility(0);
        int j;
        int i;
        if (paramProfileCardInfo.card == null)
        {
          paramProfileCardInfo = this.mActivity.getString(2131691244);
          j = 0;
          bool1 = false;
          localObject = null;
          i = 0;
        }
        else
        {
          if (this.mNewVoteAnimHelper == null) {
            this.mNewVoteAnimHelper = new NewVoteAnimHelper(this.mActivity, this.mApp, 1, 1);
          }
          j = (int)paramProfileCardInfo.card.lVoteCount;
          i = paramProfileCardInfo.card.iVoteIncrement;
          if (1 == paramProfileCardInfo.card.bVoted) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          this.mNewVoteAnimHelper.a = paramProfileCardInfo.card.getLastPraiseInfoList();
          if (i <= this.mNewVoteAnimHelper.a.size()) {
            this.mNewVoteAnimHelper.a = this.mNewVoteAnimHelper.a.subList(0, i);
          }
          this.mNewVoteAnimHelper.a = PraiseConfigHelper.a(this.mNewVoteAnimHelper.a);
          if (bool2)
          {
            localObject = new DataTag(10, paramProfileCardInfo.card);
            paramProfileCardInfo = String.format(this.mActivity.getString(2131691242), new Object[] { String.valueOf(j) });
          }
          else
          {
            localObject = new DataTag(10, paramProfileCardInfo.card);
            String str = String.format(this.mActivity.getString(2131691155), new Object[] { String.valueOf(j) });
            if (paramProfileCardInfo.card.bAvailVoteCnt == 0) {
              localVoteViewV2.a();
            }
            paramProfileCardInfo = str;
          }
        }
        localVoteViewV2.a(bool2, bool1, j, i, this.mNewVoteAnimHelper, false);
        localVoteViewV2.setTag(localObject);
        localVoteViewV2.setOnClickListener(this.mOnClickListener);
        localVoteViewV2.setContentDescription(paramProfileCardInfo);
        return;
      }
      localVoteViewV2.setVisibility(4);
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
      if ((paramProfileCardInfo.card != null) && (paramProfileCardInfo.card.bAvailVoteCnt == 0)) {
        ((VoteViewV2)localObject).a();
      }
      ((VoteViewV2)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteViewV2)localObject).setContentDescription(String.format(this.mActivity.getString(2131691167), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void updateSexAgeArea(ProfileCardInfo paramProfileCardInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipV5View
 * JD-Core Version:    0.7.0.1
 */