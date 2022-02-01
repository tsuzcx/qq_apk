package com.tencent.mobileqq.vaswebviewplugin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.emoticonview.IEmoStoreWebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmojiUiPlugin$2
  implements View.OnClickListener
{
  EmojiUiPlugin$2(EmojiUiPlugin paramEmojiUiPlugin) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.this$0;
    ((EmojiUiPlugin)localObject).closeBtnClick = true;
    if ((((EmojiUiPlugin)localObject).mRuntime.f() instanceof IEmoStoreWebViewFragment))
    {
      localObject = (IEmoStoreWebViewFragment)this.this$0.mRuntime.f();
      ((IEmoStoreWebViewFragment)localObject).reportEmoStorePageCloseClickEvent();
      this.this$0.activity.finish();
      ((IEmoStoreWebViewFragment)localObject).doOnEmoStorePageFinshed(this.this$0.activity);
    }
    else
    {
      this.this$0.activity.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin.2
 * JD-Core Version:    0.7.0.1
 */