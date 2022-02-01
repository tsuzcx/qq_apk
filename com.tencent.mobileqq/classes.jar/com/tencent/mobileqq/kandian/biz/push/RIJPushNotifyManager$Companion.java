package com.tencent.mobileqq.kandian.biz.push;

import kotlin.Lazy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/push/RIJPushNotifyManager$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mobileqq/kandian/biz/push/RIJPushNotifyManager;", "instance$annotations", "getInstance", "()Lcom/tencent/mobileqq/kandian/biz/push/RIJPushNotifyManager;", "instance$delegate", "Lkotlin/Lazy;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPushNotifyManager$Companion
{
  @NotNull
  public final RIJPushNotifyManager a()
  {
    Lazy localLazy = RIJPushNotifyManager.access$getInstance$cp();
    Companion localCompanion = RIJPushNotifyManager.Companion;
    return (RIJPushNotifyManager)localLazy.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager.Companion
 * JD-Core Version:    0.7.0.1
 */