import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;

public class jxu
  implements Runnable
{
  public jxu(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void run()
  {
    this.a.b = "QQ电话";
    if (this.a.jdField_d_of_type_Int == 2) {
      if ("CREATE_FROM_CALL".equals(this.a.jdField_a_of_type_ComTencentAvVideoController.a().t))
      {
        this.a.b = "多人电话";
        this.a.b = this.a.a(this.a.b, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.jdField_d_of_type_Int, String.valueOf(this.a.jdField_a_of_type_Long)), this.a.jdField_d_of_type_AndroidWidgetTextView);
      }
    }
    for (;;)
    {
      this.a.jdField_d_of_type_AndroidWidgetTextView.setText(this.a.b);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.b);
      MultiVideoCtrlLayerUIBase localMultiVideoCtrlLayerUIBase = this.a;
      localMultiVideoCtrlLayerUIBase.g += 1;
      if (this.a.f != null)
      {
        if (this.a.g >= 3) {
          break label287;
        }
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.f, 1000L);
      }
      return;
      this.a.b = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.a.c, String.valueOf(this.a.jdField_a_of_type_Long), null);
      break;
      if (this.a.jdField_d_of_type_Int == 1) {
        this.a.b = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.a.c, String.valueOf(this.a.jdField_a_of_type_Long), null);
      }
    }
    label287:
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jxu
 * JD-Core Version:    0.7.0.1
 */