package cooperation.vip.utils;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import cooperation.qzone.QUA;
import cooperation.vip.pb.TianShuReport.UserActionReport;
import cooperation.vip.pb.TianShuReport.UserCommReport;
import cooperation.vip.tianshu.TianShuManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import mqq.app.AppRuntime;

public class Tools
{
  private static String a = "";
  private static String b = "";
  
  public static Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString == null) {
      return localBundle;
    }
    int i = paramString.indexOf('?');
    if (i >= 0)
    {
      i += 1;
      if (i >= paramString.length()) {
        return localBundle;
      }
      paramString = paramString.substring(i);
      if (TextUtils.isEmpty(paramString)) {
        return localBundle;
      }
      paramString = paramString.split("&");
      if (paramString != null)
      {
        i = 0;
        while (i < paramString.length)
        {
          String[] arrayOfString = paramString[i].split("=");
          if ((arrayOfString != null) && (arrayOfString.length == 2)) {
            try
            {
              localBundle.putString(arrayOfString[0], URLDecoder.decode(arrayOfString[1], "UTF-8"));
            }
            catch (IllegalArgumentException localIllegalArgumentException)
            {
              QLog.e("tools", 1, "parseUrlParams", localIllegalArgumentException);
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              localUnsupportedEncodingException.printStackTrace();
            }
          }
          i += 1;
        }
      }
    }
    return localBundle;
  }
  
  public static TianShuReport.UserActionReport a(TianShuReportData paramTianShuReportData)
  {
    TianShuReport.UserActionReport localUserActionReport = new TianShuReport.UserActionReport();
    a(localUserActionReport, paramTianShuReportData);
    localUserActionReport.appid.set(String.valueOf(paramTianShuReportData.f));
    localUserActionReport.to_uid.set(String.valueOf(paramTianShuReportData.a));
    localUserActionReport.trace_detail.set(String.valueOf(paramTianShuReportData.d));
    localUserActionReport.trace_index.set(String.valueOf(paramTianShuReportData.e));
    localUserActionReport.page_id.set(String.valueOf(paramTianShuReportData.g));
    localUserActionReport.item_id.set(String.valueOf(paramTianShuReportData.h));
    localUserActionReport.sub_item_id.set(String.valueOf(paramTianShuReportData.i));
    localUserActionReport.module_id.set(String.valueOf(paramTianShuReportData.j));
    localUserActionReport.sub_module_id.set(String.valueOf(paramTianShuReportData.k));
    localUserActionReport.position_id.set(String.valueOf(paramTianShuReportData.l));
    localUserActionReport.test_id.set(paramTianShuReportData.m);
    localUserActionReport.rule_id.set(paramTianShuReportData.n);
    localUserActionReport.oper_time.set(paramTianShuReportData.o);
    localUserActionReport.action_id.set(paramTianShuReportData.p);
    localUserActionReport.action_value.set(paramTianShuReportData.q);
    localUserActionReport.action_attr.set(paramTianShuReportData.r);
    localUserActionReport.busi_info.set(String.valueOf(paramTianShuReportData.t));
    localUserActionReport.item_type.set(String.valueOf(paramTianShuReportData.u));
    return localUserActionReport;
  }
  
  public static TianShuReport.UserCommReport a()
  {
    TianShuReport.UserCommReport localUserCommReport = new TianShuReport.UserCommReport();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localUserCommReport.uid.set(str);
    localUserCommReport.guid.set(String.valueOf(c()));
    str = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCityCode();
    localUserCommReport.city_code.set(String.valueOf(str));
    localUserCommReport.platform.set("AND");
    localUserCommReport.client_type.set("SQ");
    localUserCommReport.app_version.set(AppSetting.h());
    localUserCommReport.qua.set(String.valueOf(QUA.getQUA3()));
    localUserCommReport.network_type.set(d());
    if (PrivacyPolicyHelper.d())
    {
      localUserCommReport.mobile_type.set(String.valueOf(Build.MODEL));
      localUserCommReport.os_version.set(String.valueOf(DeviceInfoUtil.g()));
    }
    else
    {
      localUserCommReport.mobile_type.set("");
      localUserCommReport.os_version.set("");
    }
    localUserCommReport.qimei.set(String.valueOf(b()));
    return localUserCommReport;
  }
  
  private static void a(TianShuReport.UserActionReport paramUserActionReport, TianShuReportData paramTianShuReportData)
  {
    Object localObject = paramTianShuReportData.b;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (localObject != null) {
        localObject = ((AppRuntime)localObject).getAccount();
      } else {
        localObject = "";
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("_");
        localStringBuilder.append(NetConnInfoCenter.getServerTime());
        localObject = localStringBuilder.toString();
        paramUserActionReport.trace_id.set((String)localObject);
      }
    }
    else
    {
      paramUserActionReport.trace_id.set(String.valueOf(localObject));
    }
    localObject = String.valueOf(paramTianShuReportData.s);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = TianShuManager.getInstance().getTraceInfoFromCache(String.valueOf(paramTianShuReportData.h));
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramUserActionReport.trigger_info.set((String)localObject);
      }
    }
    else
    {
      paramUserActionReport.trigger_info.set((String)localObject);
    }
    int j = paramTianShuReportData.c;
    int i = j;
    if (j == -1) {
      i = 1;
    }
    paramUserActionReport.trace_num.set(i);
  }
  
  public static String b()
  {
    String str = b;
    if ((str != null) && (str.length() > 0)) {
      return b;
    }
    try
    {
      b = UserAction.getQIMEI();
      label25:
      return b;
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  public static String c()
  {
    String str = a;
    if ((str != null) && (str.length() > 0)) {
      return a;
    }
    try
    {
      a = QQDeviceInfo.getIMEI("07aa5e");
      label28:
      return a;
    }
    catch (Exception localException)
    {
      break label28;
    }
  }
  
  public static String d()
  {
    int i = NetworkUtil.getNetworkType(BaseApplicationImpl.getContext());
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return "UNKNOW";
          }
          return "4G";
        }
        return "3G";
      }
      return "2G";
    }
    return "WIFI";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.utils.Tools
 * JD-Core Version:    0.7.0.1
 */