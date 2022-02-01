package com.tencent.wcdb.database;

import android.os.SystemClock;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.OperationCanceledException;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public final class SQLiteConnectionPool
  implements Closeable
{
  private final WeakReference<SQLiteDatabase> b;
  private volatile SQLiteChangeListener c;
  private volatile SQLiteTrace d;
  private volatile SQLiteCheckpointListener e;
  private byte[] f;
  private SQLiteCipherSpec g;
  private final Object h = new Object();
  private final AtomicBoolean i = new AtomicBoolean();
  private final SQLiteDatabaseConfiguration j;
  private int k;
  private boolean l;
  private int m;
  private SQLiteConnectionPool.ConnectionWaiter n;
  private SQLiteConnectionPool.ConnectionWaiter o;
  private final ArrayList<SQLiteConnection> p = new ArrayList();
  private SQLiteConnection q;
  private final WeakHashMap<SQLiteConnection, SQLiteConnectionPool.AcquiredConnectionStatus> r = new WeakHashMap();
  
  private SQLiteConnectionPool(SQLiteDatabase paramSQLiteDatabase, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt)
  {
    this.b = new WeakReference(paramSQLiteDatabase);
    this.j = new SQLiteDatabaseConfiguration(paramSQLiteDatabaseConfiguration);
    c(paramInt);
  }
  
  private SQLiteConnection a(int paramInt)
  {
    Object localObject = this.q;
    if (localObject != null)
    {
      this.q = null;
      a((SQLiteConnection)localObject, paramInt);
      return localObject;
    }
    localObject = this.r.keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((SQLiteConnection)((Iterator)localObject).next()).b()) {
        return null;
      }
    }
    localObject = a(this.j, true);
    a((SQLiteConnection)localObject, paramInt);
    return localObject;
  }
  
  private SQLiteConnection a(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, boolean paramBoolean)
  {
    int i1 = this.m;
    this.m = (i1 + 1);
    return SQLiteConnection.a(this, paramSQLiteDatabaseConfiguration, i1, paramBoolean, this.f, this.g);
  }
  
  private SQLiteConnectionPool.ConnectionWaiter a(Thread paramThread, long paramLong, int paramInt1, boolean paramBoolean, String paramString, int paramInt2)
  {
    SQLiteConnectionPool.ConnectionWaiter localConnectionWaiter = this.n;
    if (localConnectionWaiter != null)
    {
      this.n = localConnectionWaiter.a;
      localConnectionWaiter.a = null;
    }
    else
    {
      localConnectionWaiter = new SQLiteConnectionPool.ConnectionWaiter(null);
    }
    localConnectionWaiter.b = paramThread;
    localConnectionWaiter.c = paramLong;
    localConnectionWaiter.d = paramInt1;
    localConnectionWaiter.e = paramBoolean;
    localConnectionWaiter.f = paramString;
    localConnectionWaiter.g = paramInt2;
    return localConnectionWaiter;
  }
  
  public static SQLiteConnectionPool a(SQLiteDatabase paramSQLiteDatabase, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt)
  {
    if (paramSQLiteDatabaseConfiguration != null)
    {
      paramSQLiteDatabaseConfiguration = new SQLiteConnectionPool(paramSQLiteDatabase, paramSQLiteDatabaseConfiguration, paramInt);
      paramSQLiteDatabaseConfiguration.f = paramArrayOfByte;
      if (paramSQLiteCipherSpec == null) {
        paramSQLiteDatabase = null;
      } else {
        paramSQLiteDatabase = new SQLiteCipherSpec(paramSQLiteCipherSpec);
      }
      paramSQLiteDatabaseConfiguration.g = paramSQLiteDatabase;
      paramSQLiteDatabaseConfiguration.c();
      return paramSQLiteDatabaseConfiguration;
    }
    throw new IllegalArgumentException("configuration must not be null.");
  }
  
  private void a(SQLiteConnection paramSQLiteConnection, int paramInt)
  {
    boolean bool;
    if ((paramInt & 0x1) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    try
    {
      paramSQLiteConnection.a(bool);
      this.r.put(paramSQLiteConnection, SQLiteConnectionPool.AcquiredConnectionStatus.NORMAL);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to prepare acquired connection for session, closing it: ");
      localStringBuilder.append(paramSQLiteConnection);
      localStringBuilder.append(", connectionFlags=");
      localStringBuilder.append(paramInt);
      Log.a("WCDB.SQLiteConnectionPool", localStringBuilder.toString());
      b(paramSQLiteConnection);
      throw localRuntimeException;
    }
  }
  
  private void a(SQLiteConnectionPool.AcquiredConnectionStatus paramAcquiredConnectionStatus)
  {
    if (!this.r.isEmpty())
    {
      ArrayList localArrayList = new ArrayList(this.r.size());
      Iterator localIterator = this.r.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        SQLiteConnectionPool.AcquiredConnectionStatus localAcquiredConnectionStatus = (SQLiteConnectionPool.AcquiredConnectionStatus)localEntry.getValue();
        if ((paramAcquiredConnectionStatus != localAcquiredConnectionStatus) && (localAcquiredConnectionStatus != SQLiteConnectionPool.AcquiredConnectionStatus.DISCARD)) {
          localArrayList.add(localEntry.getKey());
        }
      }
      int i2 = localArrayList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        this.r.put(localArrayList.get(i1), paramAcquiredConnectionStatus);
        i1 += 1;
      }
    }
  }
  
  private void a(SQLiteConnectionPool.ConnectionPoolBusyInfo paramConnectionPoolBusyInfo, long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if (paramLong != 0L)
    {
      localObject = Thread.currentThread();
      localStringBuilder.append("The connection pool for database '");
      localStringBuilder.append(paramConnectionPoolBusyInfo.a);
      localStringBuilder.append("' has been unable to grant a connection to thread ");
      localStringBuilder.append(((Thread)localObject).getId());
      localStringBuilder.append(" (");
      localStringBuilder.append(((Thread)localObject).getName());
      localStringBuilder.append(") ");
      localStringBuilder.append("with flags 0x");
      localStringBuilder.append(Integer.toHexString(paramInt));
      localStringBuilder.append(" for ");
      localStringBuilder.append((float)paramLong * 0.001F);
      localStringBuilder.append(" seconds.\n");
    }
    localStringBuilder.append("Connections: ");
    localStringBuilder.append(paramConnectionPoolBusyInfo.c);
    localStringBuilder.append(" active, ");
    localStringBuilder.append(paramConnectionPoolBusyInfo.d);
    localStringBuilder.append(" idle, ");
    localStringBuilder.append(paramConnectionPoolBusyInfo.e);
    localStringBuilder.append(" available.\n");
    if (!paramConnectionPoolBusyInfo.b.isEmpty())
    {
      localStringBuilder.append("\nRequests in progress:\n");
      paramConnectionPoolBusyInfo = paramConnectionPoolBusyInfo.b.iterator();
      while (paramConnectionPoolBusyInfo.hasNext())
      {
        localObject = (String)paramConnectionPoolBusyInfo.next();
        localStringBuilder.append("  ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("\n");
      }
    }
    Log.b("WCDB.SQLiteConnectionPool", localStringBuilder.toString());
  }
  
  private void a(SQLiteConnectionPool.ConnectionWaiter paramConnectionWaiter)
  {
    if (paramConnectionWaiter.h == null)
    {
      if (paramConnectionWaiter.i != null) {
        return;
      }
      Object localObject2 = null;
      SQLiteConnectionPool.ConnectionWaiter localConnectionWaiter;
      for (Object localObject1 = this.o; localObject1 != paramConnectionWaiter; localObject1 = localConnectionWaiter)
      {
        if ((!a) && (localObject1 == null)) {
          throw new AssertionError();
        }
        localConnectionWaiter = ((SQLiteConnectionPool.ConnectionWaiter)localObject1).a;
        localObject2 = localObject1;
      }
      if (localObject2 != null) {
        localObject2.a = paramConnectionWaiter.a;
      } else {
        this.o = paramConnectionWaiter.a;
      }
      paramConnectionWaiter.i = new OperationCanceledException();
      LockSupport.unpark(paramConnectionWaiter.b);
      j();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      synchronized (this.h)
      {
        k();
        this.l = false;
        d();
        int i1 = this.r.size();
        if (i1 != 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("The connection pool for ");
          localStringBuilder.append(this.j.b);
          localStringBuilder.append(" has been closed but there are still ");
          localStringBuilder.append(i1);
          localStringBuilder.append(" connections in use.  They will be closed as they are released back to the pool.");
          Log.c("WCDB.SQLiteConnectionPool", localStringBuilder.toString());
        }
        j();
        return;
      }
    }
  }
  
  private boolean a(SQLiteConnection paramSQLiteConnection, SQLiteConnectionPool.AcquiredConnectionStatus paramAcquiredConnectionStatus)
  {
    Object localObject = paramAcquiredConnectionStatus;
    if (paramAcquiredConnectionStatus == SQLiteConnectionPool.AcquiredConnectionStatus.RECONFIGURE) {
      try
      {
        paramSQLiteConnection.a(this.j);
        localObject = paramAcquiredConnectionStatus;
      }
      catch (RuntimeException paramAcquiredConnectionStatus)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to reconfigure released connection, closing it: ");
        ((StringBuilder)localObject).append(paramSQLiteConnection);
        Log.a("WCDB.SQLiteConnectionPool", ((StringBuilder)localObject).toString(), new Object[] { paramAcquiredConnectionStatus });
        localObject = SQLiteConnectionPool.AcquiredConnectionStatus.DISCARD;
      }
    }
    if (localObject == SQLiteConnectionPool.AcquiredConnectionStatus.DISCARD)
    {
      b(paramSQLiteConnection);
      return false;
    }
    return true;
  }
  
  private static int b(int paramInt)
  {
    if ((paramInt & 0x4) != 0) {
      return 1;
    }
    return 0;
  }
  
  private SQLiteConnection b(String paramString, int paramInt)
  {
    int i2 = this.p.size();
    if ((i2 > 1) && (paramString != null))
    {
      i1 = 0;
      while (i1 < i2)
      {
        SQLiteConnection localSQLiteConnection = (SQLiteConnection)this.p.get(i1);
        if (localSQLiteConnection.b(paramString))
        {
          this.p.remove(i1);
          a(localSQLiteConnection, paramInt);
          return localSQLiteConnection;
        }
        i1 += 1;
      }
    }
    if (i2 > 0)
    {
      paramString = (SQLiteConnection)this.p.remove(i2 - 1);
      a(paramString, paramInt);
      return paramString;
    }
    i2 = this.r.size();
    int i1 = i2;
    if (this.q != null) {
      i1 = i2 + 1;
    }
    if (i1 >= this.k) {
      return null;
    }
    paramString = a(this.j, false);
    a(paramString, paramInt);
    return paramString;
  }
  
  /* Error */
  private SQLiteConnection b(String paramString, int paramInt, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: iload_2
    //   1: iconst_2
    //   2: iand
    //   3: ifeq +9 -> 12
    //   6: iconst_1
    //   7: istore 5
    //   9: goto +6 -> 15
    //   12: iconst_0
    //   13: istore 5
    //   15: aload_0
    //   16: getfield 59	com/tencent/wcdb/database/SQLiteConnectionPool:h	Ljava/lang/Object;
    //   19: astore 20
    //   21: aload 20
    //   23: monitorenter
    //   24: aload_0
    //   25: invokespecial 353	com/tencent/wcdb/database/SQLiteConnectionPool:k	()V
    //   28: aload_3
    //   29: ifnull +7 -> 36
    //   32: aload_3
    //   33: invokevirtual 393	com/tencent/wcdb/support/CancellationSignal:b	()V
    //   36: aconst_null
    //   37: astore 17
    //   39: aconst_null
    //   40: astore 16
    //   42: iload 5
    //   44: ifne +593 -> 637
    //   47: aload_0
    //   48: aload_1
    //   49: iload_2
    //   50: invokespecial 395	com/tencent/wcdb/database/SQLiteConnectionPool:b	(Ljava/lang/String;I)Lcom/tencent/wcdb/database/SQLiteConnection;
    //   53: astore 14
    //   55: goto +3 -> 58
    //   58: aload 14
    //   60: astore 15
    //   62: aload 14
    //   64: ifnonnull +10 -> 74
    //   67: aload_0
    //   68: iload_2
    //   69: invokespecial 397	com/tencent/wcdb/database/SQLiteConnectionPool:a	(I)Lcom/tencent/wcdb/database/SQLiteConnection;
    //   72: astore 15
    //   74: aload 15
    //   76: ifnull +9 -> 85
    //   79: aload 20
    //   81: monitorexit
    //   82: aload 15
    //   84: areturn
    //   85: iload_2
    //   86: invokestatic 399	com/tencent/wcdb/database/SQLiteConnectionPool:b	(I)I
    //   89: istore 4
    //   91: invokestatic 404	android/os/SystemClock:uptimeMillis	()J
    //   94: lstore 6
    //   96: aload_0
    //   97: invokestatic 261	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   100: lload 6
    //   102: iload 4
    //   104: iload 5
    //   106: aload_1
    //   107: iload_2
    //   108: invokespecial 406	com/tencent/wcdb/database/SQLiteConnectionPool:a	(Ljava/lang/Thread;JIZLjava/lang/String;I)Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;
    //   111: astore 19
    //   113: aload_0
    //   114: getfield 334	com/tencent/wcdb/database/SQLiteConnectionPool:o	Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;
    //   117: astore 14
    //   119: aconst_null
    //   120: astore 15
    //   122: aload 14
    //   124: ifnull +41 -> 165
    //   127: iload 4
    //   129: aload 14
    //   131: getfield 150	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:d	I
    //   134: if_icmple +13 -> 147
    //   137: aload 19
    //   139: aload 14
    //   141: putfield 139	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:a	Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;
    //   144: goto +21 -> 165
    //   147: aload 14
    //   149: getfield 139	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:a	Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;
    //   152: astore 18
    //   154: aload 14
    //   156: astore 15
    //   158: aload 18
    //   160: astore 14
    //   162: goto -40 -> 122
    //   165: aload 15
    //   167: ifnull +13 -> 180
    //   170: aload 15
    //   172: aload 19
    //   174: putfield 139	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:a	Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;
    //   177: goto +9 -> 186
    //   180: aload_0
    //   181: aload 19
    //   183: putfield 334	com/tencent/wcdb/database/SQLiteConnectionPool:o	Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;
    //   186: aload 19
    //   188: getfield 408	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:j	I
    //   191: istore 4
    //   193: aload 20
    //   195: monitorexit
    //   196: aload_3
    //   197: ifnull +19 -> 216
    //   200: aload_3
    //   201: new 410	com/tencent/wcdb/database/SQLiteConnectionPool$1
    //   204: dup
    //   205: aload_0
    //   206: aload 19
    //   208: iload 4
    //   210: invokespecial 413	com/tencent/wcdb/database/SQLiteConnectionPool$1:<init>	(Lcom/tencent/wcdb/database/SQLiteConnectionPool;Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;I)V
    //   213: invokevirtual 416	com/tencent/wcdb/support/CancellationSignal:a	(Lcom/tencent/wcdb/support/CancellationSignal$OnCancelListener;)V
    //   216: aload 17
    //   218: astore 15
    //   220: aload 19
    //   222: getfield 148	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:c	J
    //   225: ldc2_w 417
    //   228: ladd
    //   229: lstore 6
    //   231: ldc2_w 417
    //   234: lstore 8
    //   236: aload 16
    //   238: astore 14
    //   240: aload 14
    //   242: astore 15
    //   244: aload_0
    //   245: getfield 64	com/tencent/wcdb/database/SQLiteConnectionPool:i	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   248: iconst_1
    //   249: iconst_0
    //   250: invokevirtual 422	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   253: ifeq +40 -> 293
    //   256: aload 14
    //   258: astore 15
    //   260: aload_0
    //   261: getfield 59	com/tencent/wcdb/database/SQLiteConnectionPool:h	Ljava/lang/Object;
    //   264: astore 16
    //   266: aload 14
    //   268: astore 15
    //   270: aload 16
    //   272: monitorenter
    //   273: aload_0
    //   274: invokespecial 348	com/tencent/wcdb/database/SQLiteConnectionPool:j	()V
    //   277: aload 16
    //   279: monitorexit
    //   280: goto +13 -> 293
    //   283: astore_1
    //   284: aload 16
    //   286: monitorexit
    //   287: aload 14
    //   289: astore 15
    //   291: aload_1
    //   292: athrow
    //   293: aload 14
    //   295: astore 15
    //   297: lload 8
    //   299: ldc2_w 423
    //   302: lmul
    //   303: invokestatic 428	java/util/concurrent/locks/LockSupport:parkNanos	(J)V
    //   306: aload 14
    //   308: astore 15
    //   310: invokestatic 431	java/lang/Thread:interrupted	()Z
    //   313: pop
    //   314: aload 14
    //   316: astore 15
    //   318: aload_0
    //   319: getfield 59	com/tencent/wcdb/database/SQLiteConnectionPool:h	Ljava/lang/Object;
    //   322: astore 17
    //   324: aload 14
    //   326: astore 15
    //   328: aload 17
    //   330: monitorenter
    //   331: aload_0
    //   332: invokespecial 353	com/tencent/wcdb/database/SQLiteConnectionPool:k	()V
    //   335: aload 19
    //   337: getfield 329	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:h	Lcom/tencent/wcdb/database/SQLiteConnection;
    //   340: astore 15
    //   342: aload 19
    //   344: getfield 332	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:i	Ljava/lang/RuntimeException;
    //   347: astore 16
    //   349: aload 15
    //   351: ifnonnull +194 -> 545
    //   354: aload 16
    //   356: ifnull +6 -> 362
    //   359: goto +186 -> 545
    //   362: invokestatic 404	android/os/SystemClock:uptimeMillis	()J
    //   365: lstore 12
    //   367: lload 12
    //   369: lload 6
    //   371: lcmp
    //   372: ifge +25 -> 397
    //   375: lload 6
    //   377: lstore 10
    //   379: aload 14
    //   381: astore 16
    //   383: lload 12
    //   385: lload 6
    //   387: lsub
    //   388: lstore 8
    //   390: lload 10
    //   392: lstore 6
    //   394: goto +22 -> 416
    //   397: aload_0
    //   398: invokespecial 434	com/tencent/wcdb/database/SQLiteConnectionPool:i	()Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionPoolBusyInfo;
    //   401: astore 16
    //   403: lload 12
    //   405: ldc2_w 417
    //   408: ladd
    //   409: lstore 6
    //   411: ldc2_w 417
    //   414: lstore 8
    //   416: aload 17
    //   418: monitorexit
    //   419: aload 16
    //   421: ifnull +121 -> 542
    //   424: aload 14
    //   426: astore 15
    //   428: lload 12
    //   430: aload 19
    //   432: getfield 148	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter:c	J
    //   435: lsub
    //   436: lstore 10
    //   438: aload 14
    //   440: astore 15
    //   442: aload_0
    //   443: aload 16
    //   445: lload 10
    //   447: iload_2
    //   448: invokespecial 436	com/tencent/wcdb/database/SQLiteConnectionPool:a	(Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionPoolBusyInfo;JI)V
    //   451: aload 14
    //   453: astore 15
    //   455: aload_0
    //   456: getfield 81	com/tencent/wcdb/database/SQLiteConnectionPool:b	Ljava/lang/ref/WeakReference;
    //   459: invokevirtual 438	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   462: checkcast 440	com/tencent/wcdb/database/SQLiteDatabase
    //   465: astore 17
    //   467: aload 14
    //   469: astore 15
    //   471: aload_0
    //   472: getfield 442	com/tencent/wcdb/database/SQLiteConnectionPool:d	Lcom/tencent/wcdb/database/SQLiteTrace;
    //   475: astore 18
    //   477: aload 17
    //   479: ifnull +63 -> 542
    //   482: aload 18
    //   484: ifnull +58 -> 542
    //   487: aload 14
    //   489: astore 15
    //   491: aload 16
    //   493: getfield 444	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionPoolBusyInfo:f	Ljava/util/ArrayList;
    //   496: astore 20
    //   498: aload 14
    //   500: astore 15
    //   502: aload 16
    //   504: getfield 446	com/tencent/wcdb/database/SQLiteConnectionPool$ConnectionPoolBusyInfo:g	Ljava/util/ArrayList;
    //   507: astore 16
    //   509: aload 18
    //   511: aload 17
    //   513: aload_1
    //   514: lload 10
    //   516: iload 5
    //   518: aload 20
    //   520: aload 16
    //   522: invokeinterface 451 8 0
    //   527: goto +15 -> 542
    //   530: astore 15
    //   532: aload 14
    //   534: astore_1
    //   535: aload 15
    //   537: astore 14
    //   539: goto +74 -> 613
    //   542: goto -302 -> 240
    //   545: aload 14
    //   547: astore_1
    //   548: aload_1
    //   549: astore 14
    //   551: aload_0
    //   552: aload 19
    //   554: invokespecial 453	com/tencent/wcdb/database/SQLiteConnectionPool:b	(Lcom/tencent/wcdb/database/SQLiteConnectionPool$ConnectionWaiter;)V
    //   557: aload 15
    //   559: ifnull +21 -> 580
    //   562: aload_1
    //   563: astore 14
    //   565: aload 17
    //   567: monitorexit
    //   568: aload_3
    //   569: ifnull +8 -> 577
    //   572: aload_3
    //   573: aload_1
    //   574: invokevirtual 416	com/tencent/wcdb/support/CancellationSignal:a	(Lcom/tencent/wcdb/support/CancellationSignal$OnCancelListener;)V
    //   577: aload 15
    //   579: areturn
    //   580: aload_1
    //   581: astore 14
    //   583: aload 16
    //   585: athrow
    //   586: aload_1
    //   587: astore 14
    //   589: aload 17
    //   591: monitorexit
    //   592: aload 15
    //   594: athrow
    //   595: astore 14
    //   597: goto +16 -> 613
    //   600: astore 15
    //   602: aload 14
    //   604: astore_1
    //   605: goto -19 -> 586
    //   608: astore 14
    //   610: aload 15
    //   612: astore_1
    //   613: aload_3
    //   614: ifnull +8 -> 622
    //   617: aload_3
    //   618: aload_1
    //   619: invokevirtual 416	com/tencent/wcdb/support/CancellationSignal:a	(Lcom/tencent/wcdb/support/CancellationSignal$OnCancelListener;)V
    //   622: aload 14
    //   624: athrow
    //   625: astore_1
    //   626: aload 20
    //   628: monitorexit
    //   629: goto +5 -> 634
    //   632: aload_1
    //   633: athrow
    //   634: goto -2 -> 632
    //   637: aconst_null
    //   638: astore 14
    //   640: goto -582 -> 58
    //   643: astore 15
    //   645: aload 14
    //   647: astore_1
    //   648: goto -62 -> 586
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	651	0	this	SQLiteConnectionPool
    //   0	651	1	paramString	String
    //   0	651	2	paramInt	int
    //   0	651	3	paramCancellationSignal	CancellationSignal
    //   89	120	4	i1	int
    //   7	510	5	bool	boolean
    //   94	316	6	l1	long
    //   234	181	8	l2	long
    //   377	138	10	l3	long
    //   365	64	12	l4	long
    //   53	535	14	localObject1	Object
    //   595	8	14	localObject2	Object
    //   608	15	14	localObject3	Object
    //   638	8	14	localObject4	Object
    //   60	441	15	localObject5	Object
    //   530	63	15	localSQLiteConnection	SQLiteConnection
    //   600	11	15	localObject6	Object
    //   643	1	15	localObject7	Object
    //   40	544	16	localObject8	Object
    //   37	553	17	localObject9	Object
    //   152	358	18	localObject10	Object
    //   111	442	19	localConnectionWaiter	SQLiteConnectionPool.ConnectionWaiter
    //   19	608	20	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   273	280	283	finally
    //   284	287	283	finally
    //   509	527	530	finally
    //   592	595	595	finally
    //   551	557	600	finally
    //   565	568	600	finally
    //   583	586	600	finally
    //   589	592	600	finally
    //   220	231	608	finally
    //   244	256	608	finally
    //   260	266	608	finally
    //   270	273	608	finally
    //   291	293	608	finally
    //   297	306	608	finally
    //   310	314	608	finally
    //   318	324	608	finally
    //   328	331	608	finally
    //   428	438	608	finally
    //   442	451	608	finally
    //   455	467	608	finally
    //   471	477	608	finally
    //   491	498	608	finally
    //   502	509	608	finally
    //   24	28	625	finally
    //   32	36	625	finally
    //   47	55	625	finally
    //   67	74	625	finally
    //   79	82	625	finally
    //   85	119	625	finally
    //   127	144	625	finally
    //   147	154	625	finally
    //   170	177	625	finally
    //   180	186	625	finally
    //   186	196	625	finally
    //   626	629	625	finally
    //   331	349	643	finally
    //   362	367	643	finally
    //   397	403	643	finally
    //   416	419	643	finally
  }
  
  private void b(SQLiteConnection paramSQLiteConnection)
  {
    try
    {
      paramSQLiteConnection.a();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to close connection, its fate is now in the hands of the merciful GC: ");
      localStringBuilder.append(paramSQLiteConnection);
      localStringBuilder.append(localRuntimeException.getMessage());
      Log.a("WCDB.SQLiteConnectionPool", localStringBuilder.toString());
    }
  }
  
  private void b(SQLiteConnectionPool.ConnectionWaiter paramConnectionWaiter)
  {
    paramConnectionWaiter.a = this.n;
    paramConnectionWaiter.b = null;
    paramConnectionWaiter.f = null;
    paramConnectionWaiter.h = null;
    paramConnectionWaiter.i = null;
    paramConnectionWaiter.j += 1;
    this.n = paramConnectionWaiter;
  }
  
  private void c()
  {
    this.q = a(this.j, true);
    this.l = true;
  }
  
  private void c(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt <= 0) {
      if ((this.j.d & 0x20000000) != 0) {
        i1 = 4;
      } else {
        i1 = 1;
      }
    }
    this.k = i1;
    Log.c("WCDB.SQLiteConnectionPool", "Max connection pool size is %d.", new Object[] { Integer.valueOf(this.k) });
  }
  
  private void d()
  {
    e();
    SQLiteConnection localSQLiteConnection = this.q;
    if (localSQLiteConnection != null)
    {
      b(localSQLiteConnection);
      this.q = null;
    }
  }
  
  private void e()
  {
    int i2 = this.p.size();
    int i1 = 0;
    while (i1 < i2)
    {
      b((SQLiteConnection)this.p.get(i1));
      i1 += 1;
    }
    this.p.clear();
  }
  
  private void f()
  {
    int i2;
    for (int i1 = this.p.size();; i1 = i2)
    {
      i2 = i1 - 1;
      if (i1 <= this.k - 1) {
        break;
      }
      b((SQLiteConnection)this.p.remove(i2));
    }
  }
  
  private void g()
  {
    a(SQLiteConnectionPool.AcquiredConnectionStatus.DISCARD);
  }
  
  private void h()
  {
    SQLiteConnection localSQLiteConnection1 = this.q;
    if (localSQLiteConnection1 != null) {
      try
      {
        localSQLiteConnection1.a(this.j);
      }
      catch (RuntimeException localRuntimeException1)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("Failed to reconfigure available primary connection, closing it: ");
        localStringBuilder1.append(this.q);
        Log.a("WCDB.SQLiteConnectionPool", localStringBuilder1.toString(), new Object[] { localRuntimeException1 });
        b(this.q);
        this.q = null;
      }
    }
    int i2 = this.p.size();
    int i1 = 0;
    while (i1 < i2)
    {
      SQLiteConnection localSQLiteConnection2 = (SQLiteConnection)this.p.get(i1);
      try
      {
        localSQLiteConnection2.a(this.j);
      }
      catch (RuntimeException localRuntimeException2)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("Failed to reconfigure available non-primary connection, closing it: ");
        localStringBuilder2.append(localSQLiteConnection2);
        Log.a("WCDB.SQLiteConnectionPool", localStringBuilder2.toString(), new Object[] { localRuntimeException2 });
        b(localSQLiteConnection2);
        this.p.remove(i1);
        i2 -= 1;
        i1 -= 1;
      }
      i1 += 1;
    }
    a(SQLiteConnectionPool.AcquiredConnectionStatus.RECONFIGURE);
  }
  
  private SQLiteConnectionPool.ConnectionPoolBusyInfo i()
  {
    SQLiteConnectionPool.ConnectionPoolBusyInfo localConnectionPoolBusyInfo = new SQLiteConnectionPool.ConnectionPoolBusyInfo(null);
    localConnectionPoolBusyInfo.c = 0;
    localConnectionPoolBusyInfo.d = 0;
    if (!this.r.isEmpty())
    {
      Iterator localIterator = this.r.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (SQLiteConnection)localIterator.next();
        SQLiteTrace.TraceInfo localTraceInfo = ((SQLiteConnection)localObject).f();
        if (localTraceInfo != null) {
          localConnectionPoolBusyInfo.g.add(localTraceInfo);
        }
        localTraceInfo = ((SQLiteConnection)localObject).e();
        if (localTraceInfo != null)
        {
          localConnectionPoolBusyInfo.f.add(localTraceInfo);
          localObject = ((SQLiteConnection)localObject).d();
          if (localObject != null) {
            localConnectionPoolBusyInfo.b.add(localObject);
          }
          localConnectionPoolBusyInfo.c += 1;
        }
        else
        {
          localConnectionPoolBusyInfo.d += 1;
        }
      }
    }
    localConnectionPoolBusyInfo.e = this.p.size();
    if (this.q != null) {
      localConnectionPoolBusyInfo.e += 1;
    }
    return localConnectionPoolBusyInfo;
  }
  
  private void j()
  {
    Object localObject1 = this.o;
    Object localObject3 = null;
    int i2 = 0;
    int i1 = 0;
    int i6;
    int i3;
    int i4;
    int i5;
    if (localObject1 != null)
    {
      boolean bool = this.l;
      i6 = 1;
      if (!bool)
      {
        i3 = i6;
      }
      else
      {
        i4 = i2;
        i5 = i1;
      }
    }
    for (;;)
    {
      try
      {
        if ((((SQLiteConnectionPool.ConnectionWaiter)localObject1).e) || (i2 != 0)) {
          break label276;
        }
        i4 = i2;
        i5 = i1;
        Object localObject4 = b(((SQLiteConnectionPool.ConnectionWaiter)localObject1).f, ((SQLiteConnectionPool.ConnectionWaiter)localObject1).g);
        Object localObject2 = localObject4;
        if (localObject4 == null)
        {
          i2 = 1;
          localObject2 = localObject4;
        }
        i3 = i1;
        localObject4 = localObject2;
        if (localObject2 == null)
        {
          i3 = i1;
          localObject4 = localObject2;
          if (i1 == 0)
          {
            i4 = i2;
            i5 = i1;
            localObject2 = a(((SQLiteConnectionPool.ConnectionWaiter)localObject1).g);
            i3 = i1;
            localObject4 = localObject2;
            if (localObject2 == null)
            {
              i3 = 1;
              localObject4 = localObject2;
            }
          }
        }
        if (localObject4 != null)
        {
          i4 = i2;
          i5 = i3;
          ((SQLiteConnectionPool.ConnectionWaiter)localObject1).h = ((SQLiteConnection)localObject4);
          i1 = i3;
          i3 = i6;
        }
        else
        {
          if ((i2 != 0) && (i3 != 0)) {
            return;
          }
          i4 = 0;
          i1 = i3;
          i3 = i4;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        ((SQLiteConnectionPool.ConnectionWaiter)localObject1).i = localRuntimeException;
        i3 = i6;
        i1 = i5;
        i2 = i4;
      }
      SQLiteConnectionPool.ConnectionWaiter localConnectionWaiter = ((SQLiteConnectionPool.ConnectionWaiter)localObject1).a;
      if (i3 != 0)
      {
        if (localObject3 != null) {
          localObject3.a = localConnectionWaiter;
        } else {
          this.o = localConnectionWaiter;
        }
        ((SQLiteConnectionPool.ConnectionWaiter)localObject1).a = null;
        LockSupport.unpark(((SQLiteConnectionPool.ConnectionWaiter)localObject1).b);
      }
      else
      {
        localObject3 = localObject1;
      }
      localObject1 = localConnectionWaiter;
      break;
      return;
      label276:
      localConnectionWaiter = null;
    }
  }
  
  private void k()
  {
    if (this.l) {
      return;
    }
    throw new IllegalStateException("Cannot perform this operation because the connection pool has been closed.");
  }
  
  public SQLiteConnection a(String paramString, int paramInt, CancellationSignal paramCancellationSignal)
  {
    long l1 = SystemClock.uptimeMillis();
    paramCancellationSignal = b(paramString, paramInt, paramCancellationSignal);
    SQLiteTrace localSQLiteTrace = this.d;
    if (localSQLiteTrace != null)
    {
      long l2 = SystemClock.uptimeMillis();
      SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)this.b.get();
      if (localSQLiteDatabase != null)
      {
        boolean bool;
        if ((paramInt & 0x2) != 0) {
          bool = true;
        } else {
          bool = false;
        }
        localSQLiteTrace.a(localSQLiteDatabase, paramString, l2 - l1, bool);
      }
    }
    return paramCancellationSignal;
  }
  
  void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("A SQLiteConnection object for database '");
    localStringBuilder.append(this.j.b);
    localStringBuilder.append("' was leaked!  Please fix your application to end transactions in progress properly and to close the database when it is no longer needed.");
    Log.b("WCDB.SQLiteConnectionPool", localStringBuilder.toString());
    this.i.set(true);
  }
  
  public void a(SQLiteConnection paramSQLiteConnection)
  {
    synchronized (this.h)
    {
      SQLiteConnectionPool.AcquiredConnectionStatus localAcquiredConnectionStatus = (SQLiteConnectionPool.AcquiredConnectionStatus)this.r.remove(paramSQLiteConnection);
      if (localAcquiredConnectionStatus != null)
      {
        if (!this.l)
        {
          b(paramSQLiteConnection);
        }
        else if (paramSQLiteConnection.b())
        {
          if (a(paramSQLiteConnection, localAcquiredConnectionStatus))
          {
            if ((!a) && (this.q != null)) {
              throw new AssertionError();
            }
            this.q = paramSQLiteConnection;
          }
          j();
        }
        else if (this.p.size() >= this.k - 1)
        {
          b(paramSQLiteConnection);
        }
        else
        {
          if (a(paramSQLiteConnection, localAcquiredConnectionStatus)) {
            this.p.add(paramSQLiteConnection);
          }
          j();
        }
        return;
      }
      throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
    }
  }
  
  public void a(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    if (paramSQLiteDatabaseConfiguration != null) {}
    for (;;)
    {
      synchronized (this.h)
      {
        k();
        if (((paramSQLiteDatabaseConfiguration.d ^ this.j.d) & 0x20000000) == 0) {
          break label267;
        }
        i1 = 1;
        if (i1 != 0) {
          if (this.r.isEmpty()) {
            e();
          } else {
            throw new IllegalStateException("Write Ahead Logging (WAL) mode cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
          }
        }
        if (paramSQLiteDatabaseConfiguration.g == this.j.g) {
          break label272;
        }
        i2 = 1;
        if ((i2 != 0) && (!this.r.isEmpty())) {
          throw new IllegalStateException("Foreign Key Constraints cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
        }
        if ((((this.j.d ^ paramSQLiteDatabaseConfiguration.d) & 0x10000011) == 0) && (DatabaseUtils.a(this.j.c, paramSQLiteDatabaseConfiguration.c)) && (paramSQLiteDatabaseConfiguration.l.containsAll(this.j.l)))
        {
          this.j.a(paramSQLiteDatabaseConfiguration);
          c(0);
          f();
          h();
        }
        else
        {
          if (i1 != 0) {
            d();
          }
          SQLiteConnection localSQLiteConnection = a(paramSQLiteDatabaseConfiguration, true);
          d();
          g();
          this.q = localSQLiteConnection;
          this.j.a(paramSQLiteDatabaseConfiguration);
          c(0);
        }
        j();
        return;
      }
      throw new IllegalArgumentException("configuration must not be null.");
      label267:
      int i1 = 0;
      continue;
      label272:
      int i2 = 0;
    }
  }
  
  void a(String paramString, int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)this.b.get();
    SQLiteCheckpointListener localSQLiteCheckpointListener = this.e;
    if (localSQLiteCheckpointListener != null)
    {
      if (localSQLiteDatabase == null) {
        return;
      }
      localSQLiteCheckpointListener.a(localSQLiteDatabase, paramString, paramInt);
    }
  }
  
  void a(String paramString, int paramInt, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)this.b.get();
    SQLiteTrace localSQLiteTrace = this.d;
    if (localSQLiteTrace != null)
    {
      if (localSQLiteDatabase == null) {
        return;
      }
      localSQLiteTrace.a(localSQLiteDatabase, paramString, paramInt, paramLong);
    }
  }
  
  void a(String paramString1, String paramString2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)this.b.get();
    SQLiteChangeListener localSQLiteChangeListener = this.c;
    if (localSQLiteChangeListener != null)
    {
      if (localSQLiteDatabase == null) {
        return;
      }
      localSQLiteChangeListener.a(localSQLiteDatabase, paramString1, paramString2, paramArrayOfLong1, paramArrayOfLong2, paramArrayOfLong3);
    }
  }
  
  SQLiteTrace b()
  {
    return this.d;
  }
  
  public void close()
  {
    a(false);
  }
  
  protected void finalize()
  {
    try
    {
      a(true);
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
    localStringBuilder.append("SQLiteConnectionPool: ");
    localStringBuilder.append(this.j.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnectionPool
 * JD-Core Version:    0.7.0.1
 */