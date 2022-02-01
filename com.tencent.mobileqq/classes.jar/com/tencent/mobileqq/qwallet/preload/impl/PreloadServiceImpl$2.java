package com.tencent.mobileqq.qwallet.preload.impl;

import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;

class PreloadServiceImpl$2
  extends DownloadListener
{
  PreloadServiceImpl$2(PreloadServiceImpl paramPreloadServiceImpl, DownloadParam paramDownloadParam, IPreloadService.OnGetPathListener paramOnGetPathListener, WeakReference paramWeakReference) {}
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    super.onDoneFile(paramDownloadTask);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("RealTime onDoneFile|");
      ((StringBuilder)localObject1).append(paramDownloadTask.c);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(paramDownloadTask.b);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(((File)paramDownloadTask.g.get(paramDownloadTask.b)).getAbsolutePath());
      QLog.d("PreloadService", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    if ((paramDownloadTask.c == 0) && (paramDownloadTask.g != null) && (!TextUtils.isEmpty(paramDownloadTask.b)))
    {
      localObject2 = (File)paramDownloadTask.g.get(paramDownloadTask.b);
      if (localObject2 == null) {
        localObject1 = "";
      } else {
        localObject1 = ((File)localObject2).getAbsolutePath();
      }
      localObject1 = MD5Coding.encodeFile2HexStr((String)localObject1);
      if ((localObject2 != null) && (((File)localObject2).exists()) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        if ((!TextUtils.isEmpty(this.a.md5ForChecked)) && (!this.a.md5ForChecked.equalsIgnoreCase((String)localObject1)))
        {
          localObject1 = this.b;
          if (localObject1 != null) {
            ((IPreloadService.OnGetPathListener)localObject1).onResult(2, IPreloadService.PathResult.getFailRes(paramDownloadTask.b));
          }
          PreloadStaticApi.a(paramDownloadTask.b, false, this.a.filePos);
          return;
        }
        ResUtil.a(paramDownloadTask.b, (String)localObject1, NetConnInfoCenter.getServerTimeMillis(), this.a.filePos);
      }
    }
    if (!PreloadServiceImpl.isManagerValid((PreloadServiceImpl)this.c.get())) {
      return;
    }
    if (paramDownloadTask.c == 0)
    {
      localObject2 = ResUtil.a(paramDownloadTask.b, this.a.isForceUnzip, 0, this.a.filePos);
      localObject1 = new IPreloadService.PathResult();
      ((IPreloadService.PathResult)localObject1).url = paramDownloadTask.b;
      ((IPreloadService.PathResult)localObject1).filePath = ((ResourceInfo)localObject2).filePath;
      ((IPreloadService.PathResult)localObject1).folderPath = ((ResourceInfo)localObject2).folderPath;
      paramDownloadTask = this.b;
      if (paramDownloadTask != null) {
        paramDownloadTask.onResult(0, (IPreloadService.PathResult)localObject1);
      }
    }
    else
    {
      localObject1 = this.b;
      if (localObject1 != null) {
        ((IPreloadService.OnGetPathListener)localObject1).onResult(1, IPreloadService.PathResult.getFailRes(paramDownloadTask.b, paramDownloadTask.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */