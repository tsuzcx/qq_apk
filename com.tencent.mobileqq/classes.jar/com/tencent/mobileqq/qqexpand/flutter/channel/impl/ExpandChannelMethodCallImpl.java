package com.tencent.mobileqq.qqexpand.flutter.channel.impl;

import com.tencent.mobileqq.qqexpand.flutter.channel.ExpandConfigChannelHandler;
import com.tencent.mobileqq.qqexpand.flutter.channel.ExpandPushChannel;
import com.tencent.mobileqq.qqexpand.flutter.channel.IExpandChannelCallback;
import com.tencent.mobileqq.qqexpand.flutter.channel.IExpandChannelMethodCall;
import com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatApiChannel;
import com.tencent.mobileqq.qqexpand.flutter.channel.redpoint.ExpandRedPointApi;
import com.tencent.mobileqq.qqexpand.flutter.channel.redpoint.ExpandRedPointApiChannel;
import com.tencent.mobileqq.qqexpand.flutter.channel.redpoint.ExpandRedPointApiChannel.MethodCallHandler;
import com.tencent.mobileqq.qqexpand.flutter.channel.redpoint.ExpandRedPointApiChannel.MethodCallHandler.Companion;
import io.flutter.plugin.common.MethodCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/flutter/channel/impl/ExpandChannelMethodCallImpl;", "Lcom/tencent/mobileqq/qqexpand/flutter/channel/IExpandChannelMethodCall;", "()V", "mRedPointApiChannel", "Lcom/tencent/mobileqq/qqexpand/flutter/channel/redpoint/ExpandRedPointApiChannel;", "onMethodCall", "", "channel", "", "method", "arguments", "", "callback", "Lcom/tencent/mobileqq/qqexpand/flutter/channel/IExpandChannelCallback;", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandChannelMethodCallImpl
  implements IExpandChannelMethodCall
{
  private final ExpandRedPointApiChannel mRedPointApiChannel = new ExpandRedPointApiChannel();
  
  public void onMethodCall(@NotNull String paramString1, @NotNull String paramString2, @Nullable Object paramObject, @NotNull IExpandChannelCallback paramIExpandChannelCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "channel");
    Intrinsics.checkParameterIsNotNull(paramString2, "method");
    Intrinsics.checkParameterIsNotNull(paramIExpandChannelCallback, "callback");
    switch (paramString1.hashCode())
    {
    default: 
    case 1630205532: 
      if (paramString1.equals("com.tencent.qflutter/expand/method.expand_red_dot"))
      {
        ExpandRedPointApiChannel.MethodCallHandler.a.a((ExpandRedPointApi)this.mRedPointApiChannel, new MethodCall(paramString2, paramObject), paramIExpandChannelCallback);
        return;
      }
      break;
    case -142428935: 
      if (paramString1.equals("com.tencent.qflutter/expand/method.expand_push"))
      {
        ExpandPushChannel.a(new MethodCall(paramString2, paramObject), paramIExpandChannelCallback);
        return;
      }
      break;
    case -142829257: 
      if (paramString1.equals("com.tencent.qflutter/expand/method.expand_chat"))
      {
        ExpandChatApiChannel.a(new MethodCall(paramString2, paramObject), paramIExpandChannelCallback);
        return;
      }
      break;
    case -1805174872: 
      if (paramString1.equals("com.tencent.qflutter/expand/method.config")) {
        ExpandConfigChannelHandler.a(new MethodCall(paramString2, paramObject), paramIExpandChannelCallback);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.impl.ExpandChannelMethodCallImpl
 * JD-Core Version:    0.7.0.1
 */