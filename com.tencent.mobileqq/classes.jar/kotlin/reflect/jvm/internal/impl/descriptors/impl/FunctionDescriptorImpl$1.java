package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

class FunctionDescriptorImpl$1
  implements Function0<Collection<FunctionDescriptor>>
{
  FunctionDescriptorImpl$1(FunctionDescriptorImpl paramFunctionDescriptorImpl, TypeSubstitutor paramTypeSubstitutor) {}
  
  public Collection<FunctionDescriptor> invoke()
  {
    SmartList localSmartList = new SmartList();
    Iterator localIterator = this.this$0.getOverriddenDescriptors().iterator();
    while (localIterator.hasNext()) {
      localSmartList.add(((FunctionDescriptor)localIterator.next()).substitute(this.val$substitutor));
    }
    return localSmartList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.1
 * JD-Core Version:    0.7.0.1
 */