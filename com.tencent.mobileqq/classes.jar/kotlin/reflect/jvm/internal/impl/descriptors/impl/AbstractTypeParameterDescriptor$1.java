package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

class AbstractTypeParameterDescriptor$1
  implements Function0<TypeConstructor>
{
  AbstractTypeParameterDescriptor$1(AbstractTypeParameterDescriptor paramAbstractTypeParameterDescriptor, StorageManager paramStorageManager, SupertypeLoopChecker paramSupertypeLoopChecker) {}
  
  public TypeConstructor invoke()
  {
    return new AbstractTypeParameterDescriptor.TypeParameterTypeConstructor(this.this$0, this.val$storageManager, this.val$supertypeLoopChecker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor.1
 * JD-Core Version:    0.7.0.1
 */