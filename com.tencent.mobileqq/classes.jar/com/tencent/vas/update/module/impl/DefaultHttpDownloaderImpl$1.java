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
    Object localObject = new Request.Builder().url(this.val$params.mUrl);
    File localFile = new File(this.val$params.mSavePath);
    if (localFile.exists())
    {
      long l = localFile.length();
      if (l != 0L) {
        ((Request.Builder)localObject).addHeader("RANGE", "bytes=" + l + "-");
      }
    }
    localObject = ((Request.Builder)localObject).get().build();
    if (VasUpdateWrapper.getLog().isColorLevel()) {
      VasUpdateWrapper.getLog().i("VasUpdate_HttpDownload", "start http download url = " + this.val$params.mUrl);
    }
    try
    {
      localObject = DefaultHttpDownloaderImpl.access$000(this.this$0).newCall((Request)localObject).execute();
      if (((Response)localObject).isSuccessful())
      {
        DefaultHttpDownloaderImpl.access$100(this.this$0, this.val$params, this.val$downloadListener, (Response)localObject);
        return;
      }
      this.val$downloadListener.onCompleted(this.val$params.mItemId, 8, ((Response)localObject).code(), "");
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      this.val$downloadListener.onCompleted(this.val$params.mItemId, 999, -1, localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.vas.update.module.impl.DefaultHttpDownloaderImpl.1
 * JD-Core Version:    0.7.0.1
 */