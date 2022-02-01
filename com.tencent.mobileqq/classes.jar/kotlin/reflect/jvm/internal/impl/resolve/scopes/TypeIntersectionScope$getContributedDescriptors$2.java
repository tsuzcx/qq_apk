package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import org.jetbrains.annotations.NotNull;

final class TypeIntersectionScope$getContributedDescriptors$2
  extends Lambda
  implements Function1<CallableDescriptor, CallableDescriptor>
{
  public static final 2 INSTANCE = new 2();
  
  TypeIntersectionScope$getContributedDescriptors$2()
  {
    super(1);
  }
  
  @NotNull
  public final CallableDescriptor invoke(@NotNull CallableDescriptor paramCallableDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableDescriptor, "$receiver");
    return paramCallableDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope.getContributedDescriptors.2
 * JD-Core Version:    0.7.0.1
 */