package com.tencent.mobileqq.forward;

import android.text.TextUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.webviewplugin.Share.IconUrlSize;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.protofile.getappinfo.GetAppInfoProto.Ads;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0xd55.RspBody;
import tencent.im.oidb.qqconnect.AndroidAppInfo;
import tencent.im.oidb.qqconnect.Appinfo;
import tencent.im.oidb.qqconnect.MobileAppInfo;

public class AppInfo
{
  public GetAppInfoProto.Ads a;
  public List<Share.IconUrlSize> b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private int i;
  private boolean j;
  private String k;
  
  private static int a(List<Share.IconUrlSize> paramList)
  {
    paramList = paramList.iterator();
    int m = 0;
    while (paramList.hasNext())
    {
      Share.IconUrlSize localIconUrlSize = (Share.IconUrlSize)paramList.next();
      if ("16".equals(localIconUrlSize.b.get())) {
        m |= 0x1;
      } else if ("64".equals(localIconUrlSize.b.get())) {
        m |= 0x2;
      } else if ("100".equals(localIconUrlSize.b.get())) {
        m |= 0x4;
      }
    }
    return m;
  }
  
  public static int a(qqconnect.Appinfo paramAppinfo)
  {
    if (paramAppinfo.icon_mini_url.has()) {
      n = 1;
    } else {
      n = 0;
    }
    int m;
    if (!paramAppinfo.icon_middle_url.has())
    {
      m = n;
      if (!paramAppinfo.icon_small_url.has()) {}
    }
    else
    {
      m = n | 0x2;
    }
    int n = m;
    if (paramAppinfo.icon_url.has()) {
      n = m | 0x4;
    }
    return n;
  }
  
  public static AppInfo a(GetAppInfoProto.GetAppinfoResponse paramGetAppinfoResponse)
  {
    AppInfo localAppInfo = new AppInfo();
    localAppInfo.a = paramGetAppinfoResponse.ads;
    localAppInfo.b = Share.a(paramGetAppinfoResponse.iconsURL);
    if (!localAppInfo.b.isEmpty())
    {
      localAppInfo.c = Share.a(localAppInfo.b, 16);
      localAppInfo.d = Share.a(localAppInfo.b, 100);
      localAppInfo.i = a(localAppInfo.b);
    }
    GetAppInfoProto.AndroidInfo localAndroidInfo = paramGetAppinfoResponse.androidInfo;
    if (localAndroidInfo != null)
    {
      localAppInfo.j = true;
      boolean bool = localAndroidInfo.sourceUrl.has();
      String str = "";
      if (bool) {
        paramGetAppinfoResponse = localAndroidInfo.sourceUrl.get();
      } else {
        paramGetAppinfoResponse = "";
      }
      localAppInfo.e = paramGetAppinfoResponse;
      if (localAndroidInfo.messagetail.has()) {
        paramGetAppinfoResponse = localAndroidInfo.messagetail.get();
      } else {
        paramGetAppinfoResponse = "";
      }
      localAppInfo.f = paramGetAppinfoResponse;
      paramGetAppinfoResponse = str;
      if (localAndroidInfo.packName.has()) {
        paramGetAppinfoResponse = localAndroidInfo.packName.get();
      }
      localAppInfo.g = paramGetAppinfoResponse;
    }
    SSOLog.a("AppInfo", new Object[] { "convertToAppInfo AppInfo : ", localAppInfo.toString() });
    return localAppInfo;
  }
  
  private static String a(qqconnect.Appinfo paramAppinfo, String paramString)
  {
    boolean bool = paramAppinfo.mobile_app_info.has();
    Iterator localIterator = null;
    Object localObject2 = null;
    Object localObject1 = localIterator;
    if (bool)
    {
      localObject1 = localIterator;
      if (paramAppinfo.mobile_app_info.android_app_info.has())
      {
        localIterator = paramAppinfo.mobile_app_info.android_app_info.get().iterator();
        paramAppinfo = localObject2;
        for (;;)
        {
          localObject1 = paramAppinfo;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (qqconnect.AndroidAppInfo)localIterator.next();
          if (((qqconnect.AndroidAppInfo)localObject1).pack_name.has())
          {
            paramAppinfo = ((qqconnect.AndroidAppInfo)localObject1).pack_name.get();
            if (paramAppinfo.equals(paramString)) {
              return paramString;
            }
          }
        }
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return paramString;
    }
    return localObject1;
  }
  
  public static void a(oidb_0xd55.RspBody paramRspBody, String paramString, AppInfo paramAppInfo)
  {
    paramAppInfo.j = true;
    qqconnect.Appinfo localAppinfo = paramRspBody.appinfo;
    paramAppInfo.c = localAppinfo.icon_mini_url.get();
    paramAppInfo.d = localAppinfo.icon_url.get();
    paramAppInfo.i = a(localAppinfo);
    paramAppInfo.e = localAppinfo.source_url.get();
    paramAppInfo.f = localAppinfo.app_name.get();
    paramAppInfo.g = a(localAppinfo, paramString);
    paramAppInfo.h = b(localAppinfo, paramAppInfo.g);
    if (paramRspBody.wording.has()) {
      paramRspBody = paramRspBody.wording.get();
    } else {
      paramRspBody = "";
    }
    paramAppInfo.k = paramRspBody;
    SSOLog.a("AppInfo", new Object[] { "fillAppInfo AppInfo : ", paramAppInfo.toString() });
  }
  
  private static String b(qqconnect.Appinfo paramAppinfo, String paramString)
  {
    if ((paramAppinfo.mobile_app_info.has()) && (paramAppinfo.mobile_app_info.android_app_info.has()))
    {
      paramAppinfo = paramAppinfo.mobile_app_info.android_app_info.get().iterator();
      while (paramAppinfo.hasNext())
      {
        qqconnect.AndroidAppInfo localAndroidAppInfo = (qqconnect.AndroidAppInfo)paramAppinfo.next();
        if ((localAndroidAppInfo.pack_name.has()) && (paramString.equals(localAndroidAppInfo.pack_name.get())) && (localAndroidAppInfo.url_scheme.has())) {
          return localAndroidAppInfo.url_scheme.get();
        }
      }
    }
    return null;
  }
  
  public boolean a()
  {
    return this.j;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public String d()
  {
    return this.f;
  }
  
  public String e()
  {
    return this.g;
  }
  
  public String f()
  {
    return this.d;
  }
  
  public int g()
  {
    return this.i;
  }
  
  public String h()
  {
    return this.k;
  }
  
  public String i()
  {
    return this.h;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("iconUrlMini=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", iconUrlBig=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", appLackOfIcons=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", isAndroidInfoExist=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", sourceUrl=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", appName=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", pkgName=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mErrorWording=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(",scheme:");
    localStringBuilder.append(this.h);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.AppInfo
 * JD-Core Version:    0.7.0.1
 */