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
  
  public void closeDecoderInNative(int paramInt)
  {
    this.mDecoder.CloseDecoder2(paramInt);
    this.byteBuffer = null;
  }
  
  public int createDecoderInNative(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature)
  {
    return this.mDecoder.CreateDecoder2(paramString, paramSharpPFeature);
  }
  
  SharpPDecoderWrapper.SharpPFeatureWrapper createSharpPFeatureWrapper()
  {
    SharpPDecoder localSharpPDecoder = this.mDecoder;
    localSharpPDecoder.getClass();
    return new SharpPDecoderWrapper.SharpPFeatureWrapper(new SharpPDecoder.SharpPFeature(localSharpPDecoder));
  }
  
  public int decodeImageInNative(int paramInt1, int paramInt2, SharpPDecoder.SharpPOutFrame paramSharpPOutFrame)
  {
    return this.mDecoder.DecodeImage2(paramInt1, paramInt2, paramSharpPOutFrame);
  }
  
  public Bitmap decodeImageInNative(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature, int paramInt1, int paramInt2, int paramInt3, Bitmap.Config paramConfig)
  {
    Object localObject = new int[3];
    int k = createDecoderInNative(paramString, paramSharpPFeature);
    if (k == 0)
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
    int i = 0;
    paramInt1 = 0;
    while (paramInt1 < paramSharpPFeature.layerNum)
    {
      int m = decodeImageInNative(k, paramInt1, (SharpPDecoder.SharpPOutFrame)localObject);
      int j = i;
      if (m != 0)
      {
        ImageManagerEnv.getLogger().e("SharpPDecoderWrapper", new Object[] { "decodeSharpP error:layerNo=" + paramInt1 + ",status=" + m });
        j = i + 1;
      }
      paramInt1 += 1;
      i = j;
    }
    closeDecoderInNative(k);
    if (i != paramSharpPFeature.layerNum) {
      return Bitmap.createBitmap(paramString, 0, paramInt2, paramInt2, paramInt3, paramConfig);
    }
    return null;
  }
  
  public int decodeImageToBitmapInNative(int paramInt1, int paramInt2, Bitmap paramBitmap, Integer paramInteger)
  {
    return this.mDecoder.DecodeImageToBitmap2(paramInt1, paramInt2, paramBitmap, paramInteger);
  }
  
  public int decodeOneFrameInNative(int paramInt1, int paramInt2, Bitmap paramBitmap, SharpPDecoderWrapper.WriteableInteger paramWriteableInteger)
  {
    paramInt1 = decodeImageToBitmapInNative(paramInt1, paramInt2, paramBitmap, paramWriteableInteger.realInt);
    if (paramInt1 != 0) {
      ImageManagerEnv.getLogger().e("SharpPDecoderWrapper", new Object[] { "decodeSharpP error:frameIndex=" + paramInt2 + ",status=" + paramInt1 });
    }
    return paramInt1;
  }
  
  public Bitmap decodeOneFrameWithAlphaInNative(int paramInt1, int paramInt2, int paramInt3, int paramInt4, SharpPDecoderWrapper.WriteableInteger paramWriteableInteger, Bitmap paramBitmap)
  {
    if ((this.byteBuffer == null) || ((this.byteBuffer != null) && (this.byteBuffer.length < paramInt3 * paramInt4))) {
      this.byteBuffer = new int[paramInt3 * paramInt4];
    }
    int[] arrayOfInt = this.byteBuffer;
    Object localObject = this.mDecoder;
    localObject.getClass();
    localObject = new SharpPDecoder.SharpPOutFrame((SharpPDecoder)localObject);
    ((SharpPDecoder.SharpPOutFrame)localObject).pOutBuf = arrayOfInt;
    ((SharpPDecoder.SharpPOutFrame)localObject).dstWidth = paramInt3;
    ((SharpPDecoder.SharpPOutFrame)localObject).dstHeight = paramInt4;
    ((SharpPDecoder.SharpPOutFrame)localObject).fmt = 4;
    paramInt1 = decodeImageInNative(paramInt1, paramInt2, (SharpPDecoder.SharpPOutFrame)localObject);
    if (paramInt1 != 0)
    {
      ImageManagerEnv.getLogger().e("SharpPDecoderWrapper", new Object[] { "decodeSharpP gif alpha mode error:status=" + paramInt1 });
      return null;
    }
    paramWriteableInteger.realInt = Integer.valueOf(((SharpPDecoder.SharpPOutFrame)localObject).delayTime);
    if ((paramBitmap != null) && (paramBitmap.isMutable()))
    {
      paramBitmap.setPixels(arrayOfInt, 0, paramInt3, 0, 0, paramInt3, paramInt4);
      return paramBitmap;
    }
    return Bitmap.createBitmap(arrayOfInt, paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
  }
  
  public Bitmap decodeSharpP2PNGInNative(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return decodeSharpPInNative(paramString, paramSharpPFeature, paramInt1, paramInt2, paramConfig);
  }
  
  public Bitmap decodeSharpPInNative(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    int j = createDecoderInNative(paramString, paramSharpPFeature);
    if (j == 0)
    {
      ImageManagerEnv.getLogger().e("SharpPDecoderWrapper", new Object[] { "decodeSharpPInNative error:hDec=0" });
      return null;
    }
    paramString = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
    paramInt2 = 0;
    paramConfig = new Integer(0);
    paramInt1 = 0;
    while (paramInt1 < paramSharpPFeature.layerNum)
    {
      int k = decodeImageToBitmapInNative(j, paramInt1, paramString, paramConfig);
      int i = paramInt2;
      if (k != 0)
      {
        ImageManagerEnv.getLogger().e("SharpPDecoderWrapper", new Object[] { "decodeSharpP error:layerNo=" + paramInt1 + ",status=" + k });
        i = paramInt2 + 1;
      }
      paramInt1 += 1;
      paramInt2 = i;
    }
    closeDecoderInNative(j);
    if (paramInt2 == paramSharpPFeature.layerNum) {
      return null;
    }
    return paramString;
  }
  
  public int getAllocationByteCount()
  {
    if (this.byteBuffer != null) {
      return this.byteBuffer.length;
    }
    return 0;
  }
  
  public int parseHeaderInNative(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature)
  {
    return this.mDecoder.ParseHeader2(paramString, paramSharpPFeature);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sharpP.SharpPDecoderWrapper
 * JD-Core Version:    0.7.0.1
 */