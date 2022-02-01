package kotlin.reflect.jvm.internal.impl.protobuf;

public abstract class GeneratedMessageLite$ExtendableBuilder<MessageType extends GeneratedMessageLite.ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>>
  extends GeneratedMessageLite.Builder<MessageType, BuilderType>
  implements GeneratedMessageLite.ExtendableMessageOrBuilder<MessageType>
{
  private FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions = FieldSet.emptySet();
  private boolean extensionsIsMutable;
  
  private FieldSet<GeneratedMessageLite.ExtensionDescriptor> buildExtensions()
  {
    this.extensions.makeImmutable();
    this.extensionsIsMutable = false;
    return this.extensions;
  }
  
  private void ensureExtensionsIsMutable()
  {
    if (!this.extensionsIsMutable)
    {
      this.extensions = this.extensions.clone();
      this.extensionsIsMutable = true;
    }
  }
  
  public BuilderType clone()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  protected boolean extensionsAreInitialized()
  {
    return this.extensions.isInitialized();
  }
  
  protected final void mergeExtensionFields(MessageType paramMessageType)
  {
    ensureExtensionsIsMutable();
    this.extensions.mergeFrom(GeneratedMessageLite.ExtendableMessage.access$200(paramMessageType));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder
 * JD-Core Version:    0.7.0.1
 */