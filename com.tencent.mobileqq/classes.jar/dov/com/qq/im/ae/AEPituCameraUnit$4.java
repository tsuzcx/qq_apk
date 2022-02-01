package dov.com.qq.im.ae;

import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraFocusGesture.FocusGestureListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.core.AECameraManager;

class AEPituCameraUnit$4
  implements CameraFocusGesture.FocusGestureListener
{
  AEPituCameraUnit$4(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    AEPituCameraUnit.a(this.a);
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView != null) && (!this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFrontCamera()))
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView.a(paramMotionEvent);
      this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.requestCameraFocus(paramMotionEvent.getX(), paramMotionEvent.getY(), this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getSurfaceWidth(), this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getSurfaceHeight());
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, new Object[] { "", "CameraFocusGesture isRecording == false" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.4
 * JD-Core Version:    0.7.0.1
 */