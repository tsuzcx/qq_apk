package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaValueParameter
  extends ReflectJavaElement
  implements JavaValueParameter
{
  private final boolean isVararg;
  private final Annotation[] reflectAnnotations;
  private final String reflectName;
  @NotNull
  private final ReflectJavaType type;
  
  public ReflectJavaValueParameter(@NotNull ReflectJavaType paramReflectJavaType, @NotNull Annotation[] paramArrayOfAnnotation, @Nullable String paramString, boolean paramBoolean)
  {
    this.type = paramReflectJavaType;
    this.reflectAnnotations = paramArrayOfAnnotation;
    this.reflectName = paramString;
    this.isVararg = paramBoolean;
  }
  
  @Nullable
  public ReflectJavaAnnotation findAnnotation(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return ReflectJavaAnnotationOwnerKt.findAnnotation(this.reflectAnnotations, paramFqName);
  }
  
  @NotNull
  public List<ReflectJavaAnnotation> getAnnotations()
  {
    return ReflectJavaAnnotationOwnerKt.getAnnotations(this.reflectAnnotations);
  }
  
  @Nullable
  public Name getName()
  {
    String str = this.reflectName;
    if (str != null) {
      return Name.guessByFirstCharacter(str);
    }
    return null;
  }
  
  @NotNull
  public ReflectJavaType getType()
  {
    return this.type;
  }
  
  public boolean isDeprecatedInJavaDoc()
  {
    return false;
  }
  
  public boolean isVararg()
  {
    return this.isVararg;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(": ");
    String str;
    if (isVararg()) {
      str = "vararg ";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(getName());
    localStringBuilder.append(": ");
    localStringBuilder.append(getType());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaValueParameter
 * JD-Core Version:    0.7.0.1
 */