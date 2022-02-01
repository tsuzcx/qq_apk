package com.tencent.mobileqq.emoticonview.relateemo;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class RelatedEmoSlideBottomPanel
  extends FrameLayout
  implements NestedScrollingParent
{
  private static final int DEFAULT_ANIMATION_DURATION = 250;
  private static final byte SLIDE_DIR_DEFAULT = 0;
  private static final byte SLIDE_DIR_DOWN = 1;
  private static final byte SLIDE_DIR_UP = 2;
  private static final String TAG = "RelatedSlideBottomPanel";
  public static final int TYPE_BACK_DISMISS = 4;
  public static final int TYPE_CLICK_DISMISS = 2;
  public static final int TYPE_DRAG_DISMISS = 3;
  public static final int TYPE_EMPTY_DISMISS = 1;
  public static final int TYPE_NONE_DISMISS = -1;
  private RelatedEmoSlideBottomPanel.Callback mCallback;
  private boolean mConsumeTouchEvent;
  private int mContentHeight;
  private LinearLayout mContentView;
  private float mDensity;
  private int mDismissType = -1;
  private FrameLayout mDragArea;
  private boolean mIsTouch;
  private ImageView mIvDragIcon;
  private float mLastY;
  private int mMoveDistance;
  private boolean mMoved;
  private final NestedScrollingParentHelper mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
  private boolean mPanelDraging;
  private int mScaledTouchSlop;
  private byte mSlideStartDir = 0;
  
  public RelatedEmoSlideBottomPanel(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RelatedEmoSlideBottomPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RelatedEmoSlideBottomPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void animateToTargetHeight(int paramInt)
  {
    if (this.mContentView.getY() != paramInt)
    {
      animTranslationY(new float[] { this.mContentView.getY(), paramInt });
      this.mConsumeTouchEvent = false;
      doInterceptTouchEvent(false);
    }
  }
  
  private void doInterceptTouchEvent(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null) {
      localViewGroup.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private int dp2px(int paramInt)
  {
    return (int)(paramInt * this.mDensity + 0.5F);
  }
  
  private void init()
  {
    this.mDensity = getContext().getResources().getDisplayMetrics().density;
    this.mScaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.mContentView = new LinearLayout(getContext());
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).height = this.mContentHeight;
    this.mContentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    boolean bool1 = "2971".equals(ThemeUtil.getCurrentThemeId());
    boolean bool2 = ThemeUtil.isNowThemeIsNight(null, false, null);
    if (bool1)
    {
      this.mContentView.setBackgroundResource(2130849586);
      this.mContentView.setOrientation(1);
      addView(this.mContentView);
      i = dp2px(38);
      this.mDragArea = new FrameLayout(getContext());
      localObject = new LinearLayout.LayoutParams(-1, i);
      this.mDragArea.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mContentView.addView(this.mDragArea);
      this.mIvDragIcon = new ImageView(getContext());
      localObject = new FrameLayout.LayoutParams(i, i);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.mIvDragIcon.setImageResource(2130849588);
      this.mIvDragIcon.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mDragArea.addView(this.mIvDragIcon);
      setOnClickListener(new RelatedEmoSlideBottomPanel.1(this));
      this.mDragArea.setOnClickListener(new RelatedEmoSlideBottomPanel.2(this));
      setVisibility(4);
      return;
    }
    localObject = this.mContentView;
    if (bool2) {}
    for (int i = 2130849585;; i = 2130849584)
    {
      ((LinearLayout)localObject).setBackgroundResource(i);
      break;
    }
  }
  
  private void onActionMove(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawY();
    float f2 = f1 - this.mLastY;
    swipeDirectionJudge(f2);
    updateTranslationY((int)(this.mLastY - f1));
    this.mLastY = paramMotionEvent.getRawY();
    this.mMoveDistance = ((int)(this.mMoveDistance + Math.abs(f2)));
  }
  
  private void onActionUp()
  {
    if (this.mPanelDraging)
    {
      this.mPanelDraging = false;
      if (this.mCallback != null) {
        this.mCallback.onPanelEndDrag();
      }
    }
    if (this.mContentHeight == 0) {
      throw new IllegalArgumentException("content height is 0 !!!");
    }
    float f = (this.mContentView.getY() - maxTopY()) * 1.0F / this.mContentHeight;
    if ((this.mSlideStartDir == 1) && (f > 0.2F))
    {
      animateToTargetHeight(getMeasuredHeight());
      return;
    }
    animateToTargetHeight(maxTopY());
  }
  
  private void swipeDirectionJudge(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.mSlideStartDir = 1;
    }
    while (paramFloat >= 0.0F) {
      return;
    }
    this.mSlideStartDir = 2;
  }
  
  private float updateTranslationY(int paramInt)
  {
    float f3 = this.mContentView.getY() - paramInt;
    float f4 = paramInt;
    float f1;
    float f2;
    if (f3 > getMeasuredHeight())
    {
      f1 = f4 - (f3 - getMeasuredHeight());
      f2 = getMeasuredHeight();
    }
    for (;;)
    {
      if (!this.mPanelDraging)
      {
        this.mPanelDraging = true;
        if (this.mCallback != null) {
          this.mCallback.onPanelStartDrag();
        }
      }
      if (this.mCallback != null) {
        this.mCallback.updatePanelDistance(f2 - maxTopY());
      }
      this.mContentView.setY(f2);
      return f1;
      f1 = f4;
      f2 = f3;
      if (f3 < maxTopY())
      {
        f1 = f4 - (maxTopY() - f3);
        f2 = maxTopY();
      }
    }
  }
  
  public void animTranslationY(boolean paramBoolean, float... paramVarArgs)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mContentView, "y", paramVarArgs);
    localObjectAnimator.addUpdateListener(new RelatedEmoSlideBottomPanel.4(this, paramBoolean, paramVarArgs));
    localObjectAnimator.setDuration(250L).start();
  }
  
  public void animTranslationY(float... paramVarArgs)
  {
    animTranslationY(true, paramVarArgs);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.mConsumeTouchEvent)
    {
      return true;
      this.mLastY = paramMotionEvent.getRawY();
      this.mIsTouch = true;
      this.mMoved = false;
      this.mMoveDistance = 0;
      this.mPanelDraging = false;
      Object localObject = new int[2];
      this.mDragArea.getLocationOnScreen((int[])localObject);
      localObject = new Rect(localObject[0], localObject[1], localObject[0] + this.mDragArea.getMeasuredWidth(), localObject[1] + this.mDragArea.getMeasuredHeight());
      boolean bool1 = bool2;
      if (!((Rect)localObject).isEmpty())
      {
        bool1 = bool2;
        if (((Rect)localObject).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
          bool1 = true;
        }
      }
      this.mConsumeTouchEvent = bool1;
      if (this.mConsumeTouchEvent) {
        doInterceptTouchEvent(true);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("RelatedSlideBottomPanel", 2, "mConsumeTouchEvent : " + this.mConsumeTouchEvent);
        continue;
        if (this.mConsumeTouchEvent)
        {
          this.mMoved = true;
          onActionMove(paramMotionEvent);
          return true;
          this.mIsTouch = false;
          if (this.mConsumeTouchEvent)
          {
            if (((this.mMoveDistance != 0) || (this.mMoved)) && ((!this.mMoved) || (this.mMoveDistance >= this.mScaledTouchSlop))) {
              break label294;
            }
            this.mDragArea.performClick();
          }
          for (;;)
          {
            this.mMoved = false;
            break;
            label294:
            this.mDismissType = 3;
            onActionUp();
          }
          this.mIsTouch = false;
          this.mMoved = false;
        }
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void displayPanel()
  {
    post(new RelatedEmoSlideBottomPanel.3(this));
  }
  
  public int getNestedScrollAxes()
  {
    return this.mNestedScrollingParentHelper.getNestedScrollAxes();
  }
  
  public void hidePanel(int paramInt)
  {
    if (this.mDismissType != paramInt)
    {
      this.mDismissType = paramInt;
      animTranslationY(true, new float[] { this.mContentView.getY(), getMeasuredHeight() });
    }
  }
  
  public int maxTopY()
  {
    return getMeasuredHeight() - this.mContentHeight;
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i = 0;
    if (this.mContentView.getY() == maxTopY()) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (this.mContentView.getY() > maxTopY()) {
        i = 1;
      }
      if (((paramInt1 != 0) && (!ViewCompat.canScrollVertically(paramView, paramInt2))) || (i != 0))
      {
        swipeDirectionJudge(-paramInt2);
        paramArrayOfInt[1] = ((int)updateTranslationY(paramInt2));
      }
      return;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2;
    float f1;
    if (this.mContentView.getY() >= maxTopY())
    {
      paramInt1 = 1;
      if (paramInt1 != 0)
      {
        f2 = this.mContentView.getY() - paramInt4;
        if (f2 <= getMeasuredHeight()) {
          break label100;
        }
        f1 = getMeasuredHeight();
      }
    }
    for (;;)
    {
      swipeDirectionJudge(-paramInt4);
      if (this.mCallback != null) {
        this.mCallback.updatePanelDistance(f1 - maxTopY());
      }
      this.mContentView.setY(f1);
      return;
      paramInt1 = 0;
      break;
      label100:
      f1 = f2;
      if (f2 < maxTopY()) {
        f1 = maxTopY();
      }
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.mNestedScrollingParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.mNestedScrollingParentHelper.onStopNestedScroll(paramView);
    if ((!this.mIsTouch) && (this.mDismissType != 4))
    {
      this.mDismissType = 3;
      onActionUp();
    }
  }
  
  public void setCallback(RelatedEmoSlideBottomPanel.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.mContentHeight = paramInt;
    init();
  }
  
  public void setContentView(View paramView)
  {
    this.mContentView.addView(paramView, new LinearLayout.LayoutParams(-1, -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoSlideBottomPanel
 * JD-Core Version:    0.7.0.1
 */