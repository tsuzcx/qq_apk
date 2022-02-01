package com.tencent.mobileqq.teamwork;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;

class TeamWorkFileImportHandler$2
  implements Runnable
{
  TeamWorkFileImportHandler$2(TeamWorkFileImportHandler paramTeamWorkFileImportHandler, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    boolean bool = false;
    if ((TeamWorkFileImportHandler.a(this.this$0) == null) || (TextUtils.isEmpty(this.a.c))) {}
    for (;;)
    {
      return;
      Object localObject = TeamWorkHttpUtils.a(this.a, TeamWorkFileImportHandler.a(this.this$0).getCurrentAccountUin());
      if (localObject != null)
      {
        bool = TeamWorkFileImportHandler.a(this.this$0, (String)localObject, this.a);
        if (!bool) {
          break label163;
        }
        ReportController.b(TeamWorkFileImportHandler.a(this.this$0), "dc00898", "", "", "0X80098F9", "0X80098F9", 0, 0, "", "", "", "");
      }
      label163:
      while ((!bool) && (TeamWorkFileImportHandler.a(this.this$0) != null))
      {
        localObject = TeamWorkFileImportHandler.a(this.this$0).obtainMessage(8002);
        ((Message)localObject).obj = this.a;
        TeamWorkFileImportHandler.a(this.this$0).sendMessage((Message)localObject);
        return;
        TenDocLogReportHelper.a("TeamWorkFileImportHandler", "import fail", "local file dataLine parse no result string", this.a.k);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.2
 * JD-Core Version:    0.7.0.1
 */