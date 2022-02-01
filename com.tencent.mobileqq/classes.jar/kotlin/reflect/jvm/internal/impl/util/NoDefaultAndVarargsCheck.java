package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class NoDefaultAndVarargsCheck
  implements Check
{
  public static final NoDefaultAndVarargsCheck INSTANCE = new NoDefaultAndVarargsCheck();
  @NotNull
  private static final String description = "should not have varargs or parameters with default values";
  
  public boolean check(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "functionDescriptor");
    paramFunctionDescriptor = paramFunctionDescriptor.getValueParameters();
    Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "functionDescriptor.valueParameters");
    paramFunctionDescriptor = (Iterable)paramFunctionDescriptor;
    boolean bool1 = paramFunctionDescriptor instanceof Collection;
    boolean bool2 = true;
    if ((bool1) && (((Collection)paramFunctionDescriptor).isEmpty())) {
      return true;
    }
    paramFunctionDescriptor = paramFunctionDescriptor.iterator();
    int i;
    do
    {
      bool1 = bool2;
      if (!paramFunctionDescriptor.hasNext()) {
        break;
      }
      ValueParameterDescriptor localValueParameterDescriptor = (ValueParameterDescriptor)paramFunctionDescriptor.next();
      Intrinsics.checkExpressionValueIsNotNull(localValueParameterDescriptor, "it");
      if ((!DescriptorUtilsKt.declaresOrInheritsDefaultValue(localValueParameterDescriptor)) && (localValueParameterDescriptor.getVarargElementType() == null)) {
        i = 1;
      } else {
        i = 0;
      }
    } while (i != 0);
    bool1 = false;
    return bool1;
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
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.NoDefaultAndVarargsCheck
 * JD-Core Version:    0.7.0.1
 */