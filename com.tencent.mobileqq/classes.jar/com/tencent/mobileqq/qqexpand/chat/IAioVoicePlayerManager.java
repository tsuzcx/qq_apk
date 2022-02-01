package com.tencent.mobileqq.qqexpand.chat;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/chat/IAioVoicePlayerManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "stopAll", "", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IAioVoicePlayerManager
  extends QRouteApi
{
  public abstract void stopAll();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.IAioVoicePlayerManager
 * JD-Core Version:    0.7.0.1
 */