package dov.com.qq.im.ae;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.RelativeLayout.LayoutParams;
import aqmy;
import bmvr;
import bmxa;
import bmxd;
import bnbg;
import bnqc;
import bnrh;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.ae.view.AEPituCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;

public class AEPituCameraUnit$17
  implements Runnable
{
  public AEPituCameraUnit$17(bmxa parambmxa) {}
  
  public void run()
  {
    bnrh.b(this.this$0.jdField_a_of_type_JavaLangString, "actionAfterFirstFrame--ui run--BEGIN");
    Object localObject = (ViewStub)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2131378164);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      bnrh.b(this.this$0.jdField_a_of_type_JavaLangString, "AEPartAction--inflate bottom");
    }
    localObject = (ViewStub)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2131378166);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      bnrh.b(this.this$0.jdField_a_of_type_JavaLangString, "AEPartAction--inflate captureModeCode");
    }
    this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton = ((AEPituCameraCaptureButtonLayout)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2131364282));
    this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.a(this.this$0, this.this$0.jdField_a_of_type_Bmvr.i(), this.this$0.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
    if (!this.this$0.k())
    {
      localObject = (RelativeLayout.LayoutParams)this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(-30.0F, this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.getResources());
      this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.d();
    }
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.k();
      this.this$0.e();
    }
    this.this$0.jdField_a_of_type_Bnbg.b();
    if (this.this$0.jdField_a_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera())
    {
      this.this$0.Z();
      this.this$0.jdField_a_of_type_Bnqc.a();
    }
    bmxa.a(this.this$0, (AECompoundButton)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2131365386));
    bmxa.a(this.this$0).setOnClickListener(this.this$0);
    bmxa.a(this.this$0).setSelected(false);
    bmxa.a(this.this$0).setVisibility(8);
    if (bmxa.b(this.this$0)) {
      bmxa.a(this.this$0, bmxa.b(this.this$0));
    }
    bmxa.b(this.this$0, (AECompoundButton)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2131364441));
    bmxa.b(this.this$0).setOnClickListener(this.this$0);
    bmxa.b(this.this$0).setContentDescription(bmxa.b(this.this$0).getResources().getString(2131718071));
    if (!aqmy.d())
    {
      bmxa.b(this.this$0).setVisibility(4);
      bmxa.b(this.this$0).setEnabled(false);
    }
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      this.this$0.jdField_a_of_type_Bnqc.b();
      this.this$0.jdField_a_of_type_Bnbg.h();
    }
    this.this$0.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.this$0);
    if (this.this$0.k()) {
      this.this$0.jdField_a_of_type_AndroidViewView.setOnClickListener(new bmxd(this));
    }
    this.this$0.P();
    bmxa.a(this.this$0, true);
    bnrh.b(this.this$0.jdField_a_of_type_JavaLangString, "actionAfterFirstFrame--ui run--END");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.17
 * JD-Core Version:    0.7.0.1
 */