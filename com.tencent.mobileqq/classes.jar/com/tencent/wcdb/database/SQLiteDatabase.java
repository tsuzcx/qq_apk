package com.tencent.wcdb.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.DefaultDatabaseErrorHandler;
import com.tencent.wcdb.SQLException;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class SQLiteDatabase
  extends SQLiteClosable
{
  private static final WeakHashMap<SQLiteDatabase, Object> b = new WeakHashMap();
  private static final String[] j = { "", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE " };
  private final ThreadLocal<SQLiteSession> c = new SQLiteDatabase.1(this);
  private final SQLiteDatabase.CursorFactory d;
  private final DatabaseErrorHandler e;
  private final Object f = new Object();
  private final SQLiteDatabaseConfiguration g;
  private SQLiteConnectionPool h;
  private boolean i;
  
  static
  {
    SQLiteGlobal.a();
  }
  
  private SQLiteDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    this.d = paramCursorFactory;
    if (paramDatabaseErrorHandler == null) {
      paramDatabaseErrorHandler = new DefaultDatabaseErrorHandler(true);
    }
    this.e = paramDatabaseErrorHandler;
    this.g = new SQLiteDatabaseConfiguration(paramString, paramInt);
  }
  
  /* Error */
  private int a(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 96	com/tencent/wcdb/database/SQLiteDatabase:h	()V
    //   4: aload_1
    //   5: invokestatic 101	com/tencent/wcdb/DatabaseUtils:a	(Ljava/lang/String;)I
    //   8: iconst_3
    //   9: if_icmpne +51 -> 60
    //   12: iconst_0
    //   13: istore 4
    //   15: aload_0
    //   16: getfield 77	com/tencent/wcdb/database/SQLiteDatabase:f	Ljava/lang/Object;
    //   19: astore 5
    //   21: aload 5
    //   23: monitorenter
    //   24: aload_0
    //   25: getfield 103	com/tencent/wcdb/database/SQLiteDatabase:i	Z
    //   28: ifne +11 -> 39
    //   31: aload_0
    //   32: iconst_1
    //   33: putfield 103	com/tencent/wcdb/database/SQLiteDatabase:i	Z
    //   36: iconst_1
    //   37: istore 4
    //   39: aload 5
    //   41: monitorexit
    //   42: iload 4
    //   44: ifeq +16 -> 60
    //   47: aload_0
    //   48: invokevirtual 106	com/tencent/wcdb/database/SQLiteDatabase:m	()V
    //   51: goto +9 -> 60
    //   54: astore_1
    //   55: aload 5
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    //   60: new 108	com/tencent/wcdb/database/SQLiteStatement
    //   63: dup
    //   64: aload_0
    //   65: aload_1
    //   66: aload_2
    //   67: invokespecial 111	com/tencent/wcdb/database/SQLiteStatement:<init>	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: astore_1
    //   71: aload_1
    //   72: aload_3
    //   73: invokevirtual 114	com/tencent/wcdb/database/SQLiteStatement:a	(Lcom/tencent/wcdb/support/CancellationSignal;)I
    //   76: istore 4
    //   78: aload_1
    //   79: invokevirtual 117	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   82: aload_0
    //   83: invokevirtual 119	com/tencent/wcdb/database/SQLiteDatabase:i	()V
    //   86: iload 4
    //   88: ireturn
    //   89: astore_2
    //   90: aload_1
    //   91: invokevirtual 117	com/tencent/wcdb/database/SQLiteStatement:close	()V
    //   94: aload_2
    //   95: athrow
    //   96: astore_1
    //   97: aload_0
    //   98: invokevirtual 119	com/tencent/wcdb/database/SQLiteDatabase:i	()V
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	SQLiteDatabase
    //   0	103	1	paramString	String
    //   0	103	2	paramArrayOfObject	Object[]
    //   0	103	3	paramCancellationSignal	CancellationSignal
    //   13	74	4	k	int
    // Exception table:
    //   from	to	target	type
    //   24	36	54	finally
    //   39	42	54	finally
    //   55	58	54	finally
    //   71	78	89	finally
    //   4	12	96	finally
    //   15	24	96	finally
    //   47	51	96	finally
    //   58	60	96	finally
    //   60	71	96	finally
    //   78	82	96	finally
    //   90	96	96	finally
  }
  
  public static SQLiteDatabase a(File paramFile, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return a(paramFile.getPath(), paramCursorFactory);
  }
  
  public static SQLiteDatabase a(String paramString, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return a(paramString, null, null, paramCursorFactory, 268435456, null, 0);
  }
  
  public static SQLiteDatabase a(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt1, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt2)
  {
    paramString = new SQLiteDatabase(paramString, paramInt1, paramCursorFactory, paramDatabaseErrorHandler);
    paramString.a(paramArrayOfByte, paramSQLiteCipherSpec, paramInt2);
    return paramString;
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int k = paramString.indexOf(' ');
      int m = paramString.indexOf(',');
      if ((k > 0) && ((k < m) || (m < 0))) {
        return paramString.substring(0, k);
      }
      String str = paramString;
      if (m > 0) {
        if (m >= k)
        {
          str = paramString;
          if (k >= 0) {}
        }
        else
        {
          str = paramString.substring(0, m);
        }
      }
      return str;
    }
    throw new IllegalStateException("Invalid tables");
  }
  
  private Set<String> a(ContentValues paramContentValues)
  {
    if (Build.VERSION.SDK_INT < 11) {
      try
      {
        Field localField = Class.forName("android.content.ContentValues").getDeclaredField("mValues");
        localField.setAccessible(true);
        paramContentValues = ((HashMap)localField.get(paramContentValues)).keySet();
        return paramContentValues;
      }
      catch (Exception paramContentValues)
      {
        throw new RuntimeException(paramContentValues);
      }
    }
    return paramContentValues.keySet();
  }
  
  private void a(SQLiteTransactionListener paramSQLiteTransactionListener, boolean paramBoolean)
  {
    h();
    for (;;)
    {
      try
      {
        SQLiteSession localSQLiteSession = c();
        if (paramBoolean)
        {
          k = 2;
          localSQLiteSession.a(k, paramSQLiteTransactionListener, a(false), null);
          return;
        }
      }
      finally
      {
        i();
      }
      int k = 1;
    }
  }
  
  private void a(byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt)
  {
    try
    {
      b(paramArrayOfByte, paramSQLiteCipherSpec, paramInt);
      return;
    }
    catch (SQLiteException paramArrayOfByte)
    {
      break label24;
      b();
      b(paramArrayOfByte, paramSQLiteCipherSpec, paramInt);
      return;
      paramSQLiteCipherSpec = new StringBuilder();
      paramSQLiteCipherSpec.append("Failed to open database '");
      paramSQLiteCipherSpec.append(a());
      paramSQLiteCipherSpec.append("'.");
      Log.a("WCDB.SQLiteDatabase", paramSQLiteCipherSpec.toString(), new Object[] { paramArrayOfByte });
      close();
      throw paramArrayOfByte;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      label12:
      label24:
      break label12;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    synchronized (this.f)
    {
      SQLiteConnectionPool localSQLiteConnectionPool = this.h;
      this.h = null;
      if (!paramBoolean) {
        synchronized (b)
        {
          b.remove(this);
          if (localSQLiteConnectionPool != null)
          {
            localSQLiteConnectionPool.close();
            return;
          }
        }
      }
      return;
    }
  }
  
  private void b(byte[] arg1, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt)
  {
    synchronized (this.f)
    {
      if ((!a) && (this.h != null)) {
        throw new AssertionError();
      }
      this.h = SQLiteConnectionPool.a(this, this.g, ???, paramSQLiteCipherSpec, paramInt);
      synchronized (b)
      {
        b.put(this, null);
        return;
      }
    }
  }
  
  private static boolean p()
  {
    Looper localLooper = Looper.myLooper();
    return (localLooper != null) && (localLooper == Looper.getMainLooper());
  }
  
  private void q()
  {
    if (this.h != null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("The database '");
    localStringBuilder.append(this.g.b);
    localStringBuilder.append("' is not open.");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public int a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    return a(paramString1, paramContentValues, paramString2, paramArrayOfString, 0);
  }
  
  public int a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, int paramInt)
  {
    if ((paramContentValues != null) && (paramContentValues.size() != 0)) {
      h();
    }
    for (;;)
    {
      int k;
      Object[] arrayOfObject;
      int m;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder(120);
        localStringBuilder.append("UPDATE ");
        localStringBuilder.append(j[paramInt]);
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" SET ");
        paramInt = paramContentValues.size();
        if (paramArrayOfString == null) {
          k = paramInt;
        } else {
          k = paramArrayOfString.length + paramInt;
        }
        arrayOfObject = new Object[k];
        m = 0;
        Iterator localIterator = a(paramContentValues).iterator();
        if (!localIterator.hasNext()) {
          break label284;
        }
        String str = (String)localIterator.next();
        if (m <= 0) {
          break label278;
        }
        paramString1 = ",";
        localStringBuilder.append(paramString1);
        localStringBuilder.append(str);
        arrayOfObject[m] = paramContentValues.get(str);
        localStringBuilder.append("=?");
        m += 1;
        continue;
        if (!TextUtils.isEmpty(paramString2))
        {
          localStringBuilder.append(" WHERE ");
          localStringBuilder.append(paramString2);
        }
        paramString1 = new SQLiteStatement(this, localStringBuilder.toString(), arrayOfObject);
        try
        {
          paramInt = paramString1.a();
          return paramInt;
        }
        finally {}
        paramString1 = new IllegalArgumentException("Empty values");
      }
      finally
      {
        i();
      }
      for (;;)
      {
        throw paramString1;
      }
      label278:
      paramString1 = "";
      continue;
      label284:
      if (paramArrayOfString != null)
      {
        m = paramInt;
        while (m < k)
        {
          arrayOfObject[m] = paramArrayOfString[(m - paramInt)];
          m += 1;
        }
      }
    }
  }
  
  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    h();
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("DELETE FROM ");
        localStringBuilder.append(paramString1);
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1 = new StringBuilder();
          paramString1.append(" WHERE ");
          paramString1.append(paramString2);
          paramString1 = paramString1.toString();
          localStringBuilder.append(paramString1);
          paramString1 = new SQLiteStatement(this, localStringBuilder.toString(), paramArrayOfString);
          try
          {
            int k = paramString1.a();
            return k;
          }
          finally {}
        }
        paramString1 = "";
      }
      finally
      {
        i();
      }
    }
  }
  
  int a(boolean paramBoolean)
  {
    int k;
    if (paramBoolean) {
      k = 1;
    } else {
      k = 2;
    }
    int m = k;
    if (p()) {
      m = k | 0x4;
    }
    return m;
  }
  
  public long a(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    try
    {
      long l = a(paramString1, paramString2, paramContentValues, 0);
      return l;
    }
    catch (SQLException paramString1)
    {
      Log.a("WCDB.SQLiteDatabase", "Error inserting %s: %s", new Object[] { paramContentValues, paramString1 });
      return -1L;
    }
    catch (SQLiteDatabaseCorruptException paramString1)
    {
      throw paramString1;
    }
  }
  
  public long a(String paramString1, String paramString2, ContentValues paramContentValues, int paramInt)
  {
    h();
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("INSERT");
      localStringBuilder.append(j[paramInt]);
      localStringBuilder.append(" INTO ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append('(');
      paramString1 = null;
      m = 0;
      if ((paramContentValues == null) || (paramContentValues.size() <= 0)) {
        break label309;
      }
      paramInt = paramContentValues.size();
    }
    finally
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        int m;
        Iterator localIterator;
        int k;
        i();
        for (;;)
        {
          throw paramString1;
        }
        paramInt = 0;
        continue;
        paramString1 = "";
        continue;
        paramString1 = paramString2;
        if (k < paramInt) {
          if (k > 0) {
            paramString1 = ",?";
          } else {
            paramString1 = "?";
          }
        }
      }
    }
    if (paramInt > 0)
    {
      paramString2 = new Object[paramInt];
      localIterator = a(paramContentValues).iterator();
      k = 0;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (k <= 0) {
          break label315;
        }
        paramString1 = ",";
        localStringBuilder.append(paramString1);
        localStringBuilder.append(str);
        paramString2[k] = paramContentValues.get(str);
        k += 1;
      }
      localStringBuilder.append(')');
      localStringBuilder.append(" VALUES (");
      k = m;
      break label321;
      localStringBuilder.append(paramString1);
      k += 1;
    }
    else
    {
      paramContentValues = new StringBuilder();
      paramContentValues.append(paramString2);
      paramContentValues.append(") VALUES (NULL");
      localStringBuilder.append(paramContentValues.toString());
      localStringBuilder.append(')');
      paramString1 = new SQLiteStatement(this, localStringBuilder.toString(), paramString1);
      try
      {
        long l = paramString1.b();
        paramString1.close();
        return l;
      }
      finally
      {
        paramString1.close();
      }
    }
  }
  
  public long a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = paramString;
    if (paramString == null) {
      str = "unnamedNative";
    }
    int k;
    if (paramBoolean1) {
      k = 1;
    } else {
      k = 2;
    }
    int m = k;
    if (paramBoolean2) {
      m = k | 0x4;
    }
    long l = c().a(m).a(str);
    if (l != 0L) {
      return l;
    }
    throw new IllegalStateException("SQLiteConnection native handle not initialized.");
  }
  
  public Pair<Integer, Integer> a(String paramString, boolean paramBoolean)
  {
    h();
    int k;
    if (paramBoolean) {
      k = 2;
    } else {
      k = 0;
    }
    try
    {
      paramString = c().a(paramString, k);
      return paramString;
    }
    finally
    {
      i();
    }
  }
  
  public Cursor a(SQLiteDatabase.CursorFactory paramCursorFactory, String paramString1, Object[] paramArrayOfObject, String paramString2, CancellationSignal paramCancellationSignal)
  {
    h();
    try
    {
      paramString1 = new SQLiteDirectCursorDriver(this, paramString1, paramString2, paramCancellationSignal);
      if (paramCursorFactory == null) {
        paramCursorFactory = this.d;
      }
      paramCursorFactory = paramString1.a(paramCursorFactory, paramArrayOfObject);
      return paramCursorFactory;
    }
    finally
    {
      i();
    }
  }
  
  public Cursor a(SQLiteDatabase.CursorFactory paramCursorFactory, boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, Object[] paramArrayOfObject, String paramString3, String paramString4, String paramString5, String paramString6, CancellationSignal paramCancellationSignal)
  {
    h();
    try
    {
      paramCursorFactory = a(paramCursorFactory, SQLiteQueryBuilder.a(paramBoolean, paramString1, paramArrayOfString, paramString2, paramString3, paramString4, paramString5, paramString6), paramArrayOfObject, a(paramString1), paramCancellationSignal);
      return paramCursorFactory;
    }
    finally
    {
      i();
    }
  }
  
  public Cursor a(String paramString, Object[] paramArrayOfObject)
  {
    return a(null, paramString, paramArrayOfObject, null, null);
  }
  
  public Cursor a(String paramString1, String[] paramArrayOfString, String paramString2, Object[] paramArrayOfObject, String paramString3, String paramString4, String paramString5)
  {
    return a(false, paramString1, paramArrayOfString, paramString2, paramArrayOfObject, paramString3, paramString4, paramString5, null);
  }
  
  public Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, Object[] paramArrayOfObject, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return a(null, paramBoolean, paramString1, paramArrayOfString, paramString2, paramArrayOfObject, paramString3, paramString4, paramString5, paramString6, null);
  }
  
  String a()
  {
    synchronized (this.f)
    {
      String str = this.g.b;
      return str;
    }
  }
  
  public void a(long paramLong, Exception paramException)
  {
    c().a(paramException);
  }
  
  public long b(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    try
    {
      long l = a(paramString1, paramString2, paramContentValues, 5);
      return l;
    }
    catch (SQLException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("Error inserting ");
      paramString2.append(paramContentValues);
      Log.a("WCDB.SQLiteDatabase", paramString2.toString(), new Object[] { paramString1 });
      return -1L;
    }
    catch (SQLiteDatabaseCorruptException paramString1)
    {
      throw paramString1;
    }
  }
  
  void b()
  {
    this.e.a(this);
  }
  
  public void b(String paramString)
  {
    a(paramString, null, null);
  }
  
  SQLiteSession c()
  {
    return (SQLiteSession)this.c.get();
  }
  
  SQLiteSession d()
  {
    synchronized (this.f)
    {
      q();
      SQLiteConnectionPool localSQLiteConnectionPool = this.h;
      return new SQLiteSession(localSQLiteConnectionPool);
    }
  }
  
  public void e()
  {
    a(null, true);
  }
  
  public void f()
  {
    h();
    try
    {
      c().a(null);
      return;
    }
    finally
    {
      i();
    }
  }
  
  protected void finalize()
  {
    try
    {
      b(true);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  protected void g()
  {
    b(false);
  }
  
  public void j()
  {
    h();
    try
    {
      c().a();
      return;
    }
    finally
    {
      i();
    }
  }
  
  public boolean k()
  {
    for (;;)
    {
      synchronized (this.f)
      {
        if (this.h != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final String l()
  {
    synchronized (this.f)
    {
      String str = this.g.a;
      return str;
    }
  }
  
  public void m()
  {
    synchronized (this.f)
    {
      q();
      if ((this.g.d & 0x20000000) == 0) {
        return;
      }
      SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration1 = this.g;
      localSQLiteDatabaseConfiguration1.d &= 0xDFFFFFFF;
      try
      {
        this.h.a(this.g);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration2 = this.g;
        localSQLiteDatabaseConfiguration2.d = (0x20000000 | localSQLiteDatabaseConfiguration2.d);
        throw localRuntimeException;
      }
    }
  }
  
  public SQLiteTrace n()
  {
    synchronized (this.f)
    {
      q();
      SQLiteTrace localSQLiteTrace = this.h.b();
      return localSQLiteTrace;
    }
  }
  
  public List<Pair<String, String>> o()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.f)
    {
      SQLiteConnectionPool localSQLiteConnectionPool = this.h;
      Object localObject1 = null;
      if (localSQLiteConnectionPool == null) {
        return null;
      }
      if (!this.i)
      {
        localArrayList.add(new Pair("main", this.g.a));
        return localArrayList;
      }
      h();
      try
      {
        ??? = a("pragma database_list;", null);
        for (;;)
        {
          localObject1 = ???;
          if (!((Cursor)???).moveToNext()) {
            break;
          }
          localObject1 = ???;
          localArrayList.add(new Pair(((Cursor)???).getString(1), ((Cursor)???).getString(2)));
        }
        if (??? != null) {}
        localObject3 = finally;
      }
      finally
      {
        try
        {
          ((Cursor)???).close();
          return localArrayList;
        }
        finally
        {
          i();
        }
        localObject5 = finally;
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SQLiteDatabase: ");
    localStringBuilder.append(l());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDatabase
 * JD-Core Version:    0.7.0.1
 */