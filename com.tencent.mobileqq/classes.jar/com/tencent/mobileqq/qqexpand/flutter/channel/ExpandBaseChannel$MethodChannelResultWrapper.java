package com.tencent.mobileqq.qqexpand.flutter.channel;

import androidx.annotation.Nullable;
import io.flutter.plugin.common.MethodChannel.Result;
import java.lang.ref.WeakReference;

public class ExpandBaseChannel$MethodChannelResultWrapper
  implements MethodChannel.Result
{
  private final WeakReference<ExpandBaseChannel> a;
  private final String b;
  private final MethodChannel.Result c;
  
  public ExpandBaseChannel$MethodChannelResultWrapper(ExpandBaseChannel paramExpandBaseChannel, String paramString, MethodChannel.Result paramResult)
  {
    this.c = paramResult;
    this.a = new WeakReference(paramExpandBaseChannel);
    this.b = paramString;
  }
  
  public void error(String paramString1, @Nullable String paramString2, @Nullable Object paramObject)
  {
    this.c.error(paramString1, paramString2, paramObject);
    paramString1 = this.a;
    if (paramString1 != null) {
      ExpandChannelReportUtil.b(((ExpandBaseChannel)paramString1.get()).a(), this.b, "method");
    }
  }
  
  public void notImplemented()
  {
    this.c.notImplemented();
  }
  
  public void success(@Nullable Object paramObject)
  {
    this.c.success(paramObject);
    paramObject = this.a;
    if (paramObject != null) {
      ExpandChannelReportUtil.b(((ExpandBaseChannel)paramObject.get()).a(), this.b, "method");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.ExpandBaseChannel.MethodChannelResultWrapper
 * JD-Core Version:    0.7.0.1
 */