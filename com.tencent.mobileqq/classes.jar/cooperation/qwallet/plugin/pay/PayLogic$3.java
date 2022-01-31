package cooperation.qwallet.plugin.pay;

import agxa;
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
    case 2131365142: 
      this.val$dialog.dismiss();
      paramView = agxa.a(this.this$0.isPCPushDesc);
      this.this$0.startPCPushPay(paramView);
      return;
    }
    this.val$dialog.dismiss();
    agxa.b();
    this.this$0.end();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qwallet.plugin.pay.PayLogic.3
 * JD-Core Version:    0.7.0.1
 */