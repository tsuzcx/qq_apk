package com.tencent.vas.update.module.impl;

import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.callback.listener.IDownloadListener;
import com.tencent.vas.update.entity.DownloadInfoParams;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.io.File;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

class DefaultHttpDownloaderImpl$1
  implements Runnable
{
  DefaultHttpDownloaderImpl$1(DefaultHttpDownloaderImpl paramDefaultHttpDownloaderImpl, DownloadInfoParams paramDownloadInfoParams, IDownloadListener paramIDownloadListener) {}
  
  public void run()
  {
    Object localObject1 = new Request.Builder().url(this.val$params.mUrl);
    Object localObject2 = new File(this.val$params.mSavePath);
    if (((File)localObject2).exists())
    {
      long l = ((File)localObject2).length();
      if (l != 0L)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("bytes=");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append("-");
        ((Request.Builder)localObject1).addHeader("RANGE", ((StringBuilder)localObject2).toString());
      }
    }
    localObject1 = ((Request.Builder)localObject1).get().build();
    if (VasUpdateWrapper.getLog().isColorLevel())
    {
      localObject2 = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start http download url = ");
      localStringBuilder.append(this.val$params.mUrl);
      ((IVasLog)localObject2).i("VasUpdate_HttpDownload", localStringBuilder.toString());
    }
    try
    {
      localObject1 = DefaultHttpDownloaderImpl.access$000(this.this$0).newCall((Request)localObject1).execute();
      if (((Response)localObject1).isSuccessful())
      {
        DefaultHttpDownloaderImpl.access$100(this.this$0, this.val$params, this.val$downloadListener, (Response)localObject1);
        return;
      }
      this.val$downloadListener.onCompleted(this.val$params.mItemId, 8, ((Response)localObject1).code(), "");
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      this.val$downloadListener.onCompleted(this.val$params.mItemId, 999, -1, localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.module.impl.DefaultHttpDownloaderImpl.1
 * JD-Core Version:    0.7.0.1
 */