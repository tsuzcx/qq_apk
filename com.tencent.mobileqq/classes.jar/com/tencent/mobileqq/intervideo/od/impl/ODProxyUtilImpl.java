package com.tencent.mobileqq.intervideo.od.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper.AccountInfo;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.od.IODProxyUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ODProxyUtilImpl
  implements IODProxyUtil
{
  public Bundle getODIntentBundle(IVPluginInfo paramIVPluginInfo, ILoginKeyHelper paramILoginKeyHelper)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      int m;
      try
      {
        localObject1 = ((BaseApplicationImpl)MobileQQ.getContext()).waitAppRuntime(null);
        str2 = ((AppRuntime)localObject1).getAccount();
        localObject1 = (FriendsManager)((AppRuntime)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
        localObject2 = ((FriendsManager)localObject1).e(str2);
        m = 0;
        if (localObject2 == null) {
          break label436;
        }
        str1 = ((Friends)localObject2).name;
        j = ((Friends)localObject2).gender;
        i = ((Friends)localObject2).age;
        localObject2 = ((FriendsManager)localObject1).a(str2);
        if (localObject2 == null) {
          break label448;
        }
        k = (int)((Card)localObject2).lBirthday;
        localObject1 = ((Card)localObject2).strCountry;
        localObject3 = ((Card)localObject2).strProvince;
        localObject2 = ((Card)localObject2).strCity;
      }
      catch (Exception paramIVPluginInfo)
      {
        String str2;
        paramIVPluginInfo.printStackTrace();
      }
      localBundle.putString("nickname", str1);
      localBundle.putLong("roomid", paramIVPluginInfo.a);
      localBundle.putInt("authtype", 1);
      localBundle.putString("authid", paramILoginKeyHelper.getAccountInfo().b);
      localBundle.putInt("gender", j);
      localBundle.putInt("vastype", 2);
      localBundle.putLong("hostid", Long.parseLong(str2));
      localBundle.putString("authkey", paramILoginKeyHelper.getAccountInfo().a);
      localBundle.putString("appid", paramIVPluginInfo.b);
      localBundle.putString("vasname", paramIVPluginInfo.g);
      localBundle.putString("userdata", paramIVPluginInfo.d);
      localBundle.putInt("fromid", Integer.parseInt(paramIVPluginInfo.e));
      localBundle.putInt("age", i);
      localBundle.putInt("birthyear", k);
      localBundle.putInt("birthmonth", m);
      int n;
      localBundle.putInt("birthday", n);
      localBundle.putBoolean("loghost", true);
      localBundle.putBoolean("reporthost", true);
      localBundle.putString("backType", paramIVPluginInfo.h);
      localBundle.putInt("isGroupCode", paramIVPluginInfo.c);
      localBundle.putString("openType", paramIVPluginInfo.i);
      localBundle.putString("extra", paramIVPluginInfo.j);
      localBundle.putString("payToken", paramILoginKeyHelper.getAccountInfo().c);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localBundle.putString("addrCountry", (String)localObject1);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localBundle.putString("addrProv", (String)localObject3);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localBundle.putString("addrCity", (String)localObject2);
        return localBundle;
      }
      return localBundle;
      label436:
      String str1 = "";
      int i = 0;
      int j = 0;
      continue;
      label448:
      Object localObject2 = "";
      Object localObject1 = localObject2;
      Object localObject3 = localObject1;
      int k = 0;
      if (k == 0)
      {
        k = 1995;
        n = 0;
      }
      else
      {
        n = k & 0xFF;
        m = k >>> 16;
        int i1 = (0xFF00 & k) >>> 8;
        k = m;
        m = i1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.od.impl.ODProxyUtilImpl
 * JD-Core Version:    0.7.0.1
 */