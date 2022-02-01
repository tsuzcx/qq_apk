package com.tencent.mobileqq.qqlive.utils;

import android.os.Handler;
import android.util.Log;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class ThreadCenter$ThreadImpl$2
  implements Runnable
{
  ThreadCenter$ThreadImpl$2(ThreadCenter.ThreadImpl paramThreadImpl) {}
  
  public void run()
  {
    Log.i("threadimpl_log", "idle check begin...");
    Iterator localIterator = ThreadCenter.ThreadImpl.c(this.this$0).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((ThreadCenter.CoreHandler)localEntry.getValue()).a())
      {
        ((ThreadCenter.CoreHandler)localEntry.getValue()).c();
        localIterator.remove();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("remove handler thread: ");
        localStringBuilder.append((String)localEntry.getKey());
        Log.e("threadimpl_log", localStringBuilder.toString());
      }
    }
    ThreadCenter.ThreadImpl.d(this.this$0).postDelayed(this, 300000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.utils.ThreadCenter.ThreadImpl.2
 * JD-Core Version:    0.7.0.1
 */