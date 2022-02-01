package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;

final class ProtoBuf$VersionRequirement$1
  extends AbstractParser<ProtoBuf.VersionRequirement>
{
  public ProtoBuf.VersionRequirement parsePartialFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return new ProtoBuf.VersionRequirement(paramCodedInputStream, paramExtensionRegistryLite, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.1
 * JD-Core Version:    0.7.0.1
 */