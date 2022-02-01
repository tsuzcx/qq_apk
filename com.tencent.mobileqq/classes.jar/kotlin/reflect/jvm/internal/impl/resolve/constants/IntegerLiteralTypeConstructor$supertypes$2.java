package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

final class IntegerLiteralTypeConstructor$supertypes$2
  extends Lambda
  implements Function0<List<SimpleType>>
{
  IntegerLiteralTypeConstructor$supertypes$2(IntegerLiteralTypeConstructor paramIntegerLiteralTypeConstructor)
  {
    super(0);
  }
  
  @NotNull
  public final List<SimpleType> invoke()
  {
    Object localObject = this.this$0.getBuiltIns().getComparable();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "builtIns.comparable");
    localObject = ((ClassDescriptor)localObject).getDefaultType();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "builtIns.comparable.defaultType");
    localObject = CollectionsKt.mutableListOf(new SimpleType[] { TypeSubstitutionKt.replace$default((SimpleType)localObject, CollectionsKt.listOf(new TypeProjectionImpl(Variance.IN_VARIANCE, (KotlinType)IntegerLiteralTypeConstructor.access$getType$p(this.this$0))), null, 2, null) });
    if (!IntegerLiteralTypeConstructor.access$isContainsOnlyUnsignedTypes(this.this$0)) {
      ((Collection)localObject).add(this.this$0.getBuiltIns().getNumberType());
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor.supertypes.2
 * JD-Core Version:    0.7.0.1
 */