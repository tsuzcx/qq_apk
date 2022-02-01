package com.tencent.mobileqq.qwallet.hb.aio.impl;

import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils.AnsyListener;

class QQWalletHbItemApiImpl$1
  implements QwUtils.AnsyListener
{
  QQWalletHbItemApiImpl$1(QQWalletHbItemApiImpl paramQQWalletHbItemApiImpl) {}
  
  public void a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs.length > 0) && (paramVarArgs[0] != null))
    {
      QQWalletHbItemApiImpl.access$002(this.a, paramVarArgs[0]);
      return;
    }
    QLog.i("QQWalletHbItemApi", 2, "error get pskey...");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.QQWalletHbItemApiImpl.1
 * JD-Core Version:    0.7.0.1
 */