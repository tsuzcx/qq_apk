package dov.com.qq.im.aeeditor.lyric.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

class LyricViewInternalBase$1
  extends Handler
{
  LyricViewInternalBase$1(LyricViewInternalBase paramLyricViewInternalBase, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Log.d("ModuleLyricViewInternal", "mRefreshHandler -> handleMessage begin, mState:" + this.a.l);
    this.a.requestLayout();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.widget.LyricViewInternalBase.1
 * JD-Core Version:    0.7.0.1
 */