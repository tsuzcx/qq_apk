package com.tencent.replacemonitor.replace.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.tmassistant.common.a.c;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmdownloader.internal.storage.a.a;
import java.io.PrintStream;
import java.util.ArrayList;

public class b
  implements c
{
  private MonitorTask a(Cursor paramCursor)
  {
    MonitorTask localMonitorTask = new MonitorTask();
    localMonitorTask.id = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
    localMonitorTask.packageName = paramCursor.getString(paramCursor.getColumnIndex("pkg_name"));
    localMonitorTask.versionCode = paramCursor.getInt(paramCursor.getColumnIndex("version_code"));
    localMonitorTask.appName = paramCursor.getString(paramCursor.getColumnIndex("app_name"));
    localMonitorTask.fileSize = paramCursor.getLong(paramCursor.getColumnIndex("file_size"));
    localMonitorTask.fileMd5 = paramCursor.getString(paramCursor.getColumnIndex("file_md5"));
    localMonitorTask.cpChannelId = paramCursor.getString(paramCursor.getColumnIndex("channel_id"));
    localMonitorTask.filePath = paramCursor.getString(paramCursor.getColumnIndex("file_path"));
    localMonitorTask.downloadUrl = paramCursor.getString(paramCursor.getColumnIndex("download_url"));
    localMonitorTask.yybAppId = paramCursor.getLong(paramCursor.getColumnIndex("yyb_app_id"));
    localMonitorTask.yybApkId = paramCursor.getLong(paramCursor.getColumnIndex("yyb_apk_id"));
    localMonitorTask.installDir = paramCursor.getString(paramCursor.getColumnIndex("install_dir"));
    localMonitorTask.lastModifedTime = paramCursor.getLong(paramCursor.getColumnIndex("last_modify_time"));
    localMonitorTask.additionalId = paramCursor.getString(paramCursor.getColumnIndex("task_id"));
    localMonitorTask.traceId = paramCursor.getString(paramCursor.getColumnIndex("trace_id"));
    localMonitorTask.appType = paramCursor.getInt(paramCursor.getColumnIndex("app_type"));
    int i = paramCursor.getInt(paramCursor.getColumnIndex("last_step"));
    if ((MonitorStep.values().length > i) && (i >= 0))
    {
      localMonitorTask.lastStep = MonitorStep.values()[i];
    }
    else
    {
      localMonitorTask.lastStep = MonitorStep.DOWNLOADING;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Bad MonitorStep index:");
      localStringBuilder.append(i);
      ab.e("MonitorTaskTable", localStringBuilder.toString());
    }
    i = paramCursor.getInt(paramCursor.getColumnIndex("is_tdownload"));
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localMonitorTask.isTencentDownload = bool;
    localMonitorTask.externalParams = com.tencent.tmassistantbase.util.d.a(paramCursor.getString(paramCursor.getColumnIndex("external_param")), "&");
    return localMonitorTask;
  }
  
  private ContentValues d(MonitorTask paramMonitorTask)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public long a(MonitorTask paramMonitorTask)
  {
    long l = -1L;
    if (paramMonitorTask == null) {
      return -1L;
    }
    paramMonitorTask = d(paramMonitorTask);
    SQLiteDatabase localSQLiteDatabase = b().getWritableDatabase();
    if (localSQLiteDatabase != null) {
      l = localSQLiteDatabase.insert("monitor_task_table", null, paramMonitorTask);
    }
    return l;
  }
  
  public MonitorTask a(long paramLong)
  {
    Object localObject2 = null;
    if (paramLong <= 0L) {
      return null;
    }
    Object localObject1 = b().getReadableDatabase();
    if (localObject1 == null) {
      return null;
    }
    Cursor localCursor = ((SQLiteDatabase)localObject1).query("monitor_task_table", null, "_id =?", new String[] { String.valueOf(paramLong) }, null, null, null);
    localObject1 = localObject2;
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst()) {
        localObject1 = a(localCursor);
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    return localObject1;
  }
  
  public MonitorTask a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    Object localObject2 = b().getReadableDatabase();
    if (localObject2 == null) {
      return null;
    }
    localObject2 = ((SQLiteDatabase)localObject2).query("monitor_task_table", null, "task_id =?", new String[] { paramString }, null, null, null);
    paramString = localObject1;
    if (localObject2 != null)
    {
      paramString = localObject1;
      if (((Cursor)localObject2).moveToFirst()) {
        paramString = a((Cursor)localObject2);
      }
    }
    if (localObject2 != null) {
      ((Cursor)localObject2).close();
    }
    return paramString;
  }
  
  public ArrayList<MonitorTask> a()
  {
    Object localObject1 = b().getReadableDatabase();
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    Cursor localCursor = ((SQLiteDatabase)localObject1).query("monitor_task_table", null, null, null, null, null, null);
    localObject1 = localObject2;
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst())
      {
        localObject1 = new ArrayList();
        do
        {
          ((ArrayList)localObject1).add(a(localCursor));
        } while (localCursor.moveToNext());
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    return localObject1;
  }
  
  public com.tencent.tmassistant.common.a.d b()
  {
    return a.c();
  }
  
  public boolean b(MonitorTask paramMonitorTask)
  {
    Object localObject1 = System.out;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Thread.currentThread().getName());
    ((StringBuilder)localObject2).append(" update task.id = ");
    ((StringBuilder)localObject2).append(paramMonitorTask.id);
    ((PrintStream)localObject1).print(((StringBuilder)localObject2).toString());
    localObject1 = d(paramMonitorTask);
    localObject2 = b().getWritableDatabase();
    boolean bool = false;
    if (localObject2 != null) {
      try
      {
        long l = paramMonitorTask.id;
        if (l > 0L)
        {
          if (((SQLiteDatabase)localObject2).update("monitor_task_table", (ContentValues)localObject1, "_id =?", new String[] { String.valueOf(paramMonitorTask.id) }) <= 0) {
            break label222;
          }
          return true;
        }
        if (!TextUtils.isEmpty(paramMonitorTask.additionalId))
        {
          int i = ((SQLiteDatabase)localObject2).update("monitor_task_table", (ContentValues)localObject1, "task_id =?", new String[] { paramMonitorTask.additionalId });
          if (i > 0) {
            bool = true;
          }
          return bool;
        }
      }
      catch (Throwable paramMonitorTask)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(">update error:");
        ((StringBuilder)localObject1).append(paramMonitorTask.getMessage());
        ((StringBuilder)localObject1).append("|");
        ((StringBuilder)localObject1).append(paramMonitorTask.getCause());
        ab.e("MonitorTaskTable", ((StringBuilder)localObject1).toString());
      }
    } else {
      return false;
    }
    label222:
    return false;
  }
  
  public int c(MonitorTask paramMonitorTask)
  {
    if (paramMonitorTask == null) {
      return -1;
    }
    SQLiteDatabase localSQLiteDatabase = b().getWritableDatabase();
    if (localSQLiteDatabase == null) {
      return -1;
    }
    try
    {
      int i = localSQLiteDatabase.delete("monitor_task_table", "_id =?", new String[] { String.valueOf(paramMonitorTask.id) });
      return i;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(">delete error:");
      localStringBuilder.append(localException.getMessage());
      localStringBuilder.append("|");
      localStringBuilder.append(localException.getCause());
      localStringBuilder.append("|");
      localStringBuilder.append(paramMonitorTask);
      ab.e("MonitorTaskTable", localStringBuilder.toString());
    }
    return -1;
  }
  
  public String createTableSQL()
  {
    return "CREATE TABLE if not exists monitor_task_table(_id INTEGER PRIMARY KEY AUTOINCREMENT,pkg_name TEXT,version_code INTEGER,app_name TEXT,file_size INTEGER,channel_id TEXT,file_path TEXT,download_url TEXT,file_md5 TEXT,install_dir TEXT,last_modify_time INTEGER,yyb_apk_id INTEGER,yyb_app_id INTEGER,trace_id TEXT,task_id TEXT,app_type INTEGER,last_step INTEGER,is_tdownload INTEGER,external_param TEXT);";
  }
  
  public String[] getAlterSQL(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">getAlterSQL ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    ab.c("MonitorTaskTable", localStringBuilder.toString());
    if ((paramInt1 == 7) && (paramInt2 == 8)) {
      return new String[] { "alter table monitor_task_table add column is_tdownload INTEGER;", "alter table monitor_task_table add column external_param TEXT;" };
    }
    return null;
  }
  
  public String tableName()
  {
    return "monitor_task_table";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.b.b
 * JD-Core Version:    0.7.0.1
 */