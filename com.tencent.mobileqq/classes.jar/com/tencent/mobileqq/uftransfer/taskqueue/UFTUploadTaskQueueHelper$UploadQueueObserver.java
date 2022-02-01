package com.tencent.mobileqq.uftransfer.taskqueue;

import java.util.Observable;
import java.util.Observer;

public abstract class UFTUploadTaskQueueHelper$UploadQueueObserver
  implements Observer
{
  protected abstract void a(String paramString, int paramInt);
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    a((String)paramObservable[0], ((Integer)paramObservable[1]).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.taskqueue.UFTUploadTaskQueueHelper.UploadQueueObserver
 * JD-Core Version:    0.7.0.1
 */