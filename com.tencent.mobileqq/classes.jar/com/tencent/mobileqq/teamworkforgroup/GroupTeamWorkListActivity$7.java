package com.tencent.mobileqq.teamworkforgroup;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

class GroupTeamWorkListActivity$7
  implements PopupMenuDialog.OnClickActionListener
{
  GroupTeamWorkListActivity$7(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    int i;
    switch (paramMenuItem.a)
    {
    case 2131364853: 
    default: 
      i = 0;
    }
    for (;;)
    {
      ReportController.b(this.a.app, "dc00898", "", "", "0X8009C65", "0X8009C65", 0, 0, "", "", "" + GroupTeamWorkListActivity.a(this.a), "" + i);
      return;
      TeamWorkUtils.a(this.a.app, "0X800993B");
      TeamWorkUtils.a(this.a.app, this.a, 1, "group_online_doc", this.a.a, GroupTeamWorkListActivity.a(this.a), this.a.app.getLongAccountUin());
      i = 1;
      continue;
      TeamWorkUtils.a(this.a.app, "0X800993C");
      TeamWorkUtils.a(this.a.app, this.a, 2, "group_online_doc", this.a.a, GroupTeamWorkListActivity.a(this.a), this.a.app.getLongAccountUin());
      i = 2;
      continue;
      TeamWorkUtils.a(this.a.app, "0X800993C");
      TeamWorkUtils.a(this.a.app, this.a, 3, "group_online_doc", this.a.a, GroupTeamWorkListActivity.a(this.a), this.a.app.getLongAccountUin());
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.7
 * JD-Core Version:    0.7.0.1
 */