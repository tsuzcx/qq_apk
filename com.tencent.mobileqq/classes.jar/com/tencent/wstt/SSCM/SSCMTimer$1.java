package com.tencent.wstt.SSCM;

import bjyx;
import bjyy;
import bjyz;
import java.util.TimerTask;

public class SSCMTimer$1
  extends TimerTask
{
  public void run()
  {
    long l;
    int i;
    if (bjyx.a(this.this$0))
    {
      l = Long.parseLong(bjyz.a());
      if (l == -1L)
      {
        bjyx.a(this.this$0, false);
        i = 0;
      }
    }
    for (;;)
    {
      if (i > 0) {
        bjyx.a(this.this$0, 0);
      }
      do
      {
        do
        {
          return;
          i = (int)(l - bjyx.a(this.this$0));
          bjyx.a(this.this$0, l);
          break;
          bjyx.a(this.this$0, bjyx.a(this.this$0) + bjyx.b(this.this$0));
        } while (bjyx.a(this.this$0) < 120000);
        bjyx.b(this.this$0, 1);
        cancel();
      } while (bjyx.a(this.this$0) == null);
      bjyx.a(this.this$0).a(bjyx.a(this.this$0));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.wstt.SSCM.SSCMTimer.1
 * JD-Core Version:    0.7.0.1
 */