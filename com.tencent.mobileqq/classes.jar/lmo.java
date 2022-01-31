import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.qphone.base.util.QLog;

class lmo
  implements Camera.AutoFocusCallback
{
  lmo(lmn paramlmn) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AndroidCamera", 2, "camera focus success ? " + paramBoolean);
    }
    GraphicRenderMgr.getInstance().setIsFocusing(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lmo
 * JD-Core Version:    0.7.0.1
 */