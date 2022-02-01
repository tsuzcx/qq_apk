package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

final class ErasedOverridabilityCondition$isOverridable$signatureTypes$1
  extends Lambda
  implements Function1<ValueParameterDescriptor, KotlinType>
{
  public static final 1 INSTANCE = new 1();
  
  ErasedOverridabilityCondition$isOverridable$signatureTypes$1()
  {
    super(1);
  }
  
  @NotNull
  public final KotlinType invoke(ValueParameterDescriptor paramValueParameterDescriptor)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramValueParameterDescriptor, "it");
    return paramValueParameterDescriptor.getType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.ErasedOverridabilityCondition.isOverridable.signatureTypes.1
 * JD-Core Version:    0.7.0.1
 */