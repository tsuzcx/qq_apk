package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Lkotlin/text/FlagEnum;", "", "it", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Enum;)Z", "kotlin/text/RegexKt$fromInt$1$1"}, k=3, mv={1, 1, 16})
public final class Regex$fromInt$$inlined$apply$lambda$1
  extends Lambda
  implements Function1<T, Boolean>
{
  public Regex$fromInt$$inlined$apply$lambda$1(int paramInt)
  {
    super(1);
  }
  
  public final boolean invoke(T paramT)
  {
    int i = this.$value$inlined;
    paramT = (FlagEnum)paramT;
    return (i & paramT.getMask()) == paramT.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.Regex.fromInt..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */