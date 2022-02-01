package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "createCopy", "equals", "", "other", "", "fillInStackTrace", "hashCode", "", "toString", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class JobCancellationException
  extends CancellationException
  implements CopyableThrowable<JobCancellationException>
{
  @JvmField
  @NotNull
  public final Job job;
  
  public JobCancellationException(@NotNull String paramString, @Nullable Throwable paramThrowable, @NotNull Job paramJob)
  {
    super(paramString);
    this.job = paramJob;
    if (paramThrowable != null) {
      initCause(paramThrowable);
    }
  }
  
  @Nullable
  public JobCancellationException createCopy()
  {
    if (DebugKt.getDEBUG())
    {
      String str = getMessage();
      if (str == null) {
        Intrinsics.throwNpe();
      }
      return new JobCancellationException(str, (Throwable)this, this.job);
    }
    return null;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject != (JobCancellationException)this) {
      if ((paramObject instanceof JobCancellationException))
      {
        paramObject = (JobCancellationException)paramObject;
        if ((Intrinsics.areEqual(paramObject.getMessage(), getMessage())) && (Intrinsics.areEqual(paramObject.job, this.job)) && (Intrinsics.areEqual(paramObject.getCause(), getCause()))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public Throwable fillInStackTrace()
  {
    if (DebugKt.getDEBUG()) {
      return super.fillInStackTrace();
    }
    return (Throwable)this;
  }
  
  public int hashCode()
  {
    Object localObject = getMessage();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    int j = ((String)localObject).hashCode();
    int k = this.job.hashCode();
    localObject = getCause();
    int i;
    if (localObject != null) {
      i = ((Throwable)localObject).hashCode();
    } else {
      i = 0;
    }
    return (j * 31 + k) * 31 + i;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("; job=");
    localStringBuilder.append(this.job);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.JobCancellationException
 * JD-Core Version:    0.7.0.1
 */