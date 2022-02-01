package com.tencent.mobileqq.colornote.data;

import aqry;
import java.util.List;

public class ColorNoteProxy$3
  implements Runnable
{
  public ColorNoteProxy$3(aqry paramaqry, List paramList) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/mobileqq/colornote/data/ColorNoteProxy$3:this$0	Laqry;
    //   4: invokestatic 28	aqry:a	(Laqry;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 14	com/tencent/mobileqq/colornote/data/ColorNoteProxy$3:this$0	Laqry;
    //   15: invokestatic 28	aqry:a	(Laqry;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   18: invokevirtual 34	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 39	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   26: aload_0
    //   27: getfield 16	com/tencent/mobileqq/colornote/data/ColorNoteProxy$3:a	Ljava/util/List;
    //   30: invokeinterface 45 1 0
    //   35: astore_2
    //   36: aload_2
    //   37: invokeinterface 51 1 0
    //   42: ifeq +60 -> 102
    //   45: aload_2
    //   46: invokeinterface 55 1 0
    //   51: checkcast 57	com/tencent/mobileqq/colornote/data/ColorNote
    //   54: astore_3
    //   55: aload_0
    //   56: getfield 14	com/tencent/mobileqq/colornote/data/ColorNoteProxy$3:this$0	Laqry;
    //   59: invokestatic 28	aqry:a	(Laqry;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   62: aload_3
    //   63: invokevirtual 61	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   66: pop
    //   67: aload_0
    //   68: getfield 14	com/tencent/mobileqq/colornote/data/ColorNoteProxy$3:this$0	Laqry;
    //   71: iconst_2
    //   72: aload_3
    //   73: invokestatic 64	aqry:a	(Laqry;ILcom/tencent/mobileqq/colornote/data/ColorNote;)V
    //   76: goto -40 -> 36
    //   79: astore_2
    //   80: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +14 -> 97
    //   86: ldc 71
    //   88: iconst_2
    //   89: aload_2
    //   90: iconst_0
    //   91: anewarray 4	java/lang/Object
    //   94: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   97: aload_1
    //   98: invokevirtual 78	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   101: return
    //   102: aload_1
    //   103: invokevirtual 81	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   106: aload_1
    //   107: invokevirtual 78	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   110: return
    //   111: astore_2
    //   112: aload_1
    //   113: invokevirtual 78	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   116: aload_2
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	3
    //   21	92	1	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   35	11	2	localIterator	java.util.Iterator
    //   79	11	2	localException	java.lang.Exception
    //   111	6	2	localObject	Object
    //   54	19	3	localColorNote	ColorNote
    // Exception table:
    //   from	to	target	type
    //   22	36	79	java/lang/Exception
    //   36	76	79	java/lang/Exception
    //   102	106	79	java/lang/Exception
    //   22	36	111	finally
    //   36	76	111	finally
    //   80	97	111	finally
    //   102	106	111	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNoteProxy.3
 * JD-Core Version:    0.7.0.1
 */