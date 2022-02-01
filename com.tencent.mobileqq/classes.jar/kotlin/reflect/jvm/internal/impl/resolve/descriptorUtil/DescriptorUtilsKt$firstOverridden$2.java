package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorUtilsKt$firstOverridden$2
  extends DFS.AbstractNodeHandler<CallableMemberDescriptor, CallableMemberDescriptor>
{
  DescriptorUtilsKt$firstOverridden$2(Ref.ObjectRef paramObjectRef, Function1 paramFunction1) {}
  
  public void afterChildren(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "current");
    if (((CallableMemberDescriptor)this.$result.element == null) && (((Boolean)this.$predicate.invoke(paramCallableMemberDescriptor)).booleanValue())) {
      this.$result.element = paramCallableMemberDescriptor;
    }
  }
  
  public boolean beforeChildren(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "current");
    return (CallableMemberDescriptor)this.$result.element == null;
  }
  
  @Nullable
  public CallableMemberDescriptor result()
  {
    return (CallableMemberDescriptor)this.$result.element;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.firstOverridden.2
 * JD-Core Version:    0.7.0.1
 */