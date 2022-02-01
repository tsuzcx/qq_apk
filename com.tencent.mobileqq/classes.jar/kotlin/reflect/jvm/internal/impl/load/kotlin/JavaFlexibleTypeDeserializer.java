package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public final class JavaFlexibleTypeDeserializer
  implements FlexibleTypeDeserializer
{
  public static final JavaFlexibleTypeDeserializer INSTANCE = new JavaFlexibleTypeDeserializer();
  
  @NotNull
  public KotlinType create(@NotNull ProtoBuf.Type paramType, @NotNull String paramString, @NotNull SimpleType paramSimpleType1, @NotNull SimpleType paramSimpleType2)
  {
    Intrinsics.checkParameterIsNotNull(paramType, "proto");
    Intrinsics.checkParameterIsNotNull(paramString, "flexibleId");
    Intrinsics.checkParameterIsNotNull(paramSimpleType1, "lowerBound");
    Intrinsics.checkParameterIsNotNull(paramSimpleType2, "upperBound");
    if ((Intrinsics.areEqual(paramString, "kotlin.jvm.PlatformType") ^ true))
    {
      paramType = new StringBuilder();
      paramType.append("Error java flexible type with id: ");
      paramType.append(paramString);
      paramType.append(". (");
      paramType.append(paramSimpleType1);
      paramType.append("..");
      paramType.append(paramSimpleType2);
      paramType.append(')');
      paramType = ErrorUtils.createErrorType(paramType.toString());
      Intrinsics.checkExpressionValueIsNotNull(paramType, "ErrorUtils.createErrorTy…owerBound..$upperBound)\")");
      return (KotlinType)paramType;
    }
    if (paramType.hasExtension(JvmProtoBuf.isRaw)) {
      return (KotlinType)new RawTypeImpl(paramSimpleType1, paramSimpleType2);
    }
    return (KotlinType)KotlinTypeFactory.flexibleType(paramSimpleType1, paramSimpleType2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.JavaFlexibleTypeDeserializer
 * JD-Core Version:    0.7.0.1
 */