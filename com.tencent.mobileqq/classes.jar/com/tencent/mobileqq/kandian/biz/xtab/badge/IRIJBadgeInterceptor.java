package com.tencent.mobileqq.kandian.biz.xtab.badge;

import com.tencent.mobileqq.data.MessageRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/badge/IRIJBadgeInterceptor;", "", "onNotifyBadgeMsg", "", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "onReceiveBadgeMsg", "onSaveBadgeMsg", "", "shouldIntercept", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJBadgeInterceptor
{
  public static final IRIJBadgeInterceptor.Companion a = IRIJBadgeInterceptor.Companion.a;
  
  public abstract boolean a(@NotNull MessageRecord paramMessageRecord);
  
  public abstract boolean b(@NotNull MessageRecord paramMessageRecord);
  
  public abstract int c(@NotNull MessageRecord paramMessageRecord);
  
  public abstract boolean d(@NotNull MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.badge.IRIJBadgeInterceptor
 * JD-Core Version:    0.7.0.1
 */