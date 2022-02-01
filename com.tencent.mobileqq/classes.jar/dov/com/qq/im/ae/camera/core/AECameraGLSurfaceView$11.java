package dov.com.qq.im.ae.camera.core;

import android.content.Context;
import blnt;
import bluh;
import com.tencent.qphone.base.util.QLog;

class AECameraGLSurfaceView$11
  extends bluh
{
  AECameraGLSurfaceView$11(AECameraGLSurfaceView paramAECameraGLSurfaceView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    int i = 0;
    AECameraGLSurfaceView.access$1002(this.this$0, paramInt);
    if (AECameraGLSurfaceView.access$1100(this.this$0) != null) {
      AECameraGLSurfaceView.access$1100(this.this$0).onOrientionChanged(paramInt);
    }
    if (paramInt == -1) {
      if (QLog.isColorLevel()) {
        QLog.d("AECameraGLSurfaceView", 2, "OrientationEventListener unknown");
      }
    }
    for (int j = 90;; j = 0)
    {
      if ((paramInt > 315) || (paramInt < 45)) {
        i = 90;
      }
      for (;;)
      {
        AECameraGLSurfaceView.access$702(this.this$0, i);
        return;
        if ((paramInt > 45) && (paramInt < 135)) {
          i = 180;
        } else if ((paramInt > 135) && (paramInt < 225)) {
          i = 270;
        } else if ((paramInt <= 225) || (paramInt >= 315)) {
          i = j;
        }
      }
    }
  }
  
  public void onPoseChanged(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (AECameraGLSurfaceView.access$000(this.this$0) != null) {
      AECameraGLSurfaceView.access$000(this.this$0).a(paramFloat3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.11
 * JD-Core Version:    0.7.0.1
 */