package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public final class FlexibleTypeDeserializer$ThrowException
  implements FlexibleTypeDeserializer
{
  public static final ThrowException INSTANCE = new ThrowException();
  
  @NotNull
  public KotlinType create(@NotNull ProtoBuf.Type paramType, @NotNull String paramString, @NotNull SimpleType paramSimpleType1, @NotNull SimpleType paramSimpleType2)
  {
    Intrinsics.checkParameterIsNotNull(paramType, "proto");
    Intrinsics.checkParameterIsNotNull(paramString, "flexibleId");
    Intrinsics.checkParameterIsNotNull(paramSimpleType1, "lowerBound");
    Intrinsics.checkParameterIsNotNull(paramSimpleType2, "upperBound");
    throw ((Throwable)new IllegalArgumentException("This method should not be used."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer.ThrowException
 * JD-Core Version:    0.7.0.1
 */