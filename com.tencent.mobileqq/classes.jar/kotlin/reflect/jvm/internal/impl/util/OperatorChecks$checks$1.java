package kotlin.reflect.jvm.internal.impl.util;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class OperatorChecks$checks$1
  extends Lambda
  implements Function1<FunctionDescriptor, String>
{
  public static final 1 INSTANCE = new 1();
  
  OperatorChecks$checks$1()
  {
    super(1);
  }
  
  @Nullable
  public final String invoke(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "$receiver");
    paramFunctionDescriptor = paramFunctionDescriptor.getValueParameters();
    Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "valueParameters");
    paramFunctionDescriptor = (ValueParameterDescriptor)CollectionsKt.lastOrNull(paramFunctionDescriptor);
    int k = 0;
    int j = k;
    if (paramFunctionDescriptor != null)
    {
      int i;
      if ((!DescriptorUtilsKt.declaresOrInheritsDefaultValue(paramFunctionDescriptor)) && (paramFunctionDescriptor.getVarargElementType() == null)) {
        i = 1;
      } else {
        i = 0;
      }
      j = k;
      if (i == 1) {
        j = 1;
      }
    }
    paramFunctionDescriptor = (AbstractModifierChecks)OperatorChecks.INSTANCE;
    if (j == 0) {
      return "last parameter should not have a default value or be a vararg";
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.OperatorChecks.checks.1
 * JD-Core Version:    0.7.0.1
 */