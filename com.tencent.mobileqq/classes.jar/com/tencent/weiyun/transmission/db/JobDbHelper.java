package com.tencent.weiyun.transmission.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.weiyun.utils.IOUtils;
import java.io.File;

final class JobDbHelper
  extends SQLiteOpenHelper
{
  private static final String DB_NAME = "weiyunlite_db_job";
  private static final String TAG = "JobDbHelper";
  private static final int VERSION = 1;
  private static final int VERSION_1 = 1;
  private int mRefCount = 0;
  
  JobDbHelper(Context paramContext)
  {
    super(paramContext, "weiyunlite_db_job", null, 1);
  }
  
  private void createDownloadTable(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE ");
    localStringBuilder.append("download");
    localStringBuilder.append(" (");
    localStringBuilder.append("_id");
    localStringBuilder.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
    localStringBuilder.append("uid");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("cmd_type");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("file_name");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("p_dir_uid");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("p_dir_key");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("file_id");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("cloud_sha");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("file_size");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("file_type");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("file_version");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("local_dir");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("insert_time");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("thumb_uri");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("group_root_dir_key");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("state");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("error_code");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("error_msg");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("total_size");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("cur_size");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("local_path");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("valid_flag");
    localStringBuilder.append(" INTEGER ");
    localStringBuilder.append(")");
    paramSQLiteDatabase.execSQL("drop table if exists download");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    paramSQLiteDatabase.execSQL("create index if not exists index_download_insert on download(insert_time)");
  }
  
  private void createUploadTable(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE ");
    localStringBuilder.append("upload");
    localStringBuilder.append(" (");
    localStringBuilder.append("_id");
    localStringBuilder.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
    localStringBuilder.append("uid");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("cmd_type");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("local_path");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("local_modified");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("p_dir_uid");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("p_dir_name");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("p_dir_key");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("pp_dir_key");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("insert_time");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("thumb_uri");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("file_name");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("file_size");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("local_sha");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("mime_type");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("longitude");
    localStringBuilder.append(" REAL, ");
    localStringBuilder.append("latitude");
    localStringBuilder.append(" REAL, ");
    localStringBuilder.append("taken_time");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("width");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("height");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("duration");
    localStringBuilder.append(" REAL, ");
    localStringBuilder.append("album");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("artist");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("compress_flag");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("compress_path");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("compress_sha");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("cover_file_id");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("cover_file_version");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("auto_backup_flag");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("group_root_dir_key");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("batch_id");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("batch_total");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("batch_index");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("batch_desc");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("state");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("error_code");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("error_msg");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("total_size");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("cur_size");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("file_id");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("file_version");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("valid_flag");
    localStringBuilder.append(" INTEGER ");
    localStringBuilder.append(")");
    paramSQLiteDatabase.execSQL("drop table if exists upload");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    paramSQLiteDatabase.execSQL("create index if not exists index_upload_insert on upload(insert_time)");
  }
  
  public void closeDatabase(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase == null) {
      return;
    }
    try
    {
      this.mRefCount -= 1;
      return;
    }
    finally
    {
      paramSQLiteDatabase = finally;
      throw paramSQLiteDatabase;
    }
  }
  
  void dumpDb(Context paramContext, File paramFile)
  {
    if (paramContext != null)
    {
      if (paramFile == null) {
        return;
      }
      IOUtils.copyFiles(paramContext.getDatabasePath("weiyunlite_db_job"), new File(paramFile, "tencent/weiyunlite/db/weiyunlite_db_job"));
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    createUploadTable(paramSQLiteDatabase);
    createDownloadTable(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  /* Error */
  public SQLiteDatabase openDatabase(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: iload_1
    //   5: ifeq +13 -> 18
    //   8: aload_0
    //   9: invokevirtual 201	com/tencent/weiyun/transmission/db/JobDbHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore_3
    //   13: aload_3
    //   14: astore_2
    //   15: goto +10 -> 25
    //   18: aload_0
    //   19: invokevirtual 204	com/tencent/weiyun/transmission/db/JobDbHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore_3
    //   23: aload_3
    //   24: astore_2
    //   25: goto +16 -> 41
    //   28: astore_2
    //   29: goto +30 -> 59
    //   32: astore_3
    //   33: ldc 11
    //   35: ldc 206
    //   37: aload_3
    //   38: invokestatic 212	com/tencent/weiyun/transmission/utils/TsLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   41: aload_2
    //   42: ifnull +13 -> 55
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 23	com/tencent/weiyun/transmission/db/JobDbHelper:mRefCount	I
    //   50: iconst_1
    //   51: iadd
    //   52: putfield 23	com/tencent/weiyun/transmission/db/JobDbHelper:mRefCount	I
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: areturn
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_2
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	JobDbHelper
    //   0	63	1	paramBoolean	boolean
    //   3	22	2	localObject	java.lang.Object
    //   28	34	2	localSQLiteDatabase1	SQLiteDatabase
    //   12	12	3	localSQLiteDatabase2	SQLiteDatabase
    //   32	6	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   8	13	28	finally
    //   18	23	28	finally
    //   33	41	28	finally
    //   45	55	28	finally
    //   8	13	32	java/lang/Throwable
    //   18	23	32	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.transmission.db.JobDbHelper
 * JD-Core Version:    0.7.0.1
 */