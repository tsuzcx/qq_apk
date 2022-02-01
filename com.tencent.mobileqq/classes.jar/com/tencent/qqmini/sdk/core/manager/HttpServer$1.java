package com.tencent.qqmini.sdk.core.manager;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.SenderListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import java.util.Map;

final class HttpServer$1
  implements RequestProxy.RequestListener
{
  HttpServer$1(MiniAppProxy.SenderListener paramSenderListener) {}
  
  public void onRequestFailed(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("code = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", errorMsg = ");
    ((StringBuilder)localObject).append(paramString);
    QMLog.i("HttpServer", ((StringBuilder)localObject).toString());
    localObject = this.val$listener;
    if (localObject != null) {
      ((MiniAppProxy.SenderListener)localObject).onReply(paramInt, null, paramString);
    }
  }
  
  public void onRequestHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onRequestSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    int i = paramInt;
    if (paramInt == 200) {
      i = 0;
    }
    paramMap = new PROTOCAL.StQWebRsp();
    try
    {
      paramMap.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    paramArrayOfByte = this.val$listener;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.onReply(i, paramMap.toByteArray(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.HttpServer.1
 * JD-Core Version:    0.7.0.1
 */