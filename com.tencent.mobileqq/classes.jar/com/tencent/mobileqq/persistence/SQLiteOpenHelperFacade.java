package com.tencent.mobileqq.persistence;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy;
import com.tencent.mobileqq.localizeddb.LocalizedSQLiteOpenHelperImpl;
import com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SQLiteOpenHelperFacade
{
  private final String databaseName;
  private SQLiteDatabase dbR;
  private SQLiteDatabase dbW;
  private final ISQLiteOpenHelper mActualHelper;
  private final EntityManagerFactory mEmf;
  private SQLiteDatabase mInnerDb;
  private final String tag;
  
  public SQLiteOpenHelperFacade(ISQLiteOpenHelper paramISQLiteOpenHelper, String paramString1, EntityManagerFactory paramEntityManagerFactory, String paramString2)
  {
    this.mActualHelper = paramISQLiteOpenHelper;
    this.databaseName = paramString1;
    this.mEmf = paramEntityManagerFactory;
    this.tag = paramString2;
  }
  
  private void dropAllTable(SQLiteDatabase paramSQLiteDatabase)
  {
    String[] arrayOfString = getAllTableName(paramSQLiteDatabase);
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str1 = arrayOfString[i];
        if ((!"android_metadata".equals(str1)) && (!"sqlite_sequence".equals(str1))) {
          try
          {
            paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(str1));
          }
          catch (SQLiteException localSQLiteException)
          {
            String str2 = this.tag;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[DB] dropAllTable ");
            localStringBuilder.append(str1);
            QLog.e(str2, 1, localStringBuilder.toString(), localSQLiteException);
            SQLiteOpenHelper.throwDebugException(localSQLiteException);
          }
        }
        i += 1;
      }
    }
    onCreate(paramSQLiteDatabase);
  }
  
  /* Error */
  private String[] getAllTableName(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 6
    //   12: aload_1
    //   13: ldc 91
    //   15: aconst_null
    //   16: invokevirtual 95	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore 5
    //   21: aload 8
    //   23: astore 4
    //   25: aload 5
    //   27: ifnull +107 -> 134
    //   30: aload 6
    //   32: astore_1
    //   33: aload 8
    //   35: astore 4
    //   37: aload 5
    //   39: invokeinterface 101 1 0
    //   44: ifeq +90 -> 134
    //   47: aload 6
    //   49: astore_1
    //   50: aload 5
    //   52: invokeinterface 105 1 0
    //   57: anewarray 41	java/lang/String
    //   60: astore 4
    //   62: iconst_0
    //   63: istore_2
    //   64: aload 4
    //   66: astore_1
    //   67: aload 4
    //   69: iload_2
    //   70: aload 5
    //   72: iconst_0
    //   73: invokeinterface 109 2 0
    //   78: invokestatic 114	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   81: aastore
    //   82: aload 4
    //   84: astore_1
    //   85: aload 5
    //   87: invokeinterface 117 1 0
    //   92: istore_3
    //   93: iload_3
    //   94: ifne +6 -> 100
    //   97: goto +37 -> 134
    //   100: iload_2
    //   101: iconst_1
    //   102: iadd
    //   103: istore_2
    //   104: goto -40 -> 64
    //   107: astore_1
    //   108: aload 5
    //   110: astore 4
    //   112: goto +85 -> 197
    //   115: astore 7
    //   117: aload 5
    //   119: astore 4
    //   121: aload_1
    //   122: astore 6
    //   124: aload 7
    //   126: astore 5
    //   128: aload 4
    //   130: astore_1
    //   131: goto +30 -> 161
    //   134: aload 5
    //   136: ifnull +10 -> 146
    //   139: aload 5
    //   141: invokeinterface 120 1 0
    //   146: aload 4
    //   148: areturn
    //   149: astore_1
    //   150: goto +47 -> 197
    //   153: astore 5
    //   155: aconst_null
    //   156: astore 6
    //   158: aload 7
    //   160: astore_1
    //   161: aload_1
    //   162: astore 4
    //   164: aload_0
    //   165: getfield 28	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:tag	Ljava/lang/String;
    //   168: iconst_1
    //   169: ldc 121
    //   171: aload 5
    //   173: invokestatic 78	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   176: aload_1
    //   177: astore 4
    //   179: aload 5
    //   181: invokestatic 84	com/tencent/mobileqq/app/SQLiteOpenHelper:throwDebugException	(Ljava/lang/Exception;)V
    //   184: aload_1
    //   185: ifnull +9 -> 194
    //   188: aload_1
    //   189: invokeinterface 120 1 0
    //   194: aload 6
    //   196: areturn
    //   197: aload 4
    //   199: ifnull +10 -> 209
    //   202: aload 4
    //   204: invokeinterface 120 1 0
    //   209: goto +5 -> 214
    //   212: aload_1
    //   213: athrow
    //   214: goto -2 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	SQLiteOpenHelperFacade
    //   0	217	1	paramSQLiteDatabase	SQLiteDatabase
    //   63	41	2	i	int
    //   92	2	3	bool	boolean
    //   4	199	4	localObject1	Object
    //   19	121	5	localObject2	Object
    //   153	27	5	localException1	Exception
    //   10	185	6	localSQLiteDatabase	SQLiteDatabase
    //   7	1	7	localObject3	Object
    //   115	44	7	localException2	Exception
    //   1	33	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   37	47	107	finally
    //   50	62	107	finally
    //   67	82	107	finally
    //   85	93	107	finally
    //   37	47	115	java/lang/Exception
    //   50	62	115	java/lang/Exception
    //   67	82	115	java/lang/Exception
    //   85	93	115	java/lang/Exception
    //   12	21	149	finally
    //   164	176	149	finally
    //   179	184	149	finally
    //   12	21	153	java/lang/Exception
  }
  
  public static ISQLiteOpenHelper getHelper(EntityManagerFactory paramEntityManagerFactory, String paramString, int paramInt)
  {
    return getHelper(paramEntityManagerFactory, paramString, paramInt, null);
  }
  
  public static ISQLiteOpenHelper getHelper(EntityManagerFactory paramEntityManagerFactory, String paramString, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    boolean bool = isLocalized();
    if (QLog.isColorLevel()) {
      QLog.d("SQLiteOpenHelperFacade", 2, new Object[] { "getHelper isLocalized: ", Boolean.valueOf(bool) });
    }
    if (bool) {
      return new LocalizedSQLiteOpenHelperImpl(paramEntityManagerFactory, paramString, paramEntityManagerFactory.tag, paramInt, paramDatabaseErrorHandler);
    }
    return new SQLiteOpenHelperImpl(paramEntityManagerFactory, paramString, paramEntityManagerFactory.tag, paramInt, paramDatabaseErrorHandler);
  }
  
  private static boolean isLocalized()
  {
    return ((ICommonFunctionPublishConfigService)QRoute.api(ICommonFunctionPublishConfigService.class)).isLocalized();
  }
  
  private void reportDBOpenLocaleError(Exception paramException)
  {
    if ((paramException instanceof SQLiteException))
    {
      String str = paramException.getMessage();
      if ((!TextUtils.isEmpty(str)) && (str.startsWith("Failed to change locale for db"))) {
        CaughtExceptionReportProxy.e(paramException, "DB open fail for different locale");
      }
    }
  }
  
  public void close()
  {
    QLog.e(this.tag, 1, "SQLiteOpenHelperImpl close");
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
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e(this.tag, 1, "close", localException);
    }
  }
  
  public void dropAllTable()
  {
    dropAllTable(this.mInnerDb);
  }
  
  /* Error */
  public SQLiteDatabase getReadableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 22	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:mActualHelper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   7: invokeinterface 214 1 0
    //   12: putfield 196	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:dbR	Landroid/database/sqlite/SQLiteDatabase;
    //   15: goto +28 -> 43
    //   18: astore_1
    //   19: goto +33 -> 52
    //   22: astore_1
    //   23: aload_0
    //   24: getfield 28	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:tag	Ljava/lang/String;
    //   27: iconst_1
    //   28: ldc 215
    //   30: aload_1
    //   31: invokestatic 78	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   34: aload_1
    //   35: invokestatic 84	com/tencent/mobileqq/app/SQLiteOpenHelper:throwDebugException	(Ljava/lang/Exception;)V
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 217	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:reportDBOpenLocaleError	(Ljava/lang/Exception;)V
    //   43: aload_0
    //   44: getfield 196	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:dbR	Landroid/database/sqlite/SQLiteDatabase;
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: areturn
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	SQLiteOpenHelperFacade
    //   18	1	1	localObject	Object
    //   22	18	1	localException	Exception
    //   47	8	1	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   2	15	18	finally
    //   23	43	18	finally
    //   43	48	18	finally
    //   2	15	22	java/lang/Exception
  }
  
  /* Error */
  public SQLiteDatabase getWritableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 22	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:mActualHelper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   7: invokeinterface 221 1 0
    //   12: putfield 202	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:dbW	Landroid/database/sqlite/SQLiteDatabase;
    //   15: aload_0
    //   16: getfield 202	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:dbW	Landroid/database/sqlite/SQLiteDatabase;
    //   19: iconst_0
    //   20: invokevirtual 225	android/database/sqlite/SQLiteDatabase:setLockingEnabled	(Z)V
    //   23: goto +28 -> 51
    //   26: astore_1
    //   27: goto +33 -> 60
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 28	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:tag	Ljava/lang/String;
    //   35: iconst_1
    //   36: ldc 226
    //   38: aload_1
    //   39: invokestatic 78	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   42: aload_1
    //   43: invokestatic 84	com/tencent/mobileqq/app/SQLiteOpenHelper:throwDebugException	(Ljava/lang/Exception;)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 217	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:reportDBOpenLocaleError	(Ljava/lang/Exception;)V
    //   51: aload_0
    //   52: getfield 202	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:dbW	Landroid/database/sqlite/SQLiteDatabase;
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: areturn
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	SQLiteOpenHelperFacade
    //   26	1	1	localObject	Object
    //   30	18	1	localException	Exception
    //   55	8	1	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   2	23	26	finally
    //   31	51	26	finally
    //   51	56	26	finally
    //   2	23	30	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    if (QLog.isColorLevel())
    {
      String str = this.tag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[DB]");
      localStringBuilder.append(this.databaseName);
      localStringBuilder.append(" onCreate");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    this.mEmf.createDatabase(paramSQLiteDatabase);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.tag;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[DB]");
      ((StringBuilder)localObject2).append(this.databaseName);
      ((StringBuilder)localObject2).append(" onOpen");
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    this.mInnerDb = paramSQLiteDatabase;
    for (;;)
    {
      int i;
      try
      {
        localObject1 = SQLiteDatabase.class.getDeclaredField("mConfigurationLocked");
        ((Field)localObject1).setAccessible(true);
        localObject2 = ((Field)localObject1).get(paramSQLiteDatabase);
        localObject1 = localObject2.getClass().getDeclaredField("maxSqlCacheSize");
        ((Field)localObject1).setAccessible(true);
        ((Field)localObject1).set(localObject2, Integer.valueOf(150));
        localObject1 = SQLiteDatabase.class.getDeclaredField("mConnectionPoolLocked");
        ((Field)localObject1).setAccessible(true);
        Object localObject3 = ((Field)localObject1).get(paramSQLiteDatabase);
        localObject1 = null;
        Method[] arrayOfMethod = localObject3.getClass().getDeclaredMethods();
        int j = arrayOfMethod.length;
        i = 0;
        paramSQLiteDatabase = (SQLiteDatabase)localObject1;
        if (i < j)
        {
          paramSQLiteDatabase = arrayOfMethod[i];
          if (!TextUtils.equals(paramSQLiteDatabase.getName(), "reconfigure")) {
            break label621;
          }
        }
        if (paramSQLiteDatabase != null)
        {
          paramSQLiteDatabase.setAccessible(true);
          paramSQLiteDatabase.invoke(localObject3, new Object[] { localObject2 });
          if (QLog.isColorLevel())
          {
            paramSQLiteDatabase = this.tag;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[DB]");
            ((StringBuilder)localObject1).append(this.databaseName);
            ((StringBuilder)localObject1).append(" LRU MAX SIZE = ");
            ((StringBuilder)localObject1).append(150);
            QLog.i(paramSQLiteDatabase, 2, ((StringBuilder)localObject1).toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          paramSQLiteDatabase = this.tag;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[DB]");
          ((StringBuilder)localObject1).append(this.databaseName);
          ((StringBuilder)localObject1).append(" not find reconfigure()");
          QLog.w(paramSQLiteDatabase, 2, ((StringBuilder)localObject1).toString());
        }
      }
      catch (InvocationTargetException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject1 = this.tag;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[DB]");
          ((StringBuilder)localObject2).append(this.databaseName);
          ((StringBuilder)localObject2).append("  onOpen");
          QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString(), paramSQLiteDatabase);
        }
      }
      catch (IllegalAccessException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject1 = this.tag;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[DB]");
          ((StringBuilder)localObject2).append(this.databaseName);
          ((StringBuilder)localObject2).append("  onOpen");
          QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString(), paramSQLiteDatabase);
        }
      }
      catch (IllegalArgumentException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject1 = this.tag;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[DB]");
          ((StringBuilder)localObject2).append(this.databaseName);
          ((StringBuilder)localObject2).append("  onOpen");
          QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString(), paramSQLiteDatabase);
        }
      }
      catch (NoSuchFieldException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject1 = this.tag;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[DB]");
          ((StringBuilder)localObject2).append(this.databaseName);
          ((StringBuilder)localObject2).append("  onOpen");
          QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString(), paramSQLiteDatabase);
        }
      }
      this.mEmf.cleanOverDueCorruptDatabase();
      return;
      label621:
      i += 1;
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.tag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[DB]");
      localStringBuilder.append(this.databaseName);
      localStringBuilder.append(" onUpgrade oldVersion: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" newVersion: ");
      localStringBuilder.append(paramInt2);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    this.mEmf.upgradeDatabase(paramSQLiteDatabase, paramInt1, paramInt2);
    Object localObject = this.mEmf;
    ((EntityManagerFactory)localObject).checkTableColumnChange(((EntityManagerFactory)localObject).getPackageName(), paramSQLiteDatabase, paramInt1, paramInt2);
    this.mEmf.doAfterUpgradeDatabase(paramSQLiteDatabase, paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i(this.tag, 2, "[DB] onUpgrade end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade
 * JD-Core Version:    0.7.0.1
 */