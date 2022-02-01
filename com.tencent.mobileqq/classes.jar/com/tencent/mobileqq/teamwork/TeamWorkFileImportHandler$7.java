package com.tencent.mobileqq.teamwork;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bebl;
import bece;
import beeg;
import com.tencent.mobileqq.app.QQAppInterface;

public class TeamWorkFileImportHandler$7
  implements Runnable
{
  public TeamWorkFileImportHandler$7(bebl parambebl, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (TextUtils.isEmpty(this.a.jdField_f_of_type_JavaLangString))) {
      beeg.a("TeamWorkFileImportHandler", "import fail", "srcUrl is null or app is null", this.a.k);
    }
    for (;;)
    {
      return;
      Object localObject = bece.b(this.a, this.this$0.app.getCurrentAccountUin());
      boolean bool = false;
      if (localObject != null) {
        bool = bebl.b(this.this$0, (String)localObject, this.a);
      }
      while ((!bool) && (bebl.a(this.this$0) != null))
      {
        localObject = bebl.a(this.this$0).obtainMessage(8002);
        ((Message)localObject).obj = this.a;
        bebl.a(this.this$0).sendMessage((Message)localObject);
        return;
        this.a.jdField_f_of_type_Int = -1000;
        beeg.a("TeamWorkFileImportHandler", "import fail", "url2doc network fail", this.a.k);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.7
 * JD-Core Version:    0.7.0.1
 */