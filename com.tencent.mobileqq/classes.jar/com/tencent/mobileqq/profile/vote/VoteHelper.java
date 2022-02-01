package com.tencent.mobileqq.profile.vote;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.text.format.DateUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager.LikeItem;
import com.tencent.mobileqq.nearby.api.INearbyLikeLimitManagerUtil;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class VoteHelper
{
  public static final Object m = new Object();
  public static final Object n = new Object();
  public static String q = "sp_key_vote_max_friend";
  public static String r = "sp_key_vote_max_stranger";
  public static long s = -1L;
  VisitorsActivity a;
  Handler b;
  QQAppInterface c;
  int d;
  int e;
  public boolean f = false;
  long g;
  String h;
  String i;
  String j;
  ArrayList<Long> k = new ArrayList();
  ArrayList<Long> l = new ArrayList();
  public Map<Long, Pair<CardProfile, AtomicInteger>> o = new HashMap();
  public Map<Long, Pair<CardProfile, Pair<AtomicInteger, AtomicInteger>>> p = new HashMap();
  
  public VoteHelper(VisitorsActivity paramVisitorsActivity, Handler paramHandler, QQAppInterface paramQQAppInterface)
  {
    this.a = paramVisitorsActivity;
    this.b = paramHandler;
    this.c = paramQQAppInterface;
    s = -1L;
  }
  
  private void a(ArrayList<Long> paramArrayList)
  {
    this.l.clear();
    this.k.clear();
    Object localObject = (FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER);
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      if ((Long)paramArrayList.get(i1) != null) {
        if (((FriendsManager)localObject).n(Long.toString(((Long)paramArrayList.get(i1)).longValue()))) {
          this.k.add(paramArrayList.get(i1));
        } else {
          this.l.add(paramArrayList.get(i1));
        }
      }
      i1 += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fillTodayVoteArray ");
      ((StringBuilder)localObject).append(paramArrayList.size());
      ((StringBuilder)localObject).append(" friend:");
      ((StringBuilder)localObject).append(this.k.size());
      ((StringBuilder)localObject).append(" stranger:");
      ((StringBuilder)localObject).append(this.l.size());
      QLog.i("VisitorsActivity.VoteHelper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (s < 0L) {
      s = paramQQAppInterface.getPreferences().getLong("keyShowDoubleZanPopTime", 0L);
    }
    if (DateUtils.isToday(s)) {
      return false;
    }
    s = System.currentTimeMillis();
    paramQQAppInterface.getPreferences().edit().putLong("keyShowDoubleZanPopTime", s).commit();
    return true;
  }
  
  public int a(CardProfile paramCardProfile)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:806)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a()
  {
    this.d = b(q, 0);
    this.e = b(q, 0);
    ArrayList localArrayList = new ArrayList();
    this.a.ah.c(localArrayList);
    synchronized (n)
    {
      a(localArrayList);
      this.h = this.a.getResources().getString(2131897185);
      this.i = this.a.getResources().getString(2131897187);
      this.j = this.a.getResources().getString(2131897186);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    ThreadManager.postImmediately(new VoteHelper.4(this, paramLong), null, true);
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.a.ah.a(this.c.getCurrentAccountUin(), paramLong, paramInt);
  }
  
  public void a(CardProfile paramCardProfile, ImageView paramImageView, boolean paramBoolean)
  {
    short s1;
    int i1;
    Object localObject1;
    label800:
    label932:
    synchronized (m)
    {
      paramCardProfile.bAvailableCnt -= 1L;
      paramCardProfile.bTodayVotedCnt += 1L;
      if (paramCardProfile.type == 3)
      {
        paramCardProfile.bVoteCnt = ((short)(int)paramCardProfile.bTodayVotedCnt);
        paramCardProfile.dwLikeCustomId = PraiseManager.a(this.c);
        if (paramBoolean)
        {
          s1 = 0;
          paramCardProfile.bIsLastVoteCharged = s1;
          paramCardProfile.updateTime(System.currentTimeMillis() / 1000L);
          i1 = 0;
          if ((!paramBoolean) && (i1 == 0)) {
            paramCardProfile.payVoteCount = ((short)(paramCardProfile.payVoteCount + 1));
          }
          boolean bool = ((FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(Long.toString(paramCardProfile.lEctID));
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("doVote, uin=");
            ((StringBuilder)localObject1).append(paramCardProfile.lEctID);
            ((StringBuilder)localObject1).append(", isFriend=");
            ((StringBuilder)localObject1).append(bool);
            QLog.d("VisitorsActivity.VoteHelper", 2, ((StringBuilder)localObject1).toString());
          }
          if ((!bool) && (((INearbyLikeLimitManagerUtil)QRoute.api(INearbyLikeLimitManagerUtil.class)).isNeedNewLimitCheck(paramCardProfile.uSource)))
          {
            if (!this.p.containsKey(Long.valueOf(paramCardProfile.lEctID)))
            {
              localObject1 = new AtomicInteger(0);
              localObject2 = new AtomicInteger(0);
              Pair localPair = new Pair(localObject1, localObject2);
              this.p.put(Long.valueOf(paramCardProfile.lEctID), new Pair(paramCardProfile, localPair));
            }
            else
            {
              localObject2 = (Pair)((Pair)this.p.get(Long.valueOf(paramCardProfile.lEctID))).second;
              localObject1 = (AtomicInteger)((Pair)localObject2).first;
              localObject2 = (AtomicInteger)((Pair)localObject2).second;
            }
            if (paramBoolean)
            {
              ((AtomicInteger)localObject1).incrementAndGet();
              break label900;
            }
            ((AtomicInteger)localObject2).incrementAndGet();
            break label900;
          }
          if (!this.o.containsKey(Long.valueOf(paramCardProfile.lEctID)))
          {
            localObject1 = new AtomicInteger(0);
            this.o.put(Long.valueOf(paramCardProfile.lEctID), new Pair(paramCardProfile, localObject1));
          }
          else
          {
            localObject1 = (AtomicInteger)((Pair)this.o.get(Long.valueOf(paramCardProfile.lEctID))).second;
          }
          ((AtomicInteger)localObject1).incrementAndGet();
          break label900;
          if (i1 >= this.a.l.size()) {
            break label920;
          }
          Object localObject2 = (CardProfile)this.a.l.get(i1);
          if ((localObject2 == null) || (((CardProfile)localObject2).lEctID != paramCardProfile.lEctID)) {
            break label911;
          }
          ((CardProfile)localObject2).bTodayVotedCnt += 1L;
          ((CardProfile)localObject2).bAvailableCnt -= 1L;
          ((CardProfile)localObject2).bVoteCnt = ((short)(int)((CardProfile)localObject2).bTodayVotedCnt);
          localObject1 = localObject2;
          if (!paramBoolean)
          {
            ((CardProfile)localObject2).payVoteCount = ((short)(((CardProfile)localObject2).payVoteCount + 1));
            localObject1 = localObject2;
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject1 = paramCardProfile.clone();
            ((CardProfile)localObject1).type = 3;
            ((CardProfile)localObject1).bVoteCnt = ((short)(int)((CardProfile)localObject1).bTodayVotedCnt);
            ((CardProfile)localObject1).bAvailableCnt = paramCardProfile.bAvailableCnt;
            this.a.l.add(0, localObject1);
            this.a.f();
            localObject2 = localObject1;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("onVoteClick add to FavList. uin:");
              ((StringBuilder)localObject2).append(((CardProfile)localObject1).lEctID);
              QLog.i("VisitorsActivity.VoteHelper", 2, ((StringBuilder)localObject2).toString());
              localObject2 = localObject1;
            }
          }
          ((CardProfile)localObject2).updateTime(System.currentTimeMillis() / 1000L);
          break label800;
          if (i1 < this.a.d.size())
          {
            if (((CardProfile)this.a.d.get(i1)).lEctID != paramCardProfile.lEctID) {
              break label932;
            }
            localObject1 = (CardProfile)this.a.d.get(i1);
            ((CardProfile)localObject1).bTodayVotedCnt += 1L;
            ((CardProfile)localObject1).bAvailableCnt -= 1L;
          }
          this.a.a(paramCardProfile.lEctID);
          this.a.a(paramImageView, paramBoolean);
          if (!this.b.hasMessages(6)) {
            this.b.sendEmptyMessageDelayed(6, 2000L);
          }
          ThreadManager.post(new VoteHelper.1(this, paramCardProfile.lEctID, paramCardProfile.type, paramBoolean, paramCardProfile.uSource), 2, null, true);
          return;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.g > 2000L)
    {
      this.a.a(0, paramString);
      this.g = l1;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveSp key:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" value:");
      localStringBuilder.append(paramInt);
      QLog.i("VisitorsActivity.VoteHelper", 2, localStringBuilder.toString());
    }
    this.c.getPreferences().edit().putInt(paramString, paramInt).commit();
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    ThreadManager.postImmediately(new VoteHelper.3(this, paramString, paramInt, paramBoolean), null, false);
  }
  
  public void a(ArrayList<Long> paramArrayList, int paramInt1, int paramInt2, long paramLong)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    if (paramLong == 0L) {
      synchronized (n)
      {
        a(paramArrayList);
      }
    }
    a(q, this.d);
    a(r, this.e);
  }
  
  public boolean a(CardProfile paramCardProfile, ImageView paramImageView)
  {
    if (!NetworkUtil.isNetSupport(this.a))
    {
      a(HardCodeUtil.a(2131913786));
      return false;
    }
    int i1 = a(paramCardProfile);
    if (i1 == 0) {
      return false;
    }
    if (i1 == 2) {
      return true;
    }
    boolean bool = RecentUtil.a(this.c, Long.toString(paramCardProfile.lEctID));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VisitorActivity->onClickVote, uin=");
      localStringBuilder.append(paramCardProfile.lEctID);
      localStringBuilder.append(", isFriend=");
      localStringBuilder.append(bool);
      QLog.d("NearbyLikeLimitManager", 2, localStringBuilder.toString());
    }
    if ((!bool) && (((INearbyLikeLimitManagerUtil)QRoute.api(INearbyLikeLimitManagerUtil.class)).isNeedNewLimitCheck(paramCardProfile.uSource)))
    {
      ((INearbyLikeLimitManager)this.c.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).a(this.a, this.c, Long.toString(paramCardProfile.lEctID), new VoteHelper.2(this, paramCardProfile, paramImageView), "511");
      return false;
    }
    a(paramCardProfile, paramImageView, true);
    return false;
  }
  
  public int b(String paramString, int paramInt)
  {
    paramInt = this.c.getPreferences().getInt(paramString, paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSp key:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" value:");
      localStringBuilder.append(paramInt);
      QLog.i("VisitorsActivity.VoteHelper", 2, localStringBuilder.toString());
    }
    return paramInt;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity.VoteHelper", 2, "reqestVote");
    }
    long l1 = this.c.getLongAccountUin();
    FriendsManager localFriendsManager = (FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject3 = this.o.entrySet().iterator();
    Pair localPair;
    while (((Iterator)localObject3).hasNext())
    {
      ??? = (Map.Entry)((Iterator)localObject3).next();
      long l2 = ((Long)((Map.Entry)???).getKey()).longValue();
      localPair = (Pair)((Map.Entry)???).getValue();
      boolean bool = localFriendsManager.n(Long.toString(l2));
      synchronized (m)
      {
        if (((AtomicInteger)localPair.second).get() > 0)
        {
          if (bool) {
            this.a.ah.a(l1, l2, null, 66, ((AtomicInteger)localPair.second).get(), 1);
          } else {
            this.a.ak.a(l1, l2, null, 66, ((AtomicInteger)localPair.second).get(), 1);
          }
          ((AtomicInteger)localPair.second).set(0);
        }
      }
    }
    Iterator localIterator = this.p.entrySet().iterator();
    localObject3 = new ArrayList();
    while (localIterator.hasNext())
    {
      ??? = (Map.Entry)localIterator.next();
      l1 = ((Long)((Map.Entry)???).getKey()).longValue();
      localPair = (Pair)((Map.Entry)???).getValue();
      synchronized (m)
      {
        if ((((AtomicInteger)((Pair)localPair.second).first).get() > 0) || (((AtomicInteger)((Pair)localPair.second).second).get() > 0))
        {
          INearbyLikeLimitManager.LikeItem localLikeItem = new INearbyLikeLimitManager.LikeItem();
          localLikeItem.b = ((AtomicInteger)((Pair)localPair.second).first).get();
          localLikeItem.c = ((AtomicInteger)((Pair)localPair.second).second).get();
          localLikeItem.a = l1;
          localLikeItem.e = ((int)((CardProfile)localPair.first).uSource);
          ((ArrayList)localObject3).add(localLikeItem);
          ((AtomicInteger)((Pair)localPair.second).first).set(0);
          ((AtomicInteger)((Pair)localPair.second).second).set(0);
        }
      }
    }
    this.a.ak.a((ArrayList)localObject3, 511);
  }
  
  public void b(CardProfile paramCardProfile)
  {
    Object localObject1;
    int i2;
    label478:
    label483:
    label490:
    label496:
    label501:
    synchronized (m)
    {
      localObject1 = (Pair)this.o.get(Long.valueOf(paramCardProfile.lEctID));
      int i1;
      if (localObject1 == null)
      {
        i1 = 0;
      }
      else
      {
        i1 = ((AtomicInteger)((Pair)localObject1).second).get();
        break label478;
        int i3 = this.a.d.size();
        Object localObject2 = null;
        if (i2 >= i3) {
          break label490;
        }
        if (((CardProfile)this.a.d.get(i2)).lEctID != paramCardProfile.lEctID) {
          break label483;
        }
        localObject1 = (CardProfile)this.a.d.get(i2);
        if (localObject1 == null) {
          break label496;
        }
        long l1 = paramCardProfile.bTodayVotedCnt;
        long l2 = i1;
        ((CardProfile)localObject1).bTodayVotedCnt = (l1 + l2);
        ((CardProfile)localObject1).bAvailableCnt = (paramCardProfile.bAvailableCnt - l2);
        break label496;
        localObject1 = localObject2;
        if (i2 < this.a.l.size())
        {
          localObject1 = (CardProfile)this.a.l.get(i2);
          if ((localObject1 == null) || (((CardProfile)localObject1).lEctID != paramCardProfile.lEctID)) {
            break label501;
          }
          localObject1 = (CardProfile)this.a.l.remove(i2);
          ((CardProfile)localObject1).updateTime(paramCardProfile.lTime);
          l1 = paramCardProfile.bTodayVotedCnt;
          l2 = i1;
          ((CardProfile)localObject1).bTodayVotedCnt = (l1 + l2);
          ((CardProfile)localObject1).bAvailableCnt = (paramCardProfile.bAvailableCnt - l2);
          ((CardProfile)localObject1).bVoteCnt = ((short)(int)((CardProfile)localObject1).bTodayVotedCnt);
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = paramCardProfile.clone();
          ((CardProfile)localObject2).type = 3;
          l1 = paramCardProfile.bTodayVotedCnt;
          l2 = i1;
          ((CardProfile)localObject2).bTodayVotedCnt = (l1 + l2);
          ((CardProfile)localObject2).bAvailableCnt = (paramCardProfile.bAvailableCnt - l2);
          ((CardProfile)localObject2).bVoteCnt = ((short)(int)((CardProfile)localObject2).bTodayVotedCnt);
        }
        if ((((CardProfile)localObject2).bTodayVotedCnt > 0L) && (((CardProfile)localObject2).bVoteCnt > 0)) {
          this.a.l.add(0, localObject2);
        }
        this.a.a(paramCardProfile.lEctID);
        this.a.f();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("updateCardProfileToList. uin:");
          ((StringBuilder)localObject1).append(paramCardProfile.lEctID);
          ((StringBuilder)localObject1).append(" todayCount:");
          ((StringBuilder)localObject1).append(paramCardProfile.bTodayVotedCnt);
          QLog.i("VisitorsActivity.VoteHelper", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
    }
  }
  
  public void b(String paramString, int paramInt, boolean paramBoolean)
  {
    long l1 = Long.valueOf(paramString).longValue();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onVoteError, uin:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" voteNum:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.i("VisitorsActivity.VoteHelper", 2, ((StringBuilder)localObject1).toString());
    }
    paramString = m;
    int i2 = 0;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 >= this.a.l.size()) {
          break label350;
        }
        localObject1 = (CardProfile)this.a.l.get(i1);
        if ((localObject1 != null) && (((CardProfile)localObject1).lEctID == l1))
        {
          long l2 = ((CardProfile)localObject1).bTodayVotedCnt;
          long l3 = paramInt;
          ((CardProfile)localObject1).bTodayVotedCnt = (l2 - l3);
          ((CardProfile)localObject1).bAvailableCnt += l3;
          ((CardProfile)localObject1).bVoteCnt = ((short)(((CardProfile)localObject1).bVoteCnt - paramInt));
          if ((((CardProfile)localObject1).bTodayVotedCnt > 0L) && (((CardProfile)localObject1).bVoteCnt > 0)) {
            break label350;
          }
          this.a.l.remove(i1);
          i1 = 1;
          if (i2 < this.a.d.size())
          {
            if (((CardProfile)this.a.d.get(i2)).lEctID != l1) {
              break label356;
            }
            localObject1 = (CardProfile)this.a.d.get(i2);
            l2 = ((CardProfile)localObject1).bTodayVotedCnt;
            l3 = paramInt;
            ((CardProfile)localObject1).bTodayVotedCnt = (l2 - l3);
            ((CardProfile)localObject1).bAvailableCnt += l3;
          }
          this.a.a(l1);
          if (i1 != 0) {
            this.a.f();
          }
          return;
        }
      }
      finally
      {
        continue;
        throw localObject2;
        continue;
        i1 += 1;
      }
      continue;
      label350:
      i1 = 0;
      continue;
      label356:
      i2 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.vote.VoteHelper
 * JD-Core Version:    0.7.0.1
 */