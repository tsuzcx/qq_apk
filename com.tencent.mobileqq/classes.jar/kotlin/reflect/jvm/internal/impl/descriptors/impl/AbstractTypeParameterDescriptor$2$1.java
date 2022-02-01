package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;

class AbstractTypeParameterDescriptor$2$1
  implements Function0<MemberScope>
{
  AbstractTypeParameterDescriptor$2$1(AbstractTypeParameterDescriptor.2 param2) {}
  
  public MemberScope invoke()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Scope for type parameter ");
    localStringBuilder.append(this.this$1.val$name.asString());
    return TypeIntersectionScope.create(localStringBuilder.toString(), this.this$1.this$0.getUpperBounds());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor.2.1
 * JD-Core Version:    0.7.0.1
 */