package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor.Capability;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class ErrorUtils$1
  implements ModuleDescriptor
{
  public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> paramDeclarationDescriptorVisitor, D paramD)
  {
    if (paramDeclarationDescriptorVisitor == null) {
      $$$reportNull$$$0(10);
    }
    return null;
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    Annotations localAnnotations = Annotations.Companion.getEMPTY();
    if (localAnnotations == null) {
      $$$reportNull$$$0(1);
    }
    return localAnnotations;
  }
  
  @NotNull
  public KotlinBuiltIns getBuiltIns()
  {
    DefaultBuiltIns localDefaultBuiltIns = DefaultBuiltIns.getInstance();
    if (localDefaultBuiltIns == null) {
      $$$reportNull$$$0(13);
    }
    return localDefaultBuiltIns;
  }
  
  @Nullable
  public <T> T getCapability(@NotNull ModuleDescriptor.Capability<T> paramCapability)
  {
    if (paramCapability == null) {
      $$$reportNull$$$0(0);
    }
    return null;
  }
  
  @Nullable
  public DeclarationDescriptor getContainingDeclaration()
  {
    return null;
  }
  
  @NotNull
  public List<ModuleDescriptor> getExpectedByModules()
  {
    List localList = CollectionsKt.emptyList();
    if (localList == null) {
      $$$reportNull$$$0(9);
    }
    return localList;
  }
  
  @NotNull
  public Name getName()
  {
    Name localName = Name.special("<ERROR MODULE>");
    if (localName == null) {
      $$$reportNull$$$0(5);
    }
    return localName;
  }
  
  @NotNull
  public DeclarationDescriptor getOriginal()
  {
    return this;
  }
  
  @NotNull
  public PackageViewDescriptor getPackage(@NotNull FqName paramFqName)
  {
    if (paramFqName == null) {
      $$$reportNull$$$0(7);
    }
    throw new IllegalStateException("Should not be called!");
  }
  
  @NotNull
  public Collection<FqName> getSubPackagesOf(@NotNull FqName paramFqName, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    if (paramFqName == null) {
      $$$reportNull$$$0(2);
    }
    if (paramFunction1 == null) {
      $$$reportNull$$$0(3);
    }
    paramFqName = CollectionsKt.emptyList();
    if (paramFqName == null) {
      $$$reportNull$$$0(4);
    }
    return paramFqName;
  }
  
  public boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor paramModuleDescriptor)
  {
    if (paramModuleDescriptor == null) {
      $$$reportNull$$$0(11);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.ErrorUtils.1
 * JD-Core Version:    0.7.0.1
 */