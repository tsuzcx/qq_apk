package com.tencent.mobileqq.nearby.gameroom;

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
  QQAppInterface a;
  EntityManager b;
  protected Object c = new Object();
  protected Object d = new Object();
  protected Map<String, RecentInviteUser> e = new HashMap();
  
  public WerewolvesDataManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    ThreadManager.post(new WerewolvesDataManager.1(this, paramQQAppInterface), 5, null, false);
  }
  
  public List<RecentInviteUser> a()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.c)
    {
      Object localObject4 = this.e.values();
      ??? = ((Collection)localObject4).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject4 = (RecentInviteUser)((Iterator)???).next();
        if (((RecentInviteUser)localObject4).uinType == 0) {
          localArrayList.add(localObject4);
        }
      }
      synchronized (this.d)
      {
        Collections.sort(localArrayList);
        return localArrayList;
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(RecentInviteUser paramRecentInviteUser)
  {
    ThreadManager.post(new WerewolvesDataManager.3(this, paramRecentInviteUser), 5, null, false);
  }
  
  public void a(String arg1, int paramInt, String paramString2)
  {
    String str = RecentInviteUser.getKey(paramInt, ???);
    synchronized (this.c)
    {
      ??? = (RecentInviteUser)this.e.get(str);
      ??? = ???;
      if (??? == null)
      {
        ??? = new RecentInviteUser();
        ((RecentInviteUser)???).uniKey = str;
        synchronized (this.c)
        {
          this.e.put(str, ???);
        }
      }
      ((RecentInviteUser)???).uin = ???;
      ((RecentInviteUser)???).uinType = paramInt;
      ((RecentInviteUser)???).lastInviteId = paramString2;
      synchronized (this.d)
      {
        ((RecentInviteUser)???).lastInviteTime = System.currentTimeMillis();
        a((RecentInviteUser)???);
        return;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, ArrayList<String> paramArrayList, WerewolvesDataManager.GetInviteUserCallback paramGetInviteUserCallback)
  {
    ThreadManager.post(new WerewolvesDataManager.2(this, paramString1, paramString2, paramArrayList, paramGetInviteUserCallback), 8, null, true);
  }
  
  public List<RecentInviteUser> b()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.c)
    {
      Object localObject3 = this.e.values();
      ??? = ((Collection)localObject3).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (RecentInviteUser)((Iterator)???).next();
        if (((RecentInviteUser)localObject3).uinType == 1) {
          localArrayList.add(localObject3);
        }
      }
      Collections.sort(localArrayList);
      return localArrayList;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public boolean b(String paramString1, int paramInt, String paramString2)
  {
    synchronized (this.c)
    {
      paramString1 = (RecentInviteUser)this.e.get(RecentInviteUser.getKey(paramInt, paramString1));
      if (paramString1 != null)
      {
        boolean bool = TextUtils.equals(paramString1.lastInviteId, paramString2);
        return bool;
      }
      return false;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager
 * JD-Core Version:    0.7.0.1
 */