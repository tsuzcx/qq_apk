package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collections;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

class AbstractTypeParameterDescriptor$2
  implements Function0<SimpleType>
{
  AbstractTypeParameterDescriptor$2(AbstractTypeParameterDescriptor paramAbstractTypeParameterDescriptor, StorageManager paramStorageManager, Name paramName) {}
  
  public SimpleType invoke()
  {
    return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(Annotations.Companion.getEMPTY(), this.this$0.getTypeConstructor(), Collections.emptyList(), false, new LazyScopeAdapter(this.val$storageManager.createLazyValue(new AbstractTypeParameterDescriptor.2.1(this))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor.2
 * JD-Core Version:    0.7.0.1
 */