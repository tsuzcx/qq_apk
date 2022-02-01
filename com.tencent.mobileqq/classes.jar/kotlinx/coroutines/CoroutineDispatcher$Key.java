package kotlinx.coroutines;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/CoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@ExperimentalStdlibApi
public final class CoroutineDispatcher$Key
  extends AbstractCoroutineContextKey<ContinuationInterceptor, CoroutineDispatcher>
{
  private CoroutineDispatcher$Key()
  {
    super((CoroutineContext.Key)ContinuationInterceptor.Key, (Function1)CoroutineDispatcher.Key.1.INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CoroutineDispatcher.Key
 * JD-Core Version:    0.7.0.1
 */