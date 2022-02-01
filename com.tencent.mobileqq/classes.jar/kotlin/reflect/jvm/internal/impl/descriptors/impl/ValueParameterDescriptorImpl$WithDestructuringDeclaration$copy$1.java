package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import org.jetbrains.annotations.NotNull;

final class ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1
  extends Lambda
  implements Function0<List<? extends VariableDescriptor>>
{
  ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1(ValueParameterDescriptorImpl.WithDestructuringDeclaration paramWithDestructuringDeclaration)
  {
    super(0);
  }
  
  @NotNull
  public final List<VariableDescriptor> invoke()
  {
    return this.this$0.getDestructuringVariables();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl.WithDestructuringDeclaration.copy.1
 * JD-Core Version:    0.7.0.1
 */