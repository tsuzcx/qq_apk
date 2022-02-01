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
  public long mhDec;
  
  public native void CloseDecoder2(long paramLong);
  
  public native long CreateDecoder2(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature);
  
  public native int DecodeImage2(long paramLong, int paramInt, SharpPDecoder.SharpPOutFrame paramSharpPOutFrame);
  
  public native int DecodeImageToBitmap2(long paramLong, int paramInt, Bitmap paramBitmap, Integer paramInteger);
  
  public native int ParseHeader2(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature);
  
  public Bitmap decodeSharpP2PNG2(String paramString, int paramInt1, int paramInt2)
  {
    SharpPDecoder.SharpPFeature localSharpPFeature = new SharpPDecoder.SharpPFeature(this);
    if (ParseHeader2(paramString, localSharpPFeature) != 0) {
      return null;
    }
    this.mhDec = CreateDecoder2(paramString, localSharpPFeature);
    if (this.mhDec == 0L) {
      return null;
    }
    this.imageWidth = localSharpPFeature.width;
    this.imageHeight = localSharpPFeature.height;
    int i = this.imageHeight;
    double d1 = i;
    int k = this.imageWidth;
    double d2 = k;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    d2 = paramInt2;
    Double.isNaN(d2);
    int j = (int)(d1 * d2);
    if ((paramInt2 <= k) && (j <= i))
    {
      i = paramInt2;
      paramInt2 = j;
    }
    else
    {
      i = this.imageWidth;
      paramInt2 = this.imageHeight;
    }
    paramString = new int[i * paramInt2];
    SharpPDecoder.SharpPOutFrame localSharpPOutFrame = new SharpPDecoder.SharpPOutFrame(this);
    localSharpPOutFrame.pOutBuf = paramString;
    localSharpPOutFrame.dstWidth = i;
    localSharpPOutFrame.dstHeight = paramInt2;
    localSharpPOutFrame.fmt = paramInt1;
    paramInt1 = 0;
    while (paramInt1 < localSharpPFeature.layerNum)
    {
      DecodeImage2(this.mhDec, paramInt1, localSharpPOutFrame);
      paramInt1 += 1;
    }
    paramString = Bitmap.createBitmap(paramString, 0, i, i, paramInt2, Bitmap.Config.ARGB_8888);
    CloseDecoder2(this.mhDec);
    this.mhDec = 0L;
    return paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sharpP.SharpPDecoder
 * JD-Core Version:    0.7.0.1
 */