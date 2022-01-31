package com.tencent.qqmini.proxyimpl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

class DownloaderProxyImpl$1
  implements Callback
{
  private volatile boolean canceled;
  
  DownloaderProxyImpl$1(DownloaderProxyImpl paramDownloaderProxyImpl, String paramString1, DownloaderProxy.DownloadListener paramDownloadListener, String paramString2) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    QLog.e("DownloaderProxyImpl", 1, "httpConnect err url:" + this.val$url, paramIOException);
    if ("Canceled".equals(paramIOException.getLocalizedMessage()))
    {
      this.canceled = true;
      this.val$listener.onDownloadFailed(-5, "download error:cancel");
    }
    for (;;)
    {
      this.this$0.taskMap.remove(this.val$url);
      return;
      this.val$listener.onDownloadFailed(HttpUtil.getRetCodeFrom(paramIOException, -1), "request error:network");
    }
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if (this.canceled) {
      return;
    }
    int k = paramResponse.code();
    paramCall = paramResponse.headers().toMultimap();
    this.val$listener.onDownloadHeadersReceived(k, paramCall);
    Object localObject = new File(this.val$filePath);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    try
    {
      if (!((File)localObject).getParentFile().exists()) {
        ((File)localObject).getParentFile().mkdirs();
      }
      ((File)localObject).createNewFile();
    }
    catch (IOException localIOException)
    {
      int i;
      for (;;)
      {
        InputStream localInputStream;
        long l;
        this.val$listener.onDownloadFailed(2, "download error:local io exception");
        this.this$0.taskMap.remove(this.val$url);
      }
      localIOException.close();
      ((OutputStream)localObject).close();
      this.val$listener.onDownloadProgress(0.99F, i, i);
      this.val$listener.onDownloadSucceed(k, this.val$filePath, paramCall);
      this.this$0.taskMap.remove(this.val$url);
    }
    localInputStream = paramResponse.body().byteStream();
    localObject = new FileOutputStream((File)localObject);
    l = paramResponse.body().contentLength();
    paramResponse = new byte[4096];
    i = 0;
    for (;;)
    {
      int j = localInputStream.read(paramResponse);
      if (j == -1) {
        break;
      }
      ((OutputStream)localObject).write(paramResponse, 0, j);
      j = i + j;
      i = j;
      if (l > 0L)
      {
        this.val$listener.onDownloadProgress(j * 1.0F / (float)l, j, l);
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.DownloaderProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */