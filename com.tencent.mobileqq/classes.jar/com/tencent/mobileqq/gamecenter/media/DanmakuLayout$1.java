package com.tencent.mobileqq.gamecenter.media;

import java.util.List;

class DanmakuLayout$1
  implements Runnable
{
  DanmakuLayout$1(DanmakuLayout paramDanmakuLayout) {}
  
  public void run()
  {
    if (DanmakuLayout.a(this.this$0))
    {
      if (DanmakuLayout.b(this.this$0) == null) {
        return;
      }
      long l = DanmakuLayout.b(this.this$0).a();
      if (DanmakuLayout.c(this.this$0).size() > 0)
      {
        Object localObject = DanmakuLayout.c(this.this$0);
        int k = 0;
        localObject = (DanmakuHost.Item)((List)localObject).get(0);
        if (((DanmakuHost.Item)localObject).c <= l)
        {
          DanmakuLayout.DrawItem localDrawItem = DanmakuLayout.d(this.this$0);
          localDrawItem.a((DanmakuHost.Item)localObject);
          int i = 0;
          int j;
          for (;;)
          {
            j = k;
            if (i >= DanmakuLayout.e(this.this$0).length) {
              break;
            }
            if (DanmakuLayout.e(this.this$0)[i].a(localDrawItem))
            {
              DanmakuLayout.c(this.this$0).remove(0);
              this.this$0.invalidate();
              j = 1;
              break;
            }
            i += 1;
          }
          if (j == 0) {
            localDrawItem.a();
          }
          if (DanmakuLayout.c(this.this$0).size() > 0)
          {
            localObject = this.this$0;
            DanmakuLayout.a((DanmakuLayout)localObject, DanmakuLayout.f((DanmakuLayout)localObject));
          }
        }
        else
        {
          l = Math.max(((DanmakuHost.Item)localObject).c - l, DanmakuLayout.f(this.this$0));
          DanmakuLayout.a(this.this$0, l);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.DanmakuLayout.1
 * JD-Core Version:    0.7.0.1
 */