package cooperation.qqindividuality;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class QQIndividualityBridgeActivity$2
  implements DialogInterface.OnDismissListener
{
  QQIndividualityBridgeActivity$2(QQIndividualityBridgeActivity paramQQIndividualityBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.a) {
      QQIndividualityBridgeActivity.b(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "dialog dismiss: " + this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityBridgeActivity.2
 * JD-Core Version:    0.7.0.1
 */