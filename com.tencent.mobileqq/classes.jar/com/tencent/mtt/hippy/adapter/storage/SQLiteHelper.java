package com.tencent.mtt.hippy.adapter.storage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper
  extends SQLiteOpenHelper
  implements IHippySQLiteHelper
{
  private static final String DATABASE_NAME = "HippyStorage";
  private static final int DATABASE_VERSION = 1;
  private static final int SLEEP_TIME_MS = 30;
  private static final String STATEMENT_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS hippy_engine_storage (key TEXT PRIMARY KEY,value TEXT NOT NULL)";
  private static final String TABLE_STORAGE = "hippy_engine_storage";
  private Context mContext;
  private SQLiteDatabase mDb;
  private long mMaximumDatabaseSize = 52428800L;
  
  public SQLiteHelper(Context paramContext)
  {
    super(paramContext, "HippyStorage", null, 1);
    this.mContext = paramContext;
  }
  
  private void closeDatabase()
  {
    try
    {
      if ((this.mDb != null) && (this.mDb.isOpen()))
      {
        this.mDb.close();
        this.mDb = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void createTableIfNotExists(SQLiteDatabase paramSQLiteDatabase)
  {
    localObject2 = null;
    localObject1 = null;
    do
    {
      try
      {
        localCursor = paramSQLiteDatabase.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = 'hippy_engine_storage'", null);
        if (localCursor != null)
        {
          localObject1 = localCursor;
          localObject2 = localCursor;
          int i = localCursor.getCount();
          if (i > 0) {
            return;
          }
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        Cursor localCursor;
        localObject2 = localObject1;
        paramSQLiteDatabase.printStackTrace();
        return;
      }
      finally
      {
        if (localObject2 == null) {
          break;
        }
        localObject2.close();
      }
      localObject1 = localCursor;
      localObject2 = localCursor;
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hippy_engine_storage (key TEXT PRIMARY KEY,value TEXT NOT NULL)");
    } while (localCursor == null);
    localCursor.close();
  }
  
  private boolean deleteDatabase()
  {
    try
    {
      closeDatabase();
      boolean bool = this.mContext.deleteDatabase("HippyStorage");
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  void ensureDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/tencent/mtt/hippy/adapter/storage/SQLiteHelper:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   6: ifnull +18 -> 24
    //   9: aload_0
    //   10: getfield 43	com/tencent/mtt/hippy/adapter/storage/SQLiteHelper:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   13: invokevirtual 49	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   16: istore_2
    //   17: iload_2
    //   18: ifeq +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aconst_null
    //   25: astore_3
    //   26: iconst_0
    //   27: istore_1
    //   28: iload_1
    //   29: iconst_2
    //   30: if_icmpge +20 -> 50
    //   33: iload_1
    //   34: ifle +8 -> 42
    //   37: aload_0
    //   38: invokespecial 91	com/tencent/mtt/hippy/adapter/storage/SQLiteHelper:deleteDatabase	()Z
    //   41: pop
    //   42: aload_0
    //   43: aload_0
    //   44: invokevirtual 95	com/tencent/mtt/hippy/adapter/storage/SQLiteHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   47: putfield 43	com/tencent/mtt/hippy/adapter/storage/SQLiteHelper:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   50: aload_0
    //   51: getfield 43	com/tencent/mtt/hippy/adapter/storage/SQLiteHelper:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   54: ifnonnull +35 -> 89
    //   57: aload_3
    //   58: athrow
    //   59: astore_3
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_3
    //   63: athrow
    //   64: astore_3
    //   65: ldc2_w 96
    //   68: invokestatic 103	java/lang/Thread:sleep	(J)V
    //   71: iload_1
    //   72: iconst_1
    //   73: iadd
    //   74: istore_1
    //   75: goto -47 -> 28
    //   78: astore 4
    //   80: invokestatic 107	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   83: invokevirtual 110	java/lang/Thread:interrupt	()V
    //   86: goto -15 -> 71
    //   89: aload_0
    //   90: aload_0
    //   91: getfield 43	com/tencent/mtt/hippy/adapter/storage/SQLiteHelper:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   94: invokespecial 112	com/tencent/mtt/hippy/adapter/storage/SQLiteHelper:createTableIfNotExists	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   97: aload_0
    //   98: getfield 43	com/tencent/mtt/hippy/adapter/storage/SQLiteHelper:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   101: aload_0
    //   102: getfield 36	com/tencent/mtt/hippy/adapter/storage/SQLiteHelper:mMaximumDatabaseSize	J
    //   105: invokevirtual 116	android/database/sqlite/SQLiteDatabase:setMaximumSize	(J)J
    //   108: pop2
    //   109: goto -88 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	SQLiteHelper
    //   27	48	1	i	int
    //   16	2	2	bool	boolean
    //   25	33	3	localObject1	Object
    //   59	4	3	localObject2	Object
    //   64	1	3	localSQLiteException	android.database.sqlite.SQLiteException
    //   78	1	4	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	17	59	finally
    //   37	42	59	finally
    //   42	50	59	finally
    //   50	59	59	finally
    //   65	71	59	finally
    //   80	86	59	finally
    //   89	109	59	finally
    //   37	42	64	android/database/sqlite/SQLiteException
    //   42	50	64	android/database/sqlite/SQLiteException
    //   65	71	78	java/lang/InterruptedException
  }
  
  public SQLiteDatabase getDatabase()
  {
    try
    {
      ensureDatabase();
      SQLiteDatabase localSQLiteDatabase = this.mDb;
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getTableName()
  {
    return "hippy_engine_storage";
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hippy_engine_storage (key TEXT PRIMARY KEY,value TEXT NOT NULL)");
  }
  
  public void onDestroy()
  {
    closeDatabase();
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      deleteDatabase();
      onCreate(paramSQLiteDatabase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.storage.SQLiteHelper
 * JD-Core Version:    0.7.0.1
 */