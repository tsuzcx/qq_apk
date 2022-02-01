package com.tencent.mobileqq.weiyun.sdk.download;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.weiyun.api.download.IDownloadListener;

class WyDownloader$4
  implements INetEngineListener
{
  WyDownloader$4(WyDownloader paramWyDownloader, IDownloadListener paramIDownloadListener, String paramString1, String paramString2) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3) {
      return;
    }
    boolean bool;
    if (paramNetResp.mResult == 0) {
      bool = true;
    } else {
      bool = false;
    }
    int i = paramNetResp.mErrCode;
    this.a.a(this.b, this.c, bool, paramNetResp.mErrDesc, i);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.a.a(this.b, paramLong2, (float)paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.WyDownloader.4
 * JD-Core Version:    0.7.0.1
 */