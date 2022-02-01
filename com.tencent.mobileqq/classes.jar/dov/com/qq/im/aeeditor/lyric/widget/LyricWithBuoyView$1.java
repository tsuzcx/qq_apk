package dov.com.qq.im.aeeditor.lyric.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class LyricWithBuoyView$1
  extends Handler
{
  LyricWithBuoyView$1(LyricWithBuoyView paramLyricWithBuoyView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.widget.LyricWithBuoyView.1
 * JD-Core Version:    0.7.0.1
 */