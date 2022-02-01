package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Kind;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.SingleModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration.Default;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion;
import org.jetbrains.annotations.NotNull;

public final class RuntimeModuleData$Companion
{
  @NotNull
  public final RuntimeModuleData create(@NotNull ClassLoader paramClassLoader)
  {
    Intrinsics.checkParameterIsNotNull(paramClassLoader, "classLoader");
    StorageManager localStorageManager = (StorageManager)new LockBasedStorageManager("RuntimeModuleData");
    Object localObject1 = new JvmBuiltIns(localStorageManager, JvmBuiltIns.Kind.FROM_DEPENDENCIES);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("<runtime module for ");
    ((StringBuilder)localObject2).append(paramClassLoader);
    ((StringBuilder)localObject2).append('>');
    localObject2 = Name.special(((StringBuilder)localObject2).toString());
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "Name.special(\"<runtime module for $classLoader>\")");
    localObject2 = new ModuleDescriptorImpl((Name)localObject2, localStorageManager, (KotlinBuiltIns)localObject1, null, null, null, 56, null);
    ((JvmBuiltIns)localObject1).setBuiltInsModule((ModuleDescriptorImpl)localObject2);
    ModuleDescriptor localModuleDescriptor = (ModuleDescriptor)localObject2;
    ((JvmBuiltIns)localObject1).initialize(localModuleDescriptor, true);
    ReflectKotlinClassFinder localReflectKotlinClassFinder = new ReflectKotlinClassFinder(paramClassLoader);
    DeserializedDescriptorResolver localDeserializedDescriptorResolver = new DeserializedDescriptorResolver();
    Object localObject3 = new SingleModuleClassResolver();
    NotFoundClasses localNotFoundClasses = new NotFoundClasses(localStorageManager, localModuleDescriptor);
    Object localObject5 = (KotlinClassFinder)localReflectKotlinClassFinder;
    Object localObject4 = RuntimeModuleDataKt.makeLazyJavaPackageFragmentFromClassLoaderProvider$default(paramClassLoader, localModuleDescriptor, localStorageManager, localNotFoundClasses, (KotlinClassFinder)localObject5, localDeserializedDescriptorResolver, (ModuleClassResolver)localObject3, null, 128, null);
    paramClassLoader = RuntimeModuleDataKt.makeDeserializationComponentsForJava(localModuleDescriptor, localStorageManager, localNotFoundClasses, (LazyJavaPackageFragmentProvider)localObject4, (KotlinClassFinder)localObject5, localDeserializedDescriptorResolver);
    localDeserializedDescriptorResolver.setComponents(paramClassLoader);
    localObject5 = JavaResolverCache.EMPTY;
    Intrinsics.checkExpressionValueIsNotNull(localObject5, "JavaResolverCache.EMPTY");
    localObject4 = new JavaDescriptorResolver((LazyJavaPackageFragmentProvider)localObject4, (JavaResolverCache)localObject5);
    ((SingleModuleClassResolver)localObject3).setResolver((JavaDescriptorResolver)localObject4);
    localObject3 = Unit.class.getClassLoader();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "stdlibClassLoader");
    localObject1 = new JvmBuiltInsPackageFragmentProvider(localStorageManager, (KotlinClassFinder)new ReflectKotlinClassFinder((ClassLoader)localObject3), localModuleDescriptor, localNotFoundClasses, (AdditionalClassPartsProvider)((JvmBuiltIns)localObject1).getSettings(), (PlatformDependentDeclarationFilter)((JvmBuiltIns)localObject1).getSettings(), (DeserializationConfiguration)DeserializationConfiguration.Default.INSTANCE, (NewKotlinTypeChecker)NewKotlinTypeChecker.Companion.getDefault());
    ((ModuleDescriptorImpl)localObject2).setDependencies(new ModuleDescriptorImpl[] { localObject2 });
    ((ModuleDescriptorImpl)localObject2).initialize((PackageFragmentProvider)new CompositePackageFragmentProvider(CollectionsKt.listOf(new PackageFragmentProvider[] { (PackageFragmentProvider)((JavaDescriptorResolver)localObject4).getPackageFragmentProvider(), (PackageFragmentProvider)localObject1 })));
    return new RuntimeModuleData(paramClassLoader.getComponents(), new PackagePartScopeCache(localDeserializedDescriptorResolver, localReflectKotlinClassFinder), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData.Companion
 * JD-Core Version:    0.7.0.1
 */