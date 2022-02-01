package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;

public abstract interface Substitutable<T extends DeclarationDescriptorNonRoot>
{
  @NotNull
  public abstract T substitute(@NotNull TypeSubstitutor paramTypeSubstitutor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
 * JD-Core Version:    0.7.0.1
 */