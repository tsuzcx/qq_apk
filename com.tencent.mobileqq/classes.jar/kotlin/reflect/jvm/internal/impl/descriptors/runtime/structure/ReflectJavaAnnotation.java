package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaAnnotation
  extends ReflectJavaElement
  implements JavaAnnotation
{
  @NotNull
  private final Annotation annotation;
  
  public ReflectJavaAnnotation(@NotNull Annotation paramAnnotation)
  {
    this.annotation = paramAnnotation;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof ReflectJavaAnnotation)) && (Intrinsics.areEqual(this.annotation, ((ReflectJavaAnnotation)paramObject).annotation));
  }
  
  @NotNull
  public final Annotation getAnnotation()
  {
    return this.annotation;
  }
  
  @NotNull
  public Collection<JavaAnnotationArgument> getArguments()
  {
    Method[] arrayOfMethod = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(this.annotation)).getDeclaredMethods();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfMethod, "annotation.annotationClass.java.declaredMethods");
    Collection localCollection = (Collection)new ArrayList(arrayOfMethod.length);
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      ReflectJavaAnnotationArgument.Factory localFactory = ReflectJavaAnnotationArgument.Factory;
      Object localObject = localMethod.invoke(this.annotation, new Object[0]);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "method.invoke(annotation)");
      Intrinsics.checkExpressionValueIsNotNull(localMethod, "method");
      localCollection.add(localFactory.create(localObject, Name.identifier(localMethod.getName())));
      i += 1;
    }
    return (Collection)localCollection;
  }
  
  @NotNull
  public ClassId getClassId()
  {
    return ReflectClassUtilKt.getClassId(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(this.annotation)));
  }
  
  public int hashCode()
  {
    return this.annotation.hashCode();
  }
  
  public boolean isIdeExternalAnnotation()
  {
    return JavaAnnotation.DefaultImpls.isIdeExternalAnnotation(this);
  }
  
  @NotNull
  public ReflectJavaClass resolve()
  {
    return new ReflectJavaClass(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(this.annotation)));
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(": ");
    localStringBuilder.append(this.annotation);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation
 * JD-Core Version:    0.7.0.1
 */