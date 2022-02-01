package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import java.util.concurrent.atomic.AtomicBoolean;

public class GestureSelectGridView
  extends GridView
{
  public static final float HORIZONTAL_SLIDE_RATIO = 1.73F;
  int mBeginSelectPosition = -1;
  AtomicBoolean mEnableSelectMode = new AtomicBoolean(true);
  int mEndSelectPosition = -1;
  AtomicBoolean mIsBegined = new AtomicBoolean(false);
  AtomicBoolean mIsBeingInSelectMode = new AtomicBoolean(false);
  boolean mIsScrolling = false;
  boolean mIsScrollingFromTop = true;
  float mLastMotionX;
  float mLastMotionY;
  GestureSelectGridView.OnSelectListener mOnSelectChangedListener;
  AbsListView.OnScrollListener mSubOnScrollListener;
  int mTouchSlop;
  final int speed = 20000000;
  
  public GestureSelectGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GestureSelectGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mTouchSlop = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 15);
    super.setOnScrollListener(new GestureSelectGridView.MyScrollListener(this));
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
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    i &= 0xFF;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label225;
          }
        }
        else
        {
          float f3 = Math.abs(f1 - this.mLastMotionX);
          if ((f3 <= Math.abs(f2 - this.mLastMotionY) * 1.73F) || (f3 <= this.mTouchSlop)) {
            break label225;
          }
          this.mIsBeingInSelectMode.set(true);
          this.mLastMotionX = f1;
          this.mLastMotionY = f2;
          break label225;
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
      i = pointToPosition((int)f1, (int)f2);
      if (i != -1)
      {
        this.mEndSelectPosition = i;
        this.mBeginSelectPosition = i;
      }
    }
    label225:
    if (this.mIsBeingInSelectMode.get()) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mEnableSelectMode.get()) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int j = i & 0xFF;
    if (j != 0)
    {
      i = 0;
      GestureSelectGridView.OnSelectListener localOnSelectListener;
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3) {
            break label538;
          }
        }
        else
        {
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
          if ((this.mIsBeingInSelectMode.get()) && (!this.mIsScrolling))
          {
            if ((f2 < 0.0F) || (f2 > getHeight()))
            {
              this.mIsScrolling = true;
              if (f2 < 0.0F)
              {
                this.mIsScrollingFromTop = false;
                i = -20000000;
              }
              else if (f2 > getHeight())
              {
                i = 20000000;
                this.mIsScrollingFromTop = true;
              }
              smoothScrollBy(i, 1000000);
            }
          }
          else if ((this.mIsBeingInSelectMode.get()) && (this.mIsScrolling) && (f2 > 0.0F) && (f2 < getHeight()))
          {
            abordFling();
            this.mIsScrolling = false;
          }
          if (!this.mIsBeingInSelectMode.get()) {
            break label538;
          }
          if (!this.mIsBegined.get())
          {
            i = this.mBeginSelectPosition;
            if (i != -1)
            {
              localOnSelectListener = this.mOnSelectChangedListener;
              if (localOnSelectListener != null) {
                localOnSelectListener.onSelectBegin(i);
              }
              this.mIsBegined.set(true);
            }
          }
          i = pointToPosition((int)f1, (int)f2);
          if (i == -1) {
            break label538;
          }
          if (!this.mIsBegined.get())
          {
            this.mEndSelectPosition = i;
            this.mBeginSelectPosition = i;
            localOnSelectListener = this.mOnSelectChangedListener;
            if (localOnSelectListener != null) {
              localOnSelectListener.onSelectBegin(this.mBeginSelectPosition);
            }
            this.mIsBegined.set(true);
            break label538;
          }
          if (this.mEndSelectPosition == i) {
            break label538;
          }
          this.mEndSelectPosition = i;
          if (this.mIsScrolling) {
            break label538;
          }
          localOnSelectListener = this.mOnSelectChangedListener;
          if (localOnSelectListener == null) {
            break label538;
          }
          localOnSelectListener.onSelectChanged(this.mBeginSelectPosition, this.mEndSelectPosition);
          break label538;
        }
      }
      if (this.mIsScrolling)
      {
        abordFling();
        this.mIsScrolling = false;
      }
      boolean bool = this.mIsBeingInSelectMode.get();
      this.mBeginSelectPosition = -1;
      this.mEndSelectPosition = -1;
      this.mIsBeingInSelectMode.set(false);
      this.mIsBegined.set(false);
      if (bool)
      {
        localOnSelectListener = this.mOnSelectChangedListener;
        if (localOnSelectListener != null) {
          localOnSelectListener.onSelectEnd();
        }
      }
      if (bool) {
        return true;
      }
    }
    else
    {
      this.mLastMotionX = f1;
      this.mLastMotionY = f2;
    }
    label538:
    if (this.mIsBeingInSelectMode.get()) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnIndexChangedListener(GestureSelectGridView.OnSelectListener paramOnSelectListener)
  {
    this.mOnSelectChangedListener = paramOnSelectListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.mSubOnScrollListener = paramOnScrollListener;
  }
  
  public void setSelectMode(boolean paramBoolean)
  {
    this.mEnableSelectMode.set(paramBoolean);
  }
  
  public void setTouchSlopRate(int paramInt)
  {
    this.mTouchSlop = (ViewConfiguration.get(getContext()).getScaledTouchSlop() * paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.GestureSelectGridView
 * JD-Core Version:    0.7.0.1
 */