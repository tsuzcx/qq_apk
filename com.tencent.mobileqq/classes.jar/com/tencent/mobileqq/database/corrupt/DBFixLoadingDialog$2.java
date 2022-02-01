package com.tencent.mobileqq.database.corrupt;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.util.HashMap;

class DBFixLoadingDialog$2
  implements Runnable
{
  DBFixLoadingDialog$2(DBFixLoadingDialog paramDBFixLoadingDialog) {}
  
  public void run()
  {
    DBFixLoadingDialog.a(this.this$0, DBFixLoadingDialog.c);
    if (DBFixLoadingDialog.a(this.this$0).exists()) {
      DBFixLoadingDialog.a(this.this$0).delete();
    }
    long l3 = System.currentTimeMillis();
    Object localObject2 = (DBFixManager)DBFixLoadingDialog.a(this.this$0).getManager(QQManagerFactory.DB_FIX_MANAGER);
    Object localObject1 = new DBFixResult();
    String str = DBFixLoadingDialog.a();
    int i = 0;
    QLog.d(str, 1, new Object[] { "repair start, ", Integer.valueOf(DBFixLoadingDialog.a) });
    boolean bool;
    if (DBFixLoadingDialog.a == 1) {
      bool = ((DBFixManager)localObject2).dumpRepair(DBFixLoadingDialog.b(this.this$0).getAbsolutePath(), DBFixLoadingDialog.a(this.this$0).getAbsolutePath(), (DBFixResult)localObject1);
    } else {
      bool = ((DBFixManager)localObject2).dbfixRepair(DBFixLoadingDialog.b(this.this$0).getAbsolutePath(), DBFixLoadingDialog.a(this.this$0).getAbsolutePath(), (DBFixResult)localObject1);
    }
    long l4 = System.currentTimeMillis();
    QLog.d(DBFixLoadingDialog.a(), 1, new Object[] { "repair result, dur:", Double.valueOf(((DBFixResult)localObject1).duration), ", row:", Long.valueOf(((DBFixResult)localObject1).rowCount), ", table:", Long.valueOf(((DBFixResult)localObject1).tableCount), ", sucPage:", Long.valueOf(((DBFixResult)localObject1).sucPageCount), ", failPage:", Long.valueOf(((DBFixResult)localObject1).failPageCount) });
    long l2 = DBFixLoadingDialog.b(this.this$0).length();
    long l1 = DBFixLoadingDialog.a(this.this$0).length();
    if (bool)
    {
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("fixType", String.valueOf(DBFixLoadingDialog.a));
      ((HashMap)localObject2).put("duration_1", String.valueOf((int)(((DBFixResult)localObject1).duration * 1000.0D)));
      l3 = l4 - l3;
      ((HashMap)localObject2).put("duration_2", String.valueOf(l3));
      ((HashMap)localObject2).put("rowCount", String.valueOf(((DBFixResult)localObject1).rowCount));
      ((HashMap)localObject2).put("tableCount", String.valueOf(((DBFixResult)localObject1).tableCount));
      ((HashMap)localObject2).put("sucPage", String.valueOf(((DBFixResult)localObject1).sucPageCount));
      ((HashMap)localObject2).put("failPage", String.valueOf(((DBFixResult)localObject1).failPageCount));
      l2 /= 1024L;
      ((HashMap)localObject2).put("oldSize", String.valueOf(l2));
      l4 = l1 / 1024L;
      ((HashMap)localObject2).put("fixSize", String.valueOf(l4));
      ((HashMap)localObject2).put("fixSpeed", String.valueOf((float)l2 / (float)l3));
      localObject1 = "dbRepair";
      if (l1 != 0L)
      {
        str = DBFixLoadingDialog.a();
        if (DBFixLoadingDialog.a == 1) {
          localObject1 = "dump";
        }
        QLog.d(str, 1, String.format("修复方式：%s 修复成功，耗时%dms，源文件：%dkB，修复后：%dkB", new Object[] { localObject1, Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l4) }));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, DBFixManager.i, true, -1L, 0L, (HashMap)localObject2, null, true);
      }
      else
      {
        str = DBFixLoadingDialog.a();
        if (DBFixLoadingDialog.a == 1) {
          localObject1 = "dump";
        }
        QLog.d(str, 1, String.format("修复方式：%s 修复结果为0，耗时%dms，源文件：%dkB，修复后：%dkB", new Object[] { localObject1, Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l4) }));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, DBFixManager.h, true, -1L, 0L, (HashMap)localObject2, null, true);
        i = 1;
      }
    }
    else
    {
      ((DBFixManager)localObject2).a(false);
      QLog.d(DBFixLoadingDialog.a(), 1, "db fix failed");
    }
    localObject1 = this.this$0;
    if (bool)
    {
      if (i != 0) {
        i = DBFixLoadingDialog.f;
      } else {
        i = DBFixLoadingDialog.d;
      }
    }
    else {
      i = DBFixLoadingDialog.e;
    }
    DBFixLoadingDialog.a((DBFixLoadingDialog)localObject1, i);
    DBFixLoadingDialog.a(this.this$0).removeMessages(DBFixLoadingDialog.g);
    DBFixLoadingDialog.a(this.this$0).sendEmptyMessageDelayed(DBFixLoadingDialog.g, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog.2
 * JD-Core Version:    0.7.0.1
 */