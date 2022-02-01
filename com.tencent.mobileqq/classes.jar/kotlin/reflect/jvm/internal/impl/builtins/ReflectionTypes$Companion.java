package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectionTypes$Companion
{
  @Nullable
  public final KotlinType createKPropertyStarType(@NotNull ModuleDescriptor paramModuleDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "module");
    Object localObject1 = KotlinBuiltIns.FQ_NAMES.kProperty;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "KotlinBuiltIns.FQ_NAMES.kProperty");
    paramModuleDescriptor = FindClassInModuleKt.findClassAcrossModuleDependencies(paramModuleDescriptor, (ClassId)localObject1);
    if (paramModuleDescriptor != null)
    {
      localObject1 = Annotations.Companion.getEMPTY();
      Object localObject2 = paramModuleDescriptor.getTypeConstructor();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "kPropertyClass.typeConstructor");
      localObject2 = ((TypeConstructor)localObject2).getParameters();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "kPropertyClass.typeConstructor.parameters");
      localObject2 = CollectionsKt.single((List)localObject2);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "kPropertyClass.typeConstructor.parameters.single()");
      return (KotlinType)KotlinTypeFactory.simpleNotNullType((Annotations)localObject1, paramModuleDescriptor, CollectionsKt.listOf(new StarProjectionImpl((TypeParameterDescriptor)localObject2)));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.Companion
 * JD-Core Version:    0.7.0.1
 */