package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class LazyJavaScope$declaredMemberIndex$1
  extends Lambda
  implements Function0<DeclaredMemberIndex>
{
  LazyJavaScope$declaredMemberIndex$1(LazyJavaScope paramLazyJavaScope)
  {
    super(0);
  }
  
  @NotNull
  public final DeclaredMemberIndex invoke()
  {
    return this.this$0.computeMemberIndex();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.declaredMemberIndex.1
 * JD-Core Version:    0.7.0.1
 */