package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializationComponents
{
  @NotNull
  private final AdditionalClassPartsProvider additionalClassPartsProvider;
  @NotNull
  private final AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader;
  @NotNull
  private final ClassDataFinder classDataFinder;
  @NotNull
  private final ClassDeserializer classDeserializer;
  @NotNull
  private final DeserializationConfiguration configuration;
  @NotNull
  private final ContractDeserializer contractDeserializer;
  @NotNull
  private final ErrorReporter errorReporter;
  @NotNull
  private final ExtensionRegistryLite extensionRegistryLite;
  @NotNull
  private final Iterable<ClassDescriptorFactory> fictitiousClassDescriptorFactories;
  @NotNull
  private final FlexibleTypeDeserializer flexibleTypeDeserializer;
  @NotNull
  private final NewKotlinTypeChecker kotlinTypeChecker;
  @NotNull
  private final LocalClassifierTypeSettings localClassifierTypeSettings;
  @NotNull
  private final LookupTracker lookupTracker;
  @NotNull
  private final ModuleDescriptor moduleDescriptor;
  @NotNull
  private final NotFoundClasses notFoundClasses;
  @NotNull
  private final PackageFragmentProvider packageFragmentProvider;
  @NotNull
  private final PlatformDependentDeclarationFilter platformDependentDeclarationFilter;
  @NotNull
  private final StorageManager storageManager;
  
  public DeserializationComponents(@NotNull StorageManager paramStorageManager, @NotNull ModuleDescriptor paramModuleDescriptor, @NotNull DeserializationConfiguration paramDeserializationConfiguration, @NotNull ClassDataFinder paramClassDataFinder, @NotNull AnnotationAndConstantLoader<? extends AnnotationDescriptor, ? extends ConstantValue<?>> paramAnnotationAndConstantLoader, @NotNull PackageFragmentProvider paramPackageFragmentProvider, @NotNull LocalClassifierTypeSettings paramLocalClassifierTypeSettings, @NotNull ErrorReporter paramErrorReporter, @NotNull LookupTracker paramLookupTracker, @NotNull FlexibleTypeDeserializer paramFlexibleTypeDeserializer, @NotNull Iterable<? extends ClassDescriptorFactory> paramIterable, @NotNull NotFoundClasses paramNotFoundClasses, @NotNull ContractDeserializer paramContractDeserializer, @NotNull AdditionalClassPartsProvider paramAdditionalClassPartsProvider, @NotNull PlatformDependentDeclarationFilter paramPlatformDependentDeclarationFilter, @NotNull ExtensionRegistryLite paramExtensionRegistryLite, @NotNull NewKotlinTypeChecker paramNewKotlinTypeChecker)
  {
    this.storageManager = paramStorageManager;
    this.moduleDescriptor = paramModuleDescriptor;
    this.configuration = paramDeserializationConfiguration;
    this.classDataFinder = paramClassDataFinder;
    this.annotationAndConstantLoader = paramAnnotationAndConstantLoader;
    this.packageFragmentProvider = paramPackageFragmentProvider;
    this.localClassifierTypeSettings = paramLocalClassifierTypeSettings;
    this.errorReporter = paramErrorReporter;
    this.lookupTracker = paramLookupTracker;
    this.flexibleTypeDeserializer = paramFlexibleTypeDeserializer;
    this.fictitiousClassDescriptorFactories = paramIterable;
    this.notFoundClasses = paramNotFoundClasses;
    this.contractDeserializer = paramContractDeserializer;
    this.additionalClassPartsProvider = paramAdditionalClassPartsProvider;
    this.platformDependentDeclarationFilter = paramPlatformDependentDeclarationFilter;
    this.extensionRegistryLite = paramExtensionRegistryLite;
    this.kotlinTypeChecker = paramNewKotlinTypeChecker;
    this.classDeserializer = new ClassDeserializer(this);
  }
  
  @NotNull
  public final DeserializationContext createContext(@NotNull PackageFragmentDescriptor paramPackageFragmentDescriptor, @NotNull NameResolver paramNameResolver, @NotNull TypeTable paramTypeTable, @NotNull VersionRequirementTable paramVersionRequirementTable, @NotNull BinaryVersion paramBinaryVersion, @Nullable DeserializedContainerSource paramDeserializedContainerSource)
  {
    Intrinsics.checkParameterIsNotNull(paramPackageFragmentDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramNameResolver, "nameResolver");
    Intrinsics.checkParameterIsNotNull(paramTypeTable, "typeTable");
    Intrinsics.checkParameterIsNotNull(paramVersionRequirementTable, "versionRequirementTable");
    Intrinsics.checkParameterIsNotNull(paramBinaryVersion, "metadataVersion");
    return new DeserializationContext(this, paramNameResolver, (DeclarationDescriptor)paramPackageFragmentDescriptor, paramTypeTable, paramVersionRequirementTable, paramBinaryVersion, paramDeserializedContainerSource, null, CollectionsKt.emptyList());
  }
  
  @Nullable
  public final ClassDescriptor deserializeClass(@NotNull ClassId paramClassId)
  {
    Intrinsics.checkParameterIsNotNull(paramClassId, "classId");
    return ClassDeserializer.deserializeClass$default(this.classDeserializer, paramClassId, null, 2, null);
  }
  
  @NotNull
  public final AdditionalClassPartsProvider getAdditionalClassPartsProvider()
  {
    return this.additionalClassPartsProvider;
  }
  
  @NotNull
  public final AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> getAnnotationAndConstantLoader()
  {
    return this.annotationAndConstantLoader;
  }
  
  @NotNull
  public final ClassDataFinder getClassDataFinder()
  {
    return this.classDataFinder;
  }
  
  @NotNull
  public final ClassDeserializer getClassDeserializer()
  {
    return this.classDeserializer;
  }
  
  @NotNull
  public final DeserializationConfiguration getConfiguration()
  {
    return this.configuration;
  }
  
  @NotNull
  public final ContractDeserializer getContractDeserializer()
  {
    return this.contractDeserializer;
  }
  
  @NotNull
  public final ErrorReporter getErrorReporter()
  {
    return this.errorReporter;
  }
  
  @NotNull
  public final ExtensionRegistryLite getExtensionRegistryLite()
  {
    return this.extensionRegistryLite;
  }
  
  @NotNull
  public final Iterable<ClassDescriptorFactory> getFictitiousClassDescriptorFactories()
  {
    return this.fictitiousClassDescriptorFactories;
  }
  
  @NotNull
  public final FlexibleTypeDeserializer getFlexibleTypeDeserializer()
  {
    return this.flexibleTypeDeserializer;
  }
  
  @NotNull
  public final NewKotlinTypeChecker getKotlinTypeChecker()
  {
    return this.kotlinTypeChecker;
  }
  
  @NotNull
  public final LocalClassifierTypeSettings getLocalClassifierTypeSettings()
  {
    return this.localClassifierTypeSettings;
  }
  
  @NotNull
  public final LookupTracker getLookupTracker()
  {
    return this.lookupTracker;
  }
  
  @NotNull
  public final ModuleDescriptor getModuleDescriptor()
  {
    return this.moduleDescriptor;
  }
  
  @NotNull
  public final NotFoundClasses getNotFoundClasses()
  {
    return this.notFoundClasses;
  }
  
  @NotNull
  public final PackageFragmentProvider getPackageFragmentProvider()
  {
    return this.packageFragmentProvider;
  }
  
  @NotNull
  public final PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter()
  {
    return this.platformDependentDeclarationFilter;
  }
  
  @NotNull
  public final StorageManager getStorageManager()
  {
    return this.storageManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents
 * JD-Core Version:    0.7.0.1
 */