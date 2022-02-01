package com.tencent.mobileqq.troop.soso;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwConfig;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.app.MobileQQ;

public class SosoSrvAddrProvider
{
  public static int c;
  public static int d = c + 1;
  private static SosoSrvAddrProvider g;
  SosoSrvAddrProvider.SrvAddrChooser a = new SosoSrvAddrProvider.SrvAddrChooser(this);
  Application b;
  private List<ISvrAddr> e;
  private boolean f = false;
  
  private SosoSrvAddrProvider(Application paramApplication)
  {
    this.b = paramApplication;
  }
  
  public static SosoSrvAddrProvider a()
  {
    if (g == null) {
      try
      {
        if (g == null) {
          g = new SosoSrvAddrProvider(MobileQQ.sMobileQQ);
        }
      }
      finally {}
    }
    return g;
  }
  
  private List<ISvrAddr> a(int paramInt)
  {
    if (paramInt == 0) {
      return this.e;
    }
    return null;
  }
  
  public String a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        Object localObject4 = this.a.a(paramInt, paramBoolean1);
        if (localObject4 != null)
        {
          Object localObject3 = ((ISvrAddr)localObject4).a();
          paramInt = ((ISvrAddr)localObject4).b();
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          localObject3 = localObject1;
          if (((String)localObject1).indexOf(':') >= 0)
          {
            localObject3 = localObject1;
            if (!((String)localObject1).startsWith("["))
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("[");
              ((StringBuilder)localObject3).append((String)localObject1);
              ((StringBuilder)localObject3).append("]");
              localObject3 = ((StringBuilder)localObject3).toString();
              break label189;
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append((String)localObject1);
              ((StringBuilder)localObject4).append((String)localObject3);
              ((StringBuilder)localObject4).append(":");
              ((StringBuilder)localObject4).append(paramInt);
              ((StringBuilder)localObject4).append("/");
              localObject1 = ((StringBuilder)localObject4).toString();
            }
          }
        }
        else
        {
          return localObject1;
        }
      }
      finally {}
      label189:
      String str;
      if (paramBoolean2) {
        str = "https://";
      } else {
        str = "http://";
      }
    }
  }
  
  public String a(AppInterface paramAppInterface, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = null;
    if (paramAppInterface == null) {
      return null;
    }
    String str = "";
    for (;;)
    {
      boolean bool;
      try
      {
        localObject = ConfigManager.getInstance(BaseApplication.getContext(), paramAppInterface.getHwEngine());
        if (localObject != null)
        {
          localObject = ((ConfigManager)localObject).getOtherTypeIp(paramAppInterface.getApp().getBaseContext(), 21, paramBoolean1);
          bool = false;
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            paramAppInterface = ((EndPoint)((List)localObject).get(0)).host;
            paramInt = ((EndPoint)((List)localObject).get(0)).port;
          }
          else
          {
            if ((!this.f) && (NetworkUtil.isNetworkAvailable(BaseApplication.getContext())))
            {
              HwServlet.getConfig(paramAppInterface, paramAppInterface.getCurrentAccountUin());
              this.f = true;
            }
            localObject = this.a.a(paramInt, paramBoolean1);
            if (localObject == null) {
              break label329;
            }
            paramAppInterface = ((ISvrAddr)localObject).a();
            paramInt = ((ISvrAddr)localObject).b();
            paramBoolean2 = bool;
          }
          localObject = localStringBuilder;
          if (!TextUtils.isEmpty(paramAppInterface))
          {
            localObject = localStringBuilder;
            if (paramInt != -1)
            {
              localObject = paramAppInterface;
              if (paramAppInterface.indexOf(':') < 0) {
                break label341;
              }
              localObject = paramAppInterface;
              if (paramAppInterface.startsWith("[")) {
                break label341;
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("[");
              ((StringBuilder)localObject).append(paramAppInterface);
              ((StringBuilder)localObject).append("]");
              localObject = ((StringBuilder)localObject).toString();
              break label341;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramAppInterface);
              localStringBuilder.append((String)localObject);
              localStringBuilder.append(":");
              localStringBuilder.append(paramInt);
              localStringBuilder.append("/");
              localObject = localStringBuilder.toString();
            }
          }
          return localObject;
        }
      }
      finally {}
      Object localObject = null;
      continue;
      label329:
      paramInt = -1;
      paramAppInterface = str;
      paramBoolean2 = bool;
      continue;
      label341:
      if (paramBoolean2) {
        paramAppInterface = "https://";
      } else {
        paramAppInterface = "http://";
      }
    }
  }
  
  public void a(List<ISvrAddr> paramList)
  {
    try
    {
      this.e = paramList;
      this.a.a(paramList);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public void b()
  {
    Object localObject = this.b.getSharedPreferences("SosoSrvAddrList", 0).edit();
    if (localObject != null) {
      ((SharedPreferences.Editor)localObject).remove("SosoSrvAddrList_key").commit();
    }
    localObject = new Intent("com.tencent.receiver.soso");
    ((Intent)localObject).putExtra("com.tencent.receiver.soso.type", d);
    this.b.sendBroadcast((Intent)localObject);
  }
  
  public void c()
  {
    ArrayList localArrayList = new ArrayList();
    HwConfig localHwConfig = (HwConfig)((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getHighwayConfig();
    if (localHwConfig != null)
    {
      int i;
      SvrAddr localSvrAddr;
      if ((localHwConfig.ipv6List != null) && (localHwConfig.ipv6List.size() > 0))
      {
        i = 0;
        while (i < localHwConfig.ipv6List.size())
        {
          localSvrAddr = new SvrAddr();
          localSvrAddr.a = ((EndPoint)localHwConfig.ipv6List.get(i)).host;
          localSvrAddr.b = ((EndPoint)localHwConfig.ipv6List.get(i)).port;
          localSvrAddr.c = true;
          localArrayList.add(localSvrAddr);
          i += 1;
        }
      }
      if ((localHwConfig.ipList != null) && (localHwConfig.ipList.size() > 0))
      {
        i = 0;
        while (i < localHwConfig.ipList.size())
        {
          localSvrAddr = new SvrAddr();
          localSvrAddr.a = ((EndPoint)localHwConfig.ipList.get(i)).host;
          localSvrAddr.b = ((EndPoint)localHwConfig.ipList.get(i)).port;
          localSvrAddr.c = false;
          localArrayList.add(localSvrAddr);
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("SosoSrvAddrProvider", 2, String.format("init iplist=%s", new Object[] { Arrays.toString(localArrayList.toArray()) }));
    }
    a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.soso.SosoSrvAddrProvider
 * JD-Core Version:    0.7.0.1
 */