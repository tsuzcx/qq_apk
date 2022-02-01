package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.Map.Entry;

public class GeneratedMessageLite$ExtendableMessage$ExtensionWriter
{
  private final Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> iter = GeneratedMessageLite.ExtendableMessage.access$200(this.this$0).iterator();
  private final boolean messageSetWireFormat;
  private Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object> next;
  
  private GeneratedMessageLite$ExtendableMessage$ExtensionWriter(GeneratedMessageLite.ExtendableMessage paramExtendableMessage, boolean paramBoolean)
  {
    if (this.iter.hasNext()) {
      this.next = ((Map.Entry)this.iter.next());
    }
    this.messageSetWireFormat = paramBoolean;
  }
  
  public void writeUntil(int paramInt, CodedOutputStream paramCodedOutputStream)
  {
    for (;;)
    {
      Object localObject = this.next;
      if ((localObject == null) || (((GeneratedMessageLite.ExtensionDescriptor)((Map.Entry)localObject).getKey()).getNumber() >= paramInt)) {
        break;
      }
      localObject = (GeneratedMessageLite.ExtensionDescriptor)this.next.getKey();
      if ((this.messageSetWireFormat) && (((GeneratedMessageLite.ExtensionDescriptor)localObject).getLiteJavaType() == WireFormat.JavaType.MESSAGE) && (!((GeneratedMessageLite.ExtensionDescriptor)localObject).isRepeated())) {
        paramCodedOutputStream.writeMessageSetExtension(((GeneratedMessageLite.ExtensionDescriptor)localObject).getNumber(), (MessageLite)this.next.getValue());
      } else {
        FieldSet.writeField((FieldSet.FieldDescriptorLite)localObject, this.next.getValue(), paramCodedOutputStream);
      }
      if (this.iter.hasNext()) {
        this.next = ((Map.Entry)this.iter.next());
      } else {
        this.next = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage.ExtensionWriter
 * JD-Core Version:    0.7.0.1
 */