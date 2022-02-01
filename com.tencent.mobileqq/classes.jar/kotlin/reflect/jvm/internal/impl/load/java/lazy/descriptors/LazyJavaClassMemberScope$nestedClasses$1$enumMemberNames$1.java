package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

final class LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1
  extends Lambda
  implements Function0<Set<? extends Name>>
{
  LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1(LazyJavaClassMemberScope.nestedClasses.1 param1)
  {
    super(0);
  }
  
  @NotNull
  public final Set<Name> invoke()
  {
    return SetsKt.plus(this.this$0.this$0.getFunctionNames(), (Iterable)this.this$0.this$0.getVariableNames());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.nestedClasses.1.enumMemberNames.1
 * JD-Core Version:    0.7.0.1
 */