package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"FAST_SERVICE_LOADER_PROPERTY_NAME", "", "SUPPORT_MISSING", "", "SUPPORT_MISSING$annotations", "()V", "createMissingDispatcher", "Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "cause", "", "errorHint", "throwMissingMainDispatcherException", "", "isMissing", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "tryCreateDispatcher", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "factories", "", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class MainDispatchersKt
{
  private static final String FAST_SERVICE_LOADER_PROPERTY_NAME = "kotlinx.coroutines.fast.service.loader";
  private static final boolean SUPPORT_MISSING = true;
  
  private static final MissingMainCoroutineDispatcher createMissingDispatcher(Throwable paramThrowable, String paramString)
  {
    if (SUPPORT_MISSING) {
      return new MissingMainCoroutineDispatcher(paramThrowable, paramString);
    }
    if (paramThrowable != null) {
      throw paramThrowable;
    }
    throwMissingMainDispatcherException();
    throw null;
  }
  
  @InternalCoroutinesApi
  public static final boolean isMissing(@NotNull MainCoroutineDispatcher paramMainCoroutineDispatcher)
  {
    return paramMainCoroutineDispatcher instanceof MissingMainCoroutineDispatcher;
  }
  
  @NotNull
  public static final Void throwMissingMainDispatcherException()
  {
    throw ((Throwable)new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'"));
  }
  
  @InternalCoroutinesApi
  @NotNull
  public static final MainCoroutineDispatcher tryCreateDispatcher(@NotNull MainDispatcherFactory paramMainDispatcherFactory, @NotNull List<? extends MainDispatcherFactory> paramList)
  {
    try
    {
      paramList = paramMainDispatcherFactory.createDispatcher(paramList);
      return paramList;
    }
    catch (Throwable paramList) {}
    return (MainCoroutineDispatcher)createMissingDispatcher(paramList, paramMainDispatcherFactory.hintOnError());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.MainDispatchersKt
 * JD-Core Version:    0.7.0.1
 */