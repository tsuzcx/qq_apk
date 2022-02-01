package com.tencent.mobileqq.kandian.base.image;

import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import java.lang.ref.WeakReference;

class RunningJob$6
  implements Runnable
{
  public void run()
  {
    if (this.this$0.a.a) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      ((IBitmapCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.this$0.a, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.RunningJob.6
 * JD-Core Version:    0.7.0.1
 */