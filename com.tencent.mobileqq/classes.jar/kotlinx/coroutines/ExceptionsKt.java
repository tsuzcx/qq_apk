package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"CancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "cause", "", "addSuppressedThrowable", "", "other", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class ExceptionsKt
{
  @NotNull
  public static final CancellationException CancellationException(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    paramString = new CancellationException(paramString);
    paramString.initCause(paramThrowable);
    return paramString;
  }
  
  public static final void addSuppressedThrowable(@NotNull Throwable paramThrowable1, @NotNull Throwable paramThrowable2)
  {
    kotlin.ExceptionsKt.addSuppressed(paramThrowable1, paramThrowable2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ExceptionsKt
 * JD-Core Version:    0.7.0.1
 */