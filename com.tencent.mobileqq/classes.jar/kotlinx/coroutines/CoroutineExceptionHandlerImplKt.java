package kotlinx.coroutines;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"handlers", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleCoroutineExceptionImpl", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class CoroutineExceptionHandlerImplKt
{
  private static final List<CoroutineExceptionHandler> handlers = SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator()));
  
  public static final void handleCoroutineExceptionImpl(@NotNull CoroutineContext paramCoroutineContext, @NotNull Throwable paramThrowable)
  {
    Iterator localIterator = handlers.iterator();
    while (localIterator.hasNext())
    {
      CoroutineExceptionHandler localCoroutineExceptionHandler = (CoroutineExceptionHandler)localIterator.next();
      try
      {
        localCoroutineExceptionHandler.handleException(paramCoroutineContext, paramThrowable);
      }
      catch (Throwable localThrowable)
      {
        Thread localThread = Thread.currentThread();
        localThread.getUncaughtExceptionHandler().uncaughtException(localThread, CoroutineExceptionHandlerKt.handlerException(paramThrowable, localThrowable));
      }
    }
    paramCoroutineContext = Thread.currentThread();
    paramCoroutineContext.getUncaughtExceptionHandler().uncaughtException(paramCoroutineContext, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CoroutineExceptionHandlerImplKt
 * JD-Core Version:    0.7.0.1
 */