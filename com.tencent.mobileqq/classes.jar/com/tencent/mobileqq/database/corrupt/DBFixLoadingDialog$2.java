package com.tencent.mobileqq.database.corrupt;

import com.tencent.dbfix.DBFix;
import com.tencent.dbfix.DBFixResult;
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
    DBFixReportHelper.a(DBFixLoadingDialog.a);
    DBFixLoadingDialog.a(this.this$0, DBFixLoadingDialog.c);
    if (DBFixLoadingDialog.a(this.this$0).exists()) {
      DBFixLoadingDialog.a(this.this$0).delete();
    }
    long l4 = System.currentTimeMillis();
    Object localObject2 = (DBFixManager)DBFixLoadingDialog.b(this.this$0).getManager(QQManagerFactory.DB_FIX_MANAGER);
    Object localObject1 = new DBFixResult();
    String str = DBFixLoadingDialog.b();
    int i = 0;
    QLog.d(str, 1, new Object[] { "repair start, ", Integer.valueOf(DBFixLoadingDialog.a) });
    boolean bool;
    if (DBFixLoadingDialog.a == 1) {
      bool = DBFix.getInstance().doDumpRepair(DBFixLoadingDialog.c(this.this$0).getAbsolutePath(), DBFixLoadingDialog.a(this.this$0).getAbsolutePath(), (DBFixResult)localObject1);
    } else {
      bool = DBFix.getInstance().doDBFixRepair(DBFixLoadingDialog.c(this.this$0).getAbsolutePath(), DBFixLoadingDialog.a(this.this$0).getAbsolutePath(), DBFixLoadingDialog.d(this.this$0).getAbsolutePath(), (DBFixResult)localObject1);
    }
    long l5 = System.currentTimeMillis();
    QLog.d(DBFixLoadingDialog.b(), 1, new Object[] { "repair result, dur:", Double.valueOf(((DBFixResult)localObject1).duration), ", row:", Long.valueOf(((DBFixResult)localObject1).rowCount), ", table:", Long.valueOf(((DBFixResult)localObject1).tableCount), ", sucPage:", Long.valueOf(((DBFixResult)localObject1).sucPageCount), ", failPage:", Long.valueOf(((DBFixResult)localObject1).failPageCount), ", masterCorrupted:", Integer.valueOf(((DBFixResult)localObject1).masterCorrupted) });
    long l3 = DBFixLoadingDialog.c(this.this$0).length();
    long l1 = DBFixLoadingDialog.a(this.this$0).length();
    long l2 = DBFixLoadingDialog.d(this.this$0).length();
    if (bool)
    {
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("fixType", String.valueOf(DBFixLoadingDialog.a));
      ((HashMap)localObject2).put("duration_1", String.valueOf((int)(((DBFixResult)localObject1).duration * 1000.0D)));
      l4 = l5 - l4;
      ((HashMap)localObject2).put("duration_2", String.valueOf(l4));
      ((HashMap)localObject2).put("rowCount", String.valueOf(((DBFixResult)localObject1).rowCount));
      ((HashMap)localObject2).put("tableCount", String.valueOf(((DBFixResult)localObject1).tableCount));
      ((HashMap)localObject2).put("sucPage", String.valueOf(((DBFixResult)localObject1).sucPageCount));
      ((HashMap)localObject2).put("failPage", String.valueOf(((DBFixResult)localObject1).failPageCount));
      l3 /= 1024L;
      ((HashMap)localObject2).put("oldSize", String.valueOf(l3));
      l5 = l1 / 1024L;
      ((HashMap)localObject2).put("fixSize", String.valueOf(l5));
      ((HashMap)localObject2).put("fixSpeed", String.valueOf((float)l3 / (float)l4));
      ((HashMap)localObject2).put("masterCorrupted", String.valueOf(((DBFixResult)localObject1).masterCorrupted));
      localObject1 = "dump";
      if (l1 != 0L)
      {
        str = DBFixLoadingDialog.b();
        if (DBFixLoadingDialog.a != 1) {
          localObject1 = "dbRepair";
        }
        QLog.d(str, 1, String.format("修复方式：%s 修复成功，耗时%dms，源文件：%dkB，修复后：%dkB，master备份：%dkB", new Object[] { localObject1, Long.valueOf(l4), Long.valueOf(l3), Long.valueOf(l5), Long.valueOf(l2 / 1024L) }));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, DBFixManager.p, true, -1L, 0L, (HashMap)localObject2, null, true);
      }
      else
      {
        str = DBFixLoadingDialog.b();
        if (DBFixLoadingDialog.a != 1) {
          localObject1 = "dbRepair";
        }
        QLog.d(str, 1, String.format("修复方式：%s 修复结果为0，耗时%dms，源文件：%dkB，修复后：%dkB，master备份：%dkB", new Object[] { localObject1, Long.valueOf(l4), Long.valueOf(l3), Integer.valueOf(0), Long.valueOf(l2 / 1024L) }));
        this.this$0.a();
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, DBFixManager.o, true, -1L, 0L, (HashMap)localObject2, null, true);
        i = 1;
      }
    }
    else
    {
      ((DBFixManager)localObject2).a(false);
      QLog.d(DBFixLoadingDialog.b(), 1, "db fix failed");
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
    DBFixLoadingDialog.e(this.this$0).removeMessages(DBFixLoadingDialog.g);
    DBFixLoadingDialog.e(this.this$0).sendEmptyMessageDelayed(DBFixLoadingDialog.g, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog.2
 * JD-Core Version:    0.7.0.1
 */