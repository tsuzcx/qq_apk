import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;

public class ptr
  extends QIMEffectCameraCaptureUnit
{
  public ptr(bhzc parambhzc, bhzb parambhzb)
  {
    super(parambhzc, parambhzb);
    this.jdField_a_of_type_Bhyu = new bhyu(10017, 106, 4);
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
  
  protected auuv a()
  {
    auuv localauuv = super.a();
    localauuv.a(false);
    localauuv.l(2);
    localauuv.i(2);
    return localauuv;
  }
  
  public void a(auuy paramauuy)
  {
    Activity localActivity = this.jdField_a_of_type_Bhzc.a();
    localActivity.startActivity(EditPicActivity.a(localActivity, paramauuy.a, true, true, true, true, true, 8));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ptr
 * JD-Core Version:    0.7.0.1
 */