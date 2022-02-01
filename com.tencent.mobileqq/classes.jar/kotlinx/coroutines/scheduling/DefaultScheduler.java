package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "()V", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "close", "", "toDebugString", "", "toString", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class DefaultScheduler
  extends ExperimentalCoroutineDispatcher
{
  public static final DefaultScheduler INSTANCE;
  @NotNull
  private static final CoroutineDispatcher IO;
  
  static
  {
    DefaultScheduler localDefaultScheduler = new DefaultScheduler();
    INSTANCE = localDefaultScheduler;
    IO = localDefaultScheduler.blocking(SystemPropsKt.systemProp$default("kotlinx.coroutines.io.parallelism", RangesKt.coerceAtLeast(64, SystemPropsKt.getAVAILABLE_PROCESSORS()), 0, 0, 12, null));
  }
  
  private DefaultScheduler()
  {
    super(0, 0, null, 7, null);
  }
  
  public void close()
  {
    throw ((Throwable)new UnsupportedOperationException("DefaultDispatcher cannot be closed"));
  }
  
  @NotNull
  public final CoroutineDispatcher getIO()
  {
    return IO;
  }
  
  @InternalCoroutinesApi
  @NotNull
  public final String toDebugString()
  {
    return super.toString();
  }
  
  @NotNull
  public String toString()
  {
    return "DefaultDispatcher";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.scheduling.DefaultScheduler
 * JD-Core Version:    0.7.0.1
 */