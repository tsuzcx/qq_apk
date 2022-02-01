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
    if (i > this.mMinFlingVelocity)
    {
      hiddeRight(this.mCurItemView);
      return;
    }
    if (i < -this.mMinFlingVelocity)
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
    int i = 300;
    if (paramInt1 > 0) {
      i = (int)(Math.abs(paramInt2) / paramInt1 * 300.0F) + 50;
    }
    return i;
  }
  
  private int getScrollVelocity()
  {
    this.velocityTracker.computeCurrentVelocity(1000);
    return (int)this.velocityTracker.getXVelocity();
  }
  
  private void hiddeRight(View paramView)
  {
    if (paramView != null) {}
    for (int i = paramView.getScrollX();; i = 0)
    {
      if (this.mListener != null) {
        this.mListener.updateCurShowRightView(null);
      }
      if (i != 0) {
        if (!(paramView.getTag(-3) instanceof Integer)) {
          break label142;
        }
      }
      label142:
      for (int j = ((Integer)paramView.getTag(-3)).intValue();; j = 0)
      {
        if ((this.mToAnimView != paramView) && (this.mToAnimView != null)) {
          this.mToAnimView.scrollTo(0, 0);
        }
        cancelShowHideAnim();
        this.mToAnimView = paramView;
        int k = -i;
        this.mScroller.startScroll(i, 0, k, 0, getAnimDuration(j, k));
        this.mScrollerHandler.sendEmptyMessage(1);
        do
        {
          return;
        } while (this.mRIMListenr == null);
        this.mRIMListenr.onRightIconMenuHide(this.mToAnimView);
        return;
      }
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
    if ((paramFloat1 > this.scaledTouchSlop) || (paramFloat2 > this.scaledTouchSlop))
    {
      if ((paramFloat1 > this.scaledTouchSlop) && (paramFloat2 / paramFloat1 < 0.6F))
      {
        this.mSlideDir = 1;
        return true;
      }
      this.mSlideDir = 2;
      return true;
    }
    return false;
  }
  
  private void recycleVelocityTracker()
  {
    if (this.velocityTracker != null)
    {
      this.velocityTracker.recycle();
      this.velocityTracker = null;
    }
  }
  
  private void showRight(View paramView)
  {
    int j;
    if (paramView != null)
    {
      j = paramView.getScrollX();
      i = j;
      if (this.mListener != null) {
        this.mListener.updateCurShowRightView(paramView);
      }
    }
    for (int i = j;; i = 0)
    {
      j = this.mCurViewRVWidth;
      if ((j == 0) && (paramView != null) && ((paramView.getTag(-3) instanceof Integer))) {
        j = ((Integer)paramView.getTag(-3)).intValue();
      }
      for (;;)
      {
        if (i != j)
        {
          if ((this.mToAnimView != paramView) && (this.mToAnimView != null)) {
            this.mToAnimView.scrollTo(0, 0);
          }
          cancelShowHideAnim();
          this.mToAnimView = paramView;
          k = j - i;
          this.mScroller.startScroll(i, 0, k, 0, getAnimDuration(j, k));
          this.mScrollerHandler.sendEmptyMessage(0);
        }
        while (this.mRIMListenr == null)
        {
          int k;
          return;
        }
        this.mRIMListenr.onRightIconMenuShow(paramView);
        return;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
      bool = this.mScroller.computeScrollOffset();
      float f = this.mScroller.getCurrX();
      if (this.mToAnimView != null)
      {
        this.mToAnimView.scrollTo((int)f, 0);
        invalidate();
      }
      if (bool)
      {
        this.mScrollerHandler.sendEmptyMessage(0);
        return true;
      }
      if (this.mRIMListenr != null) {
        this.mRIMListenr.onRightIconMenuShow(this.mToAnimView);
      }
      this.mToAnimView = null;
      return true;
      bool = this.mScroller.computeScrollOffset();
      f = this.mScroller.getCurrX();
      if (this.mToAnimView != null)
      {
        this.mToAnimView.scrollTo((int)f, 0);
        invalidate();
      }
      if (bool)
      {
        this.mScrollerHandler.sendEmptyMessage(1);
        return true;
      }
      if (this.mRIMListenr != null) {
        this.mRIMListenr.onRightIconMenuHide(this.mToAnimView);
      }
      this.mToAnimView = null;
      return true;
    } while (this.mListener == null);
    this.mListener.hideMenuPop();
    return true;
  }
  
  public void hideCurShowingRightView()
  {
    int i;
    int j;
    if (!isShowingRightView(this.mCurItemView))
    {
      i = getFirstVisiblePosition() - getHeaderViewsCount();
      j = getLastVisiblePosition();
    }
    for (;;)
    {
      if (i <= j)
      {
        View localView = getChildAt(i);
        if (isShowingRightView(localView)) {
          this.mCurItemView = localView;
        }
      }
      else
      {
        hiddeRight(this.mCurItemView);
        return;
      }
      i += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (!this.mDragEnable)
    {
      bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool2;
    }
    int j = (int)(paramMotionEvent.getX() + 0.5F);
    int i = (int)(paramMotionEvent.getY() + 0.5F);
    int k = paramMotionEvent.getAction();
    label76:
    boolean bool1;
    switch (k)
    {
    default: 
      bool1 = false;
      label79:
      if ((k == 0) && (this.mIsShowRV))
      {
        if (this.mListener != null) {
          this.mListener.interceptTouchEvent(true);
        }
        cancelShowHideAnim();
      }
      break;
    }
    for (;;)
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.mSlideDir = 0;
      if (this.mListener != null) {
        this.mListener.updateCurShowRightView(null);
      }
      this.mStartX = j;
      this.mCurX = j;
      this.mStartY = i;
      this.mCurY = i;
      this.mPreItemView = this.mCurItemView;
      this.mIsShowRV = isShowingRightView(this.mPreItemView);
      int m;
      int n;
      if (!this.mIsShowRV)
      {
        m = getFirstVisiblePosition();
        n = getHeaderViewsCount();
        i = getLastVisiblePosition();
      }
      for (;;)
      {
        if (i >= m - n)
        {
          View localView = getChildAt(i);
          this.mIsShowRV = isShowingRightView(localView);
          if (this.mIsShowRV) {
            this.mPreItemView = localView;
          }
        }
        else
        {
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
            if ((this.mCurItemView != null) && ((this.mCurItemView.getTag(-3) instanceof Integer))) {
              this.mCurViewRVWidth = ((Integer)this.mCurItemView.getTag(-3)).intValue();
            }
            if ((this.mCurViewRVWidth > 0) && (!supportSwip(this.mCurItemView))) {
              this.mCurViewRVWidth = 0;
            }
          }
          if ((!this.mIsShowRV) || ((this.mCurItemView == this.mPreItemView) && (!isHitCurItemLeft(j)))) {
            break label416;
          }
          bool1 = true;
          break;
        }
        i -= 1;
      }
      label416:
      bool1 = false;
      break label79;
      if (this.mCurViewRVWidth <= 0) {
        break label76;
      }
      if (this.mSlideDir == 0) {
        judgeScrollDirection(Math.abs(j - this.mStartX), Math.abs(i - this.mStartY));
      }
      if (this.mSlideDir != 1) {
        break label76;
      }
      if (j < this.mStartX) {}
      for (bool2 = true;; bool2 = false)
      {
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        this.mScrollerHandler.sendEmptyMessage(2);
        bool1 = bool2;
        break;
      }
      if (this.mIsShowRV) {
        hiddeRight(this.mPreItemView);
      }
      this.mStartX = -1;
      this.mCurX = -1;
      this.mStartY = -1;
      this.mCurY = -1;
      break label76;
      if (((k == 1) || (k == 3)) && (this.mListener != null)) {
        this.mListener.interceptTouchEvent(false);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (!this.mDragEnable)
    {
      bool2 = super.onTouchEvent(paramMotionEvent);
      return bool2;
    }
    addVelocityTracker(paramMotionEvent);
    int i = (int)(paramMotionEvent.getX() + 0.5F);
    int j = (int)(paramMotionEvent.getY() + 0.5F);
    int k = paramMotionEvent.getAction();
    boolean bool1;
    switch (k)
    {
    default: 
      bool1 = false;
    case 0: 
    case 2: 
      for (;;)
      {
        if ((k == 0) && (this.mIsShowRV))
        {
          if (this.mListener != null) {
            this.mListener.interceptTouchEvent(true);
          }
          label112:
          bool2 = bool1;
          if (bool1) {
            break;
          }
          return super.onTouchEvent(paramMotionEvent);
          if ((this.mIsShowRV) && ((this.mCurItemView != this.mPreItemView) || (isHitCurItemLeft(i)))) {}
          for (bool2 = true;; bool2 = false)
          {
            bool1 = bool2;
            if (!this.mIsShowRV) {
              break;
            }
            bool1 = bool2;
            if (this.mPreItemView == this.mCurItemView) {
              break;
            }
            hiddeRight(this.mPreItemView);
            bool1 = bool2;
            break;
          }
          if (this.mIsShowRV) {
            if ((this.mCurItemView != this.mPreItemView) || (isHitCurItemLeft(i)))
            {
              bool2 = true;
              label234:
              bool1 = bool2;
              if (this.mCurItemView == this.mPreItemView)
              {
                if (this.mSlideDir == 0)
                {
                  bool1 = bool2;
                  if (!judgeScrollDirection(Math.abs(i - this.mStartX), Math.abs(j - this.mStartY))) {
                    continue;
                  }
                }
                bool1 = bool2;
                if (this.mSlideDir == 1)
                {
                  scrollItemView(i, j, this.mCurItemView, this.mCurViewRVWidth);
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      this.mCurX = i;
      this.mCurY = j;
      break;
      bool2 = false;
      break label234;
      if (this.mCurViewRVWidth == 0)
      {
        bool1 = false;
      }
      else
      {
        if ((this.mSlideDir == 0) && (!judgeScrollDirection(Math.abs(i - this.mStartX), Math.abs(j - this.mStartY))))
        {
          bool1 = false;
          break;
        }
        if (this.mSlideDir == 1)
        {
          scrollItemView(i, j, this.mCurItemView, this.mCurViewRVWidth);
          bool1 = true;
          continue;
          if (this.mIsShowRV) {
            if ((this.mCurItemView != this.mPreItemView) || (isHitCurItemLeft(i)))
            {
              bool2 = true;
              label446:
              bool1 = bool2;
              if (this.mCurItemView == this.mPreItemView)
              {
                if (this.mSlideDir != 1) {
                  break label509;
                }
                endOfTouch();
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            recycleVelocityTracker();
            this.mStartX = -1;
            this.mCurX = -1;
            this.mStartY = -1;
            this.mCurY = -1;
            break;
            bool2 = false;
            break label446;
            label509:
            hiddeRight(this.mCurItemView);
            bool1 = bool2;
            continue;
            if (this.mCurViewRVWidth == 0)
            {
              bool1 = false;
            }
            else
            {
              if (this.mSlideDir == 1)
              {
                endOfTouch();
                bool1 = true;
                continue;
                if (((k != 1) && (k != 3)) || (this.mListener == null)) {
                  break label112;
                }
                this.mListener.interceptTouchEvent(false);
                break label112;
              }
              bool1 = false;
            }
          }
        }
        else
        {
          bool1 = false;
        }
      }
    }
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
    paramInt1 = paramView.getScrollX() - (paramInt1 - paramInt2);
    if (paramInt1 > paramInt3) {}
    for (;;)
    {
      paramView.scrollTo(paramInt3, 0);
      return;
      if (paramInt1 < 0) {
        paramInt3 = 0;
      } else {
        paramInt3 = paramInt1;
      }
    }
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
    if (this.mListener != null) {
      return this.mListener.supportSwip(paramView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.SwipPinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */