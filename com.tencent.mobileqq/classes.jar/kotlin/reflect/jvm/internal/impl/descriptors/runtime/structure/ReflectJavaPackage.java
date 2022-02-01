package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaPackage
  extends ReflectJavaElement
  implements JavaPackage
{
  @NotNull
  private final FqName fqName;
  
  public ReflectJavaPackage(@NotNull FqName paramFqName)
  {
    this.fqName = paramFqName;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof ReflectJavaPackage)) && (Intrinsics.areEqual(getFqName(), ((ReflectJavaPackage)paramObject).getFqName()));
  }
  
  @Nullable
  public JavaAnnotation findAnnotation(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return null;
  }
  
  @NotNull
  public List<JavaAnnotation> getAnnotations()
  {
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public Collection<JavaClass> getClasses(@NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
    return (Collection)CollectionsKt.emptyList();
  }
  
  @NotNull
  public FqName getFqName()
  {
    return this.fqName;
  }
  
  @NotNull
  public Collection<JavaPackage> getSubPackages()
  {
    return (Collection)CollectionsKt.emptyList();
  }
  
  public int hashCode()
  {
    return getFqName().hashCode();
  }
  
  public boolean isDeprecatedInJavaDoc()
  {
    return false;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(": ");
    localStringBuilder.append(getFqName());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaPackage
 * JD-Core Version:    0.7.0.1
 */