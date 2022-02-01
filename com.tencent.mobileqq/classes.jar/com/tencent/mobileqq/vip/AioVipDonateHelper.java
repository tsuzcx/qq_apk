package com.tencent.mobileqq.vip;

import MQQ.VipUserInfo;
import VIP.AIOSendRes;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class AioVipDonateHelper
{
  public static String a = "aioVipDonateInfoSpFile_";
  public static String b = "lastCheckTime_";
  public static String c = "sendDisable";
  public static String d = "checkFreq";
  public static String e = "grayTail";
  public static String f = "sendList";
  public static String g = "popGraytips";
  public static String h = "graytips";
  public static String i = "hightLight";
  public static String j = "jumpUrl";
  public static int k = 1;
  public static String l = "";
  public static int m = 1;
  private static AioVipDonateHelper v;
  private int n = -1;
  private int o = -1;
  private String p = null;
  private List<String> q = null;
  private int r = -1;
  private String s;
  private String t;
  private String u;
  
  public static AioVipDonateHelper a()
  {
    if (v == null) {
      try
      {
        if (v == null) {
          v = new AioVipDonateHelper();
        }
      }
      finally {}
    }
    return v;
  }
  
  private void h(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences(a, 0).edit();
    paramQQAppInterface.putInt(g, this.r);
    if (!TextUtils.isEmpty(this.s)) {
      paramQQAppInterface.putString(h, this.s);
    }
    if (!TextUtils.isEmpty(this.t)) {
      paramQQAppInterface.putString(i, this.t);
    }
    if (!TextUtils.isEmpty(this.u)) {
      paramQQAppInterface.putString(j, this.u);
    }
    paramQQAppInterface.apply();
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    this.r = paramInt;
    MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).edit();
    paramQQAppInterface.putInt(g, paramInt);
    if (Build.VERSION.SDK_INT < 9)
    {
      paramQQAppInterface.commit();
      return;
    }
    paramQQAppInterface.apply();
  }
  
  @TargetApi(9)
  public void a(QQAppInterface paramQQAppInterface, VipUserInfo paramVipUserInfo)
  {
    if (paramQQAppInterface != null)
    {
      if (paramVipUserInfo == null) {
        return;
      }
      Object localObject1 = paramQQAppInterface.getCurrentAccountUin();
      paramQQAppInterface = paramQQAppInterface.getApplication();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(a);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      int i2 = 0;
      paramQQAppInterface = paramQQAppInterface.getSharedPreferences((String)localObject1, 0).edit();
      this.n = paramVipUserInfo.iSendDisable;
      this.o = paramVipUserInfo.iCheckFreq;
      if (!TextUtils.isEmpty(paramVipUserInfo.sGrayTail))
      {
        this.p = paramVipUserInfo.sGrayTail;
        paramQQAppInterface.putString(e, paramVipUserInfo.sGrayTail);
      }
      if ((paramVipUserInfo.vSendList != null) && (paramVipUserInfo.vSendList.size() > 0))
      {
        localObject1 = new StringBuilder();
        int i1 = i2;
        if (this.q == null)
        {
          this.q = new ArrayList();
          i1 = i2;
        }
        while (i1 < paramVipUserInfo.vSendList.size())
        {
          localObject2 = String.valueOf(paramVipUserInfo.vSendList.get(i1));
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(",");
          this.q.add(localObject2);
          i1 += 1;
        }
        paramQQAppInterface.putString(f, ((StringBuilder)localObject1).toString());
      }
      paramQQAppInterface.putInt(c, this.n);
      paramQQAppInterface.putInt(d, this.o);
      if (Build.VERSION.SDK_INT < 9)
      {
        paramQQAppInterface.commit();
        return;
      }
      paramQQAppInterface.apply();
    }
  }
  
  @TargetApi(9)
  public void a(QQAppInterface paramQQAppInterface, AIOSendRes paramAIOSendRes)
  {
    if (paramQQAppInterface != null)
    {
      if (paramAIOSendRes == null) {
        return;
      }
      this.r = paramAIOSendRes.iPopGrayStip;
      this.s = paramAIOSendRes.sGrayStipMsg;
      paramAIOSendRes = paramAIOSendRes.mHighLightMap;
      if ((paramAIOSendRes != null) && (paramAIOSendRes.size() > 0))
      {
        this.t = ((String)paramAIOSendRes.keySet().iterator().next());
        if (!TextUtils.isEmpty(this.t)) {
          this.u = ((String)paramAIOSendRes.get(this.t));
        }
      }
      h(paramQQAppInterface);
      if (this.r == m)
      {
        paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.sendMessage(paramQQAppInterface.obtainMessage(58));
        }
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (paramQQAppInterface == null) {
      return false;
    }
    if (this.n == -1)
    {
      MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      this.n = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getInt(c, -1);
    }
    if (this.n == k) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (this.q == null) {
        this.q = new ArrayList();
      }
      if (this.q.size() < 1)
      {
        MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(a);
        localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
        paramQQAppInterface = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getString(f, null);
        if (!TextUtils.isEmpty(paramQQAppInterface))
        {
          paramQQAppInterface = paramQQAppInterface.split(",");
          int i1 = 0;
          while (i1 < paramQQAppInterface.length)
          {
            localMobileQQ = paramQQAppInterface[i1];
            if (!TextUtils.isEmpty(localMobileQQ)) {
              this.q.add(localMobileQQ.trim());
            }
            i1 += 1;
          }
        }
      }
      paramQQAppInterface = this.q;
      if ((paramQQAppInterface != null) && (paramQQAppInterface.contains(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    String str = paramQQAppInterface.getCurrentAccountUin();
    MobileQQ localMobileQQ;
    if (TextUtils.isEmpty(this.p))
    {
      localMobileQQ = paramQQAppInterface.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      this.p = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getString(e, null);
    }
    if (!TextUtils.isEmpty(this.p))
    {
      paramQQAppInterface = this.p.split(",");
      int i1 = 0;
      while (i1 < paramQQAppInterface.length)
      {
        localMobileQQ = paramQQAppInterface[i1];
        if ((!TextUtils.isEmpty(localMobileQQ)) && (str.endsWith(localMobileQQ.trim()))) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  public long c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return -1L;
    }
    if (this.o == -1)
    {
      MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      this.o = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getInt(d, -1);
    }
    return this.o * 60 * 1000;
  }
  
  public boolean d(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (paramQQAppInterface == null) {
      return false;
    }
    if (this.r == -1)
    {
      MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      this.r = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getInt(g, 0);
    }
    if (this.r == m) {
      bool = true;
    }
    return bool;
  }
  
  public String e(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (TextUtils.isEmpty(this.s))
    {
      MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      this.s = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getString(h, null);
    }
    return this.s;
  }
  
  public String f(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (TextUtils.isEmpty(this.t))
    {
      MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      this.t = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getString(i, null);
    }
    return this.t;
  }
  
  public String g(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (TextUtils.isEmpty(this.u))
    {
      MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      this.u = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getString(j, l);
    }
    return this.u;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.AioVipDonateHelper
 * JD-Core Version:    0.7.0.1
 */