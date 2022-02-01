package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.widget.Gallery;

public class ReadInJoyGallery
  extends Gallery
{
  public static final String a;
  protected ReadInJoyGallery.OnDoubleTapListener b;
  ViewConfiguration c = ViewConfiguration.get(getContext());
  float d;
  float e;
  int f;
  boolean g = false;
  boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private int k = 1;
  private boolean l = false;
  private ReadInJoyGallery.OnScrollChangeListener m;
  private boolean n;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.atlas.");
    localStringBuilder.append(ReadInJoyGallery.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public ReadInJoyGallery(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ReadInJoyGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ReadInJoyGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  protected void a()
  {
    setMaxScale(2.147484E+009F);
    this.f = (ViewConfiguration.get(getContext()).getScaledTouchSlop() / 3);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = paramMotionEvent.getAction();
    if (i2 != 0)
    {
      if (i2 != 1)
      {
        int i1 = 2;
        if (i2 == 2)
        {
          if (this.g)
          {
            if (this.h)
            {
              super.dispatchTouchEvent(paramMotionEvent);
              return true;
            }
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          float f1 = paramMotionEvent.getX() - this.d;
          float f2 = paramMotionEvent.getY() - this.e;
          if ((Math.abs(f1) <= this.f) && (Math.abs(f2) <= this.f)) {
            return true;
          }
          this.g = true;
          if (Math.abs(f1) > Math.abs(f2))
          {
            this.h = true;
            this.j = true;
            if (f1 < 0.0F) {
              i1 = 1;
            }
            this.k = i1;
            super.dispatchTouchEvent(paramMotionEvent);
            return true;
          }
          if (this.mIsScaling)
          {
            this.h = true;
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          this.h = false;
          return super.dispatchTouchEvent(paramMotionEvent);
        }
      }
    }
    else
    {
      this.g = false;
      this.d = paramMotionEvent.getX();
      this.e = paramMotionEvent.getY();
      this.j = false;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void forceLayout()
  {
    super.forceLayout();
  }
  
  public boolean isNeedSetLongPicAction()
  {
    return true;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    ReadInJoyGallery.OnDoubleTapListener localOnDoubleTapListener = this.b;
    if (localOnDoubleTapListener != null) {
      localOnDoubleTapListener.a();
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.n)
    {
      if (paramMotionEvent.getPointerCount() >= 2) {
        return false;
      }
      int i1 = paramMotionEvent.getAction();
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2) {
            return super.onInterceptTouchEvent(paramMotionEvent);
          }
          if (this.g)
          {
            if (this.n)
            {
              if ((this.j) && (this.k == 2)) {
                return super.onInterceptTouchEvent(paramMotionEvent);
              }
              return false;
            }
            return super.onInterceptTouchEvent(paramMotionEvent);
          }
          return false;
        }
        if (this.g)
        {
          if (this.j) {
            return super.onInterceptTouchEvent(paramMotionEvent);
          }
          onTouchEvent(paramMotionEvent);
          return false;
        }
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        paramMotionEvent.setAction(3);
        onTouchEvent(paramMotionEvent);
        return false;
      }
      onTouchEvent(paramMotionEvent);
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void requestLayout()
  {
    super.requestLayout();
  }
  
  public void setIsListPage(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void setOnDoubleTapListener(ReadInJoyGallery.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.b = paramOnDoubleTapListener;
  }
  
  public void setOnScrollChangeListener(ReadInJoyGallery.OnScrollChangeListener paramOnScrollChangeListener)
  {
    this.m = paramOnScrollChangeListener;
  }
  
  protected void trackMotionScroll(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super.trackMotionScroll(paramInt1, paramInt2, paramBoolean);
    ReadInJoyGallery.OnScrollChangeListener localOnScrollChangeListener = this.m;
    if (localOnScrollChangeListener != null) {
      localOnScrollChangeListener.a(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyGallery
 * JD-Core Version:    0.7.0.1
 */