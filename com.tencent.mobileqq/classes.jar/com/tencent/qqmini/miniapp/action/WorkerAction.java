package com.tencent.qqmini.miniapp.action;

import com.tencent.qqmini.miniapp.core.AppBrandRuntime;
import com.tencent.qqmini.miniapp.core.service.AppBrandService;
import com.tencent.qqmini.miniapp.core.worker.MiniAppWorkerManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class WorkerAction
  implements Action<Integer>
{
  public static final int ACTION_CREATE_WORKE = 1;
  public static final int ACTION_GET_WORKER_MODE = 2;
  public static final int ACTION_POST_MSG_TO_SERVICE = 5;
  public static final int ACTION_POST_MSG_TO_WORKER = 4;
  public static final int ACTION_STOP_WORKER = 3;
  private int action = -1;
  private IMiniAppContext mMiniAppContext;
  private String mPostMsg = null;
  private String mWorkerName = null;
  
  public static WorkerAction obtain(IMiniAppContext paramIMiniAppContext)
  {
    WorkerAction localWorkerAction = new WorkerAction();
    localWorkerAction.mMiniAppContext = paramIMiniAppContext;
    return localWorkerAction;
  }
  
  public int createWorker(String paramString)
  {
    this.action = 1;
    this.mWorkerName = paramString;
    return ((Integer)this.mMiniAppContext.performAction(this)).intValue();
  }
  
  public int getWorkerMode()
  {
    this.action = 2;
    return ((Integer)this.mMiniAppContext.performAction(this)).intValue();
  }
  
  public Integer perform(BaseRuntime paramBaseRuntime)
  {
    boolean bool = paramBaseRuntime instanceof AppBrandRuntime;
    int i = 0;
    if (!bool) {
      return Integer.valueOf(0);
    }
    int j = this.action;
    if (j == 1) {
      return Integer.valueOf(((AppBrandRuntime)paramBaseRuntime).getMiniAppWorkerManager().createWorker(this.mWorkerName));
    }
    if (j == 2)
    {
      if ((paramBaseRuntime.getJsService() instanceof AppBrandService)) {
        i = 1;
      }
      return Integer.valueOf(i);
    }
    if (j == 3) {
      ((AppBrandRuntime)paramBaseRuntime).getMiniAppWorkerManager().stopWorker();
    }
    if (this.action == 4) {
      ((AppBrandRuntime)paramBaseRuntime).getMiniAppWorkerManager().handlePostMsgToWorker(this.mPostMsg);
    }
    if (this.action == 5)
    {
      paramBaseRuntime = paramBaseRuntime.getJsService();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("WeixinWorker.workerMsgHandler('");
      ((StringBuilder)localObject).append(Integer.valueOf(1));
      ((StringBuilder)localObject).append("',%s)");
      localObject = String.format(((StringBuilder)localObject).toString(), new Object[] { this.mPostMsg });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[postMessageToMain] jsScript:");
      localStringBuilder.append((String)localObject);
      QMLog.i("minisdk-worker", localStringBuilder.toString());
      paramBaseRuntime.evaluateJs((String)localObject, new WorkerAction.1(this));
    }
    return null;
  }
  
  public void postMsgToService(String paramString)
  {
    this.action = 5;
    this.mPostMsg = paramString;
    this.mMiniAppContext.performAction(this);
  }
  
  public void postMsgToWorker(String paramString)
  {
    this.action = 4;
    this.mPostMsg = paramString;
    this.mMiniAppContext.performAction(this);
  }
  
  public void stopWorker()
  {
    this.action = 3;
    this.mMiniAppContext.performAction(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.action.WorkerAction
 * JD-Core Version:    0.7.0.1
 */