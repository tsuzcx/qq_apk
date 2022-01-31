package org.junit.runner.notification;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;

abstract class RunNotifier$SafeNotifier
{
  private final List<RunListener> currentListeners;
  
  RunNotifier$SafeNotifier(RunNotifier paramRunNotifier)
  {
    this(paramRunNotifier, RunNotifier.access$000(paramRunNotifier));
  }
  
  RunNotifier$SafeNotifier(List<RunListener> paramList)
  {
    Object localObject;
    this.currentListeners = localObject;
  }
  
  protected abstract void notifyListener(RunListener paramRunListener);
  
  void run()
  {
    int i = this.currentListeners.size();
    ArrayList localArrayList1 = new ArrayList(i);
    ArrayList localArrayList2 = new ArrayList(i);
    Iterator localIterator = this.currentListeners.iterator();
    while (localIterator.hasNext())
    {
      RunListener localRunListener = (RunListener)localIterator.next();
      try
      {
        notifyListener(localRunListener);
        localArrayList1.add(localRunListener);
      }
      catch (Exception localException)
      {
        localArrayList2.add(new Failure(Description.TEST_MECHANISM, localException));
      }
    }
    RunNotifier.access$100(this.this$0, localArrayList1, localArrayList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.runner.notification.RunNotifier.SafeNotifier
 * JD-Core Version:    0.7.0.1
 */