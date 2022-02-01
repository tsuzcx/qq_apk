package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.JvmField;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/YieldContext;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "()V", "dispatcherWasUnconfined", "", "Key", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class YieldContext
  extends AbstractCoroutineContextElement
{
  public static final YieldContext.Key Key = new YieldContext.Key(null);
  @JvmField
  public boolean dispatcherWasUnconfined;
  
  public YieldContext()
  {
    super((CoroutineContext.Key)Key);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.YieldContext
 * JD-Core Version:    0.7.0.1
 */