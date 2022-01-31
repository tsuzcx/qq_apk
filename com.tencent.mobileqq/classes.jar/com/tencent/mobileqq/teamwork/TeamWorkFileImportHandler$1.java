package com.tencent.mobileqq.teamwork;

import alpo;
import android.os.Handler;
import android.os.Message;
import aotz;
import aoua;
import azmj;
import bacn;
import badg;
import badt;
import bafi;
import bdcs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$1
  implements Runnable
{
  public TeamWorkFileImportHandler$1(bacn parambacn, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    boolean bool2 = bdcs.b(this.a.c);
    boolean bool1;
    if (!bool2)
    {
      bool1 = false;
      if ((this.this$0.app != null) && (bool2) && (bool1)) {
        break label178;
      }
      bafi.a("TeamWorkFileImportHandler", "import fail", "filePath is null or app is null", this.a.k);
      if (bacn.a(this.this$0) != null)
      {
        localObject1 = bacn.a(this.this$0).obtainMessage(8002);
        ((Message)localObject1).obj = this.a;
        if (bool2) {
          break label156;
        }
        this.a.h = BaseApplicationImpl.getApplication().getString(2131720670);
      }
    }
    for (;;)
    {
      bacn.a(this.this$0).sendMessage((Message)localObject1);
      return;
      bool1 = badt.a(aoua.a().a(), this.a.c, this.a.b, this.a.jdField_d_of_type_Long);
      break;
      label156:
      if (!bool1) {
        this.a.h = BaseApplicationImpl.getApplication().getString(2131720663);
      }
    }
    label178:
    long l1 = System.currentTimeMillis();
    Object localObject1 = badg.a(this.a, this.this$0.app.getCurrentAccountUin());
    long l2 = System.currentTimeMillis();
    Object localObject2 = "";
    if (localObject1 != null)
    {
      bool1 = bacn.a(this.this$0, (String)localObject1, this.a);
      try
      {
        localObject1 = new JSONObject((String)localObject1).getString("url");
        localObject2 = localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label250:
          QQAppInterface localQQAppInterface;
          int j;
          QLog.e("TeamWorkFileImportHandler", 1, localException.toString());
        }
      }
      localObject1 = alpo.a(2131715181);
      if (this.a.e != 3) {
        break label440;
      }
      localObject1 = "word";
      label272:
      localQQAppInterface = this.this$0.app;
      j = this.a.jdField_d_of_type_Int;
      if (!bool1) {
        break label497;
      }
    }
    label440:
    label497:
    for (int i = 1;; i = 2)
    {
      azmj.b(localQQAppInterface, "dc00898", "", "", "0X8009955", "0X8009955", j, i, l2 - l1 + "", "", (String)localObject1, (String)localObject2);
      if ((bool1) || (bacn.a(this.this$0) == null)) {
        break;
      }
      localObject1 = bacn.a(this.this$0).obtainMessage(8002);
      ((Message)localObject1).obj = this.a;
      bacn.a(this.this$0).sendMessage((Message)localObject1);
      return;
      this.a.f = -1000;
      bafi.a("TeamWorkFileImportHandler", "import fail", "local file network fail", this.a.k);
      bool1 = false;
      break label250;
      if (this.a.e == 6)
      {
        str = "excel";
        break label272;
      }
      if (this.a.e == 7)
      {
        str = "ppt";
        break label272;
      }
      if (this.a.e != 9) {
        break label272;
      }
      String str = "pdf";
      break label272;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.1
 * JD-Core Version:    0.7.0.1
 */