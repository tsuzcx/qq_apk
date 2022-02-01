package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds;

import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsDynamicInsertController$IWatchInfoCallback;", "", "getWatchInfo", "", "rowKey", "", "action", "Lcom/tencent/mobileqq/kandian/repo/feeds/RIJFeedsInsertAction;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface RIJFeedsDynamicInsertController$IWatchInfoCallback
{
  public abstract void a(@Nullable String paramString, @NotNull RIJFeedsInsertAction paramRIJFeedsInsertAction);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController.IWatchInfoCallback
 * JD-Core Version:    0.7.0.1
 */