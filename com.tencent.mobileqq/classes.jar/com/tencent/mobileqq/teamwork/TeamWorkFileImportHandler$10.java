package com.tencent.mobileqq.teamwork;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class TeamWorkFileImportHandler$10
  implements Runnable
{
  TeamWorkFileImportHandler$10(TeamWorkFileImportHandler paramTeamWorkFileImportHandler, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if ((TeamWorkFileImportHandler.a(this.this$0) == null) || (this.a == null) || (TextUtils.isEmpty(this.a.c))) {
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = TeamWorkHttpUtils.c(this.a, TeamWorkFileImportHandler.a(this.this$0).getCurrentAccountUin());
    long l2 = System.currentTimeMillis();
    Object localObject2 = "";
    if (localObject1 != null) {}
    for (boolean bool = this.this$0.a((String)localObject1, this.a);; bool = false)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1).getString("url");
        localObject2 = localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QQAppInterface localQQAppInterface;
          int i;
          QLog.e("TeamWorkFileImportHandler", 1, localException.toString());
          continue;
          String str;
          if (this.a.e == 6)
          {
            str = "excel";
          }
          else if (this.a.e == 7)
          {
            str = "ppt";
          }
          else if (this.a.e == 9)
          {
            str = "pdf";
            continue;
            i = 2;
          }
        }
      }
      localObject1 = HardCodeUtil.a(2131714685);
      if (this.a.e == 3)
      {
        localObject1 = "word";
        localQQAppInterface = TeamWorkFileImportHandler.a(this.this$0);
        if (!bool) {
          continue;
        }
        i = 1;
        ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009958", "0X8009958", 0, i, l2 - l1 + "", "", (String)localObject1, (String)localObject2);
        if ((bool) || (TeamWorkFileImportHandler.a(this.this$0) == null)) {
          break;
        }
        localObject1 = TeamWorkFileImportHandler.a(this.this$0).obtainMessage(8002);
        ((Message)localObject1).obj = this.a;
        TeamWorkFileImportHandler.a(this.this$0).sendMessage((Message)localObject1);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.10
 * JD-Core Version:    0.7.0.1
 */