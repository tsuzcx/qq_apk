package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LyricWithBuoyView$3
  implements View.OnClickListener
{
  LyricWithBuoyView$3(LyricWithBuoyView paramLyricWithBuoyView) {}
  
  public void onClick(View paramView)
  {
    AEQLog.a("LyricWithBuoyView", "LyricWithBuoyView onClick()");
    if (LyricWithBuoyView.a(this.a) != null) {
      LyricWithBuoyView.a(this.a).a();
    } else {
      AEQLog.a("LyricWithBuoyView", "onClick() mOnLyricWithBuoyViewOperationListener == null.");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricWithBuoyView.3
 * JD-Core Version:    0.7.0.1
 */