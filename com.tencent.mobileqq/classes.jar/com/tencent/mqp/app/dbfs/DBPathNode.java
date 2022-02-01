package com.tencent.mqp.app.dbfs;

import android.database.sqlite.SQLiteDatabase;

public class DBPathNode
{
  DBHelper a;
  DBSecurity b;
  DBFSPath c;
  public long d;
  public long e;
  
  private DBFSPath c()
  {
    for (DBFSPath localDBFSPath = this.c; localDBFSPath.a != null; localDBFSPath = localDBFSPath.a) {}
    return localDBFSPath;
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    for (;;)
    {
      try
      {
        b();
        this.e = this.a.a(this.b.a(paramArrayOfByte));
        if (this.e != -1L)
        {
          this.a.a(this.d, this.e);
          i = paramArrayOfByte.length;
          localSQLiteDatabase.setTransactionSuccessful();
          return i;
        }
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
        localSQLiteDatabase.close();
      }
      int i = 0;
    }
  }
  
  public boolean a()
  {
    this.d = -1L;
    this.e = -1L;
    Object localObject = c();
    while (localObject != null)
    {
      long l2 = this.a.a(this.d, ((DBFSPath)localObject).c);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = this.a.a(this.d, -1L, ((DBFSPath)localObject).c);
      }
      DBFSPath localDBFSPath = ((DBFSPath)localObject).b;
      this.d = l1;
      this.e = this.a.b(this.d);
      localObject = localDBFSPath;
      if (this.e != -1L)
      {
        localObject = localDBFSPath;
        if (localDBFSPath != null) {
          return false;
        }
      }
    }
    return this.a.a(this.d) == null;
  }
  
  public void b()
  {
    long l = this.e;
    if (-1L == l) {
      return;
    }
    this.a.c(l);
    this.e = -1L;
    this.a.a(this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqp.app.dbfs.DBPathNode
 * JD-Core Version:    0.7.0.1
 */