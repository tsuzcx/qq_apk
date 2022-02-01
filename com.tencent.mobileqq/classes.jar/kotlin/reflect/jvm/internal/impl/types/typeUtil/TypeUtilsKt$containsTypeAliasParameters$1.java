package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

final class TypeUtilsKt$containsTypeAliasParameters$1
  extends Lambda
  implements Function1<UnwrappedType, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  TypeUtilsKt$containsTypeAliasParameters$1()
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull UnwrappedType paramUnwrappedType)
  {
    Intrinsics.checkParameterIsNotNull(paramUnwrappedType, "it");
    paramUnwrappedType = paramUnwrappedType.getConstructor().getDeclarationDescriptor();
    if (paramUnwrappedType != null) {
      return TypeUtilsKt.isTypeAliasParameter(paramUnwrappedType);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.containsTypeAliasParameters.1
 * JD-Core Version:    0.7.0.1
 */