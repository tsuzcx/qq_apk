package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public final class ModuleDependenciesImpl
  implements ModuleDependencies
{
  @NotNull
  private final List<ModuleDescriptorImpl> allDependencies;
  @NotNull
  private final List<ModuleDescriptorImpl> expectedByDependencies;
  @NotNull
  private final Set<ModuleDescriptorImpl> modulesWhoseInternalsAreVisible;
  
  public ModuleDependenciesImpl(@NotNull List<ModuleDescriptorImpl> paramList1, @NotNull Set<ModuleDescriptorImpl> paramSet, @NotNull List<ModuleDescriptorImpl> paramList2)
  {
    this.allDependencies = paramList1;
    this.modulesWhoseInternalsAreVisible = paramSet;
    this.expectedByDependencies = paramList2;
  }
  
  @NotNull
  public List<ModuleDescriptorImpl> getAllDependencies()
  {
    return this.allDependencies;
  }
  
  @NotNull
  public List<ModuleDescriptorImpl> getExpectedByDependencies()
  {
    return this.expectedByDependencies;
  }
  
  @NotNull
  public Set<ModuleDescriptorImpl> getModulesWhoseInternalsAreVisible()
  {
    return this.modulesWhoseInternalsAreVisible;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependenciesImpl
 * JD-Core Version:    0.7.0.1
 */