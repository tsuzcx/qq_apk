package com.tencent.mobileqq.qqlive.filter.download;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

class QQLiveBaseDownloader$InnerNetEngineDownloadListener
  implements INetEngineListener
{
  private String a;
  private String b;
  private QQLiveBaseDownloader.DownloadListener c;
  
  QQLiveBaseDownloader$InnerNetEngineDownloadListener(String paramString1, String paramString2, QQLiveBaseDownloader.DownloadListener paramDownloadListener)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramDownloadListener;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onResp url: ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" resultcode: ");
    ((StringBuilder)localObject).append(paramNetResp.mResult);
    QLog.d("QQLiveFilterDownloader", 4, ((StringBuilder)localObject).toString());
    localObject = this.c;
    if (localObject != null) {
      ((QQLiveBaseDownloader.DownloadListener)localObject).a(paramNetResp);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = this.c;
    if (paramNetReq != null) {
      paramNetReq.a((int)((float)paramLong1 / (float)paramLong2 * 100.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.filter.download.QQLiveBaseDownloader.InnerNetEngineDownloadListener
 * JD-Core Version:    0.7.0.1
 */