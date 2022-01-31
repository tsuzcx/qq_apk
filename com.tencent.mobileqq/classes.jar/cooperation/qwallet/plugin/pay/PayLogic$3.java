package cooperation.qwallet.plugin.pay;

import aivm;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class PayLogic$3
  implements View.OnClickListener
{
  PayLogic$3(PayLogic paramPayLogic, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131365228: 
      this.val$dialog.dismiss();
      paramView = aivm.a(this.this$0.isPCPushDesc);
      this.this$0.startPCPushPay(paramView);
      return;
    }
    this.val$dialog.dismiss();
    aivm.b();
    this.this$0.end();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qwallet.plugin.pay.PayLogic.3
 * JD-Core Version:    0.7.0.1
 */