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
  private SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  private final EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private final ISQLiteOpenHelper jdField_a_of_type_ComTencentMobileqqPersistenceISQLiteOpenHelper;
  private final String jdField_a_of_type_JavaLangString;
  private SQLiteDatabase jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  private final String jdField_b_of_type_JavaLangString;
  private SQLiteDatabase c;
  
  public SQLiteOpenHelperFacade(ISQLiteOpenHelper paramISQLiteOpenHelper, String paramString1, EntityManagerFactory paramEntityManagerFactory, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceISQLiteOpenHelper = paramISQLiteOpenHelper;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = paramEntityManagerFactory;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public static ISQLiteOpenHelper a(EntityManagerFactory paramEntityManagerFactory, String paramString, int paramInt)
  {
    return a(paramEntityManagerFactory, paramString, paramInt, null);
  }
  
  public static ISQLiteOpenHelper a(EntityManagerFactory paramEntityManagerFactory, String paramString, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    boolean bool = a();
    if (QLog.isColorLevel()) {
      QLog.d("SQLiteOpenHelperFacade", 2, new Object[] { "getHelper isLocalized: ", Boolean.valueOf(bool) });
    }
    if (bool) {
      return new LocalizedSQLiteOpenHelperImpl(paramEntityManagerFactory, paramString, paramEntityManagerFactory.tag, paramInt, paramDatabaseErrorHandler);
    }
    return new SQLiteOpenHelperImpl(paramEntityManagerFactory, paramString, paramEntityManagerFactory.tag, paramInt, paramDatabaseErrorHandler);
  }
  
  private void a(Exception paramException)
  {
    if ((paramException instanceof SQLiteException))
    {
      String str = paramException.getMessage();
      if ((!TextUtils.isEmpty(str)) && (str.startsWith("Failed to change locale for db"))) {
        CaughtExceptionReportProxy.e(paramException, "DB open fail for different locale");
      }
    }
  }
  
  private static boolean a()
  {
    return ((ICommonFunctionPublishConfigService)QRoute.api(ICommonFunctionPublishConfigService.class)).isLocalized();
  }
  
  /* Error */
  private String[] a(SQLiteDatabase paramSQLiteDatabase)
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
    //   13: ldc 109
    //   15: aconst_null
    //   16: invokevirtual 115	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
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
    //   39: invokeinterface 120 1 0
    //   44: ifeq +90 -> 134
    //   47: aload 6
    //   49: astore_1
    //   50: aload 5
    //   52: invokeinterface 124 1 0
    //   57: anewarray 83	java/lang/String
    //   60: astore 4
    //   62: iconst_0
    //   63: istore_2
    //   64: aload 4
    //   66: astore_1
    //   67: aload 4
    //   69: iload_2
    //   70: aload 5
    //   72: iconst_0
    //   73: invokeinterface 128 2 0
    //   78: invokestatic 134	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   81: aastore
    //   82: aload 4
    //   84: astore_1
    //   85: aload 5
    //   87: invokeinterface 137 1 0
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
    //   141: invokeinterface 140 1 0
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
    //   165: getfield 24	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   168: iconst_1
    //   169: ldc 142
    //   171: aload 5
    //   173: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   176: aload_1
    //   177: astore 4
    //   179: aload 5
    //   181: invokestatic 150	com/tencent/mobileqq/app/SQLiteOpenHelper:throwDebugException	(Ljava/lang/Exception;)V
    //   184: aload_1
    //   185: ifnull +9 -> 194
    //   188: aload_1
    //   189: invokeinterface 140 1 0
    //   194: aload 6
    //   196: areturn
    //   197: aload 4
    //   199: ifnull +10 -> 209
    //   202: aload 4
    //   204: invokeinterface 140 1 0
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
  
  private void c(SQLiteDatabase paramSQLiteDatabase)
  {
    String[] arrayOfString = a(paramSQLiteDatabase);
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
            String str2 = this.jdField_b_of_type_JavaLangString;
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
    a(paramSQLiteDatabase);
  }
  
  /* Error */
  public SQLiteDatabase a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 18	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:jdField_a_of_type_ComTencentMobileqqPersistenceISQLiteOpenHelper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   7: invokeinterface 189 1 0
    //   12: putfield 191	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   15: aload_0
    //   16: getfield 191	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   19: iconst_0
    //   20: invokevirtual 195	android/database/sqlite/SQLiteDatabase:setLockingEnabled	(Z)V
    //   23: goto +28 -> 51
    //   26: astore_1
    //   27: goto +33 -> 60
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 24	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   35: iconst_1
    //   36: ldc 197
    //   38: aload_1
    //   39: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   42: aload_1
    //   43: invokestatic 150	com/tencent/mobileqq/app/SQLiteOpenHelper:throwDebugException	(Ljava/lang/Exception;)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 199	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:a	(Ljava/lang/Exception;)V
    //   51: aload_0
    //   52: getfield 191	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
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
  
  public void a()
  {
    c(this.c);
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[DB]");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" onCreate");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory.createDatabase(paramSQLiteDatabase);
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[DB]");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" onUpgrade oldVersion: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" newVersion: ");
      localStringBuilder.append(paramInt2);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory.upgradeDatabase(paramSQLiteDatabase, paramInt1, paramInt2);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
    ((EntityManagerFactory)localObject).checkTableColumnChange(((EntityManagerFactory)localObject).getPackageName(), paramSQLiteDatabase, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory.doAfterUpgradeDatabase(paramSQLiteDatabase, paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "[DB] onUpgrade end");
    }
  }
  
  /* Error */
  public SQLiteDatabase b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 18	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:jdField_a_of_type_ComTencentMobileqqPersistenceISQLiteOpenHelper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   7: invokeinterface 239 1 0
    //   12: putfield 241	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   15: goto +28 -> 43
    //   18: astore_1
    //   19: goto +33 -> 52
    //   22: astore_1
    //   23: aload_0
    //   24: getfield 24	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   27: iconst_1
    //   28: ldc 243
    //   30: aload_1
    //   31: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   34: aload_1
    //   35: invokestatic 150	com/tencent/mobileqq/app/SQLiteOpenHelper:throwDebugException	(Ljava/lang/Exception;)V
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 199	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:a	(Ljava/lang/Exception;)V
    //   43: aload_0
    //   44: getfield 241	com/tencent/mobileqq/persistence/SQLiteOpenHelperFacade:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
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
  
  public void b()
  {
    QLog.e(this.jdField_b_of_type_JavaLangString, 1, "SQLiteOpenHelperImpl close");
    try
    {
      if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null) && (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()))
      {
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = null;
      }
      if ((this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase != null) && (this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()))
      {
        this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
        this.jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase = null;
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "close", localException);
    }
  }
  
  public void b(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[DB]");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(" onOpen");
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    this.c = paramSQLiteDatabase;
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
            break label623;
          }
        }
        if (paramSQLiteDatabase != null)
        {
          paramSQLiteDatabase.setAccessible(true);
          paramSQLiteDatabase.invoke(localObject3, new Object[] { localObject2 });
          if (QLog.isColorLevel())
          {
            paramSQLiteDatabase = this.jdField_b_of_type_JavaLangString;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[DB]");
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject1).append(" LRU MAX SIZE = ");
            ((StringBuilder)localObject1).append(150);
            QLog.i(paramSQLiteDatabase, 2, ((StringBuilder)localObject1).toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          paramSQLiteDatabase = this.jdField_b_of_type_JavaLangString;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[DB]");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(" not find reconfigure()");
          QLog.w(paramSQLiteDatabase, 2, ((StringBuilder)localObject1).toString());
        }
      }
      catch (InvocationTargetException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject1 = this.jdField_b_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[DB]");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append("  onOpen");
          QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString(), paramSQLiteDatabase);
        }
      }
      catch (IllegalAccessException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject1 = this.jdField_b_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[DB]");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append("  onOpen");
          QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString(), paramSQLiteDatabase);
        }
      }
      catch (IllegalArgumentException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject1 = this.jdField_b_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[DB]");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append("  onOpen");
          QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString(), paramSQLiteDatabase);
        }
      }
      catch (NoSuchFieldException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject1 = this.jdField_b_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[DB]");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append("  onOpen");
          QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString(), paramSQLiteDatabase);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory.cleanOverDueCorruptDatabase();
      return;
      label623:
      i += 1;
    }
  }
  
  public void b(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade
 * JD-Core Version:    0.7.0.1
 */