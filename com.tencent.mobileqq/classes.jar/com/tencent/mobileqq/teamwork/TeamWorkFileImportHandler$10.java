package com.tencent.mobileqq.teamwork;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import anzj;
import bdll;
import beav;
import bebo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$10
  implements Runnable
{
  public TeamWorkFileImportHandler$10(beav parambeav, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (this.a == null) || (TextUtils.isEmpty(this.a.c))) {
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = bebo.c(this.a, this.this$0.app.getCurrentAccountUin());
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
      localObject1 = anzj.a(2131713610);
      if (this.a.e == 3)
      {
        localObject1 = "word";
        localQQAppInterface = this.this$0.app;
        if (!bool) {
          continue;
        }
        i = 1;
        bdll.b(localQQAppInterface, "dc00898", "", "", "0X8009958", "0X8009958", 0, i, l2 - l1 + "", "", (String)localObject1, (String)localObject2);
        if ((bool) || (beav.a(this.this$0) == null)) {
          break;
        }
        localObject1 = beav.a(this.this$0).obtainMessage(8002);
        ((Message)localObject1).obj = this.a;
        beav.a(this.this$0).sendMessage((Message)localObject1);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.10
 * JD-Core Version:    0.7.0.1
 */