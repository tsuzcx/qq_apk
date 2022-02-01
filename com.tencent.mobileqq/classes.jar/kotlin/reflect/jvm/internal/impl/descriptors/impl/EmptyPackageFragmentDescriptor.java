package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import org.jetbrains.annotations.NotNull;

public final class EmptyPackageFragmentDescriptor
  extends PackageFragmentDescriptorImpl
{
  public EmptyPackageFragmentDescriptor(@NotNull ModuleDescriptor paramModuleDescriptor, @NotNull FqName paramFqName)
  {
    super(paramModuleDescriptor, paramFqName);
  }
  
  @NotNull
  public MemberScope.Empty getMemberScope()
  {
    return MemberScope.Empty.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor
 * JD-Core Version:    0.7.0.1
 */