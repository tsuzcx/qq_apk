package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

final class ReflectionTypes$ClassLookup
{
  private final int numberOfTypeParameters;
  
  public ReflectionTypes$ClassLookup(int paramInt)
  {
    this.numberOfTypeParameters = paramInt;
  }
  
  @NotNull
  public final ClassDescriptor getValue(@NotNull ReflectionTypes paramReflectionTypes, @NotNull KProperty<?> paramKProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramReflectionTypes, "types");
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    return ReflectionTypes.access$find(paramReflectionTypes, StringsKt.capitalize(paramKProperty.getName()), this.numberOfTypeParameters);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.ClassLookup
 * JD-Core Version:    0.7.0.1
 */