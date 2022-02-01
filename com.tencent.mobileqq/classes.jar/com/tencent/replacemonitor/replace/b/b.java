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
    boolean bool = true;
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
    localMonitorTask.lastStep = MonitorStep.values()[paramCursor.getInt(paramCursor.getColumnIndex("last_step"))];
    if (paramCursor.getInt(paramCursor.getColumnIndex("is_tdownload")) == 1) {}
    for (;;)
    {
      localMonitorTask.isTencentDownload = bool;
      localMonitorTask.externalParams = com.tencent.tmassistantbase.util.d.a(paramCursor.getString(paramCursor.getColumnIndex("external_param")), "&");
      return localMonitorTask;
      bool = false;
    }
  }
  
  private ContentValues d(MonitorTask paramMonitorTask)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("pkg_name", paramMonitorTask.packageName);
    localContentValues.put("version_code", Integer.valueOf(paramMonitorTask.versionCode));
    localContentValues.put("app_name", paramMonitorTask.appName);
    localContentValues.put("file_size", Long.valueOf(paramMonitorTask.fileSize));
    localContentValues.put("channel_id", paramMonitorTask.cpChannelId);
    localContentValues.put("file_path", paramMonitorTask.filePath);
    localContentValues.put("download_url", paramMonitorTask.downloadUrl);
    localContentValues.put("file_md5", paramMonitorTask.fileMd5);
    localContentValues.put("install_dir", paramMonitorTask.installDir);
    localContentValues.put("last_modify_time", Long.valueOf(paramMonitorTask.lastModifedTime));
    localContentValues.put("yyb_app_id", Long.valueOf(paramMonitorTask.yybAppId));
    localContentValues.put("yyb_apk_id", Long.valueOf(paramMonitorTask.yybApkId));
    localContentValues.put("trace_id", paramMonitorTask.traceId);
    localContentValues.put("task_id", paramMonitorTask.additionalId);
    localContentValues.put("app_type", Integer.valueOf(paramMonitorTask.appType));
    if (paramMonitorTask.lastStep != null) {
      localContentValues.put("last_step", Integer.valueOf(paramMonitorTask.lastStep.ordinal()));
    }
    if (paramMonitorTask.isTencentDownload) {}
    for (int i = 1;; i = 0)
    {
      localContentValues.put("is_tdownload", Integer.valueOf(i));
      if (paramMonitorTask.externalParams != null) {
        localContentValues.put("external_param", com.tencent.tmassistantbase.util.d.a(paramMonitorTask.externalParams, "&"));
      }
      return localContentValues;
    }
  }
  
  public long a(MonitorTask paramMonitorTask)
  {
    if (paramMonitorTask == null) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return -1L;
      paramMonitorTask = d(paramMonitorTask);
      localSQLiteDatabase = b().getWritableDatabase();
    } while (localSQLiteDatabase == null);
    return localSQLiteDatabase.insert("monitor_task_table", null, paramMonitorTask);
  }
  
  public MonitorTask a(long paramLong)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    if (paramLong <= 0L) {}
    Object localObject1;
    Cursor localCursor;
    do
    {
      do
      {
        return localObject2;
        localObject1 = b().getReadableDatabase();
      } while (localObject1 == null);
      localCursor = ((SQLiteDatabase)localObject1).query("monitor_task_table", null, "_id =?", new String[] { String.valueOf(paramLong) }, null, null, null);
      localObject1 = localObject3;
      if (localCursor != null)
      {
        localObject1 = localObject3;
        if (localCursor.moveToFirst()) {
          localObject1 = a(localCursor);
        }
      }
      localObject2 = localObject1;
    } while (localCursor == null);
    localCursor.close();
    return localObject1;
  }
  
  public MonitorTask a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject3;
    do
    {
      do
      {
        return localObject1;
        localObject3 = b().getReadableDatabase();
      } while (localObject3 == null);
      localObject3 = ((SQLiteDatabase)localObject3).query("monitor_task_table", null, "task_id =?", new String[] { paramString }, null, null, null);
      paramString = localObject2;
      if (localObject3 != null)
      {
        paramString = localObject2;
        if (((Cursor)localObject3).moveToFirst()) {
          paramString = a((Cursor)localObject3);
        }
      }
      localObject1 = paramString;
    } while (localObject3 == null);
    ((Cursor)localObject3).close();
    return paramString;
  }
  
  public ArrayList<MonitorTask> a()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = b().getReadableDatabase();
    if (localObject3 == null) {
      localObject2 = localObject1;
    }
    do
    {
      return localObject2;
      localObject3 = ((SQLiteDatabase)localObject3).query("monitor_task_table", null, null, null, null, null, null);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((Cursor)localObject3).moveToFirst())
        {
          localObject1 = new ArrayList();
          do
          {
            ((ArrayList)localObject1).add(a((Cursor)localObject3));
          } while (((Cursor)localObject3).moveToNext());
        }
      }
      localObject2 = localObject1;
    } while (localObject3 == null);
    ((Cursor)localObject3).close();
    return localObject1;
  }
  
  public com.tencent.tmassistant.common.a.d b()
  {
    return a.c();
  }
  
  public boolean b(MonitorTask paramMonitorTask)
  {
    boolean bool = true;
    System.out.print(Thread.currentThread().getName() + " update task.id = " + paramMonitorTask.id);
    ContentValues localContentValues = d(paramMonitorTask);
    SQLiteDatabase localSQLiteDatabase = b().getWritableDatabase();
    if (localSQLiteDatabase != null) {
      try
      {
        if (paramMonitorTask.id > 0L)
        {
          if (localSQLiteDatabase.update("monitor_task_table", localContentValues, "_id =?", new String[] { String.valueOf(paramMonitorTask.id) }) <= 0) {
            break label186;
          }
          return true;
        }
        if (!TextUtils.isEmpty(paramMonitorTask.additionalId))
        {
          int i = localSQLiteDatabase.update("monitor_task_table", localContentValues, "task_id =?", new String[] { paramMonitorTask.additionalId });
          if (i > 0) {
            break label184;
          }
          return false;
        }
      }
      catch (Throwable paramMonitorTask)
      {
        ab.e("MonitorTaskTable", ">update error:" + paramMonitorTask.getMessage() + "|" + paramMonitorTask.getCause());
      }
    } else {
      bool = false;
    }
    label184:
    return bool;
    label186:
    return false;
  }
  
  public int c(MonitorTask paramMonitorTask)
  {
    if (paramMonitorTask == null) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return -1;
      localSQLiteDatabase = b().getWritableDatabase();
    } while (localSQLiteDatabase == null);
    try
    {
      int i = localSQLiteDatabase.delete("monitor_task_table", "_id =?", new String[] { String.valueOf(paramMonitorTask.id) });
      return i;
    }
    catch (Exception localException)
    {
      ab.e("MonitorTaskTable", ">delete error:" + localException.getMessage() + "|" + localException.getCause() + "|" + paramMonitorTask);
    }
    return -1;
  }
  
  public String createTableSQL()
  {
    return "CREATE TABLE if not exists monitor_task_table(_id INTEGER PRIMARY KEY AUTOINCREMENT,pkg_name TEXT,version_code INTEGER,app_name TEXT,file_size INTEGER,channel_id TEXT,file_path TEXT,download_url TEXT,file_md5 TEXT,install_dir TEXT,last_modify_time INTEGER,yyb_apk_id INTEGER,yyb_app_id INTEGER,trace_id TEXT,task_id TEXT,app_type INTEGER,last_step INTEGER,is_tdownload INTEGER,external_param TEXT);";
  }
  
  public String[] getAlterSQL(int paramInt1, int paramInt2)
  {
    ab.c("MonitorTaskTable", ">getAlterSQL " + paramInt1 + "|" + paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.b.b
 * JD-Core Version:    0.7.0.1
 */