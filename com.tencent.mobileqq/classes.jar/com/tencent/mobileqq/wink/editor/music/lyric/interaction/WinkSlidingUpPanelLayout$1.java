package com.tencent.mobileqq.wink.editor.music.lyric.interaction;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WinkSlidingUpPanelLayout$1
  implements View.OnClickListener
{
  WinkSlidingUpPanelLayout$1(WinkSlidingUpPanelLayout paramWinkSlidingUpPanelLayout) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.isEnabled()) && (this.a.a())) {
      if ((WinkSlidingUpPanelLayout.a(this.a) != WinkSlidingUpPanelLayout.PanelState.EXPANDED) && (WinkSlidingUpPanelLayout.a(this.a) != WinkSlidingUpPanelLayout.PanelState.ANCHORED))
      {
        if (WinkSlidingUpPanelLayout.b(this.a) < 1.0F) {
          this.a.setPanelState(WinkSlidingUpPanelLayout.PanelState.ANCHORED);
        } else {
          this.a.setPanelState(WinkSlidingUpPanelLayout.PanelState.EXPANDED);
        }
      }
      else {
        this.a.setPanelState(WinkSlidingUpPanelLayout.PanelState.COLLAPSED);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.interaction.WinkSlidingUpPanelLayout.1
 * JD-Core Version:    0.7.0.1
 */