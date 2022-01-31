package com.tencent.qplus.swingworker;

import java.util.Iterator;
import java.util.List;

class SwingWorker$DoSubmitAccumulativeRunnable
  extends AccumulativeRunnable<Runnable>
{
  private static final int DELAY = 33;
  
  protected void run(List<Runnable> paramList)
  {
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return;
      }
      ((Runnable)paramList.next()).run();
    }
  }
  
  protected void submit()
  {
    WorkerUtilities.invokeInLooper(this, 33L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qplus.swingworker.SwingWorker.DoSubmitAccumulativeRunnable
 * JD-Core Version:    0.7.0.1
 */