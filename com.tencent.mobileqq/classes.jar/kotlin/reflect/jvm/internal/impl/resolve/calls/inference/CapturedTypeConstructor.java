package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import org.jetbrains.annotations.NotNull;

public abstract interface CapturedTypeConstructor
  extends TypeConstructor, CapturedTypeConstructorMarker
{
  @NotNull
  public abstract TypeProjection getProjection();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor
 * JD-Core Version:    0.7.0.1
 */