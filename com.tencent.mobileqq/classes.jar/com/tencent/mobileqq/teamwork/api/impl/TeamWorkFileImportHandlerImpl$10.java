package com.tencent.mobileqq.teamwork.api.impl;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class TeamWorkFileImportHandlerImpl$10
  implements Runnable
{
  TeamWorkFileImportHandlerImpl$10(TeamWorkFileImportHandlerImpl paramTeamWorkFileImportHandlerImpl, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (TeamWorkFileImportHandlerImpl.access$000(this.this$0) != null)
    {
      Object localObject1 = this.a;
      if (localObject1 != null)
      {
        if (TextUtils.isEmpty(((TeamWorkFileImportInfo)localObject1).d)) {
          return;
        }
        long l1 = System.currentTimeMillis();
        localObject1 = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).uploadFileForH5(this.a, TeamWorkFileImportHandlerImpl.access$000(this.this$0).getCurrentAccountUin());
        long l2 = System.currentTimeMillis();
        boolean bool = false;
        String str;
        if (localObject1 != null)
        {
          bool = this.this$0.parseFileImportResultForH5((String)localObject1, this.a);
          try
          {
            str = new JSONObject((String)localObject1).getString("url");
          }
          catch (Exception localException)
          {
            QLog.e("TeamWorkFileImportHandlerImpl", 1, localException.toString());
          }
        }
        else
        {
          str = "";
        }
        Object localObject2 = HardCodeUtil.a(2131912115);
        if (this.a.u == 3) {
          localObject2 = "word";
        }
        for (;;)
        {
          break;
          if (this.a.u == 6) {
            localObject2 = "excel";
          } else if (this.a.u == 7) {
            localObject2 = "ppt";
          } else if (this.a.u == 9) {
            localObject2 = "pdf";
          }
        }
        AppInterface localAppInterface = TeamWorkFileImportHandlerImpl.access$000(this.this$0);
        int i;
        if (bool) {
          i = 1;
        } else {
          i = 2;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l2 - l1);
        localStringBuilder.append("");
        ReportController.b(localAppInterface, "dc00898", "", "", "0X8009958", "0X8009958", 0, i, localStringBuilder.toString(), "", (String)localObject2, str);
        if ((!bool) && (TeamWorkFileImportHandlerImpl.access$100(this.this$0) != null))
        {
          localObject2 = TeamWorkFileImportHandlerImpl.access$100(this.this$0).obtainMessage(8002);
          ((Message)localObject2).obj = this.a;
          TeamWorkFileImportHandlerImpl.access$100(this.this$0).sendMessage((Message)localObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl.10
 * JD-Core Version:    0.7.0.1
 */