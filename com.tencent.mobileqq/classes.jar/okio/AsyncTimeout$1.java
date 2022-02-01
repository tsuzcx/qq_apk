package okio;

class AsyncTimeout$1
  implements Sink
{
  AsyncTimeout$1(AsyncTimeout paramAsyncTimeout, Sink paramSink) {}
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
    //   4: invokevirtual 28	okio/AsyncTimeout:enter	()V
    //   7: aload_0
    //   8: getfield 16	okio/AsyncTimeout$1:val$sink	Lokio/Sink;
    //   11: invokeinterface 30 1 0
    //   16: aload_0
    //   17: getfield 14	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
    //   20: iconst_1
    //   21: invokevirtual 34	okio/AsyncTimeout:exit	(Z)V
    //   24: return
    //   25: astore_1
    //   26: goto +13 -> 39
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 14	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
    //   34: aload_1
    //   35: invokevirtual 37	okio/AsyncTimeout:exit	(Ljava/io/IOException;)Ljava/io/IOException;
    //   38: athrow
    //   39: aload_0
    //   40: getfield 14	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
    //   43: iconst_0
    //   44: invokevirtual 34	okio/AsyncTimeout:exit	(Z)V
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	1
    //   25	1	1	localObject	Object
    //   29	19	1	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   7	16	25	finally
    //   30	39	25	finally
    //   7	16	29	java/io/IOException
  }
  
  /* Error */
  public void flush()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
    //   4: invokevirtual 28	okio/AsyncTimeout:enter	()V
    //   7: aload_0
    //   8: getfield 16	okio/AsyncTimeout$1:val$sink	Lokio/Sink;
    //   11: invokeinterface 40 1 0
    //   16: aload_0
    //   17: getfield 14	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
    //   20: iconst_1
    //   21: invokevirtual 34	okio/AsyncTimeout:exit	(Z)V
    //   24: return
    //   25: astore_1
    //   26: goto +13 -> 39
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 14	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
    //   34: aload_1
    //   35: invokevirtual 37	okio/AsyncTimeout:exit	(Ljava/io/IOException;)Ljava/io/IOException;
    //   38: athrow
    //   39: aload_0
    //   40: getfield 14	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
    //   43: iconst_0
    //   44: invokevirtual 34	okio/AsyncTimeout:exit	(Z)V
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	1
    //   25	1	1	localObject	Object
    //   29	19	1	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   7	16	25	finally
    //   30	39	25	finally
    //   7	16	29	java/io/IOException
  }
  
  public Timeout timeout()
  {
    return this.this$0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AsyncTimeout.sink(");
    localStringBuilder.append(this.val$sink);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public void write(Buffer paramBuffer, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 68	okio/Buffer:size	J
    //   4: lconst_0
    //   5: lload_2
    //   6: invokestatic 74	okio/Util:checkOffsetAndCount	(JJJ)V
    //   9: lconst_0
    //   10: lstore 4
    //   12: lload_2
    //   13: lconst_0
    //   14: lcmp
    //   15: ifle +121 -> 136
    //   18: aload_1
    //   19: getfield 78	okio/Buffer:head	Lokio/Segment;
    //   22: astore 8
    //   24: lload 4
    //   26: lstore 6
    //   28: lload 4
    //   30: ldc2_w 79
    //   33: lcmp
    //   34: ifge +43 -> 77
    //   37: lload 4
    //   39: aload 8
    //   41: getfield 86	okio/Segment:limit	I
    //   44: aload 8
    //   46: getfield 89	okio/Segment:pos	I
    //   49: isub
    //   50: i2l
    //   51: ladd
    //   52: lstore 4
    //   54: lload 4
    //   56: lload_2
    //   57: lcmp
    //   58: iflt +9 -> 67
    //   61: lload_2
    //   62: lstore 6
    //   64: goto +13 -> 77
    //   67: aload 8
    //   69: getfield 92	okio/Segment:next	Lokio/Segment;
    //   72: astore 8
    //   74: goto -50 -> 24
    //   77: aload_0
    //   78: getfield 14	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
    //   81: invokevirtual 28	okio/AsyncTimeout:enter	()V
    //   84: aload_0
    //   85: getfield 16	okio/AsyncTimeout$1:val$sink	Lokio/Sink;
    //   88: aload_1
    //   89: lload 6
    //   91: invokeinterface 94 4 0
    //   96: lload_2
    //   97: lload 6
    //   99: lsub
    //   100: lstore_2
    //   101: aload_0
    //   102: getfield 14	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
    //   105: iconst_1
    //   106: invokevirtual 34	okio/AsyncTimeout:exit	(Z)V
    //   109: goto -100 -> 9
    //   112: astore_1
    //   113: goto +13 -> 126
    //   116: astore_1
    //   117: aload_0
    //   118: getfield 14	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
    //   121: aload_1
    //   122: invokevirtual 37	okio/AsyncTimeout:exit	(Ljava/io/IOException;)Ljava/io/IOException;
    //   125: athrow
    //   126: aload_0
    //   127: getfield 14	okio/AsyncTimeout$1:this$0	Lokio/AsyncTimeout;
    //   130: iconst_0
    //   131: invokevirtual 34	okio/AsyncTimeout:exit	(Z)V
    //   134: aload_1
    //   135: athrow
    //   136: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	1
    //   0	137	1	paramBuffer	Buffer
    //   0	137	2	paramLong	long
    //   10	45	4	l1	long
    //   26	72	6	l2	long
    //   22	51	8	localSegment	Segment
    // Exception table:
    //   from	to	target	type
    //   84	96	112	finally
    //   117	126	112	finally
    //   84	96	116	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.AsyncTimeout.1
 * JD-Core Version:    0.7.0.1
 */