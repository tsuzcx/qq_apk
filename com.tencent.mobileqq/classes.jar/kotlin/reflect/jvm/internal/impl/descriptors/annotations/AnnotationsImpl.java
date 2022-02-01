package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AnnotationsImpl
  implements Annotations
{
  private final List<AnnotationDescriptor> annotations;
  
  public AnnotationsImpl(@NotNull List<? extends AnnotationDescriptor> paramList)
  {
    this.annotations = paramList;
  }
  
  @Nullable
  public AnnotationDescriptor findAnnotation(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return Annotations.DefaultImpls.findAnnotation(this, paramFqName);
  }
  
  public boolean hasAnnotation(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return Annotations.DefaultImpls.hasAnnotation(this, paramFqName);
  }
  
  public boolean isEmpty()
  {
    return this.annotations.isEmpty();
  }
  
  @NotNull
  public Iterator<AnnotationDescriptor> iterator()
  {
    return this.annotations.iterator();
  }
  
  @NotNull
  public String toString()
  {
    return this.annotations.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsImpl
 * JD-Core Version:    0.7.0.1
 */