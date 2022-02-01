package com.tencent.mobileqq.profilecard.vas.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.view.BreatheEffectView;
import com.tencent.mobileqq.profile.view.BreatheEffectView.BreatheListener;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.profile.view.helper.HeartRiseLayerDrawable;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector;
import com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector.DragSource;
import com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector.Draggable;
import com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector.DropTarget;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.RatioLayout;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class VasProfileTagView
  extends AbsProfileHeaderView
  implements Animator.AnimatorListener, DragAndDropDetector.DragSource
{
  private static final int AUTO_FULL_SCREEN_DELAY = 300;
  private static final float ROTATION_DEGREE = 120.0F;
  private static String TAG = "ProfileTagView";
  private static final int[] TAG_ADD_ORDER = { 3, 1, 0, 5, 4, 2, 6 };
  private static PointF[] TAG_POS = { new PointF(0.126562F, 0.478873F), new PointF(0.220312F, 0.242077F), new PointF(0.559375F, 0.206866F), new PointF(0.85F, 0.279049F), new PointF(0.889062F, 0.440141F), new PointF(0.815625F, 0.61F), new PointF(0.521875F, 0.75F), new PointF(0.18125F, 0.705F) };
  private static final String TAG_PRAISE_KEY = "%s-%d";
  BreatheEffectView.BreatheListener aniEndBreatheListener;
  public boolean isDragging;
  public boolean isFullScreen;
  private TextView mAddTagTips;
  private ValueAnimator mAnimEnterFullScreen;
  private ValueAnimator mAnimLeaveFullScreen;
  private ImageView mAvatarPendantImage;
  private TextView mBasicInfoLabel;
  private Drawable mBlurBackground;
  private BreatheEffectView mBreatheView;
  private int mColorScheme;
  private IComponentCenter mComponentCenter;
  private IProfileActivityDelegate mDelegate;
  private ValueAnimator[] mDiffuseAnims;
  private final int mDistanceThreshold;
  private DragAndDropDetector mDragDetector;
  private boolean mFromExtendFriend;
  private int mFullScreenHeight;
  private ValueAnimator[] mGatherAnims;
  private GestureDetector mGestureDetector;
  private HeartRiseLayerDrawable mHeartRiseDrawable;
  private boolean mIsFirstAnimation;
  private boolean mIsFullAnimPlaying = false;
  private boolean mIsScrollByExtendFriend;
  private boolean mIsScrolled;
  private SharedPreferences mLikedTagStoreSP;
  private ProfileNameView mNickLabel;
  private Drawable mNormalBackground;
  private int[] mOffsetOnScreen = new int[2];
  private PointF mPhotoFullPos;
  private PointF mPhotoInitPos;
  private AvatarLayout mPhotoView;
  ValueAnimator.AnimatorUpdateListener mSwitchScreenUpdateListener;
  private int mTagAnimCount;
  private int[] mTagCloudInWindow = new int[2];
  private RatioLayout mTagCloudLayout;
  private boolean mTagCloudNeedUpdate;
  private View[] mTagViews;
  
  public VasProfileTagView(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramQBaseActivity, paramProfileCardInfo);
    paramProfileCardInfo = TAG_POS;
    this.mTagViews = new View[paramProfileCardInfo.length];
    this.mDiffuseAnims = new ValueAnimator[paramProfileCardInfo.length];
    this.mGatherAnims = new ValueAnimator[paramProfileCardInfo.length];
    this.mIsScrollByExtendFriend = false;
    this.mIsFirstAnimation = true;
    this.isDragging = false;
    this.isFullScreen = false;
    this.mSwitchScreenUpdateListener = new VasProfileTagView.4(this);
    this.aniEndBreatheListener = new VasProfileTagView.5(this);
    this.mDistanceThreshold = paramQBaseActivity.getResources().getDimensionPixelSize(2131299353);
  }
  
  private void addAnimationListener(View paramView, PointF paramPointF, ValueAnimator paramValueAnimator)
  {
    paramValueAnimator.addListener(new VasProfileTagView.11(this, paramView, paramPointF));
  }
  
  private void addProfileTag(int paramInt, List<ProfileLabelInfo> paramList, ProfileCardInfo paramProfileCardInfo)
  {
    int i = 0;
    while (i < paramInt)
    {
      ProfileLabelInfo localProfileLabelInfo = (ProfileLabelInfo)paramList.get(i);
      Object localObject;
      if (this.mTagViews[i] == null)
      {
        localObject = new VipTagView(getContext());
        this.mTagViews[i] = localObject;
        this.mTagCloudLayout.addView((View)localObject);
        ((VipTagView)localObject).setGravity(17);
        ((VipTagView)localObject).setTag(2131443124, Integer.valueOf(i));
        ((VipTagView)localObject).setTag(2131443126, Integer.valueOf(TAG_ADD_ORDER[i]));
        ((VipTagView)localObject).setTextColor(-1);
      }
      VipTagView localVipTagView = (VipTagView)this.mTagViews[i];
      if ((this.isFullScreen) && (!this.mIsFullAnimPlaying))
      {
        localObject = TAG_POS[TAG_ADD_ORDER[i]];
        localObject = new RatioLayout.LayoutParams(-2, -2, 0.5F, 0.5F, ((PointF)localObject).x, ((PointF)localObject).y);
        localVipTagView.setVisibility(0);
        localVipTagView.setShakingState(true);
      }
      else
      {
        localObject = new RatioLayout.LayoutParams(-2, -2, 0.5F, 0.5F, 0.5F, 0.5F);
        localVipTagView.setVisibility(4);
      }
      localVipTagView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localVipTagView.setLabelAndPraise(localProfileLabelInfo.labelName, localProfileLabelInfo.likeNum.intValue());
      localVipTagView.setTag(2131443125, localProfileLabelInfo.labelId);
      if ((checkTagLiked(localVipTagView)) && (paramProfileCardInfo.allInOne.pa != 0)) {
        localVipTagView.setTagColor(getResources().getColor(2131167537), getResources().getColor(2131167535));
      } else {
        localVipTagView.setTagColor(getResources().getColor(2131167536), getResources().getColor(2131167534));
      }
      i += 1;
    }
  }
  
  private ValueAnimator enterFullScreen()
  {
    Object localObject = this.mDelegate;
    if (localObject != null) {
      ((IProfileActivityDelegate)localObject).scrollToListTop();
    }
    if (this.mFullScreenHeight == 0)
    {
      this.mFullScreenHeight = this.mActivity.findViewById(16908290).getHeight();
      localObject = this.mActivity.findViewById(2131430077);
      if (localObject != null) {
        this.mFullScreenHeight -= ((View)localObject).getHeight();
      }
    }
    localObject = this.mAnimEnterFullScreen;
    if (localObject == null)
    {
      this.mAnimEnterFullScreen = ObjectAnimator.ofInt(new int[] { this.mTagCloudLayout.getHeight(), this.mFullScreenHeight });
      return this.mAnimEnterFullScreen;
    }
    ((ValueAnimator)localObject).start();
    return null;
  }
  
  private ValueAnimator exitFullScreen()
  {
    ValueAnimator localValueAnimator = this.mAnimLeaveFullScreen;
    if (localValueAnimator == null)
    {
      this.mAnimLeaveFullScreen = ObjectAnimator.ofInt(new int[] { this.mTagCloudLayout.getHeight(), getResources().getDimensionPixelSize(2131299344) });
      return this.mAnimLeaveFullScreen;
    }
    localValueAnimator.start();
    return null;
  }
  
  private RatioLayout.LayoutParams getTagLayoutParams(View paramView)
  {
    Object localObject = (RatioLayout.LayoutParams)paramView.getLayoutParams();
    ((RatioLayout.LayoutParams)localObject).a = 0.5F;
    ((RatioLayout.LayoutParams)localObject).b = 0.5F;
    ((RatioLayout.LayoutParams)localObject).c = 0.5F;
    ((RatioLayout.LayoutParams)localObject).d = 0.5F;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramView = (RatioLayout.LayoutParams)this.mAddTagTips.getLayoutParams();
    localObject = TAG_POS;
    localObject = localObject[(localObject.length - 1)];
    paramView.a = (((PointF)localObject).x + 0.07F);
    paramView.b = ((PointF)localObject).y;
    paramView.c = 0.0F;
    paramView.d = 0.5F;
    return paramView;
  }
  
  private void hideOldProcileTag(int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      View localView = this.mTagViews[i];
      if (((localView instanceof VipTagView)) && (localView.getVisibility() != 8))
      {
        ((VipTagView)localView).setShakingState(false);
        localView.setVisibility(8);
      }
      i += 1;
    }
  }
  
  private void initMainView(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131628457, this, true);
  }
  
  private void loadColorScreen(IComponentCenter paramIComponentCenter)
  {
    if (paramIComponentCenter != null)
    {
      paramIComponentCenter = (ProfileColorScreenComponent)paramIComponentCenter.getComponent(1004);
      if (paramIComponentCenter != null) {
        paramIComponentCenter.loadColorScreen();
      }
    }
  }
  
  private void updateAddTagTips()
  {
    if (!checkTagUpdateFlag())
    {
      List localList = this.mCardInfo.card.getLabelList();
      if (localList != null) {
        if ((this.mTagViews[(TAG_POS.length - 1)] != null) && (localList.size() == 0)) {
          this.mAddTagTips.setVisibility(0);
        } else {
          this.mAddTagTips.setVisibility(4);
        }
      }
    }
    if (this.mIsFirstAnimation)
    {
      updateJueban(this.mCardInfo);
      this.mIsFirstAnimation = false;
    }
  }
  
  private void updateAvatarArea(ProfileCardInfo paramProfileCardInfo, Context paramContext)
  {
    this.mPhotoView = ((AvatarLayout)findViewById(2131435701));
    Object localObject = this.mPhotoView;
    ((AvatarLayout)localObject).a(0, ((AvatarLayout)localObject).findViewById(2131429335), false);
    this.mHeaderChildMap.put("map_key_face", this.mPhotoView);
    super.updateAvatar(paramProfileCardInfo.allInOne);
    localObject = new DataTag(1, null);
    this.mPhotoView.setTag(localObject);
    this.mPhotoView.setOnClickListener(this.mOnClickListener);
    if (paramProfileCardInfo.allInOne.pa == 0) {
      paramContext = paramContext.getString(2131888143);
    } else {
      paramContext = paramContext.getString(2131888142);
    }
    this.mPhotoView.setContentDescription(paramContext);
    this.mAvatarPendantImage = ((ImageView)findViewById(2131435529));
    this.mAvatarPendantImage.setVisibility(4);
    this.mAvatarPendantImage.setOnClickListener(this.mOnClickListener);
    this.mAvatarPendantImage.setTag(localObject);
    this.mHeaderChildMap.put("map_key_avatar_pendant", this.mAvatarPendantImage);
    super.updateAvatarPendantImage(paramProfileCardInfo, true);
  }
  
  private void updateBaseInfoArea(ProfileCardInfo paramProfileCardInfo)
  {
    this.mBasicInfoLabel = ((TextView)findViewById(2131435708));
    this.mHeaderChildMap.put("map_key_sex_age_area", this.mBasicInfoLabel);
    super.updateSexAgeArea(paramProfileCardInfo);
  }
  
  private void updateHeadArea(ProfileCardInfo paramProfileCardInfo)
  {
    this.mNickLabel = ((ProfileNameView)findViewById(2131435716));
    this.mNickLabel.setClickListener(this.mOnClickListener);
    this.mHeaderChildMap.put("map_key_profile_nick_name", this.mNickLabel);
    super.updateHead(paramProfileCardInfo);
  }
  
  private void updateLikeArea(ProfileCardInfo paramProfileCardInfo)
  {
    VoteView localVoteView = (VoteView)findViewById(2131449991);
    HeartLayout localHeartLayout = (HeartLayout)findViewById(2131435008);
    localHeartLayout.setEnabled(false);
    localVoteView.setHeartLayout(this.mApp, localHeartLayout);
    this.mHeaderChildMap.put("map_key_like", localVoteView);
    super.updateLike(paramProfileCardInfo);
  }
  
  private void updateTagArea()
  {
    this.mTagCloudLayout = ((RatioLayout)findViewById(2131446796));
    this.mHeaderChildMap.put("map_key_tag_cloud", this.mTagCloudLayout);
  }
  
  private void updateTipArea()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131435746);
    this.mHeaderChildMap.put("map_key_tips", localLinearLayout);
  }
  
  void addLike(VipTagView paramVipTagView, long paramLong)
  {
    Object localObject = String.format("%s-%d", new Object[] { this.mCardInfo.card.uin, Long.valueOf(paramLong) });
    if (!this.mLikedTagStoreSP.getBoolean((String)localObject, false))
    {
      ReportController.b(this.mApp, "CliOper", "", "", "card_mall", "0X80047EF", 0, 0, Long.toString(paramLong), "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "appreciate the label");
      }
      this.mLikedTagStoreSP.edit().putBoolean((String)localObject, true).commit();
      localObject = (CardHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (localObject == null) {
        return;
      }
      ((CardHandler)localObject).a(this.mApp.getCurrentAccountUin(), this.mCardInfo.card.uin, Long.valueOf(paramLong));
      if (QLog.isColorLevel())
      {
        localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("submit the network params ：srcUin = ");
        localStringBuilder.append(this.mApp.getCurrentAccountUin());
        localStringBuilder.append("destUin  = ");
        localStringBuilder.append(this.mCardInfo.card.uin);
        localStringBuilder.append(" labelId  = ");
        localStringBuilder.append(paramLong);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      paramVipTagView.a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "the label has appreciated");
    }
    paramVipTagView.setShakingState(true);
  }
  
  boolean checkTagLiked(VipTagView paramVipTagView)
  {
    if (paramVipTagView.getTag(2131443125) == null) {
      return false;
    }
    long l = ((Long)paramVipTagView.getTag(2131443125)).longValue();
    if ((this.mCardInfo != null) && (this.mCardInfo.card != null) && (!TextUtils.isEmpty(this.mCardInfo.card.uin)))
    {
      paramVipTagView = String.format("%s-%d", new Object[] { this.mCardInfo.card.uin, Long.valueOf(l) });
      return this.mLikedTagStoreSP.getBoolean(paramVipTagView, false);
    }
    return false;
  }
  
  boolean checkTagUpdateFlag()
  {
    if (this.mTagCloudNeedUpdate)
    {
      this.mTagCloudNeedUpdate = false;
      updateTagCloud(this.mCardInfo);
      return true;
    }
    return false;
  }
  
  void doTagScale(VipTagView paramVipTagView)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.2F, 1.0F, 0.2F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(150L);
    localScaleAnimation.setRepeatMode(2);
    localScaleAnimation.setRepeatCount(1);
    localScaleAnimation.setAnimationListener(new VasProfileTagView.6(this, paramVipTagView));
    paramVipTagView.startAnimation(localScaleAnimation);
  }
  
  void doTagSpringBack(VipTagView paramVipTagView, boolean paramBoolean)
  {
    Object localObject1 = (RatioLayout.LayoutParams)paramVipTagView.getLayoutParams();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = paramVipTagView.getTag(2131443126);
    if (localObject2 != null)
    {
      int i = ((Integer)localObject2).intValue();
      float f1 = TAG_POS[i].x;
      float f2 = TAG_POS[i].y;
      float f3 = (paramVipTagView.getLeft() + paramVipTagView.getWidth() * ((RatioLayout.LayoutParams)localObject1).c) / this.mTagCloudLayout.getWidth();
      float f4 = (paramVipTagView.getTop() + paramVipTagView.getHeight() * ((RatioLayout.LayoutParams)localObject1).d) / this.mTagCloudLayout.getHeight();
      localObject1 = ObjectAnimator.ofObject(new VasProfileTagView.7(this), new Object[] { new PointF(f3, f4), new PointF(f1, f2) });
      ((ValueAnimator)localObject1).addUpdateListener(new VasProfileTagView.8(this, paramVipTagView));
      ((ValueAnimator)localObject1).setDuration(400L);
      ((ValueAnimator)localObject1).addListener(new VasProfileTagView.9(this, paramBoolean, paramVipTagView));
      ((ValueAnimator)localObject1).start();
    }
  }
  
  public DragAndDropDetector.Draggable findDraggableByPos(float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = new int[2];
    View[] arrayOfView = this.mTagViews;
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = arrayOfView[i];
      if (((localView instanceof DragAndDropDetector.Draggable)) && (localView.getVisibility() == 0))
      {
        localView.getLocationOnScreen(arrayOfInt);
        int k = arrayOfInt[0];
        int m = localView.getWidth();
        int n = arrayOfInt[1];
        int i1 = localView.getHeight();
        if ((paramFloat1 >= arrayOfInt[0]) && (paramFloat1 <= k + m) && (paramFloat2 >= arrayOfInt[1]) && (paramFloat2 <= n + i1)) {
          return (DragAndDropDetector.Draggable)localView;
        }
      }
      i += 1;
    }
    return null;
  }
  
  void initTagLayout()
  {
    this.mBreatheView = ((BreatheEffectView)findViewById(2131435702));
    Object localObject = (ImageView)findViewById(2131435007);
    this.mHeartRiseDrawable = new HeartRiseLayerDrawable(5, getResources());
    ((ImageView)localObject).setImageDrawable(this.mHeartRiseDrawable);
    this.mAddTagTips = ((TextView)findViewById(2131447428));
    localObject = getTagLayoutParams(findViewById(2131434901));
    this.mAddTagTips.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mDragDetector = new DragAndDropDetector(this, this.mBreatheView, true);
    this.mGestureDetector = new GestureDetector(getContext(), new VasProfileTagView.1(this));
  }
  
  public boolean intercept(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.isFullScreen)
    {
      Object localObject = this.mDragDetector;
      if ((localObject == null) || (!((DragAndDropDetector)localObject).a(paramMotionEvent)))
      {
        localObject = this.mGestureDetector;
        if ((localObject != null) && (!((GestureDetector)localObject).onTouchEvent(paramMotionEvent))) {
          dispatchTouchEvent(paramMotionEvent);
        }
      }
      if (this.mFromExtendFriend) {
        return super.intercept(paramView, paramMotionEvent);
      }
      return true;
    }
    if (this.mGestureDetector != null)
    {
      this.mTagCloudLayout.getLocationInWindow(this.mTagCloudInWindow);
      if (this.mTagCloudInWindow[1] - this.mOffsetOnScreen[1] == 0) {
        return this.mGestureDetector.onTouchEvent(paramMotionEvent);
      }
    }
    return super.intercept(paramView, paramMotionEvent);
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (paramAnimator == null) {
      return;
    }
    if (paramAnimator == this.mAnimEnterFullScreen)
    {
      this.mBreatheView.a(this.aniEndBreatheListener);
    }
    else
    {
      paramAnimator = (FrameLayout)this.mActivity.findViewById(16908290);
      if ((paramAnimator != null) && (paramAnimator.getChildCount() > 0))
      {
        paramAnimator = paramAnimator.getChildAt(0);
        if (paramAnimator != null)
        {
          this.mBlurBackground = paramAnimator.getBackground();
          paramAnimator.setBackgroundDrawable(null);
        }
      }
    }
    this.mTagCloudLayout.setSkipMeasure(false);
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.mTagCloudLayout.setSkipMeasure(true);
    paramAnimator = (FrameLayout)this.mActivity.findViewById(16908290);
    if (paramAnimator != null)
    {
      Drawable localDrawable;
      if (paramAnimator.getBackground() == null)
      {
        localDrawable = this.mNormalBackground;
        if (localDrawable != null) {
          paramAnimator.setBackgroundDrawable(localDrawable);
        }
      }
      if (paramAnimator.getChildCount() > 0)
      {
        paramAnimator = paramAnimator.getChildAt(0);
        if ((paramAnimator != null) && (paramAnimator.getBackground() == null))
        {
          localDrawable = this.mBlurBackground;
          if (localDrawable != null) {
            paramAnimator.setBackgroundDrawable(localDrawable);
          }
        }
      }
    }
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
  
  public void onApolloExpand(int paramInt)
  {
    super.onApolloExpand(paramInt);
    Object localObject = (View)this.mHeaderChildMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = (ScreenUtil.dip2px(10.0F) + paramInt);
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
  
  public boolean onDrag(DragAndDropDetector.Draggable paramDraggable, float paramFloat1, float paramFloat2)
  {
    this.isDragging = true;
    if (((VipTagView)paramDraggable).b())
    {
      onMove(paramDraggable, paramFloat1, paramFloat2);
      this.mBreatheView.a();
      return true;
    }
    return false;
  }
  
  public void onDrop(DragAndDropDetector.DropTarget paramDropTarget, DragAndDropDetector.Draggable paramDraggable, float paramFloat1, float paramFloat2)
  {
    this.isDragging = false;
    this.mBreatheView.a(null);
    if (paramDropTarget != null)
    {
      paramDropTarget = (VipTagView)paramDraggable;
      paramDropTarget.setTag(2131443123, Boolean.valueOf(true));
      doTagScale(paramDropTarget);
      if ((!checkTagLiked(paramDropTarget)) && (this.mCardInfo.allInOne.pa != 0))
      {
        int i = getResources().getDimensionPixelSize(2131299334);
        if (getHandler() != null) {
          this.mHeartRiseDrawable.a(getHandler(), 900, i);
        }
      }
    }
    else
    {
      doTagSpringBack((VipTagView)paramDraggable, false);
    }
  }
  
  protected void onInit(ProfileCardInfo paramProfileCardInfo)
  {
    Context localContext = getContext();
    this.mLikedTagStoreSP = this.mActivity.getSharedPreferences(this.mApp.getCurrentAccountUin(), 0);
    initMainView(localContext);
    updateAvatarArea(paramProfileCardInfo, localContext);
    updateHeadArea(paramProfileCardInfo);
    updateBaseInfoArea(paramProfileCardInfo);
    updateLikeArea(paramProfileCardInfo);
    updateTagArea();
    updateTipArea();
    super.onInit(paramProfileCardInfo);
    initTagLayout();
    updateTagCloud(paramProfileCardInfo);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject;
    if (this.mPhotoInitPos == null)
    {
      getLocationOnScreen(this.mOffsetOnScreen);
      localObject = this.mDragDetector;
      int[] arrayOfInt = this.mOffsetOnScreen;
      ((DragAndDropDetector)localObject).a(arrayOfInt[0], arrayOfInt[1]);
      paramInt1 = this.mPhotoView.getWidth();
      paramInt3 = this.mPhotoView.getHeight();
      localObject = new int[2];
      this.mPhotoView.getLocationOnScreen((int[])localObject);
      this.mPhotoInitPos = new PointF((localObject[0] - this.mOffsetOnScreen[0] + paramInt1 / 2) / getWidth(), (localObject[1] - this.mOffsetOnScreen[1] + paramInt3 / 2) / getHeight());
      if (this.mCardInfo.allInOne.colorScreen != 1) {
        postDelayed(new VasProfileTagView.3(this), 300L);
      }
    }
    paramInt1 = this.mFullScreenHeight;
    if ((paramInt1 > 0) && (paramInt4 - paramInt2 == paramInt1) && (this.mPhotoFullPos == null))
    {
      paramInt1 = this.mPhotoView.getWidth();
      paramInt2 = this.mPhotoView.getHeight();
      localObject = new int[2];
      this.mPhotoView.getLocationOnScreen((int[])localObject);
      this.mBreatheView.setHoverHotArea(new Rect(localObject[0], localObject[1], localObject[0] + paramInt1, localObject[1] + paramInt2));
      this.mPhotoFullPos = new PointF((localObject[0] - this.mOffsetOnScreen[0] + paramInt1 / 2) / getWidth(), (localObject[1] - this.mOffsetOnScreen[1] + paramInt2 / 2) / getHeight());
      paramInt1 = this.mBasicInfoLabel.getHeight();
      this.mBasicInfoLabel.getLocationOnScreen((int[])localObject);
      paramInt2 = TAG_POS.length;
      double d = this.mDensity * 45.0F;
      Double.isNaN(d);
      paramInt3 = (int)((d + 0.5D) / 2.0D);
      float f = (localObject[1] - this.mOffsetOnScreen[1] + paramInt1 + paramInt3) / getHeight();
      localObject = TAG_POS[(paramInt2 - 1)];
      ((PointF)localObject).set(((PointF)localObject).x, f);
      localObject = this.mAddTagTips;
      if (localObject != null)
      {
        localObject = (RatioLayout.LayoutParams)((TextView)localObject).getLayoutParams();
        if (localObject != null)
        {
          ((RatioLayout.LayoutParams)localObject).b = f;
          this.mAddTagTips.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
  }
  
  public void onMove(DragAndDropDetector.Draggable paramDraggable, float paramFloat1, float paramFloat2)
  {
    paramDraggable = (View)paramDraggable;
    RatioLayout localRatioLayout = this.mTagCloudLayout;
    int i = (int)paramFloat1;
    int[] arrayOfInt = this.mOffsetOnScreen;
    localRatioLayout.a(paramDraggable, i - arrayOfInt[0], (int)paramFloat2 - arrayOfInt[1]);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mCardInfo != null)
    {
      super.updateAvatarPendantImage(this.mCardInfo, false);
      if ((this.mCardInfo.allInOne.pa == 0) && (this.mCardInfo.card != null) && (this.mColorScheme != (int)this.mCardInfo.card.backgroundColor)) {
        setColorScheme((int)this.mCardInfo.card.backgroundColor);
      }
    }
    Object localObject = (View)this.mHeaderChildMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = ScreenUtil.dip2px(15.0F);
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if ((!this.mIsScrolled) && (this.mOnClickListener != null))
      {
        this.mTagCloudLayout.setTag(new DataTag(29, null));
        this.mOnClickListener.onClick(this.mTagCloudLayout);
        return true;
      }
      this.mIsScrolled = false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onUpdate(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.updateAvatar(paramProfileCardInfo.allInOne);
    super.updateSexAgeArea(paramProfileCardInfo);
    super.updateHead(paramProfileCardInfo);
    super.updateLike(paramProfileCardInfo);
    if (this.mIsFullAnimPlaying) {
      this.mTagCloudNeedUpdate = true;
    } else {
      updateTagCloud(paramProfileCardInfo);
    }
    super.updateAvatarPendantImage(paramProfileCardInfo, false);
  }
  
  protected boolean scrollAnimation(float paramFloat)
  {
    if (Math.abs(paramFloat) > this.mDistanceThreshold)
    {
      if ((paramFloat > 0.0F) && (this.isFullScreen))
      {
        if (switchScreenMode())
        {
          tagsGather();
          this.mBreatheView.b(null);
        }
      }
      else if ((paramFloat < 0.0F) && (!this.isFullScreen)) {
        switchScreenMode();
      }
      return true;
    }
    return false;
  }
  
  void setColorScheme(int paramInt)
  {
    this.mColorScheme = paramInt;
    Object localObject = this.mAddTagTips;
    int j = -1;
    int i;
    if (2 == paramInt) {
      i = -1;
    } else {
      i = -16777216;
    }
    ((TextView)localObject).setTextColor(i);
    localObject = this.mNickLabel;
    if (2 == paramInt) {
      i = -1;
    } else {
      i = -16777216;
    }
    ((ProfileNameView)localObject).setTextColor(i);
    localObject = this.mBasicInfoLabel;
    if (2 == paramInt) {
      paramInt = j;
    } else {
      paramInt = -16777216;
    }
    ((TextView)localObject).setTextColor(paramInt);
  }
  
  public void setFromExtendFriend(boolean paramBoolean)
  {
    this.mFromExtendFriend = paramBoolean;
  }
  
  public void setProfileArgs(IComponentCenter paramIComponentCenter, IProfileActivityDelegate paramIProfileActivityDelegate)
  {
    this.mComponentCenter = paramIComponentCenter;
    this.mDelegate = paramIProfileActivityDelegate;
  }
  
  boolean switchScreenMode()
  {
    if (this.mIsFullAnimPlaying) {
      return false;
    }
    if ((this.mFromExtendFriend) && (!this.mIsScrollByExtendFriend))
    {
      this.mIsScrollByExtendFriend = true;
      return false;
    }
    this.mIsFullAnimPlaying = true;
    ValueAnimator localValueAnimator;
    if (this.isFullScreen)
    {
      localValueAnimator = exitFullScreen();
    }
    else
    {
      if ((this.mFullScreenHeight == 0) && (this.mActivity.findViewById(16908290) == null)) {
        return false;
      }
      localValueAnimator = enterFullScreen();
    }
    this.isFullScreen ^= true;
    if (localValueAnimator != null)
    {
      localValueAnimator.setDuration(500L);
      localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      localValueAnimator.removeListener(this);
      localValueAnimator.removeAllUpdateListeners();
      localValueAnimator.addListener(this);
      localValueAnimator.addUpdateListener(this.mSwitchScreenUpdateListener);
      localValueAnimator.start();
    }
    return true;
  }
  
  public void tagsDiffuse()
  {
    this.mTagAnimCount = 0;
    View[] arrayOfView = this.mTagViews;
    int k = arrayOfView.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      View localView = arrayOfView[i];
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        Object localObject = (Integer)localView.getTag(2131443126);
        if (localObject != null)
        {
          PointF localPointF = TAG_POS[localObject.intValue()];
          this.mTagAnimCount += 1;
          ValueAnimator[] arrayOfValueAnimator = this.mDiffuseAnims;
          ValueAnimator localValueAnimator = arrayOfValueAnimator[j];
          localObject = localValueAnimator;
          if (localValueAnimator == null)
          {
            localObject = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
            arrayOfValueAnimator[j] = localObject;
            ((ValueAnimator)localObject).addUpdateListener(new VasProfileTagView.10(this, localView, localPointF));
            ((ValueAnimator)localObject).setInterpolator(new DecelerateInterpolator());
            addAnimationListener(localView, localPointF, (ValueAnimator)localObject);
            ((ValueAnimator)localObject).setDuration(600L);
          }
          localView.setVisibility(0);
          ((ValueAnimator)localObject).start();
        }
      }
      else
      {
        j += 1;
      }
      i += 1;
    }
    if (this.mTagAnimCount == 0)
    {
      this.mIsFullAnimPlaying = false;
      if (this.mIsFirstAnimation)
      {
        updateJueban(this.mCardInfo);
        this.mIsFirstAnimation = false;
      }
    }
  }
  
  public void tagsGather()
  {
    this.mTagAnimCount = 0;
    View[] arrayOfView = this.mTagViews;
    int k = arrayOfView.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      View localView = arrayOfView[i];
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        if ((localView instanceof VipTagView)) {
          ((VipTagView)localView).setShakingState(false);
        }
        Object localObject = (Integer)localView.getTag(2131443126);
        if (localObject != null)
        {
          PointF localPointF = TAG_POS[localObject.intValue()];
          localObject = (RatioLayout.LayoutParams)localView.getLayoutParams();
          if (localObject != null)
          {
            ((RatioLayout.LayoutParams)localObject).a = this.mPhotoInitPos.x;
            ((RatioLayout.LayoutParams)localObject).b = this.mPhotoInitPos.y;
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          this.mTagAnimCount += 1;
          ValueAnimator[] arrayOfValueAnimator = this.mGatherAnims;
          ValueAnimator localValueAnimator = arrayOfValueAnimator[j];
          localObject = localValueAnimator;
          if (localValueAnimator == null)
          {
            localObject = ObjectAnimator.ofFloat(new float[] { 1.0F, 0.0F });
            arrayOfValueAnimator[j] = localObject;
            ((ValueAnimator)localObject).addUpdateListener(new VasProfileTagView.12(this, localView, localPointF));
            ((ValueAnimator)localObject).setInterpolator(new AccelerateInterpolator());
            ((ValueAnimator)localObject).addListener(new VasProfileTagView.13(this, localView));
            ((ValueAnimator)localObject).setDuration(600L);
          }
          this.mAddTagTips.setVisibility(4);
          ((ValueAnimator)localObject).start();
        }
      }
      else
      {
        j += 1;
      }
      i += 1;
    }
    if (this.mTagAnimCount == 0)
    {
      this.mIsFullAnimPlaying = false;
      loadColorScreen(this.mComponentCenter);
    }
  }
  
  public void updateTagCloud(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "updateTagCloud");
    }
    ThreadManager.post(new VasProfileTagView.2(this, paramProfileCardInfo), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView
 * JD-Core Version:    0.7.0.1
 */