package com.tencent.mobileqq.teamwork;

import ajjy;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import awqx;
import axem;
import axfe;
import axhg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$1
  implements Runnable
{
  public TeamWorkFileImportHandler$1(axem paramaxem, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (TextUtils.isEmpty(this.a.c)))
    {
      axhg.a("TeamWorkFileImportHandler", "import fail", "filePath is null or app is null", this.a.k);
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = axfe.a(this.a, this.this$0.app.getCurrentAccountUin());
    long l2 = System.currentTimeMillis();
    Object localObject2 = "";
    boolean bool;
    if (localObject1 != null)
    {
      bool = axem.a(this.this$0, (String)localObject1, this.a);
      try
      {
        localObject1 = new JSONObject((String)localObject1).getString("url");
        localObject2 = localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label112:
          QQAppInterface localQQAppInterface;
          int j;
          QLog.e("TeamWorkFileImportHandler", 1, localException.toString());
        }
      }
      localObject1 = ajjy.a(2131649009);
      if (this.a.e != 3) {
        break label304;
      }
      localObject1 = "word";
      label134:
      localQQAppInterface = this.this$0.app;
      j = this.a.d;
      if (!bool) {
        break label361;
      }
    }
    label304:
    label361:
    for (int i = 1;; i = 2)
    {
      awqx.b(localQQAppInterface, "dc00898", "", "", "0X8009955", "0X8009955", j, i, l2 - l1 + "", "", (String)localObject1, (String)localObject2);
      if ((bool) || (axem.a(this.this$0) == null)) {
        break;
      }
      localObject1 = axem.a(this.this$0).obtainMessage(8002);
      ((Message)localObject1).obj = this.a;
      axem.a(this.this$0).sendMessage((Message)localObject1);
      return;
      this.a.f = -1000;
      axhg.a("TeamWorkFileImportHandler", "import fail", "local file network fail", this.a.k);
      bool = false;
      break label112;
      if (this.a.e == 6)
      {
        str = "excel";
        break label134;
      }
      if (this.a.e == 7)
      {
        str = "ppt";
        break label134;
      }
      if (this.a.e != 9) {
        break label134;
      }
      String str = "pdf";
      break label134;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.1
 * JD-Core Version:    0.7.0.1
 */