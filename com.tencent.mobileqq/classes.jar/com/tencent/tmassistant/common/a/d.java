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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tables count:");
    ((StringBuilder)localObject).append(b().length);
    ab.c("SqliteHelper", ((StringBuilder)localObject).toString());
    localObject = b();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      String str = localObject[i];
      try
      {
        str = ((c)str.newInstance()).createTableSQL();
        if ((str != null) && (str.length() > 0)) {
          paramSQLiteDatabase.execSQL(str);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sql=");
        localStringBuilder.append(str);
        ab.c("SqliteHelper", localStringBuilder.toString());
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        ab.c("SqliteHelper", "exception: ", localIllegalAccessException);
        localIllegalAccessException.printStackTrace();
      }
      catch (InstantiationException localInstantiationException)
      {
        ab.c("SqliteHelper", "exception: ", localInstantiationException);
        localInstantiationException.printStackTrace();
      }
      i += 1;
    }
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    Class[] arrayOfClass = b();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      try
      {
        paramSQLiteDatabase.delete(((c)localClass.newInstance()).tableName(), null, null);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        ab.c("SqliteHelper", "exception: ", localIllegalAccessException);
        localIllegalAccessException.printStackTrace();
      }
      catch (InstantiationException localInstantiationException)
      {
        ab.c("SqliteHelper", "exception: ", localInstantiationException);
        localInstantiationException.printStackTrace();
      }
      i += 1;
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
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokespecial 92	android/database/sqlite/SQLiteOpenHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_2
    //   12: invokevirtual 96	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   15: ifne +14 -> 29
    //   18: aload_2
    //   19: astore_1
    //   20: aload_2
    //   21: astore_3
    //   22: aload_2
    //   23: invokevirtual 99	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   26: ifeq +33 -> 59
    //   29: aload_2
    //   30: astore_1
    //   31: ldc2_w 100
    //   34: invokestatic 107	android/os/SystemClock:sleep	(J)V
    //   37: goto -28 -> 9
    //   40: astore_1
    //   41: goto +22 -> 63
    //   44: astore_2
    //   45: ldc 35
    //   47: ldc 72
    //   49: aload_2
    //   50: invokestatic 75	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   53: aload_2
    //   54: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   57: aload_1
    //   58: astore_3
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_3
    //   62: areturn
    //   63: aload_0
    //   64: monitorexit
    //   65: goto +5 -> 70
    //   68: aload_1
    //   69: athrow
    //   70: goto -2 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	d
    //   3	28	1	localObject1	Object
    //   40	29	1	localObject2	Object
    //   8	22	2	localSQLiteDatabase	SQLiteDatabase
    //   44	10	2	localException	Exception
    //   21	41	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	40	finally
    //   11	18	40	finally
    //   22	29	40	finally
    //   31	37	40	finally
    //   45	57	40	finally
    //   4	9	44	java/lang/Exception
    //   11	18	44	java/lang/Exception
    //   22	29	44	java/lang/Exception
    //   31	37	44	java/lang/Exception
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
    //   5: invokespecial 111	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_2
    //   12: invokevirtual 96	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   15: ifne +14 -> 29
    //   18: aload_2
    //   19: astore_1
    //   20: aload_2
    //   21: astore_3
    //   22: aload_2
    //   23: invokevirtual 99	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   26: ifeq +33 -> 59
    //   29: aload_2
    //   30: astore_1
    //   31: ldc2_w 100
    //   34: invokestatic 107	android/os/SystemClock:sleep	(J)V
    //   37: goto -28 -> 9
    //   40: astore_1
    //   41: goto +22 -> 63
    //   44: astore_2
    //   45: ldc 35
    //   47: ldc 72
    //   49: aload_2
    //   50: invokestatic 75	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   53: aload_2
    //   54: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   57: aload_1
    //   58: astore_3
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_3
    //   62: areturn
    //   63: aload_0
    //   64: monitorexit
    //   65: goto +5 -> 70
    //   68: aload_1
    //   69: athrow
    //   70: goto -2 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	d
    //   3	28	1	localObject1	Object
    //   40	29	1	localObject2	Object
    //   8	22	2	localSQLiteDatabase	SQLiteDatabase
    //   44	10	2	localException	Exception
    //   21	41	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	40	finally
    //   11	18	40	finally
    //   22	29	40	finally
    //   31	37	40	finally
    //   45	57	40	finally
    //   4	9	44	java/lang/Exception
    //   11	18	44	java/lang/Exception
    //   22	29	44	java/lang/Exception
    //   31	37	44	java/lang/Exception
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" dbversion:");
    localStringBuilder.append(i);
    localStringBuilder.append(" newVersion:");
    localStringBuilder.append(a());
    ab.c("SqliteHelper", localStringBuilder.toString());
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
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(" upgrade:");
            localStringBuilder.append(localObject);
            ab.c("sqliteHelper", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.common.a.d
 * JD-Core Version:    0.7.0.1
 */