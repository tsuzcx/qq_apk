package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class OperatorChecks$checks$2
  extends Lambda
  implements Function1<FunctionDescriptor, String>
{
  public static final 2 INSTANCE = new 2();
  
  OperatorChecks$checks$2()
  {
    super(1);
  }
  
  @Nullable
  public final String invoke(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "$receiver");
    OperatorChecks.checks.2.1 local1 = OperatorChecks.checks.2.1.INSTANCE;
    Object localObject = (AbstractModifierChecks)OperatorChecks.INSTANCE;
    localObject = paramFunctionDescriptor.getContainingDeclaration();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "containingDeclaration");
    boolean bool = local1.invoke((DeclarationDescriptor)localObject);
    int j = 1;
    int i = j;
    if (!bool)
    {
      paramFunctionDescriptor = paramFunctionDescriptor.getOverriddenDescriptors();
      Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "overriddenDescriptors");
      paramFunctionDescriptor = (Iterable)paramFunctionDescriptor;
      if (((paramFunctionDescriptor instanceof Collection)) && (((Collection)paramFunctionDescriptor).isEmpty())) {}
      do
      {
        while (!paramFunctionDescriptor.hasNext())
        {
          i = 0;
          break;
          paramFunctionDescriptor = paramFunctionDescriptor.iterator();
        }
        localObject = (FunctionDescriptor)paramFunctionDescriptor.next();
        local1 = OperatorChecks.checks.2.1.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
        localObject = ((FunctionDescriptor)localObject).getContainingDeclaration();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it.containingDeclaration");
      } while (!local1.invoke((DeclarationDescriptor)localObject));
      i = 1;
      if (i != 0) {
        i = j;
      } else {
        i = 0;
      }
    }
    if (i == 0) {
      return "must override ''equals()'' in Any";
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.OperatorChecks.checks.2
 * JD-Core Version:    0.7.0.1
 */