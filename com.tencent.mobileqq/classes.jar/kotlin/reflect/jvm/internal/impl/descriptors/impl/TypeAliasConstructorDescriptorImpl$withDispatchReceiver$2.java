package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.Nullable;

final class TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2
  extends Lambda
  implements Function0<TypeAliasConstructorDescriptorImpl>
{
  TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2(TypeAliasConstructorDescriptorImpl paramTypeAliasConstructorDescriptorImpl, ClassConstructorDescriptor paramClassConstructorDescriptor)
  {
    super(0);
  }
  
  @Nullable
  public final TypeAliasConstructorDescriptorImpl invoke()
  {
    Object localObject1 = this.this$0.getStorageManager();
    Object localObject2 = this.this$0.getTypeAliasDescriptor();
    Object localObject3 = this.$underlyingConstructorDescriptor;
    TypeAliasConstructorDescriptor localTypeAliasConstructorDescriptor = (TypeAliasConstructorDescriptor)this.this$0;
    Annotations localAnnotations = ((ClassConstructorDescriptor)localObject3).getAnnotations();
    CallableMemberDescriptor.Kind localKind = this.$underlyingConstructorDescriptor.getKind();
    Intrinsics.checkExpressionValueIsNotNull(localKind, "underlyingConstructorDescriptor.kind");
    SourceElement localSourceElement = this.this$0.getTypeAliasDescriptor().getSource();
    Intrinsics.checkExpressionValueIsNotNull(localSourceElement, "typeAliasDescriptor.source");
    localObject2 = new TypeAliasConstructorDescriptorImpl((StorageManager)localObject1, (TypeAliasDescriptor)localObject2, (ClassConstructorDescriptor)localObject3, localTypeAliasConstructorDescriptor, localAnnotations, localKind, localSourceElement, null);
    localObject1 = TypeAliasConstructorDescriptorImpl.Companion.access$getTypeSubstitutorForUnderlyingClass(TypeAliasConstructorDescriptorImpl.Companion, this.this$0.getTypeAliasDescriptor());
    if (localObject1 != null)
    {
      localObject3 = this.$underlyingConstructorDescriptor.getDispatchReceiverParameter();
      if (localObject3 != null) {
        localObject1 = ((ReceiverParameterDescriptor)localObject3).substitute((TypeSubstitutor)localObject1);
      } else {
        localObject1 = null;
      }
      ((TypeAliasConstructorDescriptorImpl)localObject2).initialize(null, (ReceiverParameterDescriptor)localObject1, this.this$0.getTypeAliasDescriptor().getDeclaredTypeParameters(), this.this$0.getValueParameters(), this.this$0.getReturnType(), Modality.FINAL, this.this$0.getTypeAliasDescriptor().getVisibility());
      return localObject2;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl.withDispatchReceiver.2
 * JD-Core Version:    0.7.0.1
 */