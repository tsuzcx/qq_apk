package com.tencent.mobileqq.qwallet.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils.AnsyListener;
import mqq.app.NewIntent;
import tencent.im.qqwallet.GdtAdServlet;
import tencent.im.qqwallet.QWalletPubAdReport.ReportReq;

class QWalletGdtAdApiImpl$3
  implements QwUtils.AnsyListener
{
  QWalletGdtAdApiImpl$3(QWalletGdtAdApiImpl paramQWalletGdtAdApiImpl, int paramInt, BaseQQAppInterface paramBaseQQAppInterface, long paramLong) {}
  
  public void a(int paramInt, String... paramVarArgs)
  {
    if (paramVarArgs.length > 0)
    {
      if (paramVarArgs[0] == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdApi", 2, "get getPskeyAsync success");
      }
      paramVarArgs = QWalletGdtAdApiImpl.access$900(this.d, paramVarArgs[0], this.a);
      NewIntent localNewIntent = new NewIntent(this.b.getApplication(), GdtAdServlet.class);
      localNewIntent.putExtra("cmd", "ReportSvc.Statistics");
      localNewIntent.putExtra("data", WupUtil.a(paramVarArgs.toByteArray()));
      localNewIntent.setObserver(new QWalletGdtAdApiImpl.3.1(this));
      this.b.startServlet(localNewIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletGdtAdApiImpl.3
 * JD-Core Version:    0.7.0.1
 */