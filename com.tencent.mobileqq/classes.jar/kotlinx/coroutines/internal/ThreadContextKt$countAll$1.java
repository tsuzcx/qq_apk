package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<no name provided>", "", "countOrElement", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k=3, mv={1, 1, 16})
final class ThreadContextKt$countAll$1
  extends Lambda
  implements Function2<Object, CoroutineContext.Element, Object>
{
  public static final 1 INSTANCE = new 1();
  
  ThreadContextKt$countAll$1()
  {
    super(2);
  }
  
  @Nullable
  public final Object invoke(@Nullable Object paramObject, @NotNull CoroutineContext.Element paramElement)
  {
    if ((paramElement instanceof ThreadContextElement))
    {
      Object localObject = paramObject;
      if (!(paramObject instanceof Integer)) {
        localObject = null;
      }
      paramObject = (Integer)localObject;
      int i;
      if (paramObject != null) {
        i = paramObject.intValue();
      } else {
        i = 1;
      }
      if (i == 0) {
        return paramElement;
      }
      return Integer.valueOf(i + 1);
    }
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.ThreadContextKt.countAll.1
 * JD-Core Version:    0.7.0.1
 */