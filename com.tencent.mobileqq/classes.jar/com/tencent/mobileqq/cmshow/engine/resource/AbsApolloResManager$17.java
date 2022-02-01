package com.tencent.mobileqq.cmshow.engine.resource;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.utils.ApolloListenerManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class AbsApolloResManager$17
  extends DownloadListener
{
  AbsApolloResManager$17(AbsApolloResManager paramAbsApolloResManager) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]cm_res", 2, "download onDone");
    }
    if (paramDownloadTask.e() == 3) {
      VipUtils.a(AbsApolloResManager.b(this.a), "cmshow", "Apollo", "action_download_success", 0, 0, new String[0]);
    }
    if (this.a.a != null) {
      this.a.a.b();
    }
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null)
    {
      QLog.e("[cmshow]cm_res", 1, "onDoneFile task is null");
      return;
    }
    Object localObject2 = paramDownloadTask.h;
    paramDownloadTask = paramDownloadTask.b();
    if (paramDownloadTask == null)
    {
      QLog.e("[cmshow]cm_res", 1, "onDoneFile params is null");
      return;
    }
    paramDownloadTask = (ApolloActionData)paramDownloadTask.getSerializable((String)localObject2);
    if (paramDownloadTask == null)
    {
      QLog.e("[cmshow]cm_res", 1, "action res onDoneFile but action data is null");
      return;
    }
    Object localObject1 = this.a.a(paramDownloadTask, 4);
    if (((String)localObject2).equals(this.a.a(paramDownloadTask, 5)))
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("action res zip done acitonid=");
          ((StringBuilder)localObject2).append(paramDownloadTask.actionId);
          ((StringBuilder)localObject2).append(" action name =");
          ((StringBuilder)localObject2).append(paramDownloadTask.actionName);
          QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject2).toString());
        }
        if (!this.a.c(paramDownloadTask.actionId, paramDownloadTask.personNum))
        {
          FileUtils.uncompressZip((String)localObject1, this.a.a(paramDownloadTask, 6), false);
          FileUtils.deleteFile((String)localObject1);
          AbsApolloResManager.a(this.a, paramDownloadTask);
        }
        ThreadManager.getFileThreadHandler().postDelayed(new AbsApolloResManager.17.1(this, paramDownloadTask), 2000L);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break label321;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uncompressZip fail zip file: ");
      localStringBuilder.append((String)localObject1);
      QLog.e("[cmshow]cm_res", 2, localStringBuilder.toString(), localException);
    }
    else if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onDoneFile panelView actionId = ");
      ((StringBuilder)localObject1).append(paramDownloadTask.actionId);
      ((StringBuilder)localObject1).append(" action name =");
      ((StringBuilder)localObject1).append(paramDownloadTask.actionName);
      QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
    }
    label321:
    boolean bool;
    if (paramDownloadTask.compoundType > 0) {
      bool = this.a.a(paramDownloadTask.actionId, 1, paramDownloadTask.personNum, false);
    } else {
      bool = this.a.a(paramDownloadTask);
    }
    if ((bool) && (this.a.a != null))
    {
      paramDownloadTask.status = 1;
      localObject1 = AbsApolloResManager.b(this.a);
      if (localObject1 != null) {
        ((ApolloDaoManagerServiceImpl)((AppRuntime)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all")).changeActionStatus(paramDownloadTask);
      } else {
        QLog.e("[cmshow]cm_res", 1, "[DownloadListener] changeActionStatus error, app is null!");
      }
      this.a.a.a(paramDownloadTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager.17
 * JD-Core Version:    0.7.0.1
 */