package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

final class JvmBuiltInsSettings$getFunctions$2
  extends Lambda
  implements Function1<MemberScope, Collection<? extends SimpleFunctionDescriptor>>
{
  JvmBuiltInsSettings$getFunctions$2(Name paramName)
  {
    super(1);
  }
  
  @NotNull
  public final Collection<? extends SimpleFunctionDescriptor> invoke(@NotNull MemberScope paramMemberScope)
  {
    Intrinsics.checkParameterIsNotNull(paramMemberScope, "it");
    return paramMemberScope.getContributedFunctions(this.$name, (LookupLocation)NoLookupLocation.FROM_BUILTINS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings.getFunctions.2
 * JD-Core Version:    0.7.0.1
 */