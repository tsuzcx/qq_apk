package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;

final class TypeIntersectionScope$getContributedVariables$1
  extends Lambda
  implements Function1<PropertyDescriptor, PropertyDescriptor>
{
  public static final 1 INSTANCE = new 1();
  
  TypeIntersectionScope$getContributedVariables$1()
  {
    super(1);
  }
  
  @NotNull
  public final PropertyDescriptor invoke(@NotNull PropertyDescriptor paramPropertyDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramPropertyDescriptor, "$receiver");
    return paramPropertyDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope.getContributedVariables.1
 * JD-Core Version:    0.7.0.1
 */