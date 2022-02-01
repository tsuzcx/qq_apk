package com.tencent.mobileqq.vaswebviewplugin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.emoticonview.EmoStoreWebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmojiUiPlugin$2
  implements View.OnClickListener
{
  EmojiUiPlugin$2(EmojiUiPlugin paramEmojiUiPlugin) {}
  
  public void onClick(View paramView)
  {
    this.this$0.closeBtnClick = true;
    if ((this.this$0.mRuntime.a() instanceof EmoStoreWebViewFragment))
    {
      EmoStoreWebViewFragment localEmoStoreWebViewFragment = (EmoStoreWebViewFragment)this.this$0.mRuntime.a();
      localEmoStoreWebViewFragment.reportEmoStorePageCloseClickEvent();
      this.this$0.activity.finish();
      localEmoStoreWebViewFragment.doOnEmoStorePageFinshed(this.this$0.activity);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.activity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin.2
 * JD-Core Version:    0.7.0.1
 */