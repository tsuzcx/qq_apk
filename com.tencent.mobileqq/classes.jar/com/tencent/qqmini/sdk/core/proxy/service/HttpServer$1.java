package com.tencent.qqmini.sdk.core.proxy.service;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import besl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy.SenderListener;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy.RequestListener;
import java.util.List;
import java.util.Map;

final class HttpServer$1
  implements RequestProxy.RequestListener
{
  HttpServer$1(MiniAppProxy.SenderListener paramSenderListener) {}
  
  public void onRequestFailed(int paramInt, String paramString)
  {
    besl.b("HttpServer", "code = " + paramInt + ", errorMsg = " + paramString);
    if (this.val$listener != null) {
      this.val$listener.onReply(paramInt, null, paramString);
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
      if (this.val$listener != null) {
        this.val$listener.onReply(i, paramMap.toByteArray(), null);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.HttpServer.1
 * JD-Core Version:    0.7.0.1
 */