package com.tencent.mobileqq.nearby;

import android.app.Activity;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotchat.PttShowRoomMng;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.api.NearbySPUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

public class NearbyCardManager
  implements INearbyCardManager, Manager
{
  private QQAppInterface a;
  private boolean b = false;
  private int c = -2147483648;
  private int d = -2147483648;
  private long e = 0L;
  private ConcurrentHashMap<String, Long> f = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> g = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> h = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> i = new ConcurrentHashMap();
  
  public NearbyCardManager(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
  }
  
  public static void a(Object paramObject1, String paramString, Object paramObject2, Object paramObject3)
  {
    Object localObject = (QQAppInterface)paramObject1;
    paramObject2 = (Oidb_0x686.CharmEvent)paramObject2;
    paramObject3 = (Oidb_0x686.NearbyCharmNotify)paramObject3;
    NearbyUtils.a("Q.nearby", "updateNearbyPeopleCard", new Object[] { paramString, paramObject2, paramObject3 });
    if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ((paramObject2 == null) && (paramObject3 == null)) {
        return;
      }
      paramObject1 = null;
      localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
      if (!StringUtil.isEmpty(paramString)) {
        paramObject1 = (NearbyPeopleCard)((EntityManager)localObject).find(NearbyPeopleCard.class, "uin=?", new String[] { paramString });
      }
      if (paramObject1 == null) {
        return;
      }
      if ((paramObject2 != null) && (paramObject2.uint32_new_charm.get() > 0) && (paramObject2.uint32_cur_level_threshold.get() > paramObject2.uint32_next_level_threshold.get()))
      {
        paramObject1.charm = paramObject2.uint32_new_charm.get();
        paramObject1.charmLevel = paramObject2.uint32_new_charm_level.get();
        paramObject1.curThreshold = paramObject2.uint32_cur_level_threshold.get();
        paramObject1.nextThreshold = paramObject2.uint32_next_level_threshold.get();
      }
      else if (paramObject3 != null)
      {
        paramObject1.charm = paramObject3.uint32_new_charm.get();
        paramObject1.charmLevel = paramObject3.uint32_new_charm_level.get();
        paramObject1.curThreshold = paramObject3.uint32_cur_level_threshold.get();
        paramObject1.nextThreshold = paramObject3.uint32_next_level_threshold.get();
        paramObject1.profPercent = paramObject3.uint32_new_prof_percent.get();
      }
      ((EntityManager)localObject).update(paramObject1);
      ((EntityManager)localObject).close();
    }
  }
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramInt == 1) {
        ReportController.b(null, "dc00899", "grp_lbs", "", "app_down", "exp_msg", 0, 0, "", "", "", "");
      } else if (paramInt == 2) {
        ReportController.b(null, "dc00899", "grp_lbs", "", "app_down", "exp_pic", 0, 0, "", "", "", "");
      }
      DialogUtil.a(paramActivity, 230).setMessage(paramString1).setNegativeButton(HardCodeUtil.a(2131898212), new NearbyCardManager.3()).setPositiveButton(HardCodeUtil.a(2131904986), new NearbyCardManager.2(paramString2, paramInt, paramActivity)).show();
      return true;
    }
    return false;
  }
  
  public static void c(Object paramObject)
  {
    paramObject = (QQAppInterface)paramObject;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.nearby_people_card.", 4, "updateNearbyProfileCardHead");
    }
    paramObject.deleteStrangerFace(paramObject.getCurrentAccountUin(), 200);
    EntityManager localEntityManager = paramObject.getEntityManagerFactory(paramObject.getAccount()).createEntityManager();
    if (localEntityManager != null)
    {
      NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { paramObject.getCurrentAccountUin() });
      if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.tinyId > 0L)) {
        paramObject.deleteStrangerFace(String.valueOf(localNearbyPeopleCard.tinyId), 202);
      }
      localEntityManager.close();
    }
    ThreadManager.getSubThreadHandler().postDelayed(new NearbyCardManager.1(paramObject), 2000L);
  }
  
  public static boolean c(String paramString)
  {
    return (paramString != null) && (paramString.length() >= 18);
  }
  
  public int a(int paramInt)
  {
    int k = 2;
    int j;
    if ((paramInt == 0) || (paramInt == 1))
    {
      j = c();
      if (j == 1) {
        j = 0;
      } else if (j == 2) {
        j = 1;
      } else {
        j = -1;
      }
      if ((j == 0) || (j == 1)) {}
    }
    else
    {
      return 0;
    }
    if (j == 1)
    {
      j = k;
      if (paramInt == 1) {
        return 3;
      }
    }
    else
    {
      if (paramInt == 1) {
        return 1;
      }
      j = 4;
    }
    return j;
  }
  
  public void a()
  {
    try
    {
      if (k() != null) {
        k().clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(String paramString)
  {
    try
    {
      if ((k() != null) && (!k().isEmpty()) && (paramString != null))
      {
        if (k().containsKey(paramString)) {
          k().remove(paramString);
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString, long paramLong)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L)) {
        k().put(paramString, Long.valueOf(paramLong));
      }
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a(Object paramObject)
  {
    paramObject = (NearbyPeopleCard)paramObject;
    if ((paramObject != null) && (!TextUtils.isEmpty(paramObject.uin)) && (f().containsKey(String.valueOf(paramObject.tinyId))))
    {
      f().remove(String.valueOf(paramObject.tinyId));
      return true;
    }
    return false;
  }
  
  public boolean a(Object paramObject, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    paramObject = (NearbyPeopleCard)paramObject;
    boolean bool = h();
    a(false);
    if (paramObject == null) {
      return true;
    }
    int j;
    if ((paramObject != null) && (!TextUtils.isEmpty(String.valueOf(paramObject.tinyId))) && (f().containsKey(String.valueOf(paramObject.tinyId))))
    {
      f().remove(String.valueOf(paramObject.tinyId));
      j = 1;
    }
    else
    {
      j = 0;
    }
    if (j != 0) {
      return true;
    }
    if (TextUtils.isEmpty(paramObject.uin)) {
      return true;
    }
    if ((bool) && (paramObject.isHostSelf)) {
      return true;
    }
    if (!paramBoolean3) {
      return true;
    }
    if (!paramBoolean1)
    {
      if (paramBoolean2) {
        return true;
      }
      if (51 == paramInt) {}
      try
      {
        if (!l().containsKey(paramObject.uin)) {
          return true;
        }
        long l = ((Long)l().get(paramObject.uin)).longValue();
        break label193;
        l = b(String.valueOf(paramObject.tinyId));
        label193:
        l = SystemClock.elapsedRealtime() - l;
        if (paramObject.isHostSelf)
        {
          if (l >= 300000L) {
            return true;
          }
        }
        else if (l >= 300000L) {
          return true;
        }
        return (!TextUtils.isEmpty(paramObject.uin)) && (((INearbyLikeLimitManager)g().getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).a(paramObject.uin));
      }
      finally {}
    }
    return true;
  }
  
  public int b()
  {
    int k = j();
    int j = -2147483648;
    if (k == -2147483648)
    {
      Card localCard = ((FriendsManager)g().getManager(QQManagerFactory.FRIENDS_MANAGER)).f(g().getCurrentAccountUin());
      if ((localCard != null) && ((localCard.age != 0) || (!TextUtils.isEmpty(localCard.strNick))))
      {
        if (-2147483648 != localCard.age) {
          j = localCard.age;
        }
        b(j);
      }
    }
    return j();
  }
  
  public long b(String paramString)
  {
    if ((k() != null) && (k().contains(paramString))) {
      return ((Long)k().get(paramString)).longValue();
    }
    return 0L;
  }
  
  public void b(int paramInt)
  {
    if (paramInt != j())
    {
      e(paramInt);
      NearbySPUtil.b(g().getAccount(), "self_age", Integer.valueOf(j()));
    }
  }
  
  public void b(Object paramObject)
  {
    oidb_0x8dd.SelfInfo localSelfInfo = (oidb_0x8dd.SelfInfo)paramObject;
    if (localSelfInfo == null) {
      return;
    }
    EntityManager localEntityManager = g().getEntityManagerFactory(g().getCurrentAccountUin()).createEntityManager();
    if (localEntityManager != null)
    {
      int k = 1;
      paramObject = g().getCurrentAccountUin();
      int m = 0;
      Object localObject = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { paramObject });
      paramObject = localObject;
      if (localObject == null)
      {
        paramObject = localObject;
        if (localSelfInfo.uint64_tinyid.get() > 0L) {
          paramObject = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "tinyId=?", new String[] { String.valueOf(localSelfInfo.uint64_tinyid.get()) });
        }
      }
      localObject = paramObject;
      if (paramObject == null) {
        localObject = new NearbyPeopleCard();
      }
      if (localSelfInfo.uint64_tinyid.get() > 0L)
      {
        ((NearbyPeopleCard)localObject).tinyId = localSelfInfo.uint64_tinyid.get();
        ((NearbyPeopleCard)localObject).uin = g().getCurrentAccountUin();
      }
      int j = localSelfInfo.uint32_vote_num.get();
      if ((localSelfInfo.uint32_vote_num.has()) && (j > 0)) {
        ((NearbyPeopleCard)localObject).likeCount = j;
      }
      j = localSelfInfo.uint32_vote_increment.get();
      if ((localSelfInfo.uint32_vote_increment.has()) && (j > 0)) {
        ((NearbyPeopleCard)localObject).likeCountInc = j;
      }
      ((NearbyPeopleCard)localObject).gender = ((byte)localSelfInfo.uint32_gender.get());
      ((NearbyPeopleCard)localObject).nickname = localSelfInfo.bytes_nick.get().toStringUtf8();
      ((NearbyPeopleCard)localObject).age = localSelfInfo.uint32_age.get();
      if (((NearbyPeopleCard)localObject).getStatus() == 1000) {
        localEntityManager.persistOrReplace((Entity)localObject);
      } else if ((((NearbyPeopleCard)localObject).getStatus() == 1001) || (((NearbyPeopleCard)localObject).getStatus() == 1002)) {
        localEntityManager.update((Entity)localObject);
      }
      paramObject = ((FriendsManager)g().getManager(QQManagerFactory.FRIENDS_MANAGER)).g(g().getCurrentAccountUin());
      if (paramObject != null)
      {
        int n = localSelfInfo.uint32_vote_num.get();
        j = m;
        if (localSelfInfo.uint32_vote_num.has())
        {
          j = m;
          if (n > 0)
          {
            paramObject.lVoteCount = n;
            j = 1;
          }
        }
        m = localSelfInfo.uint32_vote_increment.get();
        if ((localSelfInfo.uint32_vote_increment.has()) && (m > 0))
        {
          paramObject.iVoteIncrement = m;
          j = k;
        }
        if (j != 0)
        {
          NearbySPUtil.a(g().getAccount(), paramObject.lVoteCount, paramObject.iVoteIncrement);
          localEntityManager.update(paramObject);
        }
      }
      localEntityManager.close();
    }
    c(localSelfInfo.uint32_gender.get());
    b(localSelfInfo.uint32_age.get());
    NearbySPUtil.b(g().getAccount(), "self_third_line_info", localSelfInfo.str_third_line_info.get());
    NearbySPUtil.b(g().getAccount(), "self_third_line_icon", localSelfInfo.str_third_line_icon.get());
  }
  
  public void b(String paramString, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L)) {
      l().put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public int c()
  {
    if (i() == -2147483648)
    {
      Object localObject = ((FriendsManager)g().getManager(QQManagerFactory.FRIENDS_MANAGER)).g(g().getCurrentAccountUin());
      int j = -1;
      if (localObject != null)
      {
        j = ((Card)localObject).shGender;
      }
      else
      {
        localObject = (NearbyPeopleCard)g().getEntityManagerFactory(g().getCurrentAccountUin()).createEntityManager().find(NearbyPeopleCard.class, "uin=?", new String[] { g().getCurrentAccountUin() });
        if (localObject != null) {
          j = ((NearbyPeopleCard)localObject).gender;
        }
      }
      c(j);
    }
    return i();
  }
  
  public void c(int paramInt)
  {
    int j = i();
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        d(0);
      } else {
        d(2);
      }
    }
    else {
      d(1);
    }
    if (j != i())
    {
      Object localObject = g().getHotChatMng(false);
      if (localObject != null)
      {
        localObject = ((HotChatManager)localObject).b(false);
        if (localObject != null) {
          ((PttShowRoomMng)localObject).a(g().getCurrentAccountUin(), null, paramInt, NetConnInfoCenter.getServerTime());
        }
      }
      NearbySPUtil.b(g().getAccount(), "self_gender", Integer.valueOf(i()));
    }
  }
  
  public void d(int paramInt)
  {
    this.c = paramInt;
  }
  
  public boolean d()
  {
    return ((Boolean)NearbySPUtil.a(g().getCurrentAccountUin(), "self_god_flag", Boolean.valueOf(false))).booleanValue();
  }
  
  public long e()
  {
    return this.e;
  }
  
  public void e(int paramInt)
  {
    this.d = paramInt;
  }
  
  public ConcurrentHashMap<String, Integer> f()
  {
    return this.i;
  }
  
  public QQAppInterface g()
  {
    return this.a;
  }
  
  public boolean h()
  {
    return this.b;
  }
  
  public int i()
  {
    return this.c;
  }
  
  public int j()
  {
    return this.d;
  }
  
  public ConcurrentHashMap<String, Long> k()
  {
    return this.f;
  }
  
  public ConcurrentHashMap<String, Long> l()
  {
    return this.g;
  }
  
  public void onDestroy()
  {
    try
    {
      a();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyCardManager
 * JD-Core Version:    0.7.0.1
 */