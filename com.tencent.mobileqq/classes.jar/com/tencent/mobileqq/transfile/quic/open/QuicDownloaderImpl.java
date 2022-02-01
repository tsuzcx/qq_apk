package com.tencent.mobileqq.transfile.quic.open;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.quic.internal.QuicDownloadRunnable;
import com.tencent.mobileqq.transfile.quic.internal.Task;
import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class QuicDownloaderImpl
  extends QuicDownloader
{
  private ConcurrentHashMap<String, Long> mUrlQueueMap = new ConcurrentHashMap();
  
  private void taskCanceledCallback(QuicDownloader.Builder paramBuilder, String paramString1, String paramString2, String paramString3)
  {
    taskFailedCallback(paramBuilder, paramString1, paramString2, paramString3, 9);
  }
  
  private void taskDownloadingCallback(QuicDownloader.Builder paramBuilder, String paramString1, String paramString2, String paramString3)
  {
    taskFailedCallback(paramBuilder, paramString1, paramString2, paramString3, 8);
  }
  
  private void taskFailedCallback(QuicDownloader.Builder paramBuilder, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    taskFailedCallback(paramBuilder, paramString1, paramString2, paramString3, paramInt, "");
  }
  
  private void taskFailedCallback(QuicDownloader.Builder paramBuilder, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    DownloadListener localDownloadListener = paramBuilder.mDownloadListener;
    if (localDownloadListener != null)
    {
      QuicNetReport localQuicNetReport = new QuicNetReport();
      localQuicNetReport.channel = "quic";
      localQuicNetReport.tempPath = paramString3;
      localQuicNetReport.savePath = paramString1;
      localQuicNetReport.id = localQuicNetReport.tempPath.hashCode();
      localQuicNetReport.url = paramString2;
      localQuicNetReport.ip = paramBuilder.mIp;
      localQuicNetReport.errMsg = paramString4;
      localQuicNetReport.port = paramBuilder.mPort;
      localQuicNetReport.isIpv6 = paramBuilder.mIsIpv6;
      localQuicNetReport.rttHost = paramBuilder.mRttHost;
      localQuicNetReport.businessId = paramBuilder.mBussinessId;
      localQuicNetReport.timeOut = paramBuilder.mTimeOut;
      localQuicNetReport.failReason = paramInt;
      localDownloadListener.onDownloadFailed(paramString2, localQuicNetReport);
    }
  }
  
  public boolean download(QuicDownloader.Builder paramBuilder)
  {
    if (paramBuilder == null) {
      return false;
    }
    String str1 = paramBuilder.mSavePath;
    String str2 = paramBuilder.mPath;
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
      return false;
    }
    String str3 = Task.getTempPath(paramBuilder.mTempPath, str1, str2);
    if (TextUtils.isEmpty(str3)) {
      return false;
    }
    if (QuicDownloadRunnable.isExistTaskAddIfNeed(str3))
    {
      QLog.d("quic", 4, "task is running.");
      taskDownloadingCallback(paramBuilder, str1, str2, str3);
      return false;
    }
    this.mUrlQueueMap.put(str3, Long.valueOf(System.currentTimeMillis()));
    ThreadManagerV2.excute(new QuicDownloaderImpl.1(this, str3, paramBuilder, str1, str2), 128, null, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.open.QuicDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */