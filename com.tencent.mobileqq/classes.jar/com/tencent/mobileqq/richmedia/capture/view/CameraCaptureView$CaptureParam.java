package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class CameraCaptureView$CaptureParam
{
  public static final String a;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  protected float a;
  public int a;
  public long a;
  protected boolean a;
  public int b;
  public String b;
  protected boolean b;
  protected int c;
  protected int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k = 1;
  private int l = 2000000;
  private int m = 1;
  private int n = 1;
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir().getPath() + "/Android/data/com.tencent.mobileqq/qq/video/LightVideo/";
    jdField_c_of_type_JavaLangString = "key_aio_fbo";
    jdField_d_of_type_JavaLangString = "key_riji_h_compress_fbo";
    jdField_e_of_type_JavaLangString = "key_riji_h_clip_fbo";
    jdField_f_of_type_JavaLangString = "key_riji_l_compress_fbo";
    jdField_g_of_type_JavaLangString = "key_riji_l_clip_fbo";
    jdField_h_of_type_JavaLangString = "key_ae_gif_fbo";
  }
  
  public CameraCaptureView$CaptureParam()
  {
    this.jdField_e_of_type_Int = 960;
    this.jdField_f_of_type_Int = 720;
    this.jdField_g_of_type_Int = 960;
    this.jdField_h_of_type_Int = 720;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_JavaLangString = (BaseApplicationImpl.getContext().getFilesDir().getPath() + "/Android/data/com.tencent.mobileqq/qq/video/Source/" + this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.jdField_h_of_type_Int = paramInt;
  }
  
  public void e(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void f(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void g(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void h(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void i(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void j(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    return "CaptureParam{wantedPreviewWidth=" + this.jdField_e_of_type_Int + ", wantedPreviewHeight=" + this.jdField_f_of_type_Int + ", defaultCamera=" + this.k + ", videoSizeRate=" + this.jdField_a_of_type_Float + ", videoBitRate=" + this.l + ", videoIFrameInterval=" + this.m + ", captureDir='" + this.jdField_b_of_type_JavaLangString + '\'' + ", audioCaptureEnable=" + this.jdField_a_of_type_Boolean + ", functionFlag=" + this.n + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam
 * JD-Core Version:    0.7.0.1
 */