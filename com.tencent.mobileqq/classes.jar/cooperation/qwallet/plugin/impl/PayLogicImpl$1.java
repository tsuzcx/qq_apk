package cooperation.qwallet.plugin.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class PayLogicImpl$1
  implements DialogInterface.OnClickListener
{
  PayLogicImpl$1(PayLogicImpl paramPayLogicImpl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    paramDialogInterface.dismiss();
    this.this$0.end();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.PayLogicImpl.1
 * JD-Core Version:    0.7.0.1
 */