package com.tencent.mobileqq.colornote.data;

import anyf;
import java.util.List;

public class ColorNoteProxy$2
  implements Runnable
{
  public ColorNoteProxy$2(anyf paramanyf, List paramList) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/mobileqq/colornote/data/ColorNoteProxy$2:this$0	Lanyf;
    //   4: invokestatic 28	anyf:a	(Lanyf;)Lawbw;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 14	com/tencent/mobileqq/colornote/data/ColorNoteProxy$2:this$0	Lanyf;
    //   15: invokestatic 28	anyf:a	(Lanyf;)Lawbw;
    //   18: invokevirtual 33	awbw:a	()Lawby;
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 37	awby:a	()V
    //   26: aload_0
    //   27: getfield 16	com/tencent/mobileqq/colornote/data/ColorNoteProxy$2:a	Ljava/util/List;
    //   30: invokeinterface 43 1 0
    //   35: astore_2
    //   36: aload_2
    //   37: invokeinterface 49 1 0
    //   42: ifeq +51 -> 93
    //   45: aload_2
    //   46: invokeinterface 53 1 0
    //   51: checkcast 55	com/tencent/mobileqq/colornote/data/ColorNote
    //   54: astore_3
    //   55: aload_0
    //   56: getfield 14	com/tencent/mobileqq/colornote/data/ColorNoteProxy$2:this$0	Lanyf;
    //   59: invokestatic 28	anyf:a	(Lanyf;)Lawbw;
    //   62: aload_3
    //   63: invokevirtual 59	awbw:b	(Lawbv;)Z
    //   66: pop
    //   67: goto -31 -> 36
    //   70: astore_2
    //   71: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +14 -> 88
    //   77: ldc 66
    //   79: iconst_2
    //   80: aload_2
    //   81: iconst_0
    //   82: anewarray 4	java/lang/Object
    //   85: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   88: aload_1
    //   89: invokevirtual 72	awby:b	()V
    //   92: return
    //   93: aload_1
    //   94: invokevirtual 75	awby:c	()V
    //   97: aload_1
    //   98: invokevirtual 72	awby:b	()V
    //   101: return
    //   102: astore_2
    //   103: aload_1
    //   104: invokevirtual 72	awby:b	()V
    //   107: aload_2
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	2
    //   21	83	1	localawby	awby
    //   35	11	2	localIterator	java.util.Iterator
    //   70	11	2	localException	java.lang.Exception
    //   102	6	2	localObject	Object
    //   54	9	3	localColorNote	ColorNote
    // Exception table:
    //   from	to	target	type
    //   22	36	70	java/lang/Exception
    //   36	67	70	java/lang/Exception
    //   93	97	70	java/lang/Exception
    //   22	36	102	finally
    //   36	67	102	finally
    //   71	88	102	finally
    //   93	97	102	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNoteProxy.2
 * JD-Core Version:    0.7.0.1
 */