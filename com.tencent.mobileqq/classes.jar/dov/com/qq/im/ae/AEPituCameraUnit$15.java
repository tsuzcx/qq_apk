package dov.com.qq.im.ae;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.RelativeLayout.LayoutParams;
import apju;
import blit;
import bljy;
import blka;
import blnv;
import bmas;
import bmbx;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.ae.view.AEPituCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;

public class AEPituCameraUnit$15
  implements Runnable
{
  public AEPituCameraUnit$15(bljy parambljy) {}
  
  public void run()
  {
    bmbx.b(this.this$0.jdField_a_of_type_JavaLangString, "actionAfterFirstFrame--ui run--BEGIN");
    Object localObject = (ViewStub)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2131377878);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      bmbx.b(this.this$0.jdField_a_of_type_JavaLangString, "AEPartAction--inflate bottom");
    }
    localObject = (ViewStub)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2131377880);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      bmbx.b(this.this$0.jdField_a_of_type_JavaLangString, "AEPartAction--inflate captureModeCode");
    }
    this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton = ((AEPituCameraCaptureButtonLayout)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2131364205));
    this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.a(this.this$0, this.this$0.jdField_a_of_type_Blit.i(), this.this$0.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
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
      this.this$0.J();
    }
    this.this$0.jdField_a_of_type_Blnv.b();
    if (this.this$0.jdField_a_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera())
    {
      this.this$0.Q();
      this.this$0.jdField_a_of_type_Bmas.a();
    }
    bljy.a(this.this$0, (AECompoundButton)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2131365291));
    bljy.a(this.this$0).setOnClickListener(this.this$0);
    bljy.a(this.this$0).setSelected(false);
    bljy.a(this.this$0).setVisibility(8);
    if (bljy.b(this.this$0)) {
      bljy.a(this.this$0, bljy.b(this.this$0));
    }
    bljy.b(this.this$0, (AECompoundButton)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2131364360));
    bljy.b(this.this$0).setOnClickListener(this.this$0);
    bljy.b(this.this$0).setContentDescription(bljy.b(this.this$0).getResources().getString(2131717700));
    if (!apju.d())
    {
      bljy.b(this.this$0).setVisibility(4);
      bljy.b(this.this$0).setEnabled(false);
    }
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      this.this$0.jdField_a_of_type_Bmas.b();
      this.this$0.jdField_a_of_type_Blnv.h();
    }
    this.this$0.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.this$0);
    if (this.this$0.k()) {
      this.this$0.jdField_a_of_type_AndroidViewView.setOnClickListener(new blka(this));
    }
    this.this$0.F();
    bljy.a(this.this$0, true);
    bmbx.b(this.this$0.jdField_a_of_type_JavaLangString, "actionAfterFirstFrame--ui run--END");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.15
 * JD-Core Version:    0.7.0.1
 */