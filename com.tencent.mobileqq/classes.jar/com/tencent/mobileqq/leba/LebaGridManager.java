package com.tencent.mobileqq.leba;

import aehp;
import aehq;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONObject;

public class LebaGridManager
  implements Manager
{
  public QQAppInterface a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  public Object a;
  private Comparator jdField_a_of_type_JavaUtilComparator = new aehq(this);
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  
  public LebaGridManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    ThreadManager.postImmediately(new aehp(this), null, false);
  }
  
  private void a(int paramInt)
  {
    if (PluginInfo.remove(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, paramInt)) {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
        return;
      }
    }
  }
  
  private void b(PluginInfo paramPluginInfo)
  {
    if (paramPluginInfo == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramPluginInfo.pluginId), paramPluginInfo);
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("leba_new_config_version", 0);
  }
  
  public PluginInfo a(int paramInt)
  {
    PluginInfo localPluginInfo = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localPluginInfo != null) {
      return localPluginInfo;
    }
    localPluginInfo = PluginInfo.find(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, paramInt);
    b(localPluginInfo);
    return localPluginInfo;
  }
  
  public List a(int paramInt)
  {
    Object localObject1 = null;
    Iterator localIterator;
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      localObject1 = new ArrayList();
      localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Integer)localIterator.next();
        localObject2 = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2);
        if (paramInt == 2) {
          ((List)localObject1).add(localObject2);
        } else if (((PluginInfo)localObject2).openFlag == paramInt) {
          ((List)localObject1).add(localObject2);
        }
      }
    }
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      Collections.sort((List)localObject1, this.jdField_a_of_type_JavaUtilComparator);
      return localObject1;
    }
    localObject1 = PluginInfo.getAll(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, paramInt);
    if (localObject1 != null)
    {
      localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext()) {
        b((PluginInfo)localIterator.next());
      }
    }
    return localObject1;
  }
  
  public List a(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PluginInfo localPluginInfo = a(((Integer)paramList.next()).intValue());
      if (localPluginInfo != null) {
        localArrayList.add(localPluginInfo);
      }
    }
    return localArrayList;
  }
  
  public JSONObject a()
  {
    String str;
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getString("leba_new_config_value", "");
    }
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(str);
      return this.jdField_a_of_type_OrgJsonJSONObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        QLog.d("Q.lebanew", 1, "getLebaConfigJSON e:" + localException.toString());
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebanew", 2, "initCache");
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      Object localObject1 = PluginInfo.getAll(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, 2);
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext()) {
          b((PluginInfo)((Iterator)localObject1).next());
        }
      }
    }
  }
  
  public void a(PluginInfo paramPluginInfo)
  {
    if (paramPluginInfo == null) {
      return;
    }
    b(PluginInfo.persistOrReplace(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, paramPluginInfo));
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebanew", 2, "updateLebaConfig content:" + paramString + ",\n uin: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + ", version:" + paramInt);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.getInt("isShow") == 1) {}
      for (boolean bool = true;; bool = false)
      {
        SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        localSharedPreferences.edit().putBoolean("leba_new_is_show", bool);
        localSharedPreferences.edit().putInt("leba_new_config_version", paramInt);
        localSharedPreferences.edit().putString("leba_new_config_value", paramString);
        localSharedPreferences.edit().commit();
        this.jdField_a_of_type_OrgJsonJSONObject = localJSONObject;
        ((LebaFeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(276)).c();
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("Q.lebanew", 1, "updateLebaConfig e:" + paramString.toString());
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((PluginInfo)paramList.next());
      }
    }
  }
  
  public boolean a()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("leba_new_is_show", false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebanew", 2, "uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + ", isNewLeba:" + bool);
    }
    return bool;
  }
  
  public void b(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a(((Integer)paramList.next()).intValue());
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.LebaGridManager
 * JD-Core Version:    0.7.0.1
 */