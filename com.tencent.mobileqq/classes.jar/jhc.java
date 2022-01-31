import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.av.camera.VcCamera;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.qphone.base.util.QLog;

public class jhc
  implements Camera.AutoFocusCallback
{
  public jhc(VcCamera paramVcCamera) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AndroidCamera", 2, "camera focus success ? " + paramBoolean);
    }
    GraphicRenderMgr.getInstance().setIsFocusing(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jhc
 * JD-Core Version:    0.7.0.1
 */