package com.tencent.mobileqq.transfile.dns;

import android.os.Bundle;
import android.text.TextUtils;
import bazo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.HashMap;
import java.util.Map;

public class InnerDns$4
  implements Runnable
{
  public InnerDns$4(bazo parambazo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("InnerDns", 1, "syncAddressData called, mServerProcName=" + bazo.a(this.this$0) + ", mConnected=" + bazo.a(this.this$0));
    }
    if (bazo.a(this.this$0)) {
      try
      {
        Object localObject1 = new Bundle();
        localObject1 = QIPCClientHelper.getInstance().getClient().callServer("InnerDnsModule", "syncAddressData", (Bundle)localObject1);
        if (((EIPCResult)localObject1).isSuccess())
        {
          localObject1 = ((EIPCResult)localObject1).data.getString("addressData");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            return;
          }
          localObject1 = bazo.a((String)localObject1);
          if (localObject1 == null) {
            return;
          }
          try
          {
            bazo.a(this.this$0, new HashMap((Map)localObject1));
            return;
          }
          finally {}
        }
        QLog.e("InnerDns", 1, "syncAddressData fail, mServerProcName=" + bazo.a(this.this$0));
      }
      catch (Throwable localThrowable)
      {
        QLog.e("InnerDns", 1, "syncAddressData error:" + localThrowable.getMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.dns.InnerDns.4
 * JD-Core Version:    0.7.0.1
 */