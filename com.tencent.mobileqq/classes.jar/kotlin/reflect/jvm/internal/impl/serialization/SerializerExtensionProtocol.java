package kotlin.reflect.jvm.internal.impl.serialization;

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
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;
import org.jetbrains.annotations.NotNull;

public class SerializerExtensionProtocol
{
  @NotNull
  private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Annotation>> classAnnotation;
  @NotNull
  private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> compileTimeValue;
  @NotNull
  private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> constructorAnnotation;
  @NotNull
  private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> enumEntryAnnotation;
  @NotNull
  private final ExtensionRegistryLite extensionRegistry;
  @NotNull
  private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> functionAnnotation;
  @NotNull
  private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> packageFqName;
  @NotNull
  private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> parameterAnnotation;
  @NotNull
  private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertyAnnotation;
  @NotNull
  private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertyGetterAnnotation;
  @NotNull
  private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertySetterAnnotation;
  @NotNull
  private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> typeAnnotation;
  @NotNull
  private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> typeParameterAnnotation;
  
  public SerializerExtensionProtocol(@NotNull ExtensionRegistryLite paramExtensionRegistryLite, @NotNull GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> paramGeneratedExtension, @NotNull GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> paramGeneratedExtension1, @NotNull GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Annotation>> paramGeneratedExtension2, @NotNull GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> paramGeneratedExtension3, @NotNull GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> paramGeneratedExtension4, @NotNull GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> paramGeneratedExtension5, @NotNull GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> paramGeneratedExtension6, @NotNull GeneratedMessageLite.GeneratedExtension<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> paramGeneratedExtension7, @NotNull GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> paramGeneratedExtension8, @NotNull GeneratedMessageLite.GeneratedExtension<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> paramGeneratedExtension9, @NotNull GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> paramGeneratedExtension10, @NotNull GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> paramGeneratedExtension11)
  {
    this.extensionRegistry = paramExtensionRegistryLite;
    this.packageFqName = paramGeneratedExtension;
    this.constructorAnnotation = paramGeneratedExtension1;
    this.classAnnotation = paramGeneratedExtension2;
    this.functionAnnotation = paramGeneratedExtension3;
    this.propertyAnnotation = paramGeneratedExtension4;
    this.propertyGetterAnnotation = paramGeneratedExtension5;
    this.propertySetterAnnotation = paramGeneratedExtension6;
    this.enumEntryAnnotation = paramGeneratedExtension7;
    this.compileTimeValue = paramGeneratedExtension8;
    this.parameterAnnotation = paramGeneratedExtension9;
    this.typeAnnotation = paramGeneratedExtension10;
    this.typeParameterAnnotation = paramGeneratedExtension11;
  }
  
  @NotNull
  public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Annotation>> getClassAnnotation()
  {
    return this.classAnnotation;
  }
  
  @NotNull
  public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> getCompileTimeValue()
  {
    return this.compileTimeValue;
  }
  
  @NotNull
  public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> getConstructorAnnotation()
  {
    return this.constructorAnnotation;
  }
  
  @NotNull
  public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> getEnumEntryAnnotation()
  {
    return this.enumEntryAnnotation;
  }
  
  @NotNull
  public final ExtensionRegistryLite getExtensionRegistry()
  {
    return this.extensionRegistry;
  }
  
  @NotNull
  public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> getFunctionAnnotation()
  {
    return this.functionAnnotation;
  }
  
  @NotNull
  public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> getParameterAnnotation()
  {
    return this.parameterAnnotation;
  }
  
  @NotNull
  public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> getPropertyAnnotation()
  {
    return this.propertyAnnotation;
  }
  
  @NotNull
  public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> getPropertyGetterAnnotation()
  {
    return this.propertyGetterAnnotation;
  }
  
  @NotNull
  public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> getPropertySetterAnnotation()
  {
    return this.propertySetterAnnotation;
  }
  
  @NotNull
  public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> getTypeAnnotation()
  {
    return this.typeAnnotation;
  }
  
  @NotNull
  public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> getTypeParameterAnnotation()
  {
    return this.typeParameterAnnotation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol
 * JD-Core Version:    0.7.0.1
 */