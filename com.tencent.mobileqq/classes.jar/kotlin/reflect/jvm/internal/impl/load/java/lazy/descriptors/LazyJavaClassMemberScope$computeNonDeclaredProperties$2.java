package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

final class LazyJavaClassMemberScope$computeNonDeclaredProperties$2
  extends Lambda
  implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>>
{
  LazyJavaClassMemberScope$computeNonDeclaredProperties$2(LazyJavaClassMemberScope paramLazyJavaClassMemberScope)
  {
    super(1);
  }
  
  @NotNull
  public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "it");
    return LazyJavaClassMemberScope.access$searchMethodsInSupertypesWithoutBuiltinMagic(this.this$0, paramName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.computeNonDeclaredProperties.2
 * JD-Core Version:    0.7.0.1
 */