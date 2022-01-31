package com.tencent.open.component.cache.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import bdkj;
import bdkk;
import bdkl;
import bdkm;
import bdks;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractDbCacheManager
{
  protected long a;
  protected bdkk a;
  protected bdkm a;
  protected String a;
  protected ArrayList<bdkl> a;
  protected boolean a;
  protected boolean b;
  
  protected AbstractDbCacheManager(Context paramContext, Class<? extends bdkj> paramClass, long paramLong, String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Bdkm = bdkm.a(paramContext.getApplicationContext(), paramLong);
    this.jdField_a_of_type_Bdkm.a(hashCode());
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramClass);
    c();
    a(a());
  }
  
  public static String a(long paramLong, String paramString)
  {
    return String.valueOf(paramLong) + "_" + paramString;
  }
  
  final int a(SQLiteDatabase paramSQLiteDatabase, bdkj parambdkj, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    parambdkj.a(localContentValues);
    return paramSQLiteDatabase.update(this.jdField_a_of_type_JavaLangString, localContentValues, paramString, null);
  }
  
  final Cursor a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      paramString2 = this.jdField_a_of_type_Bdkk.a();
    }
    for (;;)
    {
      return paramSQLiteDatabase.query(this.jdField_a_of_type_JavaLangString, null, paramString1, null, null, null, paramString2);
    }
  }
  
  protected Cursor a(String paramString1, String paramString2)
  {
    if (a()) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return null;
      localSQLiteDatabase = a();
    } while (localSQLiteDatabase == null);
    try
    {
      paramString1 = a(localSQLiteDatabase, paramString1, paramString2);
      return paramString1;
    }
    catch (SQLException paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  protected SQLiteDatabase a()
  {
    if (a()) {
      return null;
    }
    return this.jdField_a_of_type_Bdkm.getWritableDatabase();
  }
  
  protected bdkj a(Cursor paramCursor, int paramInt)
  {
    if ((paramCursor == null) || (paramCursor.isClosed())) {}
    for (;;)
    {
      return null;
      if ((paramInt >= 0) && (paramInt < paramCursor.getCount())) {
        try
        {
          boolean bool = paramCursor.moveToPosition(paramInt);
          if (bool) {
            return this.jdField_a_of_type_Bdkk.a(paramCursor);
          }
        }
        catch (Exception paramCursor)
        {
          paramCursor.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public final String a()
  {
    return a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
  }
  
  protected abstract void a();
  
  protected void a(int paramInt, bdkj... paramVarArgs)
  {
    if (a()) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      do
      {
        return;
      } while (paramVarArgs == null);
      localSQLiteDatabase = a();
    } while (localSQLiteDatabase == null);
    for (;;)
    {
      try
      {
        localSQLiteDatabase.beginTransaction();
        a(localSQLiteDatabase, paramInt);
        int i = paramVarArgs.length;
        paramInt = 0;
        if (paramInt < i)
        {
          a(localSQLiteDatabase, paramVarArgs[paramInt]);
          paramInt += 1;
          continue;
        }
        localSQLiteDatabase.setTransactionSuccessful();
      }
      catch (SQLException paramVarArgs)
      {
        paramVarArgs = paramVarArgs;
        paramVarArgs.printStackTrace();
        try
        {
          localSQLiteDatabase.endTransaction();
        }
        catch (Exception paramVarArgs)
        {
          paramVarArgs.printStackTrace();
        }
        continue;
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs = paramVarArgs;
        paramVarArgs.printStackTrace();
        try
        {
          localSQLiteDatabase.endTransaction();
        }
        catch (Exception paramVarArgs)
        {
          paramVarArgs.printStackTrace();
        }
        continue;
      }
      finally {}
      try
      {
        localSQLiteDatabase.endTransaction();
        b();
        return;
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
    }
    try
    {
      localSQLiteDatabase.endTransaction();
      throw paramVarArgs;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    try
    {
      paramSQLiteDatabase.execSQL(b());
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    }
    a(paramSQLiteDatabase, null);
  }
  
  final void a(SQLiteDatabase paramSQLiteDatabase, bdkj parambdkj)
  {
    ContentValues localContentValues = new ContentValues();
    parambdkj.a(localContentValues);
    paramSQLiteDatabase.replaceOrThrow(this.jdField_a_of_type_JavaLangString, null, localContentValues);
  }
  
  protected final void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase.delete(this.jdField_a_of_type_JavaLangString, paramString, null);
  }
  
  protected void a(bdkj parambdkj, String paramString)
  {
    int m = 0;
    int n = 0;
    int i = 0;
    if (a()) {
      break label15;
    }
    label15:
    SQLiteDatabase localSQLiteDatabase;
    int j;
    int k;
    for (;;)
    {
      return;
      if (parambdkj != null)
      {
        localSQLiteDatabase = a();
        if (localSQLiteDatabase == null) {
          break;
        }
        j = m;
        k = n;
        for (;;)
        {
          try
          {
            localSQLiteDatabase.beginTransaction();
            j = m;
            k = n;
            if (a(localSQLiteDatabase, parambdkj, paramString) > 0) {
              i = 1;
            }
            j = i;
            k = i;
            localSQLiteDatabase.setTransactionSuccessful();
          }
          catch (SQLException parambdkj)
          {
            parambdkj = parambdkj;
            parambdkj.printStackTrace();
            try
            {
              localSQLiteDatabase.endTransaction();
              i = j;
            }
            catch (Exception parambdkj)
            {
              parambdkj.printStackTrace();
              i = j;
            }
            continue;
          }
          catch (Exception parambdkj)
          {
            parambdkj = parambdkj;
            parambdkj.printStackTrace();
            try
            {
              localSQLiteDatabase.endTransaction();
              i = k;
            }
            catch (Exception parambdkj)
            {
              parambdkj.printStackTrace();
              i = k;
            }
            continue;
          }
          finally {}
          try
          {
            localSQLiteDatabase.endTransaction();
            if (i == 0) {
              break;
            }
            b();
            return;
          }
          catch (Exception parambdkj)
          {
            parambdkj.printStackTrace();
          }
        }
      }
    }
    try
    {
      localSQLiteDatabase.endTransaction();
      throw parambdkj;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  protected void a(Class<? extends bdkj> paramClass)
  {
    String str = paramClass.getName();
    try
    {
      paramClass = (bdkk)paramClass.getField("DB_CREATOR").get(null);
      if (paramClass == null) {
        throw new AbstractDbCacheManager.BadCacheDataException("CacheData protocol requires a CacheData.Creator object called  CREATOR on class " + str);
      }
    }
    catch (IllegalAccessException paramClass)
    {
      throw new AbstractDbCacheManager.BadCacheDataException("IllegalAccessException when access: " + str);
    }
    catch (ClassCastException paramClass)
    {
      throw new AbstractDbCacheManager.BadCacheDataException("CacheData protocol requires a CacheData.Creator object called  CREATOR on class " + str);
    }
    catch (NoSuchFieldException paramClass)
    {
      throw new AbstractDbCacheManager.BadCacheDataException("CacheData protocol requires a CacheData.Creator object called  CacheData on class " + str);
    }
    this.jdField_a_of_type_Bdkk = paramClass;
    paramClass = paramClass.a();
    if (paramClass != null)
    {
      int j = paramClass.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramClass[i];
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      throw new AbstractDbCacheManager.BadCacheDataException("CacheData protocol requires a valid CacheData.Structure from CacheData.Creator object called  CREATOR on class " + str);
    }
  }
  
  protected void a(String paramString)
  {
    if (a()) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = a();
    } while (localSQLiteDatabase == null);
    try
    {
      a(localSQLiteDatabase, paramString);
      b();
      return;
    }
    catch (SQLException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public final boolean a()
  {
    return this.b;
  }
  
  protected String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS " + this.jdField_a_of_type_JavaLangString + " (");
    localStringBuilder.append("_id INTEGER PRIMARY KEY");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bdkl localbdkl = (bdkl)localIterator.next();
      localStringBuilder.append(',');
      localStringBuilder.append(localbdkl.a());
      localStringBuilder.append(' ');
      localStringBuilder.append(localbdkl.b());
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  protected void b()
  {
    a();
  }
  
  protected void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(c());
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected String c()
  {
    return "DROP TABLE IF EXISTS " + this.jdField_a_of_type_JavaLangString;
  }
  
  protected void c()
  {
    int i = this.jdField_a_of_type_Bdkk.a();
    int j = bdks.a(this.jdField_a_of_type_JavaLangString + "_cache_db_version", -1, this.jdField_a_of_type_Long);
    SQLiteDatabase localSQLiteDatabase;
    if ((j == -1) || (j != i))
    {
      localSQLiteDatabase = a();
      if (localSQLiteDatabase == null) {}
    }
    try
    {
      b(localSQLiteDatabase);
      bdks.a(this.jdField_a_of_type_JavaLangString + "_cache_db_version", i, this.jdField_a_of_type_Long);
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        localSQLException.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.component.cache.database.AbstractDbCacheManager
 * JD-Core Version:    0.7.0.1
 */