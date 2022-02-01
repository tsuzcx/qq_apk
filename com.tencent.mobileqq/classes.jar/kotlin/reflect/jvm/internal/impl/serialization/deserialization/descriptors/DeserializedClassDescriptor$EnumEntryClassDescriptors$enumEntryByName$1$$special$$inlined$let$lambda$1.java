package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import org.jetbrains.annotations.NotNull;

final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$$special$$inlined$let$lambda$1
  extends Lambda
  implements Function0<List<? extends AnnotationDescriptor>>
{
  DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$$special$$inlined$let$lambda$1(ProtoBuf.EnumEntry paramEnumEntry, DeserializedClassDescriptor.EnumEntryClassDescriptors.enumEntryByName.1 param1, Name paramName)
  {
    super(0);
  }
  
  @NotNull
  public final List<AnnotationDescriptor> invoke()
  {
    return CollectionsKt.toList((Iterable)this.this$0.this$0.this$0.getC().getComponents().getAnnotationAndConstantLoader().loadEnumEntryAnnotations((ProtoContainer)this.this$0.this$0.this$0.getThisAsProtoContainer$deserialization(), this.$proto));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.EnumEntryClassDescriptors.enumEntryByName.1..special..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */