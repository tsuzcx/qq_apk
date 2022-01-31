package com.tencent.mobileqq.search.fragment;

import android.os.Handler;
import awpx;
import awus;
import com.tencent.mobileqq.app.QQAppInterface;

class GroupSearchFragment$2
  implements Runnable
{
  GroupSearchFragment$2(GroupSearchFragment paramGroupSearchFragment) {}
  
  public void run()
  {
    if (!this.this$0.d)
    {
      this.this$0.jdField_a_of_type_Awus.a();
      this.this$0.d = true;
    }
    if (!GroupSearchFragment.a(this.this$0))
    {
      awpx localawpx = (awpx)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(318);
      if (localawpx != null) {
        localawpx.a();
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