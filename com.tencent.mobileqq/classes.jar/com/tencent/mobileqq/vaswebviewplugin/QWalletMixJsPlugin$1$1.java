package com.tencent.mobileqq.vaswebviewplugin;

import Wallet.AcsDelMsgRsp;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class QWalletMixJsPlugin$1$1
  implements Runnable
{
  QWalletMixJsPlugin$1$1(QWalletMixJsPlugin.1 param1, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    try
    {
      if (this.val$type == 2001) {
        if (this.val$isSucc)
        {
          AcsDelMsgRsp localAcsDelMsgRsp = (AcsDelMsgRsp)this.val$bundle.getSerializable("rsp");
          if ((localAcsDelMsgRsp != null) && (localAcsDelMsgRsp.ret_code == 0))
          {
            QLog.i(QWalletMixJsPlugin.access$000(), 2, "@qqnotify req success ");
            QWalletMixJsPlugin.access$100(this.this$1.this$0, this.this$1.val$busiId, this.this$1.val$msgId);
            QWalletMixJsPlugin.access$200(this.this$1.this$0, 0);
            return;
          }
          QWalletMixJsPlugin.access$200(this.this$1.this$0, 1);
          if (localAcsDelMsgRsp != null)
          {
            String str = QWalletMixJsPlugin.access$000();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("@qqnotify ret_code =  ");
            localStringBuilder.append(localAcsDelMsgRsp.ret_code);
            QLog.i(str, 2, localStringBuilder.toString());
          }
        }
        else
        {
          QWalletMixJsPlugin.access$200(this.this$1.this$0, 2);
          QLog.i(QWalletMixJsPlugin.access$000(), 2, "@qqnotify delete faield not success  ");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(QWalletMixJsPlugin.access$000(), 1, "sendDelReminderListById onReceive", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */