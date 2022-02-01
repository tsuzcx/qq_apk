package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;

class AbstractClassDescriptor$3
  implements Function0<ReceiverParameterDescriptor>
{
  AbstractClassDescriptor$3(AbstractClassDescriptor paramAbstractClassDescriptor) {}
  
  public ReceiverParameterDescriptor invoke()
  {
    return new LazyClassReceiverParameterDescriptor(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor.3
 * JD-Core Version:    0.7.0.1
 */