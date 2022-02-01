package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import mqq.observer.BusinessObserver;

class QWalletMixJsPlugin$1
  implements BusinessObserver
{
  QWalletMixJsPlugin$1(QWalletMixJsPlugin paramQWalletMixJsPlugin, Handler paramHandler, String paramString1, String paramString2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.val$mHandler.post(new QWalletMixJsPlugin.1.1(this, paramInt, paramBoolean, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */