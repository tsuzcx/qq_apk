package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class InlineClassManglingRulesKt
{
  private static final boolean isDontMangleClass(ClassDescriptor paramClassDescriptor)
  {
    return Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe((DeclarationDescriptor)paramClassDescriptor), DescriptorUtils.RESULT_FQ_NAME);
  }
  
  public static final boolean isInlineClassThatRequiresMangling(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "$this$isInlineClassThatRequiresMangling");
    return (InlineClassesUtilsKt.isInlineClass(paramDeclarationDescriptor)) && (!isDontMangleClass((ClassDescriptor)paramDeclarationDescriptor));
  }
  
  public static final boolean isInlineClassThatRequiresMangling(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$isInlineClassThatRequiresMangling");
    paramKotlinType = paramKotlinType.getConstructor().getDeclarationDescriptor();
    return (paramKotlinType != null) && (isInlineClassThatRequiresMangling((DeclarationDescriptor)paramKotlinType) == true);
  }
  
  private static final boolean isTypeParameterWithUpperBoundThatRequiresMangling(@NotNull KotlinType paramKotlinType)
  {
    ClassifierDescriptor localClassifierDescriptor = paramKotlinType.getConstructor().getDeclarationDescriptor();
    paramKotlinType = localClassifierDescriptor;
    if (!(localClassifierDescriptor instanceof TypeParameterDescriptor)) {
      paramKotlinType = null;
    }
    paramKotlinType = (TypeParameterDescriptor)paramKotlinType;
    if (paramKotlinType != null) {
      return requiresFunctionNameMangling(TypeUtilsKt.getRepresentativeUpperBound(paramKotlinType));
    }
    return false;
  }
  
  private static final boolean requiresFunctionNameMangling(@NotNull KotlinType paramKotlinType)
  {
    return (isInlineClassThatRequiresMangling(paramKotlinType)) || (isTypeParameterWithUpperBoundThatRequiresMangling(paramKotlinType));
  }
  
  public static final boolean shouldHideConstructorDueToInlineClassTypeValueParameters(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "descriptor");
    Object localObject = paramCallableMemberDescriptor;
    if (!(paramCallableMemberDescriptor instanceof ClassConstructorDescriptor)) {
      localObject = null;
    }
    paramCallableMemberDescriptor = (ClassConstructorDescriptor)localObject;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramCallableMemberDescriptor != null)
    {
      if (Visibilities.isPrivate(paramCallableMemberDescriptor.getVisibility())) {
        return false;
      }
      localObject = paramCallableMemberDescriptor.getConstructedClass();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "constructorDescriptor.constructedClass");
      if (((ClassDescriptor)localObject).isInline()) {
        return false;
      }
      if (DescriptorUtils.isSealedClass((DeclarationDescriptor)paramCallableMemberDescriptor.getConstructedClass())) {
        return false;
      }
      paramCallableMemberDescriptor = paramCallableMemberDescriptor.getValueParameters();
      Intrinsics.checkExpressionValueIsNotNull(paramCallableMemberDescriptor, "constructorDescriptor.valueParameters");
      paramCallableMemberDescriptor = (Iterable)paramCallableMemberDescriptor;
      if (((paramCallableMemberDescriptor instanceof Collection)) && (((Collection)paramCallableMemberDescriptor).isEmpty())) {
        return false;
      }
      paramCallableMemberDescriptor = paramCallableMemberDescriptor.iterator();
      do
      {
        bool1 = bool2;
        if (!paramCallableMemberDescriptor.hasNext()) {
          break;
        }
        localObject = (ValueParameterDescriptor)paramCallableMemberDescriptor.next();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
        localObject = ((ValueParameterDescriptor)localObject).getType();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it.type");
      } while (!requiresFunctionNameMangling((KotlinType)localObject));
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.jvm.InlineClassManglingRulesKt
 * JD-Core Version:    0.7.0.1
 */