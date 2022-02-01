package com.tencent.mtt.hippy.adapter.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mtt.hippy.utils.LogUtils;

public class SQLiteHelper
  extends SQLiteOpenHelper
  implements IHippySQLiteHelper
{
  private static final String DATABASE_NAME = "HippyStorage";
  private static final int DATABASE_VERSION = 1;
  private static final int SLEEP_TIME_MS = 30;
  private static final String STATEMENT_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS hippy_engine_storage (key TEXT PRIMARY KEY,value TEXT NOT NULL)";
  private static final String TABLE_STORAGE = "hippy_engine_storage";
  private final Context mContext;
  private SQLiteDatabase mDb;
  
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
  
  /* Error */
  private void createTableIfNotExists(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_1
    //   6: ldc 52
    //   8: aconst_null
    //   9: invokevirtual 56	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   12: astore 5
    //   14: aload 5
    //   16: ifnull +35 -> 51
    //   19: aload 5
    //   21: astore 4
    //   23: aload 5
    //   25: astore_3
    //   26: aload 5
    //   28: invokeinterface 62 1 0
    //   33: istore_2
    //   34: iload_2
    //   35: ifle +16 -> 51
    //   38: aload 5
    //   40: ifnull +10 -> 50
    //   43: aload 5
    //   45: invokeinterface 63 1 0
    //   50: return
    //   51: aload 5
    //   53: astore 4
    //   55: aload 5
    //   57: astore_3
    //   58: aload_1
    //   59: ldc 18
    //   61: invokevirtual 67	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   64: aload 5
    //   66: ifnull +31 -> 97
    //   69: aload 5
    //   71: astore_3
    //   72: goto +19 -> 91
    //   75: astore_1
    //   76: goto +22 -> 98
    //   79: astore_1
    //   80: aload_3
    //   81: astore 4
    //   83: aload_1
    //   84: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   87: aload_3
    //   88: ifnull +9 -> 97
    //   91: aload_3
    //   92: invokeinterface 63 1 0
    //   97: return
    //   98: aload 4
    //   100: ifnull +10 -> 110
    //   103: aload 4
    //   105: invokeinterface 63 1 0
    //   110: aload_1
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	SQLiteHelper
    //   0	112	1	paramSQLiteDatabase	SQLiteDatabase
    //   33	2	2	i	int
    //   1	91	3	localObject1	Object
    //   3	101	4	localObject2	Object
    //   12	58	5	localCursor	android.database.Cursor
    // Exception table:
    //   from	to	target	type
    //   5	14	75	finally
    //   26	34	75	finally
    //   58	64	75	finally
    //   83	87	75	finally
    //   5	14	79	java/lang/Exception
    //   26	34	79	java/lang/Exception
    //   58	64	79	java/lang/Exception
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
  
  void ensureDatabase()
  {
    try
    {
      if (this.mDb != null)
      {
        bool = this.mDb.isOpen();
        if (bool) {
          return;
        }
      }
      Object localObject1 = null;
      i = 0;
    }
    finally
    {
      int i;
      label153:
      for (;;)
      {
        boolean bool;
        for (;;)
        {
          label97:
          throw localObject2;
        }
      }
    }
    if (i < 2)
    {
      if (i > 0) {}
      try
      {
        bool = deleteDatabase();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ensureDatabase: deleteDatabase ret=");
        localStringBuilder.append(bool);
        LogUtils.d("SQLiteHelper", localStringBuilder.toString());
        this.mDb = getWritableDatabase();
      }
      catch (SQLiteException localSQLiteException) {}
    }
    try
    {
      Thread.sleep(30L);
    }
    catch (InterruptedException localInterruptedException)
    {
      break label97;
      i += 1;
    }
    Thread.currentThread().interrupt();
    break label153;
    if (this.mDb != null)
    {
      createTableIfNotExists(this.mDb);
      this.mDb.setMaximumSize(52428800L);
      return;
    }
    throw localSQLiteException;
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
      boolean bool = deleteDatabase();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpgrade: deleteDatabase ret=");
      localStringBuilder.append(bool);
      LogUtils.d("SQLiteHelper", localStringBuilder.toString());
      onCreate(paramSQLiteDatabase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.storage.SQLiteHelper
 * JD-Core Version:    0.7.0.1
 */