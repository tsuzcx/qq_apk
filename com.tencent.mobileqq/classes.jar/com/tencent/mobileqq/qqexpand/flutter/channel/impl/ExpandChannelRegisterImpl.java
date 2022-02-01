package com.tencent.mobileqq.qqexpand.flutter.channel.impl;

import com.tencent.mobileqq.flutter.channel.BaseMethodChannel;
import com.tencent.mobileqq.qqexpand.flutter.channel.ExpandConfigChannel;
import com.tencent.mobileqq.qqexpand.flutter.channel.ExpandPushChannel;
import com.tencent.mobileqq.qqexpand.flutter.channel.IExpandChannelRegister;
import com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatApiChannel;
import com.tencent.mobileqq.qqexpand.flutter.channel.redpoint.ExpandRedPointApiChannel;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodCodec;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/flutter/channel/impl/ExpandChannelRegisterImpl;", "Lcom/tencent/mobileqq/qqexpand/flutter/channel/IExpandChannelRegister;", "()V", "mExpandRedPointApiChannel", "Lcom/tencent/mobileqq/qqexpand/flutter/channel/redpoint/ExpandRedPointApiChannel;", "registerChannel", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "registeredChannels", "", "", "registerMethodChannel", "baseChannel", "Lcom/tencent/mobileqq/flutter/channel/BaseMethodChannel;", "Ljava/util/LinkedList;", "unRegisterChannel", "Companion", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandChannelRegisterImpl
  implements IExpandChannelRegister
{
  public static final ExpandChannelRegisterImpl.Companion Companion = new ExpandChannelRegisterImpl.Companion(null);
  @NotNull
  public static final String TAG = "ExpandChannelRegisterImpl";
  private final ExpandRedPointApiChannel mExpandRedPointApiChannel = new ExpandRedPointApiChannel();
  
  private final void registerMethodChannel(BinaryMessenger paramBinaryMessenger, BaseMethodChannel paramBaseMethodChannel, LinkedList<Object> paramLinkedList)
  {
    MethodCodec localMethodCodec = paramBaseMethodChannel.b();
    String str = paramBaseMethodChannel.a();
    new MethodChannel(paramBinaryMessenger, str, localMethodCodec).setMethodCallHandler(paramBaseMethodChannel.c());
    paramLinkedList.add(paramBaseMethodChannel);
    if (QLog.isColorLevel())
    {
      paramBinaryMessenger = new StringBuilder();
      paramBinaryMessenger.append("registerMethodChannel, channelName: ");
      paramBinaryMessenger.append(str);
      QLog.d("ExpandChannelRegisterImpl", 2, paramBinaryMessenger.toString());
    }
  }
  
  public void registerChannel(@NotNull BinaryMessenger paramBinaryMessenger, @NotNull List<? extends Object> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramBinaryMessenger, "binaryMessenger");
    Intrinsics.checkParameterIsNotNull(paramList, "registeredChannels");
    if (!(paramList instanceof LinkedList))
    {
      QLog.w("ExpandChannelRegisterImpl", 2, "registeredChannels not LinkedList");
      return;
    }
    BaseMethodChannel localBaseMethodChannel = (BaseMethodChannel)new ExpandConfigChannel();
    paramList = (LinkedList)paramList;
    registerMethodChannel(paramBinaryMessenger, localBaseMethodChannel, paramList);
    registerMethodChannel(paramBinaryMessenger, (BaseMethodChannel)new ExpandChatApiChannel(paramBinaryMessenger), paramList);
    registerMethodChannel(paramBinaryMessenger, (BaseMethodChannel)new ExpandPushChannel(paramBinaryMessenger), paramList);
    this.mExpandRedPointApiChannel.a(paramBinaryMessenger);
  }
  
  public void unRegisterChannel()
  {
    this.mExpandRedPointApiChannel.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.impl.ExpandChannelRegisterImpl
 * JD-Core Version:    0.7.0.1
 */