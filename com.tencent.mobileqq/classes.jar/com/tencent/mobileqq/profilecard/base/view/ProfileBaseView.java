package com.tencent.mobileqq.profilecard.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
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
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.qid.QidCoolTextView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class ProfileBaseView
  extends AbsProfileHeaderView
  implements IProfileBaseView
{
  private AvatarLayout mAvatar;
  private ImageView mAvatarPendant;
  private boolean mClipChild = true;
  private Paint mClipPaint;
  private RectF mClipRect;
  private int mClipTop;
  private View mContentBgView;
  private View mContentView;
  private RandomCoverView mCoverView;
  private ViewGroup mHeadContainer;
  private boolean mIsFromArkBabyQ;
  private PullToZoomHeaderListView mListView;
  private View mNameLayout;
  private ProfileNameView mNameView;
  private QidCoolTextView mQidInfoView;
  private TextView mRemarkName;
  private TextView mUinInfoView;
  private View mUinLayout;
  private HeartLayout mVoteHeartLayout;
  private VoteViewV2 mVoteView;
  
  public ProfileBaseView(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo)
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
    this.mAvatarPendant.setVisibility(4);
    this.mAvatarPendant.setTag(localDataTag);
    this.mAvatarPendant.setOnClickListener(this.mOnClickListener);
    this.mNameLayout = this.mContentView.findViewById(2131374280);
    this.mNameView = ((ProfileNameView)this.mContentView.findViewById(2131371861));
    this.mHeaderChildMap.put("map_key_profile_nick_name", this.mNameView);
    this.mNameView.setVisibility(0);
    this.mNameView.setClickable(true);
    this.mNameView.setClickListener(this.mOnClickListener);
    this.mRemarkName = ((TextView)this.mContentView.findViewById(2131376390));
    this.mHeaderChildMap.put("map_key_profile_remark_name", this.mRemarkName);
    this.mVoteView = ((VoteViewV2)this.mContentView.findViewById(2131380996));
    this.mVoteHeartLayout = ((HeartLayout)this.mContentView.findViewById(2131368151));
    this.mHeaderChildMap.put("map_key_like", this.mVoteView);
    this.mVoteView.setHeartLayout(this.mApp, this.mVoteHeartLayout);
    this.mVoteHeartLayout.setEnabled(false);
    this.mUinLayout = this.mContentView.findViewById(2131374036);
    this.mUinInfoView = ((TextView)this.mContentView.findViewById(2131374034));
    this.mHeaderChildMap.put("map_key_uin_info", this.mUinInfoView);
    this.mQidInfoView = ((QidCoolTextView)this.mContentView.findViewById(2131374305));
    this.mHeaderChildMap.put("map_key_qid_info", this.mQidInfoView);
    this.mQidInfoView.setOnClickListener(this.mOnClickListener);
  }
  
  private void updateQidViewMargin(ProfileCardInfo paramProfileCardInfo)
  {
    QidCoolTextView localQidCoolTextView = this.mQidInfoView;
    if (localQidCoolTextView != null)
    {
      int i = localQidCoolTextView.a(paramProfileCardInfo);
      if (i != 0) {
        this.mQidInfoView.a(0.0F, i);
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (!this.mClipChild)
    {
      if (this.mClipRect == null) {
        this.mClipRect = new RectF();
      }
      if (this.mClipPaint == null) {
        this.mClipPaint = new Paint();
      }
      this.mClipRect.set(getLeft(), this.mClipTop, getRight(), getBottom());
      paramCanvas.save();
      paramCanvas.clipRect(this.mClipRect);
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean isInNoCoverMode()
  {
    RandomCoverView localRandomCoverView = this.mCoverView;
    boolean bool = true;
    if (localRandomCoverView != null)
    {
      if (localRandomCoverView.a() == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  protected void loadHeadLayout(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadHeadLayout mode=");
      localStringBuilder.append(paramInt);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = LayoutInflater.from(getContext()).inflate(2131562003, this.mHeadContainer, false);
    if (localObject != null)
    {
      this.mHeadContainer.removeAllViews();
      this.mHeadContainer.addView((View)localObject);
    }
  }
  
  public void onCoverModeChange(int paramInt, ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, String.format("onCoverModeChange mode: %s", new Object[] { Integer.valueOf(paramInt) }));
    }
    int i = 2131167056;
    Object localObject;
    if (paramInt == 1)
    {
      localObject = this.mNameView;
      if (localObject != null) {
        ((ProfileNameView)localObject).setTextColor(getResources().getColor(2131167056));
      }
      localObject = this.mVoteView;
      if (localObject != null) {
        ((VoteViewV2)localObject).a(1);
      }
      localObject = (RelativeLayout.LayoutParams)this.mContentBgView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, 1);
      this.mContentBgView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mCoverView.setTag(null);
      this.mCoverView.setOnClickListener(null);
      this.mCoverView.setContentDescription(null);
      updateLayoutMargin(paramInt);
    }
    else
    {
      if (this.mNameView != null)
      {
        if (!ThemeUtil.isInNightMode(this.mApp)) {
          i = 2131167222;
        }
        this.mNameView.setTextColor(getResources().getColor(i));
      }
      localObject = this.mVoteView;
      if (localObject != null) {
        ((VoteViewV2)localObject).a(0);
      }
      localObject = (RelativeLayout.LayoutParams)this.mContentBgView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131368800);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, 0);
      this.mContentBgView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      DataTag localDataTag = new DataTag(17, null);
      if (paramProfileCardInfo.allInOne.pa == 0) {
        localObject = getContext().getString(2131691192);
      } else {
        localObject = getContext().getString(2131691191);
      }
      this.mCoverView.setTag(localDataTag);
      this.mCoverView.setOnClickListener(this.mOnClickListener);
      this.mCoverView.setContentDescription((CharSequence)localObject);
      updateLayoutMargin(paramInt);
    }
    updateQidViewMargin(paramProfileCardInfo);
  }
  
  protected void onInit(ProfileCardInfo paramProfileCardInfo)
  {
    this.mContentView = LayoutInflater.from(getContext()).inflate(2131562002, this, true);
    this.mHeadContainer = ((ViewGroup)this.mContentView.findViewById(2131368784));
    this.mCoverView = ((RandomCoverView)this.mContentView.findViewById(2131368800));
    this.mListView.setHeaderImage(this.mCoverView.a());
    this.mListView.setHeaderMask(this.mCoverView.a());
    this.mListView.setProfileBaseView(this);
    if (ProfilePAUtils.isPaTypeStrangerInContact(paramProfileCardInfo.allInOne)) {}
    do
    {
      i = 1;
      break label199;
      if (paramProfileCardInfo.card == null) {
        break;
      }
      localObject1 = paramProfileCardInfo.card.getCoverData(this.mCoverTimeStamp);
      localObject2 = (String)localObject1[0];
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.mCoverUrl = ((String)localObject2);
        this.mCoverTimeStamp = ((Integer)localObject1[1]).intValue();
      }
      if ((!TextUtils.isEmpty(this.mCoverUrl)) && (!paramProfileCardInfo.card.isNoCover())) {
        i = 0;
      } else {
        i = 1;
      }
    } while (i != 0);
    int i = 0;
    label199:
    this.mCoverView = ((RandomCoverView)this.mContentView.findViewById(2131368800));
    this.mContentBgView = this.mContentView.findViewById(2131368777);
    this.mHeaderChildMap.put("map_key_qzonecover", this.mCoverView);
    this.mCoverView.setVisibility(0);
    Object localObject1 = this.mCoverView;
    Object localObject2 = this.mApp;
    String str1 = paramProfileCardInfo.allInOne.uin;
    String str2 = this.mCoverUrl;
    boolean bool;
    if (this.mCoverTimeStamp == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((RandomCoverView)localObject1).a((QQAppInterface)localObject2, str1, i, str2, bool, true);
    loadHeadLayout(i);
    initHeadUI();
    updateAvatar(paramProfileCardInfo.allInOne);
    updateAvatarPendantImage(paramProfileCardInfo, true);
    updateHead(paramProfileCardInfo);
    updateDetail(paramProfileCardInfo);
    updateLike(paramProfileCardInfo);
    updateUinInfo(paramProfileCardInfo, this.mApp.getCurrentAccountUin());
    updateQidInfo(paramProfileCardInfo);
    super.onInit(paramProfileCardInfo);
    onCoverModeChange(i, paramProfileCardInfo);
    if (ThemeUtil.isInNightMode(this.mApp))
    {
      paramProfileCardInfo = (ImageView)this.mAvatar.findViewById(2131363438);
      localObject1 = (ImageView)this.mHeaderChildMap.get("map_key_face_stoke");
      localObject2 = this.mAvatarPendant;
      paramProfileCardInfo.setColorFilter(1996488704);
      ((ImageView)localObject1).setColorFilter(1996488704);
      ((ImageView)localObject2).setColorFilter(1996488704);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.mContentBgView;
    if (localView != null)
    {
      paramInt1 = localView.getLeft();
      paramInt2 = this.mContentBgView.getTop();
      paramInt3 = this.mContentBgView.getRight();
      this.mContentBgView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
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
    updateCover(paramProfileCardInfo);
    updateAvatar(paramProfileCardInfo.allInOne);
    updateAvatarPendantImage(paramProfileCardInfo, false);
    updateHead(paramProfileCardInfo);
    updateDetail(paramProfileCardInfo);
    updateLike(paramProfileCardInfo);
    updateUinInfo(paramProfileCardInfo, this.mApp.getCurrentAccountUin());
    updateQidInfo(paramProfileCardInfo);
  }
  
  public void setClipChildren(boolean paramBoolean)
  {
    this.mClipChild = paramBoolean;
    super.setClipChildren(paramBoolean);
  }
  
  public void setProfileArgs(PullToZoomHeaderListView paramPullToZoomHeaderListView, boolean paramBoolean)
  {
    this.mListView = paramPullToZoomHeaderListView;
    this.mIsFromArkBabyQ = paramBoolean;
  }
  
  public void updateAvatarPendantImage(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    if (this.mAvatarPendant == null) {
      return;
    }
    if (!ProfilePAUtils.isPaTypeHasUin(paramProfileCardInfo.allInOne))
    {
      this.mAvatarPendant.setVisibility(4);
      this.mPendantId = 0L;
      return;
    }
    ThreadManager.post(new ProfileBaseView.1(this, paramProfileCardInfo, paramBoolean), 8, null, true);
  }
  
  public void updateClipTop(int paramInt)
  {
    this.mClipTop = paramInt;
    invalidate();
  }
  
  protected void updateCover(ProfileCardInfo paramProfileCardInfo)
  {
    if (paramProfileCardInfo.card != null)
    {
      Object localObject = paramProfileCardInfo.card.getCoverData(this.mCoverTimeStamp);
      int i = 0;
      String str = (String)localObject[0];
      if ((!TextUtils.isEmpty(str)) && (!str.equals(this.mCoverUrl)))
      {
        this.mCoverUrl = str;
        this.mCoverTimeStamp = ((Integer)localObject[1]).intValue();
        localObject = this.mCoverView;
        boolean bool;
        if (this.mCoverTimeStamp == 0) {
          bool = true;
        } else {
          bool = false;
        }
        ((RandomCoverView)localObject).a(str, bool);
      }
      if ((TextUtils.isEmpty(this.mCoverUrl)) || (paramProfileCardInfo.card.isNoCover())) {
        i = 1;
      }
      if (this.mCoverView.a() != i)
      {
        this.mCoverView.a(i);
        onCoverModeChange(i, paramProfileCardInfo);
      }
    }
  }
  
  public void updateHead(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = this.mNameView;
    if (localObject != null) {
      ((ProfileNameView)localObject).a(this.mApp, paramProfileCardInfo);
    }
    localObject = this.mCoverView;
    if (localObject != null)
    {
      updateLayoutMargin(((RandomCoverView)localObject).a());
      updateQidViewMargin(paramProfileCardInfo);
    }
  }
  
  public void updateLayoutMargin(int paramInt)
  {
    if ((this.mNameView != null) && (this.mUinLayout != null))
    {
      if (this.mNameLayout == null) {
        return;
      }
      if (paramInt == 1)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.mVoteHeartLayout.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = ScreenUtil.dip2px(5.0F);
        this.mVoteHeartLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (this.mNameView.c() == 2)
        {
          localObject = (RelativeLayout.LayoutParams)this.mNameLayout.getLayoutParams();
          if (this.mRemarkName.getVisibility() == 0)
          {
            ((RelativeLayout.LayoutParams)localObject).bottomMargin = ScreenUtil.dip2px(-2.0F);
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mUinLayout.getLayoutParams();
            localLayoutParams.addRule(3, this.mNameLayout.getId());
            this.mUinLayout.setLayoutParams(localLayoutParams);
          }
          ((RelativeLayout.LayoutParams)localObject).addRule(6, this.mAvatar.getId());
          ((RelativeLayout.LayoutParams)localObject).addRule(8, 0);
          this.mNameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          return;
        }
        localObject = (RelativeLayout.LayoutParams)this.mNameLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(6, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131368054);
        this.mNameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      Object localObject = (ViewGroup.MarginLayoutParams)this.mVoteHeartLayout.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = ScreenUtil.dip2px(15.0F);
      this.mVoteHeartLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = getResources();
      int i = ((Resources)localObject).getDimensionPixelSize(2131297603);
      int j = ((Resources)localObject).getDimensionPixelSize(2131297605);
      localObject = (RelativeLayout.LayoutParams)this.mNameLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131368054);
      this.mNameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (ViewGroup.MarginLayoutParams)this.mNameLayout.getLayoutParams();
      if (((ViewGroup.MarginLayoutParams)localObject).bottomMargin != i)
      {
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = i;
        this.mNameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = (ViewGroup.MarginLayoutParams)this.mUinLayout.getLayoutParams();
      if (((ViewGroup.MarginLayoutParams)localObject).topMargin != j)
      {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = j;
        this.mUinLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, String.format("updateLayoutMargin mode: %s, name:%s, level:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j) }));
      }
    }
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
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
 * JD-Core Version:    0.7.0.1
 */