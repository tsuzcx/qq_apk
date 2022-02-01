package com.tencent.mobileqq.guild.main;

import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IBaseChnnPreItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AppTroopItemShowManager
{
  private static AppTroopItemShowManager a;
  private Map<String, List<IBaseChnnPreItemInfo>> b = new HashMap();
  private Set<String> c = new HashSet();
  private Set<String> d = new HashSet();
  
  public static AppTroopItemShowManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AppTroopItemShowManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(String paramString, List<IBaseChnnPreItemInfo> paramList)
  {
    this.c.add(paramString);
    this.b.put(paramString, paramList);
  }
  
  public void a(List<IAppChnnPreInfo> paramList)
  {
    this.d.clear();
    if ((paramList != null) && (paramList.size() != 0))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateShouldRefresh appChnnPreInfos size：");
        ((StringBuilder)localObject).append(paramList.size());
        QLog.i("AppTroopItemShowManager", 4, ((StringBuilder)localObject).toString());
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (IAppChnnPreInfo)paramList.next();
        this.d.add(((IAppChnnPreInfo)localObject).b());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AppTroopItemShowManager", 4, "updateShouldRefresh appChnnPreInfos is empty");
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool;
    if (!this.c.contains(paramString))
    {
      this.c.add(paramString);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" is first show:");
      localStringBuilder.append(bool);
      QLog.i("AppTroopItemShowManager", 1, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AppTroopItemShowManager", 1, "initShowStatus");
    }
    this.c.clear();
    this.d.clear();
  }
  
  public boolean b(String paramString)
  {
    boolean bool;
    if (this.d.contains(paramString))
    {
      this.d.remove(paramString);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" can refresh:");
      localStringBuilder.append(bool);
      QLog.i("AppTroopItemShowManager", 1, localStringBuilder.toString());
    }
    return bool;
  }
  
  public List<IBaseChnnPreItemInfo> c(String paramString)
  {
    return (List)this.b.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.AppTroopItemShowManager
 * JD-Core Version:    0.7.0.1
 */