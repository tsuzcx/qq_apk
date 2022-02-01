package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.InputStream;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.DO_NOTHING;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer.Companion;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer.ThrowException;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings.Default;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl.Companion;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmBuiltInsPackageFragmentProvider
  extends AbstractDeserializedPackageFragmentProvider
{
  public JvmBuiltInsPackageFragmentProvider(@NotNull StorageManager paramStorageManager, @NotNull KotlinClassFinder paramKotlinClassFinder, @NotNull ModuleDescriptor paramModuleDescriptor, @NotNull NotFoundClasses paramNotFoundClasses, @NotNull AdditionalClassPartsProvider paramAdditionalClassPartsProvider, @NotNull PlatformDependentDeclarationFilter paramPlatformDependentDeclarationFilter, @NotNull DeserializationConfiguration paramDeserializationConfiguration, @NotNull NewKotlinTypeChecker paramNewKotlinTypeChecker)
  {
    super(paramStorageManager, (KotlinMetadataFinder)paramKotlinClassFinder, paramModuleDescriptor);
    paramKotlinClassFinder = (PackageFragmentProvider)this;
    ClassDataFinder localClassDataFinder = (ClassDataFinder)new DeserializedClassDataFinder(paramKotlinClassFinder);
    AnnotationAndConstantLoader localAnnotationAndConstantLoader = (AnnotationAndConstantLoader)new AnnotationAndConstantLoaderImpl(paramModuleDescriptor, paramNotFoundClasses, (SerializerExtensionProtocol)BuiltInSerializerProtocol.INSTANCE);
    LocalClassifierTypeSettings localLocalClassifierTypeSettings = (LocalClassifierTypeSettings)LocalClassifierTypeSettings.Default.INSTANCE;
    ErrorReporter localErrorReporter = ErrorReporter.DO_NOTHING;
    Intrinsics.checkExpressionValueIsNotNull(localErrorReporter, "ErrorReporter.DO_NOTHING");
    setComponents(new DeserializationComponents(paramStorageManager, paramModuleDescriptor, paramDeserializationConfiguration, localClassDataFinder, localAnnotationAndConstantLoader, paramKotlinClassFinder, localLocalClassifierTypeSettings, localErrorReporter, (LookupTracker)LookupTracker.DO_NOTHING.INSTANCE, (FlexibleTypeDeserializer)FlexibleTypeDeserializer.ThrowException.INSTANCE, (Iterable)CollectionsKt.listOf(new ClassDescriptorFactory[] { (ClassDescriptorFactory)new BuiltInFictitiousFunctionClassFactory(paramStorageManager, paramModuleDescriptor), (ClassDescriptorFactory)new JvmBuiltInClassDescriptorFactory(paramStorageManager, paramModuleDescriptor, null, 4, null) }), paramNotFoundClasses, ContractDeserializer.Companion.getDEFAULT(), paramAdditionalClassPartsProvider, paramPlatformDependentDeclarationFilter, BuiltInSerializerProtocol.INSTANCE.getExtensionRegistry(), paramNewKotlinTypeChecker));
  }
  
  @Nullable
  protected DeserializedPackageFragment findPackage(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    InputStream localInputStream = getFinder().findBuiltInsData(paramFqName);
    if (localInputStream != null) {
      paramFqName = BuiltInsPackageFragmentImpl.Companion.create(paramFqName, getStorageManager(), getModuleDescriptor(), localInputStream, false);
    } else {
      paramFqName = null;
    }
    return (DeserializedPackageFragment)paramFqName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsPackageFragmentProvider
 * JD-Core Version:    0.7.0.1
 */