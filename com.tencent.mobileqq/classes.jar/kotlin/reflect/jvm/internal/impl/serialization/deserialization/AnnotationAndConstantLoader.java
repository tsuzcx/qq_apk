package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface AnnotationAndConstantLoader<A, C>
{
  @NotNull
  public abstract List<A> loadCallableAnnotations(@NotNull ProtoContainer paramProtoContainer, @NotNull MessageLite paramMessageLite, @NotNull AnnotatedCallableKind paramAnnotatedCallableKind);
  
  @NotNull
  public abstract List<A> loadClassAnnotations(@NotNull ProtoContainer.Class paramClass);
  
  @NotNull
  public abstract List<A> loadEnumEntryAnnotations(@NotNull ProtoContainer paramProtoContainer, @NotNull ProtoBuf.EnumEntry paramEnumEntry);
  
  @NotNull
  public abstract List<A> loadExtensionReceiverParameterAnnotations(@NotNull ProtoContainer paramProtoContainer, @NotNull MessageLite paramMessageLite, @NotNull AnnotatedCallableKind paramAnnotatedCallableKind);
  
  @NotNull
  public abstract List<A> loadPropertyBackingFieldAnnotations(@NotNull ProtoContainer paramProtoContainer, @NotNull ProtoBuf.Property paramProperty);
  
  @Nullable
  public abstract C loadPropertyConstant(@NotNull ProtoContainer paramProtoContainer, @NotNull ProtoBuf.Property paramProperty, @NotNull KotlinType paramKotlinType);
  
  @NotNull
  public abstract List<A> loadPropertyDelegateFieldAnnotations(@NotNull ProtoContainer paramProtoContainer, @NotNull ProtoBuf.Property paramProperty);
  
  @NotNull
  public abstract List<A> loadTypeAnnotations(@NotNull ProtoBuf.Type paramType, @NotNull NameResolver paramNameResolver);
  
  @NotNull
  public abstract List<A> loadTypeParameterAnnotations(@NotNull ProtoBuf.TypeParameter paramTypeParameter, @NotNull NameResolver paramNameResolver);
  
  @NotNull
  public abstract List<A> loadValueParameterAnnotations(@NotNull ProtoContainer paramProtoContainer, @NotNull MessageLite paramMessageLite, @NotNull AnnotatedCallableKind paramAnnotatedCallableKind, int paramInt, @NotNull ProtoBuf.ValueParameter paramValueParameter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
 * JD-Core Version:    0.7.0.1
 */