package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType;

public final class BuiltInsProtoBuf
{
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Annotation>> classAnnotation;
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> compileTimeValue = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), ProtoBuf.Annotation.Argument.Value.getDefaultInstance(), ProtoBuf.Annotation.Argument.Value.getDefaultInstance(), null, 151, WireFormat.FieldType.MESSAGE, ProtoBuf.Annotation.Argument.Value.class);
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> constructorAnnotation;
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> enumEntryAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.EnumEntry.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> functionAnnotation;
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> packageFqName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), Integer.valueOf(0), null, null, 151, WireFormat.FieldType.INT32, Integer.class);
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> parameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.ValueParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertyAnnotation;
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertyGetterAnnotation;
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertySetterAnnotation;
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> typeAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
  public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> typeParameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.TypeParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
  
  static
  {
    classAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    constructorAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Constructor.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    functionAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    propertyAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    propertyGetterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 152, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    propertySetterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 153, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite)
  {
    paramExtensionRegistryLite.add(packageFqName);
    paramExtensionRegistryLite.add(classAnnotation);
    paramExtensionRegistryLite.add(constructorAnnotation);
    paramExtensionRegistryLite.add(functionAnnotation);
    paramExtensionRegistryLite.add(propertyAnnotation);
    paramExtensionRegistryLite.add(propertyGetterAnnotation);
    paramExtensionRegistryLite.add(propertySetterAnnotation);
    paramExtensionRegistryLite.add(compileTimeValue);
    paramExtensionRegistryLite.add(enumEntryAnnotation);
    paramExtensionRegistryLite.add(parameterAnnotation);
    paramExtensionRegistryLite.add(typeAnnotation);
    paramExtensionRegistryLite.add(typeParameterAnnotation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf
 * JD-Core Version:    0.7.0.1
 */