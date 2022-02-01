package com.tencent.qqcamerakit.capture.cameraextend;

import android.graphics.Rect;
import com.tencent.qqcamerakit.capture.CameraProxy.CameraAutoFocusCallBack;

public class FocusOperator$CameraFocusParams
{
  public float a;
  public int a;
  public Rect a;
  public CameraProxy.CameraAutoFocusCallBack a;
  public boolean a;
  public float b;
  public int b;
  public Rect b;
  public boolean b;
  public int c;
  
  public FocusOperator$CameraFocusParams()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public FocusOperator$CameraFocusParams(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Float > 0.01F) && (this.jdField_b_of_type_Float > 0.01F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.cameraextend.FocusOperator.CameraFocusParams
 * JD-Core Version:    0.7.0.1
 */