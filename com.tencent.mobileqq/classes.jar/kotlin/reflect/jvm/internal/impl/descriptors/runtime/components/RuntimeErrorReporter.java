package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import org.jetbrains.annotations.NotNull;

public final class RuntimeErrorReporter
  implements ErrorReporter
{
  public static final RuntimeErrorReporter INSTANCE = new RuntimeErrorReporter();
  
  public void reportCannotInferVisibility(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "descriptor");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot infer visibility for ");
    localStringBuilder.append(paramCallableMemberDescriptor);
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString()));
  }
  
  public void reportIncompleteHierarchy(@NotNull ClassDescriptor paramClassDescriptor, @NotNull List<String> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramList, "unresolvedSuperClasses");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Incomplete hierarchy for class ");
    localStringBuilder.append(paramClassDescriptor.getName());
    localStringBuilder.append(", unresolved classes ");
    localStringBuilder.append(paramList);
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeErrorReporter
 * JD-Core Version:    0.7.0.1
 */