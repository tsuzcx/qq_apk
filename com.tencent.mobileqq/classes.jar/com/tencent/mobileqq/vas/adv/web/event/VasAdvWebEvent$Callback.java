package com.tencent.mobileqq.vas.adv.web.event;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Callback;", "", "onResult", "", "data", "errMsg", "", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public abstract interface VasAdvWebEvent$Callback
{
  public abstract void onResult(@Nullable Object paramObject, @Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Callback
 * JD-Core Version:    0.7.0.1
 */