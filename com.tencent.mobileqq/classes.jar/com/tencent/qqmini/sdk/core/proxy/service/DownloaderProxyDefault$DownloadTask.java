package com.tencent.qqmini.sdk.core.proxy.service;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;

public class DownloaderProxyDefault$DownloadTask
  implements Runnable
{
  public volatile boolean mAbort;
  public String mFilePath;
  public Map<String, String> mHeader;
  public DownloaderProxy.DownloadListener mListener;
  public int mTaskId;
  public int mTimeout;
  public String mUrl;
  private int redirectCount = 0;
  
  public DownloaderProxyDefault$DownloadTask(int paramInt1, String paramString1, Map<String, String> paramMap, String paramString2, int paramInt2, DownloaderProxy.DownloadListener paramDownloadListener)
  {
    this.mTaskId = paramString1;
    this.mUrl = paramMap;
    this.mHeader = paramString2;
    this.mFilePath = paramInt2;
    this.mTimeout = paramDownloadListener;
    Object localObject;
    this.mListener = localObject;
    this.mAbort = false;
  }
  
  private void doDownloadTask(File paramFile)
  {
    label393:
    for (;;)
    {
      HttpURLConnection localHttpURLConnection;
      int i;
      Object localObject1;
      DownloaderProxyDefault.DownloadTask.PositionFixedInputStream localPositionFixedInputStream;
      Object localObject2;
      int j;
      int k;
      try
      {
        localHttpURLConnection = getRealConnection(this.mUrl);
        if (localHttpURLConnection == null) {
          return;
        }
        i = localHttpURLConnection.getResponseCode();
        if ((i >= 200) && (i < 300))
        {
          localObject1 = new DownloaderProxyDefault.DownloadTask.PositionFixedInputStream(this, localHttpURLConnection.getInputStream());
          localPositionFixedInputStream = (DownloaderProxyDefault.DownloadTask.PositionFixedInputStream)localObject1;
          this.mListener.onDownloadHeadersReceived(i, localHttpURLConnection.getHeaderFields());
          localObject2 = localHttpURLConnection.getContentEncoding();
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).contains("gzip"))) {
            break label393;
          }
          localObject1 = new GZIPInputStream(localPositionFixedInputStream);
          j = localHttpURLConnection.getContentLength();
          paramFile = new FileOutputStream(paramFile);
          localObject2 = new byte[4096];
          k = ((InputStream)localObject1).read((byte[])localObject2);
          if (k == -1) {
            break label319;
          }
          if (!this.mAbort) {
            break label254;
          }
          ((InputStream)localObject1).close();
          paramFile.close();
        }
      }
      catch (IOException paramFile)
      {
        QMLog.e("DefaultDownloader", "io err", paramFile);
        this.this$0.taskMap.remove(Integer.valueOf(this.mTaskId));
        this.mListener.onDownloadFailed(-2, paramFile.getMessage());
        return;
        throw new DownloadException(i, "http server code indicates err status");
      }
      catch (DownloadException paramFile)
      {
        this.this$0.taskMap.remove(Integer.valueOf(this.mTaskId));
        this.mListener.onDownloadFailed(paramFile.getCode(), paramFile.getMessage());
        return;
      }
      label254:
      paramFile.write((byte[])localObject2, 0, k);
      if (j != -1)
      {
        this.mListener.onDownloadProgress(localPositionFixedInputStream.getPosition() * 1.0F / j, localPositionFixedInputStream.getPosition(), j);
      }
      else
      {
        this.mListener.onDownloadProgress(0.0F, localPositionFixedInputStream.getPosition(), 0L);
        continue;
        label319:
        ((InputStream)localObject1).close();
        paramFile.close();
        localHttpURLConnection.disconnect();
        this.this$0.taskMap.remove(Integer.valueOf(this.mTaskId));
        this.mListener.onDownloadSucceed(i, this.mFilePath, new DownloaderProxy.DownloadListener.DownloadResult("", 200L, true, "", true, 0L, 0L, 0L, 0L, 0L, 0L, localHttpURLConnection.getHeaderFields()));
        return;
      }
    }
  }
  
  private HttpURLConnection getRealConnection(String paramString)
  {
    HttpURLConnection localHttpURLConnection;
    int i;
    try
    {
      localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
      localHttpURLConnection.setConnectTimeout(this.mTimeout * 1000);
      localHttpURLConnection.setRequestMethod("GET");
      if (this.mHeader != null)
      {
        paramString = this.mHeader.keySet().iterator();
        while (paramString.hasNext())
        {
          String str = (String)paramString.next();
          localHttpURLConnection.setRequestProperty(str, (String)this.mHeader.get(str));
        }
      }
      if (i == 302) {
        break label213;
      }
    }
    catch (MalformedURLException paramString)
    {
      throw new DownloadException(-1, paramString.getMessage());
      i = localHttpURLConnection.getResponseCode();
      if (this.mAbort)
      {
        QMLog.i("DefaultDownloader", this.mUrl + " aborted");
        throw new DownloadException(-3, "aborted by outside");
      }
    }
    catch (Throwable paramString)
    {
      QMLog.e("DefaultDownloader", "unknown err", paramString);
      throw new DownloadException(-100, paramString.getMessage());
    }
    paramString = localHttpURLConnection;
    if (i == 301)
    {
      label213:
      this.redirectCount += 1;
      localHttpURLConnection.disconnect();
      if (this.redirectCount > 30)
      {
        QMLog.e("DefaultDownloader", "url: " + this.mUrl + "server redirects connection to many times");
        throw new DownloadException(-4, "url: " + this.mUrl + "server redirects connection to many times");
      }
      paramString = getRealConnection(localHttpURLConnection.getHeaderField("Location"));
    }
    return paramString;
  }
  
  public void run()
  {
    File localFile = new File(this.mFilePath);
    if (localFile.exists()) {
      localFile.delete();
    }
    try
    {
      if (!localFile.getParentFile().exists()) {
        localFile.getParentFile().mkdirs();
      }
      localFile.createNewFile();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
    doDownloadTask(localFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.DownloaderProxyDefault.DownloadTask
 * JD-Core Version:    0.7.0.1
 */