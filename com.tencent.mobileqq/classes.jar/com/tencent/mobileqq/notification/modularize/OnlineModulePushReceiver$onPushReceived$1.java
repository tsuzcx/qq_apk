package com.tencent.mobileqq.notification.modularize;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class OnlineModulePushReceiver$onPushReceived$1
  extends Lambda
  implements Function0<Unit>
{
  OnlineModulePushReceiver$onPushReceived$1(OnlineModulePushReceiver paramOnlineModulePushReceiver, PushComponent paramPushComponent)
  {
    super(0);
  }
  
  public final void invoke()
  {
    OnlineModulePushReceiver.a(this.this$0, this.$pushComponent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.notification.modularize.OnlineModulePushReceiver.onPushReceived.1
 * JD-Core Version:    0.7.0.1
 */