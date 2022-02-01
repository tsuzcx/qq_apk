package kotlin.coroutines;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class CombinedContext$Serialized
  implements Serializable
{
  public static final CombinedContext.Serialized.Companion Companion = new CombinedContext.Serialized.Companion(null);
  private static final long serialVersionUID = 0L;
  @NotNull
  private final CoroutineContext[] elements;
  
  public CombinedContext$Serialized(@NotNull CoroutineContext[] paramArrayOfCoroutineContext)
  {
    this.elements = paramArrayOfCoroutineContext;
  }
  
  private final Object readResolve()
  {
    CoroutineContext[] arrayOfCoroutineContext = this.elements;
    Object localObject = EmptyCoroutineContext.INSTANCE;
    int j = arrayOfCoroutineContext.length;
    int i = 0;
    while (i < j)
    {
      CoroutineContext localCoroutineContext = arrayOfCoroutineContext[i];
      localObject = ((CoroutineContext)localObject).plus(localCoroutineContext);
      i += 1;
    }
    return localObject;
  }
  
  @NotNull
  public final CoroutineContext[] getElements()
  {
    return this.elements;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.coroutines.CombinedContext.Serialized
 * JD-Core Version:    0.7.0.1
 */