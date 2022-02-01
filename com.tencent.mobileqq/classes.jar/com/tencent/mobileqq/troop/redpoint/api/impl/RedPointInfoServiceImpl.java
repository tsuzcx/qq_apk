package com.tencent.mobileqq.troop.redpoint.api.impl;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.redpoint.BaseRedPointListener;
import com.tencent.mobileqq.troop.redpoint.RedPointInfo;
import com.tencent.mobileqq.troop.redpoint.RedPointListener;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointInfoService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class RedPointInfoServiceImpl
  implements IRedPointInfoService
{
  public static final String TAG = "RedPointInfoServiceImpl";
  private HashSet<BaseRedPointListener> listeners = new HashSet();
  private AppRuntime mApp;
  private ConcurrentHashMap<String, RedPointInfo> mRedPointInfoCache = new ConcurrentHashMap();
  
  private void notifyRedPointInfoChanged(String paramString1, String paramString2, RedPointInfo paramRedPointInfo, HashSet<Integer> paramHashSet)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramRedPointInfo != null) && (paramHashSet != null))
    {
      if (paramHashSet.isEmpty()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("notifyRedPointInfoChanged : uin = ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", uinType = ");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(", changedIdSet = ");
        ((StringBuilder)localObject).append(paramHashSet.toString());
        QLog.d("RedPointInfoServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.listeners;
      if (localObject != null)
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          BaseRedPointListener localBaseRedPointListener = (BaseRedPointListener)((Iterator)localObject).next();
          if (localBaseRedPointListener != null) {
            localBaseRedPointListener.a(1, new Object[] { paramString1, paramString2, paramRedPointInfo, paramHashSet });
          }
        }
      }
    }
  }
  
  public void addRedPointListener(RedPointListener paramRedPointListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPointInfoServiceImpl", 2, "addRedPointListener");
    }
    if (paramRedPointListener != null)
    {
      HashSet localHashSet = this.listeners;
      if ((localHashSet != null) && (!localHashSet.contains(paramRedPointListener))) {
        this.listeners.add(paramRedPointListener);
      }
    }
  }
  
  public void cleanRedPointInfoById(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cleanRedPointInfoById : uin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", uinType = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", redId = ");
      localStringBuilder.append(paramInt);
      QLog.d("RedPointInfoServiceImpl", 2, localStringBuilder.toString());
    }
    updateRedPointInfo(paramString1, paramString2, paramInt, 0);
  }
  
  public void cleanRedPointInfoByIds(String paramString1, String paramString2, List<Integer> paramList)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramList != null) && (!paramList.isEmpty()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cleanRedPointInfoByIds : uin = ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", uinType = ");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(", redPointIdList = ");
        ((StringBuilder)localObject).append(paramList.toString());
        QLog.d("RedPointInfoServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new HashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((HashMap)localObject).put((Integer)paramList.next(), Integer.valueOf(0));
      }
      updateRedPointInfos(paramString1, paramString2, (HashMap)localObject);
    }
  }
  
  public RedPointInfo getRedPointInfo(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRedPointInfo : uin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", uinType = ");
      localStringBuilder.append(paramString2);
      QLog.d("RedPointInfoServiceImpl", 2, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
      if (this.mRedPointInfoCache.containsKey(paramString1))
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("getRedPointInfo : mRedPointInfoCache ContainKey :");
          paramString2.append(paramString1);
          QLog.d("RedPointInfoServiceImpl", 2, paramString2.toString());
        }
        return (RedPointInfo)this.mRedPointInfoCache.get(paramString1);
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RedPointInfoServiceImpl", 2, "getRedPointInfo args error!");
    }
    return null;
  }
  
  public void notifyRedPointViewClick(String paramString1, String paramString2, View paramView)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramView == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("notifyRedPointViewClick : uin = ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", uinType = ");
        ((StringBuilder)localObject).append(paramString2);
        QLog.d("RedPointInfoServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.listeners;
      if (localObject != null)
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          BaseRedPointListener localBaseRedPointListener = (BaseRedPointListener)((Iterator)localObject).next();
          if (localBaseRedPointListener != null) {
            localBaseRedPointListener.a(2, new Object[] { paramString1, paramString2, paramView });
          }
        }
      }
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPointInfoServiceImpl", 2, "onDestroy");
    }
    HashSet localHashSet = this.listeners;
    if (localHashSet != null) {
      localHashSet.clear();
    }
    this.mRedPointInfoCache.clear();
  }
  
  public void removeRedPointListener(RedPointListener paramRedPointListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPointInfoServiceImpl", 2, "addRedPointListener");
    }
    if (paramRedPointListener != null)
    {
      HashSet localHashSet = this.listeners;
      if ((localHashSet != null) && (localHashSet.contains(paramRedPointListener))) {
        this.listeners.remove(paramRedPointListener);
      }
    }
  }
  
  public void updateRedPointInfo(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateRedPointInfo : uin = ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", uinType = ");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(", unReadNum = ");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("RedPointInfoServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(paramString2);
      String str = ((StringBuilder)localObject).toString();
      int i = 0;
      if (this.mRedPointInfoCache.get(str) == null)
      {
        localObject = new RedPointInfo();
        ((RedPointInfo)localObject).a = paramString1;
        ((RedPointInfo)localObject).b = paramString2;
      }
      else
      {
        localObject = (RedPointInfo)this.mRedPointInfoCache.get(str);
        i = 1;
      }
      boolean bool = ((RedPointInfo)localObject).a(paramInt1, paramInt2);
      if (i != 0)
      {
        if (((RedPointInfo)localObject).a()) {
          this.mRedPointInfoCache.remove(str);
        }
      }
      else if (!((RedPointInfo)localObject).a()) {
        this.mRedPointInfoCache.put(str, localObject);
      }
      if (bool) {
        ThreadManager.getUIHandler().post(new RedPointInfoServiceImpl.1(this, paramInt1, paramString1, paramString2, (RedPointInfo)localObject));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RedPointInfoServiceImpl", 2, "updateRedPointInfo uin error!");
    }
  }
  
  public void updateRedPointInfos(String paramString1, String paramString2, HashMap<Integer, Integer> paramHashMap)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateRedPointInfos : uin = ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", uinType = ");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(",redPointIdMap = ");
        ((StringBuilder)localObject).append(paramHashMap.toString());
        QLog.d("RedPointInfoServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(paramString2);
      String str = ((StringBuilder)localObject).toString();
      int i = 0;
      if (this.mRedPointInfoCache.get(str) == null)
      {
        localObject = new RedPointInfo();
        ((RedPointInfo)localObject).a = paramString1;
        ((RedPointInfo)localObject).b = paramString2;
      }
      else
      {
        localObject = (RedPointInfo)this.mRedPointInfoCache.get(str);
        i = 1;
      }
      boolean bool = ((RedPointInfo)localObject).a(paramHashMap);
      if (i != 0)
      {
        if (((RedPointInfo)localObject).a()) {
          this.mRedPointInfoCache.remove(str);
        }
      }
      else if (!((RedPointInfo)localObject).a()) {
        this.mRedPointInfoCache.put(str, localObject);
      }
      if (bool) {
        ThreadManager.getUIHandler().post(new RedPointInfoServiceImpl.2(this, paramHashMap, paramString1, paramString2, (RedPointInfo)localObject));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RedPointInfoServiceImpl", 2, "updateRedPointInfos troopUin error!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.api.impl.RedPointInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */