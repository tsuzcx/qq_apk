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
  private SQLiteDatabase db;
  private final SQLiteOpenHelper dbHelper;
  private DBThreadMonitor mDBThreadMonitor = new DBThreadMonitor("EntityTransaction");
  public final Lock mLock = new MsgLock("EntityTransaction");
  
  EntityTransaction(SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    this.dbHelper = paramSQLiteOpenHelper;
  }
  
  public void begin()
  {
    Thread localThread = Thread.currentThread();
    ThreadTraceHelperProxy.addWaitingTransThread(localThread.getId(), localThread.getName());
    this.mLock.lock();
    this.mDBThreadMonitor.a();
    this.db = this.dbHelper.getWritableDatabase();
    if ((SQLiteOpenHelper.WAL_ENABLE) && (VersionUtils.e())) {
      this.db.beginTransactionNonExclusive();
    } else {
      this.db.beginTransaction();
    }
    ThreadTraceHelperProxy.removeWaitingTransThread(localThread.getId());
    ThreadTraceHelperProxy.setCurrentTransThread(localThread.getId(), localThread.getName());
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
    //   12: aload_0
    //   13: getfield 26	com/tencent/mobileqq/persistence/EntityTransaction:mLock	Ljava/util/concurrent/locks/Lock;
    //   16: checkcast 108	java/util/concurrent/locks/ReentrantLock
    //   19: invokevirtual 111	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   22: ifeq +81 -> 103
    //   25: goto +55 -> 80
    //   28: astore_1
    //   29: aload_0
    //   30: getfield 26	com/tencent/mobileqq/persistence/EntityTransaction:mLock	Ljava/util/concurrent/locks/Lock;
    //   33: checkcast 108	java/util/concurrent/locks/ReentrantLock
    //   36: invokevirtual 111	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   39: ifeq +26 -> 65
    //   42: ldc2_w 112
    //   45: aconst_null
    //   46: invokestatic 96	com/tencent/mobileqq/imcore/proxy/db/ThreadTraceHelperProxy:setCurrentTransThread	(JLjava/lang/String;)V
    //   49: aload_0
    //   50: getfield 26	com/tencent/mobileqq/persistence/EntityTransaction:mLock	Ljava/util/concurrent/locks/Lock;
    //   53: invokeinterface 116 1 0
    //   58: aload_0
    //   59: getfield 31	com/tencent/mobileqq/persistence/EntityTransaction:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   62: invokevirtual 119	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   65: aload_1
    //   66: athrow
    //   67: aload_0
    //   68: getfield 26	com/tencent/mobileqq/persistence/EntityTransaction:mLock	Ljava/util/concurrent/locks/Lock;
    //   71: checkcast 108	java/util/concurrent/locks/ReentrantLock
    //   74: invokevirtual 111	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   77: ifeq +26 -> 103
    //   80: ldc2_w 112
    //   83: aconst_null
    //   84: invokestatic 96	com/tencent/mobileqq/imcore/proxy/db/ThreadTraceHelperProxy:setCurrentTransThread	(JLjava/lang/String;)V
    //   87: aload_0
    //   88: getfield 26	com/tencent/mobileqq/persistence/EntityTransaction:mLock	Ljava/util/concurrent/locks/Lock;
    //   91: invokeinterface 116 1 0
    //   96: aload_0
    //   97: getfield 31	com/tencent/mobileqq/persistence/EntityTransaction:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   100: invokevirtual 119	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   103: return
    //   104: astore_1
    //   105: goto -38 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	EntityTransaction
    //   28	38	1	localObject	Object
    //   104	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	12	28	finally
    //   0	12	104	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EntityTransaction
 * JD-Core Version:    0.7.0.1
 */