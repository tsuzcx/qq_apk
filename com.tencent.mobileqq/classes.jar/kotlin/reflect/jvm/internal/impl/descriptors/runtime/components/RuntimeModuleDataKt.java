package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.DO_NOTHING;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker.Default;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator.DoNothing;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.load.java.components.SamConversionResolver.Empty;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings.Default;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JavaClassDataFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer.Companion;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration.Default;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion;
import kotlin.reflect.jvm.internal.impl.utils.Jsr305State;
import org.jetbrains.annotations.NotNull;

public final class RuntimeModuleDataKt
{
  @NotNull
  public static final DeserializationComponentsForJava makeDeserializationComponentsForJava(@NotNull ModuleDescriptor paramModuleDescriptor, @NotNull StorageManager paramStorageManager, @NotNull NotFoundClasses paramNotFoundClasses, @NotNull LazyJavaPackageFragmentProvider paramLazyJavaPackageFragmentProvider, @NotNull KotlinClassFinder paramKotlinClassFinder, @NotNull DeserializedDescriptorResolver paramDeserializedDescriptorResolver)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "module");
    Intrinsics.checkParameterIsNotNull(paramStorageManager, "storageManager");
    Intrinsics.checkParameterIsNotNull(paramNotFoundClasses, "notFoundClasses");
    Intrinsics.checkParameterIsNotNull(paramLazyJavaPackageFragmentProvider, "lazyJavaPackageFragmentProvider");
    Intrinsics.checkParameterIsNotNull(paramKotlinClassFinder, "reflectKotlinClassFinder");
    Intrinsics.checkParameterIsNotNull(paramDeserializedDescriptorResolver, "deserializedDescriptorResolver");
    paramDeserializedDescriptorResolver = new JavaClassDataFinder(paramKotlinClassFinder, paramDeserializedDescriptorResolver);
    paramKotlinClassFinder = new BinaryClassAnnotationAndConstantLoaderImpl(paramModuleDescriptor, paramNotFoundClasses, paramStorageManager, paramKotlinClassFinder);
    return new DeserializationComponentsForJava(paramStorageManager, paramModuleDescriptor, (DeserializationConfiguration)DeserializationConfiguration.Default.INSTANCE, paramDeserializedDescriptorResolver, paramKotlinClassFinder, paramLazyJavaPackageFragmentProvider, paramNotFoundClasses, (ErrorReporter)RuntimeErrorReporter.INSTANCE, (LookupTracker)LookupTracker.DO_NOTHING.INSTANCE, ContractDeserializer.Companion.getDEFAULT(), (NewKotlinTypeChecker)NewKotlinTypeChecker.Companion.getDefault());
  }
  
  @NotNull
  public static final LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentFromClassLoaderProvider(@NotNull ClassLoader paramClassLoader, @NotNull ModuleDescriptor paramModuleDescriptor, @NotNull StorageManager paramStorageManager, @NotNull NotFoundClasses paramNotFoundClasses, @NotNull KotlinClassFinder paramKotlinClassFinder, @NotNull DeserializedDescriptorResolver paramDeserializedDescriptorResolver, @NotNull ModuleClassResolver paramModuleClassResolver, @NotNull PackagePartProvider paramPackagePartProvider)
  {
    Intrinsics.checkParameterIsNotNull(paramClassLoader, "classLoader");
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "module");
    Intrinsics.checkParameterIsNotNull(paramStorageManager, "storageManager");
    Intrinsics.checkParameterIsNotNull(paramNotFoundClasses, "notFoundClasses");
    Intrinsics.checkParameterIsNotNull(paramKotlinClassFinder, "reflectKotlinClassFinder");
    Intrinsics.checkParameterIsNotNull(paramDeserializedDescriptorResolver, "deserializedDescriptorResolver");
    Intrinsics.checkParameterIsNotNull(paramModuleClassResolver, "singleModuleClassResolver");
    Intrinsics.checkParameterIsNotNull(paramPackagePartProvider, "packagePartProvider");
    AnnotationTypeQualifierResolver localAnnotationTypeQualifierResolver = new AnnotationTypeQualifierResolver(paramStorageManager, Jsr305State.DISABLED);
    paramClassLoader = (JavaClassFinder)new ReflectJavaClassFinder(paramClassLoader);
    SignaturePropagator localSignaturePropagator = SignaturePropagator.DO_NOTHING;
    Intrinsics.checkExpressionValueIsNotNull(localSignaturePropagator, "SignaturePropagator.DO_NOTHING");
    ErrorReporter localErrorReporter = (ErrorReporter)RuntimeErrorReporter.INSTANCE;
    JavaResolverCache localJavaResolverCache = JavaResolverCache.EMPTY;
    Intrinsics.checkExpressionValueIsNotNull(localJavaResolverCache, "JavaResolverCache.EMPTY");
    return new LazyJavaPackageFragmentProvider(new JavaResolverComponents(paramStorageManager, paramClassLoader, paramKotlinClassFinder, paramDeserializedDescriptorResolver, localSignaturePropagator, localErrorReporter, localJavaResolverCache, (JavaPropertyInitializerEvaluator)JavaPropertyInitializerEvaluator.DoNothing.INSTANCE, (SamConversionResolver)SamConversionResolver.Empty.INSTANCE, (JavaSourceElementFactory)RuntimeSourceElementFactory.INSTANCE, paramModuleClassResolver, paramPackagePartProvider, (SupertypeLoopChecker)SupertypeLoopChecker.EMPTY.INSTANCE, (LookupTracker)LookupTracker.DO_NOTHING.INSTANCE, paramModuleDescriptor, new ReflectionTypes(paramModuleDescriptor, paramNotFoundClasses), localAnnotationTypeQualifierResolver, new SignatureEnhancement(localAnnotationTypeQualifierResolver, Jsr305State.DISABLED), (JavaClassesTracker)JavaClassesTracker.Default.INSTANCE, (JavaResolverSettings)JavaResolverSettings.Default.INSTANCE, (NewKotlinTypeChecker)NewKotlinTypeChecker.Companion.getDefault()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleDataKt
 * JD-Core Version:    0.7.0.1
 */