package com.tencent.mobileqq.kandian.base.image;

import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;

class RunningJob$5
  implements Runnable
{
  RunningJob$5(RunningJob paramRunningJob) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.h.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference.get() != null) && (this.this$0.c != null)) {
        this.this$0.c.loadImage(this.this$0.b, (IBitmapCallback)localWeakReference.get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.RunningJob.5
 * JD-Core Version:    0.7.0.1
 */