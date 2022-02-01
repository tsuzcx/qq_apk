package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "acc", "element", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", "invoke"}, k=3, mv={1, 1, 16})
final class CombinedContext$toString$1
  extends Lambda
  implements Function2<String, CoroutineContext.Element, String>
{
  public static final 1 INSTANCE = new 1();
  
  CombinedContext$toString$1()
  {
    super(2);
  }
  
  @NotNull
  public final String invoke(@NotNull String paramString, @NotNull CoroutineContext.Element paramElement)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "acc");
    Intrinsics.checkParameterIsNotNull(paramElement, "element");
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return paramElement.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramElement);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.coroutines.experimental.CombinedContext.toString.1
 * JD-Core Version:    0.7.0.1
 */