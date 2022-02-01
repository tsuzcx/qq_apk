package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

public abstract interface PackageViewDescriptor
  extends DeclarationDescriptor
{
  @NotNull
  public abstract FqName getFqName();
  
  @NotNull
  public abstract List<PackageFragmentDescriptor> getFragments();
  
  @NotNull
  public abstract MemberScope getMemberScope();
  
  @NotNull
  public abstract ModuleDescriptor getModule();
  
  public abstract boolean isEmpty();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
 * JD-Core Version:    0.7.0.1
 */