package com.tencent.weiyun.transmission.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.weiyun.transmission.utils.TsLog;
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
    localStringBuilder.append("CREATE TABLE ").append("download").append(" (").append("_id").append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append("uid").append(" TEXT, ").append("cmd_type").append(" INTEGER, ").append("file_name").append(" TEXT, ").append("p_dir_uid").append(" TEXT, ").append("p_dir_key").append(" TEXT, ").append("file_id").append(" TEXT, ").append("cloud_sha").append(" TEXT, ").append("file_size").append(" INTEGER, ").append("file_type").append(" INTEGER, ").append("file_version").append(" TEXT, ").append("local_dir").append(" TEXT, ").append("insert_time").append(" INTEGER, ").append("thumb_uri").append(" TEXT, ").append("group_root_dir_key").append(" TEXT, ").append("state").append(" INTEGER, ").append("error_code").append(" INTEGER, ").append("error_msg").append(" TEXT, ").append("total_size").append(" INTEGER, ").append("cur_size").append(" INTEGER, ").append("local_path").append(" TEXT, ").append("valid_flag").append(" INTEGER ").append(")");
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
    localStringBuilder.append("CREATE TABLE ").append("upload").append(" (").append("_id").append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append("uid").append(" TEXT, ").append("cmd_type").append(" INTEGER, ").append("local_path").append(" TEXT, ").append("local_modified").append(" INTEGER, ").append("p_dir_uid").append(" TEXT, ").append("p_dir_name").append(" TEXT, ").append("p_dir_key").append(" TEXT, ").append("pp_dir_key").append(" TEXT, ").append("insert_time").append(" INTEGER, ").append("thumb_uri").append(" TEXT, ").append("file_name").append(" TEXT, ").append("file_size").append(" INTEGER, ").append("local_sha").append(" TEXT, ").append("mime_type").append(" TEXT, ").append("longitude").append(" REAL, ").append("latitude").append(" REAL, ").append("taken_time").append(" INTEGER, ").append("width").append(" INTEGER, ").append("height").append(" INTEGER, ").append("duration").append(" REAL, ").append("album").append(" TEXT, ").append("artist").append(" TEXT, ").append("compress_flag").append(" INTEGER, ").append("compress_path").append(" TEXT, ").append("compress_sha").append(" TEXT, ").append("cover_file_id").append(" TEXT, ").append("cover_file_version").append(" TEXT, ").append("auto_backup_flag").append(" INTEGER, ").append("group_root_dir_key").append(" TEXT, ").append("batch_id").append(" TEXT, ").append("batch_total").append(" INTEGER, ").append("batch_index").append(" INTEGER, ").append("batch_desc").append(" TEXT, ").append("state").append(" INTEGER, ").append("error_code").append(" INTEGER, ").append("error_msg").append(" TEXT, ").append("total_size").append(" INTEGER, ").append("cur_size").append(" INTEGER, ").append("file_id").append(" TEXT, ").append("file_version").append(" TEXT, ").append("valid_flag").append(" INTEGER ").append(")");
    paramSQLiteDatabase.execSQL("drop table if exists upload");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    paramSQLiteDatabase.execSQL("create index if not exists index_upload_insert on upload(insert_time)");
  }
  
  public void closeDatabase(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase == null) {}
    for (;;)
    {
      return;
      try
      {
        this.mRefCount -= 1;
      }
      finally {}
    }
  }
  
  void dumpDb(Context paramContext, File paramFile)
  {
    if ((paramContext == null) || (paramFile == null)) {
      return;
    }
    IOUtils.copyFiles(paramContext.getDatabasePath("weiyunlite_db_job"), new File(paramFile, "tencent/weiyunlite/db/weiyunlite_db_job"));
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    createUploadTable(paramSQLiteDatabase);
    createDownloadTable(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public SQLiteDatabase openDatabase(boolean paramBoolean)
  {
    Object localObject1 = null;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localSQLiteDatabase = getWritableDatabase();
        localObject1 = localSQLiteDatabase;
      }
      catch (Throwable localThrowable)
      {
        SQLiteDatabase localSQLiteDatabase;
        TsLog.e("JobDbHelper", "openDatabase failed", localThrowable);
        continue;
      }
      finally {}
      if (localObject1 != null) {
        this.mRefCount += 1;
      }
      return localObject1;
      localSQLiteDatabase = getReadableDatabase();
      localObject1 = localSQLiteDatabase;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.db.JobDbHelper
 * JD-Core Version:    0.7.0.1
 */