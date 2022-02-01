package com.tencent.wcdb.database;

import android.os.Process;
import android.util.Pair;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.extension.SQLiteExtension;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;
import com.tencent.wcdb.support.Log;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SQLiteConnection
  implements CancellationSignal.OnCancelListener
{
  private static final String[] a = new String[0];
  private static final byte[] b = new byte[0];
  private static final Pattern c = Pattern.compile("[\\s]*\\n+[\\s]*");
  private static final String[] w = { "HMAC_SHA1", "HMAC_SHA256", "HMAC_SHA512" };
  private static final String[] x = { "PBKDF2_HMAC_SHA1", "PBKDF2_HMAC_SHA256", "PBKDF2_HMAC_SHA512" };
  private final SQLiteConnectionPool d;
  private final SQLiteDatabaseConfiguration e;
  private final int f;
  private final boolean g;
  private final boolean h;
  private final SQLiteConnection.PreparedStatementCache i;
  private SQLiteConnection.PreparedStatement j;
  private final SQLiteConnection.OperationLog k;
  private Thread l;
  private int m;
  private StackTraceElement[] n;
  private long o;
  private long p;
  private boolean q;
  private int r;
  private byte[] s;
  private SQLiteCipherSpec t;
  private SQLiteConnection.Operation u;
  private int v;
  
  private SQLiteConnection(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt, boolean paramBoolean, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec)
  {
    Object localObject = null;
    this.k = new SQLiteConnection.OperationLog(this, null);
    this.s = paramArrayOfByte;
    if (paramSQLiteCipherSpec == null) {
      paramArrayOfByte = localObject;
    } else {
      paramArrayOfByte = new SQLiteCipherSpec(paramSQLiteCipherSpec);
    }
    this.t = paramArrayOfByte;
    this.d = paramSQLiteConnectionPool;
    this.e = new SQLiteDatabaseConfiguration(paramSQLiteDatabaseConfiguration);
    this.f = paramInt;
    this.g = paramBoolean;
    paramInt = paramSQLiteDatabaseConfiguration.d;
    paramBoolean = true;
    if ((paramInt & 0x1) == 0) {
      paramBoolean = false;
    }
    this.h = paramBoolean;
    this.i = new SQLiteConnection.PreparedStatementCache(this, this.e.e);
  }
  
  private SQLiteConnection.PreparedStatement a(String paramString, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    SQLiteConnection.PreparedStatement localPreparedStatement = this.j;
    if (localPreparedStatement != null)
    {
      this.j = SQLiteConnection.PreparedStatement.g(localPreparedStatement);
      SQLiteConnection.PreparedStatement.a(localPreparedStatement, null);
      SQLiteConnection.PreparedStatement.b(localPreparedStatement, false);
    }
    else
    {
      localPreparedStatement = new SQLiteConnection.PreparedStatement(this);
    }
    SQLiteConnection.PreparedStatement.a(localPreparedStatement, paramString);
    SQLiteConnection.PreparedStatement.a(localPreparedStatement, paramLong);
    SQLiteConnection.PreparedStatement.a(localPreparedStatement, paramInt1);
    SQLiteConnection.PreparedStatement.b(localPreparedStatement, paramInt2);
    SQLiteConnection.PreparedStatement.c(localPreparedStatement, paramBoolean);
    return localPreparedStatement;
  }
  
  static SQLiteConnection a(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt, boolean paramBoolean, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec)
  {
    paramSQLiteConnectionPool = new SQLiteConnection(paramSQLiteConnectionPool, paramSQLiteDatabaseConfiguration, paramInt, paramBoolean, paramArrayOfByte, paramSQLiteCipherSpec);
    try
    {
      paramSQLiteConnectionPool.h();
      return paramSQLiteConnectionPool;
    }
    catch (SQLiteException paramSQLiteDatabaseConfiguration)
    {
      SQLiteDebug.a(paramSQLiteConnectionPool);
      paramSQLiteConnectionPool.b(false);
      throw paramSQLiteDatabaseConfiguration;
    }
  }
  
  private void a(SQLiteConnection.PreparedStatement paramPreparedStatement, boolean paramBoolean)
  {
    nativeResetStatement(this.p, paramPreparedStatement.a(), paramBoolean);
  }
  
  private void a(SQLiteConnection.PreparedStatement paramPreparedStatement, Object[] paramArrayOfObject)
  {
    int i2 = 0;
    int i1;
    if (paramArrayOfObject != null) {
      i1 = paramArrayOfObject.length;
    } else {
      i1 = 0;
    }
    if (i1 == SQLiteConnection.PreparedStatement.b(paramPreparedStatement))
    {
      if (i1 == 0) {
        return;
      }
      long l2 = paramPreparedStatement.a();
      while (i2 < i1)
      {
        paramPreparedStatement = paramArrayOfObject[i2];
        int i3 = DatabaseUtils.a(paramPreparedStatement);
        if (i3 != 0)
        {
          if (i3 != 1)
          {
            if (i3 != 2)
            {
              if (i3 != 4)
              {
                if ((paramPreparedStatement instanceof Boolean))
                {
                  long l3 = this.p;
                  long l1;
                  if (((Boolean)paramPreparedStatement).booleanValue()) {
                    l1 = 1L;
                  } else {
                    l1 = 0L;
                  }
                  nativeBindLong(l3, l2, i2 + 1, l1);
                }
                else
                {
                  nativeBindString(this.p, l2, i2 + 1, paramPreparedStatement.toString());
                }
              }
              else {
                nativeBindBlob(this.p, l2, i2 + 1, (byte[])paramPreparedStatement);
              }
            }
            else {
              nativeBindDouble(this.p, l2, i2 + 1, ((Number)paramPreparedStatement).doubleValue());
            }
          }
          else {
            nativeBindLong(this.p, l2, i2 + 1, ((Number)paramPreparedStatement).longValue());
          }
        }
        else {
          nativeBindNull(this.p, l2, i2 + 1);
        }
        i2 += 1;
      }
      return;
    }
    paramArrayOfObject = new StringBuilder();
    paramArrayOfObject.append("Expected ");
    paramArrayOfObject.append(SQLiteConnection.PreparedStatement.b(paramPreparedStatement));
    paramArrayOfObject.append(" bind arguments but ");
    paramArrayOfObject.append(i1);
    paramArrayOfObject.append(" were provided.");
    paramPreparedStatement = new SQLiteBindOrColumnIndexOutOfRangeException(paramArrayOfObject.toString());
    for (;;)
    {
      throw paramPreparedStatement;
    }
  }
  
  private void a(CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null)
    {
      paramCancellationSignal.b();
      this.r += 1;
      if (this.r == 1)
      {
        nativeResetCancel(this.p, true);
        paramCancellationSignal.a(this);
      }
    }
  }
  
  private static boolean a(int paramInt)
  {
    if (paramInt != 2) {
      return paramInt == 1;
    }
    return true;
  }
  
  private void b(SQLiteConnection.PreparedStatement paramPreparedStatement)
  {
    nativeFinalizeStatement(this.p, paramPreparedStatement.a());
    e(paramPreparedStatement);
  }
  
  private void b(CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null)
    {
      this.r -= 1;
      if (this.r == 0)
      {
        paramCancellationSignal.a(null);
        nativeResetCancel(this.p, false);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.p != 0L)
    {
      int i1 = this.k.a("close", null, null).h;
      try
      {
        this.i.a();
        nativeClose(this.p);
        this.p = 0L;
        return;
      }
      finally
      {
        this.k.a(i1);
      }
    }
  }
  
  private void c(SQLiteConnection.PreparedStatement paramPreparedStatement)
  {
    if (this.q)
    {
      if (SQLiteConnection.PreparedStatement.c(paramPreparedStatement)) {
        return;
      }
      throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
    }
  }
  
  private void d(SQLiteConnection.PreparedStatement paramPreparedStatement) {}
  
  private void e(SQLiteConnection.PreparedStatement paramPreparedStatement)
  {
    SQLiteConnection.PreparedStatement.a(paramPreparedStatement, null);
    SQLiteConnection.PreparedStatement.a(paramPreparedStatement, this.j);
    this.j = paramPreparedStatement;
  }
  
  private void f(String paramString)
  {
    String str = c("PRAGMA journal_mode", null, null);
    if (!str.equalsIgnoreCase(paramString)) {}
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("PRAGMA journal_mode=");
      localStringBuilder.append(paramString);
      boolean bool = c(localStringBuilder.toString(), null, null).equalsIgnoreCase(paramString);
      if (bool) {
        return;
      }
    }
    catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
    {
      StringBuilder localStringBuilder;
      label64:
      break label64;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Could not change the database journal mode of '");
    localStringBuilder.append(this.e.b);
    localStringBuilder.append("' from '");
    localStringBuilder.append(str);
    localStringBuilder.append("' to '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
    Log.b("WCDB.SQLiteConnection", localStringBuilder.toString());
  }
  
  private static String g(String paramString)
  {
    return c.matcher(paramString).replaceAll(" ");
  }
  
  private void h()
  {
    this.p = nativeOpen(this.e.a, this.e.d, this.e.c);
    Object localObject1 = this.s;
    if ((localObject1 != null) && (localObject1.length == 0)) {
      this.s = null;
    }
    localObject1 = this.s;
    if (localObject1 != null)
    {
      nativeSetKey(this.p, (byte[])localObject1);
      j();
    }
    i();
    q();
    m();
    n();
    o();
    l();
    k();
    p();
    long l1 = WCDBInitializationProbe.apiEnv;
    long l2 = nativeSQLiteHandle(this.p, true);
    try
    {
      localObject1 = this.e.l.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((SQLiteExtension)((Iterator)localObject1).next()).a(l2, l1);
      }
      nativeSQLiteHandle(this.p, false);
      r();
      return;
    }
    finally
    {
      nativeSQLiteHandle(this.p, false);
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void i()
  {
    if (!this.e.a())
    {
      Object localObject;
      long l1;
      if (this.s != null)
      {
        localObject = this.t;
        int i1;
        if ((localObject != null) && (((SQLiteCipherSpec)localObject).pageSize > 0)) {
          i1 = this.t.pageSize;
        } else {
          i1 = SQLiteGlobal.a;
        }
        l1 = i1;
        localObject = "PRAGMA cipher_page_size";
      }
      else
      {
        l1 = SQLiteGlobal.a;
        localObject = "PRAGMA page_size";
      }
      if (b((String)localObject, null, null) != l1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("=");
        localStringBuilder.append(l1);
        a(localStringBuilder.toString(), null, null);
      }
    }
  }
  
  private void j()
  {
    Object localObject = this.t;
    if (localObject != null)
    {
      if (((SQLiteCipherSpec)localObject).kdfIteration != 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PRAGMA kdf_iter=");
        ((StringBuilder)localObject).append(this.t.kdfIteration);
        a(((StringBuilder)localObject).toString(), null, null);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PRAGMA cipher_use_hmac=");
      ((StringBuilder)localObject).append(this.t.hmacEnabled);
      a(((StringBuilder)localObject).toString(), null, null);
      if (this.t.hmacAlgorithm != -1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PRAGMA cipher_hmac_algorithm=");
        ((StringBuilder)localObject).append(w[this.t.hmacAlgorithm]);
        a(((StringBuilder)localObject).toString(), null, null);
      }
      if (this.t.kdfAlgorithm != -1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PRAGMA cipher_kdf_algorithm=");
        ((StringBuilder)localObject).append(x[this.t.kdfAlgorithm]);
        a(((StringBuilder)localObject).toString(), null, null);
      }
    }
  }
  
  private void k()
  {
    if ((!this.e.a()) && (!this.h))
    {
      if (this.e.h)
      {
        nativeSetWalHook(this.p);
        return;
      }
      if (b("PRAGMA wal_autocheckpoint", null, null) != 100L) {
        b("PRAGMA wal_autocheckpoint=100", null, null);
      }
    }
  }
  
  private void l()
  {
    if ((!this.e.a()) && (!this.h) && (b("PRAGMA journal_size_limit", null, null) != 524288L)) {
      b("PRAGMA journal_size_limit=524288", null, null);
    }
  }
  
  private void m()
  {
    if (!this.h)
    {
      long l1;
      if (this.e.g) {
        l1 = 1L;
      } else {
        l1 = 0L;
      }
      if (b("PRAGMA foreign_keys", null, null) != l1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PRAGMA foreign_keys=");
        localStringBuilder.append(l1);
        a(localStringBuilder.toString(), null, null);
      }
    }
  }
  
  private void n()
  {
    if ((!this.e.a()) && (!this.h))
    {
      String str;
      if ((this.e.d & 0x20000000) != 0) {
        str = "WAL";
      } else {
        str = "PERSIST";
      }
      f(str);
    }
  }
  
  private static native void nativeBindBlob(long paramLong1, long paramLong2, int paramInt, byte[] paramArrayOfByte);
  
  private static native void nativeBindDouble(long paramLong1, long paramLong2, int paramInt, double paramDouble);
  
  private static native void nativeBindLong(long paramLong1, long paramLong2, int paramInt, long paramLong3);
  
  private static native void nativeBindNull(long paramLong1, long paramLong2, int paramInt);
  
  private static native void nativeBindString(long paramLong1, long paramLong2, int paramInt, String paramString);
  
  private static native void nativeCancel(long paramLong);
  
  private static native void nativeClose(long paramLong);
  
  private static native void nativeExecute(long paramLong1, long paramLong2);
  
  private static native int nativeExecuteForChangedRowCount(long paramLong1, long paramLong2);
  
  private static native long nativeExecuteForCursorWindow(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, boolean paramBoolean);
  
  private static native long nativeExecuteForLastInsertedRowId(long paramLong1, long paramLong2);
  
  private static native long nativeExecuteForLong(long paramLong1, long paramLong2);
  
  private static native String nativeExecuteForString(long paramLong1, long paramLong2);
  
  private static native void nativeFinalizeStatement(long paramLong1, long paramLong2);
  
  private static native int nativeGetColumnCount(long paramLong1, long paramLong2);
  
  private static native String nativeGetColumnName(long paramLong1, long paramLong2, int paramInt);
  
  private static native int nativeGetDbLookaside(long paramLong);
  
  private static native int nativeGetParameterCount(long paramLong1, long paramLong2);
  
  private static native boolean nativeIsReadOnly(long paramLong1, long paramLong2);
  
  private native long nativeOpen(String paramString1, int paramInt, String paramString2);
  
  private static native long nativePrepareStatement(long paramLong, String paramString);
  
  private static native void nativeRegisterCustomFunction(long paramLong, SQLiteCustomFunction paramSQLiteCustomFunction);
  
  private static native void nativeRegisterLocalizedCollators(long paramLong, String paramString);
  
  private static native void nativeResetCancel(long paramLong, boolean paramBoolean);
  
  private static native void nativeResetStatement(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private static native long nativeSQLiteHandle(long paramLong, boolean paramBoolean);
  
  private static native void nativeSetKey(long paramLong, byte[] paramArrayOfByte);
  
  private static native void nativeSetUpdateNotification(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native void nativeSetWalHook(long paramLong);
  
  private static native long nativeWalCheckpoint(long paramLong, String paramString);
  
  private void notifyChange(String paramString1, String paramString2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    this.d.a(paramString1, paramString2, paramArrayOfLong1, paramArrayOfLong2, paramArrayOfLong3);
  }
  
  private void notifyCheckpoint(String paramString, int paramInt)
  {
    this.d.a(paramString, paramInt);
  }
  
  private void o()
  {
    int i1 = this.e.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PRAGMA synchronous=");
    localStringBuilder.append(i1);
    a(localStringBuilder.toString(), null, null);
  }
  
  /* Error */
  private void p()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 109	com/tencent/wcdb/database/SQLiteConnection:e	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   4: astore_1
    //   5: aload_1
    //   6: aload_1
    //   7: getfield 115	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:d	I
    //   10: bipush 16
    //   12: ior
    //   13: putfield 115	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:d	I
    //   16: aload_0
    //   17: getfield 109	com/tencent/wcdb/database/SQLiteConnection:e	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   20: getfield 115	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:d	I
    //   23: bipush 16
    //   25: iand
    //   26: ifeq +4 -> 30
    //   29: return
    //   30: aload_0
    //   31: getfield 109	com/tencent/wcdb/database/SQLiteConnection:e	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   34: getfield 549	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:f	Ljava/util/Locale;
    //   37: invokevirtual 552	java/util/Locale:toString	()Ljava/lang/String;
    //   40: astore_1
    //   41: aload_0
    //   42: getfield 174	com/tencent/wcdb/database/SQLiteConnection:p	J
    //   45: aload_1
    //   46: invokestatic 554	com/tencent/wcdb/database/SQLiteConnection:nativeRegisterLocalizedCollators	(JLjava/lang/String;)V
    //   49: aload_0
    //   50: getfield 117	com/tencent/wcdb/database/SQLiteConnection:h	Z
    //   53: ifeq +4 -> 57
    //   56: return
    //   57: aload_0
    //   58: ldc_w 556
    //   61: aconst_null
    //   62: aconst_null
    //   63: invokevirtual 451	com/tencent/wcdb/database/SQLiteConnection:a	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   66: aload_0
    //   67: ldc_w 558
    //   70: aconst_null
    //   71: aconst_null
    //   72: invokevirtual 328	com/tencent/wcdb/database/SQLiteConnection:c	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)Ljava/lang/String;
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +12 -> 89
    //   80: aload_2
    //   81: aload_1
    //   82: invokevirtual 562	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifeq +4 -> 89
    //   88: return
    //   89: aload_0
    //   90: ldc_w 564
    //   93: aconst_null
    //   94: aconst_null
    //   95: invokevirtual 451	com/tencent/wcdb/database/SQLiteConnection:a	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   98: aload_0
    //   99: ldc_w 566
    //   102: aconst_null
    //   103: aconst_null
    //   104: invokevirtual 451	com/tencent/wcdb/database/SQLiteConnection:a	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   107: aload_0
    //   108: ldc_w 568
    //   111: iconst_1
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload_1
    //   118: aastore
    //   119: aconst_null
    //   120: invokevirtual 451	com/tencent/wcdb/database/SQLiteConnection:a	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   123: aload_0
    //   124: ldc_w 570
    //   127: aconst_null
    //   128: aconst_null
    //   129: invokevirtual 451	com/tencent/wcdb/database/SQLiteConnection:a	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   132: aload_0
    //   133: ldc_w 572
    //   136: aconst_null
    //   137: aconst_null
    //   138: invokevirtual 451	com/tencent/wcdb/database/SQLiteConnection:a	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   141: return
    //   142: astore_2
    //   143: aload_0
    //   144: ldc_w 574
    //   147: aconst_null
    //   148: aconst_null
    //   149: invokevirtual 451	com/tencent/wcdb/database/SQLiteConnection:a	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   152: aload_2
    //   153: athrow
    //   154: astore_2
    //   155: new 232	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   162: astore_3
    //   163: aload_3
    //   164: ldc_w 576
    //   167: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_3
    //   172: aload_0
    //   173: getfield 109	com/tencent/wcdb/database/SQLiteConnection:e	Lcom/tencent/wcdb/database/SQLiteDatabaseConfiguration;
    //   176: getfield 339	com/tencent/wcdb/database/SQLiteDatabaseConfiguration:b	Ljava/lang/String;
    //   179: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_3
    //   184: ldc_w 343
    //   187: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_3
    //   192: aload_1
    //   193: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_3
    //   198: ldc_w 578
    //   201: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: new 160	com/tencent/wcdb/database/SQLiteException
    //   208: dup
    //   209: aload_3
    //   210: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: aload_2
    //   214: invokespecial 581	com/tencent/wcdb/database/SQLiteException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   217: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	SQLiteConnection
    //   4	189	1	localObject1	Object
    //   75	6	2	str	String
    //   142	11	2	localObject2	Object
    //   154	60	2	localRuntimeException	RuntimeException
    //   162	48	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   98	132	142	finally
    //   57	76	154	java/lang/RuntimeException
    //   80	88	154	java/lang/RuntimeException
    //   89	98	154	java/lang/RuntimeException
    //   132	141	154	java/lang/RuntimeException
    //   143	154	154	java/lang/RuntimeException
  }
  
  private void q()
  {
    if (this.h) {
      a("PRAGMA query_only = 1", null, null);
    }
  }
  
  private void r()
  {
    nativeSetUpdateNotification(this.p, this.e.j, this.e.k);
  }
  
  /* Error */
  public int a(String paramString, Object[] paramArrayOfObject, com.tencent.wcdb.CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +613 -> 614
    //   4: aload_3
    //   5: ifnull +598 -> 603
    //   8: aload_3
    //   9: invokevirtual 593	com/tencent/wcdb/CursorWindow:h	()V
    //   12: aload_0
    //   13: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   16: ldc_w 595
    //   19: aload_1
    //   20: aload_2
    //   21: invokevirtual 296	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   24: astore 21
    //   26: aload 21
    //   28: getfield 300	com/tencent/wcdb/database/SQLiteConnection$Operation:h	I
    //   31: istore 13
    //   33: iconst_m1
    //   34: istore 9
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 598	com/tencent/wcdb/database/SQLiteConnection:d	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   41: astore 20
    //   43: aload 21
    //   45: aload 20
    //   47: invokestatic 600	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   50: putfield 601	com/tencent/wcdb/database/SQLiteConnection$Operation:i	I
    //   53: aload_0
    //   54: aload 20
    //   56: invokespecial 603	com/tencent/wcdb/database/SQLiteConnection:c	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   59: aload_0
    //   60: aload 20
    //   62: aload_2
    //   63: invokespecial 262	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   66: aload_0
    //   67: aload 20
    //   69: invokespecial 605	com/tencent/wcdb/database/SQLiteConnection:d	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   72: aload_0
    //   73: aload 7
    //   75: invokespecial 266	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   78: aload_0
    //   79: getfield 174	com/tencent/wcdb/database/SQLiteConnection:p	J
    //   82: lstore 14
    //   84: aload 20
    //   86: invokevirtual 177	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:a	()J
    //   89: lstore 16
    //   91: aload_3
    //   92: getfield 607	com/tencent/wcdb/CursorWindow:a	J
    //   95: lstore 18
    //   97: iload 13
    //   99: istore 10
    //   101: lload 14
    //   103: lload 16
    //   105: lload 18
    //   107: iload 4
    //   109: iload 5
    //   111: iload 6
    //   113: invokestatic 609	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForCursorWindow	(JJJIIZ)J
    //   116: lstore 14
    //   118: lload 14
    //   120: bipush 32
    //   122: lshr
    //   123: l2i
    //   124: istore 5
    //   126: lload 14
    //   128: l2i
    //   129: istore 8
    //   131: aload_3
    //   132: invokevirtual 612	com/tencent/wcdb/CursorWindow:d	()I
    //   135: istore 9
    //   137: aload_3
    //   138: iload 5
    //   140: invokevirtual 613	com/tencent/wcdb/CursorWindow:a	(I)V
    //   143: aload_0
    //   144: aload 7
    //   146: invokespecial 291	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   149: aload_0
    //   150: aload 20
    //   152: invokevirtual 615	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   155: aload_0
    //   156: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   159: iload 10
    //   161: invokevirtual 617	com/tencent/wcdb/database/SQLiteConnection$OperationLog:b	(I)Z
    //   164: ifeq +100 -> 264
    //   167: aload_0
    //   168: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   171: astore_1
    //   172: new 232	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   179: astore_2
    //   180: aload_2
    //   181: ldc_w 619
    //   184: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_2
    //   189: aload_3
    //   190: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_2
    //   195: ldc_w 624
    //   198: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_2
    //   203: iload 4
    //   205: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_2
    //   210: ldc_w 626
    //   213: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload_2
    //   218: iload 5
    //   220: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_2
    //   225: ldc_w 628
    //   228: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload_2
    //   233: iload 9
    //   235: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_2
    //   240: ldc_w 630
    //   243: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_2
    //   248: iload 8
    //   250: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_1
    //   255: iload 10
    //   257: aload_2
    //   258: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokevirtual 633	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(ILjava/lang/String;)V
    //   264: aload_3
    //   265: invokevirtual 634	com/tencent/wcdb/CursorWindow:i	()V
    //   268: iload 8
    //   270: ireturn
    //   271: astore_1
    //   272: goto +201 -> 473
    //   275: astore_1
    //   276: iload 5
    //   278: istore 10
    //   280: iload 9
    //   282: istore 5
    //   284: iload 10
    //   286: istore 9
    //   288: goto +136 -> 424
    //   291: astore_1
    //   292: iload 5
    //   294: istore 10
    //   296: iload 9
    //   298: istore 5
    //   300: iload 10
    //   302: istore 9
    //   304: goto +64 -> 368
    //   307: astore_1
    //   308: iload 5
    //   310: istore 10
    //   312: iload 9
    //   314: istore 5
    //   316: iload 10
    //   318: istore 9
    //   320: goto +29 -> 349
    //   323: astore_1
    //   324: iload 5
    //   326: istore 9
    //   328: iconst_m1
    //   329: istore 5
    //   331: goto +18 -> 349
    //   334: astore_1
    //   335: goto +8 -> 343
    //   338: astore_1
    //   339: goto +4 -> 343
    //   342: astore_1
    //   343: iconst_m1
    //   344: istore 5
    //   346: iconst_m1
    //   347: istore 8
    //   349: aload_0
    //   350: aload 7
    //   352: invokespecial 291	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   355: aload_1
    //   356: athrow
    //   357: astore_1
    //   358: goto +10 -> 368
    //   361: astore_1
    //   362: iconst_m1
    //   363: istore 5
    //   365: iconst_m1
    //   366: istore 8
    //   368: iload 5
    //   370: istore 10
    //   372: iload 8
    //   374: istore 11
    //   376: iload 9
    //   378: istore 12
    //   380: aload_0
    //   381: aload 20
    //   383: invokevirtual 615	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   386: iload 5
    //   388: istore 10
    //   390: iload 8
    //   392: istore 11
    //   394: iload 9
    //   396: istore 12
    //   398: aload_1
    //   399: athrow
    //   400: astore_1
    //   401: goto +23 -> 424
    //   404: astore_1
    //   405: iconst_m1
    //   406: istore 9
    //   408: iconst_m1
    //   409: istore 8
    //   411: iconst_m1
    //   412: istore 5
    //   414: goto +59 -> 473
    //   417: astore_1
    //   418: iconst_m1
    //   419: istore 5
    //   421: iconst_m1
    //   422: istore 8
    //   424: iload 5
    //   426: istore 10
    //   428: iload 8
    //   430: istore 11
    //   432: iload 9
    //   434: istore 12
    //   436: aload_0
    //   437: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   440: iload 13
    //   442: aload_1
    //   443: invokevirtual 637	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(ILjava/lang/Exception;)V
    //   446: iload 5
    //   448: istore 10
    //   450: iload 8
    //   452: istore 11
    //   454: iload 9
    //   456: istore 12
    //   458: aload_1
    //   459: athrow
    //   460: astore_1
    //   461: iload 12
    //   463: istore 5
    //   465: iload 11
    //   467: istore 8
    //   469: iload 10
    //   471: istore 9
    //   473: aload_0
    //   474: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   477: iload 13
    //   479: invokevirtual 617	com/tencent/wcdb/database/SQLiteConnection$OperationLog:b	(I)Z
    //   482: ifeq +112 -> 594
    //   485: aload_0
    //   486: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   489: astore_2
    //   490: new 232	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   497: astore 7
    //   499: aload 7
    //   501: ldc_w 619
    //   504: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload 7
    //   510: aload_3
    //   511: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload 7
    //   517: ldc_w 624
    //   520: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 7
    //   526: iload 4
    //   528: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 7
    //   534: ldc_w 626
    //   537: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload 7
    //   543: iload 5
    //   545: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload 7
    //   551: ldc_w 628
    //   554: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 7
    //   560: iload 9
    //   562: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 7
    //   568: ldc_w 630
    //   571: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload 7
    //   577: iload 8
    //   579: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: aload_2
    //   584: iload 13
    //   586: aload 7
    //   588: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: invokevirtual 633	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(ILjava/lang/String;)V
    //   594: aload_1
    //   595: athrow
    //   596: astore_1
    //   597: aload_3
    //   598: invokevirtual 634	com/tencent/wcdb/CursorWindow:i	()V
    //   601: aload_1
    //   602: athrow
    //   603: new 639	java/lang/IllegalArgumentException
    //   606: dup
    //   607: ldc_w 641
    //   610: invokespecial 642	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   613: athrow
    //   614: new 639	java/lang/IllegalArgumentException
    //   617: dup
    //   618: ldc_w 644
    //   621: invokespecial 642	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   624: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	625	0	this	SQLiteConnection
    //   0	625	1	paramString	String
    //   0	625	2	paramArrayOfObject	Object[]
    //   0	625	3	paramCursorWindow	com.tencent.wcdb.CursorWindow
    //   0	625	4	paramInt1	int
    //   0	625	5	paramInt2	int
    //   0	625	6	paramBoolean	boolean
    //   0	625	7	paramCancellationSignal	CancellationSignal
    //   129	449	8	i1	int
    //   34	527	9	i2	int
    //   99	371	10	i3	int
    //   374	92	11	i4	int
    //   378	84	12	i5	int
    //   31	554	13	i6	int
    //   82	45	14	l1	long
    //   89	15	16	l2	long
    //   95	11	18	l3	long
    //   41	341	20	localPreparedStatement	SQLiteConnection.PreparedStatement
    //   24	20	21	localOperation	SQLiteConnection.Operation
    // Exception table:
    //   from	to	target	type
    //   149	155	271	finally
    //   149	155	275	java/lang/RuntimeException
    //   143	149	291	finally
    //   137	143	307	finally
    //   131	137	323	finally
    //   101	118	334	finally
    //   91	97	338	finally
    //   78	91	342	finally
    //   349	357	357	finally
    //   53	78	361	finally
    //   380	386	400	java/lang/RuntimeException
    //   398	400	400	java/lang/RuntimeException
    //   36	53	404	finally
    //   36	53	417	java/lang/RuntimeException
    //   380	386	460	finally
    //   398	400	460	finally
    //   436	446	460	finally
    //   458	460	460	finally
    //   12	33	596	finally
    //   155	264	596	finally
    //   473	594	596	finally
    //   594	596	596	finally
  }
  
  long a(String paramString)
  {
    if (this.p == 0L) {
      return 0L;
    }
    if ((paramString != null) && (this.u == null))
    {
      this.u = this.k.a(paramString, null, null);
      this.u.i = 99;
    }
    this.v += 1;
    return nativeSQLiteHandle(this.p, true);
  }
  
  void a()
  {
    b(false);
  }
  
  void a(SQLiteConnection.PreparedStatement paramPreparedStatement)
  {
    SQLiteConnection.PreparedStatement.a(paramPreparedStatement, false);
    if (SQLiteConnection.PreparedStatement.e(paramPreparedStatement)) {}
    try
    {
      a(paramPreparedStatement, true);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      label20:
      break label20;
    }
    this.i.b(SQLiteConnection.PreparedStatement.f(paramPreparedStatement));
    return;
    b(paramPreparedStatement);
  }
  
  void a(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    int i5 = 0;
    this.q = false;
    long l1 = WCDBInitializationProbe.apiEnv;
    long l2 = nativeSQLiteHandle(this.p, true);
    try
    {
      Iterator localIterator = paramSQLiteDatabaseConfiguration.l.iterator();
      while (localIterator.hasNext())
      {
        SQLiteExtension localSQLiteExtension = (SQLiteExtension)localIterator.next();
        if (!this.e.l.contains(localSQLiteExtension)) {
          localSQLiteExtension.a(l2, l1);
        }
      }
      nativeSQLiteHandle(this.p, false);
      int i1;
      if (((paramSQLiteDatabaseConfiguration.d ^ this.e.d) & 0x20000000) != 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i2;
      if (paramSQLiteDatabaseConfiguration.g != this.e.g) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      boolean bool = paramSQLiteDatabaseConfiguration.f.equals(this.e.f);
      int i3;
      if (paramSQLiteDatabaseConfiguration.h != this.e.h) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      int i4;
      if (paramSQLiteDatabaseConfiguration.i != this.e.i) {
        i4 = 1;
      } else {
        i4 = 0;
      }
      if ((paramSQLiteDatabaseConfiguration.j != this.e.j) || (paramSQLiteDatabaseConfiguration.k != this.e.k)) {
        i5 = 1;
      }
      this.e.a(paramSQLiteDatabaseConfiguration);
      this.i.a(paramSQLiteDatabaseConfiguration.e);
      if (i2 != 0) {
        m();
      }
      if (i1 != 0) {
        n();
      }
      if (i4 != 0) {
        o();
      }
      if (i3 != 0) {
        k();
      }
      if ((bool ^ true)) {
        p();
      }
      if (i5 != 0) {
        r();
      }
      return;
    }
    finally
    {
      nativeSQLiteHandle(this.p, false);
    }
    for (;;)
    {
      throw paramSQLiteDatabaseConfiguration;
    }
  }
  
  void a(Exception paramException)
  {
    int i1 = this.v - 1;
    this.v = i1;
    if ((i1 == 0) && (this.u != null))
    {
      nativeSQLiteHandle(this.p, false);
      if (paramException == null) {
        this.k.b(this.u.h);
      } else {
        this.k.a(this.u.h, paramException);
      }
      this.u = null;
    }
  }
  
  /* Error */
  public void a(String paramString, SQLiteStatementInfo paramSQLiteStatementInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +180 -> 181
    //   4: aload_0
    //   5: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   8: ldc_w 670
    //   11: aload_1
    //   12: aconst_null
    //   13: invokevirtual 296	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   16: astore 6
    //   18: aload 6
    //   20: getfield 300	com/tencent/wcdb/database/SQLiteConnection$Operation:h	I
    //   23: istore 4
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 598	com/tencent/wcdb/database/SQLiteConnection:d	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   30: astore_1
    //   31: aload 6
    //   33: aload_1
    //   34: invokestatic 600	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   37: putfield 601	com/tencent/wcdb/database/SQLiteConnection$Operation:i	I
    //   40: aload_2
    //   41: ifnull +97 -> 138
    //   44: aload_2
    //   45: aload_1
    //   46: invokestatic 185	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:b	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   49: putfield 673	com/tencent/wcdb/database/SQLiteStatementInfo:a	I
    //   52: aload_2
    //   53: aload_1
    //   54: invokestatic 315	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:c	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)Z
    //   57: putfield 675	com/tencent/wcdb/database/SQLiteStatementInfo:c	Z
    //   60: aload_0
    //   61: getfield 174	com/tencent/wcdb/database/SQLiteConnection:p	J
    //   64: aload_1
    //   65: invokevirtual 177	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:a	()J
    //   68: invokestatic 677	com/tencent/wcdb/database/SQLiteConnection:nativeGetColumnCount	(JJ)I
    //   71: istore 5
    //   73: iload 5
    //   75: ifne +13 -> 88
    //   78: aload_2
    //   79: getstatic 51	com/tencent/wcdb/database/SQLiteConnection:a	[Ljava/lang/String;
    //   82: putfield 679	com/tencent/wcdb/database/SQLiteStatementInfo:b	[Ljava/lang/String;
    //   85: goto +53 -> 138
    //   88: aload_2
    //   89: iload 5
    //   91: anewarray 49	java/lang/String
    //   94: putfield 679	com/tencent/wcdb/database/SQLiteStatementInfo:b	[Ljava/lang/String;
    //   97: iconst_0
    //   98: istore_3
    //   99: iload_3
    //   100: iload 5
    //   102: if_icmpge +36 -> 138
    //   105: aload_2
    //   106: getfield 679	com/tencent/wcdb/database/SQLiteStatementInfo:b	[Ljava/lang/String;
    //   109: iload_3
    //   110: aload_0
    //   111: getfield 174	com/tencent/wcdb/database/SQLiteConnection:p	J
    //   114: aload_1
    //   115: invokevirtual 177	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:a	()J
    //   118: iload_3
    //   119: invokestatic 681	com/tencent/wcdb/database/SQLiteConnection:nativeGetColumnName	(JJI)Ljava/lang/String;
    //   122: aastore
    //   123: iload_3
    //   124: iconst_1
    //   125: iadd
    //   126: istore_3
    //   127: goto -28 -> 99
    //   130: astore_2
    //   131: aload_0
    //   132: aload_1
    //   133: invokevirtual 615	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   136: aload_2
    //   137: athrow
    //   138: aload_0
    //   139: aload_1
    //   140: invokevirtual 615	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   143: aload_0
    //   144: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   147: iload 4
    //   149: invokevirtual 309	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(I)V
    //   152: return
    //   153: astore_1
    //   154: goto +16 -> 170
    //   157: astore_1
    //   158: aload_0
    //   159: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   162: iload 4
    //   164: aload_1
    //   165: invokevirtual 637	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(ILjava/lang/Exception;)V
    //   168: aload_1
    //   169: athrow
    //   170: aload_0
    //   171: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   174: iload 4
    //   176: invokevirtual 309	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(I)V
    //   179: aload_1
    //   180: athrow
    //   181: new 639	java/lang/IllegalArgumentException
    //   184: dup
    //   185: ldc_w 644
    //   188: invokespecial 642	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   191: astore_1
    //   192: goto +5 -> 197
    //   195: aload_1
    //   196: athrow
    //   197: goto -2 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	SQLiteConnection
    //   0	200	1	paramString	String
    //   0	200	2	paramSQLiteStatementInfo	SQLiteStatementInfo
    //   98	29	3	i1	int
    //   23	152	4	i2	int
    //   71	32	5	i3	int
    //   16	16	6	localOperation	SQLiteConnection.Operation
    // Exception table:
    //   from	to	target	type
    //   44	73	130	finally
    //   78	85	130	finally
    //   88	97	130	finally
    //   105	123	130	finally
    //   25	40	153	finally
    //   131	138	153	finally
    //   138	143	153	finally
    //   158	170	153	finally
    //   25	40	157	java/lang/RuntimeException
    //   131	138	157	java/lang/RuntimeException
    //   138	143	157	java/lang/RuntimeException
  }
  
  /* Error */
  public void a(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +135 -> 136
    //   4: aload_0
    //   5: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   8: ldc_w 683
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual 296	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   16: astore 5
    //   18: aload 5
    //   20: getfield 300	com/tencent/wcdb/database/SQLiteConnection$Operation:h	I
    //   23: istore 4
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 598	com/tencent/wcdb/database/SQLiteConnection:d	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   30: astore_1
    //   31: aload 5
    //   33: aload_1
    //   34: invokestatic 600	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   37: putfield 601	com/tencent/wcdb/database/SQLiteConnection$Operation:i	I
    //   40: aload_0
    //   41: aload_1
    //   42: invokespecial 603	com/tencent/wcdb/database/SQLiteConnection:c	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   45: aload_0
    //   46: aload_1
    //   47: aload_2
    //   48: invokespecial 262	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   51: aload_0
    //   52: aload_1
    //   53: invokespecial 605	com/tencent/wcdb/database/SQLiteConnection:d	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   56: aload_0
    //   57: aload_3
    //   58: invokespecial 266	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   61: aload_0
    //   62: getfield 174	com/tencent/wcdb/database/SQLiteConnection:p	J
    //   65: aload_1
    //   66: invokevirtual 177	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:a	()J
    //   69: invokestatic 685	com/tencent/wcdb/database/SQLiteConnection:nativeExecute	(JJ)V
    //   72: aload_0
    //   73: aload_3
    //   74: invokespecial 291	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   77: aload_0
    //   78: aload_1
    //   79: invokevirtual 615	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   82: aload_0
    //   83: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   86: iload 4
    //   88: invokevirtual 309	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(I)V
    //   91: return
    //   92: astore_2
    //   93: aload_0
    //   94: aload_3
    //   95: invokespecial 291	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   98: aload_2
    //   99: athrow
    //   100: astore_2
    //   101: aload_0
    //   102: aload_1
    //   103: invokevirtual 615	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   106: aload_2
    //   107: athrow
    //   108: astore_1
    //   109: goto +16 -> 125
    //   112: astore_1
    //   113: aload_0
    //   114: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   117: iload 4
    //   119: aload_1
    //   120: invokevirtual 637	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(ILjava/lang/Exception;)V
    //   123: aload_1
    //   124: athrow
    //   125: aload_0
    //   126: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   129: iload 4
    //   131: invokevirtual 309	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(I)V
    //   134: aload_1
    //   135: athrow
    //   136: new 639	java/lang/IllegalArgumentException
    //   139: dup
    //   140: ldc_w 644
    //   143: invokespecial 642	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	SQLiteConnection
    //   0	147	1	paramString	String
    //   0	147	2	paramArrayOfObject	Object[]
    //   0	147	3	paramCancellationSignal	CancellationSignal
    //   23	107	4	i1	int
    //   16	16	5	localOperation	SQLiteConnection.Operation
    // Exception table:
    //   from	to	target	type
    //   61	72	92	finally
    //   40	61	100	finally
    //   72	77	100	finally
    //   93	100	100	finally
    //   25	40	108	finally
    //   77	82	108	finally
    //   101	108	108	finally
    //   113	125	108	finally
    //   25	40	112	java/lang/RuntimeException
    //   77	82	112	java/lang/RuntimeException
    //   101	108	112	java/lang/RuntimeException
  }
  
  void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.l = Thread.currentThread();
      this.m = Process.myTid();
      if (paramBoolean2)
      {
        this.n = this.l.getStackTrace();
        this.o = System.currentTimeMillis();
        return;
      }
      this.n = null;
      this.o = 0L;
      return;
    }
    this.l = null;
    this.m = 0;
    this.n = null;
    this.o = 0L;
  }
  
  /* Error */
  public long b(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +139 -> 140
    //   4: aload_0
    //   5: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   8: ldc_w 714
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual 296	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   16: astore 7
    //   18: aload 7
    //   20: getfield 300	com/tencent/wcdb/database/SQLiteConnection$Operation:h	I
    //   23: istore 4
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 598	com/tencent/wcdb/database/SQLiteConnection:d	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   30: astore_1
    //   31: aload 7
    //   33: aload_1
    //   34: invokestatic 600	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   37: putfield 601	com/tencent/wcdb/database/SQLiteConnection$Operation:i	I
    //   40: aload_0
    //   41: aload_1
    //   42: invokespecial 603	com/tencent/wcdb/database/SQLiteConnection:c	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   45: aload_0
    //   46: aload_1
    //   47: aload_2
    //   48: invokespecial 262	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   51: aload_0
    //   52: aload_1
    //   53: invokespecial 605	com/tencent/wcdb/database/SQLiteConnection:d	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   56: aload_0
    //   57: aload_3
    //   58: invokespecial 266	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   61: aload_0
    //   62: getfield 174	com/tencent/wcdb/database/SQLiteConnection:p	J
    //   65: aload_1
    //   66: invokevirtual 177	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:a	()J
    //   69: invokestatic 716	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForLong	(JJ)J
    //   72: lstore 5
    //   74: aload_0
    //   75: aload_3
    //   76: invokespecial 291	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   79: aload_0
    //   80: aload_1
    //   81: invokevirtual 615	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   84: aload_0
    //   85: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   88: iload 4
    //   90: invokevirtual 309	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(I)V
    //   93: lload 5
    //   95: lreturn
    //   96: astore_2
    //   97: aload_0
    //   98: aload_3
    //   99: invokespecial 291	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   102: aload_2
    //   103: athrow
    //   104: astore_2
    //   105: aload_0
    //   106: aload_1
    //   107: invokevirtual 615	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   110: aload_2
    //   111: athrow
    //   112: astore_1
    //   113: goto +16 -> 129
    //   116: astore_1
    //   117: aload_0
    //   118: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   121: iload 4
    //   123: aload_1
    //   124: invokevirtual 637	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(ILjava/lang/Exception;)V
    //   127: aload_1
    //   128: athrow
    //   129: aload_0
    //   130: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   133: iload 4
    //   135: invokevirtual 309	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(I)V
    //   138: aload_1
    //   139: athrow
    //   140: new 639	java/lang/IllegalArgumentException
    //   143: dup
    //   144: ldc_w 644
    //   147: invokespecial 642	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	SQLiteConnection
    //   0	151	1	paramString	String
    //   0	151	2	paramArrayOfObject	Object[]
    //   0	151	3	paramCancellationSignal	CancellationSignal
    //   23	111	4	i1	int
    //   72	22	5	l1	long
    //   16	16	7	localOperation	SQLiteConnection.Operation
    // Exception table:
    //   from	to	target	type
    //   61	74	96	finally
    //   40	61	104	finally
    //   74	79	104	finally
    //   97	104	104	finally
    //   25	40	112	finally
    //   79	84	112	finally
    //   105	112	112	finally
    //   117	129	112	finally
    //   25	40	116	java/lang/RuntimeException
    //   79	84	116	java/lang/RuntimeException
    //   105	112	116	java/lang/RuntimeException
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  boolean b(String paramString)
  {
    return this.i.a(paramString) != null;
  }
  
  public Pair<Integer, Integer> c(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.isEmpty()) {}
    }
    else
    {
      str = "main";
    }
    long l1 = nativeWalCheckpoint(this.p, str);
    return new Pair(Integer.valueOf((int)(l1 >> 32)), Integer.valueOf((int)(l1 & 0xFFFFFFFF)));
  }
  
  /* Error */
  public String c(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +137 -> 138
    //   4: aload_0
    //   5: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   8: ldc_w 743
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual 296	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   16: astore 5
    //   18: aload 5
    //   20: getfield 300	com/tencent/wcdb/database/SQLiteConnection$Operation:h	I
    //   23: istore 4
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 598	com/tencent/wcdb/database/SQLiteConnection:d	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   30: astore_1
    //   31: aload 5
    //   33: aload_1
    //   34: invokestatic 600	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   37: putfield 601	com/tencent/wcdb/database/SQLiteConnection$Operation:i	I
    //   40: aload_0
    //   41: aload_1
    //   42: invokespecial 603	com/tencent/wcdb/database/SQLiteConnection:c	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   45: aload_0
    //   46: aload_1
    //   47: aload_2
    //   48: invokespecial 262	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   51: aload_0
    //   52: aload_1
    //   53: invokespecial 605	com/tencent/wcdb/database/SQLiteConnection:d	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   56: aload_0
    //   57: aload_3
    //   58: invokespecial 266	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   61: aload_0
    //   62: getfield 174	com/tencent/wcdb/database/SQLiteConnection:p	J
    //   65: aload_1
    //   66: invokevirtual 177	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:a	()J
    //   69: invokestatic 745	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForString	(JJ)Ljava/lang/String;
    //   72: astore_2
    //   73: aload_0
    //   74: aload_3
    //   75: invokespecial 291	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   78: aload_0
    //   79: aload_1
    //   80: invokevirtual 615	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   83: aload_0
    //   84: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   87: iload 4
    //   89: invokevirtual 309	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(I)V
    //   92: aload_2
    //   93: areturn
    //   94: astore_2
    //   95: aload_0
    //   96: aload_3
    //   97: invokespecial 291	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   100: aload_2
    //   101: athrow
    //   102: astore_2
    //   103: aload_0
    //   104: aload_1
    //   105: invokevirtual 615	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   108: aload_2
    //   109: athrow
    //   110: astore_1
    //   111: goto +16 -> 127
    //   114: astore_1
    //   115: aload_0
    //   116: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   119: iload 4
    //   121: aload_1
    //   122: invokevirtual 637	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(ILjava/lang/Exception;)V
    //   125: aload_1
    //   126: athrow
    //   127: aload_0
    //   128: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   131: iload 4
    //   133: invokevirtual 309	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(I)V
    //   136: aload_1
    //   137: athrow
    //   138: new 639	java/lang/IllegalArgumentException
    //   141: dup
    //   142: ldc_w 644
    //   145: invokespecial 642	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	SQLiteConnection
    //   0	149	1	paramString	String
    //   0	149	2	paramArrayOfObject	Object[]
    //   0	149	3	paramCancellationSignal	CancellationSignal
    //   23	109	4	i1	int
    //   16	16	5	localOperation	SQLiteConnection.Operation
    // Exception table:
    //   from	to	target	type
    //   61	73	94	finally
    //   40	61	102	finally
    //   73	78	102	finally
    //   95	102	102	finally
    //   25	40	110	finally
    //   78	83	110	finally
    //   103	110	110	finally
    //   115	127	110	finally
    //   25	40	114	java/lang/RuntimeException
    //   78	83	114	java/lang/RuntimeException
    //   103	110	114	java/lang/RuntimeException
  }
  
  public void c()
  {
    nativeCancel(this.p);
  }
  
  /* Error */
  public int d(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +306 -> 307
    //   4: iconst_0
    //   5: istore 6
    //   7: iconst_0
    //   8: istore 7
    //   10: iconst_0
    //   11: istore 8
    //   13: aload_0
    //   14: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   17: ldc_w 750
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 296	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   25: astore 10
    //   27: aload 10
    //   29: getfield 300	com/tencent/wcdb/database/SQLiteConnection$Operation:h	I
    //   32: istore 9
    //   34: iload 6
    //   36: istore 4
    //   38: iload 7
    //   40: istore 5
    //   42: aload_0
    //   43: aload_1
    //   44: invokevirtual 598	com/tencent/wcdb/database/SQLiteConnection:d	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   47: astore_1
    //   48: iload 6
    //   50: istore 4
    //   52: iload 7
    //   54: istore 5
    //   56: aload 10
    //   58: aload_1
    //   59: invokestatic 600	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   62: putfield 601	com/tencent/wcdb/database/SQLiteConnection$Operation:i	I
    //   65: iload 8
    //   67: istore 6
    //   69: aload_0
    //   70: aload_1
    //   71: invokespecial 603	com/tencent/wcdb/database/SQLiteConnection:c	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   74: iload 8
    //   76: istore 6
    //   78: aload_0
    //   79: aload_1
    //   80: aload_2
    //   81: invokespecial 262	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   84: iload 8
    //   86: istore 6
    //   88: aload_0
    //   89: aload_1
    //   90: invokespecial 605	com/tencent/wcdb/database/SQLiteConnection:d	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   93: iload 8
    //   95: istore 6
    //   97: aload_0
    //   98: aload_3
    //   99: invokespecial 266	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   102: aload_0
    //   103: getfield 174	com/tencent/wcdb/database/SQLiteConnection:p	J
    //   106: aload_1
    //   107: invokevirtual 177	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:a	()J
    //   110: invokestatic 752	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForChangedRowCount	(JJ)I
    //   113: istore 7
    //   115: iload 7
    //   117: istore 6
    //   119: aload_0
    //   120: aload_3
    //   121: invokespecial 291	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   124: iload 7
    //   126: istore 4
    //   128: iload 7
    //   130: istore 5
    //   132: aload_0
    //   133: aload_1
    //   134: invokevirtual 615	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   137: aload_0
    //   138: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   141: iload 9
    //   143: invokevirtual 617	com/tencent/wcdb/database/SQLiteConnection$OperationLog:b	(I)Z
    //   146: ifeq +41 -> 187
    //   149: aload_0
    //   150: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   153: astore_1
    //   154: new 232	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   161: astore_2
    //   162: aload_2
    //   163: ldc_w 754
    //   166: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_2
    //   171: iload 7
    //   173: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_1
    //   178: iload 9
    //   180: aload_2
    //   181: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokevirtual 633	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(ILjava/lang/String;)V
    //   187: iload 7
    //   189: ireturn
    //   190: astore_2
    //   191: iload 8
    //   193: istore 6
    //   195: aload_0
    //   196: aload_3
    //   197: invokespecial 291	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   200: iload 8
    //   202: istore 6
    //   204: aload_2
    //   205: athrow
    //   206: astore_2
    //   207: iload 6
    //   209: istore 4
    //   211: iload 6
    //   213: istore 5
    //   215: aload_0
    //   216: aload_1
    //   217: invokevirtual 615	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   220: iload 6
    //   222: istore 4
    //   224: iload 6
    //   226: istore 5
    //   228: aload_2
    //   229: athrow
    //   230: astore_1
    //   231: goto +24 -> 255
    //   234: astore_1
    //   235: iload 5
    //   237: istore 4
    //   239: aload_0
    //   240: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   243: iload 9
    //   245: aload_1
    //   246: invokevirtual 637	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(ILjava/lang/Exception;)V
    //   249: iload 5
    //   251: istore 4
    //   253: aload_1
    //   254: athrow
    //   255: aload_0
    //   256: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   259: iload 9
    //   261: invokevirtual 617	com/tencent/wcdb/database/SQLiteConnection$OperationLog:b	(I)Z
    //   264: ifeq +41 -> 305
    //   267: aload_0
    //   268: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   271: astore_2
    //   272: new 232	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   279: astore_3
    //   280: aload_3
    //   281: ldc_w 754
    //   284: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload_3
    //   289: iload 4
    //   291: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload_2
    //   296: iload 9
    //   298: aload_3
    //   299: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokevirtual 633	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(ILjava/lang/String;)V
    //   305: aload_1
    //   306: athrow
    //   307: new 639	java/lang/IllegalArgumentException
    //   310: dup
    //   311: ldc_w 644
    //   314: invokespecial 642	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   317: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	SQLiteConnection
    //   0	318	1	paramString	String
    //   0	318	2	paramArrayOfObject	Object[]
    //   0	318	3	paramCancellationSignal	CancellationSignal
    //   36	254	4	i1	int
    //   40	210	5	i2	int
    //   5	220	6	i3	int
    //   8	180	7	i4	int
    //   11	190	8	i5	int
    //   32	265	9	i6	int
    //   25	32	10	localOperation	SQLiteConnection.Operation
    // Exception table:
    //   from	to	target	type
    //   102	115	190	finally
    //   69	74	206	finally
    //   78	84	206	finally
    //   88	93	206	finally
    //   97	102	206	finally
    //   119	124	206	finally
    //   195	200	206	finally
    //   204	206	206	finally
    //   42	48	230	finally
    //   56	65	230	finally
    //   132	137	230	finally
    //   215	220	230	finally
    //   228	230	230	finally
    //   239	249	230	finally
    //   253	255	230	finally
    //   42	48	234	java/lang/RuntimeException
    //   56	65	234	java/lang/RuntimeException
    //   132	137	234	java/lang/RuntimeException
    //   215	220	234	java/lang/RuntimeException
    //   228	230	234	java/lang/RuntimeException
  }
  
  SQLiteConnection.PreparedStatement d(String paramString)
  {
    SQLiteConnection.PreparedStatement localPreparedStatement2 = (SQLiteConnection.PreparedStatement)this.i.a(paramString);
    int i1;
    if (localPreparedStatement2 != null)
    {
      if (!SQLiteConnection.PreparedStatement.d(localPreparedStatement2))
      {
        SQLiteConnection.PreparedStatement.a(localPreparedStatement2, true);
        return localPreparedStatement2;
      }
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    long l1 = nativePrepareStatement(this.p, paramString);
    SQLiteConnection.PreparedStatement localPreparedStatement1 = localPreparedStatement2;
    try
    {
      int i2 = nativeGetParameterCount(this.p, l1);
      localPreparedStatement1 = localPreparedStatement2;
      int i3 = DatabaseUtils.a(paramString);
      localPreparedStatement1 = localPreparedStatement2;
      localPreparedStatement2 = a(paramString, l1, i2, i3, nativeIsReadOnly(this.p, l1));
      if (i1 == 0)
      {
        localPreparedStatement1 = localPreparedStatement2;
        if (a(i3))
        {
          localPreparedStatement1 = localPreparedStatement2;
          this.i.a(paramString, localPreparedStatement2);
          localPreparedStatement1 = localPreparedStatement2;
          SQLiteConnection.PreparedStatement.b(localPreparedStatement2, true);
        }
      }
      SQLiteConnection.PreparedStatement.a(localPreparedStatement2, true);
      return localPreparedStatement2;
    }
    catch (RuntimeException paramString)
    {
      if ((localPreparedStatement1 == null) || (!SQLiteConnection.PreparedStatement.e(localPreparedStatement1))) {
        nativeFinalizeStatement(this.p, l1);
      }
      throw paramString;
    }
  }
  
  String d()
  {
    return this.k.a();
  }
  
  /* Error */
  public long e(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +139 -> 140
    //   4: aload_0
    //   5: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   8: ldc_w 776
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual 296	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/wcdb/database/SQLiteConnection$Operation;
    //   16: astore 7
    //   18: aload 7
    //   20: getfield 300	com/tencent/wcdb/database/SQLiteConnection$Operation:h	I
    //   23: istore 4
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 598	com/tencent/wcdb/database/SQLiteConnection:d	(Ljava/lang/String;)Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   30: astore_1
    //   31: aload 7
    //   33: aload_1
    //   34: invokestatic 600	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)I
    //   37: putfield 601	com/tencent/wcdb/database/SQLiteConnection$Operation:i	I
    //   40: aload_0
    //   41: aload_1
    //   42: invokespecial 603	com/tencent/wcdb/database/SQLiteConnection:c	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   45: aload_0
    //   46: aload_1
    //   47: aload_2
    //   48: invokespecial 262	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   51: aload_0
    //   52: aload_1
    //   53: invokespecial 605	com/tencent/wcdb/database/SQLiteConnection:d	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   56: aload_0
    //   57: aload_3
    //   58: invokespecial 266	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   61: aload_0
    //   62: getfield 174	com/tencent/wcdb/database/SQLiteConnection:p	J
    //   65: aload_1
    //   66: invokevirtual 177	com/tencent/wcdb/database/SQLiteConnection$PreparedStatement:a	()J
    //   69: invokestatic 778	com/tencent/wcdb/database/SQLiteConnection:nativeExecuteForLastInsertedRowId	(JJ)J
    //   72: lstore 5
    //   74: aload_0
    //   75: aload_3
    //   76: invokespecial 291	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   79: aload_0
    //   80: aload_1
    //   81: invokevirtual 615	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   84: aload_0
    //   85: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   88: iload 4
    //   90: invokevirtual 309	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(I)V
    //   93: lload 5
    //   95: lreturn
    //   96: astore_2
    //   97: aload_0
    //   98: aload_3
    //   99: invokespecial 291	com/tencent/wcdb/database/SQLiteConnection:b	(Lcom/tencent/wcdb/support/CancellationSignal;)V
    //   102: aload_2
    //   103: athrow
    //   104: astore_2
    //   105: aload_0
    //   106: aload_1
    //   107: invokevirtual 615	com/tencent/wcdb/database/SQLiteConnection:a	(Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;)V
    //   110: aload_2
    //   111: athrow
    //   112: astore_1
    //   113: goto +16 -> 129
    //   116: astore_1
    //   117: aload_0
    //   118: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   121: iload 4
    //   123: aload_1
    //   124: invokevirtual 637	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(ILjava/lang/Exception;)V
    //   127: aload_1
    //   128: athrow
    //   129: aload_0
    //   130: getfield 91	com/tencent/wcdb/database/SQLiteConnection:k	Lcom/tencent/wcdb/database/SQLiteConnection$OperationLog;
    //   133: iload 4
    //   135: invokevirtual 309	com/tencent/wcdb/database/SQLiteConnection$OperationLog:a	(I)V
    //   138: aload_1
    //   139: athrow
    //   140: new 639	java/lang/IllegalArgumentException
    //   143: dup
    //   144: ldc_w 644
    //   147: invokespecial 642	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	SQLiteConnection
    //   0	151	1	paramString	String
    //   0	151	2	paramArrayOfObject	Object[]
    //   0	151	3	paramCancellationSignal	CancellationSignal
    //   23	111	4	i1	int
    //   72	22	5	l1	long
    //   16	16	7	localOperation	SQLiteConnection.Operation
    // Exception table:
    //   from	to	target	type
    //   61	74	96	finally
    //   40	61	104	finally
    //   74	79	104	finally
    //   97	104	104	finally
    //   25	40	112	finally
    //   79	84	112	finally
    //   105	112	112	finally
    //   117	129	112	finally
    //   25	40	116	java/lang/RuntimeException
    //   79	84	116	java/lang/RuntimeException
    //   105	112	116	java/lang/RuntimeException
  }
  
  SQLiteTrace.TraceInfo<String> e()
  {
    return this.k.b();
  }
  
  SQLiteTrace.TraceInfo<StackTraceElement[]> f()
  {
    StackTraceElement[] arrayOfStackTraceElement = this.n;
    if (arrayOfStackTraceElement == null) {
      return null;
    }
    return new SQLiteTrace.TraceInfo(arrayOfStackTraceElement, this.o, this.m);
  }
  
  protected void finalize()
  {
    try
    {
      if ((this.d != null) && (this.p != 0L)) {
        this.d.a();
      }
      b(true);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SQLiteConnection: ");
    localStringBuilder.append(this.e.a);
    localStringBuilder.append(" (");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnection
 * JD-Core Version:    0.7.0.1
 */