package com.tencent.mobileqq.richmedia.capture.view;

import android.os.Environment;
import java.io.File;

public class CameraCaptureView$CaptureParam
{
  protected float a;
  protected int a;
  protected String a;
  protected boolean a;
  protected int b;
  private boolean b;
  private int c = 640;
  private int d = 480;
  private int e = 640;
  private int f = 480;
  private int g = -1;
  private int h = -1;
  private int i = 1;
  private int j = 2000000;
  private int k = 1;
  private int l = 1;
  
  public CameraCaptureView$CaptureParam()
  {
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.tencent.mobileqq/qq/video/Source/" + System.currentTimeMillis());
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void e(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void f(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void g(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void h(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    return "CaptureParam{wantedPreviewWidth=" + this.c + ", wantedPreviewHeight=" + this.d + ", defaultCamera=" + this.i + ", videoSizeRate=" + this.jdField_a_of_type_Float + ", videoBitRate=" + this.j + ", videoIFrameInterval=" + this.k + ", captureDir='" + this.jdField_a_of_type_JavaLangString + '\'' + ", audioCaptureEnable=" + this.jdField_b_of_type_Boolean + ", functionFlag=" + this.l + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam
 * JD-Core Version:    0.7.0.1
 */