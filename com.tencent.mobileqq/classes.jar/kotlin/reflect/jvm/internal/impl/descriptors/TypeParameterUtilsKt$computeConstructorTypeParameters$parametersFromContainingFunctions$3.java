package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

final class TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3
  extends Lambda
  implements Function1<DeclarationDescriptor, Sequence<? extends TypeParameterDescriptor>>
{
  public static final 3 INSTANCE = new 3();
  
  TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3()
  {
    super(1);
  }
  
  @NotNull
  public final Sequence<TypeParameterDescriptor> invoke(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "it");
    paramDeclarationDescriptor = ((CallableDescriptor)paramDeclarationDescriptor).getTypeParameters();
    Intrinsics.checkExpressionValueIsNotNull(paramDeclarationDescriptor, "(it as CallableDescriptor).typeParameters");
    return CollectionsKt.asSequence((Iterable)paramDeclarationDescriptor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt.computeConstructorTypeParameters.parametersFromContainingFunctions.3
 * JD-Core Version:    0.7.0.1
 */