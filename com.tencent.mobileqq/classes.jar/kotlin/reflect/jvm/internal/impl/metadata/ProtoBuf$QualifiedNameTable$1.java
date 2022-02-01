package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;

final class ProtoBuf$QualifiedNameTable$1
  extends AbstractParser<ProtoBuf.QualifiedNameTable>
{
  public ProtoBuf.QualifiedNameTable parsePartialFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return new ProtoBuf.QualifiedNameTable(paramCodedInputStream, paramExtensionRegistryLite, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.1
 * JD-Core Version:    0.7.0.1
 */