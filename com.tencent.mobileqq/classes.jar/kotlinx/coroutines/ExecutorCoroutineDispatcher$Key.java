package kotlinx.coroutines;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/ExecutorCoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "()V", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@ExperimentalStdlibApi
public final class ExecutorCoroutineDispatcher$Key
  extends AbstractCoroutineContextKey<CoroutineDispatcher, ExecutorCoroutineDispatcher>
{
  private ExecutorCoroutineDispatcher$Key()
  {
    super((CoroutineContext.Key)CoroutineDispatcher.Key, (Function1)ExecutorCoroutineDispatcher.Key.1.INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ExecutorCoroutineDispatcher.Key
 * JD-Core Version:    0.7.0.1
 */