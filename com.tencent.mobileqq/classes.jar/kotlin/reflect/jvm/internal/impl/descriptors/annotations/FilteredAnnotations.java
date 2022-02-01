package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FilteredAnnotations
  implements Annotations
{
  private final Annotations delegate;
  private final Function1<FqName, Boolean> fqNameFilter;
  private final boolean isDefinitelyNewInference;
  
  public FilteredAnnotations(@NotNull Annotations paramAnnotations, @NotNull Function1<? super FqName, Boolean> paramFunction1)
  {
    this(paramAnnotations, false, paramFunction1);
  }
  
  public FilteredAnnotations(@NotNull Annotations paramAnnotations, boolean paramBoolean, @NotNull Function1<? super FqName, Boolean> paramFunction1)
  {
    this.delegate = paramAnnotations;
    this.isDefinitelyNewInference = paramBoolean;
    this.fqNameFilter = paramFunction1;
  }
  
  private final boolean shouldBeReturned(AnnotationDescriptor paramAnnotationDescriptor)
  {
    paramAnnotationDescriptor = paramAnnotationDescriptor.getFqName();
    return (paramAnnotationDescriptor != null) && (((Boolean)this.fqNameFilter.invoke(paramAnnotationDescriptor)).booleanValue());
  }
  
  @Nullable
  public AnnotationDescriptor findAnnotation(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    if (((Boolean)this.fqNameFilter.invoke(paramFqName)).booleanValue()) {
      return this.delegate.findAnnotation(paramFqName);
    }
    return null;
  }
  
  public boolean hasAnnotation(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    if (((Boolean)this.fqNameFilter.invoke(paramFqName)).booleanValue()) {
      return this.delegate.hasAnnotation(paramFqName);
    }
    return false;
  }
  
  public boolean isEmpty()
  {
    Object localObject = (Iterable)this.delegate;
    if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {}
    AnnotationDescriptor localAnnotationDescriptor;
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        bool1 = false;
        break;
        localObject = ((Iterable)localObject).iterator();
      }
      localAnnotationDescriptor = (AnnotationDescriptor)((Iterator)localObject).next();
    } while (!((FilteredAnnotations)this).shouldBeReturned(localAnnotationDescriptor));
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (this.isDefinitelyNewInference)
    {
      if (!bool1) {
        return true;
      }
      bool2 = false;
    }
    return bool2;
  }
  
  @NotNull
  public Iterator<AnnotationDescriptor> iterator()
  {
    Object localObject1 = (Iterable)this.delegate;
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      AnnotationDescriptor localAnnotationDescriptor = (AnnotationDescriptor)localObject2;
      if (((FilteredAnnotations)this).shouldBeReturned(localAnnotationDescriptor)) {
        localCollection.add(localObject2);
      }
    }
    return ((List)localCollection).iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations
 * JD-Core Version:    0.7.0.1
 */