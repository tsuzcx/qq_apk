package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
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

public final class ValueParameterDescriptorImpl$WithDestructuringDeclaration
  extends ValueParameterDescriptorImpl
{
  @NotNull
  private final Lazy destructuringVariables$delegate;
  
  public ValueParameterDescriptorImpl$WithDestructuringDeclaration(@NotNull CallableDescriptor paramCallableDescriptor, @Nullable ValueParameterDescriptor paramValueParameterDescriptor, int paramInt, @NotNull Annotations paramAnnotations, @NotNull Name paramName, @NotNull KotlinType paramKotlinType1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @Nullable KotlinType paramKotlinType2, @NotNull SourceElement paramSourceElement, @NotNull Function0<? extends List<? extends VariableDescriptor>> paramFunction0)
  {
    super(paramCallableDescriptor, paramValueParameterDescriptor, paramInt, paramAnnotations, paramName, paramKotlinType1, paramBoolean1, paramBoolean2, paramBoolean3, paramKotlinType2, paramSourceElement);
    this.destructuringVariables$delegate = LazyKt.lazy(paramFunction0);
  }
  
  @NotNull
  public ValueParameterDescriptor copy(@NotNull CallableDescriptor paramCallableDescriptor, @NotNull Name paramName, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableDescriptor, "newOwner");
    Intrinsics.checkParameterIsNotNull(paramName, "newName");
    Annotations localAnnotations = getAnnotations();
    Intrinsics.checkExpressionValueIsNotNull(localAnnotations, "annotations");
    KotlinType localKotlinType1 = getType();
    Intrinsics.checkExpressionValueIsNotNull(localKotlinType1, "type");
    boolean bool1 = declaresDefaultValue();
    boolean bool2 = isCrossinline();
    boolean bool3 = isNoinline();
    KotlinType localKotlinType2 = getVarargElementType();
    SourceElement localSourceElement = SourceElement.NO_SOURCE;
    Intrinsics.checkExpressionValueIsNotNull(localSourceElement, "SourceElement.NO_SOURCE");
    return (ValueParameterDescriptor)new WithDestructuringDeclaration(paramCallableDescriptor, null, paramInt, localAnnotations, paramName, localKotlinType1, bool1, bool2, bool3, localKotlinType2, localSourceElement, (Function0)new ValueParameterDescriptorImpl.WithDestructuringDeclaration.copy.1(this));
  }
  
  @NotNull
  public final List<VariableDescriptor> getDestructuringVariables()
  {
    return (List)this.destructuringVariables$delegate.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl.WithDestructuringDeclaration
 * JD-Core Version:    0.7.0.1
 */