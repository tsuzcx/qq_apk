package com.tencent.mobileqq.teamwork;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bcef;
import bcum;
import bcvf;
import bcxh;
import com.tencent.mobileqq.app.QQAppInterface;

public class TeamWorkFileImportHandler$2
  implements Runnable
{
  public TeamWorkFileImportHandler$2(bcum parambcum, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    boolean bool = false;
    if ((this.this$0.app == null) || (TextUtils.isEmpty(this.a.c))) {}
    for (;;)
    {
      return;
      Object localObject = bcvf.a(this.a, this.this$0.app.getCurrentAccountUin());
      if (localObject != null)
      {
        bool = bcum.a(this.this$0, (String)localObject, this.a);
        if (!bool) {
          break label163;
        }
        bcef.b(this.this$0.app, "dc00898", "", "", "0X80098F9", "0X80098F9", 0, 0, "", "", "", "");
      }
      label163:
      while ((!bool) && (bcum.a(this.this$0) != null))
      {
        localObject = bcum.a(this.this$0).obtainMessage(8002);
        ((Message)localObject).obj = this.a;
        bcum.a(this.this$0).sendMessage((Message)localObject);
        return;
        bcxh.a("TeamWorkFileImportHandler", "import fail", "local file dataLine parse no result string", this.a.k);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.2
 * JD-Core Version:    0.7.0.1
 */