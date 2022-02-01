import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;

public class rbj
  extends QIMEffectCameraCaptureUnit
{
  public rbj(bqai parambqai, bqah parambqah)
  {
    super(parambqai, parambqah);
    this.jdField_a_of_type_Bqaa = new bqaa(10017, 106, 4);
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
  
  protected bbhn a()
  {
    bbhn localbbhn = super.a();
    localbbhn.a(false);
    localbbhn.l(2);
    localbbhn.i(2);
    return localbbhn;
  }
  
  public void a(bbhq parambbhq)
  {
    Activity localActivity = this.jdField_a_of_type_Bqai.a();
    localActivity.startActivity(EditPicActivity.a(localActivity, parambbhq.a, true, true, true, true, true, 8));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rbj
 * JD-Core Version:    0.7.0.1
 */