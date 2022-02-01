package com.tencent.tmdownloader.internal.downloadclient;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchSDKDownloadActionResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.SubScribeSDKDownloadTaskByViaResponse;

class d
  implements com.tencent.tmassistantsdk.internal.b.a
{
  d(c paramc) {}
  
  public void a()
  {
    ab.c(c.b(), "onDownloadSDKServiceInvalid yybOpenClient......");
    synchronized (this.a)
    {
      c.a(this.a, null);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayOfByte = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramArrayOfByte);
      JceStruct localJceStruct = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramArrayOfByte);
      String str = c.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("response.head.cmdId = ");
      localStringBuilder.append(paramArrayOfByte.head.cmdId);
      ab.c(str, localStringBuilder.toString());
      int i = paramArrayOfByte.head.cmdId;
      if (i != 10)
      {
        if (i != 13) {
          return;
        }
        ab.c("jimluo", "_BatchDownloadAction......");
        if (localJceStruct != null) {
          this.a.a((BatchSDKDownloadActionResponse)localJceStruct);
        }
      }
      else
      {
        ab.c("jimluo", "_SubScribeSDKDownloadTask......");
        if (localJceStruct != null) {
          this.a.a((SubScribeSDKDownloadTaskByViaResponse)localJceStruct);
        }
      }
    }
    else
    {
      ab.c(c.b(), "onActionResult reponseData = null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadclient.d
 * JD-Core Version:    0.7.0.1
 */