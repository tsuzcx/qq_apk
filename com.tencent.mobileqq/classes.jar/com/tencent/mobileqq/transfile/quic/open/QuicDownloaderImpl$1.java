package com.tencent.mobileqq.transfile.quic.open;

import com.tencent.mobileqq.transfile.quic.internal.QuicDownloadRunnable;
import com.tencent.mobileqq.transfile.quic.internal.QuicDownloadTask;
import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport.Stats;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class QuicDownloaderImpl$1
  implements Runnable
{
  QuicDownloaderImpl$1(QuicDownloaderImpl paramQuicDownloaderImpl, String paramString1, DownloadListener paramDownloadListener, String paramString2, Map paramMap, String paramString3, int paramInt1, boolean paramBoolean, int paramInt2) {}
  
  public void run()
  {
    Long localLong = (Long)QuicDownloaderImpl.access$000(this.this$0).remove(this.val$path);
    if (this.val$listener.isCanceled())
    {
      if (QLog.isColorLevel()) {
        QLog.d("quic", 4, "task is canceled.");
      }
      return;
    }
    QuicDownloadRunnable localQuicDownloadRunnable = new QuicDownloadRunnable();
    QuicDownloadTask localQuicDownloadTask = new QuicDownloadTask(localQuicDownloadRunnable, this.val$path, this.val$savePath, this.val$headers, this.val$listener);
    localQuicDownloadTask.initDownloadFile();
    if (localLong != null) {
      localQuicDownloadTask.report.waitCost = (System.currentTimeMillis() - localLong.longValue());
    }
    localQuicDownloadTask.report.ip = this.val$ip;
    localQuicDownloadTask.report.port = this.val$port;
    if (this.this$0.mBuilder != null)
    {
      localQuicDownloadTask.report.isIpv6 = this.this$0.mBuilder.mIsIpv6;
      localQuicDownloadTask.report.businessId = this.this$0.mBuilder.mBussinessId;
      localQuicDownloadTask.report.timeOut = this.this$0.mBuilder.mTimeOut;
      localQuicDownloadTask.timeOut = this.this$0.mBuilder.mTimeOut;
    }
    try
    {
      if (QuicDownloader.sLastStats != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("quic", 2, "report stats: " + QuicDownloader.sLastStats.toString());
        }
        localQuicDownloadTask.report.lastStats = QuicDownloader.sLastStats;
        QuicDownloader.sLastStats = null;
      }
      localQuicDownloadTask.encryption = this.val$isQuicEncryption;
      localQuicDownloadTask.fec = this.val$fec;
      localQuicDownloadRunnable.enqueue(localQuicDownloadTask);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.open.QuicDownloaderImpl.1
 * JD-Core Version:    0.7.0.1
 */