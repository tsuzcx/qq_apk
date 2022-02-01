package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class IsKPropertyCheck
  implements Check
{
  public static final IsKPropertyCheck INSTANCE = new IsKPropertyCheck();
  @NotNull
  private static final String description = "second parameter must be of type KProperty<*> or its supertype";
  
  public boolean check(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "functionDescriptor");
    paramFunctionDescriptor = (ValueParameterDescriptor)paramFunctionDescriptor.getValueParameters().get(1);
    Object localObject = ReflectionTypes.Companion;
    Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "secondParameter");
    localObject = ((ReflectionTypes.Companion)localObject).createKPropertyStarType(DescriptorUtilsKt.getModule((DeclarationDescriptor)paramFunctionDescriptor));
    if (localObject != null)
    {
      paramFunctionDescriptor = paramFunctionDescriptor.getType();
      Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "secondParameter.type");
      return TypeUtilsKt.isSubtypeOf((KotlinType)localObject, TypeUtilsKt.makeNotNullable(paramFunctionDescriptor));
    }
    return false;
  }
  
  @NotNull
  public String getDescription()
  {
    return description;
  }
  
  @Nullable
  public String invoke(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "functionDescriptor");
    return Check.DefaultImpls.invoke(this, paramFunctionDescriptor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.IsKPropertyCheck
 * JD-Core Version:    0.7.0.1
 */