package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType;

public final class JvmProtoBuf
{
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> anonymousObjectOriginName;
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Property>> classLocalVariable;
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> classModuleName;
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, JvmProtoBuf.JvmMethodSignature> constructorSignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Constructor.getDefaultInstance(), JvmProtoBuf.JvmMethodSignature.getDefaultInstance(), JvmProtoBuf.JvmMethodSignature.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, JvmProtoBuf.JvmMethodSignature.class);
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, Integer> flags;
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, Boolean> isRaw;
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, Integer> lambdaClassOriginName;
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, JvmProtoBuf.JvmMethodSignature> methodSignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), JvmProtoBuf.JvmMethodSignature.getDefaultInstance(), JvmProtoBuf.JvmMethodSignature.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, JvmProtoBuf.JvmMethodSignature.class);
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, List<ProtoBuf.Property>> packageLocalVariable = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Property.class);
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> packageModuleName;
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature;
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> typeAnnotation;
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> typeParameterAnnotation;
  
  static
  {
    ProtoBuf.Function localFunction = ProtoBuf.Function.getDefaultInstance();
    Integer localInteger = Integer.valueOf(0);
    lambdaClassOriginName = GeneratedMessageLite.newSingularGeneratedExtension(localFunction, localInteger, null, null, 101, WireFormat.FieldType.INT32, Integer.class);
    propertySignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), JvmProtoBuf.JvmPropertySignature.getDefaultInstance(), JvmProtoBuf.JvmPropertySignature.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, JvmProtoBuf.JvmPropertySignature.class);
    flags = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), localInteger, null, null, 101, WireFormat.FieldType.INT32, Integer.class);
    typeAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    isRaw = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), Boolean.valueOf(false), null, null, 101, WireFormat.FieldType.BOOL, Boolean.class);
    typeParameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.TypeParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    classModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), localInteger, null, null, 101, WireFormat.FieldType.INT32, Integer.class);
    classLocalVariable = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Property.class);
    anonymousObjectOriginName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), localInteger, null, null, 103, WireFormat.FieldType.INT32, Integer.class);
    packageModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), localInteger, null, null, 101, WireFormat.FieldType.INT32, Integer.class);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite)
  {
    paramExtensionRegistryLite.add(constructorSignature);
    paramExtensionRegistryLite.add(methodSignature);
    paramExtensionRegistryLite.add(lambdaClassOriginName);
    paramExtensionRegistryLite.add(propertySignature);
    paramExtensionRegistryLite.add(flags);
    paramExtensionRegistryLite.add(typeAnnotation);
    paramExtensionRegistryLite.add(isRaw);
    paramExtensionRegistryLite.add(typeParameterAnnotation);
    paramExtensionRegistryLite.add(classModuleName);
    paramExtensionRegistryLite.add(classLocalVariable);
    paramExtensionRegistryLite.add(anonymousObjectOriginName);
    paramExtensionRegistryLite.add(packageModuleName);
    paramExtensionRegistryLite.add(packageLocalVariable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf
 * JD-Core Version:    0.7.0.1
 */