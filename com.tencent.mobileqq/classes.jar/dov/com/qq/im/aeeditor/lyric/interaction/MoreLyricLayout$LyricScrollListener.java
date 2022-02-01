package dov.com.qq.im.aeeditor.lyric.interaction;

import android.widget.TextView;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.lyric.widget.LyricScrollHelper.LyricScrollListener;
import dov.com.qq.im.aeeditor.lyric.widget.LyricWithBuoyView;

class MoreLyricLayout$LyricScrollListener
  implements LyricScrollHelper.LyricScrollListener
{
  private MoreLyricLayout$LyricScrollListener(MoreLyricLayout paramMoreLyricLayout) {}
  
  public void a(long paramLong)
  {
    AEQLog.a("MoreLyricLayout", "onScroll() position => " + paramLong);
    MoreLyricLayout.a(this.a);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    MoreLyricLayout.a(this.a, paramLong1);
    String str = LyricWithBuoyView.a((int)paramLong1);
    TextView localTextView = null;
    if (MoreLyricLayout.a(this.a) != null) {
      localTextView = MoreLyricLayout.a(this.a).a();
    }
    if (localTextView != null) {
      localTextView.setText(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.interaction.MoreLyricLayout.LyricScrollListener
 * JD-Core Version:    0.7.0.1
 */