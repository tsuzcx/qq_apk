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
    this.a.run();
    if (UITimer.a(this.this$0)) {
      UITimer.b(this.this$0).postDelayed((Runnable)this, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.UITimer.start.1
 * JD-Core Version:    0.7.0.1
 */