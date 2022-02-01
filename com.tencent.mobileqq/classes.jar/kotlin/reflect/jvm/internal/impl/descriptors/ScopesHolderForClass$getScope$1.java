package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

final class ScopesHolderForClass$getScope$1
  extends Lambda
  implements Function0<T>
{
  ScopesHolderForClass$getScope$1(ScopesHolderForClass paramScopesHolderForClass, KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    super(0);
  }
  
  @NotNull
  public final T invoke()
  {
    return (MemberScope)ScopesHolderForClass.access$getScopeFactory$p(this.this$0).invoke(this.$kotlinTypeRefiner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass.getScope.1
 * JD-Core Version:    0.7.0.1
 */