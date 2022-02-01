package com.tencent.mobileqq.kandian.biz.xtab.badge;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.IRIJBadgeInterceptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/badge/RIJBadgeInterceptorWrapper;", "Lcom/tencent/mobileqq/kandian/glue/businesshandler/engine/IRIJBadgeInterceptor;", "interceptor", "(Lcom/tencent/mobileqq/kandian/glue/businesshandler/engine/IRIJBadgeInterceptor;)V", "onNotifyBadgeMsg", "", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "onReceiveBadgeMsg", "onSaveBadgeMsg", "", "shouldIntercept", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJBadgeInterceptorWrapper
  implements IRIJBadgeInterceptor
{
  private final IRIJBadgeInterceptor a;
  
  public RIJBadgeInterceptorWrapper(@Nullable IRIJBadgeInterceptor paramIRIJBadgeInterceptor)
  {
    this.a = paramIRIJBadgeInterceptor;
  }
  
  public int a(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    IRIJBadgeInterceptor localIRIJBadgeInterceptor = this.a;
    if (localIRIJBadgeInterceptor != null) {
      return localIRIJBadgeInterceptor.a(paramMessageRecord);
    }
    return 0;
  }
  
  public boolean a(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    IRIJBadgeInterceptor localIRIJBadgeInterceptor = this.a;
    return (localIRIJBadgeInterceptor != null) && (localIRIJBadgeInterceptor.a(paramMessageRecord) == true);
  }
  
  public boolean b(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    IRIJBadgeInterceptor localIRIJBadgeInterceptor = this.a;
    return (localIRIJBadgeInterceptor != null) && (localIRIJBadgeInterceptor.b(paramMessageRecord) == true);
  }
  
  public boolean c(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    IRIJBadgeInterceptor localIRIJBadgeInterceptor = this.a;
    return (localIRIJBadgeInterceptor != null) && (localIRIJBadgeInterceptor.c(paramMessageRecord) == true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.badge.RIJBadgeInterceptorWrapper
 * JD-Core Version:    0.7.0.1
 */