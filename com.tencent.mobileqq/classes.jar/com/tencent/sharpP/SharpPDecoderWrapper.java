package com.tencent.sharpP;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;

public class SharpPDecoderWrapper
{
  private static boolean jdField_a_of_type_Boolean;
  private SharpPDecoder jdField_a_of_type_ComTencentSharpPSharpPDecoder;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  static {}
  
  SharpPDecoderWrapper()
  {
    if (!jdField_a_of_type_Boolean) {
      a();
    }
    this.jdField_a_of_type_ComTencentSharpPSharpPDecoder = new SharpPDecoder();
  }
  
  private static void a()
  {
    try
    {
      jdField_a_of_type_Boolean = ImageManagerEnv.g().loadLibrary("TcHevcDec");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ImageManagerEnv.getLogger().w("SharpPDecoderWrapper", new Object[] { "catch an exception:", localUnsatisfiedLinkError });
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ArrayOfInt != null) {
      return this.jdField_a_of_type_ArrayOfInt.length;
    }
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2, Bitmap paramBitmap, SharpPDecoderWrapper.WriteableInteger paramWriteableInteger)
  {
    paramInt1 = a(paramInt1, paramInt2, paramBitmap, paramWriteableInteger.a);
    if (paramInt1 != 0) {
      ImageManagerEnv.getLogger().e("SharpPDecoderWrapper", new Object[] { "decodeSharpP error:frameIndex=" + paramInt2 + ",status=" + paramInt1 });
    }
    return paramInt1;
  }
  
  public int a(int paramInt1, int paramInt2, Bitmap paramBitmap, Integer paramInteger)
  {
    return this.jdField_a_of_type_ComTencentSharpPSharpPDecoder.DecodeImageToBitmap2(paramInt1, paramInt2, paramBitmap, paramInteger);
  }
  
  public int a(int paramInt1, int paramInt2, SharpPDecoder.SharpPOutFrame paramSharpPOutFrame)
  {
    return this.jdField_a_of_type_ComTencentSharpPSharpPDecoder.DecodeImage2(paramInt1, paramInt2, paramSharpPOutFrame);
  }
  
  public int a(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature)
  {
    return this.jdField_a_of_type_ComTencentSharpPSharpPDecoder.ParseHeader2(paramString, paramSharpPFeature);
  }
  
  public Bitmap a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, SharpPDecoderWrapper.WriteableInteger paramWriteableInteger, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length < paramInt3 * paramInt4))) {
      this.jdField_a_of_type_ArrayOfInt = new int[paramInt3 * paramInt4];
    }
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    Object localObject = this.jdField_a_of_type_ComTencentSharpPSharpPDecoder;
    localObject.getClass();
    localObject = new SharpPDecoder.SharpPOutFrame((SharpPDecoder)localObject);
    ((SharpPDecoder.SharpPOutFrame)localObject).pOutBuf = arrayOfInt;
    ((SharpPDecoder.SharpPOutFrame)localObject).dstWidth = paramInt3;
    ((SharpPDecoder.SharpPOutFrame)localObject).dstHeight = paramInt4;
    ((SharpPDecoder.SharpPOutFrame)localObject).fmt = 4;
    paramInt1 = a(paramInt1, paramInt2, (SharpPDecoder.SharpPOutFrame)localObject);
    if (paramInt1 != 0)
    {
      ImageManagerEnv.getLogger().e("SharpPDecoderWrapper", new Object[] { "decodeSharpP gif alpha mode error:status=" + paramInt1 });
      return null;
    }
    paramWriteableInteger.a = Integer.valueOf(((SharpPDecoder.SharpPOutFrame)localObject).delayTime);
    if ((paramBitmap != null) && (paramBitmap.isMutable()))
    {
      paramBitmap.setPixels(arrayOfInt, 0, paramInt3, 0, 0, paramInt3, paramInt4);
      return paramBitmap;
    }
    return Bitmap.createBitmap(arrayOfInt, paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
  }
  
  public Bitmap a(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature, int paramInt1, int paramInt2, int paramInt3, Bitmap.Config paramConfig)
  {
    Object localObject = new int[3];
    int k = b(paramString, paramSharpPFeature);
    if (k == 0)
    {
      ImageManagerEnv.getLogger().e("SharpPDecoderWrapper", new Object[] { "decodeImageInNative error:hDec=0" });
      return null;
    }
    paramString = new int[paramInt2 * paramInt3];
    localObject = this.jdField_a_of_type_ComTencentSharpPSharpPDecoder;
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
      int m = a(k, paramInt1, (SharpPDecoder.SharpPOutFrame)localObject);
      int j = i;
      if (m != 0)
      {
        ImageManagerEnv.getLogger().e("SharpPDecoderWrapper", new Object[] { "decodeSharpP error:layerNo=" + paramInt1 + ",status=" + m });
        j = i + 1;
      }
      paramInt1 += 1;
      i = j;
    }
    a(k);
    if (i != paramSharpPFeature.layerNum) {
      return Bitmap.createBitmap(paramString, 0, paramInt2, paramInt2, paramInt3, paramConfig);
    }
    return null;
  }
  
  public Bitmap a(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    int j = b(paramString, paramSharpPFeature);
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
      int k = a(j, paramInt1, paramString, paramConfig);
      int i = paramInt2;
      if (k != 0)
      {
        ImageManagerEnv.getLogger().e("SharpPDecoderWrapper", new Object[] { "decodeSharpP error:layerNo=" + paramInt1 + ",status=" + k });
        i = paramInt2 + 1;
      }
      paramInt1 += 1;
      paramInt2 = i;
    }
    a(j);
    if (paramInt2 == paramSharpPFeature.layerNum) {
      return null;
    }
    return paramString;
  }
  
  SharpPDecoderWrapper.SharpPFeatureWrapper a()
  {
    SharpPDecoder localSharpPDecoder = this.jdField_a_of_type_ComTencentSharpPSharpPDecoder;
    localSharpPDecoder.getClass();
    return new SharpPDecoderWrapper.SharpPFeatureWrapper(new SharpPDecoder.SharpPFeature(localSharpPDecoder));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentSharpPSharpPDecoder.CloseDecoder2(paramInt);
    this.jdField_a_of_type_ArrayOfInt = null;
  }
  
  public int b(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature)
  {
    return this.jdField_a_of_type_ComTencentSharpPSharpPDecoder.CreateDecoder2(paramString, paramSharpPFeature);
  }
  
  public Bitmap b(String paramString, SharpPDecoder.SharpPFeature paramSharpPFeature, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return a(paramString, paramSharpPFeature, paramInt1, paramInt2, paramConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sharpP.SharpPDecoderWrapper
 * JD-Core Version:    0.7.0.1
 */