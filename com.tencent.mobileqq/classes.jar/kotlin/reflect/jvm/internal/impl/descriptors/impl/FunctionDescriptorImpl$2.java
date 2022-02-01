package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;

final class FunctionDescriptorImpl$2
  implements Function0<List<VariableDescriptor>>
{
  FunctionDescriptorImpl$2(List paramList) {}
  
  public List<VariableDescriptor> invoke()
  {
    return this.val$destructuringVariables;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.2
 * JD-Core Version:    0.7.0.1
 */