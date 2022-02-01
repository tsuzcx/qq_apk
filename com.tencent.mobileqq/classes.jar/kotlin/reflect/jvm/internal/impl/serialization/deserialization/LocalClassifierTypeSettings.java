package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.Nullable;

public abstract interface LocalClassifierTypeSettings
{
  @Nullable
  public abstract SimpleType getReplacementTypeForLocalClassifiers();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings
 * JD-Core Version:    0.7.0.1
 */