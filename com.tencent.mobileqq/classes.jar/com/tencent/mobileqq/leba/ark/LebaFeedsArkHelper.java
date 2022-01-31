package com.tencent.mobileqq.leba.ark;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.leba.UITemplate.ARKUITemplateInfo;
import com.tencent.mobileqq.leba.view.LebaFeedsArkView;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LebaFeedsArkHelper
{
  public static int a;
  private static LebaFeedsArkHelper jdField_a_of_type_ComTencentMobileqqLebaArkLebaFeedsArkHelper;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(2);
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(16);
  private int b = -1;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public static LebaFeedsArkHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqLebaArkLebaFeedsArkHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqLebaArkLebaFeedsArkHelper == null) {
        jdField_a_of_type_ComTencentMobileqqLebaArkLebaFeedsArkHelper = new LebaFeedsArkHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqLebaArkLebaFeedsArkHelper;
    }
    finally {}
  }
  
  private LebaFeedsArkHelper.CacheItem b(Context paramContext, long paramLong, ARKUITemplateInfo paramARKUITemplateInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsArkHelper", 2, "createArkItem " + paramLong + ", templateInfo=" + paramARKUITemplateInfo);
    }
    if ((paramLong < 0L) || (paramARKUITemplateInfo == null))
    {
      QLog.i("LebaFeedsArkHelper", 1, "createArkItem invalid params, return");
      return null;
    }
    LebaFeedsArkAppContainer localLebaFeedsArkAppContainer = new LebaFeedsArkAppContainer();
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = 1008;
    localLebaFeedsArkAppContainer.a(paramARKUITemplateInfo.a, paramARKUITemplateInfo.c, paramARKUITemplateInfo.b, paramARKUITemplateInfo.d, paramContext.getResources().getDisplayMetrics().scaledDensity, localSessionInfo);
    if (this.b <= 0) {
      this.b = ((int)DeviceInfoUtil.n() - AIOUtils.a(40.0F, paramContext.getResources()));
    }
    localLebaFeedsArkAppContainer.setFixSize(this.b, -1);
    paramContext = new ArkAppView(paramContext, null);
    paramContext.setLayoutParams(new RelativeLayout.LayoutParams(this.b, -2));
    paramContext.setBorderType(0);
    paramARKUITemplateInfo = new LebaFeedsArkHelper.CacheItem();
    paramARKUITemplateInfo.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer = localLebaFeedsArkAppContainer;
    paramARKUITemplateInfo.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = paramContext;
    return paramARKUITemplateInfo;
  }
  
  public LebaFeedsArkHelper.CacheItem a(Context paramContext, long paramLong, ARKUITemplateInfo paramARKUITemplateInfo)
  {
    LebaFeedsArkHelper.CacheItem localCacheItem = (LebaFeedsArkHelper.CacheItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsArkHelper", 2, "getArkItemFromCache " + paramLong + ", cacheItem=" + localCacheItem);
    }
    Object localObject = localCacheItem;
    if (localCacheItem == null)
    {
      paramContext = b(paramContext, paramLong, paramARKUITemplateInfo);
      localObject = paramContext;
      if (paramContext != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), paramContext);
        localObject = paramContext;
      }
    }
    return localObject;
  }
  
  public LebaFeedsArkView a(Context paramContext, View paramView)
  {
    if ((paramView != null) && ((paramView instanceof LebaFeedsArkView))) {
      return (LebaFeedsArkView)paramView;
    }
    paramContext = new LebaFeedsArkView(paramContext);
    a(paramContext);
    return paramContext;
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilLinkedList.size())
    {
      LebaFeedsArkView localLebaFeedsArkView = (LebaFeedsArkView)((WeakReference)this.jdField_a_of_type_JavaUtilLinkedList.get(i)).get();
      if (localLebaFeedsArkView != null) {
        localLebaFeedsArkView.c();
      }
      i += 1;
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsArkHelper", 2, "removeArkItemFromCache feedId=" + paramLong);
    }
    LebaFeedsArkHelper.CacheItem localCacheItem = (LebaFeedsArkHelper.CacheItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if ((localCacheItem != null) && (localCacheItem.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer != null)) {
      localCacheItem.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.doOnEvent(2);
    }
  }
  
  public void a(LebaFeedsArkView paramLebaFeedsArkView)
  {
    if (paramLebaFeedsArkView == null) {}
    do
    {
      return;
      int i = this.jdField_a_of_type_JavaUtilLinkedList.size() - 1;
      if (i < 0) {
        break;
      }
      LebaFeedsArkView localLebaFeedsArkView = (LebaFeedsArkView)((WeakReference)this.jdField_a_of_type_JavaUtilLinkedList.get(i)).get();
      if (localLebaFeedsArkView == null) {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(i);
      }
      while (paramLebaFeedsArkView != localLebaFeedsArkView)
      {
        i -= 1;
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("LebaFeedsArkHelper", 2, "addArkViewToCache already exist:" + paramLebaFeedsArkView);
    return;
    this.jdField_a_of_type_JavaUtilLinkedList.add(new WeakReference(paramLebaFeedsArkView));
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilLinkedList.size())
    {
      LebaFeedsArkView localLebaFeedsArkView = (LebaFeedsArkView)((WeakReference)this.jdField_a_of_type_JavaUtilLinkedList.get(i)).get();
      if (localLebaFeedsArkView != null) {
        localLebaFeedsArkView.b();
      }
      i += 1;
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext()) {
      a(((Long)localIterator.next()).longValue());
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.ark.LebaFeedsArkHelper
 * JD-Core Version:    0.7.0.1
 */