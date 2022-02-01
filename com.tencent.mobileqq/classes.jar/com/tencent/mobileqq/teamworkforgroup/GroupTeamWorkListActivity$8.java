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
    if (this.this$0.h != null)
    {
      if (this.a == 1) {
        this.this$0.h.a(this.this$0.m);
      }
      List localList = this.this$0.h.c();
      if (localList != null) {
        synchronized (this.this$0.e)
        {
          GroupTeamWorkListActivity.a(this.this$0, localList);
          Collections.sort(this.this$0.e, this.this$0.n);
        }
      }
      if (this.a == 1)
      {
        ??? = this.this$0;
        GroupTeamWorkListActivity.a((GroupTeamWorkListActivity)???, ((GroupTeamWorkListActivity)???).m, 0, 20, 1);
      }
      ??? = this.this$0.b.obtainMessage(113, 0, this.a, null);
      this.this$0.b.sendMessage((Message)???);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.8
 * JD-Core Version:    0.7.0.1
 */