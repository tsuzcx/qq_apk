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
  private static final String TAG = SPlayerSurfaceView.class.getSimpleName();
  private float mScale = 1.0F;
  private SurfaceHolder.Callback mSurfaceCallback = new SPlayerSurfaceView.1(this);
  private int mType = 0;
  private int mVideoHeight;
  private int mVideoWidth;
  private ISPlayerViewBase.viewCreateCallBack mViewCallBack;
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
    int i = getDefaultSize(this.mVideoWidth, paramInt1);
    int j = getDefaultSize(this.mVideoHeight, paramInt2);
    if ((this.mVideoWidth > 0) && (this.mVideoHeight > 0)) {}
    for (;;)
    {
      try
      {
        ((FrameLayout.LayoutParams)getLayoutParams()).topMargin = 0;
        ((FrameLayout.LayoutParams)getLayoutParams()).bottomMargin = 0;
        if (this.mType == 2)
        {
          if (this.mVideoWidth * j > this.mVideoHeight * i)
          {
            k = this.mVideoWidth * j / this.mVideoHeight;
            i = j;
            j = k;
            f = 1.0F;
            setMeasuredDimension((int)(j * this.mScale * f), (int)(f * (i * this.mScale)));
            return;
          }
          if (this.mVideoWidth * j >= this.mVideoHeight * i) {
            break label455;
          }
          k = this.mVideoHeight * i / this.mVideoWidth;
          j = i;
          f = 1.0F;
          i = k;
          continue;
        }
        if (this.mType == 1)
        {
          f = 1.0F;
          k = i;
          i = j;
          j = k;
          continue;
        }
        if (this.mType == 3)
        {
          if (this.mVideoWidth * j > this.mVideoHeight * i)
          {
            k = this.mVideoHeight * i / this.mVideoWidth;
            j = i;
            f = 1.0F;
            i = k;
            continue;
          }
          if (this.mVideoWidth * j >= this.mVideoHeight * i) {
            break label455;
          }
          k = this.mVideoWidth * j / this.mVideoHeight;
          f = j / (this.mVideoWidth / this.mVideoHeight * j);
          i = j;
          j = k;
          continue;
        }
        int m = this.mVideoWidth;
        k = m;
        if (this.radioWidth != 0)
        {
          k = m;
          if (this.radioHeight != 0) {
            k = this.mVideoWidth * this.radioWidth / this.radioHeight;
          }
        }
        if (k * j > this.mVideoHeight * i)
        {
          k = this.mVideoHeight * i / k;
          j = i;
          f = 1.0F;
          i = k;
          continue;
        }
        if (k * j >= this.mVideoHeight * i) {
          break label455;
        }
        k = k * j / this.mVideoHeight;
        i = j;
        j = k;
        f = 1.0F;
        continue;
        super.onMeasure(paramInt1, paramInt2);
      }
      catch (Exception localException)
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
      return;
      label455:
      float f = 1.0F;
      int k = i;
      i = j;
      j = k;
    }
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
  
  public void setVideoWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
  }
  
  public void setViewCallBack(ISPlayerViewBase.viewCreateCallBack paramviewCreateCallBack)
  {
    this.mViewCallBack = paramviewCreateCallBack;
  }
  
  public void setXYaxis(int paramInt)
  {
    this.mType = paramInt;
    this.mScale = 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.view.SPlayerSurfaceView
 * JD-Core Version:    0.7.0.1
 */