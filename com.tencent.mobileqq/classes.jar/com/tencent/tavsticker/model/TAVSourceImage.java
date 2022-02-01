package com.tencent.tavsticker.model;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.tav.coremedia.TextureInfo;
import org.libpag.PAGImage;

public class TAVSourceImage
{
  private static final String TAG = "TAVSourceImage";
  private int index = 0;
  private Matrix matrix = null;
  private PAGImage pagImage = null;
  
  public TAVSourceImage(Bitmap paramBitmap, int paramInt)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.pagImage = PAGImage.FromBitmap(paramBitmap);
      this.index = paramInt;
      return;
    }
    throw new IllegalArgumentException("<init> parameter 'bitmap' is illegal!");
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
  
  public Matrix getMatrix()
  {
    return this.matrix;
  }
  
  public PAGImage getPagImage()
  {
    return this.pagImage;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    this.matrix = paramMatrix;
    PAGImage localPAGImage = this.pagImage;
    if (localPAGImage != null) {
      localPAGImage.setMatrix(paramMatrix);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVSourceImage
 * JD-Core Version:    0.7.0.1
 */