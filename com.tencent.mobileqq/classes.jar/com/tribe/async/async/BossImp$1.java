package com.tribe.async.async;

import android.support.annotation.Nullable;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

class BossImp$1
  extends FutureListener.SimpleFutureListener<Progress, Result>
{
  BossImp$1(BossImp paramBossImp, Worker paramWorker) {}
  
  public void onFutureDone(@Nullable Result paramResult)
  {
    Dispatchers.get(BossImp.access$100(this.this$0)).dispatch(new JobController.DoneEvent(this.val$worker));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tribe.async.async.BossImp.1
 * JD-Core Version:    0.7.0.1
 */