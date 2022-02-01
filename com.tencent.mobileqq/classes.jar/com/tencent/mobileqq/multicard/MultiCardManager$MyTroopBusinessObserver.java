package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.troop.api.observer.TroopObserver;

class MultiCardManager$MyTroopBusinessObserver
  extends TroopObserver
{
  private MultiCardManager$MyTroopBusinessObserver(MultiCardManager paramMultiCardManager) {}
  
  /* Error */
  public void onUpdateTroopGetMemberList(java.lang.String arg1, boolean paramBoolean, java.util.List<com.tencent.mobileqq.data.troop.TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +47 -> 50
    //   6: ldc 29
    //   8: iconst_2
    //   9: new 31	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   16: ldc 34
    //   18: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_2
    //   22: invokevirtual 41	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   25: ldc 43
    //   27: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 43
    //   36: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload 4
    //   41: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_1
    //   51: invokestatic 60	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   54: lstore 5
    //   56: iload 4
    //   58: bipush 9
    //   60: if_icmpne +126 -> 186
    //   63: lload 5
    //   65: aload_0
    //   66: getfield 10	com/tencent/mobileqq/multicard/MultiCardManager$MyTroopBusinessObserver:a	Lcom/tencent/mobileqq/multicard/MultiCardManager;
    //   69: invokestatic 65	com/tencent/mobileqq/multicard/MultiCardManager:a	(Lcom/tencent/mobileqq/multicard/MultiCardManager;)J
    //   72: lcmp
    //   73: ifne +113 -> 186
    //   76: aload_0
    //   77: getfield 10	com/tencent/mobileqq/multicard/MultiCardManager$MyTroopBusinessObserver:a	Lcom/tencent/mobileqq/multicard/MultiCardManager;
    //   80: invokestatic 69	com/tencent/mobileqq/multicard/MultiCardManager:b	(Lcom/tencent/mobileqq/multicard/MultiCardManager;)Ljava/util/HashMap;
    //   83: ifnull +103 -> 186
    //   86: aload_0
    //   87: getfield 10	com/tencent/mobileqq/multicard/MultiCardManager$MyTroopBusinessObserver:a	Lcom/tencent/mobileqq/multicard/MultiCardManager;
    //   90: invokestatic 69	com/tencent/mobileqq/multicard/MultiCardManager:b	(Lcom/tencent/mobileqq/multicard/MultiCardManager;)Ljava/util/HashMap;
    //   93: astore_1
    //   94: aload_1
    //   95: monitorenter
    //   96: aload_0
    //   97: getfield 10	com/tencent/mobileqq/multicard/MultiCardManager$MyTroopBusinessObserver:a	Lcom/tencent/mobileqq/multicard/MultiCardManager;
    //   100: invokestatic 69	com/tencent/mobileqq/multicard/MultiCardManager:b	(Lcom/tencent/mobileqq/multicard/MultiCardManager;)Ljava/util/HashMap;
    //   103: lload 5
    //   105: invokestatic 73	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   108: invokevirtual 79	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   111: checkcast 81	java/lang/ref/WeakReference
    //   114: astore_3
    //   115: aload_1
    //   116: monitorexit
    //   117: aload_3
    //   118: ifnull +68 -> 186
    //   121: aload_3
    //   122: invokevirtual 84	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   125: checkcast 86	com/tencent/mobileqq/multicard/MultiCardManager$GetGroupMemberNickListener
    //   128: astore_3
    //   129: aload_3
    //   130: ifnull +56 -> 186
    //   133: new 88	java/util/ArrayList
    //   136: dup
    //   137: iconst_0
    //   138: invokespecial 91	java/util/ArrayList:<init>	(I)V
    //   141: pop
    //   142: aload_0
    //   143: getfield 10	com/tencent/mobileqq/multicard/MultiCardManager$MyTroopBusinessObserver:a	Lcom/tencent/mobileqq/multicard/MultiCardManager;
    //   146: invokestatic 94	com/tencent/mobileqq/multicard/MultiCardManager:c	(Lcom/tencent/mobileqq/multicard/MultiCardManager;)Ljava/util/HashMap;
    //   149: astore_1
    //   150: aload_1
    //   151: monitorenter
    //   152: aload_0
    //   153: getfield 10	com/tencent/mobileqq/multicard/MultiCardManager$MyTroopBusinessObserver:a	Lcom/tencent/mobileqq/multicard/MultiCardManager;
    //   156: invokestatic 94	com/tencent/mobileqq/multicard/MultiCardManager:c	(Lcom/tencent/mobileqq/multicard/MultiCardManager;)Ljava/util/HashMap;
    //   159: lload 5
    //   161: invokestatic 73	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   164: invokevirtual 79	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   167: checkcast 88	java/util/ArrayList
    //   170: astore 8
    //   172: aload_1
    //   173: monitorexit
    //   174: aload_0
    //   175: getfield 10	com/tencent/mobileqq/multicard/MultiCardManager$MyTroopBusinessObserver:a	Lcom/tencent/mobileqq/multicard/MultiCardManager;
    //   178: lload 5
    //   180: aload 8
    //   182: aload_3
    //   183: invokestatic 97	com/tencent/mobileqq/multicard/MultiCardManager:a	(Lcom/tencent/mobileqq/multicard/MultiCardManager;JLjava/util/ArrayList;Lcom/tencent/mobileqq/multicard/MultiCardManager$GetGroupMemberNickListener;)V
    //   186: return
    //   187: astore_1
    //   188: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +31 -> 222
    //   194: ldc 29
    //   196: iconst_2
    //   197: new 31	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   204: ldc 34
    //   206: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_1
    //   210: invokevirtual 98	java/lang/Exception:toString	()Ljava/lang/String;
    //   213: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: lconst_0
    //   223: lstore 5
    //   225: goto -169 -> 56
    //   228: astore_3
    //   229: aload_1
    //   230: monitorexit
    //   231: aload_3
    //   232: athrow
    //   233: astore_3
    //   234: aload_1
    //   235: monitorexit
    //   236: aload_3
    //   237: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	MyTroopBusinessObserver
    //   0	238	2	paramBoolean	boolean
    //   0	238	3	paramList	java.util.List<com.tencent.mobileqq.data.troop.TroopMemberInfo>
    //   0	238	4	paramInt1	int
    //   0	238	5	paramLong	long
    //   0	238	7	paramInt2	int
    //   170	11	8	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   50	56	187	java/lang/Exception
    //   96	117	228	finally
    //   229	231	228	finally
    //   152	174	233	finally
    //   234	236	233	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardManager.MyTroopBusinessObserver
 * JD-Core Version:    0.7.0.1
 */