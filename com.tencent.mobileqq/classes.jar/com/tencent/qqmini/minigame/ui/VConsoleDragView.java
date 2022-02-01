package com.tencent.qqmini.minigame.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.utils.LiuHaiUtils;
import com.tencent.qqmini.sdk.utils.ViewUtils;

public class VConsoleDragView
  extends ImageView
{
  private int bottom;
  private int height;
  private boolean isDrag = false;
  private int lastX;
  private int lastY;
  private int left;
  private DisplayMetrics mDm;
  private VConsoleDragView.Listener mListener;
  private int mScreenHeight;
  private int mScreenWidth;
  private int right;
  private int startX;
  private int startY;
  private int top;
  private int width;
  
  public VConsoleDragView(Context paramContext)
  {
    super(paramContext);
    initScreenConfig();
  }
  
  public VConsoleDragView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initScreenConfig();
  }
  
  public VConsoleDragView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initScreenConfig();
  }
  
  private void initScreenConfig()
  {
    this.mScreenWidth = ViewUtils.getScreenWidth();
    int j = ViewUtils.getScreenHeight();
    int i;
    if (LiuHaiUtils.isLiuHaiUseValid()) {
      i = LiuHaiUtils.getStatusBarHeight(getContext());
    } else {
      i = 0;
    }
    this.mScreenHeight = (j + i);
    this.mDm = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics();
  }
  
  private void onTouchEventActionMove(FrameLayout.LayoutParams paramLayoutParams)
  {
    int i = this.startX - this.lastX;
    int j = this.startY - this.lastY;
    this.left = (getLeft() + i);
    this.top = (getTop() + j);
    this.right = (getRight() + i);
    this.bottom = (getBottom() + j);
    if (this.left < 0)
    {
      this.left = 0;
      this.right = (this.left + this.width);
    }
    else
    {
      i = this.right;
      j = this.mScreenWidth;
      if (i > j)
      {
        this.right = j;
        this.left = (this.right - this.width);
      }
    }
    if (this.top < 0)
    {
      this.top = 0;
      this.bottom = (this.top + this.height);
    }
    else
    {
      i = this.bottom;
      j = this.mScreenHeight;
      if (i > j)
      {
        this.bottom = j;
        this.top = (j - this.height);
      }
    }
    paramLayoutParams.setMargins(this.left, this.top, this.mScreenWidth - this.right, this.mScreenHeight - this.bottom);
    setLayoutParams(paramLayoutParams);
    if ((!this.isDrag) && ((Math.abs(this.startX - this.lastX) > this.mDm.density * 2.0F) || (Math.abs(this.startY - this.lastY) > this.mDm.density * 2.0F))) {
      this.isDrag = true;
    }
    this.lastX = this.startX;
    this.lastY = this.startY;
  }
  
  public int getStatusBarHeight()
  {
    int i = getResources().getIdentifier("status_bar_height", "dimen", "android");
    return getResources().getDimensionPixelSize(i);
  }
  
  public boolean isDrag()
  {
    return this.isDrag;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.width = getMeasuredWidth();
    this.height = getMeasuredHeight();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    this.startX = ((int)paramMotionEvent.getRawX());
    this.startY = ((int)paramMotionEvent.getRawY());
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        onTouchEventActionMove(localLayoutParams);
        return true;
      }
      if (!this.isDrag)
      {
        paramMotionEvent = this.mListener;
        if (paramMotionEvent != null) {
          paramMotionEvent.onVConsoleMoveUp();
        }
      }
      this.isDrag = false;
      return true;
    }
    this.lastX = this.startX;
    this.lastY = this.startY;
    return true;
  }
  
  public void requestLandscapeLayout()
  {
    int i = ViewUtils.getScreenWidth();
    int k = ViewUtils.getScreenHeight();
    if (i > k)
    {
      j = i;
    }
    else
    {
      if (LiuHaiUtils.isLiuHaiUseValid()) {
        j = LiuHaiUtils.getStatusBarHeight(getContext());
      } else {
        j = 0;
      }
      j += k;
    }
    this.mScreenWidth = j;
    int j = i;
    if (i > k) {
      j = k;
    }
    this.mScreenHeight = j;
    this.mDm = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics();
  }
  
  public void setListener(VConsoleDragView.Listener paramListener)
  {
    this.mListener = paramListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.VConsoleDragView
 * JD-Core Version:    0.7.0.1
 */