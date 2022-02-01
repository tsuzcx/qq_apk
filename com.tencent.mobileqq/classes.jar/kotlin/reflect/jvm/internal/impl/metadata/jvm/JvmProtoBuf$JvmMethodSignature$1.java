package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;

final class JvmProtoBuf$JvmMethodSignature$1
  extends AbstractParser<JvmProtoBuf.JvmMethodSignature>
{
  public JvmProtoBuf.JvmMethodSignature parsePartialFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return new JvmProtoBuf.JvmMethodSignature(paramCodedInputStream, paramExtensionRegistryLite, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.1
 * JD-Core Version:    0.7.0.1
 */