package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.transfile.quic.open.QuicDownloader;
import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShortVideoDownloadProcessor$QuicDownloadListener
  implements DownloadListener
{
  public AtomicBoolean cancel = new AtomicBoolean(false);
  private WeakReference<ShortVideoDownloadProcessor> mVideoDownloadProcessor;
  
  public ShortVideoDownloadProcessor$QuicDownloadListener(ShortVideoDownloadProcessor paramShortVideoDownloadProcessor)
  {
    this.mVideoDownloadProcessor = new WeakReference(paramShortVideoDownloadProcessor);
  }
  
  public boolean isCanceled()
  {
    return this.cancel.get();
  }
  
  public void onDownloadFailed(String paramString, QuicNetReport paramQuicNetReport)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 4, "quic download failed. use http try again. errCode: " + paramQuicNetReport.errCode + " errMsg: " + paramQuicNetReport.errMsg + " ip: " + paramQuicNetReport.ip + " port: " + paramQuicNetReport.port);
    }
    if (this.cancel.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 4, "task canceled.");
      }
      return;
    }
    paramString = (ShortVideoDownloadProcessor)this.mVideoDownloadProcessor.get();
    if ((paramString == null) || (paramString.mNetReq == null))
    {
      paramQuicNetReport = new StringBuilder().append("shortVideoDownloadProcessor or netReq is null. processor: ");
      if (paramString == null) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.e("ShortVideoDownloadProcessor", 4, bool);
        return;
      }
    }
    paramQuicNetReport.stats = QuicDownloader.saveNetStats(paramQuicNetReport);
    paramString.mQuicNetReport = paramQuicNetReport;
    paramString.mNetEngine.sendReq(paramString.mNetReq);
  }
  
  public void onDownloadProgress(String paramString, long paramLong1, long paramLong2)
  {
    if (this.cancel.get()) {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 4, "task canceled.");
      }
    }
    do
    {
      return;
      paramString = (ShortVideoDownloadProcessor)this.mVideoDownloadProcessor.get();
      if ((paramString == null) || (paramString.mNetReq == null))
      {
        StringBuilder localStringBuilder = new StringBuilder().append("shortVideoDownloadProcessor or netReq is null. processor: ");
        if (paramString == null) {}
        for (boolean bool = true;; bool = false)
        {
          QLog.e("ShortVideoDownloadProcessor", 4, bool);
          return;
        }
      }
      paramString = paramString.mNetReq;
    } while (paramString.mCallback == null);
    paramString.mCallback.onUpdateProgeress(paramString, paramLong2, paramLong1);
  }
  
  public void onDownloadSucceed(String paramString, QuicNetReport paramQuicNetReport)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "quic download cost time: " + paramQuicNetReport.totaltime + " waitTime: " + paramQuicNetReport.waitCost + "  firstCostTime: " + paramQuicNetReport.firstPackageCost);
    }
    if (this.cancel.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 4, "task canceled.");
      }
      return;
    }
    paramString = (ShortVideoDownloadProcessor)this.mVideoDownloadProcessor.get();
    if ((paramString == null) || (paramString.mNetReq == null))
    {
      paramQuicNetReport = new StringBuilder().append("shortVideoDownloadProcessor or netReq is null. processor: ");
      if (paramString == null) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.e("ShortVideoDownloadProcessor", 4, bool);
        return;
      }
    }
    paramQuicNetReport.stats = QuicDownloader.saveNetStats(paramQuicNetReport);
    paramQuicNetReport.success = true;
    paramString.mQuicNetReport = paramQuicNetReport;
    paramString.quicDownloadSuc(paramQuicNetReport, (HttpNetReq)paramString.mNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor.QuicDownloadListener
 * JD-Core Version:    0.7.0.1
 */