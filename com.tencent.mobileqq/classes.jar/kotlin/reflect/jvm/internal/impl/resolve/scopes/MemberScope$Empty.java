package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class MemberScope$Empty
  extends MemberScopeImpl
{
  public static final Empty INSTANCE = new Empty();
  
  @NotNull
  public Set<Name> getFunctionNames()
  {
    return SetsKt.emptySet();
  }
  
  @NotNull
  public Set<Name> getVariableNames()
  {
    return SetsKt.emptySet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty
 * JD-Core Version:    0.7.0.1
 */