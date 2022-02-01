package com.tencent.qplus.swingworker;

import android.os.Process;
import java.util.concurrent.Callable;

class SwingWorker$1
  implements Callable<T>
{
  SwingWorker$1(SwingWorker paramSwingWorker) {}
  
  public T call()
  {
    Process.setThreadPriority(10);
    this.this$0.setState(SwingWorker.StateValue.STARTED);
    return this.this$0.doInBackground();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.swingworker.SwingWorker.1
 * JD-Core Version:    0.7.0.1
 */