package com.tencent.mobileqq.vaswebviewplugin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmojiUiPlugin$2
  implements View.OnClickListener
{
  EmojiUiPlugin$2(EmojiUiPlugin paramEmojiUiPlugin) {}
  
  public void onClick(View paramView)
  {
    this.this$0.closeBtnClick = true;
    this.this$0.activity.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin.2
 * JD-Core Version:    0.7.0.1
 */