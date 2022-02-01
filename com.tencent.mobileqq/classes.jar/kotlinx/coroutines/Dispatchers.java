package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/Dispatchers;", "", "()V", "Default", "Lkotlinx/coroutines/CoroutineDispatcher;", "Default$annotations", "getDefault", "()Lkotlinx/coroutines/CoroutineDispatcher;", "IO", "IO$annotations", "getIO", "Main", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Main$annotations", "getMain", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "Unconfined", "Unconfined$annotations", "getUnconfined", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class Dispatchers
{
  @NotNull
  private static final CoroutineDispatcher Default;
  public static final Dispatchers INSTANCE = new Dispatchers();
  @NotNull
  private static final CoroutineDispatcher IO = DefaultScheduler.INSTANCE.getIO();
  @NotNull
  private static final CoroutineDispatcher Unconfined;
  
  static
  {
    Default = CoroutineContextKt.createDefaultDispatcher();
    Unconfined = (CoroutineDispatcher)Unconfined.INSTANCE;
  }
  
  @NotNull
  public static final CoroutineDispatcher getDefault()
  {
    return Default;
  }
  
  @NotNull
  public static final CoroutineDispatcher getIO()
  {
    return IO;
  }
  
  @NotNull
  public static final MainCoroutineDispatcher getMain()
  {
    return MainDispatcherLoader.dispatcher;
  }
  
  @NotNull
  public static final CoroutineDispatcher getUnconfined()
  {
    return Unconfined;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.Dispatchers
 * JD-Core Version:    0.7.0.1
 */