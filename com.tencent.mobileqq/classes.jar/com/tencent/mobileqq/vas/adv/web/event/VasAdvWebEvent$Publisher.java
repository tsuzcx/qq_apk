package com.tencent.mobileqq.vas.adv.web.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Publisher;", "", "subscribe", "", "businessId", "", "subscriber", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Subscriber;", "unsubscribe", "unsubscribeAll", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public abstract interface VasAdvWebEvent$Publisher
{
  public abstract void subscribe(@NotNull String paramString, @NotNull VasAdvWebEvent.Subscriber paramSubscriber);
  
  public abstract void unsubscribe(@NotNull String paramString, @NotNull VasAdvWebEvent.Subscriber paramSubscriber);
  
  public abstract void unsubscribeAll(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Publisher
 * JD-Core Version:    0.7.0.1
 */