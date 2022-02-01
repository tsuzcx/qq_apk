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
  private static String a;
  private static String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
  }
  
  public static Bundle a(String paramString)
  {
    int i = 0;
    Bundle localBundle = new Bundle();
    if (paramString == null) {
      return localBundle;
    }
    int j = paramString.indexOf('?');
    if ((j < 0) || (j + 1 >= paramString.length())) {
      return localBundle;
    }
    paramString = paramString.substring(j + 1);
    if (TextUtils.isEmpty(paramString)) {
      return localBundle;
    }
    paramString = paramString.split("&");
    for (;;)
    {
      if ((paramString != null) && (i < paramString.length))
      {
        String[] arrayOfString = paramString[i].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {}
        try
        {
          localBundle.putString(arrayOfString[0], URLDecoder.decode(arrayOfString[1], "UTF-8"));
          i += 1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            QLog.e("tools", 1, "parseUrlParams", localIllegalArgumentException);
          }
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
    if ((jdField_b_of_type_JavaLangString != null) && (jdField_b_of_type_JavaLangString.length() > 0)) {
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
    String str = paramTianShuReportData.jdField_b_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      str = "";
      if (localAppRuntime != null) {
        str = localAppRuntime.getAccount();
      }
      if (!TextUtils.isEmpty(str))
      {
        str = str + "_" + NetConnInfoCenter.getServerTime();
        paramUserActionReport.trace_id.set(str);
      }
      str = String.valueOf(paramTianShuReportData.l);
      if (!TextUtils.isEmpty(str)) {
        break label171;
      }
      str = TianShuManager.getInstance().getTraceInfoFromCache(String.valueOf(paramTianShuReportData.g));
      if (!TextUtils.isEmpty(str)) {
        paramUserActionReport.trigger_info.set(str);
      }
    }
    for (;;)
    {
      int j = paramTianShuReportData.jdField_a_of_type_Int;
      int i = j;
      if (j == -1) {
        i = 1;
      }
      paramUserActionReport.trace_num.set(i);
      return;
      paramUserActionReport.trace_id.set(String.valueOf(str));
      break;
      label171:
      paramUserActionReport.trigger_info.set(str);
    }
  }
  
  public static String b()
  {
    if ((jdField_a_of_type_JavaLangString != null) && (jdField_a_of_type_JavaLangString.length() > 0)) {
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
    switch (NetworkUtil.b(BaseApplicationImpl.getContext()))
    {
    default: 
      return "UNKNOW";
    case 1: 
      return "WIFI";
    case 4: 
      return "4G";
    case 3: 
      return "3G";
    }
    return "2G";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.utils.Tools
 * JD-Core Version:    0.7.0.1
 */