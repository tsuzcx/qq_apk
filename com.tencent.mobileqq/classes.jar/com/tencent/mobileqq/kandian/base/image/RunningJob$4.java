package com.tencent.mobileqq.kandian.base.image;

import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport;
import java.lang.ref.WeakReference;

class RunningJob$4
  implements Runnable
{
  RunningJob$4(RunningJob paramRunningJob, WeakReference paramWeakReference, Throwable paramThrowable) {}
  
  public void run()
  {
    if (this.this$0.b.d)
    {
      RIJImageOptReport.a(6, this.this$0.b);
      RIJImageOptReport.a(this.this$0.b, false, "cancelled");
      return;
    }
    if (this.a.get() != null) {
      ((IBitmapCallback)this.a.get()).a(this.this$0.b, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.RunningJob.4
 * JD-Core Version:    0.7.0.1
 */