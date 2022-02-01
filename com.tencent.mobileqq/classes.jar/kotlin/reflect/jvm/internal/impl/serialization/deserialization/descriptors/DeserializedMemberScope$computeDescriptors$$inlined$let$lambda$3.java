package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;

public final class DeserializedMemberScope$computeDescriptors$$inlined$let$lambda$3
  extends Lambda
  implements Function0<M>
{
  public DeserializedMemberScope$computeDescriptors$$inlined$let$lambda$3(ByteArrayInputStream paramByteArrayInputStream, DeserializedMemberScope paramDeserializedMemberScope, Parser paramParser)
  {
    super(0);
  }
  
  public final M invoke()
  {
    return (MessageLite)this.$parser$inlined.parseDelimitedFrom((InputStream)this.$inputStream, this.this$0.getC().getComponents().getExtensionRegistryLite());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.computeDescriptors..inlined.let.lambda.3
 * JD-Core Version:    0.7.0.1
 */