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
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if (!this.mEnableSelectMode.get()) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    int j = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    label201:
    label221:
    View localView;
    switch (j & 0xFF)
    {
    default: 
    case 2: 
      for (;;)
      {
        if (this.mIsBeingInSelectMode.get())
        {
          return true;
          if (!this.mIsBeingInSelectMode.get())
          {
            float f3 = Math.abs(f1 - this.mLastMotionX);
            if ((f3 > Math.abs(f2 - this.mLastMotionY) * 1.73F) && (f3 > this.mTouchSlop))
            {
              this.mIsBeingInSelectMode.set(true);
              this.mLastMotionX = f1;
              this.mLastMotionY = f2;
            }
          }
          if ((this.mIsBeingInSelectMode.get()) && (!this.mIsScrolling)) {
            if ((f2 < 0.0F) || (f2 > getHeight()))
            {
              this.mIsScrolling = true;
              if (f2 < 0.0F)
              {
                this.mIsScrollingFromTop = false;
                this.smoothScroller.setTargetPosition(i);
                this.gridLayoutManager.startSmoothScroll(this.smoothScroller);
              }
            }
            else
            {
              if (!this.mIsBeingInSelectMode.get()) {
                continue;
              }
              if ((!this.mIsBegined.get()) && (this.mBeginSelectPosition != -1))
              {
                if (this.mOnSelectChangedListener != null) {
                  this.mOnSelectChangedListener.onSelectBegin(this.mBeginSelectPosition);
                }
                this.mIsBegined.set(true);
              }
              localView = findChildViewUnder((int)f1, (int)f2);
              if (localView == null) {
                break label580;
              }
            }
          }
        }
      }
    }
    label580:
    for (i = getChildAdapterPosition(localView); i != -1; i = -1)
    {
      if (!this.mIsBegined.get())
      {
        this.mEndSelectPosition = i;
        this.mBeginSelectPosition = i;
        if (this.mOnSelectChangedListener != null) {
          this.mOnSelectChangedListener.onSelectBegin(this.mBeginSelectPosition);
        }
        this.mIsBegined.set(true);
        break;
        if (f2 <= getHeight()) {
          break label201;
        }
        i = getAdapter().getItemCount();
        this.mIsScrollingFromTop = true;
        break label201;
        if ((!this.mIsBeingInSelectMode.get()) || (!this.mIsScrolling) || (f2 <= 0.0F) || (f2 >= getHeight())) {
          break label221;
        }
        stopScroll();
        this.mIsScrolling = false;
        break label221;
      }
      if (this.mEndSelectPosition == i) {
        break;
      }
      this.mEndSelectPosition = i;
      if ((this.mIsScrolling) || (this.mOnSelectChangedListener == null)) {
        break;
      }
      this.mOnSelectChangedListener.onSelectChanged(this.mBeginSelectPosition, this.mEndSelectPosition);
      break;
      this.mLastMotionX = f1;
      this.mLastMotionY = f2;
      break;
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
      if ((bool) && (this.mOnSelectChangedListener != null)) {
        this.mOnSelectChangedListener.onSelectEnd();
      }
      if (!bool) {
        break;
      }
      return true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
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
      return bool1;
      i = paramMotionEvent.getAction();
      if (i != 2) {
        break;
      }
      bool1 = bool2;
    } while (this.mIsBeingInSelectMode.get());
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    View localView;
    switch (i & 0xFF)
    {
    default: 
    case 2: 
      for (;;)
      {
        bool1 = bool2;
        if (this.mIsBeingInSelectMode.get()) {
          break;
        }
        return super.onInterceptTouchEvent(paramMotionEvent);
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
      localView = findChildViewUnder((int)f1, (int)f2);
      if (localView == null) {
        break;
      }
    }
    for (int i = getChildAdapterPosition(localView); i != -1; i = -1)
    {
      this.mEndSelectPosition = i;
      this.mBeginSelectPosition = i;
      break;
      bool1 = this.mIsBeingInSelectMode.get();
      this.mIsBeingInSelectMode.set(false);
      this.mBeginSelectPosition = -1;
      this.mEndSelectPosition = -1;
      this.mIsBegined.set(false);
      if (!bool1) {
        break;
      }
      return true;
    }
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