package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class SignaturePropagator$1
  implements SignaturePropagator
{
  public void reportSignatureErrors(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor, @NotNull List<String> paramList)
  {
    if (paramCallableMemberDescriptor == null) {
      $$$reportNull$$$0(5);
    }
    if (paramList == null) {
      $$$reportNull$$$0(6);
    }
    throw new UnsupportedOperationException("Should not be called");
  }
  
  @NotNull
  public SignaturePropagator.PropagatedSignature resolvePropagatedSignature(@NotNull JavaMethod paramJavaMethod, @NotNull ClassDescriptor paramClassDescriptor, @NotNull KotlinType paramKotlinType1, @Nullable KotlinType paramKotlinType2, @NotNull List<ValueParameterDescriptor> paramList, @NotNull List<TypeParameterDescriptor> paramList1)
  {
    if (paramJavaMethod == null) {
      $$$reportNull$$$0(0);
    }
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(1);
    }
    if (paramKotlinType1 == null) {
      $$$reportNull$$$0(2);
    }
    if (paramList == null) {
      $$$reportNull$$$0(3);
    }
    if (paramList1 == null) {
      $$$reportNull$$$0(4);
    }
    return new SignaturePropagator.PropagatedSignature(paramKotlinType1, paramKotlinType2, paramList, paramList1, Collections.emptyList(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator.1
 * JD-Core Version:    0.7.0.1
 */