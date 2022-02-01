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
  private int jdField_a_of_type_Int;
  public GetAppInfoProto.Ads a;
  private String jdField_a_of_type_JavaLangString;
  public List<Share.IconUrlSize> a;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  private static int a(List<Share.IconUrlSize> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Share.IconUrlSize localIconUrlSize = (Share.IconUrlSize)paramList.next();
      if ("16".equals(localIconUrlSize.b.get())) {
        i |= 0x1;
      } else if ("64".equals(localIconUrlSize.b.get())) {
        i |= 0x2;
      } else if ("100".equals(localIconUrlSize.b.get())) {
        i |= 0x4;
      }
    }
    return i;
  }
  
  public static int a(qqconnect.Appinfo paramAppinfo)
  {
    if (paramAppinfo.icon_mini_url.has()) {
      j = 1;
    } else {
      j = 0;
    }
    int i;
    if (!paramAppinfo.icon_middle_url.has())
    {
      i = j;
      if (!paramAppinfo.icon_small_url.has()) {}
    }
    else
    {
      i = j | 0x2;
    }
    int j = i;
    if (paramAppinfo.icon_url.has()) {
      j = i | 0x4;
    }
    return j;
  }
  
  public static AppInfo a(GetAppInfoProto.GetAppinfoResponse paramGetAppinfoResponse)
  {
    AppInfo localAppInfo = new AppInfo();
    localAppInfo.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$Ads = paramGetAppinfoResponse.ads;
    localAppInfo.jdField_a_of_type_JavaUtilList = Share.a(paramGetAppinfoResponse.iconsURL);
    if (!localAppInfo.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localAppInfo.jdField_a_of_type_JavaLangString = Share.a(localAppInfo.jdField_a_of_type_JavaUtilList, 16);
      localAppInfo.b = Share.a(localAppInfo.jdField_a_of_type_JavaUtilList, 100);
      localAppInfo.jdField_a_of_type_Int = a(localAppInfo.jdField_a_of_type_JavaUtilList);
    }
    GetAppInfoProto.AndroidInfo localAndroidInfo = paramGetAppinfoResponse.androidInfo;
    if (localAndroidInfo != null)
    {
      localAppInfo.jdField_a_of_type_Boolean = true;
      boolean bool = localAndroidInfo.sourceUrl.has();
      String str = "";
      if (bool) {
        paramGetAppinfoResponse = localAndroidInfo.sourceUrl.get();
      } else {
        paramGetAppinfoResponse = "";
      }
      localAppInfo.c = paramGetAppinfoResponse;
      if (localAndroidInfo.messagetail.has()) {
        paramGetAppinfoResponse = localAndroidInfo.messagetail.get();
      } else {
        paramGetAppinfoResponse = "";
      }
      localAppInfo.d = paramGetAppinfoResponse;
      paramGetAppinfoResponse = str;
      if (localAndroidInfo.packName.has()) {
        paramGetAppinfoResponse = localAndroidInfo.packName.get();
      }
      localAppInfo.e = paramGetAppinfoResponse;
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
    paramAppInfo.jdField_a_of_type_Boolean = true;
    qqconnect.Appinfo localAppinfo = paramRspBody.appinfo;
    paramAppInfo.jdField_a_of_type_JavaLangString = localAppinfo.icon_mini_url.get();
    paramAppInfo.b = localAppinfo.icon_url.get();
    paramAppInfo.jdField_a_of_type_Int = a(localAppinfo);
    paramAppInfo.c = localAppinfo.source_url.get();
    paramAppInfo.d = localAppinfo.app_name.get();
    paramAppInfo.e = a(localAppinfo, paramString);
    if (paramRspBody.wording.has()) {
      paramRspBody = paramRspBody.wording.get();
    } else {
      paramRspBody = "";
    }
    paramAppInfo.f = paramRspBody;
    SSOLog.a("AppInfo", new Object[] { "fillAppInfo AppInfo : ", paramAppInfo.toString() });
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.b;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("iconUrlMini=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", iconUrlBig=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", appLackOfIcons=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", isAndroidInfoExist=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", sourceUrl=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", appName=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", pkgName=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mErrorWording=");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.AppInfo
 * JD-Core Version:    0.7.0.1
 */