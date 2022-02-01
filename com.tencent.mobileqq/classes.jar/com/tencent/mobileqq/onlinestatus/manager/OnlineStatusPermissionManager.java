package com.tencent.mobileqq.onlinestatus.manager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionObserver;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionServlet;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusItem;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

public class OnlineStatusPermissionManager
  implements IOnlineStatusPermissionManager
{
  private int jdField_a_of_type_Int = -1;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private OnlineStatusFriendsPermissionItem jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusFriendsPermissionItem;
  private OnlineStatusPermissionObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver = new OnlineStatusPermissionManager.3(this);
  private ArrayList<WeakReference<OnlineStatusPermissionManager.ReceiveDataListener>> jdField_a_of_type_JavaUtilArrayList;
  private List<Integer> jdField_a_of_type_JavaUtilList;
  
  public OnlineStatusPermissionManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    paramAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    b();
    a(paramAppInterface);
  }
  
  private Pair<Boolean, List<Integer>> a(List<Integer> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = OnlineStatusUtil.a();
    Object localObject = Boolean.valueOf(false);
    if (!bool)
    {
      localArrayList.addAll(paramList);
      return new Pair(localObject, localArrayList);
    }
    List localList = ((OnlineAutoStatusBean)QConfigManager.a().a(652)).a.a(false);
    if (localList.size() <= 0)
    {
      localArrayList.addAll(paramList);
      return new Pair(localObject, localArrayList);
    }
    paramList = paramList.iterator();
    for (bool = false; paramList.hasNext(); bool = true)
    {
      label101:
      localObject = (Integer)paramList.next();
      Iterator localIterator = localList.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        AutoStatusItem localAutoStatusItem = (AutoStatusItem)localIterator.next();
        if (((Integer)localObject).intValue() == localAutoStatusItem.a)
        {
          localArrayList.add(localObject);
          i = 1;
        }
      }
      if ((i != 0) || (bool)) {
        break label101;
      }
    }
    return new Pair(Boolean.valueOf(bool), localArrayList);
  }
  
  private void a(AppInterface paramAppInterface)
  {
    try
    {
      if (this.jdField_a_of_type_Int == -1)
      {
        this.jdField_a_of_type_Int = 0;
        ThreadManagerV2.excute(new OnlineStatusPermissionManager.1(this, paramAppInterface), 16, null, true);
      }
      return;
    }
    finally
    {
      paramAppInterface = finally;
      throw paramAppInterface;
    }
  }
  
  private void a(OnlineStatusPermissionManager.ReceiveDataListener paramReceiveDataListener)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference.get() != null) && (paramReceiveDataListener == localWeakReference.get()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusPermissionManager", 2, new Object[] { "registerReceiveDataListener exist", paramReceiveDataListener });
          }
          return;
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramReceiveDataListener));
      return;
    }
    finally {}
    for (;;)
    {
      throw paramReceiveDataListener;
    }
  }
  
  private void b()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        if (this.jdField_a_of_type_JavaUtilList == null) {
          i = 0;
        } else {
          i = this.jdField_a_of_type_JavaUtilList.size();
        }
        QLog.d("OnlineStatusPermissionManager", 2, new Object[] { "initSmartSelectedListFromSP mSmartSelectedList isEmpty=", Integer.valueOf(i) });
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        break label265;
      }
      localObject1 = BaseApplication.getContext();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("smart_selected_list");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin());
      localObject1 = SharePreferenceUtils.a((Context)localObject1, localStringBuilder.toString());
      this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label195;
      }
      localObject1 = ((String)localObject1).split("#");
      j = localObject1.length;
      i = 0;
    }
    finally
    {
      int i;
      label265:
      label284:
      for (;;)
      {
        Object localObject1;
        StringBuilder localStringBuilder;
        int j;
        for (;;)
        {
          label166:
          label195:
          throw localObject2;
        }
      }
    }
    if (i < j) {
      localStringBuilder = localObject1[i];
    }
    try
    {
      Integer localInteger = Integer.valueOf(localStringBuilder);
      this.jdField_a_of_type_JavaUtilList.add(localInteger);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label166;
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("OnlineStatusPermissionManager", 2, new Object[] { "initSmartSelectedListFromSP NumberFormatException selected=", localStringBuilder });
      break label284;
      localObject1 = a(this.jdField_a_of_type_JavaUtilList);
      if (((Boolean)((Pair)localObject1).first).booleanValue()) {
        b((List)((Pair)localObject1).second);
      }
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionManager", 2, new Object[] { "initSmartSelectedListFromSP mSmartSelectedList size=", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      }
      return;
    }
  }
  
  private void b(@NonNull OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem)
  {
    try
    {
      ThreadManagerV2.excute(new OnlineStatusPermissionManager.2(this, paramOnlineStatusFriendsPermissionItem), 16, null, true);
      return;
    }
    finally
    {
      paramOnlineStatusFriendsPermissionItem = finally;
      throw paramOnlineStatusFriendsPermissionItem;
    }
  }
  
  private boolean b(List<Integer> paramList)
  {
    if (paramList == null) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      boolean bool = c(paramList);
      return bool;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  private void c()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (((WeakReference)localObject2).get() != null)
        {
          localObject2 = (OnlineStatusPermissionManager.ReceiveDataListener)((WeakReference)localObject2).get();
          ((OnlineStatusPermissionManager.ReceiveDataListener)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusFriendsPermissionItem, a());
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusPermissionManager", 2, new Object[] { "notifyReceiveDataListener exist", localObject2 });
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  private boolean c(List<Integer> paramList)
  {
    if (paramList.size() == 0)
    {
      paramList = BaseApplication.getContext();
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("smart_selected_list");
      localStringBuilder1.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin());
      SharePreferenceUtils.a(paramList, localStringBuilder1.toString());
      return true;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder1.append(paramList.get(i));
      if (i != paramList.size() - 1) {
        localStringBuilder1.append("#");
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionManager", 2, new Object[] { "saveSmartSelectedListToSP ", localStringBuilder1.toString() });
    }
    paramList = BaseApplication.getContext();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("smart_selected_list");
    localStringBuilder2.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin());
    SharePreferenceUtils.a(paramList, localStringBuilder2.toString(), localStringBuilder1.toString());
    return true;
  }
  
  @Nullable
  public OnlineStatusFriendsPermissionItem a(long paramLong, boolean paramBoolean, OnlineStatusPermissionManager.ReceiveDataListener paramReceiveDataListener)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionManager", 2, new Object[] { " getOnlineStatusPermission onlineStatusType=", Long.valueOf(paramLong), " state= ", Integer.valueOf(this.jdField_a_of_type_Int), " fetchIfAbsent=", Boolean.valueOf(paramBoolean) });
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusFriendsPermissionItem != null)
      {
        paramReceiveDataListener = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusFriendsPermissionItem;
        return paramReceiveDataListener;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionManager", 2, new Object[] { " getOnlineStatusPermission registerListener", paramReceiveDataListener });
      }
      a(paramReceiveDataListener);
      if (paramBoolean) {
        a(paramLong, false);
      }
      return null;
    }
    finally {}
  }
  
  /* Error */
  public List<Integer> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 169	com/tencent/mobileqq/onlinestatus/manager/OnlineStatusPermissionManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7: invokespecial 226	com/tencent/mobileqq/onlinestatus/manager/OnlineStatusPermissionManager:a	(Ljava/util/List;)Lcom/tencent/util/Pair;
    //   10: astore_1
    //   11: aload_1
    //   12: getfield 230	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   15: checkcast 62	java/lang/Boolean
    //   18: invokevirtual 233	java/lang/Boolean:booleanValue	()Z
    //   21: ifeq +30 -> 51
    //   24: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +12 -> 39
    //   30: ldc 153
    //   32: iconst_2
    //   33: ldc_w 303
    //   36: invokestatic 306	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aload_0
    //   40: aload_1
    //   41: getfield 236	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   44: checkcast 95	java/util/List
    //   47: invokespecial 239	com/tencent/mobileqq/onlinestatus/manager/OnlineStatusPermissionManager:b	(Ljava/util/List;)Z
    //   50: pop
    //   51: aload_1
    //   52: getfield 236	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   55: checkcast 95	java/util/List
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: areturn
    //   63: astore_1
    //   64: goto +32 -> 96
    //   67: astore_1
    //   68: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +13 -> 84
    //   74: ldc 153
    //   76: iconst_2
    //   77: ldc_w 308
    //   80: aload_1
    //   81: invokestatic 312	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   84: new 39	java/util/ArrayList
    //   87: dup
    //   88: invokespecial 40	java/util/ArrayList:<init>	()V
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: areturn
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	OnlineStatusPermissionManager
    //   10	52	1	localObject1	Object
    //   63	1	1	localObject2	Object
    //   67	14	1	localThrowable	java.lang.Throwable
    //   91	8	1	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	39	63	finally
    //   39	51	63	finally
    //   51	59	63	finally
    //   68	84	63	finally
    //   84	92	63	finally
    //   2	39	67	java/lang/Throwable
    //   39	51	67	java/lang/Throwable
    //   51	59	67	java/lang/Throwable
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      localList.clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusFriendsPermissionItem != null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusFriendsPermissionItem = null;
    }
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    OnlineStatusPermissionServlet.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramLong, paramBoolean, false);
  }
  
  public void a(@NonNull OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionManager", 2, new Object[] { " saveOnlineStatusPermission item=", paramOnlineStatusFriendsPermissionItem });
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusFriendsPermissionItem = paramOnlineStatusFriendsPermissionItem;
      b(paramOnlineStatusFriendsPermissionItem);
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("smart_selected_list");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin());
    return TextUtils.isEmpty(SharePreferenceUtils.a(localBaseApplication, localStringBuilder.toString())) ^ true;
  }
  
  public boolean a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem, OnlineStatusPermissionManager.ReceiveDataListener paramReceiveDataListener)
  {
    if (paramOnlineStatusPermissionItem == null) {
      return false;
    }
    paramReceiveDataListener = a(40001L, false, paramReceiveDataListener);
    if (paramReceiveDataListener == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionManager", 2, " hasPermissionChange entity is null");
      }
      return false;
    }
    if (paramReceiveDataListener.allHasPermission != paramOnlineStatusPermissionItem.isAllHasPermission())
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionManager", 2, new Object[] { " hasPermissionChange entity.allHasPermission=", Boolean.valueOf(paramReceiveDataListener.allHasPermission), " item.isAllHasPermission=", paramOnlineStatusPermissionItem.getPermissionUins() });
      }
      return true;
    }
    if (paramReceiveDataListener.permissionUins.size() != paramOnlineStatusPermissionItem.getPermissionUins().size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionManager", 2, new Object[] { " hasPermissionChange entity.size=", Integer.valueOf(paramReceiveDataListener.permissionUins.size()), " item.size=", Integer.valueOf(paramOnlineStatusPermissionItem.getPermissionUins().size()) });
      }
      return true;
    }
    if (paramReceiveDataListener.permissionUins.containsAll(paramOnlineStatusPermissionItem.getPermissionUins())) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionManager", 2, " hasPermissionChange entity not contains item all");
    }
    return true;
  }
  
  public boolean a(ArrayList<OnlineStatusItem> paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    List localList = a();
    if (localList.size() != paramArrayList.size()) {
      return true;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)paramArrayList.next();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (localOnlineStatusItem.a == localInteger.intValue())
        {
          i = 1;
          break label103;
        }
      }
      int i = 0;
      label103:
      if (i == 0) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(List<Integer> paramList)
  {
    if (paramList == null) {
      return false;
    }
    try
    {
      boolean bool = b((List)a(paramList).second);
      return bool;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager
 * JD-Core Version:    0.7.0.1
 */