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
  public static final Object a;
  public static long b;
  public static final Object b;
  public static String d;
  public static String e;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler;
  VisitorsActivity jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public Map<Long, Pair<CardProfile, AtomicInteger>> a;
  public boolean a;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  ArrayList<Long> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public Map<Long, Pair<CardProfile, Pair<AtomicInteger, AtomicInteger>>> b;
  String c;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
    d = "sp_key_vote_max_friend";
    e = "sp_key_vote_max_stranger";
    jdField_b_of_type_Long = -1L;
  }
  
  public VoteHelper(VisitorsActivity paramVisitorsActivity, Handler paramHandler, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity = paramVisitorsActivity;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_b_of_type_Long = -1L;
  }
  
  private void a(ArrayList<Long> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    int i = 0;
    while (i < paramArrayList.size())
    {
      if ((Long)paramArrayList.get(i) != null) {
        if (((FriendsManager)localObject).b(Long.toString(((Long)paramArrayList.get(i)).longValue()))) {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramArrayList.get(i));
        } else {
          this.jdField_b_of_type_JavaUtilArrayList.add(paramArrayList.get(i));
        }
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fillTodayVoteArray ");
      ((StringBuilder)localObject).append(paramArrayList.size());
      ((StringBuilder)localObject).append(" friend:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilArrayList.size());
      ((StringBuilder)localObject).append(" stranger:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaUtilArrayList.size());
      QLog.i("VisitorsActivity.VoteHelper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_b_of_type_Long < 0L) {
      jdField_b_of_type_Long = paramQQAppInterface.getPreferences().getLong("keyShowDoubleZanPopTime", 0L);
    }
    if (DateUtils.isToday(jdField_b_of_type_Long)) {
      return false;
    }
    jdField_b_of_type_Long = System.currentTimeMillis();
    paramQQAppInterface.getPreferences().edit().putLong("keyShowDoubleZanPopTime", jdField_b_of_type_Long).commit();
    return true;
  }
  
  public int a(CardProfile paramCardProfile)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:806)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public int a(String paramString, int paramInt)
  {
    paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt(paramString, paramInt);
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
  
  public void a()
  {
    this.jdField_a_of_type_Int = a(d, 0);
    this.jdField_b_of_type_Int = a(d, 0);
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler.c(localArrayList);
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      a(localArrayList);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getResources().getString(2131699169);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getResources().getString(2131699171);
      this.c = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getResources().getString(2131699170);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    ThreadManager.postImmediately(new VoteHelper.4(this, paramLong), null, true);
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramLong, paramInt);
  }
  
  public void a(CardProfile paramCardProfile)
  {
    Object localObject1;
    int j;
    label478:
    label483:
    label490:
    label496:
    label501:
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      localObject1 = (Pair)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramCardProfile.lEctID));
      int i;
      if (localObject1 == null)
      {
        i = 0;
      }
      else
      {
        i = ((AtomicInteger)((Pair)localObject1).second).get();
        break label478;
        int k = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilArrayList.size();
        Object localObject2 = null;
        if (j >= k) {
          break label490;
        }
        if (((CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilArrayList.get(j)).lEctID != paramCardProfile.lEctID) {
          break label483;
        }
        localObject1 = (CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (localObject1 == null) {
          break label496;
        }
        long l1 = paramCardProfile.bTodayVotedCnt;
        long l2 = i;
        ((CardProfile)localObject1).bTodayVotedCnt = (l1 + l2);
        ((CardProfile)localObject1).bAvailableCnt = (paramCardProfile.bAvailableCnt - l2);
        break label496;
        localObject1 = localObject2;
        if (j < this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.size())
        {
          localObject1 = (CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.get(j);
          if ((localObject1 == null) || (((CardProfile)localObject1).lEctID != paramCardProfile.lEctID)) {
            break label501;
          }
          localObject1 = (CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.remove(j);
          ((CardProfile)localObject1).updateTime(paramCardProfile.lTime);
          l1 = paramCardProfile.bTodayVotedCnt;
          l2 = i;
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
          l2 = i;
          ((CardProfile)localObject2).bTodayVotedCnt = (l1 + l2);
          ((CardProfile)localObject2).bAvailableCnt = (paramCardProfile.bAvailableCnt - l2);
          ((CardProfile)localObject2).bVoteCnt = ((short)(int)((CardProfile)localObject2).bTodayVotedCnt);
        }
        if ((((CardProfile)localObject2).bTodayVotedCnt > 0L) && (((CardProfile)localObject2).bVoteCnt > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.add(0, localObject2);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramCardProfile.lEctID);
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.f();
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
  
  public void a(CardProfile paramCardProfile, ImageView paramImageView, boolean paramBoolean)
  {
    short s;
    int i;
    Object localObject1;
    label800:
    label932:
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramCardProfile.bAvailableCnt -= 1L;
      paramCardProfile.bTodayVotedCnt += 1L;
      if (paramCardProfile.type == 3)
      {
        paramCardProfile.bVoteCnt = ((short)(int)paramCardProfile.bTodayVotedCnt);
        paramCardProfile.dwLikeCustomId = PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramBoolean)
        {
          s = 0;
          paramCardProfile.bIsLastVoteCharged = s;
          paramCardProfile.updateTime(System.currentTimeMillis() / 1000L);
          i = 0;
          if ((!paramBoolean) && (i == 0)) {
            paramCardProfile.payVoteCount = ((short)(paramCardProfile.payVoteCount + 1));
          }
          boolean bool = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(Long.toString(paramCardProfile.lEctID));
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
            if (!this.jdField_b_of_type_JavaUtilMap.containsKey(Long.valueOf(paramCardProfile.lEctID)))
            {
              localObject1 = new AtomicInteger(0);
              localObject2 = new AtomicInteger(0);
              Pair localPair = new Pair(localObject1, localObject2);
              this.jdField_b_of_type_JavaUtilMap.put(Long.valueOf(paramCardProfile.lEctID), new Pair(paramCardProfile, localPair));
            }
            else
            {
              localObject2 = (Pair)((Pair)this.jdField_b_of_type_JavaUtilMap.get(Long.valueOf(paramCardProfile.lEctID))).second;
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
          if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramCardProfile.lEctID)))
          {
            localObject1 = new AtomicInteger(0);
            this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramCardProfile.lEctID), new Pair(paramCardProfile, localObject1));
          }
          else
          {
            localObject1 = (AtomicInteger)((Pair)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramCardProfile.lEctID))).second;
          }
          ((AtomicInteger)localObject1).incrementAndGet();
          break label900;
          if (i >= this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.size()) {
            break label920;
          }
          Object localObject2 = (CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.get(i);
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
            this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.add(0, localObject1);
            this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.f();
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
          if (i < this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if (((CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilArrayList.get(i)).lEctID != paramCardProfile.lEctID) {
              break label932;
            }
            localObject1 = (CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilArrayList.get(i);
            ((CardProfile)localObject1).bTodayVotedCnt += 1L;
            ((CardProfile)localObject1).bAvailableCnt -= 1L;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramCardProfile.lEctID);
          this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramImageView, paramBoolean);
          if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(6)) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 2000L);
          }
          ThreadManager.post(new VoteHelper.1(this, paramCardProfile.lEctID, paramCardProfile.type, paramBoolean, paramCardProfile.uSource), 2, null, true);
          return;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 2000L)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(0, paramString);
      this.jdField_a_of_type_Long = l;
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt(paramString, paramInt).commit();
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    ThreadManager.postImmediately(new VoteHelper.3(this, paramString, paramInt, paramBoolean), null, false);
  }
  
  public void a(ArrayList<Long> paramArrayList, int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (paramLong == 0L) {
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        a(paramArrayList);
      }
    }
    a(d, this.jdField_a_of_type_Int);
    a(e, this.jdField_b_of_type_Int);
  }
  
  public boolean a(CardProfile paramCardProfile, ImageView paramImageView)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity))
    {
      a(HardCodeUtil.a(2131716344));
      return false;
    }
    int i = a(paramCardProfile);
    if (i == 0) {
      return false;
    }
    if (i == 2) {
      return true;
    }
    boolean bool = RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(paramCardProfile.lEctID));
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
      ((INearbyLikeLimitManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(paramCardProfile.lEctID), new VoteHelper.2(this, paramCardProfile, paramImageView), "511");
      return false;
    }
    a(paramCardProfile, paramImageView, true);
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity.VoteHelper", 2, "reqestVote");
    }
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject3 = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    Pair localPair;
    while (((Iterator)localObject3).hasNext())
    {
      ??? = (Map.Entry)((Iterator)localObject3).next();
      long l2 = ((Long)((Map.Entry)???).getKey()).longValue();
      localPair = (Pair)((Map.Entry)???).getValue();
      boolean bool = localFriendsManager.b(Long.toString(l2));
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (((AtomicInteger)localPair.second).get() > 0)
        {
          if (bool) {
            this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(l1, l2, null, 66, ((AtomicInteger)localPair.second).get(), 1);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessINearbyCardHandler.a(l1, l2, null, 66, ((AtomicInteger)localPair.second).get(), 1);
          }
          ((AtomicInteger)localPair.second).set(0);
        }
      }
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.entrySet().iterator();
    localObject3 = new ArrayList();
    while (localIterator.hasNext())
    {
      ??? = (Map.Entry)localIterator.next();
      l1 = ((Long)((Map.Entry)???).getKey()).longValue();
      localPair = (Pair)((Map.Entry)???).getValue();
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if ((((AtomicInteger)((Pair)localPair.second).first).get() > 0) || (((AtomicInteger)((Pair)localPair.second).second).get() > 0))
        {
          INearbyLikeLimitManager.LikeItem localLikeItem = new INearbyLikeLimitManager.LikeItem();
          localLikeItem.jdField_a_of_type_Int = ((AtomicInteger)((Pair)localPair.second).first).get();
          localLikeItem.jdField_b_of_type_Int = ((AtomicInteger)((Pair)localPair.second).second).get();
          localLikeItem.jdField_a_of_type_Long = l1;
          localLikeItem.d = ((int)((CardProfile)localPair.first).uSource);
          ((ArrayList)localObject3).add(localLikeItem);
          ((AtomicInteger)((Pair)localPair.second).first).set(0);
          ((AtomicInteger)((Pair)localPair.second).second).set(0);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessINearbyCardHandler.a((ArrayList)localObject3, 511);
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
    paramString = jdField_a_of_type_JavaLangObject;
    int j = 0;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.size()) {
          break label350;
        }
        localObject1 = (CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.get(i);
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
          this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.remove(i);
          i = 1;
          if (j < this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if (((CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilArrayList.get(j)).lEctID != l1) {
              break label356;
            }
            localObject1 = (CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilArrayList.get(j);
            l2 = ((CardProfile)localObject1).bTodayVotedCnt;
            l3 = paramInt;
            ((CardProfile)localObject1).bTodayVotedCnt = (l2 - l3);
            ((CardProfile)localObject1).bAvailableCnt += l3;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(l1);
          if (i != 0) {
            this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.f();
          }
          return;
        }
      }
      finally
      {
        continue;
        throw localObject2;
        continue;
        i += 1;
      }
      continue;
      label350:
      i = 0;
      continue;
      label356:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.vote.VoteHelper
 * JD-Core Version:    0.7.0.1
 */