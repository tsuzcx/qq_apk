package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1
  extends Lambda
  implements Function1<DeclarationDescriptor, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1()
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "it");
    return paramDeclarationDescriptor instanceof CallableDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt.computeConstructorTypeParameters.parametersFromContainingFunctions.1
 * JD-Core Version:    0.7.0.1
 */