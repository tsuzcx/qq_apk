package com.tencent.youtu.sdkkitframework.framework;

class YtFSM$1
  implements Runnable
{
  YtFSM$1(YtFSM paramYtFSM, int paramInt, long paramLong) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:val$threadPriority	I
    //   4: invokestatic 33	android/os/Process:setThreadPriority	(I)V
    //   7: aload_0
    //   8: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   11: invokestatic 39	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$100	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Z
    //   14: ifeq +271 -> 285
    //   17: aload_0
    //   18: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   21: invokestatic 43	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$200	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Ljava/util/concurrent/locks/Lock;
    //   24: invokeinterface 48 1 0
    //   29: aload_0
    //   30: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   33: invokestatic 51	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$300	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Z
    //   36: ifeq +117 -> 153
    //   39: aconst_null
    //   40: astore_2
    //   41: aconst_null
    //   42: astore_1
    //   43: aload_0
    //   44: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   47: invokestatic 55	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$400	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Lcom/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateStrategy;
    //   50: getstatic 61	com/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateStrategy:CacheStrategy	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateStrategy;
    //   53: if_acmpne +233 -> 286
    //   56: aload_0
    //   57: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   60: invokestatic 65	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$500	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   63: invokevirtual 71	java/util/concurrent/ConcurrentLinkedQueue:poll	()Ljava/lang/Object;
    //   66: checkcast 73	com/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateData
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull +82 -> 153
    //   74: aload_0
    //   75: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   78: aload_1
    //   79: invokestatic 77	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$702	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;Lcom/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateData;)Lcom/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateData;
    //   82: pop
    //   83: aload_0
    //   84: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   87: invokestatic 81	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$800	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Lcom/tencent/youtu/sdkkitframework/framework/YtFSMBaseState;
    //   90: ifnull +63 -> 153
    //   93: aload_0
    //   94: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   97: invokestatic 81	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$800	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Lcom/tencent/youtu/sdkkitframework/framework/YtFSMBaseState;
    //   100: aload_0
    //   101: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   104: invokestatic 85	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$700	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Lcom/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateData;
    //   107: getfield 89	com/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateData:imageData	[B
    //   110: aload_0
    //   111: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   114: invokestatic 85	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$700	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Lcom/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateData;
    //   117: getfield 92	com/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateData:imageWidth	I
    //   120: aload_0
    //   121: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   124: invokestatic 85	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$700	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Lcom/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateData;
    //   127: getfield 95	com/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateData:imageHeight	I
    //   130: aload_0
    //   131: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   134: invokestatic 85	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$700	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Lcom/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateData;
    //   137: getfield 98	com/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateData:imageType	I
    //   140: aload_0
    //   141: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   144: invokestatic 85	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$700	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Lcom/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateData;
    //   147: getfield 101	com/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateData:timeStamp	J
    //   150: invokevirtual 107	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState:update	([BIIIJ)V
    //   153: aload_0
    //   154: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   157: invokestatic 43	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$200	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Ljava/util/concurrent/locks/Lock;
    //   160: invokeinterface 110 1 0
    //   165: ldc2_w 111
    //   168: invokestatic 118	java/lang/Thread:sleep	(J)V
    //   171: aload_0
    //   172: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   175: invokestatic 81	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$800	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Lcom/tencent/youtu/sdkkitframework/framework/YtFSMBaseState;
    //   178: ifnull +30 -> 208
    //   181: aload_0
    //   182: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   185: invokestatic 81	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$800	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Lcom/tencent/youtu/sdkkitframework/framework/YtFSMBaseState;
    //   188: invokevirtual 122	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState:getStateSimpleName	()Ljava/lang/String;
    //   191: ldc 124
    //   193: invokevirtual 130	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   196: ifeq +12 -> 208
    //   199: aload_0
    //   200: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   203: iconst_0
    //   204: invokestatic 134	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$902	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;Z)Z
    //   207: pop
    //   208: aload_0
    //   209: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   212: invokestatic 137	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$900	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Z
    //   215: ifeq -208 -> 7
    //   218: aload_0
    //   219: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   222: invokestatic 141	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$1000	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)J
    //   225: lconst_0
    //   226: lcmp
    //   227: ifle -220 -> 7
    //   230: aload_0
    //   231: getfield 20	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:val$updateTimeoutMs	J
    //   234: lconst_0
    //   235: lcmp
    //   236: ifle -229 -> 7
    //   239: invokestatic 147	java/lang/System:currentTimeMillis	()J
    //   242: aload_0
    //   243: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   246: invokestatic 141	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$1000	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)J
    //   249: aload_0
    //   250: getfield 20	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:val$updateTimeoutMs	J
    //   253: ladd
    //   254: lcmp
    //   255: ifle -248 -> 7
    //   258: invokestatic 151	com/tencent/youtu/sdkkitframework/framework/YtFSM:getInstance	()Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   261: new 153	com/tencent/youtu/sdkkitframework/framework/YtFSM$1$1
    //   264: dup
    //   265: aload_0
    //   266: invokespecial 156	com/tencent/youtu/sdkkitframework/framework/YtFSM$1$1:<init>	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM$1;)V
    //   269: invokevirtual 160	com/tencent/youtu/sdkkitframework/framework/YtFSM:sendFSMEvent	(Ljava/util/HashMap;)V
    //   272: invokestatic 151	com/tencent/youtu/sdkkitframework/framework/YtFSM:getInstance	()Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   275: getstatic 166	com/tencent/youtu/sdkkitframework/framework/YtSDKKitCommon$StateNameHelper$StateClassName:IDLE_STATE	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitCommon$StateNameHelper$StateClassName;
    //   278: invokestatic 172	com/tencent/youtu/sdkkitframework/framework/YtSDKKitCommon$StateNameHelper:classNameOfState	(Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitCommon$StateNameHelper$StateClassName;)Ljava/lang/String;
    //   281: invokevirtual 176	com/tencent/youtu/sdkkitframework/framework/YtFSM:transitNow	(Ljava/lang/String;)I
    //   284: pop
    //   285: return
    //   286: aload_0
    //   287: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   290: invokestatic 55	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$400	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Lcom/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateStrategy;
    //   293: getstatic 179	com/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateStrategy:NoCacheStrategy	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateStrategy;
    //   296: if_acmpne +69 -> 365
    //   299: invokestatic 182	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$600	()Ljava/lang/String;
    //   302: new 184	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   309: ldc 187
    //   311: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload_0
    //   315: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   318: invokestatic 65	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$500	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   321: invokevirtual 195	java/util/concurrent/ConcurrentLinkedQueue:size	()I
    //   324: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 207	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload_2
    //   334: astore_1
    //   335: aload_0
    //   336: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   339: invokestatic 65	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$500	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   342: invokevirtual 195	java/util/concurrent/ConcurrentLinkedQueue:size	()I
    //   345: ifle -275 -> 70
    //   348: aload_0
    //   349: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   352: invokestatic 65	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$500	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   355: invokevirtual 71	java/util/concurrent/ConcurrentLinkedQueue:poll	()Ljava/lang/Object;
    //   358: checkcast 73	com/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateData
    //   361: astore_1
    //   362: goto -27 -> 335
    //   365: invokestatic 182	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$600	()Ljava/lang/String;
    //   368: new 184	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   375: ldc 209
    //   377: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_0
    //   381: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   384: invokestatic 55	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$400	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Lcom/tencent/youtu/sdkkitframework/framework/YtFSM$YtFSMUpdateStrategy;
    //   387: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 215	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: goto -326 -> 70
    //   399: astore_1
    //   400: aload_0
    //   401: getfield 16	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:this$0	Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   404: invokestatic 43	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$200	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;)Ljava/util/concurrent/locks/Lock;
    //   407: invokeinterface 110 1 0
    //   412: aload_1
    //   413: athrow
    //   414: astore_1
    //   415: invokestatic 182	com/tencent/youtu/sdkkitframework/framework/YtFSM:access$600	()Ljava/lang/String;
    //   418: ldc 217
    //   420: invokestatic 215	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   423: goto -252 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	1
    //   42	320	1	localObject1	Object
    //   399	14	1	localObject2	Object
    //   414	1	1	localInterruptedException	java.lang.InterruptedException
    //   40	294	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   17	39	399	finally
    //   43	70	399	finally
    //   74	153	399	finally
    //   286	333	399	finally
    //   335	362	399	finally
    //   365	396	399	finally
    //   165	171	414	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtFSM.1
 * JD-Core Version:    0.7.0.1
 */