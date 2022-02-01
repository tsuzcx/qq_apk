package com.tencent.mobileqq.multicard.manager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.TroopMemRecommendConfBean;
import com.tencent.mobileqq.config.business.TroopMemRecommendConfProcessor;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.multicard.RecommendPerson;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class TroopMemberRecommendManager
  implements Manager
{
  public TroopMemRecommendConfBean a;
  private SharedPreferences b;
  private ConcurrentHashMap<String, List<RecommendPerson>> c = new ConcurrentHashMap();
  private QQAppInterface d;
  
  public TroopMemberRecommendManager(QQAppInterface paramQQAppInterface)
  {
    this.d = paramQQAppInterface;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopMemberRecom");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    this.b = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
    ThreadManager.getSubThreadHandler().post(new TroopMemberRecommendManager.1(this));
  }
  
  public static TroopMemberRecommendManager a(QQAppInterface paramQQAppInterface)
  {
    return (TroopMemberRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MEMBER_RECOMMEND_MANAGER);
  }
  
  private void b()
  {
    if (this.a == null) {
      this.a = TroopMemRecommendConfProcessor.a();
    }
  }
  
  private TroopMemberRecommendHandler c()
  {
    return (TroopMemberRecommendHandler)this.d.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_RECOMMED_HANDLER);
  }
  
  public SharedPreferences a()
  {
    return this.b;
  }
  
  Map<Integer, List<RecommendPerson>> a(List<RecommendPerson> paramList, String paramString)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("filterAndReorderRecommenList start ,troopUin = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("TroopMemberRecommend.Manager", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject1 = paramList.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecommendPerson)((Iterator)localObject1).next();
        if (localLinkedHashMap.containsKey(Integer.valueOf(((RecommendPerson)localObject2).cardTypeID))) {
          paramList = (List)localLinkedHashMap.get(Integer.valueOf(((RecommendPerson)localObject2).cardTypeID));
        } else {
          paramList = new ArrayList();
        }
        paramList.add(localObject2);
        localLinkedHashMap.put(Integer.valueOf(((RecommendPerson)localObject2).cardTypeID), paramList);
      }
      localObject1 = localLinkedHashMap.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramList = (Map.Entry)((Iterator)localObject1).next();
        localObject2 = (Integer)paramList.getKey();
        List localList = (List)paramList.getValue();
        switch (((Integer)localObject2).intValue())
        {
        default: 
          paramList = "";
          break;
        case 105: 
          paramList = new StringBuilder();
          paramList.append("key_GroupKOL_ri");
          paramList.append(paramString);
          paramList = paramList.toString();
          break;
        case 104: 
          paramList = new StringBuilder();
          paramList.append("key_Interactive_ri");
          paramList.append(paramString);
          paramList = paramList.toString();
          break;
        case 103: 
          paramList = new StringBuilder();
          paramList.append("key_CommonBehavior_ri");
          paramList.append(paramString);
          paramList = paramList.toString();
          break;
        case 102: 
          paramList = new StringBuilder();
          paramList.append("key_SameUserInfo_ri");
          paramList.append(paramString);
          paramList = paramList.toString();
          break;
        case 101: 
          paramList = new StringBuilder();
          paramList.append("key_ActiveMember_ri");
          paramList.append(paramString);
          paramList = paramList.toString();
        }
        localLinkedHashMap.put(localObject2, b(localList, paramList));
      }
    }
    return localLinkedHashMap;
  }
  
  public void a(String paramString, int paramInt, List<Long> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTroopMemRecommendCardsData troopUin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",entryId = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TroopMemberRecommend.Manager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (List)this.c.get(paramString);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      a(paramString, false);
      localObject = a((List)this.c.get(paramString), paramString);
      c().notifyUI(1, true, new Object[] { localObject, paramString, Integer.valueOf(1) });
    }
    else
    {
      ThreadManager.excute(new TroopMemberRecommendManager.2(this, paramString), 32, null, true);
    }
    if (a(paramInt, paramString)) {
      c().a(paramString, paramInt, paramList);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      Object localObject = new ArrayList();
      ((List)localObject).addAll((Collection)this.c.get(paramString1));
      if (((List)localObject).size() > 0)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          RecommendPerson localRecommendPerson = (RecommendPerson)((Iterator)localObject).next();
          if (paramString2.equals(localRecommendPerson.uin)) {
            ((List)this.c.get(paramString1)).remove(localRecommendPerson);
          }
        }
      }
      paramString1 = this.d.getEntityManagerFactory().createEntityManager();
      if (paramString1 != null) {
        paramString1.delete(RecommendPerson.class.getSimpleName(), "uin=?", new String[] { String.valueOf(paramString2) });
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    FriendsManager localFriendsManager = (FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject = new ArrayList();
    ((List)localObject).addAll((Collection)this.c.get(paramString));
    EntityManager localEntityManager = this.d.getEntityManagerFactory().createEntityManager();
    if (((List)localObject).size() > 0)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecommendPerson localRecommendPerson = (RecommendPerson)((Iterator)localObject).next();
        if ((localFriendsManager != null) && (localFriendsManager.n(localRecommendPerson.uin)))
        {
          ((List)this.c.get(paramString)).remove(localRecommendPerson);
          if ((paramBoolean) && (localEntityManager != null)) {
            localEntityManager.delete(RecommendPerson.class.getSimpleName(), "uin=?", new String[] { String.valueOf(localRecommendPerson.uin) });
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, List<RecommendPerson> paramList, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetTroopMemRecommendList, success = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",troopUin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopMemberRecommend.Manager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new LinkedHashMap();
    if (paramBoolean)
    {
      localObject = this.b.edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_ActiveMember_ri");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), 0).commit();
      localObject = this.b.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_SameUserInfo_ri");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), 0).commit();
      localObject = this.b.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_CommonBehavior_ri");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), 0).commit();
      localObject = this.b.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_Interactive_ri");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), 0).commit();
      localObject = this.b.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_GroupKOL_ri");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), 0).commit();
      this.c.put(paramString, paramList);
      localObject = a(paramList, paramString);
    }
    c().notifyUI(1, paramBoolean, new Object[] { localObject, paramString, Integer.valueOf(3) });
  }
  
  boolean a(int paramInt, String paramString)
  {
    Object localObject = a();
    long l1 = 0L;
    StringBuilder localStringBuilder;
    if (paramInt == 11)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_LeftSlide_fetch_ts");
      localStringBuilder.append(paramString);
      l1 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 0L);
    }
    else if (paramInt == 12)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_AIO_fetch_ts");
      localStringBuilder.append(paramString);
      l1 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 0L);
    }
    long l2 = System.currentTimeMillis() / 1000L;
    boolean bool;
    if (l2 > l1) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isTimeToObtainRemote result = ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(",entryId = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",troopUin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",curTimeStamp = ");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(",fetchTimeStamp = ");
      ((StringBuilder)localObject).append(l1);
      QLog.d("TroopMemberRecommend.Manager", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    b();
    int i = b(paramString);
    if (this.a != null)
    {
      if (i <= 0) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("needShowTroopRecommend() troopUin =");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" troopMemRecommendConfBean = ");
        localStringBuilder.append(this.a.toString());
        localStringBuilder.append(" troopMemCount = ");
        localStringBuilder.append(i);
        QLog.d("TroopMemberRecommend.Manager", 2, localStringBuilder.toString());
      }
      if ((this.a.a == 1) && (i > this.a.b)) {
        return true;
      }
    }
    return false;
  }
  
  public int b(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager != null)
    {
      paramString = localTroopManager.g(paramString);
      if (paramString != null) {
        return paramString.wMemberNum;
      }
    }
    return 0;
  }
  
  List<RecommendPerson> b(List<RecommendPerson> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramList.size();
    if (i > 0)
    {
      int k = ((RecommendPerson)paramList.get(0)).cardMaxDisplayPersonNum;
      if (i <= k)
      {
        localArrayList.addAll(paramList);
        return localArrayList;
      }
      int j = this.b.getInt(paramString, 0);
      k += j;
      if (k <= i)
      {
        localArrayList.addAll(paramList.subList(j, k));
        this.b.edit().putInt(paramString, k).commit();
        return localArrayList;
      }
      k %= i;
      localArrayList.addAll(paramList.subList(j, i));
      localArrayList.addAll(paramList.subList(0, k));
      this.b.edit().putInt(paramString, k).commit();
    }
    return localArrayList;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.manager.TroopMemberRecommendManager
 * JD-Core Version:    0.7.0.1
 */