package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;

public final class MemberKindCheck$Member
  extends MemberKindCheck
{
  public static final Member INSTANCE = new Member();
  
  private MemberKindCheck$Member()
  {
    super("must be a member function", null);
  }
  
  public boolean check(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "functionDescriptor");
    return paramFunctionDescriptor.getDispatchReceiverParameter() != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.Member
 * JD-Core Version:    0.7.0.1
 */