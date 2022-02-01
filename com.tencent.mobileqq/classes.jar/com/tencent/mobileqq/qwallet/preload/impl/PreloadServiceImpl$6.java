package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.DownloadCallback;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

class PreloadServiceImpl$6
  extends DownloadListener
{
  PreloadServiceImpl$6(PreloadServiceImpl paramPreloadServiceImpl, IPreloadService.DownloadCallback paramDownloadCallback) {}
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    super.onDoneFile(paramDownloadTask);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadRes|done");
      ((StringBuilder)localObject).append(paramDownloadTask.b);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramDownloadTask.c);
      QLog.d("PreloadService", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramDownloadTask.b();
    PreloadModuleImpl localPreloadModuleImpl = (PreloadModuleImpl)((Bundle)localObject).getSerializable("module");
    localObject = (PreloadResourceImpl)((Bundle)localObject).getSerializable("resource");
    int j = paramDownloadTask.c;
    int i = -5;
    if (j == 0) {
      i = 0;
    } else if (paramDownloadTask.c != -5) {
      i = -6;
    }
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((PreloadResourceImpl)localObject).getResInfo(localPreloadModuleImpl);
    }
    this.a.onDownloadResFinished(localPreloadModuleImpl.mid, i, ((File)paramDownloadTask.g.get(paramDownloadTask.b)).getAbsolutePath(), (ResourceInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.6
 * JD-Core Version:    0.7.0.1
 */