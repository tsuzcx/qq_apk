package com.tencent.mobileqq.teamworkforgroup;

import com.tencent.mobileqq.teamwork.TeamWorkObserver;
import com.tencent.qphone.base.util.QLog;

class GroupTeamWorkListActivity$17
  extends TeamWorkObserver
{
  GroupTeamWorkListActivity$17(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    GroupTeamWorkListActivity.e(this.a);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append(" onDeletePad success: ");
      paramString.append(paramBoolean);
      QLog.i("GroupTeamWorkListActivity", 2, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.17
 * JD-Core Version:    0.7.0.1
 */