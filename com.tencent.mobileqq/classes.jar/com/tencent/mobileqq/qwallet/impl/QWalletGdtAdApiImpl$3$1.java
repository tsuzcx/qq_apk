package com.tencent.mobileqq.qwallet.impl;

import android.os.Bundle;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.qqwallet.QWalletPubAdReport.ReportRsp;

class QWalletGdtAdApiImpl$3$1
  implements BusinessObserver
{
  QWalletGdtAdApiImpl$3$1(QWalletGdtAdApiImpl.3 param3) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive:type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",bundle:");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append(",cost:");
      ((StringBuilder)localObject).append(NetConnInfoCenter.getServerTimeMillis() - this.a.c);
      QLog.d("QWalletGdtAdApi", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = paramBundle.getByteArray("data");
      if ((localObject != null) && (paramBoolean))
      {
        paramBundle = new QWalletPubAdReport.ReportRsp();
        paramBundle.mergeFrom((byte[])localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("doReqAdsStatistics onReceive: retCode:");
          ((StringBuilder)localObject).append(paramBundle.ret.get());
          ((StringBuilder)localObject).append(",msg:");
          ((StringBuilder)localObject).append(paramBundle.msg.get());
          QLog.i("QWalletGdtAdApi", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
    }
    catch (Throwable paramBundle)
    {
      QLog.e("QWalletGdtAdApi", 1, paramBundle, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletGdtAdApiImpl.3.1
 * JD-Core Version:    0.7.0.1
 */