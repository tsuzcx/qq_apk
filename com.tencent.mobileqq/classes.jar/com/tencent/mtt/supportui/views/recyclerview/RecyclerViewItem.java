package com.tencent.mtt.supportui.views.recyclerview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class RecyclerViewItem
  extends FrameLayout
{
  public static int ITEM_VIEW_DEFAULT_HEIGHT = 360;
  public int id;
  boolean mBlockRequestLayout = false;
  public View mContentView;
  public RecyclerView.ViewHolderWrapper mHolder;
  ViewTreeObserver.OnPreDrawListener mLayoutListener;
  boolean mLayoutListenerPosted;
  protected RecyclerViewBase mParentRecyclerView;
  boolean mTouchEnabled = true;
  
  public RecyclerViewItem(Context paramContext, RecyclerViewBase paramRecyclerViewBase)
  {
    super(paramContext);
    this.mParentRecyclerView = paramRecyclerViewBase;
  }
  
  public void addContentView(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      this.mContentView = paramView;
      paramView = new FrameLayout.LayoutParams(-1, -1);
      this.mContentView.setLayoutParams(paramView);
      addView(this.mContentView);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mTouchEnabled) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public View getContentView()
  {
    return this.mContentView;
  }
  
  public final boolean isPointInView(float paramFloat1, float paramFloat2)
  {
    return (paramFloat1 >= 0.0F) && (paramFloat1 < getRight() - getLeft()) && (paramFloat2 >= 0.0F) && (paramFloat2 < getBottom() - getTop());
  }
  
  public void onAnimate(float paramFloat, int paramInt, boolean paramBoolean) {}
  
  protected void onAttachedToWindow()
  {
    try
    {
      super.onAttachedToWindow();
      return;
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mBlockRequestLayout = true;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mBlockRequestLayout = false;
  }
  
  public void onPostAnimate(int paramInt, boolean paramBoolean) {}
  
  public void onPreAnimate(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onStartAnimate(int paramInt) {}
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.mTouchEnabled = paramBoolean;
  }
  
  public void setParentRecyclerView(RecyclerViewBase paramRecyclerViewBase)
  {
    this.mParentRecyclerView = paramRecyclerViewBase;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewItem
 * JD-Core Version:    0.7.0.1
 */