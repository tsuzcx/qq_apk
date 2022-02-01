package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class KClassValue
  extends ConstantValue<KClassValue.Value>
{
  public static final KClassValue.Companion Companion = new KClassValue.Companion(null);
  
  public KClassValue(@NotNull ClassId paramClassId, int paramInt)
  {
    this(new ClassLiteralValue(paramClassId, paramInt));
  }
  
  public KClassValue(@NotNull ClassLiteralValue paramClassLiteralValue)
  {
    this((KClassValue.Value)new KClassValue.Value.NormalClass(paramClassLiteralValue));
  }
  
  public KClassValue(@NotNull KClassValue.Value paramValue)
  {
    super(paramValue);
  }
  
  @NotNull
  public final KotlinType getArgumentType(@NotNull ModuleDescriptor paramModuleDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "module");
    Object localObject1 = (KClassValue.Value)getValue();
    if ((localObject1 instanceof KClassValue.Value.LocalClass)) {
      return ((KClassValue.Value.LocalClass)getValue()).getType();
    }
    if ((localObject1 instanceof KClassValue.Value.NormalClass))
    {
      Object localObject2 = ((KClassValue.Value.NormalClass)getValue()).getValue();
      localObject1 = ((ClassLiteralValue)localObject2).component1();
      int j = ((ClassLiteralValue)localObject2).component2();
      localObject2 = FindClassInModuleKt.findClassAcrossModuleDependencies(paramModuleDescriptor, (ClassId)localObject1);
      if (localObject2 != null)
      {
        localObject1 = ((ClassDescriptor)localObject2).getDefaultType();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "descriptor.defaultType");
        localObject1 = TypeUtilsKt.replaceArgumentsWithStarProjections((KotlinType)localObject1);
        int i = 0;
        while (i < j)
        {
          localObject1 = paramModuleDescriptor.getBuiltIns().getArrayType(Variance.INVARIANT, (KotlinType)localObject1);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "module.builtIns.getArray…Variance.INVARIANT, type)");
          localObject1 = (KotlinType)localObject1;
          i += 1;
        }
        return localObject1;
      }
      paramModuleDescriptor = new StringBuilder();
      paramModuleDescriptor.append("Unresolved type: ");
      paramModuleDescriptor.append(localObject1);
      paramModuleDescriptor.append(" (arrayDimensions=");
      paramModuleDescriptor.append(j);
      paramModuleDescriptor.append(')');
      paramModuleDescriptor = ErrorUtils.createErrorType(paramModuleDescriptor.toString());
      Intrinsics.checkExpressionValueIsNotNull(paramModuleDescriptor, "ErrorUtils.createErrorTy…sions=$arrayDimensions)\")");
      return (KotlinType)paramModuleDescriptor;
    }
    paramModuleDescriptor = new NoWhenBranchMatchedException();
    for (;;)
    {
      throw paramModuleDescriptor;
    }
  }
  
  @NotNull
  public KotlinType getType(@NotNull ModuleDescriptor paramModuleDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "module");
    Annotations localAnnotations = Annotations.Companion.getEMPTY();
    ClassDescriptor localClassDescriptor = paramModuleDescriptor.getBuiltIns().getKClass();
    Intrinsics.checkExpressionValueIsNotNull(localClassDescriptor, "module.builtIns.kClass");
    return (KotlinType)KotlinTypeFactory.simpleNotNullType(localAnnotations, localClassDescriptor, CollectionsKt.listOf(new TypeProjectionImpl(getArgumentType(paramModuleDescriptor))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue
 * JD-Core Version:    0.7.0.1
 */