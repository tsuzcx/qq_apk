package com.tribe.async.async;

import com.tribe.async.dispatch.Dispatcher.Event;

public class JobController$DoneEvent
  implements Dispatcher.Event
{
  public final Worker worker;
  
  public JobController$DoneEvent(Worker paramWorker)
  {
    this.worker = paramWorker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tribe.async.async.JobController.DoneEvent
 * JD-Core Version:    0.7.0.1
 */