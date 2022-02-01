package com.tencent.mobileqq.weiyun.sdk.download.processor;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.weiyun.api.download.DownloadServerInfoCallback;
import com.tencent.mobileqq.weiyun.model.DownloadFile;
import com.tencent.mobileqq.weiyun.model.DownloadJobContext;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

class UrlFetcher$1
  implements DownloadServerInfoCallback
{
  UrlFetcher$1(UrlFetcher paramUrlFetcher, String paramString, long paramLong, DownloadJobContext paramDownloadJobContext, int paramInt) {}
  
  public void a(DownloadFile paramDownloadFile, boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramDownloadFile != null)
    {
      if (!TextUtils.equals(this.a, paramDownloadFile.b)) {
        return;
      }
      if (paramBoolean)
      {
        if (paramDownloadFile.k == null)
        {
          UrlFetcher.a(this.e).a(this.b, 1810024, "");
          return;
        }
        UrlFetcher.a(this.e).a(this.b, paramDownloadFile.k);
        return;
      }
      if ((paramInt == 1002) && (!this.c.a()))
      {
        this.c.d(true);
        paramDownloadFile = Message.obtain();
        paramDownloadFile.what = 21;
        paramDownloadFile.obj = this.c;
        paramDownloadFile.arg1 = this.d;
        UrlFetcher.b(this.e).sendMessageDelayed(paramDownloadFile, 1000L);
        return;
      }
      UrlFetcher.a(this.e).a(this.b, paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.processor.UrlFetcher.1
 * JD-Core Version:    0.7.0.1
 */