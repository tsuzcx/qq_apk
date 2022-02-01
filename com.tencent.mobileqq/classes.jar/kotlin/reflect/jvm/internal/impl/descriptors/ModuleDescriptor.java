package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface ModuleDescriptor
  extends DeclarationDescriptor
{
  @NotNull
  public abstract KotlinBuiltIns getBuiltIns();
  
  @Nullable
  public abstract <T> T getCapability(@NotNull ModuleDescriptor.Capability<T> paramCapability);
  
  @NotNull
  public abstract List<ModuleDescriptor> getExpectedByModules();
  
  @NotNull
  public abstract PackageViewDescriptor getPackage(@NotNull FqName paramFqName);
  
  @NotNull
  public abstract Collection<FqName> getSubPackagesOf(@NotNull FqName paramFqName, @NotNull Function1<? super Name, Boolean> paramFunction1);
  
  public abstract boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor paramModuleDescriptor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
 * JD-Core Version:    0.7.0.1
 */