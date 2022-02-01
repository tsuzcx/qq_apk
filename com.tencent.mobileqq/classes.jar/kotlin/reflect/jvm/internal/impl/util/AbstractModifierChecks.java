package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractModifierChecks
{
  @NotNull
  public final CheckResult check(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "functionDescriptor");
    Iterator localIterator = getChecks$descriptors().iterator();
    while (localIterator.hasNext())
    {
      Checks localChecks = (Checks)localIterator.next();
      if (localChecks.isApplicable(paramFunctionDescriptor)) {
        return localChecks.checkAll(paramFunctionDescriptor);
      }
    }
    return (CheckResult)CheckResult.IllegalFunctionName.INSTANCE;
  }
  
  @NotNull
  public abstract List<Checks> getChecks$descriptors();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks
 * JD-Core Version:    0.7.0.1
 */