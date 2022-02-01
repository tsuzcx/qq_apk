package com.tencent.qflutter;

import android.content.Context;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class TextPlatformViewFactory
  extends PlatformViewFactory
{
  public TextPlatformViewFactory(MessageCodec<Object> paramMessageCodec)
  {
    super(paramMessageCodec);
  }
  
  public PlatformView create(Context paramContext, int paramInt, Object paramObject)
  {
    return new TextPlatformViewFactory.TextPlatformView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qflutter.TextPlatformViewFactory
 * JD-Core Version:    0.7.0.1
 */