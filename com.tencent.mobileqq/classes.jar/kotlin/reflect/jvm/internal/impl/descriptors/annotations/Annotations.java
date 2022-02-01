package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface Annotations
  extends Iterable<AnnotationDescriptor>, KMappedMarker
{
  public static final Annotations.Companion Companion = Annotations.Companion.$$INSTANCE;
  
  @Nullable
  public abstract AnnotationDescriptor findAnnotation(@NotNull FqName paramFqName);
  
  public abstract boolean hasAnnotation(@NotNull FqName paramFqName);
  
  public abstract boolean isEmpty();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
 * JD-Core Version:    0.7.0.1
 */