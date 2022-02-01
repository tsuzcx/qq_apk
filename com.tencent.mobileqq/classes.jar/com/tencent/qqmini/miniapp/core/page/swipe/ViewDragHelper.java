package com.tencent.qqmini.miniapp.core.page.swipe;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class ViewDragHelper
{
  private static final int BASE_SETTLE_DURATION = 256;
  public static final int DIRECTION_ALL = 3;
  public static final int DIRECTION_HORIZONTAL = 1;
  public static final int DIRECTION_VERTICAL = 2;
  public static final int EDGE_ALL = 15;
  public static final int EDGE_BOTTOM = 8;
  public static final int EDGE_LEFT = 1;
  public static final int EDGE_RIGHT = 2;
  private static final int EDGE_SIZE = 20;
  public static final int EDGE_TOP = 4;
  public static final int INVALID_POINTER = -1;
  private static final int MAX_SETTLE_DURATION = 600;
  public static final int SCROLL_LEFT_TO_RIGHT = 1;
  public static final int SCROLL_TOP_TO_BOTTOM = 2;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  private static final String TAG = "ViewDragHelper";
  private static final Interpolator sInterpolator = new ViewDragHelper.1();
  private int mActivePointerId = -1;
  private final ViewDragHelper.Callback mCallback;
  private View mCapturedView;
  private int mDragState;
  private int[] mEdgeDragsInProgress;
  private int[] mEdgeDragsLocked;
  private int mEdgeSize;
  private int[] mInitialEdgesTouched;
  private float[] mInitialMotionX;
  private float[] mInitialMotionY;
  private float[] mLastMotionX;
  private float[] mLastMotionY;
  private float mMaxVelocity;
  private float mMinVelocity;
  private final ViewGroup mParentView;
  private int mPointersDown;
  private boolean mReleaseInProgress;
  private ScrollerCompat mScroller;
  private final Runnable mSetIdleRunnable = new ViewDragHelper.2(this);
  private int mTouchSlop;
  private int mTrackingEdges;
  private VelocityTracker mVelocityTracker;
  private int scrollDirction = 1;
  
  private ViewDragHelper(Context paramContext, ViewGroup paramViewGroup, ViewDragHelper.Callback paramCallback)
  {
    if (paramViewGroup != null)
    {
      if (paramCallback != null)
      {
        this.mParentView = paramViewGroup;
        this.mCallback = paramCallback;
        paramViewGroup = ViewConfiguration.get(paramContext);
        this.mEdgeSize = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
        this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
        this.mMaxVelocity = paramViewGroup.getScaledMaximumFlingVelocity();
        this.mMinVelocity = paramViewGroup.getScaledMinimumFlingVelocity();
        this.mScroller = ScrollerCompat.create(paramContext, sInterpolator);
        return;
      }
      throw new IllegalArgumentException("Callback may not be null");
    }
    throw new IllegalArgumentException("Parent view may not be null");
  }
  
  private boolean checkNewEdgeDrag(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    int i = this.mInitialEdgesTouched[paramInt1];
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((i & paramInt2) == paramInt2)
    {
      bool1 = bool2;
      if ((this.mTrackingEdges & paramInt2) != 0)
      {
        bool1 = bool2;
        if ((this.mEdgeDragsLocked[paramInt1] & paramInt2) != paramInt2)
        {
          bool1 = bool2;
          if ((this.mEdgeDragsInProgress[paramInt1] & paramInt2) != paramInt2)
          {
            i = this.mTouchSlop;
            if ((paramFloat1 <= i) && (paramFloat2 <= i)) {
              return false;
            }
            if ((paramFloat1 < paramFloat2 * 0.5F) && (this.mCallback.onEdgeLock(paramInt2)))
            {
              int[] arrayOfInt = this.mEdgeDragsLocked;
              arrayOfInt[paramInt1] |= paramInt2;
              return false;
            }
            bool1 = bool2;
            if ((this.mEdgeDragsInProgress[paramInt1] & paramInt2) == 0)
            {
              bool1 = bool2;
              if (paramFloat1 > this.mTouchSlop) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean checkTouchSlop(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramView == null) {
      return false;
    }
    int i;
    if (this.mCallback.getViewHorizontalDragRange(paramView) > 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (this.mCallback.getViewVerticalDragRange(paramView) > 0) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i != 0) && (j != 0))
    {
      i = this.mTouchSlop;
      if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 > i * i) {
        bool1 = true;
      }
      return bool1;
    }
    if (i != 0)
    {
      bool1 = bool3;
      if (Math.abs(paramFloat1) > this.mTouchSlop) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (j != 0)
    {
      bool1 = bool2;
      if (Math.abs(paramFloat2) > this.mTouchSlop) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private float clampMag(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2) {
      return 0.0F;
    }
    if (f > paramFloat3)
    {
      if (paramFloat1 > 0.0F) {
        return paramFloat3;
      }
      return -paramFloat3;
    }
    return paramFloat1;
  }
  
  private int clampMag(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Math.abs(paramInt1);
    if (i < paramInt2) {
      return 0;
    }
    if (i > paramInt3)
    {
      if (paramInt1 > 0) {
        return paramInt3;
      }
      return -paramInt3;
    }
    return paramInt1;
  }
  
  private void clearMotionHistory()
  {
    float[] arrayOfFloat = this.mInitialMotionX;
    if (arrayOfFloat == null) {
      return;
    }
    Arrays.fill(arrayOfFloat, 0.0F);
    Arrays.fill(this.mInitialMotionY, 0.0F);
    Arrays.fill(this.mLastMotionX, 0.0F);
    Arrays.fill(this.mLastMotionY, 0.0F);
    Arrays.fill(this.mInitialEdgesTouched, 0);
    Arrays.fill(this.mEdgeDragsInProgress, 0);
    Arrays.fill(this.mEdgeDragsLocked, 0);
    this.mPointersDown = 0;
  }
  
  private void clearMotionHistory(int paramInt)
  {
    if (this.mInitialMotionX != null)
    {
      if (!isPointerDown(paramInt)) {
        return;
      }
      this.mInitialMotionX[paramInt] = 0.0F;
      this.mInitialMotionY[paramInt] = 0.0F;
      this.mLastMotionX[paramInt] = 0.0F;
      this.mLastMotionY[paramInt] = 0.0F;
      this.mInitialEdgesTouched[paramInt] = 0;
      this.mEdgeDragsInProgress[paramInt] = 0;
      this.mEdgeDragsLocked[paramInt] = 0;
      this.mPointersDown = ((1 << paramInt ^ 0xFFFFFFFF) & this.mPointersDown);
    }
  }
  
  private int computeAxisDuration(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i = this.mParentView.getWidth();
    int j = i / 2;
    float f2 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    f2 = distanceInfluenceForSnapDuration(f2);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {
      paramInt1 = Math.round(Math.abs((f1 + f2 * f1) / paramInt2) * 1000.0F) * 4;
    } else {
      paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F);
    }
    return Math.min(paramInt1, 600);
  }
  
  private int computeSettleDuration(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = clampMag(paramInt3, (int)this.mMinVelocity, (int)this.mMaxVelocity);
    paramInt4 = clampMag(paramInt4, (int)this.mMinVelocity, (int)this.mMaxVelocity);
    int i = Math.abs(paramInt1);
    int j = Math.abs(paramInt2);
    int k = Math.abs(paramInt3);
    int m = Math.abs(paramInt4);
    int n = k + m;
    int i1 = i + j;
    float f1;
    float f2;
    if (paramInt3 != 0)
    {
      f1 = k;
      f2 = n;
    }
    else
    {
      f1 = i;
      f2 = i1;
    }
    float f3 = f1 / f2;
    if (paramInt4 != 0)
    {
      f1 = m;
      f2 = n;
    }
    else
    {
      f1 = j;
      f2 = i1;
    }
    f1 /= f2;
    paramInt1 = computeAxisDuration(paramInt1, paramInt3, this.mCallback.getViewHorizontalDragRange(paramView));
    paramInt2 = computeAxisDuration(paramInt2, paramInt4, this.mCallback.getViewVerticalDragRange(paramView));
    return (int)(paramInt1 * f3 + paramInt2 * f1);
  }
  
  public static ViewDragHelper create(ViewGroup paramViewGroup, float paramFloat, ViewDragHelper.Callback paramCallback)
  {
    paramViewGroup = create(paramViewGroup, paramCallback);
    paramViewGroup.mTouchSlop = ((int)(paramViewGroup.mTouchSlop * (1.0F / paramFloat)));
    return paramViewGroup;
  }
  
  public static ViewDragHelper create(ViewGroup paramViewGroup, ViewDragHelper.Callback paramCallback)
  {
    return new ViewDragHelper(paramViewGroup.getContext(), paramViewGroup, paramCallback);
  }
  
  private void dispatchViewReleased(float paramFloat1, float paramFloat2, MotionEvent paramMotionEvent)
  {
    this.mReleaseInProgress = true;
    this.mCallback.onViewReleased(this.mCapturedView, paramFloat1, paramFloat2, paramMotionEvent);
    this.mReleaseInProgress = false;
    if (this.mDragState == 1) {
      setDragState(0);
    }
  }
  
  private float distanceInfluenceForSnapDuration(float paramFloat)
  {
    double d = paramFloat - 0.5F;
    Double.isNaN(d);
    return (float)Math.sin((float)(d * 0.47123891676382D));
  }
  
  private void dragTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = this.mCapturedView.getLeft();
    int k = this.mCapturedView.getTop();
    int i = paramInt1;
    if (paramInt3 != 0)
    {
      i = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, paramInt1, paramInt3);
      this.mCapturedView.offsetLeftAndRight(i - j);
    }
    paramInt1 = paramInt2;
    if (paramInt4 != 0)
    {
      paramInt1 = this.mCallback.clampViewPositionVertical(this.mCapturedView, paramInt2, paramInt4);
      this.mCapturedView.offsetTopAndBottom(paramInt1 - k);
    }
    if ((paramInt3 != 0) || (paramInt4 != 0)) {
      this.mCallback.onViewPositionChanged(this.mCapturedView, i, paramInt1, i - j, paramInt1 - k);
    }
  }
  
  private void ensureMotionHistorySizeForId(int paramInt)
  {
    float[] arrayOfFloat1 = this.mInitialMotionX;
    if ((arrayOfFloat1 == null) || (arrayOfFloat1.length <= paramInt))
    {
      paramInt += 1;
      arrayOfFloat1 = new float[paramInt];
      float[] arrayOfFloat2 = new float[paramInt];
      float[] arrayOfFloat3 = new float[paramInt];
      float[] arrayOfFloat4 = new float[paramInt];
      int[] arrayOfInt1 = new int[paramInt];
      int[] arrayOfInt2 = new int[paramInt];
      int[] arrayOfInt3 = new int[paramInt];
      Object localObject = this.mInitialMotionX;
      if (localObject != null)
      {
        System.arraycopy(localObject, 0, arrayOfFloat1, 0, localObject.length);
        localObject = this.mInitialMotionY;
        System.arraycopy(localObject, 0, arrayOfFloat2, 0, localObject.length);
        localObject = this.mLastMotionX;
        System.arraycopy(localObject, 0, arrayOfFloat3, 0, localObject.length);
        localObject = this.mLastMotionY;
        System.arraycopy(localObject, 0, arrayOfFloat4, 0, localObject.length);
        localObject = this.mInitialEdgesTouched;
        System.arraycopy(localObject, 0, arrayOfInt1, 0, localObject.length);
        localObject = this.mEdgeDragsInProgress;
        System.arraycopy(localObject, 0, arrayOfInt2, 0, localObject.length);
        localObject = this.mEdgeDragsLocked;
        System.arraycopy(localObject, 0, arrayOfInt3, 0, localObject.length);
      }
      this.mInitialMotionX = arrayOfFloat1;
      this.mInitialMotionY = arrayOfFloat2;
      this.mLastMotionX = arrayOfFloat3;
      this.mLastMotionY = arrayOfFloat4;
      this.mInitialEdgesTouched = arrayOfInt1;
      this.mEdgeDragsInProgress = arrayOfInt2;
      this.mEdgeDragsLocked = arrayOfInt3;
    }
  }
  
  private boolean forceSettleCapturedViewAt(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.mCapturedView.getLeft();
    int j = this.mCapturedView.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.mScroller.abortAnimation();
      setDragState(0);
      return false;
    }
    paramInt3 = computeSettleDuration(this.mCapturedView, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mScroller.startScroll(i, j, paramInt1, paramInt2, paramInt3);
    setDragState(2);
    return true;
  }
  
  private int getEdgesTouched(int paramInt1, int paramInt2)
  {
    if (paramInt1 < this.mParentView.getLeft() + this.mEdgeSize) {
      j = 1;
    } else {
      j = 0;
    }
    int i = j;
    if (paramInt2 < this.mParentView.getTop() + this.mEdgeSize) {
      i = j | 0x4;
    }
    int j = i;
    if (paramInt1 > this.mParentView.getRight() - this.mEdgeSize) {
      j = i | 0x2;
    }
    paramInt1 = j;
    if (paramInt2 > this.mParentView.getBottom() - this.mEdgeSize) {
      paramInt1 = j | 0x8;
    }
    return paramInt1;
  }
  
  private boolean handlePastSlop(int paramInt1, int paramInt2, View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = paramView.getLeft();
      paramInt1 = this.mCallback.clampViewPositionHorizontal(paramView, i + paramInt1, paramInt1);
      int j = paramView.getTop();
      paramInt2 = this.mCallback.clampViewPositionVertical(paramView, j + paramInt2, paramInt2);
      int k = this.mCallback.getViewHorizontalDragRange(paramView);
      int m = this.mCallback.getViewVerticalDragRange(paramView);
      if (((k == 0) || ((k > 0) && (paramInt1 == i))) && ((m == 0) || ((m > 0) && (paramInt2 == j)))) {
        return true;
      }
    }
    return false;
  }
  
  private void handleProcessDownEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = paramMotionEvent.getPointerId(0);
    paramMotionEvent = findTopChildUnder((int)f1, (int)f2);
    saveInitialMotion(f1, f2, i);
    tryCaptureViewForDrag(paramMotionEvent, i);
    int j = this.mInitialEdgesTouched[i];
    int k = this.mTrackingEdges;
    if ((j & k) != 0) {
      this.mCallback.onEdgeTouched(j & k, i);
    }
  }
  
  private void handleProcessMoveEvent(MotionEvent paramMotionEvent)
  {
    int j = this.mDragState;
    int i = 0;
    float f1;
    float f2;
    Object localObject;
    if (j == 1)
    {
      if (!isValidPointerForActionMove(this.mActivePointerId)) {
        return;
      }
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      f1 = paramMotionEvent.getX(i);
      f2 = paramMotionEvent.getY(i);
      localObject = this.mLastMotionX;
      j = this.mActivePointerId;
      i = (int)(f1 - localObject[j]);
      j = (int)(f2 - this.mLastMotionY[j]);
      if (this.scrollDirction == 2)
      {
        f1 = this.mCapturedView.getHeight();
        i = (int)(i * (f1 / this.mCapturedView.getWidth()));
        dragTo(this.mCapturedView.getLeft(), this.mCapturedView.getTop() + i, 0, i);
      }
      else
      {
        dragTo(this.mCapturedView.getLeft() + i, this.mCapturedView.getTop() + j, i, j);
      }
      saveLastMotion(paramMotionEvent);
      return;
    }
    j = paramMotionEvent.getPointerCount();
    while (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      if (isValidPointerForActionMove(k))
      {
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        float f3 = f1 - this.mInitialMotionX[k];
        float f4 = f2 - this.mInitialMotionY[k];
        reportNewEdgeDrags(f3, f4, k);
        if (this.mDragState == 1) {
          break;
        }
        localObject = findTopChildUnder((int)f1, (int)f2);
        if ((checkTouchSlop((View)localObject, f3, f4)) && (tryCaptureViewForDrag((View)localObject, k))) {
          break;
        }
      }
      i += 1;
    }
    saveLastMotion(paramMotionEvent);
  }
  
  private void handleProcessPointerDownEvent(MotionEvent paramMotionEvent, int paramInt)
  {
    int i = paramMotionEvent.getPointerId(paramInt);
    float f1 = paramMotionEvent.getX(paramInt);
    float f2 = paramMotionEvent.getY(paramInt);
    saveInitialMotion(f1, f2, i);
    if (this.mDragState == 0)
    {
      tryCaptureViewForDrag(findTopChildUnder((int)f1, (int)f2), i);
      paramInt = this.mInitialEdgesTouched[i];
      int j = this.mTrackingEdges;
      if ((paramInt & j) != 0) {
        this.mCallback.onEdgeTouched(paramInt & j, i);
      }
    }
    else if (isCapturedViewUnder((int)f1, (int)f2))
    {
      tryCaptureViewForDrag(this.mCapturedView, i);
    }
  }
  
  private void handleProcessPointerUpEvent(MotionEvent paramMotionEvent, int paramInt)
  {
    int i = paramMotionEvent.getPointerId(paramInt);
    if ((this.mDragState == 1) && (i == this.mActivePointerId))
    {
      int j = paramMotionEvent.getPointerCount();
      paramInt = 0;
      while (paramInt < j)
      {
        int k = paramMotionEvent.getPointerId(paramInt);
        if (k != this.mActivePointerId)
        {
          float f1 = paramMotionEvent.getX(paramInt);
          float f2 = paramMotionEvent.getY(paramInt);
          View localView1 = findTopChildUnder((int)f1, (int)f2);
          View localView2 = this.mCapturedView;
          if ((localView1 == localView2) && (tryCaptureViewForDrag(localView2, k)))
          {
            paramInt = this.mActivePointerId;
            break label122;
          }
        }
        paramInt += 1;
      }
      paramInt = -1;
      label122:
      if (paramInt == -1) {
        releaseViewForPointerUp(paramMotionEvent);
      }
    }
    clearMotionHistory(i);
  }
  
  private void handleShouldInterceptDownEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = paramMotionEvent.getPointerId(0);
    saveInitialMotion(f1, f2, i);
    paramMotionEvent = findTopChildUnder((int)f1, (int)f2);
    if ((paramMotionEvent == this.mCapturedView) && (this.mDragState == 2)) {
      tryCaptureViewForDrag(paramMotionEvent, i);
    }
    int j = this.mInitialEdgesTouched[i];
    int k = this.mTrackingEdges;
    if ((j & k) != 0) {
      this.mCallback.onEdgeTouched(j & k, i);
    }
  }
  
  private void handleShouldInterceptMoveEvent(MotionEvent paramMotionEvent)
  {
    if (this.mInitialMotionX != null)
    {
      if (this.mInitialMotionY == null) {
        return;
      }
      int j = paramMotionEvent.getPointerCount();
      int i = 0;
      while (i < j)
      {
        int k = paramMotionEvent.getPointerId(i);
        if (isValidPointerForActionMove(k))
        {
          float f1 = paramMotionEvent.getX(i);
          float f2 = paramMotionEvent.getY(i);
          float f3 = f1 - this.mInitialMotionX[k];
          float f4 = f2 - this.mInitialMotionY[k];
          View localView = findTopChildUnder((int)f1, (int)f2);
          boolean bool = checkTouchSlop(localView, f3, f4);
          if (handlePastSlop((int)f3, (int)f4, localView, bool)) {
            break;
          }
          reportNewEdgeDrags(f3, f4, k);
          if ((this.mDragState == 1) || ((bool) && (tryCaptureViewForDrag(localView, k)))) {
            break;
          }
        }
        i += 1;
      }
      saveLastMotion(paramMotionEvent);
    }
  }
  
  private void handleShouldInterceptPointerDownEvent(MotionEvent paramMotionEvent, int paramInt)
  {
    int i = paramMotionEvent.getPointerId(paramInt);
    float f1 = paramMotionEvent.getX(paramInt);
    float f2 = paramMotionEvent.getY(paramInt);
    saveInitialMotion(f1, f2, i);
    paramInt = this.mDragState;
    if (paramInt == 0)
    {
      paramInt = this.mInitialEdgesTouched[i];
      int j = this.mTrackingEdges;
      if ((paramInt & j) != 0) {
        this.mCallback.onEdgeTouched(paramInt & j, i);
      }
    }
    else if (paramInt == 2)
    {
      paramMotionEvent = findTopChildUnder((int)f1, (int)f2);
      if (paramMotionEvent == this.mCapturedView) {
        tryCaptureViewForDrag(paramMotionEvent, i);
      }
    }
  }
  
  private boolean isValidPointerForActionMove(int paramInt)
  {
    return isPointerDown(paramInt);
  }
  
  private void releaseViewForPointerUp(MotionEvent paramMotionEvent)
  {
    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
    dispatchViewReleased(clampMag(VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), paramMotionEvent);
  }
  
  private void reportNewEdgeDrags(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    if (!checkNewEdgeDrag(paramFloat1, paramFloat2, paramInt, 1)) {
      j = 0;
    }
    int i = j;
    if (checkNewEdgeDrag(paramFloat2, paramFloat1, paramInt, 4)) {
      i = j | 0x4;
    }
    j = i;
    if (checkNewEdgeDrag(paramFloat1, paramFloat2, paramInt, 2)) {
      j = i | 0x2;
    }
    i = j;
    if (checkNewEdgeDrag(paramFloat2, paramFloat1, paramInt, 8)) {
      i = j | 0x8;
    }
    if (i != 0)
    {
      int[] arrayOfInt = this.mEdgeDragsInProgress;
      arrayOfInt[paramInt] |= i;
      this.mCallback.onEdgeDragStarted(i, paramInt);
    }
  }
  
  private void saveInitialMotion(float paramFloat1, float paramFloat2, int paramInt)
  {
    ensureMotionHistorySizeForId(paramInt);
    float[] arrayOfFloat = this.mInitialMotionX;
    this.mLastMotionX[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.mInitialMotionY;
    this.mLastMotionY[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.mInitialEdgesTouched[paramInt] = getEdgesTouched((int)paramFloat1, (int)paramFloat2);
    this.mPointersDown |= 1 << paramInt;
  }
  
  private void saveLastMotion(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      if (isValidPointerForActionMove(k))
      {
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        this.mLastMotionX[k] = f1;
        this.mLastMotionY[k] = f2;
      }
      i += 1;
    }
  }
  
  public void abort()
  {
    cancel();
    if (this.mDragState == 2)
    {
      int i = this.mScroller.getCurrX();
      int j = this.mScroller.getCurrY();
      this.mScroller.abortAnimation();
      int k = this.mScroller.getCurrX();
      int m = this.mScroller.getCurrY();
      this.mCallback.onViewPositionChanged(this.mCapturedView, k, m, k - i, m - j);
    }
    setDragState(0);
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = paramView instanceof ViewGroup;
    boolean bool1 = true;
    if (bool2)
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      int i = localViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = localViewGroup.getChildAt(i);
        int m = paramInt3 + j;
        if ((m >= localView.getLeft()) && (m < localView.getRight()))
        {
          int n = paramInt4 + k;
          if ((n >= localView.getTop()) && (n < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2, m - localView.getLeft(), n - localView.getTop()))) {
            return true;
          }
        }
        i -= 1;
      }
    }
    if (paramBoolean)
    {
      paramBoolean = bool1;
      if (ViewCompat.canScrollHorizontally(paramView, -paramInt1)) {
        return paramBoolean;
      }
      if (ViewCompat.canScrollVertically(paramView, -paramInt2)) {
        return true;
      }
    }
    paramBoolean = false;
    return paramBoolean;
  }
  
  public void cancel()
  {
    this.mActivePointerId = -1;
    clearMotionHistory();
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  public void captureChildView(View paramView, int paramInt)
  {
    if (paramView.getParent() == this.mParentView)
    {
      this.mCapturedView = paramView;
      this.mActivePointerId = paramInt;
      this.mCallback.onViewCaptured(paramView, paramInt);
      setDragState(1);
      return;
    }
    paramView = new StringBuilder();
    paramView.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
    paramView.append(this.mParentView);
    paramView.append(")");
    throw new IllegalArgumentException(paramView.toString());
  }
  
  public boolean checkTouchSlop(int paramInt)
  {
    int j = this.mInitialMotionX.length;
    int i = 0;
    while (i < j)
    {
      if (checkTouchSlop(paramInt, i)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean checkTouchSlop(int paramInt1, int paramInt2)
  {
    boolean bool4 = isPointerDown(paramInt2);
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (!bool4) {
      return false;
    }
    int i;
    if ((paramInt1 & 0x1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramInt1 & 0x2) == 2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    float f1 = this.mLastMotionX[paramInt2] - this.mInitialMotionX[paramInt2];
    float f2 = this.mLastMotionY[paramInt2] - this.mInitialMotionY[paramInt2];
    if ((i != 0) && (paramInt1 != 0))
    {
      paramInt1 = this.mTouchSlop;
      if (f1 * f1 + f2 * f2 > paramInt1 * paramInt1) {
        bool1 = true;
      }
      return bool1;
    }
    if (i != 0)
    {
      bool1 = bool3;
      if (Math.abs(f1) > this.mTouchSlop) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (paramInt1 != 0)
    {
      bool1 = bool2;
      if (Math.abs(f2) > this.mTouchSlop) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean continueSettling(boolean paramBoolean)
  {
    int i = this.mDragState;
    boolean bool2 = false;
    if (i == 2)
    {
      boolean bool3 = this.mScroller.computeScrollOffset();
      i = this.mScroller.getCurrX();
      int j = this.mScroller.getCurrY();
      int k = i - this.mCapturedView.getLeft();
      int m = j - this.mCapturedView.getTop();
      if (k != 0) {
        this.mCapturedView.offsetLeftAndRight(k);
      }
      if (m != 0) {
        this.mCapturedView.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        this.mCallback.onViewPositionChanged(this.mCapturedView, i, j, k, m);
      }
      boolean bool1 = bool3;
      if (bool3)
      {
        bool1 = bool3;
        if (i == this.mScroller.getFinalX())
        {
          bool1 = bool3;
          if (j == this.mScroller.getFinalY())
          {
            this.mScroller.abortAnimation();
            bool1 = false;
          }
        }
      }
      if (!bool1) {
        if (paramBoolean) {
          this.mParentView.post(this.mSetIdleRunnable);
        } else {
          setDragState(0);
        }
      }
    }
    paramBoolean = bool2;
    if (this.mDragState == 2) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public View findTopChildUnder(int paramInt1, int paramInt2)
  {
    int i = this.mParentView.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(i));
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public void flingCapturedView(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mReleaseInProgress)
    {
      this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), paramInt1, paramInt3, paramInt2, paramInt4);
      setDragState(2);
      return;
    }
    throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
  }
  
  public int getActivePointerId()
  {
    return this.mActivePointerId;
  }
  
  public View getCapturedView()
  {
    return this.mCapturedView;
  }
  
  public int getEdgeSize()
  {
    return this.mEdgeSize;
  }
  
  public float getMinVelocity()
  {
    return this.mMinVelocity;
  }
  
  public int getScrollDirction()
  {
    return this.scrollDirction;
  }
  
  public int getTouchSlop()
  {
    return this.mTouchSlop;
  }
  
  public int getViewDragState()
  {
    return this.mDragState;
  }
  
  public boolean isCapturedViewUnder(int paramInt1, int paramInt2)
  {
    return isViewUnder(this.mCapturedView, paramInt1, paramInt2);
  }
  
  public boolean isEdgeTouched(int paramInt)
  {
    int j = this.mInitialEdgesTouched.length;
    int i = 0;
    while (i < j)
    {
      if (isEdgeTouched(paramInt, i)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isEdgeTouched(int paramInt1, int paramInt2)
  {
    return (isPointerDown(paramInt2)) && ((paramInt1 & this.mInitialEdgesTouched[paramInt2]) != 0);
  }
  
  public boolean isPointerDown(int paramInt)
  {
    return (1 << paramInt & this.mPointersDown) != 0;
  }
  
  public boolean isViewUnder(View paramView, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    if (paramView == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramInt1 >= paramView.getLeft())
    {
      bool1 = bool2;
      if (paramInt1 < paramView.getRight())
      {
        bool1 = bool2;
        if (paramInt2 >= paramView.getTop())
        {
          bool1 = bool2;
          if (paramInt2 < paramView.getBottom()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void processTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    int j = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (i == 0) {
      cancel();
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 5)
            {
              if (i != 6) {
                return;
              }
              handleProcessPointerUpEvent(paramMotionEvent, j);
              return;
            }
            handleProcessPointerDownEvent(paramMotionEvent, j);
            return;
          }
          if (this.mDragState == 1) {
            dispatchViewReleased(0.0F, 0.0F, paramMotionEvent);
          }
          cancel();
          return;
        }
        handleProcessMoveEvent(paramMotionEvent);
        return;
      }
      if (this.mDragState == 1) {
        releaseViewForPointerUp(paramMotionEvent);
      }
      cancel();
      return;
    }
    handleProcessDownEvent(paramMotionEvent);
  }
  
  void setDragState(int paramInt)
  {
    this.mParentView.removeCallbacks(this.mSetIdleRunnable);
    if (this.mDragState != paramInt)
    {
      this.mDragState = paramInt;
      this.mCallback.onViewDragStateChanged(paramInt);
      if (this.mDragState == 0) {
        this.mCapturedView = null;
      }
    }
  }
  
  public void setEdgeTrackingEnabled(int paramInt)
  {
    this.mTrackingEdges = paramInt;
  }
  
  public void setMinVelocity(float paramFloat)
  {
    this.mMinVelocity = paramFloat;
  }
  
  public void setScrollDirection(int paramInt)
  {
    this.scrollDirction = paramInt;
  }
  
  public boolean settleCapturedViewAt(int paramInt1, int paramInt2)
  {
    if (this.mReleaseInProgress) {
      return forceSettleCapturedViewAt(paramInt1, paramInt2, (int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId));
    }
    throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
  }
  
  public void settleCapturedViewImmediately(View paramView, int paramInt1, int paramInt2)
  {
    this.mCapturedView = paramView;
    int i = paramView.getLeft();
    int j = paramView.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.mScroller.abortAnimation();
      return;
    }
    this.mScroller.startScroll(i, j, paramInt1, paramInt2, 0);
    setDragState(2);
  }
  
  public boolean shouldInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    int j = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (i == 0) {
      cancel();
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 5)
            {
              if (i != 6) {
                break label114;
              }
              clearMotionHistory(paramMotionEvent.getPointerId(j));
              break label114;
            }
            handleShouldInterceptPointerDownEvent(paramMotionEvent, j);
            break label114;
          }
        }
        else
        {
          handleShouldInterceptMoveEvent(paramMotionEvent);
          break label114;
        }
      }
      cancel();
    }
    else
    {
      handleShouldInterceptDownEvent(paramMotionEvent);
    }
    label114:
    return this.mDragState == 1;
  }
  
  public boolean smoothSlideViewTo(View paramView, int paramInt1, int paramInt2)
  {
    this.mCapturedView = paramView;
    this.mActivePointerId = -1;
    boolean bool = forceSettleCapturedViewAt(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (this.mDragState == 0) && (this.mCapturedView != null)) {
      this.mCapturedView = null;
    }
    return bool;
  }
  
  boolean tryCaptureViewForDrag(View paramView, int paramInt)
  {
    if ((paramView == this.mCapturedView) && (this.mActivePointerId == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.mCallback.tryCaptureView(paramView, paramInt)))
    {
      this.mActivePointerId = paramInt;
      captureChildView(paramView, paramInt);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.swipe.ViewDragHelper
 * JD-Core Version:    0.7.0.1
 */