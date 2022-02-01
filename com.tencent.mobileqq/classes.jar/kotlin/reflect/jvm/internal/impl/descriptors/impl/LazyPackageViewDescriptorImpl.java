package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyPackageViewDescriptorImpl
  extends DeclarationDescriptorImpl
  implements PackageViewDescriptor
{
  @NotNull
  private final FqName fqName;
  @NotNull
  private final NotNullLazyValue fragments$delegate;
  @NotNull
  private final MemberScope memberScope;
  @NotNull
  private final ModuleDescriptorImpl module;
  
  public LazyPackageViewDescriptorImpl(@NotNull ModuleDescriptorImpl paramModuleDescriptorImpl, @NotNull FqName paramFqName, @NotNull StorageManager paramStorageManager)
  {
    super(Annotations.Companion.getEMPTY(), paramFqName.shortNameOrSpecial());
    this.module = paramModuleDescriptorImpl;
    this.fqName = paramFqName;
    this.fragments$delegate = paramStorageManager.createLazyValue((Function0)new LazyPackageViewDescriptorImpl.fragments.2(this));
    this.memberScope = ((MemberScope)new LazyScopeAdapter(paramStorageManager.createLazyValue((Function0)new LazyPackageViewDescriptorImpl.memberScope.1(this))));
  }
  
  public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> paramDeclarationDescriptorVisitor, D paramD)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptorVisitor, "visitor");
    return paramDeclarationDescriptorVisitor.visitPackageViewDescriptor((PackageViewDescriptor)this, paramD);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    Object localObject = paramObject;
    if (!(paramObject instanceof PackageViewDescriptor)) {
      localObject = null;
    }
    paramObject = (PackageViewDescriptor)localObject;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if (Intrinsics.areEqual(getFqName(), paramObject.getFqName()))
      {
        bool1 = bool2;
        if (Intrinsics.areEqual(getModule(), paramObject.getModule())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @Nullable
  public PackageViewDescriptor getContainingDeclaration()
  {
    if (getFqName().isRoot()) {
      return null;
    }
    ModuleDescriptorImpl localModuleDescriptorImpl = getModule();
    FqName localFqName = getFqName().parent();
    Intrinsics.checkExpressionValueIsNotNull(localFqName, "fqName.parent()");
    return localModuleDescriptorImpl.getPackage(localFqName);
  }
  
  @NotNull
  public FqName getFqName()
  {
    return this.fqName;
  }
  
  @NotNull
  public List<PackageFragmentDescriptor> getFragments()
  {
    return (List)StorageKt.getValue(this.fragments$delegate, this, $$delegatedProperties[0]);
  }
  
  @NotNull
  public MemberScope getMemberScope()
  {
    return this.memberScope;
  }
  
  @NotNull
  public ModuleDescriptorImpl getModule()
  {
    return this.module;
  }
  
  public int hashCode()
  {
    return getModule().hashCode() * 31 + getFqName().hashCode();
  }
  
  public boolean isEmpty()
  {
    return PackageViewDescriptor.DefaultImpls.isEmpty(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */