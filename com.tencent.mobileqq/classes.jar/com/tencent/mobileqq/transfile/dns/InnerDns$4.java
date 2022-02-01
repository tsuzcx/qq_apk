package com.tencent.mobileqq.transfile.dns;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.HashMap;
import java.util.Map;

class InnerDns$4
  implements Runnable
{
  InnerDns$4(InnerDns paramInnerDns) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("InnerDns", 1, "syncAddressData called, mServerProcName=" + InnerDns.access$000(this.this$0) + ", mConnected=" + InnerDns.access$100(this.this$0));
    }
    if (InnerDns.access$100(this.this$0)) {
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
          localObject1 = InnerDns.unParse((String)localObject1);
          if (localObject1 == null) {
            return;
          }
          try
          {
            InnerDns.access$302(this.this$0, new HashMap((Map)localObject1));
            return;
          }
          finally {}
        }
        QLog.e("InnerDns", 1, "syncAddressData fail, mServerProcName=" + InnerDns.access$000(this.this$0));
      }
      catch (Throwable localThrowable)
      {
        QLog.e("InnerDns", 1, "syncAddressData error:" + localThrowable.getMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.dns.InnerDns.4
 * JD-Core Version:    0.7.0.1
 */