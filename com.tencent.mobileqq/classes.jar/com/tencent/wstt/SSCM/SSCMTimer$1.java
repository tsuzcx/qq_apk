package com.tencent.wstt.SSCM;

import best;
import besu;
import besv;
import java.util.TimerTask;

public class SSCMTimer$1
  extends TimerTask
{
  public void run()
  {
    long l;
    int i;
    if (best.a(this.this$0))
    {
      l = Long.parseLong(besv.a());
      if (l == -1L)
      {
        best.a(this.this$0, false);
        i = 0;
      }
    }
    for (;;)
    {
      if (i > 0) {
        best.a(this.this$0, 0);
      }
      do
      {
        do
        {
          return;
          i = (int)(l - best.a(this.this$0));
          best.a(this.this$0, l);
          break;
          best.a(this.this$0, best.a(this.this$0) + best.b(this.this$0));
        } while (best.a(this.this$0) < 120000);
        best.b(this.this$0, 1);
        cancel();
      } while (best.a(this.this$0) == null);
      best.a(this.this$0).b(best.a(this.this$0));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.wstt.SSCM.SSCMTimer.1
 * JD-Core Version:    0.7.0.1
 */