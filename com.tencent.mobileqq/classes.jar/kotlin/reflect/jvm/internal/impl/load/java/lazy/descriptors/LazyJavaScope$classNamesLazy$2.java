package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import org.jetbrains.annotations.NotNull;

final class LazyJavaScope$classNamesLazy$2
  extends Lambda
  implements Function0<Set<? extends Name>>
{
  LazyJavaScope$classNamesLazy$2(LazyJavaScope paramLazyJavaScope)
  {
    super(0);
  }
  
  @NotNull
  public final Set<Name> invoke()
  {
    return this.this$0.computeClassNames(DescriptorKindFilter.CLASSIFIERS, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.classNamesLazy.2
 * JD-Core Version:    0.7.0.1
 */