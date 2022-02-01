package com.tencent.mobileqq.teamwork;

import android.os.Handler;
import android.os.Message;
import anvx;
import arog;
import aroh;
import bdla;
import bebl;
import bece;
import becr;
import beeg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$1
  implements Runnable
{
  public TeamWorkFileImportHandler$1(bebl parambebl, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    boolean bool2 = this.a.b();
    boolean bool3 = FileUtils.fileExistsAndNotEmpty(this.a.c);
    boolean bool1;
    if (!bool3)
    {
      bool1 = false;
      if ((bool2) || ((this.this$0.app != null) && (bool3) && (bool1))) {
        break label192;
      }
      beeg.a("TeamWorkFileImportHandler", "import fail", "filePath is null or app is null", this.a.k);
      if (bebl.a(this.this$0) != null)
      {
        localObject1 = bebl.a(this.this$0).obtainMessage(8002);
        ((Message)localObject1).obj = this.a;
        if (bool3) {
          break label170;
        }
        this.a.h = BaseApplicationImpl.getApplication().getString(2131719254);
      }
    }
    for (;;)
    {
      bebl.a(this.this$0).sendMessage((Message)localObject1);
      return;
      bool1 = becr.a(aroh.a().a(), this.a.c, this.a.b, this.a.jdField_d_of_type_Long);
      break;
      label170:
      if (!bool1) {
        this.a.h = BaseApplicationImpl.getApplication().getString(2131719247);
      }
    }
    label192:
    long l1 = System.currentTimeMillis();
    Object localObject1 = bece.a(this.a, this.this$0.app.getCurrentAccountUin());
    long l2 = System.currentTimeMillis();
    Object localObject2 = "";
    if (localObject1 != null)
    {
      bool1 = bebl.a(this.this$0, (String)localObject1, this.a);
      try
      {
        localObject1 = new JSONObject((String)localObject1).getString("url");
        localObject2 = localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label264:
          QQAppInterface localQQAppInterface;
          int j;
          QLog.e("TeamWorkFileImportHandler", 1, localException.toString());
        }
      }
      localObject1 = anvx.a(2131714181);
      if (this.a.e != 3) {
        break label454;
      }
      localObject1 = "word";
      label286:
      localQQAppInterface = this.this$0.app;
      j = this.a.jdField_d_of_type_Int;
      if (!bool1) {
        break label511;
      }
    }
    label454:
    label511:
    for (int i = 1;; i = 2)
    {
      bdla.b(localQQAppInterface, "dc00898", "", "", "0X8009955", "0X8009955", j, i, l2 - l1 + "", "", (String)localObject1, (String)localObject2);
      if ((bool1) || (bebl.a(this.this$0) == null)) {
        break;
      }
      localObject1 = bebl.a(this.this$0).obtainMessage(8002);
      ((Message)localObject1).obj = this.a;
      bebl.a(this.this$0).sendMessage((Message)localObject1);
      return;
      this.a.f = -1000;
      beeg.a("TeamWorkFileImportHandler", "import fail", "local file network fail", this.a.k);
      bool1 = false;
      break label264;
      if (this.a.e == 6)
      {
        str = "excel";
        break label286;
      }
      if (this.a.e == 7)
      {
        str = "ppt";
        break label286;
      }
      if (this.a.e != 9) {
        break label286;
      }
      String str = "pdf";
      break label286;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.1
 * JD-Core Version:    0.7.0.1
 */