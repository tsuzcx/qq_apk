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
      ab.c(c.b(), "response.head.cmdId = " + paramArrayOfByte.head.cmdId);
      switch (paramArrayOfByte.head.cmdId)
      {
      }
      do
      {
        do
        {
          return;
          ab.c("jimluo", "_SubScribeSDKDownloadTask......");
        } while (localJceStruct == null);
        this.a.a((SubScribeSDKDownloadTaskByViaResponse)localJceStruct);
        return;
        ab.c("jimluo", "_BatchDownloadAction......");
      } while (localJceStruct == null);
      this.a.a((BatchSDKDownloadActionResponse)localJceStruct);
      return;
    }
    ab.c(c.b(), "onActionResult reponseData = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadclient.d
 * JD-Core Version:    0.7.0.1
 */