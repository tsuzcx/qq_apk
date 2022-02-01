package cooperation.qqindividuality;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class QQIndividualityBridgeActivity$1
  implements DialogInterface.OnDismissListener
{
  QQIndividualityBridgeActivity$1(QQIndividualityBridgeActivity paramQQIndividualityBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.a)
    {
      this.a.setResult(1001);
      QQIndividualityBridgeActivity.a(this.a);
    }
    if (QLog.isColorLevel())
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("dialog dismiss: ");
      paramDialogInterface.append(this.a.a);
      QLog.d("QQIndividuality", 2, paramDialogInterface.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityBridgeActivity.1
 * JD-Core Version:    0.7.0.1
 */