package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializedClassConstructorDescriptor
  extends ClassConstructorDescriptorImpl
  implements DeserializedCallableMemberDescriptor
{
  @Nullable
  private final DeserializedContainerSource containerSource;
  @NotNull
  private DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesExperimentalCompatibilityMode;
  @NotNull
  private final NameResolver nameResolver;
  @NotNull
  private final ProtoBuf.Constructor proto;
  @NotNull
  private final TypeTable typeTable;
  @NotNull
  private final VersionRequirementTable versionRequirementTable;
  
  public DeserializedClassConstructorDescriptor(@NotNull ClassDescriptor paramClassDescriptor, @Nullable ConstructorDescriptor paramConstructorDescriptor, @NotNull Annotations paramAnnotations, boolean paramBoolean, @NotNull CallableMemberDescriptor.Kind paramKind, @NotNull ProtoBuf.Constructor paramConstructor, @NotNull NameResolver paramNameResolver, @NotNull TypeTable paramTypeTable, @NotNull VersionRequirementTable paramVersionRequirementTable, @Nullable DeserializedContainerSource paramDeserializedContainerSource, @Nullable SourceElement paramSourceElement)
  {
    super(paramClassDescriptor, paramConstructorDescriptor, paramAnnotations, paramBoolean, paramKind, paramSourceElement);
    this.proto = paramConstructor;
    this.nameResolver = paramNameResolver;
    this.typeTable = paramTypeTable;
    this.versionRequirementTable = paramVersionRequirementTable;
    this.containerSource = paramDeserializedContainerSource;
    this.coroutinesExperimentalCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
  }
  
  @NotNull
  protected DeserializedClassConstructorDescriptor createSubstitutedCopy(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @Nullable FunctionDescriptor paramFunctionDescriptor, @NotNull CallableMemberDescriptor.Kind paramKind, @Nullable Name paramName, @NotNull Annotations paramAnnotations, @NotNull SourceElement paramSourceElement)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "newOwner");
    Intrinsics.checkParameterIsNotNull(paramKind, "kind");
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "annotations");
    Intrinsics.checkParameterIsNotNull(paramSourceElement, "source");
    paramDeclarationDescriptor = new DeserializedClassConstructorDescriptor((ClassDescriptor)paramDeclarationDescriptor, (ConstructorDescriptor)paramFunctionDescriptor, paramAnnotations, this.isPrimary, paramKind, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), paramSourceElement);
    paramDeclarationDescriptor.setCoroutinesExperimentalCompatibilityMode$deserialization(getCoroutinesExperimentalCompatibilityMode());
    return paramDeclarationDescriptor;
  }
  
  @Nullable
  public DeserializedContainerSource getContainerSource()
  {
    return this.containerSource;
  }
  
  @NotNull
  public DeserializedMemberDescriptor.CoroutinesCompatibilityMode getCoroutinesExperimentalCompatibilityMode()
  {
    return this.coroutinesExperimentalCompatibilityMode;
  }
  
  @NotNull
  public NameResolver getNameResolver()
  {
    return this.nameResolver;
  }
  
  @NotNull
  public ProtoBuf.Constructor getProto()
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
  
  public boolean isExternal()
  {
    return false;
  }
  
  public boolean isInline()
  {
    return false;
  }
  
  public boolean isSuspend()
  {
    return false;
  }
  
  public boolean isTailrec()
  {
    return false;
  }
  
  public void setCoroutinesExperimentalCompatibilityMode$deserialization(@NotNull DeserializedMemberDescriptor.CoroutinesCompatibilityMode paramCoroutinesCompatibilityMode)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutinesCompatibilityMode, "<set-?>");
    this.coroutinesExperimentalCompatibilityMode = paramCoroutinesCompatibilityMode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor
 * JD-Core Version:    0.7.0.1
 */