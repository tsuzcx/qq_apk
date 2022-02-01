package com.tribe.async.dispatch;

class Subscriber$EventBatchSubscriber$InnerJob
  implements Runnable
{
  private Dispatcher.Dispatchable mDispatchable;
  
  public Subscriber$EventBatchSubscriber$InnerJob(Subscriber.EventBatchSubscriber paramEventBatchSubscriber, Dispatcher.Dispatchable paramDispatchable)
  {
    this.mDispatchable = paramDispatchable;
  }
  
  public void run()
  {
    this.this$0.onDispatch(this.mDispatchable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.dispatch.Subscriber.EventBatchSubscriber.InnerJob
 * JD-Core Version:    0.7.0.1
 */