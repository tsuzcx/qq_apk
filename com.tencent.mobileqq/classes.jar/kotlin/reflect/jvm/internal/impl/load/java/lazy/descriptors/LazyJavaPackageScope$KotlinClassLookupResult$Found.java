package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaPackageScope$KotlinClassLookupResult$Found
  extends LazyJavaPackageScope.KotlinClassLookupResult
{
  @NotNull
  private final ClassDescriptor descriptor;
  
  public LazyJavaPackageScope$KotlinClassLookupResult$Found(@NotNull ClassDescriptor paramClassDescriptor)
  {
    super(null);
    this.descriptor = paramClassDescriptor;
  }
  
  @NotNull
  public final ClassDescriptor getDescriptor()
  {
    return this.descriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.Found
 * JD-Core Version:    0.7.0.1
 */