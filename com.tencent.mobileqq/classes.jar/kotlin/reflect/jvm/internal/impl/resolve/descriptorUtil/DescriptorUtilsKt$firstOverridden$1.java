package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors;
import org.jetbrains.annotations.NotNull;

final class DescriptorUtilsKt$firstOverridden$1<N>
  implements DFS.Neighbors<N>
{
  DescriptorUtilsKt$firstOverridden$1(boolean paramBoolean) {}
  
  @NotNull
  public final Iterable<CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    CallableMemberDescriptor localCallableMemberDescriptor = paramCallableMemberDescriptor;
    if (this.$useOriginal) {
      if (paramCallableMemberDescriptor != null) {
        localCallableMemberDescriptor = paramCallableMemberDescriptor.getOriginal();
      } else {
        localCallableMemberDescriptor = null;
      }
    }
    if (localCallableMemberDescriptor != null)
    {
      paramCallableMemberDescriptor = localCallableMemberDescriptor.getOverriddenDescriptors();
      if (paramCallableMemberDescriptor != null) {}
    }
    else
    {
      paramCallableMemberDescriptor = CollectionsKt.emptyList();
    }
    return (Iterable)paramCallableMemberDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.firstOverridden.1
 * JD-Core Version:    0.7.0.1
 */