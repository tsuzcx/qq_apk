package kotlin.io;

import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"closeFinally", "", "Ljava/io/Closeable;", "cause", "", "use", "R", "T", "block", "Lkotlin/Function1;", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="CloseableKt")
public final class CloseableKt
{
  @PublishedApi
  @SinceKotlin(version="1.1")
  public static final void closeFinally(@Nullable Closeable paramCloseable, @Nullable Throwable paramThrowable)
  {
    if (paramCloseable == null) {
      return;
    }
    if (paramThrowable == null)
    {
      paramCloseable.close();
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable)
    {
      ExceptionsKt.addSuppressed(paramThrowable, paramCloseable);
    }
  }
  
  /* Error */
  @kotlin.internal.InlineOnly
  private static final <T extends Closeable, R> R use(T paramT, kotlin.jvm.functions.Function1<? super T, ? extends R> paramFunction1)
  {
    // Byte code:
    //   0: aconst_null
    //   1: checkcast 39	java/lang/Throwable
    //   4: astore_2
    //   5: aload_1
    //   6: aload_0
    //   7: invokeinterface 61 2 0
    //   12: astore_1
    //   13: iconst_1
    //   14: invokestatic 67	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   17: iconst_1
    //   18: iconst_1
    //   19: iconst_0
    //   20: invokestatic 73	kotlin/internal/PlatformImplementationsKt:apiVersionIsAtLeast	(III)Z
    //   23: ifeq +14 -> 37
    //   26: aload_0
    //   27: aload_2
    //   28: invokestatic 75	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   31: iconst_1
    //   32: invokestatic 78	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   35: aload_1
    //   36: areturn
    //   37: aload_0
    //   38: ifnull -7 -> 31
    //   41: aload_0
    //   42: invokeinterface 45 1 0
    //   47: goto -16 -> 31
    //   50: astore_2
    //   51: aload_2
    //   52: athrow
    //   53: astore_1
    //   54: iconst_1
    //   55: invokestatic 67	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   58: iconst_1
    //   59: iconst_1
    //   60: iconst_0
    //   61: invokestatic 73	kotlin/internal/PlatformImplementationsKt:apiVersionIsAtLeast	(III)Z
    //   64: ifeq +14 -> 78
    //   67: aload_0
    //   68: aload_2
    //   69: invokestatic 75	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   72: iconst_1
    //   73: invokestatic 78	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   76: aload_1
    //   77: athrow
    //   78: aload_0
    //   79: ifnull -7 -> 72
    //   82: aload_2
    //   83: ifnonnull +12 -> 95
    //   86: aload_0
    //   87: invokeinterface 45 1 0
    //   92: goto -20 -> 72
    //   95: aload_0
    //   96: invokeinterface 45 1 0
    //   101: goto -29 -> 72
    //   104: astore_0
    //   105: goto -33 -> 72
    //   108: astore_1
    //   109: goto -55 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramT	T
    //   0	112	1	paramFunction1	kotlin.jvm.functions.Function1<? super T, ? extends R>
    //   4	24	2	localThrowable1	Throwable
    //   50	33	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   5	13	50	java/lang/Throwable
    //   51	53	53	finally
    //   95	101	104	java/lang/Throwable
    //   5	13	108	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.io.CloseableKt
 * JD-Core Version:    0.7.0.1
 */