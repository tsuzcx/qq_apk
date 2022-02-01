package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

class AbstractClassDescriptor$1
  implements Function0<SimpleType>
{
  AbstractClassDescriptor$1(AbstractClassDescriptor paramAbstractClassDescriptor) {}
  
  public SimpleType invoke()
  {
    AbstractClassDescriptor localAbstractClassDescriptor = this.this$0;
    return TypeUtils.makeUnsubstitutedType(localAbstractClassDescriptor, localAbstractClassDescriptor.getUnsubstitutedMemberScope(), new AbstractClassDescriptor.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor.1
 * JD-Core Version:    0.7.0.1
 */