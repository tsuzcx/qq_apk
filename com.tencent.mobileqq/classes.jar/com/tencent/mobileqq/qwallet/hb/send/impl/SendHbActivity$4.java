package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;

class SendHbActivity$4
  implements DialogInterface.OnClickListener
{
  SendHbActivity$4(SendHbActivity paramSendHbActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("hb_id", SendHbActivity.access$100(this.a));
    paramDialogInterface.putExtra("send_uin", SendHbActivity.access$200(this.a));
    paramDialogInterface.putExtra("hb_type", "1");
    paramDialogInterface.putExtra("forward_text", this.a.getString(R.string.U));
    if (SendHbActivity.access$300(this.a)) {
      paramDialogInterface.putExtra("item", 1);
    }
    paramDialogInterface.putExtra("forward_type", 17);
    paramDialogInterface.putExtra("invoke_from", "qwallet");
    ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).SendHbActivity$startForwardActivity(this.a, paramDialogInterface);
    paramDialogInterface = this.a;
    paramDialogInterface.addUploadData(SendHbActivity.access$200(paramDialogInterface), this.a.getProcessType(), "hongbao.wrapped.send", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.SendHbActivity.4
 * JD-Core Version:    0.7.0.1
 */