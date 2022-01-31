import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mds
  extends lme
{
  public mds(AVActivity paramAVActivity) {}
  
  protected void a(long paramLong)
  {
    Object localObject;
    boolean bool;
    if (QLog.isDevelopLevel())
    {
      localObject = this.a.b;
      StringBuilder localStringBuilder = new StringBuilder().append("onBeforeCloseCamera, mControlUI[");
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        bool = true;
        QLog.w((String)localObject, 1, bool + "], seq[" + paramLong + "]");
      }
    }
    else
    {
      if (!this.a.isDestroyed()) {
        break label86;
      }
    }
    label86:
    do
    {
      do
      {
        return;
        bool = false;
        break;
      } while ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.g()));
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.j(paramLong);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a() != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a().a(3);
      }
      localObject = VideoController.a().a(this.a);
    } while (localObject == null);
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectSettingUi", 1, "onHide clear state");
    }
    ((lrz)localObject).a();
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.a.b, 1, "onBeforeOpenCamera, bLastOpen[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    if (this.a.isDestroyed()) {}
    while ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.g())) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.f(paramLong, 65535);
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    QLog.w(this.a.b, 1, "onAfterOpenCamera, success[" + paramBoolean + "], preSessionType[" + paramInt + "], mRotationAngle[" + this.a.h + "], mShutCamera[" + this.a.f + "], seq[" + paramLong + "]");
    if (this.a.isDestroyed()) {}
    label224:
    do
    {
      do
      {
        return;
      } while ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.g()));
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.f(paramLong, 65535);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong, this.a.h);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong, paramBoolean, paramInt);
      lko.a().a(this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().C == 2) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.h, false);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(paramLong, this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
      }
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().C != 2) {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.a.h);
      }
    } while (paramBoolean);
    this.a.f = true;
    String str;
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null))
    {
      str = "";
      if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().q()) {
        break label429;
      }
      str = "0X8004894";
    }
    for (;;)
    {
      azqs.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(2), Long.valueOf(paramLong) });
      return;
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(this.a.h);
      break label224;
      label429:
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f == 1) {
        str = "0X8004888";
      } else if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f == 2) {
        str = "0X800488E";
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    mth.a("switch_camera", "onAfterSwitchCamera", 3, new Object[] { Long.valueOf(l) });
    QLog.w(this.a.b, 1, "onAfterSwitchCamera, success[" + paramBoolean + "], seq[" + l + "]");
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(2131372903, true);
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
      }
      if (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
        lko.a().a(this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
      }
      return;
    }
    this.a.a(l);
  }
  
  protected void b()
  {
    mth.a("switch_camera", "onBeforeSwitchCamera", 3, new Object[0]);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(2131372903, false);
    }
  }
  
  protected void b(long paramLong, boolean paramBoolean)
  {
    boolean bool;
    if (QLog.isDevelopLevel())
    {
      localObject = this.a.b;
      StringBuilder localStringBuilder = new StringBuilder().append("onAfterCloseCamera, success[").append(paramBoolean).append("], mControlUI[");
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        bool = true;
        QLog.w((String)localObject, 1, bool + "], seq[" + paramLong + "]");
      }
    }
    else
    {
      if (!this.a.isDestroyed()) {
        break label98;
      }
    }
    label98:
    while ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.g()))
    {
      return;
      bool = false;
      break;
    }
    Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a = null;
    if (localObject != null) {
      ((mtx)localObject).d();
    }
    this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramLong, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mds
 * JD-Core Version:    0.7.0.1
 */