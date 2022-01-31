package com.tencent.wstt.SSCM;

import bigi;
import bigj;
import bigk;
import java.util.TimerTask;

public class SSCMTimer$1
  extends TimerTask
{
  public void run()
  {
    long l;
    int i;
    if (bigi.a(this.this$0))
    {
      l = Long.parseLong(bigk.a());
      if (l == -1L)
      {
        bigi.a(this.this$0, false);
        i = 0;
      }
    }
    for (;;)
    {
      if (i > 0) {
        bigi.a(this.this$0, 0);
      }
      do
      {
        do
        {
          return;
          i = (int)(l - bigi.a(this.this$0));
          bigi.a(this.this$0, l);
          break;
          bigi.a(this.this$0, bigi.a(this.this$0) + bigi.b(this.this$0));
        } while (bigi.a(this.this$0) < 120000);
        bigi.b(this.this$0, 1);
        cancel();
      } while (bigi.a(this.this$0) == null);
      bigi.a(this.this$0).b(bigi.a(this.this$0));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.wstt.SSCM.SSCMTimer.1
 * JD-Core Version:    0.7.0.1
 */