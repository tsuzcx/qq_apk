package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaScope$ResolvedValueParameters
{
  @NotNull
  private final List<ValueParameterDescriptor> descriptors;
  private final boolean hasSynthesizedNames;
  
  public LazyJavaScope$ResolvedValueParameters(@NotNull List<? extends ValueParameterDescriptor> paramList, boolean paramBoolean)
  {
    this.descriptors = paramList;
    this.hasSynthesizedNames = paramBoolean;
  }
  
  @NotNull
  public final List<ValueParameterDescriptor> getDescriptors()
  {
    return this.descriptors;
  }
  
  public final boolean getHasSynthesizedNames()
  {
    return this.hasSynthesizedNames;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.ResolvedValueParameters
 * JD-Core Version:    0.7.0.1
 */