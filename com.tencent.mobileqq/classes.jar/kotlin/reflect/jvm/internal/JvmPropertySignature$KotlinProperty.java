package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.NameUtils;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "string", "", "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "asString", "getManglingSuffix", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class JvmPropertySignature$KotlinProperty
  extends JvmPropertySignature
{
  @NotNull
  private final PropertyDescriptor descriptor;
  @NotNull
  private final NameResolver nameResolver;
  @NotNull
  private final ProtoBuf.Property proto;
  @NotNull
  private final JvmProtoBuf.JvmPropertySignature signature;
  private final String string;
  @NotNull
  private final TypeTable typeTable;
  
  public JvmPropertySignature$KotlinProperty(@NotNull PropertyDescriptor paramPropertyDescriptor, @NotNull ProtoBuf.Property paramProperty, @NotNull JvmProtoBuf.JvmPropertySignature paramJvmPropertySignature, @NotNull NameResolver paramNameResolver, @NotNull TypeTable paramTypeTable)
  {
    super(null);
    this.descriptor = paramPropertyDescriptor;
    this.proto = paramProperty;
    this.signature = paramJvmPropertySignature;
    this.nameResolver = paramNameResolver;
    this.typeTable = paramTypeTable;
    if (this.signature.hasGetter())
    {
      paramPropertyDescriptor = new StringBuilder();
      paramProperty = this.nameResolver;
      paramJvmPropertySignature = this.signature.getGetter();
      Intrinsics.checkExpressionValueIsNotNull(paramJvmPropertySignature, "signature.getter");
      paramPropertyDescriptor.append(paramProperty.getString(paramJvmPropertySignature.getName()));
      paramProperty = this.nameResolver;
      paramJvmPropertySignature = this.signature.getGetter();
      Intrinsics.checkExpressionValueIsNotNull(paramJvmPropertySignature, "signature.getter");
      paramPropertyDescriptor.append(paramProperty.getString(paramJvmPropertySignature.getDesc()));
      paramPropertyDescriptor = paramPropertyDescriptor.toString();
    }
    else
    {
      paramProperty = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, this.proto, this.nameResolver, this.typeTable, false, 8, null);
      if (paramProperty == null) {
        break label245;
      }
      paramPropertyDescriptor = paramProperty.component1();
      paramProperty = paramProperty.component2();
      paramJvmPropertySignature = new StringBuilder();
      paramJvmPropertySignature.append(JvmAbi.getterName(paramPropertyDescriptor));
      paramJvmPropertySignature.append(getManglingSuffix());
      paramJvmPropertySignature.append("()");
      paramJvmPropertySignature.append(paramProperty);
      paramPropertyDescriptor = paramJvmPropertySignature.toString();
    }
    this.string = paramPropertyDescriptor;
    return;
    label245:
    paramPropertyDescriptor = new StringBuilder();
    paramPropertyDescriptor.append("No field signature for property: ");
    paramPropertyDescriptor.append(this.descriptor);
    throw ((Throwable)new KotlinReflectionInternalError(paramPropertyDescriptor.toString()));
  }
  
  private final String getManglingSuffix()
  {
    Object localObject1 = this.descriptor.getContainingDeclaration();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "descriptor.containingDeclaration");
    Object localObject2;
    if ((Intrinsics.areEqual(this.descriptor.getVisibility(), Visibilities.INTERNAL)) && ((localObject1 instanceof DeserializedClassDescriptor)))
    {
      localObject1 = (GeneratedMessageLite.ExtendableMessage)((DeserializedClassDescriptor)localObject1).getClassProto();
      localObject2 = JvmProtoBuf.classModuleName;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "JvmProtoBuf.classModuleName");
      localObject1 = (Integer)ProtoBufUtilKt.getExtensionOrNull((GeneratedMessageLite.ExtendableMessage)localObject1, (GeneratedMessageLite.GeneratedExtension)localObject2);
      if (localObject1 != null)
      {
        localObject1 = this.nameResolver.getString(((Number)localObject1).intValue());
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = "main";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("$");
      ((StringBuilder)localObject2).append(NameUtils.sanitizeAsJavaIdentifier((String)localObject1));
      return ((StringBuilder)localObject2).toString();
    }
    if ((Intrinsics.areEqual(this.descriptor.getVisibility(), Visibilities.PRIVATE)) && ((localObject1 instanceof PackageFragmentDescriptor)))
    {
      localObject1 = this.descriptor;
      if (localObject1 != null)
      {
        localObject1 = ((DeserializedPropertyDescriptor)localObject1).getContainerSource();
        if ((localObject1 instanceof JvmPackagePartSource))
        {
          localObject1 = (JvmPackagePartSource)localObject1;
          if (((JvmPackagePartSource)localObject1).getFacadeClassName() != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("$");
            ((StringBuilder)localObject2).append(((JvmPackagePartSource)localObject1).getSimpleName().asString());
            return ((StringBuilder)localObject2).toString();
          }
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
      }
    }
    return "";
  }
  
  @NotNull
  public String asString()
  {
    return this.string;
  }
  
  @NotNull
  public final PropertyDescriptor getDescriptor()
  {
    return this.descriptor;
  }
  
  @NotNull
  public final NameResolver getNameResolver()
  {
    return this.nameResolver;
  }
  
  @NotNull
  public final ProtoBuf.Property getProto()
  {
    return this.proto;
  }
  
  @NotNull
  public final JvmProtoBuf.JvmPropertySignature getSignature()
  {
    return this.signature;
  }
  
  @NotNull
  public final TypeTable getTypeTable()
  {
    return this.typeTable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.JvmPropertySignature.KotlinProperty
 * JD-Core Version:    0.7.0.1
 */