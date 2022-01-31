import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.qphone.base.util.QLog;

public class mft
  implements DialogInterface.OnClickListener
{
  public mft(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.g()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a.a().a() == -1) {
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.q(this.jdField_a_of_type_Long);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.d())
      {
        MultiVideoCtrlLayerUIBase.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase, true);
        this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.f(this.jdField_a_of_type_Long, 65535);
      }
      else if (QLog.isColorLevel())
      {
        QLog.e(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.c, 2, "PressCameraBtnRunnable-->go on stage fail,can not find the session");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mft
 * JD-Core Version:    0.7.0.1
 */