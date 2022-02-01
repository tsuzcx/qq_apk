package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vip.DownloadTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class TaskStatus
{
  private String epId;
  private AtomicBoolean isCanceled = new AtomicBoolean();
  private float percent;
  private final DownloadTask task;
  
  public TaskStatus(String paramString, DownloadTask paramDownloadTask)
  {
    this.epId = paramString;
    this.task = paramDownloadTask;
  }
  
  public void cancel(AppInterface paramAppInterface)
  {
    this.isCanceled.set(true);
    Object localObject = this.task;
    if (localObject != null)
    {
      ((DownloadTask)localObject).a(true);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bqmall.android.h5magic.");
    ((StringBuilder)localObject).append(this.epId);
    ((StringBuilder)localObject).append(".zip");
    localObject = ((StringBuilder)localObject).toString();
    paramAppInterface = (IVasQuickUpdateService)paramAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    if (paramAppInterface != null) {
      paramAppInterface.cancelDwonloadItem(1004L, (String)localObject);
    }
  }
  
  public Bundle getParams(AppInterface paramAppInterface)
  {
    DownloadTask localDownloadTask = this.task;
    if (localDownloadTask != null) {
      return localDownloadTask.b();
    }
    return (Bundle)((IVasEmojiManager)((IEmosmService)QRoute.api(IEmosmService.class)).getVasEmojiManager(paramAppInterface)).getParamMap().get(this.epId);
  }
  
  public float getPercent()
  {
    DownloadTask localDownloadTask = this.task;
    if (localDownloadTask != null) {
      return localDownloadTask.l;
    }
    return this.percent;
  }
  
  public boolean isCancel()
  {
    return this.isCanceled.get();
  }
  
  public void setPercent(float paramFloat)
  {
    this.percent = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.TaskStatus
 * JD-Core Version:    0.7.0.1
 */