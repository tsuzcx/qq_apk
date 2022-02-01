package com.tencent.mobileqq.qqexpand.flutter.channel;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/flutter/channel/IExpandChannelMethodCall;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "onMethodCall", "", "channel", "", "method", "arguments", "", "callback", "Lcom/tencent/mobileqq/qqexpand/flutter/channel/IExpandChannelCallback;", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandChannelMethodCall
  extends QRouteApi
{
  public abstract void onMethodCall(@NotNull String paramString1, @NotNull String paramString2, @Nullable Object paramObject, @NotNull IExpandChannelCallback paramIExpandChannelCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.IExpandChannelMethodCall
 * JD-Core Version:    0.7.0.1
 */