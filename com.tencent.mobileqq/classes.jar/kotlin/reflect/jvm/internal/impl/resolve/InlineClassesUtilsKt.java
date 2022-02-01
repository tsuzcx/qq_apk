package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class InlineClassesUtilsKt
{
  public static final boolean isGetterOfUnderlyingPropertyOfInlineClass(@NotNull CallableDescriptor paramCallableDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableDescriptor, "$this$isGetterOfUnderlyingPropertyOfInlineClass");
    if ((paramCallableDescriptor instanceof PropertyGetterDescriptor))
    {
      paramCallableDescriptor = ((PropertyGetterDescriptor)paramCallableDescriptor).getCorrespondingProperty();
      Intrinsics.checkExpressionValueIsNotNull(paramCallableDescriptor, "correspondingProperty");
      if (isUnderlyingPropertyOfInlineClass((VariableDescriptor)paramCallableDescriptor)) {
        return true;
      }
    }
    return false;
  }
  
  public static final boolean isInlineClass(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "$this$isInlineClass");
    return ((paramDeclarationDescriptor instanceof ClassDescriptor)) && (((ClassDescriptor)paramDeclarationDescriptor).isInline());
  }
  
  public static final boolean isInlineClassType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$isInlineClassType");
    paramKotlinType = paramKotlinType.getConstructor().getDeclarationDescriptor();
    if (paramKotlinType != null) {
      return isInlineClass((DeclarationDescriptor)paramKotlinType);
    }
    return false;
  }
  
  public static final boolean isUnderlyingPropertyOfInlineClass(@NotNull VariableDescriptor paramVariableDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramVariableDescriptor, "$this$isUnderlyingPropertyOfInlineClass");
    Object localObject = paramVariableDescriptor.getContainingDeclaration();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "this.containingDeclaration");
    if (!isInlineClass((DeclarationDescriptor)localObject)) {
      return false;
    }
    if (localObject != null)
    {
      localObject = underlyingRepresentation((ClassDescriptor)localObject);
      if (localObject != null) {
        localObject = ((ValueParameterDescriptor)localObject).getName();
      } else {
        localObject = null;
      }
      return Intrinsics.areEqual(localObject, paramVariableDescriptor.getName());
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
  }
  
  @Nullable
  public static final KotlinType substitutedUnderlyingType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$substitutedUnderlyingType");
    ValueParameterDescriptor localValueParameterDescriptor = unsubstitutedUnderlyingParameter(paramKotlinType);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localValueParameterDescriptor != null)
    {
      paramKotlinType = paramKotlinType.getMemberScope();
      localObject1 = localValueParameterDescriptor.getName();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "parameter.name");
      paramKotlinType = (PropertyDescriptor)CollectionsKt.singleOrNull((Iterable)paramKotlinType.getContributedVariables((Name)localObject1, (LookupLocation)NoLookupLocation.FOR_ALREADY_TRACKED));
      localObject1 = localObject2;
      if (paramKotlinType != null) {
        localObject1 = paramKotlinType.getType();
      }
    }
    return localObject1;
  }
  
  @Nullable
  public static final ValueParameterDescriptor underlyingRepresentation(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "$this$underlyingRepresentation");
    boolean bool = paramClassDescriptor.isInline();
    Object localObject1 = null;
    if (!bool) {
      return null;
    }
    Object localObject2 = paramClassDescriptor.getUnsubstitutedPrimaryConstructor();
    paramClassDescriptor = localObject1;
    if (localObject2 != null)
    {
      localObject2 = ((ClassConstructorDescriptor)localObject2).getValueParameters();
      paramClassDescriptor = localObject1;
      if (localObject2 != null) {
        paramClassDescriptor = (ValueParameterDescriptor)CollectionsKt.singleOrNull((List)localObject2);
      }
    }
    return paramClassDescriptor;
  }
  
  @Nullable
  public static final ValueParameterDescriptor unsubstitutedUnderlyingParameter(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$unsubstitutedUnderlyingParameter");
    paramKotlinType = paramKotlinType.getConstructor().getDeclarationDescriptor();
    boolean bool = paramKotlinType instanceof ClassDescriptor;
    Object localObject = null;
    if (!bool) {
      paramKotlinType = null;
    }
    ClassDescriptor localClassDescriptor = (ClassDescriptor)paramKotlinType;
    paramKotlinType = localObject;
    if (localClassDescriptor != null) {
      paramKotlinType = underlyingRepresentation(localClassDescriptor);
    }
    return paramKotlinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt
 * JD-Core Version:    0.7.0.1
 */