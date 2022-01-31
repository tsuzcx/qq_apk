package com.tencent.sharpP;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class SharpPDecoder
{
  public static final int FORMAT_BGRA = 4;
  public static final int IMAGE_MODE_Animation = 3;
  public static final int IMAGE_MODE_AnimationWithAlpha = 4;
  public static final int SHARPP_STATUS_OK = 0;
  public int imageHeight;
  public int imageWidth;
  public SharpPDecoder.SharpPFeature mFeatureInfo;
  public int mhDec;
  
  public native void CloseDecoder2(int paramInt);
  
  public native int CreateDecoder2(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature);
  
  public native int DecodeImage2(int paramInt1, int paramInt2, SharpPDecoder.SharpPOutFrame paramSharpPOutFrame);
  
  public native int DecodeImageToBitmap2(int paramInt1, int paramInt2, Bitmap paramBitmap, Integer paramInteger);
  
  public native int ParseHeader2(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature);
  
  public Bitmap decodeSharpP2PNG2(String paramString, int paramInt1, int paramInt2)
  {
    SharpPDecoder.SharpPFeature localSharpPFeature = new SharpPDecoder.SharpPFeature(this);
    if (ParseHeader2(paramString, localSharpPFeature) != 0) {}
    do
    {
      return null;
      this.mhDec = CreateDecoder2(paramString, localSharpPFeature);
    } while (this.mhDec == 0);
    this.imageWidth = localSharpPFeature.width;
    this.imageHeight = localSharpPFeature.height;
    int i = (int)(this.imageHeight / this.imageWidth * paramInt2);
    if ((paramInt2 > this.imageWidth) || (i > this.imageHeight))
    {
      paramInt2 = this.imageWidth;
      i = this.imageHeight;
    }
    for (;;)
    {
      paramString = new int[paramInt2 * i];
      SharpPDecoder.SharpPOutFrame localSharpPOutFrame = new SharpPDecoder.SharpPOutFrame(this);
      localSharpPOutFrame.pOutBuf = paramString;
      localSharpPOutFrame.dstWidth = paramInt2;
      localSharpPOutFrame.dstHeight = i;
      localSharpPOutFrame.fmt = paramInt1;
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= localSharpPFeature.layerNum)
        {
          paramString = Bitmap.createBitmap(paramString, 0, paramInt2, paramInt2, i, Bitmap.Config.ARGB_8888);
          CloseDecoder2(this.mhDec);
          this.mhDec = 0;
          return paramString;
        }
        DecodeImage2(this.mhDec, paramInt1, localSharpPOutFrame);
        paramInt1 += 1;
      }
    }
  }
  
  public int getSharpPType()
  {
    return this.mFeatureInfo.imageMode;
  }
  
  public int parseHeader(String paramString)
  {
    this.mFeatureInfo = new SharpPDecoder.SharpPFeature(this);
    return ParseHeader2(paramString, this.mFeatureInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sharpP.SharpPDecoder
 * JD-Core Version:    0.7.0.1
 */