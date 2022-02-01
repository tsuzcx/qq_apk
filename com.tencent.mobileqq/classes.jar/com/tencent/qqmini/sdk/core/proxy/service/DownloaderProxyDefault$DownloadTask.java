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
    try
    {
      HttpURLConnection localHttpURLConnection = getRealConnection(this.mUrl);
      if (localHttpURLConnection == null) {
        return;
      }
      int i = localHttpURLConnection.getResponseCode();
      if ((i >= 200) && (i < 300))
      {
        Object localObject2 = new DownloaderProxyDefault.DownloadTask.PositionFixedInputStream(this, localHttpURLConnection.getInputStream());
        DownloaderProxyDefault.DownloadTask.PositionFixedInputStream localPositionFixedInputStream = (DownloaderProxyDefault.DownloadTask.PositionFixedInputStream)localObject2;
        this.mListener.onDownloadHeadersReceived(i, localHttpURLConnection.getHeaderFields());
        String str = localHttpURLConnection.getContentEncoding();
        Object localObject1 = localObject2;
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = localObject2;
          if (str.contains("gzip")) {
            localObject1 = new GZIPInputStream(localPositionFixedInputStream);
          }
        }
        int j = localHttpURLConnection.getContentLength();
        paramFile = new FileOutputStream(paramFile);
        localObject2 = new byte[4096];
        for (;;)
        {
          int k = ((InputStream)localObject1).read((byte[])localObject2);
          if (k == -1) {
            break;
          }
          if (this.mAbort)
          {
            ((InputStream)localObject1).close();
            paramFile.close();
            return;
          }
          paramFile.write((byte[])localObject2, 0, k);
          if (j != -1) {
            this.mListener.onDownloadProgress(localPositionFixedInputStream.getPosition() * 1.0F / j, localPositionFixedInputStream.getPosition(), j);
          } else {
            this.mListener.onDownloadProgress(0.0F, localPositionFixedInputStream.getPosition(), 0L);
          }
        }
        ((InputStream)localObject1).close();
        paramFile.close();
        localHttpURLConnection.disconnect();
        this.this$0.taskMap.remove(Integer.valueOf(this.mTaskId));
        this.mListener.onDownloadSucceed(i, this.mFilePath, new DownloaderProxy.DownloadListener.DownloadResult("", 200L, true, "", true, 0L, 0L, 0L, 0L, 0L, 0L, localHttpURLConnection.getHeaderFields()));
        return;
      }
      throw new DownloadException(i, "http server code indicates err status");
    }
    catch (DownloadException paramFile)
    {
      this.this$0.taskMap.remove(Integer.valueOf(this.mTaskId));
      this.mListener.onDownloadFailed(paramFile.getCode(), paramFile.getMessage());
      return;
    }
    catch (IOException paramFile)
    {
      QMLog.e("DefaultDownloader", "io err", paramFile);
      this.this$0.taskMap.remove(Integer.valueOf(this.mTaskId));
      this.mListener.onDownloadFailed(-2, paramFile.getMessage());
    }
  }
  
  private HttpURLConnection getRealConnection(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setRequestProperty("Accept-Encoding", "gzip, deflate");
      paramString.setConnectTimeout(this.mTimeout * 1000);
      paramString.setRequestMethod("GET");
      if (this.mHeader != null)
      {
        Iterator localIterator = this.mHeader.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramString.setRequestProperty(str, (String)this.mHeader.get(str));
        }
      }
      int i = paramString.getResponseCode();
      if (!this.mAbort)
      {
        if (i != 302) {
          if (i != 301) {
            return paramString;
          }
        }
        this.redirectCount += 1;
        paramString.disconnect();
        if (this.redirectCount <= 30) {
          return getRealConnection(paramString.getHeaderField("Location"));
        }
        paramString = new StringBuilder();
        paramString.append("url: ");
        paramString.append(this.mUrl);
        paramString.append("server redirects connection to many times");
        QMLog.e("DefaultDownloader", paramString.toString());
        paramString = new StringBuilder();
        paramString.append("url: ");
        paramString.append(this.mUrl);
        paramString.append("server redirects connection to many times");
        throw new DownloadException(-4, paramString.toString());
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(this.mUrl);
        paramString.append(" aborted");
        QMLog.i("DefaultDownloader", paramString.toString());
        throw new DownloadException(-3, "aborted by outside");
      }
    }
    catch (Throwable paramString)
    {
      QMLog.e("DefaultDownloader", "unknown err", paramString);
      throw new DownloadException(-100, paramString.getMessage());
    }
    catch (MalformedURLException paramString)
    {
      paramString = new DownloadException(-1, paramString.getMessage());
      for (;;)
      {
        throw paramString;
      }
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
      localIOException.printStackTrace();
    }
    doDownloadTask(localFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.DownloaderProxyDefault.DownloadTask
 * JD-Core Version:    0.7.0.1
 */