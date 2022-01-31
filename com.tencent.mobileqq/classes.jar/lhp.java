import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureActivity;
import com.tencent.mobileqq.richmedia.capture.view.SplitEffectsCameraCaptureView;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class lhp
  implements Runnable
{
  lhp(lho paramlho, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (ReadInJoyCameraCaptureActivity.a(this.jdField_a_of_type_Lho.a) == 5) {
        ReadInJoyCameraCaptureActivity.a(this.jdField_a_of_type_Lho.a, 2);
      }
      for (;;)
      {
        ReadInJoyCameraCaptureActivity.a(this.jdField_a_of_type_Lho.a, this.jdField_a_of_type_JavaLangString);
        ReadInJoyCameraCaptureActivity.a(this.jdField_a_of_type_Lho.a).setSourceVideoPath(this.jdField_a_of_type_JavaLangString);
        ReadInJoyCameraCaptureActivity.a(this.jdField_a_of_type_Lho.a).setVisibility(8);
        ReadInJoyCameraCaptureActivity.a(this.jdField_a_of_type_Lho.a).setVisibility(8);
        return;
        ReadInJoyCameraCaptureActivity.b(this.jdField_a_of_type_Lho.a, 2);
        ReadInJoyCameraCaptureActivity.a(this.jdField_a_of_type_Lho.a);
      }
    }
    QQToast.a(BaseApplication.getContext(), 1, 2131428448, 0).a(this.jdField_a_of_type_Lho.a.e()).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lhp
 * JD-Core Version:    0.7.0.1
 */