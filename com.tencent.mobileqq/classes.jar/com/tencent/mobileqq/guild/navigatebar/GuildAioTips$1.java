package com.tencent.mobileqq.guild.navigatebar;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

class GuildAioTips$1
  extends GestureDetector.SimpleOnGestureListener
{
  GuildAioTips$1(GuildAioTips paramGuildAioTips) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isDevelopLevel())
    {
      paramMotionEvent1 = new StringBuilder();
      paramMotionEvent1.append("velocityY = ");
      paramMotionEvent1.append(paramFloat2);
      QLog.d("ScrollTest", 4, paramMotionEvent1.toString());
    }
    return false;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.navigatebar.GuildAioTips.1
 * JD-Core Version:    0.7.0.1
 */