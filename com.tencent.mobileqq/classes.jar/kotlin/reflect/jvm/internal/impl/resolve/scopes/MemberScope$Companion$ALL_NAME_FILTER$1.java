package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

final class MemberScope$Companion$ALL_NAME_FILTER$1
  extends Lambda
  implements Function1<Name, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  MemberScope$Companion$ALL_NAME_FILTER$1()
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "it");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Companion.ALL_NAME_FILTER.1
 * JD-Core Version:    0.7.0.1
 */