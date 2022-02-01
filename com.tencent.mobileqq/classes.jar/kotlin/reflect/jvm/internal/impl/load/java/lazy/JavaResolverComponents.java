package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;

public final class JavaResolverComponents
{
  @NotNull
  private final AnnotationTypeQualifierResolver annotationTypeQualifierResolver;
  @NotNull
  private final DeserializedDescriptorResolver deserializedDescriptorResolver;
  @NotNull
  private final ErrorReporter errorReporter;
  @NotNull
  private final JavaClassFinder finder;
  @NotNull
  private final JavaClassesTracker javaClassesTracker;
  @NotNull
  private final JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator;
  @NotNull
  private final JavaResolverCache javaResolverCache;
  @NotNull
  private final KotlinClassFinder kotlinClassFinder;
  @NotNull
  private final NewKotlinTypeChecker kotlinTypeChecker;
  @NotNull
  private final LookupTracker lookupTracker;
  @NotNull
  private final ModuleDescriptor module;
  @NotNull
  private final ModuleClassResolver moduleClassResolver;
  @NotNull
  private final PackagePartProvider packagePartProvider;
  @NotNull
  private final ReflectionTypes reflectionTypes;
  @NotNull
  private final SamConversionResolver samConversionResolver;
  @NotNull
  private final JavaResolverSettings settings;
  @NotNull
  private final SignatureEnhancement signatureEnhancement;
  @NotNull
  private final SignaturePropagator signaturePropagator;
  @NotNull
  private final JavaSourceElementFactory sourceElementFactory;
  @NotNull
  private final StorageManager storageManager;
  @NotNull
  private final SupertypeLoopChecker supertypeLoopChecker;
  
  public JavaResolverComponents(@NotNull StorageManager paramStorageManager, @NotNull JavaClassFinder paramJavaClassFinder, @NotNull KotlinClassFinder paramKotlinClassFinder, @NotNull DeserializedDescriptorResolver paramDeserializedDescriptorResolver, @NotNull SignaturePropagator paramSignaturePropagator, @NotNull ErrorReporter paramErrorReporter, @NotNull JavaResolverCache paramJavaResolverCache, @NotNull JavaPropertyInitializerEvaluator paramJavaPropertyInitializerEvaluator, @NotNull SamConversionResolver paramSamConversionResolver, @NotNull JavaSourceElementFactory paramJavaSourceElementFactory, @NotNull ModuleClassResolver paramModuleClassResolver, @NotNull PackagePartProvider paramPackagePartProvider, @NotNull SupertypeLoopChecker paramSupertypeLoopChecker, @NotNull LookupTracker paramLookupTracker, @NotNull ModuleDescriptor paramModuleDescriptor, @NotNull ReflectionTypes paramReflectionTypes, @NotNull AnnotationTypeQualifierResolver paramAnnotationTypeQualifierResolver, @NotNull SignatureEnhancement paramSignatureEnhancement, @NotNull JavaClassesTracker paramJavaClassesTracker, @NotNull JavaResolverSettings paramJavaResolverSettings, @NotNull NewKotlinTypeChecker paramNewKotlinTypeChecker)
  {
    this.storageManager = paramStorageManager;
    this.finder = paramJavaClassFinder;
    this.kotlinClassFinder = paramKotlinClassFinder;
    this.deserializedDescriptorResolver = paramDeserializedDescriptorResolver;
    this.signaturePropagator = paramSignaturePropagator;
    this.errorReporter = paramErrorReporter;
    this.javaResolverCache = paramJavaResolverCache;
    this.javaPropertyInitializerEvaluator = paramJavaPropertyInitializerEvaluator;
    this.samConversionResolver = paramSamConversionResolver;
    this.sourceElementFactory = paramJavaSourceElementFactory;
    this.moduleClassResolver = paramModuleClassResolver;
    this.packagePartProvider = paramPackagePartProvider;
    this.supertypeLoopChecker = paramSupertypeLoopChecker;
    this.lookupTracker = paramLookupTracker;
    this.module = paramModuleDescriptor;
    this.reflectionTypes = paramReflectionTypes;
    this.annotationTypeQualifierResolver = paramAnnotationTypeQualifierResolver;
    this.signatureEnhancement = paramSignatureEnhancement;
    this.javaClassesTracker = paramJavaClassesTracker;
    this.settings = paramJavaResolverSettings;
    this.kotlinTypeChecker = paramNewKotlinTypeChecker;
  }
  
  @NotNull
  public final AnnotationTypeQualifierResolver getAnnotationTypeQualifierResolver()
  {
    return this.annotationTypeQualifierResolver;
  }
  
  @NotNull
  public final DeserializedDescriptorResolver getDeserializedDescriptorResolver()
  {
    return this.deserializedDescriptorResolver;
  }
  
  @NotNull
  public final ErrorReporter getErrorReporter()
  {
    return this.errorReporter;
  }
  
  @NotNull
  public final JavaClassFinder getFinder()
  {
    return this.finder;
  }
  
  @NotNull
  public final JavaClassesTracker getJavaClassesTracker()
  {
    return this.javaClassesTracker;
  }
  
  @NotNull
  public final JavaPropertyInitializerEvaluator getJavaPropertyInitializerEvaluator()
  {
    return this.javaPropertyInitializerEvaluator;
  }
  
  @NotNull
  public final JavaResolverCache getJavaResolverCache()
  {
    return this.javaResolverCache;
  }
  
  @NotNull
  public final KotlinClassFinder getKotlinClassFinder()
  {
    return this.kotlinClassFinder;
  }
  
  @NotNull
  public final NewKotlinTypeChecker getKotlinTypeChecker()
  {
    return this.kotlinTypeChecker;
  }
  
  @NotNull
  public final LookupTracker getLookupTracker()
  {
    return this.lookupTracker;
  }
  
  @NotNull
  public final ModuleDescriptor getModule()
  {
    return this.module;
  }
  
  @NotNull
  public final ModuleClassResolver getModuleClassResolver()
  {
    return this.moduleClassResolver;
  }
  
  @NotNull
  public final PackagePartProvider getPackagePartProvider()
  {
    return this.packagePartProvider;
  }
  
  @NotNull
  public final ReflectionTypes getReflectionTypes()
  {
    return this.reflectionTypes;
  }
  
  @NotNull
  public final JavaResolverSettings getSettings()
  {
    return this.settings;
  }
  
  @NotNull
  public final SignatureEnhancement getSignatureEnhancement()
  {
    return this.signatureEnhancement;
  }
  
  @NotNull
  public final SignaturePropagator getSignaturePropagator()
  {
    return this.signaturePropagator;
  }
  
  @NotNull
  public final JavaSourceElementFactory getSourceElementFactory()
  {
    return this.sourceElementFactory;
  }
  
  @NotNull
  public final StorageManager getStorageManager()
  {
    return this.storageManager;
  }
  
  @NotNull
  public final SupertypeLoopChecker getSupertypeLoopChecker()
  {
    return this.supertypeLoopChecker;
  }
  
  @NotNull
  public final JavaResolverComponents replace(@NotNull JavaResolverCache paramJavaResolverCache)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaResolverCache, "javaResolverCache");
    return new JavaResolverComponents(this.storageManager, this.finder, this.kotlinClassFinder, this.deserializedDescriptorResolver, this.signaturePropagator, this.errorReporter, paramJavaResolverCache, this.javaPropertyInitializerEvaluator, this.samConversionResolver, this.sourceElementFactory, this.moduleClassResolver, this.packagePartProvider, this.supertypeLoopChecker, this.lookupTracker, this.module, this.reflectionTypes, this.annotationTypeQualifierResolver, this.signatureEnhancement, this.javaClassesTracker, this.settings, this.kotlinTypeChecker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents
 * JD-Core Version:    0.7.0.1
 */