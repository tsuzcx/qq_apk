package com.tencent.mobileqq.teamwork.api.impl;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;

class TeamWorkFileImportHandlerImpl$7
  implements Runnable
{
  TeamWorkFileImportHandlerImpl$7(TeamWorkFileImportHandlerImpl paramTeamWorkFileImportHandlerImpl, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if ((TeamWorkFileImportHandlerImpl.access$000(this.this$0) != null) && (!TextUtils.isEmpty(this.a.jdField_f_of_type_JavaLangString)))
    {
      Object localObject = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).url2Doc(this.a, TeamWorkFileImportHandlerImpl.access$000(this.this$0).getCurrentAccountUin());
      boolean bool = false;
      if (localObject != null)
      {
        bool = TeamWorkFileImportHandlerImpl.access$400(this.this$0, (String)localObject, this.a);
      }
      else
      {
        localObject = this.a;
        ((TeamWorkFileImportInfo)localObject).jdField_f_of_type_Int = -1000;
        TenDocLogReportHelper.a("TeamWorkFileImportHandlerImpl", "import fail", "url2doc network fail", ((TeamWorkFileImportInfo)localObject).k);
      }
      if ((!bool) && (TeamWorkFileImportHandlerImpl.access$100(this.this$0) != null))
      {
        localObject = TeamWorkFileImportHandlerImpl.access$100(this.this$0).obtainMessage(8002);
        ((Message)localObject).obj = this.a;
        TeamWorkFileImportHandlerImpl.access$100(this.this$0).sendMessage((Message)localObject);
      }
      return;
    }
    TenDocLogReportHelper.a("TeamWorkFileImportHandlerImpl", "import fail", "srcUrl is null or app is null", this.a.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl.7
 * JD-Core Version:    0.7.0.1
 */