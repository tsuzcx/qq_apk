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
  private int jdField_a_of_type_Int = -2147483648;
  private long jdField_a_of_type_Long = 0L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -2147483648;
  private ConcurrentHashMap<String, Long> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> c = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> d = new ConcurrentHashMap();
  
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
      if (!StringUtil.a(paramString)) {
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
      DialogUtil.a(paramActivity, 230).setMessage(paramString1).setNegativeButton(HardCodeUtil.a(2131707149), new NearbyCardManager.3()).setPositiveButton(HardCodeUtil.a(2131707152), new NearbyCardManager.2(paramString2, paramInt, paramActivity)).show();
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.length() >= 18);
  }
  
  public static void b(Object paramObject)
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
  
  public int a()
  {
    int j = d();
    int i = -2147483648;
    if (j == -2147483648)
    {
      Card localCard = ((FriendsManager)a().getManager(QQManagerFactory.FRIENDS_MANAGER)).a(a().getCurrentAccountUin());
      if ((localCard != null) && ((localCard.age != 0) || (!TextUtils.isEmpty(localCard.strNick))))
      {
        if (-2147483648 != localCard.age) {
          i = localCard.age;
        }
        a(i);
      }
    }
    return d();
  }
  
  public int a(int paramInt)
  {
    int j = 2;
    int i;
    if ((paramInt == 0) || (paramInt == 1))
    {
      i = b();
      if (i == 1) {
        i = 0;
      } else if (i == 2) {
        i = 1;
      } else {
        i = -1;
      }
      if ((i == 0) || (i == 1)) {}
    }
    else
    {
      return 0;
    }
    if (i == 1)
    {
      i = j;
      if (paramInt == 1) {
        return 3;
      }
    }
    else
    {
      if (paramInt == 1) {
        return 1;
      }
      i = 4;
    }
    return i;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public long a(String paramString)
  {
    if ((b() != null) && (b().contains(paramString))) {
      return ((Long)b().get(paramString)).longValue();
    }
    return 0L;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public ConcurrentHashMap<String, Integer> a()
  {
    return this.d;
  }
  
  public void a()
  {
    try
    {
      if (b() != null) {
        b().clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt != d())
    {
      d(paramInt);
      NearbySPUtil.a(a().getAccount(), "self_age", Integer.valueOf(d()));
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(Object paramObject)
  {
    oidb_0x8dd.SelfInfo localSelfInfo = (oidb_0x8dd.SelfInfo)paramObject;
    if (localSelfInfo == null) {
      return;
    }
    EntityManager localEntityManager = a().getEntityManagerFactory(a().getCurrentAccountUin()).createEntityManager();
    if (localEntityManager != null)
    {
      int j = 1;
      paramObject = a().getCurrentAccountUin();
      int k = 0;
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
        ((NearbyPeopleCard)localObject).uin = a().getCurrentAccountUin();
      }
      int i = localSelfInfo.uint32_vote_num.get();
      if ((localSelfInfo.uint32_vote_num.has()) && (i > 0)) {
        ((NearbyPeopleCard)localObject).likeCount = i;
      }
      i = localSelfInfo.uint32_vote_increment.get();
      if ((localSelfInfo.uint32_vote_increment.has()) && (i > 0)) {
        ((NearbyPeopleCard)localObject).likeCountInc = i;
      }
      ((NearbyPeopleCard)localObject).gender = ((byte)localSelfInfo.uint32_gender.get());
      ((NearbyPeopleCard)localObject).nickname = localSelfInfo.bytes_nick.get().toStringUtf8();
      ((NearbyPeopleCard)localObject).age = localSelfInfo.uint32_age.get();
      if (((NearbyPeopleCard)localObject).getStatus() == 1000) {
        localEntityManager.persistOrReplace((Entity)localObject);
      } else if ((((NearbyPeopleCard)localObject).getStatus() == 1001) || (((NearbyPeopleCard)localObject).getStatus() == 1002)) {
        localEntityManager.update((Entity)localObject);
      }
      paramObject = ((FriendsManager)a().getManager(QQManagerFactory.FRIENDS_MANAGER)).b(a().getCurrentAccountUin());
      if (paramObject != null)
      {
        int m = localSelfInfo.uint32_vote_num.get();
        i = k;
        if (localSelfInfo.uint32_vote_num.has())
        {
          i = k;
          if (m > 0)
          {
            paramObject.lVoteCount = m;
            i = 1;
          }
        }
        k = localSelfInfo.uint32_vote_increment.get();
        if ((localSelfInfo.uint32_vote_increment.has()) && (k > 0))
        {
          paramObject.iVoteIncrement = k;
          i = j;
        }
        if (i != 0)
        {
          NearbySPUtil.a(a().getAccount(), paramObject.lVoteCount, paramObject.iVoteIncrement);
          localEntityManager.update(paramObject);
        }
      }
      localEntityManager.close();
    }
    b(localSelfInfo.uint32_gender.get());
    a(localSelfInfo.uint32_age.get());
    NearbySPUtil.a(a().getAccount(), "self_third_line_info", localSelfInfo.str_third_line_info.get());
    NearbySPUtil.a(a().getAccount(), "self_third_line_icon", localSelfInfo.str_third_line_icon.get());
  }
  
  public void a(String paramString)
  {
    try
    {
      if ((b() != null) && (!b().isEmpty()) && (paramString != null))
      {
        if (b().containsKey(paramString)) {
          b().remove(paramString);
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
        b().put(paramString, Long.valueOf(paramLong));
      }
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return ((Boolean)NearbySPUtil.a(a().getCurrentAccountUin(), "self_god_flag", Boolean.valueOf(false))).booleanValue();
  }
  
  public boolean a(Object paramObject)
  {
    paramObject = (NearbyPeopleCard)paramObject;
    if ((paramObject != null) && (!TextUtils.isEmpty(paramObject.uin)) && (a().containsKey(String.valueOf(paramObject.tinyId))))
    {
      a().remove(String.valueOf(paramObject.tinyId));
      return true;
    }
    return false;
  }
  
  public boolean a(Object paramObject, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    paramObject = (NearbyPeopleCard)paramObject;
    boolean bool = b();
    a(false);
    if (paramObject == null) {
      return true;
    }
    int i;
    if ((paramObject != null) && (!TextUtils.isEmpty(String.valueOf(paramObject.tinyId))) && (a().containsKey(String.valueOf(paramObject.tinyId))))
    {
      a().remove(String.valueOf(paramObject.tinyId));
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (i != 0) {
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
        if (!c().containsKey(paramObject.uin)) {
          return true;
        }
        long l = ((Long)c().get(paramObject.uin)).longValue();
        break label193;
        l = a(String.valueOf(paramObject.tinyId));
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
        return (!TextUtils.isEmpty(paramObject.uin)) && (((INearbyLikeLimitManager)a().getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).a(paramObject.uin));
      }
      finally {}
    }
    return true;
  }
  
  public int b()
  {
    if (c() == -2147483648)
    {
      Object localObject = ((FriendsManager)a().getManager(QQManagerFactory.FRIENDS_MANAGER)).b(a().getCurrentAccountUin());
      int i = -1;
      if (localObject != null)
      {
        i = ((Card)localObject).shGender;
      }
      else
      {
        localObject = (NearbyPeopleCard)a().getEntityManagerFactory(a().getCurrentAccountUin()).createEntityManager().find(NearbyPeopleCard.class, "uin=?", new String[] { a().getCurrentAccountUin() });
        if (localObject != null) {
          i = ((NearbyPeopleCard)localObject).gender;
        }
      }
      b(i);
    }
    return c();
  }
  
  public ConcurrentHashMap<String, Long> b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void b(int paramInt)
  {
    int i = c();
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        c(0);
      } else {
        c(2);
      }
    }
    else {
      c(1);
    }
    if (i != c())
    {
      Object localObject = a().getHotChatMng(false);
      if (localObject != null)
      {
        localObject = ((HotChatManager)localObject).a(false);
        if (localObject != null) {
          ((PttShowRoomMng)localObject).a(a().getCurrentAccountUin(), null, paramInt, NetConnInfoCenter.getServerTime());
        }
      }
      NearbySPUtil.a(a().getAccount(), "self_gender", Integer.valueOf(c()));
    }
  }
  
  public void b(String paramString, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L)) {
      c().put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ConcurrentHashMap<String, Long> c()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int d()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void d(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyCardManager
 * JD-Core Version:    0.7.0.1
 */