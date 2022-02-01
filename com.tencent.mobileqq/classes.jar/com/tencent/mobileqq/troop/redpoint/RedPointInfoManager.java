package com.tencent.mobileqq.troop.redpoint;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class RedPointInfoManager
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashSet<BaseRedPointListener> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private ConcurrentHashMap<String, RedPointInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public RedPointInfoManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(String paramString1, String paramString2, RedPointInfo paramRedPointInfo, HashSet<Integer> paramHashSet)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramRedPointInfo == null) || (paramHashSet == null) || (paramHashSet.isEmpty())) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RedPointInfoManager", 2, "notifyRedPointInfoChanged : uin = " + paramString1 + ", uinType = " + paramString2 + ", changedIdSet = " + paramHashSet.toString());
      }
      if (this.jdField_a_of_type_JavaUtilHashSet != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
        while (localIterator.hasNext())
        {
          BaseRedPointListener localBaseRedPointListener = (BaseRedPointListener)localIterator.next();
          if (localBaseRedPointListener != null) {
            localBaseRedPointListener.a(1, new Object[] { paramString1, paramString2, paramRedPointInfo, paramHashSet });
          }
        }
      }
    }
  }
  
  public RedPointInfo a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPointInfoManager", 2, "getRedPointInfo : uin = " + paramString1 + ", uinType = " + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.d("RedPointInfoManager", 2, "getRedPointInfo args error!");
      }
    }
    do
    {
      return null;
      paramString1 = paramString1 + paramString2;
    } while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1));
    if (QLog.isColorLevel()) {
      QLog.d("RedPointInfoManager", 2, "getRedPointInfo : mRedPointInfoCache ContainKey :" + paramString1);
    }
    return (RedPointInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
  }
  
  public void a(RedPointListener paramRedPointListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPointInfoManager", 2, "addRedPointListener");
    }
    if ((paramRedPointListener != null) && (this.jdField_a_of_type_JavaUtilHashSet != null) && (!this.jdField_a_of_type_JavaUtilHashSet.contains(paramRedPointListener))) {
      this.jdField_a_of_type_JavaUtilHashSet.add(paramRedPointListener);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.d("RedPointInfoManager", 2, "updateRedPointInfo uin error!");
      }
    }
    label214:
    label235:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RedPointInfoManager", 2, "updateRedPointInfo : uin = " + paramString1 + ", uinType = " + paramString2 + ", unReadNum = " + paramInt2);
      }
      String str = paramString1 + paramString2;
      int i = 0;
      RedPointInfo localRedPointInfo;
      boolean bool;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) == null)
      {
        localRedPointInfo = new RedPointInfo();
        localRedPointInfo.a = paramString1;
        localRedPointInfo.b = paramString2;
        bool = localRedPointInfo.a(paramInt1, paramInt2);
        if (i == 0) {
          break label214;
        }
        if (localRedPointInfo.a()) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        }
      }
      for (;;)
      {
        if (!bool) {
          break label235;
        }
        ThreadManager.getUIHandler().post(new RedPointInfoManager.1(this, paramInt1, paramString1, paramString2, localRedPointInfo));
        return;
        localRedPointInfo = (RedPointInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        i = 1;
        break;
        if (!localRedPointInfo.a()) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localRedPointInfo);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, View paramView)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramView == null)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RedPointInfoManager", 2, "notifyRedPointViewClick : uin = " + paramString1 + ", uinType = " + paramString2);
      }
      if (this.jdField_a_of_type_JavaUtilHashSet != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
        while (localIterator.hasNext())
        {
          BaseRedPointListener localBaseRedPointListener = (BaseRedPointListener)localIterator.next();
          if (localBaseRedPointListener != null) {
            localBaseRedPointListener.a(2, new Object[] { paramString1, paramString2, paramView });
          }
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, HashMap<Integer, Integer> paramHashMap)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramHashMap == null) || (paramHashMap.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("RedPointInfoManager", 2, "updateRedPointInfos troopUin error!");
      }
    }
    label225:
    label246:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RedPointInfoManager", 2, "updateRedPointInfos : uin = " + paramString1 + ", uinType = " + paramString2 + ",redPointIdMap = " + paramHashMap.toString());
      }
      String str = paramString1 + paramString2;
      int i = 0;
      RedPointInfo localRedPointInfo;
      boolean bool;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) == null)
      {
        localRedPointInfo = new RedPointInfo();
        localRedPointInfo.a = paramString1;
        localRedPointInfo.b = paramString2;
        bool = localRedPointInfo.a(paramHashMap);
        if (i == 0) {
          break label225;
        }
        if (localRedPointInfo.a()) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        }
      }
      for (;;)
      {
        if (!bool) {
          break label246;
        }
        ThreadManager.getUIHandler().post(new RedPointInfoManager.2(this, paramHashMap, paramString1, paramString2, localRedPointInfo));
        return;
        localRedPointInfo = (RedPointInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        i = 1;
        break;
        if (!localRedPointInfo.a()) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localRedPointInfo);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, List<Integer> paramList)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramList != null) && (!paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPointInfoManager", 2, "cleanRedPointInfoByIds : uin = " + paramString1 + ", uinType = " + paramString2 + ", redPointIdList = " + paramList.toString());
      }
      HashMap localHashMap = new HashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localHashMap.put((Integer)paramList.next(), Integer.valueOf(0));
      }
      a(paramString1, paramString2, localHashMap);
    }
  }
  
  public void b(RedPointListener paramRedPointListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPointInfoManager", 2, "addRedPointListener");
    }
    if ((paramRedPointListener != null) && (this.jdField_a_of_type_JavaUtilHashSet != null) && (this.jdField_a_of_type_JavaUtilHashSet.contains(paramRedPointListener))) {
      this.jdField_a_of_type_JavaUtilHashSet.remove(paramRedPointListener);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPointInfoManager", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_JavaUtilHashSet != null) {
      this.jdField_a_of_type_JavaUtilHashSet.clear();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.RedPointInfoManager
 * JD-Core Version:    0.7.0.1
 */