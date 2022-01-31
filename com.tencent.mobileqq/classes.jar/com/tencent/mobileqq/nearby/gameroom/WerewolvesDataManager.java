package com.tencent.mobileqq.nearby.gameroom;

import aepn;
import aepo;
import aepp;
import aepq;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.manager.Manager;

public class WerewolvesDataManager
  implements Manager
{
  public QQAppInterface a;
  public EntityManager a;
  public Object a;
  public Map a;
  
  public WerewolvesDataManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ThreadManager.post(new aepn(this, paramQQAppInterface), 5, null, false);
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = this.jdField_a_of_type_JavaUtilMap.values();
      ??? = ((Collection)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (RecentInviteUser)((Iterator)???).next();
        if (((RecentInviteUser)localObject2).uinType == 0) {
          localArrayList.add(localObject2);
        }
      }
    }
    Collections.sort(localList);
    return localList;
  }
  
  public void a(RecentInviteUser paramRecentInviteUser)
  {
    ThreadManager.post(new aepp(this, paramRecentInviteUser), 5, null, false);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    String str = RecentInviteUser.getKey(paramInt, paramString1);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ??? = (RecentInviteUser)this.jdField_a_of_type_JavaUtilMap.get(str);
      ??? = ???;
      if (??? == null)
      {
        ??? = new RecentInviteUser();
        ((RecentInviteUser)???).uniKey = str;
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilMap.put(str, ???);
      ((RecentInviteUser)???).uin = paramString1;
      ((RecentInviteUser)???).uinType = paramInt;
      ((RecentInviteUser)???).lastInviteId = paramString2;
      ((RecentInviteUser)???).lastInviteTime = System.currentTimeMillis();
      a((RecentInviteUser)???);
      return;
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, ArrayList paramArrayList, aepq paramaepq)
  {
    ThreadManager.post(new aepo(this, paramString1, paramString2, paramArrayList, paramaepq), 8, null, true);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramString1 = (RecentInviteUser)this.jdField_a_of_type_JavaUtilMap.get(RecentInviteUser.getKey(paramInt, paramString1));
      if (paramString1 != null)
      {
        boolean bool = TextUtils.equals(paramString1.lastInviteId, paramString2);
        return bool;
      }
      return false;
    }
  }
  
  public List b()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = this.jdField_a_of_type_JavaUtilMap.values();
      ??? = ((Collection)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (RecentInviteUser)((Iterator)???).next();
        if (((RecentInviteUser)localObject2).uinType == 1) {
          localArrayList.add(localObject2);
        }
      }
    }
    Collections.sort(localList);
    return localList;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager
 * JD-Core Version:    0.7.0.1
 */