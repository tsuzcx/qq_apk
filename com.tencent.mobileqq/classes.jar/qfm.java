import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;

public class qfm
  extends QIMEffectCameraCaptureUnit
{
  public qfm(bjrl parambjrl, bjrk parambjrk)
  {
    super(parambjrl, parambjrk);
    this.jdField_a_of_type_Bjrd = new bjrd(10017, 106, 4);
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
  
  protected avul a()
  {
    avul localavul = super.a();
    localavul.a(false);
    localavul.l(2);
    localavul.i(2);
    return localavul;
  }
  
  public void a(avuo paramavuo)
  {
    Activity localActivity = this.jdField_a_of_type_Bjrl.a();
    localActivity.startActivity(EditPicActivity.a(localActivity, paramavuo.a, true, true, true, true, true, 8));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qfm
 * JD-Core Version:    0.7.0.1
 */