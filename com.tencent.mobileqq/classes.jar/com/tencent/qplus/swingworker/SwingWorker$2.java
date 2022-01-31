package com.tencent.qplus.swingworker;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class SwingWorker$2
  extends FutureTask<T>
{
  SwingWorker$2(SwingWorker paramSwingWorker, Callable paramCallable)
  {
    super(paramCallable);
  }
  
  protected void done()
  {
    SwingWorker.access$1(this.this$0);
    this.this$0.setState(SwingWorker.StateValue.DONE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qplus.swingworker.SwingWorker.2
 * JD-Core Version:    0.7.0.1
 */