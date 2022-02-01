package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class EnhancedTypeAnnotations
  implements Annotations
{
  private final FqName fqNameToMatch;
  
  public EnhancedTypeAnnotations(@NotNull FqName paramFqName)
  {
    this.fqNameToMatch = paramFqName;
  }
  
  @Nullable
  public EnhancedTypeAnnotationDescriptor findAnnotation(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    if (Intrinsics.areEqual(paramFqName, this.fqNameToMatch)) {
      return EnhancedTypeAnnotationDescriptor.INSTANCE;
    }
    return null;
  }
  
  public boolean hasAnnotation(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return Annotations.DefaultImpls.hasAnnotation(this, paramFqName);
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  @NotNull
  public Iterator<AnnotationDescriptor> iterator()
  {
    return CollectionsKt.emptyList().iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancedTypeAnnotations
 * JD-Core Version:    0.7.0.1
 */