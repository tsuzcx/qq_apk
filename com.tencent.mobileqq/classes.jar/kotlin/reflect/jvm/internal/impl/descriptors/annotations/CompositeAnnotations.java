package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CompositeAnnotations
  implements Annotations
{
  private final List<Annotations> delegates;
  
  public CompositeAnnotations(@NotNull List<? extends Annotations> paramList)
  {
    this.delegates = paramList;
  }
  
  public CompositeAnnotations(@NotNull Annotations... paramVarArgs)
  {
    this(ArraysKt.toList(paramVarArgs));
  }
  
  @Nullable
  public AnnotationDescriptor findAnnotation(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return (AnnotationDescriptor)SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence((Iterable)this.delegates), (Function1)new CompositeAnnotations.findAnnotation.1(paramFqName)));
  }
  
  public boolean hasAnnotation(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    Iterator localIterator = CollectionsKt.asSequence((Iterable)this.delegates).iterator();
    while (localIterator.hasNext()) {
      if (((Annotations)localIterator.next()).hasAnnotation(paramFqName)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isEmpty()
  {
    Object localObject = (Iterable)this.delegates;
    boolean bool1 = localObject instanceof Collection;
    boolean bool2 = true;
    if ((bool1) && (((Collection)localObject).isEmpty())) {
      return true;
    }
    localObject = ((Iterable)localObject).iterator();
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (((Annotations)((Iterator)localObject).next()).isEmpty());
    bool1 = false;
    return bool1;
  }
  
  @NotNull
  public Iterator<AnnotationDescriptor> iterator()
  {
    return SequencesKt.flatMap(CollectionsKt.asSequence((Iterable)this.delegates), (Function1)CompositeAnnotations.iterator.1.INSTANCE).iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations
 * JD-Core Version:    0.7.0.1
 */