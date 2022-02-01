package com.tencent.mobileqq.dating;

import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import java.util.Set;
import mqq.os.MqqHandler;

class StrangerHdHeadUrlFetcher$1
  implements Runnable
{
  StrangerHdHeadUrlFetcher$1(StrangerHdHeadUrlFetcher paramStrangerHdHeadUrlFetcher, String paramString1, int paramInt, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.a.getQQHeadSetting(32, this.a, this.b);
    boolean bool;
    if (localObject1 != null) {
      bool = ((Boolean)((Pair)localObject1).first).booleanValue();
    } else {
      bool = false;
    }
    if ((bool) && (this.c))
    {
      localObject1 = (IQQAvatarHandlerService)this.this$0.a.getRuntimeService(IQQAvatarHandlerService.class, "");
      if (localObject1 != null)
      {
        this.this$0.f = System.currentTimeMillis();
        synchronized (StrangerHdHeadUrlFetcher.a(this.this$0))
        {
          if (!this.this$0.e)
          {
            this.this$0.e = true;
            this.this$0.a.addObserver(StrangerHdHeadUrlFetcher.a(this.this$0), true);
          }
          synchronized (this.this$0.c)
          {
            this.this$0.c.add(this.d);
            ((IQQAvatarHandlerService)localObject1).getStrangerHead(this.a, this.b, (byte)1, (byte)2);
            if (this.this$0.g.hasMessages(1)) {
              return;
            }
            this.this$0.g.sendEmptyMessageDelayed(1, 60000L);
            return;
          }
        }
      }
      DatingUtil.a("StrangerHdHeadUrlFetcher", new Object[] { "flh is null" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.StrangerHdHeadUrlFetcher.1
 * JD-Core Version:    0.7.0.1
 */