package com.tencent.superplayer.view;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.FrameLayout.LayoutParams;

public class SPlayerSurfaceView
  extends SurfaceView
  implements ISPlayerViewBase
{
  private static final String TAG = "SPlayerSurfaceView";
  private float mScale = 1.0F;
  private SurfaceHolder.Callback mSurfaceCallback = new SPlayerSurfaceView.1(this);
  private int mType = 0;
  private int mVideoHeight;
  private int mVideoWidth;
  private ISPlayerViewBase.ViewCreateCallBack mViewCallBack;
  private int radioHeight = 0;
  private int radioWidth = 0;
  
  public SPlayerSurfaceView(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  private void initView()
  {
    this.mScale = 1.0F;
    this.mType = 0;
    getHolder().setFormat(-2);
    getHolder().addCallback(this.mSurfaceCallback);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = getDefaultSize(this.mVideoWidth, paramInt1);
    int m = getDefaultSize(this.mVideoHeight, paramInt2);
    if ((this.mVideoWidth > 0) && (this.mVideoHeight > 0)) {}
    try
    {
      ((FrameLayout.LayoutParams)getLayoutParams()).topMargin = 0;
      ((FrameLayout.LayoutParams)getLayoutParams()).bottomMargin = 0;
      int i = this.mType;
      float f2 = 1.0F;
      int j;
      float f1;
      if (i == 2)
      {
        if (this.mVideoWidth * m > this.mVideoHeight * k)
        {
          i = this.mVideoWidth * m / this.mVideoHeight;
          j = m;
          f1 = f2;
        }
        else
        {
          i = k;
          j = m;
          f1 = f2;
          if (this.mVideoWidth * m < this.mVideoHeight * k)
          {
            j = this.mVideoHeight * k / this.mVideoWidth;
            i = k;
            f1 = f2;
          }
        }
      }
      else if (this.mType == 1)
      {
        i = k;
        j = m;
        f1 = f2;
      }
      else if (this.mType == 3)
      {
        if (this.mVideoWidth * m > this.mVideoHeight * k)
        {
          j = this.mVideoHeight * k / this.mVideoWidth;
          i = k;
          f1 = f2;
        }
        else
        {
          i = k;
          j = m;
          f1 = f2;
          if (this.mVideoWidth * m < this.mVideoHeight * k)
          {
            i = this.mVideoWidth * m / this.mVideoHeight;
            f1 = m;
            f1 /= this.mVideoWidth / this.mVideoHeight * f1;
            j = m;
          }
        }
      }
      else
      {
        j = this.mVideoWidth;
        i = j;
        if (this.radioWidth != 0)
        {
          i = j;
          if (this.radioHeight != 0) {
            i = this.mVideoWidth * this.radioWidth / this.radioHeight;
          }
        }
        int n = i * m;
        if (n > this.mVideoHeight * k)
        {
          j = this.mVideoHeight * k / i;
          i = k;
          f1 = f2;
        }
        else
        {
          i = k;
          j = m;
          f1 = f2;
          if (n < this.mVideoHeight * k)
          {
            i = n / this.mVideoHeight;
            f1 = f2;
            j = m;
          }
        }
      }
      setMeasuredDimension((int)(i * this.mScale * f1), (int)(j * this.mScale * f1));
      return;
    }
    catch (Exception localException)
    {
      label455:
      break label455;
    }
    super.onMeasure(paramInt1, paramInt2);
    return;
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean setDegree(int paramInt)
  {
    return false;
  }
  
  public void setScaleParam(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      this.mType = 0;
      this.mScale = paramFloat;
    }
  }
  
  public void setVideoViewTagId(String paramString) {}
  
  public void setVideoWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
  }
  
  public void setViewCallBack(ISPlayerViewBase.ViewCreateCallBack paramViewCreateCallBack)
  {
    this.mViewCallBack = paramViewCreateCallBack;
  }
  
  public void setXYaxis(int paramInt)
  {
    this.mType = paramInt;
    this.mScale = 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.view.SPlayerSurfaceView
 * JD-Core Version:    0.7.0.1
 */