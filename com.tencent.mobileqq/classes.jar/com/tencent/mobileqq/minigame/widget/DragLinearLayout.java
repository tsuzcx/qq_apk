package com.tencent.mobileqq.minigame.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bdoo;

public class DragLinearLayout
  extends RelativeLayout
{
  private static final String TAG = "DragLinearLayout";
  int bottom;
  private float downX;
  private float downY;
  private int height;
  private boolean isDrag;
  int left;
  int right;
  private int screenHeight;
  private int screenWidth;
  int top;
  private int width;
  
  public DragLinearLayout(Context paramContext)
  {
    super(paramContext);
    initScreenConfig();
  }
  
  public DragLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initScreenConfig();
  }
  
  public DragLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initScreenConfig();
  }
  
  @RequiresApi(api=21)
  public DragLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    initScreenConfig();
  }
  
  private void initScreenConfig()
  {
    this.screenWidth = bdoo.a();
    this.screenHeight = bdoo.b();
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
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    if (isEnabled())
    {
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return true;
        this.isDrag = false;
        this.downX = paramMotionEvent.getX();
        this.downY = paramMotionEvent.getY();
        continue;
        float f1 = paramMotionEvent.getX() - this.downX;
        float f2 = paramMotionEvent.getY() - this.downY;
        if ((Math.abs(f1) > 30.0F) || (Math.abs(f2) > 30.0F))
        {
          this.isDrag = true;
          this.left = ((int)(f1 + getLeft()));
          this.right = (this.left + this.width);
          this.top = ((int)(getTop() + f2));
          this.bottom = (this.top + this.height);
          if (this.left >= 0) {
            break label271;
          }
          this.left = 0;
          this.right = (this.left + this.width);
          label202:
          if (this.top >= 0) {
            break label306;
          }
          this.top = 0;
          this.bottom = (this.top + this.height);
        }
        for (;;)
        {
          localLayoutParams.setMargins(this.left, this.top, this.screenWidth - this.right, this.screenHeight - this.bottom);
          setLayoutParams(localLayoutParams);
          bringToFront();
          break;
          label271:
          if (this.right <= this.screenWidth) {
            break label202;
          }
          this.right = this.screenWidth;
          this.left = (this.right - this.width);
          break label202;
          label306:
          if (this.bottom > this.screenHeight)
          {
            this.bottom = this.screenHeight;
            this.top = (this.bottom - this.height);
          }
        }
        setPressed(false);
        localLayoutParams.setMargins(this.left, this.top, this.screenWidth - this.right, this.screenHeight - this.bottom - getStatusBarHeight());
        setLayoutParams(localLayoutParams);
        bringToFront();
        continue;
        setPressed(false);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.widget.DragLinearLayout
 * JD-Core Version:    0.7.0.1
 */