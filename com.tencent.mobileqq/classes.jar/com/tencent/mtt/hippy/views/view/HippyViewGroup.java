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
    int i = this.mOldLayerType;
    if (i > -1) {
      setLayerType(i, null);
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
    Object localObject = this.mOverflow;
    if (localObject != null)
    {
      int i = ((String)localObject).hashCode();
      if (i != -1217487446)
      {
        if ((i == 466743410) && (((String)localObject).equals("visible")))
        {
          i = 0;
          break label70;
        }
      }
      else if (((String)localObject).equals("hidden"))
      {
        i = 1;
        break label70;
      }
      i = -1;
      label70:
      if (i != 0) {
        if (i == 1) {}
      }
    }
    for (;;)
    {
      restoreLayerType();
      break label340;
      if (this.mBGDrawable != null)
      {
        float f2 = getWidth();
        float f3 = getHeight();
        float f4;
        float f1;
        if ((this.mBGDrawable.getBorderWidthArray() != null) && (this.mBGDrawable.getBorderWidthArray()[0] != 0.0F))
        {
          f4 = this.mBGDrawable.getBorderWidthArray()[0];
          f1 = f4 + 0.0F;
          f2 -= f4;
          f3 -= f4;
          f4 = f1;
        }
        else
        {
          f4 = 0.0F;
          f1 = 0.0F;
        }
        float f5;
        if (this.mBGDrawable.getBorderRadiusArray() != null) {
          f5 = this.mBGDrawable.getBorderRadiusArray()[0];
        } else {
          f5 = 0.0F;
        }
        if (f5 > 0.0F)
        {
          if (this.mOverflowPath == null) {
            this.mOverflowPath = new Path();
          }
          this.mOverflowPath.rewind();
          if (this.mOverflowRect == null) {
            this.mOverflowRect = new RectF();
          }
          this.mOverflowRect.set(f4, f1, f2, f3);
          this.mOverflowPath.addRoundRect(this.mOverflowRect, f5, f5, Path.Direction.CW);
          if (Build.VERSION.SDK_INT < 21)
          {
            if (this.mOldLayerType == -1) {
              this.mOldLayerType = getLayerType();
            }
            setLayerType(1, null);
          }
        }
      }
      try
      {
        paramCanvas.clipPath(this.mOverflowPath);
        break label340;
        localObject = this.mOverflowPath;
        if (localObject != null)
        {
          ((Path)localObject).rewind();
          continue;
          label340:
          super.dispatchDraw(paramCanvas);
          return;
        }
      }
      catch (Throwable localThrowable) {}
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
        if (this.mGestureDispatcher.needHandle("onInterceptPullUpEvent"))
        {
          if ((i == 2) && (!this.isHandlePullUp))
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
          bool2 = this.isHandlePullUp;
        }
      }
    }
    return bool2;
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
    if (!TextUtils.isEmpty(this.mOverflow))
    {
      paramString = this.mOverflow;
      int i = -1;
      int j = paramString.hashCode();
      if (j != -1217487446)
      {
        if ((j == 466743410) && (paramString.equals("visible"))) {
          i = 0;
        }
      }
      else if (paramString.equals("hidden")) {
        i = 1;
      }
      if (i != 0)
      {
        if (i == 1) {
          setClipChildren(true);
        }
      }
      else {
        setClipChildren(false);
      }
    }
    invalidate();
  }
  
  public void updateDrawingOrder()
  {
    this.mDrawingOrderHelper.b();
    setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.a());
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.view.HippyViewGroup
 * JD-Core Version:    0.7.0.1
 */