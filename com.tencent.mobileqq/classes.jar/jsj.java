import android.content.Context;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.AbstractOrientationEventListener;
import com.tencent.av.ui.QavVideoRecordUICtrl;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qphone.base.util.QLog;

public class jsj
  extends AbstractOrientationEventListener
{
  public jsj(AVActivity paramAVActivity, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(270);
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(270, false);
      }
      if ((this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D != 2)) {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(270);
      }
      this.a.h = 270;
      if (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d(270);
        if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.g()))
        {
          this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d();
          this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.a.h);
        }
      }
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null) && ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().y) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().z))) {
        this.a.m();
      }
      break;
    }
    for (;;)
    {
      if (paramInt != this.a.h) {
        QLog.d(this.a.b, 1, "onVideoOrientationChanged, mRotationAngle[" + paramInt + "->" + this.a.h + "]");
      }
      return;
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(0);
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(0, false);
      }
      if ((this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D != 2)) {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(0);
      }
      this.a.h = 0;
      if (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d(0);
        this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d();
        this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.a.h);
      }
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null) && ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().y) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().z)))
      {
        this.a.m();
        continue;
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(90);
        }
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(90, false);
        }
        if ((this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D != 2)) {
          this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(90);
        }
        this.a.h = 90;
        if (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)
        {
          this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d(90);
          if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.g()))
          {
            this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d();
            this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.a.h);
          }
        }
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null) && ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().y) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().z)))
        {
          this.a.m();
          continue;
          if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
            this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(180);
          }
          if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
            this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(180, false);
          }
          if ((this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D != 2)) {
            this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(180);
          }
          this.a.h = 180;
          if (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)
          {
            this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d(180);
            if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.g()))
            {
              this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d();
              this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.a.h);
            }
          }
          if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null) && ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().y) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().z))) {
            this.a.m();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jsj
 * JD-Core Version:    0.7.0.1
 */