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
        ILog localILog = ImageManagerEnv.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("createDecoder error,res=");
        localStringBuilder.append(i);
        localILog.e("SharpPPathDecoder", new Object[] { localStringBuilder.toString() });
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
    if ((this.mInfo == null) && (parseHeader() != 0)) {
      return null;
    }
    if (this.mInfo.getImageMode() == 4) {
      return this.mDecoder.decodeOneFrameWithAlphaInNative(paramLong, paramInt1, paramInt2, paramInt3, paramWriteableInteger, paramBitmap);
    }
    if (paramBitmap == null) {
      paramBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    }
    if (this.mDecoder.decodeOneFrameInNative(paramLong, paramInt1, paramBitmap, paramWriteableInteger) != 0) {
      return null;
    }
    return paramBitmap;
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
    Object localObject2 = this.mInfo;
    Object localObject1 = null;
    if ((localObject2 == null) && (parseHeader() != 0)) {
      return null;
    }
    localObject2 = this.mInfo;
    if (localObject2 != null)
    {
      int i = ((SharpPDecoderWrapper.SharpPFeatureWrapper)localObject2).getImageMode();
      if (i != 0) {
        if (i != 1)
        {
          if (i != 2)
          {
            if ((i != 3) && (i != 4))
            {
              localObject1 = ImageManagerEnv.getLogger();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("-------unknow mimeType:");
              ((StringBuilder)localObject2).append(this.mInfo.getImageMode());
              ((ILog)localObject1).e("SharpPPathDecoder", new Object[] { ((StringBuilder)localObject2).toString() });
              return null;
            }
            return "image/gif";
          }
        }
        else {
          return "image/png";
        }
      }
      localObject1 = "image/jpg";
    }
    return localObject1;
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
      ILog localILog = ImageManagerEnv.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseHeader error,res=");
      localStringBuilder.append(i);
      localILog.e("SharpPPathDecoder", new Object[] { localStringBuilder.toString() });
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sharpP.SharpPPathDecoder
 * JD-Core Version:    0.7.0.1
 */