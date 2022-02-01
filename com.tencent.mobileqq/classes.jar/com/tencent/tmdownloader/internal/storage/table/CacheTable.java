package com.tencent.tmdownloader.internal.storage.table;

import com.tencent.tmassistant.common.a.c;
import com.tencent.tmassistant.common.a.d;
import com.tencent.tmdownloader.internal.storage.a.a;

public class CacheTable
  implements c
{
  protected static final String[] COLS_SIZE = { "key" };
  protected static final String COL_BLOB = "blob";
  protected static final String COL_KEY = "key";
  public static final String COL_KEY_CACHE = "cache";
  public static final String COL_KEY_REPORT = "report";
  protected static final String COL_TYPE = "type";
  public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS reportInfo( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);";
  protected static final int REPORT_MAX_DB_SIZE = 20;
  public static final String TABLE_NAME = "reportInfo";
  protected static final String TAG = "ReportTable";
  
  public String createTableSQL()
  {
    return "CREATE TABLE IF NOT EXISTS reportInfo( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);";
  }
  
  /* Error */
  public void dataMovement(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase1, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +189 -> 190
    //   4: aload_1
    //   5: ifnull +185 -> 190
    //   8: aload_2
    //   9: invokevirtual 57	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   12: aload_1
    //   13: ldc 59
    //   15: aconst_null
    //   16: invokevirtual 63	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnull +84 -> 105
    //   24: aload_1
    //   25: astore 4
    //   27: aload_1
    //   28: invokeinterface 69 1 0
    //   33: ifeq +72 -> 105
    //   36: aload_1
    //   37: astore 4
    //   39: ldc 33
    //   41: ldc 71
    //   43: invokestatic 77	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_1
    //   47: astore 4
    //   49: new 79	android/content/ContentValues
    //   52: dup
    //   53: invokespecial 80	android/content/ContentValues:<init>	()V
    //   56: astore 5
    //   58: aload_1
    //   59: astore 4
    //   61: aload 5
    //   63: aload_1
    //   64: invokestatic 86	com/tencent/tmdownloader/internal/downloadservice/c:b	(Landroid/database/Cursor;)Lcom/tencent/tmdownloader/internal/downloadservice/c;
    //   67: invokestatic 90	com/tencent/tmdownloader/internal/downloadservice/c:a	(Landroid/content/ContentValues;Lcom/tencent/tmdownloader/internal/downloadservice/c;)V
    //   70: aload_1
    //   71: astore 4
    //   73: aload_2
    //   74: ldc 33
    //   76: aconst_null
    //   77: aload 5
    //   79: invokevirtual 94	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   82: pop2
    //   83: aload_1
    //   84: astore 4
    //   86: aload_1
    //   87: invokeinterface 97 1 0
    //   92: istore_3
    //   93: iload_3
    //   94: ifne -48 -> 46
    //   97: goto +8 -> 105
    //   100: astore 5
    //   102: goto +27 -> 129
    //   105: aload_1
    //   106: ifnull +60 -> 166
    //   109: aload_1
    //   110: invokeinterface 100 1 0
    //   115: goto +51 -> 166
    //   118: astore_1
    //   119: aconst_null
    //   120: astore 4
    //   122: goto +54 -> 176
    //   125: astore 5
    //   127: aconst_null
    //   128: astore_1
    //   129: aload_1
    //   130: astore 4
    //   132: ldc 36
    //   134: ldc 102
    //   136: aload 5
    //   138: invokestatic 105	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   141: aload_1
    //   142: astore 4
    //   144: aload 5
    //   146: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   149: aload_1
    //   150: astore 4
    //   152: ldc 33
    //   154: ldc 110
    //   156: invokestatic 77	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: aload_1
    //   160: ifnull +6 -> 166
    //   163: goto -54 -> 109
    //   166: aload_2
    //   167: invokevirtual 113	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   170: aload_2
    //   171: invokevirtual 116	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   174: return
    //   175: astore_1
    //   176: aload 4
    //   178: ifnull +10 -> 188
    //   181: aload 4
    //   183: invokeinterface 100 1 0
    //   188: aload_1
    //   189: athrow
    //   190: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	CacheTable
    //   0	191	1	paramSQLiteDatabase1	android.database.sqlite.SQLiteDatabase
    //   0	191	2	paramSQLiteDatabase2	android.database.sqlite.SQLiteDatabase
    //   92	2	3	bool	boolean
    //   25	157	4	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   56	22	5	localContentValues	android.content.ContentValues
    //   100	1	5	localException1	java.lang.Exception
    //   125	20	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   27	36	100	java/lang/Exception
    //   39	46	100	java/lang/Exception
    //   49	58	100	java/lang/Exception
    //   61	70	100	java/lang/Exception
    //   73	83	100	java/lang/Exception
    //   86	93	100	java/lang/Exception
    //   12	20	118	finally
    //   12	20	125	java/lang/Exception
    //   27	36	175	finally
    //   39	46	175	finally
    //   49	58	175	finally
    //   61	70	175	finally
    //   73	83	175	finally
    //   86	93	175	finally
    //   132	141	175	finally
    //   144	149	175	finally
    //   152	159	175	finally
  }
  
  public String[] getAlterSQL(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public d getHelper()
  {
    return a.c();
  }
  
  public String tableName()
  {
    return "reportInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.table.CacheTable
 * JD-Core Version:    0.7.0.1
 */