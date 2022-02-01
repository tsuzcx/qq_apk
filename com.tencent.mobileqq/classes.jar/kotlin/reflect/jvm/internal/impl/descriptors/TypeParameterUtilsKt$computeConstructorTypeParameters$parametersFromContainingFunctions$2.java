package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2
  extends Lambda
  implements Function1<DeclarationDescriptor, Boolean>
{
  public static final 2 INSTANCE = new 2();
  
  TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2()
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "it");
    return !(paramDeclarationDescriptor instanceof ConstructorDescriptor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt.computeConstructorTypeParameters.parametersFromContainingFunctions.2
 * JD-Core Version:    0.7.0.1
 */