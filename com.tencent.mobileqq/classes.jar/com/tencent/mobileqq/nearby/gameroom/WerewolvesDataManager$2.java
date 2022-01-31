package com.tencent.mobileqq.nearby.gameroom;

import aloz;
import amjk;
import aupu;
import auvk;
import auvl;
import auvm;
import awbv;
import bdal;
import bdbt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import ndv;

public class WerewolvesDataManager$2
  implements Runnable
{
  public WerewolvesDataManager$2(auvk paramauvk, String paramString1, String paramString2, ArrayList paramArrayList, auvl paramauvl) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Random localRandom = new Random(System.currentTimeMillis());
    Object localObject1 = (TroopManager)this.this$0.a.getManager(52);
    Object localObject2 = ((TroopManager)localObject1).a();
    ((List)localObject2).size();
    Object localObject3 = this.this$0.b();
    int i = 0;
    while ((i < ((List)localObject3).size()) && (localArrayList2.size() < 8))
    {
      localObject4 = (RecentInviteUser)((List)localObject3).get(i);
      localObject5 = new auvm(this.this$0);
      if (((TroopManager)localObject1).b(((RecentInviteUser)localObject4).uin) == null)
      {
        i += 1;
      }
      else
      {
        ((auvm)localObject5).jdField_a_of_type_JavaLangString = ((RecentInviteUser)localObject4).uin;
        ((auvm)localObject5).jdField_a_of_type_Int = ((RecentInviteUser)localObject4).uinType;
        ((auvm)localObject5).b = bdbt.a(this.this$0.a, ((auvm)localObject5).jdField_a_of_type_JavaLangString, false);
        ((auvm)localObject5).jdField_a_of_type_Boolean = this.this$0.a(((auvm)localObject5).jdField_a_of_type_JavaLangString, ((auvm)localObject5).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
        if ((!localArrayList2.contains(localObject5)) && (!((auvm)localObject5).jdField_a_of_type_JavaLangString.equals(this.b))) {
          localArrayList2.add(localObject5);
        }
        i += 1;
      }
    }
    localObject1 = this.this$0.a.a().a().a(true);
    i = 0;
    while ((localArrayList2.size() < 8) && (i < ((List)localObject1).size()))
    {
      localObject3 = (RecentUser)((List)localObject1).get(i);
      if ((((RecentUser)localObject3).getType() == 1) && (!aupu.a(this.this$0.a, (RecentUser)localObject3)) && (!bdal.a(((RecentUser)localObject3).uin)) && (((RecentUser)localObject3).lFlag != 16L))
      {
        localObject4 = new auvm(this.this$0);
        ((auvm)localObject4).jdField_a_of_type_JavaLangString = ((RecentUser)localObject3).uin;
        ((auvm)localObject4).jdField_a_of_type_Int = ((RecentUser)localObject3).getType();
        ((auvm)localObject4).b = bdbt.a(this.this$0.a, ((auvm)localObject4).jdField_a_of_type_JavaLangString, false);
        ((auvm)localObject4).jdField_a_of_type_Boolean = this.this$0.a(((auvm)localObject4).jdField_a_of_type_JavaLangString, ((auvm)localObject4).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
        if ((!localArrayList2.contains(localObject4)) && (!((auvm)localObject4).jdField_a_of_type_JavaLangString.equals(this.b))) {
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
        localObject3 = (awbv)((List)localObject2).get(localRandom.nextInt(((List)localObject2).size()));
        if ((localObject3 instanceof TroopInfo))
        {
          localObject3 = (TroopInfo)localObject3;
          localObject4 = new auvm(this.this$0);
          ((auvm)localObject4).jdField_a_of_type_JavaLangString = ((TroopInfo)localObject3).troopuin;
          ((auvm)localObject4).jdField_a_of_type_Int = 1;
          ((auvm)localObject4).b = ((TroopInfo)localObject3).getTroopName();
          ((auvm)localObject4).jdField_a_of_type_Boolean = this.this$0.a(((auvm)localObject4).jdField_a_of_type_JavaLangString, ((auvm)localObject4).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
          if ((!localArrayList2.contains(localObject4)) && (!((auvm)localObject4).jdField_a_of_type_JavaLangString.equals(this.b))) {
            localArrayList2.add(localObject4);
          }
        }
        i += 1;
      }
    }
    localObject2 = this.this$0.a.getCurrentAccountUin();
    localObject3 = new ArrayList();
    Object localObject5 = (aloz)this.this$0.a.getManager(51);
    Object localObject4 = ((aloz)localObject5).d();
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
        localObject6 = (awbv)((List)localObject4).get(localRandom.nextInt(((List)localObject4).size()));
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
          int k = bdbt.a(((Friends)localObject6).detalStatusFlag, ((Friends)localObject6).iTermType);
          if ((k != 4) && (k != 3))
          {
            i += 1;
            continue;
          }
          localObject7 = new auvm(this.this$0);
          ((auvm)localObject7).jdField_a_of_type_JavaLangString = ((Friends)localObject6).uin;
          ((auvm)localObject7).jdField_a_of_type_Int = 0;
          ((auvm)localObject7).b = bdbt.i(this.this$0.a, ((auvm)localObject7).jdField_a_of_type_JavaLangString);
          ((auvm)localObject7).jdField_a_of_type_Boolean = this.this$0.a(((auvm)localObject7).jdField_a_of_type_JavaLangString, ((auvm)localObject7).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
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
      else if ((j < 1000) && (!((aloz)localObject5).b(((RecentInviteUser)localObject7).uin)))
      {
        i += 1;
      }
      else
      {
        auvm localauvm = new auvm(this.this$0);
        localauvm.jdField_a_of_type_JavaLangString = ((RecentInviteUser)localObject7).uin;
        localauvm.jdField_a_of_type_Int = ((RecentInviteUser)localObject7).uinType;
        localauvm.b = bdbt.i(this.this$0.a, localauvm.jdField_a_of_type_JavaLangString);
        localauvm.jdField_a_of_type_Boolean = this.this$0.a(localauvm.jdField_a_of_type_JavaLangString, localauvm.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
        if (!((List)localObject3).contains(localauvm)) {
          ((List)localObject3).add(localauvm);
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
        if ((((String)localObject2).equals(localObject6)) || (!((aloz)localObject5).b((String)localObject6)))
        {
          i += 1;
        }
        else
        {
          localObject7 = new auvm(this.this$0);
          ((auvm)localObject7).jdField_a_of_type_JavaLangString = ((String)localObject6);
          ((auvm)localObject7).jdField_a_of_type_Int = 0;
          ((auvm)localObject7).b = bdbt.i(this.this$0.a, ((auvm)localObject7).jdField_a_of_type_JavaLangString);
          ((auvm)localObject7).jdField_a_of_type_Boolean = this.this$0.a(((auvm)localObject7).jdField_a_of_type_JavaLangString, ((auvm)localObject7).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
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
        if ((((RecentUser)localObject6).getType() == 0) && (!bdal.a(((RecentUser)localObject6).uin)) && (((RecentUser)localObject6).lFlag != 16L) && (!ndv.b(this.this$0.a, ((RecentUser)localObject6).uin, ((RecentUser)localObject6).getType())))
        {
          localObject7 = new auvm(this.this$0);
          ((auvm)localObject7).jdField_a_of_type_JavaLangString = ((RecentUser)localObject6).uin;
          ((auvm)localObject7).jdField_a_of_type_Int = ((RecentUser)localObject6).getType();
          ((auvm)localObject7).b = bdbt.i(this.this$0.a, ((auvm)localObject7).jdField_a_of_type_JavaLangString);
          ((auvm)localObject7).jdField_a_of_type_Boolean = this.this$0.a(((auvm)localObject7).jdField_a_of_type_JavaLangString, ((auvm)localObject7).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
          if ((!((List)localObject3).contains(localObject7)) && (((aloz)localObject5).b(((RecentUser)localObject6).uin))) {
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
        localObject1 = (awbv)((List)localObject4).get(localRandom.nextInt(((List)localObject4).size()));
        if ((localObject1 instanceof Friends))
        {
          localObject1 = (Friends)localObject1;
          if (((String)localObject2).equals(((Friends)localObject1).uin))
          {
            i += 1;
            continue;
          }
          localObject5 = new auvm(this.this$0);
          ((auvm)localObject5).jdField_a_of_type_JavaLangString = ((Friends)localObject1).uin;
          ((auvm)localObject5).jdField_a_of_type_Int = 0;
          ((auvm)localObject5).b = bdbt.i(this.this$0.a, ((auvm)localObject5).jdField_a_of_type_JavaLangString);
          ((auvm)localObject5).jdField_a_of_type_Boolean = this.this$0.a(((auvm)localObject5).jdField_a_of_type_JavaLangString, ((auvm)localObject5).jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_Auvl.a(localArrayList1, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager.2
 * JD-Core Version:    0.7.0.1
 */