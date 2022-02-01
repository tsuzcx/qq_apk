package com.tencent.mobileqq.qwallet.hb.impl;

import com.tencent.mobileqq.qroute.route.Router.OnCompleteListener;
import com.tencent.qphone.base.util.QLog;

class QWalletHbApiImpl$2
  implements Router.OnCompleteListener
{
  QWalletHbApiImpl$2(QWalletHbApiImpl paramQWalletHbApiImpl) {}
  
  public void onError(int paramInt)
  {
    QLog.i("QWalletHbApi", 2, "start QrcodeHbGuiderActivity onError");
  }
  
  public void onSuccess()
  {
    QLog.i("QWalletHbApi", 2, "start QrcodeHbGuiderActivity onSuccess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.QWalletHbApiImpl.2
 * JD-Core Version:    0.7.0.1
 */