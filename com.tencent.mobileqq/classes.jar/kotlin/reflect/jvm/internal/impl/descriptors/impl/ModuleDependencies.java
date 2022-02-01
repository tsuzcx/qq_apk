package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public abstract interface ModuleDependencies
{
  @NotNull
  public abstract List<ModuleDescriptorImpl> getAllDependencies();
  
  @NotNull
  public abstract List<ModuleDescriptorImpl> getExpectedByDependencies();
  
  @NotNull
  public abstract Set<ModuleDescriptorImpl> getModulesWhoseInternalsAreVisible();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
 * JD-Core Version:    0.7.0.1
 */