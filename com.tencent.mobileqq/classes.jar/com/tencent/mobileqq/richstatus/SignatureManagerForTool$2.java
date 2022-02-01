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
    if (paramEIPCResult.data == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramEIPCResult.data.getInt("notify_type"))
          {
          default: 
            return;
          }
        } while (paramEIPCResult.code != 0);
        i = paramEIPCResult.data.getInt("id");
        paramEIPCResult = paramEIPCResult.data.getString("url");
        if (QLog.isColorLevel()) {
          QLog.d("Signature.TOOL", 2, "mSignatureManagerIPCCallback get action id = " + i + " url = " + paramEIPCResult);
        }
      } while (TextUtils.isEmpty(paramEIPCResult));
      SignatureManagerForTool.b(this.a).put(Integer.valueOf(i), paramEIPCResult);
      SignatureManagerForTool.b(this.a);
      this.a.notifyObservers(Integer.valueOf(4));
      return;
    } while (paramEIPCResult.code != 0);
    int i = paramEIPCResult.data.getInt("id");
    this.a.a(i, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureManagerForTool.2
 * JD-Core Version:    0.7.0.1
 */