package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.annotations.NotNull;

public final class PlatformDependentDeclarationFilter$All
  implements PlatformDependentDeclarationFilter
{
  public static final All INSTANCE = new All();
  
  public boolean isFunctionAvailable(@NotNull ClassDescriptor paramClassDescriptor, @NotNull SimpleFunctionDescriptor paramSimpleFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    Intrinsics.checkParameterIsNotNull(paramSimpleFunctionDescriptor, "functionDescriptor");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter.All
 * JD-Core Version:    0.7.0.1
 */