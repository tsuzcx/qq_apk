package com.tencent.wstt.SSCM;

import blki;
import blkj;
import blkk;
import java.util.TimerTask;

public class SSCMTimer$1
  extends TimerTask
{
  public void run()
  {
    long l;
    int i;
    if (blki.a(this.this$0))
    {
      l = Long.parseLong(blkk.a());
      if (l == -1L)
      {
        blki.a(this.this$0, false);
        i = 0;
      }
    }
    for (;;)
    {
      if (i > 0) {
        blki.a(this.this$0, 0);
      }
      do
      {
        do
        {
          return;
          i = (int)(l - blki.a(this.this$0));
          blki.a(this.this$0, l);
          break;
          blki.a(this.this$0, blki.a(this.this$0) + blki.b(this.this$0));
        } while (blki.a(this.this$0) < 120000);
        blki.b(this.this$0, 1);
        cancel();
      } while (blki.a(this.this$0) == null);
      blki.a(this.this$0).a(blki.a(this.this$0));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.wstt.SSCM.SSCMTimer.1
 * JD-Core Version:    0.7.0.1
 */