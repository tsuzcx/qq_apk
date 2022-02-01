package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin._Assertions;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor.Capability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.TargetPlatform;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.checker.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ModuleDescriptorImpl
  extends DeclarationDescriptorImpl
  implements ModuleDescriptor
{
  @NotNull
  private final KotlinBuiltIns builtIns;
  private final Map<ModuleDescriptor.Capability<?>, Object> capabilities;
  private ModuleDependencies dependencies;
  private boolean isValid;
  private PackageFragmentProvider packageFragmentProviderForModuleContent;
  private final Lazy packageFragmentProviderForWholeModuleWithDependencies$delegate;
  private final MemoizedFunctionToNotNull<FqName, PackageViewDescriptor> packages;
  @Nullable
  private final TargetPlatform platform;
  @Nullable
  private final Name stableName;
  private final StorageManager storageManager;
  
  @JvmOverloads
  public ModuleDescriptorImpl(@NotNull Name paramName, @NotNull StorageManager paramStorageManager, @NotNull KotlinBuiltIns paramKotlinBuiltIns, @Nullable TargetPlatform paramTargetPlatform)
  {
    this(paramName, paramStorageManager, paramKotlinBuiltIns, paramTargetPlatform, null, null, 48, null);
  }
  
  @JvmOverloads
  public ModuleDescriptorImpl(@NotNull Name paramName1, @NotNull StorageManager paramStorageManager, @NotNull KotlinBuiltIns paramKotlinBuiltIns, @Nullable TargetPlatform paramTargetPlatform, @NotNull Map<ModuleDescriptor.Capability<?>, ? extends Object> paramMap, @Nullable Name paramName2)
  {
    super(Annotations.Companion.getEMPTY(), paramName1);
    this.storageManager = paramStorageManager;
    this.builtIns = paramKotlinBuiltIns;
    this.platform = paramTargetPlatform;
    this.stableName = paramName2;
    if (paramName1.isSpecial())
    {
      this.capabilities = MapsKt.toMutableMap(paramMap);
      this.capabilities.put(KotlinTypeRefinerKt.getREFINER_CAPABILITY(), new Ref(null));
      this.isValid = true;
      this.packages = this.storageManager.createMemoizedFunction((Function1)new ModuleDescriptorImpl.packages.1(this));
      this.packageFragmentProviderForWholeModuleWithDependencies$delegate = LazyKt.lazy((Function0)new ModuleDescriptorImpl.packageFragmentProviderForWholeModuleWithDependencies.2(this));
      return;
    }
    paramStorageManager = new StringBuilder();
    paramStorageManager.append("Module name must be special: ");
    paramStorageManager.append(paramName1);
    throw ((Throwable)new IllegalArgumentException(paramStorageManager.toString()));
  }
  
  private final String getId()
  {
    String str = getName().toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "name.toString()");
    return str;
  }
  
  private final CompositePackageFragmentProvider getPackageFragmentProviderForWholeModuleWithDependencies()
  {
    return (CompositePackageFragmentProvider)this.packageFragmentProviderForWholeModuleWithDependencies$delegate.getValue();
  }
  
  private final boolean isInitialized()
  {
    return this.packageFragmentProviderForModuleContent != null;
  }
  
  public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> paramDeclarationDescriptorVisitor, D paramD)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptorVisitor, "visitor");
    return ModuleDescriptor.DefaultImpls.accept(this, paramDeclarationDescriptorVisitor, paramD);
  }
  
  public void assertValid()
  {
    if (isValid()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Accessing invalid module descriptor ");
    localStringBuilder.append(this);
    throw ((Throwable)new InvalidModuleException(localStringBuilder.toString()));
  }
  
  @NotNull
  public KotlinBuiltIns getBuiltIns()
  {
    return this.builtIns;
  }
  
  @Nullable
  public <T> T getCapability(@NotNull ModuleDescriptor.Capability<T> paramCapability)
  {
    Intrinsics.checkParameterIsNotNull(paramCapability, "capability");
    Object localObject = this.capabilities.get(paramCapability);
    paramCapability = localObject;
    if (!(localObject instanceof Object)) {
      paramCapability = null;
    }
    return paramCapability;
  }
  
  @Nullable
  public DeclarationDescriptor getContainingDeclaration()
  {
    return ModuleDescriptor.DefaultImpls.getContainingDeclaration(this);
  }
  
  @NotNull
  public List<ModuleDescriptor> getExpectedByModules()
  {
    Object localObject = this.dependencies;
    if (localObject != null) {
      return ((ModuleDependencies)localObject).getExpectedByDependencies();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Dependencies of module ");
    ((StringBuilder)localObject).append(getId());
    ((StringBuilder)localObject).append(" were not set");
    throw ((Throwable)new AssertionError(((StringBuilder)localObject).toString()));
  }
  
  @NotNull
  public PackageViewDescriptor getPackage(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    assertValid();
    return (PackageViewDescriptor)this.packages.invoke(paramFqName);
  }
  
  @NotNull
  public final PackageFragmentProvider getPackageFragmentProvider()
  {
    assertValid();
    return (PackageFragmentProvider)getPackageFragmentProviderForWholeModuleWithDependencies();
  }
  
  @NotNull
  public Collection<FqName> getSubPackagesOf(@NotNull FqName paramFqName, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
    assertValid();
    return getPackageFragmentProvider().getSubPackagesOf(paramFqName, paramFunction1);
  }
  
  public final void initialize(@NotNull PackageFragmentProvider paramPackageFragmentProvider)
  {
    Intrinsics.checkParameterIsNotNull(paramPackageFragmentProvider, "providerForModuleContent");
    boolean bool = isInitialized();
    if ((_Assertions.ENABLED) && (!(bool ^ true)))
    {
      paramPackageFragmentProvider = new StringBuilder();
      paramPackageFragmentProvider.append("Attempt to initialize module ");
      paramPackageFragmentProvider.append(getId());
      paramPackageFragmentProvider.append(" twice");
      throw ((Throwable)new AssertionError(paramPackageFragmentProvider.toString()));
    }
    this.packageFragmentProviderForModuleContent = paramPackageFragmentProvider;
  }
  
  public boolean isValid()
  {
    return this.isValid;
  }
  
  public final void setDependencies(@NotNull List<ModuleDescriptorImpl> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "descriptors");
    setDependencies(paramList, SetsKt.emptySet());
  }
  
  public final void setDependencies(@NotNull List<ModuleDescriptorImpl> paramList, @NotNull Set<ModuleDescriptorImpl> paramSet)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "descriptors");
    Intrinsics.checkParameterIsNotNull(paramSet, "friends");
    setDependencies((ModuleDependencies)new ModuleDependenciesImpl(paramList, paramSet, CollectionsKt.emptyList()));
  }
  
  public final void setDependencies(@NotNull ModuleDependencies paramModuleDependencies)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDependencies, "dependencies");
    int i;
    if (this.dependencies == null) {
      i = 1;
    } else {
      i = 0;
    }
    if ((_Assertions.ENABLED) && (i == 0))
    {
      paramModuleDependencies = new StringBuilder();
      paramModuleDependencies.append("Dependencies of ");
      paramModuleDependencies.append(getId());
      paramModuleDependencies.append(" were already set");
      throw ((Throwable)new AssertionError(paramModuleDependencies.toString()));
    }
    this.dependencies = paramModuleDependencies;
  }
  
  public final void setDependencies(@NotNull ModuleDescriptorImpl... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "descriptors");
    setDependencies(ArraysKt.toList(paramVarArgs));
  }
  
  public boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor paramModuleDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "targetModule");
    if (Intrinsics.areEqual((ModuleDescriptorImpl)this, paramModuleDescriptor)) {
      return true;
    }
    ModuleDependencies localModuleDependencies = this.dependencies;
    if (localModuleDependencies == null) {
      Intrinsics.throwNpe();
    }
    if (CollectionsKt.contains((Iterable)localModuleDependencies.getModulesWhoseInternalsAreVisible(), paramModuleDescriptor)) {
      return true;
    }
    if (getExpectedByModules().contains(paramModuleDescriptor)) {
      return true;
    }
    return paramModuleDescriptor.getExpectedByModules().contains(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */