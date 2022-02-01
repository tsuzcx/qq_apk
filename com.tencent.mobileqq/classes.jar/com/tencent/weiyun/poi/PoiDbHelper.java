package com.tencent.weiyun.poi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.weiyun.utils.IOUtils;
import com.tencent.weiyun.utils.WyLog;
import java.io.File;

final class PoiDbHelper
  extends SQLiteOpenHelper
{
  private static final String DB_NAME = "weiyunlite_db_poi";
  private static final String TAG = "PoiDbHelper";
  private static final int VERSION = 1;
  private static final int VERSION_1 = 1;
  private int mRefCount = 0;
  
  PoiDbHelper(Context paramContext)
  {
    super(paramContext, "weiyunlite_db_poi", null, 1);
  }
  
  private void createPoiTable(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE ").append("poi").append(" (").append("_id").append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append("longitude").append(" REAL, ").append("latitude").append(" REAL, ").append("nation_type").append(" INTEGER, ").append("nation_name").append(" TEXT, ").append("city_id").append(" INTEGER, ").append("city_name").append(" TEXT, ").append("poi_id").append(" TEXT, ").append("poi_name").append(" TEXT, ").append("address").append(" TEXT, ").append(" UNIQUE(").append("longitude").append(", ").append("latitude").append(") ON CONFLICT IGNORE)");
    paramSQLiteDatabase.execSQL("drop table if exists poi");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    paramSQLiteDatabase.execSQL("create index if not exists index_poi_longitude_latitude on poi(longitude,latitude)");
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
    IOUtils.copyFiles(paramContext.getDatabasePath("weiyunlite_db_poi"), new File(paramFile, "tencent/weiyunlite/db/weiyunlite_db_poi"));
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    createPoiTable(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public SQLiteDatabase openDatabase(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      for (SQLiteDatabase localSQLiteDatabase = getWritableDatabase();; localSQLiteDatabase = getReadableDatabase())
      {
        if (localSQLiteDatabase != null) {
          this.mRefCount += 1;
        }
        return localSQLiteDatabase;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        WyLog.e("PoiDbHelper", "openDatabase failed", localThrowable);
        Object localObject1 = null;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weiyun.poi.PoiDbHelper
 * JD-Core Version:    0.7.0.1
 */