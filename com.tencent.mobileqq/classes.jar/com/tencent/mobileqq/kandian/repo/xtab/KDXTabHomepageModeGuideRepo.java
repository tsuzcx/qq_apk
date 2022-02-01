package com.tencent.mobileqq.kandian.repo.xtab;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/xtab/KDXTabHomepageModeGuideRepo;", "", "()V", "getLastShownTimestamp", "", "getRemoteConfig", "Lcom/tencent/mobileqq/kandian/repo/xtab/KDXTabHomepageModeGuideRepo$KDXTabHomepageModeGuideRemoteConfig;", "updateLastShownTimestamp", "", "timestamp", "Companion", "KDXTabHomepageModeGuideRemoteConfig", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KDXTabHomepageModeGuideRepo
{
  public static final KDXTabHomepageModeGuideRepo.Companion a = new KDXTabHomepageModeGuideRepo.Companion(null);
  
  @NotNull
  public final KDXTabHomepageModeGuideRepo.KDXTabHomepageModeGuideRemoteConfig a()
  {
    return new KDXTabHomepageModeGuideRepo.KDXTabHomepageModeGuideRemoteConfig();
  }
  
  public final void a(long paramLong)
  {
    RIJSPUtils.a("LAST_SHOWN_HOMEPAGE_MODE_GUIDE_TIMESTAMP", Long.valueOf(paramLong));
  }
  
  public final long b()
  {
    Object localObject = RIJSPUtils.b("LAST_SHOWN_HOMEPAGE_MODE_GUIDE_TIMESTAMP", Long.valueOf(-1L));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJSPUtils.getReadInJoyS…ODE_GUIDE_TIMESTAMP, -1L)");
    return ((Number)localObject).longValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.xtab.KDXTabHomepageModeGuideRepo
 * JD-Core Version:    0.7.0.1
 */