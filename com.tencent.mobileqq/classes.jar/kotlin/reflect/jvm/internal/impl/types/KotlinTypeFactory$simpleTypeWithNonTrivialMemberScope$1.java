package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1
  extends Lambda
  implements Function1<KotlinTypeRefiner, SimpleType>
{
  KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1(TypeConstructor paramTypeConstructor, List paramList, Annotations paramAnnotations, boolean paramBoolean, MemberScope paramMemberScope)
  {
    super(1);
  }
  
  @Nullable
  public final SimpleType invoke(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    paramKotlinTypeRefiner = KotlinTypeFactory.access$refineConstructor(KotlinTypeFactory.INSTANCE, this.$constructor, paramKotlinTypeRefiner, this.$arguments);
    if (paramKotlinTypeRefiner != null)
    {
      Object localObject = paramKotlinTypeRefiner.getExpandedType();
      if (localObject != null) {
        return localObject;
      }
      localObject = this.$annotations;
      paramKotlinTypeRefiner = paramKotlinTypeRefiner.getRefinedConstructor();
      if (paramKotlinTypeRefiner == null) {
        Intrinsics.throwNpe();
      }
      return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope((Annotations)localObject, paramKotlinTypeRefiner, this.$arguments, this.$nullable, this.$memberScope);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope.1
 * JD-Core Version:    0.7.0.1
 */