package com.tencent.tavsticker.model;

import android.graphics.Bitmap;
import com.tencent.tav.coremedia.TextureInfo;
import org.libpag.PAGImage;

public class TAVSourceImage
{
  private static final String TAG = TAVSourceImage.class.getSimpleName();
  private int mIndex = 0;
  private PAGImage mPagImage = null;
  
  public TAVSourceImage(Bitmap paramBitmap, int paramInt)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      throw new IllegalArgumentException("<init> parameter 'bitmap' is illegal!");
    }
    this.mPagImage = PAGImage.FromBitmap(paramBitmap);
    this.mIndex = paramInt;
  }
  
  public TAVSourceImage(TextureInfo paramTextureInfo, int paramInt)
  {
    this(paramTextureInfo, false, paramInt);
  }
  
  public TAVSourceImage(TextureInfo paramTextureInfo, boolean paramBoolean, int paramInt)
  {
    if (paramTextureInfo != null) {
      this.mPagImage = PAGImage.FromTexture(paramTextureInfo.textureID, paramTextureInfo.textureType, paramTextureInfo.width, paramTextureInfo.height, paramBoolean);
    }
    this.mIndex = paramInt;
  }
  
  public int getIndex()
  {
    return this.mIndex;
  }
  
  PAGImage getPagImage()
  {
    return this.mPagImage;
  }
  
  public void setIndex(int paramInt)
  {
    this.mIndex = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVSourceImage
 * JD-Core Version:    0.7.0.1
 */