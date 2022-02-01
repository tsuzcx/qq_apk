package com.tencent.mobileqq.transfile.quic.open;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.quic.internal.QuicDownloadRunnable;
import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QuicDownloaderImpl
  extends QuicDownloader
{
  private ConcurrentHashMap<String, Long> mUrlQueueMap = new ConcurrentHashMap();
  
  public boolean download(String paramString1, int paramInt1, String paramString2, String paramString3, boolean paramBoolean, int paramInt2, Map<String, String> paramMap, DownloadListener paramDownloadListener)
  {
    if ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    if (QuicDownloadRunnable.isExistTask(paramString2))
    {
      QLog.d("quic", 4, "task is running.");
      return false;
    }
    this.mUrlQueueMap.put(paramString2, Long.valueOf(System.currentTimeMillis()));
    ThreadManagerV2.excute(new QuicDownloaderImpl.1(this, paramString2, paramDownloadListener, paramString3, paramMap, paramString1, paramInt1, paramBoolean, paramInt2), 128, null, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.open.QuicDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */