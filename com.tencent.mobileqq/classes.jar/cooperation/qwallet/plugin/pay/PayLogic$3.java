package cooperation.qwallet.plugin.pay;

import akyb;
import akyc;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PayLogic$3
  implements View.OnClickListener
{
  PayLogic$3(PayLogic paramPayLogic, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.val$dialog.dismiss();
      akyc localakyc = akyb.a(this.this$0.isPCPushDesc);
      this.this$0.startPCPushPay(localakyc);
      continue;
      this.val$dialog.dismiss();
      akyb.b();
      this.this$0.end();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.pay.PayLogic.3
 * JD-Core Version:    0.7.0.1
 */