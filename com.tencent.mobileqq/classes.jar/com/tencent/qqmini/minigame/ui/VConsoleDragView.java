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
    if (LiuHaiUtils.isLiuHaiUseValid()) {}
    for (int i = LiuHaiUtils.getStatusBarHeight(getContext());; i = 0)
    {
      this.mScreenHeight = (i + j);
      this.mDm = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics();
      return;
    }
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
    switch (paramMotionEvent.getAction())
    {
    default: 
      return true;
    case 0: 
      this.lastX = this.startX;
      this.lastY = this.startY;
      return true;
    case 2: 
      int i = this.startX - this.lastX;
      int j = this.startY - this.lastY;
      this.left = (getLeft() + i);
      this.top = (getTop() + j);
      this.right = (i + getRight());
      this.bottom = (getBottom() + j);
      if (this.left < 0)
      {
        this.left = 0;
        this.right = (this.left + this.width);
        if (this.top >= 0) {
          break label348;
        }
        this.top = 0;
        this.bottom = (this.top + this.height);
      }
      for (;;)
      {
        localLayoutParams.setMargins(this.left, this.top, this.mScreenWidth - this.right, this.mScreenHeight - this.bottom);
        setLayoutParams(localLayoutParams);
        if ((!this.isDrag) && ((Math.abs(this.startX - this.lastX) > this.mDm.density * 2.0F) || (Math.abs(this.startY - this.lastY) > this.mDm.density * 2.0F))) {
          this.isDrag = true;
        }
        this.lastX = this.startX;
        this.lastY = this.startY;
        return true;
        if (this.right <= this.mScreenWidth) {
          break;
        }
        this.right = this.mScreenWidth;
        this.left = (this.right - this.width);
        break;
        label348:
        if (this.bottom > this.mScreenHeight)
        {
          this.bottom = this.mScreenHeight;
          this.top = (this.mScreenHeight - this.height);
        }
      }
    }
    if ((!this.isDrag) && (this.mListener != null)) {
      this.mListener.onVConsoleMoveUp();
    }
    this.isDrag = false;
    return true;
  }
  
  public void requestLandscapeLayout()
  {
    int i = ViewUtils.getScreenWidth();
    int k = ViewUtils.getScreenHeight();
    if (i > k)
    {
      j = i;
      this.mScreenWidth = j;
      j = i;
      if (i > k) {
        j = k;
      }
      this.mScreenHeight = j;
      this.mDm = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics();
      return;
    }
    if (LiuHaiUtils.isLiuHaiUseValid()) {}
    for (int j = LiuHaiUtils.getStatusBarHeight(getContext());; j = 0)
    {
      j += k;
      break;
    }
  }
  
  public void setListener(VConsoleDragView.Listener paramListener)
  {
    this.mListener = paramListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.VConsoleDragView
 * JD-Core Version:    0.7.0.1
 */