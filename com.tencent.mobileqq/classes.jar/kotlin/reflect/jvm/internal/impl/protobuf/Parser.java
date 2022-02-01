package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;

public abstract interface Parser<MessageType>
{
  public abstract MessageType parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parsePartialFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.Parser
 * JD-Core Version:    0.7.0.1
 */