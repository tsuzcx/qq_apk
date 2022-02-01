package cooperation.qwallet.plugin.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class PayLogicImpl$4
  implements DialogInterface.OnDismissListener
{
  PayLogicImpl$4(PayLogicImpl paramPayLogicImpl) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qwallet.pay.PayLogic", 4, "finish dialog dismiss...");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.PayLogicImpl.4
 * JD-Core Version:    0.7.0.1
 */