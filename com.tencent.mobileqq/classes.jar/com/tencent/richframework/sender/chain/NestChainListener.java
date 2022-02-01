package com.tencent.richframework.sender.chain;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.Call.OnRspCallBack;

public class NestChainListener<Q>
  implements Call.OnRspCallBack<Q>
{
  public SenderChain a;
  
  public void a(boolean paramBoolean, long paramLong, String paramString, Q paramQ, Object paramObject, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("isSuccess");
    paramBundle.append(paramBoolean);
    paramBundle.append(" req");
    paramBundle.append(paramQ);
    QLog.d("NestChainListener", 1, paramBundle.toString());
    paramBundle = this.a;
    if (paramBundle != null)
    {
      paramBundle.a(paramBoolean, paramLong, paramString, paramQ, paramObject);
      return;
    }
    QLog.e("NestChainListener", 1, "senderChain is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.sender.chain.NestChainListener
 * JD-Core Version:    0.7.0.1
 */