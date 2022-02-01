package com.tencent.mobileqq.vas.adv.web;

import com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Subscriber;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Subscriber;", "invoke"}, k=3, mv={1, 1, 16})
final class VasAdvWebManager$unsubscribe$1
  extends Lambda
  implements Function1<WeakReference<VasAdvWebEvent.Subscriber>, Boolean>
{
  VasAdvWebManager$unsubscribe$1(VasAdvWebEvent.Subscriber paramSubscriber)
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull WeakReference<VasAdvWebEvent.Subscriber> paramWeakReference)
  {
    Intrinsics.checkParameterIsNotNull(paramWeakReference, "it");
    return Intrinsics.areEqual((VasAdvWebEvent.Subscriber)paramWeakReference.get(), this.$subscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.web.VasAdvWebManager.unsubscribe.1
 * JD-Core Version:    0.7.0.1
 */