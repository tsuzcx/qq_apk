package cooperation.qwallet.plugin.impl;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager.PCPayData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PayLogicImpl$3
  implements View.OnClickListener
{
  PayLogicImpl$3(PayLogicImpl paramPayLogicImpl, Dialog paramDialog) {}
  
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
      QWalletPushManager.PCPayData localPCPayData = QWalletPushManager.a(this.this$0.isPCPushDesc);
      this.this$0.startPCPushPay(localPCPayData);
      continue;
      this.val$dialog.dismiss();
      QWalletPushManager.b();
      this.this$0.end();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.PayLogicImpl.3
 * JD-Core Version:    0.7.0.1
 */