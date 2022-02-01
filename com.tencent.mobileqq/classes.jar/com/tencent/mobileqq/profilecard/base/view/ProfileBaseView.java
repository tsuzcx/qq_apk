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
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.QidCoolTextView;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PullToZoomHeaderListView;
import java.util.HashMap;
import java.util.List;

public class ProfileBaseView
  extends AbsProfileHeaderView
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
  
  public ProfileBaseView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    this.mNewVoteAnimHelper = new NewVoteAnimHelper(paramBaseActivity, this.mApp, 3, 1);
  }
  
  private void initHeadUI()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "initHeadUI");
    }
    Object localObject = getContext();
    this.mHeadContainer = ((ViewGroup)this.mContentView.findViewById(2131369062));
    this.mAvatar = ((AvatarLayout)this.mContentView.findViewById(2131369058));
    this.mAvatar.setVisibility(0);
    DataTag localDataTag = new DataTag(1, null);
    if (this.mCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (localObject = ((Context)localObject).getString(2131691276);; localObject = ((Context)localObject).getString(2131691275))
    {
      this.mAvatar.setTag(localDataTag);
      this.mAvatar.setOnClickListener(this.mOnClickListener);
      this.mAvatar.setContentDescription((CharSequence)localObject);
      this.mAvatar.a(0, this.mAvatar.findViewById(2131363511), false);
      this.mHeaderChildMap.put("map_key_face", this.mAvatar);
      this.mHeaderChildMap.put("map_key_face_stoke", this.mContentView.findViewById(2131369060));
      this.mAvatarPendant = ((ImageView)this.mContentView.findViewById(2131368891));
      this.mHeaderChildMap.put("map_key_avatar_pendant", this.mAvatarPendant);
      this.mAvatarPendant.setVisibility(4);
      this.mAvatarPendant.setTag(localDataTag);
      this.mAvatarPendant.setOnClickListener(this.mOnClickListener);
      this.mNameLayout = this.mContentView.findViewById(2131374744);
      this.mNameView = ((ProfileNameView)this.mContentView.findViewById(2131372272));
      this.mHeaderChildMap.put("map_key_profile_nick_name", this.mNameView);
      this.mNameView.setVisibility(0);
      this.mNameView.setClickable(true);
      this.mNameView.setClickListener(this.mOnClickListener);
      this.mRemarkName = ((TextView)this.mContentView.findViewById(2131376901));
      this.mHeaderChildMap.put("map_key_profile_remark_name", this.mRemarkName);
      this.mVoteView = ((VoteViewV2)this.mContentView.findViewById(2131381767));
      this.mVoteHeartLayout = ((HeartLayout)this.mContentView.findViewById(2131368400));
      this.mHeaderChildMap.put("map_key_like", this.mVoteView);
      this.mVoteView.setHeartLayout(this.mApp, this.mVoteHeartLayout);
      this.mVoteHeartLayout.setEnabled(false);
      this.mUinLayout = this.mContentView.findViewById(2131374498);
      this.mUinInfoView = ((TextView)this.mContentView.findViewById(2131374496));
      this.mHeaderChildMap.put("map_key_uin_info", this.mUinInfoView);
      this.mQidInfoView = ((QidCoolTextView)this.mContentView.findViewById(2131374769));
      this.mHeaderChildMap.put("map_key_qid_info", this.mQidInfoView);
      this.mQidInfoView.setOnClickListener(this.mOnClickListener);
      return;
    }
  }
  
  private void updateQidViewMargin(ProfileCardInfo paramProfileCardInfo)
  {
    if (this.mQidInfoView != null)
    {
      int i = this.mQidInfoView.a(paramProfileCardInfo);
      if (i != 0) {
        this.mQidInfoView.a(0.0F, i);
      }
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
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
    return (this.mCoverView == null) || (this.mCoverView.a() == 1);
  }
  
  protected void loadHeadLayout(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "loadHeadLayout mode=" + paramInt);
    }
    View localView = LayoutInflater.from(getContext()).inflate(2131562166, this.mHeadContainer, false);
    if (localView != null)
    {
      this.mHeadContainer.removeAllViews();
      this.mHeadContainer.addView(localView);
    }
  }
  
  public void onCoverModeChange(int paramInt, ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, String.format("onCoverModeChange mode: %s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (paramInt == 1)
    {
      if (this.mNameView != null) {
        this.mNameView.setTextColor(getResources().getColor(2131167033));
      }
      if (this.mVoteView != null) {
        this.mVoteView.a(1);
      }
      localObject = (RelativeLayout.LayoutParams)this.mContentBgView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, 1);
      this.mContentBgView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mCoverView.setTag(null);
      this.mCoverView.setOnClickListener(null);
      this.mCoverView.setContentDescription(null);
      updateLayoutMargin(paramInt);
      updateQidViewMargin(paramProfileCardInfo);
      return;
    }
    int i;
    label166:
    DataTag localDataTag;
    if (this.mNameView != null)
    {
      if (ThemeUtil.isInNightMode(this.mApp))
      {
        i = 2131167033;
        this.mNameView.setTextColor(getResources().getColor(i));
      }
    }
    else
    {
      if (this.mVoteView != null) {
        this.mVoteView.a(0);
      }
      localObject = (RelativeLayout.LayoutParams)this.mContentBgView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131369078);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, 0);
      this.mContentBgView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localDataTag = new DataTag(17, null);
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label312;
      }
    }
    label312:
    for (Object localObject = getContext().getString(2131691271);; localObject = getContext().getString(2131691270))
    {
      this.mCoverView.setTag(localDataTag);
      this.mCoverView.setOnClickListener(this.mOnClickListener);
      this.mCoverView.setContentDescription((CharSequence)localObject);
      updateLayoutMargin(paramInt);
      break;
      i = 2131167197;
      break label166;
    }
  }
  
  protected void onInit(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = false;
    this.mContentView = LayoutInflater.from(getContext()).inflate(2131562165, this, true);
    this.mHeadContainer = ((ViewGroup)this.mContentView.findViewById(2131369062));
    this.mCoverView = ((RandomCoverView)this.mContentView.findViewById(2131369078));
    this.mListView.setHeaderImage(this.mCoverView.a());
    this.mListView.setHeaderMask(this.mCoverView.a());
    this.mListView.setProfileBaseView(this);
    int i;
    if (ProfileActivity.AllInOne.i(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
      i = 1;
    }
    for (;;)
    {
      this.mCoverView = ((RandomCoverView)this.mContentView.findViewById(2131369078));
      this.mContentBgView = this.mContentView.findViewById(2131369055);
      this.mHeaderChildMap.put("map_key_qzonecover", this.mCoverView);
      this.mCoverView.setVisibility(0);
      Object localObject1 = this.mCoverView;
      Object localObject2 = this.mApp;
      String str1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      String str2 = this.mCoverUrl;
      if (this.mCoverTimeStamp == 0) {
        bool = true;
      }
      ((RandomCoverView)localObject1).a((QQAppInterface)localObject2, str1, i, str2, bool, true);
      loadHeadLayout(i);
      initHeadUI();
      updateAvatar(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
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
        paramProfileCardInfo = (ImageView)this.mAvatar.findViewById(2131363511);
        localObject1 = (ImageView)this.mHeaderChildMap.get("map_key_face_stoke");
        localObject2 = this.mAvatarPendant;
        paramProfileCardInfo.setColorFilter(1996488704);
        ((ImageView)localObject1).setColorFilter(1996488704);
        ((ImageView)localObject2).setColorFilter(1996488704);
      }
      return;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getCoverData(this.mCoverTimeStamp);
        localObject2 = (String)localObject1[0];
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.mCoverUrl = ((String)localObject2);
          this.mCoverTimeStamp = ((Integer)localObject1[1]).intValue();
        }
        if ((TextUtils.isEmpty(this.mCoverUrl)) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover())) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label432;
          }
          i = 1;
          break;
        }
      }
      label432:
      i = 0;
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mContentBgView != null)
    {
      paramInt1 = this.mContentBgView.getLeft();
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
    updateAvatar(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
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
    if (!ProfileActivity.AllInOne.g(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
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
    int j = 1;
    boolean bool;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
    {
      Object localObject = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getCoverData(this.mCoverTimeStamp);
      String str = (String)localObject[0];
      if ((!TextUtils.isEmpty(str)) && (!str.equals(this.mCoverUrl)))
      {
        this.mCoverUrl = str;
        this.mCoverTimeStamp = ((Integer)localObject[1]).intValue();
        localObject = this.mCoverView;
        if (this.mCoverTimeStamp != 0) {
          break label150;
        }
        bool = true;
        ((RandomCoverView)localObject).a(str, bool);
      }
      if ((!TextUtils.isEmpty(this.mCoverUrl)) && (!paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover())) {
        break label156;
      }
      i = 1;
      label118:
      if (i == 0) {
        break label161;
      }
    }
    label150:
    label156:
    label161:
    for (int i = j;; i = 0)
    {
      if (this.mCoverView.a() != i)
      {
        this.mCoverView.a(i);
        onCoverModeChange(i, paramProfileCardInfo);
      }
      return;
      bool = false;
      break;
      i = 0;
      break label118;
    }
  }
  
  public void updateHead(ProfileCardInfo paramProfileCardInfo)
  {
    if (this.mNameView != null) {
      this.mNameView.a(this.mApp, paramProfileCardInfo);
    }
    if (this.mCoverView != null)
    {
      updateLayoutMargin(this.mCoverView.a());
      updateQidViewMargin(paramProfileCardInfo);
    }
  }
  
  public void updateLayoutMargin(int paramInt)
  {
    if ((this.mNameView == null) || (this.mUinLayout == null) || (this.mNameLayout == null)) {}
    int i;
    int j;
    do
    {
      return;
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
        ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131368302);
        this.mNameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      Object localObject = (ViewGroup.MarginLayoutParams)this.mVoteHeartLayout.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = ScreenUtil.dip2px(15.0F);
      this.mVoteHeartLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = getResources();
      i = ((Resources)localObject).getDimensionPixelSize(2131297612);
      j = ((Resources)localObject).getDimensionPixelSize(2131297614);
      localObject = (RelativeLayout.LayoutParams)this.mNameLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131368302);
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
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, String.format("updateLayoutMargin mode: %s, name:%s, level:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j) }));
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
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
 * JD-Core Version:    0.7.0.1
 */