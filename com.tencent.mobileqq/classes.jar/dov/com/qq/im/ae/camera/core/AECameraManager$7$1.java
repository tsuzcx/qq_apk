package dov.com.qq.im.ae.camera.core;

import android.graphics.Rect;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraAutoFocusCallBack;

class AECameraManager$7$1
  implements CameraProxy.CameraAutoFocusCallBack
{
  AECameraManager$7$1(AECameraManager.7 param7) {}
  
  public void onAutoFocusCallback(boolean paramBoolean1, boolean paramBoolean2)
  {
    AECameraManager.access$800(this.this$1.this$0).a(this.this$1.val$photoFile, new Rect(0, 0, this.this$1.val$previewSize.a, this.this$1.val$previewSize.b), this.this$1.val$callback, this.this$1.val$photoOrientation, this.this$1.val$mirror, 1, AECameraManager.access$1000(this.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.7.1
 * JD-Core Version:    0.7.0.1
 */