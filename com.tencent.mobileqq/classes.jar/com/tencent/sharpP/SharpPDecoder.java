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
  public SharpPFeature mFeatureInfo;
  public int mhDec;
  
  public native void CloseDecoder2(int paramInt);
  
  public native int CreateDecoder2(String paramString, SharpPFeature paramSharpPFeature);
  
  public native int DecodeImage2(int paramInt1, int paramInt2, SharpPOutFrame paramSharpPOutFrame);
  
  public native int DecodeImageToBitmap2(int paramInt1, int paramInt2, Bitmap paramBitmap, Integer paramInteger);
  
  public native int ParseHeader2(String paramString, SharpPFeature paramSharpPFeature);
  
  public Bitmap decodeSharpP2PNG2(String paramString, int paramInt1, int paramInt2)
  {
    SharpPFeature localSharpPFeature = new SharpPFeature();
    if (ParseHeader2(paramString, localSharpPFeature) != 0) {
      return null;
    }
    this.mhDec = CreateDecoder2(paramString, localSharpPFeature);
    if (this.mhDec == 0) {
      return null;
    }
    this.imageWidth = localSharpPFeature.width;
    this.imageHeight = localSharpPFeature.height;
    int j = (int)(this.imageHeight / this.imageWidth * paramInt2);
    int i;
    if (paramInt2 <= this.imageWidth)
    {
      i = j;
      if (j <= this.imageHeight) {}
    }
    else
    {
      paramInt2 = this.imageWidth;
      i = this.imageHeight;
    }
    paramString = new int[paramInt2 * i];
    SharpPOutFrame localSharpPOutFrame = new SharpPOutFrame();
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
  
  public int getSharpPType()
  {
    return this.mFeatureInfo.imageMode;
  }
  
  public int parseHeader(String paramString)
  {
    this.mFeatureInfo = new SharpPFeature();
    return ParseHeader2(paramString, this.mFeatureInfo);
  }
  
  public class SharpPFeature
  {
    public int bYUV444;
    public int colorCount;
    public int frameCount;
    public int headerSize;
    public int height;
    public int imageMode;
    public int layerNum;
    public int level;
    public int version;
    public int width;
    
    public SharpPFeature() {}
  }
  
  public class SharpPOutFrame
  {
    public int bufsize;
    public int delayTime;
    public int dstHeight;
    public int dstWidth;
    public int fmt;
    public int[] pOutBuf;
    
    public SharpPOutFrame() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sharpP.SharpPDecoder
 * JD-Core Version:    0.7.0.1
 */