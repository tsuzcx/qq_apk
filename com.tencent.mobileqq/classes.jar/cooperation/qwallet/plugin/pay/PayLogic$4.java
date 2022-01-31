package cooperation.qwallet.plugin.pay;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class PayLogic$4
  implements DialogInterface.OnDismissListener
{
  PayLogic$4(PayLogic paramPayLogic) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qwallet.pay.PayLogic", 4, "finish dialog dismiss...");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qwallet.plugin.pay.PayLogic.4
 * JD-Core Version:    0.7.0.1
 */