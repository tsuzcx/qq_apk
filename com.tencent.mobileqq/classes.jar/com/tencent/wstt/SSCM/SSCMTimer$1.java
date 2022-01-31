package com.tencent.wstt.SSCM;

import bgan;
import bgao;
import bgap;
import java.util.TimerTask;

public class SSCMTimer$1
  extends TimerTask
{
  public void run()
  {
    long l;
    int i;
    if (bgan.a(this.this$0))
    {
      l = Long.parseLong(bgap.a());
      if (l == -1L)
      {
        bgan.a(this.this$0, false);
        i = 0;
      }
    }
    for (;;)
    {
      if (i > 0) {
        bgan.a(this.this$0, 0);
      }
      do
      {
        do
        {
          return;
          i = (int)(l - bgan.a(this.this$0));
          bgan.a(this.this$0, l);
          break;
          bgan.a(this.this$0, bgan.a(this.this$0) + bgan.b(this.this$0));
        } while (bgan.a(this.this$0) < 120000);
        bgan.b(this.this$0, 1);
        cancel();
      } while (bgan.a(this.this$0) == null);
      bgan.a(this.this$0).b(bgan.a(this.this$0));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.wstt.SSCM.SSCMTimer.1
 * JD-Core Version:    0.7.0.1
 */