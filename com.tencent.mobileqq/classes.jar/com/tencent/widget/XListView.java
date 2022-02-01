package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.qqui.R.styleable;

public class XListView
  extends ListView
{
  public static final int MODE_ALL = 1;
  public static final int MODE_BOTTOM = 5;
  public static final int MODE_LEFT = 2;
  public static final int MODE_NONE = 0;
  public static final int MODE_RIGHT = 4;
  public static final int MODE_TOP = 3;
  public static final int WINDOW_ORIENTATION_LANDSCAPE = 1;
  public static final int WINDOW_ORIENTATION_POERRAIT = 2;
  private XListView.DrawFinishedListener mDrawFinishedListener;
  private XListView.MotionEventInterceptor mInterceptor;
  private int mLastRadius;
  private int mLastRoundMode;
  private int mMaxHeight = -1;
  private OnSizeChangeListener mOnSizeChangeListener;
  private int mOrientation = 0;
  private int mRadius;
  private int mRoundMode = 0;
  private Path mRoundPath;
  private boolean wrapByScroll = false;
  
  public XListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public XListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public XListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mOverscrollDistance = 2147483647;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.fR);
    setMaxHeight(localTypedArray.getDimensionPixelSize(R.styleable.fS, -1));
    localTypedArray.recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.fs);
    boolean bool = paramContext.getBoolean(R.styleable.ft, false);
    paramContext.recycle();
    setEdgeEffectEnabled(bool);
    this.mRoundPath = new Path();
    this.mRoundPath.setFillType(Path.FillType.EVEN_ODD);
  }
  
  private void checkPathChanged()
  {
    if ((this.mLastRadius == this.mRadius) && (this.mLastRoundMode == this.mRoundMode)) {
      return;
    }
    int i = getWidth();
    int j = getHeight();
    this.mLastRadius = this.mRadius;
    this.mRoundPath.reset();
    int k = this.mRoundMode;
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4)
          {
            if (k != 5) {
              return;
            }
            localPath = this.mRoundPath;
            localRectF = new RectF(0.0F, 0.0F, i, j);
            i = this.mRadius;
            f1 = i;
            f2 = i;
            f3 = i;
            f4 = i;
            localDirection = Path.Direction.CW;
            localPath.addRoundRect(localRectF, new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f2, f3, f4 }, localDirection);
            return;
          }
          localPath = this.mRoundPath;
          localRectF = new RectF(0.0F, 0.0F, i, j);
          i = this.mRadius;
          f1 = i;
          f2 = i;
          f3 = i;
          f4 = i;
          localDirection = Path.Direction.CW;
          localPath.addRoundRect(localRectF, new float[] { 0.0F, 0.0F, f1, f2, f3, f4, 0.0F, 0.0F }, localDirection);
          return;
        }
        localPath = this.mRoundPath;
        localRectF = new RectF(0.0F, 0.0F, i, j);
        i = this.mRadius;
        f1 = i;
        f2 = i;
        f3 = i;
        f4 = i;
        localDirection = Path.Direction.CW;
        localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, 0.0F, 0.0F, 0.0F, 0.0F }, localDirection);
        return;
      }
      localPath = this.mRoundPath;
      localRectF = new RectF(0.0F, 0.0F, i, j);
      i = this.mRadius;
      float f1 = i;
      float f2 = i;
      float f3 = i;
      float f4 = i;
      Path.Direction localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { f1, f2, 0.0F, 0.0F, 0.0F, 0.0F, f3, f4 }, localDirection);
      return;
    }
    Path localPath = this.mRoundPath;
    RectF localRectF = new RectF(0.0F, 0.0F, i, j);
    i = this.mRadius;
    localPath.addRoundRect(localRectF, i, i, Path.Direction.CW);
  }
  
  private int getWindowOrientation()
  {
    if (getContext().getResources().getDisplayMetrics().widthPixels > getContext().getResources().getDisplayMetrics().heightPixels) {
      return 1;
    }
    return 2;
  }
  
  private void notifySizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    OnSizeChangeListener localOnSizeChangeListener = this.mOnSizeChangeListener;
    if (localOnSizeChangeListener != null) {
      localOnSizeChangeListener.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    paramCanvas = this.mDrawFinishedListener;
    if (paramCanvas != null) {
      paramCanvas.drawFinished();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mInterceptor != null)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (localMotionEvent != null)
      {
        bool1 = this.mInterceptor.intercept(this, localMotionEvent);
        localMotionEvent.recycle();
        break label41;
      }
    }
    boolean bool1 = false;
    label41:
    boolean bool4 = true;
    boolean bool3 = bool4;
    if (!bool1) {}
    try
    {
      bool2 = super.dispatchTouchEvent(paramMotionEvent);
    }
    catch (RuntimeException paramMotionEvent)
    {
      boolean bool2;
      label61:
      break label61;
    }
    bool2 = false;
    bool3 = bool4;
    if (!bool1)
    {
      if (bool2) {
        return true;
      }
      bool3 = false;
    }
    return bool3;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mRoundMode != 0)
    {
      int i = paramCanvas.save();
      checkPathChanged();
      paramCanvas.clipPath(this.mRoundPath);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i;
    if (this.mMaxHeight > 0)
    {
      int j = View.MeasureSpec.getMode(paramInt2);
      int k = View.MeasureSpec.getSize(paramInt2);
      int m = this.mMaxHeight;
      i = paramInt2;
      if (k > m)
      {
        i = paramInt2;
        if (j != 0) {
          i = View.MeasureSpec.makeMeasureSpec(m, j);
        }
      }
    }
    else
    {
      i = paramInt2;
      if (this.wrapByScroll) {
        i = View.MeasureSpec.makeMeasureSpec(536870911, -2147483648);
      }
    }
    super.onMeasure(paramInt1, i);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    int i = getWindowOrientation();
    boolean bool;
    if (this.mOrientation != i) {
      bool = true;
    } else {
      bool = false;
    }
    notifySizeChanged(paramInt1, paramInt2, paramInt3, paramInt4, bool, i);
    this.mOrientation = i;
  }
  
  public void setCornerRadiusAndMode(int paramInt1, int paramInt2)
  {
    this.mRadius = paramInt1;
    this.mRoundMode = paramInt2;
  }
  
  public void setDrawFinishedListener(XListView.DrawFinishedListener paramDrawFinishedListener)
  {
    this.mDrawFinishedListener = paramDrawFinishedListener;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.mMaxHeight = paramInt;
    if (this.mMaxHeight < getMeasuredHeight()) {
      requestLayout();
    }
  }
  
  public void setMotionEventInterceptor(XListView.MotionEventInterceptor paramMotionEventInterceptor)
  {
    this.mInterceptor = paramMotionEventInterceptor;
  }
  
  public void setOnSizeChangeListener(OnSizeChangeListener paramOnSizeChangeListener)
  {
    this.mOnSizeChangeListener = paramOnSizeChangeListener;
  }
  
  public void setOverScrollDistance(int paramInt)
  {
    this.mOverscrollDistance = paramInt;
  }
  
  public void setWrapByScroll(boolean paramBoolean)
  {
    this.wrapByScroll = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.XListView
 * JD-Core Version:    0.7.0.1
 */