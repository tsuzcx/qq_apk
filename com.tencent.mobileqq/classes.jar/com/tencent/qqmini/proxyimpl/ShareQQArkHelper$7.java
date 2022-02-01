package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.widget.QQProgressDialog;

final class ShareQQArkHelper$7
  implements Runnable
{
  ShareQQArkHelper$7(QQProgressDialog paramQQProgressDialog) {}
  
  public void run()
  {
    QQProgressDialog localQQProgressDialog = this.a;
    if (localQQProgressDialog != null) {
      localQQProgressDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareQQArkHelper.7
 * JD-Core Version:    0.7.0.1
 */