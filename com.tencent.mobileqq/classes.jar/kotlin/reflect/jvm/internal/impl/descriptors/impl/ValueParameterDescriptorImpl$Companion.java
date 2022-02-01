package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ValueParameterDescriptorImpl$Companion
{
  @JvmStatic
  @NotNull
  public final ValueParameterDescriptorImpl createWithDestructuringDeclarations(@NotNull CallableDescriptor paramCallableDescriptor, @Nullable ValueParameterDescriptor paramValueParameterDescriptor, int paramInt, @NotNull Annotations paramAnnotations, @NotNull Name paramName, @NotNull KotlinType paramKotlinType1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @Nullable KotlinType paramKotlinType2, @NotNull SourceElement paramSourceElement, @Nullable Function0<? extends List<? extends VariableDescriptor>> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableDescriptor, "containingDeclaration");
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "annotations");
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramKotlinType1, "outType");
    Intrinsics.checkParameterIsNotNull(paramSourceElement, "source");
    if (paramFunction0 == null) {
      return new ValueParameterDescriptorImpl(paramCallableDescriptor, paramValueParameterDescriptor, paramInt, paramAnnotations, paramName, paramKotlinType1, paramBoolean1, paramBoolean2, paramBoolean3, paramKotlinType2, paramSourceElement);
    }
    return (ValueParameterDescriptorImpl)new ValueParameterDescriptorImpl.WithDestructuringDeclaration(paramCallableDescriptor, paramValueParameterDescriptor, paramInt, paramAnnotations, paramName, paramKotlinType1, paramBoolean1, paramBoolean2, paramBoolean3, paramKotlinType2, paramSourceElement, paramFunction0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl.Companion
 * JD-Core Version:    0.7.0.1
 */