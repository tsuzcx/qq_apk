package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public abstract interface FlexibleTypeDeserializer
{
  @NotNull
  public abstract KotlinType create(@NotNull ProtoBuf.Type paramType, @NotNull String paramString, @NotNull SimpleType paramSimpleType1, @NotNull SimpleType paramSimpleType2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
 * JD-Core Version:    0.7.0.1
 */