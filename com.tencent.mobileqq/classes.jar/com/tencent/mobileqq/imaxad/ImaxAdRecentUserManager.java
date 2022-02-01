package com.tencent.mobileqq.imaxad;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ImaxAdRecentUserManager
{
  private static ImaxAdRecentUserManager jdField_a_of_type_ComTencentMobileqqImaxadImaxAdRecentUserManager;
  private ConcurrentHashMap<String, AdvertisementItem> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static ImaxAdRecentUserManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqImaxadImaxAdRecentUserManager == null) {
        jdField_a_of_type_ComTencentMobileqqImaxadImaxAdRecentUserManager = new ImaxAdRecentUserManager();
      }
      ImaxAdRecentUserManager localImaxAdRecentUserManager = jdField_a_of_type_ComTencentMobileqqImaxadImaxAdRecentUserManager;
      return localImaxAdRecentUserManager;
    }
    finally {}
  }
  
  private void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt, AdvertisementItem paramAdvertisementItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, "jumpToImaxDisplayActivity item :" + paramString);
    }
    Intent localIntent = new Intent(paramContext, PublicAccountAdvertisementActivity.class);
    localIntent.putExtra("arg_ad_json", paramAdvertisementItem.a());
    localIntent.putExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
    localIntent.putExtra("is_first_open_imax_ad", RecentUtil.c);
    RecentUtil.c = false;
    paramContext.startActivity(localIntent);
    ThreadManager.post(new ImaxAdRecentUserManager.2(this, paramQQAppInterface, paramString, paramInt, paramAdvertisementItem), 5, null, false);
    AdvertisementRecentUserManager.a().a(paramQQAppInterface, 2, paramAdvertisementItem);
  }
  
  public AdvertisementItem a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (AdvertisementItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  public List<AdvertisementItem> a(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList(2);
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values() != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        AdvertisementItem localAdvertisementItem = (AdvertisementItem)localIterator.next();
        ArrayList localArrayList2 = localAdvertisementItem.jdField_a_of_type_JavaUtilArrayList;
        if ((localArrayList2 != null) && (localArrayList2.size() > 0) && (paramString.equals(((VideoCoverItem)localArrayList2.get(0)).b)) && (localAdvertisementItem.jdField_a_of_type_Int == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ImaxAdvertisement", 2, "getAdvertisementItembyVid:" + paramString + " item:" + localAdvertisementItem.jdField_a_of_type_JavaLangString);
          }
          localArrayList1.add(localAdvertisementItem);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, "getAdvertisementItem disPlayitemList:" + localArrayList1.size());
    }
    return localArrayList1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(AdvertisementItem paramAdvertisementItem)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramAdvertisementItem.jdField_a_of_type_JavaLangString, paramAdvertisementItem);
  }
  
  public void a(QQAppInterface paramQQAppInterface, RecentAdapter paramRecentAdapter, AbsListView paramAbsListView)
  {
    int i;
    if ((paramAbsListView != null) && (paramRecentAdapter != null) && (paramQQAppInterface != null))
    {
      i = paramAbsListView.getFirstVisiblePosition();
      if (i <= 0) {
        break label370;
      }
      i -= 1;
    }
    label240:
    label370:
    for (;;)
    {
      int k = paramAbsListView.getLastVisiblePosition();
      int j = i;
      for (;;)
      {
        Object localObject1;
        if (j < k + 1)
        {
          localObject1 = paramRecentAdapter.getItem(j);
          if ((localObject1 == null) || (!(localObject1 instanceof RecentItemImaxADData))) {
            break label361;
          }
          localObject1 = (RecentItemImaxADData)localObject1;
          localObject2 = paramQQAppInterface.getConversationFacade().a(((RecentItemImaxADData)localObject1).mUser.uin, ((RecentItemImaxADData)localObject1).mUser.getType());
          if (localObject2 != null) {
            ((ConversationInfo)localObject2).isImax = true;
          }
          if (!ImaxAdUtil.a(paramAbsListView.getChildAt(j - i))) {
            break label361;
          }
          localObject3 = ((RecentItemImaxADData)localObject1).mUser.uin;
          localObject2 = b((String)localObject3);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label246;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ImaxAdvertisement", 2, "isShowImaxAdItem item recreated " + (String)localObject3);
          }
          localObject1 = AdvertisementItem.a(ImaxAdUtil.b(paramQQAppInterface.getCurrentUin(), (String)localObject3));
          if (localObject1 != null) {
            break label240;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ImaxAdvertisement", 2, "isShowImaxAdItem item false " + (String)localObject3);
          }
        }
        return;
        a((AdvertisementItem)localObject1);
        label246:
        Object localObject2 = Message.obtain();
        Object localObject3 = new HashMap();
        ((HashMap)localObject3).put("key_app", new WeakReference(paramQQAppInterface));
        ((HashMap)localObject3).put("key_adapter", new WeakReference(paramRecentAdapter));
        ((HashMap)localObject3).put("key_listview", new WeakReference(paramAbsListView));
        ((Message)localObject2).obj = localObject3;
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("key_ad_id", ((AdvertisementItem)localObject1).c);
        ((Message)localObject2).setData((Bundle)localObject3);
        ((Message)localObject2).what = 2;
        ImaxAdPresenter.a().a((Message)localObject2);
        j += 1;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    AdvertisementItem localAdvertisementItem;
    if ((paramRecentUser != null) && (paramRecentUser.uin != null))
    {
      localAdvertisementItem = b(paramRecentUser.uin);
      if ((localAdvertisementItem != null) && (NetConnInfoCenter.getServerTimeMillis() >= localAdvertisementItem.b))
      {
        localObject = (ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER);
        if (localObject != null) {
          break label139;
        }
      }
    }
    label139:
    for (Object localObject = null;; localObject = ((ProxyManager)localObject).a())
    {
      if (localObject != null)
      {
        RecentDataListManager.a().a(paramRecentUser.uin + "-" + paramRecentUser.getType());
        ((RecentUserProxy)localObject).a(paramRecentUser);
        RecentUtil.b(paramQQAppInterface, localAdvertisementItem.jdField_a_of_type_JavaLangString, 10005);
        paramQQAppInterface.getMessageFacade().c(localAdvertisementItem.jdField_a_of_type_JavaLangString, 10005);
      }
      a(paramQQAppInterface, paramRecentUser, localAdvertisementItem, false);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, AdvertisementItem paramAdvertisementItem, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, "dodelete ExpireItem uin:" + paramRecentUser.uin);
    }
    ThreadManager.executeOnFileThread(new ImaxAdRecentUserManager.1(this, paramBoolean, paramQQAppInterface, paramAdvertisementItem, paramRecentUser));
    a(paramRecentUser.uin);
  }
  
  public boolean a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      if (paramQQAppInterface != null) {
        break label55;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "openImaxAdvertisement result " + bool1);
      }
      return bool1;
      label55:
      if (TextUtils.isEmpty(paramString))
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("ImaxAdvertisement", 2, "openImaxAdvertisement empty uin!");
          bool1 = bool2;
        }
      }
      else
      {
        AdvertisementItem localAdvertisementItem = b(paramString);
        if (localAdvertisementItem == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ImaxAdvertisement", 2, "openAdvertisement item recreated :" + paramString);
          }
          localAdvertisementItem = AdvertisementItem.a(ImaxAdUtil.b(paramQQAppInterface.getCurrentUin(), paramString));
          bool1 = bool2;
          if (localAdvertisementItem != null)
          {
            a(localAdvertisementItem);
            a(paramContext, paramQQAppInterface, paramString, paramInt, localAdvertisementItem);
            bool1 = true;
          }
        }
        else
        {
          a(paramContext, paramQQAppInterface, paramString, paramInt, localAdvertisementItem);
          bool1 = true;
        }
      }
    }
  }
  
  public AdvertisementItem b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (AdvertisementItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values() != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext()) {
        ((AdvertisementItem)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager
 * JD-Core Version:    0.7.0.1
 */