package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

final class LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$$inlined$any$lambda$1
  extends Lambda
  implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>>
{
  LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$$inlined$any$lambda$1(LazyJavaClassMemberScope paramLazyJavaClassMemberScope, SimpleFunctionDescriptor paramSimpleFunctionDescriptor)
  {
    super(1);
  }
  
  @NotNull
  public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "accessorName");
    if (Intrinsics.areEqual(this.$function$inlined.getName(), paramName)) {
      return (Collection)CollectionsKt.listOf(this.$function$inlined);
    }
    return (Collection)CollectionsKt.plus(LazyJavaClassMemberScope.access$searchMethodsByNameWithoutBuiltinMagic(this.this$0, paramName), (Iterable)LazyJavaClassMemberScope.access$searchMethodsInSupertypesWithoutBuiltinMagic(this.this$0, paramName));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.isVisibleAsFunctionInCurrentClass..inlined.any.lambda.1
 * JD-Core Version:    0.7.0.1
 */