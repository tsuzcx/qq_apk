package com.tencent.wcdb.database;

import android.database.sqlite.SQLiteTransactionListener;
import android.util.Pair;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteSession
{
  private final SQLiteConnectionPool b;
  private SQLiteConnection c;
  private int d;
  private int e;
  private SQLiteSession.Transaction f;
  private SQLiteSession.Transaction g;
  
  public SQLiteSession(SQLiteConnectionPool paramSQLiteConnectionPool)
  {
    if (paramSQLiteConnectionPool != null)
    {
      this.b = paramSQLiteConnectionPool;
      return;
    }
    throw new IllegalArgumentException("connectionPool must not be null");
  }
  
  private SQLiteSession.Transaction a(int paramInt, SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    SQLiteSession.Transaction localTransaction = this.f;
    if (localTransaction != null)
    {
      this.f = localTransaction.a;
      localTransaction.a = null;
      localTransaction.d = false;
      localTransaction.e = false;
    }
    else
    {
      localTransaction = new SQLiteSession.Transaction(null);
    }
    localTransaction.b = paramInt;
    localTransaction.c = paramSQLiteTransactionListener;
    return localTransaction;
  }
  
  private void a(SQLiteSession.Transaction paramTransaction)
  {
    paramTransaction.a = this.f;
    paramTransaction.c = null;
    this.f = paramTransaction;
  }
  
  private void a(CancellationSignal paramCancellationSignal, boolean paramBoolean)
  {
    if (paramCancellationSignal != null) {
      paramCancellationSignal.b();
    }
    SQLiteSession.Transaction localTransaction = this.g;
    int i;
    if (((localTransaction.d) || (paramBoolean)) && (!localTransaction.e)) {
      i = 1;
    } else {
      i = 0;
    }
    SQLiteTransactionListener localSQLiteTransactionListener = localTransaction.c;
    if (localSQLiteTransactionListener != null)
    {
      if (i != 0) {}
      try
      {
        localSQLiteTransactionListener.onCommit();
      }
      catch (RuntimeException localRuntimeException)
      {
        i = 0;
        break label87;
      }
      localSQLiteTransactionListener.onRollback();
    }
    Object localObject = null;
    label87:
    this.g = localTransaction.a;
    a(localTransaction);
    localTransaction = this.g;
    if (localTransaction != null)
    {
      if (i == 0) {
        localTransaction.e = true;
      }
    }
    else if (i == 0) {}
    try
    {
      this.c.a("COMMIT;", null, paramCancellationSignal);
      break label155;
      this.c.a("ROLLBACK;", null, paramCancellationSignal);
      label155:
      b();
      if (localObject == null) {
        return;
      }
      throw localObject;
    }
    finally
    {
      b();
    }
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    if (this.c == null)
    {
      this.c = this.b.a(paramString, paramInt, paramCancellationSignal);
      this.d = paramInt;
      this.c.a(true, paramBoolean);
    }
    this.e += 1;
  }
  
  private void b()
  {
    int i = this.e - 1;
    this.e = i;
    if (i == 0) {
      try
      {
        this.c.a(false, false);
        this.b.a(this.c);
        return;
      }
      finally
      {
        this.c = null;
      }
    }
  }
  
  private void b(int paramInt1, SQLiteTransactionListener paramSQLiteTransactionListener, int paramInt2, CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null) {
      paramCancellationSignal.b();
    }
    if (this.g == null) {
      a(null, paramInt2, true, paramCancellationSignal);
    }
    try
    {
      if (this.g == null) {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2) {
            this.c.a("BEGIN;", null, paramCancellationSignal);
          } else {
            this.c.a("BEGIN EXCLUSIVE;", null, paramCancellationSignal);
          }
        }
        else {
          this.c.a("BEGIN IMMEDIATE;", null, paramCancellationSignal);
        }
      }
      if (paramSQLiteTransactionListener != null) {
        try
        {
          paramSQLiteTransactionListener.onBegin();
        }
        catch (RuntimeException paramSQLiteTransactionListener)
        {
          if (this.g == null) {
            this.c.a("ROLLBACK;", null, paramCancellationSignal);
          }
          throw paramSQLiteTransactionListener;
        }
      }
      paramSQLiteTransactionListener = a(paramInt1, paramSQLiteTransactionListener);
      paramSQLiteTransactionListener.a = this.g;
      this.g = paramSQLiteTransactionListener;
      return;
    }
    finally
    {
      if (this.g == null) {
        b();
      }
    }
  }
  
  private void c()
  {
    if (this.g != null) {
      return;
    }
    throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
  }
  
  private boolean c(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null) {
      paramCancellationSignal.b();
    }
    int i = DatabaseUtils.a(paramString);
    if (i != 4)
    {
      if (i != 5)
      {
        if (i != 6) {
          return false;
        }
        a(paramCancellationSignal);
        return true;
      }
      a();
      a(paramCancellationSignal);
      return true;
    }
    a(2, null, paramInt, paramCancellationSignal);
    return true;
  }
  
  private void d()
  {
    SQLiteSession.Transaction localTransaction = this.g;
    if (localTransaction != null)
    {
      if (!localTransaction.d) {
        return;
      }
      throw new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
    }
  }
  
  public int a(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString != null)
    {
      if (c(paramString, paramArrayOfObject, paramInt, paramCancellationSignal)) {
        return 0;
      }
      a(paramString, paramInt, false, paramCancellationSignal);
      try
      {
        paramInt = this.c.d(paramString, paramArrayOfObject, paramCancellationSignal);
        return paramInt;
      }
      finally
      {
        b();
      }
    }
    throw new IllegalArgumentException("sql must not be null.");
  }
  
  public int a(String paramString, Object[] paramArrayOfObject, CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, CancellationSignal paramCancellationSignal)
  {
    if (paramString != null)
    {
      if (paramCursorWindow != null)
      {
        if (c(paramString, paramArrayOfObject, paramInt3, paramCancellationSignal))
        {
          paramCursorWindow.b();
          return 0;
        }
        a(paramString, paramInt3, false, paramCancellationSignal);
        try
        {
          paramInt1 = this.c.a(paramString, paramArrayOfObject, paramCursorWindow, paramInt1, paramInt2, paramBoolean, paramCancellationSignal);
          return paramInt1;
        }
        finally
        {
          b();
        }
      }
      throw new IllegalArgumentException("window must not be null.");
    }
    throw new IllegalArgumentException("sql must not be null.");
  }
  
  public Pair<Integer, Integer> a(String paramString, int paramInt)
  {
    a(null, paramInt, false, null);
    try
    {
      paramString = this.c.c(paramString);
      return paramString;
    }
    finally
    {
      b();
    }
  }
  
  SQLiteConnection.PreparedStatement a(String paramString, int paramInt, boolean paramBoolean)
  {
    a(paramString, paramInt, paramBoolean, null);
    return this.c.d(paramString);
  }
  
  SQLiteConnection a(int paramInt)
  {
    a(null, paramInt, true, null);
    return this.c;
  }
  
  public void a()
  {
    c();
    d();
    this.g.d = true;
  }
  
  public void a(int paramInt1, SQLiteTransactionListener paramSQLiteTransactionListener, int paramInt2, CancellationSignal paramCancellationSignal)
  {
    d();
    b(paramInt1, paramSQLiteTransactionListener, paramInt2, paramCancellationSignal);
  }
  
  void a(SQLiteConnection.PreparedStatement paramPreparedStatement)
  {
    SQLiteConnection localSQLiteConnection = this.c;
    if (localSQLiteConnection != null)
    {
      localSQLiteConnection.a(paramPreparedStatement);
      b();
    }
  }
  
  public void a(CancellationSignal paramCancellationSignal)
  {
    c();
    if ((!a) && (this.c == null)) {
      throw new AssertionError();
    }
    a(paramCancellationSignal, false);
  }
  
  void a(Exception paramException)
  {
    SQLiteConnection localSQLiteConnection = this.c;
    if (localSQLiteConnection != null) {
      localSQLiteConnection.a(paramException);
    }
    b();
  }
  
  public void a(String paramString, int paramInt, CancellationSignal paramCancellationSignal, SQLiteStatementInfo paramSQLiteStatementInfo)
  {
    if (paramString != null)
    {
      if (paramCancellationSignal != null) {
        paramCancellationSignal.b();
      }
      a(paramString, paramInt, false, paramCancellationSignal);
      try
      {
        this.c.a(paramString, paramSQLiteStatementInfo);
        return;
      }
      finally
      {
        b();
      }
    }
    throw new IllegalArgumentException("sql must not be null.");
  }
  
  public long b(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString != null)
    {
      if (c(paramString, paramArrayOfObject, paramInt, paramCancellationSignal)) {
        return 0L;
      }
      a(paramString, paramInt, false, paramCancellationSignal);
      try
      {
        long l = this.c.e(paramString, paramArrayOfObject, paramCancellationSignal);
        return l;
      }
      finally
      {
        b();
      }
    }
    throw new IllegalArgumentException("sql must not be null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteSession
 * JD-Core Version:    0.7.0.1
 */