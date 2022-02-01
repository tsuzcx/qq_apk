package com.tencent.wcdb.database;

import com.tencent.wcdb.support.CancellationSignal;
import java.lang.ref.WeakReference;

final class SQLiteConnection$PreparedStatement
{
  private WeakReference<SQLiteConnection> a;
  private PreparedStatement b;
  private String c;
  private long d;
  private int e;
  private int f;
  private boolean g;
  private boolean h;
  private boolean i;
  private SQLiteConnection.Operation j;
  
  SQLiteConnection$PreparedStatement(SQLiteConnection paramSQLiteConnection)
  {
    this.a = new WeakReference(paramSQLiteConnection);
  }
  
  public long a()
  {
    return this.d;
  }
  
  public void a(CancellationSignal paramCancellationSignal)
  {
    SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.a.get();
    if (localSQLiteConnection == null) {
      return;
    }
    SQLiteConnection.a(localSQLiteConnection, paramCancellationSignal);
  }
  
  public void a(Exception paramException)
  {
    if (this.j == null) {
      return;
    }
    SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.a.get();
    if (localSQLiteConnection == null) {
      return;
    }
    SQLiteConnection.a(localSQLiteConnection).a(this.j.h, paramException);
  }
  
  public void a(String paramString)
  {
    if (this.j == null) {
      return;
    }
    SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.a.get();
    if (localSQLiteConnection == null) {
      return;
    }
    if (SQLiteConnection.a(localSQLiteConnection).b(this.j.h)) {
      SQLiteConnection.a(localSQLiteConnection).a(this.j.h, paramString);
    }
    this.j = null;
  }
  
  public void a(String paramString, Object[] paramArrayOfObject)
  {
    SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.a.get();
    if (localSQLiteConnection == null) {
      return;
    }
    this.j = SQLiteConnection.a(localSQLiteConnection).a(paramString, this.c, paramArrayOfObject);
    this.j.i = this.f;
  }
  
  public void a(boolean paramBoolean)
  {
    SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.a.get();
    if (localSQLiteConnection == null) {
      return;
    }
    SQLiteConnection.a(localSQLiteConnection, this, paramBoolean);
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.a.get();
    if (localSQLiteConnection == null) {
      return;
    }
    SQLiteConnection.a(localSQLiteConnection, this, paramArrayOfObject);
  }
  
  public void b(CancellationSignal paramCancellationSignal)
  {
    SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.a.get();
    if (localSQLiteConnection == null) {
      return;
    }
    SQLiteConnection.b(localSQLiteConnection, paramCancellationSignal);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnection.PreparedStatement
 * JD-Core Version:    0.7.0.1
 */