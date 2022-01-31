package com.tencent.sharpP;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;

public class SharpPPathDecoder
{
  private static final String TAG = "SharpPPathDecoder";
  protected SharpPDecoderWrapper mDecoder = new SharpPDecoderWrapper();
  protected SharpPDecoderWrapper.SharpPFeatureWrapper mInfo;
  protected String mPath;
  
  public SharpPPathDecoder(String paramString)
  {
    this.mPath = paramString;
  }
  
  public void closeDecoder()
  {
    this.mInfo = null;
  }
  
  public void closeDecoder(long paramLong)
  {
    this.mDecoder.closeDecoderInNative(paramLong);
    closeDecoder();
  }
  
  public long createDecoder()
  {
    if (this.mInfo == null)
    {
      int i = parseHeader();
      if (i != 0)
      {
        ImageManagerEnv.getLogger().e("SharpPPathDecoder", new Object[] { "createDecoder error,res=" + i });
        return i;
      }
    }
    return this.mDecoder.createDecoderInNative(this.mPath, this.mInfo.getFeatureInfo());
  }
  
  public Bitmap decodeSharpP(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    if ((this.mInfo == null) && (parseHeader() != 0)) {
      return null;
    }
    return this.mDecoder.decodeSharpPInNative(this.mPath, this.mInfo.getFeatureInfo(), paramInt1, paramInt2, paramConfig);
  }
  
  public Bitmap decodeSharpP2GifFrame(long paramLong, int paramInt1, int paramInt2, int paramInt3, SharpPDecoderWrapper.WriteableInteger paramWriteableInteger, Bitmap paramBitmap)
  {
    Bitmap localBitmap;
    if ((this.mInfo == null) && (parseHeader() != 0))
    {
      localBitmap = null;
      return localBitmap;
    }
    if (this.mInfo.getImageMode() == 4) {
      return this.mDecoder.decodeOneFrameWithAlphaInNative(paramLong, paramInt1, paramInt2, paramInt3, paramWriteableInteger, paramBitmap);
    }
    if (paramBitmap == null) {
      paramBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    }
    for (;;)
    {
      localBitmap = paramBitmap;
      if (this.mDecoder.decodeOneFrameInNative(paramLong, paramInt1, paramBitmap, paramWriteableInteger) == 0) {
        break;
      }
      return null;
    }
  }
  
  public Bitmap decodeSharpP2JPG(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    if ((this.mInfo == null) && (parseHeader() != 0)) {
      return null;
    }
    return this.mDecoder.decodeImageInNative(this.mPath, this.mInfo.getFeatureInfo(), 4, paramInt1, paramInt2, paramConfig);
  }
  
  public Bitmap decodeSharpP2PNG(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    if ((this.mInfo == null) && (parseHeader() != 0)) {
      return null;
    }
    return this.mDecoder.decodeSharpP2PNGInNative(this.mPath, this.mInfo.getFeatureInfo(), paramInt1, paramInt2, paramConfig);
  }
  
  public int getAllocationByteCount()
  {
    return this.mDecoder.getAllocationByteCount();
  }
  
  public SharpPDecoderWrapper.SharpPFeatureWrapper getFeatureInfo()
  {
    if ((this.mInfo == null) && (parseHeader() != 0)) {
      return null;
    }
    return this.mInfo;
  }
  
  public String getMimeType()
  {
    if ((this.mInfo == null) && (parseHeader() != 0)) {}
    while (this.mInfo == null) {
      return null;
    }
    switch (this.mInfo.getImageMode())
    {
    default: 
      ImageManagerEnv.getLogger().e("SharpPPathDecoder", new Object[] { "-------unknow mimeType:" + this.mInfo.getImageMode() });
      return null;
    case 0: 
      return "image/jpg";
    case 1: 
      return "image/png";
    case 2: 
      return "image/jpg";
    case 3: 
      return "image/gif";
    }
    return "image/gif";
  }
  
  public int parseHeader()
  {
    if (this.mInfo != null) {
      return 0;
    }
    this.mInfo = this.mDecoder.createSharpPFeatureWrapper();
    int i = this.mDecoder.parseHeaderInNative(this.mPath, this.mInfo.getFeatureInfo());
    if (i != 0)
    {
      this.mInfo = null;
      ImageManagerEnv.getLogger().e("SharpPPathDecoder", new Object[] { "parseHeader error,res=" + i });
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.sharpP.SharpPPathDecoder
 * JD-Core Version:    0.7.0.1
 */