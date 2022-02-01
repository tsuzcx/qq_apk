package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializedSimpleFunctionDescriptor
  extends SimpleFunctionDescriptorImpl
  implements DeserializedCallableMemberDescriptor
{
  @Nullable
  private final DeserializedContainerSource containerSource;
  @NotNull
  private DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesExperimentalCompatibilityMode;
  @NotNull
  private final NameResolver nameResolver;
  @NotNull
  private final ProtoBuf.Function proto;
  @NotNull
  private final TypeTable typeTable;
  @NotNull
  private final VersionRequirementTable versionRequirementTable;
  
  public DeserializedSimpleFunctionDescriptor(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @Nullable SimpleFunctionDescriptor paramSimpleFunctionDescriptor, @NotNull Annotations paramAnnotations, @NotNull Name paramName, @NotNull CallableMemberDescriptor.Kind paramKind, @NotNull ProtoBuf.Function paramFunction, @NotNull NameResolver paramNameResolver, @NotNull TypeTable paramTypeTable, @NotNull VersionRequirementTable paramVersionRequirementTable, @Nullable DeserializedContainerSource paramDeserializedContainerSource, @Nullable SourceElement paramSourceElement)
  {
    super(paramDeclarationDescriptor, paramSimpleFunctionDescriptor, paramAnnotations, paramName, paramKind, paramSourceElement);
    this.proto = paramFunction;
    this.nameResolver = paramNameResolver;
    this.typeTable = paramTypeTable;
    this.versionRequirementTable = paramVersionRequirementTable;
    this.containerSource = paramDeserializedContainerSource;
    this.coroutinesExperimentalCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
  }
  
  @NotNull
  protected FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @Nullable FunctionDescriptor paramFunctionDescriptor, @NotNull CallableMemberDescriptor.Kind paramKind, @Nullable Name paramName, @NotNull Annotations paramAnnotations, @NotNull SourceElement paramSourceElement)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "newOwner");
    Intrinsics.checkParameterIsNotNull(paramKind, "kind");
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "annotations");
    Intrinsics.checkParameterIsNotNull(paramSourceElement, "source");
    SimpleFunctionDescriptor localSimpleFunctionDescriptor = (SimpleFunctionDescriptor)paramFunctionDescriptor;
    if (paramName != null)
    {
      paramFunctionDescriptor = paramName;
    }
    else
    {
      paramFunctionDescriptor = getName();
      Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "name");
    }
    paramDeclarationDescriptor = new DeserializedSimpleFunctionDescriptor(paramDeclarationDescriptor, localSimpleFunctionDescriptor, paramAnnotations, paramFunctionDescriptor, paramKind, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), paramSourceElement);
    paramDeclarationDescriptor.coroutinesExperimentalCompatibilityMode = getCoroutinesExperimentalCompatibilityMode();
    return (FunctionDescriptorImpl)paramDeclarationDescriptor;
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
  public ProtoBuf.Function getProto()
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
  
  @NotNull
  public final SimpleFunctionDescriptorImpl initialize(@Nullable ReceiverParameterDescriptor paramReceiverParameterDescriptor1, @Nullable ReceiverParameterDescriptor paramReceiverParameterDescriptor2, @NotNull List<? extends TypeParameterDescriptor> paramList, @NotNull List<? extends ValueParameterDescriptor> paramList1, @Nullable KotlinType paramKotlinType, @Nullable Modality paramModality, @NotNull Visibility paramVisibility, @NotNull Map<? extends CallableDescriptor.UserDataKey<?>, ?> paramMap, @NotNull DeserializedMemberDescriptor.CoroutinesCompatibilityMode paramCoroutinesCompatibilityMode)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "typeParameters");
    Intrinsics.checkParameterIsNotNull(paramList1, "unsubstitutedValueParameters");
    Intrinsics.checkParameterIsNotNull(paramVisibility, "visibility");
    Intrinsics.checkParameterIsNotNull(paramMap, "userDataMap");
    Intrinsics.checkParameterIsNotNull(paramCoroutinesCompatibilityMode, "isExperimentalCoroutineInReleaseEnvironment");
    paramReceiverParameterDescriptor1 = super.initialize(paramReceiverParameterDescriptor1, paramReceiverParameterDescriptor2, paramList, paramList1, paramKotlinType, paramModality, paramVisibility, paramMap);
    this.coroutinesExperimentalCompatibilityMode = paramCoroutinesCompatibilityMode;
    Intrinsics.checkExpressionValueIsNotNull(paramReceiverParameterDescriptor1, "super.initialize(\n      …easeEnvironment\n        }");
    return paramReceiverParameterDescriptor1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor
 * JD-Core Version:    0.7.0.1
 */