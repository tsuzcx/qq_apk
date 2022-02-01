package com.tencent.mobileqq.gamecenter.media;

import avde;
import avdf;
import avdg;
import avdi;
import java.util.List;

public class DanmakuLayout$1
  implements Runnable
{
  DanmakuLayout$1(DanmakuLayout paramDanmakuLayout) {}
  
  public void run()
  {
    int k = 0;
    if ((!DanmakuLayout.a(this.this$0)) || (DanmakuLayout.a(this.this$0) == null)) {}
    do
    {
      return;
      l = DanmakuLayout.a(this.this$0).a();
    } while (DanmakuLayout.a(this.this$0).size() <= 0);
    avde localavde = (avde)DanmakuLayout.a(this.this$0).get(0);
    if (localavde.a <= l)
    {
      avdg localavdg = DanmakuLayout.a(this.this$0);
      localavdg.a(localavde);
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < DanmakuLayout.a(this.this$0).length)
        {
          if (DanmakuLayout.a(this.this$0)[i].a(localavdg))
          {
            DanmakuLayout.a(this.this$0).remove(0);
            this.this$0.invalidate();
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            localavdg.a();
          }
          if (DanmakuLayout.a(this.this$0).size() <= 0) {
            break;
          }
          DanmakuLayout.a(this.this$0, DanmakuLayout.a(this.this$0));
          return;
        }
        i += 1;
      }
    }
    long l = Math.max(localavde.a - l, DanmakuLayout.a(this.this$0));
    DanmakuLayout.a(this.this$0, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.DanmakuLayout.1
 * JD-Core Version:    0.7.0.1
 */