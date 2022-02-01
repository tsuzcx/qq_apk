package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface ClassicTypeSystemContext
  extends TypeSystemCommonBackendContext, TypeSystemInferenceExtensionContext
{
  @Nullable
  public abstract SimpleTypeMarker asSimpleType(@NotNull KotlinTypeMarker paramKotlinTypeMarker);
  
  @NotNull
  public abstract TypeConstructorMarker typeConstructor(@NotNull SimpleTypeMarker paramSimpleTypeMarker);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext
 * JD-Core Version:    0.7.0.1
 */