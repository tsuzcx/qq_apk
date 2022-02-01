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
  private static ImaxAdRecentUserManager a;
  private ConcurrentHashMap<String, AdvertisementItem> b = new ConcurrentHashMap();
  
  public static ImaxAdRecentUserManager a()
  {
    try
    {
      if (a == null) {
        a = new ImaxAdRecentUserManager();
      }
      ImaxAdRecentUserManager localImaxAdRecentUserManager = a;
      return localImaxAdRecentUserManager;
    }
    finally {}
  }
  
  private void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt, AdvertisementItem paramAdvertisementItem)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jumpToImaxDisplayActivity item :");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ImaxAdvertisement", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent(paramContext, PublicAccountAdvertisementActivity.class);
    ((Intent)localObject).putExtra("arg_ad_json", paramAdvertisementItem.c());
    ((Intent)localObject).putExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
    ((Intent)localObject).putExtra("is_first_open_imax_ad", RecentUtil.e);
    RecentUtil.e = false;
    paramContext.startActivity((Intent)localObject);
    ThreadManager.post(new ImaxAdRecentUserManager.2(this, paramQQAppInterface, paramString, paramInt, paramAdvertisementItem), 5, null, false);
    AdvertisementRecentUserManager.a().a(paramQQAppInterface, 2, paramAdvertisementItem);
  }
  
  public AdvertisementItem a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (AdvertisementItem)this.b.remove(paramString);
  }
  
  public void a(AdvertisementItem paramAdvertisementItem)
  {
    this.b.put(paramAdvertisementItem.a, paramAdvertisementItem);
  }
  
  public void a(QQAppInterface paramQQAppInterface, RecentAdapter paramRecentAdapter, AbsListView paramAbsListView)
  {
    if ((paramAbsListView != null) && (paramRecentAdapter != null) && (paramQQAppInterface != null))
    {
      int j = paramAbsListView.getFirstVisiblePosition();
      int i = j;
      if (j > 0) {
        i = j - 1;
      }
      int k = paramAbsListView.getLastVisiblePosition();
      j = i;
      while (j < k + 1)
      {
        Object localObject1 = paramRecentAdapter.getItem(j);
        if ((localObject1 != null) && ((localObject1 instanceof RecentItemImaxADData)))
        {
          localObject1 = (RecentItemImaxADData)localObject1;
          Object localObject2 = paramQQAppInterface.getConversationFacade().p(((RecentItemImaxADData)localObject1).mUser.uin, ((RecentItemImaxADData)localObject1).mUser.getType());
          if (localObject2 != null) {
            ((ConversationInfo)localObject2).isImax = true;
          }
          if (ImaxAdUtil.a(paramAbsListView.getChildAt(j - i)))
          {
            Object localObject3 = ((RecentItemImaxADData)localObject1).mUser.uin;
            localObject2 = b((String)localObject3);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("isShowImaxAdItem item recreated ");
                ((StringBuilder)localObject1).append((String)localObject3);
                QLog.d("ImaxAdvertisement", 2, ((StringBuilder)localObject1).toString());
              }
              localObject1 = AdvertisementItem.a(ImaxAdUtil.d(paramQQAppInterface.getCurrentUin(), (String)localObject3));
              if (localObject1 == null)
              {
                if (QLog.isColorLevel())
                {
                  paramQQAppInterface = new StringBuilder();
                  paramQQAppInterface.append("isShowImaxAdItem item false ");
                  paramQQAppInterface.append((String)localObject3);
                  QLog.d("ImaxAdvertisement", 2, paramQQAppInterface.toString());
                }
                return;
              }
              a((AdvertisementItem)localObject1);
            }
            localObject2 = Message.obtain();
            localObject3 = new HashMap();
            ((HashMap)localObject3).put("key_app", new WeakReference(paramQQAppInterface));
            ((HashMap)localObject3).put("key_adapter", new WeakReference(paramRecentAdapter));
            ((HashMap)localObject3).put("key_listview", new WeakReference(paramAbsListView));
            ((Message)localObject2).obj = localObject3;
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("key_ad_id", ((AdvertisementItem)localObject1).d);
            ((Message)localObject2).setData((Bundle)localObject3);
            ((Message)localObject2).what = 2;
            ImaxAdPresenter.a().a((Message)localObject2);
          }
        }
        j += 1;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if ((paramRecentUser != null) && (paramRecentUser.uin != null))
    {
      AdvertisementItem localAdvertisementItem = b(paramRecentUser.uin);
      if ((localAdvertisementItem != null) && (NetConnInfoCenter.getServerTimeMillis() >= localAdvertisementItem.l))
      {
        Object localObject = (ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER);
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((ProxyManager)localObject).g();
        }
        if (localObject != null)
        {
          RecentDataListManager localRecentDataListManager = RecentDataListManager.a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramRecentUser.uin);
          localStringBuilder.append("-");
          localStringBuilder.append(paramRecentUser.getType());
          localRecentDataListManager.b(localStringBuilder.toString());
          ((RecentUserProxy)localObject).a(paramRecentUser);
          RecentUtil.b(paramQQAppInterface, localAdvertisementItem.a, 10005);
          paramQQAppInterface.getMessageFacade().a(localAdvertisementItem.a, 10005);
        }
        a(paramQQAppInterface, paramRecentUser, localAdvertisementItem, false);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, AdvertisementItem paramAdvertisementItem, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dodelete ExpireItem uin:");
      localStringBuilder.append(paramRecentUser.uin);
      QLog.d("ImaxAdvertisement", 2, localStringBuilder.toString());
    }
    ThreadManager.executeOnFileThread(new ImaxAdRecentUserManager.1(this, paramBoolean, paramQQAppInterface, paramAdvertisementItem, paramRecentUser));
    a(paramRecentUser.uin);
  }
  
  public boolean a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool = true;
    if ((paramContext != null) && (paramQQAppInterface != null)) {
      if (TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdvertisement", 2, "openImaxAdvertisement empty uin!");
        }
      }
      else
      {
        Object localObject = b(paramString);
        if (localObject == null)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("openAdvertisement item recreated :");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("ImaxAdvertisement", 2, ((StringBuilder)localObject).toString());
          }
          localObject = AdvertisementItem.a(ImaxAdUtil.d(paramQQAppInterface.getCurrentUin(), paramString));
          if (localObject != null)
          {
            a((AdvertisementItem)localObject);
            a(paramContext, paramQQAppInterface, paramString, paramInt, (AdvertisementItem)localObject);
            break label151;
          }
        }
        else
        {
          a(paramContext, paramQQAppInterface, paramString, paramInt, (AdvertisementItem)localObject);
          break label151;
        }
      }
    }
    bool = false;
    label151:
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("openImaxAdvertisement result ");
      paramContext.append(bool);
      QLog.d("ImaxAdvertisement", 2, paramContext.toString());
    }
    return bool;
  }
  
  public AdvertisementItem b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (AdvertisementItem)this.b.get(paramString);
    }
    return null;
  }
  
  public void b()
  {
    this.b.clear();
  }
  
  public List<AdvertisementItem> c(String paramString)
  {
    ArrayList localArrayList = new ArrayList(2);
    if ((!TextUtils.isEmpty(paramString)) && (this.b.values() != null))
    {
      Iterator localIterator = this.b.values().iterator();
      while (localIterator.hasNext())
      {
        AdvertisementItem localAdvertisementItem = (AdvertisementItem)localIterator.next();
        Object localObject = localAdvertisementItem.c;
        if ((localObject != null) && (((ArrayList)localObject).size() > 0) && (paramString.equals(((VideoCoverItem)((ArrayList)localObject).get(0)).c)) && (localAdvertisementItem.k == 0))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getAdvertisementItembyVid:");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(" item:");
            ((StringBuilder)localObject).append(localAdvertisementItem.a);
            QLog.d("ImaxAdvertisement", 2, ((StringBuilder)localObject).toString());
          }
          localArrayList.add(localAdvertisementItem);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getAdvertisementItem disPlayitemList:");
      paramString.append(localArrayList.size());
      QLog.d("ImaxAdvertisement", 2, paramString.toString());
    }
    return localArrayList;
  }
  
  public void c()
  {
    if (this.b.values() != null)
    {
      Iterator localIterator = this.b.values().iterator();
      while (localIterator.hasNext()) {
        ((AdvertisementItem)localIterator.next()).f = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager
 * JD-Core Version:    0.7.0.1
 */