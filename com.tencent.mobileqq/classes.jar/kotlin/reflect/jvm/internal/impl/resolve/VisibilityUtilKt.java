package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.Iterator;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import org.jetbrains.annotations.NotNull;

public final class VisibilityUtilKt
{
  @NotNull
  public static final CallableMemberDescriptor findMemberWithMaxVisibility(@NotNull Collection<? extends CallableMemberDescriptor> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "descriptors");
    boolean bool = paramCollection.isEmpty();
    if ((_Assertions.ENABLED) && (!(bool ^ true))) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    CallableMemberDescriptor localCallableMemberDescriptor = (CallableMemberDescriptor)null;
    Iterator localIterator = paramCollection.iterator();
    for (paramCollection = localCallableMemberDescriptor; localIterator.hasNext(); paramCollection = localCallableMemberDescriptor)
    {
      label55:
      localCallableMemberDescriptor = (CallableMemberDescriptor)localIterator.next();
      if (paramCollection != null)
      {
        Integer localInteger = Visibilities.compare(paramCollection.getVisibility(), localCallableMemberDescriptor.getVisibility());
        if ((localInteger == null) || (localInteger.intValue() >= 0)) {
          break label55;
        }
      }
    }
    if (paramCollection == null) {
      Intrinsics.throwNpe();
    }
    return paramCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.VisibilityUtilKt
 * JD-Core Version:    0.7.0.1
 */