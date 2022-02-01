package okio;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"okio/AsyncTimeout$sink$1", "Lokio/Sink;", "close", "", "flush", "timeout", "Lokio/AsyncTimeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 1, 16})
public final class AsyncTimeout$sink$1
  implements Sink
{
  AsyncTimeout$sink$1(Sink paramSink) {}
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	okio/AsyncTimeout$sink$1:this$0	Lokio/AsyncTimeout;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 50	okio/AsyncTimeout:enter	()V
    //   9: aload_0
    //   10: getfield 37	okio/AsyncTimeout$sink$1:$sink	Lokio/Sink;
    //   13: invokeinterface 52 1 0
    //   18: getstatic 58	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   21: astore_1
    //   22: aload_2
    //   23: invokevirtual 62	okio/AsyncTimeout:exit	()Z
    //   26: ifne +4 -> 30
    //   29: return
    //   30: aload_2
    //   31: aconst_null
    //   32: invokevirtual 66	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
    //   35: checkcast 68	java/lang/Throwable
    //   38: athrow
    //   39: astore_1
    //   40: goto +30 -> 70
    //   43: astore_1
    //   44: aload_2
    //   45: invokevirtual 62	okio/AsyncTimeout:exit	()Z
    //   48: ifne +11 -> 59
    //   51: aload_1
    //   52: checkcast 68	java/lang/Throwable
    //   55: astore_1
    //   56: goto +12 -> 68
    //   59: aload_2
    //   60: aload_1
    //   61: invokevirtual 66	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
    //   64: astore_1
    //   65: goto -14 -> 51
    //   68: aload_1
    //   69: athrow
    //   70: aload_2
    //   71: invokevirtual 62	okio/AsyncTimeout:exit	()Z
    //   74: pop
    //   75: goto +5 -> 80
    //   78: aload_1
    //   79: athrow
    //   80: goto -2 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	1
    //   21	1	1	localUnit	kotlin.Unit
    //   39	1	1	localObject1	Object
    //   43	9	1	localIOException	java.io.IOException
    //   55	24	1	localObject2	Object
    //   4	67	2	localAsyncTimeout	AsyncTimeout
    // Exception table:
    //   from	to	target	type
    //   9	22	39	finally
    //   44	51	39	finally
    //   51	56	39	finally
    //   59	65	39	finally
    //   68	70	39	finally
    //   9	22	43	java/io/IOException
  }
  
  /* Error */
  public void flush()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	okio/AsyncTimeout$sink$1:this$0	Lokio/AsyncTimeout;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 50	okio/AsyncTimeout:enter	()V
    //   9: aload_0
    //   10: getfield 37	okio/AsyncTimeout$sink$1:$sink	Lokio/Sink;
    //   13: invokeinterface 70 1 0
    //   18: getstatic 58	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   21: astore_1
    //   22: aload_2
    //   23: invokevirtual 62	okio/AsyncTimeout:exit	()Z
    //   26: ifne +4 -> 30
    //   29: return
    //   30: aload_2
    //   31: aconst_null
    //   32: invokevirtual 66	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
    //   35: checkcast 68	java/lang/Throwable
    //   38: athrow
    //   39: astore_1
    //   40: goto +30 -> 70
    //   43: astore_1
    //   44: aload_2
    //   45: invokevirtual 62	okio/AsyncTimeout:exit	()Z
    //   48: ifne +11 -> 59
    //   51: aload_1
    //   52: checkcast 68	java/lang/Throwable
    //   55: astore_1
    //   56: goto +12 -> 68
    //   59: aload_2
    //   60: aload_1
    //   61: invokevirtual 66	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
    //   64: astore_1
    //   65: goto -14 -> 51
    //   68: aload_1
    //   69: athrow
    //   70: aload_2
    //   71: invokevirtual 62	okio/AsyncTimeout:exit	()Z
    //   74: pop
    //   75: goto +5 -> 80
    //   78: aload_1
    //   79: athrow
    //   80: goto -2 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	1
    //   21	1	1	localUnit	kotlin.Unit
    //   39	1	1	localObject1	Object
    //   43	9	1	localIOException	java.io.IOException
    //   55	24	1	localObject2	Object
    //   4	67	2	localAsyncTimeout	AsyncTimeout
    // Exception table:
    //   from	to	target	type
    //   9	22	39	finally
    //   44	51	39	finally
    //   51	56	39	finally
    //   59	65	39	finally
    //   68	70	39	finally
    //   9	22	43	java/io/IOException
  }
  
  @NotNull
  public AsyncTimeout timeout()
  {
    return this.this$0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AsyncTimeout.sink(");
    localStringBuilder.append(this.$sink);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  /* Error */
  public void write(@NotNull Buffer paramBuffer, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 98
    //   3: invokestatic 104	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: invokevirtual 110	okio/Buffer:size	()J
    //   10: lconst_0
    //   11: lload_2
    //   12: invokestatic 116	okio/-Util:checkOffsetAndCount	(JJJ)V
    //   15: lconst_0
    //   16: lstore 6
    //   18: lload_2
    //   19: lconst_0
    //   20: lcmp
    //   21: ifle +205 -> 226
    //   24: aload_1
    //   25: getfield 120	okio/Buffer:head	Lokio/Segment;
    //   28: astore 9
    //   30: lload 6
    //   32: lstore 4
    //   34: aload 9
    //   36: astore 8
    //   38: aload 9
    //   40: ifnonnull +14 -> 54
    //   43: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   46: aload 9
    //   48: astore 8
    //   50: lload 6
    //   52: lstore 4
    //   54: lload 4
    //   56: lstore 6
    //   58: lload 4
    //   60: ldc 124
    //   62: i2l
    //   63: lcmp
    //   64: ifge +67 -> 131
    //   67: lload 4
    //   69: aload 8
    //   71: getfield 130	okio/Segment:limit	I
    //   74: aload 8
    //   76: getfield 133	okio/Segment:pos	I
    //   79: isub
    //   80: i2l
    //   81: ladd
    //   82: lstore 6
    //   84: lload 6
    //   86: lload_2
    //   87: lcmp
    //   88: iflt +9 -> 97
    //   91: lload_2
    //   92: lstore 6
    //   94: goto +37 -> 131
    //   97: aload 8
    //   99: getfield 136	okio/Segment:next	Lokio/Segment;
    //   102: astore 9
    //   104: lload 6
    //   106: lstore 4
    //   108: aload 9
    //   110: astore 8
    //   112: aload 9
    //   114: ifnonnull -60 -> 54
    //   117: invokestatic 123	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   120: lload 6
    //   122: lstore 4
    //   124: aload 9
    //   126: astore 8
    //   128: goto -74 -> 54
    //   131: aload_0
    //   132: getfield 35	okio/AsyncTimeout$sink$1:this$0	Lokio/AsyncTimeout;
    //   135: astore 8
    //   137: aload 8
    //   139: invokevirtual 50	okio/AsyncTimeout:enter	()V
    //   142: aload_0
    //   143: getfield 37	okio/AsyncTimeout$sink$1:$sink	Lokio/Sink;
    //   146: aload_1
    //   147: lload 6
    //   149: invokeinterface 138 4 0
    //   154: getstatic 58	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   157: astore 9
    //   159: aload 8
    //   161: invokevirtual 62	okio/AsyncTimeout:exit	()Z
    //   164: ifne +11 -> 175
    //   167: lload_2
    //   168: lload 6
    //   170: lsub
    //   171: lstore_2
    //   172: goto -157 -> 15
    //   175: aload 8
    //   177: aconst_null
    //   178: invokevirtual 66	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
    //   181: checkcast 68	java/lang/Throwable
    //   184: athrow
    //   185: astore_1
    //   186: goto +32 -> 218
    //   189: astore_1
    //   190: aload 8
    //   192: invokevirtual 62	okio/AsyncTimeout:exit	()Z
    //   195: ifne +11 -> 206
    //   198: aload_1
    //   199: checkcast 68	java/lang/Throwable
    //   202: astore_1
    //   203: goto +13 -> 216
    //   206: aload 8
    //   208: aload_1
    //   209: invokevirtual 66	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
    //   212: astore_1
    //   213: goto -15 -> 198
    //   216: aload_1
    //   217: athrow
    //   218: aload 8
    //   220: invokevirtual 62	okio/AsyncTimeout:exit	()Z
    //   223: pop
    //   224: aload_1
    //   225: athrow
    //   226: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	1
    //   0	227	1	paramBuffer	Buffer
    //   0	227	2	paramLong	long
    //   32	91	4	l1	long
    //   16	153	6	l2	long
    //   36	183	8	localObject1	Object
    //   28	130	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   142	159	185	finally
    //   190	198	185	finally
    //   198	203	185	finally
    //   206	213	185	finally
    //   216	218	185	finally
    //   142	159	189	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.AsyncTimeout.sink.1
 * JD-Core Version:    0.7.0.1
 */