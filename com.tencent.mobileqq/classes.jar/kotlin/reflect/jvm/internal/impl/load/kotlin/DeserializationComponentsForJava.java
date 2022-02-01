package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider.None;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter.NoPlatformDependent;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings.Default;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;

public final class DeserializationComponentsForJava
{
  @NotNull
  private final DeserializationComponents components;
  
  public DeserializationComponentsForJava(@NotNull StorageManager paramStorageManager, @NotNull ModuleDescriptor paramModuleDescriptor, @NotNull DeserializationConfiguration paramDeserializationConfiguration, @NotNull JavaClassDataFinder paramJavaClassDataFinder, @NotNull BinaryClassAnnotationAndConstantLoaderImpl paramBinaryClassAnnotationAndConstantLoaderImpl, @NotNull LazyJavaPackageFragmentProvider paramLazyJavaPackageFragmentProvider, @NotNull NotFoundClasses paramNotFoundClasses, @NotNull ErrorReporter paramErrorReporter, @NotNull LookupTracker paramLookupTracker, @NotNull ContractDeserializer paramContractDeserializer, @NotNull NewKotlinTypeChecker paramNewKotlinTypeChecker)
  {
    Object localObject2 = paramModuleDescriptor.getBuiltIns();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof JvmBuiltIns)) {
      localObject1 = null;
    }
    localObject2 = (JvmBuiltIns)localObject1;
    localObject1 = (ClassDataFinder)paramJavaClassDataFinder;
    paramBinaryClassAnnotationAndConstantLoaderImpl = (AnnotationAndConstantLoader)paramBinaryClassAnnotationAndConstantLoaderImpl;
    paramLazyJavaPackageFragmentProvider = (PackageFragmentProvider)paramLazyJavaPackageFragmentProvider;
    LocalClassifierTypeSettings localLocalClassifierTypeSettings = (LocalClassifierTypeSettings)LocalClassifierTypeSettings.Default.INSTANCE;
    FlexibleTypeDeserializer localFlexibleTypeDeserializer = (FlexibleTypeDeserializer)JavaFlexibleTypeDeserializer.INSTANCE;
    Iterable localIterable = (Iterable)CollectionsKt.emptyList();
    if (localObject2 != null)
    {
      paramJavaClassDataFinder = ((JvmBuiltIns)localObject2).getSettings();
      if (paramJavaClassDataFinder != null) {}
    }
    else
    {
      paramJavaClassDataFinder = AdditionalClassPartsProvider.None.INSTANCE;
    }
    AdditionalClassPartsProvider localAdditionalClassPartsProvider = (AdditionalClassPartsProvider)paramJavaClassDataFinder;
    if (localObject2 != null)
    {
      paramJavaClassDataFinder = ((JvmBuiltIns)localObject2).getSettings();
      if (paramJavaClassDataFinder != null) {}
    }
    else
    {
      paramJavaClassDataFinder = PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE;
    }
    this.components = new DeserializationComponents(paramStorageManager, paramModuleDescriptor, paramDeserializationConfiguration, (ClassDataFinder)localObject1, paramBinaryClassAnnotationAndConstantLoaderImpl, paramLazyJavaPackageFragmentProvider, localLocalClassifierTypeSettings, paramErrorReporter, paramLookupTracker, localFlexibleTypeDeserializer, localIterable, paramNotFoundClasses, paramContractDeserializer, localAdditionalClassPartsProvider, (PlatformDependentDeclarationFilter)paramJavaClassDataFinder, JvmProtoBufUtil.INSTANCE.getEXTENSION_REGISTRY(), paramNewKotlinTypeChecker);
  }
  
  @NotNull
  public final DeserializationComponents getComponents()
  {
    return this.components;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava
 * JD-Core Version:    0.7.0.1
 */