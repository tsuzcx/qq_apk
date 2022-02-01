package kotlin.reflect.jvm.internal.impl.protobuf;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeneratedMessageLite$GeneratedExtension<ContainingType extends MessageLite, Type>
{
  final ContainingType containingTypeDefaultInstance;
  final Type defaultValue;
  final GeneratedMessageLite.ExtensionDescriptor descriptor;
  final Method enumValueOf;
  final MessageLite messageDefaultInstance;
  final Class singularType;
  
  GeneratedMessageLite$GeneratedExtension(ContainingType paramContainingType, Type paramType, MessageLite paramMessageLite, GeneratedMessageLite.ExtensionDescriptor paramExtensionDescriptor, Class paramClass)
  {
    if (paramContainingType != null)
    {
      if ((paramExtensionDescriptor.getLiteType() == WireFormat.FieldType.MESSAGE) && (paramMessageLite == null)) {
        throw new IllegalArgumentException("Null messageDefaultInstance");
      }
      this.containingTypeDefaultInstance = paramContainingType;
      this.defaultValue = paramType;
      this.messageDefaultInstance = paramMessageLite;
      this.descriptor = paramExtensionDescriptor;
      this.singularType = paramClass;
      if (Internal.EnumLite.class.isAssignableFrom(paramClass))
      {
        this.enumValueOf = GeneratedMessageLite.getMethodOrDie(paramClass, "valueOf", new Class[] { Integer.TYPE });
        return;
      }
      this.enumValueOf = null;
      return;
    }
    throw new IllegalArgumentException("Null containingTypeDefaultInstance");
  }
  
  Object fromFieldSetType(Object paramObject)
  {
    if (this.descriptor.isRepeated())
    {
      if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM)
      {
        ArrayList localArrayList = new ArrayList();
        paramObject = ((List)paramObject).iterator();
        while (paramObject.hasNext()) {
          localArrayList.add(singularFromFieldSetType(paramObject.next()));
        }
        return localArrayList;
      }
      return paramObject;
    }
    return singularFromFieldSetType(paramObject);
  }
  
  public ContainingType getContainingTypeDefaultInstance()
  {
    return this.containingTypeDefaultInstance;
  }
  
  public MessageLite getMessageDefaultInstance()
  {
    return this.messageDefaultInstance;
  }
  
  public int getNumber()
  {
    return this.descriptor.getNumber();
  }
  
  Object singularFromFieldSetType(Object paramObject)
  {
    Object localObject = paramObject;
    if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) {
      localObject = GeneratedMessageLite.invokeOrDie(this.enumValueOf, null, new Object[] { (Integer)paramObject });
    }
    return localObject;
  }
  
  Object singularToFieldSetType(Object paramObject)
  {
    Object localObject = paramObject;
    if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) {
      localObject = Integer.valueOf(((Internal.EnumLite)paramObject).getNumber());
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension
 * JD-Core Version:    0.7.0.1
 */