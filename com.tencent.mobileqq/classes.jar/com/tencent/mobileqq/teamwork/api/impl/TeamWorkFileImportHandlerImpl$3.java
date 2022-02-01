package com.tencent.mobileqq.teamwork.api.impl;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class TeamWorkFileImportHandlerImpl$3
  implements Runnable
{
  TeamWorkFileImportHandlerImpl$3(TeamWorkFileImportHandlerImpl paramTeamWorkFileImportHandlerImpl, JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, int paramInt) {}
  
  public void run()
  {
    if (TeamWorkFileImportHandlerImpl.access$000(this.this$0) == null) {
      return;
    }
    long l1 = System.currentTimeMillis();
    if ((this.a != null) && (this.b.b()) && (!this.b.t)) {}
    try
    {
      this.a.put("cacheKeyType", 1);
    }
    catch (JSONException localJSONException1)
    {
      label56:
      String str2;
      long l2;
      StringBuilder localStringBuilder1;
      boolean bool;
      String str1;
      Object localObject;
      AppInterface localAppInterface;
      int j;
      int i;
      StringBuilder localStringBuilder2;
      break label56;
    }
    str2 = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).uploadFileInfo(this.a, TeamWorkFileImportHandlerImpl.access$000(this.this$0).getCurrentAccountUin(), TeamWorkFileImportHandlerImpl.access$000(this.this$0));
    l2 = System.currentTimeMillis();
    if (this.b.N != this.c)
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("this job has dropped ");
      localStringBuilder1.append(this.c);
      QLog.w("TeamWorkFileImportHandlerImpl", 2, localStringBuilder1.toString());
      return;
    }
    if (str2 != null)
    {
      bool = TeamWorkFileImportHandlerImpl.access$200(this.this$0, str2, this.b);
      try
      {
        str1 = new JSONObject(str2).getString("url");
      }
      catch (Exception localException)
      {
        QLog.e("TeamWorkFileImportHandlerImpl", 1, localException.toString());
        str1 = "";
      }
    }
    else
    {
      TenDocLogReportHelper.a("TeamWorkFileImportHandlerImpl", "import fail", "url import no result string", this.b.A);
      str1 = "";
      bool = false;
    }
    localObject = HardCodeUtil.a(2131912115);
    if (this.b.u == 3) {
      localObject = "word";
    }
    for (;;)
    {
      break;
      if (this.b.u == 6) {
        localObject = "excel";
      } else if (this.b.u == 7) {
        localObject = "ppt";
      } else if (this.b.u == 9) {
        localObject = "pdf";
      }
    }
    l1 = l2 - l1;
    localAppInterface = TeamWorkFileImportHandlerImpl.access$000(this.this$0);
    j = this.b.n;
    if (bool) {
      i = 1;
    } else {
      i = 2;
    }
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(l1);
    localStringBuilder2.append("");
    ReportController.b(localAppInterface, "dc00898", "", "", "0X8009955", "0X8009955", j, i, localStringBuilder2.toString(), "", (String)localObject, str1);
    TenDocLogReportHelper.a("TeamWorkFileImportHandlerImpl", "http duration", String.valueOf(l1), this.b.A);
    if (!bool) {
      if ((!this.b.b()) && (FileUtil.b(this.b.d)))
      {
        TenDocLogReportHelper.a("TeamWorkFileImportHandlerImpl", "import fail", "url import fail, try local file import", this.b.A);
        this.this$0.removeFileImporting(this.b);
        localObject = this.b;
        try
        {
          if (!TextUtils.isEmpty(str2)) {
            i = new JSONObject(str2).getInt("ret");
          }
        }
        catch (JSONException localJSONException2)
        {
          QLog.e("TeamWorkFileImportHandlerImpl", 1, localJSONException2.toString());
          i = 0;
        }
        if ((i != 20003) && (i != 20005))
        {
          ((TeamWorkFileImportInfo)localObject).m = false;
          this.this$0.addFileImportJob((TeamWorkFileImportInfo)localObject);
        }
      }
      else if (TeamWorkFileImportHandlerImpl.access$100(this.this$0) != null)
      {
        localObject = TeamWorkFileImportHandlerImpl.access$100(this.this$0).obtainMessage(8002);
        ((Message)localObject).obj = this.b;
        TeamWorkFileImportHandlerImpl.access$100(this.this$0).sendMessage((Message)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl.3
 * JD-Core Version:    0.7.0.1
 */