package com.tencent.vas.update.module.impl;

import com.tencent.vas.update.callback.listener.IDownloadListener;
import com.tencent.vas.update.callback.listener.ITaskDownloadCallback;
import com.tencent.vas.update.entity.DownloadInfoParams;
import com.tencent.vas.update.factory.api.IHttpDownloader;
import com.tencent.vas.update.factory.api.IVasLog;
import com.tencent.vas.update.module.api.IDownloadModule;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadModuleImpl
  implements IDownloadListener, IDownloadModule
{
  private ConcurrentHashMap<String, ITaskDownloadCallback> a = new ConcurrentHashMap();
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, ITaskDownloadCallback paramITaskDownloadCallback)
  {
    this.a.put(paramString1, paramITaskDownloadCallback);
    paramITaskDownloadCallback = new DownloadInfoParams();
    paramITaskDownloadCallback.mItemId = paramString1;
    paramITaskDownloadCallback.mUrl = paramString2;
    paramITaskDownloadCallback.mFrom = paramString3;
    paramITaskDownloadCallback.mSavePath = paramString4;
    VasUpdateWrapper.getHttpDownloader().a(paramITaskDownloadCallback, this, null);
  }
  
  public void onCompleted(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    ITaskDownloadCallback localITaskDownloadCallback = (ITaskDownloadCallback)this.a.get(paramString1);
    if (localITaskDownloadCallback != null)
    {
      localITaskDownloadCallback.notifyDownloadComplete(paramString1, paramInt1, paramInt2, paramString2);
      this.a.remove(paramString1);
    }
  }
  
  public void onDownloadStart(String paramString)
  {
    IVasLog localIVasLog = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadStart itemId = ");
    localStringBuilder.append(paramString);
    localIVasLog.b("VasUpdate_DownloadModule", localStringBuilder.toString());
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    ITaskDownloadCallback localITaskDownloadCallback = (ITaskDownloadCallback)this.a.get(paramString);
    if (localITaskDownloadCallback != null) {
      localITaskDownloadCallback.notifyDownloadProgress(paramString, paramLong1, paramLong2, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.module.impl.DownloadModuleImpl
 * JD-Core Version:    0.7.0.1
 */