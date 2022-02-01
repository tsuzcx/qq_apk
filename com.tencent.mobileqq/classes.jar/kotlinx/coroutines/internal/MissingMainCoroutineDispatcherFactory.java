package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcherFactory;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "()V", "loadPriority", "", "getLoadPriority", "()I", "createDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "allFactories", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@InternalCoroutinesApi
public final class MissingMainCoroutineDispatcherFactory
  implements MainDispatcherFactory
{
  public static final MissingMainCoroutineDispatcherFactory INSTANCE = new MissingMainCoroutineDispatcherFactory();
  
  @NotNull
  public MainCoroutineDispatcher createDispatcher(@NotNull List<? extends MainDispatcherFactory> paramList)
  {
    return (MainCoroutineDispatcher)new MissingMainCoroutineDispatcher(null, null, 2, null);
  }
  
  public int getLoadPriority()
  {
    return -1;
  }
  
  @Nullable
  public String hintOnError()
  {
    return MainDispatcherFactory.DefaultImpls.hintOnError(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.MissingMainCoroutineDispatcherFactory
 * JD-Core Version:    0.7.0.1
 */