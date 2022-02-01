package com.yolo.esports.download.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.timi.game.ui.pag.TimiPAGResourceLoader;
import com.tencent.timi.game.utils.Logger;
import com.yolo.esports.download.IDownloadService;
import com.yolo.esports.download.cb.DownloadTaskListener;
import com.yolo.esports.download.cb.TaskCallbackCenter;
import com.yolo.esports.download.common.DownloadInfo;
import com.yolo.esports.download.common.HalleyDownloaderProxy;
import org.jetbrains.annotations.NotNull;

public class DownloadServiceImpl
  implements IDownloadService
{
  private HalleyDownloaderProxy a;
  
  private void a(DownloadInfo paramDownloadInfo1, DownloadInfo paramDownloadInfo2)
  {
    paramDownloadInfo2.p = paramDownloadInfo1.p;
    paramDownloadInfo2.n = paramDownloadInfo1.n;
    if (!TextUtils.isEmpty(paramDownloadInfo1.c)) {
      paramDownloadInfo2.c = paramDownloadInfo1.c;
    }
    if (!TextUtils.isEmpty(paramDownloadInfo1.r)) {
      paramDownloadInfo2.r = paramDownloadInfo1.r;
    }
    if ((!TextUtils.isEmpty(paramDownloadInfo1.o)) && (TextUtils.isEmpty(paramDownloadInfo2.o))) {
      paramDownloadInfo2.o = paramDownloadInfo1.o;
    }
  }
  
  public int a(@NotNull DownloadInfo paramDownloadInfo)
  {
    return a(paramDownloadInfo, false);
  }
  
  public int a(@NotNull DownloadInfo paramDownloadInfo, boolean paramBoolean)
  {
    Object localObject = paramDownloadInfo.a();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return -100;
    }
    localObject = this.a.b((String)localObject);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[startDownload] new task: info=");
      ((StringBuilder)localObject).append(paramDownloadInfo);
      Logger.a("DownloaderImpl_", ((StringBuilder)localObject).toString());
      return this.a.a(paramDownloadInfo, paramBoolean);
    }
    a(paramDownloadInfo, (DownloadInfo)localObject);
    paramDownloadInfo = new StringBuilder();
    paramDownloadInfo.append("[startDownload] old task: oldTask=");
    paramDownloadInfo.append(localObject);
    Logger.a("DownloaderImpl_", paramDownloadInfo.toString());
    return this.a.a((DownloadInfo)localObject, paramBoolean);
  }
  
  public DownloadInfo a(@NotNull String paramString)
  {
    paramString = DownloadInfo.b(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return this.a.b(paramString);
  }
  
  public void a(Context paramContext)
  {
    this.a = HalleyDownloaderProxy.a();
    this.a.b();
    TimiPAGResourceLoader.a.a(this);
  }
  
  public void a(@NotNull DownloadTaskListener paramDownloadTaskListener)
  {
    TaskCallbackCenter.a().a(paramDownloadTaskListener);
  }
  
  public void b(@NotNull DownloadTaskListener paramDownloadTaskListener)
  {
    TaskCallbackCenter.a().b(paramDownloadTaskListener);
  }
  
  public void g()
  {
    TimiPAGResourceLoader.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.download.impl.DownloadServiceImpl
 * JD-Core Version:    0.7.0.1
 */