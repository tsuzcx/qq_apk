package com.tencent.mobileqq.studyroom.utils;

import android.os.Handler;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/studyroom/utils/UITimer$start$1", "Ljava/lang/Runnable;", "run", "", "qqstudyroom_impl_release"}, k=1, mv={1, 1, 16})
public final class UITimer$start$1
  implements Runnable
{
  UITimer$start$1(Runnable paramRunnable, long paramLong) {}
  
  public void run()
  {
    this.jdField_a_of_type_JavaLangRunnable.run();
    if (UITimer.a(this.this$0)) {
      UITimer.a(this.this$0).postDelayed((Runnable)this, this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.UITimer.start.1
 * JD-Core Version:    0.7.0.1
 */