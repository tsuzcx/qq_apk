package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.List;

public abstract class GeneratedMessageLite$ExtendableMessage<MessageType extends ExtendableMessage<MessageType>>
  extends GeneratedMessageLite
  implements GeneratedMessageLite.ExtendableMessageOrBuilder<MessageType>
{
  private final FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions;
  
  protected GeneratedMessageLite$ExtendableMessage()
  {
    this.extensions = FieldSet.newFieldSet();
  }
  
  protected GeneratedMessageLite$ExtendableMessage(GeneratedMessageLite.ExtendableBuilder<MessageType, ?> paramExtendableBuilder)
  {
    this.extensions = GeneratedMessageLite.ExtendableBuilder.access$000(paramExtendableBuilder);
  }
  
  private void verifyExtensionContainingType(GeneratedMessageLite.GeneratedExtension<MessageType, ?> paramGeneratedExtension)
  {
    if (paramGeneratedExtension.getContainingTypeDefaultInstance() == getDefaultInstanceForType()) {
      return;
    }
    throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
  }
  
  protected boolean extensionsAreInitialized()
  {
    return this.extensions.isInitialized();
  }
  
  protected int extensionsSerializedSize()
  {
    return this.extensions.getSerializedSize();
  }
  
  public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension)
  {
    verifyExtensionContainingType(paramGeneratedExtension);
    Object localObject = this.extensions.getField(paramGeneratedExtension.descriptor);
    if (localObject == null) {
      return paramGeneratedExtension.defaultValue;
    }
    return paramGeneratedExtension.fromFieldSetType(localObject);
  }
  
  public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, int paramInt)
  {
    verifyExtensionContainingType(paramGeneratedExtension);
    return paramGeneratedExtension.singularFromFieldSetType(this.extensions.getRepeatedField(paramGeneratedExtension.descriptor, paramInt));
  }
  
  public final <Type> int getExtensionCount(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension)
  {
    verifyExtensionContainingType(paramGeneratedExtension);
    return this.extensions.getRepeatedFieldCount(paramGeneratedExtension.descriptor);
  }
  
  public final <Type> boolean hasExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension)
  {
    verifyExtensionContainingType(paramGeneratedExtension);
    return this.extensions.hasField(paramGeneratedExtension.descriptor);
  }
  
  protected void makeExtensionsImmutable()
  {
    this.extensions.makeImmutable();
  }
  
  protected ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter()
  {
    return new GeneratedMessageLite.ExtendableMessage.ExtensionWriter(this, false, null);
  }
  
  protected boolean parseUnknownField(CodedInputStream paramCodedInputStream, CodedOutputStream paramCodedOutputStream, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
  {
    return GeneratedMessageLite.access$100(this.extensions, getDefaultInstanceForType(), paramCodedInputStream, paramCodedOutputStream, paramExtensionRegistryLite, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage
 * JD-Core Version:    0.7.0.1
 */