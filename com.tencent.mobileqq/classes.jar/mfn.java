import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class mfn
  implements DialogInterface.OnClickListener
{
  public mfn(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion, VideoAppInterface paramVideoAppInterface, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.w(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.c, 1, "showConfirmBoxToHangup, yes, mRelationId[" + this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.b + "]");
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.k(0L);
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("uin", String.valueOf(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.b));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4, 0, 0, paramDialogInterface, null);
    if (!bbfu.a(this.jdField_a_of_type_Int)) {
      mpy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.b), 3000, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695925));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mfn
 * JD-Core Version:    0.7.0.1
 */