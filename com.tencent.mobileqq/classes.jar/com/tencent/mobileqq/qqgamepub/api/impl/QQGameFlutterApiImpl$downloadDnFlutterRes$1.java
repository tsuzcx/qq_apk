package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/qqgamepub/api/impl/QQGameFlutterApiImpl$downloadDnFlutterRes$1", "Lcom/tencent/mobileqq/vip/DownloadListener;", "onDoneFile", "", "task", "Lcom/tencent/mobileqq/vip/DownloadTask;", "onProgress", "onStart", "", "qqgamepubaccount-impl_release"}, k=1, mv={1, 1, 16})
public final class QQGameFlutterApiImpl$downloadDnFlutterRes$1
  extends DownloadListener
{
  public void onDoneFile(@Nullable DownloadTask paramDownloadTask)
  {
    super.onDoneFile(paramDownloadTask);
    if (paramDownloadTask != null)
    {
      if (paramDownloadTask.c == 0)
      {
        this.a.checkDnFlutterRes(paramDownloadTask);
        return;
      }
      this.a.reportDownload(paramDownloadTask, 1, paramDownloadTask.H);
    }
  }
  
  public void onProgress(@NotNull DownloadTask paramDownloadTask)
  {
    Intrinsics.checkParameterIsNotNull(paramDownloadTask, "task");
    super.onProgress(paramDownloadTask);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onProgress: ");
      localStringBuilder.append(paramDownloadTask.l);
      QLog.d("QQGameFlutterUtilsImpl", 1, localStringBuilder.toString());
    }
  }
  
  public boolean onStart(@Nullable DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameFlutterUtilsImpl", 1, "updateDnFlutterByQQGame onStart");
    }
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameFlutterApiImpl.downloadDnFlutterRes.1
 * JD-Core Version:    0.7.0.1
 */