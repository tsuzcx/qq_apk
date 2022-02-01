package com.tencent.tavkit.ciimage;

import android.graphics.Bitmap;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;

public class TAVGLUtils
  extends com.tencent.tav.player.TAVGLUtils
{
  public static Bitmap saveBitmap(CIImage paramCIImage)
  {
    TextureInfo localTextureInfo = CIContext.newTextureInfo(paramCIImage.getSize().width, paramCIImage.getSize().height);
    CIImageFilter localCIImageFilter = new CIImageFilter();
    localCIImageFilter.setOutputTextureInfo(localTextureInfo);
    paramCIImage.draw(localCIImageFilter);
    return saveBitmap(localTextureInfo);
  }
  
  public static void saveBitmapToFile(Bitmap paramBitmap)
  {
    saveBitmapToFile(paramBitmap, newDebugImageFile(0, paramBitmap.getWidth(), paramBitmap.getHeight()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.TAVGLUtils
 * JD-Core Version:    0.7.0.1
 */