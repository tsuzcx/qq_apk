package com.tencent.wstt.SSCM;

import java.util.TimerTask;

class SSCMTimer$1
  extends TimerTask
{
  public void run()
  {
    long l;
    int i;
    if (SSCMTimer.a(this.this$0))
    {
      l = Long.parseLong(Utils.a());
      if (l == -1L)
      {
        SSCMTimer.a(this.this$0, false);
        i = 0;
      }
    }
    for (;;)
    {
      if (i > 0) {
        SSCMTimer.a(this.this$0, 0);
      }
      do
      {
        do
        {
          return;
          i = (int)(l - SSCMTimer.a(this.this$0));
          SSCMTimer.a(this.this$0, l);
          break;
          SSCMTimer.a(this.this$0, SSCMTimer.a(this.this$0) + SSCMTimer.b(this.this$0));
        } while (SSCMTimer.a(this.this$0) < 120000);
        SSCMTimer.b(this.this$0, 1);
        cancel();
      } while (SSCMTimer.a(this.this$0) == null);
      SSCMTimer.a(this.this$0).a(SSCMTimer.a(this.this$0));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.wstt.SSCM.SSCMTimer.1
 * JD-Core Version:    0.7.0.1
 */