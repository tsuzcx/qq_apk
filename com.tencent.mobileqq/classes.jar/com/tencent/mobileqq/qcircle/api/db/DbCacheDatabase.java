package com.tencent.mobileqq.qcircle.api.db;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.db.util.EncryptUtil;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

public class DbCacheDatabase
  extends SQLiteOpenHelper
  implements Sessional
{
  public static volatile boolean a = false;
  private static boolean i = true;
  private static HashMap<String, DbCacheDatabase> j = new HashMap();
  private String b;
  private HashSet<Integer> c = new HashSet();
  private Context d = null;
  private volatile boolean e = false;
  private boolean f = true;
  private int g = 0;
  private EncryptUtil h;
  
  @TargetApi(11)
  protected DbCacheDatabase(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt1, int paramInt2, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt1, paramDatabaseErrorHandler);
    this.b = paramString;
    this.d = paramContext;
    this.h = new EncryptUtil(a(false));
    a = QCircleConfigHelper.a("QZoneSetting", "enablewal", Boolean.valueOf(i)).booleanValue();
  }
  
  public static DbCacheDatabase a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      DbCacheDatabase localDbCacheDatabase2 = (DbCacheDatabase)j.get(paramString);
      DbCacheDatabase localDbCacheDatabase1 = localDbCacheDatabase2;
      if (localDbCacheDatabase2 == null)
      {
        localDbCacheDatabase1 = new DbCacheDatabase(paramContext, paramString, null, paramInt1, paramInt2, new DbCacheDatabase.1());
        j.put(paramString, localDbCacheDatabase1);
      }
      return localDbCacheDatabase1;
    }
    finally {}
  }
  
  private void a(Throwable paramThrowable)
  {
    try
    {
      DbCacheExceptionHandler.a().a(paramThrowable, this.b);
      return;
    }
    catch (Throwable paramThrowable)
    {
      QLog.e("QCircleDbCacheDatabase", 1, "handleException error", paramThrowable);
    }
  }
  
  public SQLiteDatabase a(boolean paramBoolean)
  {
    Object localObject1 = null;
    if (paramBoolean) {}
    label25:
    label67:
    label94:
    label119:
    do
    {
      try
      {
        try
        {
          Object localObject5 = getWritableDatabase();
          localObject1 = localObject5;
          break label25;
          localObject5 = getReadableDatabase();
          localObject1 = localObject5;
          localObject5 = localObject1;
          try
          {
            if (!this.e) {
              break;
            }
            if (localObject1 != null) {
              localObject1.close();
            }
            b();
            if (paramBoolean) {}
            try
            {
              localObject5 = getWritableDatabase();
              localObject1 = localObject5;
              break label67;
              localObject5 = getReadableDatabase();
              localObject1 = localObject5;
            }
            catch (Throwable localThrowable2)
            {
              a(localThrowable2);
            }
            this.e = false;
            localObject6 = localObject1;
          }
          finally {}
          b();
        }
        finally
        {
          break label174;
        }
      }
      catch (Throwable localThrowable5)
      {
        Object localObject6;
        Object localObject4;
        Object localObject7;
        break label94;
      }
      if (paramBoolean) {}
      try
      {
        localObject6 = getWritableDatabase();
        localObject4 = localObject6;
        break label119;
        localObject6 = getReadableDatabase();
        localObject4 = localObject6;
      }
      catch (Throwable localThrowable3)
      {
        a(localThrowable3);
      }
      localObject7 = localObject4;
    } while (this.e);
    if (localObject7 != null)
    {
      paramBoolean = a;
      if (paramBoolean) {
        try
        {
          localObject7.enableWriteAheadLogging();
        }
        catch (Throwable localThrowable1)
        {
          a = false;
          a(localThrowable1);
        }
      }
    }
    return localObject7;
    label174:
    if (this.e)
    {
      b();
      if (paramBoolean) {}
      try
      {
        getWritableDatabase();
      }
      catch (Throwable localThrowable4)
      {
        a(localThrowable4);
      }
      getReadableDatabase();
      this.e = false;
    }
    throw localThrowable1;
    for (;;)
    {
      throw localThrowable1;
    }
  }
  
  public EncryptUtil a()
  {
    return this.h;
  }
  
  public void attach(int paramInt)
  {
    try
    {
      if (this.c.add(Integer.valueOf(paramInt))) {
        this.g += 1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[DB]");
      localStringBuilder.append(this.b);
      localStringBuilder.append("  attach sessionId:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("mAttachCount:");
      localStringBuilder.append(this.g);
      QLog.i("QCircleDbCacheDatabase", 1, localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  public void b()
  {
    this.d.deleteDatabase(this.b);
    QLog.e("QCircleDbCacheDatabase", 1, new Object[] { Integer.valueOf(1), "detele db:", this.b });
  }
  
  public void detach(int paramInt)
  {
    try
    {
      boolean bool = this.c.remove(Integer.valueOf(paramInt));
      int m = 0;
      int k = m;
      if (bool)
      {
        int n = this.g - 1;
        this.g = n;
        k = m;
        if (n == 0) {
          k = 1;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[DB]");
      localStringBuilder.append(this.b);
      localStringBuilder.append("  detach sessionId:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("mAttachCount:");
      localStringBuilder.append(this.g);
      QLog.i("QCircleDbCacheDatabase", 1, localStringBuilder.toString());
      if ((k != 0) && (this.f))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[DB] close ");
        localStringBuilder.append(this.b);
        localStringBuilder.append(",mAttachCount:");
        localStringBuilder.append(this.g);
        QLog.i("QCircleDbCacheDatabase", 1, localStringBuilder.toString());
        close();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  protected void finalize()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 205	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:close	()V
    //   4: aload_0
    //   5: invokespecial 210	java/lang/Object:finalize	()V
    //   8: return
    //   9: astore_1
    //   10: goto +16 -> 26
    //   13: astore_1
    //   14: ldc 120
    //   16: iconst_1
    //   17: ldc 212
    //   19: aload_1
    //   20: invokestatic 127	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   23: goto -19 -> 4
    //   26: aload_0
    //   27: invokespecial 210	java/lang/Object:finalize	()V
    //   30: goto +5 -> 35
    //   33: aload_1
    //   34: athrow
    //   35: goto -2 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	DbCacheDatabase
    //   9	1	1	localObject	Object
    //   13	21	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	9	finally
    //   14	23	9	finally
    //   0	4	13	java/lang/Exception
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase = new StringBuilder();
    paramSQLiteDatabase.append("DbCacheDatabase onDowngrade oldVersion:");
    paramSQLiteDatabase.append(paramInt1);
    paramSQLiteDatabase.append(",newVersion=");
    paramSQLiteDatabase.append(paramInt2);
    QLog.i("QCircleDbCacheDatabase", 1, paramSQLiteDatabase.toString());
    this.e = true;
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[DB]");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(" onOpen");
      QLog.i("QCircleDbCacheDatabase", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      int k;
      try
      {
        localObject1 = SQLiteDatabase.class.getDeclaredField("mConfigurationLocked");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(paramSQLiteDatabase);
        Object localObject2 = localObject1.getClass().getDeclaredField("maxSqlCacheSize");
        ((Field)localObject2).setAccessible(true);
        ((Field)localObject2).set(localObject1, Integer.valueOf(150));
        localObject2 = SQLiteDatabase.class.getDeclaredField("mConnectionPoolLocked");
        ((Field)localObject2).setAccessible(true);
        localObject2 = ((Field)localObject2).get(paramSQLiteDatabase);
        Method[] arrayOfMethod = localObject2.getClass().getDeclaredMethods();
        int m = arrayOfMethod.length;
        k = 0;
        if (k >= m) {
          break label605;
        }
        paramSQLiteDatabase = arrayOfMethod[k];
        if (!TextUtils.equals(paramSQLiteDatabase.getName(), "reconfigure")) {
          break label598;
        }
        if (paramSQLiteDatabase != null)
        {
          paramSQLiteDatabase.setAccessible(true);
          paramSQLiteDatabase.invoke(localObject2, new Object[] { localObject1 });
          if (QLog.isColorLevel())
          {
            paramSQLiteDatabase = new StringBuilder();
            paramSQLiteDatabase.append("[DB]");
            paramSQLiteDatabase.append(this.b);
            paramSQLiteDatabase.append(" LRU MAX SIZE = ");
            paramSQLiteDatabase.append(localObject1.getClass().getDeclaredField("maxSqlCacheSize").getInt(localObject1));
            QLog.i("QCircleDbCacheDatabase", 2, paramSQLiteDatabase.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          paramSQLiteDatabase = new StringBuilder();
          paramSQLiteDatabase.append("[DB]");
          paramSQLiteDatabase.append(this.b);
          paramSQLiteDatabase.append(" not find reconfigure()");
          QLog.i("QCircleDbCacheDatabase", 2, paramSQLiteDatabase.toString());
          return;
        }
      }
      catch (InvocationTargetException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[DB]");
          ((StringBuilder)localObject1).append(this.b);
          ((StringBuilder)localObject1).append("  onOpen");
          ((StringBuilder)localObject1).append(paramSQLiteDatabase.getMessage());
          QLog.w("QCircleDbCacheDatabase", 1, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      catch (IllegalAccessException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[DB]");
          ((StringBuilder)localObject1).append(this.b);
          ((StringBuilder)localObject1).append("  onOpen");
          ((StringBuilder)localObject1).append(paramSQLiteDatabase.getMessage());
          QLog.w("QCircleDbCacheDatabase", 1, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      catch (IllegalArgumentException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[DB]");
          ((StringBuilder)localObject1).append(this.b);
          ((StringBuilder)localObject1).append("  onOpen");
          ((StringBuilder)localObject1).append(paramSQLiteDatabase.getMessage());
          QLog.w("QCircleDbCacheDatabase", 1, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      catch (NoSuchFieldException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[DB]");
          ((StringBuilder)localObject1).append(this.b);
          ((StringBuilder)localObject1).append("  onOpen");
          ((StringBuilder)localObject1).append(paramSQLiteDatabase.getMessage());
          QLog.w("QCircleDbCacheDatabase", 1, ((StringBuilder)localObject1).toString());
        }
      }
      return;
      label598:
      k += 1;
      continue;
      label605:
      paramSQLiteDatabase = null;
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase = new StringBuilder();
    paramSQLiteDatabase.append("DbCacheDatabase onUpgrade oldVersion:");
    paramSQLiteDatabase.append(paramInt1);
    paramSQLiteDatabase.append(",newVersion=");
    paramSQLiteDatabase.append(paramInt2);
    QLog.i("QCircleDbCacheDatabase", 1, paramSQLiteDatabase.toString());
    this.e = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.DbCacheDatabase
 * JD-Core Version:    0.7.0.1
 */