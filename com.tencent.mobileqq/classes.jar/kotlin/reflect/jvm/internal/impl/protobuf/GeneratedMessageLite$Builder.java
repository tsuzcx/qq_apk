package kotlin.reflect.jvm.internal.impl.protobuf;

public abstract class GeneratedMessageLite$Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder>
  extends AbstractMessageLite.Builder<BuilderType>
{
  private ByteString unknownFields = ByteString.EMPTY;
  
  public BuilderType clone()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  public abstract MessageType getDefaultInstanceForType();
  
  public final ByteString getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public abstract BuilderType mergeFrom(MessageType paramMessageType);
  
  public final BuilderType setUnknownFields(ByteString paramByteString)
  {
    this.unknownFields = paramByteString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
 * JD-Core Version:    0.7.0.1
 */