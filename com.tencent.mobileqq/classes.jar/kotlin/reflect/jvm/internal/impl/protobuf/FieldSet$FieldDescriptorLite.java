package kotlin.reflect.jvm.internal.impl.protobuf;

public abstract interface FieldSet$FieldDescriptorLite<T extends FieldDescriptorLite<T>>
  extends Comparable<T>
{
  public abstract WireFormat.JavaType getLiteJavaType();
  
  public abstract WireFormat.FieldType getLiteType();
  
  public abstract int getNumber();
  
  public abstract MessageLite.Builder internalMergeFrom(MessageLite.Builder paramBuilder, MessageLite paramMessageLite);
  
  public abstract boolean isPacked();
  
  public abstract boolean isRepeated();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
 * JD-Core Version:    0.7.0.1
 */