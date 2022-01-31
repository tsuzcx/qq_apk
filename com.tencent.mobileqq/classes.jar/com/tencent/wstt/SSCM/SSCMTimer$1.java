package com.tencent.wstt.SSCM;

import bicb;
import bicc;
import bicd;
import java.util.TimerTask;

public class SSCMTimer$1
  extends TimerTask
{
  public void run()
  {
    long l;
    int i;
    if (bicb.a(this.this$0))
    {
      l = Long.parseLong(bicd.a());
      if (l == -1L)
      {
        bicb.a(this.this$0, false);
        i = 0;
      }
    }
    for (;;)
    {
      if (i > 0) {
        bicb.a(this.this$0, 0);
      }
      do
      {
        do
        {
          return;
          i = (int)(l - bicb.a(this.this$0));
          bicb.a(this.this$0, l);
          break;
          bicb.a(this.this$0, bicb.a(this.this$0) + bicb.b(this.this$0));
        } while (bicb.a(this.this$0) < 120000);
        bicb.b(this.this$0, 1);
        cancel();
      } while (bicb.a(this.this$0) == null);
      bicb.a(this.this$0).b(bicb.a(this.this$0));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.wstt.SSCM.SSCMTimer.1
 * JD-Core Version:    0.7.0.1
 */