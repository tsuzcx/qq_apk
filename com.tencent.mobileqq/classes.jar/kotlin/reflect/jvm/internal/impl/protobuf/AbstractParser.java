package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractParser<MessageType extends MessageLite>
  implements Parser<MessageType>
{
  private static final ExtensionRegistryLite EMPTY_REGISTRY = ;
  
  private MessageType checkMessageInitialized(MessageType paramMessageType)
  {
    if (paramMessageType != null)
    {
      if (paramMessageType.isInitialized()) {
        return paramMessageType;
      }
      throw newUninitializedMessageException(paramMessageType).asInvalidProtocolBufferException().setUnfinishedMessage(paramMessageType);
    }
    return paramMessageType;
  }
  
  private UninitializedMessageException newUninitializedMessageException(MessageType paramMessageType)
  {
    if ((paramMessageType instanceof AbstractMessageLite)) {
      return ((AbstractMessageLite)paramMessageType).newUninitializedMessageException();
    }
    return new UninitializedMessageException(paramMessageType);
  }
  
  public MessageType parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return checkMessageInitialized(parsePartialDelimitedFrom(paramInputStream, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return checkMessageInitialized(parsePartialFrom(paramInputStream, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return checkMessageInitialized(parsePartialFrom(paramByteString, paramExtensionRegistryLite));
  }
  
  public MessageType parsePartialDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    try
    {
      int i = paramInputStream.read();
      if (i == -1) {
        return null;
      }
      i = CodedInputStream.readRawVarint32(i, paramInputStream);
      return parsePartialFrom(new AbstractMessageLite.Builder.LimitedInputStream(paramInputStream, i), paramExtensionRegistryLite);
    }
    catch (IOException paramInputStream)
    {
      throw new InvalidProtocolBufferException(paramInputStream.getMessage());
    }
  }
  
  public MessageType parsePartialFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    paramInputStream = CodedInputStream.newInstance(paramInputStream);
    paramExtensionRegistryLite = (MessageLite)parsePartialFrom(paramInputStream, paramExtensionRegistryLite);
    try
    {
      paramInputStream.checkLastTagWas(0);
      return paramExtensionRegistryLite;
    }
    catch (InvalidProtocolBufferException paramInputStream)
    {
      throw paramInputStream.setUnfinishedMessage(paramExtensionRegistryLite);
    }
  }
  
  /* Error */
  public MessageType parsePartialFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 125	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newCodedInput	()Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokevirtual 115	kotlin/reflect/jvm/internal/impl/protobuf/AbstractParser:parsePartialFrom	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Ljava/lang/Object;
    //   11: checkcast 27	kotlin/reflect/jvm/internal/impl/protobuf/MessageLite
    //   14: astore_2
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual 119	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:checkLastTagWas	(I)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_1
    //   23: aload_1
    //   24: aload_2
    //   25: invokevirtual 47	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   28: athrow
    //   29: astore_1
    //   30: aload_1
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	AbstractParser
    //   0	32	1	paramByteString	ByteString
    //   0	32	2	paramExtensionRegistryLite	ExtensionRegistryLite
    // Exception table:
    //   from	to	target	type
    //   15	20	22	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   0	15	29	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   23	29	29	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser
 * JD-Core Version:    0.7.0.1
 */