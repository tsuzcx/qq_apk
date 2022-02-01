package com.tencent.mobileqq.profilecard.vas.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
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
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.BreatheEffectView;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.profile.view.helper.HeartRiseLayerDrawable;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent;
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
  public boolean isDragging = false;
  public boolean isFullScreen = false;
  private TextView mAddTagTips;
  private ValueAnimator mAnimEnterFullScreen;
  private ValueAnimator mAnimLeaveFullScreen;
  private ImageView mAvatarPendantImage;
  private TextView mBasicInfoLabel;
  private Drawable mBlurBackground;
  private BreatheEffectView mBreatheView;
  private int mColorScheme;
  private IComponentCenter mComponentCenter;
  private ValueAnimator[] mDiffuseAnims = new ValueAnimator[TAG_POS.length];
  private final int mDistanceThreshold;
  private DragAndDropDetector mDragDetector;
  private int mFullScreenHeight;
  private ValueAnimator[] mGatherAnims = new ValueAnimator[TAG_POS.length];
  private GestureDetector mGestureDetector;
  private HeartRiseLayerDrawable mHeartRiseDrawable;
  private boolean mIsFirstAnimation = true;
  private boolean mIsFullAnimPlaying = false;
  private boolean mIsScrollByExtendFriend = false;
  private boolean mIsScrolled;
  private SharedPreferences mLikedTagStoreSP;
  private ProfileNameView mNickLabel;
  private Drawable mNormalBackground;
  private int[] mOffsetOnScreen = new int[2];
  private PointF mPhotoFullPos;
  private PointF mPhotoInitPos;
  private AvatarLayout mPhotoView;
  private int mTagAnimCount;
  private int[] mTagCloudInWindow = new int[2];
  private RatioLayout mTagCloudLayout;
  private boolean mTagCloudNeedUpdate;
  private View[] mTagViews = new View[TAG_POS.length];
  
  public VasProfileTagView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    this.mActivity = paramBaseActivity;
    this.mApp = paramBaseActivity.app;
    this.mCardInfo = paramProfileCardInfo;
    this.mDistanceThreshold = paramBaseActivity.getResources().getDimensionPixelSize(2131298641);
  }
  
  private void initMainView(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131562194, this, true);
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
  
  private void updateAvatarArea(ProfileCardInfo paramProfileCardInfo, Context paramContext)
  {
    this.mPhotoView = ((AvatarLayout)findViewById(2131369058));
    this.mPhotoView.a(0, this.mPhotoView.findViewById(2131363511), false);
    this.mHeaderChildMap.put("map_key_face", this.mPhotoView);
    super.updateAvatar(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    DataTag localDataTag = new DataTag(1, null);
    this.mPhotoView.setTag(localDataTag);
    this.mPhotoView.setOnClickListener(this.mOnClickListener);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (paramContext = paramContext.getString(2131691276);; paramContext = paramContext.getString(2131691275))
    {
      this.mPhotoView.setContentDescription(paramContext);
      this.mAvatarPendantImage = ((ImageView)findViewById(2131368891));
      this.mAvatarPendantImage.setVisibility(4);
      this.mAvatarPendantImage.setOnClickListener(this.mOnClickListener);
      this.mAvatarPendantImage.setTag(localDataTag);
      this.mHeaderChildMap.put("map_key_avatar_pendant", this.mAvatarPendantImage);
      super.updateAvatarPendantImage(paramProfileCardInfo, true);
      return;
    }
  }
  
  private void updateBaseInfoArea(ProfileCardInfo paramProfileCardInfo)
  {
    this.mBasicInfoLabel = ((TextView)findViewById(2131369065));
    this.mHeaderChildMap.put("map_key_sex_age_area", this.mBasicInfoLabel);
    super.updateSexAgeArea(paramProfileCardInfo);
  }
  
  private void updateHeadArea(ProfileCardInfo paramProfileCardInfo)
  {
    this.mNickLabel = ((ProfileNameView)findViewById(2131369073));
    this.mNickLabel.setClickListener(this.mOnClickListener);
    this.mHeaderChildMap.put("map_key_profile_nick_name", this.mNickLabel);
    super.updateHead(paramProfileCardInfo);
  }
  
  private void updateLikeArea(ProfileCardInfo paramProfileCardInfo)
  {
    VoteView localVoteView = (VoteView)findViewById(2131381767);
    HeartLayout localHeartLayout = (HeartLayout)findViewById(2131368400);
    localHeartLayout.setEnabled(false);
    localVoteView.setHeartLayout(this.mApp, localHeartLayout);
    this.mHeaderChildMap.put("map_key_like", localVoteView);
    super.updateLike(paramProfileCardInfo);
  }
  
  private void updateTagArea()
  {
    this.mTagCloudLayout = ((RatioLayout)findViewById(2131378888));
    this.mHeaderChildMap.put("map_key_tag_cloud", this.mTagCloudLayout);
  }
  
  private void updateTipArea()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131369104);
    this.mHeaderChildMap.put("map_key_tips", localLinearLayout);
  }
  
  void addLike(VipTagView paramVipTagView, long paramLong)
  {
    Object localObject = String.format("%s-%d", new Object[] { this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin, Long.valueOf(paramLong) });
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
      ((CardHandler)localObject).a(this.mApp.getCurrentAccountUin(), this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin, Long.valueOf(paramLong));
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "submit the network params ：srcUin = " + this.mApp.getCurrentAccountUin() + "destUin  = " + this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin + " labelId  = " + paramLong);
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
    if (paramVipTagView.getTag(2131375422) == null) {
      return false;
    }
    long l = ((Long)paramVipTagView.getTag(2131375422)).longValue();
    if ((this.mCardInfo != null) && (this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!TextUtils.isEmpty(this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin)))
    {
      paramVipTagView = String.format("%s-%d", new Object[] { this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin, Long.valueOf(l) });
      return this.mLikedTagStoreSP.getBoolean(paramVipTagView, false);
    }
    return false;
  }
  
  boolean checkTagUpdateFlag()
  {
    boolean bool = false;
    if (this.mTagCloudNeedUpdate)
    {
      this.mTagCloudNeedUpdate = false;
      updateTagCloud(this.mCardInfo);
      bool = true;
    }
    return bool;
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
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = paramVipTagView.getTag(2131375423);
    } while (localObject2 == null);
    int i = ((Integer)localObject2).intValue();
    float f1 = TAG_POS[i].x;
    float f2 = TAG_POS[i].y;
    float f3 = (paramVipTagView.getLeft() + paramVipTagView.getWidth() * ((RatioLayout.LayoutParams)localObject1).c) / this.mTagCloudLayout.getWidth();
    float f4 = paramVipTagView.getTop();
    float f5 = paramVipTagView.getHeight();
    f4 = (((RatioLayout.LayoutParams)localObject1).d * f5 + f4) / this.mTagCloudLayout.getHeight();
    localObject1 = ObjectAnimator.ofObject(new VasProfileTagView.7(this), new Object[] { new PointF(f3, f4), new PointF(f1, f2) });
    ((ValueAnimator)localObject1).addUpdateListener(new VasProfileTagView.8(this, paramVipTagView));
    ((ValueAnimator)localObject1).setDuration(400L);
    ((ValueAnimator)localObject1).addListener(new VasProfileTagView.9(this, paramBoolean, paramVipTagView));
    ((ValueAnimator)localObject1).start();
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
    this.mBreatheView = ((BreatheEffectView)findViewById(2131369059));
    Object localObject1 = (ImageView)findViewById(2131368399);
    this.mHeartRiseDrawable = new HeartRiseLayerDrawable(5, getResources());
    ((ImageView)localObject1).setImageDrawable(this.mHeartRiseDrawable);
    this.mAddTagTips = ((TextView)findViewById(2131379403));
    localObject1 = findViewById(2131368299);
    Object localObject2 = (RatioLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((RatioLayout.LayoutParams)localObject2).a = 0.5F;
    ((RatioLayout.LayoutParams)localObject2).b = 0.5F;
    ((RatioLayout.LayoutParams)localObject2).c = 0.5F;
    ((RatioLayout.LayoutParams)localObject2).d = 0.5F;
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = (RatioLayout.LayoutParams)this.mAddTagTips.getLayoutParams();
    localObject2 = TAG_POS[(TAG_POS.length - 1)];
    ((RatioLayout.LayoutParams)localObject1).a = (((PointF)localObject2).x + 0.07F);
    ((RatioLayout.LayoutParams)localObject1).b = ((PointF)localObject2).y;
    ((RatioLayout.LayoutParams)localObject1).c = 0.0F;
    ((RatioLayout.LayoutParams)localObject1).d = 0.5F;
    this.mAddTagTips.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.mDragDetector = new DragAndDropDetector(this, this.mBreatheView, true);
    this.mGestureDetector = new GestureDetector(getContext(), new VasProfileTagView.1(this));
  }
  
  public boolean intercept(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.isFullScreen)
    {
      if (((this.mDragDetector == null) || (!this.mDragDetector.a(paramMotionEvent))) && (this.mGestureDetector != null) && (!this.mGestureDetector.onTouchEvent(paramMotionEvent))) {
        dispatchTouchEvent(paramMotionEvent);
      }
      if ((this.mActivity != null) && ((this.mActivity instanceof FriendProfileCardActivity)) && (((FriendProfileCardActivity)this.mActivity).e)) {
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
    if (paramAnimator != null)
    {
      if (paramAnimator != this.mAnimEnterFullScreen) {
        break label36;
      }
      this.mBreatheView.a(new VasProfileTagView.5(this));
    }
    for (;;)
    {
      this.mTagCloudLayout.setSkipMeasure(false);
      return;
      label36:
      if (Build.VERSION.SDK_INT < 11)
      {
        ((FriendProfileCardActivity)this.mActivity).i();
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
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.mTagCloudLayout.setSkipMeasure(true);
    paramAnimator = (FrameLayout)this.mActivity.findViewById(16908290);
    if (paramAnimator != null)
    {
      if ((paramAnimator.getBackground() == null) && (this.mNormalBackground != null)) {
        paramAnimator.setBackgroundDrawable(this.mNormalBackground);
      }
      if (paramAnimator.getChildCount() > 0)
      {
        paramAnimator = paramAnimator.getChildAt(0);
        if ((paramAnimator != null) && (paramAnimator.getBackground() == null) && (this.mBlurBackground != null)) {
          paramAnimator.setBackgroundDrawable(this.mBlurBackground);
        }
      }
    }
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
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard", 2, "onApolloExpand h:" + paramInt);
      }
    }
  }
  
  public boolean onDrag(DragAndDropDetector.Draggable paramDraggable, float paramFloat1, float paramFloat2)
  {
    this.isDragging = true;
    if (((VipTagView)paramDraggable).a())
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
      ((VipTagView)paramDraggable).setTag(2131375420, Boolean.valueOf(true));
      doTagScale((VipTagView)paramDraggable);
      if ((!checkTagLiked((VipTagView)paramDraggable)) && (this.mCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != 0))
      {
        int i = getResources().getDimensionPixelSize(2131298622);
        if (getHandler() != null) {
          this.mHeartRiseDrawable.a(getHandler(), 900, i);
        }
      }
      return;
    }
    doTagSpringBack((VipTagView)paramDraggable, false);
  }
  
  public void onInit(ProfileCardInfo paramProfileCardInfo)
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
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject;
    float f;
    if (this.mPhotoInitPos == null)
    {
      getLocationOnScreen(this.mOffsetOnScreen);
      this.mDragDetector.a(this.mOffsetOnScreen[0], this.mOffsetOnScreen[1]);
      paramInt3 = this.mPhotoView.getWidth();
      paramInt1 = this.mPhotoView.getHeight();
      localObject = new int[2];
      this.mPhotoView.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = this.mOffsetOnScreen[0];
      f = (paramInt3 / 2 + (i - j)) / getWidth();
      paramInt3 = localObject[1];
      i = this.mOffsetOnScreen[1];
      this.mPhotoInitPos = new PointF(f, (paramInt1 / 2 + (paramInt3 - i)) / getHeight());
      if (this.mCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f != 1) {
        postDelayed(new VasProfileTagView.3(this), 300L);
      }
    }
    if ((this.mFullScreenHeight > 0) && (paramInt4 - paramInt2 == this.mFullScreenHeight) && (this.mPhotoFullPos == null))
    {
      paramInt2 = this.mPhotoView.getWidth();
      paramInt1 = this.mPhotoView.getHeight();
      localObject = new int[2];
      this.mPhotoView.getLocationOnScreen((int[])localObject);
      this.mBreatheView.setHoverHotArea(new Rect(localObject[0], localObject[1], localObject[0] + paramInt2, localObject[1] + paramInt1));
      paramInt3 = localObject[0];
      paramInt4 = this.mOffsetOnScreen[0];
      f = (paramInt2 / 2 + (paramInt3 - paramInt4)) / getWidth();
      paramInt2 = localObject[1];
      paramInt3 = this.mOffsetOnScreen[1];
      this.mPhotoFullPos = new PointF(f, (paramInt1 / 2 + (paramInt2 - paramInt3)) / getHeight());
      paramInt1 = this.mBasicInfoLabel.getHeight();
      this.mBasicInfoLabel.getLocationOnScreen((int[])localObject);
      paramInt2 = TAG_POS.length;
      paramInt3 = (int)((45.0F * this.mDensity + 0.5D) / 2.0D);
      f = (paramInt1 + (localObject[1] - this.mOffsetOnScreen[1]) + paramInt3) / getHeight();
      localObject = TAG_POS[(paramInt2 - 1)];
      ((PointF)localObject).set(((PointF)localObject).x, f);
      if (this.mAddTagTips != null)
      {
        localObject = (RatioLayout.LayoutParams)this.mAddTagTips.getLayoutParams();
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
    this.mTagCloudLayout.a(paramDraggable, (int)paramFloat1 - this.mOffsetOnScreen[0], (int)paramFloat2 - this.mOffsetOnScreen[1]);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mCardInfo != null)
    {
      super.updateAvatarPendantImage(this.mCardInfo, false);
      if ((this.mCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) && (this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.mColorScheme != (int)this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor)) {
        setColorScheme((int)this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor);
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
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if ((!this.mIsScrolled) && (this.mOnClickListener != null))
      {
        this.mTagCloudLayout.setTag(new DataTag(29, null));
        this.mOnClickListener.onClick(this.mTagCloudLayout);
        return true;
      }
      this.mIsScrolled = false;
    }
  }
  
  public void onUpdate(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.updateAvatar(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    super.updateSexAgeArea(paramProfileCardInfo);
    super.updateHead(paramProfileCardInfo);
    super.updateLike(paramProfileCardInfo);
    if (this.mIsFullAnimPlaying) {
      this.mTagCloudNeedUpdate = true;
    }
    for (;;)
    {
      super.updateAvatarPendantImage(paramProfileCardInfo, false);
      return;
      updateTagCloud(paramProfileCardInfo);
    }
  }
  
  void setColorScheme(int paramInt)
  {
    int j = -1;
    this.mColorScheme = paramInt;
    Object localObject = this.mAddTagTips;
    int i;
    if (2 == paramInt)
    {
      i = -1;
      ((TextView)localObject).setTextColor(i);
      localObject = this.mNickLabel;
      if (2 != paramInt) {
        break label72;
      }
      i = -1;
      label39:
      ((ProfileNameView)localObject).setTextColor(i);
      localObject = this.mBasicInfoLabel;
      if (2 != paramInt) {
        break label79;
      }
    }
    label72:
    label79:
    for (paramInt = j;; paramInt = -16777216)
    {
      ((TextView)localObject).setTextColor(paramInt);
      return;
      i = -16777216;
      break;
      i = -16777216;
      break label39;
    }
  }
  
  public void setProfileArgs(IComponentCenter paramIComponentCenter)
  {
    this.mComponentCenter = paramIComponentCenter;
  }
  
  boolean switchScreenMode()
  {
    if (this.mIsFullAnimPlaying) {
      return false;
    }
    if (((this.mActivity instanceof FriendProfileCardActivity)) && (((FriendProfileCardActivity)this.mActivity).e) && (!this.mIsScrollByExtendFriend))
    {
      this.mIsScrollByExtendFriend = true;
      return false;
    }
    this.mIsFullAnimPlaying = true;
    Object localObject;
    if (this.isFullScreen) {
      if (this.mAnimLeaveFullScreen == null)
      {
        this.mAnimLeaveFullScreen = ObjectAnimator.ofInt(new int[] { this.mTagCloudLayout.getHeight(), getResources().getDimensionPixelSize(2131298632) });
        localObject = this.mAnimLeaveFullScreen;
        label103:
        if (this.isFullScreen) {
          break label324;
        }
      }
    }
    label324:
    for (boolean bool = true;; bool = false)
    {
      this.isFullScreen = bool;
      if (localObject != null)
      {
        ((ValueAnimator)localObject).setDuration(500L);
        ((ValueAnimator)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
        ((ValueAnimator)localObject).removeListener(this);
        ((ValueAnimator)localObject).removeAllUpdateListeners();
        ((ValueAnimator)localObject).addListener(this);
        ((ValueAnimator)localObject).addUpdateListener(new VasProfileTagView.4(this));
        ((ValueAnimator)localObject).start();
      }
      return true;
      this.mAnimLeaveFullScreen.start();
      localObject = null;
      break label103;
      ((FriendProfileCardActivity)this.mActivity).j();
      if (this.mFullScreenHeight == 0)
      {
        localObject = this.mActivity.findViewById(16908290);
        if (localObject == null) {
          break;
        }
        this.mFullScreenHeight = ((View)localObject).getHeight();
        localObject = this.mActivity.findViewById(2131364192);
        if (localObject != null) {
          this.mFullScreenHeight -= ((View)localObject).getHeight();
        }
      }
      if (Build.VERSION.SDK_INT < 11) {
        ((FriendProfileCardActivity)this.mActivity).h();
      }
      if (this.mAnimEnterFullScreen == null)
      {
        this.mAnimEnterFullScreen = ObjectAnimator.ofInt(new int[] { this.mTagCloudLayout.getHeight(), this.mFullScreenHeight });
        localObject = this.mAnimEnterFullScreen;
        break label103;
      }
      this.mAnimEnterFullScreen.start();
      localObject = null;
      break label103;
    }
  }
  
  public void tagsDiffuse()
  {
    this.mTagAnimCount = 0;
    View[] arrayOfView = this.mTagViews;
    int k = arrayOfView.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = arrayOfView[j];
      Object localObject1;
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        localObject1 = (Integer)localView.getTag(2131375423);
        if (localObject1 != null) {}
      }
      for (;;)
      {
        j += 1;
        break;
        PointF localPointF = TAG_POS[localObject1.intValue()];
        this.mTagAnimCount += 1;
        Object localObject2 = this.mDiffuseAnims[i];
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = this.mDiffuseAnims;
          localObject1 = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          localObject2[i] = localObject1;
          ((ValueAnimator)localObject1).addUpdateListener(new VasProfileTagView.10(this, localView, localPointF));
          ((ValueAnimator)localObject1).setInterpolator(new DecelerateInterpolator());
          ((ValueAnimator)localObject1).addListener(new VasProfileTagView.11(this, localView, localPointF));
          ((ValueAnimator)localObject1).setDuration(600L);
        }
        localView.setVisibility(0);
        ((ValueAnimator)localObject1).start();
        i += 1;
      }
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
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = arrayOfView[j];
      Object localObject1;
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        if ((localView instanceof VipTagView)) {
          ((VipTagView)localView).setShakingState(false);
        }
        localObject1 = (Integer)localView.getTag(2131375423);
        if (localObject1 != null) {}
      }
      for (;;)
      {
        j += 1;
        break;
        PointF localPointF = TAG_POS[localObject1.intValue()];
        localObject1 = (RatioLayout.LayoutParams)localView.getLayoutParams();
        if (localObject1 != null)
        {
          ((RatioLayout.LayoutParams)localObject1).a = this.mPhotoInitPos.x;
          ((RatioLayout.LayoutParams)localObject1).b = this.mPhotoInitPos.y;
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        this.mTagAnimCount += 1;
        Object localObject2 = this.mGatherAnims[i];
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = this.mGatherAnims;
          localObject1 = ObjectAnimator.ofFloat(new float[] { 1.0F, 0.0F });
          localObject2[i] = localObject1;
          ((ValueAnimator)localObject1).addUpdateListener(new VasProfileTagView.12(this, localView, localPointF));
          ((ValueAnimator)localObject1).setInterpolator(new AccelerateInterpolator());
          ((ValueAnimator)localObject1).addListener(new VasProfileTagView.13(this, localView));
          ((ValueAnimator)localObject1).setDuration(600L);
        }
        this.mAddTagTips.setVisibility(4);
        ((ValueAnimator)localObject1).start();
        i += 1;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView
 * JD-Core Version:    0.7.0.1
 */