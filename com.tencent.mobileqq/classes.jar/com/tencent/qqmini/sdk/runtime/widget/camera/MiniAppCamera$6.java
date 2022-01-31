package com.tencent.qqmini.sdk.runtime.widget.camera;

import android.hardware.Camera;

class MiniAppCamera$6
  implements Runnable
{
  MiniAppCamera$6(MiniAppCamera paramMiniAppCamera, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.a(true);
    MiniAppCamera localMiniAppCamera = this.this$0;
    if (this.a) {}
    for (Integer localInteger = this.this$0.b;; localInteger = this.this$0.jdField_a_of_type_JavaLangInteger)
    {
      localMiniAppCamera.a(localInteger.intValue());
      this.this$0.a(this.this$0.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
      this.this$0.setCameraSize(this.this$0.jdField_a_of_type_AndroidHardwareCamera$Size);
      this.this$0.jdField_a_of_type_AndroidHardwareCamera.startPreview();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.camera.MiniAppCamera.6
 * JD-Core Version:    0.7.0.1
 */