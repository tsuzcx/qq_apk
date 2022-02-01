package kotlinx.coroutines.test;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"withTestContext", "", "testContext", "Lkotlinx/coroutines/test/TestCoroutineContext;", "testBody", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class TestCoroutineContextKt
{
  @Deprecated(level=DeprecationLevel.WARNING, message="This API has been deprecated to integrate with Structured Concurrency.", replaceWith=@ReplaceWith(expression="testContext.runBlockingTest(testBody)", imports={"kotlin.coroutines.test"}))
  public static final void withTestContext(@NotNull TestCoroutineContext paramTestCoroutineContext, @NotNull Function1<? super TestCoroutineContext, Unit> paramFunction1)
  {
    paramFunction1.invoke(paramTestCoroutineContext);
    paramFunction1 = (Iterable)paramTestCoroutineContext.getExceptions();
    boolean bool = paramFunction1 instanceof Collection;
    int j = 1;
    int i;
    if ((bool) && (((Collection)paramFunction1).isEmpty()))
    {
      i = j;
    }
    else
    {
      paramFunction1 = paramFunction1.iterator();
      do
      {
        i = j;
        if (!paramFunction1.hasNext()) {
          break;
        }
      } while (((Throwable)paramFunction1.next() instanceof CancellationException));
      i = 0;
    }
    if (i != 0) {
      return;
    }
    paramFunction1 = new StringBuilder();
    paramFunction1.append("Coroutine encountered unhandled exceptions:\n");
    paramFunction1.append(paramTestCoroutineContext.getExceptions());
    paramTestCoroutineContext = (Throwable)new AssertionError(paramFunction1.toString());
    for (;;)
    {
      throw paramTestCoroutineContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.test.TestCoroutineContextKt
 * JD-Core Version:    0.7.0.1
 */