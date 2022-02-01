package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

class AbstractClassDescriptor$2
  implements Function0<MemberScope>
{
  AbstractClassDescriptor$2(AbstractClassDescriptor paramAbstractClassDescriptor) {}
  
  public MemberScope invoke()
  {
    return new InnerClassesScopeWrapper(this.this$0.getUnsubstitutedMemberScope());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor.2
 * JD-Core Version:    0.7.0.1
 */