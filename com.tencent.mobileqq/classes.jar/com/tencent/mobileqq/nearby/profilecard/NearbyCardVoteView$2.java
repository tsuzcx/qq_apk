package com.tencent.mobileqq.nearby.profilecard;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.profile.like.PraiseManager.OnPraiseLoadListener;
import java.util.List;

class NearbyCardVoteView$2
  implements PraiseManager.OnPraiseLoadListener
{
  NearbyCardVoteView$2(NearbyCardVoteView paramNearbyCardVoteView, int paramInt1, int paramInt2, List paramList) {}
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    if (this.d.o.hasMessages(NearbyCardVoteView.n))
    {
      this.d.o.removeMessages(NearbyCardVoteView.n);
      this.d.o.obtainMessage(NearbyCardVoteView.n, this.a, this.b, this.c).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyCardVoteView.2
 * JD-Core Version:    0.7.0.1
 */