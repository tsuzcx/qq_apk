package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

public abstract interface PackageFragmentDescriptor
  extends ClassOrPackageFragmentDescriptor
{
  @NotNull
  public abstract ModuleDescriptor getContainingDeclaration();
  
  @NotNull
  public abstract FqName getFqName();
  
  @NotNull
  public abstract MemberScope getMemberScope();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
 * JD-Core Version:    0.7.0.1
 */