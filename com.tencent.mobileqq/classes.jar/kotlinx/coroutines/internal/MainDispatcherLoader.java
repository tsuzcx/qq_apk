package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "()V", "FAST_SERVICE_LOADER_ENABLED", "", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class MainDispatcherLoader
{
  private static final boolean FAST_SERVICE_LOADER_ENABLED;
  public static final MainDispatcherLoader INSTANCE;
  @JvmField
  @NotNull
  public static final MainCoroutineDispatcher dispatcher;
  
  static
  {
    MainDispatcherLoader localMainDispatcherLoader = new MainDispatcherLoader();
    INSTANCE = localMainDispatcherLoader;
    FAST_SERVICE_LOADER_ENABLED = SystemPropsKt.systemProp("kotlinx.coroutines.fast.service.loader", true);
    dispatcher = localMainDispatcherLoader.loadMainDispatcher();
  }
  
  private final MainCoroutineDispatcher loadMainDispatcher()
  {
    try
    {
      List localList;
      if (FAST_SERVICE_LOADER_ENABLED) {
        localList = FastServiceLoader.INSTANCE.loadMainDispatcherFactory$kotlinx_coroutines_core();
      } else {
        localList = SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));
      }
      Iterator localIterator = ((Iterable)localList).iterator();
      if (!localIterator.hasNext())
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = localIterator.next();
        if (localIterator.hasNext())
        {
          int i = ((MainDispatcherFactory)localObject1).getLoadPriority();
          Object localObject2 = localObject1;
          do
          {
            Object localObject3 = localIterator.next();
            int k = ((MainDispatcherFactory)localObject3).getLoadPriority();
            localObject1 = localObject2;
            int j = i;
            if (i < k)
            {
              localObject1 = localObject3;
              j = k;
            }
            localObject2 = localObject1;
            i = j;
          } while (localIterator.hasNext());
        }
      }
      Object localObject1 = (MainDispatcherFactory)localObject1;
      if (localObject1 != null)
      {
        localObject1 = MainDispatchersKt.tryCreateDispatcher((MainDispatcherFactory)localObject1, localList);
        if (localObject1 != null) {
          return localObject1;
        }
      }
      localObject1 = (MainCoroutineDispatcher)MainDispatchersKt.createMissingDispatcher$default(null, null, 3, null);
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      return (MainCoroutineDispatcher)MainDispatchersKt.createMissingDispatcher$default(localThrowable, null, 2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.MainDispatcherLoader
 * JD-Core Version:    0.7.0.1
 */