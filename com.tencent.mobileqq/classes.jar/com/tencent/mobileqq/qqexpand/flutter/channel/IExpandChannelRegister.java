package com.tencent.mobileqq.qqexpand.flutter.channel;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/flutter/channel/IExpandChannelRegister;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "registerChannel", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "registeredChannels", "", "", "unRegisterChannel", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandChannelRegister
  extends QRouteApi
{
  public abstract void registerChannel(@NotNull BinaryMessenger paramBinaryMessenger, @NotNull List<? extends Object> paramList);
  
  public abstract void unRegisterChannel();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.IExpandChannelRegister
 * JD-Core Version:    0.7.0.1
 */