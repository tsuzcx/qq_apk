package com.tencent.wcdb.database;

class SQLiteAsyncCursor$QueryThread
  extends Thread
{
  private volatile int a = 0;
  private int b = 0;
  private int c = 0;
  
  SQLiteAsyncCursor$QueryThread(SQLiteAsyncCursor paramSQLiteAsyncCursor)
  {
    super("SQLiteAsyncCursor.QueryThread");
  }
  
  void a()
  {
    interrupt();
  }
  
  void a(int paramInt)
  {
    try
    {
      this.a = paramInt;
      notifyAll();
      return;
    }
    finally {}
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
    //   4: invokestatic 44	com/tencent/wcdb/database/SQLiteAsyncCursor:a	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Lcom/tencent/wcdb/database/SQLiteAsyncQuery;
    //   7: invokevirtual 49	com/tencent/wcdb/database/SQLiteAsyncQuery:c	()I
    //   10: istore_1
    //   11: aload_0
    //   12: getfield 14	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
    //   15: invokestatic 52	com/tencent/wcdb/database/SQLiteAsyncCursor:b	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Ljava/lang/Object;
    //   18: astore 5
    //   20: aload 5
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 14	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
    //   27: iload_1
    //   28: invokestatic 55	com/tencent/wcdb/database/SQLiteAsyncCursor:a	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;I)I
    //   31: pop
    //   32: aload_0
    //   33: getfield 14	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
    //   36: invokestatic 52	com/tencent/wcdb/database/SQLiteAsyncCursor:b	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Ljava/lang/Object;
    //   39: invokevirtual 36	java/lang/Object:notifyAll	()V
    //   42: aload 5
    //   44: monitorexit
    //   45: invokestatic 59	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:interrupted	()Z
    //   48: ifne +257 -> 305
    //   51: aload_0
    //   52: monitorenter
    //   53: aload_0
    //   54: getfield 21	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:a	I
    //   57: sipush 256
    //   60: iadd
    //   61: aload_0
    //   62: getfield 25	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:b	I
    //   65: if_icmpgt +21 -> 86
    //   68: aload_0
    //   69: getfield 21	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:a	I
    //   72: aload_0
    //   73: getfield 23	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:c	I
    //   76: if_icmplt +10 -> 86
    //   79: aload_0
    //   80: invokevirtual 62	java/lang/Object:wait	()V
    //   83: goto -30 -> 53
    //   86: aload_0
    //   87: getfield 21	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:a	I
    //   90: istore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: iload_1
    //   94: aload_0
    //   95: getfield 23	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:c	I
    //   98: if_icmpge +33 -> 131
    //   101: aload_0
    //   102: getfield 14	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
    //   105: invokestatic 44	com/tencent/wcdb/database/SQLiteAsyncCursor:a	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Lcom/tencent/wcdb/database/SQLiteAsyncQuery;
    //   108: invokevirtual 65	com/tencent/wcdb/database/SQLiteAsyncQuery:d	()V
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 25	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:b	I
    //   116: aload_0
    //   117: getfield 14	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
    //   120: invokestatic 68	com/tencent/wcdb/database/SQLiteAsyncCursor:c	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Lcom/tencent/wcdb/database/ChunkedCursorWindow;
    //   123: invokevirtual 72	com/tencent/wcdb/database/ChunkedCursorWindow:a	()V
    //   126: aload_0
    //   127: iconst_0
    //   128: putfield 23	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:c	I
    //   131: aload_0
    //   132: getfield 25	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:b	I
    //   135: iload_1
    //   136: sipush 256
    //   139: iadd
    //   140: if_icmpge -95 -> 45
    //   143: aload_0
    //   144: getfield 14	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
    //   147: invokestatic 68	com/tencent/wcdb/database/SQLiteAsyncCursor:c	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Lcom/tencent/wcdb/database/ChunkedCursorWindow;
    //   150: invokevirtual 74	com/tencent/wcdb/database/ChunkedCursorWindow:b	()I
    //   153: bipush 32
    //   155: if_icmple +32 -> 187
    //   158: aload_0
    //   159: getfield 14	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
    //   162: invokestatic 68	com/tencent/wcdb/database/SQLiteAsyncCursor:c	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Lcom/tencent/wcdb/database/ChunkedCursorWindow;
    //   165: aload_0
    //   166: getfield 23	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:c	I
    //   169: invokevirtual 77	com/tencent/wcdb/database/ChunkedCursorWindow:a	(I)J
    //   172: lstore_3
    //   173: lload_3
    //   174: ldc2_w 78
    //   177: lcmp
    //   178: ifeq +9 -> 187
    //   181: aload_0
    //   182: lload_3
    //   183: l2i
    //   184: putfield 23	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:c	I
    //   187: aload_0
    //   188: getfield 14	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
    //   191: invokestatic 52	com/tencent/wcdb/database/SQLiteAsyncCursor:b	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Ljava/lang/Object;
    //   194: astore 5
    //   196: aload 5
    //   198: monitorenter
    //   199: aload_0
    //   200: getfield 14	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
    //   203: invokestatic 44	com/tencent/wcdb/database/SQLiteAsyncCursor:a	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Lcom/tencent/wcdb/database/SQLiteAsyncQuery;
    //   206: aload_0
    //   207: getfield 14	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
    //   210: invokestatic 68	com/tencent/wcdb/database/SQLiteAsyncCursor:c	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Lcom/tencent/wcdb/database/ChunkedCursorWindow;
    //   213: aload_0
    //   214: getfield 25	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:b	I
    //   217: bipush 32
    //   219: invokevirtual 82	com/tencent/wcdb/database/SQLiteAsyncQuery:a	(Lcom/tencent/wcdb/database/ChunkedCursorWindow;II)I
    //   222: istore_2
    //   223: aload_0
    //   224: getfield 25	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:b	I
    //   227: iload_1
    //   228: if_icmpgt +23 -> 251
    //   231: aload_0
    //   232: getfield 25	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:b	I
    //   235: iload_2
    //   236: iadd
    //   237: iload_1
    //   238: if_icmple +13 -> 251
    //   241: aload_0
    //   242: getfield 14	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
    //   245: invokestatic 52	com/tencent/wcdb/database/SQLiteAsyncCursor:b	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Ljava/lang/Object;
    //   248: invokevirtual 36	java/lang/Object:notifyAll	()V
    //   251: aload 5
    //   253: monitorexit
    //   254: aload_0
    //   255: aload_0
    //   256: getfield 25	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:b	I
    //   259: iload_2
    //   260: iadd
    //   261: putfield 25	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:b	I
    //   264: goto -219 -> 45
    //   267: astore 6
    //   269: aload 5
    //   271: monitorexit
    //   272: aload 6
    //   274: athrow
    //   275: astore 5
    //   277: aload_0
    //   278: monitorexit
    //   279: aload 5
    //   281: athrow
    //   282: astore 6
    //   284: aload 5
    //   286: monitorexit
    //   287: aload 6
    //   289: athrow
    //   290: astore 5
    //   292: aload_0
    //   293: getfield 14	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
    //   296: invokestatic 44	com/tencent/wcdb/database/SQLiteAsyncCursor:a	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Lcom/tencent/wcdb/database/SQLiteAsyncQuery;
    //   299: invokevirtual 84	com/tencent/wcdb/database/SQLiteAsyncQuery:b	()V
    //   302: aload 5
    //   304: athrow
    //   305: aload_0
    //   306: getfield 14	com/tencent/wcdb/database/SQLiteAsyncCursor$QueryThread:this$0	Lcom/tencent/wcdb/database/SQLiteAsyncCursor;
    //   309: invokestatic 44	com/tencent/wcdb/database/SQLiteAsyncCursor:a	(Lcom/tencent/wcdb/database/SQLiteAsyncCursor;)Lcom/tencent/wcdb/database/SQLiteAsyncQuery;
    //   312: invokevirtual 84	com/tencent/wcdb/database/SQLiteAsyncQuery:b	()V
    //   315: return
    //   316: astore 5
    //   318: goto -13 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	QueryThread
    //   10	229	1	i	int
    //   222	39	2	j	int
    //   172	11	3	l	long
    //   275	10	5	localObject2	Object
    //   290	13	5	localObject3	Object
    //   316	1	5	localInterruptedException	java.lang.InterruptedException
    //   267	6	6	localObject4	Object
    //   282	6	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   199	251	267	finally
    //   251	254	267	finally
    //   269	272	267	finally
    //   53	83	275	finally
    //   86	93	275	finally
    //   277	279	275	finally
    //   23	45	282	finally
    //   284	287	282	finally
    //   0	23	290	finally
    //   45	53	290	finally
    //   93	131	290	finally
    //   131	173	290	finally
    //   181	187	290	finally
    //   187	199	290	finally
    //   254	264	290	finally
    //   272	275	290	finally
    //   279	282	290	finally
    //   287	290	290	finally
    //   0	23	316	java/lang/InterruptedException
    //   45	53	316	java/lang/InterruptedException
    //   93	131	316	java/lang/InterruptedException
    //   131	173	316	java/lang/InterruptedException
    //   181	187	316	java/lang/InterruptedException
    //   187	199	316	java/lang/InterruptedException
    //   254	264	316	java/lang/InterruptedException
    //   272	275	316	java/lang/InterruptedException
    //   279	282	316	java/lang/InterruptedException
    //   287	290	316	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteAsyncCursor.QueryThread
 * JD-Core Version:    0.7.0.1
 */