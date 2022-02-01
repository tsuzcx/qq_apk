package com.tencent.mobileqq.teamworkforgroup;

import android.os.Message;
import java.util.List;
import mqq.os.MqqHandler;

class GroupTeamWorkListActivity$10
  implements Runnable
{
  GroupTeamWorkListActivity$10(GroupTeamWorkListActivity paramGroupTeamWorkListActivity, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkManager != null)
    {
      if (this.a == 1) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkManager.a(this.this$0.jdField_a_of_type_Long);
      }
      List localList = this.this$0.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkManager.b();
      if (localList != null) {
        synchronized (this.this$0.b)
        {
          GroupTeamWorkListActivity.b(this.this$0, localList);
        }
      }
      ??? = this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(115, 0, 0, null);
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)???);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.10
 * JD-Core Version:    0.7.0.1
 */