package com.tencent.qqmini.miniapp.task;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.OnStateChangeListener;
import com.tencent.qqmini.miniapp.core.service.AppBrandService;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class ServiceCreateTask$1
  implements StateMachine.OnStateChangeListener
{
  ServiceCreateTask$1(ServiceCreateTask paramServiceCreateTask, AppBrandService paramAppBrandService) {}
  
  public void onStateChanged()
  {
    Object localObject = this.val$normalJsService;
    if (localObject != null) {
      localObject = ((AppBrandService)localObject).getCurrState();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    if (localObject == this.val$normalJsService.stateInitFailed)
    {
      QMLog.e("ServiceCreateTask", "init AppBrandService error! change to AppBrandWebviewService.");
      new Handler(Looper.getMainLooper()).post(new ServiceCreateTask.1.1(this));
      return;
    }
    if (localObject == this.val$normalJsService.stateInited) {
      this.this$0.onServiceCreateSucc(this.val$normalJsService);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.ServiceCreateTask.1
 * JD-Core Version:    0.7.0.1
 */