package com.tencent.mobileqq.multiaio;

import com.tencent.mobileqq.multiaio.widget.MultiAIOPagerAdapter;
import com.tencent.qphone.base.util.QLog;

class MultiAIOFragment$UpdateMsgReadTimer
  implements Runnable
{
  private int a;
  
  private MultiAIOFragment$UpdateMsgReadTimer(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "run() called UpdateMsgReadTimer");
    }
    MultiAIOFragment.a(this.this$0).a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.UpdateMsgReadTimer
 * JD-Core Version:    0.7.0.1
 */