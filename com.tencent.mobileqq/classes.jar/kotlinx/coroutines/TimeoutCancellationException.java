package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "(Ljava/lang/String;)V", "coroutine", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Lkotlinx/coroutines/Job;)V", "createCopy", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class TimeoutCancellationException
  extends CancellationException
  implements CopyableThrowable<TimeoutCancellationException>
{
  @JvmField
  @Nullable
  public final Job coroutine;
  
  public TimeoutCancellationException(@NotNull String paramString)
  {
    this(paramString, null);
  }
  
  public TimeoutCancellationException(@NotNull String paramString, @Nullable Job paramJob)
  {
    super(paramString);
    this.coroutine = paramJob;
  }
  
  @Nullable
  public TimeoutCancellationException createCopy()
  {
    Object localObject = getMessage();
    if (localObject == null) {
      localObject = "";
    }
    localObject = new TimeoutCancellationException((String)localObject, this.coroutine);
    ((TimeoutCancellationException)localObject).initCause((Throwable)this);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.TimeoutCancellationException
 * JD-Core Version:    0.7.0.1
 */