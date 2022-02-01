package kotlin.reflect.jvm.internal.impl.types.model;

import org.jetbrains.annotations.NotNull;

public abstract interface TypeSystemOptimizationContext
{
  public abstract boolean identicalArguments(@NotNull SimpleTypeMarker paramSimpleTypeMarker1, @NotNull SimpleTypeMarker paramSimpleTypeMarker2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.model.TypeSystemOptimizationContext
 * JD-Core Version:    0.7.0.1
 */