package com.tencent.mobileqq.persistence;

import com.tencent.imcore.message.core.MsgLock;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.db.DBThreadMonitor;
import com.tencent.mobileqq.imcore.proxy.db.ThreadTraceHelperProxy;
import com.tencent.util.VersionUtils;
import java.util.concurrent.locks.Lock;

public class EntityTransaction
{
  private static final Lock lock = new MsgLock("EntityTransaction");
  private SQLiteDatabase db;
  private final SQLiteOpenHelper dbHelper;
  private DBThreadMonitor mDBThreadMonitor = new DBThreadMonitor("EntityTransaction");
  
  EntityTransaction(SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    this.dbHelper = paramSQLiteOpenHelper;
  }
  
  public void begin()
  {
    Thread localThread = Thread.currentThread();
    ThreadTraceHelperProxy.addWaitingTransThread(localThread.getId(), localThread.getName());
    lock.lock();
    this.mDBThreadMonitor.a();
    this.db = this.dbHelper.getWritableDatabase();
    if ((SQLiteOpenHelper.WAL_ENABLE) && (VersionUtils.e())) {
      this.db.beginTransactionNonExclusive();
    }
    for (;;)
    {
      ThreadTraceHelperProxy.removeWaitingTransThread(localThread.getId());
      ThreadTraceHelperProxy.setCurrentTransThread(localThread.getId(), localThread.getName());
      return;
      this.db.beginTransaction();
    }
  }
  
  public void commit()
  {
    this.db.setTransactionSuccessful();
  }
  
  /* Error */
  public void end()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 71	com/tencent/mobileqq/persistence/EntityTransaction:db	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   4: invokevirtual 106	com/tencent/mobileqq/app/SQLiteDatabase:endTransaction	()V
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield 71	com/tencent/mobileqq/persistence/EntityTransaction:db	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   12: getstatic 24	com/tencent/mobileqq/persistence/EntityTransaction:lock	Ljava/util/concurrent/locks/Lock;
    //   15: checkcast 108	java/util/concurrent/locks/ReentrantLock
    //   18: invokevirtual 111	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   21: ifeq +25 -> 46
    //   24: ldc2_w 112
    //   27: aconst_null
    //   28: invokestatic 93	com/tencent/mobileqq/imcore/proxy/db/ThreadTraceHelperProxy:setCurrentTransThread	(JLjava/lang/String;)V
    //   31: getstatic 24	com/tencent/mobileqq/persistence/EntityTransaction:lock	Ljava/util/concurrent/locks/Lock;
    //   34: invokeinterface 116 1 0
    //   39: aload_0
    //   40: getfield 33	com/tencent/mobileqq/persistence/EntityTransaction:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   43: invokevirtual 119	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   46: return
    //   47: astore_1
    //   48: getstatic 24	com/tencent/mobileqq/persistence/EntityTransaction:lock	Ljava/util/concurrent/locks/Lock;
    //   51: checkcast 108	java/util/concurrent/locks/ReentrantLock
    //   54: invokevirtual 111	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   57: ifeq -11 -> 46
    //   60: ldc2_w 112
    //   63: aconst_null
    //   64: invokestatic 93	com/tencent/mobileqq/imcore/proxy/db/ThreadTraceHelperProxy:setCurrentTransThread	(JLjava/lang/String;)V
    //   67: getstatic 24	com/tencent/mobileqq/persistence/EntityTransaction:lock	Ljava/util/concurrent/locks/Lock;
    //   70: invokeinterface 116 1 0
    //   75: aload_0
    //   76: getfield 33	com/tencent/mobileqq/persistence/EntityTransaction:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   79: invokevirtual 119	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   82: return
    //   83: astore_1
    //   84: getstatic 24	com/tencent/mobileqq/persistence/EntityTransaction:lock	Ljava/util/concurrent/locks/Lock;
    //   87: checkcast 108	java/util/concurrent/locks/ReentrantLock
    //   90: invokevirtual 111	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   93: ifeq +25 -> 118
    //   96: ldc2_w 112
    //   99: aconst_null
    //   100: invokestatic 93	com/tencent/mobileqq/imcore/proxy/db/ThreadTraceHelperProxy:setCurrentTransThread	(JLjava/lang/String;)V
    //   103: getstatic 24	com/tencent/mobileqq/persistence/EntityTransaction:lock	Ljava/util/concurrent/locks/Lock;
    //   106: invokeinterface 116 1 0
    //   111: aload_0
    //   112: getfield 33	com/tencent/mobileqq/persistence/EntityTransaction:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   115: invokevirtual 119	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	EntityTransaction
    //   47	1	1	localException	java.lang.Exception
    //   83	36	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	12	47	java/lang/Exception
    //   0	12	83	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EntityTransaction
 * JD-Core Version:    0.7.0.1
 */