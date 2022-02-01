package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class MemberScope$Companion
{
  @NotNull
  private static final Function1<Name, Boolean> ALL_NAME_FILTER = (Function1)MemberScope.Companion.ALL_NAME_FILTER.1.INSTANCE;
  
  @NotNull
  public final Function1<Name, Boolean> getALL_NAME_FILTER()
  {
    return ALL_NAME_FILTER;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Companion
 * JD-Core Version:    0.7.0.1
 */