package com.tencent.mobileqq.weiyun.sdk.download.processor;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.weiyun.api.download.IFetchListener;
import com.tencent.mobileqq.weiyun.model.DownloadFile;
import com.tencent.mobileqq.weiyun.model.DownloadJobContext;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

public class UrlFetcher
  implements Handler.Callback
{
  private final UrlFetcher.UrlFetcherCallback a;
  private final ReleaseLooperHandler b;
  private IFetchListener c;
  
  public UrlFetcher(UrlFetcher.UrlFetcherCallback paramUrlFetcherCallback, IFetchListener paramIFetchListener, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.a = paramUrlFetcherCallback;
    this.b = paramReleaseLooperHandler;
    this.b.addCallback(this);
    this.c = paramIFetchListener;
  }
  
  private void b(DownloadJobContext paramDownloadJobContext, int paramInt)
  {
    if (paramDownloadJobContext == null) {
      return;
    }
    long l = paramDownloadJobContext.h();
    String str = paramDownloadJobContext.c().b;
    if (paramDownloadJobContext.g()) {
      return;
    }
    this.c.a(paramDownloadJobContext.c().a(), paramInt, new UrlFetcher.1(this, str, l, paramDownloadJobContext, paramInt));
  }
  
  public void a(DownloadJobContext paramDownloadJobContext, int paramInt)
  {
    if (paramDownloadJobContext == null) {
      return;
    }
    this.b.sendMessage(Message.obtain(null, 21, paramInt, 0, paramDownloadJobContext));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 21)
    {
      b((DownloadJobContext)paramMessage.obj, paramMessage.arg1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.processor.UrlFetcher
 * JD-Core Version:    0.7.0.1
 */