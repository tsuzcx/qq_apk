package com.tencent.mobileqq.qqexpand.flutter.channel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/flutter/channel/IExpandChannelCallback;", "", "error", "", "errorCode", "", "errorMsg", "errorDetails", "notImplemented", "success", "ret", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandChannelCallback
{
  public abstract void error(@NotNull String paramString1, @Nullable String paramString2, @Nullable Object paramObject);
  
  public abstract void notImplemented();
  
  public abstract void success(@Nullable Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.IExpandChannelCallback
 * JD-Core Version:    0.7.0.1
 */