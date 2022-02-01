package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;

public abstract interface ErrorReporter
{
  public static final ErrorReporter DO_NOTHING = new ErrorReporter.1();
  
  public abstract void reportCannotInferVisibility(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor);
  
  public abstract void reportIncompleteHierarchy(@NotNull ClassDescriptor paramClassDescriptor, @NotNull List<String> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
 * JD-Core Version:    0.7.0.1
 */