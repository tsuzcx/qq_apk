package com.tencent.sharpP;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;

public class SharpPDecoderWrapper
{
  public static final int MAX_LAYER_NUM = 3;
  private static final String TAG = "SharpPDecoderWrapper";
  public static final int emMode_Animation = 3;
  public static final int emMode_AnimationWithAlpha = 4;
  public static final int emMode_BlendAlpha = 2;
  public static final int emMode_EncodeAlpha = 1;
  public static final int emMode_Normal = 0;
  private static boolean sSoLoaded;
  private int[] byteBuffer;
  private SharpPDecoder mDecoder;
  
  static {}
  
  SharpPDecoderWrapper()
  {
    if (!sSoLoaded) {
      loadLibrary();
    }
    this.mDecoder = new SharpPDecoder();
  }
  
  private static void loadLibrary()
  {
    try
    {
      sSoLoaded = ImageManagerEnv.g().loadLibrary("TcHevcDec");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ImageManagerEnv.getLogger().w("SharpPDecoderWrapper", new Object[] { "catch an exception:", localUnsatisfiedLinkError });
    }
  }
  
  public void closeDecoderInNative(long paramLong)
  {
    this.mDecoder.CloseDecoder2(paramLong);
    this.byteBuffer = null;
  }
  
  public long createDecoderInNative(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature)
  {
    return this.mDecoder.CreateDecoder2(paramString, paramSharpPFeature);
  }
  
  SharpPDecoderWrapper.SharpPFeatureWrapper createSharpPFeatureWrapper()
  {
    SharpPDecoder localSharpPDecoder = this.mDecoder;
    localSharpPDecoder.getClass();
    return new SharpPDecoderWrapper.SharpPFeatureWrapper(new SharpPDecoder.SharpPFeature(localSharpPDecoder));
  }
  
  public int decodeImageInNative(long paramLong, int paramInt, SharpPDecoder.SharpPOutFrame paramSharpPOutFrame)
  {
    return this.mDecoder.DecodeImage2(paramLong, paramInt, paramSharpPOutFrame);
  }
  
  public Bitmap decodeImageInNative(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature, int paramInt1, int paramInt2, int paramInt3, Bitmap.Config paramConfig)
  {
    Object localObject = new int[3];
    long l = createDecoderInNative(paramString, paramSharpPFeature);
    if (l == 0L)
    {
      ImageManagerEnv.getLogger().e("SharpPDecoderWrapper", new Object[] { "decodeImageInNative error:hDec=0" });
      return null;
    }
    paramString = new int[paramInt2 * paramInt3];
    localObject = this.mDecoder;
    localObject.getClass();
    localObject = new SharpPDecoder.SharpPOutFrame((SharpPDecoder)localObject);
    ((SharpPDecoder.SharpPOutFrame)localObject).pOutBuf = paramString;
    ((SharpPDecoder.SharpPOutFrame)localObject).dstWidth = paramInt2;
    ((SharpPDecoder.SharpPOutFrame)localObject).dstHeight = paramInt3;
    ((SharpPDecoder.SharpPOutFrame)localObject).fmt = paramInt1;
    paramInt1 = 0;
    int j;
    for (int i = 0; paramInt1 < paramSharpPFeature.layerNum; i = j)
    {
      int k = decodeImageInNative(l, paramInt1, (SharpPDecoder.SharpPOutFrame)localObject);
      j = i;
      if (k != 0)
      {
        ILog localILog = ImageManagerEnv.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeSharpP error:layerNo=");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",status=");
        localStringBuilder.append(k);
        localILog.e("SharpPDecoderWrapper", new Object[] { localStringBuilder.toString() });
        j = i + 1;
      }
      paramInt1 += 1;
    }
    closeDecoderInNative(l);
    if (i != paramSharpPFeature.layerNum) {
      return Bitmap.createBitmap(paramString, 0, paramInt2, paramInt2, paramInt3, paramConfig);
    }
    return null;
  }
  
  public int decodeImageToBitmapInNative(long paramLong, int paramInt, Bitmap paramBitmap, Integer paramInteger)
  {
    return this.mDecoder.DecodeImageToBitmap2(paramLong, paramInt, paramBitmap, paramInteger);
  }
  
  public int decodeOneFrameInNative(long paramLong, int paramInt, Bitmap paramBitmap, SharpPDecoderWrapper.WriteableInteger paramWriteableInteger)
  {
    int i = decodeImageToBitmapInNative(paramLong, paramInt, paramBitmap, paramWriteableInteger.realInt);
    if (i != 0)
    {
      paramBitmap = ImageManagerEnv.getLogger();
      paramWriteableInteger = new StringBuilder();
      paramWriteableInteger.append("decodeSharpP error:frameIndex=");
      paramWriteableInteger.append(paramInt);
      paramWriteableInteger.append(",status=");
      paramWriteableInteger.append(i);
      paramBitmap.e("SharpPDecoderWrapper", new Object[] { paramWriteableInteger.toString() });
    }
    return i;
  }
  
  public Bitmap decodeOneFrameWithAlphaInNative(long paramLong, int paramInt1, int paramInt2, int paramInt3, SharpPDecoderWrapper.WriteableInteger paramWriteableInteger, Bitmap paramBitmap)
  {
    int[] arrayOfInt = this.byteBuffer;
    if ((arrayOfInt == null) || ((arrayOfInt != null) && (arrayOfInt.length < paramInt2 * paramInt3))) {
      this.byteBuffer = new int[paramInt2 * paramInt3];
    }
    arrayOfInt = this.byteBuffer;
    Object localObject = this.mDecoder;
    localObject.getClass();
    localObject = new SharpPDecoder.SharpPOutFrame((SharpPDecoder)localObject);
    ((SharpPDecoder.SharpPOutFrame)localObject).pOutBuf = arrayOfInt;
    ((SharpPDecoder.SharpPOutFrame)localObject).dstWidth = paramInt2;
    ((SharpPDecoder.SharpPOutFrame)localObject).dstHeight = paramInt3;
    ((SharpPDecoder.SharpPOutFrame)localObject).fmt = 4;
    paramInt1 = decodeImageInNative(paramLong, paramInt1, (SharpPDecoder.SharpPOutFrame)localObject);
    if (paramInt1 != 0)
    {
      paramWriteableInteger = ImageManagerEnv.getLogger();
      paramBitmap = new StringBuilder();
      paramBitmap.append("decodeSharpP gif alpha mode error:status=");
      paramBitmap.append(paramInt1);
      paramWriteableInteger.e("SharpPDecoderWrapper", new Object[] { paramBitmap.toString() });
      return null;
    }
    paramWriteableInteger.realInt = Integer.valueOf(((SharpPDecoder.SharpPOutFrame)localObject).delayTime);
    if ((paramBitmap != null) && (paramBitmap.isMutable()))
    {
      paramBitmap.setPixels(arrayOfInt, 0, paramInt2, 0, 0, paramInt2, paramInt3);
      return paramBitmap;
    }
    return Bitmap.createBitmap(arrayOfInt, paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
  }
  
  public Bitmap decodeSharpP2PNGInNative(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return decodeSharpPInNative(paramString, paramSharpPFeature, paramInt1, paramInt2, paramConfig);
  }
  
  public Bitmap decodeSharpPInNative(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    long l = createDecoderInNative(paramString, paramSharpPFeature);
    if (l == 0L)
    {
      ImageManagerEnv.getLogger().e("SharpPDecoderWrapper", new Object[] { "decodeSharpPInNative error:hDec=0" });
      return null;
    }
    paramString = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
    paramConfig = new Integer(0);
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt2 < paramSharpPFeature.layerNum)
    {
      int i = decodeImageToBitmapInNative(l, paramInt2, paramString, paramConfig);
      if (i != 0)
      {
        ILog localILog = ImageManagerEnv.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeSharpP error:layerNo=");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(",status=");
        localStringBuilder.append(i);
        localILog.e("SharpPDecoderWrapper", new Object[] { localStringBuilder.toString() });
        paramInt1 += 1;
      }
      paramInt2 += 1;
    }
    closeDecoderInNative(l);
    if (paramInt1 == paramSharpPFeature.layerNum) {
      paramString = null;
    }
    return paramString;
  }
  
  public int getAllocationByteCount()
  {
    int[] arrayOfInt = this.byteBuffer;
    if (arrayOfInt != null) {
      return arrayOfInt.length;
    }
    return 0;
  }
  
  public int parseHeaderInNative(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature)
  {
    return this.mDecoder.ParseHeader2(paramString, paramSharpPFeature);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sharpP.SharpPDecoderWrapper
 * JD-Core Version:    0.7.0.1
 */