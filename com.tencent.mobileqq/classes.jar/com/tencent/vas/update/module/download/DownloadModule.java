package com.tencent.vas.update.module.download;

import com.tencent.vas.update.callback.IHttpDownloader;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.callback.listener.IDownloadListener;
import com.tencent.vas.update.callback.listener.ITaskDownloadCallback;
import com.tencent.vas.update.entity.DownloadInfoParams;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadModule
  implements IDownloadListener
{
  private static final String TAG = "VasUpdate_DownloadModule";
  private ConcurrentHashMap<String, ITaskDownloadCallback> mTaskCallback = new ConcurrentHashMap();
  
  public void onCompleted(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    ITaskDownloadCallback localITaskDownloadCallback = (ITaskDownloadCallback)this.mTaskCallback.get(paramString1);
    if (localITaskDownloadCallback != null)
    {
      localITaskDownloadCallback.notifyDownloadComplete(paramString1, paramInt1, paramInt2, paramString2);
      this.mTaskCallback.remove(paramString1);
    }
  }
  
  public void onDownloadStart(String paramString)
  {
    VasUpdateWrapper.getLog().i("VasUpdate_DownloadModule", "onDownloadStart itemId = " + paramString);
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    ITaskDownloadCallback localITaskDownloadCallback = (ITaskDownloadCallback)this.mTaskCallback.get(paramString);
    if (localITaskDownloadCallback != null) {
      localITaskDownloadCallback.notifyDownloadProgress(paramString, paramLong1, paramLong2, paramInt);
    }
  }
  
  public void startDownload(String paramString1, String paramString2, String paramString3, String paramString4, ITaskDownloadCallback paramITaskDownloadCallback)
  {
    this.mTaskCallback.put(paramString1, paramITaskDownloadCallback);
    paramITaskDownloadCallback = new DownloadInfoParams();
    paramITaskDownloadCallback.mItemId = paramString1;
    paramITaskDownloadCallback.mUrl = paramString2;
    paramITaskDownloadCallback.mFrom = paramString3;
    paramITaskDownloadCallback.mSavePath = paramString4;
    VasUpdateWrapper.getHttpDownloader().startDownload(paramITaskDownloadCallback, this, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.module.download.DownloadModule
 * JD-Core Version:    0.7.0.1
 */