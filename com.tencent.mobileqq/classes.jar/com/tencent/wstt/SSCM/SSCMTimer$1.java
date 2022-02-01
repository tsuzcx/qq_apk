package com.tencent.wstt.SSCM;

import blux;
import bluy;
import bluz;
import java.util.TimerTask;

public class SSCMTimer$1
  extends TimerTask
{
  public void run()
  {
    long l;
    int i;
    if (blux.a(this.this$0))
    {
      l = Long.parseLong(bluz.a());
      if (l == -1L)
      {
        blux.a(this.this$0, false);
        i = 0;
      }
    }
    for (;;)
    {
      if (i > 0) {
        blux.a(this.this$0, 0);
      }
      do
      {
        do
        {
          return;
          i = (int)(l - blux.a(this.this$0));
          blux.a(this.this$0, l);
          break;
          blux.a(this.this$0, blux.a(this.this$0) + blux.b(this.this$0));
        } while (blux.a(this.this$0) < 120000);
        blux.b(this.this$0, 1);
        cancel();
      } while (blux.a(this.this$0) == null);
      blux.a(this.this$0).a(blux.a(this.this$0));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.wstt.SSCM.SSCMTimer.1
 * JD-Core Version:    0.7.0.1
 */