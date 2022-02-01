package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lkotlin/reflect/KClass;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class KClasses$isSubclassOf$2
  extends Lambda
  implements Function1<KClass<?>, Boolean>
{
  KClasses$isSubclassOf$2(KClass paramKClass)
  {
    super(1);
  }
  
  public final boolean invoke(KClass<?> paramKClass)
  {
    return Intrinsics.areEqual(paramKClass, this.$base);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.full.KClasses.isSubclassOf.2
 * JD-Core Version:    0.7.0.1
 */