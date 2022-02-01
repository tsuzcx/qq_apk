package com.tencent.mobileqq.richstatus;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.ConcurrentHashMap;

class SignatureManagerForTool$2
  implements EIPCResultCallback
{
  SignatureManagerForTool$2(SignatureManagerForTool paramSignatureManagerForTool) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.data == null) {
      return;
    }
    int i = paramEIPCResult.data.getInt("notify_type");
    if (i != 6)
    {
      if (i != 7) {
        return;
      }
      if (paramEIPCResult.code == 0)
      {
        i = paramEIPCResult.data.getInt("id");
        this.a.a(i, true);
      }
    }
    else if (paramEIPCResult.code == 0)
    {
      i = paramEIPCResult.data.getInt("id");
      paramEIPCResult = paramEIPCResult.data.getString("url");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mSignatureManagerIPCCallback get action id = ");
        localStringBuilder.append(i);
        localStringBuilder.append(" url = ");
        localStringBuilder.append(paramEIPCResult);
        QLog.d("Signature.TOOL", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(paramEIPCResult))
      {
        SignatureManagerForTool.b(this.a).put(Integer.valueOf(i), paramEIPCResult);
        SignatureManagerForTool.b(this.a);
        this.a.notifyObservers(Integer.valueOf(4));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureManagerForTool.2
 * JD-Core Version:    0.7.0.1
 */