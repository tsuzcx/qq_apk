package dov.com.qq.im.aeeditor.lyric.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.util.AEQLog;

class LyricWithBuoyView$3
  implements View.OnClickListener
{
  LyricWithBuoyView$3(LyricWithBuoyView paramLyricWithBuoyView) {}
  
  public void onClick(View paramView)
  {
    AEQLog.a("LyricWithBuoyView", "LyricWithBuoyView onClick()");
    if (LyricWithBuoyView.a(this.a) != null) {
      LyricWithBuoyView.a(this.a).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      AEQLog.a("LyricWithBuoyView", "onClick() mOnLyricWithBuoyViewOperationListener == null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.widget.LyricWithBuoyView.3
 * JD-Core Version:    0.7.0.1
 */