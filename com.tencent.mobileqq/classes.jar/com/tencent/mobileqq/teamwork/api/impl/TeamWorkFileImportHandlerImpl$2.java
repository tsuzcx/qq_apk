package com.tencent.mobileqq.teamwork.api.impl;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;

class TeamWorkFileImportHandlerImpl$2
  implements Runnable
{
  TeamWorkFileImportHandlerImpl$2(TeamWorkFileImportHandlerImpl paramTeamWorkFileImportHandlerImpl, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (TeamWorkFileImportHandlerImpl.access$000(this.this$0) != null)
    {
      if (TextUtils.isEmpty(this.a.c)) {
        return;
      }
      Object localObject = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).uploadFile(this.a, TeamWorkFileImportHandlerImpl.access$000(this.this$0).getCurrentAccountUin());
      int i = 0;
      if (localObject != null)
      {
        boolean bool = TeamWorkFileImportHandlerImpl.access$200(this.this$0, (String)localObject, this.a);
        i = bool;
        if (bool)
        {
          ReportController.b(TeamWorkFileImportHandlerImpl.access$000(this.this$0), "dc00898", "", "", "0X80098F9", "0X80098F9", 0, 0, "", "", "", "");
          i = bool;
        }
      }
      else
      {
        TenDocLogReportHelper.a("TeamWorkFileImportHandlerImpl", "import fail", "local file dataLine parse no result string", this.a.k);
      }
      if ((i == 0) && (TeamWorkFileImportHandlerImpl.access$100(this.this$0) != null))
      {
        localObject = TeamWorkFileImportHandlerImpl.access$100(this.this$0).obtainMessage(8002);
        ((Message)localObject).obj = this.a;
        TeamWorkFileImportHandlerImpl.access$100(this.this$0).sendMessage((Message)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl.2
 * JD-Core Version:    0.7.0.1
 */