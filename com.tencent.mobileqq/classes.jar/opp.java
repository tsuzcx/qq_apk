import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PhoneInfo;

public class opp
{
  public static String a()
  {
    Object localObject = "";
    try
    {
      String str = bkfy.a("d059d4");
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AdDeviceInfoUtil", 2, "getIMEI: exception" + localException.getMessage());
    }
    return localObject;
    return "";
  }
  
  public static String a(Context paramContext)
  {
    return a(paramContext, "com.tencent.mm");
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str = "";
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 1);
      paramContext = str;
      if (paramString != null) {
        paramContext = paramString.versionName;
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static oidb_0x6cf.PhoneInfo a()
  {
    oidb_0x6cf.PhoneInfo localPhoneInfo = new oidb_0x6cf.PhoneInfo();
    Object localObject1 = new acry();
    ((acry)localObject1).a = "ce2d9f";
    Object localObject2 = acrx.a(BaseApplication.getContext(), (acry)localObject1);
    if (localObject2 != null) {}
    for (localObject1 = ((acrz)localObject2).a;; localObject1 = null)
    {
      if ((localObject2 != null) && (((acrz)localObject2).a != null) && (((acrz)localObject2).a.muid != null) && (((acrz)localObject2).a.muid_type != null))
      {
        localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(((acrz)localObject2).a.muid.get()));
        localPhoneInfo.uint32_muid_type.set(((acrz)localObject2).a.muid_type.get());
      }
      localObject2 = b();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localPhoneInfo.string_imei.set((String)localObject2);
      }
      int i = nve.a();
      localPhoneInfo.uint32_conn.set(i);
      i = 0;
      try
      {
        int j = bgln.e();
        i = j;
      }
      catch (Exception localException)
      {
        label158:
        break label158;
      }
      localPhoneInfo.uint32_carrier.set(i);
      localObject2 = bgln.e();
      localPhoneInfo.bytes_os_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localObject2 = bgln.c();
      localPhoneInfo.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      i = AppSetting.a();
      localPhoneInfo.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
      localObject2 = dw.a(dw.a());
      localPhoneInfo.bytes_client_ip.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localPhoneInfo.uint32_os_type.set(2);
      localPhoneInfo.uint64_func_flag.set(1L);
      localPhoneInfo.bytes_ads_context.set(ByteStringMicro.copyFromUtf8(nxw.a()));
      localPhoneInfo.bytes_manufacturer.set(ByteStringMicro.copyFromUtf8(Build.BRAND));
      localPhoneInfo.bytes_device_brand_and_model.set(ByteStringMicro.copyFromUtf8(Build.MODEL));
      if (localObject1 != null)
      {
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.has()) {
          localPhoneInfo.string_qadid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.has()) {
          localPhoneInfo.string_androidid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.has()) {
          localPhoneInfo.string_mac.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.has()) {
          localPhoneInfo.string_oaid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.has()) {
          localPhoneInfo.string_taid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.has()) {
          localPhoneInfo.string_client_ipv4.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.get());
        }
        if (QLog.isColorLevel()) {
          QLog.i("AdDeviceInfoUtil", 2, "makePhoneInfo0x6cf: deviceInfo: ma=" + localPhoneInfo.string_androidid.get() + ", mm=" + localPhoneInfo.string_mac.get() + ", oa=" + localPhoneInfo.string_oaid.get() + ", ta=" + localPhoneInfo.string_taid.get());
        }
      }
      localPhoneInfo.bytes_wx_ver.set(ByteStringMicro.copyFrom(a(BaseApplication.getContext()).getBytes()));
      return localPhoneInfo;
    }
  }
  
  public static String b()
  {
    for (Object localObject1 = "";; localObject1 = "")
    {
      try
      {
        Object localObject2 = (TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone");
        if (Build.VERSION.SDK_INT > 28) {
          continue;
        }
        localObject2 = ((TelephonyManager)localObject2).getDeviceId();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AdDeviceInfoUtil", 2, "getGdtIMEI: exception" + localException.getMessage());
        return "";
      }
      return localObject1;
    }
  }
  
  public static String c()
  {
    Object localObject = "";
    try
    {
      String str = bkfy.c("d059d4");
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AdDeviceInfoUtil", 2, "getIMEI: exception" + localException.getMessage());
    }
    return localObject;
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     opp
 * JD-Core Version:    0.7.0.1
 */