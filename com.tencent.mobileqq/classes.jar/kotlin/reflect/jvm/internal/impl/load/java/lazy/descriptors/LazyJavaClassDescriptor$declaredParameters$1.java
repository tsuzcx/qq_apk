package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import org.jetbrains.annotations.NotNull;

final class LazyJavaClassDescriptor$declaredParameters$1
  extends Lambda
  implements Function0<List<? extends TypeParameterDescriptor>>
{
  LazyJavaClassDescriptor$declaredParameters$1(LazyJavaClassDescriptor paramLazyJavaClassDescriptor)
  {
    super(0);
  }
  
  @NotNull
  public final List<TypeParameterDescriptor> invoke()
  {
    Object localObject2 = (Iterable)this.this$0.getJClass().getTypeParameters();
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    Iterator localIterator = ((Iterable)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (JavaTypeParameter)localIterator.next();
      TypeParameterDescriptor localTypeParameterDescriptor = LazyJavaClassDescriptor.access$getC$p(this.this$0).getTypeParameterResolver().resolveTypeParameter((JavaTypeParameter)localObject2);
      if (localTypeParameterDescriptor != null)
      {
        ((Collection)localObject1).add(localTypeParameterDescriptor);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Parameter ");
        ((StringBuilder)localObject1).append(localObject2);
        ((StringBuilder)localObject1).append(" surely belongs to class ");
        ((StringBuilder)localObject1).append(this.this$0.getJClass());
        ((StringBuilder)localObject1).append(", so it must be resolved");
        throw ((Throwable)new AssertionError(((StringBuilder)localObject1).toString()));
      }
    }
    return (List)localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.declaredParameters.1
 * JD-Core Version:    0.7.0.1
 */