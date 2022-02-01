package com.tencent.mobileqq.qwallet.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class QWalletAnimDialog$2
  extends BroadcastReceiver
{
  QWalletAnimDialog$2(QWalletAnimDialog paramQWalletAnimDialog) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getAction().equals("qwallet.facetoface"))) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.widget.QWalletAnimDialog.2
 * JD-Core Version:    0.7.0.1
 */