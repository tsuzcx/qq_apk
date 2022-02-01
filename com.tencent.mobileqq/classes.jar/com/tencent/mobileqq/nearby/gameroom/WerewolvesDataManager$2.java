package com.tencent.mobileqq.nearby.gameroom;

import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

class WerewolvesDataManager$2
  implements Runnable
{
  WerewolvesDataManager$2(WerewolvesDataManager paramWerewolvesDataManager, String paramString1, String paramString2, ArrayList paramArrayList, WerewolvesDataManager.GetInviteUserCallback paramGetInviteUserCallback) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Random localRandom = new Random(System.currentTimeMillis());
    Object localObject2 = (TroopManager)this.this$0.a.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject1 = ((TroopManager)localObject2).b();
    ((List)localObject1).size();
    Object localObject3 = this.this$0.b();
    int i = 0;
    if ((i < ((List)localObject3).size()) && (localArrayList2.size() < 8))
    {
      localObject4 = (RecentInviteUser)((List)localObject3).get(i);
      localObject5 = new InviteUser();
      if (((TroopManager)localObject2).b(((RecentInviteUser)localObject4).uin) == null) {}
      for (;;)
      {
        i += 1;
        break;
        ((InviteUser)localObject5).jdField_a_of_type_JavaLangString = ((RecentInviteUser)localObject4).uin;
        ((InviteUser)localObject5).jdField_a_of_type_Int = ((RecentInviteUser)localObject4).uinType;
        ((InviteUser)localObject5).b = ContactUtils.a(this.this$0.a, ((InviteUser)localObject5).jdField_a_of_type_JavaLangString, false);
        ((InviteUser)localObject5).jdField_a_of_type_Boolean = this.this$0.a(((InviteUser)localObject5).jdField_a_of_type_JavaLangString, ((InviteUser)localObject5).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
        if ((!localArrayList2.contains(localObject5)) && (!((InviteUser)localObject5).jdField_a_of_type_JavaLangString.equals(this.b))) {
          localArrayList2.add(localObject5);
        }
      }
    }
    localObject2 = this.this$0.a.getProxyManager().a().a(true);
    i = 0;
    while ((localArrayList2.size() < 8) && (i < ((List)localObject2).size()))
    {
      localObject3 = (RecentUser)((List)localObject2).get(i);
      if ((((RecentUser)localObject3).getType() == 1) && (!((IHotChatUtil)QRoute.api(IHotChatUtil.class)).checkIsHCRecentUser(this.this$0.a, (RecentUser)localObject3)) && (!Utils.a(((RecentUser)localObject3).uin)) && (((RecentUser)localObject3).lFlag != 16L))
      {
        localObject4 = new InviteUser();
        ((InviteUser)localObject4).jdField_a_of_type_JavaLangString = ((RecentUser)localObject3).uin;
        ((InviteUser)localObject4).jdField_a_of_type_Int = ((RecentUser)localObject3).getType();
        ((InviteUser)localObject4).b = ContactUtils.a(this.this$0.a, ((InviteUser)localObject4).jdField_a_of_type_JavaLangString, false);
        ((InviteUser)localObject4).jdField_a_of_type_Boolean = this.this$0.a(((InviteUser)localObject4).jdField_a_of_type_JavaLangString, ((InviteUser)localObject4).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
        if ((!localArrayList2.contains(localObject4)) && (!((InviteUser)localObject4).jdField_a_of_type_JavaLangString.equals(this.b))) {
          localArrayList2.add(localObject4);
        }
      }
      i += 1;
    }
    if (((List)localObject1).size() > 0)
    {
      i = 0;
      while ((localArrayList2.size() < 8) && (i < 100))
      {
        localObject3 = (Entity)((List)localObject1).get(localRandom.nextInt(((List)localObject1).size()));
        if ((localObject3 instanceof TroopInfo))
        {
          localObject3 = (TroopInfo)localObject3;
          localObject4 = new InviteUser();
          ((InviteUser)localObject4).jdField_a_of_type_JavaLangString = ((TroopInfo)localObject3).troopuin;
          ((InviteUser)localObject4).jdField_a_of_type_Int = 1;
          ((InviteUser)localObject4).b = ((TroopInfo)localObject3).getTroopDisplayName();
          ((InviteUser)localObject4).jdField_a_of_type_Boolean = this.this$0.a(((InviteUser)localObject4).jdField_a_of_type_JavaLangString, ((InviteUser)localObject4).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
          if ((!localArrayList2.contains(localObject4)) && (!((InviteUser)localObject4).jdField_a_of_type_JavaLangString.equals(this.b))) {
            localArrayList2.add(localObject4);
          }
        }
        i += 1;
      }
    }
    localObject3 = this.this$0.a.getCurrentAccountUin();
    Object localObject4 = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)this.this$0.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject5 = localFriendsManager.c();
    int j;
    if (localObject5 == null) {
      j = 0;
    } else {
      j = ((List)localObject5).size();
    }
    Object localObject6;
    if ((localObject5 != null) && (((List)localObject5).size() > 0))
    {
      i = 0;
      while ((((List)localObject4).size() < 8) && (i < 100))
      {
        localObject1 = (Entity)((List)localObject5).get(localRandom.nextInt(((List)localObject5).size()));
        if ((localObject1 instanceof Friends))
        {
          localObject1 = (Friends)localObject1;
          if (((String)localObject3).equals(((Friends)localObject1).uin))
          {
            i += 1;
            continue;
          }
          int k = OnlineStatusUtils.a(((Friends)localObject1).detalStatusFlag, ((Friends)localObject1).iTermType);
          if ((k != 4) && (k != 3))
          {
            i += 1;
            continue;
          }
          localObject6 = new InviteUser();
          ((InviteUser)localObject6).jdField_a_of_type_JavaLangString = ((Friends)localObject1).uin;
          ((InviteUser)localObject6).jdField_a_of_type_Int = 0;
          ((InviteUser)localObject6).b = ContactUtils.c(this.this$0.a, ((InviteUser)localObject6).jdField_a_of_type_JavaLangString);
          ((InviteUser)localObject6).jdField_a_of_type_Boolean = this.this$0.a(((InviteUser)localObject6).jdField_a_of_type_JavaLangString, ((InviteUser)localObject6).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
          if (!((List)localObject4).contains(localObject6)) {
            ((List)localObject4).add(localObject6);
          }
        }
        i += 1;
      }
    }
    localObject1 = this.this$0.a();
    i = 0;
    while ((((List)localObject4).size() < 8) && (i < ((List)localObject1).size()))
    {
      localObject6 = (RecentInviteUser)((List)localObject1).get(i);
      if (((String)localObject3).equals(((RecentInviteUser)localObject6).uin)) {}
      while ((j < 1000) && (!localFriendsManager.b(((RecentInviteUser)localObject6).uin)))
      {
        i += 1;
        break;
      }
      InviteUser localInviteUser = new InviteUser();
      localInviteUser.jdField_a_of_type_JavaLangString = ((RecentInviteUser)localObject6).uin;
      localInviteUser.jdField_a_of_type_Int = ((RecentInviteUser)localObject6).uinType;
      localInviteUser.b = ContactUtils.c(this.this$0.a, localInviteUser.jdField_a_of_type_JavaLangString);
      localInviteUser.jdField_a_of_type_Boolean = this.this$0.a(localInviteUser.jdField_a_of_type_JavaLangString, localInviteUser.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      if (!((List)localObject4).contains(localInviteUser)) {
        ((List)localObject4).add(localInviteUser);
      }
      i += 1;
    }
    localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      i = 0;
      while ((((List)localObject4).size() < 8) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        localObject1 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((!((String)localObject3).equals(localObject1)) && (localFriendsManager.b((String)localObject1)))
        {
          localObject6 = new InviteUser();
          ((InviteUser)localObject6).jdField_a_of_type_JavaLangString = ((String)localObject1);
          ((InviteUser)localObject6).jdField_a_of_type_Int = 0;
          ((InviteUser)localObject6).b = ContactUtils.c(this.this$0.a, ((InviteUser)localObject6).jdField_a_of_type_JavaLangString);
          ((InviteUser)localObject6).jdField_a_of_type_Boolean = this.this$0.a(((InviteUser)localObject6).jdField_a_of_type_JavaLangString, ((InviteUser)localObject6).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
          if (!((List)localObject4).contains(localObject6)) {
            ((List)localObject4).add(localObject6);
          }
        }
        i += 1;
      }
    }
    i = 0;
    if ((((List)localObject4).size() < 8) && (i < ((List)localObject2).size()))
    {
      localObject1 = (RecentUser)((List)localObject2).get(i);
      if (((String)localObject3).equals(((RecentUser)localObject1).uin)) {}
      for (;;)
      {
        i += 1;
        break;
        if ((((RecentUser)localObject1).getType() == 0) && (!Utils.a(((RecentUser)localObject1).uin)) && (((RecentUser)localObject1).lFlag != 16L) && (!CrmUtils.a(this.this$0.a, ((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType())))
        {
          localObject6 = new InviteUser();
          ((InviteUser)localObject6).jdField_a_of_type_JavaLangString = ((RecentUser)localObject1).uin;
          ((InviteUser)localObject6).jdField_a_of_type_Int = ((RecentUser)localObject1).getType();
          ((InviteUser)localObject6).b = ContactUtils.c(this.this$0.a, ((InviteUser)localObject6).jdField_a_of_type_JavaLangString);
          ((InviteUser)localObject6).jdField_a_of_type_Boolean = this.this$0.a(((InviteUser)localObject6).jdField_a_of_type_JavaLangString, ((InviteUser)localObject6).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
          if ((!((List)localObject4).contains(localObject6)) && (localFriendsManager.b(((RecentUser)localObject1).uin))) {
            ((List)localObject4).add(localObject6);
          }
        }
      }
    }
    if ((localObject5 != null) && (((List)localObject5).size() > 0))
    {
      i = 0;
      while ((((List)localObject4).size() < 8) && (i < 100))
      {
        localObject1 = (Entity)((List)localObject5).get(localRandom.nextInt(((List)localObject5).size()));
        if ((localObject1 instanceof Friends))
        {
          localObject1 = (Friends)localObject1;
          if (!((String)localObject3).equals(((Friends)localObject1).uin))
          {
            localObject2 = new InviteUser();
            ((InviteUser)localObject2).jdField_a_of_type_JavaLangString = ((Friends)localObject1).uin;
            ((InviteUser)localObject2).jdField_a_of_type_Int = 0;
            ((InviteUser)localObject2).b = ContactUtils.c(this.this$0.a, ((InviteUser)localObject2).jdField_a_of_type_JavaLangString);
            ((InviteUser)localObject2).jdField_a_of_type_Boolean = this.this$0.a(((InviteUser)localObject2).jdField_a_of_type_JavaLangString, ((InviteUser)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
            if (!((List)localObject4).contains(localObject2)) {
              ((List)localObject4).add(localObject2);
            }
          }
        }
        i += 1;
      }
    }
    if ((localArrayList2.size() >= 4) && (((List)localObject4).size() >= 4))
    {
      localArrayList1.addAll(localArrayList2.subList(0, 4));
      localArrayList1.addAll(((List)localObject4).subList(0, 4));
    }
    else if ((localArrayList2.size() < 4) && (((List)localObject4).size() < 4))
    {
      localArrayList1.addAll(localArrayList2);
      localArrayList1.addAll((Collection)localObject4);
    }
    else if ((localArrayList2.size() >= 4) && (((List)localObject4).size() < 4))
    {
      i = 8 - ((List)localObject4).size();
      if (localArrayList2.size() >= i) {
        localArrayList1.addAll(localArrayList2.subList(0, i));
      } else {
        localArrayList1.addAll(localArrayList2);
      }
      localArrayList1.addAll((Collection)localObject4);
    }
    else
    {
      i = 8 - localArrayList2.size();
      localArrayList1.addAll(localArrayList2);
      if (((List)localObject4).size() >= i) {
        localArrayList1.addAll(((List)localObject4).subList(0, i));
      } else {
        localArrayList1.addAll((Collection)localObject4);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomWerewolvesDataManager$GetInviteUserCallback.a(localArrayList1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager.2
 * JD-Core Version:    0.7.0.1
 */