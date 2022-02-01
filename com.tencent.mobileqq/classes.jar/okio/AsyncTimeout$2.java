package okio;

class AsyncTimeout$2
  implements Source
{
  AsyncTimeout$2(AsyncTimeout paramAsyncTimeout, Source paramSource) {}
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	okio/AsyncTimeout$2:val$source	Lokio/Source;
    //   4: invokeinterface 25 1 0
    //   9: aload_0
    //   10: getfield 14	okio/AsyncTimeout$2:this$0	Lokio/AsyncTimeout;
    //   13: iconst_1
    //   14: invokevirtual 31	okio/AsyncTimeout:exit	(Z)V
    //   17: return
    //   18: astore_1
    //   19: goto +13 -> 32
    //   22: astore_1
    //   23: aload_0
    //   24: getfield 14	okio/AsyncTimeout$2:this$0	Lokio/AsyncTimeout;
    //   27: aload_1
    //   28: invokevirtual 34	okio/AsyncTimeout:exit	(Ljava/io/IOException;)Ljava/io/IOException;
    //   31: athrow
    //   32: aload_0
    //   33: getfield 14	okio/AsyncTimeout$2:this$0	Lokio/AsyncTimeout;
    //   36: iconst_0
    //   37: invokevirtual 31	okio/AsyncTimeout:exit	(Z)V
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	2
    //   18	1	1	localObject	Object
    //   22	19	1	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   0	9	18	finally
    //   23	32	18	finally
    //   0	9	22	java/io/IOException
  }
  
  /* Error */
  public long read(Buffer paramBuffer, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	okio/AsyncTimeout$2:this$0	Lokio/AsyncTimeout;
    //   4: invokevirtual 39	okio/AsyncTimeout:enter	()V
    //   7: aload_0
    //   8: getfield 16	okio/AsyncTimeout$2:val$source	Lokio/Source;
    //   11: aload_1
    //   12: lload_2
    //   13: invokeinterface 41 4 0
    //   18: lstore_2
    //   19: aload_0
    //   20: getfield 14	okio/AsyncTimeout$2:this$0	Lokio/AsyncTimeout;
    //   23: iconst_1
    //   24: invokevirtual 31	okio/AsyncTimeout:exit	(Z)V
    //   27: lload_2
    //   28: lreturn
    //   29: astore_1
    //   30: goto +13 -> 43
    //   33: astore_1
    //   34: aload_0
    //   35: getfield 14	okio/AsyncTimeout$2:this$0	Lokio/AsyncTimeout;
    //   38: aload_1
    //   39: invokevirtual 34	okio/AsyncTimeout:exit	(Ljava/io/IOException;)Ljava/io/IOException;
    //   42: athrow
    //   43: aload_0
    //   44: getfield 14	okio/AsyncTimeout$2:this$0	Lokio/AsyncTimeout;
    //   47: iconst_0
    //   48: invokevirtual 31	okio/AsyncTimeout:exit	(Z)V
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	2
    //   0	53	1	paramBuffer	Buffer
    //   0	53	2	paramLong	long
    // Exception table:
    //   from	to	target	type
    //   7	19	29	finally
    //   34	43	29	finally
    //   7	19	33	java/io/IOException
  }
  
  public Timeout timeout()
  {
    return this.this$0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AsyncTimeout.source(");
    localStringBuilder.append(this.val$source);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.AsyncTimeout.2
 * JD-Core Version:    0.7.0.1
 */