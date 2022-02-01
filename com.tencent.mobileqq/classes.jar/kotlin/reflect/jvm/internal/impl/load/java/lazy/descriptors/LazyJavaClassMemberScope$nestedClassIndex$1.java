package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

final class LazyJavaClassMemberScope$nestedClassIndex$1
  extends Lambda
  implements Function0<Set<? extends Name>>
{
  LazyJavaClassMemberScope$nestedClassIndex$1(LazyJavaClassMemberScope paramLazyJavaClassMemberScope)
  {
    super(0);
  }
  
  @NotNull
  public final Set<Name> invoke()
  {
    return CollectionsKt.toSet((Iterable)LazyJavaClassMemberScope.access$getJClass$p(this.this$0).getInnerClassNames());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.nestedClassIndex.1
 * JD-Core Version:    0.7.0.1
 */