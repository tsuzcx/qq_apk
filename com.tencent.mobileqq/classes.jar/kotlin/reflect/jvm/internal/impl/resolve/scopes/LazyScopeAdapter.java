package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import org.jetbrains.annotations.NotNull;

public final class LazyScopeAdapter
  extends AbstractScopeAdapter
{
  private final NotNullLazyValue<MemberScope> scope;
  
  public LazyScopeAdapter(@NotNull NotNullLazyValue<? extends MemberScope> paramNotNullLazyValue)
  {
    this.scope = paramNotNullLazyValue;
  }
  
  @NotNull
  protected MemberScope getWorkerScope()
  {
    return (MemberScope)this.scope.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter
 * JD-Core Version:    0.7.0.1
 */