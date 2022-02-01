package com.tencent.open.component.cache.database;

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
  protected Cursor h;
  protected String i;
  protected String j;
  protected final ArrayList<WeakReference<DbCacheManager.OnChangeListener>> k = new ArrayList();
  protected DbCacheManager.OnCloseListener l;
  
  protected DbCacheManager(Context paramContext, Class<? extends DbCacheData> paramClass, long paramLong, String paramString)
  {
    super(paramContext, paramClass, paramLong, paramString);
    k();
  }
  
  public DbCacheData a(int paramInt)
  {
    try
    {
      DbCacheData localDbCacheData = a(this.h, paramInt);
      return localDbCacheData;
    }
    finally {}
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    if (paramInt != 2)
    {
      super.a(paramSQLiteDatabase, paramInt);
      return;
    }
    a(paramSQLiteDatabase, this.i);
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
  
  void a(DbCacheManager.OnCloseListener paramOnCloseListener)
  {
    this.l = paramOnCloseListener;
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
  
  protected void c()
  {
    try
    {
      if (this.h != null) {
        this.h.close();
      }
      k();
      d();
      return;
    }
    finally {}
  }
  
  protected void d()
  {
    Object localObject = j();
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
  
  public int i()
  {
    for (;;)
    {
      try
      {
        if (this.h != null)
        {
          m = this.h.getCount();
          return m;
        }
      }
      finally {}
      int m = 0;
    }
  }
  
  protected List<DbCacheManager.OnChangeListener> j()
  {
    Object localObject3;
    synchronized (this.k)
    {
      if (this.k.size() > 0)
      {
        ArrayList localArrayList1 = new ArrayList();
        Iterator localIterator = this.k.iterator();
        Object localObject1;
        for (;;)
        {
          localObject1 = localArrayList1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (WeakReference)localIterator.next();
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = (DbCacheManager.OnChangeListener)((WeakReference)localObject1).get();
          }
          if (localObject1 != null) {
            localArrayList1.add(localObject1);
          }
        }
        return localObject1;
      }
    }
  }
  
  protected void k()
  {
    try
    {
      this.h = a(this.i, this.j);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.component.cache.database.DbCacheManager
 * JD-Core Version:    0.7.0.1
 */