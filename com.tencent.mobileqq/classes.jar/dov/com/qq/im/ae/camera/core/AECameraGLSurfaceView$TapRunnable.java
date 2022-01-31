package dov.com.qq.im.ae.camera.core;

import bktc;
import com.tencent.aekit.api.standard.filter.AEFilterManager;

class AECameraGLSurfaceView$TapRunnable
  implements Runnable
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  float b;
  
  public AECameraGLSurfaceView$TapRunnable(AECameraGLSurfaceView paramAECameraGLSurfaceView, int paramInt, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void run()
  {
    ((bktc)AECameraGLSurfaceView.a(this.this$0)).a().setTouchTriggerEvent(this.jdField_a_of_type_Int, this.jdField_a_of_type_Float, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.TapRunnable
 * JD-Core Version:    0.7.0.1
 */