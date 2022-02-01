package com.tencent.mobileqq.teamworkforgroup;

import android.os.Message;
import befl;
import java.util.Collections;
import java.util.List;
import mqq.os.MqqHandler;

class GroupTeamWorkListActivity$8
  implements Runnable
{
  GroupTeamWorkListActivity$8(GroupTeamWorkListActivity paramGroupTeamWorkListActivity, int paramInt) {}
  
  public void run()
  {
    List localList;
    if (this.this$0.jdField_a_of_type_Befl != null)
    {
      if (this.a == 1) {
        this.this$0.jdField_a_of_type_Befl.a(this.this$0.jdField_a_of_type_Long);
      }
      localList = this.this$0.jdField_a_of_type_Befl.a();
      if (localList == null) {}
    }
    synchronized (this.this$0.jdField_a_of_type_JavaUtilList)
    {
      GroupTeamWorkListActivity.a(this.this$0, localList);
      Collections.sort(this.this$0.jdField_a_of_type_JavaUtilList, this.this$0.jdField_a_of_type_JavaUtilComparator);
      if (this.a == 1) {
        GroupTeamWorkListActivity.a(this.this$0, this.this$0.jdField_a_of_type_Long, 0, 20, 1);
      }
      ??? = this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(113, 0, this.a, null);
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)???);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.8
 * JD-Core Version:    0.7.0.1
 */