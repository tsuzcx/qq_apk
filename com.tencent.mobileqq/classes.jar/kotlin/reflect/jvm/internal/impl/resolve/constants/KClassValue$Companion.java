package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.FqNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KClassValue$Companion
{
  @Nullable
  public final ConstantValue<?> create(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "argumentType");
    boolean bool = KotlinTypeKt.isError(paramKotlinType);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    Object localObject1 = paramKotlinType;
    int i = 0;
    while (KotlinBuiltIns.isArray((KotlinType)localObject1))
    {
      localObject1 = ((TypeProjection)CollectionsKt.single(((KotlinType)localObject1).getArguments())).getType();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "type.arguments.single().type");
      i += 1;
    }
    localObject1 = ((KotlinType)localObject1).getConstructor().getDeclarationDescriptor();
    if ((localObject1 instanceof ClassDescriptor))
    {
      localObject1 = DescriptorUtilsKt.getClassId((ClassifierDescriptor)localObject1);
      if (localObject1 != null) {
        return (ConstantValue)new KClassValue((ClassId)localObject1, i);
      }
      return (ConstantValue)new KClassValue((KClassValue.Value)new KClassValue.Value.LocalClass(paramKotlinType));
    }
    paramKotlinType = localObject2;
    if ((localObject1 instanceof TypeParameterDescriptor))
    {
      paramKotlinType = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.any.toSafe());
      Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "ClassId.topLevel(KotlinB…ns.FQ_NAMES.any.toSafe())");
      paramKotlinType = (ConstantValue)new KClassValue(paramKotlinType, 0);
    }
    return paramKotlinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Companion
 * JD-Core Version:    0.7.0.1
 */