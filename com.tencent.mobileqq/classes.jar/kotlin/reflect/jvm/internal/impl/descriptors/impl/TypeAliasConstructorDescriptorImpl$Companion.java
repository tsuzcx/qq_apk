package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeAliasConstructorDescriptorImpl$Companion
{
  private final TypeSubstitutor getTypeSubstitutorForUnderlyingClass(@NotNull TypeAliasDescriptor paramTypeAliasDescriptor)
  {
    if (paramTypeAliasDescriptor.getClassDescriptor() == null) {
      return null;
    }
    return TypeSubstitutor.create((KotlinType)paramTypeAliasDescriptor.getExpandedType());
  }
  
  @Nullable
  public final TypeAliasConstructorDescriptor createIfAvailable(@NotNull StorageManager paramStorageManager, @NotNull TypeAliasDescriptor paramTypeAliasDescriptor, @NotNull ClassConstructorDescriptor paramClassConstructorDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramStorageManager, "storageManager");
    Intrinsics.checkParameterIsNotNull(paramTypeAliasDescriptor, "typeAliasDescriptor");
    Intrinsics.checkParameterIsNotNull(paramClassConstructorDescriptor, "constructor");
    TypeSubstitutor localTypeSubstitutor = ((Companion)this).getTypeSubstitutorForUnderlyingClass(paramTypeAliasDescriptor);
    Object localObject1 = null;
    if (localTypeSubstitutor != null)
    {
      Object localObject4 = paramClassConstructorDescriptor.substitute(localTypeSubstitutor);
      if (localObject4 != null)
      {
        Object localObject2 = paramClassConstructorDescriptor.getAnnotations();
        Object localObject3 = paramClassConstructorDescriptor.getKind();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "constructor.kind");
        SourceElement localSourceElement = paramTypeAliasDescriptor.getSource();
        Intrinsics.checkExpressionValueIsNotNull(localSourceElement, "typeAliasDescriptor.source");
        localObject2 = new TypeAliasConstructorDescriptorImpl(paramStorageManager, paramTypeAliasDescriptor, (ClassConstructorDescriptor)localObject4, null, (Annotations)localObject2, (CallableMemberDescriptor.Kind)localObject3, localSourceElement, null);
        localObject3 = FunctionDescriptorImpl.getSubstitutedValueParameters((FunctionDescriptor)localObject2, paramClassConstructorDescriptor.getValueParameters(), localTypeSubstitutor);
        if (localObject3 != null)
        {
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "FunctionDescriptorImpl.g…         ) ?: return null");
          paramStorageManager = FlexibleTypesKt.lowerIfFlexible((KotlinType)((ClassConstructorDescriptor)localObject4).getReturnType().unwrap());
          localObject4 = paramTypeAliasDescriptor.getDefaultType();
          Intrinsics.checkExpressionValueIsNotNull(localObject4, "typeAliasDescriptor.defaultType");
          localObject4 = SpecialTypesKt.withAbbreviation(paramStorageManager, (SimpleType)localObject4);
          paramClassConstructorDescriptor = paramClassConstructorDescriptor.getDispatchReceiverParameter();
          paramStorageManager = localObject1;
          if (paramClassConstructorDescriptor != null)
          {
            paramStorageManager = (CallableDescriptor)localObject2;
            Intrinsics.checkExpressionValueIsNotNull(paramClassConstructorDescriptor, "it");
            paramStorageManager = DescriptorFactory.createExtensionReceiverParameterForCallable(paramStorageManager, localTypeSubstitutor.safeSubstitute(paramClassConstructorDescriptor.getType(), Variance.INVARIANT), Annotations.Companion.getEMPTY());
          }
          ((TypeAliasConstructorDescriptorImpl)localObject2).initialize(paramStorageManager, null, paramTypeAliasDescriptor.getDeclaredTypeParameters(), (List)localObject3, (KotlinType)localObject4, Modality.FINAL, paramTypeAliasDescriptor.getVisibility());
          return (TypeAliasConstructorDescriptor)localObject2;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl.Companion
 * JD-Core Version:    0.7.0.1
 */