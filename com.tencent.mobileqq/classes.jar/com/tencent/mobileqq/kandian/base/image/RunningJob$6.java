package com.tencent.mobileqq.kandian.base.image;

import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import java.lang.ref.WeakReference;

class RunningJob$6
  implements Runnable
{
  public void run()
  {
    if (this.this$0.b.d) {
      return;
    }
    if (this.a.get() != null) {
      ((IBitmapCallback)this.a.get()).a(this.this$0.b, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.RunningJob.6
 * JD-Core Version:    0.7.0.1
 */