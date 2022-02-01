package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;

public abstract class GeneratedMessageLite
  extends AbstractMessageLite
  implements Serializable
{
  protected GeneratedMessageLite() {}
  
  protected GeneratedMessageLite(GeneratedMessageLite.Builder paramBuilder) {}
  
  static Method getMethodOrDie(Class paramClass, String paramString, Class... paramVarArgs)
  {
    try
    {
      paramVarArgs = paramClass.getMethod(paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (NoSuchMethodException paramVarArgs)
    {
      paramClass = String.valueOf(String.valueOf(paramClass.getName()));
      paramString = String.valueOf(String.valueOf(paramString));
      StringBuilder localStringBuilder = new StringBuilder(paramClass.length() + 45 + paramString.length());
      localStringBuilder.append("Generated message class \"");
      localStringBuilder.append(paramClass);
      localStringBuilder.append("\" missing method \"");
      localStringBuilder.append(paramString);
      localStringBuilder.append("\".");
      throw new RuntimeException(localStringBuilder.toString(), paramVarArgs);
    }
  }
  
  static Object invokeOrDie(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if (!(paramMethod instanceof RuntimeException))
      {
        if ((paramMethod instanceof Error)) {
          throw ((Error)paramMethod);
        }
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
      }
      throw ((RuntimeException)paramMethod);
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
  }
  
  public static <ContainingType extends MessageLite, Type> GeneratedMessageLite.GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType paramContainingType, MessageLite paramMessageLite, Internal.EnumLiteMap<?> paramEnumLiteMap, int paramInt, WireFormat.FieldType paramFieldType, boolean paramBoolean, Class paramClass)
  {
    return new GeneratedMessageLite.GeneratedExtension(paramContainingType, Collections.emptyList(), paramMessageLite, new GeneratedMessageLite.ExtensionDescriptor(paramEnumLiteMap, paramInt, paramFieldType, true, paramBoolean), paramClass);
  }
  
  public static <ContainingType extends MessageLite, Type> GeneratedMessageLite.GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType paramContainingType, Type paramType, MessageLite paramMessageLite, Internal.EnumLiteMap<?> paramEnumLiteMap, int paramInt, WireFormat.FieldType paramFieldType, Class paramClass)
  {
    return new GeneratedMessageLite.GeneratedExtension(paramContainingType, paramType, paramMessageLite, new GeneratedMessageLite.ExtensionDescriptor(paramEnumLiteMap, paramInt, paramFieldType, false, false), paramClass);
  }
  
  private static <MessageType extends MessageLite> boolean parseUnknownField(FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet, MessageType paramMessageType, CodedInputStream paramCodedInputStream, CodedOutputStream paramCodedOutputStream, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
  {
    int i = WireFormat.getTagWireType(paramInt);
    GeneratedMessageLite.GeneratedExtension localGeneratedExtension = paramExtensionRegistryLite.findLiteExtensionByNumber(paramMessageType, WireFormat.getTagFieldNumber(paramInt));
    if (localGeneratedExtension == null) {}
    do
    {
      for (i = 1;; i = 0)
      {
        j = 0;
        break label105;
        if (i != FieldSet.getWireFormatForFieldType(localGeneratedExtension.descriptor.getLiteType(), false)) {
          break;
        }
      }
    } while ((!localGeneratedExtension.descriptor.isRepeated) || (!localGeneratedExtension.descriptor.type.isPackable()) || (i != FieldSet.getWireFormatForFieldType(localGeneratedExtension.descriptor.getLiteType(), true)));
    i = 0;
    int j = 1;
    label105:
    if (i != 0) {
      return paramCodedInputStream.skipField(paramInt, paramCodedOutputStream);
    }
    if (j != 0)
    {
      paramInt = paramCodedInputStream.pushLimit(paramCodedInputStream.readRawVarint32());
      if (localGeneratedExtension.descriptor.getLiteType() == WireFormat.FieldType.ENUM) {
        while (paramCodedInputStream.getBytesUntilLimit() > 0)
        {
          i = paramCodedInputStream.readEnum();
          paramMessageType = localGeneratedExtension.descriptor.getEnumType().findValueByNumber(i);
          if (paramMessageType == null) {
            return true;
          }
          paramFieldSet.addRepeatedField(localGeneratedExtension.descriptor, localGeneratedExtension.singularToFieldSetType(paramMessageType));
        }
      }
      while (paramCodedInputStream.getBytesUntilLimit() > 0)
      {
        paramMessageType = FieldSet.readPrimitiveField(paramCodedInputStream, localGeneratedExtension.descriptor.getLiteType(), false);
        paramFieldSet.addRepeatedField(localGeneratedExtension.descriptor, paramMessageType);
      }
      paramCodedInputStream.popLimit(paramInt);
      return true;
    }
    i = GeneratedMessageLite.1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[localGeneratedExtension.descriptor.getLiteJavaType().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        paramMessageType = FieldSet.readPrimitiveField(paramCodedInputStream, localGeneratedExtension.descriptor.getLiteType(), false);
      }
      else
      {
        i = paramCodedInputStream.readEnum();
        paramMessageType = localGeneratedExtension.descriptor.getEnumType().findValueByNumber(i);
        if (paramMessageType == null)
        {
          paramCodedOutputStream.writeRawVarint32(paramInt);
          paramCodedOutputStream.writeUInt32NoTag(i);
          return true;
        }
      }
    }
    else
    {
      paramCodedOutputStream = null;
      paramMessageType = paramCodedOutputStream;
      if (!localGeneratedExtension.descriptor.isRepeated())
      {
        MessageLite localMessageLite = (MessageLite)paramFieldSet.getField(localGeneratedExtension.descriptor);
        paramMessageType = paramCodedOutputStream;
        if (localMessageLite != null) {
          paramMessageType = localMessageLite.toBuilder();
        }
      }
      paramCodedOutputStream = paramMessageType;
      if (paramMessageType == null) {
        paramCodedOutputStream = localGeneratedExtension.getMessageDefaultInstance().newBuilderForType();
      }
      if (localGeneratedExtension.descriptor.getLiteType() == WireFormat.FieldType.GROUP) {
        paramCodedInputStream.readGroup(localGeneratedExtension.getNumber(), paramCodedOutputStream, paramExtensionRegistryLite);
      } else {
        paramCodedInputStream.readMessage(paramCodedOutputStream, paramExtensionRegistryLite);
      }
      paramMessageType = paramCodedOutputStream.build();
    }
    if (localGeneratedExtension.descriptor.isRepeated())
    {
      paramFieldSet.addRepeatedField(localGeneratedExtension.descriptor, localGeneratedExtension.singularToFieldSetType(paramMessageType));
      return true;
    }
    paramFieldSet.setField(localGeneratedExtension.descriptor, localGeneratedExtension.singularToFieldSetType(paramMessageType));
    return true;
  }
  
  public Parser<? extends MessageLite> getParserForType()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  protected void makeExtensionsImmutable() {}
  
  protected boolean parseUnknownField(CodedInputStream paramCodedInputStream, CodedOutputStream paramCodedOutputStream, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
  {
    return paramCodedInputStream.skipField(paramInt, paramCodedOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
 * JD-Core Version:    0.7.0.1
 */