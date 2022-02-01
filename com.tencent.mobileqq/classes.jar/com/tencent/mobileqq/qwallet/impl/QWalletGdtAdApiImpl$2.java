package com.tencent.mobileqq.qwallet.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils.AnsyListener;
import mqq.app.NewIntent;
import tencent.im.qqwallet.QWalletPubAdReport.QueryReq;

class QWalletGdtAdApiImpl$2
  implements QwUtils.AnsyListener
{
  QWalletGdtAdApiImpl$2(QWalletGdtAdApiImpl paramQWalletGdtAdApiImpl, BaseQQAppInterface paramBaseQQAppInterface, long paramLong) {}
  
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
      paramVarArgs = QWalletGdtAdApiImpl.access$700(this.jdField_a_of_type_ComTencentMobileqqQwalletImplQWalletGdtAdApiImpl, paramVarArgs[0]);
      NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getApplication(), GdtAdServlet.class);
      localNewIntent.putExtra("cmd", "ReportSvc.Query");
      localNewIntent.putExtra("data", WupUtil.a(paramVarArgs.toByteArray()));
      localNewIntent.setObserver(new QWalletGdtAdApiImpl.2.1(this));
      this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.startServlet(localNewIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletGdtAdApiImpl.2
 * JD-Core Version:    0.7.0.1
 */