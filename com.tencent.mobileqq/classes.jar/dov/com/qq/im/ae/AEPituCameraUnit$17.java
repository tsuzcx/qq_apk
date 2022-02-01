package dov.com.qq.im.ae;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import dov.com.qq.im.ae.camera.ui.AECaptureController;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.ae.view.AEPituCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;

class AEPituCameraUnit$17
  implements Runnable
{
  AEPituCameraUnit$17(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void run()
  {
    AEQLog.b(this.this$0.jdField_b_of_type_JavaLangString, "actionAfterFirstFrame--ui run--BEGIN");
    Object localObject = (ViewStub)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2131378585);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      AEQLog.b(this.this$0.jdField_b_of_type_JavaLangString, "AEPartAction--inflate bottom");
    }
    localObject = (ViewStub)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2131378587);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      AEQLog.b(this.this$0.jdField_b_of_type_JavaLangString, "AEPartAction--inflate captureModeCode");
    }
    this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton = ((AEPituCameraCaptureButtonLayout)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2131364388));
    this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.a(this.this$0, this.this$0.jdField_a_of_type_DovComQqImAeAECameraConfig.i(), this.this$0.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
    if (!this.this$0.l())
    {
      localObject = (RelativeLayout.LayoutParams)this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(-30.0F, this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.getResources());
      this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.d();
    }
    if (this.this$0.jdField_b_of_type_Boolean)
    {
      this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.k();
      this.this$0.e();
    }
    this.this$0.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.b();
    if (this.this$0.jdField_a_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera())
    {
      this.this$0.Y();
      this.this$0.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a();
    }
    AEPituCameraUnit.a(this.this$0, (AECompoundButton)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2131365536));
    AEPituCameraUnit.a(this.this$0).setOnClickListener(this.this$0);
    AEPituCameraUnit.a(this.this$0).setSelected(false);
    AEPituCameraUnit.a(this.this$0).setVisibility(8);
    if (AEPituCameraUnit.a(this.this$0)) {
      AEPituCameraUnit.a(this.this$0, AEPituCameraUnit.a(this.this$0));
    }
    AEPituCameraUnit.b(this.this$0, (AECompoundButton)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2131364549));
    AEPituCameraUnit.b(this.this$0).setOnClickListener(this.this$0);
    AEPituCameraUnit.b(this.this$0).setContentDescription(AEPituCameraUnit.b(this.this$0).getResources().getString(2131718564));
    if (!CameraUtils.d())
    {
      AEPituCameraUnit.b(this.this$0).setVisibility(4);
      AEPituCameraUnit.b(this.this$0).setEnabled(false);
    }
    if (this.this$0.jdField_b_of_type_Boolean)
    {
      this.this$0.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.b();
      this.this$0.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.h();
    }
    this.this$0.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.this$0);
    if (this.this$0.l()) {
      this.this$0.jdField_a_of_type_AndroidViewView.setOnClickListener(new AEPituCameraUnit.17.1(this));
    }
    this.this$0.P();
    AEPituCameraUnit.a(this.this$0, true);
    AEQLog.b(this.this$0.jdField_b_of_type_JavaLangString, "actionAfterFirstFrame--ui run--END");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.17
 * JD-Core Version:    0.7.0.1
 */