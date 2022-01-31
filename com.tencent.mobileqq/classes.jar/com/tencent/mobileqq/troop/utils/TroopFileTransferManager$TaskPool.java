package com.tencent.mobileqq.troop.utils;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class TroopFileTransferManager$TaskPool
{
  public int a;
  public LinkedList a;
  public AtomicInteger a;
  
  public TroopFileTransferManager$TaskPool(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  /* Error */
  public void a(TroopFileTransferManager.Task paramTask)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskPool:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   6: aload_1
    //   7: invokevirtual 31	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: getfield 18	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskPool:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   15: invokevirtual 35	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   18: aload_0
    //   19: getfield 25	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskPool:jdField_a_of_type_Int	I
    //   22: if_icmple +14 -> 36
    //   25: aload_0
    //   26: getfield 18	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskPool:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   29: invokevirtual 38	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   32: pop
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: new 40	ajbh
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 43	ajbh:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskPool;)V
    //   44: iconst_5
    //   45: aconst_null
    //   46: iconst_1
    //   47: invokestatic 49	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   50: goto -17 -> 33
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	TaskPool
    //   0	58	1	paramTask	TroopFileTransferManager.Task
    // Exception table:
    //   from	to	target	type
    //   2	33	53	finally
    //   36	50	53	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskPool
 * JD-Core Version:    0.7.0.1
 */