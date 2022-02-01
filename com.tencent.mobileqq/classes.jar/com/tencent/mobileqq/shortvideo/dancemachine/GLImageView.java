package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Bitmap;
import android.graphics.RectF;

public class GLImageView
  extends GlView
{
  protected GLImage mBackGround = new GLImage();
  private String mResPath = "";
  private boolean mSizeChanged = false;
  
  public GLImageView(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
    initView(4);
  }
  
  public void clearStatus()
  {
    super.clearStatus();
  }
  
  public GLImage getCurrentBackGround()
  {
    return this.mBackGround;
  }
  
  public RectF getImageClipDrawRegion()
  {
    return this.mClipRegion;
  }
  
  public RectF getImageRegion()
  {
    return this.mSizeRegion;
  }
  
  public void release()
  {
    super.release();
    clearStatus();
    this.mBackGround.release();
    this.mResPath = "";
  }
  
  public void setConvertedImageAndClipRegion(RectF paramRectF)
  {
    if (!this.mSizeRegion.equals(paramRectF))
    {
      this.mSizeRegion.set(paramRectF);
      this.mClipRegion.set(paramRectF);
      this.mSizeChanged = true;
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.mBackGround.loadTextureSync(paramBitmap);
    this.mCurrentTexture = this.mBackGround.getTexture();
  }
  
  public void setImageClipDrawRegion(RectF paramRectF)
  {
    if (!this.mClipRegion.equals(paramRectF))
    {
      this.mClipRegion.set(paramRectF);
      this.mHaveMappedClipSize = false;
      mapClipRegion();
      this.mSizeChanged = true;
    }
  }
  
  public void setImageRegion(RectF paramRectF)
  {
    if (!this.mSizeRegion.equals(paramRectF))
    {
      this.mSizeRegion.set(paramRectF);
      this.mHaveMappedSize = false;
      mapSizeRegion();
      this.mSizeChanged = true;
    }
  }
  
  public void setImageRes(String paramString)
  {
    if (!this.mResPath.equals(paramString))
    {
      this.mBackGround.loadTextureSync(paramString);
      this.mCurrentTexture = this.mBackGround.getTexture();
      this.mResPath = paramString;
    }
  }
  
  public boolean updateParam()
  {
    boolean bool2 = super.updateParam();
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = this.mSizeChanged;
      this.mSizeChanged = false;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLImageView
 * JD-Core Version:    0.7.0.1
 */