package com.tencent.qqmini.miniapp.task;

import android.os.SystemClock;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.OnStateChangeListener;
import com.tencent.qqmini.miniapp.core.service.AbsAppBrandService;

class ServiceInitTask$1
  implements StateMachine.OnStateChangeListener
{
  long jsServiceInitStartTimestamp;
  
  ServiceInitTask$1(ServiceInitTask paramServiceInitTask, AbsAppBrandService paramAbsAppBrandService, long paramLong) {}
  
  public void onStateChanged()
  {
    Object localObject = this.val$appBrandService;
    if (localObject != null) {
      localObject = ((AbsAppBrandService)localObject).getCurrState();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (localObject == this.val$appBrandService.stateWaJsLoading)) {
      this.jsServiceInitStartTimestamp = SystemClock.uptimeMillis();
    }
    if ((localObject != null) && (localObject == this.val$appBrandService.stateWaJsLoadSucc)) {
      this.this$0.onServiceInitSucc(this.val$appBrandService, this.val$serviceInitTimeCost, SystemClock.uptimeMillis() - this.jsServiceInitStartTimestamp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.ServiceInitTask.1
 * JD-Core Version:    0.7.0.1
 */