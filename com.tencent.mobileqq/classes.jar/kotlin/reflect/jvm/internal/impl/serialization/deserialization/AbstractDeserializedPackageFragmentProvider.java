package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractDeserializedPackageFragmentProvider
  implements PackageFragmentProvider
{
  @NotNull
  protected DeserializationComponents components;
  @NotNull
  private final KotlinMetadataFinder finder;
  private final MemoizedFunctionToNullable<FqName, PackageFragmentDescriptor> fragments;
  @NotNull
  private final ModuleDescriptor moduleDescriptor;
  @NotNull
  private final StorageManager storageManager;
  
  public AbstractDeserializedPackageFragmentProvider(@NotNull StorageManager paramStorageManager, @NotNull KotlinMetadataFinder paramKotlinMetadataFinder, @NotNull ModuleDescriptor paramModuleDescriptor)
  {
    this.storageManager = paramStorageManager;
    this.finder = paramKotlinMetadataFinder;
    this.moduleDescriptor = paramModuleDescriptor;
    this.fragments = this.storageManager.createMemoizedFunctionWithNullableValues((Function1)new AbstractDeserializedPackageFragmentProvider.fragments.1(this));
  }
  
  @Nullable
  protected abstract DeserializedPackageFragment findPackage(@NotNull FqName paramFqName);
  
  @NotNull
  protected final DeserializationComponents getComponents()
  {
    DeserializationComponents localDeserializationComponents = this.components;
    if (localDeserializationComponents == null) {
      Intrinsics.throwUninitializedPropertyAccessException("components");
    }
    return localDeserializationComponents;
  }
  
  @NotNull
  protected final KotlinMetadataFinder getFinder()
  {
    return this.finder;
  }
  
  @NotNull
  protected final ModuleDescriptor getModuleDescriptor()
  {
    return this.moduleDescriptor;
  }
  
  @NotNull
  public List<PackageFragmentDescriptor> getPackageFragments(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return CollectionsKt.listOfNotNull(this.fragments.invoke(paramFqName));
  }
  
  @NotNull
  protected final StorageManager getStorageManager()
  {
    return this.storageManager;
  }
  
  @NotNull
  public Collection<FqName> getSubPackagesOf(@NotNull FqName paramFqName, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
    return (Collection)SetsKt.emptySet();
  }
  
  protected final void setComponents(@NotNull DeserializationComponents paramDeserializationComponents)
  {
    Intrinsics.checkParameterIsNotNull(paramDeserializationComponents, "<set-?>");
    this.components = paramDeserializationComponents;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider
 * JD-Core Version:    0.7.0.1
 */