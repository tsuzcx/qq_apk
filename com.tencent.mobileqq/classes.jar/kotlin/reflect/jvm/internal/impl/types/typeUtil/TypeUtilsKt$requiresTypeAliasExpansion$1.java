package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

final class TypeUtilsKt$requiresTypeAliasExpansion$1
  extends Lambda
  implements Function1<UnwrappedType, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  TypeUtilsKt$requiresTypeAliasExpansion$1()
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull UnwrappedType paramUnwrappedType)
  {
    Intrinsics.checkParameterIsNotNull(paramUnwrappedType, "it");
    paramUnwrappedType = paramUnwrappedType.getConstructor().getDeclarationDescriptor();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramUnwrappedType != null) {
      if (!(paramUnwrappedType instanceof TypeAliasDescriptor))
      {
        bool1 = bool2;
        if (!(paramUnwrappedType instanceof TypeParameterDescriptor)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.requiresTypeAliasExpansion.1
 * JD-Core Version:    0.7.0.1
 */