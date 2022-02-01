package com.tencent.mobileqq.gamecenter.media;

import java.util.List;

class DanmakuLayout$1
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
    DanmakuHost.Item localItem = (DanmakuHost.Item)DanmakuLayout.a(this.this$0).get(0);
    if (localItem.a <= l)
    {
      DanmakuLayout.DrawItem localDrawItem = DanmakuLayout.a(this.this$0);
      localDrawItem.a(localItem);
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < DanmakuLayout.a(this.this$0).length)
        {
          if (DanmakuLayout.a(this.this$0)[i].a(localDrawItem))
          {
            DanmakuLayout.a(this.this$0).remove(0);
            this.this$0.invalidate();
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            localDrawItem.a();
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
    long l = Math.max(localItem.a - l, DanmakuLayout.a(this.this$0));
    DanmakuLayout.a(this.this$0, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.DanmakuLayout.1
 * JD-Core Version:    0.7.0.1
 */