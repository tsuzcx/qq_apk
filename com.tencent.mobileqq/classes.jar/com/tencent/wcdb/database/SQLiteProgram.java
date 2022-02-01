package com.tencent.wcdb.database;

import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;
import java.util.Arrays;

public abstract class SQLiteProgram
  extends SQLiteClosable
{
  private static final String[] b = new String[0];
  protected SQLiteConnection.PreparedStatement a;
  private final SQLiteDatabase c;
  private final String d;
  private final boolean e;
  private final String[] f;
  private final int g;
  private final Object[] h;
  private SQLiteSession i;
  
  protected SQLiteProgram(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    this.c = paramSQLiteDatabase;
    this.d = paramString.trim();
    int j = DatabaseUtils.a(this.d);
    if ((j != 4) && (j != 5) && (j != 6))
    {
      boolean bool2 = true;
      boolean bool1;
      if (j == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramString = new SQLiteStatementInfo();
      paramSQLiteDatabase.c().a(this.d, paramSQLiteDatabase.a(bool1), paramCancellationSignal, paramString);
      if ((j != 8) && (paramString.c)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      this.e = bool1;
      this.f = paramString.b;
      this.g = paramString.a;
    }
    else
    {
      this.e = false;
      this.f = b;
      this.g = 0;
    }
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > this.g))
    {
      paramSQLiteDatabase = new StringBuilder();
      paramSQLiteDatabase.append("Too many bind arguments.  ");
      paramSQLiteDatabase.append(paramArrayOfObject.length);
      paramSQLiteDatabase.append(" arguments were provided but the statement needs ");
      paramSQLiteDatabase.append(this.g);
      paramSQLiteDatabase.append(" arguments.");
      throw new IllegalArgumentException(paramSQLiteDatabase.toString());
    }
    j = this.g;
    if (j != 0)
    {
      this.h = new Object[j];
      if (paramArrayOfObject != null) {
        System.arraycopy(paramArrayOfObject, 0, this.h, 0, paramArrayOfObject.length);
      }
    }
    else
    {
      this.h = null;
    }
    this.a = null;
    this.i = null;
  }
  
  protected final void a(SQLiteException paramSQLiteException)
  {
    boolean bool = paramSQLiteException instanceof SQLiteDatabaseCorruptException;
    int j = 1;
    if ((!bool) && ((!(paramSQLiteException instanceof SQLiteFullException)) || (!this.e))) {
      j = 0;
    }
    if (j != 0)
    {
      SQLiteDebug.a(this.c);
      this.c.b();
    }
  }
  
  protected boolean b(boolean paramBoolean)
  {
    try
    {
      SQLiteSession localSQLiteSession1 = this.c.c();
      SQLiteSession localSQLiteSession2 = this.i;
      if (localSQLiteSession1 == localSQLiteSession2) {
        return false;
      }
      if (this.i == null)
      {
        this.a = localSQLiteSession1.a(this.d, this.c.a(this.e), paramBoolean);
        this.a.a(this.h);
        this.i = localSQLiteSession1;
        return true;
      }
      throw new IllegalStateException("SQLiteProgram has bound to another thread.");
    }
    finally {}
  }
  
  public final SQLiteDatabase e()
  {
    return this.c;
  }
  
  protected final String f()
  {
    return this.d;
  }
  
  protected void finalize()
  {
    try
    {
      if ((this.i == null) && (this.a == null))
      {
        super.finalize();
        return;
      }
      throw new SQLiteMisuseException("Acquired prepared statement is not released.");
    }
    finally {}
  }
  
  protected void g()
  {
    o();
    n();
  }
  
  protected final Object[] j()
  {
    return this.h;
  }
  
  public final String[] k()
  {
    return this.f;
  }
  
  protected final SQLiteSession l()
  {
    return this.c.c();
  }
  
  protected final int m()
  {
    return this.c.a(this.e);
  }
  
  public void n()
  {
    Object[] arrayOfObject = this.h;
    if (arrayOfObject != null) {
      Arrays.fill(arrayOfObject, null);
    }
  }
  
  protected void o()
  {
    try
    {
      if (this.i == null)
      {
        SQLiteConnection.PreparedStatement localPreparedStatement = this.a;
        if (localPreparedStatement == null) {
          return;
        }
      }
      if ((this.i != null) && (this.a != null))
      {
        if (this.i == this.c.c())
        {
          this.i.a(this.a);
          this.a = null;
          this.i = null;
          return;
        }
        throw new IllegalStateException("SQLiteProgram has bound to another thread.");
      }
      throw new IllegalStateException("Internal state error.");
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteProgram
 * JD-Core Version:    0.7.0.1
 */