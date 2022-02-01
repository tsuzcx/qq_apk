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
    if (this.this$0.a.a)
    {
      RIJImageOptReport.a(6, this.this$0.a);
      RIJImageOptReport.a(this.this$0.a, false, "cancelled");
      return;
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      ((IBitmapCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.this$0.a, this.jdField_a_of_type_JavaLangThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.RunningJob.4
 * JD-Core Version:    0.7.0.1
 */