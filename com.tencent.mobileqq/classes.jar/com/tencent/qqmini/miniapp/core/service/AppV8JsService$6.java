package com.tencent.qqmini.miniapp.core.service;

import com.tencent.qqmini.miniapp.core.worker.MiniWorkerInterface;
import com.tencent.qqmini.v8rt.engine.IWorkerEventHandler;

class AppV8JsService$6
  implements IWorkerEventHandler
{
  AppV8JsService$6(AppV8JsService paramAppV8JsService, MiniWorkerInterface paramMiniWorkerInterface) {}
  
  public int create(String paramString)
  {
    return this.val$worker.create(paramString);
  }
  
  public void postMsgToAppService(String paramString)
  {
    this.val$worker.postMsgToAppService(paramString);
  }
  
  public void postMsgToWorker(int paramInt, String paramString)
  {
    this.val$worker.postMsgToWorker(paramInt, paramString);
  }
  
  public void terminate(int paramInt)
  {
    this.val$worker.terminate(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppV8JsService.6
 * JD-Core Version:    0.7.0.1
 */