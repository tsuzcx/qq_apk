package com.tencent.mobileqq.richmedia.capture.view;

import android.graphics.SurfaceTexture;
import auvo;
import com.tencent.qphone.base.util.QLog;

public class FollowCaptureView$1$1
  implements Runnable
{
  public FollowCaptureView$1$1(auvo paramauvo, SurfaceTexture paramSurfaceTexture) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FollowCaptureView", 2, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.FollowCaptureView.1.1
 * JD-Core Version:    0.7.0.1
 */