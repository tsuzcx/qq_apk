package com.tencent.mobileqq.search.fragment;

import android.os.Handler;
import bbop;
import bbtj;
import com.tencent.mobileqq.app.QQAppInterface;

class GroupSearchFragment$2
  implements Runnable
{
  GroupSearchFragment$2(GroupSearchFragment paramGroupSearchFragment) {}
  
  public void run()
  {
    if (!this.this$0.d)
    {
      this.this$0.jdField_a_of_type_Bbtj.a();
      this.this$0.d = true;
    }
    if (!GroupSearchFragment.a(this.this$0))
    {
      bbop localbbop = (bbop)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(318);
      if (localbbop != null) {
        localbbop.a();
      }
      GroupSearchFragment.a(this.this$0, true);
    }
    this.this$0.b.removeMessages(100);
    this.this$0.b.sendEmptyMessage(100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.GroupSearchFragment.2
 * JD-Core Version:    0.7.0.1
 */