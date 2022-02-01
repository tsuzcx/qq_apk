package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;

public final class MemberKindCheck$MemberOrExtension
  extends MemberKindCheck
{
  public static final MemberOrExtension INSTANCE = new MemberOrExtension();
  
  private MemberKindCheck$MemberOrExtension()
  {
    super("must be a member or an extension function", null);
  }
  
  public boolean check(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "functionDescriptor");
    return (paramFunctionDescriptor.getDispatchReceiverParameter() != null) || (paramFunctionDescriptor.getExtensionReceiverParameter() != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension
 * JD-Core Version:    0.7.0.1
 */