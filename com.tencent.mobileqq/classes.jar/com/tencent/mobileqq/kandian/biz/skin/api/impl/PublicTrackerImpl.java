package com.tencent.mobileqq.kandian.biz.skin.api.impl;

import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.kandian.biz.skin.api.IPublicTracker;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/skin/api/impl/PublicTrackerImpl;", "Lcom/tencent/mobileqq/kandian/biz/skin/api/IPublicTracker;", "()V", "trackAIO", "", "last", "", "next", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublicTrackerImpl
  implements IPublicTracker
{
  public void trackAIO(@Nullable String paramString1, @Nullable String paramString2)
  {
    PublicTracker.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.api.impl.PublicTrackerImpl
 * JD-Core Version:    0.7.0.1
 */