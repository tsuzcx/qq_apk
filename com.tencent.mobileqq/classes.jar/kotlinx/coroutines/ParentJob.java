package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Deprecated(level=DeprecationLevel.ERROR, message="This is internal API and may be removed in the future releases")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/ParentJob;", "Lkotlinx/coroutines/Job;", "getChildJobCancellationCause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@InternalCoroutinesApi
public abstract interface ParentJob
  extends Job
{
  @InternalCoroutinesApi
  @NotNull
  public abstract CancellationException getChildJobCancellationCause();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ParentJob
 * JD-Core Version:    0.7.0.1
 */