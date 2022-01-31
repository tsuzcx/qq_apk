import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class jpg
  extends CameraObserver
{
  public jpg(AVActivity paramAVActivity) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "onBeforeOpenCamera");
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131365399, false);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    VideoNodeManager.a(44, 2L);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.g(paramBoolean);
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().i) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.b())) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131365399, this.a.jdField_a_of_type_ComTencentAvVideoController.a().g);
      }
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().ad) && ((!this.a.jdField_a_of_type_ComTencentAvVideoController.a().aa) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().ae)) && ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().d != 1) || (this.a.jdField_a_of_type_ComTencentAvVideoController.c()))) {}
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131365399, true);
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (!SmallScreenUtils.b(BaseApplicationImpl.getContext())) {
      VideoNodeManager.a(44, 1L);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "onAfterOpenCamera success: " + paramBoolean + ", preSessionType: " + paramInt + ", mRotationAngle: " + this.a.h);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131365399, true);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(this.a.h);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramBoolean, paramInt);
    }
    String str;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D != 2)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.h, false);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f(this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
      }
    }
    else
    {
      if ((this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D != 2)) {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.a.h);
      }
      if (!paramBoolean) {
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null))
        {
          str = "";
          if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().j()) {
            break label380;
          }
          str = "0X8004894";
        }
      }
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        QLog.w(this.a.b, 1, "onAfterOpenCamera fail, DEVICE_PERMISSION_TYPE_CAMERA_OPEN_FAIL");
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(2) });
      }
      return;
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.h);
      break;
      label380:
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f == 1) {
        str = "0X8004888";
      } else if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f == 2) {
        str = "0X800488E";
      }
    }
  }
  
  protected void b()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131365399, false);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.f();
      EffectController localEffectController = VideoController.a().a(this.a);
      if (localEffectController != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("EffectSettingUi", 1, "onHide clear state");
        }
        localEffectController.b();
      }
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131365369, true);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
    }
  }
  
  protected void c()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131365369, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jpg
 * JD-Core Version:    0.7.0.1
 */