package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

final class LazyJavaStaticClassScope$computePropertyNames$1$1
  extends Lambda
  implements Function1<MemberScope, Set<? extends Name>>
{
  public static final 1 INSTANCE = new 1();
  
  LazyJavaStaticClassScope$computePropertyNames$1$1()
  {
    super(1);
  }
  
  @NotNull
  public final Set<Name> invoke(@NotNull MemberScope paramMemberScope)
  {
    Intrinsics.checkParameterIsNotNull(paramMemberScope, "it");
    return paramMemberScope.getVariableNames();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope.computePropertyNames.1.1
 * JD-Core Version:    0.7.0.1
 */