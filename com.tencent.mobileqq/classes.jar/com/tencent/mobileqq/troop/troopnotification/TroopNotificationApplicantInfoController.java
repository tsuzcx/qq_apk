package com.tencent.mobileqq.troop.troopnotification;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopNotifyApplicantInfo;
import com.tencent.mobileqq.troop.handler.TroopNotificationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class TroopNotificationApplicantInfoController
  extends TroopNotificationController
{
  protected Map<Long, TroopNotifyApplicantInfo> a = new HashMap();
  protected Map<String, ConcurrentHashMap<Long, Integer>> b = new ConcurrentHashMap();
  
  public TroopNotificationApplicantInfoController(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private void c(String paramString, List<Long> paramList)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramList == null) {
        return;
      }
      ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.b.get(paramString);
      ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
      if (localConcurrentHashMap2 == null)
      {
        localConcurrentHashMap1 = new ConcurrentHashMap();
        this.b.put(paramString, localConcurrentHashMap1);
      }
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (Long)paramString.next();
        if (paramList != null) {
          localConcurrentHashMap1.put(paramList, Integer.valueOf(0));
        }
      }
    }
  }
  
  public TroopNotifyApplicantInfo a(Long paramLong)
  {
    TroopNotifyApplicantInfo localTroopNotifyApplicantInfo = (TroopNotifyApplicantInfo)this.a.get(paramLong);
    paramLong = localTroopNotifyApplicantInfo;
    if (localTroopNotifyApplicantInfo != null) {
      paramLong = localTroopNotifyApplicantInfo.k();
    }
    return paramLong;
  }
  
  public List<Long> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    paramString = (ConcurrentHashMap)this.b.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      if ((localLong != null) && (((Integer)paramString.get(localLong)).intValue() == 0))
      {
        localArrayList.add(localLong);
        paramString.put(localLong, Integer.valueOf(1));
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  public void a(Long paramLong, int paramInt, String paramString)
  {
    if (paramLong != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.b.get(paramString);
      ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
      if (localConcurrentHashMap2 == null)
      {
        localConcurrentHashMap1 = new ConcurrentHashMap();
        this.b.put(paramString, localConcurrentHashMap1);
      }
      if (!localConcurrentHashMap1.contains(paramLong)) {
        localConcurrentHashMap1.put(paramLong, Integer.valueOf(paramInt));
      }
    }
  }
  
  public void a(String paramString, List<Long> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      ThreadManager.postImmediately(new TroopNotificationApplicantInfoController.1(this, paramString, paramList), null, false);
    }
  }
  
  public void a(List<TroopNotifyApplicantInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TroopNotifyApplicantInfo localTroopNotifyApplicantInfo = (TroopNotifyApplicantInfo)paramList.next();
        if (localTroopNotifyApplicantInfo != null)
        {
          this.a.put(Long.valueOf(localTroopNotifyApplicantInfo.a()), localTroopNotifyApplicantInfo);
          localArrayList.add(Long.valueOf(localTroopNotifyApplicantInfo.a()));
        }
      }
      a("OidbSvc.0x5eb_troopnotifycation", localArrayList);
    }
  }
  
  public void a(List<Long> paramList, String paramString)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      if (this.c == null)
      {
        c(paramString, paramList);
        return;
      }
      TroopNotificationHandler localTroopNotificationHandler = (TroopNotificationHandler)((AppInterface)this.c).getBusinessHandler(TroopNotificationHandler.class.getName());
      if (localTroopNotificationHandler == null)
      {
        c(paramString, paramList);
        return;
      }
      int i = paramList.size();
      if (i > 70)
      {
        while (i > 0)
        {
          ArrayList localArrayList;
          if (i > 70)
          {
            localArrayList = new ArrayList(paramList.subList(i - 70, i));
            i -= 70;
          }
          else
          {
            localArrayList = new ArrayList(paramList.subList(0, i));
            i = 0;
          }
          localTroopNotificationHandler.a(localArrayList, paramString);
        }
        return;
      }
      localTroopNotificationHandler.a(paramList, paramString);
    }
  }
  
  public void a(Map<Long, Integer> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.isEmpty()) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if (localLong != null)
        {
          localArrayList.add(localLong);
          int i = ((Integer)paramMap.get(localLong)).intValue();
          TroopNotifyApplicantInfo localTroopNotifyApplicantInfo = (TroopNotifyApplicantInfo)this.a.get(localLong);
          if (localTroopNotifyApplicantInfo != null)
          {
            localTroopNotifyApplicantInfo.c(i);
            localTroopNotifyApplicantInfo.b(true);
          }
          else
          {
            localTroopNotifyApplicantInfo = new TroopNotifyApplicantInfo(localLong.longValue(), i, true);
            this.a.put(localLong, localTroopNotifyApplicantInfo);
          }
        }
      }
      a("OidbSvc.0x668", localArrayList);
    }
  }
  
  public void b()
  {
    super.b();
    this.b.clear();
    this.a.clear();
  }
  
  protected void b(String paramString, List<Long> paramList)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramList == null) {
        return;
      }
      paramString = (ConcurrentHashMap)this.b.get(paramString);
      if (paramString == null) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramString.remove((Long)paramList.next());
      }
    }
  }
  
  public void c()
  {
    b();
  }
  
  @Nullable
  protected String d()
  {
    return "TroopNotificationApplicantInfoController";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationApplicantInfoController
 * JD-Core Version:    0.7.0.1
 */