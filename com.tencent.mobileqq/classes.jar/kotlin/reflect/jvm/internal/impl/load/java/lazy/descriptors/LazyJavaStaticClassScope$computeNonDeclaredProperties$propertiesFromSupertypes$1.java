package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

final class LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1
  extends Lambda
  implements Function1<MemberScope, Collection<? extends PropertyDescriptor>>
{
  LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1(Name paramName)
  {
    super(1);
  }
  
  @NotNull
  public final Collection<? extends PropertyDescriptor> invoke(@NotNull MemberScope paramMemberScope)
  {
    Intrinsics.checkParameterIsNotNull(paramMemberScope, "it");
    return paramMemberScope.getContributedVariables(this.$name, (LookupLocation)NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope.computeNonDeclaredProperties.propertiesFromSupertypes.1
 * JD-Core Version:    0.7.0.1
 */