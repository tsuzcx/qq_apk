package com.tencent.mobileqq.engineering.preload;

import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;

class Worker$2
  implements Runnable
{
  Worker$2(Worker paramWorker, OnTaskListener paramOnTaskListener, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    this.a.onComplete(this.b);
    if (this.this$0.mBasePreLoadTask.mIsOnlyRunOnce) {
      PreLoader.remove(Worker.access$000(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.engineering.preload.Worker.2
 * JD-Core Version:    0.7.0.1
 */