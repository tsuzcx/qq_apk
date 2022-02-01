package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

class AbstractClassDescriptor$1$1
  implements Function1<KotlinTypeRefiner, SimpleType>
{
  AbstractClassDescriptor$1$1(AbstractClassDescriptor.1 param1) {}
  
  public SimpleType invoke(KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    ClassifierDescriptor localClassifierDescriptor = paramKotlinTypeRefiner.refineDescriptor(this.this$1.this$0);
    if (localClassifierDescriptor == null) {
      return (SimpleType)this.this$1.this$0.defaultType.invoke();
    }
    if ((localClassifierDescriptor instanceof TypeAliasDescriptor)) {
      return KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor)localClassifierDescriptor, TypeUtils.getDefaultTypeProjections(localClassifierDescriptor.getTypeConstructor().getParameters()));
    }
    if ((localClassifierDescriptor instanceof ModuleAwareClassDescriptor)) {
      return TypeUtils.makeUnsubstitutedType(localClassifierDescriptor.getTypeConstructor().refine(paramKotlinTypeRefiner), ((ModuleAwareClassDescriptor)localClassifierDescriptor).getUnsubstitutedMemberScope(paramKotlinTypeRefiner), this);
    }
    return localClassifierDescriptor.getDefaultType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor.1.1
 * JD-Core Version:    0.7.0.1
 */