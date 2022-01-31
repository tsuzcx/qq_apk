import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.smallscreen.SmallScreenVideoController;
import com.tencent.av.smallscreen.SmallScreenVideoLayerUI;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class jow
  extends CameraObserver
{
  public jow(SmallScreenVideoController paramSmallScreenVideoController) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onBeforeOpenCamera");
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().i == 1011) || (this.a.jdField_a_of_type_ComTencentAvVideoController.f)))
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(false, false);
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.b();
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onAfterOpenCamera success: " + paramBoolean + ", preSessionType: " + paramInt);
    }
    if (paramBoolean)
    {
      if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (SmallScreenUtils.b()) && ((paramInt == 1) || (paramInt == 3)) && (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null))
      {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(true, false);
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.f(this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
      }
      return;
    }
    String str;
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null))
    {
      str = "";
      if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().j()) {
        break label229;
      }
      str = "0X8004894";
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break;
      }
      QLog.w("SmallScreenVideoController", 1, "onAfterOpenCamera fail, DEVICE_PERMISSION_TYPE_CAMERA_OPEN_FAIL");
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(2) });
      return;
      label229:
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f == 1) {
        str = "0X8004888";
      } else if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f == 2) {
        str = "0X800488E";
      }
    }
  }
  
  protected void b() {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jow
 * JD-Core Version:    0.7.0.1
 */