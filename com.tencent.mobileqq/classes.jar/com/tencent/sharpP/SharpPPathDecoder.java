package com.tencent.sharpP;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;

public class SharpPPathDecoder
{
  protected SharpPDecoderWrapper.SharpPFeatureWrapper a;
  protected SharpPDecoderWrapper a;
  protected String a;
  
  public SharpPPathDecoder(String paramString)
  {
    this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper = new SharpPDecoderWrapper();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper != null) {
      return 0;
    }
    this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper = this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper.a();
    int i = this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper.a());
    if (i != 0)
    {
      this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper = null;
      ImageManagerEnv.getLogger().e("SharpPPathDecoder", new Object[] { "parseHeader error,res=" + i });
    }
    return i;
  }
  
  public Bitmap a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, SharpPDecoderWrapper.WriteableInteger paramWriteableInteger, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper == null) && (a() != 0)) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper.c() == 4) {
      paramBitmap = this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper.a(paramInt1, paramInt2, paramInt3, paramInt4, paramWriteableInteger, paramBitmap);
    }
    for (;;)
    {
      return paramBitmap;
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null) {
        localBitmap = Bitmap.createBitmap(paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
      }
      paramBitmap = localBitmap;
      if (this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper.a(paramInt1, paramInt2, localBitmap, paramWriteableInteger) != 0) {
        paramBitmap = null;
      }
    }
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    if ((this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper == null) && (a() != 0)) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper.a(), paramInt1, paramInt2, paramConfig);
  }
  
  public SharpPDecoderWrapper.SharpPFeatureWrapper a()
  {
    if ((this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper == null) && (a() != 0)) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper == null) && (a() != 0)) {}
    while (this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper == null) {
      return null;
    }
    switch (this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper.c())
    {
    default: 
      ImageManagerEnv.getLogger().e("SharpPPathDecoder", new Object[] { "-------unknow mimeType:" + this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper.c() });
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
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper.a(paramInt);
    a();
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper == null)
    {
      int i = a();
      if (i != 0)
      {
        ImageManagerEnv.getLogger().e("SharpPPathDecoder", new Object[] { "createDecoder error,res=" + i });
        return i;
      }
    }
    return this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper.a());
  }
  
  public Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    if ((this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper == null) && (a() != 0)) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper.a(), paramInt1, paramInt2, paramConfig);
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper.a();
  }
  
  public Bitmap c(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    if ((this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper == null) && (a() != 0)) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentSharpPSharpPDecoderWrapper$SharpPFeatureWrapper.a(), 4, paramInt1, paramInt2, paramConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sharpP.SharpPPathDecoder
 * JD-Core Version:    0.7.0.1
 */