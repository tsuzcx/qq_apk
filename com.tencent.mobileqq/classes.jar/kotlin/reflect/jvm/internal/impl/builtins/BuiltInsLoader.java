package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public abstract interface BuiltInsLoader
{
  public static final BuiltInsLoader.Companion Companion = BuiltInsLoader.Companion.$$INSTANCE;
  
  @NotNull
  public abstract PackageFragmentProvider createPackageFragmentProvider(@NotNull StorageManager paramStorageManager, @NotNull ModuleDescriptor paramModuleDescriptor, @NotNull Iterable<? extends ClassDescriptorFactory> paramIterable, @NotNull PlatformDependentDeclarationFilter paramPlatformDependentDeclarationFilter, @NotNull AdditionalClassPartsProvider paramAdditionalClassPartsProvider, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader
 * JD-Core Version:    0.7.0.1
 */