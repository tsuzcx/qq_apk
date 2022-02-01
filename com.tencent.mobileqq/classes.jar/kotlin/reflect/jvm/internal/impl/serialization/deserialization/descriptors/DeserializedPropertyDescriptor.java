package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializedPropertyDescriptor
  extends PropertyDescriptorImpl
  implements DeserializedCallableMemberDescriptor
{
  @Nullable
  private final DeserializedContainerSource containerSource;
  @NotNull
  private DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesExperimentalCompatibilityMode;
  @NotNull
  private final NameResolver nameResolver;
  @NotNull
  private final ProtoBuf.Property proto;
  @NotNull
  private final TypeTable typeTable;
  @NotNull
  private final VersionRequirementTable versionRequirementTable;
  
  public DeserializedPropertyDescriptor(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @Nullable PropertyDescriptor paramPropertyDescriptor, @NotNull Annotations paramAnnotations, @NotNull Modality paramModality, @NotNull Visibility paramVisibility, boolean paramBoolean1, @NotNull Name paramName, @NotNull CallableMemberDescriptor.Kind paramKind, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, @NotNull ProtoBuf.Property paramProperty, @NotNull NameResolver paramNameResolver, @NotNull TypeTable paramTypeTable, @NotNull VersionRequirementTable paramVersionRequirementTable, @Nullable DeserializedContainerSource paramDeserializedContainerSource)
  {
    super(paramDeclarationDescriptor, paramPropertyDescriptor, paramAnnotations, paramModality, paramVisibility, paramBoolean1, paramName, paramKind, SourceElement.NO_SOURCE, paramBoolean2, paramBoolean3, paramBoolean6, false, paramBoolean4, paramBoolean5);
    this.proto = paramProperty;
    this.nameResolver = paramNameResolver;
    this.typeTable = paramTypeTable;
    this.versionRequirementTable = paramVersionRequirementTable;
    this.containerSource = paramDeserializedContainerSource;
    this.coroutinesExperimentalCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
  }
  
  @NotNull
  protected PropertyDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Modality paramModality, @NotNull Visibility paramVisibility, @Nullable PropertyDescriptor paramPropertyDescriptor, @NotNull CallableMemberDescriptor.Kind paramKind, @NotNull Name paramName, @NotNull SourceElement paramSourceElement)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "newOwner");
    Intrinsics.checkParameterIsNotNull(paramModality, "newModality");
    Intrinsics.checkParameterIsNotNull(paramVisibility, "newVisibility");
    Intrinsics.checkParameterIsNotNull(paramKind, "kind");
    Intrinsics.checkParameterIsNotNull(paramName, "newName");
    Intrinsics.checkParameterIsNotNull(paramSourceElement, "source");
    return (PropertyDescriptorImpl)new DeserializedPropertyDescriptor(paramDeclarationDescriptor, paramPropertyDescriptor, getAnnotations(), paramModality, paramVisibility, isVar(), paramName, paramKind, isLateInit(), isConst(), isExternal(), isDelegated(), isExpect(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
  }
  
  @Nullable
  public DeserializedContainerSource getContainerSource()
  {
    return this.containerSource;
  }
  
  @NotNull
  public NameResolver getNameResolver()
  {
    return this.nameResolver;
  }
  
  @NotNull
  public ProtoBuf.Property getProto()
  {
    return this.proto;
  }
  
  @NotNull
  public TypeTable getTypeTable()
  {
    return this.typeTable;
  }
  
  @NotNull
  public VersionRequirementTable getVersionRequirementTable()
  {
    return this.versionRequirementTable;
  }
  
  @NotNull
  public List<VersionRequirement> getVersionRequirements()
  {
    return DeserializedCallableMemberDescriptor.DefaultImpls.getVersionRequirements(this);
  }
  
  public final void initialize(@Nullable PropertyGetterDescriptorImpl paramPropertyGetterDescriptorImpl, @Nullable PropertySetterDescriptor paramPropertySetterDescriptor, @Nullable FieldDescriptor paramFieldDescriptor1, @Nullable FieldDescriptor paramFieldDescriptor2, @NotNull DeserializedMemberDescriptor.CoroutinesCompatibilityMode paramCoroutinesCompatibilityMode)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutinesCompatibilityMode, "isExperimentalCoroutineInReleaseEnvironment");
    super.initialize(paramPropertyGetterDescriptorImpl, paramPropertySetterDescriptor, paramFieldDescriptor1, paramFieldDescriptor2);
    paramPropertyGetterDescriptorImpl = Unit.INSTANCE;
    this.coroutinesExperimentalCompatibilityMode = paramCoroutinesCompatibilityMode;
  }
  
  public boolean isExternal()
  {
    Boolean localBoolean = Flags.IS_EXTERNAL_PROPERTY.get(getProto().getFlags());
    Intrinsics.checkExpressionValueIsNotNull(localBoolean, "Flags.IS_EXTERNAL_PROPERTY.get(proto.flags)");
    return localBoolean.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor
 * JD-Core Version:    0.7.0.1
 */