package com.tencent.mobileqq.qqlive.filter.download;

import com.tencent.mobileqq.qqlive.filter.data.MetaMaterial;
import com.tencent.mobileqq.transfile.NetResp;

class QQLiveAEResDownloader$3
  implements QQLiveBaseDownloader.DownloadListener
{
  QQLiveAEResDownloader$3(QQLiveAEResDownloader paramQQLiveAEResDownloader, String paramString1, String paramString2, String paramString3, MetaMaterial paramMetaMaterial, ResDownLoadListener paramResDownLoadListener) {}
  
  public void a(int paramInt)
  {
    ResDownLoadListener localResDownLoadListener = this.e;
    if (localResDownLoadListener != null) {
      localResDownLoadListener.a(paramInt);
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    QQLiveAEResDownloader.a(this.f, this.a, paramNetResp, this.b, this.c, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.filter.download.QQLiveAEResDownloader.3
 * JD-Core Version:    0.7.0.1
 */