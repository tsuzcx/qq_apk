package com.tencent.mobileqq.qwallet.impl;

import android.os.Bundle;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.qqwallet.QWalletPubAdReport.QueryRsp;

class QWalletGdtAdApiImpl$2$1
  implements BusinessObserver
{
  QWalletGdtAdApiImpl$2$1(QWalletGdtAdApiImpl.2 param2) {}
  
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
      ((StringBuilder)localObject).append(NetConnInfoCenter.getServerTimeMillis() - this.a.b);
      QLog.d("QWalletGdtAdApi", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = paramBundle.getByteArray("data");
      if ((localObject != null) && (paramBoolean))
      {
        paramBundle = new QWalletPubAdReport.QueryRsp();
        paramBundle.mergeFrom((byte[])localObject);
        paramInt = paramBundle.ret.get();
        if (paramInt == 0)
        {
          QWalletGdtAdApiImpl.access$302(this.a.c, paramBundle.pv_flag.get());
          QWalletGdtAdApiImpl.access$800(this.a.c, paramBundle);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("doReqAdsControl onReceive: retCode:");
            ((StringBuilder)localObject).append(paramBundle.ret.get());
            ((StringBuilder)localObject).append(",msg:");
            ((StringBuilder)localObject).append(paramBundle.msg.get());
            QLog.i("QWalletGdtAdApi", 2, ((StringBuilder)localObject).toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("onReceive fail,retCode:");
          paramBundle.append(paramInt);
          QLog.e("QWalletGdtAdApi", 2, paramBundle.toString());
          return;
        }
      }
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive fail exception:");
      ((StringBuilder)localObject).append(paramBundle.getMessage());
      QLog.e("QWalletGdtAdApi", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletGdtAdApiImpl.2.1
 * JD-Core Version:    0.7.0.1
 */