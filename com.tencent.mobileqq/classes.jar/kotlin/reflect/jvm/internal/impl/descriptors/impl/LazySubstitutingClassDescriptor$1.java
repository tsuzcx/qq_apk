package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

class LazySubstitutingClassDescriptor$1
  implements Function1<TypeParameterDescriptor, Boolean>
{
  LazySubstitutingClassDescriptor$1(LazySubstitutingClassDescriptor paramLazySubstitutingClassDescriptor) {}
  
  public Boolean invoke(TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    return Boolean.valueOf(paramTypeParameterDescriptor.isCapturedFromOuterDeclaration() ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.LazySubstitutingClassDescriptor.1
 * JD-Core Version:    0.7.0.1
 */