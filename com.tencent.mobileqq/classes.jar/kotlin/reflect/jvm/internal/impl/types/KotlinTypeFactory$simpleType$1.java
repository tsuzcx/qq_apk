package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class KotlinTypeFactory$simpleType$1
  extends Lambda
  implements Function1<KotlinTypeRefiner, SimpleType>
{
  KotlinTypeFactory$simpleType$1(TypeConstructor paramTypeConstructor, List paramList, Annotations paramAnnotations, boolean paramBoolean)
  {
    super(1);
  }
  
  @Nullable
  public final SimpleType invoke(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "refiner");
    Object localObject1 = KotlinTypeFactory.access$refineConstructor(KotlinTypeFactory.INSTANCE, this.$constructor, paramKotlinTypeRefiner, this.$arguments);
    if (localObject1 != null)
    {
      Object localObject2 = ((KotlinTypeFactory.ExpandedTypeOrRefinedConstructor)localObject1).getExpandedType();
      if (localObject2 != null) {
        return localObject2;
      }
      localObject2 = this.$annotations;
      localObject1 = ((KotlinTypeFactory.ExpandedTypeOrRefinedConstructor)localObject1).getRefinedConstructor();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      return KotlinTypeFactory.simpleType((Annotations)localObject2, (TypeConstructor)localObject1, this.$arguments, this.$nullable, paramKotlinTypeRefiner);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType.1
 * JD-Core Version:    0.7.0.1
 */