package com.tencent.weiyun.poi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.weiyun.utils.IOUtils;
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
    localStringBuilder.append("CREATE TABLE ");
    localStringBuilder.append("poi");
    localStringBuilder.append(" (");
    localStringBuilder.append("_id");
    localStringBuilder.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
    localStringBuilder.append("longitude");
    localStringBuilder.append(" REAL, ");
    localStringBuilder.append("latitude");
    localStringBuilder.append(" REAL, ");
    localStringBuilder.append("nation_type");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("nation_name");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("city_id");
    localStringBuilder.append(" INTEGER, ");
    localStringBuilder.append("city_name");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("poi_id");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("poi_name");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append("address");
    localStringBuilder.append(" TEXT, ");
    localStringBuilder.append(" UNIQUE(");
    localStringBuilder.append("longitude");
    localStringBuilder.append(", ");
    localStringBuilder.append("latitude");
    localStringBuilder.append(") ON CONFLICT IGNORE)");
    paramSQLiteDatabase.execSQL("drop table if exists poi");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    paramSQLiteDatabase.execSQL("create index if not exists index_poi_longitude_latitude on poi(longitude,latitude)");
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
      IOUtils.copyFiles(paramContext.getDatabasePath("weiyunlite_db_poi"), new File(paramFile, "tencent/weiyunlite/db/weiyunlite_db_poi"));
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    createPoiTable(paramSQLiteDatabase);
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
    //   9: invokevirtual 124	com/tencent/weiyun/poi/PoiDbHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore_3
    //   13: aload_3
    //   14: astore_2
    //   15: goto +10 -> 25
    //   18: aload_0
    //   19: invokevirtual 127	com/tencent/weiyun/poi/PoiDbHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore_3
    //   23: aload_3
    //   24: astore_2
    //   25: goto +16 -> 41
    //   28: astore_2
    //   29: goto +30 -> 59
    //   32: astore_3
    //   33: ldc 11
    //   35: ldc 129
    //   37: aload_3
    //   38: invokestatic 135	com/tencent/weiyun/utils/WyLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   41: aload_2
    //   42: ifnull +13 -> 55
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 23	com/tencent/weiyun/poi/PoiDbHelper:mRefCount	I
    //   50: iconst_1
    //   51: iadd
    //   52: putfield 23	com/tencent/weiyun/poi/PoiDbHelper:mRefCount	I
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
    //   0	63	0	this	PoiDbHelper
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
 * Qualified Name:     com.tencent.weiyun.poi.PoiDbHelper
 * JD-Core Version:    0.7.0.1
 */