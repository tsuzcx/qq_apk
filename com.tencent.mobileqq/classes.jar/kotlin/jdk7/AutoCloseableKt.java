package kotlin.jdk7;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"closeFinally", "", "Ljava/lang/AutoCloseable;", "cause", "", "use", "R", "T", "block", "Lkotlin/Function1;", "(Ljava/lang/AutoCloseable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib-jdk7"}, k=2, mv={1, 1, 16}, pn="kotlin")
@JvmName(name="AutoCloseableKt")
public final class AutoCloseableKt
{
  @PublishedApi
  @SinceKotlin(version="1.2")
  public static final void closeFinally(@Nullable AutoCloseable paramAutoCloseable, @Nullable Throwable paramThrowable)
  {
    if (paramAutoCloseable == null) {
      return;
    }
    if (paramThrowable == null)
    {
      paramAutoCloseable.close();
      return;
    }
    try
    {
      paramAutoCloseable.close();
      return;
    }
    catch (Throwable paramAutoCloseable) {}
  }
  
  /* Error */
  @SinceKotlin(version="1.2")
  @kotlin.internal.InlineOnly
  private static final <T extends AutoCloseable, R> R use(T paramT, kotlin.jvm.functions.Function1<? super T, ? extends R> paramFunction1)
  {
    // Byte code:
    //   0: aconst_null
    //   1: checkcast 40	java/lang/Throwable
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: aload_1
    //   8: aload_0
    //   9: invokeinterface 56 2 0
    //   14: astore_1
    //   15: iconst_1
    //   16: invokestatic 62	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   19: aload_0
    //   20: aload_3
    //   21: invokestatic 64	kotlin/jdk7/AutoCloseableKt:closeFinally	(Ljava/lang/AutoCloseable;Ljava/lang/Throwable;)V
    //   24: iconst_1
    //   25: invokestatic 67	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   28: aload_1
    //   29: areturn
    //   30: astore_1
    //   31: goto +8 -> 39
    //   34: astore_1
    //   35: aload_1
    //   36: astore_2
    //   37: aload_1
    //   38: athrow
    //   39: iconst_1
    //   40: invokestatic 62	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   43: aload_0
    //   44: aload_2
    //   45: invokestatic 64	kotlin/jdk7/AutoCloseableKt:closeFinally	(Ljava/lang/AutoCloseable;Ljava/lang/Throwable;)V
    //   48: iconst_1
    //   49: invokestatic 67	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramT	T
    //   0	54	1	paramFunction1	kotlin.jvm.functions.Function1<? super T, ? extends R>
    //   6	39	2	localObject	Object
    //   4	17	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	15	30	finally
    //   37	39	30	finally
    //   7	15	34	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.jdk7.AutoCloseableKt
 * JD-Core Version:    0.7.0.1
 */