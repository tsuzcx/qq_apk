package com.tencent.open.agent.datamodel;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.open.adapter.CommonDataAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FriendDataManager
{
  protected static byte[] a = new byte[1];
  protected static FriendDataManager b;
  protected List<FriendGroup> c = new ArrayList(20);
  protected List<Friend> d = new ArrayList(5);
  protected List<String> e = new ArrayList(20);
  public int f = -1;
  public int g = -1;
  
  public static FriendDataManager a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new FriendDataManager();
        }
      }
    }
    return b;
  }
  
  public Friend a(int paramInt)
  {
    return (Friend)this.d.get(paramInt);
  }
  
  public Friend a(String paramString)
  {
    Friend localFriend;
    do
    {
      Iterator localIterator1 = this.c.iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((FriendGroup)localIterator1.next()).c.iterator();
      }
      localFriend = (Friend)localIterator2.next();
    } while (!paramString.equals(localFriend.a));
    return localFriend;
    return null;
  }
  
  public void a(List<FriendGroup> paramList, int paramInt1, int paramInt2)
  {
    if (paramList.size() <= 0) {
      return;
    }
    this.f = paramInt1;
    this.g = paramInt2;
    this.c.clear();
    this.d.clear();
    this.e.clear();
    String str2 = CommonDataAdapter.a().b().getResources().getString(2131887883);
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      paramList = (FriendGroup)localIterator1.next();
      if (str2.equals(paramList.b))
      {
        this.d.addAll(paramList.c);
      }
      else
      {
        this.c.add(paramList);
        paramList = paramList.c;
        if (paramList != null)
        {
          Iterator localIterator2 = paramList.iterator();
          while (localIterator2.hasNext())
          {
            Friend localFriend = (Friend)localIterator2.next();
            String str1 = localFriend.c;
            if (str1 != null)
            {
              paramList = str1;
              if (!"".equals(str1)) {}
            }
            else
            {
              paramList = localFriend.b;
            }
            localFriend.i = ChnToSpell.b(paramList, 2);
            localFriend.j = ChnToSpell.b(paramList, 1);
          }
        }
      }
    }
  }
  
  public int b()
  {
    return this.d.size();
  }
  
  public int b(int paramInt)
  {
    List localList = ((FriendGroup)this.c.get(paramInt)).c;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public boolean b(String paramString)
  {
    return this.e.contains(paramString);
  }
  
  public int c()
  {
    return this.c.size();
  }
  
  public String c(int paramInt)
  {
    return ((FriendGroup)this.c.get(paramInt)).b;
  }
  
  public void c(String paramString)
  {
    if (!this.e.contains(paramString)) {
      this.e.add(paramString);
    }
  }
  
  public int d()
  {
    return this.e.size();
  }
  
  public List<Friend> d(int paramInt)
  {
    return ((FriendGroup)this.c.get(paramInt)).c;
  }
  
  public void d(String paramString)
  {
    if (this.e.contains(paramString)) {
      this.e.remove(paramString);
    }
  }
  
  public List<Friend> e()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.c.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((FriendGroup)localIterator1.next()).c.iterator();
      while (localIterator2.hasNext()) {
        localArrayList.add(localIterator2.next());
      }
    }
    return localArrayList;
  }
  
  public List<String> f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.datamodel.FriendDataManager
 * JD-Core Version:    0.7.0.1
 */