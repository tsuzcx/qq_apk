package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class OperatorChecks$checks$3
  extends Lambda
  implements Function1<FunctionDescriptor, String>
{
  public static final 3 INSTANCE = new 3();
  
  OperatorChecks$checks$3()
  {
    super(1);
  }
  
  @Nullable
  public final String invoke(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "$receiver");
    Object localObject = paramFunctionDescriptor.getDispatchReceiverParameter();
    if (localObject == null) {
      localObject = paramFunctionDescriptor.getExtensionReceiverParameter();
    }
    AbstractModifierChecks localAbstractModifierChecks = (AbstractModifierChecks)OperatorChecks.INSTANCE;
    int j = 0;
    int i = j;
    if (localObject != null)
    {
      paramFunctionDescriptor = paramFunctionDescriptor.getReturnType();
      boolean bool;
      if (paramFunctionDescriptor != null)
      {
        localObject = ((ReceiverParameterDescriptor)localObject).getType();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "receiver.type");
        bool = TypeUtilsKt.isSubtypeOf(paramFunctionDescriptor, (KotlinType)localObject);
      }
      else
      {
        bool = false;
      }
      i = j;
      if (bool) {
        i = 1;
      }
    }
    if (i == 0) {
      return "receiver must be a supertype of the return type";
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.OperatorChecks.checks.3
 * JD-Core Version:    0.7.0.1
 */