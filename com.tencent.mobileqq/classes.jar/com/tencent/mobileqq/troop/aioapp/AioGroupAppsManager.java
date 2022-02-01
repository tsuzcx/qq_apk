package com.tencent.mobileqq.troop.aioapp;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.aioapp.data.FullListGroupAppEntity;
import com.tencent.mobileqq.troop.aioapp.data.GrayGroupAppEntity;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import mqq.manager.Manager;

public class AioGroupAppsManager
  implements StudyModeChangeListener, Manager
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final TroopHandler jdField_a_of_type_ComTencentMobileqqAppTroopHandler;
  private final FullListGroupAppsDbHelper jdField_a_of_type_ComTencentMobileqqTroopAioappFullListGroupAppsDbHelper;
  private final GrayGroupAppsDbHelper jdField_a_of_type_ComTencentMobileqqTroopAioappGrayGroupAppsDbHelper;
  String jdField_a_of_type_JavaLangString = "";
  List<TroopAIOAppInfo> jdField_a_of_type_JavaUtilList;
  final ConcurrentHashMap<Long, GrayGroupAppEntity> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public AioGroupAppsManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopAioappGrayGroupAppsDbHelper = new GrayGroupAppsDbHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqTroopAioappFullListGroupAppsDbHelper = new FullListGroupAppsDbHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER));
    this.jdField_a_of_type_JavaUtilList = new ArrayList(20);
    StudyModeManager.a(this);
  }
  
  public static AioGroupAppsManager a(QQAppInterface paramQQAppInterface)
  {
    return (AioGroupAppsManager)paramQQAppInterface.getManager(QQManagerFactory.AIO_GROUP_APPS_MANAGER);
  }
  
  private List<TroopAIOAppInfo> a(GrayGroupAppEntity paramGrayGroupAppEntity)
  {
    ArrayList localArrayList = new ArrayList(20);
    Object localObject = paramGrayGroupAppEntity.troopAIOAppInfos;
    paramGrayGroupAppEntity = new HashSet(20);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramGrayGroupAppEntity.add(Integer.valueOf(((TroopAIOAppInfo)((Iterator)localObject).next()).appid));
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject).next();
      if (!localTroopAIOAppInfo.isGray) {
        localArrayList.add(localTroopAIOAppInfo);
      } else if (paramGrayGroupAppEntity.contains(Integer.valueOf(localTroopAIOAppInfo.appid))) {
        localArrayList.add(localTroopAIOAppInfo);
      }
    }
    return localArrayList;
  }
  
  private List<TroopAIOAppInfo> b()
  {
    ArrayList localArrayList = new ArrayList(20);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
      if (!localTroopAIOAppInfo.isGray) {
        localArrayList.add(localTroopAIOAppInfo);
      }
    }
    return localArrayList;
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaLangString = "";
    b();
    a().c();
    a().b();
  }
  
  public long a(long paramLong)
  {
    GrayGroupAppEntity localGrayGroupAppEntity = (GrayGroupAppEntity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    paramLong = TimeUnit.DAYS.toSeconds(1L);
    if (localGrayGroupAppEntity == null) {
      return paramLong;
    }
    if (localGrayGroupAppEntity.requestIntervalSecond <= 0) {
      return paramLong;
    }
    return localGrayGroupAppEntity.requestIntervalSecond;
  }
  
  public FullListGroupAppsDbHelper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopAioappFullListGroupAppsDbHelper;
  }
  
  public GrayGroupAppsDbHelper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopAioappGrayGroupAppsDbHelper;
  }
  
  public String a(long paramLong)
  {
    Object localObject = a(paramLong);
    if (GroupUtil.a((Collection)localObject)) {
      return "";
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localTroopAIOAppInfo.hashVal)) {
        return localTroopAIOAppInfo.hashVal;
      }
    }
    return "";
  }
  
  public List<TroopAIOAppInfo> a()
  {
    List localList = b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      localList.addAll(a((GrayGroupAppEntity)((Map.Entry)localIterator.next()).getValue()));
    }
    return localList;
  }
  
  public List<TroopAIOAppInfo> a(long paramLong)
  {
    GrayGroupAppEntity localGrayGroupAppEntity = (GrayGroupAppEntity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localGrayGroupAppEntity == null) {
      return b();
    }
    return a(localGrayGroupAppEntity);
  }
  
  public void a()
  {
    GroupUtil.a(new AioGroupAppsManager.1(this), 1000L);
  }
  
  public void a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(Integer.valueOf(paramInt));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(localArrayList, 0);
  }
  
  public void a(long paramLong)
  {
    boolean bool = GroupAppsServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong);
    if (QLog.isColorLevel()) {
      QLog.i("AioGroupAppsManager", 2, "getAppsInObserver: invoked.  needRequest: " + bool);
    }
    if (bool)
    {
      TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(String.valueOf(paramLong));
      if (localTroopInfo == null) {}
      for (int i = 0;; i = (int)localTroopInfo.dwGroupClassExt)
      {
        GroupAppsServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, i);
        return;
      }
    }
    if (!GroupUtil.a(a(paramLong)))
    {
      GroupAppsServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong);
      return;
    }
    GroupUtil.a(new AioGroupAppsManager.2(this, paramLong));
  }
  
  public void a(boolean paramBoolean)
  {
    d();
  }
  
  public void b()
  {
    String str = "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
    localEditor.putString("SP_KEY_FULL_APP_LIST_HASH" + str, this.jdField_a_of_type_JavaLangString);
    localEditor.apply();
  }
  
  public void b(int paramInt)
  {
    Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    Iterator localIterator = ((ArrayList)localObject).iterator();
    while (localIterator.hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
      if (paramInt == localTroopAIOAppInfo.appid) {
        localTroopAIOAppInfo.redPoint = false;
      }
    }
    this.jdField_a_of_type_JavaUtilList = ((List)localObject);
    localObject = new FullListGroupAppEntity();
    ((FullListGroupAppEntity)localObject).troopAIOAppInfos = this.jdField_a_of_type_JavaUtilList;
    a().a((FullListGroupAppEntity)localObject);
  }
  
  public void c()
  {
    String str = "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    this.jdField_a_of_type_JavaLangString = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getString("SP_KEY_FULL_APP_LIST_HASH" + str, "");
  }
  
  public void onDestroy()
  {
    StudyModeManager.b(this);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.aioapp.AioGroupAppsManager
 * JD-Core Version:    0.7.0.1
 */