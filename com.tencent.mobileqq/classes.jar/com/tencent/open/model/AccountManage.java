package com.tencent.open.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.OpenConst;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.data.SharedPrefs;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.observer.SSOAccountObserver;
import mqq.os.MqqHandler;

public class AccountManage
  implements OpenConst
{
  private static AccountManage jdField_a_of_type_ComTencentOpenModelAccountManage;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
  
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
  
  private void a(String paramString, SSOAccountObserver paramSSOAccountObserver, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("-->delegateGetTicketNoPasswd--refresh=");
    ((StringBuilder)localObject1).append(paramInt);
    SSOLog.a("BaseAccountManage", new Object[] { ((StringBuilder)localObject1).toString() });
    Bundle localBundle;
    if (paramBundle != null) {
      localBundle = new Bundle(paramBundle);
    } else {
      localBundle = new Bundle();
    }
    TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(2);
    Object localObject3 = localTicketManager.getSkey(paramString);
    if ((!SharedPrefs.a(paramString)) && (paramInt == 1))
    {
      boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
      localObject1 = null;
      if (!bool)
      {
        SSOLog.a("BaseAccountManage", new Object[] { "ticketqq valid" });
        localObject1 = localTicketManager.getSt(paramString, 16);
        paramBundle = localTicketManager.getStkey(paramString, 16);
      }
      else
      {
        paramBundle = null;
      }
      Object localObject4;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject4 = paramBundle;
        localObject2 = localObject1;
        if (paramBundle != null) {}
      }
      else
      {
        SSOLog.a("BaseAccountManage", new Object[] { "st == null || stKey == null appid = 16" });
        String str = localTicketManager.getOpenSdkKey(paramString, 4096);
        localObject3 = str;
        localObject4 = paramBundle;
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(str))
        {
          SSOLog.a("BaseAccountManage", new Object[] { "ticket opensdk valid" });
          localObject2 = localTicketManager.getSt(paramString, 1600001540);
          localObject4 = localTicketManager.getStkey(paramString, 1600001540);
          localObject3 = str;
        }
      }
      if ((localObject2 != null) && (localObject4 != null))
      {
        SSOLog.a("BaseAccountManage", new Object[] { "delegateGetTicketNoPasswd fake SSOAccountObserver success." });
        paramBundle = new Bundle();
        paramBundle.putBoolean("fake_callback", true);
        paramBundle.putByteArray("st_temp", (byte[])localObject2);
        paramBundle.putByteArray("st_temp_key", (byte[])localObject4);
        ThreadManager.getUIHandler().post(new AccountManage.2(this, paramSSOAccountObserver, paramString, (String)localObject3, paramBundle));
        i = 0;
        break label359;
      }
    }
    int i = 1;
    label359:
    if (i != 0)
    {
      if (TextUtils.isEmpty(localTicketManager.getSkey(paramString)))
      {
        SSOLog.a("BaseAccountManage", new Object[] { "delegateGetTicketNoPasswd appid=16 sKey empty" });
        localBundle.putLong("dwSrcAppid", 1600001540L);
        localBundle.putLong("dwDstAppid", 1600001540L);
      }
      if ((3 == paramInt) && (paramBoolean))
      {
        SSOLog.a("BaseAccountManage", new Object[] { "delegateGetTicketNoPasswd 110509 and use540Ticket" });
        localBundle.putLong("dwSrcAppid", 1600001540L);
        localBundle.putLong("dwDstAppid", 1600001540L);
      }
      this.jdField_a_of_type_MqqAppAppRuntime.ssoGetTicketNoPasswd(paramString, 4096, new AccountManage.3(this, paramSSOAccountObserver), localBundle);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, AccountManage.GetTicketCallback paramGetTicketCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTicketNoPasswd uin=");
    localStringBuilder.append(AuthorityUtil.a(paramString1));
    SSOLog.a("BaseAccountManage", new Object[] { localStringBuilder.toString() });
    a(paramString1, new AccountManage.1(this, paramGetTicketCallback), paramString2, paramInt);
  }
  
  public void a(String paramString1, SSOAccountObserver paramSSOAccountObserver, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("connect_data", AuthorityUtil.a(paramString2));
    boolean bool = AuthMemoryCache.a().a(paramString1);
    a(paramString1, paramSSOAccountObserver, paramInt, localBundle, AuthorityUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString1, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.model.AccountManage
 * JD-Core Version:    0.7.0.1
 */