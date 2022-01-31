package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.Animation;
import java.nio.FloatBuffer;

public class GLProgressBar
  extends GlView
{
  private GLImageView mBackgroundView;
  private GLProgressBar.ProgressBarListener mListener;
  private int mMaxProgress = 1;
  private long mProgress = 0L;
  private boolean mProgressChanged = false;
  private GLImage mProgressImage = new GLImage();
  private float mProgressMaxSize;
  private String mResProgressPath = "";
  private boolean mSizeChanged = false;
  private int mStretchLeft;
  private int mStretchRight;
  private float xLeftCoordinate;
  private float xRightCoordinate;
  
  public GLProgressBar(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
    initView(8);
    this.mBackgroundView = new GLImageView(paramGLViewContext, paramString);
    resetFlagValue();
  }
  
  private float computeProgressDistance(float paramFloat1, float paramFloat2)
  {
    this.mProgressMaxSize = (this.context.getViewPort().width() - this.mClipRegion.left * 2.0F);
    return (this.mProgressMaxSize - paramFloat1 - paramFloat2) * (float)this.mProgress / this.mMaxProgress;
  }
  
  private void computeVertexTextureCoordinate()
  {
    float f = this.mSizeRegion.width();
    this.xLeftCoordinate = (this.mStretchLeft / f);
    this.xRightCoordinate = (this.mStretchRight / f);
  }
  
  private boolean layoutHasChange()
  {
    return (this.mSizeChanged) || (this.mProgressChanged) || (this.mBackgroundView.updateParam());
  }
  
  private void reconstructProgressRegionByBackGround()
  {
    float f1 = this.mSizeRegion.left;
    float f2 = this.mBackgroundView.mSizeRegion.left;
    float f3 = this.mSizeRegion.top;
    float f4 = this.mBackgroundView.mSizeRegion.top;
    Object localObject = this.mBackgroundView.getCurrentDrawRegionSize();
    this.mClipRegion.left = (f1 - f2 + ((RectF)localObject).left);
    this.mClipRegion.top = (f3 - f4 + ((RectF)localObject).top);
    this.mClipRegion.right = (this.mClipRegion.left + this.mSizeRegion.width());
    this.mClipRegion.bottom = (this.mClipRegion.top + this.mSizeRegion.height());
    localObject = this.mBackgroundView.mColor;
    this.mColor.setValue(((Color4f)localObject).getRed(), ((Color4f)localObject).getGreen(), ((Color4f)localObject).getBlue(), ((Color4f)localObject).getAlpha());
  }
  
  private void resetFlagValue()
  {
    this.mSizeChanged = false;
    this.mProgressChanged = false;
  }
  
  public void clearAnimation()
  {
    this.mBackgroundView.clearAnimation();
  }
  
  public void clearStatus()
  {
    super.clearStatus();
    this.mProgress = 0L;
    this.mBackgroundView.clearStatus();
  }
  
  public void draw()
  {
    if (this.mVisible)
    {
      this.mBackgroundView.draw();
      if (this.mProgress > 0L) {
        drawInternal();
      }
    }
  }
  
  public Animation getAnimation()
  {
    return this.mBackgroundView.getAnimation();
  }
  
  public RectF getBackgroundRegion()
  {
    return this.mBackgroundView.mSizeRegion;
  }
  
  public RectF getCurrentDrawRegionSize()
  {
    return this.mBackgroundView.getCurrentDrawRegionSize();
  }
  
  public GLImage getProgressImage()
  {
    return this.mProgressImage;
  }
  
  public RectF gettBackgroundClipRegion()
  {
    return this.mBackgroundView.mClipRegion;
  }
  
  public void release()
  {
    clearStatus();
    super.release();
    this.mProgressImage.release();
    this.mResProgressPath = "";
    this.mBackgroundView.release();
  }
  
  public void setBackgroundClipRegion(RectF paramRectF)
  {
    this.mBackgroundView.setImageClipDrawRegion(paramRectF);
  }
  
  public void setBackgroundImageBitmap(Bitmap paramBitmap)
  {
    this.mBackgroundView.setImageBitmap(paramBitmap);
  }
  
  public void setBackgroundImageRes(String paramString)
  {
    this.mBackgroundView.setImageRes(paramString);
  }
  
  public void setBackgroundRegion(RectF paramRectF)
  {
    this.mBackgroundView.setImageRegion(paramRectF);
  }
  
  public void setMaxProgress(int paramInt)
  {
    this.mMaxProgress = paramInt;
  }
  
  public void setProgress(long paramLong)
  {
    if (this.mProgress < this.mMaxProgress)
    {
      this.mProgress = paramLong;
      if (this.mProgress > this.mMaxProgress) {
        this.mProgress = this.mMaxProgress;
      }
      this.mProgressChanged = true;
    }
    while ((this.mProgress < this.mMaxProgress) || (this.mListener == null)) {
      return;
    }
    this.mListener.progressMax();
  }
  
  public void setProgressBarListener(GLProgressBar.ProgressBarListener paramProgressBarListener)
  {
    this.mListener = paramProgressBarListener;
  }
  
  public void setProgressImageBitmap(Bitmap paramBitmap)
  {
    this.mProgressImage.loadTextureSync(paramBitmap);
  }
  
  public void setProgressImageRes(String paramString)
  {
    if (!this.mResProgressPath.equals(paramString))
    {
      this.mProgressImage.loadTextureSync(paramString);
      this.mResProgressPath = paramString;
    }
  }
  
  public void setProgressRegion(RectF paramRectF)
  {
    if (!this.mSizeRegion.equals(paramRectF))
    {
      this.mSizeRegion.set(paramRectF);
      mapSizeRegion();
      this.mClipRegion.set(paramRectF);
      mapClipRegion();
      this.mSizeChanged = true;
    }
  }
  
  public void setProgressStretchRelativeRegion(int paramInt1, int paramInt2)
  {
    if (this.mSizeChanged)
    {
      this.mStretchLeft = ((int)(paramInt1 * this.context.getViewPortRatio()));
      this.mStretchRight = ((int)(paramInt2 * this.context.getViewPortRatio()));
      computeVertexTextureCoordinate();
      return;
    }
    throw new RuntimeException("Must called after setProgressRegion");
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    this.mVisible = paramBoolean;
    this.mBackgroundView.setVisibility(this.mVisible);
  }
  
  public void startAnimation(Animation paramAnimation)
  {
    this.mBackgroundView.startAnimation(paramAnimation);
  }
  
  protected void transferVertexData()
  {
    this.mCurrentTexture = this.mProgressImage.getTexture();
    surfaceCoordinateMapToViewPortSize();
    this.context.getViewPort();
    reconstructProgressRegionByBackGround();
    float f1 = this.mClipRegion.width() - this.mStretchRight;
    float f2 = computeProgressDistance(this.mStretchLeft, f1);
    this.mVertexPointCache[0].set(this.mClipRegion.left, this.mClipRegion.top);
    this.mVertexPointCache[1].set(this.mClipRegion.left, this.mClipRegion.bottom);
    this.mVertexPointCache[2].set(this.mClipRegion.left + this.mStretchLeft, this.mClipRegion.top);
    this.mVertexPointCache[3].set(this.mClipRegion.left + this.mStretchLeft, this.mClipRegion.bottom);
    f2 += this.mClipRegion.left + this.mStretchLeft;
    this.mVertexPointCache[4].set(f2, this.mClipRegion.top);
    this.mVertexPointCache[5].set(f2, this.mClipRegion.bottom);
    this.mVertexPointCache[6].set(f2 + f1, this.mClipRegion.top);
    this.mVertexPointCache[7].set(f1 + f2, this.mClipRegion.bottom);
    this.mVertexBuffer.position(0);
    setVertexCoordinateData(this.mZOrderValue);
    this.mVertexBuffer.put(0.0F);
    this.mVertexBuffer.put(0.0F);
    this.mVertexBuffer.put(0.0F);
    this.mVertexBuffer.put(1.0F);
    this.mVertexBuffer.put(this.xLeftCoordinate);
    this.mVertexBuffer.put(0.0F);
    this.mVertexBuffer.put(this.xLeftCoordinate);
    this.mVertexBuffer.put(1.0F);
    this.mVertexBuffer.put(this.xRightCoordinate);
    this.mVertexBuffer.put(0.0F);
    this.mVertexBuffer.put(this.xRightCoordinate);
    this.mVertexBuffer.put(1.0F);
    this.mVertexBuffer.put(1.0F);
    this.mVertexBuffer.put(0.0F);
    this.mVertexBuffer.put(1.0F);
    this.mVertexBuffer.put(1.0F);
    setColorAttributeValue();
    this.mVertexBuffer.position(0);
    this.mVertexNum = 8;
    this.mDrawMode = 0;
  }
  
  public boolean updateParam()
  {
    boolean bool2 = super.updateParam();
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = layoutHasChange();
      resetFlagValue();
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLProgressBar
 * JD-Core Version:    0.7.0.1
 */