package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class LazyJavaPackageScope$FindClassRequest
{
  @Nullable
  private final JavaClass javaClass;
  @NotNull
  private final Name name;
  
  public LazyJavaPackageScope$FindClassRequest(@NotNull Name paramName, @Nullable JavaClass paramJavaClass)
  {
    this.name = paramName;
    this.javaClass = paramJavaClass;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof FindClassRequest)) && (Intrinsics.areEqual(this.name, ((FindClassRequest)paramObject).name));
  }
  
  @Nullable
  public final JavaClass getJavaClass()
  {
    return this.javaClass;
  }
  
  @NotNull
  public final Name getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    return this.name.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.FindClassRequest
 * JD-Core Version:    0.7.0.1
 */