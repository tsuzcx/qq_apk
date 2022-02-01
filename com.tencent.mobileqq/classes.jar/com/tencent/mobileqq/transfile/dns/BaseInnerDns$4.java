package com.tencent.mobileqq.transfile.dns;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.HashMap;
import java.util.Map;

class BaseInnerDns$4
  implements Runnable
{
  BaseInnerDns$4(BaseInnerDns paramBaseInnerDns) {}
  
  public void run()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("syncAddressData called, mServerProcName=");
      ((StringBuilder)localObject1).append(BaseInnerDns.access$000(this.this$0));
      ((StringBuilder)localObject1).append(", mConnected=");
      ((StringBuilder)localObject1).append(BaseInnerDns.access$100(this.this$0));
      QLog.i("InnerDns", 1, ((StringBuilder)localObject1).toString());
    }
    if (BaseInnerDns.access$100(this.this$0)) {
      try
      {
        localObject1 = new Bundle();
        localObject1 = QIPCClientHelper.getInstance().getClient().callServer("InnerDnsModule", "syncAddressData", (Bundle)localObject1);
        if (((EIPCResult)localObject1).isSuccess())
        {
          localObject1 = ((EIPCResult)localObject1).data.getString("addressData");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            return;
          }
          localObject1 = BaseInnerDns.unParse((String)localObject1);
          if (localObject1 == null) {
            return;
          }
          try
          {
            BaseInnerDns.access$302(this.this$0, new HashMap((Map)localObject1));
            return;
          }
          finally {}
        }
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("syncAddressData fail, mServerProcName=");
        localStringBuilder1.append(BaseInnerDns.access$000(this.this$0));
        QLog.e("InnerDns", 1, localStringBuilder1.toString());
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("syncAddressData error:");
        localStringBuilder2.append(localThrowable.getMessage());
        QLog.e("InnerDns", 1, localStringBuilder2.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.dns.BaseInnerDns.4
 * JD-Core Version:    0.7.0.1
 */