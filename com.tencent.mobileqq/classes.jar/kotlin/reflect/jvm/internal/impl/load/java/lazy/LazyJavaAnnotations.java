package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.FqNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaAnnotations
  implements Annotations
{
  private final MemoizedFunctionToNullable<JavaAnnotation, AnnotationDescriptor> annotationDescriptors;
  private final JavaAnnotationOwner annotationOwner;
  private final LazyJavaResolverContext c;
  
  public LazyJavaAnnotations(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull JavaAnnotationOwner paramJavaAnnotationOwner)
  {
    this.c = paramLazyJavaResolverContext;
    this.annotationOwner = paramJavaAnnotationOwner;
    this.annotationDescriptors = this.c.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new LazyJavaAnnotations.annotationDescriptors.1(this));
  }
  
  @Nullable
  public AnnotationDescriptor findAnnotation(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    Object localObject = this.annotationOwner.findAnnotation(paramFqName);
    if (localObject != null)
    {
      localObject = (AnnotationDescriptor)((Function1)this.annotationDescriptors).invoke(localObject);
      if (localObject != null) {
        return localObject;
      }
    }
    return JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(paramFqName, this.annotationOwner, this.c);
  }
  
  public boolean hasAnnotation(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return Annotations.DefaultImpls.hasAnnotation(this, paramFqName);
  }
  
  public boolean isEmpty()
  {
    return (this.annotationOwner.getAnnotations().isEmpty()) && (!this.annotationOwner.isDeprecatedInJavaDoc());
  }
  
  @NotNull
  public Iterator<AnnotationDescriptor> iterator()
  {
    Sequence localSequence = SequencesKt.map(CollectionsKt.asSequence((Iterable)this.annotationOwner.getAnnotations()), (Function1)this.annotationDescriptors);
    JavaAnnotationMapper localJavaAnnotationMapper = JavaAnnotationMapper.INSTANCE;
    FqName localFqName = KotlinBuiltIns.FQ_NAMES.deprecated;
    Intrinsics.checkExpressionValueIsNotNull(localFqName, "KotlinBuiltIns.FQ_NAMES.deprecated");
    return SequencesKt.filterNotNull(SequencesKt.plus(localSequence, localJavaAnnotationMapper.findMappedJavaAnnotation(localFqName, this.annotationOwner, this.c))).iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations
 * JD-Core Version:    0.7.0.1
 */