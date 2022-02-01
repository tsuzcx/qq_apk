package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback;
import cooperation.ilive.lite.event.IliveLiteEventCenter;

class QQIliveJsPlugin$3
  implements OnQueryGiftIconCallback
{
  QQIliveJsPlugin$3(QQIliveJsPlugin paramQQIliveJsPlugin, String paramString) {}
  
  public void onFailed(int paramInt, String paramString)
  {
    QQIliveJsPlugin.access$400(this.this$0, paramInt, paramString, this.val$callback);
  }
  
  public void onSuccess(boolean paramBoolean1, boolean paramBoolean2)
  {
    Bundle localBundle = new Bundle();
    QQIliveJsPlugin.access$400(this.this$0, paramBoolean1 ^ true, "", this.val$callback);
    QQIliveJsPlugin.access$502(this.this$0, paramBoolean2);
    localBundle.putBoolean("canShow", paramBoolean1);
    localBundle.putBoolean("isSpecialAnchor", paramBoolean2);
    IliveLiteEventCenter.a().a("ACTION_WEBVIEW_NEED_SHOW_GIFT_ICON", localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */