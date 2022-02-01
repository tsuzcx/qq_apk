package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SystemAndEmojiEmoticonPanelWithActionBar$1
  implements View.OnClickListener
{
  SystemAndEmojiEmoticonPanelWithActionBar$1(SystemAndEmojiEmoticonPanelWithActionBar paramSystemAndEmojiEmoticonPanelWithActionBar) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.mCallback != null) {
      this.this$0.mCallback.send();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanelWithActionBar.1
 * JD-Core Version:    0.7.0.1
 */