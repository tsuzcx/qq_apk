package com.tencent.mobileqq.lyric.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class LyricViewInternal$1
  extends Handler
{
  LyricViewInternal$1(LyricViewInternal paramLyricViewInternal, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.requestLayout();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewInternal.1
 * JD-Core Version:    0.7.0.1
 */