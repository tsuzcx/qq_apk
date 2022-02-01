package kotlin.reflect.jvm.internal.impl.protobuf;

public abstract class AbstractMessageLite$Builder<BuilderType extends Builder>
  implements MessageLite.Builder
{
  protected static UninitializedMessageException newUninitializedMessageException(MessageLite paramMessageLite)
  {
    return new UninitializedMessageException(paramMessageLite);
  }
  
  public abstract BuilderType clone();
  
  public abstract BuilderType mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
 * JD-Core Version:    0.7.0.1
 */