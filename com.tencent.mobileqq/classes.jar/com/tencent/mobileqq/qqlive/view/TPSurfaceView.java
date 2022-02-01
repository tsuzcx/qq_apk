package com.tencent.mobileqq.qqlive.view;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mobileqq.widget.QQUIDelegate;

public class TPSurfaceView
  extends SurfaceView
  implements ITPViewBase
{
  private ITPViewBase.ViewCreateCallBack a;
  private int b = 0;
  private int c;
  private int d;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private float h = 1.0F;
  private SurfaceHolder.Callback i = new TPSurfaceView.1(this);
  
  public TPSurfaceView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public TPSurfaceView(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext);
    if (paramBoolean1) {
      setZOrderOnTop(paramBoolean1);
    }
    if (paramBoolean2) {
      setZOrderMediaOverlay(paramBoolean2);
    }
    a();
  }
  
  private void a()
  {
    setScaleX(1.0001F);
    setScaleY(1.0001F);
    this.h = 1.0F;
    this.e = 0;
    setZOrderOnTop(true);
    setZOrderMediaOverlay(true);
    getHolder().addCallback(this.i);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int j = getDefaultSize(getWidth(), paramInt1);
    int k = getDefaultSize(getHeight(), paramInt2);
    paramInt1 = this.e;
    float f2 = 1.0F;
    int m;
    int n;
    float f1;
    if (paramInt1 == 2)
    {
      m = this.c;
      n = this.d;
      if (m * k > j * n)
      {
        paramInt2 = m * k / n;
        f1 = f2;
        paramInt1 = k;
      }
      else
      {
        f1 = f2;
        paramInt2 = j;
        paramInt1 = k;
        if (m * k < j * n)
        {
          paramInt1 = n * j / m;
          f1 = f2;
          paramInt2 = j;
        }
      }
    }
    else if (paramInt1 == 1)
    {
      f1 = f2;
      paramInt2 = j;
      paramInt1 = k;
    }
    else if (paramInt1 == 3)
    {
      m = this.c;
      n = this.d;
      if (m * k > j * n)
      {
        paramInt1 = n * j / m;
        f1 = f2;
        paramInt2 = j;
      }
      else
      {
        f1 = f2;
        paramInt2 = j;
        paramInt1 = k;
        if (m * k < j * n)
        {
          paramInt2 = k * m / n;
          f1 = k;
          f1 /= m / n * f1;
          paramInt1 = k;
        }
      }
    }
    else
    {
      paramInt2 = this.c;
      m = this.f;
      paramInt1 = paramInt2;
      if (m != 0)
      {
        n = this.g;
        paramInt1 = paramInt2;
        if (n != 0) {
          paramInt1 = (int)(paramInt2 * m / n);
        }
      }
      paramInt2 = paramInt1 * k;
      m = this.d;
      if (paramInt2 > j * m)
      {
        paramInt1 = m * j / paramInt1;
        paramInt2 = j;
      }
      else
      {
        if (paramInt2 < j * m) {
          paramInt2 /= m;
        } else {
          paramInt2 = j;
        }
        paramInt1 = k;
      }
      m = this.b;
      if (m != 90)
      {
        f1 = f2;
        if (m != 270) {}
      }
      else
      {
        f1 = f2;
        if (paramInt1 > 0)
        {
          f1 = f2;
          if (paramInt2 > 0)
          {
            if (j / paramInt1 < k / paramInt2)
            {
              f1 = j;
              f2 = paramInt1;
            }
            else
            {
              f1 = k;
              f2 = paramInt2;
            }
            f1 /= f2;
          }
        }
      }
    }
    j = paramInt1;
    if ((getContext() instanceof Activity))
    {
      j = paramInt1;
      if (QQUIDelegate.a((Activity)getContext())) {
        j = paramInt1 - QQUIDelegate.b(getContext());
      }
    }
    f2 = paramInt2;
    float f3 = this.h;
    setMeasuredDimension((int)(f2 * f3 * f1), (int)(j * f3 * f1));
  }
  
  public boolean a(int paramInt)
  {
    setRotation(paramInt);
    this.b = paramInt;
    return true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.c > 0) && (this.d > 0))
    {
      a(paramInt1, paramInt2);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setOpaqueInfo(boolean paramBoolean) {}
  
  public void setRadio(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
  }
  
  public void setScaleParam(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      this.e = 0;
      this.h = paramFloat;
    }
  }
  
  public void setVideoWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public void setViewCallBack(ITPViewBase.ViewCreateCallBack paramViewCreateCallBack)
  {
    this.a = paramViewCreateCallBack;
  }
  
  public void setXYAxis(int paramInt)
  {
    this.e = paramInt;
    this.h = 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.view.TPSurfaceView
 * JD-Core Version:    0.7.0.1
 */