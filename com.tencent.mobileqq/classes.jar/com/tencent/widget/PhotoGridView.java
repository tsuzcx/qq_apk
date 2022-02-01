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
    if (this.mIsBeingInSelectMode.get())
    {
      if (!this.mIsScrolling) {
        break label96;
      }
      handleMoveScrolling(paramFloat2);
    }
    for (;;)
    {
      handleScroll((int)paramFloat1, (int)paramFloat2);
      return;
      label96:
      handleMoveNoScrolling(paramFloat2);
    }
  }
  
  private void handleMoveNoScrolling(float paramFloat)
  {
    int i = 0;
    if ((paramFloat < 0.0F) || (paramFloat > getHeight()))
    {
      this.mIsScrolling = true;
      if (paramFloat >= 0.0F) {
        break label54;
      }
      this.mIsScrollingFromTop = false;
    }
    for (;;)
    {
      this.smoothScroller.setTargetPosition(i);
      this.gridLayoutManager.startSmoothScroll(this.smoothScroller);
      return;
      label54:
      if (paramFloat > getHeight())
      {
        i = getAdapter().getItemCount();
        this.mIsScrollingFromTop = true;
      }
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
    int i = -1;
    if (this.mIsBeingInSelectMode.get())
    {
      if ((!this.mIsBegined.get()) && (this.mBeginSelectPosition != -1))
      {
        if (this.mOnSelectChangedListener != null) {
          this.mOnSelectChangedListener.onSelectBegin(this.mBeginSelectPosition);
        }
        this.mIsBegined.set(true);
      }
      View localView = findChildViewUnder(paramInt1, paramInt2);
      paramInt1 = i;
      if (localView != null) {
        paramInt1 = getChildAdapterPosition(localView);
      }
      handleScrollSelectState(paramInt1);
    }
  }
  
  private void handleScrollSelectState(int paramInt)
  {
    if (paramInt != -1)
    {
      if (this.mIsBegined.get()) {
        break label54;
      }
      this.mEndSelectPosition = paramInt;
      this.mBeginSelectPosition = paramInt;
      if (this.mOnSelectChangedListener != null) {
        this.mOnSelectChangedListener.onSelectBegin(this.mBeginSelectPosition);
      }
      this.mIsBegined.set(true);
    }
    label54:
    do
    {
      do
      {
        return;
      } while (this.mEndSelectPosition == paramInt);
      this.mEndSelectPosition = paramInt;
    } while ((this.mIsScrolling) || (this.mOnSelectChangedListener == null));
    this.mOnSelectChangedListener.onSelectChanged(this.mBeginSelectPosition, this.mEndSelectPosition);
  }
  
  private boolean handleUp()
  {
    boolean bool1 = false;
    if (this.mIsScrolling)
    {
      stopScroll();
      this.mIsScrolling = false;
    }
    boolean bool2 = this.mIsBeingInSelectMode.get();
    this.mBeginSelectPosition = -1;
    this.mEndSelectPosition = -1;
    this.mIsBeingInSelectMode.set(false);
    this.mIsBegined.set(false);
    if ((bool2) && (this.mOnSelectChangedListener != null)) {
      this.mOnSelectChangedListener.onSelectEnd();
    }
    if (bool2) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean processEvent(MotionEvent paramMotionEvent, int paramInt)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramInt & 0xFF)
    {
    default: 
    case 2: 
      for (;;)
      {
        return false;
        float f3 = Math.abs(f1 - this.mLastMotionX);
        if ((f3 > Math.abs(f2 - this.mLastMotionY) * 1.73F) && (f3 > this.mTouchSlop))
        {
          this.mIsBeingInSelectMode.set(true);
          this.mLastMotionX = f1;
          this.mLastMotionY = f2;
        }
      }
    case 0: 
      this.mLastMotionX = f1;
      this.mLastMotionY = f2;
      paramMotionEvent = findChildViewUnder((int)f1, (int)f2);
      if (paramMotionEvent == null) {
        break;
      }
    }
    for (paramInt = getChildAdapterPosition(paramMotionEvent); paramInt != -1; paramInt = -1)
    {
      this.mEndSelectPosition = paramInt;
      this.mBeginSelectPosition = paramInt;
      break;
      boolean bool = this.mIsBeingInSelectMode.get();
      this.mIsBeingInSelectMode.set(false);
      this.mBeginSelectPosition = -1;
      this.mEndSelectPosition = -1;
      this.mIsBegined.set(false);
      if (!bool) {
        break;
      }
      return true;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!this.mEnableSelectMode.get()) {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    do
    {
      for (;;)
      {
        return bool;
        int i = paramMotionEvent.getAction();
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        switch (i & 0xFF)
        {
        default: 
        case 2: 
        case 0: 
          while (!this.mIsBeingInSelectMode.get())
          {
            return super.dispatchTouchEvent(paramMotionEvent);
            handleMove(f1, f2);
            continue;
            this.mLastMotionX = f1;
            this.mLastMotionY = f2;
          }
        }
      }
    } while (!handleUp());
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!this.mEnableSelectMode.get()) {
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
    }
    do
    {
      int i;
      do
      {
        do
        {
          return bool1;
          i = paramMotionEvent.getAction();
          if (i != 2) {
            break;
          }
          bool1 = bool2;
        } while (this.mIsBeingInSelectMode.get());
        bool1 = bool2;
      } while (processEvent(paramMotionEvent, i));
      bool1 = bool2;
    } while (this.mIsBeingInSelectMode.get());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.PhotoGridView
 * JD-Core Version:    0.7.0.1
 */