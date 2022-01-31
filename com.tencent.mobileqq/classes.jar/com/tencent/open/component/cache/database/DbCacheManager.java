package com.tencent.open.component.cache.database;

import akqi;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DbCacheManager
  extends AbstractDbCacheManager
{
  protected akqi a;
  protected Cursor a;
  protected String b;
  protected final ArrayList b;
  protected String c;
  
  protected DbCacheManager(Context paramContext, Class paramClass, long paramLong, String paramString)
  {
    super(paramContext, paramClass, paramLong, paramString);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    d();
  }
  
  public int a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidDatabaseCursor != null)
        {
          i = this.jdField_a_of_type_AndroidDatabaseCursor.getCount();
          return i;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public DbCacheData a(int paramInt)
  {
    try
    {
      DbCacheData localDbCacheData = a(this.jdField_a_of_type_AndroidDatabaseCursor, paramInt);
      return localDbCacheData;
    }
    finally {}
  }
  
  protected List a()
  {
    ArrayList localArrayList1;
    Object localObject2;
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
          break;
        }
        localArrayList1 = new ArrayList();
        Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break label99;
        }
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference == null)
        {
          localWeakReference = null;
          if (localWeakReference == null) {
            continue;
          }
          localArrayList1.add(localWeakReference);
        }
      }
      localObject2 = (DbCacheManager.OnChangeListener)localObject1.get();
    }
    for (;;)
    {
      return localObject2;
      localObject2 = null;
      continue;
      label99:
      localObject2 = localArrayList1;
    }
  }
  
  protected void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidDatabaseCursor != null) {
        this.jdField_a_of_type_AndroidDatabaseCursor.close();
      }
      d();
      b();
      return;
    }
    finally {}
  }
  
  void a(akqi paramakqi)
  {
    this.jdField_a_of_type_Akqi = paramakqi;
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramSQLiteDatabase, paramInt);
      return;
    }
    a(paramSQLiteDatabase, this.jdField_b_of_type_JavaLangString);
  }
  
  public void a(DbCacheData paramDbCacheData, int paramInt)
  {
    try
    {
      a(paramInt, new DbCacheData[] { paramDbCacheData });
      return;
    }
    finally {}
  }
  
  public void a(DbCacheData[] paramArrayOfDbCacheData, int paramInt)
  {
    try
    {
      a(paramInt, paramArrayOfDbCacheData);
      return;
    }
    finally {}
  }
  
  protected void b()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DbCacheManager.OnChangeListener localOnChangeListener = (DbCacheManager.OnChangeListener)((Iterator)localObject).next();
        if (localOnChangeListener != null) {
          localOnChangeListener.a(this);
        }
      }
    }
  }
  
  public void b(DbCacheData paramDbCacheData, String paramString)
  {
    try
    {
      a(paramDbCacheData, paramString);
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    try
    {
      a(paramString);
      return;
    }
    finally {}
  }
  
  protected void d()
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseCursor = a(this.jdField_b_of_type_JavaLangString, this.c);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.component.cache.database.DbCacheManager
 * JD-Core Version:    0.7.0.1
 */