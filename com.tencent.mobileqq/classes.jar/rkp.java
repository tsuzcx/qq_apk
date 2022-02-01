import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;

public class rkp
  extends QIMEffectCameraCaptureUnit
{
  public rkp(boyn paramboyn, boym paramboym)
  {
    super(paramboyn, paramboym);
    this.jdField_a_of_type_Boyf = new boyf(10017, 106, 4);
  }
  
  public View a()
  {
    this.s = false;
    this.r = false;
    View localView = super.a();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(2);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    return localView;
  }
  
  protected baou a()
  {
    baou localbaou = super.a();
    localbaou.a(false);
    localbaou.l(2);
    localbaou.i(2);
    return localbaou;
  }
  
  public void a(baox parambaox)
  {
    Activity localActivity = this.jdField_a_of_type_Boyn.a();
    localActivity.startActivity(EditPicActivity.a(localActivity, parambaox.a, true, true, true, true, true, 8));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkp
 * JD-Core Version:    0.7.0.1
 */