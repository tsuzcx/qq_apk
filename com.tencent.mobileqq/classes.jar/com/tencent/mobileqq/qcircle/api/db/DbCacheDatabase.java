package com.tencent.mobileqq.qcircle.api.db;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.db.util.EncryptUtil;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

public class DbCacheDatabase
  extends SQLiteOpenHelper
  implements Sessional
{
  private static HashMap<String, DbCacheDatabase> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public static volatile boolean a = false;
  private static boolean d = true;
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext = null;
  private EncryptUtil jdField_a_of_type_ComTencentMobileqqQcircleApiDbUtilEncryptUtil;
  private String jdField_a_of_type_JavaLangString;
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private int jdField_b_of_type_Int = 1;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  
  @TargetApi(11)
  protected DbCacheDatabase(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt1, int paramInt2, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt1, paramDatabaseErrorHandler);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbUtilEncryptUtil = new EncryptUtil(a(false));
    jdField_a_of_type_Boolean = QCircleConfigHelper.a("QZoneSetting", "enablewal", Boolean.valueOf(d)).booleanValue();
  }
  
  public static DbCacheDatabase a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      DbCacheDatabase localDbCacheDatabase2 = (DbCacheDatabase)jdField_a_of_type_JavaUtilHashMap.get(paramString);
      DbCacheDatabase localDbCacheDatabase1 = localDbCacheDatabase2;
      if (localDbCacheDatabase2 == null)
      {
        localDbCacheDatabase1 = new DbCacheDatabase(paramContext, paramString, null, paramInt1, paramInt2, new DbCacheDatabase.1());
        jdField_a_of_type_JavaUtilHashMap.put(paramString, localDbCacheDatabase1);
      }
      return localDbCacheDatabase1;
    }
    finally {}
  }
  
  private void a(Throwable paramThrowable)
  {
    try
    {
      DbCacheExceptionHandler.a().a(paramThrowable, this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Throwable paramThrowable)
    {
      RFLog.e("QCircleDbCacheDatabase", RFLog.USR, new Object[] { "handleException error", paramThrowable });
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
            if (!this.jdField_b_of_type_Boolean) {
              break;
            }
            if (localObject1 != null) {
              localObject1.close();
            }
            a();
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
            this.jdField_b_of_type_Boolean = false;
            localObject6 = localObject1;
          }
          finally {}
          a();
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
    } while (this.jdField_b_of_type_Boolean);
    if (localObject7 != null)
    {
      paramBoolean = jdField_a_of_type_Boolean;
      if (paramBoolean) {
        try
        {
          localObject7.enableWriteAheadLogging();
        }
        catch (Throwable localThrowable1)
        {
          jdField_a_of_type_Boolean = false;
          a(localThrowable1);
        }
      }
    }
    return localObject7;
    label174:
    if (this.jdField_b_of_type_Boolean)
    {
      a();
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
      this.jdField_b_of_type_Boolean = false;
    }
    throw localThrowable1;
    for (;;)
    {
      throw localThrowable1;
    }
  }
  
  public EncryptUtil a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbUtilEncryptUtil;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContext.deleteDatabase(this.jdField_a_of_type_JavaLangString);
    RFLog.e("QCircleDbCacheDatabase", RFLog.USR, new Object[] { Integer.valueOf(RFLog.USR), "detele db:", this.jdField_a_of_type_JavaLangString });
  }
  
  public void attach(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramInt))) {
        this.jdField_a_of_type_Int += 1;
      }
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[DB]");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("  attach sessionId:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("mAttachCount:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      RFLog.i("QCircleDbCacheDatabase", i, localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  public void detach(int paramInt)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramInt));
      int j = 0;
      int i = j;
      if (bool)
      {
        int k = this.jdField_a_of_type_Int - 1;
        this.jdField_a_of_type_Int = k;
        i = j;
        if (k == 0) {
          i = 1;
        }
      }
      j = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[DB]");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("  detach sessionId:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("mAttachCount:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      RFLog.i("QCircleDbCacheDatabase", j, localStringBuilder.toString());
      if ((i != 0) && (this.c))
      {
        paramInt = RFLog.USR;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[DB] close ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(",mAttachCount:");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        RFLog.i("QCircleDbCacheDatabase", paramInt, localStringBuilder.toString());
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
    //   1: invokevirtual 203	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:close	()V
    //   4: aload_0
    //   5: invokespecial 208	java/lang/Object:finalize	()V
    //   8: return
    //   9: astore_1
    //   10: goto +28 -> 38
    //   13: astore_1
    //   14: ldc 116
    //   16: getstatic 121	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   19: iconst_2
    //   20: anewarray 123	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: ldc 210
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: aload_1
    //   31: aastore
    //   32: invokestatic 129	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   35: goto -31 -> 4
    //   38: aload_0
    //   39: invokespecial 208	java/lang/Object:finalize	()V
    //   42: goto +5 -> 47
    //   45: aload_1
    //   46: athrow
    //   47: goto -2 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	DbCacheDatabase
    //   9	1	1	localObject	Object
    //   13	33	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	9	finally
    //   14	35	9	finally
    //   0	4	13	java/lang/Exception
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    int i = RFLog.USR;
    paramSQLiteDatabase = new StringBuilder();
    paramSQLiteDatabase.append("DbCacheDatabase onDowngrade oldVersion:");
    paramSQLiteDatabase.append(paramInt1);
    paramSQLiteDatabase.append(",newVersion=");
    paramSQLiteDatabase.append(paramInt2);
    RFLog.i("QCircleDbCacheDatabase", i, paramSQLiteDatabase.toString());
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    int i;
    Object localObject1;
    if (RFLog.isColorLevel())
    {
      i = RFLog.CLR;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[DB]");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(" onOpen");
      RFLog.i("QCircleDbCacheDatabase", i, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = SQLiteDatabase.class.getDeclaredField("mConfigurationLocked");
        ((Field)localObject1).setAccessible(true);
        Object localObject2 = ((Field)localObject1).get(paramSQLiteDatabase);
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
            break label632;
          }
        }
        if (paramSQLiteDatabase != null)
        {
          paramSQLiteDatabase.setAccessible(true);
          paramSQLiteDatabase.invoke(localObject3, new Object[] { localObject2 });
          if (RFLog.isColorLevel())
          {
            i = RFLog.CLR;
            paramSQLiteDatabase = new StringBuilder();
            paramSQLiteDatabase.append("[DB]");
            paramSQLiteDatabase.append(this.jdField_a_of_type_JavaLangString);
            paramSQLiteDatabase.append(" LRU MAX SIZE = ");
            paramSQLiteDatabase.append(localObject2.getClass().getDeclaredField("maxSqlCacheSize").getInt(localObject2));
            RFLog.i("QCircleDbCacheDatabase", i, paramSQLiteDatabase.toString());
          }
        }
        else if (RFLog.isColorLevel())
        {
          i = RFLog.CLR;
          paramSQLiteDatabase = new StringBuilder();
          paramSQLiteDatabase.append("[DB]");
          paramSQLiteDatabase.append(this.jdField_a_of_type_JavaLangString);
          paramSQLiteDatabase.append(" not find reconfigure()");
          RFLog.i("QCircleDbCacheDatabase", i, paramSQLiteDatabase.toString());
          return;
        }
      }
      catch (InvocationTargetException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (RFLog.isColorLevel())
        {
          i = RFLog.USR;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[DB]");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append("  onOpen");
          ((StringBuilder)localObject1).append(paramSQLiteDatabase.getMessage());
          RFLog.w("QCircleDbCacheDatabase", i, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      catch (IllegalAccessException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (RFLog.isColorLevel())
        {
          i = RFLog.USR;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[DB]");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append("  onOpen");
          ((StringBuilder)localObject1).append(paramSQLiteDatabase.getMessage());
          RFLog.w("QCircleDbCacheDatabase", i, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      catch (IllegalArgumentException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (RFLog.isColorLevel())
        {
          i = RFLog.USR;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[DB]");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append("  onOpen");
          ((StringBuilder)localObject1).append(paramSQLiteDatabase.getMessage());
          RFLog.w("QCircleDbCacheDatabase", i, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      catch (NoSuchFieldException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (RFLog.isColorLevel())
        {
          i = RFLog.USR;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[DB]");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append("  onOpen");
          ((StringBuilder)localObject1).append(paramSQLiteDatabase.getMessage());
          RFLog.w("QCircleDbCacheDatabase", i, ((StringBuilder)localObject1).toString());
        }
      }
      return;
      label632:
      i += 1;
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    int i = RFLog.USR;
    paramSQLiteDatabase = new StringBuilder();
    paramSQLiteDatabase.append("DbCacheDatabase onUpgrade oldVersion:");
    paramSQLiteDatabase.append(paramInt1);
    paramSQLiteDatabase.append(",newVersion=");
    paramSQLiteDatabase.append(paramInt2);
    RFLog.i("QCircleDbCacheDatabase", i, paramSQLiteDatabase.toString());
    this.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.DbCacheDatabase
 * JD-Core Version:    0.7.0.1
 */