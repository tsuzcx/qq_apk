package com.tencent.open.model;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import bipr;
import bivh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;

public class AccountManage
{
  private static AccountManage jdField_a_of_type_ComTencentOpenModelAccountManage;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication();
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
  private WtloginManager jdField_a_of_type_MqqManagerWtloginManager = (WtloginManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(1);
  
  public static AccountManage a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenModelAccountManage == null) {
        jdField_a_of_type_ComTencentOpenModelAccountManage = new AccountManage();
      }
      AccountManage localAccountManage = jdField_a_of_type_ComTencentOpenModelAccountManage;
      return localAccountManage;
    }
    finally {}
  }
  
  public void a()
  {
    Object localObject = bivh.a();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(str, 16))
        {
          QLog.d("open_log", 1, "-->checkLoginHistory-- host login " + bipr.a(str));
        }
        else if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(str, 1600001540))
        {
          QLog.d("open_log", 1, "-->checkLoginHistory-- opensdk login " + bipr.a(str));
        }
        else
        {
          QLog.d("open_log", 1, "-->checkLoginHistory-- need passwd " + bipr.a(str));
          bivh.b(str);
        }
      }
    }
  }
  
  public void a(String paramString, SSOAccountObserver paramSSOAccountObserver, AccountManage.RefreshReason paramRefreshReason, Bundle paramBundle)
  {
    QLog.d("open_log", 1, "-->delegateGetTicketNoPasswd--refresh=" + paramRefreshReason);
    Bundle localBundle;
    TicketManager localTicketManager;
    if (paramBundle != null)
    {
      localBundle = new Bundle(paramBundle);
      localTicketManager = (TicketManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(2);
      Object localObject2 = localTicketManager.getSkey(paramString);
      if ((bivh.a(paramString)) || (paramRefreshReason != AccountManage.RefreshReason.useCacheFirst)) {
        break label461;
      }
      Object localObject1 = null;
      paramBundle = null;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        QLog.d("open_log", 1, "ticketqq valid");
        localObject1 = localTicketManager.getSt(paramString, 16);
        paramBundle = localTicketManager.getStkey(paramString, 16);
      }
      Object localObject4;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject4 = paramBundle;
        localObject3 = localObject1;
        if (paramBundle != null) {}
      }
      else
      {
        QLog.d("open_log", 1, "st == null || stKey == null appid = 16");
        String str = localTicketManager.getOpenSdkKey(paramString, 4096);
        localObject4 = paramBundle;
        localObject3 = localObject1;
        localObject2 = str;
        if (!TextUtils.isEmpty(str))
        {
          QLog.d("open_log", 1, "ticket opensdk valid");
          localObject3 = localTicketManager.getSt(paramString, 1600001540);
          localObject4 = localTicketManager.getStkey(paramString, 1600001540);
          localObject2 = str;
        }
      }
      if ((localObject3 == null) || (localObject4 == null)) {
        break label461;
      }
      QLog.d("open_log", 1, "delegateGetTicketNoPasswd fake SSOAccountObserver success.");
      paramBundle = new Bundle();
      paramBundle.putBoolean("fake_callback", true);
      paramBundle.putByteArray("st_temp", (byte[])localObject3);
      paramBundle.putByteArray("st_temp_key", (byte[])localObject4);
      localObject1 = new WeakReference(paramSSOAccountObserver);
      this.jdField_a_of_type_AndroidOsHandler.post(new AccountManage.1(this, (WeakReference)localObject1, paramString, (String)localObject2, paramBundle));
    }
    label461:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        if (TextUtils.isEmpty(localTicketManager.getSkey(paramString)))
        {
          QLog.d("open_log", 1, "delegateGetTicketNoPasswd appid=16 sKey empty");
          localBundle.putLong("dwSrcAppid", 1600001540L);
          localBundle.putLong("dwDstAppid", 1600001540L);
        }
        if ((AccountManage.RefreshReason.forceRefreshBy110509 == paramRefreshReason) && (bipr.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString)))
        {
          QLog.d("open_log", 1, "delegateGetTicketNoPasswd 110509 and use540Ticket");
          localBundle.putLong("dwSrcAppid", 1600001540L);
          localBundle.putLong("dwDstAppid", 1600001540L);
        }
        if (16L == localBundle.getLong("dwSrcAppid", 16L))
        {
          QLog.d("open_log", 1, "dw_use_default_sub_appid");
          localBundle.putBoolean("dw_use_default_sub_appid", true);
        }
        this.jdField_a_of_type_MqqAppAppRuntime.ssoGetTicketNoPasswd(paramString, 4096, paramSSOAccountObserver, localBundle);
      }
      return;
      localBundle = new Bundle();
      break;
    }
  }
  
  public void a(String paramString1, SSOAccountObserver paramSSOAccountObserver, String paramString2, AccountManage.RefreshReason paramRefreshReason)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("connect_data", bipr.a(paramString2));
    a(paramString1, paramSSOAccountObserver, paramRefreshReason, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.model.AccountManage
 * JD-Core Version:    0.7.0.1
 */