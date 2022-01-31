package io.flutter.plugins.webviewflutter;

import android.webkit.ValueCallback;
import io.flutter.plugin.common.MethodChannel.Result;

final class FlutterCookieManager$1
  implements ValueCallback<Boolean>
{
  FlutterCookieManager$1(MethodChannel.Result paramResult, boolean paramBoolean) {}
  
  public void onReceiveValue(Boolean paramBoolean)
  {
    this.val$result.success(Boolean.valueOf(this.val$hasCookies));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.FlutterCookieManager.1
 * JD-Core Version:    0.7.0.1
 */