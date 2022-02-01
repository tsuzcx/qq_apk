package com.tencent.mobileqq.shortvideo.camera2;

import com.tencent.mobileqq.activity.richmedia.NewFlowCameraOperator;

public class CameraFocusParams
{
  public float a;
  public float b;
  public int c;
  public int d;
  public int e;
  public NewFlowCameraOperator f;
  public boolean g = false;
  
  public boolean a()
  {
    return (this.d > 0) && (this.c > 0) && (this.f != null) && (this.a > 0.01F) && (this.b > 0.01F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.CameraFocusParams
 * JD-Core Version:    0.7.0.1
 */