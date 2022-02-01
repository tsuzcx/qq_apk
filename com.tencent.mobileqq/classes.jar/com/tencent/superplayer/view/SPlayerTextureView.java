package com.tencent.superplayer.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.tmediacodec.hook.THookTextureView;

public class SPlayerTextureView
  extends THookTextureView
  implements ISPlayerViewBase
{
  private static final String TAG = SPlayerTextureView.class.getSimpleName();
  private int mDegree = 0;
  private float mScale = 1.0F;
  private String mTag;
  private TextureView.SurfaceTextureListener mTextureListener = new SPlayerTextureView.1(this);
  private int mType = 0;
  private int mVideoHeight;
  private int mVideoWidth;
  private ISPlayerViewBase.ViewCreateCallBack mViewCallBack;
  private int radioHeigth = 0;
  private int radioWidth = 0;
  
  public SPlayerTextureView(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public SPlayerTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public SPlayerTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void initView()
  {
    setScaleX(1.0001F);
    setScaleY(1.0001F);
    setSurfaceTextureListener(this.mTextureListener);
    this.mTag = TAG;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    float f;
    if ((this.mVideoWidth > 0) && (this.mVideoHeight > 0))
    {
      i = getDefaultSize(getWidth(), paramInt1);
      j = getDefaultSize(getHeight(), paramInt2);
      ((FrameLayout.LayoutParams)getLayoutParams()).topMargin = 0;
      ((FrameLayout.LayoutParams)getLayoutParams()).bottomMargin = 0;
      if (this.mType == 2) {
        if (this.mVideoWidth * j > this.mVideoHeight * i)
        {
          paramInt2 = this.mVideoWidth * j / this.mVideoHeight;
          f = 1.0F;
          paramInt1 = j;
        }
      }
    }
    for (;;)
    {
      setMeasuredDimension((int)(paramInt2 * this.mScale * f), (int)(f * (paramInt1 * this.mScale)));
      return;
      if (this.mVideoWidth * j < this.mVideoHeight * i)
      {
        paramInt1 = this.mVideoHeight * i / this.mVideoWidth;
        f = 1.0F;
        paramInt2 = i;
        continue;
        if (this.mType == 1)
        {
          f = 1.0F;
          paramInt1 = j;
          paramInt2 = i;
          continue;
        }
        if (this.mType == 3)
        {
          if (this.mVideoWidth * j > this.mVideoHeight * i)
          {
            paramInt1 = this.mVideoHeight * i / this.mVideoWidth;
            f = 1.0F;
            paramInt2 = i;
            continue;
          }
          if (this.mVideoWidth * j < this.mVideoHeight * i)
          {
            paramInt2 = this.mVideoWidth * j / this.mVideoHeight;
            f = j / (this.mVideoWidth / this.mVideoHeight * j);
            paramInt1 = j;
          }
        }
        else
        {
          paramInt2 = this.mVideoWidth;
          paramInt1 = paramInt2;
          if (this.radioWidth != 0)
          {
            paramInt1 = paramInt2;
            if (this.radioHeigth != 0) {
              paramInt1 = (int)(this.mVideoWidth * this.radioWidth / this.radioHeigth);
            }
          }
          if (paramInt1 * j > this.mVideoHeight * i)
          {
            paramInt1 = this.mVideoHeight * i / paramInt1;
            paramInt2 = i;
          }
          for (;;)
          {
            if (((this.mDegree == 90) || (this.mDegree == 270)) && (paramInt1 > 0) && (paramInt2 > 0))
            {
              if (i / paramInt1 < j / paramInt2)
              {
                f = i / paramInt1;
                break;
                if (paramInt1 * j >= this.mVideoHeight * i) {
                  break label452;
                }
                paramInt2 = paramInt1 * j / this.mVideoHeight;
                paramInt1 = j;
                continue;
              }
              f = j / paramInt2;
              break;
              super.onMeasure(paramInt1, paramInt2);
              return;
            }
            f = 1.0F;
            break;
            label452:
            paramInt1 = j;
            paramInt2 = i;
          }
        }
      }
      f = 1.0F;
      paramInt1 = j;
      paramInt2 = i;
    }
  }
  
  public boolean setDegree(int paramInt)
  {
    setRotation(paramInt);
    this.mDegree = paramInt;
    return true;
  }
  
  public void setScaleParam(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      this.mType = 0;
      this.mScale = paramFloat;
    }
  }
  
  public void setVideoViewTagId(String paramString)
  {
    this.mTag = (TAG + "-" + paramString);
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.view.SPlayerTextureView
 * JD-Core Version:    0.7.0.1
 */