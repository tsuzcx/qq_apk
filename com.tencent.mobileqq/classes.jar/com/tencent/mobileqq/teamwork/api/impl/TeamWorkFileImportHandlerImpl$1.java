package com.tencent.mobileqq.teamwork.api.impl;

import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreviewConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreviewConfigProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class TeamWorkFileImportHandlerImpl$1
  implements Runnable
{
  TeamWorkFileImportHandlerImpl$1(TeamWorkFileImportHandlerImpl paramTeamWorkFileImportHandlerImpl, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    boolean bool2 = this.a.b();
    boolean bool3 = FileUtils.fileExistsAndNotEmpty(this.a.c);
    boolean bool1 = false;
    int i;
    if ((bool3) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).supportTencentDoc(TencentDocPreviewConfigProcessor.a().a(), this.a.c, this.a.b, this.a.jdField_d_of_type_Long))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!bool2) && ((TeamWorkFileImportHandlerImpl.access$000(this.this$0) == null) || (!bool3) || (i == 0)))
    {
      TenDocLogReportHelper.a("TeamWorkFileImportHandlerImpl", "import fail", "filePath is null or app is null", this.a.k);
      if (TeamWorkFileImportHandlerImpl.access$100(this.this$0) != null)
      {
        localObject1 = TeamWorkFileImportHandlerImpl.access$100(this.this$0).obtainMessage(8002);
        localObject3 = this.a;
        ((Message)localObject1).obj = localObject3;
        if (!bool3) {
          ((TeamWorkFileImportInfo)localObject3).h = MobileQQ.getContext().getString(2131719533);
        } else if (i == 0) {
          ((TeamWorkFileImportInfo)localObject3).h = MobileQQ.getContext().getString(2131719526);
        }
        TeamWorkFileImportHandlerImpl.access$100(this.this$0).sendMessage((Message)localObject1);
      }
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).uploadFile(this.a, TeamWorkFileImportHandlerImpl.access$000(this.this$0).getCurrentAccountUin());
    long l2 = System.currentTimeMillis();
    if (localObject1 != null)
    {
      bool1 = TeamWorkFileImportHandlerImpl.access$200(this.this$0, (String)localObject1, this.a);
      try
      {
        localObject3 = new JSONObject((String)localObject1).getString("url");
      }
      catch (Exception localException)
      {
        QLog.e("TeamWorkFileImportHandlerImpl", 1, localException.toString());
        break label329;
      }
    }
    else
    {
      localObject2 = this.a;
      ((TeamWorkFileImportInfo)localObject2).f = -1000;
      TenDocLogReportHelper.a("TeamWorkFileImportHandlerImpl", "import fail", "local file network fail", ((TeamWorkFileImportInfo)localObject2).k);
    }
    label329:
    Object localObject3 = "";
    Object localObject2 = HardCodeUtil.a(2131714606);
    if (this.a.e == 3) {
      localObject2 = "word";
    }
    for (;;)
    {
      break;
      if (this.a.e == 6) {
        localObject2 = "excel";
      } else if (this.a.e == 7) {
        localObject2 = "ppt";
      } else if (this.a.e == 9) {
        localObject2 = "pdf";
      }
    }
    AppInterface localAppInterface = TeamWorkFileImportHandlerImpl.access$000(this.this$0);
    int j = this.a.jdField_d_of_type_Int;
    if (bool1) {
      i = 1;
    } else {
      i = 2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l2 - l1);
    localStringBuilder.append("");
    ReportController.b(localAppInterface, "dc00898", "", "", "0X8009955", "0X8009955", j, i, localStringBuilder.toString(), "", (String)localObject2, (String)localObject3);
    if ((!bool1) && (TeamWorkFileImportHandlerImpl.access$100(this.this$0) != null))
    {
      localObject2 = TeamWorkFileImportHandlerImpl.access$100(this.this$0).obtainMessage(8002);
      ((Message)localObject2).obj = this.a;
      TeamWorkFileImportHandlerImpl.access$100(this.this$0).sendMessage((Message)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl.1
 * JD-Core Version:    0.7.0.1
 */