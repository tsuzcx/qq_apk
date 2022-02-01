package com.tencent.qqmini.flutter.core.task;

import android.os.SystemClock;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine.OnStateChangeListener;
import com.tencent.qqmini.miniapp.core.service.AbsAppBrandService;

class V8ServiceInitTask$1
  implements StateMachine.OnStateChangeListener
{
  long jsServiceInitStartTimestamp;
  
  V8ServiceInitTask$1(V8ServiceInitTask paramV8ServiceInitTask, AbsAppBrandService paramAbsAppBrandService, long paramLong) {}
  
  public void onStateChanged()
  {
    Object localObject = this.val$v8JsService;
    if (localObject != null) {
      localObject = ((AbsAppBrandService)localObject).getCurrState();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (localObject == this.val$v8JsService.stateWaJsLoading)) {
      this.jsServiceInitStartTimestamp = SystemClock.uptimeMillis();
    }
    if ((localObject != null) && (localObject == this.val$v8JsService.stateWaJsLoadSucc)) {
      this.this$0.onServiceInitSucc(this.val$v8JsService, this.val$serviceInitTimeCost, SystemClock.uptimeMillis() - this.jsServiceInitStartTimestamp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.task.V8ServiceInitTask.1
 * JD-Core Version:    0.7.0.1
 */