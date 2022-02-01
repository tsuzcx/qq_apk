package com.tencent.mobileqq.qqlive.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;

public class TPTextureView
  extends TextureView
  implements ITPViewBase
{
  private ITPViewBase.ViewCreateCallBack a;
  private int b = 0;
  private int c;
  private int d;
  private int e = 0;
  private float f = 1.0F;
  private int g = 0;
  private int h = 0;
  private TextureView.SurfaceTextureListener i = new TPTextureView.1(this);
  
  public TPTextureView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public TPTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public TPTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setScaleX(1.0001F);
    setScaleY(1.0001F);
    setSurfaceTextureListener(this.i);
  }
  
  public boolean a(int paramInt)
  {
    setRotation(paramInt);
    this.b = paramInt;
    return true;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Log.i("TPPlayer[TPTextureView]", "onAttachedToWindow");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Log.i("TPPlayer[TPTextureView]", "onDetachedFromWindow");
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMeasure widthMeasureSpec: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" heightMeasureSpec:");
    localStringBuilder.append(paramInt2);
    Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMeasure videoWidth: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" videoHeight:");
    localStringBuilder.append(this.d);
    Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMeasure type: ");
    localStringBuilder.append(this.e);
    Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
    if ((this.c > 0) && (this.d > 0))
    {
      int j = getDefaultSize(getWidth(), paramInt1);
      int k = getDefaultSize(getHeight(), paramInt2);
      float f2 = 1.0F;
      paramInt1 = this.e;
      int m;
      int n;
      float f1;
      if (paramInt1 == 2)
      {
        m = this.c;
        n = this.d;
        if (m * k > j * n)
        {
          paramInt1 = m * k / n;
          f1 = f2;
          paramInt2 = k;
        }
        else
        {
          f1 = f2;
          paramInt1 = j;
          paramInt2 = k;
          if (m * k < j * n)
          {
            paramInt2 = n * j / m;
            f1 = f2;
            paramInt1 = j;
          }
        }
      }
      else if (paramInt1 == 1)
      {
        f1 = f2;
        paramInt1 = j;
        paramInt2 = k;
      }
      else if (paramInt1 == 3)
      {
        m = this.c;
        n = this.d;
        if (m * k > j * n)
        {
          paramInt2 = n * j / m;
          f1 = f2;
          paramInt1 = j;
        }
        else
        {
          f1 = f2;
          paramInt1 = j;
          paramInt2 = k;
          if (m * k < j * n)
          {
            paramInt1 = k * m / n;
            f1 = k;
            f1 /= m / n * f1;
            paramInt2 = k;
          }
        }
      }
      else
      {
        paramInt2 = this.c;
        m = this.g;
        paramInt1 = paramInt2;
        if (m != 0)
        {
          n = this.h;
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
        j = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = j;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMeasure radioWidth:");
      localStringBuilder.append(this.g);
      localStringBuilder.append(" radioHeight:");
      localStringBuilder.append(this.h);
      Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMeasure degree:");
      localStringBuilder.append(this.b);
      Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMeasure vScale:");
      localStringBuilder.append(f1);
      Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMeasure setMeasuredDimension: ");
      f2 = paramInt1;
      localStringBuilder.append((int)(this.f * f2 * f1));
      localStringBuilder.append("  ");
      float f3 = paramInt2;
      localStringBuilder.append((int)(this.f * f3 * f1));
      Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
      float f4 = this.f;
      setMeasuredDimension((int)(f2 * f4 * f1), (int)(f3 * f4 * f1));
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMeasure setMeasuredDimension: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("  ");
    localStringBuilder.append(paramInt2);
    Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setOpaqueInfo(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setOpaque(true);
      setAlpha(1.0F);
      return;
    }
    setOpaque(false);
    setAlpha(0.0F);
  }
  
  public void setRadio(int paramInt1, int paramInt2)
  {
    this.h = paramInt2;
    this.g = paramInt1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRadio num: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("  den: ");
    localStringBuilder.append(paramInt2);
    Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
  }
  
  public void setScaleParam(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      this.e = 0;
      this.f = paramFloat;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setScaleParam scale: ");
    localStringBuilder.append(paramFloat);
    Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
  }
  
  public void setVideoWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVideoWidthAndHeight width: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("  height: ");
    localStringBuilder.append(paramInt2);
    Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
  }
  
  public void setViewCallBack(ITPViewBase.ViewCreateCallBack paramViewCreateCallBack)
  {
    this.a = paramViewCreateCallBack;
  }
  
  public void setXYAxis(int paramInt)
  {
    this.e = paramInt;
    this.f = 1.0F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setXYAxis mXYAxis: ");
    localStringBuilder.append(paramInt);
    Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.view.TPTextureView
 * JD-Core Version:    0.7.0.1
 */