package com.tencent.mobileqq.persistence;

import android.annotation.TargetApi;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EntityManagerFactory$SQLiteOpenHelperImpl
  extends android.database.sqlite.SQLiteOpenHelper
{
  private String databaseName;
  private SQLiteDatabase dbR;
  private SQLiteDatabase dbW;
  private SQLiteDatabase mInnerDb;
  
  public EntityManagerFactory$SQLiteOpenHelperImpl(EntityManagerFactory paramEntityManagerFactory, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(BaseApplication.getContext(), paramString, new EntityManagerFactory.Factory(paramEntityManagerFactory, null), paramInt);
    this.databaseName = paramString;
  }
  
  @TargetApi(11)
  public EntityManagerFactory$SQLiteOpenHelperImpl(EntityManagerFactory paramEntityManagerFactory, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    super(BaseApplication.getContext(), paramString, new EntityManagerFactory.Factory(paramEntityManagerFactory, null), paramInt, paramDatabaseErrorHandler);
    this.databaseName = paramString;
  }
  
  private void dropAllTable(SQLiteDatabase paramSQLiteDatabase)
  {
    String[] arrayOfString = getAllTableName(paramSQLiteDatabase);
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        String str = arrayOfString[i];
        if ("android_metadata".equals(str)) {}
        for (;;)
        {
          i += 1;
          break;
          if (!"sqlite_sequence".equals(str)) {
            try
            {
              paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(str));
            }
            catch (SQLiteException localSQLiteException)
            {
              QLog.e(this.this$0.TAG, 1, "[DB] dropAllTable " + str, localSQLiteException);
              com.tencent.mobileqq.app.SQLiteOpenHelper.throwDebugException(localSQLiteException);
            }
          }
        }
      }
    }
    onCreate(paramSQLiteDatabase);
  }
  
  /* Error */
  private String[] getAllTableName(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: ldc 110
    //   5: aconst_null
    //   6: invokevirtual 114	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   9: astore 4
    //   11: aload 4
    //   13: ifnull +180 -> 193
    //   16: aload 4
    //   18: astore 5
    //   20: aload 4
    //   22: invokeinterface 120 1 0
    //   27: ifeq +166 -> 193
    //   30: aload 4
    //   32: astore 5
    //   34: aload 4
    //   36: invokeinterface 124 1 0
    //   41: anewarray 53	java/lang/String
    //   44: astore_1
    //   45: aload 4
    //   47: astore 5
    //   49: aload_1
    //   50: iload_2
    //   51: aload 4
    //   53: iconst_0
    //   54: invokeinterface 128 2 0
    //   59: invokestatic 133	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   62: aastore
    //   63: aload 4
    //   65: astore 5
    //   67: aload 4
    //   69: invokeinterface 136 1 0
    //   74: istore_3
    //   75: iload_3
    //   76: ifne +110 -> 186
    //   79: aload_1
    //   80: astore 5
    //   82: aload 4
    //   84: ifnull +13 -> 97
    //   87: aload 4
    //   89: invokeinterface 139 1 0
    //   94: aload_1
    //   95: astore 5
    //   97: aload 5
    //   99: areturn
    //   100: astore 6
    //   102: aconst_null
    //   103: astore 4
    //   105: aconst_null
    //   106: astore_1
    //   107: aload 4
    //   109: astore 5
    //   111: aload_0
    //   112: getfield 16	com/tencent/mobileqq/persistence/EntityManagerFactory$SQLiteOpenHelperImpl:this$0	Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   115: getfield 76	com/tencent/mobileqq/persistence/EntityManagerFactory:TAG	Ljava/lang/String;
    //   118: iconst_1
    //   119: ldc 140
    //   121: aload 6
    //   123: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   126: aload 4
    //   128: astore 5
    //   130: aload 6
    //   132: invokestatic 103	com/tencent/mobileqq/app/SQLiteOpenHelper:throwDebugException	(Ljava/lang/Exception;)V
    //   135: aload_1
    //   136: astore 5
    //   138: aload 4
    //   140: ifnull -43 -> 97
    //   143: aload 4
    //   145: invokeinterface 139 1 0
    //   150: aload_1
    //   151: areturn
    //   152: astore_1
    //   153: aconst_null
    //   154: astore 5
    //   156: aload 5
    //   158: ifnull +10 -> 168
    //   161: aload 5
    //   163: invokeinterface 139 1 0
    //   168: aload_1
    //   169: athrow
    //   170: astore_1
    //   171: goto -15 -> 156
    //   174: astore 6
    //   176: aconst_null
    //   177: astore_1
    //   178: goto -71 -> 107
    //   181: astore 6
    //   183: goto -76 -> 107
    //   186: iload_2
    //   187: iconst_1
    //   188: iadd
    //   189: istore_2
    //   190: goto -145 -> 45
    //   193: aconst_null
    //   194: astore_1
    //   195: goto -116 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	SQLiteOpenHelperImpl
    //   0	198	1	paramSQLiteDatabase	SQLiteDatabase
    //   1	189	2	i	int
    //   74	2	3	bool	boolean
    //   9	135	4	localCursor	android.database.Cursor
    //   18	144	5	localObject	Object
    //   100	31	6	localException1	Exception
    //   174	1	6	localException2	Exception
    //   181	1	6	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   2	11	100	java/lang/Exception
    //   2	11	152	finally
    //   20	30	170	finally
    //   34	45	170	finally
    //   49	63	170	finally
    //   67	75	170	finally
    //   111	126	170	finally
    //   130	135	170	finally
    //   20	30	174	java/lang/Exception
    //   34	45	174	java/lang/Exception
    //   49	63	181	java/lang/Exception
    //   67	75	181	java/lang/Exception
  }
  
  public void close()
  {
    QLog.e(this.this$0.TAG, 1, "SQLiteOpenHelperImpl close");
    try
    {
      if ((this.dbR != null) && (this.dbR.isOpen()))
      {
        this.dbR.close();
        this.dbR = null;
      }
      if ((this.dbW != null) && (this.dbW.isOpen()))
      {
        this.dbW.close();
        this.dbW = null;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.this$0.TAG, 1, "close", localException);
    }
  }
  
  public void dropAllTable()
  {
    dropAllTable(this.mInnerDb);
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    try
    {
      this.dbR = super.getReadableDatabase();
      SQLiteDatabase localSQLiteDatabase = this.dbR;
      return localSQLiteDatabase;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(this.this$0.TAG, 1, "getReadableDatabase", localException);
        com.tencent.mobileqq.app.SQLiteOpenHelper.throwDebugException(localException);
      }
    }
    finally {}
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    try
    {
      this.dbW = super.getWritableDatabase();
      this.dbW.setLockingEnabled(false);
      SQLiteDatabase localSQLiteDatabase = this.dbW;
      return localSQLiteDatabase;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(this.this$0.TAG, 1, "getWritableDatabase", localException);
        com.tencent.mobileqq.app.SQLiteOpenHelper.throwDebugException(localException);
      }
    }
    finally {}
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.this$0.TAG, 2, "[DB]" + this.databaseName + " onCreate");
    }
    this.this$0.createDatabase(paramSQLiteDatabase);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    if (QLog.isColorLevel()) {
      QLog.i(this.this$0.TAG, 2, "[DB]" + this.databaseName + " onOpen");
    }
    this.mInnerDb = paramSQLiteDatabase;
    try
    {
      localObject1 = SQLiteDatabase.class.getDeclaredField("mConfigurationLocked");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(paramSQLiteDatabase);
      localObject2 = localObject1.getClass().getDeclaredField("maxSqlCacheSize");
      ((Field)localObject2).setAccessible(true);
      ((Field)localObject2).set(localObject1, Integer.valueOf(150));
      localObject2 = SQLiteDatabase.class.getDeclaredField("mConnectionPoolLocked");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(paramSQLiteDatabase);
      Method[] arrayOfMethod = localObject2.getClass().getDeclaredMethods();
      int j = arrayOfMethod.length;
      i = 0;
      if (i >= j) {
        break label524;
      }
      paramSQLiteDatabase = arrayOfMethod[i];
      if (!TextUtils.equals(paramSQLiteDatabase.getName(), "reconfigure")) {
        break label253;
      }
    }
    catch (NoSuchFieldException paramSQLiteDatabase)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        int i;
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w(this.this$0.TAG, 2, "[DB]" + this.databaseName + "  onOpen", paramSQLiteDatabase);
        }
      }
    }
    catch (IllegalArgumentException paramSQLiteDatabase)
    {
      for (;;)
      {
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w(this.this$0.TAG, 2, "[DB]" + this.databaseName + "  onOpen", paramSQLiteDatabase);
        }
      }
    }
    catch (IllegalAccessException paramSQLiteDatabase)
    {
      for (;;)
      {
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w(this.this$0.TAG, 2, "[DB]" + this.databaseName + "  onOpen", paramSQLiteDatabase);
        }
      }
    }
    catch (InvocationTargetException paramSQLiteDatabase)
    {
      for (;;)
      {
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.w(this.this$0.TAG, 2, "[DB]" + this.databaseName + "  onOpen", paramSQLiteDatabase);
          continue;
          paramSQLiteDatabase = null;
        }
      }
    }
    if (paramSQLiteDatabase != null)
    {
      paramSQLiteDatabase.setAccessible(true);
      paramSQLiteDatabase.invoke(localObject2, new Object[] { localObject1 });
      if (QLog.isColorLevel()) {
        QLog.i(this.this$0.TAG, 2, "[DB]" + this.databaseName + " LRU MAX SIZE = " + 150);
      }
    }
    for (;;)
    {
      this.this$0.cleanOverDueCorruptDatabase();
      return;
      label253:
      i += 1;
      break;
      if (QLog.isColorLevel()) {
        QLog.w(this.this$0.TAG, 2, "[DB]" + this.databaseName + " not find reconfigure()");
      }
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.this$0.TAG, 2, "[DB]" + this.databaseName + " onUpgrade oldVersion: " + paramInt1 + " newVersion: " + paramInt2);
    }
    this.this$0.upgradeDatabase(paramSQLiteDatabase, paramInt1, paramInt2);
    this.this$0.checkTableColumnChange(this.this$0.getPackageName(), paramSQLiteDatabase, paramInt1, paramInt2);
    this.this$0.doAfterUpgradeDatabase(paramSQLiteDatabase, paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i(this.this$0.TAG, 2, "[DB] onUpgrade end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EntityManagerFactory.SQLiteOpenHelperImpl
 * JD-Core Version:    0.7.0.1
 */