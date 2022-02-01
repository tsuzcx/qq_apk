package com.tencent.wstt.SSCM;

import java.util.TimerTask;

class SSCMTimer$1
  extends TimerTask
{
  public void run()
  {
    if (SSCMTimer.a(this.this$0))
    {
      long l = Long.parseLong(Utils.a());
      if (l == -1L)
      {
        SSCMTimer.a(this.this$0, false);
      }
      else
      {
        i = (int)(l - SSCMTimer.b(this.this$0));
        SSCMTimer.a(this.this$0, l);
        break label62;
      }
    }
    int i = 0;
    label62:
    if (i > 0)
    {
      SSCMTimer.a(this.this$0, 0);
      return;
    }
    SSCMTimer localSSCMTimer = this.this$0;
    SSCMTimer.a(localSSCMTimer, SSCMTimer.c(localSSCMTimer) + SSCMTimer.d(this.this$0));
    if (SSCMTimer.c(this.this$0) >= 120000)
    {
      SSCMTimer.b(this.this$0, 1);
      cancel();
      if (SSCMTimer.e(this.this$0) != null) {
        SSCMTimer.e(this.this$0).a(SSCMTimer.f(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wstt.SSCM.SSCMTimer.1
 * JD-Core Version:    0.7.0.1
 */