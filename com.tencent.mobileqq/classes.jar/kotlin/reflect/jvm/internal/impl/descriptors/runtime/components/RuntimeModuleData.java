package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import org.jetbrains.annotations.NotNull;

public final class RuntimeModuleData
{
  public static final RuntimeModuleData.Companion Companion = new RuntimeModuleData.Companion(null);
  @NotNull
  private final DeserializationComponents deserialization;
  @NotNull
  private final PackagePartScopeCache packagePartScopeCache;
  
  private RuntimeModuleData(DeserializationComponents paramDeserializationComponents, PackagePartScopeCache paramPackagePartScopeCache)
  {
    this.deserialization = paramDeserializationComponents;
    this.packagePartScopeCache = paramPackagePartScopeCache;
  }
  
  @NotNull
  public final DeserializationComponents getDeserialization()
  {
    return this.deserialization;
  }
  
  @NotNull
  public final ModuleDescriptor getModule()
  {
    return this.deserialization.getModuleDescriptor();
  }
  
  @NotNull
  public final PackagePartScopeCache getPackagePartScopeCache()
  {
    return this.packagePartScopeCache;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData
 * JD-Core Version:    0.7.0.1
 */