package com.tencent.mobileqq.colornote.api.impl;

import java.util.List;

class ColorNoteDataServiceImpl$3
  implements Runnable
{
  ColorNoteDataServiceImpl$3(ColorNoteDataServiceImpl paramColorNoteDataServiceImpl, List paramList) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/mobileqq/colornote/api/impl/ColorNoteDataServiceImpl$3:this$0	Lcom/tencent/mobileqq/colornote/api/impl/ColorNoteDataServiceImpl;
    //   4: invokestatic 29	com/tencent/mobileqq/colornote/api/impl/ColorNoteDataServiceImpl:access$100	(Lcom/tencent/mobileqq/colornote/api/impl/ColorNoteDataServiceImpl;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 14	com/tencent/mobileqq/colornote/api/impl/ColorNoteDataServiceImpl$3:this$0	Lcom/tencent/mobileqq/colornote/api/impl/ColorNoteDataServiceImpl;
    //   15: invokestatic 29	com/tencent/mobileqq/colornote/api/impl/ColorNoteDataServiceImpl:access$100	(Lcom/tencent/mobileqq/colornote/api/impl/ColorNoteDataServiceImpl;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   18: invokevirtual 35	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 40	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   26: aload_0
    //   27: getfield 16	com/tencent/mobileqq/colornote/api/impl/ColorNoteDataServiceImpl$3:a	Ljava/util/List;
    //   30: invokeinterface 46 1 0
    //   35: astore_2
    //   36: aload_2
    //   37: invokeinterface 52 1 0
    //   42: ifeq +37 -> 79
    //   45: aload_2
    //   46: invokeinterface 56 1 0
    //   51: checkcast 58	com/tencent/mobileqq/colornote/data/ColorNote
    //   54: astore_3
    //   55: aload_0
    //   56: getfield 14	com/tencent/mobileqq/colornote/api/impl/ColorNoteDataServiceImpl$3:this$0	Lcom/tencent/mobileqq/colornote/api/impl/ColorNoteDataServiceImpl;
    //   59: invokestatic 29	com/tencent/mobileqq/colornote/api/impl/ColorNoteDataServiceImpl:access$100	(Lcom/tencent/mobileqq/colornote/api/impl/ColorNoteDataServiceImpl;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   62: aload_3
    //   63: invokevirtual 62	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   66: pop
    //   67: aload_0
    //   68: getfield 14	com/tencent/mobileqq/colornote/api/impl/ColorNoteDataServiceImpl$3:this$0	Lcom/tencent/mobileqq/colornote/api/impl/ColorNoteDataServiceImpl;
    //   71: iconst_2
    //   72: aload_3
    //   73: invokestatic 66	com/tencent/mobileqq/colornote/api/impl/ColorNoteDataServiceImpl:access$200	(Lcom/tencent/mobileqq/colornote/api/impl/ColorNoteDataServiceImpl;ILcom/tencent/mobileqq/colornote/data/ColorNote;)V
    //   76: goto -40 -> 36
    //   79: aload_1
    //   80: invokevirtual 69	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   83: goto +25 -> 108
    //   86: astore_2
    //   87: goto +26 -> 113
    //   90: astore_2
    //   91: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +14 -> 108
    //   97: ldc 76
    //   99: iconst_2
    //   100: aload_2
    //   101: iconst_0
    //   102: anewarray 4	java/lang/Object
    //   105: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   108: aload_1
    //   109: invokevirtual 83	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   112: return
    //   113: aload_1
    //   114: invokevirtual 83	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   117: goto +5 -> 122
    //   120: aload_2
    //   121: athrow
    //   122: goto -2 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	3
    //   21	93	1	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   35	11	2	localIterator	java.util.Iterator
    //   86	1	2	localObject	Object
    //   90	31	2	localException	java.lang.Exception
    //   54	19	3	localColorNote	com.tencent.mobileqq.colornote.data.ColorNote
    // Exception table:
    //   from	to	target	type
    //   22	36	86	finally
    //   36	76	86	finally
    //   79	83	86	finally
    //   91	108	86	finally
    //   22	36	90	java/lang/Exception
    //   36	76	90	java/lang/Exception
    //   79	83	90	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.api.impl.ColorNoteDataServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */