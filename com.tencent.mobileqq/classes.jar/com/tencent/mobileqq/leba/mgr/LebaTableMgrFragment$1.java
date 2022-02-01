package com.tencent.mobileqq.leba.mgr;

import ajej;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class LebaTableMgrFragment$1
  implements Runnable
{
  LebaTableMgrFragment$1(LebaTableMgrFragment paramLebaTableMgrFragment, List paramList1, List paramList2, int paramInt) {}
  
  public void run()
  {
    if (LebaTableMgrFragment.a(this.this$0) != null)
    {
      LebaTableMgrFragment.a(this.this$0).a(this.this$0.getActivity(), this.jdField_a_of_type_JavaUtilList, this.b, this.jdField_a_of_type_Int, LebaTableMgrFragment.a(this.this$0));
      return;
    }
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "mDataLogic == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.LebaTableMgrFragment.1
 * JD-Core Version:    0.7.0.1
 */