package com.tencent.mobileqq.teamwork;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;

class TeamWorkFileImportHandler$7
  implements Runnable
{
  TeamWorkFileImportHandler$7(TeamWorkFileImportHandler paramTeamWorkFileImportHandler, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if ((TeamWorkFileImportHandler.a(this.this$0) == null) || (TextUtils.isEmpty(this.a.jdField_f_of_type_JavaLangString))) {
      TenDocLogReportHelper.a("TeamWorkFileImportHandler", "import fail", "srcUrl is null or app is null", this.a.k);
    }
    for (;;)
    {
      return;
      Object localObject = TeamWorkHttpUtils.b(this.a, TeamWorkFileImportHandler.a(this.this$0).getCurrentAccountUin());
      boolean bool = false;
      if (localObject != null) {
        bool = TeamWorkFileImportHandler.b(this.this$0, (String)localObject, this.a);
      }
      while ((!bool) && (TeamWorkFileImportHandler.a(this.this$0) != null))
      {
        localObject = TeamWorkFileImportHandler.a(this.this$0).obtainMessage(8002);
        ((Message)localObject).obj = this.a;
        TeamWorkFileImportHandler.a(this.this$0).sendMessage((Message)localObject);
        return;
        this.a.jdField_f_of_type_Int = -1000;
        TenDocLogReportHelper.a("TeamWorkFileImportHandler", "import fail", "url2doc network fail", this.a.k);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.7
 * JD-Core Version:    0.7.0.1
 */