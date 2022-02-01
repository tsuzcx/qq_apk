package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import org.jetbrains.annotations.NotNull;

public abstract interface ClassifierNamePolicy
{
  @NotNull
  public abstract String renderClassifier(@NotNull ClassifierDescriptor paramClassifierDescriptor, @NotNull DescriptorRenderer paramDescriptorRenderer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
 * JD-Core Version:    0.7.0.1
 */