package com.tencent.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.concurrent.atomic.AtomicBoolean;

public class PhotoGridView
  extends RecyclerView
{
  public static final float HORIZONTAL_SLIDE_RATIO = 1.73F;
  GridLayoutManager gridLayoutManager;
  int mBeginSelectPosition = -1;
  AtomicBoolean mEnableSelectMode = new AtomicBoolean(true);
  int mEndSelectPosition = -1;
  AtomicBoolean mIsBegined = new AtomicBoolean(false);
  AtomicBoolean mIsBeingInSelectMode = new AtomicBoolean(false);
  boolean mIsScrolling = false;
  boolean mIsScrollingFromTop = true;
  float mLastMotionX;
  float mLastMotionY;
  PhotoGridView.OnSelectListener mOnSelectChangedListener;
  int mTouchSlop;
  LinearSmoothScroller smoothScroller;
  
  public PhotoGridView(@NonNull Context paramContext)
  {
    this(paramContext, (AttributeSet)null);
  }
  
  public PhotoGridView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PhotoGridView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mTouchSlop = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 15);
    addOnScrollListener(new PhotoGridView.MyScrollListener(this));
    this.smoothScroller = new PhotoGridView.1(this, paramContext);
  }
  
  private void handleMove(float paramFloat1, float paramFloat2)
  {
    if (!this.mIsBeingInSelectMode.get())
    {
      float f = Math.abs(paramFloat1 - this.mLastMotionX);
      if ((f > Math.abs(paramFloat2 - this.mLastMotionY) * 1.73F) && (f > this.mTouchSlop))
      {
        this.mIsBeingInSelectMode.set(true);
        this.mLastMotionX = paramFloat1;
        this.mLastMotionY = paramFloat2;
      }
    }
    if (this.mIsBeingInSelectMode.get()) {
      if (this.mIsScrolling) {
        handleMoveScrolling(paramFloat2);
      } else {
        handleMoveNoScrolling(paramFloat2);
      }
    }
    handleScroll((int)paramFloat1, (int)paramFloat2);
  }
  
  private void handleMoveNoScrolling(float paramFloat)
  {
    if ((paramFloat < 0.0F) || (paramFloat > getHeight()))
    {
      this.mIsScrolling = true;
      int i = 0;
      if (paramFloat < 0.0F)
      {
        this.mIsScrollingFromTop = false;
      }
      else if (paramFloat > getHeight())
      {
        i = getAdapter().getItemCount();
        this.mIsScrollingFromTop = true;
      }
      this.smoothScroller.setTargetPosition(i);
      this.gridLayoutManager.startSmoothScroll(this.smoothScroller);
    }
  }
  
  private void handleMoveScrolling(float paramFloat)
  {
    if ((paramFloat > 0.0F) && (paramFloat < getHeight()))
    {
      stopScroll();
      this.mIsScrolling = false;
    }
  }
  
  private void handleScroll(int paramInt1, int paramInt2)
  {
    if (this.mIsBeingInSelectMode.get())
    {
      boolean bool = this.mIsBegined.get();
      int i = -1;
      if (!bool)
      {
        int j = this.mBeginSelectPosition;
        if (j != -1)
        {
          localObject = this.mOnSelectChangedListener;
          if (localObject != null) {
            ((PhotoGridView.OnSelectListener)localObject).onSelectBegin(j);
          }
          this.mIsBegined.set(true);
        }
      }
      Object localObject = findChildViewUnder(paramInt1, paramInt2);
      paramInt1 = i;
      if (localObject != null) {
        paramInt1 = getChildAdapterPosition((View)localObject);
      }
      handleScrollSelectState(paramInt1);
    }
  }
  
  private void handleScrollSelectState(int paramInt)
  {
    if (paramInt != -1)
    {
      PhotoGridView.OnSelectListener localOnSelectListener;
      if (!this.mIsBegined.get())
      {
        this.mEndSelectPosition = paramInt;
        this.mBeginSelectPosition = paramInt;
        localOnSelectListener = this.mOnSelectChangedListener;
        if (localOnSelectListener != null) {
          localOnSelectListener.onSelectBegin(this.mBeginSelectPosition);
        }
        this.mIsBegined.set(true);
        return;
      }
      if (this.mEndSelectPosition != paramInt)
      {
        this.mEndSelectPosition = paramInt;
        if (!this.mIsScrolling)
        {
          localOnSelectListener = this.mOnSelectChangedListener;
          if (localOnSelectListener != null) {
            localOnSelectListener.onSelectChanged(this.mBeginSelectPosition, this.mEndSelectPosition);
          }
        }
      }
    }
  }
  
  private boolean handleUp()
  {
    if (this.mIsScrolling)
    {
      stopScroll();
      this.mIsScrolling = false;
    }
    boolean bool = this.mIsBeingInSelectMode.get();
    this.mBeginSelectPosition = -1;
    this.mEndSelectPosition = -1;
    this.mIsBeingInSelectMode.set(false);
    this.mIsBegined.set(false);
    if (bool)
    {
      PhotoGridView.OnSelectListener localOnSelectListener = this.mOnSelectChangedListener;
      if (localOnSelectListener != null) {
        localOnSelectListener.onSelectEnd();
      }
    }
    return bool;
  }
  
  private boolean processEvent(MotionEvent paramMotionEvent, int paramInt)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramInt &= 0xFF;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return false;
          }
        }
        else
        {
          float f3 = Math.abs(f1 - this.mLastMotionX);
          if ((f3 <= Math.abs(f2 - this.mLastMotionY) * 1.73F) || (f3 <= this.mTouchSlop)) {
            break label195;
          }
          this.mIsBeingInSelectMode.set(true);
          this.mLastMotionX = f1;
          this.mLastMotionY = f2;
          return false;
        }
      }
      boolean bool = this.mIsBeingInSelectMode.get();
      this.mIsBeingInSelectMode.set(false);
      this.mBeginSelectPosition = -1;
      this.mEndSelectPosition = -1;
      this.mIsBegined.set(false);
      if (bool) {
        return true;
      }
    }
    else
    {
      this.mLastMotionX = f1;
      this.mLastMotionY = f2;
      paramMotionEvent = findChildViewUnder((int)f1, (int)f2);
      if (paramMotionEvent != null) {
        paramInt = getChildAdapterPosition(paramMotionEvent);
      } else {
        paramInt = -1;
      }
      if (paramInt != -1)
      {
        this.mEndSelectPosition = paramInt;
        this.mBeginSelectPosition = paramInt;
      }
    }
    label195:
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mEnableSelectMode.get()) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    i &= 0xFF;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label94;
          }
        }
        else
        {
          handleMove(f1, f2);
          break label94;
        }
      }
      if (handleUp()) {
        return true;
      }
    }
    else
    {
      this.mLastMotionX = f1;
      this.mLastMotionY = f2;
    }
    label94:
    if (this.mIsBeingInSelectMode.get()) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mEnableSelectMode.get()) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.mIsBeingInSelectMode.get())) {
      return true;
    }
    if (processEvent(paramMotionEvent, i)) {
      return true;
    }
    if (this.mIsBeingInSelectMode.get()) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setLayoutManager(@Nullable GridLayoutManager paramGridLayoutManager)
  {
    super.setLayoutManager(paramGridLayoutManager);
    this.gridLayoutManager = paramGridLayoutManager;
  }
  
  public void setOnIndexChangedListener(PhotoGridView.OnSelectListener paramOnSelectListener)
  {
    this.mOnSelectChangedListener = paramOnSelectListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.PhotoGridView
 * JD-Core Version:    0.7.0.1
 */