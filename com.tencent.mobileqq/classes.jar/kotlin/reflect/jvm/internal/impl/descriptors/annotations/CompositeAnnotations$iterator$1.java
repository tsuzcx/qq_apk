package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

final class CompositeAnnotations$iterator$1
  extends Lambda
  implements Function1<Annotations, Sequence<? extends AnnotationDescriptor>>
{
  public static final 1 INSTANCE = new 1();
  
  CompositeAnnotations$iterator$1()
  {
    super(1);
  }
  
  @NotNull
  public final Sequence<AnnotationDescriptor> invoke(@NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "it");
    return CollectionsKt.asSequence((Iterable)paramAnnotations);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations.iterator.1
 * JD-Core Version:    0.7.0.1
 */