package com.tencent.wstt.SSCM;

import bgbe;
import bgbf;
import bgbg;
import java.util.TimerTask;

public class SSCMTimer$1
  extends TimerTask
{
  public void run()
  {
    long l;
    int i;
    if (bgbe.a(this.this$0))
    {
      l = Long.parseLong(bgbg.a());
      if (l == -1L)
      {
        bgbe.a(this.this$0, false);
        i = 0;
      }
    }
    for (;;)
    {
      if (i > 0) {
        bgbe.a(this.this$0, 0);
      }
      do
      {
        do
        {
          return;
          i = (int)(l - bgbe.a(this.this$0));
          bgbe.a(this.this$0, l);
          break;
          bgbe.a(this.this$0, bgbe.a(this.this$0) + bgbe.b(this.this$0));
        } while (bgbe.a(this.this$0) < 120000);
        bgbe.b(this.this$0, 1);
        cancel();
      } while (bgbe.a(this.this$0) == null);
      bgbe.a(this.this$0).b(bgbe.a(this.this$0));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.wstt.SSCM.SSCMTimer.1
 * JD-Core Version:    0.7.0.1
 */