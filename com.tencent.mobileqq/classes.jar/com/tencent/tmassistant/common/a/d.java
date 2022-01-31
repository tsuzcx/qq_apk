package com.tencent.tmassistant.common.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.tmassistantbase.util.ab;

public abstract class d
  extends SQLiteOpenHelper
{
  public d(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    ab.c("SqliteHelper", "tables count:" + b().length);
    Class[] arrayOfClass = b();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      Object localObject = arrayOfClass[i];
      try
      {
        localObject = ((c)((Class)localObject).newInstance()).createTableSQL();
        if ((localObject != null) && (((String)localObject).length() > 0)) {
          paramSQLiteDatabase.execSQL((String)localObject);
        }
        ab.c("SqliteHelper", "sql=" + (String)localObject);
      }
      catch (InstantiationException localInstantiationException)
      {
        for (;;)
        {
          ab.c("SqliteHelper", "exception: ", localInstantiationException);
          localInstantiationException.printStackTrace();
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          ab.c("SqliteHelper", "exception: ", localIllegalAccessException);
          localIllegalAccessException.printStackTrace();
        }
      }
      i += 1;
    }
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    Class[] arrayOfClass = b();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        try
        {
          paramSQLiteDatabase.delete(((c)localClass.newInstance()).tableName(), null, null);
          i += 1;
        }
        catch (InstantiationException localInstantiationException)
        {
          for (;;)
          {
            ab.c("SqliteHelper", "exception: ", localInstantiationException);
            localInstantiationException.printStackTrace();
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            ab.c("SqliteHelper", "exception: ", localIllegalAccessException);
            localIllegalAccessException.printStackTrace();
          }
        }
      }
    }
  }
  
  public abstract int a();
  
  public abstract Class<?>[] b();
  
  /* Error */
  public SQLiteDatabase getReadableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 92	android/database/sqlite/SQLiteOpenHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore_1
    //   7: aload_1
    //   8: invokevirtual 96	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   11: ifne +12 -> 23
    //   14: aload_1
    //   15: astore_2
    //   16: aload_1
    //   17: invokevirtual 99	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   20: ifeq +27 -> 47
    //   23: ldc2_w 100
    //   26: invokestatic 107	android/os/SystemClock:sleep	(J)V
    //   29: goto -22 -> 7
    //   32: astore_2
    //   33: ldc 17
    //   35: ldc 72
    //   37: aload_2
    //   38: invokestatic 75	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   41: aload_2
    //   42: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   45: aload_1
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: areturn
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    //   56: astore_2
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -26 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	d
    //   6	40	1	localSQLiteDatabase1	SQLiteDatabase
    //   51	4	1	localObject1	Object
    //   58	1	1	localObject2	Object
    //   15	1	2	localSQLiteDatabase2	SQLiteDatabase
    //   32	10	2	localException1	Exception
    //   46	4	2	localSQLiteDatabase3	SQLiteDatabase
    //   56	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   7	14	32	java/lang/Exception
    //   16	23	32	java/lang/Exception
    //   23	29	32	java/lang/Exception
    //   2	7	51	finally
    //   7	14	51	finally
    //   16	23	51	finally
    //   23	29	51	finally
    //   33	45	51	finally
    //   2	7	56	java/lang/Exception
  }
  
  /* Error */
  public SQLiteDatabase getWritableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 111	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore_1
    //   7: aload_1
    //   8: invokevirtual 96	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   11: ifne +12 -> 23
    //   14: aload_1
    //   15: astore_2
    //   16: aload_1
    //   17: invokevirtual 99	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   20: ifeq +27 -> 47
    //   23: ldc2_w 100
    //   26: invokestatic 107	android/os/SystemClock:sleep	(J)V
    //   29: goto -22 -> 7
    //   32: astore_2
    //   33: ldc 17
    //   35: ldc 72
    //   37: aload_2
    //   38: invokestatic 75	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   41: aload_2
    //   42: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   45: aload_1
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: areturn
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    //   56: astore_2
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -26 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	d
    //   6	40	1	localSQLiteDatabase1	SQLiteDatabase
    //   51	4	1	localObject1	Object
    //   58	1	1	localObject2	Object
    //   15	1	2	localSQLiteDatabase2	SQLiteDatabase
    //   32	10	2	localException1	Exception
    //   46	4	2	localSQLiteDatabase3	SQLiteDatabase
    //   56	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   7	14	32	java/lang/Exception
    //   16	23	32	java/lang/Exception
    //   23	29	32	java/lang/Exception
    //   2	7	51	finally
    //   7	14	51	finally
    //   16	23	51	finally
    //   23	29	51	finally
    //   33	45	51	finally
    //   2	7	56	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    b(paramSQLiteDatabase);
    a(paramSQLiteDatabase);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    int i = paramSQLiteDatabase.getVersion();
    ab.c("SqliteHelper", " dbversion:" + i + " newVersion:" + a());
    if (i == 0) {
      return;
    }
    if (i < a())
    {
      onUpgrade(paramSQLiteDatabase, i, a());
      return;
    }
    if (i > a())
    {
      onDowngrade(paramSQLiteDatabase, i, a());
      return;
    }
    a(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      Class[] arrayOfClass = b();
      int k = arrayOfClass.length;
      int i = 0;
      for (;;)
      {
        if (i < k)
        {
          Object localObject = arrayOfClass[i];
          try
          {
            localObject = ((c)((Class)localObject).newInstance()).getAlterSQL(paramInt1, paramInt1 + 1);
            ab.c("sqliteHelper", " upgrade:" + localObject);
            if (localObject != null)
            {
              int j = 0;
              while (j < localObject.length)
              {
                paramSQLiteDatabase.execSQL(localObject[j]);
                j += 1;
              }
            }
          }
          catch (Exception localException)
          {
            ab.c("SqliteHelper", "exception: ", localException);
            localException.printStackTrace();
            i += 1;
          }
        }
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistant.common.a.d
 * JD-Core Version:    0.7.0.1
 */