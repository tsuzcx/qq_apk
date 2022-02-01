package kotlin.jvm.internal;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/PackageReference;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "moduleName", "", "(Ljava/lang/Class;Ljava/lang/String;)V", "getJClass", "()Ljava/lang/Class;", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "equals", "", "other", "", "hashCode", "", "toString", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public final class PackageReference
  implements ClassBasedDeclarationContainer
{
  @NotNull
  private final Class<?> jClass;
  private final String moduleName;
  
  public PackageReference(@NotNull Class<?> paramClass, @NotNull String paramString)
  {
    this.jClass = paramClass;
    this.moduleName = paramString;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof PackageReference)) && (Intrinsics.areEqual(getJClass(), ((PackageReference)paramObject).getJClass()));
  }
  
  @NotNull
  public Class<?> getJClass()
  {
    return this.jClass;
  }
  
  @NotNull
  public Collection<KCallable<?>> getMembers()
  {
    throw ((Throwable)new KotlinReflectionNotSupportedError());
  }
  
  public int hashCode()
  {
    return getJClass().hashCode();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getJClass().toString());
    localStringBuilder.append(" (Kotlin reflection is not available)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.jvm.internal.PackageReference
 * JD-Core Version:    0.7.0.1
 */