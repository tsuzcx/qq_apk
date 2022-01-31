package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.view.View;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.Map;

public final class WebViewFactory
  extends PlatformViewFactory
{
  private final View containerView;
  private final BinaryMessenger messenger;
  
  WebViewFactory(BinaryMessenger paramBinaryMessenger, View paramView)
  {
    super(StandardMessageCodec.INSTANCE);
    this.messenger = paramBinaryMessenger;
    this.containerView = paramView;
  }
  
  public PlatformView create(Context paramContext, int paramInt, Object paramObject)
  {
    paramObject = (Map)paramObject;
    return new FlutterWebView(paramContext, this.messenger, paramInt, paramObject, this.containerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.WebViewFactory
 * JD-Core Version:    0.7.0.1
 */