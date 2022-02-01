package com.tencent.mobileqq.kandian.biz.reward.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.reward.aidl.RIJAidlClient;
import com.tencent.mobileqq.kandian.biz.reward.api.IRIJAidlClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/api/impl/RIJAidlClientImpl;", "Lcom/tencent/mobileqq/kandian/biz/reward/api/IRIJAidlClient;", "()V", "bindService", "", "context", "Landroid/content/Context;", "unbindService", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJAidlClientImpl
  implements IRIJAidlClient
{
  public void bindService(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    RIJAidlClient.a.a(paramContext);
  }
  
  public void unbindService(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    RIJAidlClient.a.b(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.api.impl.RIJAidlClientImpl
 * JD-Core Version:    0.7.0.1
 */