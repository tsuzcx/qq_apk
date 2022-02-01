package com.tencent.mtt.hippy.views.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.uimanager.d;
import com.tencent.mtt.hippy.uimanager.k;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.mtt.supportui.views.asyncimage.AsyncImageView.ScaleType;
import com.tencent.mtt.supportui.views.asyncimage.BackgroundDrawable;

public class HippyViewGroup
  extends HippyImageView
  implements d
{
  private static final int LAYER_TYPE_NOT_SET = -1;
  boolean isHandlePullUp = false;
  float mDownX = 0.0F;
  float mDownY = 0.0F;
  private final k mDrawingOrderHelper = new k(this);
  private int mOldLayerType = -1;
  private String mOverflow;
  private Path mOverflowPath;
  private RectF mOverflowRect;
  private ViewConfiguration mViewConfiguration;
  
  public HippyViewGroup(Context paramContext)
  {
    super(paramContext);
    setScaleType(AsyncImageView.ScaleType.ORIGIN);
  }
  
  private void restoreLayerType()
  {
    if (this.mOldLayerType > -1) {
      setLayerType(this.mOldLayerType, null);
    }
  }
  
  public void addView(View paramView, int paramInt)
  {
    super.addView(paramView, paramInt);
    this.mDrawingOrderHelper.a(paramView);
    setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.a());
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    String str;
    int i;
    if (this.mOverflow != null)
    {
      str = this.mOverflow;
      switch (str.hashCode())
      {
      default: 
        i = -1;
        switch (i)
        {
        default: 
          label47:
          restoreLayerType();
        }
        break;
      }
    }
    do
    {
      for (;;)
      {
        super.dispatchDraw(paramCanvas);
        return;
        if (!str.equals("visible")) {
          break;
        }
        i = 0;
        break label47;
        if (!str.equals("hidden")) {
          break;
        }
        i = 1;
        break label47;
        if (this.mOverflowPath != null) {
          this.mOverflowPath.rewind();
        }
        restoreLayerType();
      }
    } while (this.mBGDrawable == null);
    float f2 = getWidth();
    float f1 = getHeight();
    float f5;
    float f4;
    float f3;
    if ((this.mBGDrawable.getBorderWidthArray() != null) && (this.mBGDrawable.getBorderWidthArray()[0] != 0.0F))
    {
      f5 = this.mBGDrawable.getBorderWidthArray()[0];
      f4 = 0.0F + f5;
      f3 = 0.0F + f5;
      f2 -= f5;
      f1 -= f5;
    }
    for (;;)
    {
      if (this.mBGDrawable.getBorderRadiusArray() != null) {}
      for (f5 = this.mBGDrawable.getBorderRadiusArray()[0];; f5 = 0.0F)
      {
        for (;;)
        {
          if (f5 <= 0.0F) {
            break label368;
          }
          if (this.mOverflowPath == null) {
            this.mOverflowPath = new Path();
          }
          this.mOverflowPath.rewind();
          if (this.mOverflowRect == null) {
            this.mOverflowRect = new RectF();
          }
          this.mOverflowRect.set(f4, f3, f2, f1);
          this.mOverflowPath.addRoundRect(this.mOverflowRect, f5, f5, Path.Direction.CW);
          if (Build.VERSION.SDK_INT < 21)
          {
            if (this.mOldLayerType == -1) {
              this.mOldLayerType = getLayerType();
            }
            setLayerType(1, null);
          }
          try
          {
            paramCanvas.clipPath(this.mOverflowPath);
          }
          catch (Throwable localThrowable)
          {
            restoreLayerType();
          }
        }
        break;
      }
      label368:
      break;
      f3 = 0.0F;
      f4 = 0.0F;
    }
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    return this.mDrawingOrderHelper.a(paramInt1, paramInt2);
  }
  
  public int getZIndexMappedChildIndex(int paramInt)
  {
    int i = paramInt;
    if (this.mDrawingOrderHelper.a()) {
      i = this.mDrawingOrderHelper.a(getChildCount(), paramInt);
    }
    return i;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0)
    {
      this.mDownX = paramMotionEvent.getX();
      this.mDownY = paramMotionEvent.getY();
      this.isHandlePullUp = false;
    }
    boolean bool2 = super.onInterceptTouchEvent(paramMotionEvent);
    boolean bool1 = bool2;
    if (this.mGestureDispatcher != null) {
      bool1 = bool2 | this.mGestureDispatcher.needHandle("onInterceptTouchEvent");
    }
    bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (this.mGestureDispatcher != null)
      {
        bool2 = bool1;
        if (this.mGestureDispatcher.needHandle("onInterceptPullUpEvent")) {
          switch (i)
          {
          }
        }
      }
    }
    for (;;)
    {
      bool2 = this.isHandlePullUp;
      return bool2;
      if (!this.isHandlePullUp)
      {
        if (this.mViewConfiguration == null) {
          this.mViewConfiguration = new ViewConfiguration();
        }
        float f1 = paramMotionEvent.getX();
        float f2 = this.mDownX;
        float f3 = paramMotionEvent.getY() - this.mDownY;
        if ((f3 < 0.0F) && (Math.abs(f1 - f2) < Math.abs(f3)) && (Math.abs(f3) > this.mViewConfiguration.getScaledTouchSlop()))
        {
          this.mGestureDispatcher.handle("onTouchDown", this.mDownX, this.mDownY);
          this.isHandlePullUp = true;
        }
      }
    }
  }
  
  public void removeView(View paramView)
  {
    super.removeView(paramView);
    this.mDrawingOrderHelper.b(paramView);
    setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.a());
  }
  
  public void resetProps()
  {
    HippyViewGroupController.removeViewZIndex(this);
    this.mOverflow = null;
    setClipChildren(true);
  }
  
  public void setOverflow(String paramString)
  {
    this.mOverflow = paramString;
    int i;
    if (!TextUtils.isEmpty(this.mOverflow))
    {
      paramString = this.mOverflow;
      i = -1;
      switch (paramString.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
    }
    for (;;)
    {
      invalidate();
      return;
      if (!paramString.equals("visible")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("hidden")) {
        break;
      }
      i = 1;
      break;
      setClipChildren(false);
      continue;
      setClipChildren(true);
    }
  }
  
  public void updateDrawingOrder()
  {
    this.mDrawingOrderHelper.b();
    setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.a());
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.view.HippyViewGroup
 * JD-Core Version:    0.7.0.1
 */