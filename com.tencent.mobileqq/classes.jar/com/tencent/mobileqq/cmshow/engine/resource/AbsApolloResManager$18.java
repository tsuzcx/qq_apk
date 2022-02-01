package com.tencent.mobileqq.cmshow.engine.resource;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.ApolloListenerManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class AbsApolloResManager$18
  extends DownloadListener
{
  AbsApolloResManager$18(AbsApolloResManager paramAbsApolloResManager) {}
  
  public void onDone(DownloadTask paramDownloadTask) {}
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return;
    }
    Object localObject = paramDownloadTask.b();
    if (localObject == null) {
      return;
    }
    int i = ((Bundle)localObject).getInt(paramDownloadTask.h);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onDoneFile], taskType:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",httpCode: ");
      ((StringBuilder)localObject).append(paramDownloadTask.H);
      ((StringBuilder)localObject).append(", status: ");
      ((StringBuilder)localObject).append(paramDownloadTask.e());
      ((StringBuilder)localObject).append(",task.currUrl:");
      ((StringBuilder)localObject).append(paramDownloadTask.h);
      QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject).toString());
    }
    if (1 != i) {
      return;
    }
    super.onDone(paramDownloadTask);
    if (paramDownloadTask.e() != 3) {
      this.a.a.a(Boolean.valueOf(false));
    }
    try
    {
      this.a.c();
      VipUtils.a(AbsApolloResManager.b(this.a), "cmshow", "Apollo", "json_download_success", 0, 0, new String[0]);
      return;
    }
    catch (Exception paramDownloadTask)
    {
      QLog.e("[cmshow]cm_res", 1, "read apollo panel json content fail", paramDownloadTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager.18
 * JD-Core Version:    0.7.0.1
 */