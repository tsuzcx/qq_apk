package com.tencent.mobileqq.troop.api.troopcreate.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.fts.data.troop.TroopIndex;
import com.tencent.mobileqq.fts.query.QueryArgs;
import com.tencent.mobileqq.fts.query.QueryArgs.Builder;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.troop.api.troopcreate.IRelationFriendsSearchHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class RelationFriendsSearchHelperImpl
  implements IRelationFriendsSearchHelper
{
  private static final String TAG = "RelationFriendsSearchHelperImpl";
  
  public ArrayList<Entity> search(String paramString, AppInterface paramAppInterface)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("RelationFriendsSearchHelperImpl", 1, "uin empty");
      return null;
    }
    Object localObject2 = (QQAppInterface)paramAppInterface;
    paramAppInterface = (IFTSDBRuntimeService)((QQAppInterface)localObject2).getRuntimeService(IFTSDBRuntimeService.class, "");
    paramAppInterface = new QueryArgs.Builder((AppRuntime)localObject2).a(1).a(paramString).a().a();
    if ((paramAppInterface != null) && (paramAppInterface.size() != 0))
    {
      Object localObject1 = new HashMap();
      long l2 = NetConnInfoCenter.getServerTime() + 100L;
      Object localObject4 = ((QQAppInterface)localObject2).getProxyManager().g();
      int j = 0;
      int i = 0;
      long l1 = 0L;
      while (j < paramAppInterface.size())
      {
        localObject3 = (TroopIndex)paramAppInterface.get(j);
        if (!((HashMap)localObject1).containsKey(((TroopIndex)localObject3).mTroopUin))
        {
          localObject5 = ((RecentUserProxy)localObject4).b(((TroopIndex)localObject3).mTroopUin, 1);
          if ((localObject5 != null) && (((RecentUser)localObject5).lastmsgtime > 0L))
          {
            l3 = l2 - ((RecentUser)localObject5).lastmsgtime;
            i += 1;
            l1 += l3;
            ((HashMap)localObject1).put(((TroopIndex)localObject3).mTroopUin, Long.valueOf(l3));
          }
          else
          {
            ((HashMap)localObject1).put(((TroopIndex)localObject3).mTroopUin, Long.valueOf(0L));
          }
        }
        j += 1;
      }
      l2 = System.currentTimeMillis();
      Object localObject3 = (IFriendDataService)((QQAppInterface)localObject2).getRuntimeService(IFriendDataService.class, "");
      Object localObject5 = new HashMap();
      float f2 = 1.0F / ((HashMap)localObject1).size();
      String str = ((QQAppInterface)localObject2).getCurrentAccountUin();
      Iterator localIterator = ((HashMap)localObject1).keySet().iterator();
      long l3 = 0L;
      paramAppInterface = (AppInterface)localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        long l4 = ((Long)((HashMap)localObject1).get(localObject2)).longValue();
        float f1;
        Object localObject6;
        if ((l4 > 0L) && (l1 > 0L))
        {
          f1 = ((float)l4 + 0.0F) / (float)l1;
          if ((f1 <= 1.0F) && (i > 0))
          {
            if (i == 1) {
              f1 = 1.0F;
            } else {
              f1 = (1.0F - f1) / (i - 1);
            }
          }
          else {
            f1 = 0.0F;
          }
          if (QLog.isColorLevel())
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("troopUin:");
            ((StringBuilder)localObject6).append((String)localObject2);
            ((StringBuilder)localObject6).append(",delta:");
            ((StringBuilder)localObject6).append(l4);
            ((StringBuilder)localObject6).append("troopActiveFator_delta:");
            ((StringBuilder)localObject6).append(f1);
            QLog.i("RelationFriendsSearchHelperImpl", 2, ((StringBuilder)localObject6).toString());
          }
        }
        else
        {
          f1 = 0.0F;
        }
        l4 = System.currentTimeMillis();
        localObject2 = new QueryArgs.Builder(paramAppInterface).a(2).a((String)localObject2).a().a();
        l3 += System.currentTimeMillis() - l4;
        if ((localObject2 != null) && (((List)localObject2).size() != 0))
        {
          j = 0;
          while (j < ((List)localObject2).size())
          {
            localObject6 = (TroopIndex)((List)localObject2).get(j);
            if ((((IFriendDataService)localObject3).isFriend(((TroopIndex)localObject6).mMemberUin)) && (!str.equals(((TroopIndex)localObject6).mMemberUin)) && (!paramString.equals(((TroopIndex)localObject6).mMemberUin))) {
              if (!((HashMap)localObject5).containsKey(((TroopIndex)localObject6).mMemberUin))
              {
                RelationFriendsSearchHelperImpl.MemberScore localMemberScore = new RelationFriendsSearchHelperImpl.MemberScore(f2);
                localMemberScore.b = f1;
                localMemberScore.c = 1;
                RecentUser localRecentUser = ((RecentUserProxy)localObject4).b(((TroopIndex)localObject6).mMemberUin, 0);
                if (localRecentUser != null) {
                  localMemberScore.d = localRecentUser.lastmsgtime;
                }
                ((HashMap)localObject5).put(((TroopIndex)localObject6).mMemberUin, localMemberScore);
              }
              else
              {
                localObject6 = (RelationFriendsSearchHelperImpl.MemberScore)((HashMap)localObject5).get(((TroopIndex)localObject6).mMemberUin);
                ((RelationFriendsSearchHelperImpl.MemberScore)localObject6).c += 1;
                ((RelationFriendsSearchHelperImpl.MemberScore)localObject6).b += f1;
              }
            }
            j += 1;
          }
        }
        else
        {
          QLog.e("RelationFriendsSearchHelperImpl", 1, "Search ftsMembers empty");
        }
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("timecost:");
        paramString.append(System.currentTimeMillis() - l2);
        paramString.append("querycostmember:");
        paramString.append(l3);
        paramString.append(",troopsSize:");
        paramString.append(((HashMap)localObject1).size());
        paramString.append("Members:");
        paramString.append(((HashMap)localObject5).size());
        QLog.i("RelationFriendsSearchHelperImpl", 2, paramString.toString());
      }
      paramString = new ArrayList(((HashMap)localObject5).entrySet());
      Collections.sort(paramString, new RelationFriendsSearchHelperImpl.1(this));
      i = paramString.size();
      if ((i > 1) && (((RelationFriendsSearchHelperImpl.MemberScore)((Map.Entry)paramString.get(i - 1)).getValue()).a() == ((RelationFriendsSearchHelperImpl.MemberScore)((Map.Entry)paramString.get(0)).getValue()).a())) {
        i = 1;
      } else {
        i = 0;
      }
      j = 0;
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("RelationFriendsSearchHelperImpl", 2, "isAllMemberScoreEqual");
        }
        Collections.sort(paramString, new RelationFriendsSearchHelperImpl.2(this));
      }
      paramAppInterface = new ArrayList();
      i = j;
      while (i < paramString.size())
      {
        localObject1 = (RelationFriendsSearchHelperImpl.MemberScore)((Map.Entry)paramString.get(i)).getValue();
        localObject2 = ((IFriendDataService)localObject3).getFriend((String)((Map.Entry)paramString.get(i)).getKey(), true);
        if (localObject2 != null)
        {
          paramAppInterface.add(localObject2);
          if ((i < 20) && (QLog.isColorLevel()))
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("top20:uin");
            ((StringBuilder)localObject4).append(StringUtil.getSimpleUinForPrint(((Friends)localObject2).uin));
            ((StringBuilder)localObject4).append(",scores:");
            ((StringBuilder)localObject4).append(((RelationFriendsSearchHelperImpl.MemberScore)localObject1).a());
            ((StringBuilder)localObject4).append(",frequency:");
            ((StringBuilder)localObject4).append(((RelationFriendsSearchHelperImpl.MemberScore)localObject1).c);
            ((StringBuilder)localObject4).append(",activefactor:");
            ((StringBuilder)localObject4).append(((RelationFriendsSearchHelperImpl.MemberScore)localObject1).b);
            ((StringBuilder)localObject4).append(",c2clastmsgtime:");
            ((StringBuilder)localObject4).append(((RelationFriendsSearchHelperImpl.MemberScore)localObject1).d);
            QLog.i("RelationFriendsSearchHelperImpl", 2, ((StringBuilder)localObject4).toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.i("RelationFriendsSearchHelperImpl", 2, "friends null");
        }
        i += 1;
      }
      return paramAppInterface;
    }
    QLog.e("RelationFriendsSearchHelperImpl", 1, "Search ftsEntities empty");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopcreate.impl.RelationFriendsSearchHelperImpl
 * JD-Core Version:    0.7.0.1
 */