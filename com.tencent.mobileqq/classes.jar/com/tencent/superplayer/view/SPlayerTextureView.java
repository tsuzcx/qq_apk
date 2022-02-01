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
  private static final String TAG = "SPlayerTextureView";
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
    if ((this.mVideoWidth > 0) && (this.mVideoHeight > 0))
    {
      int i = getDefaultSize(getWidth(), paramInt1);
      int j = getDefaultSize(getHeight(), paramInt2);
      float f2 = 1.0F;
      ((FrameLayout.LayoutParams)getLayoutParams()).topMargin = 0;
      ((FrameLayout.LayoutParams)getLayoutParams()).bottomMargin = 0;
      paramInt1 = this.mType;
      int k;
      int m;
      float f1;
      if (paramInt1 == 2)
      {
        k = this.mVideoWidth;
        m = this.mVideoHeight;
        if (k * j > i * m)
        {
          paramInt1 = k * j / m;
          f1 = f2;
          paramInt2 = j;
        }
        else
        {
          f1 = f2;
          paramInt1 = i;
          paramInt2 = j;
          if (k * j < i * m)
          {
            paramInt2 = m * i / k;
            f1 = f2;
            paramInt1 = i;
          }
        }
      }
      else if (paramInt1 == 1)
      {
        f1 = f2;
        paramInt1 = i;
        paramInt2 = j;
      }
      else if (paramInt1 == 3)
      {
        k = this.mVideoWidth;
        m = this.mVideoHeight;
        if (k * j > i * m)
        {
          paramInt2 = m * i / k;
          f1 = f2;
          paramInt1 = i;
        }
        else
        {
          f1 = f2;
          paramInt1 = i;
          paramInt2 = j;
          if (k * j < i * m)
          {
            paramInt1 = j * k / m;
            f1 = j;
            f1 /= k / m * f1;
            paramInt2 = j;
          }
        }
      }
      else
      {
        paramInt2 = this.mVideoWidth;
        k = this.radioWidth;
        paramInt1 = paramInt2;
        if (k != 0)
        {
          m = this.radioHeigth;
          paramInt1 = paramInt2;
          if (m != 0) {
            paramInt1 = (int)(paramInt2 * k / m);
          }
        }
        paramInt2 = paramInt1 * j;
        k = this.mVideoHeight;
        if (paramInt2 > i * k)
        {
          paramInt1 = k * i / paramInt1;
          paramInt2 = i;
        }
        else
        {
          if (paramInt2 < i * k) {
            paramInt2 /= k;
          } else {
            paramInt2 = i;
          }
          paramInt1 = j;
        }
        k = this.mDegree;
        if (k != 90)
        {
          f1 = f2;
          if (k != 270) {}
        }
        else
        {
          f1 = f2;
          if (paramInt1 > 0)
          {
            f1 = f2;
            if (paramInt2 > 0)
            {
              if (i / paramInt1 < j / paramInt2)
              {
                f1 = i;
                f2 = paramInt1;
              }
              else
              {
                f1 = j;
                f2 = paramInt2;
              }
              f1 /= f2;
            }
          }
        }
        i = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = i;
      }
      f2 = paramInt1;
      float f3 = this.mScale;
      setMeasuredDimension((int)(f2 * f3 * f1), (int)(paramInt2 * f3 * f1));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString);
    this.mTag = localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.view.SPlayerTextureView
 * JD-Core Version:    0.7.0.1
 */