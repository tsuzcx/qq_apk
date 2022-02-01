package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializedTypeAliasDescriptor
  extends AbstractTypeAliasDescriptor
  implements DeserializedMemberDescriptor
{
  @NotNull
  private Collection<? extends TypeAliasConstructorDescriptor> constructors;
  @Nullable
  private final DeserializedContainerSource containerSource;
  @NotNull
  private DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesExperimentalCompatibilityMode;
  private SimpleType defaultTypeImpl;
  @NotNull
  private SimpleType expandedType;
  @NotNull
  private final NameResolver nameResolver;
  @NotNull
  private final ProtoBuf.TypeAlias proto;
  @NotNull
  private final StorageManager storageManager;
  private List<? extends TypeParameterDescriptor> typeConstructorParameters;
  @NotNull
  private final TypeTable typeTable;
  @NotNull
  private SimpleType underlyingType;
  @NotNull
  private final VersionRequirementTable versionRequirementTable;
  
  public DeserializedTypeAliasDescriptor(@NotNull StorageManager paramStorageManager, @NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Annotations paramAnnotations, @NotNull Name paramName, @NotNull Visibility paramVisibility, @NotNull ProtoBuf.TypeAlias paramTypeAlias, @NotNull NameResolver paramNameResolver, @NotNull TypeTable paramTypeTable, @NotNull VersionRequirementTable paramVersionRequirementTable, @Nullable DeserializedContainerSource paramDeserializedContainerSource)
  {
    super(paramDeclarationDescriptor, paramAnnotations, paramName, localSourceElement, paramVisibility);
    this.storageManager = paramStorageManager;
    this.proto = paramTypeAlias;
    this.nameResolver = paramNameResolver;
    this.typeTable = paramTypeTable;
    this.versionRequirementTable = paramVersionRequirementTable;
    this.containerSource = paramDeserializedContainerSource;
    this.coroutinesExperimentalCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
  }
  
  @Nullable
  public ClassDescriptor getClassDescriptor()
  {
    if (KotlinTypeKt.isError((KotlinType)getExpandedType())) {
      return null;
    }
    ClassifierDescriptor localClassifierDescriptor2 = getExpandedType().getConstructor().getDeclarationDescriptor();
    ClassifierDescriptor localClassifierDescriptor1 = localClassifierDescriptor2;
    if (!(localClassifierDescriptor2 instanceof ClassDescriptor)) {
      localClassifierDescriptor1 = null;
    }
    return (ClassDescriptor)localClassifierDescriptor1;
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
  public SimpleType getDefaultType()
  {
    SimpleType localSimpleType = this.defaultTypeImpl;
    if (localSimpleType == null) {
      Intrinsics.throwUninitializedPropertyAccessException("defaultTypeImpl");
    }
    return localSimpleType;
  }
  
  @NotNull
  public SimpleType getExpandedType()
  {
    SimpleType localSimpleType = this.expandedType;
    if (localSimpleType == null) {
      Intrinsics.throwUninitializedPropertyAccessException("expandedType");
    }
    return localSimpleType;
  }
  
  @NotNull
  public NameResolver getNameResolver()
  {
    return this.nameResolver;
  }
  
  @NotNull
  public ProtoBuf.TypeAlias getProto()
  {
    return this.proto;
  }
  
  @NotNull
  protected StorageManager getStorageManager()
  {
    return this.storageManager;
  }
  
  @NotNull
  protected List<TypeParameterDescriptor> getTypeConstructorTypeParameters()
  {
    List localList = this.typeConstructorParameters;
    if (localList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("typeConstructorParameters");
    }
    return localList;
  }
  
  @NotNull
  public TypeTable getTypeTable()
  {
    return this.typeTable;
  }
  
  @NotNull
  public SimpleType getUnderlyingType()
  {
    SimpleType localSimpleType = this.underlyingType;
    if (localSimpleType == null) {
      Intrinsics.throwUninitializedPropertyAccessException("underlyingType");
    }
    return localSimpleType;
  }
  
  @NotNull
  public VersionRequirementTable getVersionRequirementTable()
  {
    return this.versionRequirementTable;
  }
  
  @NotNull
  public List<VersionRequirement> getVersionRequirements()
  {
    return DeserializedMemberDescriptor.DefaultImpls.getVersionRequirements(this);
  }
  
  public final void initialize(@NotNull List<? extends TypeParameterDescriptor> paramList, @NotNull SimpleType paramSimpleType1, @NotNull SimpleType paramSimpleType2, @NotNull DeserializedMemberDescriptor.CoroutinesCompatibilityMode paramCoroutinesCompatibilityMode)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "declaredTypeParameters");
    Intrinsics.checkParameterIsNotNull(paramSimpleType1, "underlyingType");
    Intrinsics.checkParameterIsNotNull(paramSimpleType2, "expandedType");
    Intrinsics.checkParameterIsNotNull(paramCoroutinesCompatibilityMode, "isExperimentalCoroutineInReleaseEnvironment");
    initialize(paramList);
    this.underlyingType = paramSimpleType1;
    this.expandedType = paramSimpleType2;
    this.typeConstructorParameters = TypeParameterUtilsKt.computeConstructorTypeParameters(this);
    this.defaultTypeImpl = computeDefaultType();
    this.constructors = getTypeAliasConstructors();
    this.coroutinesExperimentalCompatibilityMode = paramCoroutinesCompatibilityMode;
  }
  
  @NotNull
  public TypeAliasDescriptor substitute(@NotNull TypeSubstitutor paramTypeSubstitutor)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeSubstitutor, "substitutor");
    if (paramTypeSubstitutor.isEmpty()) {
      return (TypeAliasDescriptor)this;
    }
    Object localObject1 = getStorageManager();
    Object localObject2 = getContainingDeclaration();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "containingDeclaration");
    Object localObject3 = getAnnotations();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "annotations");
    Name localName = getName();
    Intrinsics.checkExpressionValueIsNotNull(localName, "name");
    localObject1 = new DeserializedTypeAliasDescriptor((StorageManager)localObject1, (DeclarationDescriptor)localObject2, (Annotations)localObject3, localName, getVisibility(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
    localObject2 = getDeclaredTypeParameters();
    localObject3 = paramTypeSubstitutor.safeSubstitute((KotlinType)getUnderlyingType(), Variance.INVARIANT);
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
    localObject3 = TypeSubstitutionKt.asSimpleType((KotlinType)localObject3);
    paramTypeSubstitutor = paramTypeSubstitutor.safeSubstitute((KotlinType)getExpandedType(), Variance.INVARIANT);
    Intrinsics.checkExpressionValueIsNotNull(paramTypeSubstitutor, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
    ((DeserializedTypeAliasDescriptor)localObject1).initialize((List)localObject2, (SimpleType)localObject3, TypeSubstitutionKt.asSimpleType(paramTypeSubstitutor), getCoroutinesExperimentalCompatibilityMode());
    return (TypeAliasDescriptor)localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor
 * JD-Core Version:    0.7.0.1
 */