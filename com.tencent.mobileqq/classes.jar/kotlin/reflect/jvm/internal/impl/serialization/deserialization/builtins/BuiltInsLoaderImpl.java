package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.DO_NOTHING;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer.Companion;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration.Default;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer.ThrowException;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings.Default;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class BuiltInsLoaderImpl
  implements BuiltInsLoader
{
  private final BuiltInsResourceLoader resourceLoader = new BuiltInsResourceLoader();
  
  @NotNull
  public final PackageFragmentProvider createBuiltInPackageFragmentProvider(@NotNull StorageManager paramStorageManager, @NotNull ModuleDescriptor paramModuleDescriptor, @NotNull Set<FqName> paramSet, @NotNull Iterable<? extends ClassDescriptorFactory> paramIterable, @NotNull PlatformDependentDeclarationFilter paramPlatformDependentDeclarationFilter, @NotNull AdditionalClassPartsProvider paramAdditionalClassPartsProvider, boolean paramBoolean, @NotNull Function1<? super String, ? extends InputStream> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramStorageManager, "storageManager");
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "module");
    Intrinsics.checkParameterIsNotNull(paramSet, "packageFqNames");
    Intrinsics.checkParameterIsNotNull(paramIterable, "classDescriptorFactories");
    Intrinsics.checkParameterIsNotNull(paramPlatformDependentDeclarationFilter, "platformDependentDeclarationFilter");
    Intrinsics.checkParameterIsNotNull(paramAdditionalClassPartsProvider, "additionalClassPartsProvider");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "loadResource");
    Object localObject1 = (Iterable)paramSet;
    paramSet = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    Object localObject2 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (FqName)((Iterator)localObject2).next();
      localObject1 = BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath((FqName)localObject3);
      localObject4 = (InputStream)paramFunction1.invoke(localObject1);
      if (localObject4 != null)
      {
        paramSet.add(BuiltInsPackageFragmentImpl.Companion.create((FqName)localObject3, paramStorageManager, paramModuleDescriptor, (InputStream)localObject4, paramBoolean));
      }
      else
      {
        paramStorageManager = new StringBuilder();
        paramStorageManager.append("Resource not found in classpath: ");
        paramStorageManager.append((String)localObject1);
        throw ((Throwable)new IllegalStateException(paramStorageManager.toString()));
      }
    }
    paramSet = (List)paramSet;
    paramFunction1 = new PackageFragmentProviderImpl((Collection)paramSet);
    localObject1 = new NotFoundClasses(paramStorageManager, paramModuleDescriptor);
    localObject2 = (DeserializationConfiguration)DeserializationConfiguration.Default.INSTANCE;
    paramFunction1 = (PackageFragmentProvider)paramFunction1;
    Object localObject3 = (ClassDataFinder)new DeserializedClassDataFinder(paramFunction1);
    Object localObject4 = (AnnotationAndConstantLoader)new AnnotationAndConstantLoaderImpl(paramModuleDescriptor, (NotFoundClasses)localObject1, (SerializerExtensionProtocol)BuiltInSerializerProtocol.INSTANCE);
    LocalClassifierTypeSettings localLocalClassifierTypeSettings = (LocalClassifierTypeSettings)LocalClassifierTypeSettings.Default.INSTANCE;
    ErrorReporter localErrorReporter = ErrorReporter.DO_NOTHING;
    Intrinsics.checkExpressionValueIsNotNull(localErrorReporter, "ErrorReporter.DO_NOTHING");
    paramStorageManager = new DeserializationComponents(paramStorageManager, paramModuleDescriptor, (DeserializationConfiguration)localObject2, (ClassDataFinder)localObject3, (AnnotationAndConstantLoader)localObject4, paramFunction1, localLocalClassifierTypeSettings, localErrorReporter, (LookupTracker)LookupTracker.DO_NOTHING.INSTANCE, (FlexibleTypeDeserializer)FlexibleTypeDeserializer.ThrowException.INSTANCE, paramIterable, (NotFoundClasses)localObject1, ContractDeserializer.Companion.getDEFAULT(), paramAdditionalClassPartsProvider, paramPlatformDependentDeclarationFilter, BuiltInSerializerProtocol.INSTANCE.getExtensionRegistry(), null, 65536, null);
    paramModuleDescriptor = paramSet.iterator();
    while (paramModuleDescriptor.hasNext()) {
      ((BuiltInsPackageFragmentImpl)paramModuleDescriptor.next()).initialize(paramStorageManager);
    }
    return paramFunction1;
  }
  
  @NotNull
  public PackageFragmentProvider createPackageFragmentProvider(@NotNull StorageManager paramStorageManager, @NotNull ModuleDescriptor paramModuleDescriptor, @NotNull Iterable<? extends ClassDescriptorFactory> paramIterable, @NotNull PlatformDependentDeclarationFilter paramPlatformDependentDeclarationFilter, @NotNull AdditionalClassPartsProvider paramAdditionalClassPartsProvider, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramStorageManager, "storageManager");
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "builtInsModule");
    Intrinsics.checkParameterIsNotNull(paramIterable, "classDescriptorFactories");
    Intrinsics.checkParameterIsNotNull(paramPlatformDependentDeclarationFilter, "platformDependentDeclarationFilter");
    Intrinsics.checkParameterIsNotNull(paramAdditionalClassPartsProvider, "additionalClassPartsProvider");
    Set localSet = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAMES;
    Intrinsics.checkExpressionValueIsNotNull(localSet, "KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAMES");
    return createBuiltInPackageFragmentProvider(paramStorageManager, paramModuleDescriptor, localSet, paramIterable, paramPlatformDependentDeclarationFilter, paramAdditionalClassPartsProvider, paramBoolean, (Function1)new BuiltInsLoaderImpl.createPackageFragmentProvider.1(this.resourceLoader));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsLoaderImpl
 * JD-Core Version:    0.7.0.1
 */