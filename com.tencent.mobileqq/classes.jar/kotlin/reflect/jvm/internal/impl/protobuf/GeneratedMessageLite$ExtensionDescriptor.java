package kotlin.reflect.jvm.internal.impl.protobuf;

final class GeneratedMessageLite$ExtensionDescriptor
  implements FieldSet.FieldDescriptorLite<ExtensionDescriptor>
{
  final Internal.EnumLiteMap<?> enumTypeMap;
  final boolean isPacked;
  final boolean isRepeated;
  final int number;
  final WireFormat.FieldType type;
  
  GeneratedMessageLite$ExtensionDescriptor(Internal.EnumLiteMap<?> paramEnumLiteMap, int paramInt, WireFormat.FieldType paramFieldType, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.enumTypeMap = paramEnumLiteMap;
    this.number = paramInt;
    this.type = paramFieldType;
    this.isRepeated = paramBoolean1;
    this.isPacked = paramBoolean2;
  }
  
  public int compareTo(ExtensionDescriptor paramExtensionDescriptor)
  {
    return this.number - paramExtensionDescriptor.number;
  }
  
  public Internal.EnumLiteMap<?> getEnumType()
  {
    return this.enumTypeMap;
  }
  
  public WireFormat.JavaType getLiteJavaType()
  {
    return this.type.getJavaType();
  }
  
  public WireFormat.FieldType getLiteType()
  {
    return this.type;
  }
  
  public int getNumber()
  {
    return this.number;
  }
  
  public MessageLite.Builder internalMergeFrom(MessageLite.Builder paramBuilder, MessageLite paramMessageLite)
  {
    return ((GeneratedMessageLite.Builder)paramBuilder).mergeFrom((GeneratedMessageLite)paramMessageLite);
  }
  
  public boolean isPacked()
  {
    return this.isPacked;
  }
  
  public boolean isRepeated()
  {
    return this.isRepeated;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtensionDescriptor
 * JD-Core Version:    0.7.0.1
 */