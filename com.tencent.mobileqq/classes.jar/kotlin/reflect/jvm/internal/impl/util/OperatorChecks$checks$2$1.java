package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import org.jetbrains.annotations.NotNull;

final class OperatorChecks$checks$2$1
  extends Lambda
  implements Function1<DeclarationDescriptor, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  OperatorChecks$checks$2$1()
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "$this$isAny");
    return ((paramDeclarationDescriptor instanceof ClassDescriptor)) && (KotlinBuiltIns.isAny((ClassDescriptor)paramDeclarationDescriptor));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.OperatorChecks.checks.2.1
 * JD-Core Version:    0.7.0.1
 */