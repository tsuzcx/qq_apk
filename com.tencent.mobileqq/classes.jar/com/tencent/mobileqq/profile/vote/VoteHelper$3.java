package com.tencent.mobileqq.profile.vote;

import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class VoteHelper$3
  implements Runnable
{
  VoteHelper$3(VoteHelper paramVoteHelper, String paramString, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    long l = Long.valueOf(this.a).longValue();
    EntityManager localEntityManager = this.this$0.c.getEntityManagerFactory().createEntityManager();
    Object localObject1 = Long.toString(l);
    int j = 0;
    CardProfile localCardProfile = (CardProfile)localEntityManager.find(CardProfile.class, "lEctID=? and type=?", new String[] { localObject1, Integer.toString(3) });
    boolean bool;
    if (localCardProfile != null) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onVoteOk, uin:");
      ((StringBuilder)localObject1).append(this.a);
      ((StringBuilder)localObject1).append(" voteNum:");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append("dbHas:");
      ((StringBuilder)localObject1).append(bool);
      QLog.i("VisitorsActivity.VoteHelper", 2, ((StringBuilder)localObject1).toString());
    }
    Pair localPair = (Pair)this.this$0.o.get(Long.valueOf(l));
    Object localObject6 = VoteHelper.m;
    int i = 0;
    for (;;)
    {
      try
      {
        int k = this.this$0.a.l.size();
        Object localObject5 = null;
        if (i < k)
        {
          localObject1 = (CardProfile)this.this$0.a.l.get(i);
          if ((localObject1 != null) && (((CardProfile)localObject1).lEctID == l))
          {
            if (localObject1 != null)
            {
              localObject5 = ((CardProfile)localObject1).clone();
              if (localPair != null)
              {
                ((CardProfile)localObject5).bAvailableCnt += ((AtomicInteger)localPair.second).get();
                ((CardProfile)localObject5).bTodayVotedCnt -= ((AtomicInteger)localPair.second).get();
              }
              ((CardProfile)localObject5).bVoteCnt = ((short)(int)((CardProfile)localObject5).bTodayVotedCnt);
            }
            if ((localObject5 != null) && ((!bool) || (localCardProfile.bTodayVotedCnt != ((CardProfile)localObject5).bTodayVotedCnt) || (localCardProfile.bAvailableCnt != ((CardProfile)localObject5).bAvailableCnt) || (localCardProfile.bVoteCnt != ((CardProfile)localObject5).bVoteCnt))) {
              if (((CardProfile)localObject5).getStatus() == 1000) {
                localEntityManager.persistOrReplace((Entity)localObject5);
              } else {
                localEntityManager.update((Entity)localObject5);
              }
            }
            if (this.c) {
              localObject1 = this.this$0.k;
            } else {
              localObject1 = this.this$0.l;
            }
            localObject5 = VoteHelper.n;
            i = 0;
            try
            {
              if (i >= ((ArrayList)localObject1).size()) {
                break label597;
              }
              if (((Long)((ArrayList)localObject1).get(i)).longValue() != l) {
                break label590;
              }
              i = j;
              if (i != 0) {
                ((ArrayList)localObject1).add(Long.valueOf(l));
              }
              if (i != 0)
              {
                localObject1 = new ArrayList();
                ((List)localObject1).addAll(this.this$0.k);
                ((List)localObject1).addAll(this.this$0.l);
                this.this$0.a.ah.b((List)localObject1);
              }
              return;
            }
            finally {}
          }
          continue;
        }
      }
      finally
      {
        continue;
        throw localObject3;
        continue;
        i += 1;
      }
      Object localObject4 = null;
      continue;
      label590:
      i += 1;
      continue;
      label597:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.vote.VoteHelper.3
 * JD-Core Version:    0.7.0.1
 */