package com.tencent.mobileqq.vas;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class ClubContentJsonTask$1
  extends DownloadListener
{
  private void a(AppRuntime paramAppRuntime)
  {
    ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).reportRedPacket(paramAppRuntime);
  }
  
  private boolean a(DownloadTask paramDownloadTask, AppRuntime paramAppRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ClubContentJsonTask jsondownfail task.key = ");
    localStringBuilder.append(paramDownloadTask.b);
    QLog.e("ClubContentJsonTask", 1, localStringBuilder.toString());
    if ((paramDownloadTask.b != null) && (paramDownloadTask.b.equals(ClubContentJsonTask.g.a)) && (paramAppRuntime != null)) {
      a(paramAppRuntime);
    }
    return false;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject4 = paramDownloadTask.b();
    Object localObject2 = ((Bundle)localObject4).getString("method");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "other";
    }
    Object localObject3 = ((Bundle)localObject4).getString("ifromet");
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "null";
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Club_jsonDownloadListener key = ");
      ((StringBuilder)localObject3).append(paramDownloadTask.b);
      ((StringBuilder)localObject3).append(",satatus = ");
      ((StringBuilder)localObject3).append(paramDownloadTask.e());
      ((StringBuilder)localObject3).append(",errCode = ");
      ((StringBuilder)localObject3).append(paramDownloadTask.c);
      ((StringBuilder)localObject3).append(",errMsg = ");
      ((StringBuilder)localObject3).append(paramDownloadTask.d);
      QLog.d("ClubContentJsonTask", 2, ((StringBuilder)localObject3).toString());
    }
    localObject3 = MobileQQ.sMobileQQ.peekAppRuntime();
    boolean bool;
    if ((paramDownloadTask.e() == 3) && (paramDownloadTask.c == 0))
    {
      ClubContentJsonTask.a(paramDownloadTask, (Bundle)localObject4, (AppRuntime)localObject3);
      bool = true;
    }
    else
    {
      bool = a(paramDownloadTask, (AppRuntime)localObject3);
    }
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("jsonDownloadListener,ret=");
      ((StringBuilder)localObject4).append(bool);
      ((StringBuilder)localObject4).append(",file.name:");
      ((StringBuilder)localObject4).append(paramDownloadTask.b);
      ((StringBuilder)localObject4).append(",method:");
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append(",ifromet:");
      ((StringBuilder)localObject4).append((String)localObject2);
      QLog.d("ClubContentJsonTask", 2, ((StringBuilder)localObject4).toString());
    }
    if (localObject3 != null) {
      try
      {
        localObject4 = new HashMap();
        ((HashMap)localObject4).put("param_jsonName", paramDownloadTask.b);
        ((HashMap)localObject4).put("param_method", localObject1);
        ((HashMap)localObject4).put("param_from", localObject2);
        StatisticCollector.getInstance(((AppRuntime)localObject3).getApplication().getApplicationContext()).collectPerformance(((AppRuntime)localObject3).getAccount(), "ClubContentJsonLoaded", bool, 1L, 0L, (HashMap)localObject4, "", false);
        return;
      }
      catch (Exception paramDownloadTask)
      {
        paramDownloadTask.printStackTrace();
      }
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask) {}
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ClubContentJsonTask.1
 * JD-Core Version:    0.7.0.1
 */