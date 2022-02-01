package com.tencent.mobileqq.vas.adv.web.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Subscriber;", "", "onVasEvent", "", "eventKey", "", "callback", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Callback;", "data", "", "(Ljava/lang/String;Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Callback;[Ljava/lang/Object;)V", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public abstract interface VasAdvWebEvent$Subscriber
{
  public abstract void onVasEvent(@NotNull String paramString, @Nullable VasAdvWebEvent.Callback paramCallback, @NotNull Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Subscriber
 * JD-Core Version:    0.7.0.1
 */