package me.weishu.epic.art;

import java.util.HashMap;
import java.util.Map;

class Epic$EntryLock
{
  static Map<Long, EntryLock> sLockPool = new HashMap();
  
  /* Error */
  static EntryLock obtain(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 16	me/weishu/epic/art/Epic$EntryLock:sLockPool	Ljava/util/Map;
    //   6: lload_0
    //   7: invokestatic 26	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10: invokeinterface 32 2 0
    //   15: ifeq +24 -> 39
    //   18: getstatic 16	me/weishu/epic/art/Epic$EntryLock:sLockPool	Ljava/util/Map;
    //   21: lload_0
    //   22: invokestatic 26	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   25: invokeinterface 36 2 0
    //   30: checkcast 2	me/weishu/epic/art/Epic$EntryLock
    //   33: astore_2
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_2
    //   38: areturn
    //   39: new 2	me/weishu/epic/art/Epic$EntryLock
    //   42: dup
    //   43: invokespecial 37	me/weishu/epic/art/Epic$EntryLock:<init>	()V
    //   46: astore_2
    //   47: getstatic 16	me/weishu/epic/art/Epic$EntryLock:sLockPool	Ljava/util/Map;
    //   50: lload_0
    //   51: invokestatic 26	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   54: aload_2
    //   55: invokeinterface 41 3 0
    //   60: pop
    //   61: goto -27 -> 34
    //   64: astore_2
    //   65: ldc 2
    //   67: monitorexit
    //   68: aload_2
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramLong	long
    //   33	22	2	localEntryLock	EntryLock
    //   64	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	34	64	finally
    //   39	61	64	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.weishu.epic.art.Epic.EntryLock
 * JD-Core Version:    0.7.0.1
 */