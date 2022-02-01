package cooperation.vip.utils;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
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
    localUserActionReport.appid.set(String.valueOf(paramTianShuReportData.jdField_e_of_type_JavaLangString));
    localUserActionReport.to_uid.set(String.valueOf(paramTianShuReportData.jdField_a_of_type_JavaLangString));
    localUserActionReport.trace_detail.set(String.valueOf(paramTianShuReportData.jdField_c_of_type_JavaLangString));
    localUserActionReport.trace_index.set(String.valueOf(paramTianShuReportData.jdField_d_of_type_JavaLangString));
    localUserActionReport.page_id.set(String.valueOf(paramTianShuReportData.jdField_f_of_type_JavaLangString));
    localUserActionReport.item_id.set(String.valueOf(paramTianShuReportData.g));
    localUserActionReport.sub_item_id.set(String.valueOf(paramTianShuReportData.h));
    localUserActionReport.module_id.set(String.valueOf(paramTianShuReportData.i));
    localUserActionReport.sub_module_id.set(String.valueOf(paramTianShuReportData.j));
    localUserActionReport.position_id.set(String.valueOf(paramTianShuReportData.k));
    localUserActionReport.test_id.set(paramTianShuReportData.jdField_b_of_type_Int);
    localUserActionReport.rule_id.set(paramTianShuReportData.jdField_c_of_type_Int);
    localUserActionReport.oper_time.set(paramTianShuReportData.jdField_a_of_type_Long);
    localUserActionReport.action_id.set(paramTianShuReportData.jdField_d_of_type_Int);
    localUserActionReport.action_value.set(paramTianShuReportData.jdField_e_of_type_Int);
    localUserActionReport.action_attr.set(paramTianShuReportData.jdField_f_of_type_Int);
    localUserActionReport.busi_info.set(String.valueOf(paramTianShuReportData.m));
    localUserActionReport.item_type.set(String.valueOf(paramTianShuReportData.n));
    return localUserActionReport;
  }
  
  public static TianShuReport.UserCommReport a()
  {
    TianShuReport.UserCommReport localUserCommReport = new TianShuReport.UserCommReport();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localUserCommReport.uid.set(str);
    localUserCommReport.guid.set(String.valueOf(b()));
    str = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCityCode();
    localUserCommReport.city_code.set(String.valueOf(str));
    localUserCommReport.platform.set("AND");
    localUserCommReport.client_type.set("SQ");
    localUserCommReport.app_version.set(AppSetting.f());
    localUserCommReport.qua.set(String.valueOf(QUA.getQUA3()));
    localUserCommReport.network_type.set(c());
    localUserCommReport.mobile_type.set(String.valueOf(Build.MODEL));
    localUserCommReport.os_version.set(String.valueOf(DeviceInfoUtil.e()));
    localUserCommReport.qimei.set(String.valueOf(a()));
    return localUserCommReport;
  }
  
  public static String a()
  {
    String str = jdField_b_of_type_JavaLangString;
    if ((str != null) && (str.length() > 0)) {
      return jdField_b_of_type_JavaLangString;
    }
    try
    {
      jdField_b_of_type_JavaLangString = UserAction.getQIMEI();
      label25:
      return jdField_b_of_type_JavaLangString;
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  private static void a(TianShuReport.UserActionReport paramUserActionReport, TianShuReportData paramTianShuReportData)
  {
    Object localObject = paramTianShuReportData.jdField_b_of_type_JavaLangString;
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
    localObject = String.valueOf(paramTianShuReportData.l);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = TianShuManager.getInstance().getTraceInfoFromCache(String.valueOf(paramTianShuReportData.g));
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramUserActionReport.trigger_info.set((String)localObject);
      }
    }
    else
    {
      paramUserActionReport.trigger_info.set((String)localObject);
    }
    int j = paramTianShuReportData.jdField_a_of_type_Int;
    int i = j;
    if (j == -1) {
      i = 1;
    }
    paramUserActionReport.trace_num.set(i);
  }
  
  public static String b()
  {
    String str = jdField_a_of_type_JavaLangString;
    if ((str != null) && (str.length() > 0)) {
      return jdField_a_of_type_JavaLangString;
    }
    try
    {
      jdField_a_of_type_JavaLangString = QQDeviceInfo.getIMEI("07aa5e");
      label28:
      return jdField_a_of_type_JavaLangString;
    }
    catch (Exception localException)
    {
      break label28;
    }
  }
  
  public static String c()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.utils.Tools
 * JD-Core Version:    0.7.0.1
 */