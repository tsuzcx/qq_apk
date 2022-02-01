package cooperation.qwallet.plugin.impl;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPayApi;

class PayLogicImpl$3
  implements View.OnClickListener
{
  PayLogicImpl$3(PayLogicImpl paramPayLogicImpl, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.x)
    {
      paramView = ((IQWalletPayApi)QRoute.api(IQWalletPayApi.class)).getIdlePayData(this.this$0.isPCPushDesc);
      this.this$0.startPCPushPay(paramView);
      return;
    }
    if (paramView.getId() == R.id.w)
    {
      this.val$dialog.dismiss();
      ((IQWalletPayApi)QRoute.api(IQWalletPayApi.class)).clearAllPayData();
      this.this$0.end();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.PayLogicImpl.3
 * JD-Core Version:    0.7.0.1
 */