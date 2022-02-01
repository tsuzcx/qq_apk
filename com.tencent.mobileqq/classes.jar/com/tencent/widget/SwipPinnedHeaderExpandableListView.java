package com.tencent.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListAdapter;
import android.widget.Scroller;

public class SwipPinnedHeaderExpandableListView
  extends PinnedHeaderExpandableListView
  implements Handler.Callback
{
  private static final int ANIM_DURATION = 300;
  private static final int MSG_ANIM_HIDE = 1;
  private static final int MSG_ANIM_SHOW = 0;
  private static final int MSG_HIDE_POPMENU = 2;
  private static final byte SLIDE_DIR_DEFAULT = 0;
  private static final byte SLIDE_DIR_HORIZONTAL = 1;
  private static final byte SLIDE_DIR_VERTICAL = 2;
  public static final String TAG = "SwipListView";
  public static final int TAG_MENUS_WIDTH = -3;
  private View mCurItemView;
  private int mCurViewRVWidth;
  private int mCurX;
  private int mCurY;
  private boolean mDragEnable = false;
  private boolean mIsShowRV;
  private SwipPinnedHeaderExpandableListView.SwipListListener mListener;
  private int mMinFlingVelocity;
  private View mPreItemView;
  private SwipPinnedHeaderExpandableListView.RightIconMenuListener mRIMListenr;
  private Scroller mScroller;
  private Handler mScrollerHandler;
  private byte mSlideDir;
  private int mStartX;
  private int mStartY;
  private View mToAnimView;
  private final int scaledTouchSlop;
  private VelocityTracker velocityTracker;
  
  public SwipPinnedHeaderExpandableListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842863);
  }
  
  public SwipPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mScroller = new Scroller(paramContext, new SwipPinnedHeaderExpandableListView.SmoothInterpolator());
    paramContext = ViewConfiguration.get(getContext());
    this.scaledTouchSlop = paramContext.getScaledTouchSlop();
    this.mMinFlingVelocity = (paramContext.getScaledMinimumFlingVelocity() * 4);
    this.mStartX = -1;
    this.mCurX = -1;
    this.mStartY = -1;
    this.mCurY = -1;
    this.mScrollerHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void addVelocityTracker(MotionEvent paramMotionEvent)
  {
    if (this.velocityTracker == null) {
      this.velocityTracker = VelocityTracker.obtain();
    }
    this.velocityTracker.addMovement(paramMotionEvent);
  }
  
  private void cancelShowHideAnim()
  {
    this.mScrollerHandler.removeMessages(1);
    this.mScrollerHandler.removeMessages(0);
    this.mToAnimView = null;
  }
  
  private void endOfTouch()
  {
    int i = getScrollVelocity();
    int j = this.mCurItemView.getScrollX();
    int k = this.mMinFlingVelocity;
    if (i > k)
    {
      hiddeRight(this.mCurItemView);
      return;
    }
    if (i < -k)
    {
      showRight(this.mCurItemView);
      return;
    }
    if ((i > 0) && (j < this.mCurViewRVWidth * 0.7F))
    {
      hiddeRight(this.mCurItemView);
      return;
    }
    if ((i < 0) && (j > this.mCurViewRVWidth * 0.3F))
    {
      showRight(this.mCurItemView);
      return;
    }
    if ((this.mIsShowRV) && (j < this.mCurViewRVWidth * 0.7F))
    {
      hiddeRight(this.mCurItemView);
      return;
    }
    if (j > this.mCurViewRVWidth * 0.3F)
    {
      showRight(this.mCurItemView);
      return;
    }
    hiddeRight(this.mCurItemView);
  }
  
  private int getAnimDuration(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      return (int)(Math.abs(paramInt2) / paramInt1 * 300.0F) + 50;
    }
    return 300;
  }
  
  private int getScrollVelocity()
  {
    this.velocityTracker.computeCurrentVelocity(1000);
    return (int)this.velocityTracker.getXVelocity();
  }
  
  private void hiddeRight(View paramView)
  {
    int i;
    if (paramView != null) {
      i = paramView.getScrollX();
    } else {
      i = 0;
    }
    Object localObject = this.mListener;
    if (localObject != null) {
      ((SwipPinnedHeaderExpandableListView.SwipListListener)localObject).updateCurShowRightView(null);
    }
    if (i != 0)
    {
      int j;
      if ((paramView.getTag(-3) instanceof Integer)) {
        j = ((Integer)paramView.getTag(-3)).intValue();
      } else {
        j = 0;
      }
      localObject = this.mToAnimView;
      if ((localObject != paramView) && (localObject != null)) {
        ((View)localObject).scrollTo(0, 0);
      }
      cancelShowHideAnim();
      this.mToAnimView = paramView;
      int k = -i;
      this.mScroller.startScroll(i, 0, k, 0, getAnimDuration(j, k));
      this.mScrollerHandler.sendEmptyMessage(1);
      return;
    }
    paramView = this.mRIMListenr;
    if (paramView != null) {
      paramView.onRightIconMenuHide(this.mToAnimView);
    }
  }
  
  private boolean isHitCurItemLeft(float paramFloat)
  {
    return paramFloat < getWidth() - this.mCurViewRVWidth;
  }
  
  private boolean isShowingRightView(View paramView)
  {
    return (paramView != null) && (paramView.getScrollX() >= this.scaledTouchSlop);
  }
  
  private boolean judgeScrollDirection(float paramFloat1, float paramFloat2)
  {
    int i = this.scaledTouchSlop;
    if ((paramFloat1 <= i) && (paramFloat2 <= i)) {
      return false;
    }
    if ((paramFloat1 > this.scaledTouchSlop) && (paramFloat2 / paramFloat1 < 0.6F))
    {
      this.mSlideDir = 1;
      return true;
    }
    this.mSlideDir = 2;
    return true;
  }
  
  private void recycleVelocityTracker()
  {
    VelocityTracker localVelocityTracker = this.velocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.velocityTracker = null;
    }
  }
  
  private void showRight(View paramView)
  {
    int i;
    if (paramView != null)
    {
      i = paramView.getScrollX();
      localObject = this.mListener;
      if (localObject != null) {
        ((SwipPinnedHeaderExpandableListView.SwipListListener)localObject).updateCurShowRightView(paramView);
      }
    }
    else
    {
      i = 0;
    }
    int k = this.mCurViewRVWidth;
    int j = k;
    if (k == 0)
    {
      j = k;
      if (paramView != null)
      {
        j = k;
        if ((paramView.getTag(-3) instanceof Integer)) {
          j = ((Integer)paramView.getTag(-3)).intValue();
        }
      }
    }
    if (i != j)
    {
      localObject = this.mToAnimView;
      if ((localObject != paramView) && (localObject != null)) {
        ((View)localObject).scrollTo(0, 0);
      }
      cancelShowHideAnim();
      this.mToAnimView = paramView;
      k = j - i;
      this.mScroller.startScroll(i, 0, k, 0, getAnimDuration(j, k));
      this.mScrollerHandler.sendEmptyMessage(0);
      return;
    }
    Object localObject = this.mRIMListenr;
    if (localObject != null) {
      ((SwipPinnedHeaderExpandableListView.RightIconMenuListener)localObject).onRightIconMenuShow(paramView);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    boolean bool;
    float f;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
        paramMessage = this.mListener;
        if (paramMessage != null)
        {
          paramMessage.hideMenuPop();
          return true;
        }
      }
      else
      {
        bool = this.mScroller.computeScrollOffset();
        f = this.mScroller.getCurrX();
        paramMessage = this.mToAnimView;
        if (paramMessage != null)
        {
          paramMessage.scrollTo((int)f, 0);
          invalidate();
        }
        if (bool)
        {
          this.mScrollerHandler.sendEmptyMessage(1);
          return true;
        }
        paramMessage = this.mRIMListenr;
        if (paramMessage != null) {
          paramMessage.onRightIconMenuHide(this.mToAnimView);
        }
        this.mToAnimView = null;
        return true;
      }
    }
    else
    {
      bool = this.mScroller.computeScrollOffset();
      f = this.mScroller.getCurrX();
      paramMessage = this.mToAnimView;
      if (paramMessage != null)
      {
        paramMessage.scrollTo((int)f, 0);
        invalidate();
      }
      if (bool)
      {
        this.mScrollerHandler.sendEmptyMessage(0);
        return true;
      }
      paramMessage = this.mRIMListenr;
      if (paramMessage != null) {
        paramMessage.onRightIconMenuShow(this.mToAnimView);
      }
      this.mToAnimView = null;
    }
    return true;
  }
  
  public void hideCurShowingRightView()
  {
    if (!isShowingRightView(this.mCurItemView))
    {
      int i = getFirstVisiblePosition() - getHeaderViewsCount();
      int j = getLastVisiblePosition();
      while (i <= j)
      {
        View localView = getChildAt(i);
        if (isShowingRightView(localView))
        {
          this.mCurItemView = localView;
          break;
        }
        i += 1;
      }
    }
    hiddeRight(this.mCurItemView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mDragEnable) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int j = (int)(paramMotionEvent.getX() + 0.5F);
    int i = (int)(paramMotionEvent.getY() + 0.5F);
    int k = paramMotionEvent.getAction();
    if (k != 0)
    {
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3) {
            break label189;
          }
        }
        else
        {
          if (this.mCurViewRVWidth <= 0) {
            break label189;
          }
          if (this.mSlideDir == 0) {
            judgeScrollDirection(Math.abs(j - this.mStartX), Math.abs(i - this.mStartY));
          }
          if (this.mSlideDir != 1) {
            break label189;
          }
          if (j < this.mStartX) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          bool1 = bool2;
          if (!bool2) {
            break label488;
          }
          this.mScrollerHandler.sendEmptyMessage(2);
          bool1 = bool2;
          break label488;
        }
      }
      if (this.mIsShowRV) {
        hiddeRight(this.mPreItemView);
      }
      this.mStartX = -1;
      this.mCurX = -1;
      this.mStartY = -1;
      this.mCurY = -1;
    }
    label189:
    Object localObject;
    do
    {
      bool1 = false;
      break;
      this.mSlideDir = 0;
      localObject = this.mListener;
      if (localObject != null) {
        ((SwipPinnedHeaderExpandableListView.SwipListListener)localObject).updateCurShowRightView(null);
      }
      this.mStartX = j;
      this.mCurX = j;
      this.mStartY = i;
      this.mCurY = i;
      this.mPreItemView = this.mCurItemView;
      this.mIsShowRV = isShowingRightView(this.mPreItemView);
      if (!this.mIsShowRV)
      {
        int m = getFirstVisiblePosition();
        int n = getHeaderViewsCount();
        i = getLastVisiblePosition();
        while (i >= m - n)
        {
          localObject = getChildAt(i);
          this.mIsShowRV = isShowingRightView((View)localObject);
          if (this.mIsShowRV)
          {
            this.mPreItemView = ((View)localObject);
            break;
          }
          i -= 1;
        }
      }
      this.mCurViewRVWidth = 0;
      this.mCurItemView = null;
      i = this.mStartY;
      if (isOverscrollHeadVisiable()) {
        i = this.mStartY + getScrollY();
      }
      i = pointToPosition(this.mStartX, i);
      if (i >= 0)
      {
        this.mCurItemView = getChildAt(i - getFirstVisiblePosition());
        localObject = this.mCurItemView;
        if ((localObject != null) && ((((View)localObject).getTag(-3) instanceof Integer))) {
          this.mCurViewRVWidth = ((Integer)this.mCurItemView.getTag(-3)).intValue();
        }
        if ((this.mCurViewRVWidth > 0) && (!supportSwip(this.mCurItemView))) {
          this.mCurViewRVWidth = 0;
        }
      }
    } while ((!this.mIsShowRV) || ((this.mCurItemView == this.mPreItemView) && (!isHitCurItemLeft(j))));
    boolean bool1 = true;
    label488:
    if ((k == 0) && (this.mIsShowRV))
    {
      localObject = this.mListener;
      if (localObject != null) {
        ((SwipPinnedHeaderExpandableListView.SwipListListener)localObject).interceptTouchEvent(true);
      }
      cancelShowHideAnim();
    }
    else if ((k == 1) || (k == 3))
    {
      localObject = this.mListener;
      if (localObject != null) {
        ((SwipPinnedHeaderExpandableListView.SwipListListener)localObject).interceptTouchEvent(false);
      }
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = super.onInterceptTouchEvent(paramMotionEvent);
    }
    return bool2;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mDragEnable) {
      return super.onTouchEvent(paramMotionEvent);
    }
    addVelocityTracker(paramMotionEvent);
    int i = (int)(paramMotionEvent.getX() + 0.5F);
    int j = (int)(paramMotionEvent.getY() + 0.5F);
    int k = paramMotionEvent.getAction();
    boolean bool1;
    label265:
    label268:
    label282:
    label285:
    Object localObject;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2)
        {
          if (k == 3) {
            break label285;
          }
        }
        else
        {
          if (this.mIsShowRV)
          {
            if ((this.mCurItemView == this.mPreItemView) && (!isHitCurItemLeft(i))) {
              bool1 = false;
            } else {
              bool1 = true;
            }
            bool2 = bool1;
            if (this.mCurItemView != this.mPreItemView) {
              break label268;
            }
            if ((this.mSlideDir == 0) && (!judgeScrollDirection(Math.abs(i - this.mStartX), Math.abs(j - this.mStartY)))) {
              break label282;
            }
            bool2 = bool1;
            if (this.mSlideDir != 1) {
              break label268;
            }
            scrollItemView(i, j, this.mCurItemView, this.mCurViewRVWidth);
            break label265;
          }
          if (this.mCurViewRVWidth != 0) {}
        }
        do
        {
          bool2 = false;
          break;
          if ((this.mSlideDir == 0) && (!judgeScrollDirection(Math.abs(i - this.mStartX), Math.abs(j - this.mStartY))))
          {
            bool1 = false;
            break label505;
          }
        } while (this.mSlideDir != 1);
        scrollItemView(i, j, this.mCurItemView, this.mCurViewRVWidth);
        bool2 = true;
        this.mCurX = i;
        this.mCurY = j;
        bool1 = bool2;
        break label505;
      }
      if (this.mIsShowRV)
      {
        if ((this.mCurItemView == this.mPreItemView) && (!isHitCurItemLeft(i))) {
          bool2 = false;
        } else {
          bool2 = true;
        }
        localObject = this.mCurItemView;
        bool1 = bool2;
        if (localObject != this.mPreItemView) {
          break label402;
        }
        if (this.mSlideDir == 1)
        {
          endOfTouch();
        }
        else
        {
          hiddeRight((View)localObject);
          bool1 = bool2;
          break label402;
        }
      }
      else
      {
        if ((this.mCurViewRVWidth == 0) || (this.mSlideDir != 1)) {
          break label399;
        }
        endOfTouch();
      }
      bool1 = true;
      break label402;
      label399:
      bool1 = false;
      label402:
      recycleVelocityTracker();
      this.mStartX = -1;
      this.mCurX = -1;
      this.mStartY = -1;
      this.mCurY = -1;
    }
    else
    {
      if ((this.mIsShowRV) && ((this.mCurItemView != this.mPreItemView) || (isHitCurItemLeft(i)))) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      bool1 = bool2;
      if (this.mIsShowRV)
      {
        localObject = this.mPreItemView;
        bool1 = bool2;
        if (localObject != this.mCurItemView)
        {
          hiddeRight((View)localObject);
          bool1 = bool2;
        }
      }
    }
    label505:
    if ((k == 0) && (this.mIsShowRV))
    {
      localObject = this.mListener;
      if (localObject != null) {
        ((SwipPinnedHeaderExpandableListView.SwipListListener)localObject).interceptTouchEvent(true);
      }
    }
    else if ((k == 1) || (k == 3))
    {
      localObject = this.mListener;
      if (localObject != null) {
        ((SwipPinnedHeaderExpandableListView.SwipListListener)localObject).interceptTouchEvent(false);
      }
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = super.onTouchEvent(paramMotionEvent);
    }
    return bool2;
  }
  
  public void resetState()
  {
    this.mPreItemView = null;
    this.mCurItemView = null;
    this.mStartX = -1;
    this.mCurX = -1;
    this.mStartY = -1;
    this.mCurY = -1;
  }
  
  protected void scrollItemView(int paramInt1, int paramInt2, View paramView, int paramInt3)
  {
    paramInt2 = this.mCurX;
    paramInt2 = paramView.getScrollX() - (paramInt1 - paramInt2);
    if (paramInt2 > paramInt3)
    {
      paramInt1 = paramInt3;
    }
    else
    {
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        paramInt1 = 0;
      }
    }
    paramView.scrollTo(paramInt1, 0);
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    super.setAdapter(paramExpandableListAdapter);
    if ((paramExpandableListAdapter instanceof SwipPinnedHeaderExpandableListView.SwipListListener)) {
      this.mListener = ((SwipPinnedHeaderExpandableListView.SwipListListener)paramExpandableListAdapter);
    }
  }
  
  public void setDragEnable(boolean paramBoolean)
  {
    this.mDragEnable = paramBoolean;
    if (!this.mDragEnable) {
      hideCurShowingRightView();
    }
  }
  
  public void setRightIconMenuListener(SwipPinnedHeaderExpandableListView.RightIconMenuListener paramRightIconMenuListener)
  {
    this.mRIMListenr = paramRightIconMenuListener;
  }
  
  public void setSwipListListener(SwipPinnedHeaderExpandableListView.SwipListListener paramSwipListListener)
  {
    this.mListener = paramSwipListListener;
  }
  
  public boolean supportSwip(View paramView)
  {
    SwipPinnedHeaderExpandableListView.SwipListListener localSwipListListener = this.mListener;
    if (localSwipListListener != null) {
      return localSwipListListener.supportSwip(paramView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.SwipPinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */