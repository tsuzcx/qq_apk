package com.tencent.mobileqq.search.fragment;

import android.os.Handler;
import avqe;
import avuz;
import com.tencent.mobileqq.app.QQAppInterface;

class GroupSearchFragment$2
  implements Runnable
{
  GroupSearchFragment$2(GroupSearchFragment paramGroupSearchFragment) {}
  
  public void run()
  {
    if (!this.this$0.d)
    {
      this.this$0.jdField_a_of_type_Avuz.a();
      this.this$0.d = true;
    }
    if (!GroupSearchFragment.a(this.this$0))
    {
      avqe localavqe = (avqe)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(318);
      if (localavqe != null) {
        localavqe.a();
      }
      GroupSearchFragment.a(this.this$0, true);
    }
    this.this$0.b.removeMessages(100);
    this.this$0.b.sendEmptyMessage(100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.GroupSearchFragment.2
 * JD-Core Version:    0.7.0.1
 */