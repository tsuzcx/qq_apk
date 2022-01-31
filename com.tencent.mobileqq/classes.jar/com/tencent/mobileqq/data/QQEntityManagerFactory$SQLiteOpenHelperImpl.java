package com.tencent.mobileqq.data;

import abvb;
import abvd;
import android.annotation.TargetApi;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class QQEntityManagerFactory$SQLiteOpenHelperImpl
  extends SQLiteOpenHelper
{
  private String databaseName;
  private SQLiteDatabase dbR;
  private SQLiteDatabase dbW;
  private SQLiteDatabase mInnerDb;
  
  public QQEntityManagerFactory$SQLiteOpenHelperImpl(QQEntityManagerFactory paramQQEntityManagerFactory, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(BaseApplication.getContext(), paramString, new abvb(paramQQEntityManagerFactory, null), paramInt);
    this.databaseName = paramString;
  }
  
  @TargetApi(11)
  public QQEntityManagerFactory$SQLiteOpenHelperImpl(QQEntityManagerFactory paramQQEntityManagerFactory, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, abvd paramabvd)
  {
    super(BaseApplication.getContext(), paramString, new abvb(paramQQEntityManagerFactory, null), paramInt, paramabvd);
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
          if (!"sqlite_sequence".equals(str))
          {
            try
            {
              paramSQLiteDatabase.execSQL(TableBuilder.a(str));
            }
            catch (SQLiteException localSQLiteException)
            {
              localSQLiteException.printStackTrace();
            }
            if (QLog.isColorLevel()) {
              QLog.w(this.this$0.TAG, 2, "[DB] dropAllTable " + str, localSQLiteException);
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
    //   3: ldc 111
    //   5: aconst_null
    //   6: invokevirtual 115	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   9: astore 4
    //   11: aload 4
    //   13: ifnull +161 -> 174
    //   16: aload 4
    //   18: astore 5
    //   20: aload 4
    //   22: invokeinterface 120 1 0
    //   27: ifeq +147 -> 174
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
    //   59: invokestatic 133	com/tencent/mobileqq/utils/SecurityUtile:b	(Ljava/lang/String;)Ljava/lang/String;
    //   62: aastore
    //   63: aload 4
    //   65: astore 5
    //   67: aload 4
    //   69: invokeinterface 136 1 0
    //   74: istore_3
    //   75: iload_3
    //   76: ifne +91 -> 167
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
    //   111: aload 6
    //   113: invokevirtual 140	java/lang/Exception:printStackTrace	()V
    //   116: aload_1
    //   117: astore 5
    //   119: aload 4
    //   121: ifnull -24 -> 97
    //   124: aload 4
    //   126: invokeinterface 139 1 0
    //   131: aload_1
    //   132: areturn
    //   133: astore_1
    //   134: aconst_null
    //   135: astore 5
    //   137: aload 5
    //   139: ifnull +10 -> 149
    //   142: aload 5
    //   144: invokeinterface 139 1 0
    //   149: aload_1
    //   150: athrow
    //   151: astore_1
    //   152: goto -15 -> 137
    //   155: astore 6
    //   157: aconst_null
    //   158: astore_1
    //   159: goto -52 -> 107
    //   162: astore 6
    //   164: goto -57 -> 107
    //   167: iload_2
    //   168: iconst_1
    //   169: iadd
    //   170: istore_2
    //   171: goto -126 -> 45
    //   174: aconst_null
    //   175: astore_1
    //   176: goto -97 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	SQLiteOpenHelperImpl
    //   0	179	1	paramSQLiteDatabase	SQLiteDatabase
    //   1	170	2	i	int
    //   74	2	3	bool	boolean
    //   9	116	4	localCursor	android.database.Cursor
    //   18	125	5	localObject	Object
    //   100	12	6	localException1	Exception
    //   155	1	6	localException2	Exception
    //   162	1	6	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   2	11	100	java/lang/Exception
    //   2	11	133	finally
    //   20	30	151	finally
    //   34	45	151	finally
    //   49	63	151	finally
    //   67	75	151	finally
    //   111	116	151	finally
    //   20	30	155	java/lang/Exception
    //   34	45	155	java/lang/Exception
    //   49	63	162	java/lang/Exception
    //   67	75	162	java/lang/Exception
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
    catch (Exception localException) {}
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
        localException.printStackTrace();
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
        localException.printStackTrace();
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
        break label576;
      }
      paramSQLiteDatabase = arrayOfMethod[i];
      if (!TextUtils.equals(paramSQLiteDatabase.getName(), "reconfigure")) {
        break label305;
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
      paramSQLiteDatabase = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/corruptInfo");
      if ((paramSQLiteDatabase.exists()) && (System.currentTimeMillis() - paramSQLiteDatabase.lastModified() > 604800000L)) {
        paramSQLiteDatabase.delete();
      }
      return;
      label305:
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
    AIOInputTypeHelper.a();
    if (QLog.isColorLevel()) {
      QLog.i(this.this$0.TAG, 2, "[DB] onUpgrade end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQEntityManagerFactory.SQLiteOpenHelperImpl
 * JD-Core Version:    0.7.0.1
 */