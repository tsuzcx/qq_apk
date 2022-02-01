package okio;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"okio/AsyncTimeout$source$1", "Lokio/Source;", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/AsyncTimeout;", "toString", "", "okio"}, k=1, mv={1, 1, 16})
public final class AsyncTimeout$source$1
  implements Source
{
  AsyncTimeout$source$1(Source paramSource) {}
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	okio/AsyncTimeout$source$1:this$0	Lokio/AsyncTimeout;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 49	okio/AsyncTimeout:enter	()V
    //   9: aload_0
    //   10: getfield 36	okio/AsyncTimeout$source$1:$source	Lokio/Source;
    //   13: invokeinterface 51 1 0
    //   18: getstatic 57	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   21: astore_1
    //   22: aload_2
    //   23: invokevirtual 61	okio/AsyncTimeout:exit	()Z
    //   26: ifne +4 -> 30
    //   29: return
    //   30: aload_2
    //   31: aconst_null
    //   32: invokevirtual 65	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
    //   35: checkcast 67	java/lang/Throwable
    //   38: athrow
    //   39: astore_1
    //   40: goto +30 -> 70
    //   43: astore_1
    //   44: aload_2
    //   45: invokevirtual 61	okio/AsyncTimeout:exit	()Z
    //   48: ifne +11 -> 59
    //   51: aload_1
    //   52: checkcast 67	java/lang/Throwable
    //   55: astore_1
    //   56: goto +12 -> 68
    //   59: aload_2
    //   60: aload_1
    //   61: invokevirtual 65	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
    //   64: astore_1
    //   65: goto -14 -> 51
    //   68: aload_1
    //   69: athrow
    //   70: aload_2
    //   71: invokevirtual 61	okio/AsyncTimeout:exit	()Z
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
  public long read(@NotNull Buffer paramBuffer, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 70
    //   3: invokestatic 76	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: getfield 34	okio/AsyncTimeout$source$1:this$0	Lokio/AsyncTimeout;
    //   10: astore 4
    //   12: aload 4
    //   14: invokevirtual 49	okio/AsyncTimeout:enter	()V
    //   17: aload_0
    //   18: getfield 36	okio/AsyncTimeout$source$1:$source	Lokio/Source;
    //   21: aload_1
    //   22: lload_2
    //   23: invokeinterface 78 4 0
    //   28: lstore_2
    //   29: aload 4
    //   31: invokevirtual 61	okio/AsyncTimeout:exit	()Z
    //   34: ifne +5 -> 39
    //   37: lload_2
    //   38: lreturn
    //   39: aload 4
    //   41: aconst_null
    //   42: invokevirtual 65	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
    //   45: checkcast 67	java/lang/Throwable
    //   48: athrow
    //   49: astore_1
    //   50: goto +32 -> 82
    //   53: astore_1
    //   54: aload 4
    //   56: invokevirtual 61	okio/AsyncTimeout:exit	()Z
    //   59: ifne +11 -> 70
    //   62: aload_1
    //   63: checkcast 67	java/lang/Throwable
    //   66: astore_1
    //   67: goto +13 -> 80
    //   70: aload 4
    //   72: aload_1
    //   73: invokevirtual 65	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
    //   76: astore_1
    //   77: goto -15 -> 62
    //   80: aload_1
    //   81: athrow
    //   82: aload 4
    //   84: invokevirtual 61	okio/AsyncTimeout:exit	()Z
    //   87: pop
    //   88: goto +5 -> 93
    //   91: aload_1
    //   92: athrow
    //   93: goto -2 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	1
    //   0	96	1	paramBuffer	Buffer
    //   0	96	2	paramLong	long
    //   10	73	4	localAsyncTimeout	AsyncTimeout
    // Exception table:
    //   from	to	target	type
    //   17	29	49	finally
    //   54	62	49	finally
    //   62	67	49	finally
    //   70	77	49	finally
    //   80	82	49	finally
    //   17	29	53	java/io/IOException
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
    localStringBuilder.append("AsyncTimeout.source(");
    localStringBuilder.append(this.$source);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.AsyncTimeout.source.1
 * JD-Core Version:    0.7.0.1
 */