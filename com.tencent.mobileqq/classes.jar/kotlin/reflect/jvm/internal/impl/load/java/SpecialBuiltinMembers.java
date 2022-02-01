package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JvmName(name="SpecialBuiltinMembers")
public final class SpecialBuiltinMembers
{
  private static final FqName child(@NotNull FqName paramFqName, String paramString)
  {
    paramFqName = paramFqName.child(Name.identifier(paramString));
    Intrinsics.checkExpressionValueIsNotNull(paramFqName, "child(Name.identifier(name))");
    return paramFqName;
  }
  
  private static final FqName childSafe(@NotNull FqNameUnsafe paramFqNameUnsafe, String paramString)
  {
    paramFqNameUnsafe = paramFqNameUnsafe.child(Name.identifier(paramString)).toSafe();
    Intrinsics.checkExpressionValueIsNotNull(paramFqNameUnsafe, "child(Name.identifier(name)).toSafe()");
    return paramFqNameUnsafe;
  }
  
  public static final boolean doesOverrideBuiltinWithDifferentJvmName(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "$this$doesOverrideBuiltinWithDifferentJvmName");
    return getOverriddenBuiltinWithDifferentJvmName(paramCallableMemberDescriptor) != null;
  }
  
  @Nullable
  public static final String getJvmMethodNameIfSpecial(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "callableMemberDescriptor");
    Object localObject2 = getOverriddenBuiltinThatAffectsJvmName(paramCallableMemberDescriptor);
    Object localObject1 = null;
    paramCallableMemberDescriptor = localObject1;
    if (localObject2 != null)
    {
      localObject2 = DescriptorUtilsKt.getPropertyIfAccessor((CallableMemberDescriptor)localObject2);
      paramCallableMemberDescriptor = localObject1;
      if (localObject2 != null)
      {
        if ((localObject2 instanceof PropertyDescriptor)) {
          return BuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName((CallableMemberDescriptor)localObject2);
        }
        paramCallableMemberDescriptor = localObject1;
        if ((localObject2 instanceof SimpleFunctionDescriptor))
        {
          localObject2 = BuiltinMethodsWithDifferentJvmName.INSTANCE.getJvmName((SimpleFunctionDescriptor)localObject2);
          paramCallableMemberDescriptor = localObject1;
          if (localObject2 != null) {
            paramCallableMemberDescriptor = ((Name)localObject2).asString();
          }
        }
      }
    }
    return paramCallableMemberDescriptor;
  }
  
  private static final CallableMemberDescriptor getOverriddenBuiltinThatAffectsJvmName(CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    if (KotlinBuiltIns.isBuiltIn((DeclarationDescriptor)paramCallableMemberDescriptor)) {
      return getOverriddenBuiltinWithDifferentJvmName(paramCallableMemberDescriptor);
    }
    return null;
  }
  
  @Nullable
  public static final <T extends CallableMemberDescriptor> T getOverriddenBuiltinWithDifferentJvmName(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "$this$getOverriddenBuiltinWithDifferentJvmName");
    boolean bool = BuiltinMethodsWithDifferentJvmName.INSTANCE.getORIGINAL_SHORT_NAMES().contains(paramT.getName());
    CallableMemberDescriptor localCallableMemberDescriptor = null;
    if ((!bool) && (!BuiltinSpecialProperties.INSTANCE.getSPECIAL_SHORT_NAMES$descriptors_jvm().contains(DescriptorUtilsKt.getPropertyIfAccessor(paramT).getName()))) {
      return null;
    }
    if (((paramT instanceof PropertyDescriptor)) || ((paramT instanceof PropertyAccessorDescriptor))) {
      return DescriptorUtilsKt.firstOverridden$default(paramT, false, (Function1)SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName.1.INSTANCE, 1, null);
    }
    if ((paramT instanceof SimpleFunctionDescriptor)) {
      localCallableMemberDescriptor = DescriptorUtilsKt.firstOverridden$default(paramT, false, (Function1)SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName.2.INSTANCE, 1, null);
    }
    return localCallableMemberDescriptor;
  }
  
  @Nullable
  public static final <T extends CallableMemberDescriptor> T getOverriddenSpecialBuiltin(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "$this$getOverriddenSpecialBuiltin");
    Object localObject = getOverriddenBuiltinWithDifferentJvmName(paramT);
    if (localObject != null) {
      return localObject;
    }
    localObject = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
    Name localName = paramT.getName();
    Intrinsics.checkExpressionValueIsNotNull(localName, "name");
    if (!((BuiltinMethodsWithSpecialGenericSignature)localObject).getSameAsBuiltinMethodWithErasedValueParameters(localName)) {
      return null;
    }
    return DescriptorUtilsKt.firstOverridden$default(paramT, false, (Function1)SpecialBuiltinMembers.getOverriddenSpecialBuiltin.2.INSTANCE, 1, null);
  }
  
  public static final boolean hasRealKotlinSuperClassWithOverrideOf(@NotNull ClassDescriptor paramClassDescriptor, @NotNull CallableDescriptor paramCallableDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "$this$hasRealKotlinSuperClassWithOverrideOf");
    Intrinsics.checkParameterIsNotNull(paramCallableDescriptor, "specialCallableDescriptor");
    paramCallableDescriptor = paramCallableDescriptor.getContainingDeclaration();
    if (paramCallableDescriptor != null)
    {
      paramCallableDescriptor = ((ClassDescriptor)paramCallableDescriptor).getDefaultType();
      Intrinsics.checkExpressionValueIsNotNull(paramCallableDescriptor, "(specialCallableDescript…ssDescriptor).defaultType");
      for (paramClassDescriptor = DescriptorUtils.getSuperClassDescriptor(paramClassDescriptor);; paramClassDescriptor = DescriptorUtils.getSuperClassDescriptor(paramClassDescriptor))
      {
        int i = 0;
        if (paramClassDescriptor == null) {
          break;
        }
        if (!(paramClassDescriptor instanceof JavaClassDescriptor))
        {
          if (TypeCheckingProcedure.findCorrespondingSupertype((KotlinType)paramClassDescriptor.getDefaultType(), (KotlinType)paramCallableDescriptor) != null) {
            i = 1;
          }
          if (i != 0) {
            return KotlinBuiltIns.isBuiltIn((DeclarationDescriptor)paramClassDescriptor) ^ true;
          }
        }
      }
      return false;
    }
    paramClassDescriptor = new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    for (;;)
    {
      throw paramClassDescriptor;
    }
  }
  
  public static final boolean isFromJava(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "$this$isFromJava");
    return DescriptorUtilsKt.getPropertyIfAccessor(paramCallableMemberDescriptor).getContainingDeclaration() instanceof JavaClassDescriptor;
  }
  
  public static final boolean isFromJavaOrBuiltins(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "$this$isFromJavaOrBuiltins");
    return (isFromJava(paramCallableMemberDescriptor)) || (KotlinBuiltIns.isBuiltIn((DeclarationDescriptor)paramCallableMemberDescriptor));
  }
  
  private static final NameAndSignature method(@NotNull String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Name localName = Name.identifier(paramString2);
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(name)");
    SignatureBuildingComponents localSignatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append('(');
    localStringBuilder.append(paramString3);
    localStringBuilder.append(')');
    localStringBuilder.append(paramString4);
    return new NameAndSignature(localName, localSignatureBuildingComponents.signature(paramString1, localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers
 * JD-Core Version:    0.7.0.1
 */