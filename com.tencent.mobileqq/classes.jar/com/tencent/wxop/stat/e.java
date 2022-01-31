package com.tencent.wxop.stat;

import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.common.l;
import java.util.TimerTask;

class e
  extends TimerTask
{
  e(d paramd) {}
  
  public void run()
  {
    if (StatConfig.isDebugEnable()) {
      l.b().i("TimerTask run");
    }
    StatServiceImpl.e(d.a(this.a));
    cancel();
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.e
 * JD-Core Version:    0.7.0.1
 */