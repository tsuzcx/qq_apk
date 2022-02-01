package com.tencent.mobileqq.kandian.repo.feeds.api;

import android.content.Context;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/api/IRIJSubscriptionFeeds;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "clearUnreadMsg", "", "uin", "", "convertMsgToSubscriptionFeed", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SubscriptionFeed;", "context", "Landroid/content/Context;", "latestMessage", "Lcom/tencent/mobileqq/data/MessageRecord;", "lastMsgTime", "", "lastDraftTime", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJSubscriptionFeeds
  extends QRouteApi
{
  public abstract boolean clearUnreadMsg(@Nullable String paramString);
  
  @Nullable
  public abstract SubscriptionFeed convertMsgToSubscriptionFeed(@Nullable Context paramContext, @Nullable MessageRecord paramMessageRecord, @Nullable String paramString, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.api.IRIJSubscriptionFeeds
 * JD-Core Version:    0.7.0.1
 */