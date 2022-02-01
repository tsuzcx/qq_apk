package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class VariableDescriptorWithInitializerImpl
  extends VariableDescriptorImpl
{
  protected NullableLazyValue<ConstantValue<?>> compileTimeInitializer;
  private final boolean isVar;
  
  public VariableDescriptorWithInitializerImpl(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Annotations paramAnnotations, @NotNull Name paramName, @Nullable KotlinType paramKotlinType, boolean paramBoolean, @NotNull SourceElement paramSourceElement)
  {
    super(paramDeclarationDescriptor, paramAnnotations, paramName, paramKotlinType, paramSourceElement);
    this.isVar = paramBoolean;
  }
  
  @Nullable
  public ConstantValue<?> getCompileTimeInitializer()
  {
    NullableLazyValue localNullableLazyValue = this.compileTimeInitializer;
    if (localNullableLazyValue != null) {
      return (ConstantValue)localNullableLazyValue.invoke();
    }
    return null;
  }
  
  public boolean isVar()
  {
    return this.isVar;
  }
  
  public void setCompileTimeInitializer(@NotNull NullableLazyValue<ConstantValue<?>> paramNullableLazyValue)
  {
    if (paramNullableLazyValue == null) {
      $$$reportNull$$$0(4);
    }
    this.compileTimeInitializer = paramNullableLazyValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorWithInitializerImpl
 * JD-Core Version:    0.7.0.1
 */