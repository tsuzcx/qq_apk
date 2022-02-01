package com.tencent.mobileqq.leba.more;

import com.tencent.mobileqq.leba.entity.LebaShowData;
import com.tencent.qphone.base.util.QLog;

class LebaMoreFragment$4
  implements Runnable
{
  LebaMoreFragment$4(LebaMoreFragment paramLebaMoreFragment, LebaShowData paramLebaShowData, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.d != null)
    {
      this.this$0.d.a(this.this$0.getActivity(), this.a, this.this$0.e, this.this$0.b, this.b);
      this.this$0.f();
      return;
    }
    QLog.i("LebaMoreFragment", 1, "mDataLogic == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.more.LebaMoreFragment.4
 * JD-Core Version:    0.7.0.1
 */