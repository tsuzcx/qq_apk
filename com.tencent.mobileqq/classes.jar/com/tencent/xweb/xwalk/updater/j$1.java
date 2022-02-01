package com.tencent.xweb.xwalk.updater;

import java.util.TimerTask;
import org.xwalk.core.XWalkInitializer;

class j$1
  extends TimerTask
{
  j$1(j paramj) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("task retry execute ! mRetrytimes = ");
    localStringBuilder.append(j.a(this.a));
    XWalkInitializer.addXWalkInitializeLog(localStringBuilder.toString());
    j.a(j.b(this.a), j.c(this.a), j.a(this.a));
    j.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.j.1
 * JD-Core Version:    0.7.0.1
 */