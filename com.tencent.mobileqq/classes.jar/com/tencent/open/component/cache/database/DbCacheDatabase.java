package com.tencent.open.component.cache.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.open.base.MD5Utils;
import java.util.HashMap;
import java.util.HashSet;

public class DbCacheDatabase
  extends SQLiteOpenHelper
{
  protected static final int DATABASE_VERSION = 74;
  protected static HashMap<Long, DbCacheDatabase> sInstanceMap = new HashMap();
  protected int mAttachCount;
  protected boolean mAutoCloseNoAttach = true;
  protected Context mContext;
  protected String mDataName;
  protected volatile boolean mDatabaseUpdated;
  protected HashSet<Integer> mSeesionIds = new HashSet();
  
  protected DbCacheDatabase(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
    this.mDataName = paramString;
    this.mContext = paramContext;
  }
  
  public static DbCacheDatabase getInstance(Context paramContext, long paramLong)
  {
    try
    {
      DbCacheDatabase localDbCacheDatabase2 = (DbCacheDatabase)sInstanceMap.get(Long.valueOf(paramLong));
      DbCacheDatabase localDbCacheDatabase1 = localDbCacheDatabase2;
      if (localDbCacheDatabase2 == null)
      {
        localDbCacheDatabase1 = new DbCacheDatabase(paramContext, MD5Utils.encodeHexStr(String.valueOf(paramLong) + "_opensdk"), null, 74);
        sInstanceMap.put(Long.valueOf(paramLong), localDbCacheDatabase1);
      }
      return localDbCacheDatabase1;
    }
    finally {}
  }
  
  public void attach(int paramInt)
  {
    try
    {
      if (this.mSeesionIds.add(Integer.valueOf(paramInt))) {
        this.mAttachCount += 1;
      }
      return;
    }
    finally {}
  }
  
  public void deleteDatabase()
  {
    this.mContext.deleteDatabase(this.mDataName);
  }
  
  public void detach(int paramInt)
  {
    int j = 0;
    int i = j;
    try
    {
      if (this.mSeesionIds.remove(Integer.valueOf(paramInt)))
      {
        paramInt = this.mAttachCount - 1;
        this.mAttachCount = paramInt;
        i = j;
        if (paramInt == 0) {
          i = 1;
        }
      }
      if ((i != 0) && (this.mAutoCloseNoAttach)) {
        close();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public SQLiteDatabase getWritableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokespecial 118	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_1
    //   12: astore_2
    //   13: aload_0
    //   14: getfield 120	com/tencent/open/component/cache/database/DbCacheDatabase:mDatabaseUpdated	Z
    //   17: ifeq +29 -> 46
    //   20: aload_1
    //   21: ifnull +7 -> 28
    //   24: aload_1
    //   25: invokevirtual 123	android/database/sqlite/SQLiteDatabase:close	()V
    //   28: aload_0
    //   29: invokevirtual 125	com/tencent/open/component/cache/database/DbCacheDatabase:deleteDatabase	()V
    //   32: aload_0
    //   33: invokespecial 118	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 120	com/tencent/open/component/cache/database/DbCacheDatabase:mDatabaseUpdated	Z
    //   44: aload_1
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: areturn
    //   50: astore_2
    //   51: aload_0
    //   52: invokevirtual 125	com/tencent/open/component/cache/database/DbCacheDatabase:deleteDatabase	()V
    //   55: aload_0
    //   56: invokespecial 118	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   59: astore_2
    //   60: aload_2
    //   61: astore_1
    //   62: aload_1
    //   63: astore_2
    //   64: aload_0
    //   65: getfield 120	com/tencent/open/component/cache/database/DbCacheDatabase:mDatabaseUpdated	Z
    //   68: ifeq -22 -> 46
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 120	com/tencent/open/component/cache/database/DbCacheDatabase:mDatabaseUpdated	Z
    //   76: aload_1
    //   77: astore_2
    //   78: goto -32 -> 46
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    //   86: astore_2
    //   87: aload_0
    //   88: getfield 120	com/tencent/open/component/cache/database/DbCacheDatabase:mDatabaseUpdated	Z
    //   91: ifeq +29 -> 120
    //   94: iconst_0
    //   95: ifeq +11 -> 106
    //   98: new 127	java/lang/NullPointerException
    //   101: dup
    //   102: invokespecial 128	java/lang/NullPointerException:<init>	()V
    //   105: athrow
    //   106: aload_0
    //   107: invokevirtual 125	com/tencent/open/component/cache/database/DbCacheDatabase:deleteDatabase	()V
    //   110: aload_0
    //   111: invokespecial 118	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   114: pop
    //   115: aload_0
    //   116: iconst_0
    //   117: putfield 120	com/tencent/open/component/cache/database/DbCacheDatabase:mDatabaseUpdated	Z
    //   120: aload_2
    //   121: athrow
    //   122: astore_2
    //   123: goto -84 -> 39
    //   126: astore_2
    //   127: goto -65 -> 62
    //   130: astore_1
    //   131: goto -16 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	DbCacheDatabase
    //   3	74	1	localObject1	Object
    //   81	4	1	localObject2	Object
    //   130	1	1	localThrowable1	java.lang.Throwable
    //   8	41	2	localObject3	Object
    //   50	1	2	localThrowable2	java.lang.Throwable
    //   59	19	2	localObject4	Object
    //   86	35	2	localObject5	Object
    //   122	1	2	localThrowable3	java.lang.Throwable
    //   126	1	2	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   4	9	50	java/lang/Throwable
    //   13	20	81	finally
    //   24	28	81	finally
    //   28	32	81	finally
    //   32	37	81	finally
    //   39	44	81	finally
    //   46	48	81	finally
    //   64	76	81	finally
    //   82	84	81	finally
    //   87	94	81	finally
    //   98	106	81	finally
    //   106	110	81	finally
    //   110	115	81	finally
    //   115	120	81	finally
    //   120	122	81	finally
    //   4	9	86	finally
    //   51	55	86	finally
    //   55	60	86	finally
    //   32	37	122	java/lang/Throwable
    //   55	60	126	java/lang/Throwable
    //   110	115	130	java/lang/Throwable
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.mDatabaseUpdated = true;
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.mDatabaseUpdated = true;
  }
  
  public void setAutoCloseWhenNoAttach(boolean paramBoolean)
  {
    this.mAutoCloseNoAttach = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.component.cache.database.DbCacheDatabase
 * JD-Core Version:    0.7.0.1
 */