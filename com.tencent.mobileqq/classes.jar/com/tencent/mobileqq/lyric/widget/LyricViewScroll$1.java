package com.tencent.mobileqq.lyric.widget;

import android.util.Log;
import atsy;
import java.util.Timer;
import java.util.TimerTask;

class LyricViewScroll$1
  extends TimerTask
{
  int a;
  
  LyricViewScroll$1(LyricViewScroll paramLyricViewScroll) {}
  
  public void run()
  {
    Log.v("LyricViewScroll", "fling detect running");
    if (this.jdField_a_of_type_Int == this.this$0.getScrollY())
    {
      this.this$0.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      LyricViewScroll.a(this.this$0).b(this.jdField_a_of_type_Int);
      Log.d("LyricViewScroll", "fling stop");
      this.this$0.jdField_a_of_type_JavaUtilTimer.cancel();
      this.this$0.jdField_a_of_type_Boolean = false;
      LyricViewScroll.a(this.this$0, false);
      return;
    }
    this.jdField_a_of_type_Int = this.this$0.getScrollY();
    LyricViewScroll.a(this.this$0).a(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewScroll.1
 * JD-Core Version:    0.7.0.1
 */