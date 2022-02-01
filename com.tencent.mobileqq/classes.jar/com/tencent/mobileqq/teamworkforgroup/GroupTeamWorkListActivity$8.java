package com.tencent.mobileqq.teamworkforgroup;

import android.os.Message;
import java.util.Collections;
import java.util.List;
import mqq.os.MqqHandler;

class GroupTeamWorkListActivity$8
  implements Runnable
{
  GroupTeamWorkListActivity$8(GroupTeamWorkListActivity paramGroupTeamWorkListActivity, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkManager != null)
    {
      if (this.a == 1) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkManager.a(this.this$0.jdField_a_of_type_Long);
      }
      List localList = this.this$0.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkManager.a();
      if (localList != null) {
        synchronized (this.this$0.jdField_a_of_type_JavaUtilList)
        {
          GroupTeamWorkListActivity.a(this.this$0, localList);
          Collections.sort(this.this$0.jdField_a_of_type_JavaUtilList, this.this$0.jdField_a_of_type_JavaUtilComparator);
        }
      }
      if (this.a == 1)
      {
        ??? = this.this$0;
        GroupTeamWorkListActivity.a((GroupTeamWorkListActivity)???, ((GroupTeamWorkListActivity)???).jdField_a_of_type_Long, 0, 20, 1);
      }
      ??? = this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(113, 0, this.a, null);
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)???);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.8
 * JD-Core Version:    0.7.0.1
 */