package com.tencent.wstt.SSCM;

import bktu;
import bktv;
import bktw;
import java.util.TimerTask;

public class SSCMTimer$1
  extends TimerTask
{
  public void run()
  {
    long l;
    int i;
    if (bktu.a(this.this$0))
    {
      l = Long.parseLong(bktw.a());
      if (l == -1L)
      {
        bktu.a(this.this$0, false);
        i = 0;
      }
    }
    for (;;)
    {
      if (i > 0) {
        bktu.a(this.this$0, 0);
      }
      do
      {
        do
        {
          return;
          i = (int)(l - bktu.a(this.this$0));
          bktu.a(this.this$0, l);
          break;
          bktu.a(this.this$0, bktu.a(this.this$0) + bktu.b(this.this$0));
        } while (bktu.a(this.this$0) < 120000);
        bktu.b(this.this$0, 1);
        cancel();
      } while (bktu.a(this.this$0) == null);
      bktu.a(this.this$0).a(bktu.a(this.this$0));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.wstt.SSCM.SSCMTimer.1
 * JD-Core Version:    0.7.0.1
 */