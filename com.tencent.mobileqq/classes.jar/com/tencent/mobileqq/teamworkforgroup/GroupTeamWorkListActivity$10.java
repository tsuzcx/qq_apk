package com.tencent.mobileqq.teamworkforgroup;

import android.os.Message;
import bakw;
import java.util.List;
import mqq.os.MqqHandler;

class GroupTeamWorkListActivity$10
  implements Runnable
{
  GroupTeamWorkListActivity$10(GroupTeamWorkListActivity paramGroupTeamWorkListActivity, int paramInt) {}
  
  public void run()
  {
    List localList;
    if (this.this$0.jdField_a_of_type_Bakw != null)
    {
      if (this.a == 1) {
        this.this$0.jdField_a_of_type_Bakw.a(this.this$0.jdField_a_of_type_Long);
      }
      localList = this.this$0.jdField_a_of_type_Bakw.b();
      if (localList == null) {}
    }
    synchronized (this.this$0.b)
    {
      GroupTeamWorkListActivity.b(this.this$0, localList);
      ??? = this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(115, 0, 0, null);
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)???);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.10
 * JD-Core Version:    0.7.0.1
 */