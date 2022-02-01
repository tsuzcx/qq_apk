package com.tencent.mobileqq.filemanageraux.fileviewer.FileView;

import com.tencent.kwstudio.office.preview.IHostInterface.IDownloadListener;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

final class TdsReaderGlobal$NetEngineListener4Download
  implements INetEngineListener
{
  private final String a;
  private final IHostInterface.IDownloadListener b;
  
  private TdsReaderGlobal$NetEngineListener4Download(String paramString, IHostInterface.IDownloadListener paramIDownloadListener)
  {
    this.a = paramString;
    this.b = paramIDownloadListener;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3) {
      return;
    }
    int j = paramNetResp.mResult;
    int i = 0;
    boolean bool;
    if (j == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool) {
      i = paramNetResp.mErrCode;
    }
    IHostInterface.IDownloadListener localIDownloadListener = this.b;
    if (localIDownloadListener != null)
    {
      if (bool) {
        localIDownloadListener.onDownloadProgress(this.a, paramNetResp.mTotalFileLen, 1.0F);
      }
      this.b.onDownloadFinished(this.a, bool, i);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (paramLong2 != 0L)
    {
      float f = (float)paramLong1 / (float)paramLong2;
      paramNetReq = this.b;
      if (paramNetReq != null) {
        paramNetReq.onDownloadProgress(this.a, paramLong2, f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal.NetEngineListener4Download
 * JD-Core Version:    0.7.0.1
 */