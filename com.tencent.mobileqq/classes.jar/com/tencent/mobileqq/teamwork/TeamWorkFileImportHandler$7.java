package com.tencent.mobileqq.teamwork;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import beav;
import bebo;
import bedq;
import com.tencent.mobileqq.app.QQAppInterface;

public class TeamWorkFileImportHandler$7
  implements Runnable
{
  public TeamWorkFileImportHandler$7(beav parambeav, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (TextUtils.isEmpty(this.a.jdField_f_of_type_JavaLangString))) {
      bedq.a("TeamWorkFileImportHandler", "import fail", "srcUrl is null or app is null", this.a.k);
    }
    for (;;)
    {
      return;
      Object localObject = bebo.b(this.a, this.this$0.app.getCurrentAccountUin());
      boolean bool = false;
      if (localObject != null) {
        bool = beav.b(this.this$0, (String)localObject, this.a);
      }
      while ((!bool) && (beav.a(this.this$0) != null))
      {
        localObject = beav.a(this.this$0).obtainMessage(8002);
        ((Message)localObject).obj = this.a;
        beav.a(this.this$0).sendMessage((Message)localObject);
        return;
        this.a.jdField_f_of_type_Int = -1000;
        bedq.a("TeamWorkFileImportHandler", "import fail", "url2doc network fail", this.a.k);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.7
 * JD-Core Version:    0.7.0.1
 */