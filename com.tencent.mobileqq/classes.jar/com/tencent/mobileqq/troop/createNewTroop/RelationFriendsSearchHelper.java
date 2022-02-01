package com.tencent.mobileqq.troop.createNewTroop;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.fts.TroopIndex;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class RelationFriendsSearchHelper
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString = "RelationFriendsSearchHelper";
  
  public RelationFriendsSearchHelper(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public ArrayList<Entity> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("RelationFriendsSearchHelper", 1, "uin empty");
      return null;
    }
    Object localObject2 = (FTSTroopOperator)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a(2);
    Object localObject1 = ((FTSTroopOperator)localObject2).a(paramString);
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      QLog.e("RelationFriendsSearchHelper", 1, "Search ftsEntities empty");
      return null;
    }
    Object localObject3 = new HashMap();
    long l2 = NetConnInfoCenter.getServerTime();
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    long l1 = 0L;
    int i = 0;
    int j = 0;
    long l3;
    if (j < ((List)localObject1).size())
    {
      localObject5 = (TroopIndex)((List)localObject1).get(j);
      if (!((HashMap)localObject3).containsKey(((TroopIndex)localObject5).mTroopUin))
      {
        localObject6 = ((RecentUserProxy)localObject4).a(((TroopIndex)localObject5).mTroopUin, 1);
        if ((localObject6 != null) && (((RecentUser)localObject6).lastmsgtime > 0L))
        {
          l3 = 100L + l2 - ((RecentUser)localObject6).lastmsgtime;
          if (l3 < 0L) {}
          ((HashMap)localObject3).put(((TroopIndex)localObject5).mTroopUin, Long.valueOf(l3));
          i += 1;
          l1 += l3;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        ((HashMap)localObject3).put(((TroopIndex)localObject5).mTroopUin, Long.valueOf(0L));
      }
    }
    long l4 = System.currentTimeMillis();
    localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject5 = new HashMap();
    float f3 = 1.0F / ((HashMap)localObject3).size();
    Object localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Iterator localIterator = ((HashMap)localObject3).keySet().iterator();
    l2 = 0L;
    Object localObject7;
    float f1;
    if (localIterator.hasNext())
    {
      localObject7 = (String)localIterator.next();
      l3 = ((Long)((HashMap)localObject3).get(localObject7)).longValue();
      if ((l3 <= 0L) || (l1 <= 0L)) {
        break label1124;
      }
      f1 = (0.0F + (float)l3) / (float)l1;
      if ((f1 > 1.0F) || (i <= 0)) {
        break label1119;
      }
      if (i == 1)
      {
        f1 = 1.0F;
        label390:
        f2 = f1;
        if (QLog.isColorLevel()) {
          QLog.i("RelationFriendsSearchHelper", 2, "troopUin:" + (String)localObject7 + ",delta:" + l3 + "troopActiveFator_delta:" + f1);
        }
      }
    }
    label673:
    label1119:
    label1124:
    for (float f2 = f1;; f2 = 0.0F)
    {
      l3 = System.currentTimeMillis();
      localObject7 = ((FTSTroopOperator)localObject2).b((String)localObject7);
      l3 = l2 + (System.currentTimeMillis() - l3);
      if ((localObject7 == null) || (((List)localObject7).size() == 0))
      {
        QLog.e("RelationFriendsSearchHelper", 1, "Search ftsMembers empty");
        l2 = l3;
        break;
        f1 = (1.0F - f1) / (i - 1);
        break label390;
      }
      j = 0;
      l2 = l3;
      if (j >= ((List)localObject7).size()) {
        break;
      }
      Object localObject8 = (TroopIndex)((List)localObject7).get(j);
      if ((((FriendsManager)localObject1).b(((TroopIndex)localObject8).mMemberUin)) && (!((String)localObject6).equals(((TroopIndex)localObject8).mMemberUin)) && (!paramString.equals(((TroopIndex)localObject8).mMemberUin)))
      {
        if (((HashMap)localObject5).containsKey(((TroopIndex)localObject8).mMemberUin)) {
          break label673;
        }
        RelationFriendsSearchHelper.MemberScore localMemberScore = new RelationFriendsSearchHelper.MemberScore(this, f3);
        localMemberScore.b = f2;
        localMemberScore.jdField_a_of_type_Int = 1;
        RecentUser localRecentUser = ((RecentUserProxy)localObject4).a(((TroopIndex)localObject8).mMemberUin, 0);
        if (localRecentUser != null) {
          localMemberScore.jdField_a_of_type_Long = localRecentUser.lastmsgtime;
        }
        ((HashMap)localObject5).put(((TroopIndex)localObject8).mMemberUin, localMemberScore);
      }
      for (;;)
      {
        j += 1;
        break;
        localObject8 = (RelationFriendsSearchHelper.MemberScore)((HashMap)localObject5).get(((TroopIndex)localObject8).mMemberUin);
        ((RelationFriendsSearchHelper.MemberScore)localObject8).jdField_a_of_type_Int += 1;
        ((RelationFriendsSearchHelper.MemberScore)localObject8).b += f2;
      }
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsSearchHelper", 2, "timecost:" + (System.currentTimeMillis() - l4) + "querycostmember:" + l2 + ",troopsSize:" + ((HashMap)localObject3).size() + "Members:" + ((HashMap)localObject5).size());
      }
      paramString = new ArrayList(((HashMap)localObject5).entrySet());
      Collections.sort(paramString, new RelationFriendsSearchHelper.1(this));
      i = paramString.size();
      if ((i > 1) && (((RelationFriendsSearchHelper.MemberScore)((Map.Entry)paramString.get(i - 1)).getValue()).a() == ((RelationFriendsSearchHelper.MemberScore)((Map.Entry)paramString.get(0)).getValue()).a())) {}
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("RelationFriendsSearchHelper", 2, "isAllMemberScoreEqual");
          }
          Collections.sort(paramString, new RelationFriendsSearchHelper.2(this));
        }
        localObject2 = new ArrayList();
        i = 0;
        if (i < paramString.size())
        {
          localObject3 = (RelationFriendsSearchHelper.MemberScore)((Map.Entry)paramString.get(i)).getValue();
          localObject4 = ((FriendsManager)localObject1).b((String)((Map.Entry)paramString.get(i)).getKey());
          if (localObject4 != null)
          {
            ((ArrayList)localObject2).add(localObject4);
            if ((i < 20) && (QLog.isColorLevel())) {
              QLog.i("RelationFriendsSearchHelper", 2, "top20:uin" + StringUtil.e(((Friends)localObject4).uin) + ",scores:" + ((RelationFriendsSearchHelper.MemberScore)localObject3).a() + ",frequency:" + ((RelationFriendsSearchHelper.MemberScore)localObject3).jdField_a_of_type_Int + ",activefactor:" + ((RelationFriendsSearchHelper.MemberScore)localObject3).b + ",c2clastmsgtime:" + ((RelationFriendsSearchHelper.MemberScore)localObject3).jdField_a_of_type_Long);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            if (QLog.isColorLevel()) {
              QLog.i("RelationFriendsSearchHelper", 2, "friends null");
            }
          }
        }
        return localObject2;
      }
      f1 = 0.0F;
      break label390;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.RelationFriendsSearchHelper
 * JD-Core Version:    0.7.0.1
 */