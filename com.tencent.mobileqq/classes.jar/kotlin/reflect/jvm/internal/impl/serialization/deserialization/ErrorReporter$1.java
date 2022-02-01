package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;

final class ErrorReporter$1
  implements ErrorReporter
{
  public void reportCannotInferVisibility(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    if (paramCallableMemberDescriptor == null) {
      $$$reportNull$$$0(2);
    }
  }
  
  public void reportIncompleteHierarchy(@NotNull ClassDescriptor paramClassDescriptor, @NotNull List<String> paramList)
  {
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(0);
    }
    if (paramList == null) {
      $$$reportNull$$$0(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter.1
 * JD-Core Version:    0.7.0.1
 */