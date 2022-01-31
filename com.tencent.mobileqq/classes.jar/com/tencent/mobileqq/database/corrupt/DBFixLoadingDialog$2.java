package com.tencent.mobileqq.database.corrupt;

import amuj;
import awrn;
import beez;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class DBFixLoadingDialog$2
  implements Runnable
{
  public DBFixLoadingDialog$2(amuj paramamuj) {}
  
  public void run()
  {
    amuj.a(this.this$0, amuj.c);
    if (amuj.a(this.this$0).exists()) {
      amuj.a(this.this$0).delete();
    }
    long l1 = System.currentTimeMillis();
    Object localObject = (DBFixManager)amuj.a(this.this$0).getManager(205);
    DBFixResult localDBFixResult = new DBFixResult();
    QLog.d(amuj.a(), 1, new Object[] { "repair start, ", Integer.valueOf(amuj.a) });
    boolean bool;
    if (amuj.a == 1)
    {
      bool = ((DBFixManager)localObject).dumpRepair(amuj.b(this.this$0).getAbsolutePath(), amuj.a(this.this$0).getAbsolutePath(), localDBFixResult);
      long l2 = System.currentTimeMillis();
      QLog.d(amuj.a(), 1, new Object[] { "repair result, dur:", Double.valueOf(localDBFixResult.duration), ", row:", Long.valueOf(localDBFixResult.rowCount), ", table:", Long.valueOf(localDBFixResult.tableCount), ", sucPage:", Long.valueOf(localDBFixResult.sucPageCount), ", failPage:", Long.valueOf(localDBFixResult.failPageCount) });
      if (!bool) {
        break label622;
      }
      long l3 = amuj.b(this.this$0).length();
      long l4 = amuj.a(this.this$0).length();
      String str = amuj.a();
      if (amuj.a != 1) {
        break label615;
      }
      localObject = "dump";
      label273:
      QLog.d(str, 1, String.format("修复方式：%s 修复成功，耗时%dms，源文件：%dkB，修复后：%dkB", new Object[] { localObject, Long.valueOf(l2 - l1), Long.valueOf(l3 / 1024L), Long.valueOf(l4 / 1024L) }));
      localObject = new HashMap();
      ((HashMap)localObject).put("fixType", String.valueOf(amuj.a));
      ((HashMap)localObject).put("duration_1", String.valueOf((int)(localDBFixResult.duration * 1000.0D)));
      ((HashMap)localObject).put("duration_2", String.valueOf(l2 - l1));
      ((HashMap)localObject).put("rowCount", String.valueOf(localDBFixResult.rowCount));
      ((HashMap)localObject).put("tableCount", String.valueOf(localDBFixResult.tableCount));
      ((HashMap)localObject).put("sucPage", String.valueOf(localDBFixResult.sucPageCount));
      ((HashMap)localObject).put("failPage", String.valueOf(localDBFixResult.failPageCount));
      ((HashMap)localObject).put("oldSize", String.valueOf(l3 / 1024L));
      ((HashMap)localObject).put("fixSize", String.valueOf(l4 / 1024L));
      ((HashMap)localObject).put("fixSpeed", String.valueOf((float)(l3 / 1024L) / (float)(l2 - l1)));
      awrn.a(BaseApplication.getContext()).a(null, DBFixManager.h, true, -1L, 0L, (HashMap)localObject, null, true);
      label530:
      localObject = this.this$0;
      if (!bool) {
        break label640;
      }
    }
    label640:
    for (int i = amuj.d;; i = amuj.e)
    {
      amuj.a((amuj)localObject, i);
      amuj.a(this.this$0).removeMessages(amuj.f);
      amuj.a(this.this$0).sendEmptyMessageDelayed(amuj.f, 100L);
      return;
      bool = ((DBFixManager)localObject).dbfixRepair(amuj.b(this.this$0).getAbsolutePath(), amuj.a(this.this$0).getAbsolutePath(), localDBFixResult);
      break;
      label615:
      localObject = "dbRepair";
      break label273;
      label622:
      ((DBFixManager)localObject).a(false);
      QLog.d(amuj.a(), 1, "db fix failed");
      break label530;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog.2
 * JD-Core Version:    0.7.0.1
 */