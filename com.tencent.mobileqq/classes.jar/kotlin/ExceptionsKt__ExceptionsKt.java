package kotlin;

import java.io.PrintStream;
import java.io.PrintWriter;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementations;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"stackTrace", "", "Ljava/lang/StackTraceElement;", "", "stackTrace$annotations", "(Ljava/lang/Throwable;)V", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "addSuppressed", "", "exception", "printStackTrace", "stream", "Ljava/io/PrintStream;", "writer", "Ljava/io/PrintWriter;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/ExceptionsKt")
public class ExceptionsKt__ExceptionsKt
{
  public static final void addSuppressed(@NotNull Throwable paramThrowable1, @NotNull Throwable paramThrowable2)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable1, "$this$addSuppressed");
    Intrinsics.checkParameterIsNotNull(paramThrowable2, "exception");
    PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(paramThrowable1, paramThrowable2);
  }
  
  @NotNull
  public static final StackTraceElement[] getStackTrace(@NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable, "$this$stackTrace");
    paramThrowable = paramThrowable.getStackTrace();
    if (paramThrowable == null) {
      Intrinsics.throwNpe();
    }
    return paramThrowable;
  }
  
  @InlineOnly
  private static final void printStackTrace(@NotNull Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Throwable");
    }
    paramThrowable.printStackTrace();
  }
  
  @InlineOnly
  private static final void printStackTrace(@NotNull Throwable paramThrowable, PrintStream paramPrintStream)
  {
    if (paramThrowable == null) {
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Throwable");
    }
    paramThrowable.printStackTrace(paramPrintStream);
  }
  
  @InlineOnly
  private static final void printStackTrace(@NotNull Throwable paramThrowable, PrintWriter paramPrintWriter)
  {
    if (paramThrowable == null) {
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Throwable");
    }
    paramThrowable.printStackTrace(paramPrintWriter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.ExceptionsKt__ExceptionsKt
 * JD-Core Version:    0.7.0.1
 */