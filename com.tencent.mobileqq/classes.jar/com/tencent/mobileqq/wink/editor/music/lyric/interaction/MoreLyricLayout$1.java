package com.tencent.mobileqq.wink.editor.music.lyric.interaction;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MoreLyricLayout$1
  implements View.OnClickListener
{
  MoreLyricLayout$1(MoreLyricLayout paramMoreLyricLayout) {}
  
  public void onClick(View paramView)
  {
    MoreLyricLayout.a(this.a).setPanelState(WinkSlidingUpPanelLayout.PanelState.COLLAPSED);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.interaction.MoreLyricLayout.1
 * JD-Core Version:    0.7.0.1
 */