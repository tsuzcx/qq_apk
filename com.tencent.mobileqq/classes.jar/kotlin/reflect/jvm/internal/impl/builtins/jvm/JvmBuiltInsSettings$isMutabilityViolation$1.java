package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors;
import org.jetbrains.annotations.NotNull;

final class JvmBuiltInsSettings$isMutabilityViolation$1<N>
  implements DFS.Neighbors<N>
{
  public static final 1 INSTANCE = new 1();
  
  @NotNull
  public final Collection<? extends CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramCallableMemberDescriptor, "it");
    paramCallableMemberDescriptor = paramCallableMemberDescriptor.getOriginal();
    Intrinsics.checkExpressionValueIsNotNull(paramCallableMemberDescriptor, "it.original");
    return paramCallableMemberDescriptor.getOverriddenDescriptors();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings.isMutabilityViolation.1
 * JD-Core Version:    0.7.0.1
 */