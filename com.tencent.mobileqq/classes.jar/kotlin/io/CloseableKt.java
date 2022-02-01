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
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: aload_1
    //   8: aload_0
    //   9: invokeinterface 61 2 0
    //   14: astore_1
    //   15: iconst_1
    //   16: invokestatic 67	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   19: iconst_1
    //   20: iconst_1
    //   21: iconst_0
    //   22: invokestatic 73	kotlin/internal/PlatformImplementationsKt:apiVersionIsAtLeast	(III)Z
    //   25: ifeq +11 -> 36
    //   28: aload_0
    //   29: aload_3
    //   30: invokestatic 75	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   33: goto +16 -> 49
    //   36: aload_0
    //   37: ifnonnull +6 -> 43
    //   40: goto +9 -> 49
    //   43: aload_0
    //   44: invokeinterface 45 1 0
    //   49: iconst_1
    //   50: invokestatic 78	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   53: aload_1
    //   54: areturn
    //   55: astore_1
    //   56: goto +8 -> 64
    //   59: astore_1
    //   60: aload_1
    //   61: astore_2
    //   62: aload_1
    //   63: athrow
    //   64: iconst_1
    //   65: invokestatic 67	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   68: iconst_1
    //   69: iconst_1
    //   70: iconst_0
    //   71: invokestatic 73	kotlin/internal/PlatformImplementationsKt:apiVersionIsAtLeast	(III)Z
    //   74: ifne +29 -> 103
    //   77: aload_0
    //   78: ifnull +30 -> 108
    //   81: aload_2
    //   82: ifnonnull +12 -> 94
    //   85: aload_0
    //   86: invokeinterface 45 1 0
    //   91: goto +17 -> 108
    //   94: aload_0
    //   95: invokeinterface 45 1 0
    //   100: goto +8 -> 108
    //   103: aload_0
    //   104: aload_2
    //   105: invokestatic 75	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   108: iconst_1
    //   109: invokestatic 78	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   112: aload_1
    //   113: athrow
    //   114: astore_0
    //   115: goto -7 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramT	T
    //   0	118	1	paramFunction1	kotlin.jvm.functions.Function1<? super T, ? extends R>
    //   6	99	2	localObject	Object
    //   4	26	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	15	55	finally
    //   62	64	55	finally
    //   7	15	59	java/lang/Throwable
    //   94	100	114	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.io.CloseableKt
 * JD-Core Version:    0.7.0.1
 */