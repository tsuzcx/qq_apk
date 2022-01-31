package com.tencent.mobileqq.teamwork;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import axem;
import axfe;
import axhg;
import com.tencent.mobileqq.app.QQAppInterface;

public class TeamWorkFileImportHandler$4
  implements Runnable
{
  public TeamWorkFileImportHandler$4(axem paramaxem, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (TextUtils.isEmpty(this.a.jdField_f_of_type_JavaLangString))) {
      axhg.a("TeamWorkFileImportHandler", "import fail", "srcUrl is null or app is null", this.a.k);
    }
    for (;;)
    {
      return;
      Object localObject = axfe.b(this.a, this.this$0.app.getCurrentAccountUin());
      boolean bool = false;
      if (localObject != null) {
        bool = axem.b(this.this$0, (String)localObject, this.a);
      }
      while ((!bool) && (axem.a(this.this$0) != null))
      {
        localObject = axem.a(this.this$0).obtainMessage(8002);
        ((Message)localObject).obj = this.a;
        axem.a(this.this$0).sendMessage((Message)localObject);
        return;
        this.a.jdField_f_of_type_Int = -1000;
        axhg.a("TeamWorkFileImportHandler", "import fail", "url2doc network fail", this.a.k);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.4
 * JD-Core Version:    0.7.0.1
 */