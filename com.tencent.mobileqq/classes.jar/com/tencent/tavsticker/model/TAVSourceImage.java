package com.tencent.tavsticker.model;

import android.graphics.Bitmap;
import com.tencent.tav.coremedia.TextureInfo;
import org.libpag.PAGImage;

public class TAVSourceImage
{
  private static final String TAG = TAVSourceImage.class.getSimpleName();
  private int index = 0;
  private PAGImage pagImage = null;
  
  public TAVSourceImage(Bitmap paramBitmap, int paramInt)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      throw new IllegalArgumentException("<init> parameter 'bitmap' is illegal!");
    }
    this.pagImage = PAGImage.FromBitmap(paramBitmap);
    this.index = paramInt;
  }
  
  public TAVSourceImage(TextureInfo paramTextureInfo, int paramInt)
  {
    this(paramTextureInfo, false, paramInt);
  }
  
  public TAVSourceImage(TextureInfo paramTextureInfo, boolean paramBoolean, int paramInt)
  {
    if (paramTextureInfo != null) {
      this.pagImage = PAGImage.FromTexture(paramTextureInfo.textureID, paramTextureInfo.textureType, paramTextureInfo.width, paramTextureInfo.height, paramBoolean);
    }
    this.index = paramInt;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public PAGImage getPagImage()
  {
    return this.pagImage;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVSourceImage
 * JD-Core Version:    0.7.0.1
 */