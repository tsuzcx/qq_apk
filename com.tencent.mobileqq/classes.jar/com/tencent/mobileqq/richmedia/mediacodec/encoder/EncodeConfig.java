package com.tencent.mobileqq.richmedia.mediacodec.encoder;

import android.opengl.EGLContext;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.MediaMuxerWrapper;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ThumbnailUtil.ThumbConfig;

public class EncodeConfig
{
  public int a;
  public EGLContext a;
  public MuxerDataListener a;
  public MediaMuxerWrapper a;
  public ThumbnailUtil.ThumbConfig a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e = 8;
  public int f;
  public int g;
  public int h = 0;
  public int i;
  public int j = -1;
  public int k = -1;
  
  public EncodeConfig(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean1, int paramInt7, String paramString2, String paramString3, String paramString4, boolean paramBoolean2)
  {
    this.jdField_d_of_type_Int = 30;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.e = paramInt4;
    this.f = paramInt6;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_d_of_type_Int = paramInt5;
    this.g = paramInt7;
    this.jdField_d_of_type_JavaLangString = paramString4;
  }
  
  public EncodeConfig(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    this(paramString, paramInt1, paramInt2, paramInt3, paramInt4, 30, 0, paramBoolean, paramInt5, null, null, null, false);
  }
  
  public EGLContext a()
  {
    return this.jdField_a_of_type_AndroidOpenglEGLContext;
  }
  
  public void a(EGLContext paramEGLContext)
  {
    this.jdField_a_of_type_AndroidOpenglEGLContext = paramEGLContext;
  }
  
  public String toString()
  {
    return "EncodeConfig{sharedContext=" + this.jdField_a_of_type_AndroidOpenglEGLContext + ", outputFilePath='" + this.jdField_a_of_type_JavaLangString + '\'' + ", width='" + this.jdField_a_of_type_Int + '\'' + ", height='" + this.jdField_b_of_type_Int + '\'' + ", bitRate='" + this.jdField_c_of_type_Int + '\'' + ", frameRate='" + this.jdField_d_of_type_Int + '\'' + ", iFrameInterval='" + this.e + '\'' + ", filterType=" + this.f + ", needGenerateThumb=" + this.jdField_a_of_type_Boolean + ", watermarkPath='" + this.jdField_b_of_type_JavaLangString + '\'' + ", mosaicPath='" + this.jdField_c_of_type_JavaLangString + '\'' + ", orientation=" + this.g + ", adjustRotation=" + this.h + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig
 * JD-Core Version:    0.7.0.1
 */