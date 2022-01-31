import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;

public class qfp
  extends QIMEffectCameraCaptureUnit
{
  public qfp(bjqu parambjqu, bjqt parambjqt)
  {
    super(parambjqu, parambjqt);
    this.jdField_a_of_type_Bjqm = new bjqm(10017, 106, 4);
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
  
  protected avuj a()
  {
    avuj localavuj = super.a();
    localavuj.a(false);
    localavuj.l(2);
    localavuj.i(2);
    return localavuj;
  }
  
  public void a(avum paramavum)
  {
    Activity localActivity = this.jdField_a_of_type_Bjqu.a();
    localActivity.startActivity(EditPicActivity.a(localActivity, paramavum.a, true, true, true, true, true, 8));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qfp
 * JD-Core Version:    0.7.0.1
 */