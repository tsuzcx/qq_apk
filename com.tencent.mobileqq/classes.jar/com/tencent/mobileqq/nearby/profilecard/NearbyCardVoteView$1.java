package com.tencent.mobileqq.nearby.profilecard;

import SummaryCard.TPraiseInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import java.util.List;

class NearbyCardVoteView$1
  extends Handler
{
  NearbyCardVoteView$1(NearbyCardVoteView paramNearbyCardVoteView) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int j = paramMessage.what;
    int k = NearbyCardVoteView.m;
    int i = 0;
    if (j == k)
    {
      j = paramMessage.arg1;
      if (paramMessage.arg2 > 0) {
        i = 2;
      }
      this.a.a(j, i);
      return;
    }
    if (paramMessage.what == NearbyCardVoteView.n)
    {
      int m = paramMessage.arg1;
      int n = paramMessage.arg2;
      Object localObject = (List)paramMessage.obj;
      paramMessage = (Message)localObject;
      if (localObject != null)
      {
        paramMessage = (Message)localObject;
        if (n < ((List)localObject).size()) {
          paramMessage = ((List)localObject).subList(0, n);
        }
      }
      paramMessage = PraiseConfigHelper.a(paramMessage);
      i = 0;
      while ((i < n) && (i < 20))
      {
        if ((paramMessage != null) && (i < paramMessage.size()))
        {
          k = (int)((TPraiseInfo)paramMessage.get(i)).uCustomId;
          j = ((TPraiseInfo)paramMessage.get(i)).iIsPayed;
        }
        else
        {
          j = 0;
          k = 0;
        }
        localObject = this.a.o.obtainMessage(NearbyCardVoteView.m, k, j);
        this.a.o.sendMessageDelayed((Message)localObject, (i + 2) * 500);
        i += 1;
      }
      paramMessage = this.a.getContext().getSharedPreferences("nearby_card_reddot_num", 0).edit();
      paramMessage.putInt("voteNum", m);
      paramMessage.putInt("increaseNum", n);
      paramMessage.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyCardVoteView.1
 * JD-Core Version:    0.7.0.1
 */