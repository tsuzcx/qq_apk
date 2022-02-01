package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import org.jetbrains.annotations.NotNull;

final class LazyJavaAnnotationDescriptor$allValueArguments$2
  extends Lambda
  implements Function0<Map<Name, ? extends ConstantValue<?>>>
{
  LazyJavaAnnotationDescriptor$allValueArguments$2(LazyJavaAnnotationDescriptor paramLazyJavaAnnotationDescriptor)
  {
    super(0);
  }
  
  @NotNull
  public final Map<Name, ConstantValue<?>> invoke()
  {
    Object localObject1 = (Iterable)LazyJavaAnnotationDescriptor.access$getJavaAnnotation$p(this.this$0).getArguments();
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (JavaAnnotationArgument)localIterator.next();
      localObject1 = ((JavaAnnotationArgument)localObject2).getName();
      if (localObject1 == null) {
        localObject1 = JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
      }
      localObject2 = LazyJavaAnnotationDescriptor.access$resolveAnnotationArgument(this.this$0, (JavaAnnotationArgument)localObject2);
      if (localObject2 != null) {
        localObject1 = TuplesKt.to(localObject1, localObject2);
      } else {
        localObject1 = null;
      }
      if (localObject1 != null) {
        localCollection.add(localObject1);
      }
    }
    return MapsKt.toMap((Iterable)localCollection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor.allValueArguments.2
 * JD-Core Version:    0.7.0.1
 */