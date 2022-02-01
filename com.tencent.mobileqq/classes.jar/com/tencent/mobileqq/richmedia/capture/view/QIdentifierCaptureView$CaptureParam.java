package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class QIdentifierCaptureView$CaptureParam
{
  public static final long a;
  public static String b;
  public int a;
  public String a;
  protected boolean a;
  public int b;
  protected boolean b;
  protected int c = -1;
  private int d = 960;
  private int e = 720;
  private int f = 1;
  
  static
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_b_of_type_JavaLangString = "key_aio_fbo";
  }
  
  public QIdentifierCaptureView$CaptureParam()
  {
    this.jdField_a_of_type_JavaLangString = (BaseApplicationImpl.getContext().getFilesDir().getPath() + "/Android/data/com.tencent.mobileqq/qq/video/Source/" + jdField_a_of_type_Long);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView.CaptureParam
 * JD-Core Version:    0.7.0.1
 */