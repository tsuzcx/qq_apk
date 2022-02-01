package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder.Request;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaClassFinder
  implements JavaClassFinder
{
  private final ClassLoader classLoader;
  
  public ReflectJavaClassFinder(@NotNull ClassLoader paramClassLoader)
  {
    this.classLoader = paramClassLoader;
  }
  
  @Nullable
  public JavaClass findClass(@NotNull JavaClassFinder.Request paramRequest)
  {
    Intrinsics.checkParameterIsNotNull(paramRequest, "request");
    paramRequest = paramRequest.getClassId();
    FqName localFqName = paramRequest.getPackageFqName();
    Intrinsics.checkExpressionValueIsNotNull(localFqName, "classId.packageFqName");
    paramRequest = paramRequest.getRelativeClassName().asString();
    Intrinsics.checkExpressionValueIsNotNull(paramRequest, "classId.relativeClassName.asString()");
    paramRequest = StringsKt.replace$default(paramRequest, '.', '$', false, 4, null);
    if (!localFqName.isRoot())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localFqName.asString());
      localStringBuilder.append(".");
      localStringBuilder.append(paramRequest);
      paramRequest = localStringBuilder.toString();
    }
    paramRequest = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, paramRequest);
    if (paramRequest != null) {
      return (JavaClass)new ReflectJavaClass(paramRequest);
    }
    return null;
  }
  
  @Nullable
  public JavaPackage findPackage(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return (JavaPackage)new ReflectJavaPackage(paramFqName);
  }
  
  @Nullable
  public Set<String> knownClassNamesInPackage(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "packageFqName");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinder
 * JD-Core Version:    0.7.0.1
 */