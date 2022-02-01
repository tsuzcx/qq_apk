package com.tencent.mobileqq.dating;

import android.os.Message;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.profile.like.PraiseManager.OnPraiseLoadListener;
import mqq.os.MqqHandler;

class NewVoteAnimHelper$1
  implements PraiseManager.OnPraiseLoadListener
{
  NewVoteAnimHelper$1(NewVoteAnimHelper paramNewVoteAnimHelper, int paramInt) {}
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    if (this.b.c.hasMessages(0))
    {
      this.b.c.removeMessages(0);
      this.b.c.obtainMessage(0, this.a, 0).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NewVoteAnimHelper.1
 * JD-Core Version:    0.7.0.1
 */