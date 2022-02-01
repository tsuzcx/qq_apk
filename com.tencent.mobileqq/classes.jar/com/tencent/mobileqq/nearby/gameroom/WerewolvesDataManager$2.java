package com.tencent.mobileqq.nearby.gameroom;

import amsw;
import anuz;
import awhn;
import awnd;
import awne;
import awnf;
import bftf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import npt;

public class WerewolvesDataManager$2
  implements Runnable
{
  public WerewolvesDataManager$2(awnd paramawnd, String paramString1, String paramString2, ArrayList paramArrayList, awne paramawne) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Random localRandom = new Random(System.currentTimeMillis());
    Object localObject1 = (TroopManager)this.this$0.a.getManager(52);
    Object localObject2 = ((TroopManager)localObject1).b();
    ((List)localObject2).size();
    Object localObject3 = this.this$0.b();
    int i = 0;
    while ((i < ((List)localObject3).size()) && (localArrayList2.size() < 8))
    {
      localObject4 = (RecentInviteUser)((List)localObject3).get(i);
      localObject5 = new awnf(this.this$0);
      if (((TroopManager)localObject1).b(((RecentInviteUser)localObject4).uin) == null)
      {
        i += 1;
      }
      else
      {
        ((awnf)localObject5).jdField_a_of_type_JavaLangString = ((RecentInviteUser)localObject4).uin;
        ((awnf)localObject5).jdField_a_of_type_Int = ((RecentInviteUser)localObject4).uinType;
        ((awnf)localObject5).b = ContactUtils.getTroopName(this.this$0.a, ((awnf)localObject5).jdField_a_of_type_JavaLangString, false);
        ((awnf)localObject5).jdField_a_of_type_Boolean = this.this$0.a(((awnf)localObject5).jdField_a_of_type_JavaLangString, ((awnf)localObject5).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
        if ((!localArrayList2.contains(localObject5)) && (!((awnf)localObject5).jdField_a_of_type_JavaLangString.equals(this.b))) {
          localArrayList2.add(localObject5);
        }
        i += 1;
      }
    }
    localObject1 = this.this$0.a.getProxyManager().a().getRecentList(true);
    i = 0;
    while ((localArrayList2.size() < 8) && (i < ((List)localObject1).size()))
    {
      localObject3 = (RecentUser)((List)localObject1).get(i);
      if ((((RecentUser)localObject3).getType() == 1) && (!awhn.a(this.this$0.a, (RecentUser)localObject3)) && (!bftf.a(((RecentUser)localObject3).uin)) && (((RecentUser)localObject3).lFlag != 16L))
      {
        localObject4 = new awnf(this.this$0);
        ((awnf)localObject4).jdField_a_of_type_JavaLangString = ((RecentUser)localObject3).uin;
        ((awnf)localObject4).jdField_a_of_type_Int = ((RecentUser)localObject3).getType();
        ((awnf)localObject4).b = ContactUtils.getTroopName(this.this$0.a, ((awnf)localObject4).jdField_a_of_type_JavaLangString, false);
        ((awnf)localObject4).jdField_a_of_type_Boolean = this.this$0.a(((awnf)localObject4).jdField_a_of_type_JavaLangString, ((awnf)localObject4).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
        if ((!localArrayList2.contains(localObject4)) && (!((awnf)localObject4).jdField_a_of_type_JavaLangString.equals(this.b))) {
          localArrayList2.add(localObject4);
        }
      }
      i += 1;
    }
    if (((List)localObject2).size() > 0)
    {
      i = 0;
      while ((localArrayList2.size() < 8) && (i < 100))
      {
        localObject3 = (Entity)((List)localObject2).get(localRandom.nextInt(((List)localObject2).size()));
        if ((localObject3 instanceof TroopInfo))
        {
          localObject3 = (TroopInfo)localObject3;
          localObject4 = new awnf(this.this$0);
          ((awnf)localObject4).jdField_a_of_type_JavaLangString = ((TroopInfo)localObject3).troopuin;
          ((awnf)localObject4).jdField_a_of_type_Int = 1;
          ((awnf)localObject4).b = ((TroopInfo)localObject3).getTroopName();
          ((awnf)localObject4).jdField_a_of_type_Boolean = this.this$0.a(((awnf)localObject4).jdField_a_of_type_JavaLangString, ((awnf)localObject4).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
          if ((!localArrayList2.contains(localObject4)) && (!((awnf)localObject4).jdField_a_of_type_JavaLangString.equals(this.b))) {
            localArrayList2.add(localObject4);
          }
        }
        i += 1;
      }
    }
    localObject2 = this.this$0.a.getCurrentAccountUin();
    localObject3 = new ArrayList();
    Object localObject5 = (amsw)this.this$0.a.getManager(51);
    Object localObject4 = ((amsw)localObject5).d();
    int j;
    Object localObject7;
    if (localObject4 == null)
    {
      j = 0;
      if ((localObject4 != null) && (((List)localObject4).size() > 0)) {
        i = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((((List)localObject3).size() >= 8) || (i >= 100)) {
          break label951;
        }
        localObject6 = (Entity)((List)localObject4).get(localRandom.nextInt(((List)localObject4).size()));
        if ((localObject6 instanceof Friends))
        {
          localObject6 = (Friends)localObject6;
          if (((String)localObject2).equals(((Friends)localObject6).uin))
          {
            i += 1;
            continue;
            j = ((List)localObject4).size();
            break;
          }
          int k = ContactUtils.getFriendStatus(((Friends)localObject6).detalStatusFlag, ((Friends)localObject6).iTermType);
          if ((k != 4) && (k != 3))
          {
            i += 1;
            continue;
          }
          localObject7 = new awnf(this.this$0);
          ((awnf)localObject7).jdField_a_of_type_JavaLangString = ((Friends)localObject6).uin;
          ((awnf)localObject7).jdField_a_of_type_Int = 0;
          ((awnf)localObject7).b = ContactUtils.getFriendNickName(this.this$0.a, ((awnf)localObject7).jdField_a_of_type_JavaLangString);
          ((awnf)localObject7).jdField_a_of_type_Boolean = this.this$0.a(((awnf)localObject7).jdField_a_of_type_JavaLangString, ((awnf)localObject7).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
          if (!((List)localObject3).contains(localObject7)) {
            ((List)localObject3).add(localObject7);
          }
        }
        i += 1;
      }
    }
    label951:
    Object localObject6 = this.this$0.a();
    i = 0;
    while ((((List)localObject3).size() < 8) && (i < ((List)localObject6).size()))
    {
      localObject7 = (RecentInviteUser)((List)localObject6).get(i);
      if (((String)localObject2).equals(((RecentInviteUser)localObject7).uin))
      {
        i += 1;
      }
      else if ((j < 1000) && (!((amsw)localObject5).b(((RecentInviteUser)localObject7).uin)))
      {
        i += 1;
      }
      else
      {
        awnf localawnf = new awnf(this.this$0);
        localawnf.jdField_a_of_type_JavaLangString = ((RecentInviteUser)localObject7).uin;
        localawnf.jdField_a_of_type_Int = ((RecentInviteUser)localObject7).uinType;
        localawnf.b = ContactUtils.getFriendNickName(this.this$0.a, localawnf.jdField_a_of_type_JavaLangString);
        localawnf.jdField_a_of_type_Boolean = this.this$0.a(localawnf.jdField_a_of_type_JavaLangString, localawnf.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
        if (!((List)localObject3).contains(localawnf)) {
          ((List)localObject3).add(localawnf);
        }
        i += 1;
      }
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      i = 0;
      while ((((List)localObject3).size() < 8) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        localObject6 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((((String)localObject2).equals(localObject6)) || (!((amsw)localObject5).b((String)localObject6)))
        {
          i += 1;
        }
        else
        {
          localObject7 = new awnf(this.this$0);
          ((awnf)localObject7).jdField_a_of_type_JavaLangString = ((String)localObject6);
          ((awnf)localObject7).jdField_a_of_type_Int = 0;
          ((awnf)localObject7).b = ContactUtils.getFriendNickName(this.this$0.a, ((awnf)localObject7).jdField_a_of_type_JavaLangString);
          ((awnf)localObject7).jdField_a_of_type_Boolean = this.this$0.a(((awnf)localObject7).jdField_a_of_type_JavaLangString, ((awnf)localObject7).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
          if (!((List)localObject3).contains(localObject7)) {
            ((List)localObject3).add(localObject7);
          }
          i += 1;
        }
      }
    }
    i = 0;
    while ((((List)localObject3).size() < 8) && (i < ((List)localObject1).size()))
    {
      localObject6 = (RecentUser)((List)localObject1).get(i);
      if (((String)localObject2).equals(((RecentUser)localObject6).uin))
      {
        i += 1;
      }
      else
      {
        if ((((RecentUser)localObject6).getType() == 0) && (!bftf.a(((RecentUser)localObject6).uin)) && (((RecentUser)localObject6).lFlag != 16L) && (!npt.b(this.this$0.a, ((RecentUser)localObject6).uin, ((RecentUser)localObject6).getType())))
        {
          localObject7 = new awnf(this.this$0);
          ((awnf)localObject7).jdField_a_of_type_JavaLangString = ((RecentUser)localObject6).uin;
          ((awnf)localObject7).jdField_a_of_type_Int = ((RecentUser)localObject6).getType();
          ((awnf)localObject7).b = ContactUtils.getFriendNickName(this.this$0.a, ((awnf)localObject7).jdField_a_of_type_JavaLangString);
          ((awnf)localObject7).jdField_a_of_type_Boolean = this.this$0.a(((awnf)localObject7).jdField_a_of_type_JavaLangString, ((awnf)localObject7).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
          if ((!((List)localObject3).contains(localObject7)) && (((amsw)localObject5).b(((RecentUser)localObject6).uin))) {
            ((List)localObject3).add(localObject7);
          }
        }
        i += 1;
      }
    }
    if ((localObject4 != null) && (((List)localObject4).size() > 0))
    {
      i = 0;
      while ((((List)localObject3).size() < 8) && (i < 100))
      {
        localObject1 = (Entity)((List)localObject4).get(localRandom.nextInt(((List)localObject4).size()));
        if ((localObject1 instanceof Friends))
        {
          localObject1 = (Friends)localObject1;
          if (((String)localObject2).equals(((Friends)localObject1).uin))
          {
            i += 1;
            continue;
          }
          localObject5 = new awnf(this.this$0);
          ((awnf)localObject5).jdField_a_of_type_JavaLangString = ((Friends)localObject1).uin;
          ((awnf)localObject5).jdField_a_of_type_Int = 0;
          ((awnf)localObject5).b = ContactUtils.getFriendNickName(this.this$0.a, ((awnf)localObject5).jdField_a_of_type_JavaLangString);
          ((awnf)localObject5).jdField_a_of_type_Boolean = this.this$0.a(((awnf)localObject5).jdField_a_of_type_JavaLangString, ((awnf)localObject5).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
          if (!((List)localObject3).contains(localObject5)) {
            ((List)localObject3).add(localObject5);
          }
        }
        i += 1;
      }
    }
    if ((localArrayList2.size() >= 4) && (((List)localObject3).size() >= 4))
    {
      localArrayList1.addAll(localArrayList2.subList(0, 4));
      localArrayList1.addAll(((List)localObject3).subList(0, 4));
    }
    for (;;)
    {
      this.jdField_a_of_type_Awne.a(localArrayList1, true);
      return;
      if ((localArrayList2.size() < 4) && (((List)localObject3).size() < 4))
      {
        localArrayList1.addAll(localArrayList2);
        localArrayList1.addAll((Collection)localObject3);
      }
      else
      {
        if ((localArrayList2.size() >= 4) && (((List)localObject3).size() < 4))
        {
          i = 8 - ((List)localObject3).size();
          if (localArrayList2.size() >= i) {
            localArrayList1.addAll(localArrayList2.subList(0, i));
          }
          for (;;)
          {
            localArrayList1.addAll((Collection)localObject3);
            break;
            localArrayList1.addAll(localArrayList2);
          }
        }
        i = 8 - localArrayList2.size();
        localArrayList1.addAll(localArrayList2);
        if (((List)localObject3).size() >= i) {
          localArrayList1.addAll(((List)localObject3).subList(0, i));
        } else {
          localArrayList1.addAll((Collection)localObject3);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager.2
 * JD-Core Version:    0.7.0.1
 */