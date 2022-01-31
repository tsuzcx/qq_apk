import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;

public class qps
  extends QIMEffectCameraCaptureUnit
{
  public qps(bmhh parambmhh, bmhg parambmhg)
  {
    super(parambmhh, parambmhg);
    this.jdField_a_of_type_Bmgz = new bmgz(10017, 106, 4);
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
  
  protected axqt a()
  {
    axqt localaxqt = super.a();
    localaxqt.a(false);
    localaxqt.l(2);
    localaxqt.i(2);
    return localaxqt;
  }
  
  public void a(axqw paramaxqw)
  {
    Activity localActivity = this.jdField_a_of_type_Bmhh.a();
    localActivity.startActivity(EditPicActivity.a(localActivity, paramaxqw.a, true, true, true, true, true, 8));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qps
 * JD-Core Version:    0.7.0.1
 */